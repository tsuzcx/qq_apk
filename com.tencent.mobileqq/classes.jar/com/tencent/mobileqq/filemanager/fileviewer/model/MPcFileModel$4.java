package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class MPcFileModel$4
  implements DialogInterface.OnClickListener
{
  MPcFileModel$4(MPcFileModel paramMPcFileModel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b();
    this.a.a.removeObserver(MPcFileModel.a(this.a));
    Intent localIntent = new Intent(this.a.a.getApplication(), LiteActivity.class);
    localIntent.addFlags(67108864);
    this.a.a.getApplication().startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel.4
 * JD-Core Version:    0.7.0.1
 */