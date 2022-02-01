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
  public static int b = 0;
  public static String c = "video/avc";
  public static String d = "request-sync";
  public static String h = "AndroidCodec";
  protected static Method k;
  protected static Method l;
  protected static Method m;
  protected static Method n;
  protected static boolean o = true;
  protected MediaFormat e;
  protected MediaFormat f;
  protected MediaCodec g;
  protected ByteBuffer[] i;
  protected ByteBuffer[] j;
  protected int p = b;
  
  public SVHwCodec()
  {
    a();
    if ((Build.VERSION.SDK_INT >= 19) && (n == null)) {}
    try
    {
      n = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label48:
      break label48;
    }
    n = null;
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
        QLog.e(h, 2, "getCodecCapabilities erro", paramMediaCodecInfo);
      }
    }
    return null;
  }
  
  public static MediaCodecInfo a(String paramString)
  {
    int i2 = MediaCodecList.getCodecCount();
    int i1 = 0;
    while (i1 < i2)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static List<MediaCodecInfo> a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    while (i1 < i3)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if ((localMediaCodecInfo.isEncoder()) && ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))))
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int i2 = 0;
        while (i2 < arrayOfString.length)
        {
          if (arrayOfString[i2].equalsIgnoreCase(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  protected static void a()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (k == null) {
        k = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (l == null) {
        l = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (m != null) {
        break label103;
      }
      m = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      return;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    k = null;
    l = null;
    m = null;
    o = false;
    label103:
  }
  
  public static List<MediaCodecInfo> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    while (i1 < i3)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if ((localMediaCodecInfo.isEncoder()) && ((localMediaCodecInfo.getName().contains(".sw.")) || (localMediaCodecInfo.getName().contains(".SW.")) || (localMediaCodecInfo.getName().contains("google")) || (localMediaCodecInfo.getName().contains("Google")) || (localMediaCodecInfo.getName().contains("GOOGLE"))))
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int i2 = 0;
        while (i2 < arrayOfString.length)
        {
          if (arrayOfString[i2].equalsIgnoreCase(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public SVHwCodec.BufferData a(long paramLong)
  {
    if (this.g == null) {
      return null;
    }
    SVHwCodec.BufferData localBufferData1 = new SVHwCodec.BufferData(this);
    int i1 = this.g.dequeueInputBuffer(paramLong);
    if (i1 >= 0)
    {
      if (Build.VERSION.SDK_INT <= 20) {
        try
        {
          localBufferData1.c = i1;
          localBufferData1.a = this.i[i1];
          return localBufferData1;
        }
        finally {}
      }
      try
      {
        localBufferData2.c = i1;
        try
        {
          localBufferData2.a = ((ByteBuffer)k.invoke(this.g, new Object[] { Integer.valueOf(i1) }));
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localInvocationTargetException.printStackTrace();
          localBufferData2.e = false;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          localBufferData2.e = false;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          localBufferData2.e = false;
        }
        return localBufferData2;
      }
      finally {}
    }
    localBufferData3.c = i1;
    return localBufferData3;
  }
  
  public void a(SVHwCodec.BufferData paramBufferData)
  {
    try
    {
      if (this.g != null)
      {
        this.g.releaseOutputBuffer(paramBufferData.c, false);
        if (QLog.isColorLevel())
        {
          String str = h;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("releaseOutputBuffer index = ");
          localStringBuilder.append(paramBufferData.c);
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
      if (this.g != null) {
        this.g.queueInputBuffer(paramBufferData.c, 0, paramInt1, paramLong, paramInt2);
      }
      return;
    }
    finally
    {
      paramBufferData = finally;
      throw paramBufferData;
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString)
  {
    this.e = paramMediaFormat;
    paramMediaFormat = a(paramString);
    int i1;
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
    {
      this.p = a;
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    try
    {
      this.g = MediaCodec.createByCodecName(paramString);
      try
      {
        if (this.g != null) {
          this.g.configure(this.e, null, null, i1);
        }
        return this.g != null;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        this.g.release();
        this.g = null;
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
    int i1;
    StringBuilder localStringBuilder;
    String str2;
    label527:
    label599:
    try
    {
      localObject1 = this.g;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new SVHwCodec.BufferData(this);
      i1 = this.g.dequeueOutputBuffer(((SVHwCodec.BufferData)localObject1).d, paramLong);
      if (i1 != -3)
      {
        if (i1 != -2)
        {
          if (i1 != -1)
          {
            if (i1 >= 0)
            {
              if (QLog.isColorLevel())
              {
                String str1 = h;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("dequeueOutputBuffer ok,index = ");
                localStringBuilder.append(i1);
                localStringBuilder.append(",BufferInfo[flags = ");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).d.flags);
                localStringBuilder.append(",offset=");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).d.offset);
                localStringBuilder.append(",size= ");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).d.size);
                localStringBuilder.append(",TimeUs=");
                localStringBuilder.append(((SVHwCodec.BufferData)localObject1).d.presentationTimeUs);
                localStringBuilder.append("]");
                QLog.d(str1, 2, localStringBuilder.toString());
              }
              if (Build.VERSION.SDK_INT <= 20)
              {
                ((SVHwCodec.BufferData)localObject1).a = this.j[i1];
                ((SVHwCodec.BufferData)localObject1).c = i1;
                ((SVHwCodec.BufferData)localObject1).b = this.f;
                return localObject1;
              }
              ((SVHwCodec.BufferData)localObject1).c = i1;
              try
              {
                ((SVHwCodec.BufferData)localObject1).a = ((ByteBuffer)l.invoke(this.g, new Object[] { Integer.valueOf(i1) }));
                ((SVHwCodec.BufferData)localObject1).b = ((MediaFormat)m.invoke(this.g, new Object[] { Integer.valueOf(i1) }));
              }
              catch (InvocationTargetException localInvocationTargetException)
              {
                localInvocationTargetException.printStackTrace();
                ((SVHwCodec.BufferData)localObject1).e = false;
              }
              catch (IllegalArgumentException localIllegalArgumentException)
              {
                localIllegalArgumentException.printStackTrace();
                ((SVHwCodec.BufferData)localObject1).e = false;
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                localIllegalAccessException.printStackTrace();
                ((SVHwCodec.BufferData)localObject1).e = false;
              }
              return localObject1;
            }
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.e(h, 2, "dequeueOutputBuffer timed out!");
          }
          ((SVHwCodec.BufferData)localObject1).c = -1;
          return localObject1;
        }
        ((SVHwCodec.BufferData)localObject1).c = -2;
        this.f = this.g.getOutputFormat();
        if (this.f == null) {
          break label599;
        }
        i1 = this.p;
        int i2 = b;
        if (i1 != i2) {}
      }
    }
    finally {}
    try
    {
      i1 = this.f.getInteger("color-format");
      if (!QLog.isColorLevel()) {
        break label599;
      }
      str2 = h;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("New color format ");
      localStringBuilder.append(i1);
      localStringBuilder.append("[0x");
      localStringBuilder.append(Integer.toHexString(i1));
      localStringBuilder.append("]");
      QLog.e(str2, 2, localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      break label527;
    }
    if (QLog.isColorLevel())
    {
      QLog.e(h, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
      break label599;
      if (QLog.isColorLevel())
      {
        QLog.e(h, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
        break label599;
        if (QLog.isColorLevel()) {
          QLog.e(h, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.j = this.g.getOutputBuffers();
        ((SVHwCodec.BufferData)localObject1).c = -3;
      }
    }
    return localObject1;
  }
  
  public boolean b()
  {
    try
    {
      if (this.g != null)
      {
        this.g.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.i = this.g.getInputBuffers();
            this.j = this.g.getOutputBuffers();
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
  
  public void c()
  {
    MediaCodec localMediaCodec = this.g;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
  }
  
  public void d()
  {
    try
    {
      this.i = null;
      this.j = null;
      if (this.g != null)
      {
        this.g.release();
        this.g = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public MediaCodec e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwCodec
 * JD-Core Version:    0.7.0.1
 */