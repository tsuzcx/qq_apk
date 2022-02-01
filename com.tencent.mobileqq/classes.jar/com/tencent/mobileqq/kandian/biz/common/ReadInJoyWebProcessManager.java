package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ReadInJoyWebProcessManager
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyWebProcessManager.InitWebProcessRunnable(paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyWebProcessManager
 * JD-Core Version:    0.7.0.1
 */