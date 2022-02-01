package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.qphone.base.util.QLog;

class TextItem$4
  implements View.OnFocusChangeListener
{
  TextItem$4(TextItem paramTextItem, TextInfo paramTextInfo, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = new StringBuilder();
    paramView.append("mData.position:");
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.c);
    paramView.append(", text:");
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString);
    paramView.append(",onFocusChange:");
    paramView.append(paramBoolean);
    QLog.i("xmediaEditor", 1, paramView.toString());
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setCursorVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.a.c(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setCursorVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.a.d(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setFocusable(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setFocusableInTouchMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.4
 * JD-Core Version:    0.7.0.1
 */