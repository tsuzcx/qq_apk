package com.tencent.mobileqq.extendfriend;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.LruCache;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerConfBean;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerConfBean.BannerItem;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerProcessor;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.bean.ChatFriendInfo;
import com.tencent.mobileqq.extendfriend.bean.ExtendFriendLocationInfo;
import com.tencent.mobileqq.extendfriend.bean.ExtendFriendSignalBombCardData;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.fragment.CacheData;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchHistoryManager;
import com.tencent.mobileqq.extendfriend.limitchat.CompletePesonalDataTask;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatResourceUtil;
import com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper;
import com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendGetLocationListener;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import cooperation.plugin.IPluginManager;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SearchKeyWord;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.matchTaskInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.oneTask;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.matchTaskInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.oneTask;
import tencent.im.usercategory.ExtendFriendUserCategory.ForbiddenInfo;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

public class ExtendFriendManager
  implements ExtendFriendResourceDownloader.ResourceDownloaderListener, Manager
{
  public static CacheData a;
  public static final String a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private LruCache<String, ExtendFriendUserInfo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExpandResourceDownloader jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader;
  private ExtendFriendResourceDownloader jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader;
  private ExpandConfigManager jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager;
  private ExtendFriendSearchHistoryManager jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager;
  private ExpandCmdHandler jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendManager.2(this);
  private ColdPalaceHelper jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsColdPalaceHelper;
  private ExpandChatRepository jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private SchoolInfo jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new ExtendFriendManager.1(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<CompletePesonalDataTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oidb_0xdb1.SchoolInfo jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ExtendFriendSearchHistoryManager jdField_b_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager;
  public String b;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<ExtendFriendSignalBombCardData> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = "";
  private volatile boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private volatile long jdField_e_of_type_Long = 0L;
  private String jdField_e_of_type_JavaLangString = "";
  private volatile boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private String jdField_f_of_type_JavaLangString = "";
  private volatile boolean jdField_f_of_type_Boolean = false;
  private String g = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131704295);
    ExpandReportUtils.a();
    QLog.i("ExtendFriendManager", 1, "init expand tunnel");
  }
  
  public ExtendFriendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository = new ExpandChatRepository(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler = new ExpandCmdHandler();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager = new ExpandConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader = new ExtendFriendResourceDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager = new ExtendFriendSearchHistoryManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager = new ExtendFriendSearchHistoryManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsColdPalaceHelper = new ColdPalaceHelper(paramQQAppInterface);
    ThreadManager.postImmediately(new ExtendFriendManager.3(this), null, true);
  }
  
  private static int a(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (paramQQAppInterface != null) {
      i = SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_forbid_flag", 0);
    }
    return i;
  }
  
  private static long a(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    if (paramQQAppInterface != null) {
      l = SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getLong("sp_extend_friend_forbid_end_time", 0L);
    }
    return l;
  }
  
  public static SpannableStringBuilder a(Activity paramActivity, String paramString, boolean paramBoolean, long paramLong)
  {
    paramString = new SpannableStringBuilder(paramString);
    if (paramBoolean) {
      return paramString;
    }
    paramString.append("\n");
    Object localObject1 = new SpannableString("图");
    int i = ViewUtils.a(20.0F);
    Object localObject2 = paramActivity.getResources().getDrawable(2130841558);
    ((Drawable)localObject2).setBounds(0, 0, i, i);
    ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), 0, ((SpannableString)localObject1).length(), 17);
    paramString.append((CharSequence)localObject1);
    paramString.append(" ");
    localObject1 = paramActivity.getString(2131698745);
    localObject2 = a(paramActivity, paramLong);
    paramActivity = String.format(" %s ", new Object[] { ((ArrayList)localObject2).get(0) });
    localObject2 = (String)((ArrayList)localObject2).get(1);
    localObject2 = new SpannableString((String)localObject1 + paramActivity + (String)localObject2);
    ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(14, true), 0, ((SpannableString)localObject2).length(), 17);
    ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#878B99")), 0, ((SpannableString)localObject2).length(), 17);
    i = ((String)localObject1).length();
    int j = ((String)localObject1).length() + paramActivity.length();
    ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(24, true), i, j, 33);
    ((SpannableString)localObject2).setSpan(new StyleSpan(1), i, j, 33);
    paramString.append((CharSequence)localObject2);
    return paramString;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static ArrayList<String> a(Activity paramActivity, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramLong > 86400L)
    {
      localArrayList.add(String.valueOf((paramLong + 86400L - 1L) / 86400L));
      localArrayList.add(paramActivity.getString(2131691529));
      return localArrayList;
    }
    if (paramLong > 3600L)
    {
      localArrayList.add(String.valueOf((paramLong + 3600L - 1L) / 3600L));
      localArrayList.add(paramActivity.getString(2131693277));
      return localArrayList;
    }
    if (paramLong > 60L)
    {
      localArrayList.add(String.valueOf((paramLong + 60L - 1L) / 60L));
      localArrayList.add(paramActivity.getString(2131694224));
      return localArrayList;
    }
    if (paramLong > 0L)
    {
      localArrayList.add(String.valueOf(paramLong));
      localArrayList.add(paramActivity.getString(2131718936));
      return localArrayList;
    }
    localArrayList.add(String.valueOf(0));
    localArrayList.add(paramActivity.getString(2131718936));
    return localArrayList;
  }
  
  private JSONObject a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramAppInfo.buffer.has())
        {
          paramAppInfo = paramAppInfo.buffer.get();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "TianShuBufferJsonStr = " + paramAppInfo);
          }
          if (!TextUtils.isEmpty(paramAppInfo))
          {
            paramAppInfo = new JSONObject(paramAppInfo);
            String str = paramAppInfo.optString("_show_mission");
            if (!TextUtils.isEmpty(str))
            {
              paramAppInfo = new JSONObject(paramAppInfo.optJSONObject("msg").optJSONObject(str).optString("src"));
              return paramAppInfo;
            }
          }
        }
      }
      catch (Throwable paramAppInfo)
      {
        QLog.e("ExtendFriendManager", 1, "getTianShuSrcInfo() JSONException ", paramAppInfo);
      }
    }
    return null;
  }
  
  private void a(Context paramContext, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    if (paramExtendFriendGetLocationListener == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync start");
    }
    if ((!NetworkUtil.d(paramContext)) || (!SignalBombHelper.a()))
    {
      a(false, null, paramExtendFriendGetLocationListener);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.jdField_e_of_type_Long < 3600000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync get cache");
      }
      paramContext = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
      if ((paramContext != null) && (paramContext.mLocation != null))
      {
        a(true, paramContext, paramExtendFriendGetLocationListener);
        return;
      }
    }
    this.jdField_e_of_type_Long = l;
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new ExtendFriendManager.11(this, "extend_friend", false, paramExtendFriendGetLocationListener));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit();
      paramQQAppInterface.putInt("sp_extend_friend_forbid_flag", paramInt);
      paramQQAppInterface.putLong("sp_extend_friend_forbid_end_time", paramLong);
      paramQQAppInterface.commit();
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("setAnswerQuestionFlag, uin: %s, flag: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    SharedPreUtils.g(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
  
  private void a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    int j = 0;
    if (paramSchoolInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = new SchoolInfo();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
      int i;
      if (paramSchoolInfo.uint32_idx.has())
      {
        i = paramSchoolInfo.uint32_idx.get();
        ((SchoolInfo)localObject).jdField_a_of_type_Int = i;
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
        i = j;
        if (paramSchoolInfo.uint32_category.has()) {
          i = paramSchoolInfo.uint32_category.get();
        }
        ((SchoolInfo)localObject).jdField_b_of_type_Int = i;
        SchoolInfo localSchoolInfo = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
        if (!paramSchoolInfo.str_school_id.has()) {
          break label147;
        }
        localObject = paramSchoolInfo.str_school_id.get();
        label104:
        localSchoolInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
        if (!paramSchoolInfo.str_school_name.has()) {
          break label154;
        }
      }
      label147:
      label154:
      for (paramSchoolInfo = paramSchoolInfo.str_school_name.get();; paramSchoolInfo = "")
      {
        ((SchoolInfo)localObject).jdField_b_of_type_JavaLangString = paramSchoolInfo;
        return;
        i = 0;
        break;
        localObject = "";
        break label104;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = null;
  }
  
  private void a(boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    paramExtendFriendGetLocationListener.a(paramBoolean, ExtendFriendLocationInfo.a(paramSosoLbsInfo));
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramQQAppInterface == null) || (paramBaseActivity.isFinishing())) {}
    int i;
    do
    {
      return false;
      i = a(paramQQAppInterface);
    } while (i == 0);
    long l = a(paramQQAppInterface) - NetConnInfoCenter.getServerTime();
    if ((i != 1) || (l > 8640000L)) {}
    for (boolean bool = true; (bool) || (l > 0L); bool = false)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramBaseActivity, 230);
      SpannableStringBuilder localSpannableStringBuilder = a(paramBaseActivity, paramBaseActivity.getString(2131698744), bool, l);
      localQQCustomDialog.setTitle(paramBaseActivity.getString(2131698746)).setMessage(localSpannableStringBuilder).setPositiveButton(paramBaseActivity.getString(2131698743), new ExtendFriendManager.14(paramBaseActivity)).setOnKeyListener(new ExtendFriendManager.13(paramBaseActivity));
      localQQCustomDialog.show();
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B076", "0X800B076", (int)(l / 86400L), 0, "", "", "", "");
      return true;
    }
    a(paramQQAppInterface, 0, 0L);
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = SharedPreUtils.g(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "needAnswerQuestion: " + bool);
    }
    return bool;
  }
  
  private void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit_days", String.valueOf(paramInt));
    ExpandReportUtils.a("success#limit_done#view", true, localHashMap);
  }
  
  private void f(boolean paramBoolean)
  {
    ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void g(boolean paramBoolean)
  {
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_is_user_student", paramBoolean).commit();
  }
  
  private void h(boolean paramBoolean)
  {
    QLog.i("ExtendFriendManager", 2, "setExtendFriendUsing o " + paramBoolean);
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_c_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_is_user_student", false);
    }
  }
  
  private void k()
  {
    if (!NetworkUtil.h(BaseApplicationImpl.getContext()))
    {
      QLog.i("ExtendFriendManager", 1, "preDownloadExpandPlugin(): won't preload plugin, wifi not connected!");
      return;
    }
    if (!QFlutterResConfigProcessor.a().a("ExpandShadowPlugin"))
    {
      QLog.i("ExtendFriendManager", 1, "preDownloadExpandPlugin(): manage system won't allow preload expand plugin!");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.e("ExtendFriendManager", 1, "preDownloadExpandPlugin: app is null!");
      return;
    }
    localObject = (IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN);
    if (localObject == null)
    {
      QLog.e("ExtendFriendManager", 1, "preDownloadExpandPlugin: IPluginManager is null!");
      return;
    }
    QLog.d("ExtendFriendManager", 1, "preDownloadExpandPlugin: start IPluginManager::preDownloadPlugin... !!");
    ((IPluginManager)localObject).a("expand", new ExtendFriendManager.5(this), "extend_friend_manager");
  }
  
  private void l()
  {
    ThreadManager.getUIHandlerV2().postDelayed(new ExtendFriendManager.6(this), TimeUnit.SECONDS.toMillis(10L));
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() }));
    }
    ExtendFriendConfig localExtendFriendConfig;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.b())
    {
      localExtendFriendConfig = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a();
      if (localExtendFriendConfig == null) {
        QLog.e("ExtendFriendManager", 1, "you should not be here!");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader = new ExpandResourceDownloader(a(), localExtendFriendConfig.jdField_p_of_type_JavaLangString, localExtendFriendConfig.q, new ExtendFriendManager.7(this));
      if ((!b()) && (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader.a())) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader.a();
      }
      l();
      label136:
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader != null)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().j);
          if (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a();
            b(false);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
            return;
            if (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.c()) {
              break label136;
            }
            k();
            break label136;
            b(true);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("ExtendFriendManager", 1, "checkToDownloadResource fail.", localException);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() == null)
    {
      QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig is null", new Object[0]));
      return;
    }
    QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mDownloader is null", new Object[0]));
  }
  
  private void n()
  {
    String str = ExtendFriendResourceUtil.a("expand_question_dialog.png");
    File localFile = new File(str);
    boolean bool = localFile.exists();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("downloadQuestionRes, filePath:%s, isExist:%s", new Object[] { str, Boolean.valueOf(bool) }));
    }
    if (bool) {}
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().l))) {
        break label158;
      }
      i = DownloaderFactory.a(new DownloadTask(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().l, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
    return;
    QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i) }));
    return;
    label158:
    QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (localCard != null)
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            continue;
          }
          bool1 = true;
          boolean bool2 = localCard.isShowCard;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData profileComplete=%s showCard=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if (jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData != null)
          {
            jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_a_of_type_Boolean = bool1;
            jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_b_of_type_Boolean = bool2;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData }));
      }
      return;
      bool1 = false;
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ExtendFriendManager", 2, "checkFirstEnterExtendFriendEveryDay : mApp is null!");
      return;
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = localSharedPreferences.getLong("sp_extend_friend_first_enter_everyday", 0L);
    long l2 = MessageCache.a();
    boolean bool = false;
    if (l2 - l1 > 86400L) {
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        localSharedPreferences.edit().putLong("sp_extend_friend_first_enter_everyday", l2).remove("sp_extend_friend_signal_everyday_report_" + l1).commit();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ExtendFriendManager", 2, "checkFirstEnterExtendFriendEveryDay first:" + l1 + " current:" + l2 + " isFirstTimeToday:" + bool);
      return;
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(1000L * l1);
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(1000L * l2);
      if (localCalendar1.get(6) != localCalendar2.get(6)) {
        bool = true;
      }
    }
  }
  
  private void q()
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = localSharedPreferences.getLong("sp_extend_friend_first_enter_everyday", 0L);
    if (l1 > 0L)
    {
      String str = "sp_extend_friend_signal_everyday_report_" + l1;
      boolean bool = localSharedPreferences.getBoolean(str, false);
      if (!bool)
      {
        long l2 = MessageCache.a();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE99", "0X800AE99", 0, 0, String.valueOf(l2 - l1), "", "", "");
        localSharedPreferences.edit().putBoolean(str, true).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "checkReportForFirstReceiveCardEveryDay " + l1 + " " + bool);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(String paramString)
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getInt(paramString, 0);
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public ExtendFriendUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      return null;
    }
    return (ExtendFriendUserInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExtendFriendUserInfo.class, paramString);
  }
  
  public ExtendFriendUserInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("ExtendFriendManager", 1, "getExtendFriendUserInfoCache but uin is empty");
      localObject = null;
    }
    ExtendFriendUserInfo localExtendFriendUserInfo;
    do
    {
      do
      {
        do
        {
          return localObject;
          localExtendFriendUserInfo = (ExtendFriendUserInfo)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
          localObject = localExtendFriendUserInfo;
        } while (localExtendFriendUserInfo != null);
        localObject = localExtendFriendUserInfo;
      } while (!paramBoolean);
      localExtendFriendUserInfo = a(paramString);
      localObject = localExtendFriendUserInfo;
    } while (localExtendFriendUserInfo == null);
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localExtendFriendUserInfo);
    return localExtendFriendUserInfo;
  }
  
  public ExtendFriendLocationInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync: mApp is null!");
      return null;
    }
    Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
    if (localObject != null) {}
    for (localObject = ExtendFriendLocationInfo.a((SosoLbsInfo)localObject);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync " + localObject);
      }
      long l = System.currentTimeMillis();
      if ((NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext())) && (SignalBombHelper.a()) && (l - this.jdField_e_of_type_Long > 3600000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync start");
        }
        this.jdField_e_of_type_Long = l;
        ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.12(this));
      }
      return localObject;
    }
  }
  
  public ExtendFriendSignalBombCardData a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break label162;
      }
      long l = MessageCache.a();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ExtendFriendSignalBombCardData localExtendFriendSignalBombCardData2 = (ExtendFriendSignalBombCardData)localIterator.next();
        if (l - localExtendFriendSignalBombCardData2.jdField_a_of_type_Long > 86400L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "checkAndGetLatestSignalBombCardData remove timeout data " + localExtendFriendSignalBombCardData2.jdField_a_of_type_JavaLangString);
          }
          localIterator.remove();
        }
      }
    }
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      ExtendFriendSignalBombCardData localExtendFriendSignalBombCardData1 = (ExtendFriendSignalBombCardData)this.jdField_b_of_type_JavaUtilList.remove(0);
      return localExtendFriendSignalBombCardData1;
    }
    label162:
    return null;
  }
  
  public ExpandConfigManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager;
  }
  
  @Nullable
  public ExtendFriendConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a();
  }
  
  public ExtendFriendSearchHistoryManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager;
  }
  
  public ExpandCmdHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler;
  }
  
  public ColdPalaceHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsColdPalaceHelper;
  }
  
  public ExpandChatRepository a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository;
  }
  
  public SchoolInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public ArrayList<ExtendFriendBannerConfBean.BannerItem> a()
  {
    return ExtendFriendBannerProcessor.a().a();
  }
  
  public List<CompletePesonalDataTask> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<String> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ExtendFriendManager", 2, String.format("getDefaultTags app is null check here!", new Object[0]));
        }
        return localArrayList;
      }
      String[] arrayOfString = QZoneUnreadServletLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("getDefaultTags campusHotTags=%s", new Object[] { Arrays.toString(arrayOfString) }));
      }
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(Arrays.asList(arrayOfString));
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 10);
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
    for (;;)
    {
      localArrayList.add(0, jdField_a_of_type_JavaLangString);
      return localArrayList;
      paramInt = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
  }
  
  public void a()
  {
    this.jdField_c_of_type_Long += 1L;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "increaseMatchedCount matchedCount = " + this.jdField_c_of_type_Long);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCampusCertificateStatus campusCertificateStatus = " + this.jdField_e_of_type_Int + ",new status = " + paramInt1);
    }
    this.jdField_e_of_type_Int = paramInt1;
    CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCurExtendFriendSchoolInfo ,idx = " + paramInt1 + ",schoolName = " + paramString1 + ",schoolId = " + paramString2 + ",schoolCategory = " + paramInt2);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = new SchoolInfo();
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.8(this));
  }
  
  public void a(SharedPreferences paramSharedPreferences)
  {
    try
    {
      long l1 = paramSharedPreferences.getLong("sp_extend_forbidden_update_time", 0L);
      long l2 = ((System.currentTimeMillis() - l1) / 1000L + 3600 - 1L) / 3600;
      QLog.d("ExtendFriendManager", 1, "update time " + l1 + " pass time " + l2);
      if (l2 >= 2L) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.c();
      }
      return;
    }
    catch (Exception paramSharedPreferences)
    {
      QLog.e("ExtendFriendManager", 1, "checkForbiddenUpdate e " + paramSharedPreferences.getMessage());
    }
  }
  
  public void a(ExtendFriendUserInfo paramExtendFriendUserInfo)
  {
    if ((paramExtendFriendUserInfo == null) || (TextUtils.isEmpty(paramExtendFriendUserInfo.uin))) {
      QLog.w("ExtendFriendManager", 1, "updateExtendFriendUserInfo but extendFriendUserInfo is empty");
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidUtilLruCache.put(paramExtendFriendUserInfo.uin, paramExtendFriendUserInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
      {
        if (paramExtendFriendUserInfo.getStatus() != 1000) {
          break label105;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramExtendFriendUserInfo);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ExtendFriendManager", 2, "updateExtendFriendUserInfo " + paramExtendFriendUserInfo);
        return;
        label105:
        if (paramExtendFriendUserInfo.getStatus() == 1001) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramExtendFriendUserInfo);
        }
      }
    }
  }
  
  public void a(ExtendFriendSignalBombCardData paramExtendFriendSignalBombCardData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "addExtendFriendSignalBombCardData " + paramExtendFriendSignalBombCardData);
    }
    if (paramExtendFriendSignalBombCardData != null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_JavaUtilList == null) {
          this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
        }
        this.jdField_b_of_type_JavaUtilList.add(0, paramExtendFriendSignalBombCardData);
        return;
      }
    }
  }
  
  public void a(MatchInfo paramMatchInfo)
  {
    if (paramMatchInfo == null)
    {
      QLog.e("ExtendFriendManager", 2, "updateSignalBombPush : matchInfo is null!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ExtendFriendManager", 2, "updateSignalBombPush : mApp is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_ArrayOfByte);
    Object localObject2;
    String str;
    Object localObject1;
    label212:
    int j;
    boolean bool;
    if (m())
    {
      a(ExtendFriendSignalBombCardData.a(paramMatchInfo));
      if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = paramMatchInfo.jdField_b_of_type_JavaLangString;
        i = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.g;
        if (this.jdField_c_of_type_Boolean)
        {
          localObject1 = "1";
          ReportController.b((AppRuntime)localObject2, "dc00898", "", str, "0X800AE9A", "0X800AE9A", i, 0, "", (String)localObject1, paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.j, paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.k);
        }
      }
      else
      {
        q();
      }
    }
    else
    {
      LimitChatUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString);
      LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString, 1044);
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramMatchInfo.jdField_b_of_type_JavaLangString)) {
        break label300;
      }
      LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo, paramMatchInfo.jdField_a_of_type_Long, 1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = paramMatchInfo.jdField_b_of_type_JavaLangString;
      j = paramMatchInfo.jdField_b_of_type_Int;
      str = paramMatchInfo.jdField_f_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramMatchInfo.jdField_c_of_type_JavaLangString)) {
        break label312;
      }
      bool = true;
      label248:
      if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo == null) {
        break label318;
      }
    }
    label300:
    label312:
    label318:
    for (int i = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_Int;; i = -1)
    {
      LimitChatUtil.a((QQAppInterface)localObject1, (String)localObject2, j, str, bool, i, true, 4);
      ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString, true);
      return;
      localObject1 = "2";
      break;
      QLog.d("ExtendFriendManager", 1, "updateSignalBombPush already friend.");
      break label212;
      bool = false;
      break label248;
    }
  }
  
  @WorkerThread
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("updateTianShuWaveStatus iNewFlag: %d , exposure_max: %d", new Object[] { Integer.valueOf(paramAppInfo.iNewFlag.get()), Integer.valueOf(paramAppInfo.exposure_max.get()) }));
    }
    if ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0))
    {
      this.jdField_e_of_type_JavaLangString = "";
      return;
    }
    paramAppInfo = a(paramAppInfo);
    if (paramAppInfo != null) {
      try
      {
        this.jdField_e_of_type_JavaLangString = paramAppInfo.optJSONObject("waves").optString("waves_type");
        QLog.i("ExtendFriendManager", 1, "TianShuSrcInfo: " + paramAppInfo.toString());
        return;
      }
      catch (Throwable paramAppInfo)
      {
        QLog.e("ExtendFriendManager", 1, "updateTianShuWaveStatus() JSONException ", paramAppInfo);
      }
    }
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_0xdb1.RspBody paramRspBody)
  {
    Object localObject2 = "";
    int k = 0;
    int j;
    String str1;
    label45:
    int i;
    label62:
    label89:
    boolean bool;
    label98:
    String str2;
    label131:
    label140:
    label167:
    label191:
    Object localObject1;
    label219:
    label253:
    ArrayList localArrayList;
    label290:
    label329:
    label347:
    Iterator localIterator;
    if (paramRspBody.enum_school_verify_status.has())
    {
      j = paramRspBody.enum_school_verify_status.get();
      if (!paramRspBody.str_school_verify_tips.has()) {
        break label459;
      }
      str1 = paramRspBody.str_school_verify_tips.get();
      this.g = str1;
      if (!TextUtils.isEmpty(str1)) {
        break label466;
      }
      i = 1;
      a(j, i);
      if (!paramRspBody.uint32_user_identity.has()) {
        break label472;
      }
      i = paramRspBody.uint32_user_identity.get();
      if (i != 1) {
        break label478;
      }
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      g(this.jdField_c_of_type_Boolean);
      if (!paramRspBody.uint32_need_display_school_info.has()) {
        break label484;
      }
      i = paramRspBody.uint32_need_display_school_info.get();
      if (i != 1) {
        break label490;
      }
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!paramRspBody.msg_new_school_info.has()) {
        break label496;
      }
      paramFromServiceMsg = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_new_school_info.get();
      this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo = paramFromServiceMsg;
      if (!paramRspBody.str_suggest_school_name.has()) {
        break label501;
      }
      str2 = paramRspBody.str_suggest_school_name.get();
      this.jdField_f_of_type_JavaLangString = str2;
      if (!paramRspBody.msg_kuolie_school_info.has()) {
        break label508;
      }
      localObject1 = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_kuolie_school_info.get();
      a((oidb_0xdb1.SchoolInfo)localObject1);
      paramFromServiceMsg = (FromServiceMsg)localObject2;
      if (localObject1 != null)
      {
        if (!((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.has()) {
          break label514;
        }
        paramFromServiceMsg = ((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.get();
      }
      i = k;
      if (paramToServiceMsg.extraData.getBoolean("key_need_get_online_number", false))
      {
        if (!paramRspBody.uint32_online_num.has()) {
          break label520;
        }
        i = paramRspBody.uint32_online_num.get();
      }
      this.jdField_b_of_type_Int = i;
      if (!paramToServiceMsg.extraData.getBoolean("key_need_get_search_keywords", false)) {
        break label637;
      }
      if (!paramRspBody.msg_campus_search_keywords.has()) {
        break label526;
      }
      localObject1 = paramRspBody.msg_campus_search_keywords.get();
      if (!paramRspBody.msg_voice_search_keywords.has()) {
        break label532;
      }
      paramToServiceMsg = paramRspBody.msg_voice_search_keywords.get();
      localObject2 = new ArrayList();
      localArrayList = new ArrayList();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label544;
      }
      localIterator = ((List)localObject1).iterator();
    }
    label389:
    label520:
    label526:
    label532:
    label542:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label544;
      }
      localObject1 = (oidb_0xdb1.SearchKeyWord)localIterator.next();
      if (((oidb_0xdb1.SearchKeyWord)localObject1).str_school_name.has()) {}
      for (localObject1 = ((oidb_0xdb1.SearchKeyWord)localObject1).str_school_name.get();; localObject1 = "")
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label542;
        }
        ((List)localObject2).add(localObject1);
        break label389;
        j = 0;
        break;
        label459:
        str1 = "";
        break label45;
        label466:
        i = 2;
        break label62;
        label472:
        i = 0;
        break label89;
        label478:
        bool = false;
        break label98;
        label484:
        i = 0;
        break label131;
        label490:
        bool = false;
        break label140;
        label496:
        paramFromServiceMsg = null;
        break label167;
        label501:
        str2 = "";
        break label191;
        label508:
        localObject1 = null;
        break label219;
        paramFromServiceMsg = "";
        break label253;
        i = 0;
        break label290;
        localObject1 = null;
        break label329;
        paramToServiceMsg = null;
        break label347;
      }
    }
    label514:
    label544:
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
    {
      localObject1 = paramToServiceMsg.iterator();
      label627:
      while (((Iterator)localObject1).hasNext())
      {
        paramToServiceMsg = (oidb_0xdb1.SearchKeyWord)((Iterator)localObject1).next();
        if (paramToServiceMsg.str_school_name.has()) {}
        for (paramToServiceMsg = paramToServiceMsg.str_school_name.get();; paramToServiceMsg = "")
        {
          if (TextUtils.isEmpty(paramToServiceMsg)) {
            break label627;
          }
          localArrayList.add(paramToServiceMsg);
          break;
        }
      }
    }
    a((List)localObject2, localArrayList);
    label637:
    long l;
    if (paramRspBody.uint32_forbid_flag.has())
    {
      k = paramRspBody.uint32_forbid_flag.get();
      if (!paramRspBody.uint32_forbid_end_time.has()) {
        break label882;
      }
      l = paramRspBody.uint32_forbid_end_time.get();
      label675:
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, l);
      if (!paramRspBody.bytes_birthday.has()) {
        break label888;
      }
    }
    label882:
    label888:
    for (int m = ByteBuffer.wrap(paramRspBody.bytes_birthday.get().toByteArray()).getInt();; m = 0)
    {
      this.jdField_c_of_type_Int = m;
      a(paramRspBody);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "handleGetExtendFriendPermissionAndStatusResponse. ,verifyStatus = " + j + ",verifyTips = " + str1 + ",serverSuggestSchoolName = " + str2 + ",schoolNameInExtendFriendCard = " + paramFromServiceMsg + ",onlineNumber = " + i + ",needShowEduBackgroundUpdateDialog = " + this.jdField_b_of_type_Boolean + ",profileNewSchoolInfo = " + this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo + ",isUserStudentOrNot = " + this.jdField_c_of_type_Boolean + ",userBirthday = " + this.jdField_c_of_type_Int + ",forbidFlag = " + k + ",forbidEndTime = " + l);
      }
      return;
      k = 0;
      break;
      l = 0L;
      break label675;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit().putInt(paramString, paramInt).apply();
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    ExtendFriendUserInfo localExtendFriendUserInfo2 = a(paramString, true);
    ExtendFriendUserInfo localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
    if (localExtendFriendUserInfo2 == null) {
      localExtendFriendUserInfo1 = new ExtendFriendUserInfo();
    }
    localExtendFriendUserInfo1.uin = paramString;
    localExtendFriendUserInfo1.fromType = paramBundle.getInt("fromType", 3);
    a(localExtendFriendUserInfo1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getUnlimitMatchUserInfo() uin = " + paramString1 + " matchUin = " + paramString2 + "uinType=" + paramInt);
    }
    ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramString1, paramString2, paramInt);
  }
  
  public void a(List<String> paramList1, List<String> paramList2)
  {
    if (paramList2 != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList2);
    }
  }
  
  public void a(oidb_0xdb1.RspBody paramRspBody)
  {
    long l2 = 0L;
    long l1;
    if (paramRspBody.uint64_max_match_times.has())
    {
      l1 = paramRspBody.uint64_max_match_times.get();
      this.jdField_b_of_type_Long = l1;
      l1 = l2;
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.jdField_c_of_type_Long = l1;
      if (!paramRspBody.msg_task_info.has()) {
        break label574;
      }
    }
    label574:
    for (paramRspBody = (oidb_0xdb1.matchTaskInfo)paramRspBody.msg_task_info.get();; paramRspBody = null)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramRspBody != null)
      {
        CompletePesonalDataTask localCompletePesonalDataTask;
        if (paramRspBody.msg_base_info.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 1;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_base_info.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_base_info.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_base_info.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_kuolie_school.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 2;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_school.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_kuolie_declaration.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 3;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_declaration.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_personal_label.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 4;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_personal_label.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_personal_label.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_personal_label.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_photo.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 5;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_photo.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_photo.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_photo.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "updateMatchChatCompletePersonalDataTaskBy0xdb1 ,maxMatchCount" + this.jdField_b_of_type_Long + ",matchedCount" + this.jdField_c_of_type_Long + ",completePesonalDataTasks" + this.jdField_a_of_type_JavaUtilList);
      }
      return;
      l1 = 0L;
      break;
    }
  }
  
  public void a(oidb_0xe03.RspBody paramRspBody)
  {
    long l1 = 0L;
    int i;
    long l2;
    if (paramRspBody.enum_matchopretcode.has())
    {
      i = paramRspBody.enum_matchopretcode.get();
      if (12 != i) {
        break label617;
      }
      if (!paramRspBody.uint64_max_match_times.has()) {
        break label606;
      }
      l2 = paramRspBody.uint64_max_match_times.get();
      label45:
      this.jdField_b_of_type_Long = l2;
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.jdField_c_of_type_Long = l1;
      if (!paramRspBody.msg_task_info.has()) {
        break label612;
      }
      paramRspBody = (oidb_0xe03.matchTaskInfo)paramRspBody.msg_task_info.get();
      label95:
      ArrayList localArrayList = new ArrayList();
      if (paramRspBody != null)
      {
        CompletePesonalDataTask localCompletePesonalDataTask;
        if (paramRspBody.msg_base_info.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 1;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_base_info.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_base_info.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_base_info.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_kuolie_school.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 2;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_school.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_kuolie_school.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_kuolie_declaration.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 3;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_kuolie_declaration.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_kuolie_declaration.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_personal_label.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 4;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_personal_label.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_personal_label.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_personal_label.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_photo.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.jdField_a_of_type_Int = 5;
          localCompletePesonalDataTask.jdField_b_of_type_Int = paramRspBody.msg_photo.uint32_task_match_times.get();
          localCompletePesonalDataTask.jdField_a_of_type_JavaLangString = paramRspBody.msg_photo.str_msg.get();
          localCompletePesonalDataTask.jdField_c_of_type_Int = paramRspBody.msg_photo.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "updateMatchChatCompletePersonalDataTaskBy0xe03 ,retCode " + i + ",maxMatchCount " + this.jdField_b_of_type_Long + ",matchedCount " + this.jdField_c_of_type_Long + ",completePesonalDataTasks " + this.jdField_a_of_type_JavaUtilList);
      }
      return;
      i = -1;
      break;
      label606:
      l2 = 0L;
      break label45;
      label612:
      paramRspBody = null;
      break label95;
      label617:
      if (i == 0)
      {
        if (paramRspBody.uint64_matched_times.has()) {
          l1 = paramRspBody.uint64_matched_times.get();
        }
        this.jdField_c_of_type_Long = l1;
      }
    }
  }
  
  public void a(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    int i = paramGetUserStatusRsp.Category.get();
    boolean bool1 = paramGetUserStatusRsp.UsedNewMatch.get();
    boolean bool2 = paramGetUserStatusRsp.HasPersonalLabels.get();
    if (QLog.isColorLevel()) {
      QLog.w("ExtendFriendManager", 2, "updateUserCategory category ： " + i + "，usedNewMatch ：" + bool1 + "，hasPersonalLabels ：" + bool2);
    }
    paramGetUserStatusRsp = SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit();
    paramGetUserStatusRsp.putInt("sp_extend_friend_user_category", i);
    paramGetUserStatusRsp.putBoolean("sp_extend_friend_used_new_match", bool1);
    paramGetUserStatusRsp.putBoolean("sp_extend_friend_has_personal_labels", bool2);
    paramGetUserStatusRsp.apply();
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("onResourceDownloadComplete mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "onResourceDownloadComplete FAILED!");
    }
  }
  
  public boolean a()
  {
    if (b() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "isAllCompleteDataTaskDone result = " + bool);
      }
      return bool;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ExtendFriendManager", 1, "isShowExpandEntry: mApp is null!");
      return false;
    }
    boolean bool = ExpandFriendChatUtil.a(paramQQAppInterface);
    if ((bool) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      ((ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "")).notifyPluginListChanged();
      long l = SystemClock.uptimeMillis() - this.jdField_d_of_type_Long;
      QLog.i("ExtendFriendManagerexpand.enter.", 1, "begin show Entry. time cost=" + l + " ms");
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put("time_cost", l + "");
      ExpandReportUtils.a("expand_quality#qq_launch#get_entrance", true, paramQQAppInterface);
    }
    return bool;
  }
  
  public boolean a(ExtendFriendConfig paramExtendFriendConfig)
  {
    boolean bool = true;
    if ((paramExtendFriendConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        int i = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_contact", 0);
        int j = ExpandSharePreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((i != 1) || (j != 1)) {
          break label85;
        }
        return bool;
      }
      catch (Exception paramExtendFriendConfig)
      {
        paramExtendFriendConfig.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ExtendFriendManager", 2, paramExtendFriendConfig.getMessage());
      return false;
      label85:
      bool = false;
    }
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((CompletePesonalDataTask)localIterator.next()).jdField_c_of_type_Int == 2) {
        break label78;
      }
      i += 1;
    }
    label78:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getUnFinishedCompletePeronalInfoTaskCount count = " + i);
      }
      return i;
    }
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public ExtendFriendConfig b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.b();
  }
  
  public ExtendFriendSearchHistoryManager b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader.b();
  }
  
  public List<String> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    while (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader != null) && (!b())) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader.c();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a(paramString);
    boolean bool = ExtendFriendLimitChatResourceUtil.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a());
    ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.4(this, bool));
  }
  
  public void b(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    boolean bool = paramGetUserStatusRsp.forbiddenInfo.isForbidden.get();
    long l = paramGetUserStatusRsp.forbiddenInfo.forbiddenEndTime.get();
    int i = paramGetUserStatusRsp.forbiddenInfo.forbiddenDuration.get();
    if (QLog.isColorLevel()) {
      QLog.w("ExtendFriendManager", 2, "updateForbiddenInfo isForbidden " + bool + " forbiddenEndTime " + l + " forbiddenDuration " + i);
    }
    paramGetUserStatusRsp = SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785");
    SharedPreferences.Editor localEditor = paramGetUserStatusRsp.edit();
    if ((l != paramGetUserStatusRsp.getLong("sp_extend_forbidden_end_time", 0L)) && (l != 0L) && (i != 0)) {
      b(i);
    }
    localEditor.putBoolean("sp_extend_friend_is_forbidden", bool);
    localEditor.putLong("sp_extend_forbidden_end_time", l);
    localEditor.putLong("sp_extend_forbidden_update_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    f(paramBoolean);
  }
  
  public boolean b()
  {
    boolean bool = DeviceInfoUtils.b();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "isLowPerfDevice:  " + bool);
    }
    return bool;
  }
  
  public int c()
  {
    ExtendFriendConfig localExtendFriendConfig;
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      localExtendFriendConfig = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a();
      if ((localExtendFriendConfig == null) || (localExtendFriendConfig.h <= 0)) {
        break label61;
      }
      i = localExtendFriendConfig.jdField_i_of_type_Int;
    }
    label61:
    for (this.jdField_a_of_type_Int = (new Random().nextInt(localExtendFriendConfig.h - localExtendFriendConfig.jdField_i_of_type_Int) + i);; this.jdField_a_of_type_Int = new Random().nextInt(10000000)) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public long c()
  {
    long l1 = 0L;
    long l2 = this.jdField_b_of_type_Long - this.jdField_c_of_type_Long;
    if (l2 < 0L) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("getLeftMatchCount max:%d,matched:%d,left:%d", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long), Long.valueOf(l1) }));
      }
      return l1;
      l1 = l2;
    }
  }
  
  public String c()
  {
    int k = 0;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      String str = String.valueOf(c());
      int i = str.length();
      int m = str.length() / 3 + i;
      int n = str.length() % 3;
      i = n;
      int j = m;
      if (n == 0)
      {
        i = n + 3;
        j = m - 1;
      }
      char[] arrayOfChar = new char[j];
      m = 0;
      j = k;
      k = i;
      i = m;
      if (i < arrayOfChar.length)
      {
        if (i == k)
        {
          k += 4;
          arrayOfChar[i] = ',';
          j += 1;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfChar[i] = str.charAt(i - j);
        }
      }
      this.jdField_c_of_type_JavaLangString = new String(arrayOfChar);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a();
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.i("ExtendFriendManager", 2, "setSingalBombWaiting o " + paramBoolean);
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int d()
  {
    int j = 2147483647;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a())
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().u;
      }
    }
    return i;
  }
  
  public long d()
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785");
    a(localSharedPreferences);
    return localSharedPreferences.getLong("sp_extend_forbidden_end_time", 0L);
  }
  
  public String d()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a())
    {
      ExtendFriendConfig localExtendFriendConfig = a();
      localObject1 = localObject2;
      if (localExtendFriendConfig != null) {
        localObject1 = localExtendFriendConfig.k;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = HardCodeUtil.a(2131704292);
    }
    return localObject2;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateMatchChatConfig ");
    }
    ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(18, true, null);
  }
  
  public void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit();
    localEditor.putBoolean("sp_extend_friend_has_personal_labels", paramBoolean);
    localEditor.commit();
  }
  
  public boolean d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.e("ExtendFriendManager", 2, "isResourceReady NOT READY!");
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public int e()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a())
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().jdField_c_of_type_Int;
      }
    }
    return i;
  }
  
  public String e()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().m;
      }
    }
    return str1;
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(ExtendFriendUserInfo.class);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_first_prompt_extend_friend_new_user", paramBoolean).apply();
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null)) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().v;; i = 1) {
      return i == 1;
    }
  }
  
  public int f()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String f()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().n;
      }
    }
    return str1;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    h(true);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), new ExtendFriendManager.9(this));
    p();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.d();
  }
  
  public int g()
  {
    int j = 1;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a())
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null)
      {
        j = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().w;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("ExtendFriendManager", 2, "coldPalaceGrayTipPosition  " + j);
          i = j;
        }
      }
    }
    return i;
  }
  
  public String g()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().o;
      }
    }
    return str1;
  }
  
  public void g()
  {
    h(false);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b();
    }
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.c();
  }
  
  public int h()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String h()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ExtendFriendManager", 2, "getLocationAndOpenSignal: mApp is null!");
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), new ExtendFriendManager.10(this));
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.w("ExtendFriendManager", 1, "call isNeedShowCertificateBanner after manager destroy!");
      bool2 = bool1;
    }
    boolean bool3;
    do
    {
      return bool2;
      bool3 = CampusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bool1 = bool2;
      if (bool3) {
        if ((this.jdField_e_of_type_Int != 0) && (this.jdField_e_of_type_Int != 2))
        {
          bool1 = bool2;
          if (this.jdField_e_of_type_Int != 3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendManager", 2, "isNeedShowCertificateBanner result = " + bool1 + ",showFlag = " + bool3);
    return bool1;
  }
  
  public int i()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_user_category", 0);
  }
  
  public String i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public void i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_JavaUtilList.clear();
      }
      return;
    }
  }
  
  public boolean i()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().jdField_p_of_type_Int == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String j()
  {
    if (this.jdField_e_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean j()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().r == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bVoiceMatchOpen  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean k()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager.a().s == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bSignalBombOpen  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean l()
  {
    QLog.i("ExtendFriendManager", 2, "getIsSingalBombWaiting o " + this.jdField_e_of_type_Boolean);
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean m()
  {
    QLog.i("ExtendFriendManager", 2, "getIsExtendFriendUsing " + this.jdField_f_of_type_Boolean);
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean n()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_used_new_match", false);
  }
  
  public boolean o()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_has_personal_labels", false);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.b();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader.a(null);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader = null;
      this.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData = null;
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler.a();
    }
  }
  
  public boolean p()
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785");
    a(localSharedPreferences);
    return localSharedPreferences.getBoolean("sp_extend_friend_is_forbidden", false);
  }
  
  public boolean q()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_first_prompt_extend_friend_new_user", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager
 * JD-Core Version:    0.7.0.1
 */