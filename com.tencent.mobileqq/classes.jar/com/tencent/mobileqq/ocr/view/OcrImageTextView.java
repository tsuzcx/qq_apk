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
    int i = 0;
    float f1 = 0.0F;
    if (paramList.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)paramList.next();
      float f2 = OcrImageUtil.a(localPicOcrResultBean.a(this.jdField_a_of_type_Float), localPicOcrResultBean.b(this.jdField_b_of_type_Float), localPicOcrResultBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (f2 <= 0.0F) {
        break label90;
      }
      i += 1;
      f1 += f2;
    }
    label90:
    for (;;)
    {
      break;
      return 1.0F * f1 / i;
    }
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
    label142:
    for (;;)
    {
      try
      {
        if (paramPoint.x + paramInt1 <= paramBitmap.getWidth()) {
          break label142;
        }
        paramInt1 = paramBitmap.getWidth() - paramPoint.x;
        if (paramPoint.y + paramInt2 > paramBitmap.getHeight())
        {
          paramInt2 = paramBitmap.getHeight() - paramPoint.y;
          paramBitmap = Bitmap.createBitmap(paramBitmap, paramPoint.x, paramPoint.y, paramInt1, paramInt2, localMatrix, false);
          return paramBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("OcrImageTextView", 2, "cropBitmap error=" + paramBitmap.getMessage());
        OCRPerformUtil.a(0, paramString, "", "ocr_crop_back_img", paramBitmap.getMessage());
        return null;
      }
    }
  }
  
  private Bitmap a(PicOcrResultBean paramPicOcrResultBean, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramPicOcrResultBean.b();
      localObject = a(this.jdField_a_of_type_AndroidGraphicsBitmap, (Point)localObject, paramPicOcrResultBean.b(), paramPicOcrResultBean.c(), paramInt1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramString);
      if (localObject != null) {
        break label59;
      }
      paramPicOcrResultBean = null;
    }
    label59:
    do
    {
      return paramPicOcrResultBean;
      localObject = paramPicOcrResultBean.a();
      break;
      OCRPerformUtil.a(1, paramString, "", "ocr_crop_back_img", "");
      paramString = a((Bitmap)localObject);
      if (((Bitmap)localObject).getHeight() != paramInt3) {
        break label102;
      }
      paramPicOcrResultBean = paramString;
    } while (((Bitmap)localObject).getWidth() == paramInt2);
    label102:
    ((Bitmap)localObject).recycle();
    return paramString;
  }
  
  private StaticLayout a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramTextPaint == null) || (paramInt <= 0)) {
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
  
  private PicOcrRspResult a(PicOcrRspResult paramPicOcrRspResult, int paramInt)
  {
    Iterator localIterator = paramPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)localIterator.next();
      if (paramInt != paramPicOcrRspResult.jdField_a_of_type_Int)
      {
        float f = paramInt / paramPicOcrRspResult.jdField_a_of_type_Int;
        if ((paramPicOcrRspResult.f == 90) || (paramPicOcrRspResult.f == 270)) {
          f = paramInt / paramPicOcrRspResult.b;
        }
        localPicOcrResultBean.a(f);
      }
    }
    return paramPicOcrRspResult;
  }
  
  private OcrImageSectBean a(List<PicOcrResultBean> paramList, String paramString)
  {
    OcrImageSectBean localOcrImageSectBean = null;
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)localIterator.next();
      if (localOcrImageSectBean == null) {
        localOcrImageSectBean = new OcrImageSectBean(localPicOcrResultBean);
      }
      for (;;)
      {
        break;
        localOcrImageSectBean.a(localPicOcrResultBean);
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      localOcrImageSectBean.jdField_a_of_type_JavaLangString = paramString;
    }
    localOcrImageSectBean.jdField_b_of_type_Float = a(paramList);
    localOcrImageSectBean.jdField_c_of_type_Float = paramList.size();
    return localOcrImageSectBean;
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
    i = (int)(ScreenUtil.getRealWidth(getContext()) / i * j);
    super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(ScreenUtil.getRealWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label30:
    OcrImageTextBean localOcrImageTextBean;
    while (localIterator.hasNext())
    {
      localOcrImageTextBean = (OcrImageTextBean)localIterator.next();
      if ((localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        a(localOcrImageTextBean, localOcrImageTextBean.f, localOcrImageTextBean.g);
        localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localOcrImageTextBean.f, localOcrImageTextBean.g);
        Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
        localOcrImageTextBean.j = (localOcrImageTextBean.g / 2 + (((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2 - ((Paint.FontMetricsInt)localObject).bottom);
        localObject = localOcrImageTextBean.a();
        paramCanvas.save();
        paramCanvas.translate(((Point)localObject).x, ((Point)localObject).y);
        paramCanvas.rotate(localOcrImageTextBean.jdField_a_of_type_Int);
        if (!localOcrImageTextBean.d) {
          break label191;
        }
        b(paramCanvas, localOcrImageTextBean);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      break label30;
      break;
      label191:
      a(paramCanvas, localOcrImageTextBean);
    }
  }
  
  private void a(Canvas paramCanvas, OcrImageTextBean paramOcrImageTextBean)
  {
    Paint localPaint;
    if (paramOcrImageTextBean.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
      paramCanvas.drawRect(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (!paramOcrImageTextBean.b) {
        break label92;
      }
    }
    label92:
    for (int i = -1;; i = -16777216)
    {
      localPaint.setColor(i);
      paramCanvas.drawText(paramOcrImageTextBean.jdField_a_of_type_JavaLangString, 0.0F, paramOcrImageTextBean.j, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      paramCanvas.drawBitmap(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap, paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
    }
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
      for (;;)
      {
        OCRPerformUtil.a(0, "ocr_palette_suc", localThrowable.getMessage());
      }
      paramOcrImageSectBean.jdField_c_of_type_Boolean = a(paramOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap);
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
  }
  
  private void a(OcrImageTextBean paramOcrImageTextBean)
  {
    int i = 0;
    if (paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    Object localObject = null;
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
      for (;;)
      {
        OCRPerformUtil.a(0, "ocr_palette_suc", localThrowable.getMessage());
      }
      paramOcrImageTextBean.b = a(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap);
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
  }
  
  private void a(OcrImageTextBean paramOcrImageTextBean, int paramInt1, int paramInt2)
  {
    if ((paramOcrImageTextBean == null) || (TextUtils.isEmpty(paramOcrImageTextBean.jdField_a_of_type_JavaLangString)) || (paramInt1 <= 0))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(30.0F);
      return;
    }
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
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    long l4 = 0L;
    int j = paramBitmap.getHeight() / 20;
    int i = j;
    if (j <= 0) {
      i = 5;
    }
    int k = paramBitmap.getWidth() / 20;
    j = k;
    if (k <= 0) {
      j = 5;
    }
    k = 0;
    while (k < paramBitmap.getHeight())
    {
      int m = 0;
      while (m < paramBitmap.getWidth())
      {
        int n = paramBitmap.getPixel(m, k);
        l4 += 1L;
        l3 += Color.red(n);
        l2 += Color.green(n);
        l1 += Color.blue(n);
        m += j;
      }
      k += i;
    }
    float f1 = (float)(l3 / l4);
    float f2 = (float)(l2 / l4);
    float f3 = (float)(l1 / l4);
    double d = f1;
    return f2 * 0.578D + d * 0.299D + f3 * 0.114D < 90.0D;
  }
  
  private CharSequence b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = -2;
    OcrImageTextBean localOcrImageTextBean;
    if (localIterator.hasNext())
    {
      localOcrImageTextBean = (OcrImageTextBean)localIterator.next();
      if (!localOcrImageTextBean.jdField_a_of_type_Boolean) {
        break label155;
      }
      if (i < 0)
      {
        localStringBuilder.append(localOcrImageTextBean.jdField_a_of_type_JavaLangString.trim());
        i = localOcrImageTextBean.h;
      }
    }
    label155:
    for (;;)
    {
      break;
      if (localOcrImageTextBean.h == i)
      {
        localStringBuilder.append(localOcrImageTextBean.jdField_a_of_type_JavaLangString.trim());
      }
      else
      {
        localStringBuilder.append("\n\n").append(localOcrImageTextBean.jdField_a_of_type_JavaLangString.trim());
        i = localOcrImageTextBean.h;
        continue;
        return localStringBuilder.toString();
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    label31:
    OcrImageSectBean localOcrImageSectBean;
    Rect localRect;
    Object localObject1;
    int i;
    label212:
    int k;
    label306:
    int m;
    Object localObject2;
    label399:
    StaticLayout localStaticLayout;
    int j;
    while (localIterator.hasNext())
    {
      localOcrImageSectBean = (OcrImageSectBean)localIterator.next();
      if ((localOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (!TextUtils.isEmpty(localOcrImageSectBean.jdField_a_of_type_JavaLangString)) && (!localOcrImageSectBean.a()))
      {
        localRect = localOcrImageSectBean.a();
        localObject1 = localOcrImageSectBean.a();
        if (QLog.isColorLevel()) {
          QLog.i("OcrImageTextView", 2, "rect:" + localRect.toShortString() + ", point:" + ((Point)localObject1).toString());
        }
        paramCanvas.save();
        paramCanvas.translate(((Point)localObject1).x, ((Point)localObject1).y);
        paramCanvas.rotate(localOcrImageSectBean.jdField_a_of_type_Int);
        if (localOcrImageSectBean.d)
        {
          localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint;
          if (localOcrImageSectBean.jdField_a_of_type_Boolean)
          {
            i = -15550475;
            ((Paint)localObject1).setColor(i);
            paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(localOcrImageSectBean.jdField_a_of_type_JavaLangString)) {
            break label306;
          }
          paramCanvas.restore();
          break;
          i = localOcrImageSectBean.g;
          break label212;
          if (localOcrImageSectBean.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
            paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          else
          {
            paramCanvas.drawBitmap(localOcrImageSectBean.jdField_a_of_type_AndroidGraphicsBitmap, localRect, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
        i = Math.round(localOcrImageSectBean.jdField_a_of_type_Float);
        k = localRect.width() - localOcrImageSectBean.j * 2;
        m = localRect.height() - localOcrImageSectBean.i * 2;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(i);
        this.jdField_a_of_type_AndroidTextTextPaint.setColor(localOcrImageSectBean.h);
        localObject2 = a(localOcrImageSectBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          paramCanvas.restore();
          continue;
          localObject1 = localStaticLayout;
          i = j;
        }
        else
        {
          if (((StaticLayout)localObject1).getHeight() >= m) {
            break label597;
          }
          j = i + 1;
          if (j <= 30) {
            break label497;
          }
          i = j;
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      label431:
      if (((StaticLayout)localObject2).getHeight() > m)
      {
        i -= 1;
        if (i >= 5) {
          break label551;
        }
      }
      label497:
      do
      {
        i = localOcrImageSectBean.j;
        j = localRect.height() / 2;
        k = ((StaticLayout)localObject2).getHeight() / 2;
        paramCanvas.translate(i, j - k);
        ((StaticLayout)localObject2).draw(paramCanvas);
        paramCanvas.restore();
        break label31;
        break;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(j);
        localStaticLayout = a(localOcrImageSectBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
        localObject2 = localObject1;
        i = j;
        if (localStaticLayout == null) {
          break label431;
        }
        if (localStaticLayout.getHeight() > 0) {
          break label399;
        }
        localObject2 = localObject1;
        i = j;
        break label431;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(i);
        localObject1 = a(localOcrImageSectBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
      } while ((localObject1 == null) || (((StaticLayout)localObject1).getHeight() <= 0));
      label551:
      localObject2 = localObject1;
      continue;
      label597:
      localObject2 = localObject1;
    }
  }
  
  private void b(Canvas paramCanvas, OcrImageTextBean paramOcrImageTextBean)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (paramOcrImageTextBean.jdField_a_of_type_Boolean) {}
    for (int i = -15550475;; i = paramOcrImageTextBean.n)
    {
      localPaint.setColor(i);
      paramCanvas.drawRect(paramOcrImageTextBean.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramOcrImageTextBean.o);
      paramCanvas.drawText(paramOcrImageTextBean.jdField_a_of_type_JavaLangString, 0.0F, paramOcrImageTextBean.j, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  private CharSequence c()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      OcrImageSectBean localOcrImageSectBean = (OcrImageSectBean)localIterator.next();
      if (localOcrImageSectBean.jdField_a_of_type_Boolean) {
        localStringBuilder.append(localOcrImageSectBean.jdField_a_of_type_JavaLangString).append("\n\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((OcrImageTextBean)localIterator.next()).jdField_a_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  private boolean d()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((OcrImageSectBean)localIterator.next()).jdField_a_of_type_Boolean) {
        return true;
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
    Object localObject2;
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = (OcrImageTextBean)localIterator1.next();
        if ((localObject2 != null) && (((OcrImageTextBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          ((OcrImageTextBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          ((OcrImageTextBean)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    finally {}
    Iterator localIterator2 = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (OcrImageSectBean)localIterator2.next();
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
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public boolean b()
  {
    if (OCRPerformUtil.jdField_a_of_type_Boolean) {
      return d();
    }
    return c();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!a()) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
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
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((getDrawable() == null) || (((BitmapDrawable)getDrawable()).getBitmap() == null))
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    Bitmap localBitmap = OCRPerformUtil.a(getDrawable());
    if (localBitmap == null)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    a(localBitmap);
  }
  
  /* Error */
  public void setResultNormal(PicOcrRspResult paramPicOcrRspResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +22 -> 25
    //   6: aload_1
    //   7: getfield 289	com/tencent/mobileqq/gallery/picocr/PicOcrRspResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10: ifnull +15 -> 25
    //   13: aload_1
    //   14: getfield 289	com/tencent/mobileqq/gallery/picocr/PicOcrRspResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: invokevirtual 689	java/util/ArrayList:isEmpty	()Z
    //   20: istore_3
    //   21: iload_3
    //   22: ifeq +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokevirtual 661	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   32: instanceof 680
    //   35: ifeq -10 -> 25
    //   38: aload_0
    //   39: invokevirtual 691	com/tencent/mobileqq/ocr/view/OcrImageTextView:a	()V
    //   42: aload_0
    //   43: getfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   46: ifnonnull +42 -> 88
    //   49: aload_0
    //   50: aload_0
    //   51: invokevirtual 661	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   54: invokestatic 664	com/tencent/mobileqq/ocr/OCRPerformUtil:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   57: putfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   60: aload_0
    //   61: invokevirtual 401	com/tencent/mobileqq/ocr/view/OcrImageTextView:getContext	()Landroid/content/Context;
    //   64: invokestatic 407	com/tencent/mobileqq/shortvideo/util/ScreenUtil:getRealWidth	(Landroid/content/Context;)I
    //   67: i2f
    //   68: aload_0
    //   69: getfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   72: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   75: i2f
    //   76: fdiv
    //   77: fstore_2
    //   78: aload_0
    //   79: fload_2
    //   80: putfield 86	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Float	F
    //   83: aload_0
    //   84: fload_2
    //   85: putfield 110	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_b_of_type_Float	F
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   93: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   96: putfield 125	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Int	I
    //   99: invokestatic 694	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   102: new 696	com/tencent/mobileqq/ocr/view/OcrImageTextView$2
    //   105: dup
    //   106: aload_0
    //   107: aload_1
    //   108: invokespecial 699	com/tencent/mobileqq/ocr/view/OcrImageTextView$2:<init>	(Lcom/tencent/mobileqq/ocr/view/OcrImageTextView;Lcom/tencent/mobileqq/gallery/picocr/PicOcrRspResult;)V
    //   111: invokevirtual 703	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   114: pop
    //   115: goto -90 -> 25
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	OcrImageTextView
    //   0	123	1	paramPicOcrRspResult	PicOcrRspResult
    //   77	8	2	f	float
    //   20	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	21	118	finally
    //   28	88	118	finally
    //   88	115	118	finally
  }
  
  /* Error */
  public void setResultSection(TranslateResult paramTranslateResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +24 -> 27
    //   6: aload_1
    //   7: getfield 332	com/tencent/mobileqq/ocr/data/TranslateResult:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10: ifnull +17 -> 27
    //   13: aload_1
    //   14: getfield 332	com/tencent/mobileqq/ocr/data/TranslateResult:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   17: invokeinterface 306 1 0
    //   22: istore_3
    //   23: iload_3
    //   24: ifeq +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: getstatic 708	com/tencent/mobileqq/ocr/OCRPerformUtil:jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult	Lcom/tencent/mobileqq/gallery/picocr/PicOcrRspResult;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull -10 -> 27
    //   40: aload 4
    //   42: getfield 289	com/tencent/mobileqq/gallery/picocr/PicOcrRspResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   45: invokevirtual 689	java/util/ArrayList:isEmpty	()Z
    //   48: ifne -21 -> 27
    //   51: aload_0
    //   52: invokevirtual 661	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   55: instanceof 680
    //   58: ifeq -31 -> 27
    //   61: aload_0
    //   62: invokevirtual 691	com/tencent/mobileqq/ocr/view/OcrImageTextView:a	()V
    //   65: aload_0
    //   66: getfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   69: ifnonnull +42 -> 111
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 661	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   77: invokestatic 664	com/tencent/mobileqq/ocr/OCRPerformUtil:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   80: putfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   83: aload_0
    //   84: invokevirtual 401	com/tencent/mobileqq/ocr/view/OcrImageTextView:getContext	()Landroid/content/Context;
    //   87: invokestatic 407	com/tencent/mobileqq/shortvideo/util/ScreenUtil:getRealWidth	(Landroid/content/Context;)I
    //   90: i2f
    //   91: aload_0
    //   92: getfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   95: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   98: i2f
    //   99: fdiv
    //   100: fstore_2
    //   101: aload_0
    //   102: fload_2
    //   103: putfield 86	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Float	F
    //   106: aload_0
    //   107: fload_2
    //   108: putfield 110	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_b_of_type_Float	F
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 208	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   116: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   119: putfield 125	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Int	I
    //   122: invokestatic 694	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   125: new 710	com/tencent/mobileqq/ocr/view/OcrImageTextView$3
    //   128: dup
    //   129: aload_0
    //   130: aload 4
    //   132: aload_1
    //   133: invokespecial 713	com/tencent/mobileqq/ocr/view/OcrImageTextView$3:<init>	(Lcom/tencent/mobileqq/ocr/view/OcrImageTextView;Lcom/tencent/mobileqq/gallery/picocr/PicOcrRspResult;Lcom/tencent/mobileqq/ocr/data/TranslateResult;)V
    //   136: invokevirtual 703	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   139: pop
    //   140: goto -113 -> 27
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	OcrImageTextView
    //   0	148	1	paramTranslateResult	TranslateResult
    //   100	8	2	f	float
    //   22	2	3	bool	boolean
    //   33	98	4	localPicOcrRspResult	PicOcrRspResult
    // Exception table:
    //   from	to	target	type
    //   6	23	143	finally
    //   30	35	143	finally
    //   40	111	143	finally
    //   111	140	143	finally
  }
  
  public void setShowTextMask(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView
 * JD-Core Version:    0.7.0.1
 */