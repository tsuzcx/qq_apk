package com.tencent.mobileqq.kandian.glue.report.api.impl;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/impl/RIJImageOptReportImpl;", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/IRIJImageOptReport;", "()V", "reportQualityDataDimension", "", "resultCode", "", "eventId", "cost", "", "params", "Ljava/util/HashMap;", "", "", "reportSlowImageRequest", "imageRequest", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJImageOptReportImpl
  implements IRIJImageOptReport
{
  public static final RIJImageOptReportImpl a = new RIJImageOptReportImpl();
  
  public void reportQualityDataDimension(int paramInt1, int paramInt2, long paramLong, @Nullable HashMap<String, Object> paramHashMap)
  {
    ReadinjoyReportUtils.a(paramInt1, paramInt2, paramLong, paramHashMap);
  }
  
  public void reportSlowImageRequest(@Nullable ImageRequest paramImageRequest)
  {
    if (paramImageRequest != null) {
      PublicAccountReportUtils.a(null, "", "0X800AEF3", "0X800AEF3", 0, 0, "", "", "", paramImageRequest.toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.impl.RIJImageOptReportImpl
 * JD-Core Version:    0.7.0.1
 */