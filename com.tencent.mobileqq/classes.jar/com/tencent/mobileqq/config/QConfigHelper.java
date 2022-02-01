package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Locale;
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
  
  public static String a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "handleCompressConfig| version is update, return null");
      }
      return null;
    }
    if (paramConfig.msg_content_list.size() == 0)
    {
      QLog.i("QConfigManager", 1, String.format(Locale.CHINA, "handleCompressConfig| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return "";
    }
    if (paramConfig.msg_content_list.size() >= 2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleCompressConfig, 拉到了多份配置, type[");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("], size[");
      ((StringBuilder)localObject1).append(paramConfig.msg_content_list.size());
      ((StringBuilder)localObject1).append("]");
      QLog.w("QConfigManager", 1, ((StringBuilder)localObject1).toString());
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    Object localObject2 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1)).content.get().toByteArray();
    if (localObject2 == null)
    {
      paramConfig = new StringBuilder();
      paramConfig.append("handleCompressConfig| config content is null. type=");
      paramConfig.append(paramInt2);
      QLog.e("QConfigManager", 1, paramConfig.toString());
      return null;
    }
    Object localObject1 = localObject2;
    if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
    {
      localObject2 = ArConfigUtils.a((byte[])localObject2);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramConfig = new StringBuilder();
        paramConfig.append("handleCompressConfig| decompress is failed. type=");
        paramConfig.append(paramInt2);
        paramConfig.append(", data=null");
        QLog.e("QConfigManager", 1, paramConfig.toString());
        return null;
      }
    }
    String str;
    try
    {
      localObject2 = new String((byte[])localObject1, "utf-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QLog.d("QConfigManager", 1, "handleCompressConfig| parse content, ", localUnsupportedEncodingException);
      str = null;
    }
    if (str == null)
    {
      paramConfig = new StringBuilder();
      paramConfig.append("handleCompressConfig| switch data[] to String failed. type=");
      paramConfig.append(paramInt2);
      paramConfig.append(", data=");
      paramConfig.append(new String((byte[])localObject1));
      QLog.e("QConfigManager", 1, paramConfig.toString());
      return null;
    }
    localObject1 = String.format(Locale.CHINA, "handleCompressConfig| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
    if (QLog.isColorLevel())
    {
      if ((paramConfig.version.get() != 397) && (paramConfig.version.get() != 394))
      {
        paramConfig = new StringBuilder();
        paramConfig.append((String)localObject1);
        paramConfig.append("content=");
        paramConfig.append(str);
        QLog.i("QConfigManager", 2, paramConfig.toString());
        return str;
      }
    }
    else {
      QLog.i("QConfigManager", 1, (String)localObject1);
    }
    return str;
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
  
  static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    int i = (int)l;
    byte[] arrayOfByte = new byte[i + 4];
    a(arrayOfByte, 0, l + 4L);
    System.arraycopy(paramReqGetConfig, 0, arrayOfByte, 4, i);
    return arrayOfByte;
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
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigHelper
 * JD-Core Version:    0.7.0.1
 */