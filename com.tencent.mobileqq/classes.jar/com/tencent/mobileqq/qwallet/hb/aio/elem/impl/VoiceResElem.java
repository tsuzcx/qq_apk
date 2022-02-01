package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;

public class VoiceResElem
  extends BaseRedPkgElem
{
  public Bitmap a;
  public String b;
  
  public VoiceResElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.a = paramRedPacketInfo.icon;
      this.b = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (!TextUtils.isEmpty(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.VoiceResElem
 * JD-Core Version:    0.7.0.1
 */