package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.SystemClock;
import auct;
import audm;
import audo;
import axte;
import bahn;
import com.tencent.qphone.base.util.QLog;
import java.io.PipedInputStream;

public final class SilkCodecWrapper
  extends audo
{
  private static boolean jdField_b_of_type_Boolean;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  int c;
  private int d;
  
  public SilkCodecWrapper(Context paramContext)
  {
    super(paramContext);
    a(true);
  }
  
  public SilkCodecWrapper(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    a(paramBoolean);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!jdField_b_of_type_Boolean)
    {
      auct.a(this.jdField_a_of_type_AndroidContentContext, "codecsilk");
      jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public native int SilkDecoderNew(int paramInt1, int paramInt2);
  
  public native int SilkEncoderNew(int paramInt1, int paramInt2);
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    if (this.jdField_b_of_type_Int == 0) {
      return 0;
    }
    try
    {
      paramInt1 = decode(this.jdField_b_of_type_Int, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
      l = SystemClock.uptimeMillis() - l;
      this.jdField_a_of_type_Long += l;
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
      this.jdField_c_of_type_Int += 1;
      return paramInt1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return 0;
  }
  
  public audm a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = super.a(paramArrayOfByte, paramInt1, paramInt2);
    l = SystemClock.uptimeMillis() - l;
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    this.jdField_a_of_type_Long = (l + this.jdField_a_of_type_Long);
    this.jdField_c_of_type_Int += 1;
    return paramArrayOfByte;
  }
  
  public void a()
  {
    super.a();
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    try
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (this.jdField_b_of_type_Int = SilkEncoderNew(paramInt1, paramInt2);; this.jdField_b_of_type_Int = SilkDecoderNew(paramInt1, paramInt2))
      {
        this.jdField_a_of_type_Int = bahn.a(paramInt1);
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
        this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
        this.jdField_a_of_type_Audm = new audm(this.jdField_c_of_type_ArrayOfByte, 0);
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SilkCodecWrapper", 2, "init silk codec =" + localUnsatisfiedLinkError.toString());
        }
        this.jdField_b_of_type_Int = 0;
        jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int != 0)
    {
      deleteCodec(this.jdField_b_of_type_Int);
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_c_of_type_Int > 0))
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label60;
        }
        axte.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long, 0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 0;
      return;
      label60:
      axte.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long, 1);
    }
  }
  
  public void close()
  {
    super.close();
    b();
  }
  
  public native int decode(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3);
  
  public native void deleteCodec(int paramInt);
  
  public native int encode(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) == -1) {
      return -1;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.d = encode(this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    }
    bahn.a(this.d, paramArrayOfByte, paramInt1);
    System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1 + 2, this.d);
    return this.d + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SilkCodecWrapper
 * JD-Core Version:    0.7.0.1
 */