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
    ImageButton localImageButton;
    if (SystemAndEmojiUniversalPanel.access$600(this.this$0) != null)
    {
      localImageButton = SystemAndEmojiUniversalPanel.access$600(this.this$0);
      if (TextUtils.isEmpty(paramEditable)) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      localImageButton.setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.3
 * JD-Core Version:    0.7.0.1
 */