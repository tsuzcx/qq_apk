package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.troop.api.config.AbsRoamSettingProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OtherRoamSettingProcessor
  extends AbsRoamSettingProcessor
{
  public int a(String paramString)
  {
    if (paramString.contains("message.ring.switch")) {
      return 4;
    }
    if (paramString.contains("message.vibrate.switch")) {
      return 5;
    }
    if (paramString.contains("sync.c2c_message")) {
      return 6;
    }
    if (paramString.contains("message.ring.care")) {
      return 7;
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 4) {
      return "message.ring.switch";
    }
    if (paramInt == 5) {
      return "message.vibrate.switch";
    }
    if (paramInt == 6) {
      return "sync.c2c_message";
    }
    if (paramInt == 7) {
      return "message.ring.care";
    }
    return null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (("message.ring.switch".equals(paramString1)) || ("message.vibrate.switch".equals(paramString1)) || ("message.ring.care".equals(paramString1)))
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin(), 0).edit();
      try
      {
        localEditor.putString(paramString1, paramString2);
        localEditor.apply();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList.add("sync.c2c_message");
    paramArrayList.add("message.ring.switch");
    paramArrayList.add("message.vibrate.switch");
    paramArrayList.add("message.ring.care");
  }
  
  public String b(int paramInt)
  {
    if (paramInt == 4) {
      return "";
    }
    if (paramInt == 5) {
      return "";
    }
    if (paramInt == 6) {
      return String.valueOf(1);
    }
    if (paramInt == 7) {
      return String.valueOf(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.OtherRoamSettingProcessor
 * JD-Core Version:    0.7.0.1
 */