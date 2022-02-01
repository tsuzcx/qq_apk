package com.tencent.mobileqq.shortvideo.mediacodec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.AndroidCodec.BufferData;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class ShortVideoCodec
  extends AndroidCodec
{
  public static String TAG = "ShortVideoCodec";
  public static int mMediaCodecFeature = -1;
  
  public static int checkSupportMediaCodecFeature(Context paramContext)
  {
    if (mMediaCodecFeature >= 0) {
      return mMediaCodecFeature;
    }
    mMediaCodecFeature = 0;
    if (paramContext == null) {
      return mMediaCodecFeature;
    }
    VcControllerImpl.loadLibrary(paramContext);
    if (Build.VERSION.SDK_INT < 16) {
      return mMediaCodecFeature;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      invoke21Apis();
      if (!fInvokeAPILevel21)
      {
        mMediaCodecFeature = 0;
        return mMediaCodecFeature;
      }
    }
    if (DeviceCheck.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.e()) {
        mMediaCodecFeature = 1;
      }
      if (!isAVCEncWhitelistDevices()) {
        break label146;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.f()) {
        mMediaCodecFeature += 2;
      }
    }
    for (;;)
    {
      return mMediaCodecFeature;
      if (!DeviceCheck.e()) {
        break;
      }
      mMediaCodecFeature = 1;
      break;
      label146:
      if (DeviceCheck.f()) {
        mMediaCodecFeature += 2;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> getDecoderInfos(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE"))))
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
      }
    }
    return localArrayList;
  }
  
  public static List<MediaCodecInfo> getEndoderInfos(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE"))))
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
      }
    }
    return localArrayList;
  }
  
  public static boolean isAVCEncWhitelistDevices()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI 3")) && (Build.PRODUCT.equalsIgnoreCase("pisces"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4"))) {
        return DeviceCheck.f();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Meizu")) || (!Build.MODEL.equalsIgnoreCase("MX4 Pro")));
    return DeviceCheck.f();
  }
  
  public AndroidCodec.BufferData dequeueOutputBuffer()
  {
    label512:
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new AndroidCodec.BufferData(this);
        i = this.mMediaCodec.dequeueOutputBuffer(((AndroidCodec.BufferData)localObject1).info, TIMEOUT_US);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            break label512;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dequeueOutputBuffer ok,index = " + i + ",BufferInfo[flags = " + ((AndroidCodec.BufferData)localObject1).info.flags + ",offset=" + ((AndroidCodec.BufferData)localObject1).info.offset + ",size= " + ((AndroidCodec.BufferData)localObject1).info.size + ",TimeUs=" + ((AndroidCodec.BufferData)localObject1).info.presentationTimeUs + "]");
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label406;
          }
          ((AndroidCodec.BufferData)localObject1).buffer = this.outputBuffers[i];
          ((AndroidCodec.BufferData)localObject1).index = i;
          ((AndroidCodec.BufferData)localObject1).format = this.mOutputFormat;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          ((AndroidCodec.BufferData)localObject1).index = -3;
        }
      }
      finally {}
      ((AndroidCodec.BufferData)localObject1).index = -2;
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      if (this.mOutputFormat != null)
      {
        ((AndroidCodec.BufferData)localObject1).format = this.mOutputFormat;
        if (this.mCodecType == DEC_CODEC)
        {
          if (this.mOutputFormat.containsKey("color-format"))
          {
            i = this.mOutputFormat.getInteger("color-format");
            if (QLog.isColorLevel()) {
              QLog.e(TAG, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
          break label512;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "dequeueOutputBuffer timed out!");
          }
          localObject2.index = -1;
          continue;
          label406:
          localObject2.index = i;
          try
          {
            localObject2.buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject2.format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            localObject2.success = false;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            localObject2.success = false;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localInvocationTargetException.printStackTrace();
            localObject2.success = false;
          }
        }
      }
    }
  }
  
  public MediaCodec getInnerMediaCodec()
  {
    return this.mMediaCodec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec
 * JD-Core Version:    0.7.0.1
 */