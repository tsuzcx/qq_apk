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
    ExceptionTracker.trackException("DBVerifyFailToastHandler", "table " + this.a.a + " Entity file changed without updating DBVersion");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler.1.2
 * JD-Core Version:    0.7.0.1
 */