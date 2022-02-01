package com.tencent.mobileqq.kandian.base.bandwidth;

import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.bandwidth.api.IBandwidthMonitor;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPBandwidthMonitor;
import com.tencent.superplayer.api.ISPBandwidthMonitor.Callback;
import com.tencent.superplayer.api.ISPBandwidthMonitor.Stat;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/bandwidth/BandwidthMonitor;", "Lcom/tencent/mobileqq/kandian/base/bandwidth/api/IBandwidthMonitor;", "()V", "ACTION", "", "CONFIG_BANDWIDTH_REPORT_ENABLE", "", "KEY_AD_ENABLE", "KEY_ENABLE", "TAG", "enable", "", "getEnable", "()Z", "isADEnable", "monitor", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor;", "dealCallback", "", "stats", "", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor$Stat;", "start", "context", "Landroid/content/Context;", "stop", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BandwidthMonitor
  implements IBandwidthMonitor
{
  private static final String ACTION = "0X800BD0B";
  private static final int CONFIG_BANDWIDTH_REPORT_ENABLE = 541;
  public static final BandwidthMonitor INSTANCE = new BandwidthMonitor();
  private static final String KEY_AD_ENABLE = "bandwidth_report_ad_enable";
  private static final String KEY_ENABLE = "bandwidth_report_enable";
  private static final String TAG = "BandwidthMonitor";
  private static final boolean enable;
  private static final boolean isADEnable;
  private static ISPBandwidthMonitor monitor;
  
  static
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(541);
    boolean bool2 = true;
    boolean bool1;
    if (localAladdinConfig.getIntegerFromString("bandwidth_report_enable", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    enable = bool1;
    if (Aladdin.getConfig(541).getIntegerFromString("bandwidth_report_ad_enable", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    isADEnable = bool1;
    if (enable) {
      monitor = SuperPlayerFactory.createBandwidthMonitor(104);
    }
  }
  
  private final void dealCallback(Map<String, ? extends ISPBandwidthMonitor.Stat> paramMap)
  {
    long l1 = System.currentTimeMillis();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = (ISPBandwidthMonitor.Stat)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      long l2 = ((ISPBandwidthMonitor.Stat)localObject1).httpBandwidth;
      long l3 = ((ISPBandwidthMonitor.Stat)localObject1).pcdnBandwidth;
      long l4 = ((ISPBandwidthMonitor.Stat)localObject1).p2pBandwidth;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dealCallback: host=");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", httpBw=");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(", pcdnBw=");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(", p2pBw=");
        ((StringBuilder)localObject1).append(l4);
        QLog.d("BandwidthMonitor", 2, ((StringBuilder)localObject1).toString());
      }
      if ((l2 > 0L) || (l3 > 0L) || (l4 > 0L))
      {
        localObject1 = new VideoR5.Builder("").b("report_timestamp", Long.valueOf(l1)).b("host", localObject2).b("httpBw", Long.valueOf(l2)).b("pcdnBw", Long.valueOf(l3)).b("p2pBw", Long.valueOf(l4)).a();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoR5.Builder(\"\")\n    …          .toJsonString()");
        PublicAccountReportUtils.a(null, "", "0X800BD0B", "0X800BD0B", 0, 0, "", "", "", (String)localObject1, false);
      }
    }
  }
  
  public final boolean getEnable()
  {
    return enable;
  }
  
  public final boolean isADEnable()
  {
    return isADEnable;
  }
  
  public void start(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (enable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BandwidthMonitor", 2, "start: ");
      }
      ISPBandwidthMonitor localISPBandwidthMonitor = monitor;
      if (localISPBandwidthMonitor != null) {
        localISPBandwidthMonitor.start(paramContext, (ISPBandwidthMonitor.Callback)BandwidthMonitor.start.1.a, 60000L);
      }
    }
  }
  
  public void stop(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (enable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BandwidthMonitor", 2, "stop: ");
      }
      ISPBandwidthMonitor localISPBandwidthMonitor = monitor;
      if (localISPBandwidthMonitor != null) {
        localISPBandwidthMonitor.stop(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.BandwidthMonitor
 * JD-Core Version:    0.7.0.1
 */