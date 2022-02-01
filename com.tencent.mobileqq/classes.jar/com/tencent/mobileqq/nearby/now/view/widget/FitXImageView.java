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
  private static final Matrix.ScaleToFit[] w = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private Uri a;
  private int b = 0;
  private boolean c = false;
  private boolean d = false;
  private int e = 2147483647;
  private int f = 2147483647;
  private int g = 255;
  private int h = 256;
  private boolean i = false;
  private Drawable j = null;
  private int[] k = null;
  private boolean l = false;
  private int m = 0;
  private int n;
  private int o;
  private Matrix p = null;
  private final RectF q = new RectF();
  private final RectF r = new RectF();
  private boolean s;
  private Context t;
  private Matrix u;
  private boolean v = false;
  
  public FitXImageView(Context paramContext)
  {
    super(paramContext);
    this.t = paramContext;
    a();
  }
  
  public FitXImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.t = paramContext;
    a();
    a(paramContext, paramAttributeSet);
  }
  
  public FitXImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.t = paramContext;
    a();
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = View.MeasureSpec.getMode(paramInt3);
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    if (i1 != -2147483648)
    {
      if (i1 != 0)
      {
        if (i1 != 1073741824) {
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
    this.u = new Matrix();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ((IResourceUtil)QRoute.api(IResourceUtil.class)).getCustomFitMode());
    this.v = paramContext.getBoolean(((IResourceUtil)QRoute.api(IResourceUtil.class)).getCustomFitModeUseFitXFromStart(), false);
    paramContext.recycle();
  }
  
  private void a(Drawable paramDrawable)
  {
    Drawable localDrawable = this.j;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.j);
    }
    this.j = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      paramDrawable.setLevel(this.m);
      this.n = paramDrawable.getIntrinsicWidth();
      this.o = paramDrawable.getIntrinsicHeight();
      e();
      d();
      return;
    }
    this.o = -1;
    this.n = -1;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:j	Landroid/graphics/drawable/Drawable;
    //   4: ifnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokevirtual 209	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:getResources	()Landroid/content/res/Resources;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 62	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:b	I
    //   22: istore_1
    //   23: aconst_null
    //   24: astore_2
    //   25: iload_1
    //   26: ifeq +62 -> 88
    //   29: aload_3
    //   30: iload_1
    //   31: invokevirtual 215	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: goto +284 -> 321
    //   40: astore_3
    //   41: new 217	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: ldc 220
    //   54: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: aload_0
    //   61: getfield 62	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:b	I
    //   64: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: ldc 229
    //   70: aload 4
    //   72: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: aload_3
    //   76: invokestatic 238	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   79: pop
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 240	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	Landroid/net/Uri;
    //   85: goto +236 -> 321
    //   88: aload_0
    //   89: getfield 240	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	Landroid/net/Uri;
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +252 -> 346
    //   97: aload_2
    //   98: invokevirtual 245	android/net/Uri:getScheme	()Ljava/lang/String;
    //   101: astore_2
    //   102: ldc 247
    //   104: aload_2
    //   105: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +29 -> 137
    //   111: ldc 255
    //   113: aload_2
    //   114: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifeq +6 -> 123
    //   120: goto +17 -> 137
    //   123: aload_0
    //   124: getfield 240	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	Landroid/net/Uri;
    //   127: invokevirtual 256	android/net/Uri:toString	()Ljava/lang/String;
    //   130: invokestatic 260	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   133: astore_2
    //   134: goto +137 -> 271
    //   137: aload_0
    //   138: getfield 99	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:t	Landroid/content/Context;
    //   141: invokevirtual 264	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   144: aload_0
    //   145: getfield 240	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	Landroid/net/Uri;
    //   148: invokevirtual 270	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   151: astore_3
    //   152: aload_3
    //   153: astore_2
    //   154: aload_3
    //   155: aconst_null
    //   156: invokestatic 274	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   159: astore 4
    //   161: aload 4
    //   163: astore_2
    //   164: aload_3
    //   165: ifnull +106 -> 271
    //   168: aload_3
    //   169: invokevirtual 279	java/io/InputStream:close	()V
    //   172: aload 4
    //   174: astore_2
    //   175: goto +96 -> 271
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 282	java/io/IOException:printStackTrace	()V
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
    //   206: new 217	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   213: astore 5
    //   215: aload_3
    //   216: astore_2
    //   217: aload 5
    //   219: ldc_w 284
    //   222: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_3
    //   227: astore_2
    //   228: aload 5
    //   230: aload_0
    //   231: getfield 240	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	Landroid/net/Uri;
    //   234: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_3
    //   239: astore_2
    //   240: ldc 229
    //   242: aload 5
    //   244: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: aload 4
    //   249: invokestatic 238	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   252: pop
    //   253: aload_3
    //   254: ifnull +15 -> 269
    //   257: aload_3
    //   258: invokevirtual 279	java/io/InputStream:close	()V
    //   261: goto +8 -> 269
    //   264: astore_2
    //   265: aload_2
    //   266: invokevirtual 282	java/io/IOException:printStackTrace	()V
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_2
    //   272: ifnonnull +49 -> 321
    //   275: getstatic 293	java/lang/System:out	Ljava/io/PrintStream;
    //   278: astore_3
    //   279: new 217	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   286: astore 4
    //   288: aload 4
    //   290: ldc_w 295
    //   293: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 4
    //   299: aload_0
    //   300: getfield 240	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	Landroid/net/Uri;
    //   303: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: aload 4
    //   310: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokevirtual 301	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 240	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	Landroid/net/Uri;
    //   321: aload_0
    //   322: aload_2
    //   323: invokespecial 303	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:a	(Landroid/graphics/drawable/Drawable;)V
    //   326: return
    //   327: astore_3
    //   328: aload_2
    //   329: ifnull +15 -> 344
    //   332: aload_2
    //   333: invokevirtual 279	java/io/InputStream:close	()V
    //   336: goto +8 -> 344
    //   339: astore_2
    //   340: aload_2
    //   341: invokevirtual 282	java/io/IOException:printStackTrace	()V
    //   344: aload_3
    //   345: athrow
    //   346: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	FitXImageView
    //   22	9	1	i1	int
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
    Drawable localDrawable = this.j;
    if (localDrawable != null)
    {
      int i2 = localDrawable.getIntrinsicWidth();
      int i1 = i2;
      if (i2 < 0) {
        i1 = this.n;
      }
      int i3 = localDrawable.getIntrinsicHeight();
      i2 = i3;
      if (i3 < 0) {
        i2 = this.o;
      }
      if ((i1 != this.n) || (i2 != this.o))
      {
        this.n = i1;
        this.o = i2;
        requestLayout();
      }
    }
  }
  
  private void d()
  {
    if (this.j != null)
    {
      if (!this.c) {
        return;
      }
      int i2 = this.n;
      int i3 = this.o;
      int i4 = getWidth() - getPaddingLeft() - getPaddingRight();
      int i5 = getHeight() - getPaddingTop() - getPaddingBottom();
      int i1;
      if (((i2 >= 0) && (i4 != i2)) || ((i3 >= 0) && (i5 != i3))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if ((i2 > 0) && (i3 > 0))
      {
        this.j.setBounds(0, 0, i2, i3);
        if (i1 != 0)
        {
          this.p = null;
          return;
        }
        Matrix localMatrix = this.u;
        this.p = localMatrix;
        i1 = i4 * i3;
        int i6 = i1 / i2;
        float f3 = 0.0F;
        if (i6 < i5)
        {
          this.q.set(0.0F, 0.0F, i2, i3);
          this.r.set(0.0F, 0.0F, i4, i5);
          this.p = this.u;
          this.p.setRectToRect(this.q, this.r, Matrix.ScaleToFit.CENTER);
          return;
        }
        this.p = localMatrix;
        float f1;
        float f2;
        if (i2 * i5 > i1)
        {
          f1 = i5 / i3;
          f3 = (i4 - i2 * f1) * 0.5F;
          f2 = 0.0F;
        }
        else
        {
          f1 = i4 / i2;
          f2 = (i5 - i3 * f1) * 0.5F;
        }
        this.p.setScale(f1, f1);
        if (!this.v) {
          this.p.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
        }
      }
      else
      {
        this.j.setBounds(0, 0, i4, i5);
        this.p = null;
      }
    }
  }
  
  private void e()
  {
    Drawable localDrawable = this.j;
    if ((localDrawable != null) && (this.i))
    {
      this.j = localDrawable.mutate();
      this.j.setAlpha(this.g * this.h >> 8);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.j;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public boolean getCropToPadding()
  {
    return this.s;
  }
  
  public Drawable getDrawable()
  {
    return this.j;
  }
  
  public int getMaxHeight()
  {
    return this.f;
  }
  
  public int getMaxWidth()
  {
    return this.e;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.j)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.j;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = true;
    d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Drawable localDrawable = this.j;
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
    int[] arrayOfInt = this.k;
    if (arrayOfInt == null) {
      return super.onCreateDrawableState(paramInt);
    }
    if (!this.l) {
      return arrayOfInt;
    }
    return mergeDrawableStates(super.onCreateDrawableState(paramInt + arrayOfInt.length), this.k);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = this.j;
    if (localDrawable != null) {
      localDrawable.setVisible(false, false);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.j == null) {
      return;
    }
    if (this.n != 0)
    {
      if (this.o == 0) {
        return;
      }
      try
      {
        if ((this.p == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
        {
          this.j.draw(paramCanvas);
          return;
        }
        int i1 = paramCanvas.getSaveCount();
        paramCanvas.save();
        if (this.s)
        {
          int i2 = getScrollX();
          int i3 = getScrollY();
          paramCanvas.clipRect(getPaddingLeft() + i2, getPaddingTop() + i3, i2 + getRight() - getLeft() - getPaddingRight(), i3 + getBottom() - getTop() - getPaddingBottom());
        }
        paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        if (this.p != null) {
          paramCanvas.concat(this.p);
        }
        this.j.draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
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
    int i5 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i1;
    int i2;
    if (this.j == null)
    {
      this.n = -1;
      this.o = -1;
      i1 = 0;
      i2 = 0;
    }
    int i3;
    float f1;
    for (;;)
    {
      i4 = 0;
      i3 = 0;
      f1 = 0.0F;
      i5 = i2;
      break;
      i2 = this.n;
      i3 = this.o;
      i1 = i2;
      if (i2 <= 0) {
        i1 = 1;
      }
      i2 = i3;
      if (i3 <= 0) {
        i2 = 1;
      }
      if (this.d)
      {
        if (i5 != 1073741824) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if (i4 != 1073741824) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        f1 = i1 / i2;
        i5 = i2;
        break;
      }
    }
    int i8 = getPaddingLeft();
    int i9 = getPaddingRight();
    int i6 = getPaddingTop();
    int i7 = getPaddingBottom();
    if ((i3 == 0) && (i4 == 0))
    {
      i1 = Math.max(i1 + (i8 + i9), getSuggestedMinimumWidth());
      i2 = Math.max(i5 + (i6 + i7), getSuggestedMinimumHeight());
      paramInt1 = resolveSizeAndState(i1, paramInt1, 0);
      i1 = resolveSizeAndState(i2, paramInt2, 0);
    }
    else
    {
      i2 = a(i1 + i8 + i9, this.e, paramInt1);
      i5 = a(i5 + i6 + i7, this.f, paramInt2);
      paramInt1 = i2;
      i1 = i5;
      if (f1 != 0.0F)
      {
        float f2 = i2 - i8 - i9;
        float f3 = i5 - i6 - i7;
        paramInt1 = i2;
        i1 = i5;
        if (Math.abs(f2 / f3 - f1) > 1.0E-007D)
        {
          if (i3 != 0)
          {
            paramInt2 = (int)(f3 * f1) + i8 + i9;
            if (paramInt2 <= i2)
            {
              i3 = 1;
              break label371;
            }
          }
          i3 = 0;
          paramInt2 = i2;
          label371:
          paramInt1 = paramInt2;
          i1 = i5;
          if (i3 == 0)
          {
            paramInt1 = paramInt2;
            i1 = i5;
            if (i4 != 0)
            {
              i2 = (int)((paramInt2 - i8 - i9) / f1) + i6 + i7;
              paramInt1 = paramInt2;
              i1 = i5;
              if (i2 <= i5)
              {
                i1 = i2;
                paramInt1 = paramInt2;
              }
            }
          }
        }
      }
    }
    setMeasuredDimension(paramInt1, i1);
  }
  
  public void setAlpha(int paramInt)
  {
    paramInt &= 0xFF;
    if (this.g != paramInt)
    {
      this.g = paramInt;
      this.i = true;
      e();
      invalidate();
    }
  }
  
  public void setCropToPadding(boolean paramBoolean)
  {
    if (this.s != paramBoolean)
    {
      this.s = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new BitmapDrawable(this.t.getResources(), paramBitmap));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.j != paramDrawable) || (this.n != paramDrawable.getIntrinsicWidth()) || (this.o != paramDrawable.getIntrinsicHeight()))
    {
      this.b = 0;
      this.a = null;
      int i1 = this.n;
      int i2 = this.o;
      a(paramDrawable);
      if ((i1 != this.n) || (i2 != this.o)) {
        requestLayout();
      }
      invalidate();
    }
  }
  
  public void setImageLevel(int paramInt)
  {
    this.m = paramInt;
    Drawable localDrawable = this.j;
    if (localDrawable != null)
    {
      localDrawable.setLevel(paramInt);
      c();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if ((this.a != null) || (this.b != paramInt))
    {
      a(null);
      this.b = paramInt;
      this.a = null;
      b();
      requestLayout();
      invalidate();
    }
  }
  
  public void setImageState(int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.k = paramArrayOfInt;
    this.l = paramBoolean;
    if (this.j != null)
    {
      refreshDrawableState();
      c();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    if (this.b == 0)
    {
      Uri localUri = this.a;
      if ((localUri == paramUri) || ((paramUri != null) && (localUri != null) && (paramUri.equals(localUri)))) {}
    }
    else
    {
      a(null);
      this.b = 0;
      this.a = paramUri;
      b();
      requestLayout();
      invalidate();
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    c();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Drawable localDrawable = this.j;
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
    return (this.j == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.FitXImageView
 * JD-Core Version:    0.7.0.1
 */