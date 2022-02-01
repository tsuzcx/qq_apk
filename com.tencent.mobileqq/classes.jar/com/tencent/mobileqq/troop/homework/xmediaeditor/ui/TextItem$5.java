package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TextItem$5
  implements TextWatcher
{
  TextItem$5(TextItem paramTextItem, TextItem.TextViewHolder paramTextViewHolder, TextInfo paramTextInfo) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b() != 0)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
      i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.c();
      j -= i;
      int k = paramInt3 - paramInt2;
      if (k > j)
      {
        QQToast.a(TextItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem), "最多可以输入500个字", 1).a();
        paramInt2 = j + paramInt2;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.removeTextChangedListener(this);
        j = paramInt1 + paramInt2;
        localObject = paramCharSequence.subSequence(0, j);
        paramCharSequence = paramCharSequence.subSequence(paramInt1 + paramInt3, paramCharSequence.length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((CharSequence)localObject).toString());
        localStringBuilder.append(paramCharSequence.toString());
        paramCharSequence = localStringBuilder.toString();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setText(paramCharSequence);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.addTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setSelection(j);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(i, paramInt2 + i);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
        ((TextInfo)localObject).jdField_a_of_type_Int = j;
        ((TextInfo)localObject).a(paramCharSequence);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(i, i + k);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
        ((TextInfo)localObject).jdField_a_of_type_Int = (paramInt1 + k);
        ((TextInfo)localObject).a(paramCharSequence.toString());
      }
    }
    else
    {
      i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(i, i + paramInt3 - paramInt2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
      ((TextInfo)localObject).jdField_a_of_type_Int = (paramInt1 + paramInt3);
      ((TextInfo)localObject).a(paramCharSequence.toString());
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("onTextChanged, mData.position:");
    paramCharSequence.append(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.c);
    paramCharSequence.append(", text:");
    paramCharSequence.append(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString);
    paramCharSequence.append(",Listener:");
    paramCharSequence.append(toString());
    QLog.i("xmediaEditor", 1, paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.5
 * JD-Core Version:    0.7.0.1
 */