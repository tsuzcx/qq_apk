package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

public class DonDisturbBean
{
  private int a = 0;
  
  public static DonDisturbBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      DonDisturbBean localDonDisturbBean = new DonDisturbBean();
      localDonDisturbBean.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localDonDisturbBean;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return super.toString() + " showDonDisturb=" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DonDisturbBean
 * JD-Core Version:    0.7.0.1
 */