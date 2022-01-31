package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import blec;
import blen;
import blfh;
import com.tencent.ttpic.videoshelf.ImagePositonManager;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import java.lang.reflect.Field;

public class ScaleMoveImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = ScaleMoveImageViewer.class.getSimpleName();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  private blec jdField_a_of_type_Blec;
  private NodeItem jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem = new NodeItem();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private float jdField_b_of_type_Float;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  
  public ScaleMoveImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleMoveImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    setOnClickListener(this);
    c();
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)getResources().getDrawable(2130837599));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131367989);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837602);
  }
  
  private float a()
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return Math.min(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[4]);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = a();
    if (((f1 > 4.0F) && (paramFloat1 < 1.0F)) || ((f1 < 0.2F) && (paramFloat1 > 1.0F)) || ((paramFloat1 < 4.0F) && (paramFloat1 > 0.2F))) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    }
    if (a() < this.jdField_a_of_type_Float) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_c_of_type_AndroidGraphicsMatrix);
    }
    ImagePositonManager.setShowPosition(getDrawable(), this.jdField_b_of_type_AndroidGraphicsMatrix, getWidth(), getHeight());
    setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
    e();
    this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.draw(paramCanvas);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, getHeight() / 2, getWidth(), getHeight());
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.matrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeID;
  }
  
  public NodeItem a()
  {
    return this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.matrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    int k = (int)((int)(0 - this.jdField_a_of_type_ArrayOfFloat[2]) / this.jdField_a_of_type_ArrayOfFloat[0]);
    int m = (int)((int)(0 - this.jdField_a_of_type_ArrayOfFloat[5]) / this.jdField_a_of_type_ArrayOfFloat[4]);
    int n = (int)(getWidth() / this.jdField_a_of_type_ArrayOfFloat[0]);
    int i1 = (int)(getHeight() / this.jdField_a_of_type_ArrayOfFloat[4]);
    if ((n <= 0) || (i1 <= 0) || (k < 0) || (m < 0))
    {
      if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap != null) && (!this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.isRecycled())) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.recycle();
      }
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap, 0, 0, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getWidth() - 1, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getHeight() - 1);
      }
      if (this.jdField_a_of_type_Blec != null) {
        this.jdField_a_of_type_Blec.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap != null) && (!this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.isRecycled()) && (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.recycle();
      }
      if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) && (!this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.isRecycled())) {}
      try
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap, k, m, n, i1);
        if (this.jdField_a_of_type_Blec == null) {
          continue;
        }
        this.jdField_a_of_type_Blec.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.once = false;
    int n = 720;
    int i1 = 1280;
    Drawable localDrawable = getDrawable();
    int m;
    int k;
    if (localDrawable != null)
    {
      m = localDrawable.getIntrinsicWidth();
      k = localDrawable.getIntrinsicHeight();
    }
    for (;;)
    {
      float f1 = Math.max(paramInt1 * 1.0F / m, paramInt2 * 1.0F / k);
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(paramInt1 / 2 - m / 2, paramInt2 / 2 - k / 2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f1, paramInt1 / 2, paramInt2 / 2);
      setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
      this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
      e();
      return;
      k = i1;
      m = n;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem != null)
      {
        k = i1;
        m = n;
        if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null)
        {
          m = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getWidth();
          k = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getHeight();
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeGroupID;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) && (!this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.isRecycled())) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.recycle();
    }
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap != null) && (!this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.isRecycled())) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.recycle();
    }
    setImageBitmap(null);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    b();
    blen.a().h();
    blfh.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeID);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.once) {
      a(getWidth(), getHeight());
    }
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        a(paramCanvas);
        b(paramCanvas);
        return;
      }
      catch (Throwable paramCanvas) {}
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.matrix);
      setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    int m = paramMotionEvent.getPointerCount();
    int k = 0;
    while (k < m)
    {
      this.jdField_d_of_type_Float += paramMotionEvent.getX();
      this.jdField_e_of_type_Float += paramMotionEvent.getY();
      k += 1;
    }
    this.jdField_d_of_type_Float /= m;
    this.jdField_e_of_type_Float /= m;
    if (m != this.jdField_a_of_type_Int)
    {
      this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
      this.jdField_c_of_type_Float = this.jdField_e_of_type_Float;
      this.jdField_a_of_type_Int = m;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.f = paramMotionEvent.getRawX();
      this.g = paramMotionEvent.getRawY();
      this.jdField_d_of_type_Boolean = true;
      this.j = 0.0F;
      return true;
      this.jdField_d_of_type_Boolean = false;
      return true;
      float f1 = this.jdField_d_of_type_Float;
      float f2 = this.jdField_b_of_type_Float;
      float f3 = this.jdField_e_of_type_Float;
      float f4 = this.jdField_c_of_type_Float;
      ImagePositonManager.setMovePosition(getDrawable(), this.jdField_b_of_type_AndroidGraphicsMatrix, f1 - f2, f3 - f4, getWidth(), getHeight());
      setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
      e();
      this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
      this.jdField_c_of_type_Float = this.jdField_e_of_type_Float;
      if (paramMotionEvent.getPointerCount() == 2)
      {
        f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
        if (this.j == 0.0F)
        {
          this.j = f3;
          return true;
        }
        if (Math.abs(f3 - this.j) >= 10.0F)
        {
          f4 = f3 / this.j;
          this.j = f3;
          a(f4, f1, f2);
          return true;
          this.h = paramMotionEvent.getRawX();
          this.i = paramMotionEvent.getRawY();
          this.jdField_a_of_type_Int = 0;
          if ((Math.abs(this.h - this.f) > 10.0F) || (Math.abs(this.g - this.i) > 10.0F))
          {
            if (this.jdField_a_of_type_Blec != null)
            {
              this.jdField_a_of_type_Blec.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
              return true;
            }
          }
          else if (this.jdField_d_of_type_Boolean) {
            try
            {
              paramMotionEvent = View.class.getDeclaredField("mListenerInfo");
              paramMotionEvent.setAccessible(true);
              paramMotionEvent = paramMotionEvent.get(paramView);
              Field localField = paramMotionEvent.getClass().getDeclaredField("mOnClickListener");
              localField.setAccessible(true);
              paramMotionEvent = localField.get(paramMotionEvent);
              if ((paramMotionEvent != null) && ((paramMotionEvent instanceof View.OnClickListener)))
              {
                ((View.OnClickListener)paramMotionEvent).onClick(paramView);
                return true;
              }
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
            }
          }
        }
      }
    }
    return true;
  }
  
  public void setImageSelected(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean)
    {
      setOnTouchListener(this);
      return;
    }
    setOnTouchListener(null);
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = paramBitmap;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.once = true;
    if (this.jdField_a_of_type_Blec != null) {
      this.jdField_a_of_type_Blec.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
    }
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeID = paramNodeItem.nodeID;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeGroupID = paramNodeItem.nodeGroupID;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.once = paramNodeItem.once;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.matrix.set(paramNodeItem.matrix);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = paramNodeItem.bitmap;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect = paramNodeItem.maskRect;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.zIndex = paramNodeItem.zIndex;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.type = paramNodeItem.type;
  }
  
  public void setOnSaveScrollInfoListener(blec paramblec)
  {
    this.jdField_a_of_type_Blec = paramblec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.ScaleMoveImageViewer
 * JD-Core Version:    0.7.0.1
 */