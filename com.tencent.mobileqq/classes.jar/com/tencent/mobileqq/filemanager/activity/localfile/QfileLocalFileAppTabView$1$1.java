package com.tencent.mobileqq.filemanager.activity.localfile;

import aqlo;
import aqlp;
import aqlq;
import bdcd;
import bdfq;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131692641).setNegativeButton(2131690648, new aqlp(this)).setPositiveButton(2131692642, new aqlo(this));
    localbdfq.setOnDismissListener(new aqlq(this));
    localbdfq.setTitle(2131692643);
    localbdfq.setCancelable(false);
    localbdfq.setCanceledOnTouchOutside(false);
    localbdfq.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */