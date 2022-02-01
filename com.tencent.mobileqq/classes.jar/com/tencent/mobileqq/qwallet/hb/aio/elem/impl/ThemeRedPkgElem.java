package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class ThemeRedPkgElem
  extends BaseRedPkgElem
{
  public String b;
  public AnimationView.AnimationInfo c;
  
  public ThemeRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.background;
      this.c = paramRedPacketInfo.animInfo;
    }
  }
  
  public boolean a()
  {
    return (this.b != null) || (this.c != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.ThemeRedPkgElem
 * JD-Core Version:    0.7.0.1
 */