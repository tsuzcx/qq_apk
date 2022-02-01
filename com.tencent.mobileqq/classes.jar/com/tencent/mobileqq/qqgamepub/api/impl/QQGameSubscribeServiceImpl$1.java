package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qroute.route.Router.OnCompleteListener;
import com.tencent.qphone.base.util.QLog;

class QQGameSubscribeServiceImpl$1
  implements Router.OnCompleteListener
{
  QQGameSubscribeServiceImpl$1(QQGameSubscribeServiceImpl paramQQGameSubscribeServiceImpl, Context paramContext, String paramString, int paramInt) {}
  
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterSingleGameMsgPage onError,context:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
      localStringBuilder.append(",result:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",appId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",from:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void onSuccess()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterSingleGameMsgPage onSuccess,context:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
      localStringBuilder.append(",appId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",from:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameSubscribeServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */