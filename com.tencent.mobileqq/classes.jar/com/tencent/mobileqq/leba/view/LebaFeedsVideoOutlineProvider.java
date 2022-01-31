package com.tencent.mobileqq.leba.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.activity.aio.AIOUtils;

@TargetApi(21)
public class LebaFeedsVideoOutlineProvider
  extends ViewOutlineProvider
{
  private int a;
  
  public LebaFeedsVideoOutlineProvider(Context paramContext)
  {
    this.a = AIOUtils.a(4.0F, paramContext.getResources());
  }
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight() + this.a + 1, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsVideoOutlineProvider
 * JD-Core Version:    0.7.0.1
 */