package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;

class HttpUtil$1$1
  extends IApolloRunnableTask
{
  HttpUtil$1$1(HttpUtil.1 param1, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ArrayOfByte != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpLog httpCallBack data.len=");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte.length);
      QLog.d("[cmshow]HttpUtil", 2, localStringBuilder.toString());
    }
    ((ApolloSurfaceView)this.this$0.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().httpCallBack(this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.1.1
 * JD-Core Version:    0.7.0.1
 */