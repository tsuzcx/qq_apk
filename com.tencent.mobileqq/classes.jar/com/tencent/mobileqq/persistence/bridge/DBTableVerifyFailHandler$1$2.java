package com.tencent.mobileqq.persistence.bridge;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;

class DBTableVerifyFailHandler$1$2
  implements DialogInterface.OnClickListener
{
  DBTableVerifyFailHandler$1$2(DBTableVerifyFailHandler.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("table ");
    paramDialogInterface.append(this.a.a);
    paramDialogInterface.append(" Entity file changed without updating DBVersion");
    ExceptionTracker.trackException("DBVerifyFailToastHandler", paramDialogInterface.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler.1.2
 * JD-Core Version:    0.7.0.1
 */