package com.tencent.mobileqq.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

public class VasUpdateCfgBean
{
  public int a;
  
  public static VasUpdateCfgBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new VasUpdateCfgBean();
    }
    VasUpdateCfgBean localVasUpdateCfgBean = new VasUpdateCfgBean();
    try
    {
      localVasUpdateCfgBean.a = new JSONObject(paramString).optInt("enable", 0);
      return localVasUpdateCfgBean;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localVasUpdateCfgBean;
  }
  
  @NonNull
  public String toString()
  {
    return "switch = " + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.VasUpdateCfgBean
 * JD-Core Version:    0.7.0.1
 */