package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ViolaCommentManager$3
  implements View.OnLayoutChangeListener
{
  ViolaCommentManager$3(ViolaCommentManager paramViolaCommentManager) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    if (ViolaCommentManager.a(this.a) != null)
    {
      paramView.setTranslationX(ViolaCommentManager.a(this.a)[0]);
      paramView.setTranslationY(ViolaCommentManager.a(this.a)[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.3
 * JD-Core Version:    0.7.0.1
 */