import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class mqr
  implements mqp
{
  protected float a;
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected Canvas a;
  protected Paint a;
  final String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "_" + AudioHelper.b();
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference;
  public ljf a;
  protected mqq a;
  protected boolean a;
  protected int b = 255;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
  public mqr(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_Int = 24;
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Float = paramFloat;
    this.g = paramInt1;
    this.h = paramInt2;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public int a()
  {
    return this.e;
  }
  
  protected int a(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    float f1 = paramPaint.descent;
    float f2 = paramPaint.ascent;
    return (int)(paramPaint.leading + (f1 - f2));
  }
  
  protected int a(Paint paramPaint, String paramString)
  {
    float f3 = 0.0F;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.length();
      float[] arrayOfFloat = new float[j + 1];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      int i = 0;
      for (f1 = 0.0F;; f1 = f2 + f1)
      {
        f2 = f1;
        if (i >= j) {
          break;
        }
        f2 = arrayOfFloat[i];
        i += 1;
      }
    }
    float f2 = 0.0F;
    float f1 = f3;
    if (this.jdField_a_of_type_Mqq != null) {
      f1 = this.jdField_a_of_type_Mqq.jdField_a_of_type_Float;
    }
    return (int)Math.ceil(f2 + f1 / 2.0F);
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = b();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((ZimuView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void a(long paramLong)
  {
    lek.c(this.jdField_a_of_type_JavaLangString, "start:" + paramLong);
  }
  
  protected abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public void a(Typeface paramTypeface, int paramInt, mqq parammqq)
  {
    Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
    if ((localTypeface != paramTypeface) || (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setFontAttr, Typeface[" + localTypeface + "->" + paramTypeface + "], TextSize[" + this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize() + "->" + paramInt + "]");
    }
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_Mqq = parammqq;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt);
    d();
    if (this.jdField_a_of_type_Ljf != null) {}
    for (paramTypeface = this.jdField_a_of_type_Ljf.a;; paramTypeface = null)
    {
      paramTypeface = (String)paramTypeface;
      this.c = a(this.jdField_a_of_type_AndroidGraphicsPaint, paramTypeface);
      this.d = a(this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void a(ljf paramljf)
  {
    d();
    Object localObject;
    if (this.jdField_a_of_type_Ljf != null)
    {
      localObject = this.jdField_a_of_type_Ljf.b;
      localObject = (String)localObject;
      this.jdField_a_of_type_Ljf = paramljf;
      if ((this.jdField_a_of_type_Ljf != null) && (!this.jdField_a_of_type_Ljf.a()) && (paramljf != null) && (TextUtils.isEmpty(paramljf.b)) && (localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_a_of_type_Ljf.b = ((CharSequence)localObject);
      }
      if (this.jdField_a_of_type_Ljf == null) {
        break label124;
      }
    }
    label124:
    for (paramljf = this.jdField_a_of_type_Ljf.a;; paramljf = null)
    {
      paramljf = (String)paramljf;
      this.c = a(this.jdField_a_of_type_AndroidGraphicsPaint, paramljf);
      return;
      localObject = null;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.f;
  }
  
  Bitmap b()
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Ljf.a)) {
      localObject3 = localObject1;
    }
    do
    {
      for (;;)
      {
        return localObject3;
        lek.c(this.jdField_a_of_type_JavaLangString, "build:" + toString());
        localObject1 = localObject3;
        Object localObject2 = localObject4;
        try
        {
          int i = c();
          localObject1 = localObject3;
          localObject2 = localObject4;
          int j = d();
          localObject1 = localObject3;
          localObject2 = localObject4;
          localObject3 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          localObject1 = localObject3;
          localObject2 = localObject3;
          this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap((Bitmap)localObject3);
          localObject1 = localObject3;
          localObject2 = localObject3;
          a(this.jdField_a_of_type_AndroidGraphicsCanvas, i, j);
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject3 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError.getMessage());
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          localObject3 = localOutOfMemoryError;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
    return localOutOfMemoryError;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(null);
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    d();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return true;
  }
  
  public int d()
  {
    if (this.d == 0) {
      this.d = a(this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    return this.d;
  }
  
  public void d()
  {
    lek.c(this.jdField_a_of_type_JavaLangString, "releaseBitmap:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public String toString()
  {
    return "ZimuItemView{mFontPara=" + this.jdField_a_of_type_Mqq.toString() + ", getTypeface=" + this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface() + ", mTextSize=" + this.jdField_a_of_type_Int + ", mAlpha=" + this.b + ", mWidth=" + this.c + ", mHeight=" + this.d + ", mCurrentX=" + this.e + ", mCurrentY=" + this.f + ", mSentenceInfo=" + this.jdField_a_of_type_Ljf.toString() + ", mBitmapCache=" + this.jdField_a_of_type_AndroidGraphicsBitmap + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqr
 * JD-Core Version:    0.7.0.1
 */