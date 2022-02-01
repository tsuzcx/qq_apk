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
import blfw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends URLThemeImageView
{
  private int jdField_a_of_type_Int = 128;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int = 128;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private int c;
  
  public AsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RectFAsyncImageView);
    this.c = paramContext.getDimensionPixelOffset(0, 0);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    if (Build.VERSION.SDK_INT <= 26) {}
    for (this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);; this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT))
    {
      this.jdField_a_of_type_Blfw.a(blfw.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_ArrayOfFloat = new float[8];
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      a();
      c();
      paramContext.recycle();
      return;
    }
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
    long l = 0L;
    if (paramFile != null) {
      l = paramFile.lastModified();
    }
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    if (paramBoolean1)
    {
      paramString = paramString + "|1";
      if (!paramBoolean2) {
        break label174;
      }
      paramString = paramString + "|1";
      label111:
      if (!paramBoolean3) {
        break label197;
      }
    }
    for (paramString = paramString + "|1";; paramString = paramString + "|0")
    {
      try
      {
        paramString = new URL("fileassistantimage", "", paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        label174:
        label197:
        if (!QLog.isColorLevel()) {
          break label238;
        }
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
      paramString = paramString + "|0";
      break;
      paramString = paramString + "|0";
      break label111;
    }
    label238:
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public static boolean a(URL paramURL)
  {
    if (paramURL == null) {}
    for (;;)
    {
      return false;
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
      }
      catch (Exception paramURL) {}
    }
    return false;
  }
  
  private void c()
  {
    if (this.c > 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfFloat.length)
      {
        this.jdField_a_of_type_ArrayOfFloat[i] = (this.c / 2.0F);
        i += 1;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.c <= 0)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.saveLayer(this.jdField_a_of_type_AndroidGraphicsRectF, null, 31);
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CCW);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
    if (Build.VERSION.SDK_INT <= 26) {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.restore();
      return;
      this.jdField_b_of_type_AndroidGraphicsPath.addRect(this.jdField_a_of_type_AndroidGraphicsRectF, Path.Direction.CCW);
      this.jdField_b_of_type_AndroidGraphicsPath.op(this.jdField_a_of_type_AndroidGraphicsPath, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
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
    if (((File)localObject).exists())
    {
      try
      {
        int i = getWidth();
        int j = getHeight();
        if ((i > 0) && (j > 0))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_b_of_type_Int = j;
        }
        setAdjustViewBounds(false);
        paramString = a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (File)localObject, false, true);
        if (paramString == null) {
          break label162;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = 12.0F;
        paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        if (paramString != null)
        {
          setImageDrawable(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
      label162:
      a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (paramInt2 > 0) {
      this.jdField_b_of_type_Int = paramInt2;
    }
  }
  
  public void setAsyncImage(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      File localFile = new File(paramString);
      if (!localFile.exists()) {
        break label97;
      }
      try
      {
        setAdjustViewBounds(false);
        paramString = a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, localFile, false, false);
        if (paramString != null)
        {
          paramString = URLDrawable.getDrawable(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
          if (paramString == null)
          {
            a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
    }
    setImageDrawable(paramString);
    return;
    label97:
    a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.c = paramInt;
    a();
    c();
    invalidate();
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setUrlIconAsyncImage(String paramString)
  {
    if (paramString == null)
    {
      a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    try
    {
      paramString = new URL(paramString);
      if (paramString == null)
      {
        a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
    }
    catch (Exception paramString)
    {
      a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
    if (paramString == null)
    {
      a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    setImageDrawable(paramString);
  }
  
  public void setWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */