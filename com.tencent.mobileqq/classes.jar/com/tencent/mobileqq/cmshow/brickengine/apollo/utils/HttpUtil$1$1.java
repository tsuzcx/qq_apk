package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

class HttpUtil$1$1
  extends IApolloRunnableTask
{
  HttpUtil$1$1(HttpUtil.1 param1, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.a != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpLog httpCallBack data.len=");
      localStringBuilder.append(this.a.length);
      QLog.d("[cmshow]HttpUtil", 2, localStringBuilder.toString());
    }
    ((ApolloSurfaceView)this.this$0.a).getRender().getSavaWrapper().httpCallBack(this.this$0.b, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.1.1
 * JD-Core Version:    0.7.0.1
 */