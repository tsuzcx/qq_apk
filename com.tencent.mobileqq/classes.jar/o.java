import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.view.animation.LinearInterpolator;
import com.etrump.mixlayout.ETFont;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public abstract class o
{
  public ValueAnimator a;
  public Bitmap a;
  protected Canvas a;
  public ETFont a;
  public int e;
  public int[] i = { -1, -1 };
  
  public o()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  }
  
  public abstract int a(int paramInt1, int paramInt2, gj paramgj);
  
  protected String a()
  {
    if (l.a) {
      return getClass().getSimpleName();
    }
    return "BaseLayout";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.i[0] });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.i[0] * this.i[1]);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      n.a("FounderBaseLayout", "StopAnimation......");
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      } else if ((paramInt1 > this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) || (paramInt2 > this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) || ((paramInt1 << 1 < this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) && (paramInt2 << 1 < this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()))) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("FounderBaseLayout", 2, "FounderColorLayout#createNewWordBitmapIfNeed w=" + paramInt1 + " h=" + paramInt2, localOutOfMemoryError);
      return false;
    }
    return true;
  }
  
  public abstract boolean a(Canvas paramCanvas);
  
  public abstract int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont);
  
  public abstract void b();
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null) {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public void e()
  {
    n.a("FounderBaseLayout", "release....");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) && (this.e > 0))
    {
      n.a("FounderBaseLayout", "PauseAnimation...... animInfo:" + Arrays.toString(this.i) + "  frameIndex:" + this.e);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (this.i[0] <= 0) || (this.i[1] <= 0)) {}
    while ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) || (this.e <= 0) || (this.e >= this.i[0])) {
      return;
    }
    n.a("FounderBaseLayout", "RestartAnimation...... animInfo:" + Arrays.toString(this.i) + "  frameIndex:" + this.e);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { this.e, this.i[0] });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((this.i[0] - this.e) * this.i[1]);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = true;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      a();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    while (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { this.i[0] });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.i[0] * this.i[1]);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void i()
  {
    a(true);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.e = 0;
    this.i[0] = -1;
    this.i[1] = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     o
 * JD-Core Version:    0.7.0.1
 */