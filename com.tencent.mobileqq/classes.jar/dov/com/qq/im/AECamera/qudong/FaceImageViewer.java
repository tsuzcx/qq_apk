package dov.com.qq.im.AECamera.qudong;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import bhca;
import com.tencent.ttpic.videoshelf.ImagePositonManager;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import java.lang.reflect.Field;

public class FaceImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = FaceImageViewer.class.getSimpleName();
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  private bhca jdField_a_of_type_Bhca;
  private NodeItem jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem = new NodeItem();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private final int jdField_e_of_type_Int = 100;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private final int jdField_f_of_type_Int = 300;
  private boolean jdField_f_of_type_Boolean = true;
  private float jdField_g_of_type_Float;
  private final int jdField_g_of_type_Int = 5;
  private boolean jdField_g_of_type_Boolean;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int;
  private float jdField_i_of_type_Float = 0.0F;
  private int jdField_i_of_type_Int;
  private float jdField_j_of_type_Float;
  private int jdField_j_of_type_Int;
  
  public FaceImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FaceImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    setOnClickListener(this);
    c();
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)getResources().getDrawable(2130837590));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131302234);
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    double d1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), d1));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    ImagePositonManager.setShowPosition(getDrawable(), this.jdField_b_of_type_AndroidGraphicsMatrix, getWidth(), getHeight());
    this.jdField_b_of_type_AndroidGraphicsMatrix.postRotate(paramFloat4, getWidth() / 2, getHeight() / 2);
    setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
    e();
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.draw(paramCanvas);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    switch (this.jdField_d_of_type_Int)
    {
    }
    float f1;
    float f2;
    do
    {
      return;
      f1 = this.jdField_c_of_type_Float;
      f2 = this.jdField_a_of_type_Float;
      f3 = this.jdField_d_of_type_Float;
      f4 = this.jdField_b_of_type_Float;
      ImagePositonManager.setMovePosition(getDrawable(), this.jdField_b_of_type_AndroidGraphicsMatrix, f1 - f2, f3 - f4, getWidth(), getHeight());
      setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
      e();
      this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
      this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
      return;
      f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
      f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
      f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f4 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      if (this.jdField_j_of_type_Float == 0.0F)
      {
        this.jdField_j_of_type_Float = f4;
        return;
      }
    } while (Math.abs(f4 - this.jdField_j_of_type_Float) < 1.0F);
    float f3 = f4 / this.jdField_j_of_type_Float;
    this.jdField_j_of_type_Float = f4;
    float f4 = a(paramMotionEvent);
    float f5 = this.jdField_i_of_type_Float;
    this.jdField_i_of_type_Float = a(paramMotionEvent);
    a(f3, f1, f2, f4 - f5);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.matrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeGroupID;
  }
  
  public NodeItem a()
  {
    return this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem;
  }
  
  public void a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    draw(new Canvas(localBitmap));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      localBitmap.recycle();
    }
    if (this.jdField_a_of_type_Bhca != null) {
      this.jdField_a_of_type_Bhca.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
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
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(paramInt1 / 2 - m / 2, paramInt2 / 2 - k / 2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f1, paramInt1 / 2, paramInt2 / 2);
      setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
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
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
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
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    b();
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
        return;
      }
      catch (Throwable paramCanvas) {}
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.matrix);
      setImageMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    int m = paramMotionEvent.getPointerCount();
    int k = 0;
    while (k < m)
    {
      this.jdField_c_of_type_Float += paramMotionEvent.getX();
      this.jdField_d_of_type_Float += paramMotionEvent.getY();
      k += 1;
    }
    this.jdField_c_of_type_Float /= m;
    this.jdField_d_of_type_Float /= m;
    if (m != this.jdField_i_of_type_Int)
    {
      this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
      this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
      this.jdField_i_of_type_Int = m;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_f_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_h_of_type_Int = 0;
      this.jdField_j_of_type_Float = 0.0F;
      this.jdField_d_of_type_Int = 1;
      return true;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_i_of_type_Float = a(paramMotionEvent);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Int = 2;
      return true;
      this.jdField_d_of_type_Int = 0;
      return true;
      a(paramMotionEvent);
      this.jdField_h_of_type_Int += 1;
      return true;
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (this.jdField_h_of_type_Int > 5) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Long = (l1 + 300L);
      }
      for (;;)
      {
        this.jdField_g_of_type_Float = paramMotionEvent.getRawX();
        this.jdField_h_of_type_Float = paramMotionEvent.getRawY();
        this.jdField_i_of_type_Int = 0;
        if ((Math.abs(this.jdField_g_of_type_Float - this.jdField_e_of_type_Float) <= 10.0F) && (Math.abs(this.jdField_f_of_type_Float - this.jdField_h_of_type_Float) <= 10.0F)) {
          break label406;
        }
        if (this.jdField_a_of_type_Bhca == null) {
          break;
        }
        this.jdField_a_of_type_Bhca.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
        return true;
        if (l1 <= this.jdField_b_of_type_Long) {
          this.jdField_e_of_type_Boolean = false;
        }
      }
      label406:
      if ((this.jdField_e_of_type_Boolean) && (l1 - l2 < 100L)) {
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
    return true;
  }
  
  public void setCenterViewWidth(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
  }
  
  public void setImageSelected(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_d_of_type_Boolean)
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
    if (this.jdField_a_of_type_Bhca != null) {
      this.jdField_a_of_type_Bhca.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
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
  }
  
  public void setOnSaveScrollInfoListener(bhca parambhca)
  {
    this.jdField_a_of_type_Bhca = parambhca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.qudong.FaceImageViewer
 * JD-Core Version:    0.7.0.1
 */