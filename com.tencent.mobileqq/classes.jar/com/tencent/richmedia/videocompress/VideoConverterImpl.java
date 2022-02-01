package com.tencent.richmedia.videocompress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.richmedia.videocompress.converter.HardwareConverter;
import com.tencent.richmedia.videocompress.converter.SoftwareConverter;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoConverterImpl
{
  private static final String TAG = "VideoConverter";
  private int compressMode = 3;
  private boolean mCancelled = false;
  private VideoConverter.Processor mConverterCallback;
  private Throwable mException;
  private Process mProcess;
  private WeakReference<Thread> mThreadRef;
  private boolean noNeedCompress = false;
  private boolean running = false;
  private boolean useNativeCodec = false;
  
  private void initConverterCallback(VideoConverter.Processor paramProcessor)
  {
    this.mConverterCallback = new VideoConverterImpl.1(this, paramProcessor);
  }
  
  @SuppressLint({"NewApi"})
  private int startHardwareConvert(String paramString, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.useNativeCodec) {
      paramString = localObject;
    }
    for (;;)
    {
      paramString = new Thread(paramString, "VideoConverter");
      this.mThreadRef = new WeakReference(paramString);
      paramString.start();
      if (paramBoolean) {}
      try
      {
        paramString.join();
        if (this.mException != null)
        {
          return -1003;
          initConverterCallback(paramProcessor);
          paramString = new HardwareConverter(paramString, this.mConverterCallback);
        }
      }
      catch (InterruptedException paramString)
      {
        for (;;)
        {
          ConvertLog.e("VideoConverter", 1, "startHardwareConvert error", paramString);
        }
        if (this.mCancelled) {
          return -1002;
        }
        if (this.noNeedCompress) {
          return -1;
        }
      }
    }
    return 0;
  }
  
  private int startSoftwareConvert(String paramString, VideoConverter.Processor paramProcessor)
  {
    int i = SoftwareConverter.compressVideo(paramString, new VideoConverterImpl.2(this, paramProcessor));
    try
    {
      if (this.mProcess != null)
      {
        this.mProcess.destroy();
        this.mProcess = null;
      }
      return i;
    }
    catch (Exception paramString) {}
    return i;
  }
  
  protected boolean cancel()
  {
    if (this.mThreadRef != null)
    {
      Thread localThread = (Thread)this.mThreadRef.get();
      if (localThread != null) {
        localThread.interrupt();
      }
    }
    SoftwareConverter.continueCompress.set(false);
    if (this.mProcess != null) {
      this.mProcess.destroy();
    }
    return true;
  }
  
  public int executeFFmpegCmd(List<String> paramList)
  {
    return SoftwareConverter.executeFFmpegCmd(paramList, null);
  }
  
  protected void setCompressMode(int paramInt)
  {
    this.compressMode = paramInt;
  }
  
  protected void setFFmpegBinAndSoPath(String paramString1, String paramString2)
  {
    SoftwareConverter.setFFmpegBinAndSoPath(paramString1, paramString2);
  }
  
  protected int start(Context paramContext, String paramString, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    int m = 0;
    if (!this.running)
    {
      this.running = true;
      int n = -5;
      if ((this.compressMode == 1) && (Build.VERSION.SDK_INT < 18))
      {
        j = -3;
        return j;
      }
      int i = MediaCodecSupport.checkSupportMediaCodecFeature(paramContext);
      if ((Build.VERSION.SDK_INT >= 18) && ((i & 0x1) > 0) && ((i & 0x2) > 0)) {}
      for (int j = 1; (this.compressMode == 1) && (j == 0); j = 0) {
        return -6;
      }
      int k;
      if ((this.compressMode == 3) || (this.compressMode == 1))
      {
        k = 1;
        label114:
        i = n;
        if (j != 0)
        {
          i = n;
          if (k != 0) {
            i = startHardwareConvert(paramString, paramProcessor, paramBoolean);
          }
        }
        paramBoolean = SoftwareConverter.supportCodec();
        if ((j != 0) || (this.compressMode != 3)) {
          break label214;
        }
      }
      label214:
      for (j = 1;; j = 0)
      {
        if (this.compressMode != 2)
        {
          k = m;
          if (j == 0) {}
        }
        else
        {
          k = 1;
        }
        j = i;
        if (!paramBoolean) {
          break;
        }
        j = i;
        if (k == 0) {
          break;
        }
        return startSoftwareConvert(paramString, paramProcessor);
        k = 0;
        break label114;
      }
    }
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.VideoConverterImpl
 * JD-Core Version:    0.7.0.1
 */