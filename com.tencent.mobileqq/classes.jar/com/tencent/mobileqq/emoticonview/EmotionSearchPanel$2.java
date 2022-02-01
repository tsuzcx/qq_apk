package com.tencent.mobileqq.emoticonview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.StringUtil;

class EmotionSearchPanel$2
  implements TextWatcher
{
  EmotionSearchPanel$2(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!StringUtil.a(paramEditable.toString())) {
      this.this$0.searchCleanImg.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.2
 * JD-Core Version:    0.7.0.1
 */