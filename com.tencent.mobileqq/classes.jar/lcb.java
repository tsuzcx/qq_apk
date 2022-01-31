import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class lcb
  extends BitmapDrawable
{
  protected float a;
  protected int a;
  private Matrix a = new Matrix();
  protected float[] a;
  protected float b;
  protected int b;
  protected float c;
  protected float d;
  protected float e;
  protected float f;
  protected float g;
  protected float h;
  protected float i;
  protected float j;
  protected float k;
  protected float l;
  protected float m;
  protected float n;
  protected float o;
  protected float p;
  private float q;
  private float r;
  private float s;
  private float t = 1.0F;
  private float u;
  private float v;
  private float w;
  private float x;
  
  public lcb(BitmapDrawable paramBitmapDrawable)
  {
    super(paramBitmapDrawable.getBitmap());
  }
  
  private void a()
  {
    this.a.reset();
    this.a.preRotate(this.s, this.q, this.r);
    this.a.preScale(this.t, this.t, this.q, this.r);
  }
  
  public void a(float paramFloat)
  {
    if (this.s != paramFloat)
    {
      this.s = paramFloat;
      a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.u + paramFloat1, this.v + paramFloat2, this.w, this.x);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Rect localRect1 = getBounds();
    Rect localRect2 = new Rect();
    this.u = paramFloat1;
    this.v = paramFloat2;
    this.w = paramFloat3;
    this.x = paramFloat4;
    localRect2.left = ((int)this.u);
    localRect2.top = ((int)this.v);
    localRect2.right = ((int)(this.u + this.w));
    localRect2.bottom = ((int)(this.v + this.x));
    if (!localRect1.equals(localRect2)) {
      setBounds(localRect2);
    }
  }
  
  public void b(float paramFloat)
  {
    if (this.t != paramFloat)
    {
      this.t = paramFloat;
      a();
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setColorFilter(Color.argb(255, (int)(paramFloat1 * 255.0F), (int)(paramFloat2 * 255.0F), (int)(paramFloat3 * 255.0F)), PorterDuff.Mode.SRC_ATOP);
    setAlpha((int)(paramFloat4 * 255.0F));
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.a);
    super.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 1;
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = (paramInt1 + paramInt3) / 2;
    float f2 = (paramInt2 + paramInt4) / 2;
    paramInt1 = 0;
    if (this.q != f1)
    {
      this.q = f1;
      paramInt1 = 1;
    }
    if (this.r != f2)
    {
      this.r = f2;
      paramInt1 = i1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcb
 * JD-Core Version:    0.7.0.1
 */