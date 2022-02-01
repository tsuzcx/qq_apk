package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.share.ShareResultCallback;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.lang.ref.WeakReference;

class VideoFeedsShareController$WeChatShareResultCallback
  implements ShareResultCallback
{
  private WeakReference<Context> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private VideoInfo f;
  
  public VideoFeedsShareController$WeChatShareResultCallback(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoInfo paramVideoInfo)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramVideoInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      VideoFeedsShareController.a((Context)this.a.get(), this.b, this.c, this.f, this.d, this.e, false, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.WeChatShareResultCallback
 * JD-Core Version:    0.7.0.1
 */