package com.tencent.mobileqq.emoticonview;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageButton;

class SystemAndEmojiUniversalPanel$3
  implements TextWatcher
{
  SystemAndEmojiUniversalPanel$3(SystemAndEmojiUniversalPanel paramSystemAndEmojiUniversalPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (SystemAndEmojiUniversalPanel.access$600(this.this$0) != null) {
      SystemAndEmojiUniversalPanel.access$600(this.this$0).setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.3
 * JD-Core Version:    0.7.0.1
 */