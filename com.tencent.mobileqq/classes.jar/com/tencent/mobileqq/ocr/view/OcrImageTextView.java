package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.OCRPerformUtil;
import com.tencent.mobileqq.ocr.OCRPerformUtil.TextWatcher;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.data.TranslateResult.Record;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.palette.Palette;
import com.tencent.mobileqq.utils.palette.Palette.Builder;
import com.tencent.mobileqq.utils.palette.Palette.Swatch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class OcrImageTextView
  extends ImageView
  implements OCRPerformUtil.TextWatcher
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private Runnable jdField_a_of_type_JavaLangRunnable = new OcrImageTextView.1(this);
  private List<OcrImageTextBean> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private List<OcrImageSectBean> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public OcrImageTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-38294);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(30.0F);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-38294);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(30.0F);
  }
  
  private float a(List<PicOcrResultBean> paramList)
  {
    paramList = paramList.iterator();
    float f1 = 0.0F;
    int i = 0;
    while (paramList.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)paramList.next();
      float f2 = OcrImageUtil.a(localPicOcrResultBean.a(this.jdField_a_of_type_Float), localPicOcrResultBean.b(this.jdField_b_of_type_Float), localPicOcrResultBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (f2 > 0.0F)
      {
        f1 += f2;
        i += 1;
      }
    }
    return f1 * 1.0F / i;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    paramBitmap = new StackBlurManager(paramBitmap);
    paramBitmap.setDbg(false);
    return paramBitmap.process(64);
  }
  
  private Bitmap a(Bitmap paramBitmap, Point paramPoint, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, String paramString)
  {
    if (paramBitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat1, paramFloat2);
    paramInt3 = paramInt1;
    try
    {
      if (paramPoint.x + paramInt1 > paramBitmap.getWidth()) {
        paramInt3 = paramBitmap.getWidth() - paramPoint.x;
      }
      paramInt1 = paramInt2;
      if (paramPoint.y + paramInt2 > paramBitmap.getHeight()) {
        paramInt1 = paramBitmap.getHeight() - paramPoint.y;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, paramPoint.x, paramPoint.y, paramInt3, paramInt1, localMatrix, false);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramPoint = new StringBuilder();
      paramPoint.append("cropBitmap error=");
      paramPoint.append(paramBitmap.getMessage());
      QLog.e("OcrImageTextView", 2, paramPoint.toString());
      OCRPerformUtil.a(0, paramString, "", "ocr_crop_back_img", paramBitmap.getMessage());
    }
    return null;
  }
  
  private Bitmap a(PicOcrResultBean paramPicOcrResultBean, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Point localPoint;
    if (paramBoolean) {
      localPoint = paramPicOcrResultBean.b();
    } else {
      localPoint = paramPicOcrResultBean.a();
    }
    paramPicOcrResultBean = a(this.jdField_a_of_type_AndroidGraphicsBitmap, localPoint, paramPicOcrResultBean.b(), paramPicOcrResultBean.c(), paramInt1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramString);
    if (paramPicOcrResultBean == null) {
      return null;
    }
    OCRPerformUtil.a(1, paramString, "", "ocr_crop_back_img", "");
    paramString = a(paramPicOcrResultBean);
    if ((paramPicOcrResultBean.getHeight() != paramInt3) || (paramPicOcrResultBean.getWidth() != paramInt2)) {
      paramPicOcrResultBean.recycle();
    }
    return paramString;
  }
  
  private StaticLayout a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramTextPaint != null))
    {
      if (paramInt <= 0) {
        return null;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), paramTextPaint, paramInt);
        paramCharSequence.setAlignment(Layout.Alignment.ALIGN_NORMAL);
        paramCharSequence.setLineSpacing(0.0F, 1.0F);
        paramCharSequence.setIncludePad(false);
        paramCharSequence.setEllipsize(null);
        return paramCharSequence.build();
      }
      return new StaticLayout(paramCharSequence, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    }
    return null;
  }
  
  private PicOcrRspResult a(PicOcrRspResult paramPicOcrRspResult, int paramInt)
  {
    Iterator localIterator = paramPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)localIterator.next();
      if (paramInt != paramPicOcrRspResult.jdField_a_of_type_Int)
      {
        float f2 = paramInt;
        float f1 = f2 / paramPicOcrRspResult.jdField_a_of_type_Int;
        if ((paramPicOcrRspResult.f == 90) || (paramPicOcrRspResult.f == 270)) {
          f1 = f2 / paramPicOcrRspResult.b;
        }
        localPicOcrResultBean.a(f1);
      }
    }
    return paramPicOcrRspResult;
  }
  
  private OcrImageSectBean a(List<PicOcrResultBean> paramList, String paramString)
  {
    Object localObject = null;
    PicOcrResultBean localPicOcrResultBean = null;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      Iterator localIterator = paramList.iterator();
      localObject = localPicOcrResultBean;
      while (localIterator.hasNext())
      {
        localPicOcrResultBean = (PicOcrResultBean)localIterator.next();
        if (localObject == null) {
          localObject = new OcrImageSectBean(localPicOcrResultBean);
        } else {
          ((OcrImageSectBean)localObject).a(localPicOcrResultBean);
        }
      }
      if (!TextUtils.isEmpty(paramString)) {
        ((OcrImageSectBean)localObject).jdField_a_of_type_JavaLangString = paramString;
      }
      ((OcrImageSectBean)localObject).jdField_b_of_type_Float = a(paramList);
      ((OcrImageSectBean)localObject).jdField_c_of_type_Float = paramList.size();
    }
    return localObject;
  }
  
  private List<OcrImageSectBean> a(List<PicOcrResultBean> paramList, TranslateResult paramTranslateResult)
  {
    if (paramTranslateResult.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (PicOcrResultBean)paramList.next();
      if (((PicOcrResultBean)localObject2).b != -1) {
        if (((Map)localObject1).containsKey(Integer.valueOf(((PicOcrResultBean)localObject2).b)))
        {
          ((List)((Map)localObject1).get(Integer.valueOf(((PicOcrResultBean)localObject2).b))).add(localObject2);
        }
        else
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((Map)localObject1).put(Integer.valueOf(((PicOcrResultBean)localObject2).b), localObject3);
        }
      }
    }
    paramList = new HashMap();
    paramTranslateResult = paramTranslateResult.jdField_a_of_type_JavaUtilList.iterator();
    while (paramTranslateResult.hasNext())
    {
      localObject2 = (TranslateResult.Record)paramTranslateResult.next();
      paramList.put(((TranslateResult.Record)localObject2).jdField_a_of_type_JavaLangString.replace(" ", ""), ((TranslateResult.Record)localObject2).b);
    }
    paramTranslateResult = new ArrayList();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (String)paramList.get(OcrImageUtil.a((List)((Map.Entry)localObject2).getValue()));
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = a((List)((Map.Entry)localObject2).getValue(), (String)localObject3);
        if (localObject2 != null) {
          paramTranslateResult.add(localObject2);
        }
      }
      else
      {
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (PicOcrResultBean)((Iterator)localObject2).next();
          String str = (String)paramList.get(((PicOcrResultBean)localObject3).jdField_a_of_type_JavaLangString.replace(" ", ""));
          localObject3 = a(Collections.singletonList(localObject3), str);
          if (localObject3 != null) {
            paramTranslateResult.add(localObject3);
          }
        }
      }
    }
    return paramTranslateResult;
  }
  
  private void a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = ScreenUtil.getRealWidth(getContext()) / i;
    i = (int)(j * f);
    super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(ScreenUtil.getRealWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        OcrImageTextBean localOcrImageTextBean = (OcrImageTextBean)((Iterator)localObject1).next();
        if ((localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          a(localOcrImageTextBean, localOcrImageTextBean.f, localOcrImageTextBean.g);
          localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localOcrImageTextBean.f, localOcrImageTextBean.g);
          Object localObject2 = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
          localOcrImageTextBean.j = (localOcrImageTextBean.g / 2 + (((Paint.FontMetricsInt)localObject2).bottom - ((Paint.FontMetricsInt)localObject2).top) / 2 - ((Paint.FontMetricsInt)localObject2).bottom);
          localObject2 = localOcrImageTextBean.a();
          paramCanvas.save();
          paramCanvas.translate(((Point)localObject2).x, ((Point)localObject2).y);
          paramCanvas.rotate(localOcrImageTextBean.jdField_a_of_type_Int);
          if (localOcrImageTextBean.d) {
            b(paramCanvas, localOcrImageTextBean);
          } else {
            a(paramCanvas, localOcrImageTextBean);
          }
          paramCanvas.restore();
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas, OcrImageTextBean paramOcrImageTextBean)
  {
    if (paramOcrImageTextBean.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
      paramCanvas.drawRect(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    else
    {
      paramCanvas.drawBitmap(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap, paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    int i;
    if (paramOcrImageTextBean.b) {
      i = -1;
    } else {
      i = -16777216;
    }
    localPaint.setColor(i);
    paramCanvas.drawText(paramOcrImageTextBean.jdField_a_of_type_JavaLangString, 0.0F, paramOcrImageTextBean.j, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(OcrImageSectBean paramOcrImageSectBean)
  {
    int i = 0;
    Object localObject = null;
    try
    {
      Palette localPalette = Palette.a(paramOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap).a();
      localObject = localPalette;
      Palette.Swatch localSwatch = localPalette.a();
      localObject = localPalette;
      if (localSwatch != null)
      {
        i = 1;
        localObject = localPalette;
      }
    }
    catch (Throwable localThrowable)
    {
      OCRPerformUtil.a(0, "ocr_palette_suc", localThrowable.getMessage());
    }
    if (i != 0)
    {
      localObject = ((Palette)localObject).a();
      paramOcrImageSectBean.g = (((Palette.Swatch)localObject).a() | 0xFF000000);
      paramOcrImageSectBean.h = (((Palette.Swatch)localObject).d() | 0xFF000000);
      paramOcrImageSectBean.d = true;
      OCRPerformUtil.a(1, "ocr_palette_suc", "");
      return;
    }
    paramOcrImageSectBean.jdField_c_of_type_Boolean = a(paramOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  private void a(OcrImageTextBean paramOcrImageTextBean)
  {
    if (paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    Object localObject = null;
    int i = 0;
    try
    {
      Palette localPalette = Palette.a(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap).a();
      localObject = localPalette;
      Palette.Swatch localSwatch = localPalette.a();
      localObject = localPalette;
      if (localSwatch != null)
      {
        i = 1;
        localObject = localPalette;
      }
    }
    catch (Throwable localThrowable)
    {
      OCRPerformUtil.a(0, "ocr_palette_suc", localThrowable.getMessage());
    }
    if (i != 0)
    {
      localObject = ((Palette)localObject).a();
      paramOcrImageTextBean.n = (((Palette.Swatch)localObject).a() | 0xFF000000);
      paramOcrImageTextBean.o = (((Palette.Swatch)localObject).d() | 0xFF000000);
      paramOcrImageTextBean.d = true;
      OCRPerformUtil.a(1, "ocr_palette_suc", "");
      return;
    }
    paramOcrImageTextBean.b = a(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  private void a(OcrImageTextBean paramOcrImageTextBean, int paramInt1, int paramInt2)
  {
    if ((paramOcrImageTextBean != null) && (!TextUtils.isEmpty(paramOcrImageTextBean.jdField_a_of_type_JavaLangString)) && (paramInt1 > 0))
    {
      if (paramOcrImageTextBean.jdField_a_of_type_Float > 0.0F)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramOcrImageTextBean.jdField_a_of_type_Float);
        return;
      }
      paramOcrImageTextBean.jdField_a_of_type_Float = OcrImageUtil.a(paramInt1, paramInt2, paramOcrImageTextBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPaint);
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramOcrImageTextBean.jdField_a_of_type_JavaLangString, 0, paramOcrImageTextBean.jdField_a_of_type_JavaLangString.length(), localRect);
      paramOcrImageTextBean.k = ((paramInt1 - localRect.width()) / 2);
      paramOcrImageTextBean.l = ((paramInt2 - localRect.height()) / 2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramOcrImageTextBean.jdField_a_of_type_Float);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(30.0F);
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getHeight() / 20;
    int k = 5;
    int j = i;
    if (i <= 0) {
      j = 5;
    }
    i = paramBitmap.getWidth() / 20;
    if (i > 0) {
      k = i;
    }
    long l6 = 0L;
    long l1 = l6;
    long l2 = l1;
    long l5 = l2;
    i = 0;
    long l3 = l2;
    long l4 = l1;
    l2 = l6;
    l1 = l5;
    while (i < paramBitmap.getHeight())
    {
      l5 = l2;
      l2 = l1;
      int m = 0;
      l1 = l5;
      while (m < paramBitmap.getWidth())
      {
        int n = paramBitmap.getPixel(m, i);
        l1 += 1L;
        l2 += Color.red(n);
        l4 += Color.green(n);
        l3 += Color.blue(n);
        m += k;
      }
      i += j;
      l5 = l1;
      l1 = l2;
      l2 = l5;
    }
    float f1 = (float)(l1 / l2);
    float f2 = (float)(l4 / l2);
    float f3 = (float)(l3 / l2);
    double d1 = f1;
    Double.isNaN(d1);
    double d2 = f2;
    Double.isNaN(d2);
    double d3 = f3;
    Double.isNaN(d3);
    return d1 * 0.299D + d2 * 0.578D + d3 * 0.114D < 90.0D;
  }
  
  private CharSequence b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      int i = -2;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        OcrImageTextBean localOcrImageTextBean = (OcrImageTextBean)localIterator.next();
        if (localOcrImageTextBean.jdField_a_of_type_Boolean) {
          if (i < 0)
          {
            ((StringBuilder)localObject).append(localOcrImageTextBean.jdField_a_of_type_JavaLangString.trim());
            i = localOcrImageTextBean.h;
          }
          else if (localOcrImageTextBean.h == i)
          {
            ((StringBuilder)localObject).append(localOcrImageTextBean.jdField_a_of_type_JavaLangString.trim());
          }
          else
          {
            ((StringBuilder)localObject).append("\n\n");
            ((StringBuilder)localObject).append(localOcrImageTextBean.jdField_a_of_type_JavaLangString.trim());
            i = localOcrImageTextBean.h;
          }
        }
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject1 = this.jdField_b_of_type_JavaUtilList;
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        OcrImageSectBean localOcrImageSectBean = (OcrImageSectBean)localIterator.next();
        if ((localOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (!TextUtils.isEmpty(localOcrImageSectBean.jdField_a_of_type_JavaLangString)) && (!localOcrImageSectBean.a()))
        {
          Rect localRect = localOcrImageSectBean.a();
          localObject1 = localOcrImageSectBean.a();
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("rect:");
            ((StringBuilder)localObject2).append(localRect.toShortString());
            ((StringBuilder)localObject2).append(", point:");
            ((StringBuilder)localObject2).append(((Point)localObject1).toString());
            QLog.i("OcrImageTextView", 2, ((StringBuilder)localObject2).toString());
          }
          paramCanvas.save();
          paramCanvas.translate(((Point)localObject1).x, ((Point)localObject1).y);
          paramCanvas.rotate(localOcrImageSectBean.jdField_a_of_type_Int);
          boolean bool = localOcrImageSectBean.d;
          int i = -15550475;
          if (bool)
          {
            localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint;
            if (!localOcrImageSectBean.jdField_a_of_type_Boolean) {
              i = localOcrImageSectBean.g;
            }
            ((Paint)localObject1).setColor(i);
            paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          else if (localOcrImageSectBean.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
            paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          else
          {
            paramCanvas.drawBitmap(localOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap, localRect, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          if (TextUtils.isEmpty(localOcrImageSectBean.jdField_a_of_type_JavaLangString))
          {
            paramCanvas.restore();
          }
          else
          {
            int j = Math.round(localOcrImageSectBean.jdField_a_of_type_Float);
            int k = localRect.width() - localOcrImageSectBean.j * 2;
            int m = localRect.height() - localOcrImageSectBean.i * 2;
            this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(j);
            this.jdField_a_of_type_AndroidTextTextPaint.setColor(localOcrImageSectBean.h);
            localObject2 = a(localOcrImageSectBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              paramCanvas.restore();
            }
            else
            {
              for (;;)
              {
                i = j;
                localObject2 = localObject1;
                if (((StaticLayout)localObject1).getHeight() >= m) {
                  break;
                }
                j += 1;
                if (j > 30)
                {
                  i = j;
                  localObject2 = localObject1;
                  break;
                }
                this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(j);
                StaticLayout localStaticLayout = a(localOcrImageSectBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
                i = j;
                localObject2 = localObject1;
                if (localStaticLayout == null) {
                  break;
                }
                if (localStaticLayout.getHeight() <= 0)
                {
                  i = j;
                  localObject2 = localObject1;
                  break;
                }
                localObject1 = localStaticLayout;
              }
              while (((StaticLayout)localObject2).getHeight() > m)
              {
                i -= 1;
                if (i < 5) {
                  break;
                }
                this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(i);
                localObject1 = a(localOcrImageSectBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
                if ((localObject1 == null) || (((StaticLayout)localObject1).getHeight() <= 0)) {
                  break;
                }
                localObject2 = localObject1;
              }
              i = localOcrImageSectBean.j;
              j = localRect.height() / 2;
              k = ((StaticLayout)localObject2).getHeight() / 2;
              paramCanvas.translate(i, j - k);
              ((StaticLayout)localObject2).draw(paramCanvas);
              paramCanvas.restore();
            }
          }
        }
      }
    }
  }
  
  private void b(Canvas paramCanvas, OcrImageTextBean paramOcrImageTextBean)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    int i;
    if (paramOcrImageTextBean.jdField_a_of_type_Boolean) {
      i = -15550475;
    } else {
      i = paramOcrImageTextBean.n;
    }
    localPaint.setColor(i);
    paramCanvas.drawRect(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramOcrImageTextBean.o);
    paramCanvas.drawText(paramOcrImageTextBean.jdField_a_of_type_JavaLangString, 0.0F, paramOcrImageTextBean.j, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private CharSequence c()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        OcrImageSectBean localOcrImageSectBean = (OcrImageSectBean)localIterator.next();
        if (localOcrImageSectBean.jdField_a_of_type_Boolean)
        {
          ((StringBuilder)localObject).append(localOcrImageSectBean.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("\n\n");
        }
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private boolean c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((OcrImageTextBean)((Iterator)localObject).next()).jdField_a_of_type_Boolean) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean d()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((OcrImageSectBean)((Iterator)localObject).next()).jdField_a_of_type_Boolean) {
          return true;
        }
      }
    }
    return false;
  }
  
  public CharSequence a()
  {
    if (OCRPerformUtil.jdField_a_of_type_Boolean) {
      return c();
    }
    return b();
  }
  
  public List<OcrImageTextBean> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (OcrImageTextBean)localIterator.next();
        if ((localObject2 != null) && (((OcrImageTextBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          ((OcrImageTextBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          ((OcrImageTextBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (OcrImageSectBean)localIterator.next();
        if ((localObject2 != null) && (((OcrImageSectBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          ((OcrImageSectBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          ((OcrImageSectBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = OCRPerformUtil.a(getDrawable());
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_b_of_type_Float <= paramInt;
  }
  
  public List<OcrImageSectBean> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public boolean b()
  {
    if (OCRPerformUtil.jdField_a_of_type_Boolean) {
      return d();
    }
    return c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a())
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        return;
      }
      paramCanvas.save();
      paramCanvas.translate(0.0F, 0.0F);
      paramCanvas.restore();
      if (OCRPerformUtil.jdField_a_of_type_Boolean)
      {
        b(paramCanvas);
        return;
      }
      a(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((getDrawable() != null) && (((BitmapDrawable)getDrawable()).getBitmap() != null))
    {
      Bitmap localBitmap = OCRPerformUtil.a(getDrawable());
      if (localBitmap == null)
      {
        super.setMeasuredDimension(paramInt1, paramInt2);
        return;
      }
      a(localBitmap);
      return;
    }
    super.setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setResultNormal(PicOcrRspResult paramPicOcrRspResult)
  {
    if (paramPicOcrRspResult != null) {
      try
      {
        if ((paramPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList != null) && (!paramPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
        {
          boolean bool = getDrawable() instanceof BitmapDrawable;
          if (!bool) {
            return;
          }
          a();
          if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = OCRPerformUtil.a(getDrawable());
            float f = ScreenUtil.getRealWidth(getContext()) / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
            this.jdField_a_of_type_Float = f;
            this.jdField_b_of_type_Float = f;
          }
          this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
          ThreadManager.getSubThreadHandler().post(new OcrImageTextView.2(this, paramPicOcrRspResult));
          return;
        }
      }
      finally {}
    }
  }
  
  public void setResultSection(TranslateResult paramTranslateResult)
  {
    if (paramTranslateResult != null) {
      try
      {
        if ((paramTranslateResult.jdField_a_of_type_JavaUtilList != null) && (!paramTranslateResult.jdField_a_of_type_JavaUtilList.isEmpty()))
        {
          PicOcrRspResult localPicOcrRspResult = OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult;
          if ((localPicOcrRspResult != null) && (!localPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
          {
            boolean bool = getDrawable() instanceof BitmapDrawable;
            if (!bool) {
              return;
            }
            a();
            if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
            {
              this.jdField_a_of_type_AndroidGraphicsBitmap = OCRPerformUtil.a(getDrawable());
              float f = ScreenUtil.getRealWidth(getContext()) / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
              this.jdField_a_of_type_Float = f;
              this.jdField_b_of_type_Float = f;
            }
            this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
            ThreadManager.getSubThreadHandler().post(new OcrImageTextView.3(this, localPicOcrRspResult, paramTranslateResult));
            return;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void setShowTextMask(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView
 * JD-Core Version:    0.7.0.1
 */