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
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class FitXImageView
  extends View
{
  private static final Matrix.ScaleToFit[] jdField_a_of_type_ArrayOfAndroidGraphicsMatrix$ScaleToFit = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = null;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private Uri jdField_a_of_type_AndroidNetUri;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int jdField_b_of_type_Int = 2147483647;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 255;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 256;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
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
    if (i != -2147483648)
    {
      if (i != 0)
      {
        if (i != 1073741824) {
          return paramInt1;
        }
        return paramInt3;
      }
      return Math.min(paramInt1, paramInt2);
    }
    return Math.min(Math.min(paramInt1, paramInt3), paramInt2);
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ((IResourceUtil)QRoute.api(IResourceUtil.class)).getCustomFitMode());
    this.jdField_f_of_type_Boolean = paramContext.getBoolean(((IResourceUtil)QRoute.api(IResourceUtil.class)).getCustomFitModeUseFitXFromStart(), false);
    paramContext.recycle();
  }
  
  private void a(Drawable paramDrawable)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
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
    //   0: aload_0
    //   1: getfield 64	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   4: ifnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokevirtual 194	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:getResources	()Landroid/content/res/Resources;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 47	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_Int	I
    //   22: istore_1
    //   23: aconst_null
    //   24: astore_2
    //   25: iload_1
    //   26: ifeq +62 -> 88
    //   29: aload_3
    //   30: iload_1
    //   31: invokevirtual 200	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: goto +284 -> 321
    //   40: astore_3
    //   41: new 202	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: ldc 205
    //   54: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: aload_0
    //   61: getfield 47	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_Int	I
    //   64: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: ldc 214
    //   70: aload 4
    //   72: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: aload_3
    //   76: invokestatic 224	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   79: pop
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 226	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   85: goto +236 -> 321
    //   88: aload_0
    //   89: getfield 226	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +252 -> 346
    //   97: aload_2
    //   98: invokevirtual 231	android/net/Uri:getScheme	()Ljava/lang/String;
    //   101: astore_2
    //   102: ldc 233
    //   104: aload_2
    //   105: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +29 -> 137
    //   111: ldc 241
    //   113: aload_2
    //   114: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifeq +6 -> 123
    //   120: goto +17 -> 137
    //   123: aload_0
    //   124: getfield 226	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   127: invokevirtual 242	android/net/Uri:toString	()Ljava/lang/String;
    //   130: invokestatic 246	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   133: astore_2
    //   134: goto +137 -> 271
    //   137: aload_0
    //   138: getfield 84	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   141: invokevirtual 250	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   144: aload_0
    //   145: getfield 226	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   148: invokevirtual 256	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   151: astore_3
    //   152: aload_3
    //   153: astore_2
    //   154: aload_3
    //   155: aconst_null
    //   156: invokestatic 260	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   159: astore 4
    //   161: aload 4
    //   163: astore_2
    //   164: aload_3
    //   165: ifnull +106 -> 271
    //   168: aload_3
    //   169: invokevirtual 265	java/io/InputStream:close	()V
    //   172: aload 4
    //   174: astore_2
    //   175: goto +96 -> 271
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   183: aload 4
    //   185: astore_2
    //   186: goto +85 -> 271
    //   189: astore 4
    //   191: goto +13 -> 204
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_2
    //   197: goto +131 -> 328
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_3
    //   204: aload_3
    //   205: astore_2
    //   206: new 202	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   213: astore 5
    //   215: aload_3
    //   216: astore_2
    //   217: aload 5
    //   219: ldc_w 270
    //   222: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_3
    //   227: astore_2
    //   228: aload 5
    //   230: aload_0
    //   231: getfield 226	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   234: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_3
    //   239: astore_2
    //   240: ldc 214
    //   242: aload 5
    //   244: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: aload 4
    //   249: invokestatic 224	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   252: pop
    //   253: aload_3
    //   254: ifnull +15 -> 269
    //   257: aload_3
    //   258: invokevirtual 265	java/io/InputStream:close	()V
    //   261: goto +8 -> 269
    //   264: astore_2
    //   265: aload_2
    //   266: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_2
    //   272: ifnonnull +49 -> 321
    //   275: getstatic 279	java/lang/System:out	Ljava/io/PrintStream;
    //   278: astore_3
    //   279: new 202	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   286: astore 4
    //   288: aload 4
    //   290: ldc_w 281
    //   293: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 4
    //   299: aload_0
    //   300: getfield 226	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   303: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: aload 4
    //   310: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokevirtual 287	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 226	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   321: aload_0
    //   322: aload_2
    //   323: invokespecial 289	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	(Landroid/graphics/drawable/Drawable;)V
    //   326: return
    //   327: astore_3
    //   328: aload_2
    //   329: ifnull +15 -> 344
    //   332: aload_2
    //   333: invokevirtual 265	java/io/InputStream:close	()V
    //   336: goto +8 -> 344
    //   339: astore_2
    //   340: aload_2
    //   341: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   344: aload_3
    //   345: athrow
    //   346: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	FitXImageView
    //   22	9	1	i	int
    //   24	151	2	localObject1	java.lang.Object
    //   178	2	2	localIOException1	java.io.IOException
    //   185	55	2	localObject2	java.lang.Object
    //   264	2	2	localIOException2	java.io.IOException
    //   270	63	2	localDrawable	Drawable
    //   339	2	2	localIOException3	java.io.IOException
    //   12	24	3	localObject3	java.lang.Object
    //   40	36	3	localException1	Exception
    //   151	18	3	localInputStream	java.io.InputStream
    //   194	1	3	localObject4	java.lang.Object
    //   203	105	3	localPrintStream	java.io.PrintStream
    //   327	18	3	localObject5	java.lang.Object
    //   48	136	4	localObject6	java.lang.Object
    //   189	1	4	localException2	Exception
    //   200	48	4	localException3	Exception
    //   286	23	4	localStringBuilder1	java.lang.StringBuilder
    //   213	30	5	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	35	40	java/lang/Exception
    //   168	172	178	java/io/IOException
    //   154	161	189	java/lang/Exception
    //   137	152	194	finally
    //   137	152	200	java/lang/Exception
    //   257	261	264	java/io/IOException
    //   154	161	327	finally
    //   206	215	327	finally
    //   217	226	327	finally
    //   228	238	327	finally
    //   240	253	327	finally
    //   332	336	339	java/io/IOException
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
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      int j = this.g;
      int k = this.h;
      int m = getWidth() - getPaddingLeft() - getPaddingRight();
      int n = getHeight() - getPaddingTop() - getPaddingBottom();
      int i;
      if (((j >= 0) && (m != j)) || ((k >= 0) && (n != k))) {
        i = 0;
      } else {
        i = 1;
      }
      if ((j > 0) && (k > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, j, k);
        if (i != 0)
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix = null;
          return;
        }
        Matrix localMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
        this.jdField_a_of_type_AndroidGraphicsMatrix = localMatrix;
        i = m * k;
        int i1 = i / j;
        float f3 = 0.0F;
        if (i1 < n)
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, j, k);
          this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m, n);
          this.jdField_a_of_type_AndroidGraphicsMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, Matrix.ScaleToFit.CENTER);
          return;
        }
        this.jdField_a_of_type_AndroidGraphicsMatrix = localMatrix;
        float f1;
        float f2;
        if (j * n > i)
        {
          f1 = n / k;
          f3 = (m - j * f1) * 0.5F;
          f2 = 0.0F;
        }
        else
        {
          f1 = m / j;
          f2 = (n - k * f1) * 0.5F;
        }
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        if (!this.jdField_f_of_type_Boolean) {
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, m, n);
        this.jdField_a_of_type_AndroidGraphicsMatrix = null;
      }
    }
  }
  
  private void e()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable.mutate();
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
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
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
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      boolean bool;
      if (getVisibility() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localDrawable.setVisible(bool, false);
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (arrayOfInt == null) {
      return super.onCreateDrawableState(paramInt);
    }
    if (!this.jdField_d_of_type_Boolean) {
      return arrayOfInt;
    }
    return mergeDrawableStates(super.onCreateDrawableState(paramInt + arrayOfInt.length), this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(false, false);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    if (this.g != 0)
    {
      if (this.h == 0) {
        return;
      }
      try
      {
        if ((this.jdField_a_of_type_AndroidGraphicsMatrix == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
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
        return;
      }
      catch (Exception paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    b();
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i;
    int j;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.g = -1;
      this.h = -1;
      i = 0;
      j = 0;
    }
    int k;
    float f1;
    for (;;)
    {
      m = 0;
      k = 0;
      f1 = 0.0F;
      n = j;
      break;
      j = this.g;
      k = this.h;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      j = k;
      if (k <= 0) {
        j = 1;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (n != 1073741824) {
          k = 1;
        } else {
          k = 0;
        }
        if (m != 1073741824) {
          m = 1;
        } else {
          m = 0;
        }
        f1 = i / j;
        n = j;
        break;
      }
    }
    int i3 = getPaddingLeft();
    int i4 = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    if ((k == 0) && (m == 0))
    {
      i = Math.max(i + (i3 + i4), getSuggestedMinimumWidth());
      j = Math.max(n + (i1 + i2), getSuggestedMinimumHeight());
      paramInt1 = resolveSizeAndState(i, paramInt1, 0);
      i = resolveSizeAndState(j, paramInt2, 0);
    }
    else
    {
      j = a(i + i3 + i4, this.jdField_b_of_type_Int, paramInt1);
      n = a(n + i1 + i2, this.jdField_c_of_type_Int, paramInt2);
      paramInt1 = j;
      i = n;
      if (f1 != 0.0F)
      {
        float f2 = j - i3 - i4;
        float f3 = n - i1 - i2;
        paramInt1 = j;
        i = n;
        if (Math.abs(f2 / f3 - f1) > 1.0E-007D)
        {
          if (k != 0)
          {
            paramInt2 = (int)(f3 * f1) + i3 + i4;
            if (paramInt2 <= j)
            {
              k = 1;
              break label371;
            }
          }
          k = 0;
          paramInt2 = j;
          label371:
          paramInt1 = paramInt2;
          i = n;
          if (k == 0)
          {
            paramInt1 = paramInt2;
            i = n;
            if (m != 0)
            {
              j = (int)((paramInt2 - i3 - i4) / f1) + i1 + i2;
              paramInt1 = paramInt2;
              i = n;
              if (j <= n)
              {
                i = j;
                paramInt1 = paramInt2;
              }
            }
          }
        }
      }
    }
    setMeasuredDimension(paramInt1, i);
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
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      localDrawable.setLevel(paramInt);
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
    if (this.jdField_a_of_type_Int == 0)
    {
      Uri localUri = this.jdField_a_of_type_AndroidNetUri;
      if ((localUri == paramUri) || ((paramUri != null) && (localUri != null) && (paramUri.equals(localUri)))) {}
    }
    else
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
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localDrawable.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.FitXImageView
 * JD-Core Version:    0.7.0.1
 */