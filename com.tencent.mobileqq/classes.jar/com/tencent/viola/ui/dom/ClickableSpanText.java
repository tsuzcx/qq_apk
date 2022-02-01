package com.tencent.viola.ui.dom;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.viola.ui.view.VTextView;
import java.util.HashMap;
import java.util.Map;

public class ClickableSpanText
  extends ClickableSpan
{
  public SpanText mSpanText;
  
  ClickableSpanText(SpanText paramSpanText)
  {
    this.mSpanText = paramSpanText;
  }
  
  public void onClick(View paramView)
  {
    if (this.mSpanText != null)
    {
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("index", Integer.valueOf(this.mSpanText.index));
      localHashMap1.put("click", localHashMap2);
      if ((paramView instanceof VTextView)) {
        paramView.setTag(localHashMap1);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.ClickableSpanText
 * JD-Core Version:    0.7.0.1
 */