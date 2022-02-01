package com.tencent.mobileqq.phonecontact.api.impl;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.AggregationExceptions;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.constant.ContactSyncConstants;
import com.tencent.mobileqq.phonecontact.data.ContactOperation;
import com.tencent.mobileqq.phonecontact.data.RawContact;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.ContactSyncUtils;
import com.tencent.mobileqq.phonecontact.util.ReportUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ContactSyncServiceImpl
  implements IContactSyncService
{
  private static final int DEFAULT_BATCH_SIZE = 500;
  private static final long DELAY_REFRESH_QQ_CONTACT = 30000L;
  private static final int MSG_ADD_SYNC_ACCOUNT = 1;
  private static final int MSG_REMOVE_SYNC_ACCOUNT = 2;
  private static final String PREF_FILE_NAME = "contactsync";
  private static final String PREF_REMOVE_ACCOUNT_PREFIX = "pref_remove_account_prefix";
  private static final String TAG = "ContactSync.Manager";
  private static final Set<String> accountSetIDel = new HashSet();
  private static String mIsSync = ContactSyncConstants.jdField_a_of_type_JavaLangString;
  private final String PREF_SYNC_CONTACT = "pref_sync_contact";
  private AppInterface app;
  private ContactBindObserver contactOb = new ContactSyncServiceImpl.1(this);
  private boolean hasIRemovedByUser;
  private boolean isSyncSwitchOpen;
  private volatile boolean isSyncing = false;
  private AccountManager mAccountMgr;
  private String mContactAuthority = "com.android.contacts";
  private Lock mLock = new ReentrantLock();
  private SharedPreferences mPref;
  private Handler mSyncAccountHandler = new ContactSyncServiceImpl.3(this, ThreadManager.getSubThreadLooper());
  private ContactSyncServiceImpl.RefreshContactRunnable refreshContactRunnable = new ContactSyncServiceImpl.RefreshContactRunnable(this, null);
  private volatile Account syncAccount = null;
  private volatile boolean waitDelAccount = false;
  
  /* Error */
  private boolean addSyncAccount()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 151	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:couldAddAccount	()Z
    //   4: istore_1
    //   5: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +34 -> 42
    //   11: new 158	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc 161
    //   22: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_2
    //   27: iload_1
    //   28: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: ldc 27
    //   34: iconst_2
    //   35: aload_2
    //   36: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iload_1
    //   43: ifne +5 -> 48
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_0
    //   49: getfield 85	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mLock	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 180 1 0
    //   57: new 182	android/accounts/Account
    //   60: dup
    //   61: ldc 184
    //   63: iconst_2
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   73: invokevirtual 189	com/tencent/common/app/AppInterface:getCurrentNickname	()Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload_0
    //   80: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   83: invokevirtual 192	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 198	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokestatic 202	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:sqliteEscape	(Ljava/lang/String;)Ljava/lang/String;
    //   93: ldc 204
    //   95: invokespecial 207	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore_2
    //   99: aload_0
    //   100: getfield 146	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mAccountMgr	Landroid/accounts/AccountManager;
    //   103: aload_2
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual 213	android/accounts/AccountManager:addAccountExplicitly	(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   109: ifeq +52 -> 161
    //   112: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +11 -> 126
    //   118: ldc 27
    //   120: iconst_2
    //   121: ldc 215
    //   123: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_0
    //   127: aload_2
    //   128: putfield 118	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:syncAccount	Landroid/accounts/Account;
    //   131: aload_0
    //   132: getfield 118	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:syncAccount	Landroid/accounts/Account;
    //   135: aload_0
    //   136: getfield 80	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mContactAuthority	Ljava/lang/String;
    //   139: iconst_1
    //   140: invokestatic 221	android/content/ContentResolver:setIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;I)V
    //   143: aload_2
    //   144: aload_0
    //   145: getfield 80	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mContactAuthority	Ljava/lang/String;
    //   148: iconst_1
    //   149: invokestatic 225	android/content/ContentResolver:setSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;Z)V
    //   152: aload_0
    //   153: iconst_2
    //   154: invokevirtual 229	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:onQQContactRefreshed	(I)Z
    //   157: pop
    //   158: goto +40 -> 198
    //   161: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +34 -> 198
    //   167: ldc 27
    //   169: iconst_2
    //   170: ldc 231
    //   172: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: goto +23 -> 198
    //   178: astore_2
    //   179: goto +30 -> 209
    //   182: astore_2
    //   183: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +12 -> 198
    //   189: ldc 27
    //   191: iconst_2
    //   192: ldc 233
    //   194: aload_2
    //   195: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload_0
    //   199: getfield 85	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mLock	Ljava/util/concurrent/locks/Lock;
    //   202: invokeinterface 239 1 0
    //   207: iconst_1
    //   208: ireturn
    //   209: aload_0
    //   210: getfield 85	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mLock	Ljava/util/concurrent/locks/Lock;
    //   213: invokeinterface 239 1 0
    //   218: aload_2
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	ContactSyncServiceImpl
    //   4	39	1	bool	boolean
    //   18	126	2	localObject1	Object
    //   178	1	2	localObject2	Object
    //   182	37	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   57	126	178	finally
    //   126	158	178	finally
    //   161	175	178	finally
    //   183	198	178	finally
    //   57	126	182	java/lang/Throwable
    //   126	158	182	java/lang/Throwable
    //   161	175	182	java/lang/Throwable
  }
  
  private void aggregateRawContact(List<ContentProviderOperation> paramList, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("raw_contact_id1", Long.valueOf(paramLong1));
    localContentValues.put("raw_contact_id2", Long.valueOf(paramLong2));
    localContentValues.put("type", Integer.valueOf(1));
    paramList.add(ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI).withValues(localContentValues).withYieldAllowed(true).build());
  }
  
  private boolean applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "applyBatch | enter");
    }
    boolean bool2 = false;
    boolean bool1;
    try
    {
      this.app.getApp().getContentResolver().applyBatch(this.mContactAuthority, paramArrayList);
      bool1 = true;
    }
    catch (IllegalArgumentException paramArrayList)
    {
      String str = Log.getStackTraceString(paramArrayList);
      if ((!TextUtils.isEmpty(str)) && (str.contains("Unknown authority"))) {
        onAuthorityUnknown();
      }
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ContactSync.Manager", 2, "doSyncContacts | IllegalArgumentException: ", paramArrayList);
        bool1 = bool2;
      }
    }
    catch (OperationApplicationException paramArrayList)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ContactSync.Manager", 2, "doSyncContacts | OperationApplicationException:", paramArrayList);
        bool1 = bool2;
      }
    }
    catch (RemoteException paramArrayList)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ContactSync.Manager", 2, "doSyncContacts | RemoteException:", paramArrayList);
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("applyBatch | result = ");
      paramArrayList.append(bool1);
      paramArrayList.append(" | leave");
      QLog.d("ContactSync.Manager", 2, paramArrayList.toString());
    }
    return bool1;
  }
  
  private boolean applyBatchOn(ArrayList<ContentProviderOperation> paramArrayList, int paramInt, String paramString)
  {
    if ((paramArrayList.size() > paramInt) && (!shouldStopSync()))
    {
      boolean bool = applyBatch(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, String.format("applyBatchOn | %s | res=%b size=%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramArrayList.size()) }));
      }
      paramArrayList.clear();
      return bool;
    }
    return false;
  }
  
  private boolean couldAddAccount()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("couldAddAccount | is device support = ");
      ((StringBuilder)localObject).append(isSyncSupportForTheDevice());
      ((StringBuilder)localObject).append(" | app is login=");
      ((StringBuilder)localObject).append(this.app.isLogin());
      ((StringBuilder)localObject).append(" | syncContactAllowed=");
      ((StringBuilder)localObject).append(this.isSyncSwitchOpen);
      ((StringBuilder)localObject).append(" | hasIRemovedByUser = ");
      ((StringBuilder)localObject).append(this.hasIRemovedByUser);
      QLog.d("ContactSync.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if ((isSyncSupportForTheDevice()) && (this.app.isLogin()) && (this.isSyncSwitchOpen) && (!this.hasIRemovedByUser))
    {
      localObject = getSyncAccountUin();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("couldAddAccount | syncUin = ");
        localStringBuilder.append(ContactSyncUtils.a((String)localObject));
        localStringBuilder.append(" | currentUin = ");
        localStringBuilder.append(ContactSyncUtils.a(this.app.getCurrentAccountUin()));
        QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.app.getCurrentAccountUin()))) {
        return false;
      }
      localObject = PhoneContactServiceImpl.getService(this.app);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("coundlAddAccount | pcm = ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" | bindState = ");
        localStringBuilder.append(((IPhoneContactService)localObject).getSelfBindState());
        QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
      }
      if (((IPhoneContactService)localObject).isBindContactOk())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("couldAddAccount | bind state = ");
          localStringBuilder.append(((IPhoneContactService)localObject).getSelfBindState());
          QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean couldSyncContact()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("couldSyncContact | app is login=");
      ((StringBuilder)localObject).append(this.app.isLogin());
      ((StringBuilder)localObject).append(" | syncContactAllowed=");
      ((StringBuilder)localObject).append(this.isSyncSwitchOpen);
      QLog.d("ContactSync.Manager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool5 = this.app.isLogin();
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = bool4;
    if (bool5)
    {
      bool1 = bool4;
      if (this.isSyncSwitchOpen)
      {
        localObject = getSyncAccountUin();
        PhoneContactServiceImpl localPhoneContactServiceImpl = PhoneContactServiceImpl.getService(this.app);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("couldSyncContact | bind state = ");
        int i;
        if (localPhoneContactServiceImpl != null) {
          i = 9;
        } else {
          i = -100000;
        }
        localStringBuilder.append(i);
        localStringBuilder.append(" | account.name = ");
        localStringBuilder.append(ContactSyncUtils.a((String)localObject));
        QLog.d("ContactSync.Manager", 1, localStringBuilder.toString());
        bool1 = bool4;
        if (localPhoneContactServiceImpl != null)
        {
          bool1 = bool4;
          if (localPhoneContactServiceImpl.isBindContactOk())
          {
            bool1 = bool4;
            if (this.app.getCurrentAccountUin().equals(localObject))
            {
              localObject = this.syncAccount;
              if (localObject != null)
              {
                bool2 = ContentResolver.getSyncAutomatically((Account)localObject, this.mContactAuthority);
                bool1 = bool3;
                if (ContentResolver.getIsSyncable((Account)localObject, this.mContactAuthority) > 0) {
                  bool1 = true;
                }
                bool4 = ContentResolver.getMasterSyncAutomatically();
                bool3 = bool2;
                bool2 = bool1;
                bool1 = bool3;
                bool3 = bool4;
              }
              else
              {
                bool4 = false;
                bool3 = false;
                bool1 = bool2;
                bool2 = bool4;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("couldSyncContact | isSystemSyncAutomatic = ");
              ((StringBuilder)localObject).append(bool1);
              ((StringBuilder)localObject).append(" | isSystemSyncable = ");
              ((StringBuilder)localObject).append(bool2);
              ((StringBuilder)localObject).append(" | isMasterSyncAutomatic = ");
              ((StringBuilder)localObject).append(bool3);
              QLog.d("ContactSync.Manager", 1, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void deleteRawContact(long paramLong, List<ContentProviderOperation> paramList)
  {
    paramList = this.app.getApp().getContentResolver();
    Uri localUri = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", mIsSync).build();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    paramList.delete(localUri, "_id = ?", new String[] { localStringBuilder.toString() });
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteRawContact | leave");
    }
  }
  
  private boolean doSyncContacts(Map<String, PhoneContact> paramMap, int paramInt)
  {
    try
    {
      bool = shouldStopSyncCheck("enter");
      if (bool) {
        return false;
      }
      localObject3 = getRawContacts();
      if ((((List)localObject3).size() == 0) && (!PermissionChecker.a().a(true)))
      {
        QLog.d("ContactSync.Manager", 1, "doSyncContacts return. no read contacts permission !");
        return false;
      }
      localArrayList = new ArrayList();
      localObject2 = new HashSet(paramMap.size());
      localObject1 = new HashSet();
      i5 = paramMap.size();
      localObject4 = ((List)localObject3).iterator();
      k = 0;
      j = 0;
      i1 = 0;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        boolean bool;
        Object localObject3;
        ArrayList localArrayList;
        Object localObject2;
        Object localObject1;
        int i5;
        Object localObject4;
        RawContact localRawContact;
        String str;
        int i3;
        int m;
        for (;;)
        {
          throw paramMap;
        }
        int i4 = i;
        int n = j;
        int i2 = m;
        label1153:
        int k = i2;
        int j = n;
        int i1 = i3;
        int i = i4;
      }
    }
    if (((Iterator)localObject4).hasNext())
    {
      localRawContact = (RawContact)((Iterator)localObject4).next();
      bool = shouldStopSyncCheck("for1");
      if (bool) {
        return false;
      }
      str = localRawContact.jdField_a_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(str)) && (paramMap.containsKey(localRawContact.jdField_a_of_type_JavaLangString)))
      {
        i2 = k;
        n = j;
        i3 = i1;
        i4 = i;
        if (TextUtils.isEmpty(str)) {
          break label1153;
        }
        i2 = k;
        n = j;
        i3 = i1;
        i4 = i;
        if (!paramMap.containsKey(str)) {
          break label1153;
        }
        if (((Set)localObject2).contains(Integer.valueOf(localRawContact.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ContactSync.Manager", 2, "doSyncContacts | error: duplicate contact id");
          }
          m = i + 1;
          deleteRawContact(localRawContact.jdField_a_of_type_Long, localArrayList);
          n = j;
        }
        else
        {
          ((Set)localObject2).add(Integer.valueOf(localRawContact.jdField_a_of_type_Int));
          n = j;
          m = i;
          if (((PhoneContact)paramMap.get(str)).contactID != localRawContact.jdField_a_of_type_Int)
          {
            ((Set)localObject1).add(localRawContact.jdField_a_of_type_JavaLangString);
            updateRawContact(localArrayList, (PhoneContact)paramMap.get(str), localRawContact.jdField_a_of_type_Long);
            n = j + 1;
            m = i;
          }
        }
        paramMap.remove(str);
        i2 = k;
        i3 = i1;
        i4 = m;
        break label1153;
      }
      deleteRawContact(localRawContact.jdField_a_of_type_Long, localArrayList);
      i3 = i1 + 1;
      m = k;
      if (i3 < 15)
      {
        m = k;
        if (k < 3)
        {
          m = k;
          if (ReportUtil.a(this.app, localRawContact.jdField_a_of_type_Int)) {
            m = k + 1;
          }
        }
      }
    }
    else
    {
      paramMap = paramMap.values();
      QLog.d("ContactSync.Manager", 1, String.format("doSyncContacts syncFrom|selfUin|syncUin|qqContactSize|rawContactSize|delCnt|delCntConflict|aggCnt|willInsertCnt|dangersDelCnt = %d|%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(paramInt), this.app.getCurrentAccountUin(), ContactSyncUtils.a(getSyncAccountUin()), Integer.valueOf(i5), Integer.valueOf(((List)localObject3).size()), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramMap.size()), Integer.valueOf(k) }));
      ReportUtil.a(this.app, paramInt, i5, ((List)localObject3).size(), i1, i, k, paramMap.size());
      applyBatchOn(localArrayList, 0, "doSyncContacts apply update ops");
      paramMap = paramMap.iterator();
      for (paramInt = 0; paramMap.hasNext(); paramInt = i)
      {
        localObject3 = (PhoneContact)paramMap.next();
        bool = shouldStopSyncCheck("for2");
        if (bool) {
          return false;
        }
        if (!((Set)localObject2).contains(Integer.valueOf(((PhoneContact)localObject3).contactID)))
        {
          insertRawContact(localArrayList, (PhoneContact)localObject3);
          ((Set)localObject2).add(Integer.valueOf(((PhoneContact)localObject3).contactID));
          ((Set)localObject1).add(((PhoneContact)localObject3).mobileNo);
          i = paramInt + 1;
        }
        else
        {
          i = paramInt;
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("doSyncContacts | contact ");
            ((StringBuilder)localObject4).append(((PhoneContact)localObject3).contactID);
            ((StringBuilder)localObject4).append(" has two match phonenum");
            QLog.d("ContactSync.Manager", 2, ((StringBuilder)localObject4).toString());
            i = paramInt;
          }
        }
        applyBatchOn(localArrayList, 500, "doSyncContacts apply insert ops");
      }
      applyBatchOn(localArrayList, 0, "doSyncContacts apply insert ops left");
      QLog.d("ContactSync.Manager", 1, String.format("doSyncContacts realInsertCnt|aggCnt = %d|%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((Set)localObject1).size()) }));
      paramInt = ((Set)localObject1).size();
      if (paramInt == 0) {
        return true;
      }
      localArrayList.clear();
      localArrayList.ensureCapacity(((Set)localObject1).size());
      localObject2 = getRawContacts();
      paramMap = getLocalContacts();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (RawContact)((Iterator)localObject2).next();
        if ((((Set)localObject1).contains(((RawContact)localObject3).jdField_a_of_type_JavaLangString)) && (paramMap.containsKey(((RawContact)localObject3).jdField_a_of_type_JavaLangString)))
        {
          aggregateRawContact(localArrayList, ((RawContact)localObject3).jdField_a_of_type_Long, ((Long)paramMap.get(((RawContact)localObject3).jdField_a_of_type_JavaLangString)).longValue());
          ((Set)localObject1).remove(((RawContact)localObject3).jdField_a_of_type_JavaLangString);
        }
        applyBatchOn(localArrayList, 500, "doSyncContacts apply aggregate batch");
      }
      applyBatchOn(localArrayList, 0, "doSyncContacts apply aggregate batch left");
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder(1024);
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramMap.append(ContactSyncUtils.b((String)((Iterator)localObject1).next()));
          paramMap.append("|");
        }
        QLog.d("ContactSync.Manager", 2, String.format("doSyncContacts | remain source IDs = [%s] | leave", new Object[] { paramMap.toString() }));
      }
      return true;
    }
  }
  
  private static String extraUin(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("(");
      int j = paramString.lastIndexOf(")");
      if ((i != -1) && (j != -1)) {
        return paramString.substring(i + 1, j);
      }
    }
    return null;
  }
  
  /* Error */
  private Map<String, Long> getLocalContacts()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 316	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 322	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_1
    //   11: new 670	java/util/HashMap
    //   14: dup
    //   15: invokespecial 671	java/util/HashMap:<init>	()V
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_3
    //   22: aconst_null
    //   23: astore_2
    //   24: aload_1
    //   25: getstatic 675	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$PhoneQuery:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   28: getstatic 678	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$PhoneQuery:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_1
    //   38: aload 4
    //   40: astore_2
    //   41: aload_1
    //   42: ifnull +78 -> 120
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: astore_3
    //   49: new 670	java/util/HashMap
    //   52: dup
    //   53: aload_1
    //   54: invokeinterface 687 1 0
    //   59: invokespecial 688	java/util/HashMap:<init>	(I)V
    //   62: astore 5
    //   64: aload_1
    //   65: astore_2
    //   66: aload_1
    //   67: invokeinterface 691 1 0
    //   72: ifeq +34 -> 106
    //   75: aload_1
    //   76: astore_2
    //   77: aload 5
    //   79: aload_1
    //   80: iconst_0
    //   81: invokeinterface 695 2 0
    //   86: invokestatic 698	com/tencent/mobileqq/phonecontact/util/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   89: aload_1
    //   90: iconst_3
    //   91: invokeinterface 702 2 0
    //   96: invokestatic 252	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   99: invokevirtual 705	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: goto -39 -> 64
    //   106: aload 5
    //   108: astore_2
    //   109: goto +11 -> 120
    //   112: astore 4
    //   114: aload 5
    //   116: astore_3
    //   117: goto +51 -> 168
    //   120: aload_2
    //   121: astore_3
    //   122: aload_1
    //   123: ifnull +96 -> 219
    //   126: aload_1
    //   127: invokeinterface 708 1 0
    //   132: aload_2
    //   133: areturn
    //   134: astore_1
    //   135: aload_2
    //   136: astore_3
    //   137: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +79 -> 219
    //   143: ldc 27
    //   145: iconst_2
    //   146: ldc_w 710
    //   149: aload_1
    //   150: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_2
    //   154: areturn
    //   155: astore_1
    //   156: goto +65 -> 221
    //   159: astore_2
    //   160: aload_3
    //   161: astore_1
    //   162: aload 4
    //   164: astore_3
    //   165: aload_2
    //   166: astore 4
    //   168: aload_1
    //   169: astore_2
    //   170: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +16 -> 189
    //   176: aload_1
    //   177: astore_2
    //   178: ldc 27
    //   180: iconst_2
    //   181: ldc_w 711
    //   184: aload 4
    //   186: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   189: aload_1
    //   190: ifnull +29 -> 219
    //   193: aload_1
    //   194: invokeinterface 708 1 0
    //   199: goto +20 -> 219
    //   202: astore_1
    //   203: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +13 -> 219
    //   209: ldc 27
    //   211: iconst_2
    //   212: ldc_w 710
    //   215: aload_1
    //   216: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_3
    //   220: areturn
    //   221: aload_2
    //   222: ifnull +29 -> 251
    //   225: aload_2
    //   226: invokeinterface 708 1 0
    //   231: goto +20 -> 251
    //   234: astore_2
    //   235: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +13 -> 251
    //   241: ldc 27
    //   243: iconst_2
    //   244: ldc_w 710
    //   247: aload_2
    //   248: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: goto +5 -> 256
    //   254: aload_1
    //   255: athrow
    //   256: goto -2 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	ContactSyncServiceImpl
    //   10	117	1	localObject1	Object
    //   134	16	1	localThrowable1	Throwable
    //   155	1	1	localObject2	Object
    //   161	33	1	localObject3	Object
    //   202	53	1	localThrowable2	Throwable
    //   23	131	2	localObject4	Object
    //   159	7	2	localException1	java.lang.Exception
    //   169	57	2	localObject5	Object
    //   234	14	2	localThrowable3	Throwable
    //   21	199	3	localObject6	Object
    //   18	21	4	localHashMap1	HashMap
    //   112	51	4	localException2	java.lang.Exception
    //   166	19	4	localObject7	Object
    //   62	53	5	localHashMap2	HashMap
    // Exception table:
    //   from	to	target	type
    //   66	75	112	java/lang/Exception
    //   77	103	112	java/lang/Exception
    //   126	132	134	java/lang/Throwable
    //   24	38	155	finally
    //   49	64	155	finally
    //   66	75	155	finally
    //   77	103	155	finally
    //   170	176	155	finally
    //   178	189	155	finally
    //   24	38	159	java/lang/Exception
    //   49	64	159	java/lang/Exception
    //   193	199	202	java/lang/Throwable
    //   225	231	234	java/lang/Throwable
  }
  
  /* Error */
  private Set<Long> getLocalSIMContacts()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 316	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 322	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: new 65	java/util/HashSet
    //   14: dup
    //   15: invokespecial 68	java/util/HashSet:<init>	()V
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_1
    //   22: aconst_null
    //   23: astore_3
    //   24: aload_2
    //   25: getstatic 468	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   28: iconst_1
    //   29: anewarray 194	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 716
    //   37: aastore
    //   38: ldc_w 718
    //   41: iconst_1
    //   42: anewarray 194	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc_w 720
    //   50: aastore
    //   51: aconst_null
    //   52: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_2
    //   56: aload 4
    //   58: astore_1
    //   59: aload_2
    //   60: ifnull +72 -> 132
    //   63: aload_2
    //   64: astore_3
    //   65: aload_2
    //   66: astore_1
    //   67: new 65	java/util/HashSet
    //   70: dup
    //   71: aload_2
    //   72: invokeinterface 687 1 0
    //   77: invokespecial 529	java/util/HashSet:<init>	(I)V
    //   80: astore 5
    //   82: aload_2
    //   83: astore_3
    //   84: aload_2
    //   85: invokeinterface 691 1 0
    //   90: ifeq +26 -> 116
    //   93: aload_2
    //   94: astore_3
    //   95: aload 5
    //   97: aload_2
    //   98: iconst_0
    //   99: invokeinterface 702 2 0
    //   104: invokestatic 252	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: invokeinterface 566 2 0
    //   112: pop
    //   113: goto -31 -> 82
    //   116: aload 5
    //   118: astore_1
    //   119: goto +13 -> 132
    //   122: astore_3
    //   123: aload 5
    //   125: astore_1
    //   126: aload_3
    //   127: astore 5
    //   129: goto +55 -> 184
    //   132: aload_1
    //   133: astore_3
    //   134: aload_2
    //   135: ifnull +99 -> 234
    //   138: aload_2
    //   139: invokeinterface 708 1 0
    //   144: aload_1
    //   145: astore_3
    //   146: goto +88 -> 234
    //   149: astore_2
    //   150: aload_1
    //   151: astore_3
    //   152: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +79 -> 234
    //   158: ldc 27
    //   160: iconst_2
    //   161: ldc_w 722
    //   164: aload_2
    //   165: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_1
    //   169: astore_3
    //   170: goto +64 -> 234
    //   173: astore_1
    //   174: goto +105 -> 279
    //   177: astore 5
    //   179: aload_1
    //   180: astore_2
    //   181: aload 4
    //   183: astore_1
    //   184: aload_2
    //   185: astore_3
    //   186: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +16 -> 205
    //   192: aload_2
    //   193: astore_3
    //   194: ldc 27
    //   196: iconst_2
    //   197: ldc_w 723
    //   200: aload 5
    //   202: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_1
    //   206: astore_3
    //   207: aload_2
    //   208: ifnull +26 -> 234
    //   211: aload_2
    //   212: invokeinterface 708 1 0
    //   217: aload_1
    //   218: astore_3
    //   219: goto +15 -> 234
    //   222: astore_2
    //   223: aload_1
    //   224: astore_3
    //   225: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +6 -> 234
    //   231: goto -73 -> 158
    //   234: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +40 -> 277
    //   240: new 158	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   247: astore_1
    //   248: aload_1
    //   249: ldc_w 725
    //   252: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_1
    //   257: aload_3
    //   258: invokeinterface 624 1 0
    //   263: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: ldc 27
    //   269: iconst_2
    //   270: aload_1
    //   271: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: aload_3
    //   278: areturn
    //   279: aload_3
    //   280: ifnull +29 -> 309
    //   283: aload_3
    //   284: invokeinterface 708 1 0
    //   289: goto +20 -> 309
    //   292: astore_2
    //   293: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +13 -> 309
    //   299: ldc 27
    //   301: iconst_2
    //   302: ldc_w 722
    //   305: aload_2
    //   306: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: goto +5 -> 314
    //   312: aload_1
    //   313: athrow
    //   314: goto -2 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	ContactSyncServiceImpl
    //   21	148	1	localObject1	Object
    //   173	7	1	localObject2	Object
    //   183	130	1	localObject3	Object
    //   10	129	2	localObject4	Object
    //   149	16	2	localThrowable1	Throwable
    //   180	32	2	localObject5	Object
    //   222	1	2	localThrowable2	Throwable
    //   292	14	2	localThrowable3	Throwable
    //   23	72	3	localObject6	Object
    //   122	5	3	localException1	java.lang.Exception
    //   133	151	3	localObject7	Object
    //   18	164	4	localHashSet	HashSet
    //   80	48	5	localObject8	Object
    //   177	24	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   84	93	122	java/lang/Exception
    //   95	113	122	java/lang/Exception
    //   138	144	149	java/lang/Throwable
    //   24	56	173	finally
    //   67	82	173	finally
    //   84	93	173	finally
    //   95	113	173	finally
    //   186	192	173	finally
    //   194	205	173	finally
    //   24	56	177	java/lang/Exception
    //   67	82	177	java/lang/Exception
    //   211	217	222	java/lang/Throwable
    //   283	289	292	java/lang/Throwable
  }
  
  private Map<String, PhoneContact> getQQContacts()
  {
    List localList = PhoneContactServiceImpl.getService(this.app).getContactList();
    if (localList != null)
    {
      HashMap localHashMap = new HashMap(localList.size());
      Object localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localPhoneContact.uin)) {
          localHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getQQContacts | allList.size = ");
        ((StringBuilder)localObject).append(localList.size());
        ((StringBuilder)localObject).append(" | map.size=");
        ((StringBuilder)localObject).append(localHashMap.size());
        QLog.d("ContactSync.Manager", 2, ((StringBuilder)localObject).toString());
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  /* Error */
  private List<RawContact> getRawContacts()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 316	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 322	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_3
    //   11: new 360	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 523	java/util/ArrayList:<init>	()V
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_2
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_3
    //   25: aload_0
    //   26: invokespecial 742	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:getSyncAccountName	()Ljava/lang/String;
    //   29: invokestatic 747	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$RawQuery:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   32: getstatic 748	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$RawQuery:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +107 -> 150
    //   46: aload_3
    //   47: astore_1
    //   48: aload_3
    //   49: astore_2
    //   50: aload 4
    //   52: aload_3
    //   53: invokeinterface 687 1 0
    //   58: invokevirtual 627	java/util/ArrayList:ensureCapacity	(I)V
    //   61: aload_3
    //   62: astore_1
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: invokeinterface 691 1 0
    //   71: ifeq +79 -> 150
    //   74: aload_3
    //   75: astore_1
    //   76: aload_3
    //   77: astore_2
    //   78: new 544	com/tencent/mobileqq/phonecontact/data/RawContact
    //   81: dup
    //   82: invokespecial 749	com/tencent/mobileqq/phonecontact/data/RawContact:<init>	()V
    //   85: astore 5
    //   87: aload_3
    //   88: astore_1
    //   89: aload_3
    //   90: astore_2
    //   91: aload 5
    //   93: aload_3
    //   94: iconst_0
    //   95: invokeinterface 702 2 0
    //   100: putfield 563	com/tencent/mobileqq/phonecontact/data/RawContact:jdField_a_of_type_Long	J
    //   103: aload_3
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: aload 5
    //   109: aload_3
    //   110: iconst_1
    //   111: invokeinterface 695 2 0
    //   116: putfield 547	com/tencent/mobileqq/phonecontact/data/RawContact:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   119: aload_3
    //   120: astore_1
    //   121: aload_3
    //   122: astore_2
    //   123: aload 5
    //   125: aload_3
    //   126: iconst_2
    //   127: invokeinterface 753 2 0
    //   132: putfield 552	com/tencent/mobileqq/phonecontact/data/RawContact:jdField_a_of_type_Int	I
    //   135: aload_3
    //   136: astore_1
    //   137: aload_3
    //   138: astore_2
    //   139: aload 4
    //   141: aload 5
    //   143: invokevirtual 754	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   146: pop
    //   147: goto -86 -> 61
    //   150: aload_3
    //   151: ifnull +80 -> 231
    //   154: aload_3
    //   155: invokeinterface 708 1 0
    //   160: goto +71 -> 231
    //   163: astore_1
    //   164: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +64 -> 231
    //   170: ldc 27
    //   172: iconst_2
    //   173: ldc_w 756
    //   176: aload_1
    //   177: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   180: goto +51 -> 231
    //   183: astore_2
    //   184: goto +86 -> 270
    //   187: astore_3
    //   188: aload_2
    //   189: astore_1
    //   190: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +15 -> 208
    //   196: aload_2
    //   197: astore_1
    //   198: ldc 27
    //   200: iconst_2
    //   201: ldc_w 757
    //   204: aload_3
    //   205: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: aload_2
    //   209: ifnull +22 -> 231
    //   212: aload_2
    //   213: invokeinterface 708 1 0
    //   218: goto +13 -> 231
    //   221: astore_1
    //   222: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +6 -> 231
    //   228: goto -58 -> 170
    //   231: new 158	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   238: astore_1
    //   239: aload_1
    //   240: ldc_w 759
    //   243: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_1
    //   248: aload 4
    //   250: invokevirtual 364	java/util/ArrayList:size	()I
    //   253: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 27
    //   259: iconst_1
    //   260: aload_1
    //   261: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload 4
    //   269: areturn
    //   270: aload_1
    //   271: ifnull +29 -> 300
    //   274: aload_1
    //   275: invokeinterface 708 1 0
    //   280: goto +20 -> 300
    //   283: astore_1
    //   284: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +13 -> 300
    //   290: ldc 27
    //   292: iconst_2
    //   293: ldc_w 756
    //   296: aload_1
    //   297: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: goto +5 -> 305
    //   303: aload_2
    //   304: athrow
    //   305: goto -2 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	ContactSyncServiceImpl
    //   23	114	1	localObject1	Object
    //   163	14	1	localThrowable1	Throwable
    //   189	9	1	localObject2	Object
    //   221	1	1	localThrowable2	Throwable
    //   238	37	1	localStringBuilder	StringBuilder
    //   283	14	1	localThrowable3	Throwable
    //   21	118	2	localObject3	Object
    //   183	121	2	localObject4	Object
    //   10	145	3	localObject5	Object
    //   187	18	3	localException	java.lang.Exception
    //   18	250	4	localArrayList	ArrayList
    //   85	57	5	localRawContact	RawContact
    // Exception table:
    //   from	to	target	type
    //   154	160	163	java/lang/Throwable
    //   24	42	183	finally
    //   50	61	183	finally
    //   65	74	183	finally
    //   78	87	183	finally
    //   91	103	183	finally
    //   107	119	183	finally
    //   123	135	183	finally
    //   139	147	183	finally
    //   190	196	183	finally
    //   198	208	183	finally
    //   24	42	187	java/lang/Exception
    //   50	61	187	java/lang/Exception
    //   65	74	187	java/lang/Exception
    //   78	87	187	java/lang/Exception
    //   91	103	187	java/lang/Exception
    //   107	119	187	java/lang/Exception
    //   123	135	187	java/lang/Exception
    //   139	147	187	java/lang/Exception
    //   212	218	221	java/lang/Throwable
    //   274	280	283	java/lang/Throwable
  }
  
  public static ContactSyncServiceImpl getService(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return null;
    }
    return (ContactSyncServiceImpl)paramAppInterface.getRuntimeService(IContactSyncService.class, "");
  }
  
  private String getSubstituteAuthority()
  {
    Object localObject = this.app.getApp().getPackageManager().queryContentProviders(null, 0, 131072);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ProviderInfo localProviderInfo = (ProviderInfo)((Iterator)localObject).next();
        if ((localProviderInfo.authority.contains("contacts")) && (!localProviderInfo.authority.equals("com.android.contacts"))) {
          return localProviderInfo.authority;
        }
      }
    }
    return null;
  }
  
  private String getSyncAccountName()
  {
    Account localAccount = this.syncAccount;
    if (localAccount != null) {
      return localAccount.name;
    }
    return null;
  }
  
  private void initSyncAccount()
  {
    Account[] arrayOfAccount = this.mAccountMgr.getAccountsByType("com.tencent.mobileqq.account");
    if (arrayOfAccount.length > 0)
    {
      this.syncAccount = arrayOfAccount[0];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initSyncAccount | syncAccount = ");
        localStringBuilder.append(this.syncAccount);
        QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
      }
      ThreadManager.executeOnNetWorkThread(new ContactSyncServiceImpl.4(this, arrayOfAccount));
    }
  }
  
  private void insertRawContact(List<ContentProviderOperation> paramList, PhoneContact paramPhoneContact)
  {
    paramList = ContactOperation.a(this.app, paramList, getSyncAccountName(), paramPhoneContact.mobileNo, paramPhoneContact.nationCode, paramPhoneContact.mobileCode, paramPhoneContact.ability, paramPhoneContact.contactID);
    paramList.a(paramPhoneContact.name);
    paramList.b(paramPhoneContact.mobileNo);
  }
  
  private void markCurrentUserRebirth()
  {
    this.hasIRemovedByUser = false;
    SharedPreferences.Editor localEditor = this.mPref.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_remove_account_prefix");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localEditor.remove(localStringBuilder.toString()).apply();
    if (QLog.isColorLevel()) {
      QLog.i("ContactSync.Manager", 2, "markCurrentUserRebirth");
    }
  }
  
  private void onAuthorityUnknown()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAuthorityUnknown | current authority = ");
      ((StringBuilder)localObject).append(this.mContactAuthority);
      QLog.d("ContactSync.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mContactAuthority.equals("com.android.contacts"))
    {
      localObject = getSubstituteAuthority();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onAuthorityUnknown | find substitute authority = ");
          localStringBuilder.append((String)localObject);
          QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
        }
        this.mContactAuthority = ((String)localObject);
        localObject = this.syncAccount;
        if (localObject != null) {
          ContentResolver.setSyncAutomatically((Account)localObject, this.mContactAuthority, true);
        }
        onQQContactRefreshed(3);
      }
    }
  }
  
  /* Error */
  private void removeSyncAccount()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 180 1 0
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 118	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:syncAccount	Landroid/accounts/Account;
    //   14: aload_0
    //   15: getfield 146	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mAccountMgr	Landroid/accounts/AccountManager;
    //   18: ldc 204
    //   20: invokevirtual 792	android/accounts/AccountManager:getAccountsByType	(Ljava/lang/String;)[Landroid/accounts/Account;
    //   23: astore_3
    //   24: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +40 -> 67
    //   30: new 158	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 852
    //   44: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: aload_3
    //   51: arraylength
    //   52: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 27
    //   58: iconst_2
    //   59: aload 4
    //   61: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_3
    //   68: arraylength
    //   69: istore_2
    //   70: iconst_0
    //   71: istore_1
    //   72: iload_1
    //   73: iload_2
    //   74: if_icmpge +135 -> 209
    //   77: aload_3
    //   78: iload_1
    //   79: aaload
    //   80: astore 4
    //   82: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +46 -> 131
    //   88: new 158	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   95: astore 5
    //   97: aload 5
    //   99: ldc_w 854
    //   102: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 5
    //   108: aload 4
    //   110: getfield 787	android/accounts/Account:name	Ljava/lang/String;
    //   113: invokestatic 407	com/tencent/mobileqq/phonecontact/util/ContactSyncUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 27
    //   122: iconst_2
    //   123: aload 5
    //   125: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: getstatic 70	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:accountSetIDel	Ljava/util/Set;
    //   134: astore 5
    //   136: aload 5
    //   138: monitorenter
    //   139: getstatic 70	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:accountSetIDel	Ljava/util/Set;
    //   142: aload 4
    //   144: getfield 787	android/accounts/Account:name	Ljava/lang/String;
    //   147: invokeinterface 566 2 0
    //   152: pop
    //   153: aload 5
    //   155: monitorexit
    //   156: aload_0
    //   157: getfield 146	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mAccountMgr	Landroid/accounts/AccountManager;
    //   160: aload 4
    //   162: new 856	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$5
    //   165: dup
    //   166: aload_0
    //   167: invokespecial 857	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$5:<init>	(Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;)V
    //   170: aconst_null
    //   171: invokevirtual 861	android/accounts/AccountManager:removeAccount	(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    //   174: pop
    //   175: iload_1
    //   176: iconst_1
    //   177: iadd
    //   178: istore_1
    //   179: goto -107 -> 72
    //   182: astore_3
    //   183: aload 5
    //   185: monitorexit
    //   186: aload_3
    //   187: athrow
    //   188: astore_3
    //   189: goto +30 -> 219
    //   192: astore_3
    //   193: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +13 -> 209
    //   199: ldc 27
    //   201: iconst_2
    //   202: ldc_w 863
    //   205: aload_3
    //   206: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_0
    //   210: getfield 85	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mLock	Ljava/util/concurrent/locks/Lock;
    //   213: invokeinterface 239 1 0
    //   218: return
    //   219: aload_0
    //   220: getfield 85	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:mLock	Ljava/util/concurrent/locks/Lock;
    //   223: invokeinterface 239 1 0
    //   228: goto +5 -> 233
    //   231: aload_3
    //   232: athrow
    //   233: goto -2 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	ContactSyncServiceImpl
    //   71	108	1	i	int
    //   69	6	2	j	int
    //   23	55	3	arrayOfAccount	Account[]
    //   182	5	3	localObject1	Object
    //   188	1	3	localObject2	Object
    //   192	40	3	localThrowable	Throwable
    //   37	124	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   139	156	182	finally
    //   183	186	182	finally
    //   9	67	188	finally
    //   67	70	188	finally
    //   82	131	188	finally
    //   131	139	188	finally
    //   156	175	188	finally
    //   186	188	188	finally
    //   193	209	188	finally
    //   9	67	192	java/lang/Throwable
    //   67	70	192	java/lang/Throwable
    //   82	131	192	java/lang/Throwable
    //   131	139	192	java/lang/Throwable
    //   156	175	192	java/lang/Throwable
    //   186	188	192	java/lang/Throwable
  }
  
  private boolean shouldStopSync()
  {
    Account localAccount = this.syncAccount;
    boolean bool2 = false;
    boolean bool1;
    if ((localAccount != null) && (!Thread.interrupted())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if ((bool1) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldStopSync | account = ");
      if (localAccount == null) {
        bool2 = true;
      }
      localStringBuilder.append(bool2);
      localStringBuilder.append(" | interrupted = ");
      localStringBuilder.append(Thread.interrupted());
      QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private boolean shouldStopSyncCheck(String paramString)
  {
    if (shouldStopSync())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, String.format("doSyncContacts | shouldStopSync = true | pos = %s", new Object[] { paramString }));
      }
      return true;
    }
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  public static String sqliteEscape(String paramString)
  {
    String str = paramString;
    if (Build.MANUFACTURER.contains("OPPO")) {
      str = paramString.replace("'", "").replace("%", "").replace("_", "-").replace("/", "").replace("[", "").replace("]", "").replace("&", "");
    }
    return str;
  }
  
  /* Error */
  private void updateRawContact(List<ContentProviderOperation> paramList, PhoneContact paramPhoneContact, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: aload_1
    //   5: lload_3
    //   6: invokestatic 908	com/tencent/mobileqq/phonecontact/data/ContactOperation:a	(Lcom/tencent/common/app/AppInterface;Ljava/util/List;J)Lcom/tencent/mobileqq/phonecontact/data/ContactOperation;
    //   9: astore 7
    //   11: aload_0
    //   12: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   15: invokevirtual 912	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   18: invokevirtual 915	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore_1
    //   28: aload 6
    //   30: getstatic 918	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$DataQuery:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   33: getstatic 919	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$DataQuery:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   36: ldc_w 921
    //   39: iconst_1
    //   40: anewarray 194	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: lload_3
    //   46: invokestatic 924	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnull +146 -> 204
    //   61: aload 6
    //   63: astore_1
    //   64: aload 6
    //   66: astore 5
    //   68: aload 6
    //   70: invokeinterface 691 1 0
    //   75: ifeq +129 -> 204
    //   78: aload 6
    //   80: astore_1
    //   81: aload 6
    //   83: astore 5
    //   85: aload 6
    //   87: iconst_1
    //   88: invokeinterface 695 2 0
    //   93: ldc_w 926
    //   96: invokevirtual 412	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq -38 -> 61
    //   102: aload 6
    //   104: astore_1
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: iconst_2
    //   112: invokeinterface 695 2 0
    //   117: astore 8
    //   119: aload 6
    //   121: astore_1
    //   122: aload 6
    //   124: astore 5
    //   126: aload 8
    //   128: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +22 -> 153
    //   134: aload 6
    //   136: astore_1
    //   137: aload 6
    //   139: astore 5
    //   141: aload 8
    //   143: aload_2
    //   144: getfield 818	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   147: invokevirtual 412	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifne +54 -> 204
    //   153: aload 6
    //   155: astore_1
    //   156: aload 6
    //   158: astore 5
    //   160: aload 6
    //   162: iconst_0
    //   163: invokeinterface 702 2 0
    //   168: lstore_3
    //   169: aload 6
    //   171: astore_1
    //   172: aload 6
    //   174: astore 5
    //   176: getstatic 918	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$DataQuery:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   179: lload_3
    //   180: invokestatic 932	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   183: astore 8
    //   185: aload 6
    //   187: astore_1
    //   188: aload 6
    //   190: astore 5
    //   192: aload 7
    //   194: aload_2
    //   195: getfield 818	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   198: aload 8
    //   200: invokevirtual 935	com/tencent/mobileqq/phonecontact/data/ContactOperation:a	(Ljava/lang/String;Landroid/net/Uri;)Lcom/tencent/mobileqq/phonecontact/data/ContactOperation;
    //   203: pop
    //   204: aload 6
    //   206: ifnull +79 -> 285
    //   209: aload 6
    //   211: invokeinterface 708 1 0
    //   216: return
    //   217: astore_1
    //   218: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +64 -> 285
    //   224: ldc 27
    //   226: iconst_2
    //   227: ldc_w 937
    //   230: aload_1
    //   231: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: return
    //   235: astore_2
    //   236: goto +50 -> 286
    //   239: astore_2
    //   240: aload 5
    //   242: astore_1
    //   243: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +16 -> 262
    //   249: aload 5
    //   251: astore_1
    //   252: ldc 27
    //   254: iconst_2
    //   255: ldc_w 938
    //   258: aload_2
    //   259: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload 5
    //   264: ifnull +21 -> 285
    //   267: aload 5
    //   269: invokeinterface 708 1 0
    //   274: return
    //   275: astore_1
    //   276: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +6 -> 285
    //   282: goto -58 -> 224
    //   285: return
    //   286: aload_1
    //   287: ifnull +29 -> 316
    //   290: aload_1
    //   291: invokeinterface 708 1 0
    //   296: goto +20 -> 316
    //   299: astore_1
    //   300: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +13 -> 316
    //   306: ldc 27
    //   308: iconst_2
    //   309: ldc_w 937
    //   312: aload_1
    //   313: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: goto +5 -> 321
    //   319: aload_2
    //   320: athrow
    //   321: goto -2 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	ContactSyncServiceImpl
    //   0	324	1	paramList	List<ContentProviderOperation>
    //   0	324	2	paramPhoneContact	PhoneContact
    //   0	324	3	paramLong	long
    //   24	244	5	localObject1	Object
    //   21	189	6	localObject2	Object
    //   9	184	7	localContactOperation	ContactOperation
    //   117	82	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   209	216	217	java/lang/Throwable
    //   28	56	235	finally
    //   68	78	235	finally
    //   85	102	235	finally
    //   109	119	235	finally
    //   126	134	235	finally
    //   141	153	235	finally
    //   160	169	235	finally
    //   176	185	235	finally
    //   192	204	235	finally
    //   243	249	235	finally
    //   252	262	235	finally
    //   28	56	239	java/lang/Exception
    //   68	78	239	java/lang/Exception
    //   85	102	239	java/lang/Exception
    //   109	119	239	java/lang/Exception
    //   126	134	239	java/lang/Exception
    //   141	153	239	java/lang/Exception
    //   160	169	239	java/lang/Exception
    //   176	185	239	java/lang/Exception
    //   192	204	239	java/lang/Exception
    //   267	274	275	java/lang/Throwable
    //   290	296	299	java/lang/Throwable
  }
  
  /* Error */
  public boolean acquirePermissionForSamsung()
  {
    // Byte code:
    //   0: getstatic 947	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 22
    //   5: if_icmpge +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   14: invokevirtual 316	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: invokevirtual 322	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   20: ldc 78
    //   22: invokevirtual 951	android/content/ContentResolver:acquireContentProviderClient	(Ljava/lang/String;)Landroid/content/ContentProviderClient;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +21 -> 48
    //   30: invokestatic 956	com/tencent/util/VersionUtils:l	()Z
    //   33: ifeq +10 -> 43
    //   36: aload_1
    //   37: invokevirtual 959	android/content/ContentProviderClient:close	()V
    //   40: goto +8 -> 48
    //   43: aload_1
    //   44: invokevirtual 962	android/content/ContentProviderClient:release	()Z
    //   47: pop
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_1
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: iconst_0
    //   55: ireturn
    //   56: astore_1
    //   57: goto -9 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ContactSyncServiceImpl
    //   25	19	1	localContentProviderClient	android.content.ContentProviderClient
    //   50	2	1	localObject	Object
    //   53	1	1	localSecurityException	java.lang.SecurityException
    //   56	1	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	26	50	finally
    //   10	26	53	java/lang/SecurityException
    //   30	40	56	java/lang/Throwable
    //   43	48	56	java/lang/Throwable
  }
  
  public void deleteSyncContact(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteSyncContact | mobileNo = ");
      localStringBuilder.append(ContactSyncUtils.b(paramString));
      QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
    }
    this.app.getApp().getContentResolver().delete(ContactSyncServiceImpl.RawQuery.a(getSyncAccountName()), "sourceid=?", new String[] { paramString });
  }
  
  /* Error */
  public String getMimeTypeByJumpUri(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 316	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 322	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_3
    //   20: aload_1
    //   21: iconst_1
    //   22: anewarray 194	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 972
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_3
    //   38: aload_2
    //   39: astore_1
    //   40: aload_3
    //   41: ifnull +36 -> 77
    //   44: aload_2
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: invokeinterface 691 1 0
    //   54: ifeq +23 -> 77
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: iconst_0
    //   61: invokeinterface 695 2 0
    //   66: astore_1
    //   67: goto +10 -> 77
    //   70: astore 4
    //   72: aload_3
    //   73: astore_1
    //   74: goto +50 -> 124
    //   77: aload_1
    //   78: astore_2
    //   79: aload_3
    //   80: ifnull +98 -> 178
    //   83: aload_3
    //   84: invokeinterface 708 1 0
    //   89: aload_1
    //   90: areturn
    //   91: astore_3
    //   92: aload_1
    //   93: astore_2
    //   94: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +81 -> 178
    //   100: aload_3
    //   101: astore_2
    //   102: ldc 27
    //   104: iconst_2
    //   105: ldc_w 974
    //   108: aload_2
    //   109: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_1
    //   113: areturn
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_2
    //   117: goto +64 -> 181
    //   120: astore 4
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: astore_2
    //   126: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +16 -> 145
    //   132: aload_1
    //   133: astore_2
    //   134: ldc 27
    //   136: iconst_2
    //   137: ldc_w 976
    //   140: aload 4
    //   142: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload 6
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull +29 -> 178
    //   152: aload_1
    //   153: invokeinterface 708 1 0
    //   158: aconst_null
    //   159: areturn
    //   160: astore_3
    //   161: aload 6
    //   163: astore_2
    //   164: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +11 -> 178
    //   170: aload 5
    //   172: astore_1
    //   173: aload_3
    //   174: astore_2
    //   175: goto -73 -> 102
    //   178: aload_2
    //   179: areturn
    //   180: astore_1
    //   181: aload_2
    //   182: ifnull +29 -> 211
    //   185: aload_2
    //   186: invokeinterface 708 1 0
    //   191: goto +20 -> 211
    //   194: astore_2
    //   195: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +13 -> 211
    //   201: ldc 27
    //   203: iconst_2
    //   204: ldc_w 974
    //   207: aload_2
    //   208: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: goto +5 -> 216
    //   214: aload_1
    //   215: athrow
    //   216: goto -2 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	ContactSyncServiceImpl
    //   0	219	1	paramUri	Uri
    //   18	168	2	localObject1	Object
    //   194	14	2	localThrowable1	Throwable
    //   10	74	3	localObject2	Object
    //   91	10	3	localThrowable2	Throwable
    //   160	14	3	localThrowable3	Throwable
    //   70	1	4	localException1	java.lang.Exception
    //   120	21	4	localException2	java.lang.Exception
    //   12	159	5	localObject3	Object
    //   15	147	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   48	57	70	java/lang/Exception
    //   59	67	70	java/lang/Exception
    //   83	89	91	java/lang/Throwable
    //   19	38	114	finally
    //   19	38	120	java/lang/Exception
    //   152	158	160	java/lang/Throwable
    //   48	57	180	finally
    //   59	67	180	finally
    //   126	132	180	finally
    //   134	145	180	finally
    //   185	191	194	java/lang/Throwable
  }
  
  /* Error */
  public String getMobileNoByJumpUri(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 316	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 322	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_3
    //   20: aload_1
    //   21: iconst_1
    //   22: anewarray 194	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 979
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_3
    //   38: aload_2
    //   39: astore_1
    //   40: aload_3
    //   41: ifnull +36 -> 77
    //   44: aload_2
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: invokeinterface 691 1 0
    //   54: ifeq +23 -> 77
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: iconst_0
    //   61: invokeinterface 695 2 0
    //   66: astore_1
    //   67: goto +10 -> 77
    //   70: astore 4
    //   72: aload_3
    //   73: astore_1
    //   74: goto +50 -> 124
    //   77: aload_1
    //   78: astore_2
    //   79: aload_3
    //   80: ifnull +98 -> 178
    //   83: aload_3
    //   84: invokeinterface 708 1 0
    //   89: aload_1
    //   90: areturn
    //   91: astore_3
    //   92: aload_1
    //   93: astore_2
    //   94: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +81 -> 178
    //   100: aload_3
    //   101: astore_2
    //   102: ldc 27
    //   104: iconst_2
    //   105: ldc_w 981
    //   108: aload_2
    //   109: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_1
    //   113: areturn
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_2
    //   117: goto +64 -> 181
    //   120: astore 4
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: astore_2
    //   126: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +16 -> 145
    //   132: aload_1
    //   133: astore_2
    //   134: ldc 27
    //   136: iconst_2
    //   137: ldc_w 983
    //   140: aload 4
    //   142: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload 6
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull +29 -> 178
    //   152: aload_1
    //   153: invokeinterface 708 1 0
    //   158: aconst_null
    //   159: areturn
    //   160: astore_3
    //   161: aload 6
    //   163: astore_2
    //   164: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +11 -> 178
    //   170: aload 5
    //   172: astore_1
    //   173: aload_3
    //   174: astore_2
    //   175: goto -73 -> 102
    //   178: aload_2
    //   179: areturn
    //   180: astore_1
    //   181: aload_2
    //   182: ifnull +29 -> 211
    //   185: aload_2
    //   186: invokeinterface 708 1 0
    //   191: goto +20 -> 211
    //   194: astore_2
    //   195: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +13 -> 211
    //   201: ldc 27
    //   203: iconst_2
    //   204: ldc_w 981
    //   207: aload_2
    //   208: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: goto +5 -> 216
    //   214: aload_1
    //   215: athrow
    //   216: goto -2 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	ContactSyncServiceImpl
    //   0	219	1	paramUri	Uri
    //   18	168	2	localObject1	Object
    //   194	14	2	localThrowable1	Throwable
    //   10	74	3	localObject2	Object
    //   91	10	3	localThrowable2	Throwable
    //   160	14	3	localThrowable3	Throwable
    //   70	1	4	localException1	java.lang.Exception
    //   120	21	4	localException2	java.lang.Exception
    //   12	159	5	localObject3	Object
    //   15	147	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   48	57	70	java/lang/Exception
    //   59	67	70	java/lang/Exception
    //   83	89	91	java/lang/Throwable
    //   19	38	114	finally
    //   19	38	120	java/lang/Exception
    //   152	158	160	java/lang/Throwable
    //   48	57	180	finally
    //   59	67	180	finally
    //   126	132	180	finally
    //   134	145	180	finally
    //   185	191	194	java/lang/Throwable
  }
  
  public String getNetworkDescription(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    String str2 = null;
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    int i = paramGetOnlineInfoResp.eNetworkType;
    paramGetOnlineInfoResp = "";
    String str1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              str1 = "";
              i = 0;
              break label236;
            }
            paramGetOnlineInfoResp = this.app.getApp().getApplicationContext().getString(2131699047);
            str1 = this.app.getApp().getApplicationContext().getString(2131699045);
          }
          else
          {
            paramGetOnlineInfoResp = this.app.getApp().getApplicationContext().getString(2131699047);
            str1 = this.app.getApp().getApplicationContext().getString(2131699044);
          }
        }
        else
        {
          paramGetOnlineInfoResp = this.app.getApp().getApplicationContext().getString(2131699047);
          str1 = this.app.getApp().getApplicationContext().getString(2131699043);
        }
      }
      else
      {
        paramGetOnlineInfoResp = this.app.getApp().getApplicationContext().getString(2131699046);
        str1 = this.app.getApp().getApplicationContext().getString(2131699042);
      }
    }
    else
    {
      paramGetOnlineInfoResp = this.app.getApp().getApplicationContext().getString(2131699047);
      str1 = this.app.getApp().getApplicationContext().getString(2131699048);
    }
    i = 1;
    label236:
    if (i != 0) {
      str2 = String.format(this.app.getApp().getApplicationContext().getResources().getString(2131698728), new Object[] { paramGetOnlineInfoResp, str1 });
    }
    return str2;
  }
  
  /* Error */
  public com.tencent.mobileqq.phonecontact.data.SimplePhoneContact getSimplePhoneContactByJumpUri(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 316	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 322	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 4
    //   15: aload 8
    //   17: aload_1
    //   18: iconst_1
    //   19: anewarray 194	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 1016
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +34 -> 70
    //   39: aload_1
    //   40: astore 4
    //   42: aload_1
    //   43: invokeinterface 691 1 0
    //   48: ifeq +22 -> 70
    //   51: aload_1
    //   52: astore 4
    //   54: aload_1
    //   55: iconst_0
    //   56: invokeinterface 702 2 0
    //   61: lstore_2
    //   62: goto +12 -> 74
    //   65: astore 5
    //   67: goto +63 -> 130
    //   70: ldc2_w 1017
    //   73: lstore_2
    //   74: aload_1
    //   75: ifnull +31 -> 106
    //   78: aload_1
    //   79: invokeinterface 708 1 0
    //   84: goto +22 -> 106
    //   87: astore 4
    //   89: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +14 -> 106
    //   95: ldc 27
    //   97: iconst_2
    //   98: ldc_w 1020
    //   101: aload 4
    //   103: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: goto +83 -> 189
    //   109: astore_1
    //   110: goto +10 -> 120
    //   113: astore 4
    //   115: goto +9 -> 124
    //   118: astore 5
    //   120: goto +587 -> 707
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_1
    //   126: aload 4
    //   128: astore 5
    //   130: aload_1
    //   131: astore 4
    //   133: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +17 -> 153
    //   139: aload_1
    //   140: astore 4
    //   142: ldc 27
    //   144: iconst_2
    //   145: ldc_w 1022
    //   148: aload 5
    //   150: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_1
    //   154: ifnull +31 -> 185
    //   157: aload_1
    //   158: invokeinterface 708 1 0
    //   163: goto +22 -> 185
    //   166: astore 4
    //   168: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +14 -> 185
    //   174: ldc 27
    //   176: iconst_2
    //   177: ldc_w 1020
    //   180: aload 4
    //   182: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: ldc2_w 1017
    //   188: lstore_2
    //   189: lload_2
    //   190: ldc2_w 1017
    //   193: lcmp
    //   194: ifne +5 -> 199
    //   197: aconst_null
    //   198: areturn
    //   199: new 1024	com/tencent/mobileqq/phonecontact/data/SimplePhoneContact
    //   202: dup
    //   203: invokespecial 1025	com/tencent/mobileqq/phonecontact/data/SimplePhoneContact:<init>	()V
    //   206: astore 7
    //   208: aload_1
    //   209: astore 4
    //   211: getstatic 918	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$DataQuery:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   214: astore 6
    //   216: aload_1
    //   217: astore 4
    //   219: getstatic 919	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$DataQuery:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   222: astore 9
    //   224: aload_1
    //   225: astore 5
    //   227: aload_1
    //   228: astore 4
    //   230: aload 8
    //   232: aload 6
    //   234: aload 9
    //   236: ldc_w 921
    //   239: iconst_1
    //   240: anewarray 194	java/lang/String
    //   243: dup
    //   244: iconst_0
    //   245: lload_2
    //   246: invokestatic 924	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   249: aastore
    //   250: aconst_null
    //   251: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   254: astore_1
    //   255: aload_1
    //   256: ifnull +58 -> 314
    //   259: aload_1
    //   260: astore 5
    //   262: aload_1
    //   263: astore 4
    //   265: aload_1
    //   266: invokeinterface 691 1 0
    //   271: ifeq +43 -> 314
    //   274: aload_1
    //   275: astore 5
    //   277: aload_1
    //   278: astore 4
    //   280: aload_1
    //   281: iconst_1
    //   282: invokeinterface 695 2 0
    //   287: ldc_w 926
    //   290: invokevirtual 412	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq -34 -> 259
    //   296: aload_1
    //   297: astore 5
    //   299: aload_1
    //   300: astore 4
    //   302: aload 7
    //   304: aload_1
    //   305: iconst_2
    //   306: invokeinterface 695 2 0
    //   311: putfield 1026	com/tencent/mobileqq/phonecontact/data/SimplePhoneContact:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   314: aload_1
    //   315: astore 4
    //   317: aload_1
    //   318: ifnull +113 -> 431
    //   321: aload_1
    //   322: invokeinterface 708 1 0
    //   327: aload_1
    //   328: astore 4
    //   330: goto +101 -> 431
    //   333: astore 5
    //   335: aload_1
    //   336: astore 4
    //   338: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +90 -> 431
    //   344: ldc 27
    //   346: iconst_2
    //   347: ldc_w 1028
    //   350: aload 5
    //   352: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   355: aload_1
    //   356: astore 4
    //   358: goto +73 -> 431
    //   361: astore 6
    //   363: aload 5
    //   365: astore_1
    //   366: goto +9 -> 375
    //   369: astore_1
    //   370: goto +300 -> 670
    //   373: astore 6
    //   375: aload_1
    //   376: astore 4
    //   378: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +17 -> 398
    //   384: aload_1
    //   385: astore 4
    //   387: ldc 27
    //   389: iconst_2
    //   390: ldc_w 1022
    //   393: aload 6
    //   395: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   398: aload_1
    //   399: astore 4
    //   401: aload_1
    //   402: ifnull +29 -> 431
    //   405: aload_1
    //   406: invokeinterface 708 1 0
    //   411: aload_1
    //   412: astore 4
    //   414: goto +17 -> 431
    //   417: astore 5
    //   419: aload_1
    //   420: astore 4
    //   422: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +6 -> 431
    //   428: goto -84 -> 344
    //   431: aload 4
    //   433: astore_1
    //   434: aload 8
    //   436: getstatic 468	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   439: getstatic 1030	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$RawQuery:b	[Ljava/lang/String;
    //   442: ldc_w 1032
    //   445: iconst_1
    //   446: anewarray 194	java/lang/String
    //   449: dup
    //   450: iconst_0
    //   451: lload_2
    //   452: invokestatic 924	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   455: aastore
    //   456: aconst_null
    //   457: invokevirtual 682	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   460: astore 5
    //   462: aload 5
    //   464: ifnull +80 -> 544
    //   467: aload 5
    //   469: astore_1
    //   470: aload 5
    //   472: astore 4
    //   474: aload 5
    //   476: invokeinterface 691 1 0
    //   481: ifeq +63 -> 544
    //   484: aload 5
    //   486: astore_1
    //   487: aload 5
    //   489: astore 4
    //   491: aload 7
    //   493: aload 5
    //   495: iconst_0
    //   496: invokeinterface 695 2 0
    //   501: putfield 1034	com/tencent/mobileqq/phonecontact/data/SimplePhoneContact:b	Ljava/lang/String;
    //   504: aload 5
    //   506: astore_1
    //   507: aload 5
    //   509: astore 4
    //   511: aload 7
    //   513: aload 5
    //   515: iconst_1
    //   516: invokeinterface 695 2 0
    //   521: putfield 1037	com/tencent/mobileqq/phonecontact/data/SimplePhoneContact:c	Ljava/lang/String;
    //   524: aload 5
    //   526: astore_1
    //   527: aload 5
    //   529: astore 4
    //   531: aload 7
    //   533: aload 5
    //   535: iconst_2
    //   536: invokeinterface 753 2 0
    //   541: putfield 1038	com/tencent/mobileqq/phonecontact/data/SimplePhoneContact:jdField_a_of_type_Int	I
    //   544: aload 5
    //   546: ifnull +88 -> 634
    //   549: aload 5
    //   551: invokeinterface 708 1 0
    //   556: aload 7
    //   558: areturn
    //   559: astore_1
    //   560: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   563: ifeq +71 -> 634
    //   566: ldc 27
    //   568: iconst_2
    //   569: ldc_w 1040
    //   572: aload_1
    //   573: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   576: aload 7
    //   578: areturn
    //   579: astore 4
    //   581: goto +56 -> 637
    //   584: astore 5
    //   586: aload 4
    //   588: astore_1
    //   589: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq +17 -> 609
    //   595: aload 4
    //   597: astore_1
    //   598: ldc 27
    //   600: iconst_2
    //   601: ldc_w 1022
    //   604: aload 5
    //   606: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   609: aload 4
    //   611: ifnull +23 -> 634
    //   614: aload 4
    //   616: invokeinterface 708 1 0
    //   621: aload 7
    //   623: areturn
    //   624: astore_1
    //   625: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +6 -> 634
    //   631: goto -65 -> 566
    //   634: aload 7
    //   636: areturn
    //   637: aload_1
    //   638: ifnull +29 -> 667
    //   641: aload_1
    //   642: invokeinterface 708 1 0
    //   647: goto +20 -> 667
    //   650: astore_1
    //   651: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq +13 -> 667
    //   657: ldc 27
    //   659: iconst_2
    //   660: ldc_w 1040
    //   663: aload_1
    //   664: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   667: aload 4
    //   669: athrow
    //   670: aload 4
    //   672: ifnull +32 -> 704
    //   675: aload 4
    //   677: invokeinterface 708 1 0
    //   682: goto +22 -> 704
    //   685: astore 4
    //   687: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +14 -> 704
    //   693: ldc 27
    //   695: iconst_2
    //   696: ldc_w 1028
    //   699: aload 4
    //   701: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   704: aload_1
    //   705: athrow
    //   706: astore_1
    //   707: aload 4
    //   709: ifnull +32 -> 741
    //   712: aload 4
    //   714: invokeinterface 708 1 0
    //   719: goto +22 -> 741
    //   722: astore 4
    //   724: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +14 -> 741
    //   730: ldc 27
    //   732: iconst_2
    //   733: ldc_w 1020
    //   736: aload 4
    //   738: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   741: goto +5 -> 746
    //   744: aload_1
    //   745: athrow
    //   746: goto -2 -> 744
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	this	ContactSyncServiceImpl
    //   0	749	1	paramUri	Uri
    //   61	13	2	l	long
    //   13	40	4	localUri	Uri
    //   87	15	4	localThrowable	Throwable
    //   113	1	4	localException1	java.lang.Exception
    //   65	1	5	localException2	java.lang.Exception
    //   10	6	8	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   42	51	65	java/lang/Exception
    //   54	62	65	java/lang/Exception
    //   78	84	87	java/lang/Throwable
    //   15	35	109	finally
    //   15	35	113	java/lang/Exception
    //   157	163	166	java/lang/Throwable
    //   321	327	333	java/lang/Throwable
    //   230	255	361	java/lang/Exception
    //   265	274	361	java/lang/Exception
    //   280	296	361	java/lang/Exception
    //   302	314	361	java/lang/Exception
    //   211	216	369	finally
    //   219	224	369	finally
    //   230	255	369	finally
    //   265	274	369	finally
    //   280	296	369	finally
    //   302	314	369	finally
    //   378	384	369	finally
    //   387	398	369	finally
    //   211	216	373	java/lang/Exception
    //   219	224	373	java/lang/Exception
    //   405	411	417	java/lang/Throwable
    //   549	556	559	java/lang/Throwable
    //   434	462	579	finally
    //   474	484	579	finally
    //   491	504	579	finally
    //   511	524	579	finally
    //   531	544	579	finally
    //   589	595	579	finally
    //   598	609	579	finally
    //   434	462	584	java/lang/Exception
    //   474	484	584	java/lang/Exception
    //   491	504	584	java/lang/Exception
    //   511	524	584	java/lang/Exception
    //   531	544	584	java/lang/Exception
    //   614	621	624	java/lang/Throwable
    //   641	647	650	java/lang/Throwable
    //   675	682	685	java/lang/Throwable
    //   42	51	706	finally
    //   54	62	706	finally
    //   133	139	706	finally
    //   142	153	706	finally
    //   712	719	722	java/lang/Throwable
  }
  
  public String getStatusDescription(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    long l = paramGetOnlineInfoResp.iTermType;
    if (paramGetOnlineInfoResp.iTermType != 67586L) {}
    int i = (int)paramGetOnlineInfoResp.dwStatus;
    if ((20 != i) && (21 != i) && (40 != i)) {}
    i = OnlineStatusUtils.a(i, (int)paramGetOnlineInfoResp.iTermType);
    if ((i != 0) && (i != 6)) {
      return paramGetOnlineInfoResp.strTermDesc;
    }
    return null;
  }
  
  public String getSyncAccountUin()
  {
    String str = getSyncAccountName();
    if (!TextUtils.isEmpty(str)) {
      return extraUin(str);
    }
    return null;
  }
  
  public boolean isSyncContactAllowed()
  {
    return this.isSyncSwitchOpen;
  }
  
  public boolean isSyncSupportForTheDevice()
  {
    String str = Build.MANUFACTURER;
    boolean bool2 = str.toLowerCase().contains("samsung");
    boolean bool1 = true;
    if (bool2)
    {
      if (!acquirePermissionForSamsung()) {
        bool1 = false;
      }
      return bool1;
    }
    return str.toLowerCase().contains("oppo") ^ true;
  }
  
  public void markAccountDeleteByUser(AppInterface paramAppInterface, Account paramAccount)
  {
    synchronized (accountSetIDel)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("markAccountDeleteByUser | accountSetIDel = ");
        localStringBuilder.append(accountSetIDel);
        localStringBuilder.append(" | name = ");
        localStringBuilder.append(paramAccount.name);
        localStringBuilder.append(" | contain = ");
        localStringBuilder.append(accountSetIDel.contains(paramAccount.name));
        QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
      }
      if (accountSetIDel.remove(paramAccount.name)) {
        return;
      }
      ??? = paramAppInterface.getApp().getSharedPreferences("contactsync", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pref_remove_account_prefix");
      localStringBuilder.append(paramAccount.name);
      ((SharedPreferences.Editor)???).putBoolean(localStringBuilder.toString(), true).apply();
      ??? = getService(paramAppInterface);
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      if ((!TextUtils.isEmpty(paramAppInterface)) && (paramAppInterface.equals(extraUin(paramAccount.name)))) {
        ((ContactSyncServiceImpl)???).hasIRemovedByUser = true;
      }
      ((ContactSyncServiceImpl)???).syncAccount = null;
      ((ContactSyncServiceImpl)???).waitDelAccount = false;
      return;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "ContactSyncManager onCreate");
    }
    this.app = ((AppInterface)paramAppRuntime);
    this.mAccountMgr = AccountManager.get(this.app.getApp());
    this.mPref = this.app.getApp().getSharedPreferences("contactsync", 0);
    this.isSyncSwitchOpen = this.mPref.getBoolean("pref_sync_contact", true);
    try
    {
      initSyncAccount();
      boolean bool = isSyncSupportForTheDevice();
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("ContactSyncManager oncreate | support = ");
        paramAppRuntime.append(bool);
        QLog.d("ContactSync.Manager", 2, paramAppRuntime.toString());
      }
      if (bool)
      {
        this.app.registObserver(this.contactOb);
      }
      else
      {
        this.mSyncAccountHandler.removeCallbacksAndMessages(null);
        this.mSyncAccountHandler.sendEmptyMessage(2);
      }
    }
    catch (Throwable paramAppRuntime)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "initSyncAccount e = ", paramAppRuntime);
      }
    }
    paramAppRuntime = this.mPref;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_remove_account_prefix");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    this.hasIRemovedByUser = paramAppRuntime.getBoolean(localStringBuilder.toString(), false);
  }
  
  public void onDestroy()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.refreshContactRunnable);
    this.app.unRegistObserver(this.contactOb);
  }
  
  public boolean onQQContactRefreshed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncBindContactList");
    }
    ThreadManager.getUIHandler().removeCallbacks(this.refreshContactRunnable);
    if (!this.isSyncing)
    {
      ThreadManager.executeOnNetWorkThread(new ContactSyncServiceImpl.2(this, paramInt));
    }
    else
    {
      this.refreshContactRunnable.a(paramInt);
      ThreadManager.getUIHandler().postDelayed(this.refreshContactRunnable, 30000L);
    }
    return true;
  }
  
  public void setSyncContactAllowed(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSyncContactAllowed | allow = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
    }
    this.isSyncSwitchOpen = paramBoolean;
    this.mPref.edit().putBoolean("pref_sync_contact", paramBoolean).commit();
    if (paramBoolean)
    {
      this.waitDelAccount = false;
      this.mSyncAccountHandler.removeCallbacksAndMessages(null);
      this.mSyncAccountHandler.sendEmptyMessage(1);
      return;
    }
    if (this.isSyncing)
    {
      this.waitDelAccount = true;
      return;
    }
    this.waitDelAccount = false;
    this.mSyncAccountHandler.removeCallbacksAndMessages(null);
    this.mSyncAccountHandler.sendEmptyMessage(2);
  }
  
  public boolean syncAllContacts(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncAllContacts | isSyncing = ");
      localStringBuilder.append(this.isSyncing);
      localStringBuilder.append(" syncFrom = ");
      localStringBuilder.append(paramInt);
      QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
    }
    if (!this.isSyncing)
    {
      if (!couldSyncContact()) {
        return false;
      }
      this.isSyncing = true;
      ThreadManager.getUIHandler().removeCallbacks(this.refreshContactRunnable);
      boolean bool = doSyncContacts(getQQContacts(), paramInt);
      if (this.waitDelAccount)
      {
        this.mSyncAccountHandler.removeCallbacksAndMessages(null);
        this.mSyncAccountHandler.sendEmptyMessage(2);
        this.waitDelAccount = false;
      }
      this.isSyncing = false;
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl
 * JD-Core Version:    0.7.0.1
 */