package com.tencent.mobileqq.filemanager.activity.localfile;

import aosq;
import aosr;
import aoss;
import bbdj;
import bbgu;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131692565).setNegativeButton(2131690596, new aosr(this)).setPositiveButton(2131692566, new aosq(this));
    localbbgu.setOnDismissListener(new aoss(this));
    localbbgu.setTitle(2131692567);
    localbbgu.setCancelable(false);
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */