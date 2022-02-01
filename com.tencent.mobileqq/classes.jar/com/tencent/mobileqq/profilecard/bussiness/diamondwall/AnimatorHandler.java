package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class AnimatorHandler
  extends Handler
{
  public static boolean playing = false;
  
  public void handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.arg1) {
      startPopAnimation(paramMessage);
    }
  }
  
  public void startPopAnimation(Message paramMessage)
  {
    View localView = (View)paramMessage.obj;
    int i = paramMessage.getData().getInt("iTipsTimes");
    long l = paramMessage.getData().getLong("iRemindTime");
    int j = paramMessage.what;
    paramMessage = ValueAnimator.ofFloat(new float[] { 3.0F });
    paramMessage.setEvaluator(new AnimatorHandler.FloatEvaluator(this));
    paramMessage.setDuration(3000L);
    if (i >= 1) {
      paramMessage.setRepeatCount(i - 1);
    }
    paramMessage.addUpdateListener(new AnimatorHandler.1(this, localView));
    paramMessage.addListener(new AnimatorHandler.2(this, localView, l, j));
    paramMessage.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler
 * JD-Core Version:    0.7.0.1
 */