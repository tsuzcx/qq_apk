package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class PublishLbsPart$9
  implements DialogInterface.OnClickListener
{
  PublishLbsPart$9(PublishLbsPart paramPublishLbsPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    this.a.c().startActivityForResult(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.9
 * JD-Core Version:    0.7.0.1
 */