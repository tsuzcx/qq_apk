package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import android.content.Intent;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class MiniAppGetAppInfoByIdForSDKServlet$1
  implements Runnable
{
  MiniAppGetAppInfoByIdForSDKServlet$1(MiniAppGetAppInfoByIdForSDKServlet paramMiniAppGetAppInfoByIdForSDKServlet, Intent paramIntent, INTERFACE.StGetAppInfoByIdRsp paramStGetAppInfoByIdRsp) {}
  
  public void run()
  {
    MiniAppInfo.saveMiniAppByIdEntity(this.val$intent.getStringExtra("key_first_path"), this.val$result.appInfo);
    MiniAppInfo.saveMiniAppInfoEntity(this.val$result.appInfo);
    MiniAppInfo.saveMiniAppShowInfoEntity(this.val$result.appInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdForSDKServlet.1
 * JD-Core Version:    0.7.0.1
 */