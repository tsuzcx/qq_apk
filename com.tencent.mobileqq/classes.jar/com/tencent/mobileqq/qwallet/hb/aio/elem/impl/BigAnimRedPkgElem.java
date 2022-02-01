package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class BigAnimRedPkgElem
  extends BaseRedPkgElem
{
  public Bitmap b;
  public AnimationView.AnimationInfo c;
  
  public BigAnimRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.specialBackground;
      this.c = paramRedPacketInfo.specailBackgroundAnimInfo;
    }
  }
  
  public boolean a()
  {
    return (this.c != null) || (this.b != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.BigAnimRedPkgElem
 * JD-Core Version:    0.7.0.1
 */