package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class RoamSetting
  extends Entity
{
  public static final String SETTING_REVISION = "setting_revision";
  @unique
  public String path;
  public String value;
  
  public RoamSetting() {}
  
  public RoamSetting(String paramString1, String paramString2)
  {
    this.path = paramString1;
    this.value = paramString2;
  }
  
  public static int getIntValue(RoamSetting paramRoamSetting, int paramInt)
  {
    if (paramRoamSetting == null) {}
    while ((paramRoamSetting.value == null) || (paramRoamSetting.value.length() == 0)) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramRoamSetting.value);
      return i;
    }
    catch (Exception paramRoamSetting)
    {
      paramRoamSetting.printStackTrace();
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RoamSetting
 * JD-Core Version:    0.7.0.1
 */