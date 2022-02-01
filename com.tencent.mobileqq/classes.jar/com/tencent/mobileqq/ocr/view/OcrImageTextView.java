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
  private TextPaint a;
  private Runnable b = new OcrImageTextView.1(this);
  private Bitmap c;
  private Paint d = new Paint();
  private List<OcrImageTextBean> e = new CopyOnWriteArrayList();
  private List<OcrImageSectBean> f = new CopyOnWriteArrayList();
  private float g;
  private float h;
  private int i;
  private boolean j = false;
  
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
    this.d.setAntiAlias(true);
    this.d.setColor(-38294);
    this.d.setTextSize(30.0F);
    this.a = new TextPaint();
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(-38294);
    this.a.setTextSize(30.0F);
  }
  
  private float a(List<PicOcrResultBean> paramList)
  {
    paramList = paramList.iterator();
    float f1 = 0.0F;
    int k = 0;
    while (paramList.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)paramList.next();
      float f2 = OcrImageUtil.a(localPicOcrResultBean.a(this.g), localPicOcrResultBean.b(this.h), localPicOcrResultBean.a, this.d);
      if (f2 > 0.0F)
      {
        f1 += f2;
        k += 1;
      }
    }
    return f1 * 1.0F / k;
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
      localPoint = paramPicOcrResultBean.e();
    } else {
      localPoint = paramPicOcrResultBean.d();
    }
    paramPicOcrResultBean = a(this.c, localPoint, paramPicOcrResultBean.b(), paramPicOcrResultBean.c(), paramInt1, this.g, this.h, paramString);
    if (paramPicOcrResultBean == null) {
      return null;
    }
    OCRPerformUtil.a(1, paramString, "", "ocr_crop_back_img", "");
    paramString = c(paramPicOcrResultBean);
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
    Iterator localIterator = paramPicOcrRspResult.f.iterator();
    while (localIterator.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)localIterator.next();
      if (paramInt != paramPicOcrRspResult.b)
      {
        float f2 = paramInt;
        float f1 = f2 / paramPicOcrRspResult.b;
        if ((paramPicOcrRspResult.m == 90) || (paramPicOcrRspResult.m == 270)) {
          f1 = f2 / paramPicOcrRspResult.c;
        }
        localPicOcrResultBean.c(f1);
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
        ((OcrImageSectBean)localObject).h = paramString;
      }
      ((OcrImageSectBean)localObject).l = a(paramList);
      ((OcrImageSectBean)localObject).m = paramList.size();
    }
    return localObject;
  }
  
  private List<OcrImageSectBean> a(List<PicOcrResultBean> paramList, TranslateResult paramTranslateResult)
  {
    if (paramTranslateResult.d == null) {
      return null;
    }
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (PicOcrResultBean)paramList.next();
      if (((PicOcrResultBean)localObject2).d != -1) {
        if (((Map)localObject1).containsKey(Integer.valueOf(((PicOcrResultBean)localObject2).d)))
        {
          ((List)((Map)localObject1).get(Integer.valueOf(((PicOcrResultBean)localObject2).d))).add(localObject2);
        }
        else
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((Map)localObject1).put(Integer.valueOf(((PicOcrResultBean)localObject2).d), localObject3);
        }
      }
    }
    paramList = new HashMap();
    paramTranslateResult = paramTranslateResult.d.iterator();
    while (paramTranslateResult.hasNext())
    {
      localObject2 = (TranslateResult.Record)paramTranslateResult.next();
      paramList.put(((TranslateResult.Record)localObject2).a.replace(" ", ""), ((TranslateResult.Record)localObject2).b);
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
          String str = (String)paramList.get(((PicOcrResultBean)localObject3).a.replace(" ", ""));
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
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    float f1 = ScreenUtil.getRealWidth(getContext()) / k;
    k = (int)(m * f1);
    super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(ScreenUtil.getRealWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(k, 1073741824));
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      localObject1 = this.e.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        OcrImageTextBean localOcrImageTextBean = (OcrImageTextBean)((Iterator)localObject1).next();
        if ((localOcrImageTextBean.h != null) && (!localOcrImageTextBean.h.isRecycled()))
        {
          a(localOcrImageTextBean, localOcrImageTextBean.j, localOcrImageTextBean.k);
          localOcrImageTextBean.q.set(0, 0, localOcrImageTextBean.j, localOcrImageTextBean.k);
          Object localObject2 = this.d.getFontMetricsInt();
          localOcrImageTextBean.p = (localOcrImageTextBean.k / 2 + (((Paint.FontMetricsInt)localObject2).bottom - ((Paint.FontMetricsInt)localObject2).top) / 2 - ((Paint.FontMetricsInt)localObject2).bottom);
          localObject2 = localOcrImageTextBean.a();
          paramCanvas.save();
          paramCanvas.translate(((Point)localObject2).x, ((Point)localObject2).y);
          paramCanvas.rotate(localOcrImageTextBean.c);
          if (localOcrImageTextBean.x) {
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
    if (paramOcrImageTextBean.b)
    {
      this.d.setColor(-15550475);
      paramCanvas.drawRect(paramOcrImageTextBean.q, this.d);
    }
    else
    {
      paramCanvas.drawBitmap(paramOcrImageTextBean.h, paramOcrImageTextBean.q, paramOcrImageTextBean.q, this.d);
    }
    Paint localPaint = this.d;
    int k;
    if (paramOcrImageTextBean.m) {
      k = -1;
    } else {
      k = -16777216;
    }
    localPaint.setColor(k);
    paramCanvas.drawText(paramOcrImageTextBean.i, 0.0F, paramOcrImageTextBean.p, this.d);
  }
  
  private void a(OcrImageSectBean paramOcrImageSectBean)
  {
    int k = 0;
    Object localObject = null;
    try
    {
      Palette localPalette = Palette.a(paramOcrImageSectBean.w).a();
      localObject = localPalette;
      Palette.Swatch localSwatch = localPalette.a();
      localObject = localPalette;
      if (localSwatch != null)
      {
        k = 1;
        localObject = localPalette;
      }
    }
    catch (Throwable localThrowable)
    {
      OCRPerformUtil.a(0, "ocr_palette_suc", localThrowable.getMessage());
    }
    if (k != 0)
    {
      localObject = ((Palette)localObject).a();
      paramOcrImageSectBean.o = (((Palette.Swatch)localObject).a() | 0xFF000000);
      paramOcrImageSectBean.p = (((Palette.Swatch)localObject).e() | 0xFF000000);
      paramOcrImageSectBean.u = true;
      OCRPerformUtil.a(1, "ocr_palette_suc", "");
      return;
    }
    paramOcrImageSectBean.t = b(paramOcrImageSectBean.w);
  }
  
  private void a(OcrImageTextBean paramOcrImageTextBean)
  {
    if (paramOcrImageTextBean.h == null) {
      return;
    }
    Object localObject = null;
    int k = 0;
    try
    {
      Palette localPalette = Palette.a(paramOcrImageTextBean.h).a();
      localObject = localPalette;
      Palette.Swatch localSwatch = localPalette.a();
      localObject = localPalette;
      if (localSwatch != null)
      {
        k = 1;
        localObject = localPalette;
      }
    }
    catch (Throwable localThrowable)
    {
      OCRPerformUtil.a(0, "ocr_palette_suc", localThrowable.getMessage());
    }
    if (k != 0)
    {
      localObject = ((Palette)localObject).a();
      paramOcrImageTextBean.v = (((Palette.Swatch)localObject).a() | 0xFF000000);
      paramOcrImageTextBean.w = (((Palette.Swatch)localObject).e() | 0xFF000000);
      paramOcrImageTextBean.x = true;
      OCRPerformUtil.a(1, "ocr_palette_suc", "");
      return;
    }
    paramOcrImageTextBean.m = b(paramOcrImageTextBean.h);
  }
  
  private void a(OcrImageTextBean paramOcrImageTextBean, int paramInt1, int paramInt2)
  {
    if ((paramOcrImageTextBean != null) && (!TextUtils.isEmpty(paramOcrImageTextBean.i)) && (paramInt1 > 0))
    {
      if (paramOcrImageTextBean.l > 0.0F)
      {
        this.d.setTextSize(paramOcrImageTextBean.l);
        return;
      }
      paramOcrImageTextBean.l = OcrImageUtil.a(paramInt1, paramInt2, paramOcrImageTextBean.i, this.d);
      Rect localRect = new Rect();
      this.d.getTextBounds(paramOcrImageTextBean.i, 0, paramOcrImageTextBean.i.length(), localRect);
      paramOcrImageTextBean.r = ((paramInt1 - localRect.width()) / 2);
      paramOcrImageTextBean.s = ((paramInt2 - localRect.height()) / 2);
      this.d.setTextSize(paramOcrImageTextBean.l);
      return;
    }
    this.d.setTextSize(30.0F);
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        OcrImageSectBean localOcrImageSectBean = (OcrImageSectBean)localIterator.next();
        if ((localOcrImageSectBean.w != null) && (!localOcrImageSectBean.w.isRecycled()) && (!TextUtils.isEmpty(localOcrImageSectBean.h)) && (!localOcrImageSectBean.c()))
        {
          Rect localRect = localOcrImageSectBean.a();
          localObject1 = localOcrImageSectBean.b();
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
          paramCanvas.rotate(localOcrImageSectBean.c);
          boolean bool = localOcrImageSectBean.u;
          int k = -15550475;
          if (bool)
          {
            localObject1 = this.d;
            if (!localOcrImageSectBean.b) {
              k = localOcrImageSectBean.o;
            }
            ((Paint)localObject1).setColor(k);
            paramCanvas.drawRect(localRect, this.d);
          }
          else if (localOcrImageSectBean.b)
          {
            this.d.setColor(-15550475);
            paramCanvas.drawRect(localRect, this.d);
          }
          else
          {
            paramCanvas.drawBitmap(localOcrImageSectBean.w, localRect, localRect, this.d);
          }
          if (TextUtils.isEmpty(localOcrImageSectBean.h))
          {
            paramCanvas.restore();
          }
          else
          {
            int m = Math.round(localOcrImageSectBean.k);
            int n = localRect.width() - localOcrImageSectBean.r * 2;
            int i1 = localRect.height() - localOcrImageSectBean.q * 2;
            this.a.setTextSize(m);
            this.a.setColor(localOcrImageSectBean.p);
            localObject2 = a(localOcrImageSectBean.h, this.a, n);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              paramCanvas.restore();
            }
            else
            {
              for (;;)
              {
                k = m;
                localObject2 = localObject1;
                if (((StaticLayout)localObject1).getHeight() >= i1) {
                  break;
                }
                m += 1;
                if (m > 30)
                {
                  k = m;
                  localObject2 = localObject1;
                  break;
                }
                this.a.setTextSize(m);
                StaticLayout localStaticLayout = a(localOcrImageSectBean.h, this.a, n);
                k = m;
                localObject2 = localObject1;
                if (localStaticLayout == null) {
                  break;
                }
                if (localStaticLayout.getHeight() <= 0)
                {
                  k = m;
                  localObject2 = localObject1;
                  break;
                }
                localObject1 = localStaticLayout;
              }
              while (((StaticLayout)localObject2).getHeight() > i1)
              {
                k -= 1;
                if (k < 5) {
                  break;
                }
                this.a.setTextSize(k);
                localObject1 = a(localOcrImageSectBean.h, this.a, n);
                if ((localObject1 == null) || (((StaticLayout)localObject1).getHeight() <= 0)) {
                  break;
                }
                localObject2 = localObject1;
              }
              k = localOcrImageSectBean.r;
              m = localRect.height() / 2;
              n = ((StaticLayout)localObject2).getHeight() / 2;
              paramCanvas.translate(k, m - n);
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
    Paint localPaint = this.d;
    int k;
    if (paramOcrImageTextBean.b) {
      k = -15550475;
    } else {
      k = paramOcrImageTextBean.v;
    }
    localPaint.setColor(k);
    paramCanvas.drawRect(paramOcrImageTextBean.q, this.d);
    this.d.setColor(paramOcrImageTextBean.w);
    paramCanvas.drawText(paramOcrImageTextBean.i, 0.0F, paramOcrImageTextBean.p, this.d);
  }
  
  private boolean b(Bitmap paramBitmap)
  {
    int k = paramBitmap.getHeight() / 20;
    int n = 5;
    int m = k;
    if (k <= 0) {
      m = 5;
    }
    k = paramBitmap.getWidth() / 20;
    if (k > 0) {
      n = k;
    }
    long l6 = 0L;
    long l1 = l6;
    long l2 = l1;
    long l5 = l2;
    k = 0;
    long l3 = l2;
    long l4 = l1;
    l2 = l6;
    l1 = l5;
    while (k < paramBitmap.getHeight())
    {
      l5 = l2;
      l2 = l1;
      int i1 = 0;
      l1 = l5;
      while (i1 < paramBitmap.getWidth())
      {
        int i2 = paramBitmap.getPixel(i1, k);
        l1 += 1L;
        l2 += Color.red(i2);
        l4 += Color.green(i2);
        l3 += Color.blue(i2);
        i1 += n;
      }
      k += m;
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
  
  private Bitmap c(Bitmap paramBitmap)
  {
    paramBitmap = new StackBlurManager(paramBitmap);
    paramBitmap.setDbg(false);
    return paramBitmap.process(64);
  }
  
  private boolean f()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((OcrImageTextBean)((Iterator)localObject).next()).b) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean g()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((OcrImageSectBean)((Iterator)localObject).next()).b) {
          return true;
        }
      }
    }
    return false;
  }
  
  private CharSequence h()
  {
    Object localObject = this.e;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      int k = -2;
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        OcrImageTextBean localOcrImageTextBean = (OcrImageTextBean)localIterator.next();
        if (localOcrImageTextBean.b) {
          if (k < 0)
          {
            ((StringBuilder)localObject).append(localOcrImageTextBean.i.trim());
            k = localOcrImageTextBean.n;
          }
          else if (localOcrImageTextBean.n == k)
          {
            ((StringBuilder)localObject).append(localOcrImageTextBean.i.trim());
          }
          else
          {
            ((StringBuilder)localObject).append("\n\n");
            ((StringBuilder)localObject).append(localOcrImageTextBean.i.trim());
            k = localOcrImageTextBean.n;
          }
        }
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private CharSequence i()
  {
    Object localObject = this.f;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        OcrImageSectBean localOcrImageSectBean = (OcrImageSectBean)localIterator.next();
        if (localOcrImageSectBean.b)
        {
          ((StringBuilder)localObject).append(localOcrImageSectBean.h);
          ((StringBuilder)localObject).append("\n\n");
        }
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public boolean a(int paramInt)
  {
    if (this.c == null) {
      this.c = OCRPerformUtil.a(getDrawable());
    }
    return this.c.getHeight() * this.h <= paramInt;
  }
  
  public boolean b()
  {
    if (OCRPerformUtil.a) {
      return g();
    }
    return f();
  }
  
  public CharSequence c()
  {
    if (OCRPerformUtil.a) {
      return i();
    }
    return h();
  }
  
  public void d()
  {
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.b);
      Iterator localIterator = this.e.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (OcrImageTextBean)localIterator.next();
        if ((localObject2 != null) && (((OcrImageTextBean)localObject2).h != null))
        {
          ((OcrImageTextBean)localObject2).h.recycle();
          ((OcrImageTextBean)localObject2).h = null;
        }
      }
      this.e.clear();
      localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (OcrImageSectBean)localIterator.next();
        if ((localObject2 != null) && (((OcrImageSectBean)localObject2).w != null))
        {
          ((OcrImageSectBean)localObject2).w.recycle();
          ((OcrImageSectBean)localObject2).w = null;
        }
      }
      this.f.clear();
      if (this.c != null) {
        this.c = null;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void e()
  {
    Bitmap localBitmap = this.c;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public List<OcrImageTextBean> getOcrImageTextList()
  {
    return this.e;
  }
  
  public List<OcrImageSectBean> getOcrTransTextList()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a())
    {
      if (this.c == null) {
        return;
      }
      paramCanvas.save();
      paramCanvas.translate(0.0F, 0.0F);
      paramCanvas.restore();
      if (OCRPerformUtil.a)
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
        if ((paramPicOcrRspResult.f != null) && (!paramPicOcrRspResult.f.isEmpty()))
        {
          boolean bool = getDrawable() instanceof BitmapDrawable;
          if (!bool) {
            return;
          }
          d();
          if (this.c == null)
          {
            this.c = OCRPerformUtil.a(getDrawable());
            float f1 = ScreenUtil.getRealWidth(getContext()) / this.c.getWidth();
            this.g = f1;
            this.h = f1;
          }
          this.i = this.c.getWidth();
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
        if ((paramTranslateResult.d != null) && (!paramTranslateResult.d.isEmpty()))
        {
          PicOcrRspResult localPicOcrRspResult = OCRPerformUtil.g;
          if ((localPicOcrRspResult != null) && (!localPicOcrRspResult.f.isEmpty()))
          {
            boolean bool = getDrawable() instanceof BitmapDrawable;
            if (!bool) {
              return;
            }
            d();
            if (this.c == null)
            {
              this.c = OCRPerformUtil.a(getDrawable());
              float f1 = ScreenUtil.getRealWidth(getContext()) / this.c.getWidth();
              this.g = f1;
              this.h = f1;
            }
            this.i = this.c.getWidth();
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
    this.j = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView
 * JD-Core Version:    0.7.0.1
 */