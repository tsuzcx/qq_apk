package com.tencent.mobileqq.richmedia.capture.audio;

import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWAudioEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWAudioEncoder.AudioEncodeListener;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceChanger;
import dov.com.qq.im.ae.util.AEQLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AudioChangerManager
  implements HWAudioEncoder.AudioEncodeListener
{
  public static int a;
  public static int b;
  private AudioCapture.AudioCaptureListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener;
  HWAudioEncoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder;
  protected VoiceChanger a;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile = null;
  private final String jdField_a_of_type_JavaLangString = "AudioChangerManager";
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = null;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = null;
  private int e = 0;
  
  static
  {
    jdField_a_of_type_Int = com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.SAMPLE_RATES[4];
    jdField_b_of_type_Int = (int)(jdField_a_of_type_Int * 0.02D * 1.0D * 4.0D);
  }
  
  public AudioChangerManager(String paramString, int paramInt, AudioCapture.AudioCaptureListener paramAudioCaptureListener)
  {
    this.jdField_d_of_type_JavaLangString = (FileUtils.genSeperateFileDir(paramString) + "audio_data_cache" + File.separator);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener = paramAudioCaptureListener;
  }
  
  private boolean b()
  {
    return (c()) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener != null);
  }
  
  private boolean c()
  {
    try
    {
      File localFile = new File(this.jdField_d_of_type_JavaLangString);
      if (!localFile.exists()) {
        return localFile.mkdir();
      }
      if (localFile.isFile())
      {
        localFile.delete();
        boolean bool = localFile.mkdir();
        return bool;
      }
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void a()
  {
    if (!b()) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + VidUtil.generateVid() + ".pcm");
      this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger = new VoiceChanger(this.jdField_c_of_type_JavaLangString, jdField_a_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_c_of_type_JavaLangString, "rw");
        if (this.jdField_a_of_type_ArrayOfByte == null) {
          this.jdField_a_of_type_ArrayOfByte = new byte[jdField_b_of_type_Int];
        }
        this.e = 0;
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder != null)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder = new HWAudioEncoder();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder.a(CodecParam.mAudioSampleRate);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder.a(this);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder.a(this.jdField_b_of_type_JavaLangString);
        AEQLog.a("AudioChangerManager", "New mHwAudioEncoder");
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (FeatureManager.Features.LIGHT_SDK.isFunctionReady());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger != null) {
      this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger.release();
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.close();
      this.jdField_a_of_type_ArrayOfByte = null;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder.c();
      }
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener.onAudioChangeCaptured(this.jdField_c_of_type_JavaLangString);
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void h()
  {
    AEQLog.a("AudioChangerManager", "[onAudioFileEncoded]");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener.onAudioChangeCaptured(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder = null;
  }
  
  public void i()
  {
    AEQLog.a("AudioChangerManager", "[onAudioFileEncodeFailed]");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener.onAudioError(-6);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioChangerManager
 * JD-Core Version:    0.7.0.1
 */