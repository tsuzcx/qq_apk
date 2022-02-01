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
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class QidPagView
  extends VasPagView
{
  private static final float jdField_a_of_type_Float = (float)DeviceInfoUtil.i() / 750.0F;
  private int jdField_a_of_type_Int;
  private QidPagView.QidData jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  public boolean a;
  
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
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = new Canvas(paramBitmap);
      paramDrawable.setBounds(0, 0, paramInt2, paramInt3);
      if (paramInt1 == 3) {
        paramDrawable.setColorFilter(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
      }
      paramDrawable.draw(paramBitmap);
      if (this.jdField_a_of_type_Boolean) {
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private void a(PAGView paramPAGView)
  {
    this.jdField_a_of_type_OrgLibpagPAGView = paramPAGView;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData;
    if (localObject == null) {
      return;
    }
    if (TextUtils.isEmpty(((QidPagView.QidData)localObject).jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramPAGView.setScaleMode(3);
    localObject = QidCardManager.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_JavaLangString);
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
      localPAGText.text = this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.e;
      localPAGText.fontFamily = "monospace";
      paramPAGView.setTextData(0, localPAGText);
      if (!TextUtils.isEmpty(localPAGText.text))
      {
        TextPaint localTextPaint = new TextPaint();
        localTextPaint.setTextSize(localPAGText.fontSize * jdField_a_of_type_Float);
        this.jdField_a_of_type_Int = ((int)Layout.getDesiredWidth(localPAGText.text, localTextPaint));
      }
      localPAGText = ((PAGFile)localObject).getTextData(1);
      localPAGText.text = this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.f;
      paramPAGView.setTextData(1, localPAGText);
      localPAGText = ((PAGFile)localObject).getTextData(2);
      localPAGText.text = this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.g;
      paramPAGView.setTextData(2, localPAGText);
    }
    if (((PAGFile)localObject).numImages() > 4)
    {
      a(paramPAGView, 1, this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.c);
      a(paramPAGView, 2, this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsBitmap);
      a(paramPAGView, 3, this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      b(paramPAGView, 4, this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.d);
    }
    paramPAGView.setFile((PAGFile)localObject);
    paramPAGView.setRepeatCount(0);
    paramPAGView.play();
  }
  
  private void a(PAGView paramPAGView, int paramInt, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = PAGImage.FromBitmap(paramBitmap);
      if (paramInt == 1) {
        paramBitmap.setScaleMode(1);
      }
      paramPAGView.replaceImage(paramInt, paramBitmap);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramPAGView = new StringBuilder();
      paramPAGView.append("QID_QR,replaceImage bitmap is empty ");
      paramPAGView.append(paramInt);
      QLog.d("QidPagView", 2, paramPAGView.toString());
    }
  }
  
  private void a(PAGView paramPAGView, int paramInt, Drawable paramDrawable)
  {
    a(paramPAGView, paramInt, a(paramDrawable, paramInt));
  }
  
  private void a(PAGView paramPAGView, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, null);
    if (paramString.getStatus() == 1)
    {
      a(paramPAGView, paramInt, paramString);
      return;
    }
    paramString.setURLDrawableListener(new QidPagView.2(this, paramPAGView, paramInt));
    paramString.startDownload();
  }
  
  private void b(PAGView paramPAGView, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = URLDrawable.getDrawable(((StringBuilder)localObject).toString(), null);
    ((URLDrawable)localObject).setURLDrawableListener(new QidPagView.3(this, paramPAGView, paramInt, paramString));
    ((URLDrawable)localObject).startDownload();
  }
  
  public Bitmap a()
  {
    PAGView localPAGView = this.jdField_a_of_type_OrgLibpagPAGView;
    if (localPAGView != null)
    {
      localPAGView.flush(true);
      return this.jdField_a_of_type_OrgLibpagPAGView.getBitmap();
    }
    return null;
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
        float f = jdField_a_of_type_Float;
        paramInt = (int)(603.0F * f);
        i = (int)(71.0F * f);
        Rect localRect = new Rect((int)(40.0F * f), 2, (int)(this.jdField_a_of_type_Int + f * 205.0F) * 2, i);
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
    QidPagView.QidData localQidData = this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData;
    if ((localQidData != null) && (localQidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable.clearColorFilter();
    }
  }
  
  public void a(int paramInt)
  {
    QidPagView.QidData localQidData = this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData;
    if ((localQidData != null) && (localQidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public void a(QidPagView.QidData paramQidData)
  {
    if (paramQidData == null) {
      return;
    }
    a().a();
    this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData = paramQidData;
    a().a(new QidPagView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidPagView
 * JD-Core Version:    0.7.0.1
 */