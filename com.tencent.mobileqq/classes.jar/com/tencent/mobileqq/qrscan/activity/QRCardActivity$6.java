package com.tencent.mobileqq.qrscan.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class QRCardActivity$6
  implements DialogInterface.OnClickListener
{
  QRCardActivity$6(QRCardActivity paramQRCardActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.toLowerCase();
    if (paramDialogInterface.startsWith("www."))
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("http://");
      paramDialogInterface.append(this.a);
      paramDialogInterface = paramDialogInterface.toString();
    }
    else if (paramDialogInterface.startsWith("https:"))
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("https");
      paramDialogInterface.append(this.a.substring(5));
      paramDialogInterface = paramDialogInterface.toString();
    }
    else if (paramDialogInterface.startsWith("http:"))
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("http");
      paramDialogInterface.append(this.a.substring(4));
      paramDialogInterface = paramDialogInterface.toString();
    }
    else
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("http://");
      paramDialogInterface.append(this.a);
      paramDialogInterface = paramDialogInterface.toString();
    }
    Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("injectrecommend", false);
    this.b.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.6
 * JD-Core Version:    0.7.0.1
 */