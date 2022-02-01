package com.tencent.mobileqq.qqlive.prepare;

import android.text.Editable;
import android.text.Selection;
import android.widget.EditText;

class QQLivePrepareFragment$3
  implements Runnable
{
  QQLivePrepareFragment$3(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void run()
  {
    Editable localEditable = QQLivePrepareFragment.k(this.this$0).getText();
    Selection.setSelection(localEditable, localEditable.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.3
 * JD-Core Version:    0.7.0.1
 */