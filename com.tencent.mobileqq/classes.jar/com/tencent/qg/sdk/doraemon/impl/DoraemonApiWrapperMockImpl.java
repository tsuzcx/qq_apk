package com.tencent.qg.sdk.doraemon.impl;

import android.util.Log;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper;

public class DoraemonApiWrapperMockImpl
  extends DoraemonApiWrapper
{
  private static final String TAG = DoraemonApiWrapperMockImpl.class.getSimpleName();
  QGGLSurfaceView mQGGLSurfaceView;
  
  public DoraemonApiWrapperMockImpl(QGGLSurfaceView paramQGGLSurfaceView)
  {
    this.mQGGLSurfaceView = paramQGGLSurfaceView;
  }
  
  public void call(String paramString1, String paramString2, long paramLong)
  {
    Log.d(TAG, "call apiName=" + paramString1 + " ,apiParamJson=" + paramString2);
    new Thread(new DoraemonApiWrapperMockImpl.1(this, paramLong, paramString1)).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.impl.DoraemonApiWrapperMockImpl
 * JD-Core Version:    0.7.0.1
 */