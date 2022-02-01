package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;

class HttpUtil$3$1
  extends IApolloRunnableTask
{
  HttpUtil$3$1(HttpUtil.3 param3, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    ((ApolloSurfaceView)this.this$0.a).getRender().getSavaWrapper().httpCallBack(this.this$0.b, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.3.1
 * JD-Core Version:    0.7.0.1
 */