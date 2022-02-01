package com.tencent.qqconnect.wtlogin;

import android.os.Bundle;
import mqq.observer.SSOAccountObserver;

class LoginHelper$1
  extends SSOAccountObserver
{
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.a.a();
    this.a.a = null;
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    } else {
      paramArrayOfByte = null;
    }
    this.a.a.a(paramString, paramArrayOfByte);
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.LoginHelper.1
 * JD-Core Version:    0.7.0.1
 */