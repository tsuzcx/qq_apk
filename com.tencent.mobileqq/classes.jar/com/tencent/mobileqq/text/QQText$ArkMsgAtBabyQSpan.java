package com.tencent.mobileqq.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.ArkMsgAtBabyQClickCallback;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.qphone.base.util.QLog;

public class QQText$ArkMsgAtBabyQSpan
  extends ClickableSpan
{
  public int a;
  public TextItemBuilder.ArkMsgAtBabyQClickCallback a;
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof String)) {
      QQText.a((String)paramView);
    }
    if (BubbleContextMenu.a)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkMsgAtBabyQSpan", 2, "ArkMsgAtBabyQSpan onCLick is invoked by LongClick misstake");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$ArkMsgAtBabyQClickCallback.a();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.ArkMsgAtBabyQSpan
 * JD-Core Version:    0.7.0.1
 */