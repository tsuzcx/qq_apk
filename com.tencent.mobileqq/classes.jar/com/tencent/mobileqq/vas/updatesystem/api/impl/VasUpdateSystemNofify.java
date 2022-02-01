package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.vas.update.module.thread.ThreadManager;

public class VasUpdateSystemNofify
{
  public static void a()
  {
    ThreadManager.getInstance().post(new VasUpdateSystemNofify.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasUpdateSystemNofify
 * JD-Core Version:    0.7.0.1
 */