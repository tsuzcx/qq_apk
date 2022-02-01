package com.tencent.qg.sdk.doraemon.impl;

import android.util.Log;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper;

public class DoraemonApiWrapperMockImpl
  extends DoraemonApiWrapper
{
  private static final String TAG = "DoraemonApiWrapperMockImpl";
  QGGLSurfaceView mQGGLSurfaceView;
  
  public DoraemonApiWrapperMockImpl(QGGLSurfaceView paramQGGLSurfaceView)
  {
    this.mQGGLSurfaceView = paramQGGLSurfaceView;
  }
  
  public void call(String paramString1, String paramString2, long paramLong)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call apiName=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ,apiParamJson=");
    localStringBuilder.append(paramString2);
    Log.d(str, localStringBuilder.toString());
    new Thread(new DoraemonApiWrapperMockImpl.1(this, paramLong, paramString1)).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.impl.DoraemonApiWrapperMockImpl
 * JD-Core Version:    0.7.0.1
 */