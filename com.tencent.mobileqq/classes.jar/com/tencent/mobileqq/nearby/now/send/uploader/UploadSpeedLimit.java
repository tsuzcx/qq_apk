package com.tencent.mobileqq.nearby.now.send.uploader;

import com.tencent.qphone.base.util.BaseApplication;

public class UploadSpeedLimit
{
  public final int a;
  private boolean a;
  private int b = a();
  private int c;
  private final int d = 16;
  private final int e = 32;
  private final int f = 64;
  private final int g = 128;
  private final int h = 2000;
  
  public UploadSpeedLimit()
  {
    this.jdField_a_of_type_Int = 16;
  }
  
  private int a(float paramFloat)
  {
    return Math.max(16, Math.min(128, (int)(paramFloat / 16.0F) * 16));
  }
  
  public int a()
  {
    if (com.tencent.mobileqq.utils.NetworkUtil.h(BaseApplication.getContext())) {
      return 64;
    }
    if ((com.tencent.biz.common.util.NetworkUtil.a(BaseApplication.getContext()) == 3) || (com.tencent.biz.common.util.NetworkUtil.a(BaseApplication.getContext()) == 4)) {
      return 32;
    }
    return 16;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if ((com.tencent.biz.common.util.NetworkUtil.a(BaseApplication.getContext()) == 2) || (com.tencent.biz.common.util.NetworkUtil.a(BaseApplication.getContext()) == 3))
    {
      paramInt1 = a() * 1024;
      return paramInt1;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return 131072;
    }
    if (paramInt2 == 0)
    {
      paramInt1 = a();
      label50:
      if (this.b <= paramInt1) {
        break label140;
      }
      this.c = a((paramInt1 + this.b) / 2);
    }
    for (;;)
    {
      this.b = this.c;
      int i = Math.max(8192, this.c / 8 * 8192);
      paramInt1 = i;
      if (paramInt2 >= 1000) {
        break;
      }
      long l = 1000 - paramInt2;
      try
      {
        Thread.sleep(l);
        return i;
      }
      catch (InterruptedException localInterruptedException)
      {
        return i;
      }
      paramInt1 = paramInt1 * 1000 / paramInt2;
      break label50;
      label140:
      if (this.b < paramInt1) {
        this.c = a(this.b * 2);
      } else {
        this.c = paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.UploadSpeedLimit
 * JD-Core Version:    0.7.0.1
 */