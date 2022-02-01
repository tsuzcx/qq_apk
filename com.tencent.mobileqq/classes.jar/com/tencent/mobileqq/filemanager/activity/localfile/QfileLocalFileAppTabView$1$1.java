package com.tencent.mobileqq.filemanager.activity.localfile;

import atdr;
import atds;
import atdt;
import bhdj;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    if ((this.a.this$0.a == null) || (this.a.this$0.a.isFinishing())) {
      return;
    }
    QQCustomDialog localQQCustomDialog = bhdj.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131692372).setNegativeButton(2131690697, new atds(this)).setPositiveButton(2131692373, new atdr(this));
    localQQCustomDialog.setOnDismissListener(new atdt(this));
    localQQCustomDialog.setTitle(2131692374);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */