package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloTicker$NativeDrawTask
  extends TimerTask
{
  private WeakReference<View> a;
  private final long b;
  private final long c;
  private int d;
  private long e;
  private long f;
  private long g;
  private StringBuilder h;
  
  ApolloTicker$NativeDrawTask(ApolloTicker paramApolloTicker, View paramView, long paramLong1, long paramLong2)
  {
    this.a = new WeakReference(paramView);
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = -1;
    paramLong1 = System.currentTimeMillis();
    this.e = paramLong1;
    this.f = paramLong1;
    this.h = new StringBuilder();
  }
  
  public String a()
  {
    int i = this.d;
    long l;
    if (i > 0) {
      l = (this.g - this.e) / i;
    } else {
      l = 0L;
    }
    Object localObject = this.h;
    ((StringBuilder)localObject).append("[mspf:");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    localObject = this.h.toString();
    StringBuilder localStringBuilder = this.h;
    localStringBuilder.delete(0, localStringBuilder.length());
    return localObject;
  }
  
  public void a(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof ApolloSurfaceView))
    {
      localObject = (ApolloSurfaceView)localObject;
      if (((ApolloSurfaceView)localObject).mIsDestroy != null)
      {
        if (((ApolloSurfaceView)localObject).mIsDestroy.get()) {
          return;
        }
        if (((ApolloSurfaceView)localObject).mRenderMode == 0)
        {
          ((ApolloSurfaceView)localObject).requestRender();
          return;
        }
        if (((ApolloSurfaceView)localObject).mRenderMode != 1) {
          return;
        }
        localObject = this.this$0;
        ((ApolloTicker)localObject).pauseTicker(((ApolloTicker)localObject).ticker);
      }
    }
    else if ((localObject instanceof ApolloTextureView))
    {
      localObject = (ApolloTextureView)localObject;
      if (((ApolloTextureView)localObject).mIsDestroy != null)
      {
        if (((ApolloTextureView)localObject).mIsDestroy.get()) {
          return;
        }
        System.currentTimeMillis();
        ((ApolloTextureView)localObject).requestRender();
        System.currentTimeMillis();
        this.d += 1;
        this.g = System.currentTimeMillis();
        this.f = this.g;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTicker.NativeDrawTask
 * JD-Core Version:    0.7.0.1
 */