package com.tencent.mobileqq.flashshow.utils;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.mobileqq.flashshow.application.FSApplication;

public class FSHardCodeUtil
{
  public static String a(int paramInt)
  {
    try
    {
      String str = FSApplication.APP.getResources().getString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil
 * JD-Core Version:    0.7.0.1
 */