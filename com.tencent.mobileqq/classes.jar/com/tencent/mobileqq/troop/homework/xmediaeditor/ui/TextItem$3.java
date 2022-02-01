package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class TextItem$3
  implements TextView.OnEditorActionListener
{
  TextItem$3(TextItem paramTextItem, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) || (paramInt == 6) || ((paramKeyEvent != null) && (66 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0)))
    {
      paramTextView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.getEditableText().toString();
      paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.getSelectionStart();
      paramTextView = paramTextView.substring(0, paramInt);
      paramTextView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.a(paramTextView);
      if (!TextUtils.isEmpty(paramTextView))
      {
        paramKeyEvent = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.getEditableText();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\n");
        localStringBuilder.append(paramTextView);
        paramKeyEvent.replace(paramInt, paramInt, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setSelection(paramInt + paramTextView.length() + 1);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.3
 * JD-Core Version:    0.7.0.1
 */