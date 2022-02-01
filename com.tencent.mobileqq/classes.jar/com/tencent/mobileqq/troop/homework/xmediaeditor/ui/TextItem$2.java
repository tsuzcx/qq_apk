package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class TextItem$2
  implements View.OnKeyListener
{
  TextItem$2(TextItem paramTextItem, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.getSelectionStart() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.a.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.2
 * JD-Core Version:    0.7.0.1
 */