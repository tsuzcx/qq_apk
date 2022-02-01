package com.tencent.mobileqq.kandian.base.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import mqq.app.AppRuntime;

public class RIJSPUtils
{
  public static SharedPreferences a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_sp_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0);
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    Object localObject = "readinjoy_sp";
    if (paramBoolean1)
    {
      paramAppRuntime = paramAppRuntime.getAccount();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readinjoy_sp");
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramAppRuntime);
      localObject = ((StringBuilder)localObject).toString();
    }
    int j = 0;
    int i = j;
    if (paramBoolean2)
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 11) {
        i = 4;
      }
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, i);
  }
  
  public static SharedPreferences a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(RIJQQAppInterfaceUtil.e(), paramBoolean1, paramBoolean2);
  }
  
  public static Object a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime, true, paramBoolean);
      if (paramAppRuntime == null) {
        return null;
      }
      paramAppRuntime = paramAppRuntime.getString(paramString, "");
      if (TextUtils.isEmpty(paramAppRuntime)) {
        return null;
      }
      paramAppRuntime = new ObjectInputStream(new ByteArrayInputStream(PkgTools.hexToBytes(paramAppRuntime)));
      paramString = paramAppRuntime.readObject();
      paramAppRuntime.close();
      return paramString;
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
    return null;
  }
  
  public static void a(SharedPreferences.Editor paramEditor, boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 9))
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  public static <T> void a(String paramString, T paramT)
  {
    c(paramString, paramT, true);
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof Serializable))
    {
      ThreadManager.executeOnFileThread(new RIJSPUtils.2(paramString, paramObject, paramBoolean));
      return;
    }
    throw new RuntimeException("the data obj must implement Serializable interface ! ");
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnFileThread(new RIJSPUtils.1(paramBoolean, paramString));
  }
  
  public static <T> T b(String paramString, T paramT)
  {
    return d(paramString, paramT, true);
  }
  
  public static void b(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      paramObject = PkgTools.toHexStr(((ByteArrayOutputStream)localObject).toByteArray());
      localObject = a(RIJQQAppInterfaceUtil.e(), true, paramBoolean);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramObject);
        ((SharedPreferences.Editor)localObject).apply();
      }
      paramObject = new StringBuilder();
      paramObject.append("asyncWriteDataToSP successful !  key : ");
      paramObject.append(paramString);
      QLog.d("RIJSPUtils", 2, paramObject.toString());
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      paramObject = new StringBuilder();
      paramObject.append("write hb info to storage , error : ");
      paramObject.append(paramString.toString());
      QLog.d("RIJSPUtils", 2, paramObject.toString());
    }
  }
  
  public static <T> void c(String paramString, T paramT, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateReadInJoySpValue: key - ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" value - ");
    ((StringBuilder)localObject).append(paramT);
    QLog.d("RIJSPUtils", 2, ((StringBuilder)localObject).toString());
    localObject = a(RIJQQAppInterfaceUtil.e(), paramBoolean, true);
    if (localObject == null)
    {
      QLog.d("RIJSPUtils", 2, "updateReadInJoySpValue: sp is null");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramT instanceof String))
    {
      ((SharedPreferences.Editor)localObject).putString(paramString, (String)paramT);
    }
    else if ((paramT instanceof Integer))
    {
      ((SharedPreferences.Editor)localObject).putInt(paramString, ((Integer)paramT).intValue());
    }
    else if ((paramT instanceof Long))
    {
      ((SharedPreferences.Editor)localObject).putLong(paramString, ((Long)paramT).longValue());
    }
    else if ((paramT instanceof Float))
    {
      ((SharedPreferences.Editor)localObject).putFloat(paramString, ((Float)paramT).floatValue());
    }
    else if ((paramT instanceof Boolean))
    {
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, ((Boolean)paramT).booleanValue());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateReadInJoySpValue: unsupported type ");
      if (paramT != null) {
        paramString = paramT.getClass();
      } else {
        paramString = "null";
      }
      localStringBuilder.append(paramString);
      QLog.d("RIJSPUtils", 2, localStringBuilder.toString());
    }
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static <T> T d(String paramString, T paramT, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(RIJQQAppInterfaceUtil.e(), paramBoolean, true);
    if (localSharedPreferences == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJSPUtils", 2, "getReadInJoySpValue: sp is null");
      }
      return paramT;
    }
    if ((paramT instanceof String)) {
      return localSharedPreferences.getString(paramString, (String)paramT);
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(localSharedPreferences.getInt(paramString, ((Integer)paramT).intValue()));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(localSharedPreferences.getLong(paramString, ((Long)paramT).longValue()));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(localSharedPreferences.getBoolean(paramString, ((Boolean)paramT).booleanValue()));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(localSharedPreferences.getFloat(paramString, ((Float)paramT).floatValue()));
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJSPUtils
 * JD-Core Version:    0.7.0.1
 */