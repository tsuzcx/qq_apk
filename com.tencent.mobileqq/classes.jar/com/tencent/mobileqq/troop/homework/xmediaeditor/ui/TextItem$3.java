package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextItem$3
  implements TextView.OnEditorActionListener
{
  TextItem$3(TextItem paramTextItem, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 4) || (paramInt == 6) || ((paramKeyEvent != null) && (66 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0)))
    {
      String str = this.a.b.getEditableText().toString();
      int i = this.a.b.getSelectionStart();
      str = str.substring(0, i);
      str = this.b.a(str);
      if (!TextUtils.isEmpty(str))
      {
        Editable localEditable = this.a.b.getEditableText();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\n");
        localStringBuilder.append(str);
        localEditable.replace(i, i, localStringBuilder.toString());
        this.a.b.setSelection(i + str.length() + 1);
        break label170;
      }
    }
    bool = false;
    label170:
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.3
 * JD-Core Version:    0.7.0.1
 */