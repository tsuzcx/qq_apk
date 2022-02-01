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
  
  private void a(PAGView paramPAGView)
  {
    this.jdField_a_of_type_OrgLibpagPAGView = paramPAGView;
    if (this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_JavaLangString));
        paramPAGView.setScaleMode(3);
        localObject = QidCardManager.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QidPagView", 1, "QID_QR, localFile,empty ");
      return;
      localObject = PAGFile.Load(((File)localObject).getAbsolutePath());
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QidPagView", 1, "QID_QR, pagFile,empty ");
    return;
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
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QidPagView", 2, "QID_QR,replaceImage bitmap is empty " + paramInt);
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
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString + "?" + System.currentTimeMillis(), null);
    localURLDrawable.setURLDrawableListener(new QidPagView.3(this, paramPAGView, paramInt, paramString));
    localURLDrawable.startDownload();
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_OrgLibpagPAGView != null)
    {
      this.jdField_a_of_type_OrgLibpagPAGView.flush(true);
      return this.jdField_a_of_type_OrgLibpagPAGView.getBitmap();
    }
    return null;
  }
  
  Bitmap a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {}
    Object localObject1;
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return null;
          if ((paramDrawable instanceof BitmapDrawable))
          {
            localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
            if (paramInt != 3) {
              return localObject1;
            }
          }
          i = paramDrawable.getIntrinsicWidth();
          j = paramDrawable.getIntrinsicHeight();
        } while ((i <= 0) || (j <= 0));
        if (paramInt != 1) {
          break;
        }
        paramInt = (int)(603.0F * jdField_a_of_type_Float);
        i = (int)(71.0F * jdField_a_of_type_Float);
        localObject1 = new Rect((int)(40.0F * jdField_a_of_type_Float), 2, (int)(this.jdField_a_of_type_Int + 205.0F * jdField_a_of_type_Float) * 2, i);
      } while (!(paramDrawable instanceof URLDrawable));
      paramDrawable = ((URLDrawable)paramDrawable).getCurrDrawable();
    } while (!(paramDrawable instanceof RegionDrawable));
    paramDrawable = ((RegionDrawable)paramDrawable).getBitmap();
    if (paramDrawable != null) {
      return NinePatchUtil.a(paramDrawable, new NinePatchUtil.NinePatchParams(paramInt * 2, i, paramDrawable.getWidth() / 2, 1, paramDrawable.getHeight() / 2, 1), (Rect)localObject1);
    }
    Object localObject2 = null;
    for (;;)
    {
      return localObject2;
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (localObject1 = Bitmap.Config.ARGB_8888;; localObject1 = Bitmap.Config.RGB_565)
        {
          localObject1 = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject1);
          localObject2 = localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject2 = new Canvas((Bitmap)localObject1);
          paramDrawable.setBounds(0, 0, i, j);
          if (paramInt == 3) {
            paramDrawable.setColorFilter(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
          }
          paramDrawable.draw((Canvas)localObject2);
          localObject2 = localObject1;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          paramDrawable.clearColorFilter();
          localObject2 = localObject1;
          break;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData != null) && (this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable.clearColorFilter();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData != null) && (this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public void a(QidPagView.QidData paramQidData)
  {
    if (paramQidData == null) {
      return;
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData = paramQidData;
    a(new QidPagView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidPagView
 * JD-Core Version:    0.7.0.1
 */