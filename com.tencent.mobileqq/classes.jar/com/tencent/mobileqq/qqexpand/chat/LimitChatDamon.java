package com.tencent.mobileqq.qqexpand.chat;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LimitChatDamon
{
  private static volatile LimitChatDamon jdField_a_of_type_ComTencentMobileqqQqexpandChatLimitChatDamon;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  
  public static LimitChatDamon a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQqexpandChatLimitChatDamon == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQqexpandChatLimitChatDamon == null) {
          jdField_a_of_type_ComTencentMobileqqQqexpandChatLimitChatDamon = new LimitChatDamon();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQqexpandChatLimitChatDamon;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendMessageReadConfirm invoke, uin:");
        localStringBuilder.append(paramString);
        QLog.d("LimitChatDamon", 2, localStringBuilder.toString());
      }
      try
      {
        if (this.jdField_a_of_type_JavaLangRunnable != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm last request do not finish");
          }
          return;
        }
        this.jdField_a_of_type_JavaLangRunnable = new LimitChatDamon.1(this, paramString, paramQQAppInterface);
        if (this.jdField_a_of_type_JavaLangRunnable != null) {
          ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.LimitChatDamon
 * JD-Core Version:    0.7.0.1
 */