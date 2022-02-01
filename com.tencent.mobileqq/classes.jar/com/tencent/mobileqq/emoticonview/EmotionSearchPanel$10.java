package com.tencent.mobileqq.emoticonview;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

class EmotionSearchPanel$10
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EmotionSearchPanel$10(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.isDestory) {}
    Object localObject;
    int j;
    boolean bool;
    do
    {
      return;
      localObject = new Rect();
      this.this$0.decorView.getWindowVisibleDisplayFrame((Rect)localObject);
      int i = ((Rect)localObject).bottom - ((Rect)localObject).top;
      j = this.this$0.decorView.getHeight();
      if (i / j >= 0.8D) {
        break;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "visible" + bool + " isVisiableForLast=" + this.this$0.isVisiableForLast + " displayHight=" + i + " hight=" + j);
      }
    } while (bool == this.this$0.isVisiableForLast);
    if (bool)
    {
      EmotionSearchPanel.keyboardHeight = j - ((Rect)localObject).bottom;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "keyboardHeight=" + EmotionSearchPanel.keyboardHeight);
      }
      EmotionSearchPanel.access$800(this.this$0, EmotionSearchPanel.keyboardHeight);
      this.this$0.setEmotionStatus(2);
      this.this$0.mask.setAlpha(0.71F);
    }
    for (;;)
    {
      this.this$0.isVisiableForLast = bool;
      return;
      bool = false;
      break;
      if (this.this$0.emotionPanelState == 2)
      {
        localObject = (AIOEmoticonPanelHelper)this.this$0.chatPie.a(104);
        if (localObject != null) {
          ((AIOEmoticonPanelHelper)localObject).showEmoticonPanel(12);
        }
      }
      this.this$0.startExitAinm();
      if (!StringUtil.a(this.this$0.emotionInput.getText().toString())) {
        EmoticonUtils.report("0X800AE25", 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.10
 * JD-Core Version:    0.7.0.1
 */