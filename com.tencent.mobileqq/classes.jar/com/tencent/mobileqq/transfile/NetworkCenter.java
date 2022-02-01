package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class NetworkCenter
{
  public static final String TAG = "NetworkCenter";
  public static NetworkCenter sNC;
  
  public static NetworkCenter getInstance()
  {
    if (sNC == null) {}
    try
    {
      if (sNC == null) {
        sNC = new NetworkCenter();
      }
      return sNC;
    }
    finally {}
  }
  
  public String getApnType()
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
  
  public int getNetType()
  {
    return NetworkUtil.getSystemNetwork(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetworkCenter
 * JD-Core Version:    0.7.0.1
 */