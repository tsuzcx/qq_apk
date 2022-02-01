package com.tencent.mobileqq.writetogetherconfig;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import mqq.app.AppRuntime;

public class WriteTogetherConfBean
{
  @SerializedName("enable")
  private int a = 0;
  @SerializedName("troopType")
  private long[] b = { -1L };
  
  public static WriteTogetherConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (WriteTogetherConfBean)new Gson().fromJson(paramString, WriteTogetherConfBean.class);
  }
  
  public static boolean a(long paramLong)
  {
    Object localObject = (WriteTogetherConfBean)QConfigManager.b().b(653);
    if (((WriteTogetherConfBean)localObject).a == 1)
    {
      localObject = ((WriteTogetherConfBean)localObject).b;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        long l = localObject[i];
        if (l == -1L) {
          return true;
        }
        if (l == paramLong) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null) {
      return a(WriteTogetherUtils.b(paramAppRuntime, paramString));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherConfBean
 * JD-Core Version:    0.7.0.1
 */