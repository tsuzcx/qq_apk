package com.tencent.mobileqq.vas.qid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vas.util.NinePatchUtil;
import com.tencent.mobileqq.vas.util.NinePatchUtil.NinePatchParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class QidPagView
  extends VasPagView
{
  private static final float b = (float)DeviceInfoUtil.D() / 750.0F;
  public boolean a = false;
  private QidPagView.QidData c;
  private int e;
  private PAGView f;
  
  public QidPagView(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QidPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QidPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = new Canvas(paramBitmap);
      paramDrawable.setBounds(0, 0, paramInt2, paramInt3);
      if (paramInt1 == 3) {
        paramDrawable.setColorFilter(this.c.j, PorterDuff.Mode.SRC_ATOP);
      }
      paramDrawable.draw(paramBitmap);
      if (this.a) {
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private void a(PAGFile paramPAGFile, int paramInt, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = PAGImage.FromBitmap(paramBitmap);
      if (paramInt == 1) {
        paramBitmap.setScaleMode(1);
      }
      paramPAGFile.replaceImage(paramInt, paramBitmap);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramPAGFile = new StringBuilder();
      paramPAGFile.append("QID_QR,replaceImage bitmap is empty ");
      paramPAGFile.append(paramInt);
      QLog.d("QidPagView", 2, paramPAGFile.toString());
    }
  }
  
  private void a(PAGFile paramPAGFile, int paramInt, Drawable paramDrawable)
  {
    a(paramPAGFile, paramInt, a(paramDrawable, paramInt));
  }
  
  private void a(PAGFile paramPAGFile, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, null);
    if (paramString.getStatus() == 1)
    {
      a(paramPAGFile, paramInt, paramString);
      return;
    }
    paramString.setURLDrawableListener(new QidPagView.2(this, paramPAGFile, paramInt));
    paramString.startDownload();
  }
  
  private void a(PAGView paramPAGView)
  {
    this.f = paramPAGView;
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    if (TextUtils.isEmpty(((QidPagView.QidData)localObject).a)) {
      return;
    }
    paramPAGView.setScaleMode(3);
    localObject = QidCardManager.b(this.c.a);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidPagView", 1, "QID_QR, localFile,empty ");
      }
      return;
    }
    localObject = PAGFile.Load(((File)localObject).getAbsolutePath());
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidPagView", 1, "QID_QR, pagFile,empty ");
      }
      return;
    }
    if (((PAGFile)localObject).numTexts() > 2)
    {
      PAGText localPAGText = ((PAGFile)localObject).getTextData(0);
      localPAGText.text = this.c.g;
      localPAGText.fontFamily = "monospace";
      ((PAGFile)localObject).replaceText(0, localPAGText);
      if (!TextUtils.isEmpty(localPAGText.text))
      {
        TextPaint localTextPaint = new TextPaint();
        localTextPaint.setTextSize(localPAGText.fontSize * b);
        this.e = ((int)Layout.getDesiredWidth(localPAGText.text, localTextPaint));
      }
      localPAGText = ((PAGFile)localObject).getTextData(1);
      localPAGText.text = this.c.h;
      ((PAGFile)localObject).replaceText(1, localPAGText);
      localPAGText = ((PAGFile)localObject).getTextData(2);
      localPAGText.text = this.c.i;
      ((PAGFile)localObject).replaceText(2, localPAGText);
    }
    if (((PAGFile)localObject).numImages() > 4)
    {
      a((PAGFile)localObject, 1, this.c.c);
      a((PAGFile)localObject, 2, this.c.e);
      a((PAGFile)localObject, 3, this.c.f);
      b((PAGFile)localObject, 4, this.c.d);
    }
    paramPAGView.setComposition((PAGComposition)localObject);
    paramPAGView.setRepeatCount(0);
    paramPAGView.play();
  }
  
  private void b(PAGFile paramPAGFile, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = URLDrawable.getDrawable(((StringBuilder)localObject).toString(), null);
    ((URLDrawable)localObject).setURLDrawableListener(new QidPagView.3(this, paramPAGFile, paramInt, paramString));
    ((URLDrawable)localObject).startDownload();
  }
  
  Bitmap a(Drawable paramDrawable, int paramInt)
  {
    Object localObject2 = null;
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramInt != 3) {
        return localObject1;
      }
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Object localObject1 = localObject2;
    if (i > 0)
    {
      if (j <= 0) {
        return null;
      }
      if (paramInt == 1)
      {
        float f1 = b;
        paramInt = (int)(603.0F * f1);
        i = (int)(71.0F * f1);
        Rect localRect = new Rect((int)(40.0F * f1), 2, (int)(this.e + f1 * 205.0F) * 2, i);
        if (!(paramDrawable instanceof URLDrawable)) {
          return null;
        }
        paramDrawable = ((URLDrawable)paramDrawable).getCurrDrawable();
        if (!(paramDrawable instanceof RegionDrawable)) {
          return null;
        }
        paramDrawable = ((RegionDrawable)paramDrawable).getBitmap();
        localObject1 = localObject2;
        if (paramDrawable == null) {
          break label236;
        }
        return NinePatchUtil.a(paramDrawable, new NinePatchUtil.NinePatchParams(paramInt * 2, i, paramDrawable.getWidth() / 2, 1, paramDrawable.getHeight() / 2, 1), localRect);
      }
    }
    try
    {
      if (paramDrawable.getOpacity() != -1) {
        localObject1 = Bitmap.Config.ARGB_8888;
      } else {
        localObject1 = Bitmap.Config.RGB_565;
      }
      localObject1 = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject1);
      a(paramDrawable, paramInt, i, j, (Bitmap)localObject1);
      label236:
      return localObject1;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  public void a()
  {
    QidPagView.QidData localQidData = this.c;
    if ((localQidData != null) && (localQidData.f != null)) {
      this.c.f.clearColorFilter();
    }
  }
  
  public void a(int paramInt)
  {
    QidPagView.QidData localQidData = this.c;
    if ((localQidData != null) && (localQidData.f != null)) {
      this.c.f.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public void a(QidPagView.QidData paramQidData)
  {
    if (paramQidData == null) {
      return;
    }
    g().a();
    this.c = paramQidData;
    g().a(new QidPagView.1(this));
  }
  
  public Bitmap getBitmap()
  {
    PAGView localPAGView = this.f;
    if (localPAGView != null)
    {
      localPAGView.flush(true);
      return this.f.getBitmap();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidPagView
 * JD-Core Version:    0.7.0.1
 */