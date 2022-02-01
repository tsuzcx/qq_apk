package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.os.SystemClock;
import bahq;
import baij;
import bail;
import bhhd;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.PipedInputStream;

public class VoiceChange
  extends bail
{
  private static boolean jdField_a_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c;
  private int d;
  
  public VoiceChange(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    if (!jdField_a_of_type_Boolean)
    {
      bahq.a(paramContext, "codecsilk");
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_JavaLangString = new File(paramString).getCanonicalPath();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public native int Create(String paramString);
  
  public native int Init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int Release(int paramInt);
  
  public baij a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = super.a(paramArrayOfByte, paramInt1, paramInt2);
    l = SystemClock.uptimeMillis() - l;
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    this.jdField_a_of_type_Long = (l + this.jdField_a_of_type_Long);
    this.d += 1;
    return paramArrayOfByte;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Long > 0L) && (this.d > 0) && (this.jdField_c_of_type_Int > 0)) {
      PttInfoCollector.reportSoundProcessCost(this.jdField_a_of_type_Long, this.d, this.jdField_b_of_type_Long, this.jdField_c_of_type_Int + 2);
    }
    Release(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_Int = 0;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -1;
    super.a(paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_Long = 0L;
    this.d = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = bhhd.a(paramInt1);
    this.jdField_b_of_type_Int = Create(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_b_of_type_Int == 0) {
      QLog.e("QQVoiceChanger", 1, "Create voiceChanger error with:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      paramInt2 = 1;
      paramInt3 = i;
    }
    for (;;)
    {
      Init(this.jdField_b_of_type_Int, paramInt1, 1, paramInt2, paramInt3);
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int * 10];
      this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_ArrayOfByte.length * 2];
      this.jdField_a_of_type_Baij = new baij(this.jdField_c_of_type_ArrayOfByte, 0);
      return;
      if (this.jdField_c_of_type_Int == 2)
      {
        paramInt2 = 2;
        paramInt3 = i;
      }
      else if (this.jdField_c_of_type_Int == 3)
      {
        paramInt2 = 8;
        paramInt3 = 3;
      }
      else if (this.jdField_c_of_type_Int == 4)
      {
        paramInt2 = 7;
        paramInt3 = i;
      }
      else if (this.jdField_c_of_type_Int == 5)
      {
        paramInt2 = -1;
        paramInt3 = 2;
      }
      else if (this.jdField_c_of_type_Int == 6)
      {
        paramInt2 = 6;
        paramInt3 = i;
      }
      else if (this.jdField_c_of_type_Int == 7)
      {
        paramInt2 = 10;
        paramInt3 = 4;
      }
      else if (this.jdField_c_of_type_Int == 8)
      {
        paramInt2 = 10;
        paramInt3 = 20;
      }
      else if (this.jdField_c_of_type_Int == 9)
      {
        paramInt2 = 11;
        paramInt3 = i;
      }
      else if (this.jdField_c_of_type_Int == 10)
      {
        paramInt2 = 12;
        paramInt3 = i;
      }
      else if (this.jdField_c_of_type_Int == 11)
      {
        paramInt3 = 51;
        paramInt2 = 9;
      }
      else if (this.jdField_c_of_type_Int == 12)
      {
        paramInt2 = 13;
        paramInt3 = 1;
      }
      else if (this.jdField_c_of_type_Int == 13)
      {
        paramInt2 = 536936433;
        paramInt3 = 50;
      }
      else if (this.jdField_c_of_type_Int == 14)
      {
        paramInt2 = -1;
        paramInt3 = 5;
      }
      else if (this.jdField_c_of_type_Int == 15)
      {
        paramInt2 = -1;
        paramInt3 = 9;
      }
      else if (this.jdField_c_of_type_Int == 16)
      {
        paramInt2 = 13;
        paramInt3 = i;
      }
      else
      {
        QLog.e("QQVoiceChanger", 1, "Init Error type=" + this.jdField_c_of_type_Int);
        paramInt3 = 0;
        paramInt2 = 0;
      }
    }
  }
  
  public native int doChange(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) == -1) {
      return -1;
    }
    paramInt2 = doChange(this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "change voice type=" + this.jdField_c_of_type_Int + " changedSize=" + paramInt2);
    }
    System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChange
 * JD-Core Version:    0.7.0.1
 */