package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class UriParserPathHelper$2
  implements DialogInterface.OnClickListener
{
  UriParserPathHelper$2(UriParserPathHelper paramUriParserPathHelper, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      UriParserPathHelper.a(this.e, this.a, this.b, this.c, this.d);
      this.e.c = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (UriParserPathHelper.b == null) {
        paramDialogInterface = this.e.a.getString(2131916548);
      } else {
        paramDialogInterface = UriParserPathHelper.b;
      }
      UriParserPathHelper.a(this.e, paramDialogInterface);
      if (UriParserPathHelper.b(this.e) != null)
      {
        UriParserPathHelper.b(this.e).a(this.a);
        UriParserPathHelper.a(this.e, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.UriParserPathHelper.2
 * JD-Core Version:    0.7.0.1
 */