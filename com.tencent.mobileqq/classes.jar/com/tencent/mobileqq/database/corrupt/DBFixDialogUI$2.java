package com.tencent.mobileqq.database.corrupt;

import android.app.Activity;
import android.app.Dialog;

class DBFixDialogUI$2
  implements Runnable
{
  DBFixDialogUI$2(DBFixDialogUI paramDBFixDialogUI, Dialog paramDialog) {}
  
  public void run()
  {
    if (((this.this$0.a instanceof Activity)) && (((Activity)this.this$0.a).isFinishing())) {
      return;
    }
    this.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.2
 * JD-Core Version:    0.7.0.1
 */