package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.HashMap;

public final class WechatNsWrapper
  extends AudioComponentProcessor
{
  public static boolean a;
  short[] a;
  int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public WechatNsWrapper()
  {
    super(BaseApplication.getContext());
    this.jdField_c_of_type_Int = 0;
    c();
  }
  
  public WechatNsWrapper(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = 0;
    c();
  }
  
  private void c()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      boolean bool = SoLoadUtil.a(this.jdField_a_of_type_AndroidContentContext, "stlport_shared", 0, false);
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "load stlport_shared " + bool);
      }
      bool = SoLoadUtilNew.loadSoByName(this.jdField_a_of_type_AndroidContentContext, "voicemessagedenoise");
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "load voicemessagedenoise " + bool);
      }
      bool = SoLoadUtilNew.loadSoByName(this.jdField_a_of_type_AndroidContentContext, "wechatns");
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "load wechatns " + bool);
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("throwable", localThrowable.getMessage());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWechatNsLoadFail", false, 0L, 0L, localHashMap, "");
    }
  }
  
  public void a()
  {
    super.a();
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 960;
    super.a(paramInt1, paramInt2, paramInt3);
    if (this.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Int = nsNew();
        if (QLog.isColorLevel()) {
          QLog.d("SilkCodecWrapper", 2, "silkEncoderNew =" + this.jdField_b_of_type_Int);
        }
        paramInt2 = nsInit(this.jdField_b_of_type_Int, paramInt1);
        if (paramInt2 != 0) {
          continue;
        }
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        if (QLog.isColorLevel()) {
          QLog.d("SilkCodecWrapper", 2, "silkEncoderInit =" + paramInt2);
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkCodecWrapper", 2, "init silk codec =" + localException.toString());
        this.jdField_b_of_type_Int = 0;
        jdField_a_of_type_Boolean = false;
        continue;
      }
      this.jdField_a_of_type_Int = QQAudioUtils.a(paramInt1);
      this.jdField_a_of_type_ArrayOfShort = new short[this.jdField_a_of_type_Int / 2];
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
      paramInt1 = i;
      if (this.jdField_a_of_type_Int * 2 > 960) {
        paramInt1 = this.jdField_a_of_type_Int * 2;
      }
      this.jdField_c_of_type_ArrayOfByte = new byte[paramInt1];
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessor$ProcessData = new IAudioProcessor.ProcessData(this.jdField_c_of_type_ArrayOfByte, 0);
      return;
      bool = false;
    }
  }
  
  public void a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    ByteBuffer.wrap(paramArrayOfByte, 0, paramArrayOfByte.length).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(paramArrayOfShort, 0, paramArrayOfByte.length / 2);
  }
  
  public void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(paramArrayOfShort);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int != 0)
    {
      int i = nsDelete(this.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "deleteCodec =" + i);
      }
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void close()
  {
    super.close();
    b();
  }
  
  public native int nsDelete(int paramInt);
  
  public native int nsInit(int paramInt1, int paramInt2);
  
  public native int nsNew();
  
  public native int nsProcess(int paramInt1, short[] paramArrayOfShort, int paramInt2);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Boolean)) {
      if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) != -1) {}
    }
    while (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) == -1)
    {
      return -1;
      a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfShort);
      nsProcess(this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfShort, this.jdField_a_of_type_ArrayOfByte.length);
      a(this.jdField_a_of_type_ArrayOfShort, this.jdField_a_of_type_ArrayOfByte);
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, this.jdField_a_of_type_Int);
      return this.jdField_a_of_type_Int;
    }
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, this.jdField_a_of_type_Int);
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.WechatNsWrapper
 * JD-Core Version:    0.7.0.1
 */