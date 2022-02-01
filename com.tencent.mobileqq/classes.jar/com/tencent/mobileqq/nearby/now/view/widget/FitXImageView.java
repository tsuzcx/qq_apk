package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;

public class FitXImageView
  extends View
{
  private static final Matrix.ScaleToFit[] jdField_a_of_type_ArrayOfAndroidGraphicsMatrix$ScaleToFit = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Uri jdField_a_of_type_AndroidNetUri;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int = 2147483647;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 255;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 256;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  
  public FitXImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public FitXImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    a(paramContext, paramAttributeSet);
  }
  
  public FitXImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt3);
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    switch (i)
    {
    default: 
      return paramInt1;
    case 0: 
      return Math.min(paramInt1, paramInt2);
    case -2147483648: 
      return Math.min(Math.min(paramInt1, paramInt3), paramInt2);
    }
    return paramInt3;
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.customFitMode);
    this.jdField_f_of_type_Boolean = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  private void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      paramDrawable.setLevel(this.jdField_f_of_type_Int);
      this.g = paramDrawable.getIntrinsicWidth();
      this.h = paramDrawable.getIntrinsicHeight();
      e();
      d();
      return;
    }
    this.h = -1;
    this.g = -1;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 119	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   6: ifnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: invokevirtual 169	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:getResources	()Landroid/content/res/Resources;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull -7 -> 9
    //   19: aload_0
    //   20: getfield 171	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_Int	I
    //   23: ifeq +58 -> 81
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 171	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_Int	I
    //   31: invokevirtual 177	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 179	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	(Landroid/graphics/drawable/Drawable;)V
    //   42: return
    //   43: astore_2
    //   44: ldc 181
    //   46: new 183	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   53: ldc 186
    //   55: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 171	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_Int	I
    //   62: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aload_2
    //   69: invokestatic 203	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   72: pop
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   78: goto -41 -> 37
    //   81: aload_0
    //   82: getfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   85: ifnull -76 -> 9
    //   88: aload_0
    //   89: getfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   92: invokevirtual 210	android/net/Uri:getScheme	()Ljava/lang/String;
    //   95: astore_1
    //   96: ldc 212
    //   98: aload_1
    //   99: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +12 -> 114
    //   105: ldc 220
    //   107: aload_1
    //   108: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifeq +167 -> 278
    //   114: aload_0
    //   115: getfield 64	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   118: invokevirtual 224	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   121: aload_0
    //   122: getfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   125: invokevirtual 230	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: aconst_null
    //   133: invokestatic 234	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   136: astore_3
    //   137: aload_3
    //   138: astore_1
    //   139: aload_2
    //   140: ifnull +9 -> 149
    //   143: aload_2
    //   144: invokevirtual 239	java/io/InputStream:close	()V
    //   147: aload_3
    //   148: astore_1
    //   149: aload_1
    //   150: ifnonnull +36 -> 186
    //   153: getstatic 245	java/lang/System:out	Ljava/io/PrintStream;
    //   156: new 183	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   163: ldc 247
    //   165: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: getfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   172: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokevirtual 256	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   186: goto -149 -> 37
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   194: aload_3
    //   195: astore_1
    //   196: goto -47 -> 149
    //   199: astore_3
    //   200: aconst_null
    //   201: astore_2
    //   202: aload_2
    //   203: astore_1
    //   204: ldc 181
    //   206: new 183	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 261
    //   216: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: getfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   223: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: aload_3
    //   230: invokestatic 203	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: aload_2
    //   235: ifnull +65 -> 300
    //   238: aload_2
    //   239: invokevirtual 239	java/io/InputStream:close	()V
    //   242: aconst_null
    //   243: astore_1
    //   244: goto -95 -> 149
    //   247: astore_1
    //   248: aload_1
    //   249: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   252: aconst_null
    //   253: astore_1
    //   254: goto -105 -> 149
    //   257: astore_2
    //   258: aconst_null
    //   259: astore_1
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 239	java/io/InputStream:close	()V
    //   268: aload_2
    //   269: athrow
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   275: goto -7 -> 268
    //   278: aload_0
    //   279: getfield 205	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   282: invokevirtual 262	android/net/Uri:toString	()Ljava/lang/String;
    //   285: invokestatic 266	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   288: astore_1
    //   289: goto -140 -> 149
    //   292: astore_2
    //   293: goto -33 -> 260
    //   296: astore_3
    //   297: goto -95 -> 202
    //   300: aconst_null
    //   301: astore_1
    //   302: goto -153 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	FitXImageView
    //   1	149	1	localObject1	java.lang.Object
    //   189	2	1	localIOException1	java.io.IOException
    //   195	49	1	localObject2	java.lang.Object
    //   247	2	1	localIOException2	java.io.IOException
    //   253	12	1	localObject3	java.lang.Object
    //   270	2	1	localIOException3	java.io.IOException
    //   288	14	1	localDrawable1	Drawable
    //   14	22	2	localObject4	java.lang.Object
    //   43	26	2	localException1	Exception
    //   128	111	2	localInputStream	java.io.InputStream
    //   257	12	2	localObject5	java.lang.Object
    //   292	1	2	localObject6	java.lang.Object
    //   136	59	3	localDrawable2	Drawable
    //   199	31	3	localException2	Exception
    //   296	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   26	35	43	java/lang/Exception
    //   143	147	189	java/io/IOException
    //   114	129	199	java/lang/Exception
    //   238	242	247	java/io/IOException
    //   114	129	257	finally
    //   264	268	270	java/io/IOException
    //   131	137	292	finally
    //   204	234	292	finally
    //   131	137	296	java/lang/Exception
  }
  
  private void c()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.g;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.h;
      }
      if ((i != this.g) || (j != this.h))
      {
        this.g = i;
        this.h = j;
        requestLayout();
      }
    }
  }
  
  private void d()
  {
    float f1 = 0.0F;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    int j = this.g;
    int k = this.h;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0); i = 0)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, m, n);
      this.jdField_a_of_type_AndroidGraphicsMatrix = null;
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, j, k);
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix = null;
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
    if (m * k / j < n)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, j, k);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m, n);
      this.jdField_a_of_type_AndroidGraphicsMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, Matrix.ScaleToFit.CENTER);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
    float f3;
    float f2;
    if (j * n > m * k)
    {
      f3 = n / k;
      f2 = (m - j * f3) * 0.5F;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f3, f3);
      if (this.jdField_f_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
      return;
      f3 = m / j;
      f1 = n;
      float f4 = k;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.mutate();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_d_of_type_Int * this.jdField_e_of_type_Int >> 8);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
    }
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Drawable localDrawable;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (getVisibility() != 0) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      localDrawable.setVisible(bool, false);
      return;
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      return super.onCreateDrawableState(paramInt);
    }
    if (!this.jdField_d_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfInt;
    }
    return mergeDrawableStates(super.onCreateDrawableState(this.jdField_a_of_type_ArrayOfInt.length + paramInt), this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
    while ((this.g == 0) || (this.h == 0)) {
      return;
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsMatrix == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        return;
      }
    }
    catch (Exception paramCanvas)
    {
      paramCanvas.printStackTrace();
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.jdField_e_of_type_Boolean)
    {
      int j = getScrollX();
      int k = getScrollY();
      paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
    }
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.jdField_a_of_type_AndroidGraphicsMatrix != null) {
      paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    b();
    int m = 0;
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j;
    int k;
    int i;
    float f1;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.g = -1;
      this.h = -1;
      j = 0;
      k = 0;
      i = 0;
      f1 = 0.0F;
    }
    for (;;)
    {
      int i2 = getPaddingLeft();
      int i3 = getPaddingRight();
      n = getPaddingTop();
      i1 = getPaddingBottom();
      if ((i != 0) || (m != 0))
      {
        paramInt1 = a(j + i2 + i3, this.jdField_b_of_type_Int, paramInt1);
        j = a(k + n + i1, this.jdField_c_of_type_Int, paramInt2);
        paramInt2 = paramInt1;
        if (f1 == 0.0F) {
          break label404;
        }
        paramInt2 = paramInt1;
        if (Math.abs((paramInt1 - i2 - i3) / (j - n - i1) - f1) <= 1.0E-007D) {
          break label404;
        }
        if (i == 0) {
          break label410;
        }
        paramInt2 = (int)((j - n - i1) * f1) + i2 + i3;
        if (paramInt2 > paramInt1) {
          break label410;
        }
        i = 1;
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i == 0)
        {
          paramInt2 = paramInt1;
          if (m != 0)
          {
            i = (int)((paramInt1 - i2 - i3) / f1) + n + i1;
            paramInt2 = paramInt1;
            if (i <= j)
            {
              paramInt2 = paramInt1;
              paramInt1 = i;
            }
          }
        }
        for (;;)
        {
          setMeasuredDimension(paramInt2, paramInt1);
          return;
          i = this.g;
          k = this.h;
          j = i;
          if (i <= 0) {
            j = 1;
          }
          i = k;
          if (k <= 0) {
            i = 1;
          }
          if (!this.jdField_b_of_type_Boolean) {
            break label416;
          }
          if (i1 != 1073741824)
          {
            k = 1;
            label301:
            if (n == 1073741824) {
              break label341;
            }
          }
          label341:
          for (m = 1;; m = 0)
          {
            f1 = j / i;
            n = i;
            i = k;
            k = n;
            break;
            k = 0;
            break label301;
          }
          i = Math.max(i2 + i3 + j, getSuggestedMinimumWidth());
          j = Math.max(n + i1 + k, getSuggestedMinimumHeight());
          i = resolveSizeAndState(i, paramInt1, 0);
          paramInt1 = resolveSizeAndState(j, paramInt2, 0);
          paramInt2 = i;
          continue;
          label404:
          paramInt1 = j;
        }
        label410:
        i = 0;
      }
      label416:
      f1 = 0.0F;
      k = i;
      i = 0;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    paramInt &= 0xFF;
    if (this.jdField_d_of_type_Int != paramInt)
    {
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_c_of_type_Boolean = true;
      e();
      invalidate();
    }
  }
  
  public void setCropToPadding(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean != paramBoolean)
    {
      this.jdField_e_of_type_Boolean = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable) || (this.g != paramDrawable.getIntrinsicWidth()) || (this.h != paramDrawable.getIntrinsicHeight()))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidNetUri = null;
      int i = this.g;
      int j = this.h;
      a(paramDrawable);
      if ((i != this.g) || (j != this.h)) {
        requestLayout();
      }
      invalidate();
    }
  }
  
  public void setImageLevel(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setLevel(paramInt);
      c();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidNetUri != null) || (this.jdField_a_of_type_Int != paramInt))
    {
      a(null);
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidNetUri = null;
      b();
      requestLayout();
      invalidate();
    }
  }
  
  public void setImageState(int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      refreshDrawableState();
      c();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    if ((this.jdField_a_of_type_Int != 0) || ((this.jdField_a_of_type_AndroidNetUri != paramUri) && ((paramUri == null) || (this.jdField_a_of_type_AndroidNetUri == null) || (!paramUri.equals(this.jdField_a_of_type_AndroidNetUri)))))
    {
      a(null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidNetUri = paramUri;
      b();
      requestLayout();
      invalidate();
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    c();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Drawable localDrawable;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramInt != 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localDrawable.setVisible(bool, false);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.FitXImageView
 * JD-Core Version:    0.7.0.1
 */