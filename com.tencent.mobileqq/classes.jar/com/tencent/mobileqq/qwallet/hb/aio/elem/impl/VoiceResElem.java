package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;

public class VoiceResElem
  extends BaseRedPkgElem
{
  public Bitmap b;
  public String c;
  
  public VoiceResElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.icon;
      this.c = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean a()
  {
    return (this.b != null) && (!TextUtils.isEmpty(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.VoiceResElem
 * JD-Core Version:    0.7.0.1
 */