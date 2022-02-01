package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.biz.pubaccount.util.TraceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJJsonUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData.BucketKeyFetcher;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoDynamicBufferConfigSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSdkConfigSp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/baseconfig/ReadInJoyVideoReportDataConfig;", "Lcom/tencent/mobileqq/kandian/glue/baseconfig/IConfig;", "()V", "getPrepareOptimizeConfigJson", "", "initConfig", "", "updateConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyVideoReportDataConfig
  implements IConfig
{
  public static final ReadInJoyVideoReportDataConfig a = new ReadInJoyVideoReportDataConfig();
  
  private final String a()
  {
    TraceUtil.a();
    StringBuilder localStringBuilder = new StringBuilder("{");
    RIJJsonUtils.a(localStringBuilder, "probesize", Long.valueOf(ReadInJoyHelper.b()));
    localStringBuilder.append(",");
    RIJJsonUtils.a(localStringBuilder, "isFFProbelistSwitch", Boolean.valueOf(ReadInJoyHelper.t()));
    localStringBuilder.append(",");
    RIJJsonUtils.a(localStringBuilder, "isDownloadAsyncIo", Boolean.valueOf(ReadInJoyHelper.u()));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    ReadInJoyVideoReportData.a((ReadInJoyVideoReportData.BucketKeyFetcher)new ReadInJoyVideoReportDataConfig.initConfig.1(Aladdin.getConfig(428)));
    Map localMap = ReadInJoyVideoReportData.a;
    Intrinsics.checkExpressionValueIsNotNull(localMap, "configReportMap");
    localMap.put("param_prepareOptimizeConfigJson", a());
    localMap = ReadInJoyVideoReportData.a;
    Intrinsics.checkExpressionValueIsNotNull(localMap, "configReportMap");
    localMap.put("param_httpbuffertime_for_playpreload", String.valueOf(RIJVideoSdkConfigSp.a()));
    localMap = ReadInJoyVideoReportData.a;
    Intrinsics.checkExpressionValueIsNotNull(localMap, "configReportMap");
    localMap.put("param_dynamic_buffer_switch", String.valueOf(RIJVideoDynamicBufferConfigSp.a()));
    localMap = ReadInJoyVideoReportData.a;
    Intrinsics.checkExpressionValueIsNotNull(localMap, "configReportMap");
    localMap.put("param_dynamic_buffer_config_json", RIJVideoDynamicBufferConfigSp.a());
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.ReadInJoyVideoReportDataConfig
 * JD-Core Version:    0.7.0.1
 */