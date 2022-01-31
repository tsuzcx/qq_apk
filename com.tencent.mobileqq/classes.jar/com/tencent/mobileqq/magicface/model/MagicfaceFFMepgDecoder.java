package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceFFMepgDecoder
  extends MagicfaceDecoder
{
  public DecoderUtil a;
  public byte[] a;
  public int[] a;
  public byte[] b;
  public int c;
  public byte[] c;
  public int d;
  public byte[] d;
  public int e;
  public byte[] e;
  public int f;
  public byte[] f;
  public int g;
  public int h;
  public int i = -1;
  public int j = -1;
  
  public MagicfaceFFMepgDecoder()
  {
    this.jdField_b_of_type_ArrayOfByte = new byte[51200];
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_e_of_type_ArrayOfByte = new byte[51200];
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder begins");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends");
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int k;
    if (paramInt == paramArrayOfByte.length) {
      k = -1;
    }
    do
    {
      return k;
      int m = paramInt + 1;
      int n = 0;
      int i1 = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
      k = n;
      paramInt = m;
      if (i1 != 7)
      {
        k = n;
        paramInt = m;
        if (i1 != 8)
        {
          k = 1;
          paramInt = m;
        }
      }
      while (paramInt < paramArrayOfByte.length - 4) {
        if ((paramArrayOfByte[paramInt] == 0) && (paramArrayOfByte[(paramInt + 1)] == 0) && (paramArrayOfByte[(paramInt + 2)] == 0) && (paramArrayOfByte[(paramInt + 3)] == 1))
        {
          m = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
          if ((m != 7) && (m != 8))
          {
            if (k != 0) {
              break;
            }
            paramInt += 1;
            k = 1;
          }
          else
          {
            paramInt += 1;
          }
        }
        else
        {
          paramInt += 1;
        }
      }
      k = paramInt;
    } while (paramInt != paramArrayOfByte.length - 4);
    return paramArrayOfByte.length;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func maigcfaceDecoder begins:,isStartDecodr:" + this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
        if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder() == 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder() != 0)) {}
        this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_b_of_type_ArrayOfByte;
        byte[] arrayOfByte1 = this.jdField_a_of_type_ArrayOfByte;
        if (arrayOfByte1 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "===MagicfaceDecoder=Exception==" + localException.getMessage());
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError4) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError4.getMessage());
        return;
        k = 1;
        l2 = 0L;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        l1 = System.currentTimeMillis();
        m = a(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int);
        this.jdField_c_of_type_Int = (m - this.jdField_d_of_type_Int);
        n = this.jdField_c_of_type_Int;
        if (n > 0) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError5) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError5.getMessage());
        return;
        a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
        this.jdField_d_of_type_Int = m;
        l3 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoder(this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.jdField_c_of_type_ArrayOfByte);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "decodeVideoDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==videoFrameLength==" + this.jdField_c_of_type_Int);
        try
        {
          if (this.jdField_e_of_type_Int == -1)
          {
            this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
            this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
            if ((this.jdField_e_of_type_Int > 500) || (this.jdField_f_of_type_Int > 500))
            {
              this.jdField_e_of_type_Int = -1;
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
                continue;
              }
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
                return;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError6) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError6.getMessage());
              return;
            }
            this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_f_of_type_Int * this.jdField_e_of_type_Int];
          }
          m = a(this.jdField_d_of_type_ArrayOfByte, this.h);
          this.g = (m - this.h);
          b(this.g, this.h, this.jdField_d_of_type_ArrayOfByte);
          this.h = m;
          l3 = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoder(this.jdField_e_of_type_ArrayOfByte, this.g, this.jdField_f_of_type_ArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "decodeAlphaDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==alphaFrameLength==" + this.g);
          }
          l3 = System.currentTimeMillis();
          arrayOfInt = a(this.jdField_c_of_type_ArrayOfByte, this.jdField_f_of_type_ArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "convertByteToColor==usetime=" + (System.currentTimeMillis() - l3));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener.a(arrayOfInt, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
          }
          l3 = System.currentTimeMillis() - l1;
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "==============frameTime=============" + l3);
          }
          if (l3 >= this.jdField_b_of_type_Int) {
            continue;
          }
          if (l2 <= 0L) {
            continue;
          }
          l1 = this.jdField_b_of_type_Int - l3;
          if (l1 <= l2) {
            continue;
          }
          Thread.sleep(l1 - l2);
          l1 = l2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MagicfaceFFMepgDecoder", 2, "magicfaceffMepgDecoder outofMemoryError");
          }
          this.jdField_e_of_type_Int = -1;
          System.gc();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError7) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError7.getMessage());
        return;
        l1 = l2 - l1;
        break label1186;
        Thread.sleep(this.jdField_b_of_type_Int - l3);
        l1 = l2;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        localOutOfMemoryError3.printStackTrace();
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError8) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError8.getMessage());
        return;
        l1 = l2;
        if (k != 0) {
          break label1186;
        }
        k = this.jdField_b_of_type_Int;
        l1 = l2 + (l3 - k);
      }
      finally
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          break label1161;
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError1.getMessage());
        return;
      }
      this.jdField_d_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
      arrayOfByte2 = this.jdField_d_of_type_ArrayOfByte;
      if (arrayOfByte2 == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
            return;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {}
          if (QLog.isColorLevel()) {
            QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError2.getMessage());
          }
        }
      }
      else {
        try
        {
          this.jdField_c_of_type_ArrayOfByte = new byte[480000];
          this.jdField_f_of_type_ArrayOfByte = new byte[480000];
          byte[] arrayOfByte3 = this.jdField_c_of_type_ArrayOfByte;
          if (arrayOfByte3 == null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
              continue;
            }
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
              return;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError3) {}
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError3.getMessage());
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localOutOfMemoryError1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends, OOM.");
          }
        }
      }
    }
    for (;;)
    {
      long l1;
      try
      {
        int m;
        int n;
        long l3;
        int[] arrayOfInt;
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        label1161:
        throw localObject;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError9)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError9.getMessage());
        continue;
      }
      label1186:
      int k = 0;
      long l2 = l1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.jdField_b_of_type_ArrayOfByte.length < paramInt1)
    {
      this.jdField_b_of_type_ArrayOfByte = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "videoFrame.length = " + this.jdField_b_of_type_ArrayOfByte.length + "new framelength = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.jdField_b_of_type_ArrayOfByte, 0, paramInt1);
  }
  
  public int[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = 0;
    if (m < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int i1 = m * 3;
      int n = paramArrayOfByte2[i1] & 0xFF;
      int k;
      if (n <= 50) {
        k = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfInt[m] = (k << 24 & 0xFF000000 | paramArrayOfByte1[(i1 + 2)] << 16 & 0xFF0000 | paramArrayOfByte1[(i1 + 1)] << 8 & 0xFF00 | paramArrayOfByte1[i1] & 0xFF);
        m += 1;
        break;
        k = n;
        if (n >= 235) {
          k = 255;
        }
      }
    }
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.jdField_e_of_type_ArrayOfByte.length < paramInt1)
    {
      this.jdField_e_of_type_ArrayOfByte = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "alphaFrame.length = " + this.jdField_e_of_type_ArrayOfByte.length + " new fillFrameAlpha = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.jdField_e_of_type_ArrayOfByte, 0, paramInt1);
  }
  
  public void c()
  {
    super.c();
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_e_of_type_ArrayOfByte = null;
    this.jdField_f_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    System.gc();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_d_of_type_Int = 0;
    this.h = 0;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceFFMepgDecoder
 * JD-Core Version:    0.7.0.1
 */