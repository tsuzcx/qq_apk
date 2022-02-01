package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;

class TextItem$6
  implements Runnable
{
  TextItem$6(TextItem paramTextItem, TextItem.TextViewHolder paramTextViewHolder, TextInfo paramTextInfo) {}
  
  public void run()
  {
    this.a.b.requestFocus();
    this.a.b.findFocus();
    this.a.b.setSelection(this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.6
 * JD-Core Version:    0.7.0.1
 */