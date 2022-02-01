package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

class PublishLbsPart$11
  implements DialogInterface.OnClickListener
{
  PublishLbsPart$11(PublishLbsPart paramPublishLbsPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    paramDialogInterface.setData(Uri.fromParts("package", this.a.c().getPackageName(), null));
    this.a.c().startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.11
 * JD-Core Version:    0.7.0.1
 */