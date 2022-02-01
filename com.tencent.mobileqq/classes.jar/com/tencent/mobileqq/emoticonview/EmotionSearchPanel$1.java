package com.tencent.mobileqq.emoticonview;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import bdla;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.StringUtil;

class EmotionSearchPanel$1
  implements TextView.OnEditorActionListener
{
  EmotionSearchPanel$1(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 3)
    {
      if (!StringUtil.isEmpty(this.this$0.emotionInput.getText().toString()))
      {
        bdla.b(this.this$0.app, "dc00898", "", "", "0X800AE28", "0X800AE28", 0, 0, "2", "", this.this$0.emotionInput.getText().toString(), "");
        EmotionSearchPanel.access$002(this.this$0, true);
        ((EmoticonPanelHotPicSearchHelper)this.this$0.chatPie.getEmoPanel().getEmoController().getHelper(7)).prepareSearch();
      }
      bool = true;
      EmotionSearchPanel.access$100(this.this$0);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.1
 * JD-Core Version:    0.7.0.1
 */