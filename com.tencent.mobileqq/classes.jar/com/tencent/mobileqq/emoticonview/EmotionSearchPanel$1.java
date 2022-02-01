package com.tencent.mobileqq.emoticonview;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;

class EmotionSearchPanel$1
  implements TextView.OnEditorActionListener
{
  EmotionSearchPanel$1(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      if (!StringUtil.a(this.this$0.emotionInput.getText().toString()))
      {
        ReportController.b(this.this$0.app, "dc00898", "", "", "0X800AE28", "0X800AE28", 0, 0, "2", "", this.this$0.emotionInput.getText().toString(), "");
        EmotionSearchPanel.access$002(this.this$0, true);
        paramTextView = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.this$0.interactionListener);
        if (paramTextView != null) {
          ((EmoticonPanelHotPicSearchHelper)paramTextView.getEmoController().getHelper(7)).prepareSearch();
        }
      }
      EmotionSearchPanel.access$100(this.this$0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.1
 * JD-Core Version:    0.7.0.1
 */