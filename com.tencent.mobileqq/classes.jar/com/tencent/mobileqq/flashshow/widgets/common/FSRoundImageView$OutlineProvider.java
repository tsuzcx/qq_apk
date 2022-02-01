package com.tencent.mobileqq.flashshow.widgets.common;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(api=21)
class FSRoundImageView$OutlineProvider
  extends ViewOutlineProvider
{
  private FSRoundImageView$OutlineProvider(FSRoundImageView paramFSRoundImageView) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (FSRoundImageView.a(this.a))
    {
      ViewOutlineProvider.BACKGROUND.getOutline(paramView, paramOutline);
      return;
    }
    paramView = new Rect();
    FSRoundImageView.b(this.a).roundOut(paramView);
    paramOutline.setRoundRect(paramView, paramView.width() / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSRoundImageView.OutlineProvider
 * JD-Core Version:    0.7.0.1
 */