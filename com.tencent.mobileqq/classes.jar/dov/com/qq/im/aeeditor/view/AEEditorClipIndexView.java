package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import bllm;

public class AEEditorClipIndexView
  extends View
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Paint b;
  
  public AEEditorClipIndexView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorClipIndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorClipIndexView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.b = new Paint();
    this.jdField_a_of_type_Int = 1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = Math.min(getWidth(), getHeight()) / 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167192));
    paramCanvas.drawCircle(i, i, i, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165215));
    int j = bllm.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
    paramCanvas.drawCircle(i, i, i - j, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setTextSize(bllm.a(this.jdField_a_of_type_AndroidContentContext, 17.0F));
    this.b.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167192));
    this.b.setTextAlign(Paint.Align.CENTER);
    Paint.FontMetrics localFontMetrics = this.b.getFontMetrics();
    float f1 = (localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
    float f2 = localFontMetrics.bottom;
    float f3 = getHeight() / 2.0F;
    paramCanvas.drawText(this.jdField_a_of_type_Int + "", getWidth() / 2, f1 - f2 + f3, this.b);
  }
  
  public void setIndex(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorClipIndexView
 * JD-Core Version:    0.7.0.1
 */