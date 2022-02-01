package com.tencent.mobileqq.qassistant.audio;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.VadHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VoiceBeanProcessor
{
  private VoiceBeanProcessor.PttEncodeListener jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor$PttEncodeListener;
  private AudioCompositeProcessor jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor;
  private VadHelper jdField_a_of_type_ComTencentMobileqqUtilsVadHelper;
  private boolean jdField_a_of_type_Boolean = false;
  
  public VoiceBeanProcessor(RecordParams.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor$PttEncodeListener = new VoiceBeanProcessor.PttEncodeListener();
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor = new AudioCompositeProcessor();
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(new SilkCodecWrapper(BaseApplication.getContext()));
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.b, paramRecorderParam.c);
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor$PttEncodeListener);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper = new VadHelper();
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.c();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.a();
          return;
          this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.d();
        }
      }
      return;
    }
    catch (IOException paramRecorderParam)
    {
      paramRecorderParam.printStackTrace();
    }
  }
  
  public VoiceEncodeResult a(byte[] paramArrayOfByte)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject = new ArrayList();
        int i = 0;
        IAudioProcessor.ProcessData localProcessData;
        if (i < paramArrayOfByte.length)
        {
          int k = Math.min(paramArrayOfByte.length - i, 6400);
          localProcessData = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(paramArrayOfByte, i, k);
          i += k;
          ((List)localObject).add(localProcessData);
        }
        else
        {
          long l2;
          i = 2000;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
        return paramArrayOfByte;
        paramArrayOfByte = ((List)localObject).iterator();
        i = 0;
        if (paramArrayOfByte.hasNext())
        {
          i = ((IAudioProcessor.ProcessData)paramArrayOfByte.next()).jdField_a_of_type_Int + i;
        }
        else
        {
          paramArrayOfByte = new byte[i];
          localObject = ((List)localObject).iterator();
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            localProcessData = (IAudioProcessor.ProcessData)((Iterator)localObject).next();
            System.arraycopy(localProcessData.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, i, localProcessData.jdField_a_of_type_Int);
            i = localProcessData.jdField_a_of_type_Int + i;
          }
          else
          {
            l2 = System.currentTimeMillis();
            AssistantUtils.a("VoiceBeanProcessor", "silk encode time:" + (l2 - l1));
            if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor$PttEncodeListener != null)
            {
              i = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor$PttEncodeListener.a();
              paramArrayOfByte = new VoiceEncodeResult(paramArrayOfByte, i);
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a();
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.b();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    finally {}
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqUtilsVadHelper.a(paramArrayOfByte, this.jdField_a_of_type_Boolean);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceBeanProcessor
 * JD-Core Version:    0.7.0.1
 */