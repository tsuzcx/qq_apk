package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;

final class KeyBoardUtil$2
  implements Runnable
{
  KeyBoardUtil$2(ApolloRender paramApolloRender, View paramView) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.a;
    localApolloRender.mShowEditWindow = true;
    try
    {
      KeyBoardUtil.a(this.b, localApolloRender);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show editor err =");
      localStringBuilder.append(localException.toString());
      QLog.e("[cmshow]KeyBoardUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.2
 * JD-Core Version:    0.7.0.1
 */