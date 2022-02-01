package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloTicker$NativeDrawTask
  extends TimerTask
{
  private int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private final long b;
  private long c;
  private long d;
  private long e;
  
  ApolloTicker$NativeDrawTask(ApolloTicker paramApolloTicker, View paramView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Int = -1;
    paramLong1 = System.currentTimeMillis();
    this.c = paramLong1;
    this.d = paramLong1;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  public String a()
  {
    int i = this.jdField_a_of_type_Int;
    long l;
    if (i > 0) {
      l = (this.e - this.c) / i;
    } else {
      l = 0L;
    }
    Object localObject = this.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject).append("[mspf:");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.delete(0, localStringBuilder.length());
    return localObject;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
        this.jdField_a_of_type_Int += 1;
        this.e = System.currentTimeMillis();
        this.d = this.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTicker.NativeDrawTask
 * JD-Core Version:    0.7.0.1
 */