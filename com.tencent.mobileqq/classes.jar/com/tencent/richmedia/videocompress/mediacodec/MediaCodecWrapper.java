package com.tencent.richmedia.videocompress.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class MediaCodecWrapper
{
  public static int DEC_CODEC = 0;
  public static int ENC_CODEC = 1;
  private static String TAG = "AndroidCodec";
  public static int TIMEOUT_US = 33000;
  protected static Method getInputBuffer21;
  protected static Method getOutputBuffer21;
  protected static Method getOutputFormat21;
  public static boolean invokeAPILevel21 = true;
  protected ByteBuffer[] inputBuffers;
  protected int mCodecType = DEC_CODEC;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mOutputFormat;
  protected ByteBuffer[] outputBuffers;
  
  public MediaCodecWrapper(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_AndroidCodec");
      TAG = localStringBuilder.toString();
    }
    invoke21Apis();
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    try
    {
      int j = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        boolean bool = localMediaCodecInfo.getName().equalsIgnoreCase(paramString);
        if (bool) {
          return localMediaCodecInfo;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      ConvertLog.e(TAG, 1, "getCodecInfo error", paramString);
    }
  }
  
  public static void invoke21Apis()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (getInputBuffer21 == null) {
        getInputBuffer21 = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (getOutputBuffer21 == null) {
        getOutputBuffer21 = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (getOutputFormat21 != null) {
        break label103;
      }
      getOutputFormat21 = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      return;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    getInputBuffer21 = null;
    getOutputBuffer21 = null;
    getOutputFormat21 = null;
    invokeAPILevel21 = false;
    label103:
  }
  
  public MediaCodecWrapper.BufferData dequeueOutputBuffer()
  {
    try
    {
      Object localObject1 = this.mMediaCodec;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new MediaCodecWrapper.BufferData();
      int i = this.mMediaCodec.dequeueOutputBuffer(((MediaCodecWrapper.BufferData)localObject1).info, TIMEOUT_US);
      if (i != -3)
      {
        StringBuilder localStringBuilder;
        if (i != -2)
        {
          if (i != -1)
          {
            if (i >= 0)
            {
              if (ConvertLog.isColorLevel())
              {
                String str1 = TAG;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("dequeueOutputBuffer ok, index = ");
                localStringBuilder.append(i);
                localStringBuilder.append(", BufferInfo[flags = ");
                localStringBuilder.append(((MediaCodecWrapper.BufferData)localObject1).info.flags);
                localStringBuilder.append(", offset=");
                localStringBuilder.append(((MediaCodecWrapper.BufferData)localObject1).info.offset);
                localStringBuilder.append(", size= ");
                localStringBuilder.append(((MediaCodecWrapper.BufferData)localObject1).info.size);
                localStringBuilder.append(", TimeUs=");
                localStringBuilder.append(((MediaCodecWrapper.BufferData)localObject1).info.presentationTimeUs);
                localStringBuilder.append("]");
                ConvertLog.d(str1, 2, new Object[] { localStringBuilder.toString() });
              }
              if (Build.VERSION.SDK_INT <= 20)
              {
                ((MediaCodecWrapper.BufferData)localObject1).buffer = this.outputBuffers[i];
                ((MediaCodecWrapper.BufferData)localObject1).index = i;
                ((MediaCodecWrapper.BufferData)localObject1).format = this.mOutputFormat;
                return localObject1;
              }
              ((MediaCodecWrapper.BufferData)localObject1).index = i;
              try
              {
                ((MediaCodecWrapper.BufferData)localObject1).buffer = ((ByteBuffer)getOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
                ((MediaCodecWrapper.BufferData)localObject1).format = ((MediaFormat)getOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                ((MediaCodecWrapper.BufferData)localObject1).success = false;
              }
            }
          }
          else
          {
            if (ConvertLog.isColorLevel()) {
              ConvertLog.e(TAG, 2, new Object[] { "dequeueOutputBuffer timed out!" });
            }
            ((MediaCodecWrapper.BufferData)localObject1).index = -1;
            return localObject1;
          }
        }
        else
        {
          ((MediaCodecWrapper.BufferData)localObject1).index = -2;
          this.mOutputFormat = this.mMediaCodec.getOutputFormat();
          ((MediaCodecWrapper.BufferData)localObject1).format = this.mOutputFormat;
          if (this.mCodecType == DEC_CODEC)
          {
            if (this.mOutputFormat.containsKey("color-format"))
            {
              i = this.mOutputFormat.getInteger("color-format");
              if (ConvertLog.isColorLevel())
              {
                String str2 = TAG;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("New color format ");
                localStringBuilder.append(i);
                localStringBuilder.append("[0x");
                localStringBuilder.append(Integer.toHexString(i));
                localStringBuilder.append("]");
                ConvertLog.e(str2, 2, new Object[] { localStringBuilder.toString() });
              }
            }
          }
          else if (ConvertLog.isColorLevel()) {
            ConvertLog.e(TAG, 2, new Object[] { "EncCodec,INFO_OUTPUT_FORMAT_CHANGED" });
          }
        }
      }
      else
      {
        if (ConvertLog.isColorLevel()) {
          ConvertLog.e(TAG, 2, new Object[] { "INFO_OUTPUT_BUFFERS_CHANGED" });
        }
        this.outputBuffers = this.mMediaCodec.getOutputBuffers();
        ((MediaCodecWrapper.BufferData)localObject1).index = -3;
      }
      return localObject1;
    }
    finally {}
  }
  
  public MediaCodec getInnerMediaCodec()
  {
    return this.mMediaCodec;
  }
  
  public MediaCodecWrapper.BufferData getInputBuffer()
  {
    if (this.mMediaCodec == null) {
      return null;
    }
    MediaCodecWrapper.BufferData localBufferData1 = new MediaCodecWrapper.BufferData();
    int i = this.mMediaCodec.dequeueInputBuffer(TIMEOUT_US);
    if (i >= 0)
    {
      if (Build.VERSION.SDK_INT <= 20) {
        try
        {
          localBufferData1.index = i;
          localBufferData1.buffer = this.inputBuffers[i];
          return localBufferData1;
        }
        finally {}
      }
      try
      {
        localBufferData2.index = i;
        try
        {
          localBufferData2.buffer = ((ByteBuffer)getInputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localBufferData2.success = false;
        }
        return localBufferData2;
      }
      finally {}
    }
    return null;
  }
  
  public void init(MediaFormat paramMediaFormat, int paramInt)
  {
    this.mCodecType = paramInt;
    for (;;)
    {
      try
      {
        String str = paramMediaFormat.getString("mime");
        if (str != null)
        {
          if (paramInt == DEC_CODEC) {
            this.mMediaCodec = MediaCodec.createDecoderByType(str);
          } else {
            this.mMediaCodec = MediaCodec.createEncoderByType(str);
          }
          if (paramInt != ENC_CODEC) {
            break label80;
          }
          paramInt = 1;
          this.mMediaCodec.configure(paramMediaFormat, null, null, paramInt);
          return;
        }
      }
      catch (Exception paramMediaFormat)
      {
        ConvertLog.e(TAG, 1, "init codec error", paramMediaFormat);
      }
      return;
      label80:
      paramInt = 0;
    }
  }
  
  public void init(MediaFormat paramMediaFormat, String paramString, Surface paramSurface)
  {
    MediaCodecInfo localMediaCodecInfo = getCodecInfo(paramString);
    int i;
    if ((localMediaCodecInfo != null) && (localMediaCodecInfo.isEncoder()))
    {
      this.mCodecType = ENC_CODEC;
      i = 1;
    }
    else
    {
      i = 0;
    }
    try
    {
      this.mMediaCodec = MediaCodec.createByCodecName(paramString);
      this.mMediaCodec.configure(paramMediaFormat, paramSurface, null, i);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ConvertLog.e(TAG, 1, "init codec error", paramMediaFormat);
    }
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      MediaCodec localMediaCodec = this.mMediaCodec;
      if (localMediaCodec == null) {
        return;
      }
      try
      {
        this.mMediaCodec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
      }
      catch (Exception localException)
      {
        if (ConvertLog.isColorLevel())
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("queueInputBuffer exception, index[");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append("], sampleSize[");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("], timestamp[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("], flags[");
          localStringBuilder.append(paramInt3);
          localStringBuilder.append("]");
          ConvertLog.e(str, 1, localStringBuilder.toString(), localException);
        }
      }
      return;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      this.inputBuffers = null;
      this.outputBuffers = null;
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void releaseOutputBuffer(int paramInt)
  {
    try
    {
      MediaCodec localMediaCodec = this.mMediaCodec;
      if (localMediaCodec == null) {
        return;
      }
      this.mMediaCodec.releaseOutputBuffer(paramInt, false);
      return;
    }
    finally {}
  }
  
  public void start()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.inputBuffers = this.mMediaCodec.getInputBuffers();
            this.outputBuffers = this.mMediaCodec.getOutputBuffers();
            return;
          }
          finally {}
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ConvertLog.e(TAG, 1, "start codec error", localException);
    }
  }
  
  public void stop()
  {
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.mediacodec.MediaCodecWrapper
 * JD-Core Version:    0.7.0.1
 */