package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.filecommon.api.R.styleable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.URLThemeImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends URLThemeImageView
{
  private Drawable a = null;
  private Context b = null;
  private int c = 128;
  private int d = 128;
  private RectF e;
  private Paint f;
  private Path g;
  private float[] h;
  private Xfermode i;
  private int j;
  private Path k;
  
  public AsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bp);
    this.j = paramContext.getDimensionPixelOffset(R.styleable.bq, 0);
    this.g = new Path();
    if (Build.VERSION.SDK_INT <= 26) {
      this.i = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    } else {
      this.i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
    this.themeImageWrapper.setMaskShape(ThemeImageWrapper.MODE_SQURE);
    this.k = new Path();
    this.h = new float[8];
    this.f = new Paint();
    a();
    b();
    paramContext.recycle();
  }
  
  public static URL a(String paramString)
  {
    try
    {
      paramString = new URL("filegalleryorigimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString, paramInt1, paramInt2, paramFile, paramBoolean1, paramBoolean2, false);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l;
    if (paramFile != null) {
      l = paramFile.lastModified();
    } else {
      l = 0L;
    }
    paramFile = new StringBuilder();
    paramFile.append(paramString);
    paramFile.append("|");
    paramFile.append(paramInt1);
    paramFile.append("|");
    paramFile.append(paramInt2);
    paramFile.append("|");
    paramFile.append(l);
    paramFile.append("|1");
    paramString = paramFile.toString();
    if (paramBoolean1)
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("|1");
      paramString = paramFile.toString();
    }
    else
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("|0");
      paramString = paramFile.toString();
    }
    if (paramBoolean2)
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("|1");
      paramString = paramFile.toString();
    }
    else
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("|0");
      paramString = paramFile.toString();
    }
    if (paramBoolean3)
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("|1");
      paramString = paramFile.toString();
    }
    else
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("|0");
      paramString = paramFile.toString();
    }
    try
    {
      paramString = new URL("fileassistantimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  private void a()
  {
    if (this.e == null) {
      this.e = new RectF();
    }
    this.e.set(0.0F, 0.0F, getWidth(), getHeight());
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float[] arrayOfFloat = this.h;
    float f1 = paramInt1 / 2.0F;
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f1;
    f1 = paramInt2 / 2.0F;
    arrayOfFloat[2] = f1;
    arrayOfFloat[3] = f1;
    f1 = paramInt3 / 2.0F;
    arrayOfFloat[4] = f1;
    arrayOfFloat[5] = f1;
    f1 = paramInt4 / 2.0F;
    arrayOfFloat[6] = f1;
    arrayOfFloat[7] = f1;
  }
  
  public static boolean a(URL paramURL)
  {
    if (paramURL == null) {
      return false;
    }
    try
    {
      paramURL = paramURL.getProtocol();
      if (paramURL != null)
      {
        boolean bool = paramURL.equals("filegalleryorigimage");
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramURL) {}
    return false;
  }
  
  private void b()
  {
    if (this.j > 0)
    {
      int m = 0;
      for (;;)
      {
        float[] arrayOfFloat = this.h;
        if (m >= arrayOfFloat.length) {
          break;
        }
        arrayOfFloat[m] = (this.j / 2.0F);
        m += 1;
      }
    }
  }
  
  private void setDefaultDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.j <= 0)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.saveLayer(this.e, null, 31);
    super.onDraw(paramCanvas);
    this.f.reset();
    this.g.reset();
    this.k.reset();
    this.g.addRoundRect(this.e, this.h, Path.Direction.CCW);
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setXfermode(this.i);
    if (Build.VERSION.SDK_INT <= 26)
    {
      paramCanvas.drawPath(this.g, this.f);
    }
    else
    {
      this.k.addRect(this.e, Path.Direction.CCW);
      this.k.op(this.g, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(this.k, this.f);
    }
    this.f.setXfermode(null);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void setApkIconAsyncImage(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = new File(paramString);
    if (((File)localObject).exists()) {}
    try
    {
      int m = getWidth();
      int n = getHeight();
      if ((m > 0) && (n > 0))
      {
        this.c = m;
        this.d = n;
      }
      setAdjustViewBounds(false);
      paramString = a(paramString, this.c, this.d, (File)localObject, false, true);
      if (paramString != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.c;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.d;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = 12.0F;
        paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        if (paramString != null)
        {
          setImageDrawable(paramString);
          return;
        }
        setDefaultDrawable(this.a);
        return;
      }
      setDefaultDrawable(this.a);
      return;
    }
    catch (Exception paramString)
    {
      label161:
      break label161;
    }
    setDefaultDrawable(this.a);
    return;
    setDefaultDrawable(this.a);
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.c = paramInt1;
    }
    if (paramInt2 > 0) {
      this.d = paramInt2;
    }
  }
  
  public void setAsyncImage(String paramString)
  {
    if (paramString == null) {
      return;
    }
    File localFile = new File(paramString);
    if (localFile.exists()) {}
    try
    {
      setAdjustViewBounds(false);
      paramString = a(paramString, this.c, this.d, localFile, false, false);
      if (paramString == null) {
        return;
      }
      paramString = URLDrawable.getDrawable(paramString, this.c, this.d, this.a, this.a, true);
      if (paramString == null)
      {
        setDefaultDrawable(this.a);
        return;
      }
      setImageDrawable(paramString);
      return;
    }
    catch (Exception paramString)
    {
      label88:
      break label88;
    }
    setDefaultDrawable(this.a);
    return;
    setDefaultDrawable(this.a);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.j = paramInt;
    a();
    b();
    invalidate();
  }
  
  public void setCornerRadius(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = 1;
    a();
    a(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.a = this.b.getResources().getDrawable(paramInt);
    setImageDrawable(this.a);
  }
  
  public void setHeight(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setUrlIconAsyncImage(String paramString)
  {
    if (paramString == null)
    {
      setDefaultDrawable(this.a);
      return;
    }
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), this.c, this.d, this.a, this.a, true);
      if (paramString == null)
      {
        setDefaultDrawable(this.a);
        return;
      }
      setImageDrawable(paramString);
      return;
    }
    catch (Exception paramString)
    {
      label61:
      break label61;
    }
    setDefaultDrawable(this.a);
  }
  
  public void setWidth(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */