package com.tencent.mobileqq.emoticonview.relateemo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class RelatedEmotionPanel$2
  implements DialogInterface.OnKeyListener
{
  RelatedEmotionPanel$2(RelatedEmotionPanel paramRelatedEmotionPanel, RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.val$slideBottomPanel.hidePanel(4);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel.2
 * JD-Core Version:    0.7.0.1
 */