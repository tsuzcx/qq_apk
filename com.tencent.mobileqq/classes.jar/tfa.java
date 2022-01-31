import UserGrowth.stReportItem;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.3;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class tfa
{
  private static WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  public static final String a;
  public static final HashMap<String, String> a;
  private static tez jdField_a_of_type_Tez;
  private static String jdField_b_of_type_JavaLangString;
  private static HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static tez jdField_b_of_type_Tez;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131717294);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    return LocalMultiProcConfig.getInt("eventId", -1);
  }
  
  public static int a(String paramString)
  {
    int j = -1;
    int i = j;
    try
    {
      PackageInfo localPackageInfo = BaseApplicationImpl.getApplication().getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localPackageInfo != null)
      {
        i = j;
        j = localPackageInfo.versionCode;
        i = j;
        tlo.a("WeishiDownloadUtil", "versionName:" + localPackageInfo.versionName + ",versionCode:" + localPackageInfo.versionCode);
        return j;
      }
      i = j;
      tlo.c("WeishiDownloadUtil", paramString + "获取 PackageInfo 失败");
      return -1;
    }
    catch (Exception paramString)
    {
      tlo.a("WeishiDownloadUtil", paramString.getLocalizedMessage());
    }
    return i;
  }
  
  private static RockDownloadInfo a(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)paramArrayList.next();
      if ((localRockDownloadInfo.businessName.equals(paramRockDownloadInfo.businessName)) && (localRockDownloadInfo.packageName.equals(paramRockDownloadInfo.packageName)) && (localRockDownloadInfo.realVersionCode >= paramRockDownloadInfo.versionCode) && (localRockDownloadInfo.versionCode >= paramRockDownloadInfo.versionCode))
      {
        tlo.a("WeishiDownloadUtil", "Rock包版本大于或等于要下载的版本，有效~~~");
        return localRockDownloadInfo;
      }
    }
    return null;
  }
  
  public static String a()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  private static String a(int paramInt)
  {
    Object localObject2 = bfkr.a().b("com.tencent.weishi", 4);
    Object localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = bfkr.a().a("com.tencent.weishi", 4);
    }
    localObject2 = bfok.a().a("10261931");
    if (localObject2 != null)
    {
      ((DownloadInfo)localObject2).a(4);
      ((List)localObject1).add(localObject2);
    }
    tlo.a("WeishiDownloadUtil", ">existValidQQDownloadWeishiApk, info:" + localObject1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DownloadInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        tlo.d("WeishiDownloadUtil", "downloadInfo 's url: " + ((DownloadInfo)localObject2).d);
        if ((((DownloadInfo)localObject2).a() == 4) && (TextUtils.equals(((DownloadInfo)localObject2).e, "com.tencent.weishi")) && (((DownloadInfo)localObject2).d != null) && (((DownloadInfo)localObject2).d.startsWith(b()))) {
          if (TextUtils.isEmpty(((DownloadInfo)localObject2).l))
          {
            tlo.a("WeishiDownloadUtil", "QQ下载包filePath为空!!!");
          }
          else
          {
            int i = a(((DownloadInfo)localObject2).l);
            tlo.a("WeishiDownloadUtil", "判断QQ下载包有没有过期，apkVersionCode：" + i + ",targetVersion:" + paramInt);
            if (i >= paramInt)
            {
              tlo.a("WeishiDownloadUtil", "本地包版本(" + i + ")大于或等于要下载的版本" + paramInt + ")，直接安装~~~");
              return ((DownloadInfo)localObject2).l;
            }
          }
        }
      }
      else
      {
        tlo.d("WeishiDownloadUtil", "downloadInfo is null");
      }
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label70;
      }
      label8:
      if (paramInt3 <= 0) {
        break label75;
      }
    }
    for (;;)
    {
      String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3;
      str = (String)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (TextUtils.isEmpty(str)) {
        break label80;
      }
      return str;
      paramInt1 = 0;
      break;
      label70:
      paramInt2 = 0;
      break label8;
      label75:
      paramInt3 = 0;
    }
    label80:
    return "204002042";
  }
  
  private static ArrayList<RockDownloadInfo> a(tes paramtes, RockDownloadInfo paramRockDownloadInfo)
  {
    ArrayList localArrayList = anvz.a(paramRockDownloadInfo);
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return null;
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)localArrayList.get(i);
      int j = localRockDownloadInfo.versionCode;
      int k = localRockDownloadInfo.realVersionCode;
      if ((k < paramRockDownloadInfo.versionCode) || (j < paramRockDownloadInfo.versionCode))
      {
        Log.i("WeishiDownloadUtil", "本地已经有的安装包版本太旧，报告服务器删除掉第" + i + "个rockDownloadInfo，此info的versionCode是" + j + ",realVersionCode是:" + k + ",要下载的version是:" + paramRockDownloadInfo.versionCode);
        paramtes.a(localRockDownloadInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        Log.i("WeishiDownloadUtil", "第" + i + "个rockDownloadInfo是正确的，此info的versionCode是" + j + ",realVersionCode是:" + k + ",要下载的version是:" + paramRockDownloadInfo.versionCode);
      }
    }
    return localArrayList;
  }
  
  public static tez a(int paramInt1, int paramInt2)
  {
    if (b()) {
      return c(paramInt1, paramInt2);
    }
    return b(paramInt1, paramInt2);
  }
  
  public static void a()
  {
    tlo.a("WeishiDownloadUtil", "resetDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", false);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", 0L);
  }
  
  public static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventId", paramInt);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramActivity == null) || (paramWSDownloadParams == null)) {
      tlo.a("WeishiDownloadUtil", "rock download activity or params is null");
    }
    tes localtes;
    RockDownloadInfo localRockDownloadInfo;
    do
    {
      do
      {
        return;
        tlo.d("WeishiDownloadUtil", "WSDownloadParams:" + paramWSDownloadParams.toString());
        localtes = new tes(paramActivity);
        if (xrn.b(paramActivity)) {
          break;
        }
      } while (a(paramWSDownloadParams, localtes, localtes.a(), 3));
      QQToast.a(paramActivity, alud.a(2131717293), 0).a();
      return;
      if (c())
      {
        a(true);
        tlo.d("WeishiDownloadUtil", "当前有正在下载的任务,不响应钩子下载请求,但更改下载类型为主动下载");
        if ((tee.a().f()) && (a()))
        {
          b(3);
          return;
        }
        a(paramWSDownloadParams.mEventId, 3);
        tju.a(true, paramWSDownloadParams);
        tju.a(paramWSDownloadParams, 2);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 1, 2, 0);
        tet.a(paramActivity);
        return;
      }
      if ((tee.a().e()) && (tkq.a(paramActivity)))
      {
        tlo.d("WeishiDownloadUtil", "主动点击 执行厂商下载-----");
        tkq.a(paramActivity);
        b(3);
        tlv.a(paramWSDownloadParams.mScheme);
        paramWSDownloadParams.mStReportItem = tjr.a();
        tet.a(115, paramWSDownloadParams);
        tju.a(false, paramWSDownloadParams);
        tju.a(paramWSDownloadParams, 3);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 0, 3, 0);
        bfkq.a(paramActivity, paramWSDownloadParams.mScheme, "com.tencent.weishi", "biz_src_jc_gzh_weishi");
        return;
      }
      localRockDownloadInfo = localtes.a();
    } while (a(paramWSDownloadParams, localtes, localRockDownloadInfo, 3));
    b(3);
    if ((!tee.a().b()) && (!a()))
    {
      tlo.a("WeishiDownloadUtil", "服务器关闭了4g开关");
      tet.b(paramActivity, paramWSDownloadParams);
      return;
    }
    tlo.a("WeishiDownloadUtil", "服务器打开了4g");
    if (tee.a().f())
    {
      localtes.a(paramActivity, localRockDownloadInfo, 3, paramWSDownloadParams, null);
      return;
    }
    tet.a(paramActivity, paramWSDownloadParams);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, tez paramtez, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    paramtez = new tes(paramActivity);
    if (!xrn.b(paramActivity)) {
      if (!a(paramWSDownloadParams, paramtez, paramtez.a(), 3)) {}
    }
    RockDownloadInfo localRockDownloadInfo;
    do
    {
      do
      {
        return;
        QQToast.a(paramActivity, alud.a(2131717293), 0).a();
        return;
        if ((!tee.a().e()) || (!tkq.a(paramActivity))) {
          break;
        }
        tlo.d("WeishiDownloadUtil", "B链路点击 延迟执行厂商下载");
        LocalMultiProcConfig.putBool("need_appstore_download", true);
      } while (!c());
      if ((tee.a().f()) && (a()))
      {
        tlo.c("WeishiDownloadUtil", "当前有下载的Rock任务,开始中断-----");
        paramActivity = tee.a().c();
        bfkv.a().b(paramActivity, false);
        return;
      }
      paramActivity = tee.a().d();
      tlo.c("WeishiDownloadUtil", "当当前有QQ下载的任务,开始中断~~");
      bfkv.a().b(paramActivity, false);
      return;
      paramtez = new tes(paramActivity);
      localRockDownloadInfo = paramtez.a();
    } while (a(paramWSDownloadParams, paramtez, localRockDownloadInfo, 2));
    if ((!tee.a().b()) && (!a()))
    {
      tlo.d("WeishiDownloadUtil", "不可以在非WIFI环境下，静默下载微视");
      return;
    }
    if (c())
    {
      tlo.d("WeishiDownloadUtil", "当前有正在下载的任务,不响应静默下载请求");
      if ((tee.a().f()) && (a()))
      {
        b(2);
        return;
      }
      tju.a(true, paramWSDownloadParams);
      tju.a(paramWSDownloadParams, 2);
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 2, 1, 2, 0);
      return;
    }
    tlo.d("WeishiDownloadUtil", "执行QQ或Rock下载");
    b(2);
    if (tee.a().f())
    {
      paramtez.a(paramActivity, localRockDownloadInfo, 2, paramWSDownloadParams, paramRockDownloadListenerWrapper);
      return;
    }
    a(paramActivity, paramWSDownloadParams, true, 2);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean)
  {
    a(paramActivity, paramWSDownloadParams);
  }
  
  public static void a(Activity paramActivity, tes paramtes, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    a(paramWSDownloadParams.mEventId, paramInt);
    tlv.a(paramWSDownloadParams.mScheme);
    a(paramActivity, paramWSDownloadParams, paramBoolean, paramInt);
  }
  
  private static void a(String paramString, int paramInt)
  {
    Object localObject2 = bfkr.a().a();
    if (localObject2 == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = null;
      Iterator localIterator = ((ConcurrentHashMap)localObject2).values().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (DownloadInfo)localIterator.next();
        if ((localObject2 != null) && (((DownloadInfo)localObject2).e.equals("com.tencent.weishi")) && (((DownloadInfo)localObject2).d != null) && (((DownloadInfo)localObject2).d.startsWith(b())) && (!((DownloadInfo)localObject2).d.equals(paramString))) {
          if ((((DownloadInfo)localObject2).a() == 4) && (a(((DownloadInfo)localObject2).l) < paramInt))
          {
            localArrayList.add(localObject2);
          }
          else
          {
            Object localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = localObject2;
            }
            localObject1 = localObject3;
            if (System.currentTimeMillis() - ((DownloadInfo)localObject2).jdField_a_of_type_Long > 2592000000L) {
              if (((DownloadInfo)localObject2).jdField_a_of_type_Long > localObject3.jdField_a_of_type_Long)
              {
                localArrayList.add(localObject3);
                localObject1 = localObject2;
              }
              else
              {
                localArrayList.add(localObject2);
                localObject1 = localObject3;
              }
            }
          }
        }
      }
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (DownloadInfo)paramString.next();
        tlo.d("WeishiDownloadUtil", "删除了info:" + ((DownloadInfo)localObject1).d);
        bfkr.a().b(((DownloadInfo)localObject1).d, false);
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    tlo.a("WeishiDownloadUtil", "setPreDownloadingClick");
    LocalMultiProcConfig.putBool("preDownloadingClick", paramBoolean);
  }
  
  public static boolean a()
  {
    return "wifi".equals(DeviceUtils.getNetworkTypeName(BaseApplicationImpl.getContext()).toLowerCase());
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    a(false);
    if (xsx.a(paramActivity))
    {
      tlo.d("WeishiDownloadUtil", "本地已经安装微视app");
      return false;
    }
    if (!e())
    {
      tlo.d("WeishiDownloadUtil", "预下载开关没打开");
      return false;
    }
    tes localtes = new tes(paramActivity);
    RockDownloadInfo localRockDownloadInfo = localtes.a();
    b(1);
    if (a(paramWSDownloadParams, localtes, localRockDownloadInfo, 1)) {
      return false;
    }
    if ((tee.a().f()) && (a()))
    {
      localtes.a(paramActivity, localRockDownloadInfo, 1, paramWSDownloadParams, null);
      return true;
    }
    tlo.c("WeishiDownloadUtil", "用QQ预下载兜底~");
    a(99, 1);
    a(paramActivity, paramWSDownloadParams, false, 1);
    return true;
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    if ((paramActivity == null) || (paramWSDownloadParams == null))
    {
      tlo.a("startQQDownload: activity is null Or params is null:");
      return false;
    }
    tlo.a("downloadWeishi:" + paramWSDownloadParams);
    String str = tee.a().d();
    a(paramWSDownloadParams.mEventId, paramInt);
    tlv.a(paramWSDownloadParams.mScheme);
    return a(paramActivity, str, paramBoolean, false, paramWSDownloadParams, paramInt);
  }
  
  private static boolean a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    tlo.a("WeishiDownloadUtil", String.format("downloadWeishi : autoInstall = %s, showNotification = %s, mDownloadUrlStr = %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    b();
    Bundle localBundle = new Bundle();
    localBundle.putString(bfoh.jdField_b_of_type_JavaLangString, "10261931");
    localBundle.putString(bfoh.l, jdField_a_of_type_JavaLangString);
    localBundle.putString(bfoh.f, "com.tencent.weishi");
    localBundle.putString(bfoh.j, paramString);
    localBundle.putInt(bfoh.k, 2);
    localBundle.putBoolean(bfoh.h, false);
    paramString = bfoh.x;
    if (!paramBoolean2) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localBundle.putBoolean(paramString, paramBoolean1);
      bfkv.a().a(paramActivity, localBundle, "biz_src_jc_gzh_weishi", null, 0);
      jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
      tju.a(true, paramWSDownloadParams);
      tju.a(paramWSDownloadParams, 2);
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0);
      return true;
    }
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, int paramInt, String paramString)
  {
    if (bfms.a(bfbm.a().a(), paramString, "biz_src_jc_gzh_weishi", ""))
    {
      tlo.a("WeishiDownloadUtil", "本地QQ包的版本有效，启动开始安装成功！");
      tju.a(1, 2);
      paramString = paramWSDownloadParams;
      if (paramWSDownloadParams == null)
      {
        paramString = new WSDownloadParams();
        tlo.d("WeishiDownloadUtil", "WSDownloadParams异常！");
      }
      WSPublicAccReport.getInstance().reportDownload(paramString.mEventId, paramInt, 2, 2, 1);
      if (paramString.mStReportItem == null) {
        paramString.mStReportItem = tjr.a();
      }
      tjr.a(115, paramString.mStReportItem.pagetype, paramString.mStReportItem.comment_loctaion, null);
      tlv.a(paramString.mScheme);
      return true;
    }
    tlo.d("WeishiDownloadUtil", "本地QQ包安装失败,重新下载！");
    return false;
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, tes paramtes, RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    ArrayList localArrayList = a(paramtes, paramRockDownloadInfo);
    if (a(localArrayList, paramRockDownloadInfo))
    {
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 1, 0);
      paramRockDownloadInfo = a(localArrayList, paramRockDownloadInfo);
      if (paramRockDownloadInfo != null)
      {
        if (paramInt == 1)
        {
          tlo.c("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
          return true;
        }
        if (tee.a().a() == 2)
        {
          tby.b += 1;
          tlo.c("WeishiDownloadUtil", "CCCCCCCCC onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + tby.b);
        }
        paramtes.a(paramRockDownloadInfo, 1);
        tlv.a(paramWSDownloadParams.mScheme);
        tlo.d("WeishiDownloadUtil", "本地Rock包的版本有效，直接安装");
        return true;
      }
    }
    paramtes = a(tee.a().e());
    if (!TextUtils.isEmpty(paramtes))
    {
      tlo.d("WeishiDownloadUtil", "checkAndInstallValidApp QQDownloader apkPath = " + paramtes);
      if (paramInt == 1)
      {
        tlo.c("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
        return true;
      }
      if (tee.a().a() == 2)
      {
        tby.b += 1;
        tlo.c("WeishiDownloadUtil", "DDDDDDDDDDD onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + tby.b);
      }
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0);
      a(paramWSDownloadParams.mEventId, paramInt);
      if (a(paramWSDownloadParams, paramInt, paramtes))
      {
        tlo.a("WeishiDownloadUtil", "installApkByQQDownloader！eventId:" + paramWSDownloadParams.mEventId + ",eventType:" + paramInt);
        return true;
      }
    }
    else
    {
      tlo.a("WeishiDownloadUtil", "本地QQ包路径为空！");
    }
    return false;
  }
  
  private static boolean a(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      do
      {
        return false;
        paramArrayList = a(paramArrayList, paramRockDownloadInfo);
      } while (paramArrayList == null);
      paramArrayList = paramArrayList.localPath;
    } while ((paramArrayList == null) || (TextUtils.isEmpty(paramArrayList)));
    return true;
  }
  
  public static int b()
  {
    return LocalMultiProcConfig.getInt("eventType", -1);
  }
  
  public static String b()
  {
    return "https://weseeugg.qq.com/download?channelid=";
  }
  
  private static tez b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Tez != null)
    {
      if (!c()) {
        a(paramInt1);
      }
      b(paramInt2);
      return jdField_a_of_type_Tez;
    }
    a(paramInt1);
    b(paramInt2);
    jdField_a_of_type_Tez = new tfb();
    bfkr.a().a(jdField_a_of_type_Tez);
    return jdField_a_of_type_Tez;
  }
  
  public static void b()
  {
    tlo.a("WeishiDownloadUtil", "updateDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", true);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", System.currentTimeMillis());
  }
  
  public static void b(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventType", paramInt);
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 3))
    {
      tlo.d("WeishiDownloadUtil", " 下载器的DB还没准备就绪,重新注册监听，并重试下载一次");
      Integer localInteger;
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramDownloadInfo.d))
      {
        localInteger = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramDownloadInfo.d);
        if (localInteger != null)
        {
          paramInt = localInteger.intValue();
          jdField_b_of_type_JavaUtilHashMap.put(paramDownloadInfo.d, Integer.valueOf(paramInt + 1));
        }
      }
      for (;;)
      {
        localInteger = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramDownloadInfo.d);
        if (localInteger == null) {
          break;
        }
        tlo.d("WeishiDownloadUtil", "onDownloadError retryCount = " + localInteger);
        if (localInteger.intValue() <= 3) {
          break;
        }
        tlo.d("WeishiDownloadUtil", "重试次数已经达到3次，中止！");
        return;
        jdField_b_of_type_JavaUtilHashMap.put(paramDownloadInfo.d, Integer.valueOf(1));
      }
      ThreadManager.getUIHandler().postDelayed(new WeishiDownloadUtil.3(paramDownloadInfo), 2000L);
      return;
    }
    tlo.d("WeishiDownloadUtil", "下载器其他错误");
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2, String paramString)
  {
    tlo.d("WeishiDownloadUtil", paramString + " onDownloadFinish info = " + paramDownloadInfo);
    tlo.d("WeishiDownloadUtil", paramString + " onDownloadFinish eventId:" + paramInt1 + ",eventType:" + paramInt2);
    int i;
    if (b(paramDownloadInfo))
    {
      if (paramInt2 != 3) {
        break label255;
      }
      tet.a();
      tlo.c("WeishiDownloadUtil", paramString + " onDownloadFinish ACTIVE closeDownloadDialog");
      i = 1;
      tju.a(paramInt1, true);
      tju.a(2);
      WSPublicAccReport.getInstance().reportDownload(a(), paramInt2, 2, 2, 0);
      if (paramDownloadInfo.jdField_a_of_type_Boolean) {
        WSPublicAccReport.getInstance().reportDownload(a(), paramInt2, 2, 2, 1);
      }
      if (paramInt1 != 8) {
        break label423;
      }
      tjr.a(132, 10, null);
    }
    for (;;)
    {
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramDownloadInfo.d))
      {
        jdField_b_of_type_JavaUtilHashMap.remove(paramDownloadInfo.d);
        tlo.d("WeishiDownloadUtil", paramString + " onDownloadFinish remove retryCount!");
      }
      if (i != 0)
      {
        paramString = a(tee.a().e());
        a(jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams, paramInt2, paramString);
      }
      a(paramDownloadInfo.d, tee.a().e());
      return;
      label255:
      if (paramInt2 == 2)
      {
        if (tee.a().a() == 2)
        {
          tby.b += 1;
          tlo.b("WeishiDownloadUtil", paramString + " onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + tby.b);
          i = 1;
          break;
        }
        tlo.a("WeishiDownloadUtil", "processDownloadFinish, this is maybe DTest silent download,linktype is :" + tee.a().a());
        i = 1;
        break;
      }
      if (d())
      {
        a(false);
        tlo.d("WeishiDownloadUtil", paramString + " 预下载中用户点击了钩子，下载完成需弹起安装！！！ByQQ");
        i = 1;
        break;
      }
      tlo.d("WeishiDownloadUtil", paramString + " 正常预下载无需安装");
      i = 0;
      break;
      label423:
      if (paramInt1 == 401) {
        tjr.a(138, 1, null);
      }
    }
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    tlo.d("WeishiDownloadUtil", "qq installSucceed appid = " + paramString1 + ", packageName = " + paramString2);
    int i;
    if ((TextUtils.equals(paramString1, "10261931")) && (TextUtils.equals(paramString2, "com.tencent.weishi")))
    {
      tlo.d("WeishiDownloadUtil", "这是统一的DownloadListener，installSucceed, appId:" + paramString1 + ",packName:" + paramString2);
      bfkr.a().b(jdField_a_of_type_Tez);
      tby.b = 0;
      if (!paramBoolean) {
        break label155;
      }
      jdField_b_of_type_Tez = null;
      i = a();
      int j = b();
      tju.a(i, false);
      tju.b(2);
      WSPublicAccReport.getInstance().reportDownload(i, j, 2, 2, 2);
      if (i != 8) {
        break label162;
      }
      tjr.a(133, 10, null);
    }
    label155:
    label162:
    while (i != 401)
    {
      return;
      jdField_a_of_type_Tez = null;
      break;
    }
    tjr.a(139, 1, null);
  }
  
  public static boolean b()
  {
    String str = c();
    tlo.b("WeishiDownloadUtil", "~~~~~~~~~~~~~~~~~~~~~~~~~currentProcessName:" + str);
    return "com.tencent.mobileqq:qzone".equals(str);
  }
  
  private static boolean b(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (TextUtils.equals(paramDownloadInfo.e, "com.tencent.weishi")) && (paramDownloadInfo.d != null) && (paramDownloadInfo.d.startsWith(b()));
  }
  
  private static String c()
  {
    if (jdField_b_of_type_JavaLangString != null) {
      return jdField_b_of_type_JavaLangString;
    }
    int i = Process.myPid();
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i)
      {
        localObject = localRunningAppProcessInfo.processName;
        jdField_b_of_type_JavaLangString = (String)localObject;
        return localObject;
      }
    }
    return null;
  }
  
  private static tez c(int paramInt1, int paramInt2)
  {
    tlo.a("WeishiDownloadUtil", "createQzoneListener~~~");
    if (jdField_b_of_type_Tez != null)
    {
      if (!c()) {
        a(paramInt1);
      }
      b(paramInt2);
      return jdField_b_of_type_Tez;
    }
    a(paramInt1);
    b(paramInt2);
    jdField_b_of_type_Tez = new tfc();
    bfkr.a().a(jdField_b_of_type_Tez);
    tlo.a("WeishiDownloadUtil", "qzone registerListener");
    return jdField_b_of_type_Tez;
  }
  
  public static boolean c()
  {
    long l = System.currentTimeMillis() - LocalMultiProcConfig.getLong("weishi_downloading_start_time_key", 0L);
    if (l > 120000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = LocalMultiProcConfig.getBool("weishi_downloading_key", false);
      tlo.b("WeishiDownloadUtil", "downloading  = " + bool2 + ", timeout = " + bool1 + ", time passed = " + l / 1000L + "s");
      if ((!bool2) || (bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean d()
  {
    tlo.a("WeishiDownloadUtil", "getPreDownloadingClick");
    return LocalMultiProcConfig.getBool("preDownloadingClick", false);
  }
  
  private static boolean e()
  {
    return (tee.a().d()) && (!TextUtils.isEmpty(tee.a().c())) && (tee.a().c().startsWith("http"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfa
 * JD-Core Version:    0.7.0.1
 */