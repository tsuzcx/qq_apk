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
import com.tencent.commonsdk.util.notification.QQNotificationManager;
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
  private final ExpandChatRepository A;
  private final ExpandCmdHandler B;
  private final ExpandConfigManager C;
  private int D;
  private String E = "";
  private boolean F = false;
  private volatile boolean G = false;
  private oidb_0xdb1.SchoolInfo H;
  private SchoolInfo I;
  private long J = 0L;
  private volatile boolean K = false;
  private final ProfileCardObserver L = new ExpandManager.1(this);
  private final ExpandObserver M = new ExpandManager.2(this);
  private volatile boolean N = false;
  private volatile boolean O = false;
  private volatile long P = 0L;
  private final Object Q = new Object();
  private List<ExtendFriendSignalBombCardData> R;
  private int S = 0;
  public String a;
  private CacheData b;
  private final ExpandPluginPreloadManager c = new ExpandPluginPreloadManager();
  private final ActiveUserManager d = new ActiveUserManager();
  private QQAppInterface e;
  private ExtendFriendResourceDownloader f;
  private ExpandResourceDownloader g;
  private final ExtendFriendSearchHistoryManager h;
  private final ExtendFriendSearchHistoryManager i;
  private int j;
  private String k;
  private boolean l;
  private final LruCache<String, ExpandUserInfo> m = new LruCache(50);
  private final EntityManager n;
  private final ArrayList<String> o = new ArrayList();
  private final ArrayList<String> p = new ArrayList();
  private int q;
  private int r;
  private long s = 0L;
  private int t = 0;
  private String u = "";
  private long v;
  private long w;
  private String x = "";
  private final List<CompletePesonalDataTask> y = new ArrayList();
  private final ColdPalaceHelper z;
  
  static
  {
    ExpandReportUtils.a();
    QLog.i("ExtendFriendManager", 1, "init expand tunnel");
  }
  
  public ExpandManager(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    this.e.addObserver(this.L);
    this.e.addObserver(this.M);
    this.A = new ExpandChatRepository(this.e);
    this.B = new ExpandCmdHandler(this.e);
    this.C = new ExpandConfigManager(this.e);
    this.f = new ExtendFriendResourceDownloader(this.e);
    this.f.a(this);
    this.h = new ExtendFriendSearchHistoryManager(this.e, 2);
    this.i = new ExtendFriendSearchHistoryManager(this.e, 1);
    this.n = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.z = new ColdPalaceHelper(paramQQAppInterface);
    this.c.a();
    QQNotificationManager.getInstance().createLimitChatNotificationChannel();
    ThreadManager.postImmediately(new ExpandManager.3(this), null, true);
  }
  
  private void a(Context paramContext, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    if (paramExtendFriendGetLocationListener == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync start");
    }
    if ((NetworkUtil.isNetSupport(paramContext)) && (af()))
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.P < 3600000L)
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
      this.P = l1;
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new ExpandManager.12(this, "extend_friend", false, paramExtendFriendGetLocationListener));
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
      this.I = new SchoolInfo();
      Object localObject = this.I;
      boolean bool = paramSchoolInfo.uint32_idx.has();
      int i2 = 0;
      if (bool) {
        i1 = paramSchoolInfo.uint32_idx.get();
      } else {
        i1 = 0;
      }
      ((SchoolInfo)localObject).a = i1;
      localObject = this.I;
      int i1 = i2;
      if (paramSchoolInfo.uint32_category.has()) {
        i1 = paramSchoolInfo.uint32_category.get();
      }
      ((SchoolInfo)localObject).b = i1;
      SchoolInfo localSchoolInfo = this.I;
      bool = paramSchoolInfo.str_school_id.has();
      String str = "";
      if (bool) {
        localObject = paramSchoolInfo.str_school_id.get();
      } else {
        localObject = "";
      }
      localSchoolInfo.c = ((String)localObject);
      localSchoolInfo = this.I;
      localObject = str;
      if (paramSchoolInfo.str_school_name.has()) {
        localObject = paramSchoolInfo.str_school_name.get();
      }
      localSchoolInfo.d = ((String)localObject);
      return;
    }
    this.I = null;
  }
  
  private void a(boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    paramExtendFriendGetLocationListener.a(paramBoolean, ExtendFriendLocationInfo.a(paramSosoLbsInfo));
  }
  
  public static boolean af()
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
  
  private void ah()
  {
    QQAppInterface localQQAppInterface = this.e;
    if (localQQAppInterface != null) {
      this.G = SharedPreUtils.a(localQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_is_user_student", false);
    }
  }
  
  private void ai()
  {
    if (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))
    {
      QLog.i("ExtendFriendManager", 1, "preDownloadExpandPlugin(): won't preload plugin, wifi not connected!");
      return;
    }
    if (!QFlutterResConfigProcessor.b(ExpandModuleKey.ExpandPluginPreDownload))
    {
      QLog.i("ExtendFriendManager", 1, "preDownloadExpandPlugin(): manage system won't allow preload expand plugin!");
      return;
    }
    Object localObject = this.e;
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
    ((IPluginManager)localObject).a("expand", new ExpandManager.6(this), "extend_friend_manager");
  }
  
  private void aj()
  {
    ThreadManager.getUIHandlerV2().postDelayed(new ExpandManager.7(this), TimeUnit.SECONDS.toMillis(10L));
  }
  
  private void ak()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.w("ExtendFriendManager", 1, "checkToDownloadResource mApp=null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s", new Object[] { this.C.a() }));
    }
    if (this.C.e())
    {
      ExpandConfig localExpandConfig = this.C.a();
      if (localExpandConfig == null)
      {
        QLog.e("ExtendFriendManager", 1, "you should not be here!");
        return;
      }
      ExpandResourceDownloader localExpandResourceDownloader = this.g;
      if (localExpandResourceDownloader != null) {
        localExpandResourceDownloader.c();
      }
      this.g = new ExpandResourceDownloader((QQAppInterface)localObject, localExpandConfig.flutterResUrl, localExpandConfig.flutterResMd5, new ExpandManager.8(this));
      if ((!i()) && (!this.g.a())) {
        this.g.b();
      }
      aj();
    }
    else if (this.C.f())
    {
      ai();
      al();
    }
    if (this.C.a() != null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        try
        {
          ((ExtendFriendResourceDownloader)localObject).a(this.C.a().mResourceURL, this.C.a().mResourceMD5);
          if (!this.f.b())
          {
            this.f.c();
            c(false);
          }
          else
          {
            c(true);
          }
        }
        catch (Exception localException)
        {
          QLog.e("ExtendFriendManager", 1, "checkToDownloadResource fail.", localException);
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mResourceReady=%s", new Object[] { Boolean.valueOf(this.l) }));
        return;
      }
    }
    if (this.C.a() == null)
    {
      QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig is null", new Object[0]));
      return;
    }
    QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mDownloader is null", new Object[0]));
  }
  
  private void al()
  {
    boolean bool = ExpandPreloadUtils.a(ExpandModuleKey.ExpandPluginPreInstall);
    this.c.a(bool);
  }
  
  private void am()
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
    if ((this.C.a() != null) && (!TextUtils.isEmpty(this.C.a().expandExamImg)))
    {
      localObject = new DownloadTask(this.C.a().expandExamImg, localFile);
      int i1 = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject, this.e);
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
        }
      }
      else {
        QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i1) }));
      }
    }
    else
    {
      QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
    }
  }
  
  private void an()
  {
    Object localObject = this.e;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        localObject = ((FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.e.getCurrentUin());
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
          if (this.b != null)
          {
            this.b.b = bool1;
            this.b.c = bool2;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", localException);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { this.b }));
      }
      return;
      label157:
      boolean bool1 = false;
    }
  }
  
  private void ao()
  {
    Object localObject1 = this.e;
    if (localObject1 == null)
    {
      QLog.e("ExtendFriendManager", 2, "checkFirstEnterExtendFriendEveryDay : mApp is null!");
      return;
    }
    localObject1 = SharedPreUtils.a(((QQAppInterface)localObject1).getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = ((SharedPreferences)localObject1).getLong("sp_extend_friend_first_enter_everyday", 0L);
    long l2 = MessageCache.c();
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
  
  private void ap()
  {
    Object localObject1 = SharedPreUtils.a(this.e.getCurrentAccountUin(), "extend_friend_config_785");
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
        long l2 = MessageCache.c();
        ReportController.b(this.e, "dc00898", "", "", "0X800AE99", "0X800AE99", 0, 0, String.valueOf(l2 - l1), "", "", "");
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
  
  private static int b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    int i1 = 0;
    if (paramBaseQQAppInterface != null) {
      i1 = SharedPreUtils.a(paramBaseQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_forbid_flag", 0);
    }
    return i1;
  }
  
  public static QQAppInterface b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private JSONObject b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
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
  
  private void b(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    int i1 = paramGetUserStatusRsp.Category.get();
    boolean bool1 = paramGetUserStatusRsp.UsedNewMatch.get();
    boolean bool2 = paramGetUserStatusRsp.HasPersonalLabels.get();
    if (QLog.isColorLevel())
    {
      paramGetUserStatusRsp = new StringBuilder();
      paramGetUserStatusRsp.append("updateUserCategory category ： ");
      paramGetUserStatusRsp.append(i1);
      paramGetUserStatusRsp.append("，usedNewMatch ：");
      paramGetUserStatusRsp.append(bool1);
      paramGetUserStatusRsp.append("，hasPersonalLabels ：");
      paramGetUserStatusRsp.append(bool2);
      QLog.w("ExtendFriendManager", 2, paramGetUserStatusRsp.toString());
    }
    paramGetUserStatusRsp = SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").edit();
    paramGetUserStatusRsp.putInt("sp_extend_friend_user_category", i1);
    paramGetUserStatusRsp.putBoolean("sp_extend_friend_used_new_match", bool1);
    paramGetUserStatusRsp.putBoolean("sp_extend_friend_has_personal_labels", bool2);
    paramGetUserStatusRsp.apply();
  }
  
  private static long c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    long l1 = 0L;
    if (paramBaseQQAppInterface != null) {
      l1 = SharedPreUtils.a(paramBaseQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getLong("sp_extend_friend_forbid_end_time", 0L);
    }
    return l1;
  }
  
  private void f(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.e;
    if (localQQAppInterface == null) {
      return;
    }
    ((ExpandHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void g(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.e;
    if (localQQAppInterface == null) {
      return;
    }
    SharedPreUtils.a(localQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_is_user_student", paramBoolean).commit();
  }
  
  private void h(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setExtendFriendUsing o ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendManager", 2, localStringBuilder.toString());
    this.O = paramBoolean;
  }
  
  public String A()
  {
    if ((this.C.c()) && (this.C.a() != null)) {
      return this.C.a().matchChatGrayTipsMsg;
    }
    return "";
  }
  
  public String B()
  {
    if ((this.C.c()) && (this.C.a() != null)) {
      return this.C.a().matchChatGrayTipsLight;
    }
    return "";
  }
  
  public boolean C()
  {
    int i1;
    if ((this.C.c()) && (this.C.a() != null)) {
      i1 = this.C.a().matchChatIceBreakSwitch;
    } else {
      i1 = 1;
    }
    return i1 == 1;
  }
  
  public String D()
  {
    if ((this.C.c()) && (this.C.a() != null)) {
      return this.C.a().mBeatWarning;
    }
    return "";
  }
  
  public boolean E()
  {
    return q().g();
  }
  
  public boolean F()
  {
    return this.C.f();
  }
  
  public int G()
  {
    if ((this.C.c()) && (this.C.a() != null)) {
      return this.C.a().tabIndex;
    }
    return 0;
  }
  
  public int H()
  {
    return this.D;
  }
  
  public String I()
  {
    return this.E;
  }
  
  public String J()
  {
    SchoolInfo localSchoolInfo = this.I;
    if (localSchoolInfo != null) {
      return localSchoolInfo.d;
    }
    return "";
  }
  
  public boolean K()
  {
    Object localObject = this.e;
    boolean bool2 = true;
    if (localObject == null)
    {
      QLog.w("ExtendFriendManager", 1, "call isNeedShowCertificateBanner after manager destroy!");
      return false;
    }
    boolean bool3 = CampusHelper.c((QQAppInterface)localObject);
    if (bool3)
    {
      int i1 = this.D;
      bool1 = bool2;
      if (i1 == 0) {
        break label66;
      }
      bool1 = bool2;
      if (i1 == 2) {
        break label66;
      }
      if (i1 == 3)
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
  
  public boolean L()
  {
    ExpandConfig localExpandConfig = this.C.a();
    boolean bool = false;
    if (localExpandConfig == null) {
      return false;
    }
    if (this.C.a().bLimitchatOpen == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateMatchChatConfig ");
    }
    QQAppInterface localQQAppInterface = this.e;
    if (localQQAppInterface == null) {
      return;
    }
    ((ExpandHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(18, true, null);
  }
  
  public ArrayList<ExpandBannerConfBean.BannerItem> N()
  {
    return ExpandBannerProcessor.a().a();
  }
  
  public void O()
  {
    this.m.evictAll();
    EntityManager localEntityManager = this.n;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.n.drop(ExpandUserInfo.class);
    }
  }
  
  public boolean P()
  {
    Object localObject = this.C.a();
    boolean bool = true;
    if ((localObject == null) || (this.C.a().bVoiceMatchOpen != 1)) {
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
  
  public int Q()
  {
    int i1;
    if ((this.C.c()) && (this.C.a() != null))
    {
      int i2 = this.C.a().coldPalaceGrayTipPosition;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("coldPalaceGrayTipPosition  ");
        localStringBuilder.append(i2);
        QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
        return i2;
      }
    }
    else
    {
      i1 = 1;
    }
    return i1;
  }
  
  public SchoolInfo R()
  {
    return this.I;
  }
  
  public boolean S()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getIsExtendFriendUsing ");
    localStringBuilder.append(this.O);
    QLog.i("ExtendFriendManager", 2, localStringBuilder.toString());
    return this.O;
  }
  
  public void T()
  {
    if (this.e == null) {
      return;
    }
    h(true);
    a(this.e.getApp().getBaseContext(), new ExpandManager.10(this));
    ao();
  }
  
  public void U()
  {
    h(false);
    QQAppInterface localQQAppInterface = this.e;
    if (localQQAppInterface != null) {
      ((ExpandHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).d();
    }
  }
  
  public ExtendFriendLocationInfo V()
  {
    Object localObject = this.e;
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
    long l1 = System.currentTimeMillis();
    if ((NetworkUtil.isNetSupport(this.e.getApp().getBaseContext())) && (af()) && (l1 - this.P > 3600000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync start");
      }
      this.P = l1;
      ThreadManager.getSubThreadHandler().post(new ExpandManager.13(this));
    }
    return localExtendFriendLocationInfo;
  }
  
  public void W()
  {
    synchronized (this.Q)
    {
      if (this.R != null) {
        this.R.clear();
      }
      return;
    }
  }
  
  public int X()
  {
    return SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_user_category", 0);
  }
  
  public boolean Y()
  {
    return SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_used_new_match", false);
  }
  
  public boolean Z()
  {
    return SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_has_personal_labels", false);
  }
  
  public int a()
  {
    return this.S;
  }
  
  public ExpandUserInfo a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("ExtendFriendManager", 1, "getExtendFriendUserInfoCache but uin is empty");
      return null;
    }
    ExpandUserInfo localExpandUserInfo2 = (ExpandUserInfo)this.m.get(paramString);
    ExpandUserInfo localExpandUserInfo1 = localExpandUserInfo2;
    if (localExpandUserInfo2 == null)
    {
      localExpandUserInfo1 = localExpandUserInfo2;
      if (paramBoolean)
      {
        localExpandUserInfo2 = e(paramString);
        localExpandUserInfo1 = localExpandUserInfo2;
        if (localExpandUserInfo2 != null)
        {
          this.m.put(paramString, localExpandUserInfo2);
          localExpandUserInfo1 = localExpandUserInfo2;
        }
      }
    }
    return localExpandUserInfo1;
  }
  
  public void a(int paramInt)
  {
    this.S = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCampusCertificateStatus campusCertificateStatus = ");
      localStringBuilder.append(this.D);
      localStringBuilder.append(",new status = ");
      localStringBuilder.append(paramInt1);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
    this.D = paramInt1;
    CampusHelper.a(this.e, paramInt1, paramInt2);
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
      this.I = null;
      return;
    }
    if (this.I == null) {
      this.I = new SchoolInfo();
    }
    Object localObject = this.I;
    ((SchoolInfo)localObject).a = paramInt1;
    ((SchoolInfo)localObject).d = paramString1;
    ((SchoolInfo)localObject).c = paramString2;
    ((SchoolInfo)localObject).b = paramInt2;
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandManager.9(this));
  }
  
  public void a(CacheData paramCacheData)
  {
    this.b = paramCacheData;
  }
  
  public void a(MatchInfo paramMatchInfo)
  {
    if (paramMatchInfo == null)
    {
      QLog.e("ExtendFriendManager", 2, "updateSignalBombPush : matchInfo is null!");
      return;
    }
    Object localObject1 = this.e;
    if (localObject1 == null)
    {
      QLog.e("ExtendFriendManager", 2, "updateSignalBombPush : mApp is null!");
      return;
    }
    ((QQAppInterface)localObject1).getMsgCache().b(paramMatchInfo.c, paramMatchInfo.a, paramMatchInfo.b);
    int i1;
    if (S())
    {
      a(ExtendFriendSignalBombCardData.a(paramMatchInfo));
      if (paramMatchInfo.k != null)
      {
        localObject2 = this.e;
        str = paramMatchInfo.c;
        i1 = paramMatchInfo.k.s;
        if (this.G) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        ReportController.b((AppRuntime)localObject2, "dc00898", "", str, "0X800AE9A", "0X800AE9A", i1, 0, "", (String)localObject1, paramMatchInfo.k.t, paramMatchInfo.k.u);
      }
      ap();
    }
    LimitChatUtil.c(this.e, paramMatchInfo.c);
    LimitChatUtil.a(this.e, paramMatchInfo.c, 1044);
    if (!((FriendsManager)this.e.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramMatchInfo.c)) {
      LimitChatUtil.a(this.e, paramMatchInfo, paramMatchInfo.e, 1);
    } else {
      QLog.d("ExtendFriendManager", 1, "updateSignalBombPush already friend.");
    }
    localObject1 = this.e;
    Object localObject2 = paramMatchInfo.c;
    int i2 = paramMatchInfo.i;
    String str = paramMatchInfo.j;
    boolean bool = TextUtils.isEmpty(paramMatchInfo.d);
    if (paramMatchInfo.k != null) {
      i1 = paramMatchInfo.k.r;
    } else {
      i1 = -1;
    }
    LimitChatUtil.a((QQAppInterface)localObject1, (String)localObject2, i2, str, bool ^ true, i1, true, 4);
    ContactUtils.a(this.e, paramMatchInfo.c, true);
  }
  
  public void a(ExpandUserInfo paramExpandUserInfo)
  {
    if ((paramExpandUserInfo != null) && (!TextUtils.isEmpty(paramExpandUserInfo.uin)))
    {
      this.m.put(paramExpandUserInfo.uin, paramExpandUserInfo);
      Object localObject = this.n;
      if ((localObject != null) && (((EntityManager)localObject).isOpen())) {
        if (paramExpandUserInfo.getStatus() == 1000) {
          this.n.persistOrReplace(paramExpandUserInfo);
        } else if (paramExpandUserInfo.getStatus() == 1001) {
          this.n.update(paramExpandUserInfo);
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
    this.C.a(paramIConfigCallback);
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
      synchronized (this.Q)
      {
        if (this.R == null) {
          this.R = new ArrayList(5);
        }
        this.R.add(0, paramExtendFriendSignalBombCardData);
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
      paramAppInfo = b(paramAppInfo);
      if (paramAppInfo != null) {
        try
        {
          this.x = paramAppInfo.optJSONObject("waves").optString("waves_type");
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
      this.x = "";
      return;
    }
    this.x = "";
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_0xdb1.RspBody paramRspBody)
  {
    boolean bool1 = paramRspBody.enum_school_verify_status.has();
    int i4 = 0;
    int i1;
    if (bool1) {
      i1 = paramRspBody.enum_school_verify_status.get();
    } else {
      i1 = 0;
    }
    if (paramRspBody.str_school_verify_tips.has()) {
      paramFromServiceMsg = paramRspBody.str_school_verify_tips.get();
    } else {
      paramFromServiceMsg = "";
    }
    bool1 = TextUtils.isEmpty(paramFromServiceMsg);
    boolean bool2 = true;
    int i2;
    if (bool1) {
      i2 = 1;
    } else {
      i2 = 2;
    }
    a(i1, i2);
    if (paramRspBody.uint32_user_identity.has()) {
      i2 = paramRspBody.uint32_user_identity.get();
    } else {
      i2 = 0;
    }
    if (i2 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.G = bool1;
    g(this.G);
    if (paramRspBody.uint32_need_display_school_info.has()) {
      i2 = paramRspBody.uint32_need_display_school_info.get();
    } else {
      i2 = 0;
    }
    if (i2 == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.F = bool1;
    bool1 = paramRspBody.msg_new_school_info.has();
    ArrayList localArrayList1 = null;
    Object localObject1;
    if (bool1) {
      localObject1 = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_new_school_info.get();
    } else {
      localObject1 = null;
    }
    this.H = ((oidb_0xdb1.SchoolInfo)localObject1);
    if (paramRspBody.str_suggest_school_name.has()) {
      localObject1 = paramRspBody.str_suggest_school_name.get();
    } else {
      localObject1 = "";
    }
    this.E = ((String)localObject1);
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
      i2 = paramRspBody.uint32_online_num.get();
    } else {
      i2 = 0;
    }
    this.q = i2;
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
    int i3;
    if (paramRspBody.uint32_forbid_flag.has()) {
      i3 = paramRspBody.uint32_forbid_flag.get();
    } else {
      i3 = 0;
    }
    long l1;
    if (paramRspBody.uint32_forbid_end_time.has()) {
      l1 = paramRspBody.uint32_forbid_end_time.get();
    } else {
      l1 = 0L;
    }
    a(this.e, i3, l1);
    if (paramRspBody.bytes_birthday.has()) {
      i4 = ByteBuffer.wrap(paramRspBody.bytes_birthday.get().toByteArray()).getInt();
    }
    this.r = i4;
    a(paramRspBody);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetExtendFriendPermissionAndStatusResponse. ,verifyStatus = ");
      paramToServiceMsg.append(i1);
      paramToServiceMsg.append(",verifyTips = ");
      paramToServiceMsg.append(paramFromServiceMsg);
      paramToServiceMsg.append(",serverSuggestSchoolName = ");
      paramToServiceMsg.append(this.E);
      paramToServiceMsg.append(",schoolNameInExtendFriendCard = ");
      paramToServiceMsg.append((String)localObject1);
      paramToServiceMsg.append(",onlineNumber = ");
      paramToServiceMsg.append(i2);
      paramToServiceMsg.append(",needShowEduBackgroundUpdateDialog = ");
      paramToServiceMsg.append(this.F);
      paramToServiceMsg.append(",profileNewSchoolInfo = ");
      paramToServiceMsg.append(this.H);
      paramToServiceMsg.append(",isUserStudentOrNot = ");
      paramToServiceMsg.append(this.G);
      paramToServiceMsg.append(",userBirthday = ");
      paramToServiceMsg.append(this.r);
      paramToServiceMsg.append(",forbidFlag = ");
      paramToServiceMsg.append(i3);
      paramToServiceMsg.append(",forbidEndTime = ");
      paramToServiceMsg.append(l1);
      QLog.d("ExtendFriendManager", 2, paramToServiceMsg.toString());
    }
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").edit().putInt(paramString, paramInt).apply();
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
    QQAppInterface localQQAppInterface = this.e;
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
      this.p.clear();
      this.p.addAll(paramList2);
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
    this.v = l1;
    long l1 = l2;
    if (paramRspBody.uint64_matched_times.has()) {
      l1 = paramRspBody.uint64_matched_times.get();
    }
    this.w = l1;
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
        localCompletePesonalDataTask.a = 1;
        localCompletePesonalDataTask.b = paramRspBody.msg_base_info.uint32_task_match_times.get();
        localCompletePesonalDataTask.c = paramRspBody.msg_base_info.str_msg.get();
        localCompletePesonalDataTask.d = paramRspBody.msg_base_info.uint32_task_status.get();
        localArrayList.add(localCompletePesonalDataTask);
      }
      if (paramRspBody.msg_kuolie_school.has())
      {
        localCompletePesonalDataTask = new CompletePesonalDataTask();
        localCompletePesonalDataTask.a = 2;
        localCompletePesonalDataTask.b = paramRspBody.msg_kuolie_school.uint32_task_match_times.get();
        localCompletePesonalDataTask.c = paramRspBody.msg_kuolie_school.str_msg.get();
        localCompletePesonalDataTask.d = paramRspBody.msg_kuolie_school.uint32_task_status.get();
        localArrayList.add(localCompletePesonalDataTask);
      }
      if (paramRspBody.msg_kuolie_declaration.has())
      {
        localCompletePesonalDataTask = new CompletePesonalDataTask();
        localCompletePesonalDataTask.a = 3;
        localCompletePesonalDataTask.b = paramRspBody.msg_kuolie_declaration.uint32_task_match_times.get();
        localCompletePesonalDataTask.c = paramRspBody.msg_kuolie_declaration.str_msg.get();
        localCompletePesonalDataTask.d = paramRspBody.msg_kuolie_declaration.uint32_task_status.get();
        localArrayList.add(localCompletePesonalDataTask);
      }
      if (paramRspBody.msg_personal_label.has())
      {
        localCompletePesonalDataTask = new CompletePesonalDataTask();
        localCompletePesonalDataTask.a = 4;
        localCompletePesonalDataTask.b = paramRspBody.msg_personal_label.uint32_task_match_times.get();
        localCompletePesonalDataTask.c = paramRspBody.msg_personal_label.str_msg.get();
        localCompletePesonalDataTask.d = paramRspBody.msg_personal_label.uint32_task_status.get();
        localArrayList.add(localCompletePesonalDataTask);
      }
      if (paramRspBody.msg_photo.has())
      {
        localCompletePesonalDataTask = new CompletePesonalDataTask();
        localCompletePesonalDataTask.a = 5;
        localCompletePesonalDataTask.b = paramRspBody.msg_photo.uint32_task_match_times.get();
        localCompletePesonalDataTask.c = paramRspBody.msg_photo.str_msg.get();
        localCompletePesonalDataTask.d = paramRspBody.msg_photo.uint32_task_status.get();
        localArrayList.add(localCompletePesonalDataTask);
      }
    }
    this.y.clear();
    this.y.addAll(localArrayList);
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("updateMatchChatCompletePersonalDataTaskBy0xdb1 ,maxMatchCount");
      paramRspBody.append(this.v);
      paramRspBody.append(",matchedCount");
      paramRspBody.append(this.w);
      paramRspBody.append(",completePesonalDataTasks");
      paramRspBody.append(this.y);
      QLog.d("ExtendFriendManager", 2, paramRspBody.toString());
    }
  }
  
  public void a(oidb_0xe03.RspBody paramRspBody)
  {
    int i1;
    if (paramRspBody.enum_matchopretcode.has()) {
      i1 = paramRspBody.enum_matchopretcode.get();
    } else {
      i1 = -1;
    }
    long l1 = 0L;
    if (12 == i1)
    {
      long l2;
      if (paramRspBody.uint64_max_match_times.has()) {
        l2 = paramRspBody.uint64_max_match_times.get();
      } else {
        l2 = 0L;
      }
      this.v = l2;
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.w = l1;
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
          localCompletePesonalDataTask.a = 1;
          localCompletePesonalDataTask.b = paramRspBody.msg_base_info.uint32_task_match_times.get();
          localCompletePesonalDataTask.c = paramRspBody.msg_base_info.str_msg.get();
          localCompletePesonalDataTask.d = paramRspBody.msg_base_info.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_kuolie_school.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.a = 2;
          localCompletePesonalDataTask.b = paramRspBody.msg_kuolie_school.uint32_task_match_times.get();
          localCompletePesonalDataTask.c = paramRspBody.msg_kuolie_school.str_msg.get();
          localCompletePesonalDataTask.d = paramRspBody.msg_kuolie_school.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_kuolie_declaration.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.a = 3;
          localCompletePesonalDataTask.b = paramRspBody.msg_kuolie_declaration.uint32_task_match_times.get();
          localCompletePesonalDataTask.c = paramRspBody.msg_kuolie_declaration.str_msg.get();
          localCompletePesonalDataTask.d = paramRspBody.msg_kuolie_declaration.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_personal_label.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.a = 4;
          localCompletePesonalDataTask.b = paramRspBody.msg_personal_label.uint32_task_match_times.get();
          localCompletePesonalDataTask.c = paramRspBody.msg_personal_label.str_msg.get();
          localCompletePesonalDataTask.d = paramRspBody.msg_personal_label.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
        if (paramRspBody.msg_photo.has())
        {
          localCompletePesonalDataTask = new CompletePesonalDataTask();
          localCompletePesonalDataTask.a = 5;
          localCompletePesonalDataTask.b = paramRspBody.msg_photo.uint32_task_match_times.get();
          localCompletePesonalDataTask.c = paramRspBody.msg_photo.str_msg.get();
          localCompletePesonalDataTask.d = paramRspBody.msg_photo.uint32_task_status.get();
          localArrayList.add(localCompletePesonalDataTask);
        }
      }
      this.y.clear();
      this.y.addAll(localArrayList);
    }
    else if (i1 == 0)
    {
      if (paramRspBody.uint64_matched_times.has()) {
        l1 = paramRspBody.uint64_matched_times.get();
      }
      this.w = l1;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("updateMatchChatCompletePersonalDataTaskBy0xe03 ,retCode ");
      paramRspBody.append(i1);
      paramRspBody.append(",maxMatchCount ");
      paramRspBody.append(this.v);
      paramRspBody.append(",matchedCount ");
      paramRspBody.append(this.w);
      paramRspBody.append(",completePesonalDataTasks ");
      paramRspBody.append(this.y);
      QLog.d("ExtendFriendManager", 2, paramRspBody.toString());
    }
  }
  
  public void a(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    b(paramGetUserStatusRsp);
    this.d.a(paramGetUserStatusRsp);
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("onResourceDownloadComplete mResourceReady=%s", new Object[] { Boolean.valueOf(this.l) }));
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "onResourceDownloadComplete FAILED!");
    }
  }
  
  public boolean a(Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if ((paramActivity != null) && (paramBaseQQAppInterface != null))
    {
      if (paramActivity.isFinishing()) {
        return false;
      }
      int i1 = b(paramBaseQQAppInterface);
      if (i1 == 0) {
        return false;
      }
      long l1 = c(paramBaseQQAppInterface) - NetConnInfoCenter.getServerTime();
      boolean bool;
      if ((i1 == 1) && (l1 <= 8640000L)) {
        bool = false;
      } else {
        bool = true;
      }
      if ((!bool) && (l1 <= 0L))
      {
        a(paramBaseQQAppInterface, 0, 0L);
        return false;
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      SpannableStringBuilder localSpannableStringBuilder = ((IExpandForbiddenUtils)QRoute.api(IExpandForbiddenUtils.class)).getForbidDialogMessage(paramActivity, paramActivity.getString(2131896786), bool, l1, true);
      localQQCustomDialog.setTitle(paramActivity.getString(2131896789)).setMessage(localSpannableStringBuilder).setPositiveButton(paramActivity.getString(2131896785), new ExpandManager.15(this, paramActivity)).setOnKeyListener(new ExpandManager.14(this, paramActivity));
      localQQCustomDialog.show();
      ReportController.b(paramBaseQQAppInterface, "dc00898", "", "", "0X800B076", "0X800B076", (int)(l1 / 86400L), 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (this.e == null)
    {
      QLog.e("ExtendFriendManager", 1, "isShowExpandEntry: mApp is null!");
      return false;
    }
    boolean bool = ExpandChatUtil.b(paramBaseQQAppInterface);
    if ((bool) && (!this.K))
    {
      this.K = true;
      ((ILebaHelperService)this.e.getRuntimeService(ILebaHelperService.class, "")).notifyPluginListChanged();
      long l1 = SystemClock.uptimeMillis() - this.J;
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("begin show Entry. time cost=");
      paramBaseQQAppInterface.append(l1);
      paramBaseQQAppInterface.append(" ms");
      QLog.i("ExtendFriendManagerexpand.enter.", 1, paramBaseQQAppInterface.toString());
      paramBaseQQAppInterface = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
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
      paramExpandConfig = this.e;
      if (paramExpandConfig == null) {
        return false;
      }
      try
      {
        int i1 = SharedPreUtils.a(paramExpandConfig.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_contact", 0);
        int i2 = ExpandSharePreUtils.b(this.e.getCurrentAccountUin());
        if ((i1 == 1) && (i2 == 1)) {
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
  
  public boolean aa()
  {
    return SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_first_prompt_extend_friend_new_user", true);
  }
  
  public String ab()
  {
    String str2 = this.x;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public boolean ac()
  {
    this.C.h();
    return false;
  }
  
  public boolean ad()
  {
    return this.d.b();
  }
  
  public void ae()
  {
    this.d.a();
  }
  
  public List<String> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      Object localObject = this.e;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ExtendFriendManager", 2, String.format("getDefaultTags app is null check here!", new Object[0]));
        }
        return localArrayList;
      }
      localObject = QZoneUnreadServletLogic.c(((QQAppInterface)localObject).getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("getDefaultTags campusHotTags=%s", new Object[] { Arrays.toString((Object[])localObject) }));
      }
      if ((localObject != null) && (localObject.length > 0))
      {
        this.o.clear();
        this.o.addAll(Arrays.asList((Object[])localObject));
      }
      paramInt = this.o.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 10);
        localArrayList.addAll(this.o.subList(0, paramInt));
      }
    }
    else
    {
      paramInt = this.p.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.p.subList(0, paramInt));
      }
    }
    localArrayList.add(0, "推荐");
    return localArrayList;
  }
  
  public void b(String paramString)
  {
    this.u = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new ExpandManager.4(this, paramBoolean));
  }
  
  public String c()
  {
    return this.a;
  }
  
  public List<String> c(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      if (this.o.size() > 0)
      {
        localArrayList.addAll(this.o);
        return localArrayList;
      }
    }
    else if (this.p.size() > 0) {
      localArrayList.addAll(this.p);
    }
    return localArrayList;
  }
  
  public void c(String paramString)
  {
    this.C.b(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
    f(paramBoolean);
  }
  
  public ColdPalaceHelper d()
  {
    return this.z;
  }
  
  public void d(int paramInt) {}
  
  public void d(String paramString)
  {
    this.C.a(paramString);
    if (this.C.a() == null) {
      paramString = null;
    } else {
      paramString = this.C.a().limitChatResList;
    }
    boolean bool = ExpandLimitChatResourceUtil.a(paramString);
    ThreadManager.getSubThreadHandler().post(new ExpandManager.5(this, bool));
  }
  
  public void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").edit();
    localEditor.putBoolean("sp_extend_friend_has_personal_labels", paramBoolean);
    localEditor.commit();
  }
  
  public ExpandUserInfo e(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    EntityManager localEntityManager = this.n;
    Object localObject1 = localObject2;
    if (localEntityManager != null)
    {
      localObject1 = localObject2;
      if (localEntityManager.isOpen()) {
        localObject1 = (ExpandUserInfo)this.n.find(ExpandUserInfo.class, paramString);
      }
    }
    return localObject1;
  }
  
  public void e()
  {
    this.w += 1L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("increaseMatchedCount matchedCount = ");
      localStringBuilder.append(this.w);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_first_prompt_extend_friend_new_user", paramBoolean).apply();
  }
  
  public int f(String paramString)
  {
    return SharedPreUtils.a(b().getCurrentAccountUin(), "extend_friend_config_785").getInt(paramString, 0);
  }
  
  public String f()
  {
    return this.u;
  }
  
  public String g()
  {
    ExpandResourceDownloader localExpandResourceDownloader = this.g;
    if (localExpandResourceDownloader == null) {
      return "";
    }
    return localExpandResourceDownloader.d();
  }
  
  public void h()
  {
    if ((this.g != null) && (!i())) {
      this.g.e();
    }
  }
  
  public boolean i()
  {
    boolean bool = DeviceInfoUtils.isLowPerfDevice();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isLowPerfDevice:  ");
      localStringBuilder.append(bool);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void j()
  {
    this.C.d();
  }
  
  public ExtendFriendSearchHistoryManager k()
  {
    return this.h;
  }
  
  public ExtendFriendSearchHistoryManager l()
  {
    return this.i;
  }
  
  public CacheData m()
  {
    return this.b;
  }
  
  public boolean n()
  {
    return this.G;
  }
  
  public ExpandChatRepository o()
  {
    return this.A;
  }
  
  public void onDestroy()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.L);
      this.e.removeObserver(this.M);
    }
    this.e = null;
    localObject = this.f;
    if (localObject != null)
    {
      ((ExtendFriendResourceDownloader)localObject).d();
      this.f.a(null);
      this.f = null;
      this.l = false;
    }
    this.c.b();
    this.b = null;
    localObject = this.m;
    if (localObject != null) {
      ((LruCache)localObject).evictAll();
    }
    localObject = this.A;
    if (localObject != null) {
      ((ExpandChatRepository)localObject).a();
    }
    localObject = this.B;
    if (localObject != null) {
      ((ExpandCmdHandler)localObject).a();
    }
  }
  
  public ExpandCmdHandler p()
  {
    return this.B;
  }
  
  public ExpandConfigManager q()
  {
    return this.C;
  }
  
  public boolean r()
  {
    return this.C.j();
  }
  
  public int s()
  {
    return this.C.i();
  }
  
  @Nullable
  public ExpandConfig t()
  {
    return q().a();
  }
  
  public ExpandConfig u()
  {
    return this.C.b();
  }
  
  public int v()
  {
    if (this.j == 0)
    {
      ExpandConfig localExpandConfig = this.C.a();
      if ((localExpandConfig != null) && (localExpandConfig.maxPlayers > 0)) {
        this.j = (localExpandConfig.minPlayers + new Random().nextInt(localExpandConfig.maxPlayers - localExpandConfig.minPlayers));
      } else {
        this.j = new Random().nextInt(10000000);
      }
    }
    return this.j;
  }
  
  public String w()
  {
    if (TextUtils.isEmpty(this.k))
    {
      String str = String.valueOf(v());
      int i3 = str.length() + str.length() / 3;
      int i4 = str.length() % 3;
      int i2 = i3;
      int i1 = i4;
      if (i4 == 0)
      {
        i1 = i4 + 3;
        i2 = i3 - 1;
      }
      char[] arrayOfChar = new char[i2];
      i2 = 0;
      i3 = 0;
      while (i2 < arrayOfChar.length)
      {
        if (i2 == i1)
        {
          i1 += 4;
          arrayOfChar[i2] = ',';
          i3 += 1;
        }
        else
        {
          arrayOfChar[i2] = str.charAt(i2 - i3);
        }
        i2 += 1;
      }
      this.k = new String(arrayOfChar);
    }
    return this.k;
  }
  
  public boolean x()
  {
    if (!this.l) {
      QLog.e("ExtendFriendManager", 2, "isResourceReady NOT READY!");
    }
    return this.l;
  }
  
  public String y()
  {
    if (this.C.c())
    {
      localObject1 = t();
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
      localObject2 = HardCodeUtil.a(2131902296);
    }
    return localObject2;
  }
  
  public int z()
  {
    if ((this.C.c()) && (this.C.a() != null)) {
      return this.C.a().matchChatGrayTipsCount;
    }
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager
 * JD-Core Version:    0.7.0.1
 */