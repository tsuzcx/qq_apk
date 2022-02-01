package com.tencent.mqp.app.sec;

import android.os.Bundle;

public class SecCenterConfig
  extends SecBaseConfig
{
  public SecCenterConfig(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = this.a.getBundle(paramString1);
    if (paramString1 != null) {
      return paramString1.getString(paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecCenterConfig
 * JD-Core Version:    0.7.0.1
 */