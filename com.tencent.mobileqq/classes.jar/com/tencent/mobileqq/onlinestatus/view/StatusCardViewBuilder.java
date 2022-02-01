package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import mqq.app.AppRuntime.Status;

public class StatusCardViewBuilder
{
  public static long a(long paramLong)
  {
    long l;
    if (OnLineStatusHelper.a(AppRuntime.Status.online, paramLong)) {
      l = 1055L;
    }
    do
    {
      return l;
      l = paramLong;
    } while (paramLong < 40001L);
    return 40001L;
  }
  
  public static BaseStatusCardView a(BaseActivity paramBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback, long paramLong)
  {
    ConstellationView localConstellationView = null;
    if (paramLong == 1040L) {
      localConstellationView = new ConstellationView(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    }
    do
    {
      return localConstellationView;
      if (paramLong == 1030L) {
        return new WeatherView(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
      }
      if (paramLong == 1055L) {
        return new MyMoodView(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
      }
      if (paramLong == 40001L) {
        return new AutoStatusSelectView(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
      }
    } while (paramLong != 40000L);
    return new AutoStatusAccountView(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.StatusCardViewBuilder
 * JD-Core Version:    0.7.0.1
 */