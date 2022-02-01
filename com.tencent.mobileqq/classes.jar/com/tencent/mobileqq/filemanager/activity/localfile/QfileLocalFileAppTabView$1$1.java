package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.C != null)
    {
      if (this.a.this$0.C.isFinishing()) {
        return;
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(QfileLocalFileAppTabView.b(this.a.this$0), 230).setMessage(2131889428).setNegativeButton(2131887648, new QfileLocalFileAppTabView.1.1.2(this)).setPositiveButton(2131889429, new QfileLocalFileAppTabView.1.1.1(this));
      localQQCustomDialog.setOnDismissListener(new QfileLocalFileAppTabView.1.1.3(this));
      localQQCustomDialog.setTitle(2131889430);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      localQQCustomDialog.show();
      this.a.this$0.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */