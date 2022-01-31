package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class NetworkCenter
{
  public static NetworkCenter a;
  
  public static NetworkCenter a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new NetworkCenter();
      }
      return a;
    }
    finally {}
  }
  
  public int a()
  {
    return NetworkUtil.a(BaseApplication.getContext());
  }
  
  public String a()
  {
    try
    {
      String str = AppNetConnInfo.getCurrentAPN();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetworkCenter
 * JD-Core Version:    0.7.0.1
 */