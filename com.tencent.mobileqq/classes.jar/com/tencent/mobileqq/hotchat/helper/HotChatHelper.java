package com.tencent.mobileqq.hotchat.helper;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;

public class HotChatHelper
{
  public static long a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      NearbyUtils.a("HotChatHelper", new Object[] { "getCurTime", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(Math.abs(l2 - l1)) });
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.helper.HotChatHelper
 * JD-Core Version:    0.7.0.1
 */