package com.tencent.mobileqq.limitchat;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class LimitChatDamon
{
  private static volatile LimitChatDamon jdField_a_of_type_ComTencentMobileqqLimitchatLimitChatDamon = null;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private ConcurrentHashMap<String, Bundle> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static LimitChatDamon a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLimitchatLimitChatDamon == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqLimitchatLimitChatDamon == null) {
        jdField_a_of_type_ComTencentMobileqqLimitchatLimitChatDamon = new LimitChatDamon();
      }
      return jdField_a_of_type_ComTencentMobileqqLimitchatLimitChatDamon;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm invoke, uin:" + paramString);
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
    }
    finally {}
    this.jdField_a_of_type_JavaLangRunnable = new LimitChatDamon.1(this, paramString, paramQQAppInterface);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatDamon
 * JD-Core Version:    0.7.0.1
 */