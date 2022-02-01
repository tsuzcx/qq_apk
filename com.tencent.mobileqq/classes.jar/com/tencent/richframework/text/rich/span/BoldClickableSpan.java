package com.tencent.richframework.text.rich.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.lang.ref.WeakReference;

public class BoldClickableSpan
  extends ClickableSpan
{
  private Object a;
  private WeakReference<BoldClickableSpan.OnClickBoldTextListener> b;
  private int c;
  private boolean d;
  
  public BoldClickableSpan(BoldClickableSpan.OnClickBoldTextListener paramOnClickBoldTextListener, int paramInt, boolean paramBoolean)
  {
    this.b = new WeakReference(paramOnClickBoldTextListener);
    this.c = paramInt;
    this.d = paramBoolean;
  }
  
  public BoldClickableSpan(BoldClickableSpan.OnClickBoldTextListener paramOnClickBoldTextListener, int paramInt, boolean paramBoolean, Object paramObject)
  {
    this.b = new WeakReference(paramOnClickBoldTextListener);
    this.c = paramInt;
    this.d = paramBoolean;
    this.a = paramObject;
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = this.b;
    if (paramView == null) {
      paramView = null;
    } else {
      paramView = (BoldClickableSpan.OnClickBoldTextListener)paramView.get();
    }
    if (paramView != null) {
      paramView.a(this.a);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.c != 0) {
      paramTextPaint.setColor(QCircleSkinHelper.getInstance().getColor(this.c));
    }
    paramTextPaint.setUnderlineText(false);
    if (this.d) {
      paramTextPaint.setFakeBoldText(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.span.BoldClickableSpan
 * JD-Core Version:    0.7.0.1
 */