package com.tencent.mobileqq.shortvideo.hwcodec;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class SVHwCodec
{
  public static int a = 1;
  public static String a = "video/avc";
  protected static Method a;
  protected static boolean a = true;
  public static int b = 0;
  public static String b = "request-sync";
  protected static Method b;
  public static String c = "AndroidCodec";
  protected static Method c;
  protected static Method d;
  protected MediaCodec a;
  protected MediaFormat a;
  protected ByteBuffer[] a;
  protected MediaFormat b;
  protected ByteBuffer[] b;
  protected int c;
  
  public SVHwCodec()
  {
    this.jdField_c_of_type_Int = jdField_b_of_type_Int;
    a();
    if ((Build.VERSION.SDK_INT >= 19) && (d == null)) {}
    try
    {
      d = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label48:
      break label48;
    }
    d = null;
  }
  
  public static MediaCodecInfo.CodecCapabilities a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramMediaCodecInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "getCodecCapabilities erro", paramMediaCodecInfo);
      }
    }
    return null;
  }
  
  public static MediaCodecInfo a(String paramString)
  {
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static List<MediaCodecInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if ((localMediaCodecInfo.isEncoder()) && ((localMediaCodecInfo.getName().contains(".sw.")) || (localMediaCodecInfo.getName().contains(".SW.")) || (localMediaCodecInfo.getName().contains("google")) || (localMediaCodecInfo.getName().contains("Google")) || (localMediaCodecInfo.getName().contains("GOOGLE"))))
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<MediaCodecInfo> a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if ((localMediaCodecInfo.isEncoder()) && ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))))
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected static void a()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        jdField_a_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_b_of_type_JavaLangReflectMethod == null) {
        jdField_b_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_c_of_type_JavaLangReflectMethod != null) {
        break label103;
      }
      jdField_c_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      return;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    jdField_a_of_type_JavaLangReflectMethod = null;
    jdField_b_of_type_JavaLangReflectMethod = null;
    jdField_c_of_type_JavaLangReflectMethod = null;
    jdField_a_of_type_Boolean = false;
    label103:
  }
  
  public MediaCodec a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaCodec;
  }
  
  public SVHwCodec.BufferData a(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
      return null;
    }
    SVHwCodec.BufferData localBufferData1 = new SVHwCodec.BufferData(this);
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(paramLong);
    if (i >= 0)
    {
      if (Build.VERSION.SDK_INT <= 20) {
        try
        {
          localBufferData1.jdField_a_of_type_Int = i;
          localBufferData1.jdField_a_of_type_JavaNioByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
          return localBufferData1;
        }
        finally {}
      }
      try
      {
        localBufferData2.jdField_a_of_type_Int = i;
        try
        {
          localBufferData2.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localInvocationTargetException.printStackTrace();
          localBufferData2.jdField_a_of_type_Boolean = false;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          localBufferData2.jdField_a_of_type_Boolean = false;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          localBufferData2.jdField_a_of_type_Boolean = false;
        }
        return localBufferData2;
      }
      finally {}
    }
    localBufferData3.jdField_a_of_type_Int = i;
    return localBufferData3;
  }
  
  public void a(SVHwCodec.BufferData paramBufferData)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(paramBufferData.jdField_a_of_type_Int, false);
        if (QLog.isColorLevel())
        {
          String str = jdField_c_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("releaseOutputBuffer index = ");
          localStringBuilder.append(paramBufferData.jdField_a_of_type_Int);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      return;
    }
    finally
    {
      paramBufferData = finally;
      throw paramBufferData;
    }
  }
  
  public void a(SVHwCodec.BufferData paramBufferData, int paramInt1, long paramLong, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(paramBufferData.jdField_a_of_type_Int, 0, paramInt1, paramLong, paramInt2);
      }
      return;
    }
    finally
    {
      paramBufferData = finally;
      throw paramBufferData;
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
            this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          }
          finally {}
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    paramMediaFormat = a(paramString);
    int i;
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
    {
      this.jdField_c_of_type_Int = jdField_a_of_type_Int;
      i = 1;
    }
    else
    {
      i = 0;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
          this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, i);
        }
        return this.jdField_a_of_type_AndroidMediaMediaCodec != null;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
        return false;
      }
      return false;
    }
    catch (Exception paramMediaFormat)
    {
      paramMediaFormat.printStackTrace();
    }
  }
  
  public SVHwCodec.BufferData b(long paramLong)
  {
    Object localObject1;
    int i;
    StringBuilder localStringBuilder;
    String str2;
    label527:
    label599:
    try
    {
      localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new SVHwCodec.BufferData(this);
      i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(((SVHwCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, paramLong);
      if (i != -3)
      {
        if (i != -2)
        {
          if (i != -1)
          {
            if (i >= 0)
            {
              if (QLog.isColorLevel())
              {
                String str1 = jdField_c_of_type_JavaLangString;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("dequeueOutputBuffer ok,index = ");
                localStringBuilder.append(i);
                localStringBuilder.append(",BufferInfo[flags = ");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags);
                localStringBuilder.append(",offset=");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
                localStringBuilder.append(",size= ");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
                localStringBuilder.append(",TimeUs=");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs);
                localStringBuilder.append("]");
                QLog.d(str1, 2, localStringBuilder.toString());
              }
              if (Build.VERSION.SDK_INT <= 20)
              {
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Int = i;
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
                return localObject1;
              }
              ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Int = i;
              try
              {
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
              }
              catch (InvocationTargetException localInvocationTargetException)
              {
                localInvocationTargetException.printStackTrace();
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Boolean = false;
              }
              catch (IllegalArgumentException localIllegalArgumentException)
              {
                localIllegalArgumentException.printStackTrace();
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Boolean = false;
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                localIllegalAccessException.printStackTrace();
                ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Boolean = false;
              }
              return localObject1;
            }
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
          }
          ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Int = -1;
          return localObject1;
        }
        ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Int = -2;
        this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        if (this.jdField_b_of_type_AndroidMediaMediaFormat == null) {
          break label599;
        }
        i = this.jdField_c_of_type_Int;
        int j = jdField_b_of_type_Int;
        if (i != j) {}
      }
    }
    finally {}
    try
    {
      i = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
      if (!QLog.isColorLevel()) {
        break label599;
      }
      str2 = jdField_c_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("New color format ");
      localStringBuilder.append(i);
      localStringBuilder.append("[0x");
      localStringBuilder.append(Integer.toHexString(i));
      localStringBuilder.append("]");
      QLog.e(str2, 2, localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      break label527;
    }
    if (QLog.isColorLevel())
    {
      QLog.e(jdField_c_of_type_JavaLangString, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
      break label599;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
        break label599;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_c_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        ((SVHwCodec.BufferData)localObject1).jdField_a_of_type_Int = -3;
      }
    }
    return localObject1;
  }
  
  public void b()
  {
    MediaCodec localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = null;
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = null;
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwCodec
 * JD-Core Version:    0.7.0.1
 */