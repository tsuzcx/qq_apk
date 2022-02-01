package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.av.temp.IQavTemp;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.silk.SilkSoLoader;
import com.tencent.mobileqq.qroute.QRoute;
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
    this.jdField_b_of_type_Long += l;
    this.jdField_c_of_type_Int += 1;
    return paramArrayOfByte;
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_c_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0)) {
      ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportSoundProcessCost(this.jdField_b_of_type_Long, this.jdField_c_of_type_Int, this.jdField_c_of_type_Long, this.jdField_b_of_type_Int + 2);
    }
    Release(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Int = QQAudioUtils.a(paramInt1);
    Object localObject = ((IQavTemp)QRoute.api(IQavTemp.class)).getAudio3ALicenseFilename();
    boolean bool = QLog.isColorLevel();
    paramInt2 = 1;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("voice Init getAudio3ALicenseFilename  = ");
      localStringBuilder.append((String)localObject);
      QLog.e("QQVoiceChanger", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Long = Create(this.jdField_a_of_type_JavaLangString, (String)localObject);
    if (this.jdField_a_of_type_Long == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Create voiceChanger error with:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.e("QQVoiceChanger", 1, ((StringBuilder)localObject).toString());
    }
    paramInt3 = this.jdField_b_of_type_Int;
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramInt3 = -1;
      break label405;
      if (paramInt3 == 2)
      {
        paramInt2 = 2;
      }
      else
      {
        if (paramInt3 == 3)
        {
          paramInt2 = 8;
          paramInt3 = 3;
          break label405;
        }
        if (paramInt3 == 4)
        {
          paramInt2 = 7;
        }
        else
        {
          if (paramInt3 == 5)
          {
            paramInt2 = -1;
            paramInt3 = 2;
            break label405;
          }
          if (paramInt3 == 6)
          {
            paramInt2 = 6;
          }
          else
          {
            if (paramInt3 == 7)
            {
              paramInt2 = 10;
              paramInt3 = 4;
              break label405;
            }
            if (paramInt3 == 8)
            {
              paramInt2 = 10;
              paramInt3 = 20;
              break label405;
            }
            if (paramInt3 == 9)
            {
              paramInt2 = 11;
            }
            else if (paramInt3 == 10)
            {
              paramInt2 = 12;
            }
            else
            {
              if (paramInt3 == 11)
              {
                paramInt2 = 9;
                paramInt3 = 51;
                break label405;
              }
              if (paramInt3 == 12)
              {
                paramInt2 = 13;
                paramInt3 = 1;
                break label405;
              }
              if (paramInt3 == 13)
              {
                paramInt2 = 536936433;
                paramInt3 = 50;
                break label405;
              }
              if (paramInt3 == 14)
              {
                paramInt2 = -1;
                paramInt3 = 5;
                break label405;
              }
              if (paramInt3 == 15)
              {
                paramInt2 = -1;
                paramInt3 = 9;
                break label405;
              }
              if (paramInt3 != 16) {
                break;
              }
              paramInt2 = 13;
            }
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init Error type=");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    QLog.e("QQVoiceChanger", 1, ((StringBuilder)localObject).toString());
    paramInt2 = 0;
    paramInt3 = 0;
    label405:
    Init(this.jdField_a_of_type_Long, paramInt1, 1, paramInt2, paramInt3);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int * 10];
    this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_ArrayOfByte.length * 2];
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessor$ProcessData = new IAudioProcessor.ProcessData(this.jdField_c_of_type_ArrayOfByte, 0);
  }
  
  public native int doChange(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) == -1) {
      return -1;
    }
    paramInt2 = doChange(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("change voice type=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" changedSize=");
      localStringBuilder.append(paramInt2);
      QLog.d("QQVoiceChanger", 2, localStringBuilder.toString());
    }
    System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChange
 * JD-Core Version:    0.7.0.1
 */