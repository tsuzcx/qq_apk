package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageView;
import blpy;

public class ClipThumbnailImageView
  extends ImageView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  
  public ClipThumbnailImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ClipThumbnailImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ClipThumbnailImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getResources().getColor(2131165215));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      int i = getWidth();
      int j = getHeight();
      int k = blpy.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      paramCanvas.drawRect(0.0F, 0.0F, i, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(i - k, 0.0F, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, j - k, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, 0.0F, k, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setIsSelected(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.ClipThumbnailImageView
 * JD-Core Version:    0.7.0.1
 */