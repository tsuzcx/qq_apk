package com.tencent.mobileqq.kandian.base.image.imageloader;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/imageloader/IRIJImageOptReport;", "", "reportQualityDataDimension", "", "resultCode", "", "eventId", "cost", "", "params", "Ljava/util/HashMap;", "", "reportSlowImageRequest", "imageRequest", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJImageOptReport
{
  public abstract void reportQualityDataDimension(int paramInt1, int paramInt2, long paramLong, @Nullable HashMap<String, Object> paramHashMap);
  
  public abstract void reportSlowImageRequest(@Nullable ImageRequest paramImageRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport
 * JD-Core Version:    0.7.0.1
 */