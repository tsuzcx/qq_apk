package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;
import mqq.os.MqqHandler;

class XMediaEditor$1
  implements Runnable
{
  XMediaEditor$1(XMediaEditor paramXMediaEditor, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public void run()
  {
    this.a.a.requestFocus();
    this.a.a.findFocus();
    EditText localEditText = this.a.a;
    int i;
    if (XMediaEditor.a(this.this$0).a >= 0) {
      i = XMediaEditor.a(this.this$0).a;
    } else {
      i = 0;
    }
    localEditText.setSelection(i);
    ThreadManager.getUIHandler().post(new XMediaEditor.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.1
 * JD-Core Version:    0.7.0.1
 */