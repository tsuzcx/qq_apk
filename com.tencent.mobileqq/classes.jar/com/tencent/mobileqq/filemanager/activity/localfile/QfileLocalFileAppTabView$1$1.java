package com.tencent.mobileqq.filemanager.activity.localfile;

import aosm;
import aosn;
import aoso;
import bbcv;
import bbgg;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    bbgg localbbgg = bbcv.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131692564).setNegativeButton(2131690596, new aosn(this)).setPositiveButton(2131692565, new aosm(this));
    localbbgg.setOnDismissListener(new aoso(this));
    localbbgg.setTitle(2131692566);
    localbbgg.setCancelable(false);
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */