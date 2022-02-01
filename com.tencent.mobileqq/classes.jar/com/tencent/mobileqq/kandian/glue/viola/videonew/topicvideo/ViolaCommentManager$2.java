package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;
import com.tencent.qphone.base.util.QLog;

class ViolaCommentManager$2
  implements View.OnLayoutChangeListener
{
  ViolaCommentManager$2(ViolaCommentManager paramViolaCommentManager, VVideoView paramVVideoView, View paramView, int[] paramArrayOfInt, int paramInt1, int paramInt2) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    paramView.setTranslationX(ViolaCommentManager.b(this.f)[0]);
    paramView.setTranslationY(ViolaCommentManager.b(this.f)[1]);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vvvideo w:");
    ((StringBuilder)localObject).append(this.a.getWidth());
    ((StringBuilder)localObject).append(" h:");
    ((StringBuilder)localObject).append(this.a.getHeight());
    ((StringBuilder)localObject).append(" vW:");
    ((StringBuilder)localObject).append(paramView.getWidth());
    ((StringBuilder)localObject).append(" vH:");
    ((StringBuilder)localObject).append(paramView.getHeight());
    QLog.d("ViolaCommentManager", 1, ((StringBuilder)localObject).toString());
    VideoFeedsHelper.a(this.b, ViolaCommentManager.b(this.f), ViolaCommentManager.c(this.f), this.c, new int[] { this.d, this.e }, 300L, true);
    paramView = ViolaCommentManager.a(this.f);
    paramInt1 = ViolaCommentManager.b(this.f)[1];
    paramInt2 = ViolaCommentManager.c(this.f)[1];
    localObject = ViolaCommentManager.d(this.f);
    paramInt3 = VideoFeedsHelper.c(ViolaCommentManager.e(this.f))[1];
    paramInt4 = ViolaCommentManager.d(this.f)[1];
    int[] arrayOfInt = ViolaCommentManager.d(this.f);
    VideoFeedsHelper.a(paramView, new int[] { 0, paramInt1 + paramInt2 }, (int[])localObject, new int[] { 0, paramInt3 - paramInt4 }, arrayOfInt, 300L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.2
 * JD-Core Version:    0.7.0.1
 */