package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupMgr;

public class BusinessCommonConfig$WorldCupConfigHandler
  extends BusinessCommonConfig.ConfigHandler
{
  String a;
  
  public BusinessCommonConfig$WorldCupConfigHandler(String paramString)
  {
    this.a = paramString;
  }
  
  public int a()
  {
    return a(a(), "config", "ver");
  }
  
  public SharedPreferences a()
  {
    return WorldCupConfigInfo.a(this.a);
  }
  
  public Class a()
  {
    return WorldCupConfigInfo.class;
  }
  
  public String a()
  {
    return "WorldCupMgr";
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, BusinessCommonConfig.ConfigInfo paramConfigInfo)
  {
    WorldCupMgr.a(paramQQAppInterface).a(paramQQAppInterface, paramString, (WorldCupConfigInfo)paramConfigInfo);
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (TextUtils.isEmpty(paramString)) {
      localSharedPreferences.edit().remove("config");
    }
    for (;;)
    {
      localSharedPreferences.edit().putInt("ver", paramInt);
      localSharedPreferences.edit().commit();
      return;
      localSharedPreferences.edit().putString("config", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig.WorldCupConfigHandler
 * JD-Core Version:    0.7.0.1
 */