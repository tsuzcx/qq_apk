import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mou
  extends mot
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new mov(this.jdField_a_of_type_JavaLangString, this);
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas = new Canvas();
  Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(2);
  mos jdField_b_of_type_Mos;
  boolean jdField_b_of_type_Boolean = true;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  public mou(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.m = ((int)paramContext.getResources().getDimension(2131297662));
    this.l = (this.g - this.m * 2);
    this.i = (this.g / 6);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Mos.b);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Mos.jdField_a_of_type_Float);
    float f = -this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_Lgi.a, paramInt, f, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Mos.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    paramCanvas.drawText((String)this.jdField_a_of_type_Lgi.a, paramInt, f, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        paramCanvas.save();
        if (!d()) {
          break label138;
        }
        paramInt2 = -this.o;
        paramCanvas.translate(paramInt2, 0.0F);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
        paramCanvas.restore();
      }
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        paramInt2 = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        if (!e()) {
          break label150;
        }
      }
    }
    label138:
    label150:
    for (paramInt1 = -this.n;; paramInt1 = paramInt1 - g() >> 1)
    {
      paramCanvas.save();
      paramCanvas.translate(paramInt1, 0.0F);
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, 0.0F, paramInt2, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
      return;
      paramInt2 = paramInt1 - super.c() >> 1;
      break;
    }
  }
  
  private void c(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramInt2 = super.c();
    int i1 = super.d();
    a(paramCanvas, paramInt1 - paramInt2 >> 1);
    d(paramCanvas, paramInt1 - g() >> 1, i1);
  }
  
  private void d(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Mos.b);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Mos.jdField_a_of_type_Float);
    Paint.FontMetrics localFontMetrics = this.jdField_c_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f = paramInt2 - localFontMetrics.ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_Lgi.b, paramInt1, f, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Mos.jdField_a_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    paramCanvas.drawText((String)this.jdField_a_of_type_Lgi.b, paramInt1, f, this.jdField_c_of_type_AndroidGraphicsPaint);
  }
  
  private void e()
  {
    if ((d()) || (e()))
    {
      int i1 = e();
      int i2 = super.c() - this.l;
      if ((d()) && (i2 > this.o))
      {
        this.o += i1;
        if (i2 < this.n) {
          this.n = i2;
        }
      }
      i2 = g() - this.l;
      if ((e()) && (i2 > this.n))
      {
        this.n = (i1 + this.n);
        if (i2 < this.n) {
          this.n = i2;
        }
      }
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      a();
    }
  }
  
  public int a(long paramLong)
  {
    return 0;
  }
  
  public Bitmap a()
  {
    e();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      if ((d()) || (e()))
      {
        c();
        d();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = b();
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, c(), d());
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    if ((d()) || (e()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label76;
      }
      b(paramCanvas, paramInt1, paramInt2);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      lbj.c(this.jdField_a_of_type_JavaLangString, "onDraw film:|" + (l2 - l1));
      return;
      i1 = 0;
      break;
      label76:
      c(paramCanvas, paramInt1, paramInt2);
    }
  }
  
  public void a(lgi paramlgi)
  {
    super.a(paramlgi);
    if (this.jdField_a_of_type_Lgi != null) {}
    for (paramlgi = this.jdField_a_of_type_Lgi.b;; paramlgi = null)
    {
      paramlgi = (String)paramlgi;
      this.j = a(this.jdField_c_of_type_AndroidGraphicsPaint, paramlgi);
      int i1 = c();
      this.e = ((this.g - i1) / 2);
      if ((this.jdField_a_of_type_Lgi != null) && (this.jdField_a_of_type_Lgi.a()))
      {
        paramlgi = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramlgi, 2000L);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void b(Typeface paramTypeface, int paramInt, mos parammos)
  {
    if (paramTypeface != null) {
      this.jdField_c_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    this.jdField_b_of_type_Mos = parammos;
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(paramInt);
    if (this.jdField_a_of_type_Lgi != null) {}
    for (paramTypeface = this.jdField_a_of_type_Lgi.b;; paramTypeface = null)
    {
      paramTypeface = (String)paramTypeface;
      this.j = a(this.jdField_c_of_type_AndroidGraphicsPaint, paramTypeface);
      this.k = a(this.jdField_c_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public int c()
  {
    return Math.min(Math.max(super.c(), g()), this.l);
  }
  
  Bitmap c()
  {
    try
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(super.c(), super.d(), Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
      a(this.jdField_b_of_type_AndroidGraphicsCanvas, 0);
      return this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
        }
      }
    }
  }
  
  public int d()
  {
    return (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297660);
  }
  
  Bitmap d()
  {
    if ((this.jdField_a_of_type_Lgi == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Lgi.b))) {
      return null;
    }
    try
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(g(), f(), Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap);
      d(this.jdField_b_of_type_AndroidGraphicsCanvas, 0, 0);
      return this.jdField_c_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
        }
      }
    }
  }
  
  void d()
  {
    super.d();
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  boolean d()
  {
    return super.c() > this.l;
  }
  
  int e()
  {
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long != 0L) {
      l1 = (l2 - this.jdField_a_of_type_Long) * this.i >> 10;
    }
    this.jdField_a_of_type_Long = l2;
    return (int)l1;
  }
  
  boolean e()
  {
    return g() > this.l;
  }
  
  int f()
  {
    if (this.k == 0) {
      this.k = a(this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    return this.k;
  }
  
  public boolean f()
  {
    return ((d()) && (super.c() - this.l > this.o)) || ((e()) && (g() - this.l > this.n));
  }
  
  int g()
  {
    if (this.j == 0) {
      if (this.jdField_a_of_type_Lgi == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = this.jdField_a_of_type_Lgi.b;; localObject = null)
    {
      localObject = (String)localObject;
      this.j = a(this.jdField_c_of_type_AndroidGraphicsPaint, (String)localObject);
      return this.j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mou
 * JD-Core Version:    0.7.0.1
 */