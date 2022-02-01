package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;
import mqq.os.MqqHandler;

public class QConfigHelper
{
  public static <T> T a(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      a(paramClass, localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newInstance failed, class=");
        localStringBuilder.append(paramClass.getSimpleName());
        QLog.d("QConfigManager", 2, localStringBuilder.toString(), localException);
      }
    }
    return null;
  }
  
  public static ArrayList<QConReqExtraInfo> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        return localArrayList;
      }
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new QConReqExtraInfo(paramArrayOfInt[i], false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(Class paramClass, Object paramObject) {}
  
  public static void a(Exception paramException)
  {
    try
    {
      throw paramException;
    }
    catch (Exception paramException)
    {
      ThreadManager.getSubThreadHandler().post(new QConfigHelper.1(paramException));
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static int[] a(ArrayList<QConReqExtraInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      int[] arrayOfInt = new int[paramArrayList.size()];
      int i = 0;
      while (i < paramArrayList.size())
      {
        arrayOfInt[i] = ((QConReqExtraInfo)paramArrayList.get(i)).a;
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigHelper
 * JD-Core Version:    0.7.0.1
 */