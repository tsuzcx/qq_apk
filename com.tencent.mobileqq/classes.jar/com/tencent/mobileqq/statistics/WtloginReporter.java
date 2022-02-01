package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class WtloginReporter
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnFileThread(new WtloginReporter.1(paramQQAppInterface.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.WtloginReporter
 * JD-Core Version:    0.7.0.1
 */