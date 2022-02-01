package com.tencent.timi.game.api.cb;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;

public abstract interface ExpandHallListener
{
  public abstract void a(long paramLong, ExpandHallLaunchParam paramExpandHallLaunchParam);
  
  public abstract void a(long paramLong, ExpandHallLaunchParam paramExpandHallLaunchParam, int paramInt, String paramString);
  
  public abstract void a(long paramLong, ExpandHallLaunchParam paramExpandHallLaunchParam, QBaseActivity paramQBaseActivity);
  
  public abstract boolean a(int paramInt, ExpandHallLaunchParam paramExpandHallLaunchParam, QBaseActivity paramQBaseActivity);
  
  public abstract void b(long paramLong, ExpandHallLaunchParam paramExpandHallLaunchParam, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.cb.ExpandHallListener
 * JD-Core Version:    0.7.0.1
 */