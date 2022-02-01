package com.tencent.mobileqq.filemanager.activity.localfile;

import atnc;
import atnd;
import atne;
import bhlq;
import bhpc;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    if ((this.a.this$0.a == null) || (this.a.this$0.a.isFinishing())) {
      return;
    }
    bhpc localbhpc = bhlq.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131692234).setNegativeButton(2131690580, new atnd(this)).setPositiveButton(2131692235, new atnc(this));
    localbhpc.setOnDismissListener(new atne(this));
    localbhpc.setTitle(2131692236);
    localbhpc.setCancelable(false);
    localbhpc.setCanceledOnTouchOutside(false);
    localbhpc.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */