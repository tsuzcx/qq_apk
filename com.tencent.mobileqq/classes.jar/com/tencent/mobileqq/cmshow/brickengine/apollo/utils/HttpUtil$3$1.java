package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

class HttpUtil$3$1
  extends IApolloRunnableTask
{
  HttpUtil$3$1(HttpUtil.3 param3, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    ((ApolloSurfaceView)this.this$0.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().httpCallBack(this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.3.1
 * JD-Core Version:    0.7.0.1
 */