package com.tencent.mobileqq.mini.servlet;

import NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeReq;
import android.content.Intent;
import com.tencent.mobileqq.pb.PBUInt32Field;

class MiniAppStoreGetAppListServlet$1
  extends ProtoBufRequest
{
  MiniAppStoreGetAppListServlet$1(MiniAppStoreGetAppListServlet paramMiniAppStoreGetAppListServlet, Intent paramIntent) {}
  
  public byte[] getBusiBuf()
  {
    MiniAppStore.StGetFirstPageByTypeReq localStGetFirstPageByTypeReq = new MiniAppStore.StGetFirstPageByTypeReq();
    localStGetFirstPageByTypeReq.uiPageType.set(this.val$intent.getIntExtra("key_app_store_get_app_list_type", 0));
    return localStGetFirstPageByTypeReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppStoreGetAppListServlet.1
 * JD-Core Version:    0.7.0.1
 */