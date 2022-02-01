package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.av.so.ResMgr;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.silk.SilkSoLoader;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.PipedInputStream;

public class VoiceChange
  extends AudioComponentProcessor
{
  private static boolean jdField_a_of_type_Boolean = false;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  
  public VoiceChange(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    if (!jdField_a_of_type_Boolean)
    {
      SilkSoLoader.a(paramContext, "codecsilk");
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_JavaLangString = new File(paramString).getCanonicalPath();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public native long Create(String paramString1, String paramString2);
  
  public native int Init(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int Release(long paramLong);
  
  public IAudioProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = super.a(paramArrayOfByte, paramInt1, paramInt2);
    l = SystemClock.uptimeMillis() - l;
    if (l > this.jdField_c_of_type_Long) {
      this.jdField_c_of_type_Long = l;
    }
    this.jdField_b_of_type_Long = (l + this.jdField_b_of_type_Long);
    this.jdField_c_of_type_Int += 1;
    return paramArrayOfByte;
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_c_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0)) {
      PttInfoCollector.reportSoundProcessCost(this.jdField_b_of_type_Long, this.jdField_c_of_type_Int, this.jdField_c_of_type_Long, this.jdField_b_of_type_Int + 2);
    }
    Release(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -1;
    super.a(paramInt1, paramInt2, paramInt3);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Int = QQAudioUtils.a(paramInt1);
    String str = ResMgr.a();
    if (QLog.isColorLevel()) {
      QLog.e("QQVoiceChanger", 1, "voice Init getAudio3ALicenseFilename  = " + str);
    }
    this.jdField_a_of_type_Long = Create(this.jdField_a_of_type_JavaLangString, str);
    if (this.jdField_a_of_type_Long == 0L) {
      QLog.e("QQVoiceChanger", 1, "Create voiceChanger error with:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      paramInt2 = 1;
      paramInt3 = i;
    }
    for (;;)
    {
      Init(this.jdField_a_of_type_Long, paramInt1, 1, paramInt2, paramInt3);
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int * 10];
      this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_ArrayOfByte.length * 2];
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessor$ProcessData = new IAudioProcessor.ProcessData(this.jdField_c_of_type_ArrayOfByte, 0);
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramInt2 = 2;
        paramInt3 = i;
      }
      else if (this.jdField_b_of_type_Int == 3)
      {
        paramInt2 = 8;
        paramInt3 = 3;
      }
      else if (this.jdField_b_of_type_Int == 4)
      {
        paramInt2 = 7;
        paramInt3 = i;
      }
      else if (this.jdField_b_of_type_Int == 5)
      {
        paramInt2 = -1;
        paramInt3 = 2;
      }
      else if (this.jdField_b_of_type_Int == 6)
      {
        paramInt2 = 6;
        paramInt3 = i;
      }
      else if (this.jdField_b_of_type_Int == 7)
      {
        paramInt2 = 10;
        paramInt3 = 4;
      }
      else if (this.jdField_b_of_type_Int == 8)
      {
        paramInt2 = 10;
        paramInt3 = 20;
      }
      else if (this.jdField_b_of_type_Int == 9)
      {
        paramInt2 = 11;
        paramInt3 = i;
      }
      else if (this.jdField_b_of_type_Int == 10)
      {
        paramInt2 = 12;
        paramInt3 = i;
      }
      else if (this.jdField_b_of_type_Int == 11)
      {
        paramInt3 = 51;
        paramInt2 = 9;
      }
      else if (this.jdField_b_of_type_Int == 12)
      {
        paramInt2 = 13;
        paramInt3 = 1;
      }
      else if (this.jdField_b_of_type_Int == 13)
      {
        paramInt2 = 536936433;
        paramInt3 = 50;
      }
      else if (this.jdField_b_of_type_Int == 14)
      {
        paramInt2 = -1;
        paramInt3 = 5;
      }
      else if (this.jdField_b_of_type_Int == 15)
      {
        paramInt2 = -1;
        paramInt3 = 9;
      }
      else if (this.jdField_b_of_type_Int == 16)
      {
        paramInt2 = 13;
        paramInt3 = i;
      }
      else
      {
        QLog.e("QQVoiceChanger", 1, "Init Error type=" + this.jdField_b_of_type_Int);
        paramInt3 = 0;
        paramInt2 = 0;
      }
    }
  }
  
  public native int doChange(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) == -1) {
      return -1;
    }
    paramInt2 = doChange(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "change voice type=" + this.jdField_b_of_type_Int + " changedSize=" + paramInt2);
    }
    System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChange
 * JD-Core Version:    0.7.0.1
 */