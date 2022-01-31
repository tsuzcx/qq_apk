package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.widget.EditText;
import azaj;
import azbo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class XMediaEditor$1
  implements Runnable
{
  XMediaEditor$1(XMediaEditor paramXMediaEditor, azbo paramazbo) {}
  
  public void run()
  {
    this.a.a.requestFocus();
    this.a.a.findFocus();
    EditText localEditText = this.a.a;
    if (XMediaEditor.a(this.this$0).a >= 0) {}
    for (int i = XMediaEditor.a(this.this$0).a;; i = 0)
    {
      localEditText.setSelection(i);
      ThreadManager.getUIHandler().post(new XMediaEditor.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.1
 * JD-Core Version:    0.7.0.1
 */