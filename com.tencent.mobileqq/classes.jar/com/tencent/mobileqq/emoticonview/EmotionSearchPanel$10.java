package com.tencent.mobileqq.emoticonview;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

class EmotionSearchPanel$10
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EmotionSearchPanel$10(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.isDestory) {
      return;
    }
    Object localObject = new Rect();
    this.this$0.decorView.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).bottom - ((Rect)localObject).top;
    int j = this.this$0.decorView.getHeight();
    double d1 = i;
    double d2 = j;
    Double.isNaN(d1);
    Double.isNaN(d2);
    boolean bool;
    if (d1 / d2 < 0.8D) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("visible");
      localStringBuilder.append(bool);
      localStringBuilder.append(" isVisiableForLast=");
      localStringBuilder.append(this.this$0.isVisiableForLast);
      localStringBuilder.append(" displayHight=");
      localStringBuilder.append(i);
      localStringBuilder.append(" hight=");
      localStringBuilder.append(j);
      QLog.d("EmotionSearchPanel", 2, localStringBuilder.toString());
    }
    if (bool != this.this$0.isVisiableForLast)
    {
      if (bool)
      {
        EmotionSearchPanel.keyboardHeight = j - ((Rect)localObject).bottom;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("keyboardHeight=");
          ((StringBuilder)localObject).append(EmotionSearchPanel.keyboardHeight);
          QLog.d("EmotionSearchPanel", 2, ((StringBuilder)localObject).toString());
        }
        EmotionSearchPanel.access$800(this.this$0, EmotionSearchPanel.keyboardHeight);
        this.this$0.setEmotionStatus(2);
        this.this$0.mask.setAlpha(0.71F);
      }
      else
      {
        if (this.this$0.emotionPanelState == 2) {
          ((IEmosmService)QRoute.api(IEmosmService.class)).showEmoticonPanel(this.this$0.aioContext, 12);
        }
        this.this$0.startExitAinm();
        if (!StringUtil.isEmpty(this.this$0.emotionInput.getText().toString())) {
          EmoticonUtils.report("0X800AE25", 0);
        }
      }
      this.this$0.isVisiableForLast = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.10
 * JD-Core Version:    0.7.0.1
 */