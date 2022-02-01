package cooperation.qzone.statistic;

import com.tencent.common.app.BaseApplicationImpl;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.QUA;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class AccManager
{
  private static final String CMD_CALL_MUSIC = "qzonenewservice.call.music";
  private static final String CMD_JUMP_QZONE = "qzonenewservice.to.qzone";
  private static final String CMD_JUMP_QZONE_FROMQQ = "qzonenewservice.qq.to.qzone";
  private static final String CMD_JUMP_QZONE_WAP = "qzonenewservice.to.qzonewap";
  private static final String CMD_JUMP_QZONE_WAP_FROMQQ = "qzonenewservice.qq.to.qzonewap";
  private static final String CMD_KEY_POINT = "qzonenewservice.debug.keypoint";
  private static final String CMD_LAUNCH = "qzonenewservice.launchtime";
  private static final String CMD_OUTBOX = "qzonenewservice.opBox";
  private static final String CMD_QZLOG_EMAIL = "QZLog.email";
  public static final String CMD_QZONE_FEEDVIDEO_PLAY = "Qzone.FeedVideo.Play";
  private static final String CMD_QZONE_FEED_STICKER_GET_REPORT = "Feeds.getStickerGif";
  public static final String CMD_QZONE_FORWARD_REPORT = "QzoneNewService.forwardReport";
  private static final String CMD_QZONE_MUSIC_SDK_PLAY = "QzoneNewService.MusicSdkPlay";
  public static final String CMD_QZONE_NICKNAME = "Qzone.emptynickname";
  private static final String CMD_QZONE_OPNEVIP = "qzonenewservice.openvip";
  public static final String CMD_QZONE_PREDOWNLOAD = "QzoneNewService.predownload";
  private static final String CMD_QZONE_WAP_WEBERROR = "qzonenewservice.qzonewap.weberror";
  public static final String CMD_QZONE_WIFI_IMAGE_PREDOWN_CACHE_HIT = "QzoneNewService.hit_feedimage";
  public static final String CMD_QZONE_WIFI_IMAGE_PREDOWN_SUSPEND = "QzoneNewService.suspend_predownload";
  private static final String CMD_REFRESH = "qzonenewservice.refresh";
  private static final String CMD_REFRESH_MORE = "qzonenewservice.refresh.more";
  private static final String CMD_TRAFFICDATA_DAY = "qzonenewservice.traffic.day";
  public static final String CMD_WNS_INTERNAL_CRASH_RELATED_SERVERIP = "wns.internal.crashRelatedServerIP";
  public static final String PREFIX_ACTIVITY_SWITCH = "QZoneAPPInQQ.activiySwitch.";
  public static final int RESULT_CODE_FORWARD_REPORT = 900103;
  private static final int seqEnd = 1000000;
  private static final AtomicInteger seqFactory = new AtomicInteger(0);
  private static final int seqStart = 0;
  
  private static void createStatistic(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    StatisticCollector localStatisticCollector;
    do
    {
      return;
      long l2 = 0L;
      long l1 = l2;
      if (BaseApplicationImpl.getApplication() != null)
      {
        l1 = l2;
        if (BaseApplicationImpl.getApplication().isRuntimeReady())
        {
          l1 = l2;
          if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
          }
        }
      }
      localStatisticCollector = StatisticCollector.getInstance();
      Statistic localStatistic = localStatisticCollector.getStatistic();
      localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
      localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
      localStatistic.setValue(WnsKeys.CommandId, paramString1);
      localStatistic.setValue(WnsKeys.APN, NetworkState.getAPN());
      localStatistic.setValue(WnsKeys.Sequence, Integer.valueOf(getNextSeq()));
      localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt1));
      localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(l1));
      localStatistic.setValue(WnsKeys.Qua, QUA.getQUA3());
      localStatistic.setValue(WnsKeys.Build, "4810");
      localStatistic.setValue(WnsKeys.TimeCost, Integer.valueOf(paramInt2));
      if (paramString2 != null) {
        localStatistic.setValue(WnsKeys.Detail, paramString2);
      }
      if (paramInt3 > 0) {
        localStatistic.setValue(WnsKeys.Frequency, Integer.valueOf(paramInt3));
      }
      if (paramInt4 > 0)
      {
        localStatistic.setValue(WnsKeys.DType, Integer.valueOf(paramInt4));
        localStatistic.setValue(WnsKeys.ODetails, paramString3);
      }
      localStatisticCollector.put(localStatistic);
    } while (paramInt3 != 1);
    localStatisticCollector.forceReport();
  }
  
  public static void createStatistic(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    createStatistic(paramString1, paramInt1, paramString2, paramInt2, 0, null);
  }
  
  private static void createStatistic(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    StatisticCollector localStatisticCollector;
    do
    {
      return;
      long l2 = 0L;
      long l1 = l2;
      if (BaseApplicationImpl.getApplication() != null)
      {
        l1 = l2;
        if (BaseApplicationImpl.getApplication().isRuntimeReady())
        {
          l1 = l2;
          if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
          }
        }
      }
      localStatisticCollector = StatisticCollector.getInstance();
      Statistic localStatistic = localStatisticCollector.getStatistic();
      localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
      localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
      localStatistic.setValue(WnsKeys.CommandId, paramString1);
      localStatistic.setValue(WnsKeys.APN, NetworkState.getAPN());
      localStatistic.setValue(WnsKeys.Sequence, Integer.valueOf(getNextSeq()));
      localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt1));
      localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(l1));
      localStatistic.setValue(WnsKeys.Qua, QUA.getQUA3());
      localStatistic.setValue(WnsKeys.Build, "4810");
      if (paramString2 != null) {
        localStatistic.setValue(WnsKeys.Detail, paramString2);
      }
      if (paramInt2 > 0) {
        localStatistic.setValue(WnsKeys.Frequency, Integer.valueOf(paramInt2));
      }
      if (paramInt3 > 0)
      {
        localStatistic.setValue(WnsKeys.DType, Integer.valueOf(paramInt3));
        localStatistic.setValue(WnsKeys.ODetails, paramString3);
      }
      localStatisticCollector.put(localStatistic);
    } while (paramInt2 != 1);
    localStatisticCollector.forceReport();
  }
  
  public static int getNextSeq()
  {
    try
    {
      int i = seqFactory.incrementAndGet();
      if (i > 1000000) {
        seqFactory.set(0);
      }
      return i;
    }
    finally {}
  }
  
  public static void jumpQZoneWap(String paramString)
  {
    createStatistic("qzonenewservice.to.qzonewap", 1100006, paramString, 1);
  }
  
  public static void reportActivitySwitch(String paramString, int paramInt)
  {
    int i = QZoneConfigHelper.getActivitySwitchAccReportSamples();
    createStatistic("QZoneAPPInQQ.activiySwitch." + paramString, 0, paramInt, null, i, 0, null);
  }
  
  public static void reportCallMusic(String paramString)
  {
    createStatistic("qzonenewservice.call.music", 0, paramString, 1);
  }
  
  public static void reportCrashRelatedServerIP(int paramInt, String paramString)
  {
    createStatistic("wns.internal.crashRelatedServerIP", paramInt, paramString, 1);
  }
  
  public static void reportFeedVideoPlay(int paramInt, String paramString)
  {
    createStatistic("Qzone.FeedVideo.Play", paramInt, paramString, 1);
  }
  
  public static void reportForward(int paramInt)
  {
    createStatistic("QzoneNewService.forwardReport", paramInt, null, 1);
  }
  
  public static void reportGetSticker(int paramInt, String paramString)
  {
    createStatistic("Feeds.getStickerGif", paramInt, paramString, 1);
  }
  
  public static void reportImagePredownCacheHitRate(float paramFloat, String paramString)
  {
    createStatistic("QzoneNewService.hit_feedimage", (int)(100.0F * paramFloat), paramString, 1);
    QZLog.i("QZLog[reportImagePredownCacheHitRate]", 1, paramString);
  }
  
  public static void reportImagePredownSuccessRate(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    int i = (int)(1.0F * paramInt1 / paramInt2 * 100.0F);
    Object localObject = new StringBuilder("successRate=");
    ((StringBuilder)localObject).append(i).append("(").append(paramInt1).append("/").append(paramInt2).append(")");
    localObject = ((StringBuilder)localObject).toString();
    createStatistic("QzoneNewService.suspend_predownload", i, (String)localObject, 1);
    QZLog.i("QZLog[FeedsImagePreDownloader]", 1, (String)localObject);
  }
  
  public static void reportJumpQZone(String paramString)
  {
    createStatistic("qzonenewservice.to.qzone", 1100003, paramString, 1);
  }
  
  public static void reportMusicSDKPlay(int paramInt, String paramString)
  {
    createStatistic("QzoneNewService.MusicSdkPlay", paramInt, paramString, 1);
  }
  
  public static void reportOpenQZoneVipResult(int paramInt, String paramString)
  {
    createStatistic("qzonenewservice.openvip", 1300000 + paramInt, paramString, 1);
  }
  
  public static void reportOutboxResult(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject = "";
    if (paramInt1 == 0)
    {
      localObject = new StringBuilder().append("errorCode = ").append(paramInt2).append(", msg = ");
      if (paramString1 == null) {
        break label61;
      }
    }
    for (;;)
    {
      localObject = paramString1;
      createStatistic("qzonenewservice.opBox", paramInt1, (String)localObject, 0, 5, paramString2);
      return;
      label61:
      paramString1 = "";
    }
  }
  
  public static void reportTimeWithRefresh(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      createStatistic("qzonenewservice.refresh", 0, null, i, 1, paramString);
      return;
    }
  }
  
  public static void reportTimeWithRefreshMore(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      createStatistic("qzonenewservice.refresh.more", 0, null, i, 1, paramString);
      return;
    }
  }
  
  public static void reportTimeWithStep(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      createStatistic("qzonenewservice.launchtime", 0, null, i, 1, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.AccManager
 * JD-Core Version:    0.7.0.1
 */