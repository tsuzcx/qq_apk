package com.tencent.mobileqq.qqexpand.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.leba.ILebaHelperService;
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
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.CacheData;
import com.tencent.mobileqq.qqexpand.bean.match.CompletePesonalDataTask;
import com.tencent.mobileqq.qqexpand.bean.match.ExtendFriendLocationInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.config.IConfigCallback;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean.BannerItem;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerProcessor;
import com.tencent.mobileqq.qqexpand.downloader.ExpandResourceDownloader;
import com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader;
import com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader.ResourceDownloaderListener;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository;
import com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager;
import com.tencent.mobileqq.qqexpand.match.ExtendFriendSignalBombCardData;
import com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;
import com.tencent.mobileqq.qqexpand.plugin.preload.ExpandPluginPreloadManager;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.ExpandPreloadUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.qqexpand.utils.ExtendFriendGetLocationListener;
import com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils;
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
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
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
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

public class ExpandManager
  implements ExtendFriendResourceDownloader.ResourceDownloaderListener, IExpandManager, Manager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private final LruCache<String, ExpandUserInfo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private SchoolInfo jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
  private final ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new ExpandManager.1(this);
  private CacheData jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData;
  private ExpandResourceDownloader jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader;
  private ExtendFriendResourceDownloader jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader;
  private final ExpandChatRepository jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository;
  private final ActiveUserManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager = new ActiveUserManager();
  private final ExtendFriendSearchHistoryManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager;
  private final ExpandConfigManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager;
  private final ExpandCmdHandler jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandCmdHandler;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExpandManager.2(this);
  private final ExpandPluginPreloadManager jdField_a_of_type_ComTencentMobileqqQqexpandPluginPreloadExpandPluginPreloadManager = new ExpandPluginPreloadManager();
  private final ColdPalaceHelper jdField_a_of_type_ComTencentMobileqqQqexpandUtilsColdPalaceHelper;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final List<CompletePesonalDataTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oidb_0xdb1.SchoolInfo jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final ExtendFriendSearchHistoryManager jdField_b_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager;
  private String jdField_b_of_type_JavaLangString;
  private final ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<ExtendFriendSignalBombCardData> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "";
  private volatile boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = "";
  private volatile boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private volatile long jdField_e_of_type_Long = 0L;
  private String jdField_e_of_type_JavaLangString = "";
  private volatile boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private volatile boolean jdField_f_of_type_Boolean = false;
  
  static
  {
    ExpandReportUtils.a();
    QLog.i("ExtendFriendManager", 1, "init expand tunnel");
  }
  
  public ExpandManager(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository = new ExpandChatRepository(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandCmdHandler = new ExpandCmdHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager = new ExpandConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader = new ExtendFriendResourceDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager = new ExtendFriendSearchHistoryManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    this.jdField_b_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager = new ExtendFriendSearchHistoryManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsColdPalaceHelper = new ColdPalaceHelper(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginPreloadExpandPluginPreloadManager.a();
    ThreadManager.postImmediately(new ExpandManager.3(this), null, true);
  }
  
  private static int a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    int i = 0;
    if (paramBaseQQAppInterface != null) {
      i = SharedPreUtils.a(paramBaseQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_forbid_flag", 0);
    }
    return i;
  }
  
  private static long a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    long l = 0L;
    if (paramBaseQQAppInterface != null) {
      l = SharedPreUtils.a(paramBaseQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getLong("sp_extend_friend_forbid_end_time", 0L);
    }
    return l;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private JSONObject a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return null;
    }
    try
    {
      if (!paramAppInfo.buffer.has()) {
        return null;
      }
      paramAppInfo = paramAppInfo.buffer.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TianShuBufferJsonStr = ");
        ((StringBuilder)localObject).append(paramAppInfo);
        QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
      }
      if (TextUtils.isEmpty(paramAppInfo)) {
        return null;
      }
      paramAppInfo = new JSONObject(paramAppInfo);
      Object localObject = paramAppInfo.optString("_show_mission");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramAppInfo = new JSONObject(paramAppInfo.optJSONObject("msg").optJSONObject((String)localObject).optString("src"));
        return paramAppInfo;
      }
    }
    catch (Throwable paramAppInfo)
    {
      QLog.e("ExtendFriendManager", 1, "getTianShuSrcInfo() JSONException ", paramAppInfo);
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
    if ((NetworkUtil.isNetSupport(paramContext)) && (q()))
    {
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
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new ExpandManager.11(this, "extend_friend", false, paramExtendFriendGetLocationListener));
      return;
    }
    a(false, null, paramExtendFriendGetLocationListener);
  }
  
  private static void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, long paramLong)
  {
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = SharedPreUtils.a(paramBaseQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit();
      paramBaseQQAppInterface.putInt("sp_extend_friend_forbid_flag", paramInt);
      paramBaseQQAppInterface.putLong("sp_extend_friend_forbid_end_time", paramLong);
      paramBaseQQAppInterface.commit();
    }
  }
  
  private void a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    if (paramSchoolInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = new SchoolInfo();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
      boolean bool = paramSchoolInfo.uint32_idx.has();
      int j = 0;
      if (bool) {
        i = paramSchoolInfo.uint32_idx.get();
      } else {
        i = 0;
      }
      ((SchoolInfo)localObject).jdField_a_of_type_Int = i;
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
      int i = j;
      if (paramSchoolInfo.uint32_category.has()) {
        i = paramSchoolInfo.uint32_category.get();
      }
      ((SchoolInfo)localObject).jdField_b_of_type_Int = i;
      SchoolInfo localSchoolInfo = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
      bool = paramSchoolInfo.str_school_id.has();
      String str = "";
      if (bool) {
        localObject = paramSchoolInfo.str_school_id.get();
      } else {
        localObject = "";
      }
      localSchoolInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      localSchoolInfo = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
      localObject = str;
      if (paramSchoolInfo.str_school_name.has()) {
        localObject = paramSchoolInfo.str_school_name.get();
      }
      localSchoolInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = null;
  }
  
  private void a(boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    paramExtendFriendGetLocationListener.a(paramBoolean, ExtendFriendLocationInfo.a(paramSosoLbsInfo));
  }
  
  private void b(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    int i = paramGetUserStatusRsp.Category.get();
    boolean bool1 = paramGetUserStatusRsp.UsedNewMatch.get();
    boolean bool2 = paramGetUserStatusRsp.HasPersonalLabels.get();
    if (QLog.isColorLevel())
    {
      paramGetUserStatusRsp = new StringBuilder();
      paramGetUserStatusRsp.append("updateUserCategory category ： ");
      paramGetUserStatusRsp.append(i);
      paramGetUserStatusRsp.append("，usedNewMatch ：");
      paramGetUserStatusRsp.append(bool1);
      paramGetUserStatusRsp.append("，hasPersonalLabels ：");
      paramGetUserStatusRsp.append(bool2);
      QLog.w("ExtendFriendManager", 2, paramGetUserStatusRsp.toString());
    }
    paramGetUserStatusRsp = SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit();
    paramGetUserStatusRsp.putInt("sp_extend_friend_user_category", i);
    paramGetUserStatusRsp.putBoolean("sp_extend_friend_used_new_match", bool1);
    paramGetUserStatusRsp.putBoolean("sp_extend_friend_has_personal_labels", bool2);
    paramGetUserStatusRsp.apply();
  }
  
  private void e(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    ((ExpandHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void f(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    SharedPreUtils.a(localQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_is_user_student", paramBoolean).commit();
  }
  
  private void g(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setExtendFriendUsing o ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendManager", 2, localStringBuilder.toString());
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  private void i()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      this.jdField_c_of_type_Boolean = SharedPreUtils.a(localQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_is_user_student", false);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a();
  }
  
  private void k()
  {
    if (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))
    {
      QLog.i("ExtendFriendManager", 1, "preDownloadExpandPlugin(): won't preload plugin, wifi not connected!");
      return;
    }
    if (!QFlutterResConfigProcessor.a(ExpandModuleKey.ExpandPluginPreDownload))
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
    IExpandEntrance localIExpandEntrance = (IExpandEntrance)QRoute.api(IExpandEntrance.class);
    ((IPluginManager)localObject).a("expand", new ExpandManager.5(this), "extend_friend_manager");
  }
  
  private void l()
  {
    ThreadManager.getUIHandlerV2().postDelayed(new ExpandManager.6(this), TimeUnit.SECONDS.toMillis(10L));
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.w("ExtendFriendManager", 1, "checkToDownloadResource mApp=null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.b())
    {
      ExpandConfig localExpandConfig = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a();
      if (localExpandConfig == null)
      {
        QLog.e("ExtendFriendManager", 1, "you should not be here!");
        return;
      }
      ExpandResourceDownloader localExpandResourceDownloader = this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader;
      if (localExpandResourceDownloader != null) {
        localExpandResourceDownloader.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader = new ExpandResourceDownloader((QQAppInterface)localObject, localExpandConfig.flutterResUrl, localExpandConfig.flutterResMd5, new ExpandManager.7(this));
      if ((!a()) && (!this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader.a())) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader.a();
      }
      l();
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.c())
    {
      k();
      n();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader;
      if (localObject != null)
      {
        try
        {
          ((ExtendFriendResourceDownloader)localObject).a(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().mResourceURL, this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().mResourceMD5);
          if (!this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader.a();
            b(false);
          }
          else
          {
            b(true);
          }
        }
        catch (Exception localException)
        {
          QLog.e("ExtendFriendManager", 1, "checkToDownloadResource fail.", localException);
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() == null)
    {
      QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig is null", new Object[0]));
      return;
    }
    QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mDownloader is null", new Object[0]));
  }
  
  private void n()
  {
    boolean bool = ExpandPreloadUtils.a(ExpandModuleKey.ExpandPluginPreInstall);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginPreloadExpandPluginPreloadManager.a(bool);
  }
  
  private void o()
  {
    Object localObject = ExpandResourceUtil.a("expand_question_dialog.png");
    File localFile = new File((String)localObject);
    boolean bool = localFile.exists();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("downloadQuestionRes, filePath:%s, isExist:%s", new Object[] { localObject, Boolean.valueOf(bool) }));
    }
    if (bool) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().expandExamImg)))
    {
      localObject = new DownloadTask(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().expandExamImg, localFile);
      int i = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
        }
      }
      else {
        QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i) }));
      }
    }
    else
    {
      QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
    }
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        localObject = ((FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (localObject != null)
        {
          if (TextUtils.isEmpty(((Card)localObject).declaration)) {
            break label157;
          }
          bool1 = true;
          boolean bool2 = ((Card)localObject).isShowCard;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData profileComplete=%s showCard=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData.jdField_a_of_type_Boolean = bool1;
            this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData.jdField_b_of_type_Boolean = bool2;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", localException);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData }));
      }
      return;
      label157:
      boolean bool1 = false;
    }
  }
  
  private void q()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null)
    {
      QLog.e("ExtendFriendManager", 2, "checkFirstEnterExtendFriendEveryDay : mApp is null!");
      return;
    }
    localObject1 = SharedPreUtils.a(((QQAppInterface)localObject1).getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = ((SharedPreferences)localObject1).getLong("sp_extend_friend_first_enter_everyday", 0L);
    long l2 = MessageCache.a();
    boolean bool = false;
    if (l2 - l1 > 86400L) {}
    Object localObject2;
    Calendar localCalendar;
    do
    {
      bool = true;
      break;
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(l1 * 1000L);
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(1000L * l2);
    } while (((Calendar)localObject2).get(6) != localCalendar.get(6));
    if (bool)
    {
      localObject1 = ((SharedPreferences)localObject1).edit().putLong("sp_extend_friend_first_enter_everyday", l2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp_extend_friend_signal_everyday_report_");
      ((StringBuilder)localObject2).append(l1);
      ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString()).commit();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkFirstEnterExtendFriendEveryDay first:");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(" current:");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" isFirstTimeToday:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static boolean q()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hasLocationPermission no permission ");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  private void r()
  {
    Object localObject1 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = ((SharedPreferences)localObject1).getLong("sp_extend_friend_first_enter_everyday", 0L);
    if (l1 > 0L)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp_extend_friend_signal_everyday_report_");
      ((StringBuilder)localObject2).append(l1);
      localObject2 = ((StringBuilder)localObject2).toString();
      boolean bool = ((SharedPreferences)localObject1).getBoolean((String)localObject2, false);
      if (!bool)
      {
        long l2 = MessageCache.a();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE99", "0X800AE99", 0, 0, String.valueOf(l2 - l1), "", "", "");
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).commit();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkReportForFirstReceiveCardEveryDay ");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int a(String paramString)
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getInt(paramString, 0);
  }
  
  public SchoolInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
  }
  
  public CacheData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData;
  }
  
  public ExtendFriendLocationInfo a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ExtendFriendLocationInfo localExtendFriendLocationInfo = null;
    if (localObject == null)
    {
      QLog.e("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync: mApp is null!");
      return null;
    }
    localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
    if (localObject != null) {
      localExtendFriendLocationInfo = ExtendFriendLocationInfo.a((SosoLbsInfo)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getExtendFriendLocationInfoSync ");
      ((StringBuilder)localObject).append(localExtendFriendLocationInfo);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext())) && (q()) && (l - this.jdField_e_of_type_Long > 3600000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync start");
      }
      this.jdField_e_of_type_Long = l;
      ThreadManager.getSubThreadHandler().post(new ExpandManager.12(this));
    }
    return localExtendFriendLocationInfo;
  }
  
  public ExpandUserInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    Object localObject1 = localObject2;
    if (localEntityManager != null)
    {
      localObject1 = localObject2;
      if (localEntityManager.isOpen()) {
        localObject1 = (ExpandUserInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExpandUserInfo.class, paramString);
      }
    }
    return localObject1;
  }
  
  public ExpandUserInfo a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("ExtendFriendManager", 1, "getExtendFriendUserInfoCache but uin is empty");
      return null;
    }
    ExpandUserInfo localExpandUserInfo2 = (ExpandUserInfo)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    ExpandUserInfo localExpandUserInfo1 = localExpandUserInfo2;
    if (localExpandUserInfo2 == null)
    {
      localExpandUserInfo1 = localExpandUserInfo2;
      if (paramBoolean)
      {
        localExpandUserInfo2 = a(paramString);
        localExpandUserInfo1 = localExpandUserInfo2;
        if (localExpandUserInfo2 != null)
        {
          this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localExpandUserInfo2);
          localExpandUserInfo1 = localExpandUserInfo2;
        }
      }
    }
    return localExpandUserInfo1;
  }
  
  @Nullable
  public ExpandConfig a()
  {
    return a().a();
  }
  
  public ExpandChatRepository a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository;
  }
  
  public ExtendFriendSearchHistoryManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager;
  }
  
  public ExpandConfigManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager;
  }
  
  public ExpandCmdHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandCmdHandler;
  }
  
  public ColdPalaceHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsColdPalaceHelper;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<ExpandBannerConfBean.BannerItem> a()
  {
    return ExpandBannerProcessor.a().a();
  }
  
  public List<String> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ExtendFriendManager", 2, String.format("getDefaultTags app is null check here!", new Object[0]));
        }
        return localArrayList;
      }
      localObject = QZoneUnreadServletLogic.a(((QQAppInterface)localObject).getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("getDefaultTags campusHotTags=%s", new Object[] { Arrays.toString((Object[])localObject) }));
      }
      if ((localObject != null) && (localObject.length > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(Arrays.asList((Object[])localObject));
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 10);
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
    else
    {
      paramInt = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
    localArrayList.add(0, "推荐");
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Long += 1L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("increaseMatchedCount matchedCount = ");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCampusCertificateStatus campusCertificateStatus = ");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      localStringBuilder.append(",new status = ");
      localStringBuilder.append(paramInt1);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
    this.jdField_e_of_type_Int = paramInt1;
    CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCurExtendFriendSchoolInfo ,idx = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",schoolName = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",schoolId = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",schoolCategory = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo = new SchoolInfo();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
    ((SchoolInfo)localObject).jdField_a_of_type_Int = paramInt1;
    ((SchoolInfo)localObject).jdField_b_of_type_JavaLangString = paramString1;
    ((SchoolInfo)localObject).jdField_a_of_type_JavaLangString = paramString2;
    ((SchoolInfo)localObject).jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandManager.8(this));
  }
  
  public void a(CacheData paramCacheData)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData = paramCacheData;
  }
  
  public void a(MatchInfo paramMatchInfo)
  {
    if (paramMatchInfo == null)
    {
      QLog.e("ExtendFriendManager", 2, "updateSignalBombPush : matchInfo is null!");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null)
    {
      QLog.e("ExtendFriendManager", 2, "updateSignalBombPush : mApp is null!");
      return;
    }
    ((QQAppInterface)localObject1).getMsgCache().b(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_ArrayOfByte);
    int i;
    if (k())
    {
      a(ExtendFriendSignalBombCardData.a(paramMatchInfo));
      if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = paramMatchInfo.jdField_b_of_type_JavaLangString;
        i = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.g;
        if (this.jdField_c_of_type_Boolean) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        ReportController.b((AppRuntime)localObject2, "dc00898", "", str, "0X800AE9A", "0X800AE9A", i, 0, "", (String)localObject1, paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.j, paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.k);
      }
      r();
    }
    LimitChatUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString);
    LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString, 1044);
    if (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramMatchInfo.jdField_b_of_type_JavaLangString)) {
      LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo, paramMatchInfo.jdField_a_of_type_Long, 1);
    } else {
      QLog.d("ExtendFriendManager", 1, "updateSignalBombPush already friend.");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject2 = paramMatchInfo.jdField_b_of_type_JavaLangString;
    int j = paramMatchInfo.jdField_b_of_type_Int;
    String str = paramMatchInfo.f;
    boolean bool = TextUtils.isEmpty(paramMatchInfo.jdField_c_of_type_JavaLangString);
    if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo != null) {
      i = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_f_of_type_Int;
    } else {
      i = -1;
    }
    LimitChatUtil.a((QQAppInterface)localObject1, (String)localObject2, j, str, bool ^ true, i, true, 4);
    ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString, true);
  }
  
  public void a(ExpandUserInfo paramExpandUserInfo)
  {
    if ((paramExpandUserInfo != null) && (!TextUtils.isEmpty(paramExpandUserInfo.uin)))
    {
      this.jdField_a_of_type_AndroidUtilLruCache.put(paramExpandUserInfo.uin, paramExpandUserInfo);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      if ((localObject != null) && (((EntityManager)localObject).isOpen())) {
        if (paramExpandUserInfo.getStatus() == 1000) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramExpandUserInfo);
        } else if (paramExpandUserInfo.getStatus() == 1001) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramExpandUserInfo);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateExtendFriendUserInfo ");
        ((StringBuilder)localObject).append(paramExpandUserInfo);
        QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    QLog.w("ExtendFriendManager", 1, "updateExtendFriendUserInfo but extendFriendUserInfo is empty");
  }
  
  public void a(IConfigCallback paramIConfigCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a(paramIConfigCallback);
  }
  
  public void a(ExtendFriendSignalBombCardData paramExtendFriendSignalBombCardData)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addExtendFriendSignalBombCardData ");
      ((StringBuilder)???).append(paramExtendFriendSignalBombCardData);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)???).toString());
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
  
  @WorkerThread
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("updateTianShuWaveStatus iNewFlag: %d , exposure_max: %d", new Object[] { Integer.valueOf(paramAppInfo.iNewFlag.get()), Integer.valueOf(paramAppInfo.exposure_max.get()) }));
    }
    if ((paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.exposure_max.get() >= 0))
    {
      paramAppInfo = a(paramAppInfo);
      if (paramAppInfo != null) {
        try
        {
          this.jdField_d_of_type_JavaLangString = paramAppInfo.optJSONObject("waves").optString("waves_type");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TianShuSrcInfo: ");
          localStringBuilder.append(paramAppInfo.toString());
          QLog.i("ExtendFriendManager", 1, localStringBuilder.toString());
          return;
        }
        catch (Throwable paramAppInfo)
        {
          QLog.e("ExtendFriendManager", 1, "updateTianShuWaveStatus() JSONException ", paramAppInfo);
        }
      }
      this.jdField_d_of_type_JavaLangString = "";
      return;
    }
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_0xdb1.RspBody paramRspBody)
  {
    boolean bool1 = paramRspBody.enum_school_verify_status.has();
    int m = 0;
    int i;
    if (bool1) {
      i = paramRspBody.enum_school_verify_status.get();
    } else {
      i = 0;
    }
    if (paramRspBody.str_school_verify_tips.has()) {
      paramFromServiceMsg = paramRspBody.str_school_verify_tips.get();
    } else {
      paramFromServiceMsg = "";
    }
    bool1 = TextUtils.isEmpty(paramFromServiceMsg);
    boolean bool2 = true;
    int j;
    if (bool1) {
      j = 1;
    } else {
      j = 2;
    }
    a(i, j);
    if (paramRspBody.uint32_user_identity.has()) {
      j = paramRspBody.uint32_user_identity.get();
    } else {
      j = 0;
    }
    if (j == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    f(this.jdField_c_of_type_Boolean);
    if (paramRspBody.uint32_need_display_school_info.has()) {
      j = paramRspBody.uint32_need_display_school_info.get();
    } else {
      j = 0;
    }
    if (j == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    bool1 = paramRspBody.msg_new_school_info.has();
    ArrayList localArrayList1 = null;
    Object localObject1;
    if (bool1) {
      localObject1 = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_new_school_info.get();
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo = ((oidb_0xdb1.SchoolInfo)localObject1);
    if (paramRspBody.str_suggest_school_name.has()) {
      localObject1 = paramRspBody.str_suggest_school_name.get();
    } else {
      localObject1 = "";
    }
    this.jdField_e_of_type_JavaLangString = ((String)localObject1);
    if (paramRspBody.msg_kuolie_school_info.has()) {
      localObject1 = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_kuolie_school_info.get();
    } else {
      localObject1 = null;
    }
    a((oidb_0xdb1.SchoolInfo)localObject1);
    if ((localObject1 != null) && (((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.has())) {
      localObject1 = ((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.get();
    } else {
      localObject1 = "";
    }
    if ((paramToServiceMsg.extraData.getBoolean("key_need_get_online_number", false)) && (paramRspBody.uint32_online_num.has())) {
      j = paramRspBody.uint32_online_num.get();
    } else {
      j = 0;
    }
    this.jdField_b_of_type_Int = j;
    if (paramToServiceMsg.extraData.getBoolean("key_need_get_search_keywords", false))
    {
      Object localObject2;
      if (paramRspBody.msg_campus_search_keywords.has()) {
        localObject2 = paramRspBody.msg_campus_search_keywords.get();
      } else {
        localObject2 = null;
      }
      paramToServiceMsg = localArrayList1;
      if (paramRspBody.msg_voice_search_keywords.has()) {
        paramToServiceMsg = paramRspBody.msg_voice_search_keywords.get();
      }
      localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (oidb_0xdb1.SearchKeyWord)localIterator.next();
          if (((oidb_0xdb1.SearchKeyWord)localObject2).str_school_name.has()) {
            localObject2 = ((oidb_0xdb1.SearchKeyWord)localObject2).str_school_name.get();
          } else {
            localObject2 = "";
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localArrayList1.add(localObject2);
          }
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        localObject2 = paramToServiceMsg.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramToServiceMsg = (oidb_0xdb1.SearchKeyWord)((Iterator)localObject2).next();
          if (paramToServiceMsg.str_school_name.has()) {
            paramToServiceMsg = paramToServiceMsg.str_school_name.get();
          } else {
            paramToServiceMsg = "";
          }
          if (!TextUtils.isEmpty(paramToServiceMsg)) {
            localArrayList2.add(paramToServiceMsg);
          }
        }
      }
      a(localArrayList1, localArrayList2);
    }
    int k;
    if (paramRspBody.uint32_forbid_flag.has()) {
      k = paramRspBody.uint32_forbid_flag.get();
    } else {
      k = 0;
    }
    long l;
    if (paramRspBody.uint32_forbid_end_time.has()) {
      l = paramRspBody.uint32_forbid_end_time.get();
    } else {
      l = 0L;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, l);
    if (paramRspBody.bytes_birthday.has()) {
      m = ByteBuffer.wrap(paramRspBody.bytes_birthday.get().toByteArray()).getInt();
    }
    this.jdField_c_of_type_Int = m;
    a(paramRspBody);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetExtendFriendPermissionAndStatusResponse. ,verifyStatus = ");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",verifyTips = ");
      paramToServiceMsg.append(paramFromServiceMsg);
      paramToServiceMsg.append(",serverSuggestSchoolName = ");
      paramToServiceMsg.append(this.jdField_e_of_type_JavaLangString);
      paramToServiceMsg.append(",schoolNameInExtendFriendCard = ");
      paramToServiceMsg.append((String)localObject1);
      paramToServiceMsg.append(",onlineNumber = ");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append(",needShowEduBackgroundUpdateDialog = ");
      paramToServiceMsg.append(this.jdField_b_of_type_Boolean);
      paramToServiceMsg.append(",profileNewSchoolInfo = ");
      paramToServiceMsg.append(this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo);
      paramToServiceMsg.append(",isUserStudentOrNot = ");
      paramToServiceMsg.append(this.jdField_c_of_type_Boolean);
      paramToServiceMsg.append(",userBirthday = ");
      paramToServiceMsg.append(this.jdField_c_of_type_Int);
      paramToServiceMsg.append(",forbidFlag = ");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(",forbidEndTime = ");
      paramToServiceMsg.append(l);
      QLog.d("ExtendFriendManager", 2, paramToServiceMsg.toString());
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit().putInt(paramString, paramInt).apply();
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    ExpandUserInfo localExpandUserInfo2 = a(paramString, true);
    ExpandUserInfo localExpandUserInfo1 = localExpandUserInfo2;
    if (localExpandUserInfo2 == null) {
      localExpandUserInfo1 = new ExpandUserInfo();
    }
    localExpandUserInfo1.uin = paramString;
    localExpandUserInfo1.fromType = paramBundle.getInt("fromType", 3);
    a(localExpandUserInfo1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUnlimitMatchUserInfo() uin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" matchUin = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("uinType=");
      localStringBuilder.append(paramInt);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
    ((ExpandHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramString1, paramString2, paramInt);
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
    boolean bool = paramRspBody.uint64_max_match_times.has();
    long l2 = 0L;
    if (bool) {
      l1 = paramRspBody.uint64_max_match_times.get();
    } else {
      l1 = 0L;
    }
    this.jdField_b_of_type_Long = l1;
    long l1 = l2;
    if (paramRspBody.uint64_matched_times.has()) {
      l1 = paramRspBody.uint64_matched_times.get();
    }
    this.jdField_c_of_type_Long = l1;
    if (paramRspBody.msg_task_info.has()) {
      paramRspBody = (oidb_0xdb1.matchTaskInfo)paramRspBody.msg_task_info.get();
    } else {
      paramRspBody = null;
    }
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
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("updateMatchChatCompletePersonalDataTaskBy0xdb1 ,maxMatchCount");
      paramRspBody.append(this.jdField_b_of_type_Long);
      paramRspBody.append(",matchedCount");
      paramRspBody.append(this.jdField_c_of_type_Long);
      paramRspBody.append(",completePesonalDataTasks");
      paramRspBody.append(this.jdField_a_of_type_JavaUtilList);
      QLog.d("ExtendFriendManager", 2, paramRspBody.toString());
    }
  }
  
  public void a(oidb_0xe03.RspBody paramRspBody)
  {
    int i;
    if (paramRspBody.enum_matchopretcode.has()) {
      i = paramRspBody.enum_matchopretcode.get();
    } else {
      i = -1;
    }
    long l1 = 0L;
    if (12 == i)
    {
      long l2;
      if (paramRspBody.uint64_max_match_times.has()) {
        l2 = paramRspBody.uint64_max_match_times.get();
      } else {
        l2 = 0L;
      }
      this.jdField_b_of_type_Long = l2;
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.jdField_c_of_type_Long = l1;
      if (paramRspBody.msg_task_info.has()) {
        paramRspBody = (oidb_0xe03.matchTaskInfo)paramRspBody.msg_task_info.get();
      } else {
        paramRspBody = null;
      }
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
    else if (i == 0)
    {
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.jdField_c_of_type_Long = l1;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("updateMatchChatCompletePersonalDataTaskBy0xe03 ,retCode ");
      paramRspBody.append(i);
      paramRspBody.append(",maxMatchCount ");
      paramRspBody.append(this.jdField_b_of_type_Long);
      paramRspBody.append(",matchedCount ");
      paramRspBody.append(this.jdField_c_of_type_Long);
      paramRspBody.append(",completePesonalDataTasks ");
      paramRspBody.append(this.jdField_a_of_type_JavaUtilList);
      QLog.d("ExtendFriendManager", 2, paramRspBody.toString());
    }
  }
  
  public void a(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    b(paramGetUserStatusRsp);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager.a(paramGetUserStatusRsp);
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
    boolean bool = DeviceInfoUtils.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isLowPerfDevice:  ");
      localStringBuilder.append(bool);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean a(Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if ((paramActivity != null) && (paramBaseQQAppInterface != null))
    {
      if (paramActivity.isFinishing()) {
        return false;
      }
      int i = a(paramBaseQQAppInterface);
      if (i == 0) {
        return false;
      }
      long l = a(paramBaseQQAppInterface) - NetConnInfoCenter.getServerTime();
      boolean bool;
      if ((i == 1) && (l <= 8640000L)) {
        bool = false;
      } else {
        bool = true;
      }
      if ((!bool) && (l <= 0L))
      {
        a(paramBaseQQAppInterface, 0, 0L);
        return false;
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      SpannableStringBuilder localSpannableStringBuilder = ((IExpandForbiddenUtils)QRoute.api(IExpandForbiddenUtils.class)).getForbidDialogMessage(paramActivity, paramActivity.getString(2131698819), bool, l, true);
      localQQCustomDialog.setTitle(paramActivity.getString(2131698821)).setMessage(localSpannableStringBuilder).setPositiveButton(paramActivity.getString(2131698818), new ExpandManager.14(this, paramActivity)).setOnKeyListener(new ExpandManager.13(this, paramActivity));
      localQQCustomDialog.show();
      ReportController.b(paramBaseQQAppInterface, "dc00898", "", "", "0X800B076", "0X800B076", (int)(l / 86400L), 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ExtendFriendManager", 1, "isShowExpandEntry: mApp is null!");
      return false;
    }
    boolean bool = ExpandChatUtil.a(paramBaseQQAppInterface);
    if ((bool) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      ((ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "")).notifyPluginListChanged();
      long l = SystemClock.uptimeMillis() - this.jdField_d_of_type_Long;
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("begin show Entry. time cost=");
      paramBaseQQAppInterface.append(l);
      paramBaseQQAppInterface.append(" ms");
      QLog.i("ExtendFriendManagerexpand.enter.", 1, paramBaseQQAppInterface.toString());
      paramBaseQQAppInterface = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("");
      paramBaseQQAppInterface.put("time_cost", localStringBuilder.toString());
      ExpandReportUtils.a("expand_quality#qq_launch#get_entrance", true, paramBaseQQAppInterface);
    }
    return bool;
  }
  
  public boolean a(ExpandConfig paramExpandConfig)
  {
    if (paramExpandConfig != null)
    {
      paramExpandConfig = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramExpandConfig == null) {
        return false;
      }
      try
      {
        int i = SharedPreUtils.a(paramExpandConfig.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_contact", 0);
        int j = ExpandSharePreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((i == 1) && (j == 1)) {
          return true;
        }
      }
      catch (Exception paramExpandConfig)
      {
        paramExpandConfig.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendManager", 2, paramExpandConfig.getMessage());
        }
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a();
  }
  
  public ExpandConfig b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.b();
  }
  
  public ExtendFriendSearchHistoryManager b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public List<String> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        return localArrayList;
      }
    }
    else if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    }
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader != null) && (!a())) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader.c();
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    e(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      ExpandConfig localExpandConfig = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a();
      if ((localExpandConfig != null) && (localExpandConfig.maxPlayers > 0)) {
        this.jdField_a_of_type_Int = (localExpandConfig.minPlayers + new Random().nextInt(localExpandConfig.maxPlayers - localExpandConfig.minPlayers));
      } else {
        this.jdField_a_of_type_Int = new Random().nextInt(10000000);
      }
    }
    return this.jdField_a_of_type_Int;
  }
  
  public String c()
  {
    ExpandResourceDownloader localExpandResourceDownloader = this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExpandResourceDownloader;
    if (localExpandResourceDownloader == null) {
      return "";
    }
    return localExpandResourceDownloader.a();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateMatchChatConfig ");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    ((ExpandHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(18, true, null);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.b(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit();
    localEditor.putBoolean("sp_extend_friend_has_personal_labels", paramBoolean);
    localEditor.commit();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.f();
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().matchChatGrayTipsCount;
    }
    return 2147483647;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      String str = String.valueOf(c());
      int k = str.length() + str.length() / 3;
      int m = str.length() % 3;
      int j = k;
      int i = m;
      if (m == 0)
      {
        i = m + 3;
        j = k - 1;
      }
      char[] arrayOfChar = new char[j];
      j = 0;
      k = 0;
      while (j < arrayOfChar.length)
      {
        if (j == i)
        {
          i += 4;
          arrayOfChar[j] = ',';
          k += 1;
        }
        else
        {
          arrayOfChar[j] = str.charAt(j - k);
        }
        j += 1;
      }
      this.jdField_b_of_type_JavaLangString = new String(arrayOfChar);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(ExpandUserInfo.class);
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() == null) {
      paramString = null;
    } else {
      paramString = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().limitChatResList;
    }
    boolean bool = ExpandLimitChatResourceUtil.a(paramString);
    ThreadManager.getSubThreadHandler().post(new ExpandManager.4(this, bool));
  }
  
  public void d(boolean paramBoolean)
  {
    SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_first_prompt_extend_friend_new_user", paramBoolean).apply();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().tabIndex;
    }
    return 0;
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a())
    {
      localObject1 = a();
      if (localObject1 != null)
      {
        localObject1 = ((ExpandConfig)localObject1).searchHint;
        break label29;
      }
    }
    Object localObject1 = null;
    label29:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = HardCodeUtil.a(2131704383);
    }
    return localObject2;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    g(true);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), new ExpandManager.9(this));
    q();
  }
  
  public boolean e()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null)) {
      i = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().matchChatIceBreakSwitch;
    } else {
      i = 1;
    }
    return i == 1;
  }
  
  public int f()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().matchChatGrayTipsMsg;
    }
    return "";
  }
  
  public void f()
  {
    g(false);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((ExpandHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a();
    }
  }
  
  public boolean f()
  {
    return a().d();
  }
  
  public int g()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().coldPalaceGrayTipPosition;
      i = j;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("coldPalaceGrayTipPosition  ");
        localStringBuilder.append(j);
        QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
        return j;
      }
    }
    else
    {
      i = 1;
    }
    return i;
  }
  
  public String g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().matchChatGrayTipsLight;
    }
    return "";
  }
  
  public void g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_JavaUtilList.clear();
      }
      return;
    }
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.c();
  }
  
  public int h()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_user_category", 0);
  }
  
  public String h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().mBeatWarning;
    }
    return "";
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager.a();
  }
  
  public boolean h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2 = true;
    if (localObject == null)
    {
      QLog.w("ExtendFriendManager", 1, "call isNeedShowCertificateBanner after manager destroy!");
      return false;
    }
    boolean bool3 = CampusHelper.b((QQAppInterface)localObject);
    if (bool3)
    {
      int i = this.jdField_e_of_type_Int;
      bool1 = bool2;
      if (i == 0) {
        break label66;
      }
      bool1 = bool2;
      if (i == 2) {
        break label66;
      }
      if (i == 3)
      {
        bool1 = bool2;
        break label66;
      }
    }
    boolean bool1 = false;
    label66:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowCertificateBanner result = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",showFlag = ");
      ((StringBuilder)localObject).append(bool3);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public String i()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean i()
  {
    ExpandConfig localExpandConfig = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a();
    boolean bool = false;
    if (localExpandConfig == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().bLimitchatOpen == 1) {
      bool = true;
    }
    return bool;
  }
  
  public String j()
  {
    SchoolInfo localSchoolInfo = this.jdField_a_of_type_ComTencentMobileqqProfileSchoolInfo;
    if (localSchoolInfo != null) {
      return localSchoolInfo.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a();
    boolean bool = true;
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.a().bVoiceMatchOpen != 1)) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bVoiceMatchOpen  ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public String k()
  {
    String str2 = this.jdField_d_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public boolean k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getIsExtendFriendUsing ");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    QLog.i("ExtendFriendManager", 2, localStringBuilder.toString());
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean l()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_used_new_match", false);
  }
  
  public boolean m()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_has_personal_labels", false);
  }
  
  public boolean n()
  {
    return SharedPreUtils.a(a().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_first_prompt_extend_friend_new_user", true);
  }
  
  public boolean o()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager.e();
    return false;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader;
    if (localObject != null)
    {
      ((ExtendFriendResourceDownloader)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader.a(null);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader = null;
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginPreloadExpandPluginPreloadManager.b();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedCacheData = null;
    localObject = this.jdField_a_of_type_AndroidUtilLruCache;
    if (localObject != null) {
      ((LruCache)localObject).evictAll();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository;
    if (localObject != null) {
      ((ExpandChatRepository)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandCmdHandler;
    if (localObject != null) {
      ((ExpandCmdHandler)localObject).a();
    }
  }
  
  public boolean p()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerActiveUserManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager
 * JD-Core Version:    0.7.0.1
 */