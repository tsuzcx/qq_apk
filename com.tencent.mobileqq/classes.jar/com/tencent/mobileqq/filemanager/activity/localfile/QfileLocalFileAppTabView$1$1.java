package com.tencent.mobileqq.filemanager.activity.localfile;

import aswy;
import aswz;
import asxa;
import bglp;
import bgpa;
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
    bgpa localbgpa = bglp.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131692229).setNegativeButton(2131690582, new aswz(this)).setPositiveButton(2131692230, new aswy(this));
    localbgpa.setOnDismissListener(new asxa(this));
    localbgpa.setTitle(2131692231);
    localbgpa.setCancelable(false);
    localbgpa.setCanceledOnTouchOutside(false);
    localbgpa.show();
    this.a.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */