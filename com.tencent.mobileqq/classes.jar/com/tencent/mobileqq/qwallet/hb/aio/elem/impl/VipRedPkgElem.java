package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;

public class VipRedPkgElem
  extends BaseRedPkgElem
{
  public Bitmap b;
  public Drawable[] c;
  public ICustomizeStrategyFactory.AnimConfig d;
  public boolean e;
  
  public VipRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.e;
      this.c = paramRedPacketInfo.i;
      this.d = paramRedPacketInfo.h;
      this.e = paramRedPacketInfo.g;
    }
  }
  
  public boolean a()
  {
    return (this.b != null) || (this.c != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.VipRedPkgElem
 * JD-Core Version:    0.7.0.1
 */