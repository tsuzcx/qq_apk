package com.tencent.mobileqq.onlinestatus.utils;

import mqq.app.AppRuntime.Status;

public class AutoReplyUtils
{
  public static int a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.away) {
      return 1;
    }
    if (paramStatus == AppRuntime.Status.busy) {
      return 2;
    }
    if (paramStatus == AppRuntime.Status.dnd) {
      return 3;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.AutoReplyUtils
 * JD-Core Version:    0.7.0.1
 */