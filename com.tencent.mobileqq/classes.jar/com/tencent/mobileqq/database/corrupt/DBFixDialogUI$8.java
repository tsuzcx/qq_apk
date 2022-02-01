package com.tencent.mobileqq.database.corrupt;

class DBFixDialogUI$8
  implements Runnable
{
  DBFixDialogUI$8(DBFixDialogUI paramDBFixDialogUI, int paramInt) {}
  
  public void run()
  {
    if (this.a == DBFixLoadingDialog.d) {
      DBFixDialogUI.c(this.this$0);
    }
    while (this.a != DBFixLoadingDialog.e) {
      return;
    }
    DBFixDialogUI.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.8
 * JD-Core Version:    0.7.0.1
 */