package com.tencent.mobileqq.filemanager.activity.localfile;

import aobs;
import aobt;
import aobu;
import babr;
import bafb;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    bafb localbafb = babr.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131626946).setNegativeButton(2131625035, new aobt(this)).setPositiveButton(2131626947, new aobs(this));
    localbafb.setOnDismissListener(new aobu(this));
    localbafb.setTitle(2131626948);
    localbafb.setCancelable(false);
    localbafb.setCanceledOnTouchOutside(false);
    localbafb.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */