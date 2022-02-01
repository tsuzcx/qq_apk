package com.tencent.mobileqq.ptt.preop;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessorListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;

public class PttPreVoiceChanger
  implements IAudioProcessorListener
{
  AudioCompositeProcessor a;
  String b;
  FileOutputStream c;
  int d;
  public int e;
  
  public void a()
  {
    try
    {
      if (this.c != null)
      {
        this.c.close();
        this.c = null;
      }
      if (this.a != null)
      {
        this.a.a();
        this.a = null;
      }
      this.d = 0;
      this.e = 0;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("PttPreVoiceChanger", 2, "PttPreVoiceChanger.close error");
      }
    }
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof SilkCodecWrapper)) || ((paramIAudioProcessor instanceof AmrInputStreamWrapper))) {
      this.e += (int)((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(this.d, 4, 2, paramProcessData.a);
    }
  }
  
  public boolean a(Context paramContext, String paramString1, int paramInt, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    try
    {
      this.a = new AudioCompositeProcessor();
      if (paramInt != 0) {
        this.a.a(((IVoiceChangeHelper)QRoute.api(IVoiceChangeHelper.class)).createVoiceChangeObj(paramContext, paramInt, paramString2));
      }
      if (paramRecorderParam.c == 0) {
        this.a.a(new AmrInputStreamWrapper(paramContext));
      } else {
        this.a.a(new SilkCodecWrapper(paramContext));
      }
      this.a.a(paramRecorderParam.a, paramRecorderParam.b, paramRecorderParam.c);
      this.d = paramRecorderParam.a;
      this.a.a(this);
      this.e = 0;
      this.b = paramString1;
      paramContext = new File(this.b);
      if (paramContext.exists()) {
        paramContext.delete();
      }
      paramContext.createNewFile();
      this.c = new FileOutputStream(paramContext);
      paramContext = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
      this.c.write(paramContext, 0, paramContext.length);
      this.c.flush();
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.a != null)
      {
        paramArrayOfByte = this.a.a(paramArrayOfByte, 0, paramInt);
        if (paramArrayOfByte != null) {
          this.c.write(paramArrayOfByte.c, 0, paramArrayOfByte.a);
        }
      }
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.e("PttPreVoiceChanger", 4, "handleSliceDataIfNeed exception !!!");
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete tempfile, path : ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("PttPreVoiceChanger", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.b))
    {
      localObject = new File(this.b);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
  }
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData) {}
  
  public int c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PttPreVoiceChanger
 * JD-Core Version:    0.7.0.1
 */