package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.share.ShareResultCallback;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.lang.ref.WeakReference;

class VideoFeedsShareController$WeChatShareResultCallback
  implements ShareResultCallback
{
  private int jdField_a_of_type_Int;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  private int c;
  private int d;
  
  public VideoFeedsShareController$WeChatShareResultCallback(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      VideoFeedsShareController.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.c, this.d, false, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.WeChatShareResultCallback
 * JD-Core Version:    0.7.0.1
 */