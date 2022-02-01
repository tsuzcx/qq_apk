package com.tencent.mobileqq.phonecontact.api.impl;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactBinded;
import com.tencent.mobileqq.phonecontact.data.ContactBindedData;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.phonecontact.data.LastLoginPhoneInfo;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.phonecontact.data.PhoneNumInfo;
import com.tencent.mobileqq.phonecontact.handler.ContactBindHandler;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver2;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.processor.IPhoneContactProcessor;
import com.tencent.mobileqq.phonecontact.processor.PhoneContactInjectFactory;
import com.tencent.mobileqq.phonecontact.util.PhoneContactComparator;
import com.tencent.mobileqq.phonecontact.util.PhoneContactHelper;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.VersionUtils;
import friendlist.GetOnlineInfoResp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mobileqq.data.PhoneContact;>;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class PhoneContactServiceImpl
  implements IPhoneContactService
{
  private static final int CMD_PHONE_UNITY_BANNER_CONFIG = 34;
  private static final boolean DEBUG_DETAIL_LOG = true;
  private static final boolean DEBUG_UPDATE_LAST_LOGIN = false;
  private static final String DEVICE_INFO_BUSIID = "73f9b3";
  private static final String FRD_HAS_BIND_PHONE_COUNT_TAG = "frd_has_bind_phone_count_";
  private static final String FRD_HAS_BIND_PHONE_SOME_TAG = "frd_has_bind_phone_some_";
  private static final String KEY_ALL_ENTRANCE_NUM = "all_entrance_num";
  private static final String KEY_BIND_STYLE = "key_bind_style";
  private static final String KEY_BIND_WORDING = "key_bind_wording";
  private static final String KEY_BLOCK_MSG = "key_block_msg";
  private static final String KEY_CONFIG_VERSION = "key_config_version";
  public static final String KEY_CONTACTS_SWITCHES = "key_contacts_switches";
  private static final String KEY_LAST_REQ_LOGIN_TIME = "key_req_last_login_time";
  private static final String KEY_LAST_UNBIND_MOBILE_TIME = "last_unbind_mobile_time";
  private static final String KEY_LOGIN_INFO_TIME_STAMP = "key_login_info_timestamp";
  private static final String KEY_REQUEST_LOGIN_INTERVAL = "key_req_login_interval";
  private static final long MIN_GAP_AFTER_LAST_UNBIND_MOBILE = 3600000L;
  private static final long MIN_POPUP_MATCH_INTERVAL_FOR_SWITCHPHONE = 86400000L;
  private static final long MIN_RETRY_INTERVAL = 120000L;
  private static final String[] PHONES_PROJECTION = { "data1", "display_name", "contact_id", "data2", "data3" };
  public static int RESULT_FAIL = 2;
  public static int RESULT_OK = 0;
  private static final String SP_NEW_FRIEND = "sp_new_friend";
  private static final String TAG = "IMCore.PhoneContact.PhoneContactServiceImpl";
  private static final String USER_SETTING_FLAG = "user_setting_flag_";
  public static int sAllEntranceNum = 20;
  private static volatile long sQueryContactListInterval = 120000L;
  private static volatile long sQueryContactListIntervalLogin = 86400000L;
  private String UNIQUE_NO;
  private AppInterface app;
  public volatile List<PhoneContact> bindAllFriendList = null;
  private volatile List<PhoneContact> bindNonFriendList = null;
  public ContactBindedData contactBindedDataCache = null;
  private ConcurrentHashMap<String, PhoneContact> contactCache = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PhoneContact> contactCacheByCodeNumber = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PhoneContact> contactCacheByUin = new ConcurrentHashMap();
  boolean contactChanged = false;
  private volatile long contactListQueryTimeStamp = 0L;
  private ContactBindObserver contactOb = new PhoneContactServiceImpl.2(this);
  private PhoneContactServiceImpl.MyContentObserver contactObserver;
  private volatile boolean destroyed = false;
  private EntityManager em;
  private SharedPreferences globalPref;
  private boolean isAppBlocking = false;
  private volatile boolean isCacheInited;
  private volatile boolean isLastLoginRequesting = false;
  private boolean isPhoneSwitched = false;
  private volatile boolean isQueryingContact = false;
  private volatile boolean isUpdatingContact = false;
  private volatile long lastUpdateFailTimeStamp = 0L;
  private volatile long lastUploadFailTimeStamp = 0L;
  private Runnable mClearRecommendBadgeTask = new PhoneContactServiceImpl.8(this);
  private ContactBindHandler mContactBindHandler;
  private ContactBindObserver2 mContactBindObserver2 = new PhoneContactServiceImpl.21(this);
  private ContactBinded mContactBinded;
  private ArrayList<ContactMatch> mContactMatch;
  private volatile int mCurrentBindState = -1;
  private JSONObject mDataForNewGuide;
  private int mFrdHasBindPhoneTotalCount = -1;
  private boolean mFromNotBind;
  private IPhoneContactProcessor mInjectProcessor;
  private volatile boolean mIsFirstQueryBindState = true;
  private boolean mIsUploadForNewGuide = false;
  private volatile Set<String> mLastLoginSet = new HashSet();
  private long mLastUnbindMobileTime = 0L;
  private List<PhoneContact> mListForContactListView = null;
  private List<PhoneContact> mListForPhoneSelector = null;
  private List<PhoneContact> mListForSelector = null;
  private LinkedList<IPhoneContactListener> mListenerList = new LinkedList();
  private PhoneContactServiceImpl.LoadContactFriendListTask mLoadContactFriendTask;
  private ArrayList<PhoneContactAdd> mPhoneContactAddList;
  private Random mRandom = null;
  private Object mRecommendLock = new Object();
  private SharedPreferences mSharePref;
  private List<String> mSomeFrdHasBindPhone = null;
  private int mStarRecommendCount = 0;
  public long mUIBits;
  public volatile int mUploadPackages = 0;
  private PhoneContactServiceImpl.UploadProgressGenerator mUploadProgressGenerator = null;
  private volatile long mUserSettingFlag = 0L;
  private ConcurrentHashMap<String, PhoneContact> md52PhoneContact = new ConcurrentHashMap();
  public boolean needUploadResultTip = false;
  private List<PhoneContact> orderedBindList = null;
  private List<PhoneContact> orderedNobindList = null;
  private ConcurrentHashMap<String, String> phoneNumToUinMap = new ConcurrentHashMap();
  private SharedPreferences pref;
  List<PhoneContact> recommendMobiles = new ArrayList();
  private List<NotBindContactFriendInfo> respBindFriendListNotBind;
  private List<MobileContactsFriendInfo> respBindFriendList_V2;
  private List<NotBindContactNotFriendInfo> respBindStrangerListNotBind;
  private List<MobileContactsNotFriendInfo> respBindStrangerList_V2;
  private volatile boolean runningForegroud = true;
  private byte[] sessionId;
  private ConcurrentHashMap<String, PhoneContact> tmpContactCache = null;
  private ConcurrentHashMap<String, String> uinToPhoneNumMap = new ConcurrentHashMap();
  
  static
  {
    RESULT_OK = 0;
  }
  
  private void addContactsToLastLoginList(List<String> paramList)
  {
    try
    {
      HashSet localHashSet = new HashSet(this.mLastLoginSet.size() + paramList.size());
      localHashSet.addAll(this.mLastLoginSet);
      localHashSet.addAll(paramList);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("addContactsToLastLogin, mLastLoginSet.size=");
        paramList.append(this.mLastLoginSet.size());
        paramList.append(", tempSet.size=");
        paramList.append(localHashSet.size());
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, paramList.toString());
      }
      this.mLastLoginSet = localHashSet;
      saveLastLoginListToDb(this.mLastLoginSet);
      return;
    }
    catch (OutOfMemoryError paramList)
    {
      QLog.e("PhoneContactManagerImp", 1, "addContactsToLastLoginList oom", paramList);
    }
  }
  
  private void afterLoadLocalContact(ConcurrentHashMap<String, PhoneContact> paramConcurrentHashMap)
  {
    Object localObject1 = this.contactCache.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      PhoneContact localPhoneContact = (PhoneContact)((Map.Entry)localObject2).getValue();
      localObject2 = (PhoneContact)paramConcurrentHashMap.get(((Map.Entry)localObject2).getKey());
      if ((localObject2 != null) && (localPhoneContact != null))
      {
        ((PhoneContact)localObject2).uin = localPhoneContact.uin;
        ((PhoneContact)localObject2).nationCode = localPhoneContact.nationCode;
        ((PhoneContact)localObject2).mobileCode = localPhoneContact.mobileCode;
        ((PhoneContact)localObject2).bindingDate = localPhoneContact.bindingDate;
        ((PhoneContact)localObject2).nickName = localPhoneContact.nickName;
        ((PhoneContact)localObject2).isUploaded = localPhoneContact.isUploaded;
        ((PhoneContact)localObject2).originBinder = localPhoneContact.originBinder;
        ((PhoneContact)localObject2).ability = localPhoneContact.ability;
      }
    }
    localObject1 = this.contactCache;
    this.contactCache = paramConcurrentHashMap;
    ((ConcurrentHashMap)localObject1).clear();
  }
  
  private void afterSaveContactFromServer(boolean paramBoolean)
  {
    Object localObject1 = this.tmpContactCache;
    if (localObject1 != null)
    {
      if (!((ConcurrentHashMap)localObject1).isEmpty())
      {
        localObject1 = this.em.getTransaction();
        try
        {
          ((EntityTransaction)localObject1).begin();
          Iterator localIterator = this.tmpContactCache.values().iterator();
          while (localIterator.hasNext())
          {
            PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
            resetContact(localPhoneContact, paramBoolean);
            this.em.update(localPhoneContact);
          }
          this.tmpContactCache.clear();
          ((EntityTransaction)localObject1).commit();
        }
        finally
        {
          ((EntityTransaction)localObject1).end();
        }
      }
      this.tmpContactCache = null;
    }
  }
  
  private void beforeSaveContactFromServer(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.contactCacheByUin.clear();
      this.contactCacheByCodeNumber.clear();
    }
    if (this.tmpContactCache == null) {
      this.tmpContactCache = new ConcurrentHashMap();
    }
    this.tmpContactCache.putAll(this.contactCache);
  }
  
  private boolean checkUpdateBindStateAndList(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    for (;;)
    {
      try
      {
        AppInterface localAppInterface = this.app;
        if ((!this.destroyed) && (localAppInterface != null))
        {
          this.mInjectProcessor.b(true);
          long l1 = System.currentTimeMillis();
          Object localObject2 = new StringBuilder(200);
          ((StringBuilder)localObject2).append("checkUpdateBindStateAndList, from: ");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append(", isQueryingContact: ");
          ((StringBuilder)localObject2).append(this.isQueryingContact);
          ((StringBuilder)localObject2).append(", isUpdatingContact: ");
          ((StringBuilder)localObject2).append(this.isUpdatingContact);
          ((StringBuilder)localObject2).append(", mCurrentBindState: ");
          ((StringBuilder)localObject2).append(this.mCurrentBindState);
          ((StringBuilder)localObject2).append(", beForce: ");
          ((StringBuilder)localObject2).append(paramBoolean1);
          ((StringBuilder)localObject2).append(", isQueryAll: ");
          ((StringBuilder)localObject2).append(paramBoolean2);
          ((StringBuilder)localObject2).append(", lastQueryTime: ");
          ((StringBuilder)localObject2).append(this.contactListQueryTimeStamp / 1000L);
          ((StringBuilder)localObject2).append(", currentTime: ");
          ((StringBuilder)localObject2).append(l1 / 1000L);
          ((StringBuilder)localObject2).append(", bindState: ");
          ((StringBuilder)localObject2).append(getSelfBindState());
          QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, ((StringBuilder)localObject2).toString());
          if ((!this.isQueryingContact) && (this.mCurrentBindState != 8) && (!this.isUpdatingContact) && (this.mCurrentBindState != 4))
          {
            l1 = Math.abs(l1 - this.contactListQueryTimeStamp);
            if (((paramLong != 2L) && (paramLong != 23L)) || ((l1 >= sQueryContactListIntervalLogin) && (this.runningForegroud)))
            {
              if ((!paramBoolean1) && (l1 < sQueryContactListInterval))
              {
                QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 1, String.format("checkUpdateBindStateAndList return. [interval:%s, limit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(sQueryContactListInterval) }));
                return false;
              }
              this.isQueryingContact = true;
              this.respBindFriendList_V2 = null;
              this.respBindStrangerList_V2 = null;
              localObject2 = new NewIntent(localAppInterface.getApplication(), ContactBindServlet.class);
              ((NewIntent)localObject2).putExtra("req_type", 30);
              ((NewIntent)localObject2).putExtra("next_flag", 0L);
              long l2 = this.pref.getLong("queryContactTimeStamp", 0L);
              long l3 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
              int j = getBindStateForServer();
              ((NewIntent)localObject2).putExtra("time_stamp", l2);
              ((NewIntent)localObject2).putExtra("richinfo_time_stamp", l3);
              ((NewIntent)localObject2).putExtra("session_id", new byte[0]);
              ((NewIntent)localObject2).putExtra("unique_phone_no", getUNIQUE_NO());
              if (paramBoolean2)
              {
                i = 1;
                ((NewIntent)localObject2).putExtra("force_query_list", i);
                ((NewIntent)localObject2).putExtra("param_query_from", paramLong);
                ((NewIntent)localObject2).putExtra("param_bind_state", j);
                localAppInterface.startServlet((NewIntent)localObject2);
                QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, String.format("real doQueryContactList. [force, queryAll, from, interval] = [%b, %b, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong), Long.valueOf(l1) }));
                return true;
              }
            }
            else
            {
              QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 1, String.format("checkUpdateBindStateAndList return. foreground=%b [interval:%s, limit:%s]", new Object[] { Boolean.valueOf(this.runningForegroud), Long.valueOf(l1), Long.valueOf(sQueryContactListIntervalLogin) }));
              return false;
            }
          }
          else
          {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      finally {}
      int i = 2;
    }
  }
  
  private void checkUpdateLastLoginList()
  {
    if (this.destroyed) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new PhoneContactServiceImpl.4(this));
  }
  
  private boolean dealCheckUpdateLocalContact(boolean paramBoolean)
  {
    int i = getSelfBindState();
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = getSelfBindInfo();
    QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, String.format("pre dealCheckUpdateLocalContact() | contactChanged: %s, beFirstQuery: %s, bindState: %s, bindInfo: %s", new Object[] { Boolean.valueOf(this.contactChanged), Boolean.valueOf(paramBoolean), Integer.valueOf(i), localRespondQueryQQBindingStat }));
    if ((i != 8) && (isAutoUploadContacts()))
    {
      paramBoolean = uploadPhoneContact();
      return false | paramBoolean;
    }
    if (isBindContactOk())
    {
      if ((!paramBoolean) && (!this.contactChanged)) {}
    }
    else {
      for (paramBoolean = updatePhoneContact();; paramBoolean = updatePhoneContactNotBind())
      {
        return false | paramBoolean;
        if ((i != 4) && (isAutoUploadContactsNotBind()))
        {
          paramBoolean = uploadPhoneContactNotBind();
          break;
        }
        if (i == 1)
        {
          if ((!paramBoolean) || (!getSelfBindInfo().noBindUploadContacts)) {
            break label179;
          }
          paramBoolean = checkUpdateBindStateAndList(true, true, 15L);
          break;
        }
        if ((i != 2) || ((!paramBoolean) && (!this.contactChanged))) {
          break label179;
        }
      }
    }
    label179:
    return false;
  }
  
  private void deleteLocalData()
  {
    if (this.destroyed) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.isCacheInited = false;
    saveContactListTimeStamp(0L, 0L);
    this.contactCache.clear();
    this.contactCacheByUin.clear();
    this.contactCacheByCodeNumber.clear();
    this.md52PhoneContact.clear();
    notifyContactChanged(1);
    pushRecommendUnreadCount(false);
    synchronized (this.mRecommendLock)
    {
      if (this.mContactMatch != null)
      {
        this.mContactMatch.clear();
        this.mContactMatch = null;
      }
      this.mContactBinded = null;
      ??? = this.em.getTransaction();
      try
      {
        ((EntityTransaction)???).begin();
        this.app.getWritableDatabase().delete(new PhoneContact().getTableName(), null, null);
        this.app.getWritableDatabase().delete(new ContactMatch().getTableName(), null, null);
        this.app.getWritableDatabase().delete(new ContactBinded().getTableName(), null, null);
        ((EntityTransaction)???).commit();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  private boolean doUpdateContact(String paramString, ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    if ((paramString != null) && ((paramArrayList1 != null) || (paramArrayList2 != null)))
    {
      int i;
      if (QLog.isColorLevel())
      {
        if (paramArrayList1 == null) {
          i = 0;
        } else {
          i = paramArrayList1.size();
        }
        int j;
        if (paramArrayList2 == null) {
          j = 0;
        } else {
          j = paramArrayList2.size();
        }
        int k;
        if (paramArrayList == null) {
          k = 0;
        } else {
          k = paramArrayList.size();
        }
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("doUpdateContact bind:%s, add:%s, del:%s, rename:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      if (paramBoolean) {
        i = 15;
      } else {
        i = 38;
      }
      localNewIntent.putExtra("req_type", i);
      localNewIntent.putExtra("unique_phone_no", paramString);
      localNewIntent.putExtra("add_contact_list", paramArrayList1);
      localNewIntent.putExtra("del_contact_list", paramArrayList2);
      localNewIntent.putExtra("rename_contact_list", paramArrayList);
      localNewIntent.putExtra("next_flag", 0L);
      localNewIntent.putExtra("upload_package_no", 0);
      localNewIntent.putExtra("session_id", new byte[0]);
      localNewIntent.putExtra("is_resend", false);
      this.app.startServlet(localNewIntent);
      return true;
    }
    this.isUpdatingContact = false;
    return false;
  }
  
  private int getSelfBindState(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, String.format("getSelfBindState [%s, %s]", new Object[] { getUNIQUE_NO(), paramRespondQueryQQBindingStat }));
    }
    if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo))
    {
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
        return 1;
      }
      if (getUNIQUE_NO().equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
        return 2;
      }
      return 3;
    }
    if ((paramRespondQueryQQBindingStat.originBinder != 2L) && (paramRespondQueryQQBindingStat.originBinder != 3L))
    {
      if (paramRespondQueryQQBindingStat.originBinder == 1L)
      {
        if (paramRespondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
          paramRespondQueryQQBindingStat.MobileUniqueNo = null;
        }
        if ((!TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) && (!paramRespondQueryQQBindingStat.isStopFindMatch))
        {
          if (getUNIQUE_NO().equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
            return 9;
          }
          return 6;
        }
        return 7;
      }
      return 0;
    }
    return 5;
  }
  
  public static PhoneContactServiceImpl getService(AppInterface paramAppInterface)
  {
    return (PhoneContactServiceImpl)paramAppInterface.getRuntimeService(IPhoneContactService.class, "");
  }
  
  private String getUniqueString()
  {
    String str = QQDeviceInfo.getIMEI("73f9b3");
    if (!VersionUtils.k()) {
      localObject1 = QQDeviceInfo.getMAC("73f9b3");
    } else {
      localObject1 = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).equals("02:00:00:00:00:00")) {
        break label127;
      }
    }
    try
    {
      localObject2 = Settings.Secure.getString(BaseApplication.getContext().getContentResolver(), "android_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label59:
      break label59;
    }
    QLog.i("PhoneContact", 1, String.format("fallback androidId:%s", new Object[] { localObject1 }));
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new Random();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((Random)localObject1).nextLong());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    label127:
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append((String)localObject2);
    return ((StringBuilder)localObject1).toString();
  }
  
  private List<PhoneContact> initBindAllFriendList()
  {
    ArrayList localArrayList = new ArrayList(this.contactCache.size());
    Iterator localIterator = this.contactCache.values().iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (!TextUtils.isEmpty(localPhoneContact.uin)) {
        localArrayList.add(localPhoneContact);
      }
    }
    return localArrayList;
  }
  
  private List<PhoneContact> initBindNonfriendList()
  {
    ArrayList localArrayList = new ArrayList(this.contactCache.size());
    Object localObject = this.contactCache.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
      if ("0".equals(localPhoneContact.uin)) {
        localArrayList.add(localPhoneContact);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initBindNonfriendList| [ ");
      ((StringBuilder)localObject).append(localArrayList.size());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.contactCache.size());
      ((StringBuilder)localObject).append("]");
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  private void initLastLoginList()
  {
    if (this.destroyed) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = this.app.getEntityManagerFactory().createEntityManager();
    if (localObject2 != null) {
      localObject1 = ((EntityManager)localObject2).query(LastLoginPhoneInfo.class);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList(0);
    }
    localObject1 = new HashSet(((List)localObject2).size());
    Object localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      LastLoginPhoneInfo localLastLoginPhoneInfo = (LastLoginPhoneInfo)((Iterator)localObject3).next();
      if (!TextUtils.isEmpty(localLastLoginPhoneInfo.unifiedCode)) {
        ((Set)localObject1).add(localLastLoginPhoneInfo.unifiedCode);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initLastLoginList, load for db,size=");
      ((StringBuilder)localObject3).append(((List)localObject2).size());
      ((StringBuilder)localObject3).append(", tempSet.size=");
      ((StringBuilder)localObject3).append(((Set)localObject1).size());
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject3).toString());
    }
    this.mLastLoginSet = ((Set)localObject1);
  }
  
  private void initQueryInterval()
  {
    try
    {
      sQueryContactListInterval = this.globalPref.getLong("query_contact_list_min_interval", sQueryContactListInterval);
      sQueryContactListIntervalLogin = this.globalPref.getLong("query_contact_list_min_interval_for_login", sQueryContactListIntervalLogin);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localThrowable.getMessage());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("initQueryInterval  [limit:%s limitLogin:%s]", new Object[] { Long.valueOf(sQueryContactListInterval), Long.valueOf(sQueryContactListIntervalLogin) }));
    }
  }
  
  private String initUniqueString()
  {
    String str = this.pref.getString("contact_bind_info_unique", "");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("null|null"))) {
      return str;
    }
    str = getUniqueString();
    SharedPreferences.Editor localEditor = this.pref.edit();
    localEditor.putString("contact_bind_info_unique", str);
    localEditor.commit();
    return str;
  }
  
  /* Error */
  private ArrayList<AddressBookItem> loadContactFromPhoneToDB()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1055	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:preLoadLocalContact	()V
    //   4: ldc 74
    //   6: iconst_1
    //   7: ldc_w 1057
    //   10: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: aconst_null
    //   14: astore 9
    //   16: aconst_null
    //   17: astore 7
    //   19: aload_0
    //   20: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   23: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: invokevirtual 1061	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   29: getstatic 1067	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   32: getstatic 197	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:PHONES_PROJECTION	[Ljava/lang/String;
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 1072	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 8
    //   43: goto +13 -> 56
    //   46: astore 5
    //   48: aload 5
    //   50: invokevirtual 1073	java/lang/Exception:printStackTrace	()V
    //   53: aconst_null
    //   54: astore 8
    //   56: new 304	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 305	java/util/ArrayList:<init>	()V
    //   63: astore 12
    //   65: aload 8
    //   67: ifnull +792 -> 859
    //   70: invokestatic 643	java/lang/System:currentTimeMillis	()J
    //   73: lstore_3
    //   74: aload 8
    //   76: invokeinterface 1078 1 0
    //   81: istore_1
    //   82: aload 12
    //   84: iload_1
    //   85: invokevirtual 1081	java/util/ArrayList:ensureCapacity	(I)V
    //   88: new 227	java/util/concurrent/ConcurrentHashMap
    //   91: dup
    //   92: iload_1
    //   93: invokespecial 1082	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   96: astore 13
    //   98: aload 7
    //   100: astore 6
    //   102: aload 9
    //   104: astore 5
    //   106: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +71 -> 180
    //   112: aload 7
    //   114: astore 6
    //   116: aload 9
    //   118: astore 5
    //   120: new 496	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   127: astore 10
    //   129: aload 7
    //   131: astore 6
    //   133: aload 9
    //   135: astore 5
    //   137: aload 10
    //   139: ldc_w 1084
    //   142: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 7
    //   148: astore 6
    //   150: aload 9
    //   152: astore 5
    //   154: aload 10
    //   156: iload_1
    //   157: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 7
    //   163: astore 6
    //   165: aload 9
    //   167: astore 5
    //   169: ldc 74
    //   171: iconst_2
    //   172: aload 10
    //   174: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload 7
    //   182: astore 6
    //   184: aload 9
    //   186: astore 5
    //   188: aload_0
    //   189: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   192: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   195: astore 7
    //   197: aload 7
    //   199: astore 6
    //   201: aload 7
    //   203: astore 5
    //   205: aload 7
    //   207: invokevirtual 606	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   210: aload 7
    //   212: astore 6
    //   214: aload 7
    //   216: astore 5
    //   218: aload 8
    //   220: invokeinterface 1087 1 0
    //   225: pop
    //   226: aload 7
    //   228: astore 6
    //   230: aload 7
    //   232: astore 5
    //   234: aload 8
    //   236: invokeinterface 1090 1 0
    //   241: ifne +453 -> 694
    //   244: aload 7
    //   246: astore 6
    //   248: aload 7
    //   250: astore 5
    //   252: aload 8
    //   254: aload 8
    //   256: ldc 187
    //   258: invokeinterface 1094 2 0
    //   263: invokeinterface 1097 2 0
    //   268: invokestatic 1102	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   271: astore 10
    //   273: aload 7
    //   275: astore 6
    //   277: aload 7
    //   279: astore 5
    //   281: aload 8
    //   283: aload 8
    //   285: ldc 189
    //   287: invokeinterface 1094 2 0
    //   292: invokeinterface 1097 2 0
    //   297: astore 11
    //   299: aload 11
    //   301: astore 9
    //   303: aload 7
    //   305: astore 6
    //   307: aload 7
    //   309: astore 5
    //   311: aload 11
    //   313: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   316: ifeq +7 -> 323
    //   319: aload 10
    //   321: astore 9
    //   323: aload 7
    //   325: astore 6
    //   327: aload 7
    //   329: astore 5
    //   331: aload 8
    //   333: aload 8
    //   335: ldc 191
    //   337: invokeinterface 1094 2 0
    //   342: invokeinterface 1106 2 0
    //   347: istore_1
    //   348: aload 7
    //   350: astore 6
    //   352: aload 7
    //   354: astore 5
    //   356: aload 8
    //   358: aload 8
    //   360: ldc 193
    //   362: invokeinterface 1094 2 0
    //   367: invokeinterface 1106 2 0
    //   372: istore_2
    //   373: aload 7
    //   375: astore 6
    //   377: aload 7
    //   379: astore 5
    //   381: aload 8
    //   383: aload 8
    //   385: ldc 195
    //   387: invokeinterface 1094 2 0
    //   392: invokeinterface 1097 2 0
    //   397: astore 11
    //   399: aload 7
    //   401: astore 6
    //   403: aload 7
    //   405: astore 5
    //   407: aload 10
    //   409: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   412: ifne +263 -> 675
    //   415: aload 7
    //   417: astore 6
    //   419: aload 7
    //   421: astore 5
    //   423: aload 9
    //   425: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   428: ifeq +6 -> 434
    //   431: goto +244 -> 675
    //   434: aload 7
    //   436: astore 6
    //   438: aload 7
    //   440: astore 5
    //   442: new 556	com/tencent/mobileqq/data/PhoneContact
    //   445: dup
    //   446: invokespecial 842	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   449: astore 14
    //   451: aload 7
    //   453: astore 6
    //   455: aload 7
    //   457: astore 5
    //   459: aload 14
    //   461: aload 10
    //   463: putfield 1107	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   466: aload 7
    //   468: astore 6
    //   470: aload 7
    //   472: astore 5
    //   474: aload 14
    //   476: aload 9
    //   478: putfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   481: aload 7
    //   483: astore 6
    //   485: aload 7
    //   487: astore 5
    //   489: aload 14
    //   491: iload_1
    //   492: putfield 1113	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   495: aload 7
    //   497: astore 6
    //   499: aload 7
    //   501: astore 5
    //   503: aload 14
    //   505: iload_2
    //   506: putfield 1116	com/tencent/mobileqq/data/PhoneContact:type	I
    //   509: aload 7
    //   511: astore 6
    //   513: aload 7
    //   515: astore 5
    //   517: aload 14
    //   519: aload 11
    //   521: putfield 1119	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   524: aload 7
    //   526: astore 6
    //   528: aload 7
    //   530: astore 5
    //   532: aload 14
    //   534: lload_3
    //   535: putfield 1122	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   538: aload 7
    //   540: astore 6
    //   542: aload 7
    //   544: astore 5
    //   546: aload 14
    //   548: aload 9
    //   550: iconst_1
    //   551: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   554: putfield 1130	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   557: aload 7
    //   559: astore 6
    //   561: aload 7
    //   563: astore 5
    //   565: aload 14
    //   567: aload 9
    //   569: iconst_2
    //   570: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   573: putfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   576: aload 7
    //   578: astore 6
    //   580: aload 7
    //   582: astore 5
    //   584: aload 14
    //   586: aload 14
    //   588: getfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   591: invokestatic 1135	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   594: putfield 1138	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   597: aload 7
    //   599: astore 6
    //   601: aload 7
    //   603: astore 5
    //   605: aload 14
    //   607: aload 9
    //   609: aload 10
    //   611: invokestatic 1140	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   614: putfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   617: aload 7
    //   619: astore 6
    //   621: aload 7
    //   623: astore 5
    //   625: aload 13
    //   627: aload 10
    //   629: aload 14
    //   631: invokevirtual 1147	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   634: pop
    //   635: aload 7
    //   637: astore 6
    //   639: aload 7
    //   641: astore 5
    //   643: aload_0
    //   644: getfield 278	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:md52PhoneContact	Ljava/util/concurrent/ConcurrentHashMap;
    //   647: aload 14
    //   649: getfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   652: aload 14
    //   654: invokevirtual 1147	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   657: pop
    //   658: aload 7
    //   660: astore 6
    //   662: aload 7
    //   664: astore 5
    //   666: aload_0
    //   667: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   670: aload 14
    //   672: invokevirtual 1151	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   675: aload 7
    //   677: astore 6
    //   679: aload 7
    //   681: astore 5
    //   683: aload 8
    //   685: invokeinterface 1154 1 0
    //   690: pop
    //   691: goto -465 -> 226
    //   694: aload 7
    //   696: astore 6
    //   698: aload 7
    //   700: astore 5
    //   702: aload 7
    //   704: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   707: aload 7
    //   709: ifnull +12 -> 721
    //   712: aload 7
    //   714: astore 5
    //   716: aload 5
    //   718: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   721: aload 8
    //   723: invokeinterface 1157 1 0
    //   728: goto +43 -> 771
    //   731: astore 5
    //   733: goto +106 -> 839
    //   736: astore 7
    //   738: aload 5
    //   740: astore 6
    //   742: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   745: ifeq +18 -> 763
    //   748: aload 5
    //   750: astore 6
    //   752: ldc 74
    //   754: iconst_2
    //   755: ldc_w 915
    //   758: aload 7
    //   760: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   763: aload 5
    //   765: ifnull -44 -> 721
    //   768: goto -52 -> 716
    //   771: aload_0
    //   772: aload 13
    //   774: invokespecial 1161	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:afterLoadLocalContact	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   777: aload_0
    //   778: getfield 272	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:contactCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   781: invokevirtual 610	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   784: invokeinterface 613 1 0
    //   789: astore 5
    //   791: aload 5
    //   793: invokeinterface 545 1 0
    //   798: ifeq +61 -> 859
    //   801: aload 5
    //   803: invokeinterface 549 1 0
    //   808: checkcast 556	com/tencent/mobileqq/data/PhoneContact
    //   811: astore 6
    //   813: aload 12
    //   815: new 1163	SecurityAccountServer/AddressBookItem
    //   818: dup
    //   819: aload 6
    //   821: getfield 1107	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   824: aload 6
    //   826: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   829: invokespecial 1166	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   835: pop
    //   836: goto -45 -> 791
    //   839: aload 6
    //   841: ifnull +8 -> 849
    //   844: aload 6
    //   846: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   849: aload 8
    //   851: invokeinterface 1157 1 0
    //   856: aload 5
    //   858: athrow
    //   859: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq +43 -> 905
    //   865: new 496	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   872: astore 5
    //   874: aload 5
    //   876: ldc_w 1169
    //   879: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 5
    //   885: aload 12
    //   887: invokevirtual 862	java/util/ArrayList:size	()I
    //   890: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: ldc 74
    //   896: iconst_2
    //   897: aload 5
    //   899: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aload_0
    //   906: iconst_1
    //   907: putfield 834	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:isCacheInited	Z
    //   910: aload 12
    //   912: areturn
    //   913: astore 5
    //   915: goto -144 -> 771
    //   918: astore 6
    //   920: goto -64 -> 856
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	923	0	this	PhoneContactServiceImpl
    //   81	411	1	i	int
    //   372	134	2	j	int
    //   73	462	3	l	long
    //   46	3	5	localException1	Exception
    //   104	613	5	localObject1	Object
    //   731	33	5	localObject2	Object
    //   789	109	5	localObject3	Object
    //   913	1	5	localException2	Exception
    //   100	745	6	localObject4	Object
    //   918	1	6	localException3	Exception
    //   17	696	7	localEntityTransaction	EntityTransaction
    //   736	23	7	localStaleDataException	android.database.StaleDataException
    //   41	809	8	localCursor	android.database.Cursor
    //   14	594	9	localObject5	Object
    //   127	501	10	localObject6	Object
    //   297	223	11	str	String
    //   63	848	12	localArrayList	ArrayList
    //   96	677	13	localConcurrentHashMap	ConcurrentHashMap
    //   449	222	14	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   19	43	46	java/lang/Exception
    //   106	112	731	finally
    //   120	129	731	finally
    //   137	146	731	finally
    //   154	161	731	finally
    //   169	180	731	finally
    //   188	197	731	finally
    //   205	210	731	finally
    //   218	226	731	finally
    //   234	244	731	finally
    //   252	273	731	finally
    //   281	299	731	finally
    //   311	319	731	finally
    //   331	348	731	finally
    //   356	373	731	finally
    //   381	399	731	finally
    //   407	415	731	finally
    //   423	431	731	finally
    //   442	451	731	finally
    //   459	466	731	finally
    //   474	481	731	finally
    //   489	495	731	finally
    //   503	509	731	finally
    //   517	524	731	finally
    //   532	538	731	finally
    //   546	557	731	finally
    //   565	576	731	finally
    //   584	597	731	finally
    //   605	617	731	finally
    //   625	635	731	finally
    //   643	658	731	finally
    //   666	675	731	finally
    //   683	691	731	finally
    //   702	707	731	finally
    //   742	748	731	finally
    //   752	763	731	finally
    //   106	112	736	android/database/StaleDataException
    //   120	129	736	android/database/StaleDataException
    //   137	146	736	android/database/StaleDataException
    //   154	161	736	android/database/StaleDataException
    //   169	180	736	android/database/StaleDataException
    //   188	197	736	android/database/StaleDataException
    //   205	210	736	android/database/StaleDataException
    //   218	226	736	android/database/StaleDataException
    //   234	244	736	android/database/StaleDataException
    //   252	273	736	android/database/StaleDataException
    //   281	299	736	android/database/StaleDataException
    //   311	319	736	android/database/StaleDataException
    //   331	348	736	android/database/StaleDataException
    //   356	373	736	android/database/StaleDataException
    //   381	399	736	android/database/StaleDataException
    //   407	415	736	android/database/StaleDataException
    //   423	431	736	android/database/StaleDataException
    //   442	451	736	android/database/StaleDataException
    //   459	466	736	android/database/StaleDataException
    //   474	481	736	android/database/StaleDataException
    //   489	495	736	android/database/StaleDataException
    //   503	509	736	android/database/StaleDataException
    //   517	524	736	android/database/StaleDataException
    //   532	538	736	android/database/StaleDataException
    //   546	557	736	android/database/StaleDataException
    //   565	576	736	android/database/StaleDataException
    //   584	597	736	android/database/StaleDataException
    //   605	617	736	android/database/StaleDataException
    //   625	635	736	android/database/StaleDataException
    //   643	658	736	android/database/StaleDataException
    //   666	675	736	android/database/StaleDataException
    //   683	691	736	android/database/StaleDataException
    //   702	707	736	android/database/StaleDataException
    //   721	728	913	java/lang/Exception
    //   849	856	918	java/lang/Exception
  }
  
  private void notifyBindStateChanged()
  {
    if (this.destroyed) {
      return;
    }
    this.app.runOnUiThread(new PhoneContactServiceImpl.9(this));
  }
  
  private void notifyContactChanged(int paramInt)
  {
    if (this.destroyed) {
      return;
    }
    if ((paramInt & 0x1) != 0)
    {
      this.orderedNobindList = null;
      this.orderedBindList = null;
      this.mListForSelector = null;
      this.mListForContactListView = null;
      this.mInjectProcessor.d();
      this.mInjectProcessor.e();
    }
    this.bindNonFriendList = null;
    this.bindAllFriendList = null;
    this.app.runOnUiThread(new PhoneContactServiceImpl.6(this, paramInt));
  }
  
  private void notifyContactFriendListLoaded(List<PhoneContact> paramList)
  {
    this.mInjectProcessor.a(paramList);
  }
  
  private void notifyRecommendCountChanged(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyRecommendCountChanged|beAdded = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("|list.size = ");
      localStringBuilder.append(paramList.size());
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    if (this.destroyed) {
      return;
    }
    int i = paramList.size();
    this.app.runOnUiThread(new PhoneContactServiceImpl.11(this, paramBoolean, i));
  }
  
  private void notifyUISwitchChanged(long paramLong)
  {
    this.app.runOnUiThread(new PhoneContactServiceImpl.12(this, paramLong));
  }
  
  private void notifyUploadProgressChanged(int paramInt)
  {
    if (this.destroyed) {
      return;
    }
    this.app.runOnUiThread(new PhoneContactServiceImpl.10(this, paramInt));
  }
  
  private void onNewRecommendContact(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, new Object[] { "onNewRecommendContact|listSize = ", Integer.valueOf(paramList.size()) });
    }
    synchronized (this.mRecommendLock)
    {
      if (paramList.size() > 0)
      {
        if ((this.mContactBinded != null) && (paramList.size() <= sAllEntranceNum))
        {
          EntityTransaction localEntityTransaction = this.em.getTransaction();
          localEntityTransaction.begin();
          try
          {
            if (this.mContactMatch == null) {
              this.mContactMatch = new ArrayList(paramList.size());
            }
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext())
            {
              PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
              Object localObject2 = this.mContactMatch.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ContactMatch localContactMatch = (ContactMatch)((Iterator)localObject2).next();
                if (localContactMatch.mobileNo.equals(localPhoneContact.mobileNo))
                {
                  ((Iterator)localObject2).remove();
                  this.em.remove(localContactMatch);
                  if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, new Object[] { "onNewRecommendContact remove uin=", localContactMatch.mobileNo });
                  }
                }
              }
              localObject2 = new ContactMatch();
              ((ContactMatch)localObject2).mobileNo = localPhoneContact.mobileNo;
              ((ContactMatch)localObject2).unifiedCode = localPhoneContact.unifiedCode;
              ((ContactMatch)localObject2).name = localPhoneContact.name;
              ((ContactMatch)localObject2).timestamp = MessageCache.c();
              ((ContactMatch)localObject2).age = ((short)localPhoneContact.age);
              ((ContactMatch)localObject2).gender = ((short)localPhoneContact.sex);
              ((ContactMatch)localObject2).commonFriend = localPhoneContact.samFriend;
              this.mContactMatch.add(localObject2);
              if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, new Object[] { "onNewRecommendContact new uin=", ((ContactMatch)localObject2).mobileNo });
              }
              updateEntity((Entity)localObject2);
            }
            localEntityTransaction.commit();
          }
          finally
          {
            localEntityTransaction.end();
          }
        }
        else
        {
          if (this.mContactBinded == null) {
            this.mContactBinded = new ContactBinded();
          }
          this.mContactBinded.timestamp = MessageCache.c();
          this.mContactBinded.isReaded = false;
        }
        updateEntity(this.mContactBinded);
      }
      if (paramBoolean)
      {
        if (this.mContactBinded == null)
        {
          this.mContactBinded = new ContactBinded();
          this.mContactBinded.isReaded = paramList.isEmpty();
          updateEntity(this.mContactBinded);
        }
      }
      else {
        this.mContactBinded = null;
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  private boolean poppedForThisVersion()
  {
    boolean bool = "8.8.17".equals(this.pref.getString("last_phone_version_popped", "")) ^ true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPhoneContactFirstRun result = ");
      localStringBuilder.append(bool);
      QLog.d("PhoneContact", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean poppedForThisVersionNotBind()
  {
    boolean bool = "8.8.17".equals(this.pref.getString("last_phone_version_popped_notbind", "")) ^ true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("poppedForThisVersionNotBind result = ");
      localStringBuilder.append(bool);
      QLog.d("PhoneContact", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void preLoadLocalContact()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    saveContactListTimeStamp(0L, 0L);
    this.isCacheInited = false;
    this.contactCache.clear();
    this.contactCacheByUin.clear();
    this.contactCacheByCodeNumber.clear();
    this.md52PhoneContact.clear();
    try
    {
      this.app.getWritableDatabase().delete(new PhoneContact().getTableName(), null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void pushRecommendUnreadCount(boolean paramBoolean)
  {
    List localList = getRecommendUnreadList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushRecommendUnreadCount: beAdded = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", unreadCount = ");
      localStringBuilder.append(localList.size());
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    notifyRecommendCountChanged(paramBoolean, localList);
    this.mInjectProcessor.f();
  }
  
  private void queryShowBindPhonePage(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("queryShowBindPhonePage fromNotBind=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      this.mFromNotBind = paramBoolean;
      if (this.mContactBindHandler == null) {
        this.mContactBindHandler = ((ContactBindHandler)this.app.getBusinessHandler(ContactBindHandler.class.getName()));
      }
      ReportController.b(this.app, "dc00898", "", "", "0X80095EE", "0X80095EE", 0, 0, "", "", "", "");
      this.mContactBindHandler.a(this.app.getCurrentUin());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "queryShowBindPhonePage fail.", localException);
    }
  }
  
  private void registContentObserver()
  {
    try
    {
      this.contactObserver = new PhoneContactServiceImpl.MyContentObserver(new Handler(this.app.getApp().getMainLooper()));
      this.contactObserver.a(this);
      this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.contactObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
      }
    }
  }
  
  private void removeIllegalRecommend()
  {
    synchronized (this.mRecommendLock)
    {
      if ((this.mCurrentBindState >= 9) && (getBannerState() == 1))
      {
        if (this.mContactBinded != null) {
          this.mContactBinded = null;
        }
        if ((this.mContactMatch != null) && (this.mContactMatch.size() > 0)) {
          this.mContactMatch.clear();
        }
        localObject2 = this.em.getTransaction();
      }
      try
      {
        ((EntityTransaction)localObject2).begin();
        this.app.getWritableDatabase().delete(new ContactMatch().getTableName(), null, null);
        this.app.getWritableDatabase().delete(new ContactBinded().getTableName(), null, null);
        ((EntityTransaction)localObject2).commit();
        ((EntityTransaction)localObject2).end();
        if (!QLog.isColorLevel()) {
          break label459;
        }
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "removeIllegalRecommend with BannerShow");
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
      Object localObject2 = this.em.getTransaction();
      try
      {
        ((EntityTransaction)localObject2).begin();
        Iterator localIterator = this.mContactMatch.iterator();
        ContactMatch localContactMatch;
        Object localObject6;
        while (localIterator.hasNext())
        {
          localContactMatch = (ContactMatch)localIterator.next();
          localObject6 = queryPhoneContactByMobile(localContactMatch.mobileNo);
          if ((localObject6 == null) || ((((PhoneContact)localObject6).uin != null) && (!((PhoneContact)localObject6).uin.equals("0"))) || (this.mContactMatch.size() >= sAllEntranceNum))
          {
            localIterator.remove();
            this.em.remove(localContactMatch);
            if (QLog.isColorLevel()) {
              QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, new Object[] { "removeIllegalRecommend remove ContactMatch = ", localContactMatch.mobileNo });
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localIterator = this.mContactMatch.iterator();
          while (localIterator.hasNext())
          {
            localContactMatch = (ContactMatch)localIterator.next();
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("removeIllegalRecommend|mobileNo : ");
            ((StringBuilder)localObject6).append(localContactMatch.mobileNo);
            ((StringBuilder)localObject6).append("|size : ");
            ((StringBuilder)localObject6).append(this.mContactMatch.size());
            QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject6).toString());
          }
        }
        ((EntityTransaction)localObject2).commit();
        ((EntityTransaction)localObject2).end();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("removeIllegalRecommend mContactMatchsize = ");
          ((StringBuilder)localObject2).append(this.mContactMatch.size());
          QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject2).toString());
        }
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
      label459:
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void resetContact(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramPhoneContact.uin))
    {
      if (paramBoolean)
      {
        paramPhoneContact.bindingDate = 0L;
        paramPhoneContact.isRecommend = 0;
        paramPhoneContact.uin = "";
        paramPhoneContact.originBinder = 0L;
        paramPhoneContact.ability = 0;
        return;
      }
      if (paramPhoneContact.uin.equals("0"))
      {
        paramPhoneContact.netTypeIconId = 0;
        paramPhoneContact.detalStatusFlag = 20;
        paramPhoneContact.iTermType = 0;
        paramPhoneContact.strTermDesc = "";
        paramPhoneContact.eNetworkType = 0;
        paramPhoneContact.abilityBits = 0L;
      }
    }
  }
  
  private void saveContactListTimeStamp(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("saveContactListTimeStamp, [%s,%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    this.pref.edit().putLong("queryContactTimeStamp", paramLong1).putLong("queryRichInfoTimeStamp", paramLong2).apply();
  }
  
  private void saveContactListTimeStampNotBind(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveContactListTimeStampNotBind");
      localStringBuilder.append(paramLong);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    this.pref.edit().putLong("queryContactTimeStamp", paramLong).commit();
  }
  
  private void saveUploadDataForNewGuide(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, String.format("saveUploadDataForNewGuide [%s, %s, %s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      }
      if (this.mDataForNewGuide == null) {
        this.mDataForNewGuide = new JSONObject();
      }
      this.mDataForNewGuide.put("state", paramInt1);
      if (paramInt2 > 0) {
        this.mDataForNewGuide.put("total", paramInt2);
      }
      this.mDataForNewGuide.put("curPer", paramInt3);
      this.mDataForNewGuide.put("expPer", paramInt4);
      this.mInjectProcessor.a(this.app.getAccount(), this.mDataForNewGuide);
      if ((paramInt1 == 3) || (paramInt1 == 4))
      {
        this.mIsUploadForNewGuide = false;
        this.mDataForNewGuide = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void setShowBindPhonePageResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("setShowBindPhonePageResult success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      if (this.mContactBindHandler == null) {
        this.mContactBindHandler = ((ContactBindHandler)this.app.getBusinessHandler(ContactBindHandler.class.getName()));
      }
      this.mContactBindHandler.a(this.app.getCurrentUin(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "setShowBindPhonePageResult fail.", localException);
    }
  }
  
  private boolean showBindPhonePage(boolean paramBoolean)
  {
    if (!this.app.isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("showBindPhonePage isLogin return false", new Object[0]));
      }
      return false;
    }
    boolean bool1 = poppedForThisVersion();
    boolean bool2 = poppedForThisVersionNotBind();
    long l = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.mLastUnbindMobileTime);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showBindPhonePage| isFirstRun: ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", needToJumpBind: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", unbindGap: ");
      localStringBuilder.append(l);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    return this.mInjectProcessor.a(paramBoolean, bool1, bool2, getSelfBindState(), getSelfBindInfo(), isAutoUploadContacts(), l);
  }
  
  private void showToast(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("showToast [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(this.needUploadResultTip), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.mCurrentBindState) }));
    }
    if (this.needUploadResultTip)
    {
      this.needUploadResultTip = false;
      if (this.mCurrentBindState != 1)
      {
        String str;
        if (paramBoolean) {
          str = BaseApplication.getContext().getString(2131896687);
        } else {
          str = BaseApplication.getContext().getString(2131896676);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          showToast(paramBoolean, str);
          return;
        }
        this.app.runOnUiThread(new PhoneContactServiceImpl.3(this, paramBoolean, str));
      }
    }
  }
  
  private void showToast(boolean paramBoolean, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    QQToast.makeText(localBaseApplication, i, paramString, 0).show(localBaseApplication.getResources().getDimensionPixelSize(2131299920));
  }
  
  private void syncBindState(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    int i = this.mCurrentBindState;
    int j = getSelfBindState(paramRespondQueryQQBindingStat);
    if (j != 1) {
      if ((j != 2) && (j != 3))
      {
        if (j != 5)
        {
          if (j != 6)
          {
            if (j != 7)
            {
              if (j != 9) {
                break label193;
              }
              this.mCurrentBindState = j;
              break label193;
            }
            if (this.mCurrentBindState != 8)
            {
              if (this.mCurrentBindState != j) {
                deleteLocalData();
              }
              this.mCurrentBindState = j;
              break label193;
            }
            if (!QLog.isColorLevel()) {
              break label193;
            }
            QLog.d("PhoneContact", 2, "cur state is uploading");
            break label193;
          }
          if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L) {
            deleteLocalData();
          }
          this.mCurrentBindState = j;
          break label193;
        }
      }
      else
      {
        this.mCurrentBindState = j;
        break label193;
      }
    }
    if (this.mCurrentBindState != j)
    {
      deleteLocalData();
      this.pref.edit().putBoolean("key_show_contact_banner", true).commit();
    }
    if ((j != 1) || (this.mCurrentBindState != 4)) {
      this.mCurrentBindState = j;
    }
    label193:
    if (this.mCurrentBindState == 0) {
      this.mCurrentBindState = j;
    }
    if (QLog.isColorLevel())
    {
      paramRespondQueryQQBindingStat = new StringBuilder();
      paramRespondQueryQQBindingStat.append("syncBindState newState = ");
      paramRespondQueryQQBindingStat.append(j);
      paramRespondQueryQQBindingStat.append(" lastState=");
      paramRespondQueryQQBindingStat.append(i);
      paramRespondQueryQQBindingStat.append(" curState=");
      paramRespondQueryQQBindingStat.append(this.mCurrentBindState);
      QLog.d("PhoneContact", 2, paramRespondQueryQQBindingStat.toString());
    }
    if (i != this.mCurrentBindState) {
      notifyBindStateChanged();
    }
  }
  
  /* Error */
  private ArrayList<PhoneContact> updateLocalContact(ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2)
  {
    // Byte code:
    //   0: new 1508	java/util/HashMap
    //   3: dup
    //   4: invokespecial 1509	java/util/HashMap:<init>	()V
    //   7: astore 15
    //   9: new 304	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 305	java/util/ArrayList:<init>	()V
    //   16: astore 14
    //   18: invokestatic 643	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: ldc 74
    //   25: iconst_1
    //   26: ldc_w 1511
    //   29: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   36: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   39: invokevirtual 1061	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   42: astore 9
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 7
    //   50: aload 9
    //   52: getstatic 1067	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   55: getstatic 197	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:PHONES_PROJECTION	[Ljava/lang/String;
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 1072	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 9
    //   66: goto +19 -> 85
    //   69: astore 9
    //   71: ldc 74
    //   73: iconst_1
    //   74: ldc_w 1512
    //   77: aload 9
    //   79: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aconst_null
    //   83: astore 9
    //   85: aload 9
    //   87: ifnull +1585 -> 1672
    //   90: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +45 -> 138
    //   96: new 496	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   103: astore 10
    //   105: aload 10
    //   107: ldc_w 1514
    //   110: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 10
    //   116: aload 9
    //   118: invokeinterface 1078 1 0
    //   123: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 74
    //   129: iconst_2
    //   130: aload 10
    //   132: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   142: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   145: astore 10
    //   147: aload 10
    //   149: astore 7
    //   151: aload 10
    //   153: astore 8
    //   155: aload 10
    //   157: invokevirtual 606	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   160: aload 10
    //   162: astore 7
    //   164: aload 10
    //   166: astore 8
    //   168: aload 9
    //   170: invokeinterface 1087 1 0
    //   175: pop
    //   176: aload 10
    //   178: astore 7
    //   180: aload 10
    //   182: astore 8
    //   184: aload 9
    //   186: invokeinterface 1090 1 0
    //   191: ifne +844 -> 1035
    //   194: aload 10
    //   196: astore 7
    //   198: aload 10
    //   200: astore 8
    //   202: aload 9
    //   204: aload 9
    //   206: ldc 187
    //   208: invokeinterface 1094 2 0
    //   213: invokeinterface 1097 2 0
    //   218: invokestatic 1102	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   221: astore 12
    //   223: aload 10
    //   225: astore 7
    //   227: aload 10
    //   229: astore 8
    //   231: aload 9
    //   233: aload 9
    //   235: ldc 189
    //   237: invokeinterface 1094 2 0
    //   242: invokeinterface 1097 2 0
    //   247: astore 13
    //   249: aload 13
    //   251: astore 11
    //   253: aload 10
    //   255: astore 7
    //   257: aload 10
    //   259: astore 8
    //   261: aload 13
    //   263: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifeq +7 -> 273
    //   269: aload 12
    //   271: astore 11
    //   273: aload 10
    //   275: astore 7
    //   277: aload 10
    //   279: astore 8
    //   281: aload 9
    //   283: aload 9
    //   285: ldc 191
    //   287: invokeinterface 1094 2 0
    //   292: invokeinterface 1106 2 0
    //   297: istore_3
    //   298: aload 10
    //   300: astore 7
    //   302: aload 10
    //   304: astore 8
    //   306: aload 9
    //   308: aload 9
    //   310: ldc 193
    //   312: invokeinterface 1094 2 0
    //   317: invokeinterface 1106 2 0
    //   322: istore 4
    //   324: aload 10
    //   326: astore 7
    //   328: aload 10
    //   330: astore 8
    //   332: aload 9
    //   334: aload 9
    //   336: ldc 195
    //   338: invokeinterface 1094 2 0
    //   343: invokeinterface 1097 2 0
    //   348: astore 13
    //   350: aload 10
    //   352: astore 7
    //   354: aload 10
    //   356: astore 8
    //   358: aload 12
    //   360: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   363: ifne +653 -> 1016
    //   366: aload 10
    //   368: astore 7
    //   370: aload 10
    //   372: astore 8
    //   374: aload 11
    //   376: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   379: ifeq +6 -> 385
    //   382: goto +634 -> 1016
    //   385: aload 10
    //   387: astore 7
    //   389: aload 10
    //   391: astore 8
    //   393: aload_0
    //   394: getfield 272	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:contactCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   397: aload 12
    //   399: invokevirtual 563	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   402: checkcast 556	com/tencent/mobileqq/data/PhoneContact
    //   405: astore 16
    //   407: aload 16
    //   409: ifnonnull +274 -> 683
    //   412: aload 10
    //   414: astore 7
    //   416: aload 10
    //   418: astore 8
    //   420: new 556	com/tencent/mobileqq/data/PhoneContact
    //   423: dup
    //   424: invokespecial 842	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   427: astore 16
    //   429: aload 10
    //   431: astore 7
    //   433: aload 10
    //   435: astore 8
    //   437: aload 16
    //   439: aload 12
    //   441: putfield 1107	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   444: aload 10
    //   446: astore 7
    //   448: aload 10
    //   450: astore 8
    //   452: aload 16
    //   454: aload 11
    //   456: putfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   459: aload 10
    //   461: astore 7
    //   463: aload 10
    //   465: astore 8
    //   467: aload 16
    //   469: iload_3
    //   470: putfield 1113	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   473: aload 10
    //   475: astore 7
    //   477: aload 10
    //   479: astore 8
    //   481: aload 16
    //   483: iload 4
    //   485: putfield 1116	com/tencent/mobileqq/data/PhoneContact:type	I
    //   488: aload 10
    //   490: astore 7
    //   492: aload 10
    //   494: astore 8
    //   496: aload 16
    //   498: aload 13
    //   500: putfield 1119	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   503: aload 10
    //   505: astore 7
    //   507: aload 10
    //   509: astore 8
    //   511: aload 16
    //   513: lload 5
    //   515: putfield 1122	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   518: aload 10
    //   520: astore 7
    //   522: aload 10
    //   524: astore 8
    //   526: aload 16
    //   528: aload 11
    //   530: iconst_1
    //   531: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   534: putfield 1130	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   537: aload 10
    //   539: astore 7
    //   541: aload 10
    //   543: astore 8
    //   545: aload 16
    //   547: aload 11
    //   549: iconst_2
    //   550: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   553: putfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   556: aload 10
    //   558: astore 7
    //   560: aload 10
    //   562: astore 8
    //   564: aload 16
    //   566: aload 16
    //   568: getfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   571: invokestatic 1135	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   574: putfield 1138	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   577: aload 10
    //   579: astore 7
    //   581: aload 10
    //   583: astore 8
    //   585: aload_0
    //   586: getfield 272	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:contactCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   589: aload 12
    //   591: aload 16
    //   593: invokevirtual 1147	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   596: pop
    //   597: aload 10
    //   599: astore 7
    //   601: aload 10
    //   603: astore 8
    //   605: aload 16
    //   607: aload 11
    //   609: aload 12
    //   611: invokestatic 1140	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   614: putfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   617: aload 10
    //   619: astore 7
    //   621: aload 10
    //   623: astore 8
    //   625: aload_0
    //   626: getfield 278	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:md52PhoneContact	Ljava/util/concurrent/ConcurrentHashMap;
    //   629: aload 16
    //   631: getfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   634: aload 16
    //   636: invokevirtual 1147	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   639: pop
    //   640: aload 10
    //   642: astore 7
    //   644: aload 10
    //   646: astore 8
    //   648: aload 14
    //   650: aload 16
    //   652: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   655: pop
    //   656: aload 10
    //   658: astore 7
    //   660: aload 10
    //   662: astore 8
    //   664: aload_1
    //   665: new 1163	SecurityAccountServer/AddressBookItem
    //   668: dup
    //   669: aload 12
    //   671: aload 11
    //   673: invokespecial 1166	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   679: pop
    //   680: goto +336 -> 1016
    //   683: aload 10
    //   685: astore 7
    //   687: aload 10
    //   689: astore 8
    //   691: aload 16
    //   693: iload_3
    //   694: putfield 1113	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   697: aload 10
    //   699: astore 7
    //   701: aload 10
    //   703: astore 8
    //   705: aload 16
    //   707: lload 5
    //   709: putfield 1122	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   712: aload 10
    //   714: astore 7
    //   716: aload 10
    //   718: astore 8
    //   720: aload 16
    //   722: getfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   725: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   728: ifeq +49 -> 777
    //   731: aload 10
    //   733: astore 7
    //   735: aload 10
    //   737: astore 8
    //   739: aload 16
    //   741: aload 16
    //   743: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   746: aload 12
    //   748: invokestatic 1140	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   751: putfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   754: aload 10
    //   756: astore 7
    //   758: aload 10
    //   760: astore 8
    //   762: aload_0
    //   763: getfield 278	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:md52PhoneContact	Ljava/util/concurrent/ConcurrentHashMap;
    //   766: aload 16
    //   768: getfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   771: aload 16
    //   773: invokevirtual 1147	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   776: pop
    //   777: aload 10
    //   779: astore 7
    //   781: aload 10
    //   783: astore 8
    //   785: aload 16
    //   787: getfield 581	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   790: ifeq +186 -> 976
    //   793: aload 10
    //   795: astore 7
    //   797: aload 10
    //   799: astore 8
    //   801: aload 11
    //   803: aload 16
    //   805: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   808: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   811: ifne +80 -> 891
    //   814: aload 10
    //   816: astore 7
    //   818: aload 10
    //   820: astore 8
    //   822: aload 15
    //   824: aload 12
    //   826: aload 11
    //   828: invokevirtual 1515	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   831: pop
    //   832: aload 10
    //   834: astore 7
    //   836: aload 10
    //   838: astore 8
    //   840: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +173 -> 1016
    //   846: aload 10
    //   848: astore 7
    //   850: aload 10
    //   852: astore 8
    //   854: ldc 74
    //   856: iconst_2
    //   857: ldc_w 1517
    //   860: iconst_3
    //   861: anewarray 4	java/lang/Object
    //   864: dup
    //   865: iconst_0
    //   866: aload 16
    //   868: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   871: aastore
    //   872: dup
    //   873: iconst_1
    //   874: aload 11
    //   876: aastore
    //   877: dup
    //   878: iconst_2
    //   879: aload 12
    //   881: aastore
    //   882: invokestatic 699	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   885: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   888: goto +128 -> 1016
    //   891: aload 10
    //   893: astore 7
    //   895: aload 10
    //   897: astore 8
    //   899: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   902: ifeq +55 -> 957
    //   905: aload 10
    //   907: astore 7
    //   909: aload 10
    //   911: astore 8
    //   913: aload 15
    //   915: aload 12
    //   917: invokevirtual 1520	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   920: ifeq +37 -> 957
    //   923: aload 10
    //   925: astore 7
    //   927: aload 10
    //   929: astore 8
    //   931: ldc 74
    //   933: iconst_2
    //   934: ldc_w 1522
    //   937: iconst_2
    //   938: anewarray 4	java/lang/Object
    //   941: dup
    //   942: iconst_0
    //   943: aload 11
    //   945: aastore
    //   946: dup
    //   947: iconst_1
    //   948: aload 12
    //   950: aastore
    //   951: invokestatic 699	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   954: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: aload 10
    //   959: astore 7
    //   961: aload 10
    //   963: astore 8
    //   965: aload 15
    //   967: aload 12
    //   969: invokevirtual 1524	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   972: pop
    //   973: goto +43 -> 1016
    //   976: aload 10
    //   978: astore 7
    //   980: aload 10
    //   982: astore 8
    //   984: aload_1
    //   985: new 1163	SecurityAccountServer/AddressBookItem
    //   988: dup
    //   989: aload 12
    //   991: aload 11
    //   993: invokespecial 1166	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   996: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   999: pop
    //   1000: aload 10
    //   1002: astore 7
    //   1004: aload 10
    //   1006: astore 8
    //   1008: aload 14
    //   1010: aload 16
    //   1012: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1015: pop
    //   1016: aload 10
    //   1018: astore 7
    //   1020: aload 10
    //   1022: astore 8
    //   1024: aload 9
    //   1026: invokeinterface 1154 1 0
    //   1031: pop
    //   1032: goto -856 -> 176
    //   1035: aload 10
    //   1037: astore 7
    //   1039: aload 10
    //   1041: astore 8
    //   1043: aload 15
    //   1045: invokevirtual 1527	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1048: invokeinterface 540 1 0
    //   1053: astore 11
    //   1055: aload 10
    //   1057: astore 7
    //   1059: aload 10
    //   1061: astore 8
    //   1063: aload 11
    //   1065: invokeinterface 545 1 0
    //   1070: ifeq +283 -> 1353
    //   1073: aload 10
    //   1075: astore 7
    //   1077: aload 10
    //   1079: astore 8
    //   1081: aload 11
    //   1083: invokeinterface 549 1 0
    //   1088: checkcast 185	java/lang/String
    //   1091: astore 12
    //   1093: aload 10
    //   1095: astore 7
    //   1097: aload 10
    //   1099: astore 8
    //   1101: aload_0
    //   1102: getfield 272	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:contactCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   1105: aload 12
    //   1107: invokevirtual 563	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1110: checkcast 556	com/tencent/mobileqq/data/PhoneContact
    //   1113: astore 13
    //   1115: aload 13
    //   1117: ifnonnull +6 -> 1123
    //   1120: goto -65 -> 1055
    //   1123: aload 10
    //   1125: astore 7
    //   1127: aload 10
    //   1129: astore 8
    //   1131: aload 15
    //   1133: aload 12
    //   1135: invokevirtual 1528	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1138: checkcast 185	java/lang/String
    //   1141: astore 16
    //   1143: aload 10
    //   1145: astore 7
    //   1147: aload 10
    //   1149: astore 8
    //   1151: aload_2
    //   1152: new 1163	SecurityAccountServer/AddressBookItem
    //   1155: dup
    //   1156: aload 12
    //   1158: aload 13
    //   1160: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1163: invokespecial 1166	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1166: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1169: pop
    //   1170: aload 10
    //   1172: astore 7
    //   1174: aload 10
    //   1176: astore 8
    //   1178: aload_1
    //   1179: new 1163	SecurityAccountServer/AddressBookItem
    //   1182: dup
    //   1183: aload 12
    //   1185: aload 16
    //   1187: invokespecial 1166	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1190: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1193: pop
    //   1194: aload 10
    //   1196: astore 7
    //   1198: aload 10
    //   1200: astore 8
    //   1202: aload 13
    //   1204: aload 16
    //   1206: putfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1209: aload 10
    //   1211: astore 7
    //   1213: aload 10
    //   1215: astore 8
    //   1217: aload 13
    //   1219: aload 16
    //   1221: iconst_1
    //   1222: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   1225: putfield 1130	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   1228: aload 10
    //   1230: astore 7
    //   1232: aload 10
    //   1234: astore 8
    //   1236: aload 13
    //   1238: aload 16
    //   1240: iconst_2
    //   1241: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   1244: putfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   1247: aload 10
    //   1249: astore 7
    //   1251: aload 10
    //   1253: astore 8
    //   1255: aload 13
    //   1257: aload 13
    //   1259: getfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   1262: invokestatic 1135	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1265: putfield 1138	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   1268: aload 10
    //   1270: astore 7
    //   1272: aload 10
    //   1274: astore 8
    //   1276: aload_0
    //   1277: getfield 278	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:md52PhoneContact	Ljava/util/concurrent/ConcurrentHashMap;
    //   1280: aload 13
    //   1282: getfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   1285: aload 13
    //   1287: invokevirtual 1531	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1290: pop
    //   1291: aload 10
    //   1293: astore 7
    //   1295: aload 10
    //   1297: astore 8
    //   1299: aload 13
    //   1301: aload 16
    //   1303: aload 12
    //   1305: invokestatic 1140	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1308: putfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   1311: aload 10
    //   1313: astore 7
    //   1315: aload 10
    //   1317: astore 8
    //   1319: aload_0
    //   1320: getfield 278	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:md52PhoneContact	Ljava/util/concurrent/ConcurrentHashMap;
    //   1323: aload 13
    //   1325: getfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   1328: aload 13
    //   1330: invokevirtual 1147	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1333: pop
    //   1334: aload 10
    //   1336: astore 7
    //   1338: aload 10
    //   1340: astore 8
    //   1342: aload 14
    //   1344: aload 13
    //   1346: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1349: pop
    //   1350: goto -295 -> 1055
    //   1353: aload 10
    //   1355: astore 7
    //   1357: aload 10
    //   1359: astore 8
    //   1361: new 304	java/util/ArrayList
    //   1364: dup
    //   1365: invokespecial 305	java/util/ArrayList:<init>	()V
    //   1368: astore 11
    //   1370: aload 10
    //   1372: astore 7
    //   1374: aload 10
    //   1376: astore 8
    //   1378: aload_0
    //   1379: getfield 272	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:contactCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   1382: invokevirtual 536	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   1385: invokeinterface 540 1 0
    //   1390: astore 12
    //   1392: aload 10
    //   1394: astore 7
    //   1396: aload 10
    //   1398: astore 8
    //   1400: aload 12
    //   1402: invokeinterface 545 1 0
    //   1407: ifeq +169 -> 1576
    //   1410: aload 10
    //   1412: astore 7
    //   1414: aload 10
    //   1416: astore 8
    //   1418: aload 12
    //   1420: invokeinterface 549 1 0
    //   1425: checkcast 551	java/util/Map$Entry
    //   1428: invokeinterface 554 1 0
    //   1433: checkcast 556	com/tencent/mobileqq/data/PhoneContact
    //   1436: astore 13
    //   1438: aload 10
    //   1440: astore 7
    //   1442: aload 10
    //   1444: astore 8
    //   1446: aload 13
    //   1448: getfield 1122	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   1451: lload 5
    //   1453: lcmp
    //   1454: ifeq -62 -> 1392
    //   1457: aload 10
    //   1459: astore 7
    //   1461: aload 10
    //   1463: astore 8
    //   1465: aload 13
    //   1467: getfield 1223	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1470: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1473: ifne +24 -> 1497
    //   1476: aload 10
    //   1478: astore 7
    //   1480: aload 10
    //   1482: astore 8
    //   1484: aload_0
    //   1485: getfield 274	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:contactCacheByCodeNumber	Ljava/util/concurrent/ConcurrentHashMap;
    //   1488: aload 13
    //   1490: getfield 1223	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1493: invokevirtual 1532	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1496: pop
    //   1497: aload 10
    //   1499: astore 7
    //   1501: aload 10
    //   1503: astore 8
    //   1505: aload 12
    //   1507: invokeinterface 1218 1 0
    //   1512: aload 10
    //   1514: astore 7
    //   1516: aload 10
    //   1518: astore 8
    //   1520: aload_0
    //   1521: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1524: aload 13
    //   1526: invokevirtual 1220	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1529: pop
    //   1530: aload 10
    //   1532: astore 7
    //   1534: aload 10
    //   1536: astore 8
    //   1538: aload_2
    //   1539: new 1163	SecurityAccountServer/AddressBookItem
    //   1542: dup
    //   1543: aload 13
    //   1545: getfield 1107	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1548: aload 13
    //   1550: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1553: invokespecial 1166	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1556: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1559: pop
    //   1560: aload 10
    //   1562: astore 7
    //   1564: aload 10
    //   1566: astore 8
    //   1568: aload 11
    //   1570: invokevirtual 837	java/util/ArrayList:clear	()V
    //   1573: goto -181 -> 1392
    //   1576: aload 10
    //   1578: astore 7
    //   1580: aload 10
    //   1582: astore 8
    //   1584: aload 10
    //   1586: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1589: aload 10
    //   1591: ifnull +8 -> 1599
    //   1594: aload 10
    //   1596: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1599: aload 9
    //   1601: invokeinterface 1157 1 0
    //   1606: goto +66 -> 1672
    //   1609: astore_1
    //   1610: goto +43 -> 1653
    //   1613: astore 10
    //   1615: aload 8
    //   1617: astore 7
    //   1619: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1622: ifeq +18 -> 1640
    //   1625: aload 8
    //   1627: astore 7
    //   1629: ldc 74
    //   1631: iconst_2
    //   1632: ldc_w 915
    //   1635: aload 10
    //   1637: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1640: aload 8
    //   1642: ifnull -43 -> 1599
    //   1645: aload 8
    //   1647: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1650: goto -51 -> 1599
    //   1653: aload 7
    //   1655: ifnull +8 -> 1663
    //   1658: aload 7
    //   1660: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1663: aload 9
    //   1665: invokeinterface 1157 1 0
    //   1670: aload_1
    //   1671: athrow
    //   1672: aload_0
    //   1673: iconst_0
    //   1674: putfield 270	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:contactChanged	Z
    //   1677: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1680: ifeq +62 -> 1742
    //   1683: ldc 74
    //   1685: iconst_2
    //   1686: ldc_w 1534
    //   1689: iconst_4
    //   1690: anewarray 4	java/lang/Object
    //   1693: dup
    //   1694: iconst_0
    //   1695: aload_1
    //   1696: invokevirtual 862	java/util/ArrayList:size	()I
    //   1699: invokestatic 800	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1702: aastore
    //   1703: dup
    //   1704: iconst_1
    //   1705: aload_2
    //   1706: invokevirtual 862	java/util/ArrayList:size	()I
    //   1709: invokestatic 800	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1712: aastore
    //   1713: dup
    //   1714: iconst_2
    //   1715: aload 14
    //   1717: invokevirtual 862	java/util/ArrayList:size	()I
    //   1720: invokestatic 800	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1723: aastore
    //   1724: dup
    //   1725: iconst_3
    //   1726: invokestatic 643	java/lang/System:currentTimeMillis	()J
    //   1729: lload 5
    //   1731: lsub
    //   1732: invokestatic 695	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1735: aastore
    //   1736: invokestatic 699	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1739: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1742: aload 14
    //   1744: areturn
    //   1745: astore 7
    //   1747: goto -75 -> 1672
    //   1750: astore_2
    //   1751: goto -81 -> 1670
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1754	0	this	PhoneContactServiceImpl
    //   0	1754	1	paramArrayList1	ArrayList<AddressBookItem>
    //   0	1754	2	paramArrayList2	ArrayList<AddressBookItem>
    //   297	397	3	i	int
    //   322	162	4	j	int
    //   21	1709	5	l	long
    //   48	1611	7	localObject1	Object
    //   1745	1	7	localException	Exception
    //   45	1601	8	localObject2	Object
    //   42	23	9	localObject3	Object
    //   69	9	9	localThrowable	Throwable
    //   83	1581	9	localObject4	Object
    //   103	1492	10	localObject5	Object
    //   1613	23	10	localStaleDataException	android.database.StaleDataException
    //   251	1318	11	localObject6	Object
    //   221	1285	12	localObject7	Object
    //   247	1302	13	localObject8	Object
    //   16	1727	14	localArrayList	ArrayList
    //   7	1125	15	localHashMap	HashMap
    //   405	897	16	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   50	66	69	java/lang/Throwable
    //   138	147	1609	finally
    //   155	160	1609	finally
    //   168	176	1609	finally
    //   184	194	1609	finally
    //   202	223	1609	finally
    //   231	249	1609	finally
    //   261	269	1609	finally
    //   281	298	1609	finally
    //   306	324	1609	finally
    //   332	350	1609	finally
    //   358	366	1609	finally
    //   374	382	1609	finally
    //   393	407	1609	finally
    //   420	429	1609	finally
    //   437	444	1609	finally
    //   452	459	1609	finally
    //   467	473	1609	finally
    //   481	488	1609	finally
    //   496	503	1609	finally
    //   511	518	1609	finally
    //   526	537	1609	finally
    //   545	556	1609	finally
    //   564	577	1609	finally
    //   585	597	1609	finally
    //   605	617	1609	finally
    //   625	640	1609	finally
    //   648	656	1609	finally
    //   664	680	1609	finally
    //   691	697	1609	finally
    //   705	712	1609	finally
    //   720	731	1609	finally
    //   739	754	1609	finally
    //   762	777	1609	finally
    //   785	793	1609	finally
    //   801	814	1609	finally
    //   822	832	1609	finally
    //   840	846	1609	finally
    //   854	888	1609	finally
    //   899	905	1609	finally
    //   913	923	1609	finally
    //   931	957	1609	finally
    //   965	973	1609	finally
    //   984	1000	1609	finally
    //   1008	1016	1609	finally
    //   1024	1032	1609	finally
    //   1043	1055	1609	finally
    //   1063	1073	1609	finally
    //   1081	1093	1609	finally
    //   1101	1115	1609	finally
    //   1131	1143	1609	finally
    //   1151	1170	1609	finally
    //   1178	1194	1609	finally
    //   1202	1209	1609	finally
    //   1217	1228	1609	finally
    //   1236	1247	1609	finally
    //   1255	1268	1609	finally
    //   1276	1291	1609	finally
    //   1299	1311	1609	finally
    //   1319	1334	1609	finally
    //   1342	1350	1609	finally
    //   1361	1370	1609	finally
    //   1378	1392	1609	finally
    //   1400	1410	1609	finally
    //   1418	1438	1609	finally
    //   1446	1457	1609	finally
    //   1465	1476	1609	finally
    //   1484	1497	1609	finally
    //   1505	1512	1609	finally
    //   1520	1530	1609	finally
    //   1538	1560	1609	finally
    //   1568	1573	1609	finally
    //   1584	1589	1609	finally
    //   1619	1625	1609	finally
    //   1629	1640	1609	finally
    //   138	147	1613	android/database/StaleDataException
    //   155	160	1613	android/database/StaleDataException
    //   168	176	1613	android/database/StaleDataException
    //   184	194	1613	android/database/StaleDataException
    //   202	223	1613	android/database/StaleDataException
    //   231	249	1613	android/database/StaleDataException
    //   261	269	1613	android/database/StaleDataException
    //   281	298	1613	android/database/StaleDataException
    //   306	324	1613	android/database/StaleDataException
    //   332	350	1613	android/database/StaleDataException
    //   358	366	1613	android/database/StaleDataException
    //   374	382	1613	android/database/StaleDataException
    //   393	407	1613	android/database/StaleDataException
    //   420	429	1613	android/database/StaleDataException
    //   437	444	1613	android/database/StaleDataException
    //   452	459	1613	android/database/StaleDataException
    //   467	473	1613	android/database/StaleDataException
    //   481	488	1613	android/database/StaleDataException
    //   496	503	1613	android/database/StaleDataException
    //   511	518	1613	android/database/StaleDataException
    //   526	537	1613	android/database/StaleDataException
    //   545	556	1613	android/database/StaleDataException
    //   564	577	1613	android/database/StaleDataException
    //   585	597	1613	android/database/StaleDataException
    //   605	617	1613	android/database/StaleDataException
    //   625	640	1613	android/database/StaleDataException
    //   648	656	1613	android/database/StaleDataException
    //   664	680	1613	android/database/StaleDataException
    //   691	697	1613	android/database/StaleDataException
    //   705	712	1613	android/database/StaleDataException
    //   720	731	1613	android/database/StaleDataException
    //   739	754	1613	android/database/StaleDataException
    //   762	777	1613	android/database/StaleDataException
    //   785	793	1613	android/database/StaleDataException
    //   801	814	1613	android/database/StaleDataException
    //   822	832	1613	android/database/StaleDataException
    //   840	846	1613	android/database/StaleDataException
    //   854	888	1613	android/database/StaleDataException
    //   899	905	1613	android/database/StaleDataException
    //   913	923	1613	android/database/StaleDataException
    //   931	957	1613	android/database/StaleDataException
    //   965	973	1613	android/database/StaleDataException
    //   984	1000	1613	android/database/StaleDataException
    //   1008	1016	1613	android/database/StaleDataException
    //   1024	1032	1613	android/database/StaleDataException
    //   1043	1055	1613	android/database/StaleDataException
    //   1063	1073	1613	android/database/StaleDataException
    //   1081	1093	1613	android/database/StaleDataException
    //   1101	1115	1613	android/database/StaleDataException
    //   1131	1143	1613	android/database/StaleDataException
    //   1151	1170	1613	android/database/StaleDataException
    //   1178	1194	1613	android/database/StaleDataException
    //   1202	1209	1613	android/database/StaleDataException
    //   1217	1228	1613	android/database/StaleDataException
    //   1236	1247	1613	android/database/StaleDataException
    //   1255	1268	1613	android/database/StaleDataException
    //   1276	1291	1613	android/database/StaleDataException
    //   1299	1311	1613	android/database/StaleDataException
    //   1319	1334	1613	android/database/StaleDataException
    //   1342	1350	1613	android/database/StaleDataException
    //   1361	1370	1613	android/database/StaleDataException
    //   1378	1392	1613	android/database/StaleDataException
    //   1400	1410	1613	android/database/StaleDataException
    //   1418	1438	1613	android/database/StaleDataException
    //   1446	1457	1613	android/database/StaleDataException
    //   1465	1476	1613	android/database/StaleDataException
    //   1484	1497	1613	android/database/StaleDataException
    //   1505	1512	1613	android/database/StaleDataException
    //   1520	1530	1613	android/database/StaleDataException
    //   1538	1560	1613	android/database/StaleDataException
    //   1568	1573	1613	android/database/StaleDataException
    //   1584	1589	1613	android/database/StaleDataException
    //   1599	1606	1745	java/lang/Exception
    //   1663	1670	1750	java/lang/Exception
  }
  
  private boolean updatePhoneContact()
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(50);
        ((StringBuilder)localObject1).append("updatePhoneContact, isUpdating = ");
        ((StringBuilder)localObject1).append(this.isUpdatingContact);
        ((StringBuilder)localObject1).append(", isQuerying = ");
        ((StringBuilder)localObject1).append(this.isQueryingContact);
        ((StringBuilder)localObject1).append(", lastFailPeriode = ");
        ((StringBuilder)localObject1).append((System.currentTimeMillis() - this.lastUpdateFailTimeStamp) / 1000L);
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!this.isUpdatingContact) && (!this.isQueryingContact))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.lastUpdateFailTimeStamp;
        if (l1 - l2 < 120000L) {
          return false;
        }
        localObject1 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "do-updatePhoneContact()");
        ArrayList localArrayList2 = updateLocalContact((ArrayList)localObject1, localArrayList1);
        if (((ArrayList)localObject1).isEmpty())
        {
          boolean bool = localArrayList1.isEmpty();
          if (bool) {
            return false;
          }
        }
        this.isUpdatingContact = doUpdateContact(getUNIQUE_NO(), (ArrayList)localObject1, localArrayList1, localArrayList2, true);
        notifyContactChanged(1);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private boolean updatePhoneContactNotBind()
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(50);
        ((StringBuilder)localObject1).append("updatePhoneContactNotBind, isUpdating = ");
        ((StringBuilder)localObject1).append(this.isUpdatingContact);
        ((StringBuilder)localObject1).append(", isQuerying = ");
        ((StringBuilder)localObject1).append(this.isQueryingContact);
        ((StringBuilder)localObject1).append(", lastFailPeriode = ");
        ((StringBuilder)localObject1).append((System.currentTimeMillis() - this.lastUpdateFailTimeStamp) / 1000L);
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!this.isUpdatingContact) && (!this.isQueryingContact))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.lastUpdateFailTimeStamp;
        if (l1 - l2 < 120000L) {
          return false;
        }
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "do-updatePhoneContactNotBind()");
        localObject1 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = updateLocalContact((ArrayList)localObject1, localArrayList1);
        if (((ArrayList)localObject1).isEmpty())
        {
          boolean bool = localArrayList1.isEmpty();
          if (bool) {
            return false;
          }
        }
        this.isUpdatingContact = doUpdateContact(getUNIQUE_NO(), (ArrayList)localObject1, localArrayList1, localArrayList2, false);
        notifyContactChanged(1);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void OnDisableMobileBindSuc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "OnDisableMobileBindSuc");
    }
    this.mCurrentBindState = 7;
    checkUpdateBindStateAndList(true, true, 22L);
  }
  
  public boolean addContactAndUpload(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addContactAndUpload ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.app.getApp().getContentResolver();
    try
    {
      ContentValues localContentValues = new ContentValues();
      long l = ContentUris.parseId(((ContentResolver)localObject).insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues));
      if (l <= 0L) {
        return false;
      }
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("mimetype", "vnd.android.cursor.item/name");
      localContentValues.put("data1", paramString1);
      ((ContentResolver)localObject).insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      localContentValues.put("data1", paramString2);
      localContentValues.put("data2", Integer.valueOf(2));
      ((ContentResolver)localObject).insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      checkUpdateLocalContact(false, 1);
      return true;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public void addFriendSuccessNotify(String paramString1, String paramString2)
  {
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        paramString1 = (PhoneContact)this.contactCache.get(paramString1);
        if (paramString1 == null) {
          break label116;
        }
        paramString1.uin = paramString2;
        this.em.update(paramString1);
        if ((TextUtils.isEmpty(paramString1.uin)) || (paramString1.uin.equals("0"))) {
          break label111;
        }
        this.contactCacheByUin.put(paramString1.uin, paramString1);
      }
      finally
      {
        localEntityTransaction.end();
      }
      localEntityTransaction.commit();
      localEntityTransaction.end();
      if (i != 0) {
        notifyContactChanged(1);
      }
      return;
      label111:
      int i = 1;
      continue;
      label116:
      i = 0;
    }
  }
  
  public void addListener(IPhoneContactListener paramIPhoneContactListener)
  {
    synchronized (this.mListenerList)
    {
      if (!this.mListenerList.contains(paramIPhoneContactListener)) {
        this.mListenerList.add(paramIPhoneContactListener);
      }
      return;
    }
  }
  
  public void addUinByPhoneNum(String paramString1, String paramString2)
  {
    Object localObject = (String)this.phoneNumToUinMap.get(paramString1);
    if ((localObject == null) || (!((String)localObject).equals(paramString2)))
    {
      this.phoneNumToUinMap.put(paramString1, paramString2);
      this.uinToPhoneNumMap.put(paramString2, paramString1);
      localObject = this.app.getEntityManagerFactory().createEntityManager();
      PhoneNumInfo localPhoneNumInfo = new PhoneNumInfo();
      localPhoneNumInfo.phoneNum = paramString1;
      localPhoneNumInfo.uin = paramString2;
      if (localObject != null)
      {
        ((EntityManager)localObject).persistOrReplace(localPhoneNumInfo);
        ((EntityManager)localObject).close();
      }
    }
  }
  
  public ContactBindedData asyncInitContactBindedData(List<PhoneContact> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new PhoneContactServiceImpl.7(this, paramList));
    return this.contactBindedDataCache;
  }
  
  public void changeHidenStatus(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeHidenStatus: mobile = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(";hide=");
      localStringBuilder.append(paramBoolean);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    paramString = queryContactByCodeNumber(paramString);
    if ((paramString != null) && (paramString.isHiden != paramBoolean))
    {
      paramString.isHiden = paramBoolean;
      this.em.update(paramString);
    }
  }
  
  public boolean checkAndUploadContact(boolean paramBoolean)
  {
    int i;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      i = 1;
    } else {
      i = 0;
    }
    long l1 = MessageCache.c();
    long l2 = Math.abs(l1 - this.mUserSettingFlag);
    int j;
    if (l2 < 3600L) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && ((paramBoolean) || (this.runningForegroud)))
    {
      boolean bool = PermissionChecker.a().d();
      if (i == 0) {
        bool = PermissionChecker.a().e();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndUploadContact,  has: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(",  state: ");
        localStringBuilder.append(getSelfBindState());
        QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        if (i != 0)
        {
          ThreadManager.excute(new PhoneContactServiceImpl.20(this, paramBoolean), 16, null, false);
        }
        else
        {
          uploadOrUpdateContact();
          if (paramBoolean) {
            paramBoolean = true;
          } else {
            paramBoolean = this.needUploadResultTip;
          }
          this.needUploadResultTip = paramBoolean;
        }
        paramBoolean = true;
        break label207;
      }
    }
    paramBoolean = false;
    label207:
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("checkAndUploadContact [%s, %s, %s, %s]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(this.mUserSettingFlag), Boolean.valueOf(paramBoolean) }));
    }
    if ((j == 0) || (paramBoolean)) {
      markOrClearUserSettingFlag(false);
    }
    return paramBoolean;
  }
  
  public void checkUpdateBindStateAndListIgnoreBindState(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      boolean bool = this.destroyed;
      if (bool) {
        return;
      }
      ThreadManager.excute(new PhoneContactServiceImpl.5(this, paramBoolean1, paramBoolean2, paramInt), 16, null, false);
      return;
    }
    finally {}
  }
  
  public void checkUpdateLocalContact(boolean paramBoolean, int paramInt)
  {
    if (this.destroyed) {
      return;
    }
    if (((paramInt == 2) || (paramInt == 23)) && (!this.runningForegroud))
    {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, String.format("checkUpdateLocalContact() return. beFirstQuery=%b queryFrom=%d runningForegroud=%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.runningForegroud) }));
      return;
    }
    int i;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      boolean bool = dealCheckUpdateLocalContact(paramBoolean);
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 1, String.format("post dealCheckUpdateLocalContact() [beFirstQuery, queryFrom, deal]=[%b, %d, %b]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      if ((!bool) && ((paramInt == 2) || (paramInt == 23))) {
        checkUpdateBindStateAndList(false, true, paramInt);
      }
    }
    else
    {
      ThreadManager.getSubThreadHandler().post(new PhoneContactServiceImpl.15(this, paramBoolean, paramInt));
    }
  }
  
  public void clearRecommendBadge()
  {
    ThreadManager.executeOnNetWorkThread(this.mClearRecommendBadgeTask);
  }
  
  public void deleteContactMatch(ContactMatch paramContactMatch)
  {
    synchronized (this.mRecommendLock)
    {
      if (this.mContactMatch != null)
      {
        this.mContactMatch.remove(paramContactMatch);
        this.em.remove(paramContactMatch);
      }
      return;
    }
  }
  
  public void deletePhoneContactAddInfo(PhoneContactAdd paramPhoneContactAdd)
  {
    synchronized (this.mRecommendLock)
    {
      if (this.mPhoneContactAddList != null)
      {
        this.mPhoneContactAddList.remove(paramPhoneContactAdd);
        this.em.remove(paramPhoneContactAdd);
      }
      return;
    }
  }
  
  public boolean deletePhoneContactAddInfo(String paramString)
  {
    synchronized (this.mRecommendLock)
    {
      Iterator localIterator = this.mPhoneContactAddList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)localIterator.next();
        if (localPhoneContactAdd.unifiedCode.equals(paramString))
        {
          localIterator.remove();
          this.em.remove(localPhoneContactAdd);
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void disableMobileMatch(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 33);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    this.app.startServlet(localNewIntent);
  }
  
  /* Error */
  public boolean existContact(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1714
    //   3: astore 10
    //   5: ldc_w 1581
    //   8: astore 9
    //   10: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +58 -> 71
    //   16: new 496	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   23: astore 6
    //   25: aload 6
    //   27: ldc_w 1716
    //   30: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_1
    //   37: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: ldc_w 1562
    //   46: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 6
    //   52: aload_2
    //   53: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 74
    //   59: iconst_2
    //   60: aload 6
    //   62: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: goto +3 -> 71
    //   71: aload_2
    //   72: astore 6
    //   74: aload_0
    //   75: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   78: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   81: invokevirtual 1061	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   84: astore 12
    //   86: aconst_null
    //   87: astore 8
    //   89: aconst_null
    //   90: astore 7
    //   92: aconst_null
    //   93: astore 11
    //   95: aload 8
    //   97: astore_2
    //   98: getstatic 1593	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   101: astore 13
    //   103: aload 8
    //   105: astore_2
    //   106: new 496	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   113: astore 14
    //   115: aload 8
    //   117: astore_2
    //   118: aload 14
    //   120: ldc_w 1718
    //   123: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 8
    //   129: astore_2
    //   130: aload 14
    //   132: aload_1
    //   133: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 8
    //   139: astore_2
    //   140: aload 14
    //   142: ldc_w 1720
    //   145: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 8
    //   151: astore_2
    //   152: aload 14
    //   154: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore_1
    //   158: aload 8
    //   160: astore_2
    //   161: aload 12
    //   163: aload 13
    //   165: iconst_4
    //   166: anewarray 185	java/lang/String
    //   169: dup
    //   170: iconst_0
    //   171: ldc_w 1581
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: ldc_w 1714
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: ldc_w 1586
    //   186: aastore
    //   187: dup
    //   188: iconst_3
    //   189: ldc 187
    //   191: aastore
    //   192: aload_1
    //   193: aconst_null
    //   194: aconst_null
    //   195: invokevirtual 1072	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   198: astore 8
    //   200: aload 11
    //   202: astore_2
    //   203: aload 6
    //   205: astore_1
    //   206: aload 8
    //   208: invokeinterface 1154 1 0
    //   213: ifeq +368 -> 581
    //   216: aload 8
    //   218: aload 8
    //   220: aload 9
    //   222: invokeinterface 1094 2 0
    //   227: invokeinterface 1723 2 0
    //   232: lstore_3
    //   233: getstatic 1593	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   236: astore 6
    //   238: new 496	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   245: astore 7
    //   247: aload 7
    //   249: ldc_w 1725
    //   252: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 7
    //   258: lload_3
    //   259: invokevirtual 649	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 7
    //   265: ldc_w 1727
    //   268: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 7
    //   274: ldc_w 1586
    //   277: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 7
    //   283: ldc_w 1729
    //   286: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 7
    //   292: ldc_w 1595
    //   295: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 7
    //   301: ldc_w 1731
    //   304: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 7
    //   310: ldc 193
    //   312: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 7
    //   318: ldc_w 1729
    //   321: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 7
    //   327: iconst_2
    //   328: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 7
    //   334: ldc_w 1720
    //   337: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 7
    //   343: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: astore 7
    //   348: aload 12
    //   350: aload 6
    //   352: iconst_5
    //   353: anewarray 185	java/lang/String
    //   356: dup
    //   357: iconst_0
    //   358: aload 9
    //   360: aastore
    //   361: dup
    //   362: iconst_1
    //   363: aload 10
    //   365: aastore
    //   366: dup
    //   367: iconst_2
    //   368: ldc_w 1586
    //   371: aastore
    //   372: dup
    //   373: iconst_3
    //   374: ldc 187
    //   376: aastore
    //   377: dup
    //   378: iconst_4
    //   379: ldc 193
    //   381: aastore
    //   382: aload 7
    //   384: aconst_null
    //   385: aconst_null
    //   386: invokevirtual 1072	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   389: astore 6
    //   391: aload_1
    //   392: astore 7
    //   394: aload_1
    //   395: astore_2
    //   396: aload 6
    //   398: invokeinterface 1087 1 0
    //   403: ifeq +124 -> 527
    //   406: aload_1
    //   407: astore_2
    //   408: aload 6
    //   410: aload 6
    //   412: ldc 187
    //   414: invokeinterface 1094 2 0
    //   419: invokeinterface 1097 2 0
    //   424: invokestatic 1102	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   427: astore 11
    //   429: aload_1
    //   430: astore_2
    //   431: aload_1
    //   432: invokestatic 1102	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   435: astore 7
    //   437: aload 7
    //   439: astore_2
    //   440: aload 11
    //   442: aload 7
    //   444: invokestatic 1734	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   447: ifne +54 -> 501
    //   450: aload 7
    //   452: astore_2
    //   453: new 496	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   460: astore_1
    //   461: aload 7
    //   463: astore_2
    //   464: aload_1
    //   465: ldc_w 1736
    //   468: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 7
    //   474: astore_2
    //   475: aload_1
    //   476: aload 11
    //   478: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 7
    //   484: astore_2
    //   485: aload_1
    //   486: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: aload 7
    //   491: invokestatic 1734	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   494: istore 5
    //   496: iload 5
    //   498: ifeq +29 -> 527
    //   501: aload 6
    //   503: ifnull +10 -> 513
    //   506: aload 6
    //   508: invokeinterface 1157 1 0
    //   513: aload 8
    //   515: ifnull +10 -> 525
    //   518: aload 8
    //   520: invokeinterface 1157 1 0
    //   525: iconst_1
    //   526: ireturn
    //   527: aload 6
    //   529: ifnull +160 -> 689
    //   532: aload 6
    //   534: invokeinterface 1157 1 0
    //   539: goto +150 -> 689
    //   542: aload_2
    //   543: ifnull +9 -> 552
    //   546: aload_2
    //   547: invokeinterface 1157 1 0
    //   552: aload_1
    //   553: athrow
    //   554: aload 6
    //   556: astore_1
    //   557: aload 7
    //   559: astore_2
    //   560: aload 7
    //   562: ifnull +16 -> 578
    //   565: aload 7
    //   567: invokeinterface 1157 1 0
    //   572: aload 7
    //   574: astore_2
    //   575: aload 6
    //   577: astore_1
    //   578: goto -372 -> 206
    //   581: aload 8
    //   583: ifnull +67 -> 650
    //   586: aload 8
    //   588: invokeinterface 1157 1 0
    //   593: iconst_0
    //   594: ireturn
    //   595: astore_1
    //   596: aload 8
    //   598: astore_2
    //   599: goto +53 -> 652
    //   602: astore 6
    //   604: aload 8
    //   606: astore_1
    //   607: goto +12 -> 619
    //   610: astore_1
    //   611: goto +41 -> 652
    //   614: astore 6
    //   616: aload 7
    //   618: astore_1
    //   619: aload_1
    //   620: astore_2
    //   621: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   624: ifeq +16 -> 640
    //   627: aload_1
    //   628: astore_2
    //   629: ldc 74
    //   631: iconst_2
    //   632: ldc_w 1737
    //   635: aload 6
    //   637: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   640: aload_1
    //   641: ifnull +9 -> 650
    //   644: aload_1
    //   645: invokeinterface 1157 1 0
    //   650: iconst_0
    //   651: ireturn
    //   652: aload_2
    //   653: ifnull +9 -> 662
    //   656: aload_2
    //   657: invokeinterface 1157 1 0
    //   662: goto +5 -> 667
    //   665: aload_1
    //   666: athrow
    //   667: goto -2 -> 665
    //   670: astore 6
    //   672: goto +56 -> 728
    //   675: astore 6
    //   677: goto +51 -> 728
    //   680: astore 6
    //   682: goto +33 -> 715
    //   685: astore_1
    //   686: goto +19 -> 705
    //   689: aload 6
    //   691: astore_2
    //   692: aload 7
    //   694: astore_1
    //   695: goto -117 -> 578
    //   698: astore_1
    //   699: aload 6
    //   701: astore_2
    //   702: goto -160 -> 542
    //   705: aload 6
    //   707: astore 7
    //   709: aload_2
    //   710: astore 6
    //   712: goto -158 -> 554
    //   715: aload_1
    //   716: astore 6
    //   718: aload_2
    //   719: astore 7
    //   721: goto -167 -> 554
    //   724: astore_1
    //   725: goto -183 -> 542
    //   728: aload_1
    //   729: astore 6
    //   731: aload_2
    //   732: astore 7
    //   734: goto -180 -> 554
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	737	0	this	PhoneContactServiceImpl
    //   0	737	1	paramString1	String
    //   0	737	2	paramString2	String
    //   232	27	3	l	long
    //   494	3	5	bool	boolean
    //   23	553	6	localObject1	Object
    //   602	1	6	localException1	Exception
    //   614	22	6	localException2	Exception
    //   670	1	6	localException3	Exception
    //   675	1	6	localException4	Exception
    //   680	26	6	localException5	Exception
    //   710	20	6	str1	String
    //   90	643	7	localObject2	Object
    //   87	518	8	localCursor	android.database.Cursor
    //   8	351	9	str2	String
    //   3	361	10	str3	String
    //   93	384	11	str4	String
    //   84	265	12	localContentResolver	ContentResolver
    //   101	63	13	localUri	android.net.Uri
    //   113	40	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   206	233	595	finally
    //   506	513	595	finally
    //   532	539	595	finally
    //   546	552	595	finally
    //   552	554	595	finally
    //   565	572	595	finally
    //   206	233	602	java/lang/Exception
    //   506	513	602	java/lang/Exception
    //   532	539	602	java/lang/Exception
    //   546	552	602	java/lang/Exception
    //   552	554	602	java/lang/Exception
    //   565	572	602	java/lang/Exception
    //   98	103	610	finally
    //   106	115	610	finally
    //   118	127	610	finally
    //   130	137	610	finally
    //   140	149	610	finally
    //   152	158	610	finally
    //   161	200	610	finally
    //   621	627	610	finally
    //   629	640	610	finally
    //   98	103	614	java/lang/Exception
    //   106	115	614	java/lang/Exception
    //   118	127	614	java/lang/Exception
    //   130	137	614	java/lang/Exception
    //   140	149	614	java/lang/Exception
    //   152	158	614	java/lang/Exception
    //   161	200	614	java/lang/Exception
    //   233	238	670	java/lang/Exception
    //   238	247	675	java/lang/Exception
    //   247	391	680	java/lang/Exception
    //   396	406	685	java/lang/Exception
    //   408	429	685	java/lang/Exception
    //   431	437	685	java/lang/Exception
    //   440	450	685	java/lang/Exception
    //   453	461	685	java/lang/Exception
    //   464	472	685	java/lang/Exception
    //   475	482	685	java/lang/Exception
    //   485	496	685	java/lang/Exception
    //   396	406	698	finally
    //   408	429	698	finally
    //   431	437	698	finally
    //   440	450	698	finally
    //   453	461	698	finally
    //   464	472	698	finally
    //   475	482	698	finally
    //   485	496	698	finally
    //   233	238	724	finally
    //   238	247	724	finally
    //   247	391	724	finally
  }
  
  public void fillToMaxCountIfNeeded(ArrayList<PhoneContact> paramArrayList, int paramInt)
  {
    Iterator localIterator = this.contactCache.values().iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (paramInt == 0) {
        return;
      }
      if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!paramArrayList.contains(localPhoneContact)))
      {
        paramInt -= 1;
        paramArrayList.add(localPhoneContact);
      }
    }
  }
  
  public ArrayList<PhoneContact> generateRandomList()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = getBindNonfriendList(null);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      Object localObject1 = (IAddFriendServiceApi)this.app.getRuntimeService(IAddFriendServiceApi.class, "");
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PhoneContact)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((PhoneContact)localObject3).samFriend > 0) && (!((IAddFriendServiceApi)localObject1).hasSendAddFriendReq(((PhoneContact)localObject3).unifiedCode, true))) {
          localArrayList.add(localObject3);
        }
      }
      int i = localArrayList.size();
      int j = this.mStarRecommendCount;
      if (i < j)
      {
        localObject1 = localArrayList;
      }
      else
      {
        localObject2 = new ArrayList(j);
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= this.mStarRecommendCount) {
            break;
          }
          ((ArrayList)localObject2).add((PhoneContact)localArrayList.remove(this.mRandom.nextInt(localArrayList.size())));
          i += 1;
        }
      }
      try
      {
        localObject2 = this.mLastLoginSet;
        localObject3 = this.app;
        Collections.sort((List)localObject1, new PhoneContactComparator(new int[] { 3, 4 }, (Set)localObject2, (AppInterface)localObject3));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(localIllegalArgumentException);
        QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 1, ((StringBuilder)localObject3).toString(), localIllegalArgumentException);
      }
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("generateRandomList,[%s, %s, %s]", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()), Integer.valueOf(localArrayList.size()), Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("generateRandomList,[%s, %s]", new Object[] { Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - l) }));
    }
    return new ArrayList();
  }
  
  public int getBannerState()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (QLog.isColorLevel())
    {
      localStringBuffer.append("getBannerState bind state = ");
      localStringBuffer.append(getSelfBindState());
    }
    if (getSelfBindState() == 9)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" isCacheInited=");
        localStringBuffer.append(this.isCacheInited);
      }
      if (this.isCacheInited)
      {
        if (this.contactCache.size() == 0)
        {
          i = 1;
          break label92;
        }
      }
      else
      {
        i = 0;
        break label92;
      }
    }
    int i = 2;
    label92:
    if (QLog.isColorLevel())
    {
      localStringBuffer.append(" ret=");
      localStringBuffer.append(i);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuffer.toString());
    }
    return i;
  }
  
  public List<PhoneContact> getBindAllFriendList()
  {
    Object localObject2 = this.bindAllFriendList;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = initBindAllFriendList();
    }
    Object localObject1 = new ArrayList((Collection)localObject1);
    try
    {
      localObject2 = this.mLastLoginSet;
      AppInterface localAppInterface = this.app;
      Collections.sort((List)localObject1, new PhoneContactComparator(new int[] { 6, 5, 1, 4 }, (Set)localObject2, localAppInterface));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "getBindAllFriendList", localException);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBindAllFriendList size = ");
      localStringBuilder.append(((List)localObject1).size());
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    this.bindAllFriendList = ((List)localObject1);
    return localObject1;
  }
  
  public List<PhoneContact> getBindHideNoneFriendList(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Object localObject2 = this.bindNonFriendList;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = initBindNonfriendList();
    }
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject1).next();
      if (localPhoneContact.isHiden) {
        ((List)localObject2).add(localPhoneContact);
      }
    }
    if (paramBoolean) {
      Collections.sort((List)localObject2, new PhoneContactComparator(new int[] { 1, 4 }, null, null));
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBindHideNoneFriendList cost: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject1).append(", size = ");
      ((StringBuilder)localObject1).append(((List)localObject2).size());
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public List<PhoneContact> getBindNonfriendList()
  {
    return getBindNonfriendList(new int[] { 1, 2, 4 });
  }
  
  public List<PhoneContact> getBindNonfriendList(int[] paramArrayOfInt)
  {
    long l = System.currentTimeMillis();
    List localList = this.bindNonFriendList;
    Object localObject = localList;
    if (localList == null) {
      localObject = initBindNonfriendList();
    }
    localObject = new ArrayList((Collection)localObject);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      try
      {
        Collections.sort((List)localObject, new PhoneContactComparator(paramArrayOfInt, this.mLastLoginSet, this.app));
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "getBindNonfriendList", paramArrayOfInt);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("getBindNonfriendList cost: ");
      paramArrayOfInt.append(System.currentTimeMillis() - l);
      paramArrayOfInt.append(", size = ");
      paramArrayOfInt.append(((List)localObject).size());
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, paramArrayOfInt.toString());
    }
    this.bindNonFriendList = ((List)localObject);
    return localObject;
  }
  
  public int getBindStateForServer()
  {
    if (getSelfBindState() <= 5) {
      return 2;
    }
    return 1;
  }
  
  public String getBindWording()
  {
    return this.pref.getString("key_bind_wording", null);
  }
  
  public String getBlockMsg()
  {
    return this.pref.getString("key_block_msg", null);
  }
  
  public ContactBindedData getContactBoundDataCache()
  {
    return this.contactBindedDataCache;
  }
  
  public List<PhoneContact> getContactList()
  {
    if (this.isCacheInited)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(this.contactCache.values());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localException.toString());
        }
        return this.em.query(PhoneContact.class);
      }
    }
    return this.em.query(PhoneContact.class);
  }
  
  public List<PhoneContact> getContactListForContactListView(Map<String, PhoneContact> paramMap, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new ArrayList();
    if (paramMap != null) {
      ((List)localObject1).addAll(paramMap.values());
    }
    if (!paramBoolean) {
      Collections.sort((List)localObject1, new PhoneContactServiceImpl.18(this));
    }
    ArrayList localArrayList = new ArrayList();
    IFriendDataService localIFriendDataService = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
    if (((List)localObject1).size() > 0)
    {
      if (getSelfBindInfo() == null) {
        return null;
      }
      String str1 = getSelfBindInfo().mobileNo;
      Iterator localIterator = ((List)localObject1).iterator();
      paramMap = null;
      label650:
      while (localIterator.hasNext())
      {
        localObject1 = (PhoneContact)localIterator.next();
        if ((str1 == null) || (!str1.endsWith(((PhoneContact)localObject1).mobileNo.trim())))
        {
          localObject1 = (PhoneContact)((PhoneContact)localObject1).clone();
          if (paramMap == null)
          {
            if (!TextUtils.isEmpty(((PhoneContact)localObject1).uin))
            {
              if (((PhoneContact)localObject1).uin.equals("0")) {
                paramMap = null;
              } else {
                paramMap = localIFriendDataService.getFriend(((PhoneContact)localObject1).uin, true, true);
              }
              if ((paramMap != null) && (paramMap.groupid >= 0))
              {
                ((PhoneContact)localObject1).nickName = paramMap.getFriendNick();
                ((PhoneContact)localObject1).remark = paramMap.remark;
              }
              else
              {
                ((PhoneContact)localObject1).uin = "0";
              }
            }
          }
          else
          {
            if ((!paramBoolean) && (((PhoneContact)localObject1).contactID == paramMap.contactID))
            {
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramMap.mobileNo);
              ((StringBuilder)localObject2).append("|");
              ((StringBuilder)localObject2).append(((PhoneContact)localObject1).mobileNo);
              String str2 = ((StringBuilder)localObject2).toString();
              boolean bool2 = TextUtils.isEmpty(paramMap.uin) ^ true;
              int i;
              if ((bool2) && (!paramMap.uin.equals("0"))) {
                i = 1;
              } else {
                i = 0;
              }
              boolean bool1 = TextUtils.isEmpty(((PhoneContact)localObject1).uin) ^ true;
              int j;
              if ((bool1) && (!((PhoneContact)localObject1).uin.equals("0"))) {
                j = 1;
              } else {
                j = 0;
              }
              if (j == 0) {
                localObject2 = null;
              } else {
                localObject2 = localIFriendDataService.getFriend(((PhoneContact)localObject1).uin, true, true);
              }
              int k;
              if ((localObject2 != null) && (((Friends)localObject2).groupid >= 0)) {
                k = 1;
              } else {
                k = 0;
              }
              if (i != 0) {
                i = 0;
              } else if (bool2) {
                i = 1;
              } else {
                i = 2;
              }
              if (k != 0) {
                j = 0;
              } else if (bool1) {
                j = 1;
              } else {
                j = 2;
              }
              if (i > j)
              {
                if (bool1) {
                  if (k != 0)
                  {
                    ((PhoneContact)localObject1).nickName = ((Friends)localObject2).getFriendNick();
                    ((PhoneContact)localObject1).remark = ((Friends)localObject2).remark;
                  }
                  else
                  {
                    ((PhoneContact)localObject1).uin = "0";
                  }
                }
                paramMap = (Map<String, PhoneContact>)localObject1;
              }
              paramMap.mobileNo = str2;
              break label650;
            }
            localArrayList.add(paramMap);
            if (!TextUtils.isEmpty(((PhoneContact)localObject1).uin))
            {
              if (((PhoneContact)localObject1).uin.equals("0")) {
                paramMap = null;
              } else {
                paramMap = localIFriendDataService.getFriend(((PhoneContact)localObject1).uin, true, true);
              }
              if ((paramMap != null) && (paramMap.groupid >= 0))
              {
                ((PhoneContact)localObject1).nickName = paramMap.getFriendNick();
                ((PhoneContact)localObject1).remark = paramMap.remark;
              }
              else
              {
                ((PhoneContact)localObject1).uin = "0";
              }
            }
          }
          paramMap = (Map<String, PhoneContact>)localObject1;
        }
      }
      if (paramMap != null) {
        localArrayList.add(paramMap);
      }
      removeDuplicate(localArrayList);
      Collections.sort(localArrayList, new PhoneContactServiceImpl.19(this));
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("getContactListForContactListView sort contact cost time: ");
      paramMap.append(System.currentTimeMillis() - l);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, paramMap.toString());
    }
    return localArrayList;
  }
  
  public List<PhoneContact> getContactListForContactListView(boolean paramBoolean)
  {
    if (this.mListForContactListView == null) {
      this.mListForContactListView = getContactListForContactListView(this.contactCache, paramBoolean);
    }
    return this.mListForContactListView;
  }
  
  public List<List<PhoneContact>> getContactListForDisplay()
  {
    long l = System.currentTimeMillis();
    if (this.destroyed) {
      return new ArrayList(0);
    }
    Object localObject2;
    if (this.orderedBindList == null)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.contactCache.values());
      Collections.sort((List)localObject1, new PhoneContactServiceImpl.13(this));
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      IFriendDataService localIFriendDataService = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
      if (((List)localObject1).size() > 0)
      {
        if (getSelfBindInfo() == null) {
          return null;
        }
        String str = getSelfBindInfo().mobileNo;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        while (localIterator.hasNext())
        {
          localObject2 = (PhoneContact)localIterator.next();
          if ((str == null) || (!str.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
          {
            PhoneContact localPhoneContact = (PhoneContact)((PhoneContact)localObject2).clone();
            if (TextUtils.isEmpty(localPhoneContact.uin))
            {
              if (localObject1 != null)
              {
                if (localPhoneContact.contactID == ((PhoneContact)localObject1).contactID)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(((PhoneContact)localObject1).mobileNo);
                  ((StringBuilder)localObject2).append("|");
                  ((StringBuilder)localObject2).append(localPhoneContact.mobileNo);
                  ((PhoneContact)localObject1).mobileNo = ((StringBuilder)localObject2).toString();
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("getContactListForDisplay: conbine contact contact name is:");
                    ((StringBuilder)localObject2).append(((PhoneContact)localObject1).name);
                    ((StringBuilder)localObject2).append("uin is :");
                    ((StringBuilder)localObject2).append(((PhoneContact)localObject1).uin);
                    ((StringBuilder)localObject2).append("number is:");
                    ((StringBuilder)localObject2).append(((PhoneContact)localObject1).mobileNo);
                    QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject2).toString());
                  }
                }
                else
                {
                  localArrayList2.add(localObject1);
                }
              }
              else {
                localObject1 = localPhoneContact;
              }
            }
            else
            {
              if (localPhoneContact.uin.equals("0")) {
                localObject2 = null;
              } else {
                localObject2 = localIFriendDataService.getFriend(localPhoneContact.uin, true, true);
              }
              if ((localObject2 != null) && (((Friends)localObject2).groupid >= 0))
              {
                localPhoneContact.nickName = ((Friends)localObject2).getFriendNick();
                localPhoneContact.remark = ((Friends)localObject2).remark;
              }
              else
              {
                localPhoneContact.uin = "0";
              }
              localArrayList1.add(localPhoneContact);
            }
          }
        }
        if (localObject1 != null) {
          localArrayList2.add(localObject1);
        }
        localObject1 = new PhoneContactServiceImpl.14(this);
        Collections.sort(localArrayList1, (Comparator)localObject1);
        Collections.sort(localArrayList2, (Comparator)localObject1);
      }
      this.orderedBindList = localArrayList1;
      this.orderedNobindList = localArrayList2;
    }
    Object localObject1 = new ArrayList();
    removeDuplicate(this.orderedBindList);
    removeDuplicate(this.orderedNobindList);
    ((List)localObject1).add(this.orderedBindList);
    ((List)localObject1).add(this.orderedNobindList);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sort contact cost time: ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public List<PhoneContact> getContactListForPhoneSelector()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
    Object localObject1 = this.mListForPhoneSelector;
    if ((localObject1 == null) || (((List)localObject1).size() <= 0))
    {
      localObject1 = new ArrayList();
      Object localObject3 = this.contactCache.values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject3).next();
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          ((List)localObject1).add(localPhoneContact);
        } else if ((!localPhoneContact.uin.equals("0")) && (((IFriendDataService)localObject2).getFriend(localPhoneContact.uin, true, true) != null)) {
          ((List)localObject1).add(localPhoneContact);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        if (getSelfBindInfo() == null) {
          return null;
        }
        ((List)localObject1).remove(queryPhoneContactByMobile(getSelfBindInfo().mobileNo));
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (PhoneContact)((Iterator)localObject2).next();
          if (((PhoneContact)localObject3).pinyinFirst == null) {
            ((PhoneContact)localObject3).pinyinFirst = PhoneContactHelper.b(((PhoneContact)localObject3).pinyinInitial);
          }
        }
        Collections.sort((List)localObject1, new PhoneContactServiceImpl.17(this));
      }
      this.mListForPhoneSelector = ((List)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getContactListForPhoneSelector sort contact cost time: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    return this.mListForPhoneSelector;
  }
  
  public List<PhoneContact> getContactListForSelector()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.mListForSelector;
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      localObject = new ArrayList();
      ((List)localObject).addAll(this.contactCache.values());
      if (((List)localObject).size() > 0)
      {
        if (getSelfBindInfo() == null) {
          return null;
        }
        ((List)localObject).remove(queryPhoneContactByMobile(getSelfBindInfo().mobileNo));
        Collections.sort((List)localObject, new PhoneContactServiceImpl.16(this));
      }
      this.mListForSelector = ((List)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getContactListForSelector sort contact cost time: ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    return this.mListForSelector;
  }
  
  public int getDetailedBindState()
  {
    return this.mCurrentBindState;
  }
  
  public Object[] getFriendHasBindPhone()
  {
    Object localObject;
    if (this.mFrdHasBindPhoneTotalCount < 0)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      if (localObject != null)
      {
        String str = this.app.getAccount();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("frd_has_bind_phone_count_");
        localStringBuilder.append(str);
        this.mFrdHasBindPhoneTotalCount = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("frd_has_bind_phone_some_");
        localStringBuilder.append(str);
        localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
        if (((String)localObject).length() > 0)
        {
          localObject = ((String)localObject).split("\\|");
          if (localObject.length > 0)
          {
            this.mSomeFrdHasBindPhone = new ArrayList(localObject.length);
            Collections.addAll(this.mSomeFrdHasBindPhone, (Object[])localObject);
          }
        }
      }
      else
      {
        this.mFrdHasBindPhoneTotalCount = 0;
        this.mSomeFrdHasBindPhone = null;
      }
    }
    if (QLog.isColorLevel())
    {
      int i = this.mFrdHasBindPhoneTotalCount;
      localObject = this.mSomeFrdHasBindPhone;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = TextUtils.join(",", (Iterable)localObject);
      }
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("getFriendHasBindPhone [%s, %s]", new Object[] { Integer.valueOf(i), localObject }));
    }
    return new Object[] { Integer.valueOf(this.mFrdHasBindPhoneTotalCount), this.mSomeFrdHasBindPhone };
  }
  
  public long getLastLoginType(String paramString)
  {
    if (this.mLastLoginSet.contains(paramString)) {
      return 1L;
    }
    return 10L;
  }
  
  public ArrayList<PhoneContactAdd> getPhoneContactAddList()
  {
    return this.mPhoneContactAddList;
  }
  
  public PhoneContact getPhoneContactByMD5(String paramString)
  {
    return (PhoneContact)this.md52PhoneContact.get(paramString);
  }
  
  public String getPhoneNumByUin(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      Object localObject = (String)this.uinToPhoneNumMap.get(paramString);
      if (localObject != null) {
        return localObject;
      }
      localObject = this.app;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      }
      if (localObject == null) {
        return null;
      }
      paramString = (PhoneNumInfo)((EntityManager)localObject).find(PhoneNumInfo.class, "uin=?", new String[] { paramString });
      if (paramString != null) {
        return paramString.phoneNum;
      }
    }
    return null;
  }
  
  public ArrayList<Entity> getRecommendContact()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mRecommendLock)
    {
      if (this.mContactBinded != null) {
        localArrayList.add(this.mContactBinded);
      }
      if ((this.mContactMatch != null) && (this.mContactMatch.size() > 0))
      {
        localArrayList.addAll(this.mContactMatch);
        if (QLog.isColorLevel())
        {
          Iterator localIterator = this.mContactMatch.iterator();
          while (localIterator.hasNext())
          {
            ContactMatch localContactMatch = (ContactMatch)localIterator.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getRecommendContact|mobileNo : ");
            localStringBuilder.append(localContactMatch.mobileNo);
            localStringBuilder.append("|size : ");
            localStringBuilder.append(this.mContactMatch.size());
            QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
          }
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int getRecommendUnreadCount()
  {
    return getRecommendUnreadList().size();
  }
  
  public List<PhoneContact> getRecommendUnreadList()
  {
    Object localObject2 = this.bindNonFriendList;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = initBindNonfriendList();
    }
    localObject2 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (localPhoneContact.isNewRecommend) {
        ((List)localObject2).add(localPhoneContact);
      }
    }
    this.bindNonFriendList = ((List)localObject1);
    return localObject2;
  }
  
  public RespondQueryQQBindingStat getSelfBindInfo()
  {
    if (this.destroyed) {
      return null;
    }
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    Object localObject = this.app.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contact_bind_info");
    localStringBuilder.append(this.app.getAccount());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (localObject == null) {
      return null;
    }
    localRespondQueryQQBindingStat.nationCode = ((SharedPreferences)localObject).getString("contact_bind_info_nation", null);
    localRespondQueryQQBindingStat.mobileNo = ((SharedPreferences)localObject).getString("contact_bind_info_mobile", "");
    localRespondQueryQQBindingStat.MobileUniqueNo = ((SharedPreferences)localObject).getString("contact_bind_info_imei", "");
    localRespondQueryQQBindingStat.isRecommend = ((SharedPreferences)localObject).getLong("contact_bind_info_recommend", 0L);
    localRespondQueryQQBindingStat.originBinder = ((SharedPreferences)localObject).getLong("contact_bind_info_origin", 0L);
    localRespondQueryQQBindingStat.bindingTime = ((SharedPreferences)localObject).getLong("contact_bind_info_time", 0L);
    localRespondQueryQQBindingStat.lastUsedFlag = ((SharedPreferences)localObject).getLong("contact_bind_info_flag", 0L);
    localRespondQueryQQBindingStat.type = ((SharedPreferences)localObject).getInt("contact_bind_type", 0);
    localRespondQueryQQBindingStat.isStopFindMatch = ((SharedPreferences)localObject).getBoolean("contact_bind_stop_find_match", false);
    localRespondQueryQQBindingStat.noBindUploadContacts = ((SharedPreferences)localObject).getBoolean("contact_bind_nobind_upload", false);
    localRespondQueryQQBindingStat.noBindUploadContactsLocal = ((SharedPreferences)localObject).getBoolean("contact_bind_nobind_upload_local", false);
    localRespondQueryQQBindingStat.continueUploadNotbind = ((SharedPreferences)localObject).getBoolean("contact_bind_nobind_continue_upload", false);
    localRespondQueryQQBindingStat.isPhoneSwitched = ((SharedPreferences)localObject).getBoolean("contact_bind_is_phone_switched", false);
    return localRespondQueryQQBindingStat;
  }
  
  public int getSelfBindState()
  {
    switch (this.mCurrentBindState)
    {
    case 0: 
    default: 
      return 0;
    case 9: 
      return 9;
    case 8: 
      return 8;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      return this.mCurrentBindState;
    }
    this.mCurrentBindState = getSelfBindState(getSelfBindInfo());
    return getSelfBindState();
  }
  
  public long getUIBits()
  {
    return this.mUIBits;
  }
  
  public String getUNIQUE_NO()
  {
    if (this.UNIQUE_NO == null) {
      try
      {
        if (this.UNIQUE_NO == null) {
          this.UNIQUE_NO = initUniqueString();
        }
      }
      finally {}
    }
    return this.UNIQUE_NO;
  }
  
  public String getUinByPhoneNum(String paramString)
  {
    if (this.destroyed) {
      return null;
    }
    if (paramString == null) {
      return null;
    }
    if (!this.phoneNumToUinMap.containsKey(paramString))
    {
      Object localObject = this.app;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      }
      if (localObject == null) {
        return null;
      }
      PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)((EntityManager)localObject).find(PhoneNumInfo.class, paramString);
      if (localPhoneNumInfo != null)
      {
        this.phoneNumToUinMap.put(paramString, localPhoneNumInfo.uin);
        this.uinToPhoneNumMap.put(localPhoneNumInfo.uin, paramString);
      }
      ((EntityManager)localObject).close();
    }
    return (String)this.phoneNumToUinMap.get(paramString);
  }
  
  public int getUploadPackages()
  {
    return this.mUploadPackages;
  }
  
  public int getsAllEntranceConfigVersion()
  {
    return this.mSharePref.getInt("key_config_version", 0);
  }
  
  /* Error */
  public boolean hasReadContactPermission()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   17: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: invokevirtual 1061	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   23: getstatic 1067	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   26: iconst_1
    //   27: anewarray 185	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 187
    //   34: aastore
    //   35: aconst_null
    //   36: aconst_null
    //   37: ldc_w 2027
    //   40: invokevirtual 1072	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 7
    //   45: aload 7
    //   47: astore 6
    //   49: aload 7
    //   51: astore 5
    //   53: aload 7
    //   55: invokeinterface 1078 1 0
    //   60: istore_1
    //   61: iload_3
    //   62: istore_2
    //   63: iload_1
    //   64: ifle +5 -> 69
    //   67: iconst_1
    //   68: istore_2
    //   69: iload_2
    //   70: istore_3
    //   71: aload 7
    //   73: ifnull +43 -> 116
    //   76: aload 7
    //   78: astore 5
    //   80: aload 5
    //   82: invokeinterface 1157 1 0
    //   87: iload_2
    //   88: ireturn
    //   89: astore 5
    //   91: goto +27 -> 118
    //   94: astore 7
    //   96: aload 5
    //   98: astore 6
    //   100: aload 7
    //   102: invokevirtual 1073	java/lang/Exception:printStackTrace	()V
    //   105: iload 4
    //   107: istore_3
    //   108: aload 5
    //   110: ifnull +6 -> 116
    //   113: goto -33 -> 80
    //   116: iload_3
    //   117: ireturn
    //   118: aload 6
    //   120: ifnull +10 -> 130
    //   123: aload 6
    //   125: invokeinterface 1157 1 0
    //   130: goto +6 -> 136
    //   133: aload 5
    //   135: athrow
    //   136: goto -3 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	PhoneContactServiceImpl
    //   60	4	1	i	int
    //   1	87	2	bool1	boolean
    //   6	111	3	bool2	boolean
    //   3	103	4	bool3	boolean
    //   8	73	5	localObject1	Object
    //   89	45	5	localObject2	Object
    //   11	113	6	localObject3	Object
    //   43	34	7	localCursor	android.database.Cursor
    //   94	7	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   13	45	89	finally
    //   53	61	89	finally
    //   100	105	89	finally
    //   13	45	94	java/lang/Exception
    //   53	61	94	java/lang/Exception
  }
  
  public void hideContact(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideContact mobile=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("; hide=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = queryContactByCodeNumber(paramString);
    if (localObject != null)
    {
      localObject = new AddressBookItem(((PhoneContact)localObject).mobileNo, ((PhoneContact)localObject).name);
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 34);
      localNewIntent.putExtra("param_hiden_mobile", (Serializable)localObject);
      localNewIntent.putExtra("param_hiden_flag", paramBoolean);
      localNewIntent.putExtra("unique_phone_no", paramString);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void initContactCache()
  {
    if (!this.isCacheInited)
    {
      this.contactCache.clear();
      this.contactCacheByUin.clear();
      this.contactCacheByCodeNumber.clear();
      this.md52PhoneContact.clear();
      ??? = this.em.query(PhoneContact.class);
      if (??? != null)
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)???).next();
          localPhoneContact.pinyinFirst = PhoneContactHelper.b(localPhoneContact.pinyinInitial);
          this.contactCache.put(localPhoneContact.mobileNo, localPhoneContact);
          if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
            this.contactCacheByUin.put(localPhoneContact.uin, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
            this.contactCacheByCodeNumber.put(localPhoneContact.unifiedCode, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.md5)) {
            this.md52PhoneContact.put(localPhoneContact.md5, localPhoneContact);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "No contacts.");
      }
      synchronized (this.mRecommendLock)
      {
        this.mContactMatch = ((ArrayList)this.em.query(ContactMatch.class, false, null, null, null, null, null, null));
        this.mPhoneContactAddList = ((ArrayList)this.em.query(PhoneContactAdd.class, false, null, null, null, null, null, null));
        sAllEntranceNum = this.mSharePref.getInt("all_entrance_num", 20);
        initLastLoginList();
        this.isCacheInited = true;
        notifyContactChanged(1);
        if (QLog.isColorLevel())
        {
          QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("initContactCache [%s]", new Object[] { Integer.valueOf(sAllEntranceNum) }));
          return;
        }
      }
    }
  }
  
  public boolean isAutoUploadContacts()
  {
    if (this.mCurrentBindState == 8) {
      return true;
    }
    if (this.mCurrentBindState == 6)
    {
      if (getSelfBindInfo() != null) {
        return getSelfBindInfo().lastUsedFlag == 2L;
      }
    }
    else if (this.mCurrentBindState == 7)
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = getSelfBindInfo();
      if (localRespondQueryQQBindingStat != null) {
        return localRespondQueryQQBindingStat.isStopFindMatch ^ true;
      }
    }
    return false;
  }
  
  public boolean isAutoUploadContactsNotBind()
  {
    int i = this.mCurrentBindState;
    boolean bool2 = false;
    if (i == 4) {}
    boolean bool1;
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      bool1 = true;
      break;
      localObject2 = getSelfBindInfo();
      if (this.mCurrentBindState == 3)
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (localObject2 == null) {
          break;
        }
        localObject1 = localObject2;
        bool1 = bool2;
        if (getSelfBindInfo().lastUsedFlag != 2L) {
          break;
        }
      }
      else
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (localObject2 == null) {
          break;
        }
        localObject1 = localObject2;
        bool1 = bool2;
        if (!((RespondQueryQQBindingStat)localObject2).continueUploadNotbind) {
          break;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isAutoUploadContactsNotBind| result: ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", selfBindInfo: ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", bindState: ");
      ((StringBuilder)localObject2).append(this.mCurrentBindState);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public boolean isBindContactOk()
  {
    int i = getSelfBindState();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBindContactOk = ");
      localStringBuilder.append(i);
      QLog.d("PhoneContact", 2, localStringBuilder.toString());
    }
    return i >= 9;
  }
  
  public boolean isBindNoneFriendListEmpty()
  {
    if (this.bindNonFriendList == null) {
      this.bindNonFriendList = initBindNonfriendList();
    }
    return (this.bindNonFriendList == null) || (this.bindNonFriendList.isEmpty());
  }
  
  public boolean isBindedIgnoreUpload()
  {
    return getSelfBindState() > 5;
  }
  
  public boolean isDestroyed()
  {
    return this.destroyed;
  }
  
  public int loadContactFriendList(List<String> paramList)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = getSelfBindInfo();
    if (localRespondQueryQQBindingStat == null) {
      return RESULT_FAIL;
    }
    PhoneContactServiceImpl.LoadContactFriendListTask localLoadContactFriendListTask = this.mLoadContactFriendTask;
    if (localLoadContactFriendListTask != null) {
      localLoadContactFriendListTask.cancel(true);
    }
    this.mLoadContactFriendTask = new PhoneContactServiceImpl.LoadContactFriendListTask(this, null);
    this.mLoadContactFriendTask.a(paramList);
    this.mLoadContactFriendTask.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return RESULT_OK;
  }
  
  /* Error */
  public Map<String, PhoneContact> loadContactFromPhoneWithoutCaches()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 1061	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: getstatic 1067	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   13: getstatic 197	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:PHONES_PROJECTION	[Ljava/lang/String;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 1072	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore 5
    //   24: goto +21 -> 45
    //   27: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +12 -> 42
    //   33: ldc 74
    //   35: iconst_2
    //   36: ldc_w 2075
    //   39: invokestatic 2077	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aconst_null
    //   43: astore 5
    //   45: aload 5
    //   47: ifnull +408 -> 455
    //   50: invokestatic 643	java/lang/System:currentTimeMillis	()J
    //   53: lstore_3
    //   54: aload 5
    //   56: invokeinterface 1078 1 0
    //   61: istore_1
    //   62: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +39 -> 104
    //   68: new 496	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   75: astore 6
    //   77: aload 6
    //   79: ldc_w 2079
    //   82: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 6
    //   88: iload_1
    //   89: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 74
    //   95: iconst_2
    //   96: aload 6
    //   98: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: new 227	java/util/concurrent/ConcurrentHashMap
    //   107: dup
    //   108: invokespecial 228	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   111: astore 9
    //   113: aload 5
    //   115: invokeinterface 1087 1 0
    //   120: pop
    //   121: aload 5
    //   123: invokeinterface 1090 1 0
    //   128: ifne +247 -> 375
    //   131: aload 5
    //   133: aload 5
    //   135: ldc 187
    //   137: invokeinterface 1094 2 0
    //   142: invokeinterface 1097 2 0
    //   147: invokestatic 1102	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 7
    //   152: aload 5
    //   154: aload 5
    //   156: ldc 189
    //   158: invokeinterface 1094 2 0
    //   163: invokeinterface 1097 2 0
    //   168: astore 8
    //   170: aload 8
    //   172: astore 6
    //   174: aload 8
    //   176: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +7 -> 186
    //   182: aload 7
    //   184: astore 6
    //   186: aload 5
    //   188: aload 5
    //   190: ldc 191
    //   192: invokeinterface 1094 2 0
    //   197: invokeinterface 1106 2 0
    //   202: istore_1
    //   203: aload 5
    //   205: aload 5
    //   207: ldc 193
    //   209: invokeinterface 1094 2 0
    //   214: invokeinterface 1106 2 0
    //   219: istore_2
    //   220: aload 5
    //   222: aload 5
    //   224: ldc 195
    //   226: invokeinterface 1094 2 0
    //   231: invokeinterface 1097 2 0
    //   236: astore 8
    //   238: aload 7
    //   240: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +121 -> 364
    //   246: aload 6
    //   248: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifeq +6 -> 257
    //   254: goto +110 -> 364
    //   257: new 556	com/tencent/mobileqq/data/PhoneContact
    //   260: dup
    //   261: invokespecial 842	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   264: astore 10
    //   266: aload 10
    //   268: aload 7
    //   270: putfield 1107	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   273: aload 10
    //   275: aload 6
    //   277: putfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   280: aload 10
    //   282: iload_1
    //   283: putfield 1113	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   286: aload 10
    //   288: iload_2
    //   289: putfield 1116	com/tencent/mobileqq/data/PhoneContact:type	I
    //   292: aload 10
    //   294: aload 8
    //   296: putfield 1119	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   299: aload 10
    //   301: lload_3
    //   302: putfield 1122	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   305: aload 10
    //   307: aload 6
    //   309: iconst_1
    //   310: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   313: putfield 1130	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   316: aload 10
    //   318: aload 6
    //   320: iconst_2
    //   321: invokestatic 1127	com/tencent/mobileqq/utils/ChnToSpell:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   324: putfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   327: aload 10
    //   329: aload 10
    //   331: getfield 1133	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   334: invokestatic 1135	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   337: putfield 1138	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   340: aload 10
    //   342: aload 6
    //   344: aload 7
    //   346: invokestatic 1140	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   349: putfield 1143	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   352: aload 9
    //   354: aload 7
    //   356: aload 10
    //   358: invokeinterface 2080 3 0
    //   363: pop
    //   364: aload 5
    //   366: invokeinterface 1154 1 0
    //   371: pop
    //   372: goto -251 -> 121
    //   375: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +57 -> 435
    //   381: ldc 74
    //   383: iconst_2
    //   384: iconst_2
    //   385: anewarray 4	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: ldc_w 2082
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: invokestatic 643	java/lang/System:currentTimeMillis	()J
    //   399: lload_3
    //   400: lsub
    //   401: invokestatic 695	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   404: aastore
    //   405: invokestatic 1213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   408: goto +27 -> 435
    //   411: astore 6
    //   413: goto +32 -> 445
    //   416: astore 6
    //   418: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +14 -> 435
    //   424: ldc 74
    //   426: iconst_2
    //   427: ldc_w 2084
    //   430: aload 6
    //   432: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   435: aload 5
    //   437: invokeinterface 1157 1 0
    //   442: aload 9
    //   444: areturn
    //   445: aload 5
    //   447: invokeinterface 1157 1 0
    //   452: aload 6
    //   454: athrow
    //   455: aconst_null
    //   456: areturn
    //   457: astore 5
    //   459: goto -432 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	PhoneContactServiceImpl
    //   61	222	1	i	int
    //   219	70	2	j	int
    //   53	347	3	l	long
    //   22	424	5	localCursor	android.database.Cursor
    //   457	1	5	localException	Exception
    //   75	268	6	localObject1	Object
    //   411	1	6	localObject2	Object
    //   416	37	6	localStaleDataException	android.database.StaleDataException
    //   150	205	7	str1	String
    //   168	127	8	str2	String
    //   111	332	9	localConcurrentHashMap	ConcurrentHashMap
    //   264	93	10	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   113	121	411	finally
    //   121	170	411	finally
    //   174	182	411	finally
    //   186	254	411	finally
    //   257	364	411	finally
    //   364	372	411	finally
    //   375	408	411	finally
    //   418	435	411	finally
    //   113	121	416	android/database/StaleDataException
    //   121	170	416	android/database/StaleDataException
    //   174	182	416	android/database/StaleDataException
    //   186	254	416	android/database/StaleDataException
    //   257	364	416	android/database/StaleDataException
    //   364	372	416	android/database/StaleDataException
    //   375	408	416	android/database/StaleDataException
    //   0	24	457	java/lang/Exception
  }
  
  /* Error */
  public void makePhoneContactAddInfo(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +71 -> 74
    //   6: new 496	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc_w 2090
    //   20: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: aload_1
    //   27: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: ldc_w 2092
    //   36: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 5
    //   42: iload_2
    //   43: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: ldc_w 2094
    //   52: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 5
    //   58: aload_3
    //   59: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 74
    //   65: iconst_2
    //   66: aload 5
    //   68: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: iload_2
    //   75: iconst_1
    //   76: if_icmpeq +9 -> 85
    //   79: iload_2
    //   80: iconst_4
    //   81: if_icmpeq +4 -> 85
    //   84: return
    //   85: aload_0
    //   86: getfield 236	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mRecommendLock	Ljava/lang/Object;
    //   89: astore 5
    //   91: aload 5
    //   93: monitorenter
    //   94: aload_0
    //   95: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   98: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   101: astore 6
    //   103: aload 6
    //   105: invokevirtual 606	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   108: aload_0
    //   109: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   112: ifnull +340 -> 452
    //   115: aload_0
    //   116: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   119: invokevirtual 1546	java/util/ArrayList:isEmpty	()Z
    //   122: ifne +330 -> 452
    //   125: aload_0
    //   126: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   129: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   132: astore 7
    //   134: aload 7
    //   136: invokeinterface 545 1 0
    //   141: ifeq +311 -> 452
    //   144: aload 7
    //   146: invokeinterface 549 1 0
    //   151: checkcast 1705	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd
    //   154: astore 8
    //   156: aload 8
    //   158: getfield 1706	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:unifiedCode	Ljava/lang/String;
    //   161: aload_1
    //   162: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq -31 -> 134
    //   168: aload 8
    //   170: invokestatic 1230	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   173: putfield 2095	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:timestamp	J
    //   176: aload_0
    //   177: aload 8
    //   179: invokevirtual 1256	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   182: pop
    //   183: iconst_0
    //   184: istore 4
    //   186: goto +3 -> 189
    //   189: iload 4
    //   191: ifeq +128 -> 319
    //   194: new 1705	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd
    //   197: dup
    //   198: invokespecial 2096	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:<init>	()V
    //   201: astore 7
    //   203: aload 7
    //   205: aload_3
    //   206: putfield 2097	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:name	Ljava/lang/String;
    //   209: aload 7
    //   211: aload_1
    //   212: putfield 1706	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:unifiedCode	Ljava/lang/String;
    //   215: aload 7
    //   217: invokestatic 1230	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   220: putfield 2095	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:timestamp	J
    //   223: iload_2
    //   224: iconst_1
    //   225: if_icmpne +30 -> 255
    //   228: aload 7
    //   230: aload_0
    //   231: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   234: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   237: invokevirtual 2101	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   240: invokevirtual 1471	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   243: ldc_w 2102
    //   246: invokevirtual 2103	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   249: putfield 2106	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:remindInfo	Ljava/lang/String;
    //   252: goto +32 -> 284
    //   255: iload_2
    //   256: iconst_4
    //   257: if_icmpne +27 -> 284
    //   260: aload 7
    //   262: aload_0
    //   263: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   266: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   269: invokevirtual 2101	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   272: invokevirtual 1471	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   275: ldc_w 2107
    //   278: invokevirtual 2103	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   281: putfield 2106	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:remindInfo	Ljava/lang/String;
    //   284: aload_0
    //   285: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   288: ifnonnull +14 -> 302
    //   291: aload_0
    //   292: new 304	java/util/ArrayList
    //   295: dup
    //   296: invokespecial 305	java/util/ArrayList:<init>	()V
    //   299: putfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   302: aload_0
    //   303: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   306: aload 7
    //   308: invokevirtual 1167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   311: pop
    //   312: aload_0
    //   313: aload 7
    //   315: invokevirtual 1256	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   318: pop
    //   319: aload_0
    //   320: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   323: ifnull +69 -> 392
    //   326: aload_0
    //   327: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   330: invokevirtual 1546	java/util/ArrayList:isEmpty	()Z
    //   333: ifne +59 -> 392
    //   336: aload_0
    //   337: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   340: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   343: astore_3
    //   344: aload_3
    //   345: invokeinterface 545 1 0
    //   350: ifeq +42 -> 392
    //   353: aload_3
    //   354: invokeinterface 549 1 0
    //   359: checkcast 853	com/tencent/mobileqq/phonecontact/data/ContactMatch
    //   362: astore 7
    //   364: aload 7
    //   366: getfield 1224	com/tencent/mobileqq/phonecontact/data/ContactMatch:unifiedCode	Ljava/lang/String;
    //   369: aload_1
    //   370: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifeq -29 -> 344
    //   376: aload_3
    //   377: invokeinterface 1218 1 0
    //   382: aload_0
    //   383: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   386: aload 7
    //   388: invokevirtual 1220	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   391: pop
    //   392: aload 6
    //   394: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   397: aload 6
    //   399: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   402: goto +27 -> 429
    //   405: astore_1
    //   406: goto +27 -> 433
    //   409: astore_1
    //   410: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq -16 -> 397
    //   416: ldc 74
    //   418: iconst_2
    //   419: ldc_w 2108
    //   422: aload_1
    //   423: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   426: goto -29 -> 397
    //   429: aload 5
    //   431: monitorexit
    //   432: return
    //   433: aload 6
    //   435: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   438: aload_1
    //   439: athrow
    //   440: astore_1
    //   441: aload 5
    //   443: monitorexit
    //   444: goto +5 -> 449
    //   447: aload_1
    //   448: athrow
    //   449: goto -2 -> 447
    //   452: iconst_1
    //   453: istore 4
    //   455: goto -266 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	PhoneContactServiceImpl
    //   0	458	1	paramString1	String
    //   0	458	2	paramInt	int
    //   0	458	3	paramString2	String
    //   184	270	4	i	int
    //   13	429	5	localObject1	Object
    //   101	333	6	localEntityTransaction	EntityTransaction
    //   132	255	7	localObject2	Object
    //   154	24	8	localPhoneContactAdd	PhoneContactAdd
    // Exception table:
    //   from	to	target	type
    //   103	134	405	finally
    //   134	183	405	finally
    //   194	223	405	finally
    //   228	252	405	finally
    //   260	284	405	finally
    //   284	302	405	finally
    //   302	319	405	finally
    //   319	344	405	finally
    //   344	392	405	finally
    //   392	397	405	finally
    //   410	426	405	finally
    //   103	134	409	android/content/res/Resources$NotFoundException
    //   134	183	409	android/content/res/Resources$NotFoundException
    //   194	223	409	android/content/res/Resources$NotFoundException
    //   228	252	409	android/content/res/Resources$NotFoundException
    //   260	284	409	android/content/res/Resources$NotFoundException
    //   284	302	409	android/content/res/Resources$NotFoundException
    //   302	319	409	android/content/res/Resources$NotFoundException
    //   319	344	409	android/content/res/Resources$NotFoundException
    //   344	392	409	android/content/res/Resources$NotFoundException
    //   392	397	409	android/content/res/Resources$NotFoundException
    //   94	103	440	finally
    //   397	402	440	finally
    //   429	432	440	finally
    //   433	440	440	finally
    //   441	444	440	finally
  }
  
  public void markAndUploadForNewGuide()
  {
    int i = getSelfBindState();
    if (i > 5)
    {
      if (i == 9)
      {
        this.mIsUploadForNewGuide = false;
        if (!this.isCacheInited) {
          initContactCache();
        }
        saveUploadDataForNewGuide(3, this.contactCache.size(), 100, 100);
      }
      else
      {
        this.mIsUploadForNewGuide = true;
        uploadPhoneContact();
      }
    }
    else if (i == 2)
    {
      this.mIsUploadForNewGuide = false;
      if (!this.isCacheInited) {
        initContactCache();
      }
      saveUploadDataForNewGuide(3, this.contactCache.size(), 100, 100);
    }
    else
    {
      this.mIsUploadForNewGuide = true;
      uploadPhoneContactNotBind();
    }
    QLog.i("BindMsgConstant", 1, String.format("markAndUploadForNewGuide [%s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.mIsUploadForNewGuide) }));
  }
  
  public void markOrClearUserSettingFlag(boolean paramBoolean)
  {
    long l;
    if (paramBoolean) {
      l = MessageCache.c();
    } else {
      l = 0L;
    }
    this.mUserSettingFlag = l;
    SharedPreferences.Editor localEditor = this.globalPref.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user_setting_flag_");
    localStringBuilder.append(this.app.getAccount());
    localEditor.putLong(localStringBuilder.toString(), this.mUserSettingFlag).apply();
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("markOrClearUserSettingFlag [%s]", new Object[] { Long.valueOf(this.mUserSettingFlag) }));
    }
  }
  
  /* Error */
  public void markRecommendReaded()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 236	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mRecommendLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 606	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_0
    //   20: getfield 425	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactBinded	Lcom/tencent/mobileqq/phonecontact/data/ContactBinded;
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 425	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactBinded	Lcom/tencent/mobileqq/phonecontact/data/ContactBinded;
    //   30: iconst_1
    //   31: putfield 1260	com/tencent/mobileqq/phonecontact/data/ContactBinded:isReaded	Z
    //   34: aload_0
    //   35: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   38: ifnull +57 -> 95
    //   41: aload_0
    //   42: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   45: invokevirtual 862	java/util/ArrayList:size	()I
    //   48: ifle +47 -> 95
    //   51: aload_0
    //   52: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   55: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 545 1 0
    //   65: ifeq +30 -> 95
    //   68: aload_3
    //   69: invokeinterface 549 1 0
    //   74: checkcast 853	com/tencent/mobileqq/phonecontact/data/ContactMatch
    //   77: astore 4
    //   79: aload 4
    //   81: iconst_1
    //   82: putfield 2117	com/tencent/mobileqq/phonecontact/data/ContactMatch:isReaded	Z
    //   85: aload_0
    //   86: aload 4
    //   88: invokevirtual 1256	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   91: pop
    //   92: goto -33 -> 59
    //   95: aload_2
    //   96: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   99: aload_2
    //   100: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   103: goto +27 -> 130
    //   106: astore_3
    //   107: goto +26 -> 133
    //   110: astore_3
    //   111: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -15 -> 99
    //   117: ldc 74
    //   119: iconst_2
    //   120: ldc_w 2119
    //   123: aload_3
    //   124: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -28 -> 99
    //   130: aload_1
    //   131: monitorexit
    //   132: return
    //   133: aload_2
    //   134: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   137: aload_3
    //   138: athrow
    //   139: astore_2
    //   140: aload_1
    //   141: monitorexit
    //   142: goto +5 -> 147
    //   145: aload_2
    //   146: athrow
    //   147: goto -2 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	PhoneContactServiceImpl
    //   4	137	1	localObject1	Object
    //   14	120	2	localEntityTransaction	EntityTransaction
    //   139	7	2	localObject2	Object
    //   58	11	3	localIterator	Iterator
    //   106	1	3	localObject3	Object
    //   110	28	3	localException	Exception
    //   77	10	4	localContactMatch	ContactMatch
    // Exception table:
    //   from	to	target	type
    //   15	34	106	finally
    //   34	59	106	finally
    //   59	92	106	finally
    //   95	99	106	finally
    //   111	127	106	finally
    //   15	34	110	java/lang/Exception
    //   34	59	110	java/lang/Exception
    //   59	92	110	java/lang/Exception
    //   95	99	110	java/lang/Exception
    //   7	15	139	finally
    //   99	103	139	finally
    //   130	132	139	finally
    //   133	139	139	finally
    //   140	142	139	finally
  }
  
  public void markUploadedContact(List<AddressBookItem> paramList)
  {
    try
    {
      boolean bool = this.destroyed;
      if (bool) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.contactCache.get(((AddressBookItem)localObject).mobileNo);
            if (localObject != null)
            {
              ((PhoneContact)localObject).isUploaded = true;
              this.em.update((Entity)localObject);
            }
          }
          localEntityTransaction.commit();
          localEntityTransaction.end();
          this.mUploadPackages += 1;
          return;
        }
        finally
        {
          localEntityTransaction.end();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void markUploadedContactNotBind(List<AddressBookItem> paramList)
  {
    try
    {
      boolean bool = this.destroyed;
      if (bool) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.contactCache.get(((AddressBookItem)localObject).mobileNo);
            if (localObject != null)
            {
              ((PhoneContact)localObject).isUploaded = true;
              this.em.update((Entity)localObject);
            }
          }
          localEntityTransaction.commit();
          localEntityTransaction.end();
          this.mUploadPackages += 1;
          return;
        }
        finally
        {
          localEntityTransaction.end();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  /* Error */
  public void multiMakePhoneContactAddInfo(ArrayList<PhoneContact> paramArrayList, ArrayList<com.tencent.mobileqq.app.AddBatchPhoneFriendResult> paramArrayList1, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +149 -> 152
    //   6: new 496	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc_w 2127
    //   20: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 6
    //   26: iload_3
    //   27: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_1
    //   32: ifnonnull +11 -> 43
    //   35: ldc_w 2129
    //   38: astore 5
    //   40: goto +38 -> 78
    //   43: new 496	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   50: astore 5
    //   52: aload 5
    //   54: ldc_w 2131
    //   57: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 5
    //   63: aload_1
    //   64: invokevirtual 862	java/util/ArrayList:size	()I
    //   67: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore 5
    //   78: aload 6
    //   80: aload 5
    //   82: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: ifnonnull +11 -> 98
    //   90: ldc_w 2133
    //   93: astore 5
    //   95: goto +38 -> 133
    //   98: new 496	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   105: astore 5
    //   107: aload 5
    //   109: ldc_w 2135
    //   112: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: aload_2
    //   119: invokevirtual 862	java/util/ArrayList:size	()I
    //   122: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 5
    //   128: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore 5
    //   133: aload 6
    //   135: aload 5
    //   137: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 74
    //   143: iconst_2
    //   144: aload 6
    //   146: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_1
    //   153: ifnull +556 -> 709
    //   156: aload_1
    //   157: invokevirtual 1546	java/util/ArrayList:isEmpty	()Z
    //   160: ifne +549 -> 709
    //   163: aload_2
    //   164: ifnull +545 -> 709
    //   167: aload_2
    //   168: invokevirtual 1546	java/util/ArrayList:isEmpty	()Z
    //   171: ifeq +4 -> 175
    //   174: return
    //   175: iload_3
    //   176: sipush 3078
    //   179: if_icmpeq +11 -> 190
    //   182: iload_3
    //   183: sipush 3079
    //   186: if_icmpeq +4 -> 190
    //   189: return
    //   190: aload_0
    //   191: getfield 236	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mRecommendLock	Ljava/lang/Object;
    //   194: astore 5
    //   196: aload 5
    //   198: monitorenter
    //   199: aload_0
    //   200: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   203: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   206: astore 6
    //   208: aload 6
    //   210: invokevirtual 606	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   213: new 304	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 305	java/util/ArrayList:<init>	()V
    //   220: astore 7
    //   222: aload_0
    //   223: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   226: ifnonnull +21 -> 247
    //   229: aload_0
    //   230: new 304	java/util/ArrayList
    //   233: dup
    //   234: aload 7
    //   236: invokeinterface 483 1 0
    //   241: invokespecial 972	java/util/ArrayList:<init>	(I)V
    //   244: putfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   247: aload_2
    //   248: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   251: astore_2
    //   252: aload_2
    //   253: invokeinterface 545 1 0
    //   258: ifeq +160 -> 418
    //   261: aload_2
    //   262: invokeinterface 549 1 0
    //   267: checkcast 2137	com/tencent/mobileqq/app/AddBatchPhoneFriendResult
    //   270: astore 8
    //   272: aload 8
    //   274: getfield 2140	com/tencent/mobileqq/app/AddBatchPhoneFriendResult:sendResult	I
    //   277: ifne -25 -> 252
    //   280: iconst_1
    //   281: istore 4
    //   283: aload_0
    //   284: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   287: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   290: astore 9
    //   292: iload 4
    //   294: istore_3
    //   295: aload 9
    //   297: invokeinterface 545 1 0
    //   302: ifeq +48 -> 350
    //   305: aload 9
    //   307: invokeinterface 549 1 0
    //   312: checkcast 1705	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd
    //   315: astore 10
    //   317: aload 10
    //   319: getfield 1706	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:unifiedCode	Ljava/lang/String;
    //   322: aload 8
    //   324: getfield 2143	com/tencent/mobileqq/app/AddBatchPhoneFriendResult:mobile	Ljava/lang/String;
    //   327: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   330: ifeq -38 -> 292
    //   333: aload 10
    //   335: invokestatic 1230	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   338: putfield 2095	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:timestamp	J
    //   341: aload_0
    //   342: aload 10
    //   344: invokevirtual 1256	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   347: pop
    //   348: iconst_0
    //   349: istore_3
    //   350: iload_3
    //   351: ifeq -99 -> 252
    //   354: new 1705	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd
    //   357: dup
    //   358: invokespecial 2096	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:<init>	()V
    //   361: astore 9
    //   363: aload 9
    //   365: aload 8
    //   367: getfield 2143	com/tencent/mobileqq/app/AddBatchPhoneFriendResult:mobile	Ljava/lang/String;
    //   370: putfield 1706	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:unifiedCode	Ljava/lang/String;
    //   373: aload 9
    //   375: invokestatic 1230	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   378: putfield 2095	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:timestamp	J
    //   381: aload 9
    //   383: aload_0
    //   384: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   387: invokevirtual 1060	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   390: invokevirtual 2101	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   393: invokevirtual 1471	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   396: ldc_w 2102
    //   399: invokevirtual 2103	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   402: putfield 2106	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:remindInfo	Ljava/lang/String;
    //   405: aload 7
    //   407: aload 9
    //   409: invokeinterface 975 2 0
    //   414: pop
    //   415: goto -163 -> 252
    //   418: aload 7
    //   420: invokeinterface 1261 1 0
    //   425: ifne +230 -> 655
    //   428: aload 7
    //   430: invokeinterface 1003 1 0
    //   435: astore 8
    //   437: aload 8
    //   439: invokeinterface 545 1 0
    //   444: ifeq +93 -> 537
    //   447: aload 8
    //   449: invokeinterface 549 1 0
    //   454: checkcast 1705	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd
    //   457: astore 9
    //   459: aload_1
    //   460: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   463: astore 10
    //   465: aload 10
    //   467: invokeinterface 545 1 0
    //   472: ifeq -35 -> 437
    //   475: aload 10
    //   477: invokeinterface 549 1 0
    //   482: checkcast 556	com/tencent/mobileqq/data/PhoneContact
    //   485: astore_2
    //   486: aload_2
    //   487: getfield 1223	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   490: aload 9
    //   492: getfield 1706	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:unifiedCode	Ljava/lang/String;
    //   495: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   498: ifeq -33 -> 465
    //   501: aload_2
    //   502: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   505: ifnonnull +11 -> 516
    //   508: aload_2
    //   509: getfield 578	com/tencent/mobileqq/data/PhoneContact:nickName	Ljava/lang/String;
    //   512: astore_2
    //   513: goto +8 -> 521
    //   516: aload_2
    //   517: getfield 1110	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   520: astore_2
    //   521: aload 9
    //   523: aload_2
    //   524: putfield 2097	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:name	Ljava/lang/String;
    //   527: aload_0
    //   528: aload 9
    //   530: invokevirtual 1256	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   533: pop
    //   534: goto -69 -> 465
    //   537: aload_0
    //   538: getfield 1703	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mPhoneContactAddList	Ljava/util/ArrayList;
    //   541: aload 7
    //   543: invokevirtual 1953	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   546: pop
    //   547: aload_0
    //   548: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   551: ifnull +104 -> 655
    //   554: aload_0
    //   555: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   558: invokevirtual 1546	java/util/ArrayList:isEmpty	()Z
    //   561: ifne +94 -> 655
    //   564: aload_0
    //   565: getfield 836	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:mContactMatch	Ljava/util/ArrayList;
    //   568: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   571: astore_1
    //   572: aload_1
    //   573: invokeinterface 545 1 0
    //   578: ifeq +77 -> 655
    //   581: aload_1
    //   582: invokeinterface 549 1 0
    //   587: checkcast 853	com/tencent/mobileqq/phonecontact/data/ContactMatch
    //   590: astore_2
    //   591: aload 7
    //   593: invokeinterface 1003 1 0
    //   598: astore 8
    //   600: aload 8
    //   602: invokeinterface 545 1 0
    //   607: ifeq -35 -> 572
    //   610: aload 8
    //   612: invokeinterface 549 1 0
    //   617: checkcast 1705	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd
    //   620: astore 9
    //   622: aload_2
    //   623: getfield 1224	com/tencent/mobileqq/phonecontact/data/ContactMatch:unifiedCode	Ljava/lang/String;
    //   626: aload 9
    //   628: getfield 1706	com/tencent/mobileqq/phonecontact/data/PhoneContactAdd:unifiedCode	Ljava/lang/String;
    //   631: invokevirtual 908	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifeq -34 -> 600
    //   637: aload_1
    //   638: invokeinterface 1218 1 0
    //   643: aload_0
    //   644: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   647: aload_2
    //   648: invokevirtual 1220	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   651: pop
    //   652: goto -80 -> 572
    //   655: aload 6
    //   657: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   660: aload 6
    //   662: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   665: goto +27 -> 692
    //   668: astore_1
    //   669: goto +27 -> 696
    //   672: astore_1
    //   673: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   676: ifeq -16 -> 660
    //   679: ldc 74
    //   681: iconst_2
    //   682: ldc_w 2144
    //   685: aload_1
    //   686: invokestatic 1159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   689: goto -29 -> 660
    //   692: aload 5
    //   694: monitorexit
    //   695: return
    //   696: aload 6
    //   698: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   701: aload_1
    //   702: athrow
    //   703: astore_1
    //   704: aload 5
    //   706: monitorexit
    //   707: aload_1
    //   708: athrow
    //   709: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	this	PhoneContactServiceImpl
    //   0	710	1	paramArrayList	ArrayList<PhoneContact>
    //   0	710	2	paramArrayList1	ArrayList<com.tencent.mobileqq.app.AddBatchPhoneFriendResult>
    //   0	710	3	paramInt	int
    //   281	12	4	i	int
    //   38	667	5	localObject1	Object
    //   13	684	6	localObject2	Object
    //   220	372	7	localArrayList	ArrayList
    //   270	341	8	localObject3	Object
    //   290	337	9	localObject4	Object
    //   315	161	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   208	247	668	finally
    //   247	252	668	finally
    //   252	280	668	finally
    //   283	292	668	finally
    //   295	348	668	finally
    //   354	415	668	finally
    //   418	437	668	finally
    //   437	465	668	finally
    //   465	513	668	finally
    //   516	521	668	finally
    //   521	534	668	finally
    //   537	572	668	finally
    //   572	600	668	finally
    //   600	652	668	finally
    //   655	660	668	finally
    //   673	689	668	finally
    //   208	247	672	android/content/res/Resources$NotFoundException
    //   247	252	672	android/content/res/Resources$NotFoundException
    //   252	280	672	android/content/res/Resources$NotFoundException
    //   283	292	672	android/content/res/Resources$NotFoundException
    //   295	348	672	android/content/res/Resources$NotFoundException
    //   354	415	672	android/content/res/Resources$NotFoundException
    //   418	437	672	android/content/res/Resources$NotFoundException
    //   437	465	672	android/content/res/Resources$NotFoundException
    //   465	513	672	android/content/res/Resources$NotFoundException
    //   516	521	672	android/content/res/Resources$NotFoundException
    //   521	534	672	android/content/res/Resources$NotFoundException
    //   537	572	672	android/content/res/Resources$NotFoundException
    //   572	600	672	android/content/res/Resources$NotFoundException
    //   600	652	672	android/content/res/Resources$NotFoundException
    //   655	660	672	android/content/res/Resources$NotFoundException
    //   199	208	703	finally
    //   660	665	703	finally
    //   692	695	703	finally
    //   696	703	703	finally
    //   704	707	703	finally
  }
  
  public boolean needUploadContact()
  {
    int i = getSelfBindState();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 6)
    {
      bool1 = bool2;
      if (i != 7)
      {
        bool1 = bool2;
        if (i != 5)
        {
          bool1 = bool2;
          if (i != 1) {
            if (i == 3) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needUploadContact [");
      localStringBuilder.append(i);
      localStringBuilder.append(", ");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public void notifyContactChanged()
  {
    notifyContactChanged(1);
  }
  
  public void onAppRunBackground()
  {
    this.runningForegroud = false;
  }
  
  public void onAppRunForeground()
  {
    this.runningForegroud = true;
    checkUpdateLocalContact(false, 23);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
    this.mInjectProcessor = PhoneContactInjectFactory.a(this.app);
    this.mSharePref = this.app.getApp().getSharedPreferences("sp_new_friend", 0);
    paramAppRuntime = this.app.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contact_bind_info");
    localStringBuilder.append(this.app.getAccount());
    this.pref = paramAppRuntime.getSharedPreferences(localStringBuilder.toString(), 0);
    this.globalPref = this.app.getApp().getSharedPreferences("contact_bind_info_global", 0);
    this.sessionId = this.pref.getString("session_id", "").getBytes();
    this.contactListQueryTimeStamp = this.pref.getLong("contact_last_query_list_time", 0L);
    this.mLastUnbindMobileTime = this.pref.getLong("last_unbind_mobile_time", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("init [%s, %s]", new Object[] { Long.valueOf(this.contactListQueryTimeStamp), Long.valueOf(this.mLastUnbindMobileTime) }));
    }
    initQueryInterval();
    paramAppRuntime = this.globalPref;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("user_setting_flag_");
    localStringBuilder.append(this.app.getAccount());
    this.mUserSettingFlag = paramAppRuntime.getLong(localStringBuilder.toString(), 0L);
    this.mCurrentBindState = getSelfBindState(getSelfBindInfo());
    this.em = this.app.getEntityManagerFactory().createEntityManager();
    this.app.registObserver(this.contactOb);
    this.app.addObserver(this.mContactBindObserver2);
    this.mRandom = new Random(SystemClock.elapsedRealtime());
    paramAppRuntime = this.app.getApplication().getResources().getDisplayMetrics();
    int i;
    if (Math.min(paramAppRuntime.widthPixels, paramAppRuntime.heightPixels) >= 1080) {
      i = 5;
    } else {
      i = 4;
    }
    this.mStarRecommendCount = i;
    ThreadManager.excute(new PhoneContactServiceImpl.1(this), 16, null, false);
  }
  
  public void onDestroy()
  {
    this.destroyed = true;
    this.orderedNobindList = null;
    this.orderedBindList = null;
    this.mListForSelector = null;
    this.mListForContactListView = null;
    this.app.unRegistObserver(this.contactOb);
    this.app.removeObserver(this.mContactBindObserver2);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    unRegistContentObservers();
    this.mCurrentBindState = -1;
    this.isCacheInited = false;
    PermissionChecker.a().c();
    IPhoneContactProcessor localIPhoneContactProcessor = this.mInjectProcessor;
    if (localIPhoneContactProcessor != null)
    {
      localIPhoneContactProcessor.a();
      this.mInjectProcessor = null;
    }
  }
  
  public void onFriendListChanged()
  {
    checkUpdateBindStateAndListIgnoreBindState(true, true, 14);
  }
  
  public void onGetFriendsHasBindPhone(int paramInt, List<String> paramList)
  {
    this.mFrdHasBindPhoneTotalCount = paramInt;
    this.mSomeFrdHasBindPhone = paramList;
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (localObject != null)
        {
          if (localStringBuilder1.length() > 0) {
            localStringBuilder1.append("|");
          }
          localStringBuilder1.append((String)localObject);
        }
      }
    }
    paramList = this.app.getAccount();
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("frd_has_bind_phone_count_");
      localStringBuilder2.append(paramList);
      localObject = ((SharedPreferences.Editor)localObject).putInt(localStringBuilder2.toString(), this.mFrdHasBindPhoneTotalCount);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("frd_has_bind_phone_some_");
      localStringBuilder2.append(paramList);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder2.toString(), localStringBuilder1.toString()).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("onGetFriendsHasBindPhone [%s, %s]", new Object[] { Integer.valueOf(this.mFrdHasBindPhoneTotalCount), localStringBuilder1.toString() }));
    }
  }
  
  public void onStepAction(boolean paramBoolean)
  {
    QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, new Object[] { "onStepAction fromLogin=", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      initContactCache();
      String str = this.app.getCurrentAccountUin();
      QConfigManager.a(new int[] { 34 }, str);
    }
    boolean bool = checkAndUploadContact(false);
    if ((paramBoolean) && (!bool)) {
      checkUpdateLocalContact(true, 2);
    }
  }
  
  public PhoneContact queryContactByCodeNumber(String paramString)
  {
    PhoneContact localPhoneContact = null;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "queryContactByCodeNumber codeNumber is null");
      }
      return null;
    }
    if (this.isCacheInited) {
      return (PhoneContact)this.contactCacheByCodeNumber.get(paramString);
    }
    EntityManager localEntityManager = this.em;
    if (localEntityManager != null) {
      localPhoneContact = (PhoneContact)localEntityManager.find(PhoneContact.class, "mobileCode=?", new String[] { paramString });
    }
    return localPhoneContact;
  }
  
  public PhoneContact queryPhoneContactByMobile(String paramString)
  {
    if (this.isCacheInited) {
      return (PhoneContact)this.contactCache.get(paramString);
    }
    EntityManager localEntityManager = this.em;
    if (localEntityManager != null) {
      return (PhoneContact)localEntityManager.find(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public PhoneContact queryPhoneContactByUin(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (PhoneContact)this.contactCacheByUin.get(paramString);
    }
    return null;
  }
  
  public void removeDuplicate(List<PhoneContact> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        String str = localPhoneContact.mobileCode;
        if (!TextUtils.isEmpty(localPhoneContact.uin))
        {
          localArrayList.add(str);
        }
        else
        {
          localObject2 = (ArrayList)localHashMap.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            localHashMap.put(str, localObject1);
          }
          ((ArrayList)localObject1).add(localPhoneContact);
        }
      }
      Object localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArrayList)localHashMap.get((String)((Iterator)localObject1).next());
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramList.remove((PhoneContact)((Iterator)localObject2).next());
          }
        }
      }
    }
  }
  
  public void removeListener(IPhoneContactListener paramIPhoneContactListener)
  {
    synchronized (this.mListenerList)
    {
      this.mListenerList.remove(paramIPhoneContactListener);
      return;
    }
  }
  
  public void saveBindConfig(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveBindConfig style:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" wording:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" blockMsg:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.pref.edit();
    ((SharedPreferences.Editor)localObject).putInt("key_bind_style", paramInt);
    ((SharedPreferences.Editor)localObject).putString("key_bind_wording", paramString1);
    ((SharedPreferences.Editor)localObject).putString("key_block_msg", paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public boolean saveBindInfo(RespondQueryQQBindingStat paramRespondQueryQQBindingStat, String paramString)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("saveBindInfo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(this.destroyed), paramRespondQueryQQBindingStat, Integer.valueOf(this.mCurrentBindState), paramString }));
    }
    if (this.destroyed) {
      return false;
    }
    if (this.mCurrentBindState == -1) {
      this.mCurrentBindState = getSelfBindState(getSelfBindInfo());
    }
    int i = getSelfBindState(paramRespondQueryQQBindingStat);
    if (this.mCurrentBindState == i) {
      bool1 = false;
    }
    paramString = paramRespondQueryQQBindingStat;
    if (paramRespondQueryQQBindingStat == null) {
      paramString = new RespondQueryQQBindingStat();
    }
    paramRespondQueryQQBindingStat = this.pref.edit();
    paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", paramString.mobileNo);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", paramString.nationCode);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", paramString.MobileUniqueNo);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", paramString.isRecommend);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", paramString.originBinder);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", paramString.bindingTime);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", paramString.lastUsedFlag);
    paramRespondQueryQQBindingStat.putInt("contact_bind_type", paramString.type);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_stop_find_match", paramString.isStopFindMatch);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload", paramString.noBindUploadContacts);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload_local", paramString.noBindUploadContactsLocal);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_is_phone_switched", paramString.isPhoneSwitched);
    this.isPhoneSwitched = paramString.isPhoneSwitched;
    paramRespondQueryQQBindingStat.commit();
    syncBindState(paramString);
    return bool1;
  }
  
  public int saveContactFromServer(boolean paramBoolean1, int paramInt, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, List<MobileContactsFriendInfo> paramList, List<MobileContactsNotFriendInfo> paramList1)
  {
    if (this.destroyed) {
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServer_v2, isSegmented = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", packageNo = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ");
      ((StringBuilder)localObject1).append(paramLong1);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.respBindFriendList_V2;
    if (localObject1 == null) {
      this.respBindFriendList_V2 = paramList;
    } else {
      ((List)localObject1).addAll(paramList);
    }
    paramList = this.respBindStrangerList_V2;
    if (paramList == null) {
      this.respBindStrangerList_V2 = paramList1;
    } else {
      paramList.addAll(paramList1);
    }
    if ((paramLong1 != 4294967295L) && (!paramBoolean1)) {
      return 0;
    }
    long l1 = this.pref.getLong("queryContactTimeStamp", 0L);
    long l2 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
    int i;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder(200);
      paramList.append("saveContactFromServer, localTimeStamp:");
      paramList.append(l1);
      paramList.append(", ");
      paramList.append(l2);
      paramList.append(", remoteTimeStamp: ");
      paramList.append(paramLong2);
      paramList.append(", ");
      paramList.append(paramLong3);
      paramList.append(", friendCount:");
      paramList1 = this.respBindFriendList_V2;
      int j = -1;
      if (paramList1 != null) {
        i = paramList1.size();
      } else {
        i = -1;
      }
      paramList.append(i);
      paramList.append(", strangerCount:");
      paramList1 = this.respBindStrangerList_V2;
      i = j;
      if (paramList1 != null) {
        i = paramList1.size();
      }
      paramList.append(i);
      paramList.append(", isListChanged:");
      paramList.append(paramBoolean2);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, paramList.toString());
    }
    if (!this.isCacheInited) {
      initContactCache();
    }
    if (((paramInt == 0) && (paramBoolean1)) || (!paramBoolean1)) {
      beforeSaveContactFromServer(paramBoolean2);
    }
    paramList = this.respBindFriendList_V2;
    Object localObject2;
    Object localObject3;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = this.em.getTransaction();
      paramList = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
      localObject3 = (IAddFriendServiceApi)this.app.getRuntimeService(IAddFriendServiceApi.class, "");
      try
      {
        ((EntityTransaction)localObject2).begin();
        paramList1 = this.respBindFriendList_V2.iterator();
        paramBoolean1 = false;
        if (paramList1.hasNext())
        {
          Object localObject4 = (MobileContactsFriendInfo)paramList1.next();
          localObject1 = (PhoneContact)this.md52PhoneContact.get(((MobileContactsFriendInfo)localObject4).contactsInfoEncrypt.toUpperCase());
          if (localObject1 != null)
          {
            resetContact((PhoneContact)localObject1, paramBoolean2);
            ((PhoneContact)localObject1).uin = ((MobileContactsFriendInfo)localObject4).QQ;
            ((PhoneContact)localObject1).bindingDate = ((MobileContactsFriendInfo)localObject4).bindingDate;
            ((PhoneContact)localObject1).isUploaded = true;
            ((PhoneContact)localObject1).originBinder = ((MobileContactsFriendInfo)localObject4).originBinder;
            ((PhoneContact)localObject1).ability = ((MobileContactsFriendInfo)localObject4).accountAbi;
            ((PhoneContact)localObject1).unifiedCode = PhoneContactUtils.a(((MobileContactsFriendInfo)localObject4).MobileNoMask, ((PhoneContact)localObject1).mobileNo);
            ((PhoneContact)localObject1).mobileCode = ((PhoneContact)localObject1).unifiedCode;
            ((PhoneContact)localObject1).nationCode = "";
            if ((TextUtils.isEmpty(((PhoneContact)localObject1).uin)) || (((PhoneContact)localObject1).uin.equals("0"))) {
              break label1634;
            }
            localObject4 = paramList.getFriend(((PhoneContact)localObject1).uin, true, true);
            if (localObject4 != null) {
              ((PhoneContact)localObject1).nickName = ((Friends)localObject4).name;
            }
            this.contactCacheByUin.put(((PhoneContact)localObject1).uin, localObject1);
            ((IAddFriendServiceApi)localObject3).setAddFriendReqStatus(((PhoneContact)localObject1).unifiedCode, false);
            label727:
            if (!TextUtils.isEmpty(((PhoneContact)localObject1).unifiedCode)) {
              this.contactCacheByCodeNumber.put(((PhoneContact)localObject1).unifiedCode, localObject1);
            }
            this.tmpContactCache.remove(((PhoneContact)localObject1).mobileNo);
            this.em.update((Entity)localObject1);
            paramBoolean1 = true;
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label1637;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("bind friend not found, ");
            localStringBuilder.append(((MobileContactsFriendInfo)localObject4).contactsInfoEncrypt);
            QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
          }
          label830:
          if (!QLog.isColorLevel()) {
            break label1640;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("MobileContactsFriendInfo;");
          if (localObject1 == null) {
            localObject1 = "null";
          } else {
            localObject1 = ((PhoneContact)localObject1).unifiedCode;
          }
          ((StringBuilder)localObject4).append((String)localObject1);
          QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject4).toString());
          break label1640;
        }
        ((EntityTransaction)localObject2).commit();
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    else
    {
      paramBoolean1 = false;
    }
    paramList = this.respBindStrangerList_V2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject1 = new ArrayList(this.respBindStrangerList_V2.size());
      paramList1 = this.em.getTransaction();
    }
    label1634:
    label1637:
    label1640:
    label1643:
    label1646:
    label1652:
    for (;;)
    {
      try
      {
        paramList1.begin();
        paramList = this.respBindStrangerList_V2.iterator();
        bool1 = paramBoolean1;
        paramBoolean1 = false;
        if (paramList.hasNext())
        {
          localObject2 = (MobileContactsNotFriendInfo)paramList.next();
          localObject3 = (PhoneContact)this.md52PhoneContact.get(((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt.toUpperCase());
          if (localObject3 != null)
          {
            resetContact((PhoneContact)localObject3, paramBoolean2);
            if (!paramBoolean2) {
              break label1643;
            }
            ((PhoneContact)localObject3).uin = "0";
            ((PhoneContact)localObject3).bindingDate = ((MobileContactsNotFriendInfo)localObject2).bindingDate;
            ((PhoneContact)localObject3).nickName = ((MobileContactsNotFriendInfo)localObject2).nickname;
            ((PhoneContact)localObject3).isUploaded = true;
            ((PhoneContact)localObject3).originBinder = ((MobileContactsNotFriendInfo)localObject2).originBinder;
            ((PhoneContact)localObject3).ability = ((MobileContactsNotFriendInfo)localObject2).accountAbi;
            ((PhoneContact)localObject3).unifiedCode = PhoneContactUtils.a(((MobileContactsNotFriendInfo)localObject2).MobileNoMask, ((PhoneContact)localObject3).mobileNo);
            ((PhoneContact)localObject3).mobileCode = ((PhoneContact)localObject3).unifiedCode;
            ((PhoneContact)localObject3).nationCode = "";
            ((PhoneContact)localObject3).age = ((MobileContactsNotFriendInfo)localObject2).age;
            ((PhoneContact)localObject3).sex = ((MobileContactsNotFriendInfo)localObject2).sex;
            ((PhoneContact)localObject3).samFriend = ((MobileContactsNotFriendInfo)localObject2).sameFriend;
            if (!((MobileContactsNotFriendInfo)localObject2).isNew) {
              break label1643;
            }
            ((PhoneContact)localObject3).isNewRecommend = true;
            this.recommendMobiles.add(localObject3);
            paramBoolean1 = true;
            if (((MobileContactsNotFriendInfo)localObject2).isUpdateSign) {
              ((PhoneContact)localObject3).setRichBuffer(((MobileContactsNotFriendInfo)localObject2).personalSign, ((MobileContactsNotFriendInfo)localObject2).richTime);
            }
            if (((PhoneContact)localObject3).detalStatusFlag != 20) {
              ((List)localObject1).add(((PhoneContact)localObject3).unifiedCode);
            }
            ((PhoneContact)localObject3).netTypeIconId = ((MobileContactsNotFriendInfo)localObject2).conType;
            ((PhoneContact)localObject3).detalStatusFlag = ((MobileContactsNotFriendInfo)localObject2).detalStatusFlag;
            ((PhoneContact)localObject3).iTermType = ((MobileContactsNotFriendInfo)localObject2).iTermType;
            ((PhoneContact)localObject3).strTermDesc = ((MobileContactsNotFriendInfo)localObject2).strTermDesc;
            ((PhoneContact)localObject3).eNetworkType = ((MobileContactsNotFriendInfo)localObject2).eNetworkType;
            ((PhoneContact)localObject3).abilityBits = ((MobileContactsNotFriendInfo)localObject2).uAbiFlag;
            if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
              this.contactCacheByCodeNumber.put(((PhoneContact)localObject3).unifiedCode, localObject3);
            }
            ((PhoneContact)localObject3).isHiden = ((MobileContactsNotFriendInfo)localObject2).isHide;
            this.tmpContactCache.remove(((PhoneContact)localObject3).mobileNo);
            this.em.update((Entity)localObject3);
            if (!QLog.isColorLevel()) {
              break label1646;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("MobileContactsNotFriendInfo; mobile=");
            ((StringBuilder)localObject2).append(((PhoneContact)localObject3).unifiedCode);
            ((StringBuilder)localObject2).append(" hide=");
            ((StringBuilder)localObject2).append(((PhoneContact)localObject3).isHiden);
            QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject2).toString());
            break label1646;
          }
          if (!QLog.isColorLevel()) {
            break label1652;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("bind nofriend not found, ");
          ((StringBuilder)localObject3).append(((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt);
          QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject3).toString());
          break label1652;
        }
        addContactsToLastLoginList((List)localObject1);
        paramList1.commit();
      }
      finally
      {
        paramList1.end();
      }
      boolean bool2 = false;
      boolean bool1 = paramBoolean1;
      paramBoolean1 = bool2;
      this.bindNonFriendList = null;
      this.bindAllFriendList = null;
      this.respBindFriendList_V2 = null;
      this.respBindStrangerList_V2 = null;
      paramInt = 6;
      if (paramBoolean2) {
        paramInt = 7;
      }
      i = paramInt;
      if (paramBoolean1) {
        i = paramInt | 0x8;
      }
      if (paramLong1 == 4294967295L)
      {
        afterSaveContactFromServer(paramBoolean2);
        onNewRecommendContact(bool1, this.recommendMobiles);
        this.recommendMobiles.clear();
        removeIllegalRecommend();
        saveContactListTimeStamp(paramLong2, paramLong3);
      }
      pushRecommendUnreadCount(paramBoolean1);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "saveContactFromServer_v2 leave");
      }
      return i;
      break label727;
      break label830;
      break;
      continue;
      bool1 = true;
    }
  }
  
  public int saveContactFromServerNotBind(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, ArrayList<NotBindContactFriendInfo> paramArrayList, ArrayList<NotBindContactNotFriendInfo> paramArrayList1)
  {
    if (this.destroyed) {
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServerNotBind, isSegmented = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", packageNo = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ");
      ((StringBuilder)localObject1).append(paramLong1);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.respBindFriendListNotBind;
    if (localObject1 == null) {
      this.respBindFriendListNotBind = paramArrayList;
    } else {
      ((List)localObject1).addAll(paramArrayList);
    }
    paramArrayList = this.respBindStrangerListNotBind;
    if (paramArrayList == null) {
      this.respBindStrangerListNotBind = paramArrayList1;
    } else {
      paramArrayList.addAll(paramArrayList1);
    }
    if ((paramLong1 != 4294967295L) && (!paramBoolean)) {
      return 0;
    }
    long l1 = this.pref.getLong("queryContactTimeStamp", 0L);
    long l2 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder(200);
      paramArrayList.append("saveContactFromServer, localTimeStamp:");
      paramArrayList.append(l1);
      paramArrayList.append(", ");
      paramArrayList.append(l2);
      paramArrayList.append(", remoteTimeStamp: ");
      paramArrayList.append(paramLong2);
      paramArrayList.append(", friendCount:");
      paramArrayList1 = this.respBindFriendListNotBind;
      int j = -1;
      if (paramArrayList1 != null) {
        i = paramArrayList1.size();
      } else {
        i = -1;
      }
      paramArrayList.append(i);
      paramArrayList.append(", strangerCount:");
      paramArrayList1 = this.respBindStrangerListNotBind;
      int i = j;
      if (paramArrayList1 != null) {
        i = paramArrayList1.size();
      }
      paramArrayList.append(i);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, paramArrayList.toString());
    }
    if (!this.isCacheInited) {
      initContactCache();
    }
    if (((paramInt == 0) && (paramBoolean)) || (!paramBoolean)) {
      beforeSaveContactFromServer(true);
    }
    paramArrayList = this.respBindFriendListNotBind;
    Object localObject2;
    Object localObject3;
    label664:
    boolean bool;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject1 = this.em.getTransaction();
      localObject2 = (IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "");
      localObject3 = (IAddFriendServiceApi)this.app.getRuntimeService(IAddFriendServiceApi.class, "");
      try
      {
        ((EntityTransaction)localObject1).begin();
        paramArrayList = this.respBindFriendListNotBind.iterator();
        paramBoolean = false;
        if (paramArrayList.hasNext())
        {
          Object localObject4 = (NotBindContactFriendInfo)paramArrayList.next();
          paramArrayList1 = (PhoneContact)this.md52PhoneContact.get(((NotBindContactFriendInfo)localObject4).contactsInfoEncrypt.toUpperCase());
          if (paramArrayList1 != null)
          {
            resetContact(paramArrayList1, true);
            paramArrayList1.uin = String.valueOf(((NotBindContactFriendInfo)localObject4).bindUin);
            paramArrayList1.isUploaded = true;
            paramArrayList1.unifiedCode = PhoneContactUtils.a(((NotBindContactFriendInfo)localObject4).MobileNoMask, paramArrayList1.mobileNo);
            paramArrayList1.mobileCode = paramArrayList1.unifiedCode;
            paramArrayList1.nationCode = "";
            if ((TextUtils.isEmpty(paramArrayList1.uin)) || (paramArrayList1.uin.equals("0"))) {
              break label1429;
            }
            localObject4 = ((IFriendDataService)localObject2).getFriend(paramArrayList1.uin, true, true);
            if (localObject4 != null) {
              paramArrayList1.nickName = ((Friends)localObject4).name;
            }
            this.contactCacheByUin.put(paramArrayList1.uin, paramArrayList1);
            ((IAddFriendServiceApi)localObject3).setAddFriendReqStatus(paramArrayList1.unifiedCode, false);
            if (!TextUtils.isEmpty(paramArrayList1.unifiedCode)) {
              this.contactCacheByCodeNumber.put(paramArrayList1.unifiedCode, paramArrayList1);
            }
            this.tmpContactCache.remove(paramArrayList1.mobileNo);
            this.em.update(paramArrayList1);
            bool = true;
          }
          else
          {
            bool = paramBoolean;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("bind friend not found, ");
              localStringBuilder.append(((NotBindContactFriendInfo)localObject4).contactsInfoEncrypt);
              QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
              bool = paramBoolean;
            }
          }
          if (!QLog.isColorLevel()) {
            break label1432;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("MobileContactsFriendInfo;");
          if (paramArrayList1 == null) {
            paramArrayList1 = "null";
          } else {
            paramArrayList1 = paramArrayList1.toString();
          }
          ((StringBuilder)localObject4).append(paramArrayList1);
          QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject4).toString());
          break label1432;
        }
        ((EntityTransaction)localObject1).commit();
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
    }
    else
    {
      paramBoolean = false;
    }
    paramArrayList = this.respBindStrangerListNotBind;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList1 = new ArrayList(this.respBindStrangerListNotBind.size());
      paramArrayList = this.em.getTransaction();
    }
    for (;;)
    {
      try
      {
        paramArrayList.begin();
        localObject1 = this.respBindStrangerListNotBind.iterator();
        bool = false;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (NotBindContactNotFriendInfo)((Iterator)localObject1).next();
          localObject3 = (PhoneContact)this.md52PhoneContact.get(((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt.toUpperCase());
          if (localObject3 != null)
          {
            resetContact((PhoneContact)localObject3, true);
            ((PhoneContact)localObject3).uin = "0";
            ((PhoneContact)localObject3).nickName = ((NotBindContactNotFriendInfo)localObject2).nickname;
            ((PhoneContact)localObject3).isUploaded = true;
            ((PhoneContact)localObject3).unifiedCode = PhoneContactUtils.a(((NotBindContactNotFriendInfo)localObject2).MobileNoMask, ((PhoneContact)localObject3).mobileNo);
            ((PhoneContact)localObject3).mobileCode = ((PhoneContact)localObject3).unifiedCode;
            ((PhoneContact)localObject3).nationCode = "";
            ((PhoneContact)localObject3).age = ((NotBindContactNotFriendInfo)localObject2).age;
            ((PhoneContact)localObject3).sex = ((NotBindContactNotFriendInfo)localObject2).sex;
            ((PhoneContact)localObject3).samFriend = ((NotBindContactNotFriendInfo)localObject2).sameFriend;
            if (((NotBindContactNotFriendInfo)localObject2).isNew)
            {
              ((PhoneContact)localObject3).isNewRecommend = true;
              this.recommendMobiles.add(localObject3);
              bool = true;
            }
            if (((PhoneContact)localObject3).detalStatusFlag != 20) {
              paramArrayList1.add(((PhoneContact)localObject3).unifiedCode);
            }
            ((PhoneContact)localObject3).abilityBits = ((NotBindContactNotFriendInfo)localObject2).uAbiFlag;
            if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
              this.contactCacheByCodeNumber.put(((PhoneContact)localObject3).unifiedCode, localObject3);
            }
            this.tmpContactCache.remove(((PhoneContact)localObject3).mobileNo);
            this.em.update((Entity)localObject3);
            if (!QLog.isColorLevel()) {
              break label1438;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("MobileContactsNotFriendInfo; mobile=");
            ((StringBuilder)localObject2).append(((PhoneContact)localObject3).unifiedCode);
            ((StringBuilder)localObject2).append(" hide=");
            ((StringBuilder)localObject2).append(((PhoneContact)localObject3).isHiden);
            QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject2).toString());
            break label1438;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("bind nofriend not found, ");
          ((StringBuilder)localObject3).append(((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt);
          QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject3).toString());
          continue;
        }
        addContactsToLastLoginList(paramArrayList1);
        paramArrayList.commit();
      }
      finally
      {
        paramArrayList.end();
      }
      bool = false;
      this.bindNonFriendList = null;
      this.bindAllFriendList = null;
      this.respBindFriendListNotBind = null;
      this.respBindStrangerListNotBind = null;
      paramInt = 7;
      if (bool) {
        paramInt = 15;
      }
      if (paramLong1 == 4294967295L)
      {
        afterSaveContactFromServer(true);
        onNewRecommendContact(paramBoolean, this.recommendMobiles);
        this.recommendMobiles.clear();
        removeIllegalRecommend();
        saveContactListTimeStampNotBind(paramLong2);
      }
      pushRecommendUnreadCount(bool);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "saveContactFromServerNotBind leave");
      }
      return paramInt;
      label1429:
      break label664;
      label1432:
      paramBoolean = bool;
      break;
      label1438:
      paramBoolean = true;
    }
  }
  
  public void saveLastLoginList(List<String> paramList, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveLastLoginList, size = ");
      ((StringBuilder)localObject1).append(paramList.size());
      ((StringBuilder)localObject1).append(", stamp ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(", interval = ");
      ((StringBuilder)localObject1).append(paramLong2);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    this.pref.edit().putLong("key_req_last_login_time", System.currentTimeMillis()).putLong("key_login_info_timestamp", paramLong1).putLong("key_req_login_interval", Math.max(43200000L, paramLong2 * 1000L)).commit();
    Object localObject1 = new HashSet(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Object localObject2 = (PhoneContact)this.md52PhoneContact.get(str.toUpperCase());
      if (localObject2 != null)
      {
        ((Set)localObject1).add(((PhoneContact)localObject2).unifiedCode);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveLastLoginList, wtf pc null ");
        ((StringBuilder)localObject2).append(str.toUpperCase());
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject2).toString());
      }
    }
    this.mLastLoginSet = ((Set)localObject1);
    saveLastLoginListToDb(this.mLastLoginSet);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("saveLastLoginInfo: tempSet.size=");
      paramList.append(((Set)localObject1).size());
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, paramList.toString());
    }
  }
  
  /* Error */
  public void saveLastLoginListToDb(Set<String> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 240	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:destroyed	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +35 -> 46
    //   14: new 496	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 497	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: ldc_w 2439
    //   26: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 1774	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 74
    //   38: iconst_2
    //   39: aload_2
    //   40: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 702	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 409	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   50: invokevirtual 990	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   53: invokevirtual 996	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnonnull +13 -> 71
    //   61: ldc 74
    //   63: iconst_1
    //   64: ldc_w 2441
    //   67: invokestatic 2077	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: return
    //   71: aload_3
    //   72: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual 606	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   80: aload_3
    //   81: ldc_w 2443
    //   84: aconst_null
    //   85: aconst_null
    //   86: invokevirtual 2444	com/tencent/mobileqq/persistence/EntityManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   89: pop
    //   90: aload_1
    //   91: invokeinterface 540 1 0
    //   96: astore_1
    //   97: aload_1
    //   98: invokeinterface 545 1 0
    //   103: ifeq +47 -> 150
    //   106: aload_1
    //   107: invokeinterface 549 1 0
    //   112: checkcast 185	java/lang/String
    //   115: astore 4
    //   117: aload 4
    //   119: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne -25 -> 97
    //   125: new 998	com/tencent/mobileqq/phonecontact/data/LastLoginPhoneInfo
    //   128: dup
    //   129: invokespecial 2445	com/tencent/mobileqq/phonecontact/data/LastLoginPhoneInfo:<init>	()V
    //   132: astore 5
    //   134: aload 5
    //   136: aload 4
    //   138: putfield 1006	com/tencent/mobileqq/phonecontact/data/LastLoginPhoneInfo:unifiedCode	Ljava/lang/String;
    //   141: aload_3
    //   142: aload 5
    //   144: invokevirtual 1151	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   147: goto -50 -> 97
    //   150: aload_2
    //   151: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   154: goto +18 -> 172
    //   157: astore_1
    //   158: goto +19 -> 177
    //   161: astore_1
    //   162: ldc 74
    //   164: iconst_1
    //   165: ldc_w 2447
    //   168: aload_1
    //   169: invokestatic 528	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_2
    //   173: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   176: return
    //   177: aload_2
    //   178: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   181: goto +5 -> 186
    //   184: aload_1
    //   185: athrow
    //   186: goto -2 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	PhoneContactServiceImpl
    //   0	189	1	paramSet	Set<String>
    //   21	157	2	localObject	Object
    //   56	86	3	localEntityManager	EntityManager
    //   115	22	4	str	String
    //   132	11	5	localLastLoginPhoneInfo	LastLoginPhoneInfo
    // Exception table:
    //   from	to	target	type
    //   76	97	157	finally
    //   97	147	157	finally
    //   150	154	157	finally
    //   162	172	157	finally
    //   76	97	161	java/lang/Exception
    //   97	147	161	java/lang/Exception
    //   150	154	161	java/lang/Exception
  }
  
  public void saveQueryInterval(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == sQueryContactListInterval) && (paramLong2 == sQueryContactListIntervalLogin))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("saveQueryInterval not change [limit:%s, limitLogin:%s]", new Object[] { Long.valueOf(sQueryContactListInterval), Long.valueOf(sQueryContactListIntervalLogin) }));
      }
      return;
    }
    try
    {
      sQueryContactListInterval = Math.max(1800000L, paramLong1);
      sQueryContactListIntervalLogin = Math.max(86400000L, paramLong2);
      this.globalPref.edit().putLong("query_contact_list_min_interval", sQueryContactListInterval).apply();
      this.globalPref.edit().putLong("query_contact_list_min_interval_for_login", sQueryContactListIntervalLogin).apply();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localThrowable.getMessage());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("saveQueryInterval  [limit:%s, limitLogin:%s]", new Object[] { Long.valueOf(sQueryContactListInterval), Long.valueOf(sQueryContactListIntervalLogin) }));
    }
  }
  
  public void saveUIBits(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveUIBits: newBits = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" localUIBits = ");
      localStringBuilder.append(this.mUIBits);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    if (this.mUIBits != paramLong)
    {
      this.mUIBits = paramLong;
      this.pref.edit().putLong("key_contacts_switches", paramLong);
      notifyUISwitchChanged(paramLong);
    }
  }
  
  public void sendBindMobile(String paramString1, String paramString2)
  {
    sendBindMobile(paramString1, paramString2, 0, false, false);
  }
  
  public void sendBindMobile(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 35);
      localNewIntent.putExtra("country_code", paramString1);
      localNewIntent.putExtra("phone_number", paramString2);
      localNewIntent.putExtra("cmd_param_bind_type", paramInt);
      localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
      localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void sendBindMobileEncrypt(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString != null)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 35);
      localNewIntent.putExtra("country_code", paramString);
      localNewIntent.putExtra("cmd_param_is_encrypt", true);
      localNewIntent.putExtra("cmd_param_encrypt_mobile", paramArrayOfByte);
      localNewIntent.putExtra("cmd_param_bind_type", paramInt);
      localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
      localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void sendRebindMobile(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 19);
      localNewIntent.putExtra("country_code", paramString1);
      localNewIntent.putExtra("phone_number", paramString2);
      localNewIntent.putExtra("cmd_param_bind_type", 0);
      this.app.startServlet(localNewIntent);
      sendRebindMobile(paramString1, paramString2, 0, false, false);
    }
  }
  
  public void sendRebindMobile(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 19);
      localNewIntent.putExtra("country_code", paramString1);
      localNewIntent.putExtra("phone_number", paramString2);
      localNewIntent.putExtra("cmd_param_bind_type", paramInt);
      localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
      localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void sendRebindMobileEncrypt(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString != null)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 19);
      localNewIntent.putExtra("country_code", paramString);
      localNewIntent.putExtra("cmd_param_is_encrypt", true);
      localNewIntent.putExtra("cmd_param_encrypt_mobile", paramArrayOfByte);
      localNewIntent.putExtra("cmd_param_bind_type", paramInt);
      localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
      localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void sendVerifySmsCode(String paramString)
  {
    sendVerifySmsCode(paramString, 0, false, false);
  }
  
  public void sendVerifySmsCode(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 16);
    localNewIntent.putExtra("verify_smscode", paramString);
    localNewIntent.putExtra("session_id", this.sessionId);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.app.startServlet(localNewIntent);
  }
  
  public void setContactBoundDataCache(ContactBindedData paramContactBindedData)
  {
    this.contactBindedDataCache = paramContactBindedData;
  }
  
  public void setNeedUploadResultTip(boolean paramBoolean)
  {
    this.needUploadResultTip = paramBoolean;
  }
  
  public void setOpeningShareFlag(boolean paramBoolean)
  {
    com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
  }
  
  public boolean shouldBlockMessageTips()
  {
    return this.isAppBlocking;
  }
  
  void unRegistContentObservers()
  {
    if (this.contactObserver != null)
    {
      try
      {
        if (this.destroyed) {
          return;
        }
        this.app.getApp().getContentResolver().unregisterContentObserver(this.contactObserver);
        this.contactObserver.a(null);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
        }
      }
      this.contactObserver = null;
    }
  }
  
  public void unbindMobile()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = getSelfBindInfo();
    if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.nationCode != null))
    {
      if (localRespondQueryQQBindingStat.mobileNo == null) {
        return;
      }
      unbindMobile(false, false);
    }
  }
  
  public void unbindMobile(boolean paramBoolean1, boolean paramBoolean2)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = getSelfBindInfo();
    if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.nationCode != null))
    {
      if (localRespondQueryQQBindingStat.mobileNo == null) {
        return;
      }
      this.mLastUnbindMobileTime = NetConnInfoCenter.getServerTimeMillis();
      this.pref.edit().putLong("last_unbind_mobile_time", this.mLastUnbindMobileTime).apply();
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("unbindMobile [%s]", new Object[] { Long.valueOf(this.mLastUnbindMobileTime) }));
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 20);
      localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
      localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
      localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
      localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void unbindMobileEncrypt(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = getSelfBindInfo();
    if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.nationCode != null))
    {
      if (localRespondQueryQQBindingStat.mobileNo == null) {
        return;
      }
      this.mLastUnbindMobileTime = NetConnInfoCenter.getServerTimeMillis();
      this.pref.edit().putLong("last_unbind_mobile_time", this.mLastUnbindMobileTime).apply();
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("unbindMobileEncrypt [%s]", new Object[] { Long.valueOf(this.mLastUnbindMobileTime) }));
      }
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 20);
      localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
      localNewIntent.putExtra("cmd_param_is_encrypt", true);
      localNewIntent.putExtra("cmd_param_encrypt_mobile", paramArrayOfByte);
      localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
      localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void updateAllEntranceConfig(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int i = new JSONObject(paramString).optInt("all_entrance_num");
        if (i > 0) {
          sAllEntranceNum = i;
        }
        this.mSharePref.edit().putInt("all_entrance_num", sAllEntranceNum).commit();
        this.mSharePref.edit().putInt("key_config_version", paramInt).commit();
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateConfigs error ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateAllEntranceConfig|allEntranceNum = ");
      paramString.append(sAllEntranceNum);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, paramString.toString());
    }
  }
  
  protected boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.em.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void updateOnlineStatus(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    paramString = queryContactByCodeNumber(paramString);
    if (paramString != null)
    {
      paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
      paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
      paramString.eNetworkType = paramGetOnlineInfoResp.eNetworkType;
      paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
      paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
      paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
      if (((paramGetOnlineInfoResp.iTermType == 67586L) || (paramGetOnlineInfoResp.iTermType == 66566L) || (paramGetOnlineInfoResp.iTermType == 72194L) || (paramGetOnlineInfoResp.iTermType == 65804L) || (paramGetOnlineInfoResp.iTermType == 72706L)) && (paramGetOnlineInfoResp.eNetworkType != 1)) {
        paramString.netTypeIconIdIphoneOrWphoneNoWifi = paramGetOnlineInfoResp.eIconType;
      }
      notifyContactChanged(2);
    }
  }
  
  /* Error */
  public void updateRenameList(ArrayList<PhoneContact> paramArrayList)
  {
    // Byte code:
    //   0: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 74
    //   8: iconst_2
    //   9: ldc_w 2566
    //   12: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +131 -> 147
    //   19: aload_1
    //   20: invokevirtual 862	java/util/ArrayList:size	()I
    //   23: ifne +4 -> 27
    //   26: return
    //   27: aload_0
    //   28: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: invokevirtual 601	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 606	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   39: aload_1
    //   40: invokevirtual 1214	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_1
    //   44: aload_1
    //   45: invokeinterface 545 1 0
    //   50: ifeq +46 -> 96
    //   53: aload_1
    //   54: invokeinterface 549 1 0
    //   59: checkcast 556	com/tencent/mobileqq/data/PhoneContact
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 2567	com/tencent/mobileqq/data/PhoneContact:getStatus	()I
    //   67: sipush 1000
    //   70: if_icmpne +14 -> 84
    //   73: aload_0
    //   74: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   77: aload_3
    //   78: invokevirtual 2570	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   81: goto -37 -> 44
    //   84: aload_0
    //   85: getfield 421	com/tencent/mobileqq/phonecontact/api/impl/PhoneContactServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: aload_3
    //   89: invokevirtual 621	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   92: pop
    //   93: goto -49 -> 44
    //   96: aload_2
    //   97: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   100: aload_2
    //   101: ifnull +35 -> 136
    //   104: goto +28 -> 132
    //   107: astore_1
    //   108: goto +29 -> 137
    //   111: astore_1
    //   112: invokestatic 494	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: ldc 74
    //   120: iconst_2
    //   121: aload_1
    //   122: invokevirtual 2522	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   136: return
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   145: aload_1
    //   146: athrow
    //   147: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	PhoneContactServiceImpl
    //   0	148	1	paramArrayList	ArrayList<PhoneContact>
    //   34	108	2	localEntityTransaction	EntityTransaction
    //   62	27	3	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   35	44	107	finally
    //   44	81	107	finally
    //   84	93	107	finally
    //   96	100	107	finally
    //   112	128	107	finally
    //   35	44	111	java/lang/Exception
    //   44	81	111	java/lang/Exception
    //   84	93	111	java/lang/Exception
    //   96	100	111	java/lang/Exception
  }
  
  public void updateSessionId(byte[] paramArrayOfByte)
  {
    this.sessionId = paramArrayOfByte;
    this.pref.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public void uploadOrUpdateContact()
  {
    int i = getSelfBindState();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadOrUpdateContact() state: ");
    localStringBuilder.append(i);
    QLog.i("IMCore.PhoneContact.PhoneContactServiceImpl", 1, localStringBuilder.toString());
    if (i > 5)
    {
      if (i == 9)
      {
        updatePhoneContact();
        return;
      }
      uploadPhoneContact();
      return;
    }
    if (i == 2)
    {
      updatePhoneContactNotBind();
      return;
    }
    uploadPhoneContactNotBind();
  }
  
  public boolean uploadPhoneContact()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder(50);
          ((StringBuilder)localObject1).append("uploadPhoneContact, isUploading = ");
          if (this.mCurrentBindState == 8)
          {
            bool = true;
            ((StringBuilder)localObject1).append(bool);
            ((StringBuilder)localObject1).append(", isQueryingContact = ");
            ((StringBuilder)localObject1).append(this.isQueryingContact);
            ((StringBuilder)localObject1).append(", lastFailPeriode = ");
            ((StringBuilder)localObject1).append((System.currentTimeMillis() - this.lastUploadFailTimeStamp) / 1000L);
            QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          if ((this.mCurrentBindState != 8) && (!this.isQueryingContact) && (getUNIQUE_NO() != null))
          {
            long l1 = System.currentTimeMillis();
            long l2 = this.lastUploadFailTimeStamp;
            if (l1 - l2 < 120000L) {
              return false;
            }
            QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "do-uploadPhoneContact()");
            if ((this.mCurrentBindState == 2) || (this.mCurrentBindState == 3) || (this.mCurrentBindState == 4)) {
              deleteLocalData();
            }
            this.mCurrentBindState = 8;
            notifyBindStateChanged();
            if (this.mUploadProgressGenerator == null)
            {
              this.mUploadProgressGenerator = new PhoneContactServiceImpl.UploadProgressGenerator(this, null);
              this.mUploadProgressGenerator.a();
            }
            Object localObject3 = loadContactFromPhoneToDB();
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = new ArrayList(0);
            }
            if (this.mIsUploadForNewGuide) {
              saveUploadDataForNewGuide(1, ((ArrayList)localObject1).size(), 0, 0);
            }
            localObject3 = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            ((NewIntent)localObject3).putExtra("req_type", 31);
            ((NewIntent)localObject3).putExtra("unique_phone_no", getUNIQUE_NO());
            ((NewIntent)localObject3).putExtra("next_flag", 0L);
            ((NewIntent)localObject3).putExtra("upload_package_no", 0);
            ((NewIntent)localObject3).putExtra("contact_list", (Serializable)localObject1);
            ((NewIntent)localObject3).putExtra("session_id", new byte[0]);
            ((NewIntent)localObject3).putExtra("is_resend", false);
            this.app.startServlet((NewIntent)localObject3);
            return true;
          }
          return false;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean uploadPhoneContactNotBind()
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(50);
        ((StringBuilder)localObject1).append("uploadPhoneContactNotBind, isUploading = ");
        ((StringBuilder)localObject1).append(this.mCurrentBindState);
        ((StringBuilder)localObject1).append("isQueryingContact = ");
        ((StringBuilder)localObject1).append(this.isQueryingContact);
        ((StringBuilder)localObject1).append(", lastFailPeriode = ");
        ((StringBuilder)localObject1).append((System.currentTimeMillis() - this.lastUploadFailTimeStamp) / 1000L);
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.mCurrentBindState != 4) && (!this.isQueryingContact) && (getUNIQUE_NO() != null))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.lastUploadFailTimeStamp;
        if (l1 - l2 < 120000L) {
          return false;
        }
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "do-uploadPhoneContactNotBind()");
        this.pref.edit().putBoolean("contact_bind_nobind_continue_upload", false).commit();
        this.mCurrentBindState = 4;
        notifyBindStateChanged();
        if (this.mUploadProgressGenerator == null)
        {
          this.mUploadProgressGenerator = new PhoneContactServiceImpl.UploadProgressGenerator(this, null);
          this.mUploadProgressGenerator.a();
        }
        Object localObject3 = loadContactFromPhoneToDB();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new ArrayList(0);
        }
        if (this.mIsUploadForNewGuide) {
          saveUploadDataForNewGuide(1, ((ArrayList)localObject1).size(), 0, 0);
        }
        localObject3 = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
        ((NewIntent)localObject3).putExtra("req_type", 37);
        ((NewIntent)localObject3).putExtra("unique_phone_no", getUNIQUE_NO());
        ((NewIntent)localObject3).putExtra("next_flag", 0L);
        ((NewIntent)localObject3).putExtra("upload_package_no", 0);
        ((NewIntent)localObject3).putExtra("contact_list", (Serializable)localObject1);
        ((NewIntent)localObject3).putExtra("session_id", new byte[0]);
        ((NewIntent)localObject3).putExtra("is_resend", false);
        this.app.startServlet((NewIntent)localObject3);
        return true;
      }
      if (this.isQueryingContact) {
        this.pref.edit().putBoolean("contact_bind_nobind_continue_upload", true).commit();
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl
 * JD-Core Version:    0.7.0.1
 */