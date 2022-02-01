package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import android.content.Intent;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class MiniAppGetAppInfoByIdServlet$1
  implements Runnable
{
  MiniAppGetAppInfoByIdServlet$1(MiniAppGetAppInfoByIdServlet paramMiniAppGetAppInfoByIdServlet, Intent paramIntent, INTERFACE.StGetAppInfoByIdRsp paramStGetAppInfoByIdRsp) {}
  
  public void run()
  {
    String str = this.val$intent.getStringExtra("key_first_path");
    MiniAppInfo.saveMiniAppByIdEntity(str, this.val$result.appInfo);
    MiniAppInfo.saveMiniAppInfoEntity(this.val$result.appInfo);
    MiniAppInfo.saveMiniAppShowInfoEntity(this.val$result.appInfo);
    MiniAppInfo.saveMiniAppInfoByIdEntity(str, this.val$result.appInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdServlet.1
 * JD-Core Version:    0.7.0.1
 */