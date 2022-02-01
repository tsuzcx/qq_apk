package dov.com.qq.im.capture.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bmvs;

public class EditTextPreView
  extends ImageView
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bmvs jdField_a_of_type_Bmvs;
  private DynamicTextItem jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
  
  public EditTextPreView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public EditTextPreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public EditTextPreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setScaleType(ImageView.ScaleType.CENTER);
    setClickable(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(paramCanvas.getWidth() / 2, paramCanvas.getHeight() / 2);
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isEnabled()) && (isClickable())) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    do
    {
      return super.onTouchEvent(paramMotionEvent);
      return true;
    } while ((this.jdField_a_of_type_Bmvs == null) || (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null));
    int i = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramMotionEvent, getWidth(), getHeight(), null, null);
    if (i > -1)
    {
      setText(i, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(i));
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(i, true);
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(i, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(i));
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(i);
    }
    this.jdField_a_of_type_Bmvs.a(this, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem, i);
    return true;
  }
  
  @Deprecated
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    throw new UnsupportedOperationException("unSupport normal click listener, use EditTextPreView.OnClickListener instead");
  }
  
  public void setOnClickListener(@Nullable bmvs parambmvs)
  {
    this.jdField_a_of_type_Bmvs = parambmvs;
  }
  
  public void setPreViewDrawer(DynamicTextItem paramDynamicTextItem)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
    invalidate();
  }
  
  public void setText(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (!paramString.equals(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt))))
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt, paramString);
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(false);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.text.EditTextPreView
 * JD-Core Version:    0.7.0.1
 */