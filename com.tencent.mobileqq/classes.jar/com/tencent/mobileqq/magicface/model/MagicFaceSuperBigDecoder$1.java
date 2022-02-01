package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

class MagicFaceSuperBigDecoder$1
  implements Runnable
{
  MagicFaceSuperBigDecoder$1(MagicFaceSuperBigDecoder paramMagicFaceSuperBigDecoder) {}
  
  public void run()
  {
    int i;
    long l2;
    try
    {
      if (!QLog.isColorLevel()) {
        break label748;
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("func mDecoder.run begins, isStartDecodr:");
      localStringBuilder1.append(this.this$0.f);
      QLog.d("MagicFaceSuperBigDecoder", 2, localStringBuilder1.toString());
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder1;
      int j;
      long l3;
      Object localObject;
      localOutOfMemoryError.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (!QLog.isColorLevel()) {
        break label747;
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("func mDecoder.run ends, error is catched.msg:");
      localStringBuilder2.append(localException.getMessage());
      QLog.d("MagicFaceSuperBigDecoder", 2, localStringBuilder2.toString());
    }
    if (this.this$0.f)
    {
      l1 = System.currentTimeMillis();
      j = this.this$0.a(this.this$0.h, this.this$0.l);
      this.this$0.k = (j - this.this$0.l);
      if (this.this$0.k <= 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("func mDecoder.run ends, 【condition】 frame len <= 0, videoFrameLength:");
          localStringBuilder1.append(this.this$0.k);
          QLog.d("MagicFaceSuperBigDecoder", 2, localStringBuilder1.toString());
        }
      }
      else
      {
        this.this$0.a(this.this$0.k, this.this$0.l, this.this$0.h);
        this.this$0.l = j;
        this.this$0.g.decodeVideoDecoderReturnYUV(this.this$0.i, this.this$0.k, this.this$0.j);
        if (this.this$0.m == -1)
        {
          this.this$0.m = this.this$0.g.getWidthVideoDecoder();
          this.this$0.n = this.this$0.g.getHeightVideoDecoder();
        }
        j = this.this$0.a(this.this$0.o, this.this$0.s);
        this.this$0.r = (j - this.this$0.s);
        this.this$0.b(this.this$0.r, this.this$0.s, this.this$0.o);
        if (this.this$0.r <= 0)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("func mDecoder.run ends, 【condition】 frame len <= 0, alphaFrameLength:");
            localStringBuilder1.append(this.this$0.r);
            QLog.d("MagicFaceSuperBigDecoder", 2, localStringBuilder1.toString());
          }
        }
        else
        {
          this.this$0.s = j;
          this.this$0.g.decodeAlphaDecoderReturnYUV(this.this$0.p, this.this$0.r, this.this$0.q);
          if (this.this$0.t == -1)
          {
            this.this$0.t = this.this$0.g.getWidthAlphaDecoder();
            this.this$0.u = this.this$0.g.getHeightAlphaDecoder();
          }
          if (this.this$0.c != null) {
            this.this$0.c.a(this.this$0.j, this.this$0.q, this.this$0.m, this.this$0.n, 0.0F);
          }
          l3 = System.currentTimeMillis() - l1;
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("func mDecoder.run, 【useFrameTime】 ");
            localStringBuilder1.append(l3);
            QLog.d("MagicFaceSuperBigDecoder", 2, localStringBuilder1.toString());
          }
          if (l3 < this.this$0.e)
          {
            if (localObject > 0L)
            {
              l1 = this.this$0.e - l3;
              if (l1 <= localObject) {
                break label756;
              }
              Thread.sleep(l1 - localObject);
              l1 = localObject;
            }
            else
            {
              Thread.sleep(this.this$0.e - l3);
              l1 = localObject;
            }
          }
          else
          {
            l1 = localObject;
            if (i == 0) {
              i = this.this$0.e;
            }
          }
        }
      }
    }
    label747:
    label748:
    label756:
    for (long l1 = localObject + (l3 - i);; l1 = l2 - l1)
    {
      i = 0;
      l2 = l1;
      break;
      StringBuilder localStringBuilder2;
      return;
      i = 1;
      l2 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder.1
 * JD-Core Version:    0.7.0.1
 */