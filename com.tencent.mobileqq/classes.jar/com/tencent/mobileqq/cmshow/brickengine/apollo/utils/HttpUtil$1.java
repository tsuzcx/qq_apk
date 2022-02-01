package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.apollo.utils.ApolloHttpCallBack;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

final class HttpUtil$1
  extends ApolloHttpCallBack
{
  HttpUtil$1(View paramView, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (!(localView instanceof ApolloSurfaceView)) {
      return;
    }
    ((ApolloSurfaceView)localView).runRenderTask(new HttpUtil.1.1(this, paramArrayOfByte, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.1
 * JD-Core Version:    0.7.0.1
 */