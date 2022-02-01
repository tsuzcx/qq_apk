package com.tencent.mobileqq.studymode;

import android.widget.CompoundButton;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;

class ModeChoiceViewContainer$4
  implements Runnable
{
  ModeChoiceViewContainer$4(ModeChoiceViewContainer paramModeChoiceViewContainer, boolean paramBoolean1, int paramInt, CompoundButton paramCompoundButton, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!((SimpleUIHandler)ModeChoiceViewContainer.c(this.this$0).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(this.a, this.b, true))
    {
      this.this$0.a(2131916388, 0);
      this.this$0.a(this.c, this.d ^ true);
      return;
    }
    ModeChoiceViewContainer localModeChoiceViewContainer = this.this$0;
    ModeChoiceViewContainer.a(localModeChoiceViewContainer, true, ModeChoiceViewContainer.b(localModeChoiceViewContainer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.4
 * JD-Core Version:    0.7.0.1
 */