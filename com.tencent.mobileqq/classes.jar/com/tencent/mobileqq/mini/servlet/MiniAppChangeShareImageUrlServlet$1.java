package com.tencent.mobileqq.mini.servlet;

import NS_MINI_SHARE.MiniProgramShare.StAdaptSharePicReq;
import android.content.Intent;
import com.tencent.mobileqq.pb.PBStringField;

class MiniAppChangeShareImageUrlServlet$1
  extends ProtoBufRequest
{
  MiniAppChangeShareImageUrlServlet$1(MiniAppChangeShareImageUrlServlet paramMiniAppChangeShareImageUrlServlet, Intent paramIntent) {}
  
  public byte[] getBusiBuf()
  {
    MiniProgramShare.StAdaptSharePicReq localStAdaptSharePicReq = new MiniProgramShare.StAdaptSharePicReq();
    localStAdaptSharePicReq.srcPicUrl.set(this.val$intent.getStringExtra("key_old_image_url"));
    return localStAdaptSharePicReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppChangeShareImageUrlServlet.1
 * JD-Core Version:    0.7.0.1
 */