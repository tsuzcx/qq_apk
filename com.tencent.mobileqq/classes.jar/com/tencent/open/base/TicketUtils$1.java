package com.tencent.open.base;

import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

class TicketUtils$1
  extends SSOAccountObserver
{
  TicketUtils$1(TicketUtils paramTicketUtils) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 == 0)
    {
      paramBundle = new WloginSimpleInfo();
      if (this.a.b != null) {
        this.a.b.getBasicUserInfo(paramString, paramBundle);
      }
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(paramBundle._uin);
      paramString = paramString.toString();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("outA1 buff: ");
        paramBundle.append(util.buf_to_string(paramArrayOfByte));
        util.LOGD(paramBundle.toString());
        paramArrayOfByte = new RSACrypt(CommonDataAdapter.a().b()).EncryptData(this.a.a(CommonDataAdapter.a().b(), this.a.c, 1L), paramArrayOfByte);
        paramBundle = new StringBuilder();
        paramBundle.append("encrypt buff:");
        paramBundle.append(util.buf_to_string(paramArrayOfByte));
        util.LOGD(paramBundle.toString());
        if (this.a.a != null) {
          this.a.a.a(paramString, paramArrayOfByte);
        }
      }
    }
    else if (this.a.a != null)
    {
      this.a.a.a();
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.TicketUtils.1
 * JD-Core Version:    0.7.0.1
 */