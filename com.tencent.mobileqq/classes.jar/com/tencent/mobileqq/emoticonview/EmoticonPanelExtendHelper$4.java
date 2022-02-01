package com.tencent.mobileqq.emoticonview;

import android.text.Editable;
import android.text.TextWatcher;

class EmoticonPanelExtendHelper$4
  implements TextWatcher
{
  EmoticonPanelExtendHelper$4(EmoticonPanelExtendHelper paramEmoticonPanelExtendHelper) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.this$0.updateDeleteBtnVisibility(paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.4
 * JD-Core Version:    0.7.0.1
 */