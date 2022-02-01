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
  int jdField_a_of_type_Int;
  AudioCompositeProcessor jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor;
  FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  String jdField_a_of_type_JavaLangString;
  public int b;
  
  public int a()
  {
    return this.b;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a();
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor = null;
      }
      this.jdField_a_of_type_Int = 0;
      this.b = 0;
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
      this.b += (int)((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(this.jdField_a_of_type_Int, 4, 2, paramProcessData.jdField_a_of_type_Int);
    }
  }
  
  public boolean a(Context paramContext, String paramString1, int paramInt, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor = new AudioCompositeProcessor();
      if (paramInt != 0) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(((IVoiceChangeHelper)QRoute.api(IVoiceChangeHelper.class)).createVoiceChangeObj(paramContext, paramInt, paramString2));
      }
      if (paramRecorderParam.c == 0) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(new AmrInputStreamWrapper(paramContext));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(new SilkCodecWrapper(paramContext));
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.b, paramRecorderParam.c);
      this.jdField_a_of_type_Int = paramRecorderParam.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(this);
      this.b = 0;
      this.jdField_a_of_type_JavaLangString = paramString1;
      paramContext = new File(this.jdField_a_of_type_JavaLangString);
      if (paramContext.exists()) {
        paramContext.delete();
      }
      paramContext.createNewFile();
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramContext);
      paramContext = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaIoFileOutputStream.write(paramContext, 0, paramContext.length);
      this.jdField_a_of_type_JavaIoFileOutputStream.flush();
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
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(paramArrayOfByte, 0, paramInt);
        if (paramArrayOfByte != null) {
          this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.jdField_a_of_type_Int);
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("PttPreVoiceChanger", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
  }
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PttPreVoiceChanger
 * JD-Core Version:    0.7.0.1
 */