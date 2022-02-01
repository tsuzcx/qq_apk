package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Keep
public class ApolloTicker
{
  public static final String TAG = "[cmshow]sava_ApolloTicker";
  public int mInterval = 3;
  private float mOffscreenFrameInterval;
  public boolean mTimerAlive;
  public long ticker;
  private Map<Long, ApolloTicker.ApolloTickerInfo> tickerMap = new HashMap();
  
  public ApolloTicker()
  {
    QLog.d("[cmshow]sava_ApolloTicker", 1, "tickerObj new");
  }
  
  private Timer getTimer()
  {
    return new Timer();
  }
  
  public void createTicker(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ApolloTicker  thread=");
    ((StringBuilder)localObject1).append(Thread.currentThread().getId());
    ((StringBuilder)localObject1).append("ticker = ");
    ((StringBuilder)localObject1).append(paramLong);
    QLog.d("[cmshow]sava_ApolloTicker", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = ApolloRender.getCurrentRenderView();
    this.ticker = paramLong;
    try
    {
      localObject1 = getTimer();
      localObject2 = new ApolloTicker.NativeDrawTask(this, (View)localObject2, paramLong, 2L);
      ApolloTicker.ApolloTickerInfo localApolloTickerInfo = new ApolloTicker.ApolloTickerInfo();
      localApolloTickerInfo.a = ((Timer)localObject1);
      localApolloTickerInfo.b = 1;
      localApolloTickerInfo.c = ((ApolloTicker.NativeDrawTask)localObject2);
      ((Timer)localObject1).scheduleAtFixedRate((TimerTask)localObject2, 0L, 16L);
      this.tickerMap.put(Long.valueOf(paramLong), localApolloTickerInfo);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]sava_ApolloTicker", 1, "createTicker ", localThrowable);
    }
  }
  
  public void disposeTicker(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("disposeTicker ticker = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",thread=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.d("[cmshow]sava_ApolloTicker", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ApolloTicker.ApolloTickerInfo)this.tickerMap.remove(Long.valueOf(paramLong));
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[disposeTicker], null error. ticker:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.e("[cmshow]sava_ApolloTicker", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Timer localTimer = ((ApolloTicker.ApolloTickerInfo)localObject).a;
    if (!this.mTimerAlive)
    {
      if (localTimer != null)
      {
        localTimer.cancel();
        localTimer.purge();
      }
    }
    else if (((ApolloTicker.ApolloTickerInfo)localObject).c != null) {
      ((ApolloTicker.ApolloTickerInfo)localObject).c.cancel();
    }
    ((ApolloTicker.ApolloTickerInfo)localObject).a = null;
  }
  
  public void driveOffScreenFrame(long paramLong)
  {
    if ((paramLong >= 0L) && (nativeGetNeedRecord(paramLong)))
    {
      if (this.mOffscreenFrameInterval <= 0.0F) {
        return;
      }
      long l = System.currentTimeMillis();
      ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(this.ticker));
      int j;
      if (localApolloTickerInfo != null) {
        j = localApolloTickerInfo.b;
      } else {
        j = 1;
      }
      float f = j;
      f = f / 60.0F * f * 1000.0F / 2.0F;
      int i = 0;
      int k;
      do
      {
        k = i;
        if (paramLong < 0L) {
          break;
        }
        if (!nativeGetNeedRecord(paramLong))
        {
          k = i;
          break;
        }
        nativeCallbackTicker(this.ticker, System.currentTimeMillis(), this.mOffscreenFrameInterval);
        k = i + 1;
        i = k;
      } while ((float)(System.currentTimeMillis() - l) <= f);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]sava_ApolloTicker", 2, new Object[] { "driveOffScreenFrame frame:", Integer.valueOf(k), ", cost:", Long.valueOf(System.currentTimeMillis() - l), ", halfPhysicalInterval:", Float.valueOf(f), ", interval:", Integer.valueOf(j), ", ticker:", Long.valueOf(this.ticker) });
      }
    }
  }
  
  public float getDuration(long paramLong)
  {
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
    if (localApolloTickerInfo != null) {
      return localApolloTickerInfo.b / 60.0F;
    }
    return 0.0F;
  }
  
  public int getInterval(long paramLong)
  {
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
    if (localApolloTickerInfo != null) {
      return localApolloTickerInfo.b;
    }
    return 1;
  }
  
  public native void nativeCallbackTicker(long paramLong, double paramDouble1, double paramDouble2);
  
  public native boolean nativeGetNeedRecord(long paramLong);
  
  public native void nativeSetRecorderMode(long paramLong, boolean paramBoolean);
  
  public void pauseTicker(long paramLong)
  {
    try
    {
      localObject2 = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[pauseTicker], null error. ticker:");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.e("[cmshow]sava_ApolloTicker", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      Object localObject1 = "";
      if (((ApolloTicker.ApolloTickerInfo)localObject2).c != null) {
        localObject1 = ((ApolloTicker.ApolloTickerInfo)localObject2).c.a();
      }
      long l = Thread.currentThread().getId();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", timer:");
      localStringBuilder.append(((ApolloTicker.ApolloTickerInfo)localObject2).a);
      QLog.d("[cmshow]sava_ApolloTicker", 1, new Object[] { "pauseTicker ticker = ", Long.valueOf(paramLong), ",thread=", Long.valueOf(l), ",intervalFps:", localStringBuilder.toString() });
      if (((ApolloTicker.ApolloTickerInfo)localObject2).a != null)
      {
        if (!this.mTimerAlive)
        {
          ((ApolloTicker.ApolloTickerInfo)localObject2).a.cancel();
          ((ApolloTicker.ApolloTickerInfo)localObject2).a.purge();
          ((ApolloTicker.ApolloTickerInfo)localObject2).a = null;
          return;
        }
        if (((ApolloTicker.ApolloTickerInfo)localObject2).c != null)
        {
          ((ApolloTicker.ApolloTickerInfo)localObject2).c.cancel();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pause ticker error=");
      ((StringBuilder)localObject2).append(localThrowable.toString());
      QLog.e("[cmshow]sava_ApolloTicker", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void resumeTicker(long paramLong)
  {
    resumeTicker(paramLong, ApolloRender.getCurrentRenderView());
  }
  
  public void resumeTicker(long paramLong, View paramView)
  {
    try
    {
      localObject1 = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
      if (localObject1 == null)
      {
        paramView = new StringBuilder();
        paramView.append("[resumeTicker], null error. ticker:");
        paramView.append(paramLong);
        QLog.e("[cmshow]sava_ApolloTicker", 1, paramView.toString());
        return;
      }
      int i = ((ApolloTicker.ApolloTickerInfo)localObject1).b;
      if (paramView == null)
      {
        QLog.e("[cmshow]sava_ApolloTicker", 1, "[resumeTicker], return, apolloView is null");
        return;
      }
      if (((ApolloTicker.ApolloTickerInfo)localObject1).a != null)
      {
        if (!this.mTimerAlive)
        {
          ((ApolloTicker.ApolloTickerInfo)localObject1).a.cancel();
          ((ApolloTicker.ApolloTickerInfo)localObject1).a.purge();
        }
        else if (((ApolloTicker.ApolloTickerInfo)localObject1).c != null)
        {
          ((ApolloTicker.ApolloTickerInfo)localObject1).c.cancel();
        }
        ((ApolloTicker.ApolloTickerInfo)localObject1).a = null;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resumeTicker ticker = ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(",thread=");
      ((StringBuilder)localObject2).append(Thread.currentThread().getId());
      QLog.d("[cmshow]sava_ApolloTicker", 1, ((StringBuilder)localObject2).toString());
      paramView = new ApolloTicker.NativeDrawTask(this, paramView, paramLong, i);
      localObject2 = getTimer();
      ((Timer)localObject2).scheduleAtFixedRate(paramView, 0L, i * 16);
      ((ApolloTicker.ApolloTickerInfo)localObject1).a = ((Timer)localObject2);
      ((ApolloTicker.ApolloTickerInfo)localObject1).c = paramView;
      return;
    }
    catch (Throwable paramView)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resumeTicker ticker error=");
      ((StringBuilder)localObject1).append(paramView.toString());
      QLog.e("[cmshow]sava_ApolloTicker", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void setInterval(long paramLong, int paramInt)
  {
    if (paramInt == 1) {
      return;
    }
    this.mInterval = paramInt;
    ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)this.tickerMap.get(Long.valueOf(paramLong));
    if (localApolloTickerInfo == null)
    {
      QLog.e("[cmshow]sava_ApolloTicker", 1, "setInterval tickerInfo null");
      return;
    }
    Object localObject1 = ApolloRender.getCurrentRenderView();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ScheduledExecutorService setInterval call = ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" thread=");
    ((StringBuilder)localObject2).append(Thread.currentThread().getId());
    QLog.d("[cmshow]sava_ApolloTicker", 1, ((StringBuilder)localObject2).toString());
    localObject2 = localApolloTickerInfo.a;
    if ((!this.mTimerAlive) && (localObject2 != null))
    {
      ((Timer)localObject2).cancel();
      ((Timer)localObject2).purge();
    }
    if (localApolloTickerInfo.c != null) {
      localApolloTickerInfo.c.cancel();
    }
    localObject1 = new ApolloTicker.NativeDrawTask(this, (View)localObject1, paramLong, paramInt);
    localObject2 = getTimer();
    ((Timer)localObject2).scheduleAtFixedRate((TimerTask)localObject1, 0L, paramInt * 16);
    localApolloTickerInfo.a = ((Timer)localObject2);
    localApolloTickerInfo.c = ((ApolloTicker.NativeDrawTask)localObject1);
    localApolloTickerInfo.b = paramInt;
  }
  
  public void setOffscreenFrameInterval(float paramFloat)
  {
    this.mOffscreenFrameInterval = paramFloat;
  }
  
  public void setRenderView(View paramView)
  {
    Iterator localIterator = this.tickerMap.values().iterator();
    while (localIterator.hasNext())
    {
      ApolloTicker.ApolloTickerInfo localApolloTickerInfo = (ApolloTicker.ApolloTickerInfo)localIterator.next();
      if ((localApolloTickerInfo != null) && (localApolloTickerInfo.c != null)) {
        localApolloTickerInfo.c.a(paramView);
      }
    }
    paramView = new StringBuilder();
    paramView.append("setRenderView size:");
    paramView.append(this.tickerMap.size());
    QLog.i("[cmshow]sava_ApolloTicker", 1, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTicker
 * JD-Core Version:    0.7.0.1
 */