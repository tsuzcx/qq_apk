package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;

public class ResPathRedPkgElem
  extends BaseRedPkgElem
{
  public String b;
  
  public ResPathRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      this.b = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.ResPathRedPkgElem
 * JD-Core Version:    0.7.0.1
 */