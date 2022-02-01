package com.tencent.mobileqq.flashshow.viewmodel.barrage.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;

public class FSBlackStrokeTextView
  extends RFWAsyncRichTextView
{
  private TextView a = null;
  
  public FSBlackStrokeTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSBlackStrokeTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSBlackStrokeTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new TextView(getContext(), paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    TextPaint localTextPaint = this.a.getPaint();
    localTextPaint.setStrokeWidth(2.0F);
    localTextPaint.setStyle(Paint.Style.STROKE);
    this.a.setTextColor(-16777216);
    this.a.setGravity(getGravity());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    CharSequence localCharSequence = this.a.getText();
    if ((localCharSequence == null) || (!localCharSequence.equals(getText())))
    {
      this.a.setText(getText());
      postInvalidate();
    }
    super.onMeasure(paramInt1, paramInt2);
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
    this.a.setLayoutParams(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.widgets.FSBlackStrokeTextView
 * JD-Core Version:    0.7.0.1
 */