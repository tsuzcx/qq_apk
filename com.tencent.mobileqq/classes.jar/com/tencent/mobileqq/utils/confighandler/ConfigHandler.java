package com.tencent.mobileqq.utils.confighandler;

import ajyc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bblq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;
import lcx;
import lcy;

public abstract class ConfigHandler<T extends ConfigInfo>
{
  public final String TAG;
  private final Class<T> mConfigInfoClass;
  protected final String mUin;
  
  public ConfigHandler(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = getClass().getSimpleName();
    }
    paramString1 = getClass().getGenericSuperclass();
    if (paramString1 != null) {
      if ((paramString1 instanceof ParameterizedType))
      {
        paramString1 = ((ParameterizedType)paramString1).getActualTypeArguments();
        if (paramString1 != null) {
          if (paramString1.length > 0)
          {
            this.mConfigInfoClass = ((Class)paramString1[0]);
            paramString1 = "ConfigInfoClass[" + this.mConfigInfoClass + "]";
            this.TAG = str;
            this.mUin = paramString2;
            if (this.mConfigInfoClass != null) {
              break label257;
            }
            QLog.w(this.TAG, 1, "ConfigHandler, get ConfigInfoClassType失败, " + paramString1);
          }
        }
      }
    }
    for (;;)
    {
      if ((this.mConfigInfoClass != null) || (!AudioHelper.d())) {
        return;
      }
      throw new IllegalArgumentException(this.TAG + " get ConfigInfoClassType失败, " + paramString1);
      this.mConfigInfoClass = null;
      paramString1 = "ActualTypeArguments长度为0";
      break;
      this.mConfigInfoClass = null;
      paramString1 = "getActualTypeArguments为空";
      break;
      this.mConfigInfoClass = null;
      paramString1 = "type[" + paramString1.getClass().getName() + "]";
      break;
      this.mConfigInfoClass = null;
      paramString1 = "getGenericSuperclass为空";
      break;
      label257:
      if (AudioHelper.e()) {
        QLog.w(this.TAG, 1, "ConfigHandler, get ConfigInfoClassType成功, " + this.mConfigInfoClass);
      }
    }
  }
  
  public static void checkUin(String paramString1, String paramString2)
  {
    if ((AudioHelper.d()) && (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException(paramString1 + " 配置需要UIN");
    }
  }
  
  public static <T extends ConfigInfo> T getConfigInfo(String paramString1, String paramString2, int paramInt, Class<T> paramClass, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int i = 0;
    String str = paramString2;
    int j = paramInt;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString4 = bblq.a(paramString1, paramString3, paramString4);
      if (paramString4 == null) {
        break label172;
      }
      str = paramString4.getString(paramString5, null);
      j = paramString4.getInt(paramString6, 0);
      i = 1;
    }
    for (;;)
    {
      QLog.w(paramString1, 1, "ConfigInfo.get, step[" + i + "], configText[" + str + "], version[" + j + "]");
      try
      {
        paramString4 = paramClass.getName();
      }
      catch (Exception paramClass)
      {
        label172:
        paramString4 = null;
        paramString2 = null;
      }
      try
      {
        paramString2 = (ConfigInfo)paramClass.newInstance();
      }
      catch (Exception paramClass)
      {
        for (;;)
        {
          paramString2 = null;
        }
      }
      try
      {
        paramString2.setUin(paramString3);
        paramString2.serverVer = j;
        if (!paramString2.tryParse(paramString1, str)) {
          AudioHelper.c(paramString1 + ajyc.a(2131702416));
        }
        return paramString2;
      }
      catch (Exception paramClass)
      {
        break;
      }
      i = 2;
      str = paramString2;
      j = paramInt;
    }
    QLog.w(paramString1, 1, "getConfigInfo 实例失败1, cls[" + paramString4 + "]", paramClass);
    return paramString2;
  }
  
  public static <T extends ConfigInfo> T getConfigInfoNew(String paramString1, String paramString2, int paramInt, Class<T> paramClass, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = lcy.b(paramInt).a;
    }
    String str;
    for (;;)
    {
      try
      {
        str = paramClass.getName();
      }
      catch (Exception paramClass)
      {
        str = null;
        paramString2 = null;
      }
      try
      {
        paramClass = (ConfigInfo)paramClass.newInstance();
      }
      catch (Exception paramClass)
      {
        for (;;)
        {
          paramString2 = null;
        }
      }
      try
      {
        paramClass.setUin(paramString3);
        paramClass.serverVer = lcy.a(paramInt);
        if (!paramClass.tryParse(paramString1, paramString2)) {
          AudioHelper.c(paramString1 + ajyc.a(2131702417));
        }
        return paramClass;
      }
      catch (Exception paramString3)
      {
        paramString2 = paramClass;
        paramClass = paramString3;
        break;
      }
      QLog.w(paramString1, 1, "ConfigInfo.get, configText[" + paramString2 + "]");
    }
    QLog.w(paramString1, 1, "getConfigInfo 实例失败1, cls[" + str + "]", paramClass);
    return paramString2;
  }
  
  public static int getConfigVer(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (paramSharedPreferences != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramSharedPreferences.getString(paramString1, null))) {
        i = paramSharedPreferences.getInt(paramString2, 0);
      }
    }
    return i;
  }
  
  public static void saveConfigSP(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramSharedPreferences != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramSharedPreferences.edit().remove(paramString3);
      }
      for (;;)
      {
        paramSharedPreferences.edit().putInt(paramString4, paramInt);
        paramSharedPreferences.edit().commit();
        return;
        paramSharedPreferences.edit().putString(paramString3, paramString2);
      }
    }
    QLog.w(paramString1, 1, "saveConfig, sp为null");
  }
  
  public void doOnReconnect(QQAppInterface paramQQAppInterface) {}
  
  public final Class<T> getConfigInfoClass()
  {
    return this.mConfigInfoClass;
  }
  
  public abstract int getConfigVer();
  
  public final String getTag()
  {
    return this.TAG;
  }
  
  public abstract void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, T paramT);
  
  public abstract void saveConfig(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ConfigHandler
 * JD-Core Version:    0.7.0.1
 */