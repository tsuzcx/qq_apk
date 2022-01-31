package com.tencent.mobileqq.filemanager.activity.localfile;

import aqpx;
import aqpy;
import aqpz;
import bdgm;
import bdjz;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131692642).setNegativeButton(2131690648, new aqpy(this)).setPositiveButton(2131692643, new aqpx(this));
    localbdjz.setOnDismissListener(new aqpz(this));
    localbdjz.setTitle(2131692644);
    localbdjz.setCancelable(false);
    localbdjz.setCanceledOnTouchOutside(false);
    localbdjz.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */