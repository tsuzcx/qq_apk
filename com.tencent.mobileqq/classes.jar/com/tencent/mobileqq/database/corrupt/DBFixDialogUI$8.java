package com.tencent.mobileqq.database.corrupt;

class DBFixDialogUI$8
  implements Runnable
{
  DBFixDialogUI$8(DBFixDialogUI paramDBFixDialogUI, int paramInt) {}
  
  public void run()
  {
    if (this.a == DBFixLoadingDialog.d) {
      DBFixDialogUI.e(this.this$0);
    } else if (this.a == DBFixLoadingDialog.e) {
      DBFixDialogUI.f(this.this$0);
    } else if (this.a == DBFixLoadingDialog.f) {
      DBFixDialogUI.g(this.this$0);
    }
    DBFixReportHelper.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.8
 * JD-Core Version:    0.7.0.1
 */