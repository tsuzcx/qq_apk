package com.tencent.tkd.topicsdk.covergallery;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.ucrop.callback.BitmapCropCallback;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.OutputPicListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/covergallery/CoverGalleryView$confirmClick$1", "Lcom/tencent/tkd/topicsdk/ucrop/callback/BitmapCropCallback;", "onBitmapCropped", "", "filePath", "", "onCropFailure", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverGalleryView$confirmClick$1
  implements BitmapCropCallback
{
  CoverGalleryView$confirmClick$1(OutputPicListener paramOutputPicListener) {}
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getString(R.string.ad);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getStr…g.tips_image_crop_failed)");
    TopicSDKHelperKt.a((String)localObject, true, null, 4, null);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("相册封面裁剪获取 coverPath = ");
    localStringBuilder.append(paramString);
    TLog.d("CoverGalleryView", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureOutputPicListener.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.confirmClick.1
 * JD-Core Version:    0.7.0.1
 */