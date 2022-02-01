package com.tencent.open.downloadnew;

import android.content.DialogInterface.OnClickListener;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

class MyAppApi$17$1
  implements Runnable
{
  MyAppApi$17$1(MyAppApi.17 param17, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.c.a.a();
    if (this.c.e.q != null)
    {
      try
      {
        if ((this.a != null) && (this.a.length != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          String str2;
          try
          {
            String str1 = util.buf_to_string(this.a);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            str2 = null;
          }
          TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = this.c.e.q;
          localStringBuilder.append(this.b);
          localStringBuilder.append("&identity=");
          localStringBuilder.append(str2);
          localTMAssistantCallYYBParamStruct.uin = localStringBuilder.toString();
          this.c.e.m = this.c.b;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      if (this.c.e.a() <= 2) {
        ((TMAssistantCallYYB_V1)this.c.e.d()).startToAuthorized(this.c.c, this.c.e.q, "2");
      } else {
        ((TMAssistantCallYYB_V2)this.c.e.d()).startToAuthorized(this.c.c, this.c.e.q, "2");
      }
      this.c.e.q = null;
      if (this.c.d != null) {
        this.c.d.onClick(null, 0);
      }
    }
    else
    {
      LogUtility.e("MyAppApi", "startToAuthorizedDirect->onGetA1 mLastAuthorizeParam = null, needCarryQQIdentity = true");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.17.1
 * JD-Core Version:    0.7.0.1
 */