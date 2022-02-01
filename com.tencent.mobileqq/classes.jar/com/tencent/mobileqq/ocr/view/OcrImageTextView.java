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
import avav;
import avaw;
import ayrt;
import aytg;
import ayvc;
import ayvd;
import bhkw;
import bhky;
import bhla;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.data.TranslateResult.Record;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
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
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private Runnable jdField_a_of_type_JavaLangRunnable = new OcrImageTextView.1(this);
  private List<ayvd> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private List<ayvc> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
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
  
  private float a(List<avav> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    float f1 = 0.0F;
    if (paramList.hasNext())
    {
      avav localavav = (avav)paramList.next();
      float f2 = aytg.a(localavav.a(this.jdField_a_of_type_Float), localavav.b(this.jdField_b_of_type_Float), localavav.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPaint);
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
  
  private Bitmap a(Bitmap paramBitmap, Point paramPoint, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat1, paramFloat2);
    label128:
    for (;;)
    {
      try
      {
        if (paramPoint.x + paramInt1 <= paramBitmap.getWidth()) {
          break label128;
        }
        paramInt1 = paramBitmap.getWidth() - paramPoint.x;
        if (paramPoint.y + paramInt2 > paramBitmap.getHeight())
        {
          paramInt2 = paramBitmap.getHeight() - paramPoint.y;
          paramBitmap = Bitmap.createBitmap(paramBitmap, paramPoint.x, paramPoint.y, paramInt1, paramInt2, localMatrix, false);
          return paramBitmap;
        }
      }
      catch (Exception paramBitmap)
      {
        QLog.e("OcrImageTextView", 2, "cropBitmap error=" + paramBitmap.getMessage());
        return null;
      }
    }
  }
  
  private Bitmap a(avav paramavav, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramavav.b();
      localObject = a(this.jdField_a_of_type_AndroidGraphicsBitmap, (Point)localObject, paramavav.b(), paramavav.c(), paramInt1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      if (localObject != null) {
        break label74;
      }
      paramInt1 = 0;
      label46:
      ayrt.a(paramInt1, paramString, "", "ocr_crop_back_img");
      if (localObject != null) {
        break label79;
      }
      paramavav = null;
    }
    label74:
    label79:
    do
    {
      return paramavav;
      localObject = paramavav.a();
      break;
      paramInt1 = 1;
      break label46;
      paramString = a((Bitmap)localObject);
      if (((Bitmap)localObject).getHeight() != paramInt3) {
        break label110;
      }
      paramavav = paramString;
    } while (((Bitmap)localObject).getWidth() == paramInt2);
    label110:
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
  
  private avaw a(avaw paramavaw, int paramInt)
  {
    Iterator localIterator = paramavaw.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      avav localavav = (avav)localIterator.next();
      if (paramInt != paramavaw.jdField_a_of_type_Int)
      {
        float f = paramInt / paramavaw.jdField_a_of_type_Int;
        if ((paramavaw.f == 90) || (paramavaw.f == 270)) {
          f = paramInt / paramavaw.b;
        }
        localavav.a(f);
      }
    }
    return paramavaw;
  }
  
  private ayvc a(List<avav> paramList, String paramString)
  {
    ayvc localayvc = null;
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      avav localavav = (avav)localIterator.next();
      if (localayvc == null) {
        localayvc = new ayvc(localavav);
      }
      for (;;)
      {
        break;
        localayvc.a(localavav);
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      localayvc.jdField_a_of_type_JavaLangString = paramString;
    }
    localayvc.jdField_b_of_type_Float = a(paramList);
    localayvc.jdField_c_of_type_Float = paramList.size();
    return localayvc;
  }
  
  private List<ayvc> a(List<avav> paramList, TranslateResult paramTranslateResult)
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
      localObject2 = (avav)paramList.next();
      if (((avav)localObject2).b != -1) {
        if (((Map)localObject1).containsKey(Integer.valueOf(((avav)localObject2).b)))
        {
          ((List)((Map)localObject1).get(Integer.valueOf(((avav)localObject2).b))).add(localObject2);
        }
        else
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((Map)localObject1).put(Integer.valueOf(((avav)localObject2).b), localObject3);
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
      localObject3 = (String)paramList.get(aytg.a((List)((Map.Entry)localObject2).getValue()));
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
          localObject3 = (avav)((Iterator)localObject2).next();
          String str = (String)paramList.get(((avav)localObject3).jdField_a_of_type_JavaLangString.replace(" ", ""));
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
    ayvd localayvd;
    while (localIterator.hasNext())
    {
      localayvd = (ayvd)localIterator.next();
      if ((localayvd.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localayvd.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        a(localayvd, localayvd.f, localayvd.g);
        localayvd.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localayvd.f, localayvd.g);
        Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
        localayvd.j = (localayvd.g / 2 + (((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2 - ((Paint.FontMetricsInt)localObject).bottom);
        localObject = localayvd.a();
        paramCanvas.save();
        paramCanvas.translate(((Point)localObject).x, ((Point)localObject).y);
        paramCanvas.rotate(localayvd.jdField_a_of_type_Int);
        if (!localayvd.d) {
          break label191;
        }
        b(paramCanvas, localayvd);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      break label30;
      break;
      label191:
      a(paramCanvas, localayvd);
    }
  }
  
  private void a(Canvas paramCanvas, ayvd paramayvd)
  {
    Paint localPaint;
    if (paramayvd.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
      paramCanvas.drawRect(paramayvd.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (!paramayvd.b) {
        break label92;
      }
    }
    label92:
    for (int i = -1;; i = -16777216)
    {
      localPaint.setColor(i);
      paramCanvas.drawText(paramayvd.jdField_a_of_type_JavaLangString, 0.0F, paramayvd.j, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      paramCanvas.drawBitmap(paramayvd.jdField_a_of_type_AndroidGraphicsBitmap, paramayvd.jdField_a_of_type_AndroidGraphicsRect, paramayvd.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
    }
  }
  
  private void a(ayvc paramayvc)
  {
    int j = 1;
    Object localObject = bhkw.a(paramayvc.jdField_a_of_type_AndroidGraphicsBitmap).a();
    if (((bhkw)localObject).a() != null)
    {
      i = 1;
      if (i == 0) {
        break label85;
      }
      localObject = ((bhkw)localObject).a();
      paramayvc.g = (((bhla)localObject).a() | 0xFF000000);
      paramayvc.h = (((bhla)localObject).d() | 0xFF000000);
      paramayvc.d = true;
      label66:
      if (i == 0) {
        break label100;
      }
    }
    label85:
    label100:
    for (int i = j;; i = 0)
    {
      ayrt.a(i, "ocr_palette_suc");
      return;
      i = 0;
      break;
      paramayvc.jdField_c_of_type_Boolean = a(paramayvc.jdField_a_of_type_AndroidGraphicsBitmap);
      break label66;
    }
  }
  
  private void a(ayvd paramayvd)
  {
    int j = 1;
    if (paramayvd.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    Object localObject = bhkw.a(paramayvd.jdField_a_of_type_AndroidGraphicsBitmap).a();
    if (((bhkw)localObject).a() != null)
    {
      i = 1;
      if (i == 0) {
        break label93;
      }
      localObject = ((bhkw)localObject).a();
      paramayvd.n = (((bhla)localObject).a() | 0xFF000000);
      paramayvd.o = (((bhla)localObject).d() | 0xFF000000);
      paramayvd.d = true;
      label74:
      if (i == 0) {
        break label108;
      }
    }
    label93:
    label108:
    for (int i = j;; i = 0)
    {
      ayrt.a(i, "ocr_palette_suc");
      return;
      i = 0;
      break;
      paramayvd.b = a(paramayvd.jdField_a_of_type_AndroidGraphicsBitmap);
      break label74;
    }
  }
  
  private void a(ayvd paramayvd, int paramInt1, int paramInt2)
  {
    if ((paramayvd == null) || (TextUtils.isEmpty(paramayvd.jdField_a_of_type_JavaLangString)) || (paramInt1 <= 0))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(30.0F);
      return;
    }
    if (paramayvd.jdField_a_of_type_Float > 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramayvd.jdField_a_of_type_Float);
      return;
    }
    paramayvd.jdField_a_of_type_Float = aytg.a(paramInt1, paramInt2, paramayvd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPaint);
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramayvd.jdField_a_of_type_JavaLangString, 0, paramayvd.jdField_a_of_type_JavaLangString.length(), localRect);
    paramayvd.k = ((paramInt1 - localRect.width()) / 2);
    paramayvd.l = ((paramInt2 - localRect.height()) / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramayvd.jdField_a_of_type_Float);
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
    ayvd localayvd;
    if (localIterator.hasNext())
    {
      localayvd = (ayvd)localIterator.next();
      if (!localayvd.jdField_a_of_type_Boolean) {
        break label155;
      }
      if (i < 0)
      {
        localStringBuilder.append(localayvd.jdField_a_of_type_JavaLangString.trim());
        i = localayvd.h;
      }
    }
    label155:
    for (;;)
    {
      break;
      if (localayvd.h == i)
      {
        localStringBuilder.append(localayvd.jdField_a_of_type_JavaLangString.trim());
      }
      else
      {
        localStringBuilder.append("\n\n").append(localayvd.jdField_a_of_type_JavaLangString.trim());
        i = localayvd.h;
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
    ayvc localayvc;
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
      localayvc = (ayvc)localIterator.next();
      if ((localayvc.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localayvc.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (!TextUtils.isEmpty(localayvc.jdField_a_of_type_JavaLangString)) && (!localayvc.a()))
      {
        localRect = localayvc.a();
        localObject1 = localayvc.a();
        if (QLog.isColorLevel()) {
          QLog.i("OcrImageTextView", 2, "rect:" + localRect.toShortString() + ", point:" + ((Point)localObject1).toString());
        }
        paramCanvas.save();
        paramCanvas.translate(((Point)localObject1).x, ((Point)localObject1).y);
        paramCanvas.rotate(localayvc.jdField_a_of_type_Int);
        if (localayvc.d)
        {
          localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint;
          if (localayvc.jdField_a_of_type_Boolean)
          {
            i = -15550475;
            ((Paint)localObject1).setColor(i);
            paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(localayvc.jdField_a_of_type_JavaLangString)) {
            break label306;
          }
          paramCanvas.restore();
          break;
          i = localayvc.g;
          break label212;
          if (localayvc.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
            paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          else
          {
            paramCanvas.drawBitmap(localayvc.jdField_a_of_type_AndroidGraphicsBitmap, localRect, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
        i = Math.round(localayvc.jdField_a_of_type_Float);
        k = localRect.width() - localayvc.j * 2;
        m = localRect.height() - localayvc.i * 2;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(i);
        this.jdField_a_of_type_AndroidTextTextPaint.setColor(localayvc.h);
        localObject2 = a(localayvc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
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
        i = localayvc.j;
        j = localRect.height() / 2;
        k = ((StaticLayout)localObject2).getHeight() / 2;
        paramCanvas.translate(i, j - k);
        ((StaticLayout)localObject2).draw(paramCanvas);
        paramCanvas.restore();
        break label31;
        break;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(j);
        localStaticLayout = a(localayvc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
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
        localObject1 = a(localayvc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, k);
      } while ((localObject1 == null) || (((StaticLayout)localObject1).getHeight() <= 0));
      label551:
      localObject2 = localObject1;
      continue;
      label597:
      localObject2 = localObject1;
    }
  }
  
  private void b(Canvas paramCanvas, ayvd paramayvd)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (paramayvd.jdField_a_of_type_Boolean) {}
    for (int i = -15550475;; i = paramayvd.n)
    {
      localPaint.setColor(i);
      paramCanvas.drawRect(paramayvd.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramayvd.o);
      paramCanvas.drawText(paramayvd.jdField_a_of_type_JavaLangString, 0.0F, paramayvd.j, this.jdField_a_of_type_AndroidGraphicsPaint);
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
      ayvc localayvc = (ayvc)localIterator.next();
      if (localayvc.jdField_a_of_type_Boolean) {
        localStringBuilder.append(localayvc.jdField_a_of_type_JavaLangString).append("\n\n");
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
      if (((ayvd)localIterator.next()).jdField_a_of_type_Boolean) {
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
      if (((ayvc)localIterator.next()).jdField_a_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  public CharSequence a()
  {
    if (ayrt.jdField_a_of_type_Boolean) {
      return c();
    }
    return b();
  }
  
  public List<ayvd> a()
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
        localObject2 = (ayvd)localIterator1.next();
        if ((localObject2 != null) && (((ayvd)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          ((ayvd)localObject2).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          ((ayvd)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    finally {}
    Iterator localIterator2 = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (ayvc)localIterator2.next();
      if ((localObject2 != null) && (((ayvc)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null))
      {
        ((ayvc)localObject2).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        ((ayvc)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = null;
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
      this.jdField_a_of_type_AndroidGraphicsBitmap = ayrt.a(getDrawable());
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_b_of_type_Float <= paramInt;
  }
  
  public List<ayvc> b()
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
    if (ayrt.jdField_a_of_type_Boolean) {
      return d();
    }
    return c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!a()) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(0.0F, 0.0F);
    paramCanvas.restore();
    if (ayrt.jdField_a_of_type_Boolean)
    {
      b(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((getDrawable() == null) || (((BitmapDrawable)getDrawable()).getBitmap() == null))
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    Bitmap localBitmap = ayrt.a(getDrawable());
    if (localBitmap == null)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    a(localBitmap);
  }
  
  /* Error */
  public void setResultNormal(avaw paramavaw)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +22 -> 25
    //   6: aload_1
    //   7: getfield 285	avaw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10: ifnull +15 -> 25
    //   13: aload_1
    //   14: getfield 285	avaw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: invokevirtual 687	java/util/ArrayList:isEmpty	()Z
    //   20: istore_3
    //   21: iload_3
    //   22: ifeq +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokevirtual 659	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   32: instanceof 678
    //   35: ifeq -10 -> 25
    //   38: aload_0
    //   39: invokevirtual 689	com/tencent/mobileqq/ocr/view/OcrImageTextView:a	()V
    //   42: aload_0
    //   43: getfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   46: ifnonnull +42 -> 88
    //   49: aload_0
    //   50: aload_0
    //   51: invokevirtual 659	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   54: invokestatic 662	ayrt:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   57: putfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   60: aload_0
    //   61: invokevirtual 397	com/tencent/mobileqq/ocr/view/OcrImageTextView:getContext	()Landroid/content/Context;
    //   64: invokestatic 403	com/tencent/mobileqq/shortvideo/util/ScreenUtil:getRealWidth	(Landroid/content/Context;)I
    //   67: i2f
    //   68: aload_0
    //   69: getfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   72: invokevirtual 155	android/graphics/Bitmap:getWidth	()I
    //   75: i2f
    //   76: fdiv
    //   77: fstore_2
    //   78: aload_0
    //   79: fload_2
    //   80: putfield 82	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Float	F
    //   83: aload_0
    //   84: fload_2
    //   85: putfield 106	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_b_of_type_Float	F
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   93: invokevirtual 155	android/graphics/Bitmap:getWidth	()I
    //   96: putfield 121	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Int	I
    //   99: invokestatic 692	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   102: new 694	com/tencent/mobileqq/ocr/view/OcrImageTextView$2
    //   105: dup
    //   106: aload_0
    //   107: aload_1
    //   108: invokespecial 697	com/tencent/mobileqq/ocr/view/OcrImageTextView$2:<init>	(Lcom/tencent/mobileqq/ocr/view/OcrImageTextView;Lavaw;)V
    //   111: invokevirtual 701	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
    //   0	123	1	paramavaw	avaw
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
    //   7: getfield 328	com/tencent/mobileqq/ocr/data/TranslateResult:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10: ifnull +17 -> 27
    //   13: aload_1
    //   14: getfield 328	com/tencent/mobileqq/ocr/data/TranslateResult:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   17: invokeinterface 302 1 0
    //   22: istore_3
    //   23: iload_3
    //   24: ifeq +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: getstatic 706	ayrt:jdField_a_of_type_Avaw	Lavaw;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull -10 -> 27
    //   40: aload 4
    //   42: getfield 285	avaw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   45: invokevirtual 687	java/util/ArrayList:isEmpty	()Z
    //   48: ifne -21 -> 27
    //   51: aload_0
    //   52: invokevirtual 659	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   55: instanceof 678
    //   58: ifeq -31 -> 27
    //   61: aload_0
    //   62: invokevirtual 689	com/tencent/mobileqq/ocr/view/OcrImageTextView:a	()V
    //   65: aload_0
    //   66: getfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   69: ifnonnull +42 -> 111
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 659	com/tencent/mobileqq/ocr/view/OcrImageTextView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   77: invokestatic 662	ayrt:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   80: putfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   83: aload_0
    //   84: invokevirtual 397	com/tencent/mobileqq/ocr/view/OcrImageTextView:getContext	()Landroid/content/Context;
    //   87: invokestatic 403	com/tencent/mobileqq/shortvideo/util/ScreenUtil:getRealWidth	(Landroid/content/Context;)I
    //   90: i2f
    //   91: aload_0
    //   92: getfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   95: invokevirtual 155	android/graphics/Bitmap:getWidth	()I
    //   98: i2f
    //   99: fdiv
    //   100: fstore_2
    //   101: aload_0
    //   102: fload_2
    //   103: putfield 82	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Float	F
    //   106: aload_0
    //   107: fload_2
    //   108: putfield 106	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_b_of_type_Float	F
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 195	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   116: invokevirtual 155	android/graphics/Bitmap:getWidth	()I
    //   119: putfield 121	com/tencent/mobileqq/ocr/view/OcrImageTextView:jdField_a_of_type_Int	I
    //   122: invokestatic 692	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   125: new 708	com/tencent/mobileqq/ocr/view/OcrImageTextView$3
    //   128: dup
    //   129: aload_0
    //   130: aload 4
    //   132: aload_1
    //   133: invokespecial 711	com/tencent/mobileqq/ocr/view/OcrImageTextView$3:<init>	(Lcom/tencent/mobileqq/ocr/view/OcrImageTextView;Lavaw;Lcom/tencent/mobileqq/ocr/data/TranslateResult;)V
    //   136: invokevirtual 701	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
    //   33	98	4	localavaw	avaw
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