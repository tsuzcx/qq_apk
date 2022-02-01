package com.tencent.mobileqq.richmedia.capture.audio;

import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.videocodec.audio.AudioCapture.AudioCaptureListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder.AudioEncodeListener;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceChanger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class AudioChangerManager
  implements HWAudioEncoder.AudioEncodeListener
{
  public static int a;
  public static int b;
  private AudioCapture.AudioCaptureListener jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener;
  HWAudioEncoder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder;
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
    double d1 = jdField_a_of_type_Int;
    Double.isNaN(d1);
    jdField_b_of_type_Int = (int)(d1 * 0.02D * 1.0D * 4.0D);
  }
  
  public AudioChangerManager(String paramString, int paramInt, AudioCapture.AudioCaptureListener paramAudioCaptureListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtils.genSeperateFileDir(paramString));
    localStringBuilder.append("audio_data_cache");
    localStringBuilder.append(File.separator);
    this.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener = paramAudioCaptureListener;
  }
  
  private boolean b()
  {
    return (c()) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener != null);
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
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    return false;
  }
  
  public void a()
  {
    if (!b()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(VidUtil.generateVid());
    localStringBuilder.append(".pcm");
    this.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger = new VoiceChanger(this.jdField_c_of_type_JavaLangString, jdField_a_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_c_of_type_JavaLangString, "rw");
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      this.jdField_a_of_type_ArrayOfByte = new byte[jdField_b_of_type_Int];
    }
    this.e = 0;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder = new HWAudioEncoder();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a(CodecParam.mAudioSampleRate);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a(this.jdField_b_of_type_JavaLangString);
      AEQLog.a("AudioChangerManager", "New mHwAudioEncoder");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((a()) && (b()))
    {
      paramInt1 = 0;
      Object localObject;
      for (;;)
      {
        int i = jdField_b_of_type_Int;
        if (paramInt2 < i) {
          break;
        }
        localObject = this.jdField_a_of_type_ArrayOfByte;
        if (localObject == null) {
          return;
        }
        int j = this.e;
        System.arraycopy(paramArrayOfByte, paramInt1, localObject, j, i - j);
        localObject = new short[jdField_b_of_type_Int / 2];
        ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])localObject);
        localObject = this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger.writeVoiceFrames((short[])localObject);
        if (localObject == null) {
          return;
        }
        try
        {
          if (!this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_JavaIoRandomAccessFile.write((byte[])localObject, 0, localObject.length);
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder != null) && (this.jdField_b_of_type_Boolean))
        {
          byte[] arrayOfByte = new byte[localObject.length];
          System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a(arrayOfByte, 0L);
        }
        i = jdField_b_of_type_Int;
        j = this.e;
        paramInt1 += i - j;
        paramInt2 -= i - j;
        this.e = 0;
      }
      if (paramInt2 > 0)
      {
        localObject = this.jdField_a_of_type_ArrayOfByte;
        if (localObject == null) {
          return;
        }
        System.arraycopy(paramArrayOfByte, paramInt1, localObject, this.e, paramInt2);
        this.e = paramInt2;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (FeatureManager.Features.LIGHT_SDK.isFunctionReady());
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger;
    if (localObject != null) {
      ((VoiceChanger)localObject).release();
    }
    localObject = this.jdField_a_of_type_JavaIoRandomAccessFile;
    if (localObject != null) {
      try
      {
        ((RandomAccessFile)localObject).close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    this.jdField_a_of_type_ArrayOfByte = null;
    HWAudioEncoder localHWAudioEncoder = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder;
    if (localHWAudioEncoder != null) {
      localHWAudioEncoder.c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener.onAudioChangeCaptured(this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void c()
  {
    AEQLog.a("AudioChangerManager", "[onAudioFileEncoded]");
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener.onAudioChangeCaptured(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder = null;
  }
  
  public void d()
  {
    AEQLog.a("AudioChangerManager", "[onAudioFileEncodeFailed]");
    AudioCapture.AudioCaptureListener localAudioCaptureListener = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener;
    if (localAudioCaptureListener != null) {
      localAudioCaptureListener.onAudioError(-6);
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioChangerManager
 * JD-Core Version:    0.7.0.1
 */