package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;

class XMediaEditor$2$1
  implements Runnable
{
  XMediaEditor$2$1(XMediaEditor.2 param2) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.this$0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.a.b.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.2.1
 * JD-Core Version:    0.7.0.1
 */