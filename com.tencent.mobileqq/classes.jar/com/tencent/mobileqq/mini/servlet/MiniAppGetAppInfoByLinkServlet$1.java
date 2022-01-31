package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import android.content.Intent;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;

class MiniAppGetAppInfoByLinkServlet$1
  implements Runnable
{
  MiniAppGetAppInfoByLinkServlet$1(MiniAppGetAppInfoByLinkServlet paramMiniAppGetAppInfoByLinkServlet, Intent paramIntent, INTERFACE.StGetAppInfoByLinkRsp paramStGetAppInfoByLinkRsp) {}
  
  public void run()
  {
    MiniAppInfo.saveMiniAppByLinkEntity(this.val$intent.getStringExtra("key_link"), this.val$intent.getIntExtra("key_link_type", 0), this.val$result.shareTicket.get(), this.val$result.appInfo);
    MiniAppInfo.saveMiniAppInfoEntity(this.val$result.appInfo);
    MiniAppInfo.saveMiniAppShowInfoEntity(this.val$result.appInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByLinkServlet.1
 * JD-Core Version:    0.7.0.1
 */