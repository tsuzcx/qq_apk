package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import mqq.app.AppRuntime.Status;

public class StatusCardViewBuilder
{
  public static long a(long paramLong)
  {
    if (OnLineStatusHelper.a(AppRuntime.Status.online, paramLong)) {
      return 1055L;
    }
    long l = paramLong;
    if (paramLong >= 40001L) {
      l = 40001L;
    }
    return l;
  }
  
  public static BaseStatusCardView a(QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback, long paramLong)
  {
    if (paramLong == 1040L) {
      return new ConstellationView(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    }
    if (paramLong == 1030L) {
      return new WeatherView(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    }
    if (paramLong == 1055L) {
      return new MyMoodView(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    }
    if (paramLong == 40001L) {
      return new AutoStatusSelectView(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    }
    if (paramLong == 40000L) {
      return new AutoStatusAccountView(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.StatusCardViewBuilder
 * JD-Core Version:    0.7.0.1
 */