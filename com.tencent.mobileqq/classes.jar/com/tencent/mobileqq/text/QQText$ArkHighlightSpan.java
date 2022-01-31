package com.tencent.mobileqq.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.ArkHighLightClickCallback;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.qphone.base.util.QLog;

public class QQText$ArkHighlightSpan
  extends ClickableSpan
{
  public int a;
  public TextItemBuilder.ArkHighLightClickCallback a;
  
  public QQText$ArkHighlightSpan(int paramInt, TextItemBuilder.ArkHighLightClickCallback paramArkHighLightClickCallback)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$ArkHighLightClickCallback = paramArkHighLightClickCallback;
  }
  
  public static void a(View paramView, TextItemBuilder.ArkHighLightClickCallback paramArkHighLightClickCallback)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof String)) {
      QQText.a((String)localObject);
    }
    if (BubbleContextMenu.a) {
      if (QLog.isColorLevel()) {
        QLog.e("ArkHighlightSpan", 2, "ArkHighlightSpan onCLick is invoked by LongClick misstake");
      }
    }
    do
    {
      return;
      if (paramArkHighLightClickCallback != null) {
        paramArkHighLightClickCallback.a();
      }
    } while (!(paramView instanceof ETTextView));
    ((ETTextView)paramView).c = true;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$ArkHighLightClickCallback != null)
    {
      if (ArkAiAppCenter.l) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$ArkHighLightClickCallback.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$ArkHighLightClickCallback);
      }
    }
    else {
      return;
    }
    a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$ArkHighLightClickCallback);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.ArkHighlightSpan
 * JD-Core Version:    0.7.0.1
 */