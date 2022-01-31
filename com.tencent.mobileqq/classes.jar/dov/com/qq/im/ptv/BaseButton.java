package dov.com.qq.im.ptv;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import bnsm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class BaseButton
  extends View
{
  protected int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected Paint a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private HashMap<Integer, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  protected Paint b;
  private boolean b;
  protected int c;
  private Paint c;
  protected int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public BaseButton(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = bnsm.a(10.0F);
    a();
  }
  
  public BaseButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = bnsm.a(10.0F);
    a();
  }
  
  @TargetApi(21)
  private Drawable a()
  {
    return getContext().getDrawable(this.g);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
    int j = this.e / 2;
    int k = this.jdField_c_of_type_Int;
    int m = this.jdField_b_of_type_Int / 2;
    paramCanvas.drawCircle(this.e / 2, this.f / 2, j - k + m, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.d);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_b_of_type_Int, 0.0F, 0.0F, this.jdField_a_of_type_Int);
    }
    int j = this.e / 2;
    int k = this.jdField_c_of_type_Int;
    paramCanvas.drawCircle(this.e / 2, this.f / 2, j - k, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.top = ((this.f - this.i) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.left = ((this.e - this.h) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + this.i);
    this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_AndroidGraphicsRect.left + this.h);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    while (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_c_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
  }
  
  protected void a()
  {
    setLayerType(1, null);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (a())
    {
      int[] arrayOfInt = getDrawableState();
      if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt)) {
        setAlpha(0.4901961F);
      }
    }
    else
    {
      return;
    }
    setAlpha(1.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.e = getWidth();
    this.f = getHeight();
    if (this.e <= 0) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      a(paramCanvas);
    }
    b(paramCanvas);
    c(paramCanvas);
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setImageHeight(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.g == paramInt) {
      return;
    }
    this.g = paramInt;
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
    }
    Bitmap localBitmap;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.g));
      if (localBitmap == null) {
        break label69;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    }
    for (;;)
    {
      invalidate();
      return;
      try
      {
        label69:
        localBitmap = BitmapFactory.decodeResource(getResources(), this.g);
        if (localBitmap != null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.g), localBitmap);
          this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("BaseButton", 2, "setImageResource error Id=" + this.g);
      }
    }
  }
  
  public void setImageWidth(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setShadowDraw(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setShadowStrokeMaxWidth(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setShadowStrokeWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setStateful(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.BaseButton
 * JD-Core Version:    0.7.0.1
 */