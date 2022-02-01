package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class Amr2PcmWrapper
{
  static final int[] a = { 12, 13, 15, 17, 19, 20, 26, 31, 5, 0 };
  private static boolean k = false;
  private int b = 14;
  private long c;
  private long d;
  private byte[] e;
  private byte[] f = new byte[320];
  private byte[] g;
  private int h = 0;
  private byte[] i = new byte[1024];
  private int j = 0;
  
  public Amr2PcmWrapper(Context paramContext, int paramInt)
  {
    if ((!k) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      k = true;
    }
    this.b = a(paramInt);
    paramInt = this.b;
    this.e = new byte[paramInt];
    this.g = new byte[paramInt];
    this.c = AmrInputStreamWrapper.CreateDecoder();
    this.d = AmrInputStreamWrapper.GsmAmrDecoderNew(this.c);
    AmrInputStreamWrapper.GsmAmrDecoderInitialize(this.d);
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 8)) {
      return a[paramInt] + 1;
    }
    return 14;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    long l1 = this.d;
    if (l1 != 0L)
    {
      long l2 = this.c;
      if (l2 != 0L)
      {
        if (AmrInputStreamWrapper.GsmAmrDecoderDecode(l2, l1, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
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
    //   1: getfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifeq +14 -> 20
    //   9: aload_0
    //   10: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:c	J
    //   13: aload_0
    //   14: getfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   17: invokestatic 92	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderCleanup	(JJ)V
    //   20: aload_0
    //   21: getfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifeq +14 -> 40
    //   29: aload_0
    //   30: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:c	J
    //   33: aload_0
    //   34: getfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   37: invokestatic 95	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(JJ)V
    //   40: aload_0
    //   41: lconst_0
    //   42: putfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   45: aload_0
    //   46: invokevirtual 81	com/tencent/mobileqq/utils/Amr2PcmWrapper:b	()V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: lconst_0
    //   53: putfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifeq +14 -> 79
    //   68: aload_0
    //   69: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:c	J
    //   72: aload_0
    //   73: getfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   76: invokestatic 95	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(JJ)V
    //   79: aload_0
    //   80: lconst_0
    //   81: putfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: lconst_0
    //   89: putfield 70	com/tencent/mobileqq/utils/Amr2PcmWrapper:d	J
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	Amr2PcmWrapper
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
    if (paramInt + m > 1024) {
      this.i = new byte[m + paramInt];
    }
    m = this.h;
    if (paramInt + m < this.b)
    {
      System.arraycopy(paramArrayOfByte, 0, this.g, m, paramInt);
      return null;
    }
    System.arraycopy(this.g, 0, this.i, 0, m);
    System.arraycopy(paramArrayOfByte, 0, this.i, this.h, paramInt);
    this.j = (paramInt + this.h);
    paramInt = this.j;
    m = paramInt % this.b;
    this.h = m;
    if (m != 0) {
      System.arraycopy(this.i, paramInt - m, this.g, 0, m);
    }
    paramArrayOfByte = new byte[this.j / this.b * 320];
    m = 0;
    paramInt = 0;
    for (;;)
    {
      int n = this.j;
      int i1 = this.b;
      if (n >= i1)
      {
        System.arraycopy(this.i, paramInt, this.e, 0, i1);
        try
        {
          a(this.e, this.f);
          arrayOfByte = this.f;
          System.arraycopy(arrayOfByte, 0, paramArrayOfByte, m, arrayOfByte.length);
          m += this.f.length;
          n = this.b;
          paramInt += n;
          this.j -= n;
        }
        catch (IOException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Amr2PcmWrapper", 2, "========mAmr2Pcm.amr2pcmParser==IOException=====", paramArrayOfByte);
          }
          b();
          return null;
        }
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
 * Qualified Name:     com.tencent.mobileqq.utils.Amr2PcmWrapper
 * JD-Core Version:    0.7.0.1
 */