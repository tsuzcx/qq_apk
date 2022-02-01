package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class Pcm2AmrWrapper
{
  private static boolean k = false;
  private int a = 14;
  private long b;
  private long c;
  private int d = 1;
  private byte[] e = new byte[320];
  private byte[] f;
  private byte[] g = new byte[320];
  private int h;
  private byte[] i;
  private int j;
  
  public Pcm2AmrWrapper(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    this.h = 0;
    this.i = new byte[10240];
    this.j = 0;
    if (!k)
    {
      boolean bool1;
      StringBuilder localStringBuilder;
      try
      {
        bool1 = SoLoadUtilNew.loadSoByName(paramContext, "amrnb");
      }
      catch (Throwable paramContext)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("libamrnb.so load failed, exception info : ");
          localStringBuilder.append(QLog.getStackTraceString(paramContext));
          QLog.e("Pcm2AmrWrapper", 2, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
      if (bool1) {
        k = true;
      } else {
        try
        {
          System.loadLibrary("amrnb");
          k = true;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("libamrnb.so load system way failed, exception info : ");
            localStringBuilder.append(QLog.getStackTraceString(paramContext));
            QLog.e("Pcm2AmrWrapper", 2, localStringBuilder.toString());
          }
        }
      }
    }
    this.d = paramInt;
    this.a = Amr2PcmWrapper.a(paramInt);
    this.f = new byte[this.a];
    this.b = AmrInputStreamWrapper.CreateEncoder();
    this.c = AmrInputStreamWrapper.GsmAmrEncoderNew(this.b);
    AmrInputStreamWrapper.GsmAmrEncoderInitialize(this.c);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    long l1 = this.b;
    if (l1 != 0L)
    {
      long l2 = this.c;
      if (l2 != 0L)
      {
        if (AmrInputStreamWrapper.GsmAmrEncoderEncode(l1, l2, this.d, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
          b();
        }
        return;
      }
    }
    throw new IllegalStateException("not open");
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifeq +14 -> 20
    //   9: aload_0
    //   10: getfield 106	com/tencent/mobileqq/utils/Pcm2AmrWrapper:b	J
    //   13: aload_0
    //   14: getfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   17: invokestatic 133	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(JJ)V
    //   20: aload_0
    //   21: getfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifeq +14 -> 40
    //   29: aload_0
    //   30: getfield 106	com/tencent/mobileqq/utils/Pcm2AmrWrapper:b	J
    //   33: aload_0
    //   34: getfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   37: invokestatic 136	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   40: aload_0
    //   41: lconst_0
    //   42: putfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   45: aload_0
    //   46: invokevirtual 123	com/tencent/mobileqq/utils/Pcm2AmrWrapper:b	()V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: lconst_0
    //   53: putfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifeq +14 -> 79
    //   68: aload_0
    //   69: getfield 106	com/tencent/mobileqq/utils/Pcm2AmrWrapper:b	J
    //   72: aload_0
    //   73: getfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   76: invokestatic 136	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   79: aload_0
    //   80: lconst_0
    //   81: putfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: lconst_0
    //   89: putfield 112	com/tencent/mobileqq/utils/Pcm2AmrWrapper:c	J
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	Pcm2AmrWrapper
    //   50	7	1	localObject1	Object
    //   58	27	1	localObject2	Object
    //   86	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	40	50	finally
    //   0	20	58	finally
    //   59	79	86	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int m = this.h;
    if (paramInt + m > 10240) {
      this.i = new byte[m + paramInt];
    }
    m = this.h;
    if (paramInt + m < 320)
    {
      System.arraycopy(paramArrayOfByte, 0, this.g, m, paramInt);
      return null;
    }
    System.arraycopy(this.g, 0, this.i, 0, m);
    System.arraycopy(paramArrayOfByte, 0, this.i, this.h, paramInt);
    this.j = (paramInt + this.h);
    paramInt = this.j;
    m = paramInt % 320;
    this.h = m;
    if (m != 0) {
      System.arraycopy(this.i, paramInt - m, this.g, 0, m);
    }
    paramArrayOfByte = new byte[this.j / 320 * this.a];
    m = 0;
    paramInt = 0;
    while (this.j >= 320)
    {
      System.arraycopy(this.i, paramInt, this.e, 0, 320);
      try
      {
        a(this.e, this.f);
        arrayOfByte = this.f;
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, m, arrayOfByte.length);
        m += this.f.length;
        paramInt += 320;
        this.j -= 320;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Pcm2AmrWrapper", 2, "========mPcm2Amr.pcm2amrParser==IOException=====", paramArrayOfByte);
        }
        b();
        return null;
      }
    }
    if (m == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[m];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, m);
    return arrayOfByte;
  }
  
  public void b()
  {
    this.h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.Pcm2AmrWrapper
 * JD-Core Version:    0.7.0.1
 */