package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopActiveLayout
  extends View
  implements Handler.Callback
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130842623, 2130842624, 2130842624, 2130842625, 2130842626, 2130842627 };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TroopActiveLayout.SizeableBitmapCache jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 10;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private ArrayList<Bitmap> jdField_b_of_type_JavaUtilArrayList;
  private int c;
  private volatile int d = 0;
  
  public TroopActiveLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopActiveLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopActiveLayout(Context arg1, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(???, paramAttributeSet, paramInt);
    Sizeable localSizeable = CommonImageCacheHelper.a("TroopActiveLayout_cache");
    paramAttributeSet = localSizeable;
    if (!(localSizeable instanceof TroopActiveLayout.SizeableBitmapCache))
    {
      paramAttributeSet = new TroopActiveLayout.SizeableBitmapCache(41702);
      CommonImageCacheHelper.a("TroopActiveLayout_cache", paramAttributeSet);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache = ((TroopActiveLayout.SizeableBitmapCache)paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = ???;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_b_of_type_Int / 2 + 1);
      this.c = ScreenUtil.dip2px(3.0F);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_b_of_type_Int / 2 + 1);
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      setHotLevel(this.d);
      this.jdField_a_of_type_Boolean = "1103".equals(ThemeUtil.getCurrentThemeId());
      return;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt3) {
      return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
    }
    throw new IllegalArgumentException(String.format("getValueWithLimit min value %s is greater than max value %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int k = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    int j = 0;
    int i = 0;
    if ((k != -2147483648) && (k != 0))
    {
      if (k != 1073741824) {
        return 0;
      }
    }
    else {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      if (paramBoolean)
      {
        j = this.jdField_b_of_type_JavaUtilArrayList.size();
        if (j <= 0) {
          return paramInt;
        }
        ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        paramInt = i;
        while (((Iterator)???).hasNext()) {
          paramInt += ((Bitmap)((Iterator)???).next()).getWidth();
        }
        paramInt += (j - 1) * this.c;
        i = getPaddingLeft();
        j = getPaddingRight();
      }
      else
      {
        ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (paramInt = j; ((Iterator)???).hasNext(); paramInt = Math.max(paramInt, ((Bitmap)((Iterator)???).next()).getHeight())) {}
        i = getPaddingTop();
        j = getPaddingBottom();
      }
      paramInt = i + j + paramInt;
      return paramInt;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private Bitmap a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt, null);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("TroopActiveLayout", 1, localOutOfMemoryError, new Object[0]);
    }
    return null;
  }
  
  private Bitmap a(@NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    try
    {
      Paint localPaint = new Paint();
      localBitmap1 = localBitmap2;
      localPaint.setAntiAlias(true);
      localBitmap1 = localBitmap2;
      localBitmap2 = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
      localBitmap1 = localBitmap2;
      Canvas localCanvas = new Canvas(localBitmap2);
      localBitmap1 = localBitmap2;
      localCanvas.drawBitmap(paramBitmap1, new Rect(0, 0, paramBitmap1.getWidth() / 2, paramBitmap1.getHeight()), new Rect(0, 0, paramBitmap1.getWidth() / 2, paramBitmap1.getHeight()), localPaint);
      localBitmap1 = localBitmap2;
      localCanvas.drawBitmap(paramBitmap2, new Rect(paramBitmap2.getWidth() / 2, 0, paramBitmap2.getWidth(), paramBitmap2.getHeight()), new Rect(paramBitmap1.getWidth() / 2, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight()), localPaint);
      return localBitmap2;
    }
    catch (Throwable paramBitmap1)
    {
      QLog.e("TroopActiveLayout", 1, paramBitmap1, new Object[0]);
    }
    return localBitmap1;
  }
  
  private void a(int paramInt)
  {
    Bitmap[] arrayOfBitmap = a(paramInt);
    int i = 0;
    if (arrayOfBitmap == null)
    {
      ??? = this.jdField_b_of_type_AndroidOsHandler;
      ((Handler)???).sendMessage(Message.obtain((Handler)???, 102, paramInt, 0));
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int j = arrayOfBitmap.length;
      paramInt = i;
      if (paramInt < j)
      {
        Bitmap localBitmap = arrayOfBitmap[paramInt];
        if (localBitmap != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localBitmap);
        }
      }
      else
      {
        requestLayout();
        invalidate();
        return;
      }
    }
  }
  
  private Bitmap[] a(int paramInt)
  {
    int m = a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache;
    int k = 0;
    int j = 0;
    localObject1 = (Bitmap)((TroopActiveLayout.SizeableBitmapCache)localObject1).get(Integer.valueOf(0));
    int i;
    if (paramInt % 2 == 1) {
      i = 1;
    } else {
      i = 0;
    }
    Bitmap localBitmap;
    Object localObject2;
    if (i != 0)
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.get(Integer.valueOf(paramInt));
      localObject2 = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.get(Integer.valueOf(paramInt - 1));
      if ((localBitmap != null) && (localObject2 != null))
      {
        i = paramInt / 2;
        Bitmap[] arrayOfBitmap = new Bitmap[m];
        paramInt = j;
        while (paramInt < i)
        {
          arrayOfBitmap[paramInt] = localObject2;
          paramInt += 1;
        }
        arrayOfBitmap[i] = localBitmap;
        paramInt = i + 1;
        while (paramInt < m)
        {
          arrayOfBitmap[paramInt] = localObject1;
          paramInt += 1;
        }
        return arrayOfBitmap;
      }
    }
    else
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.get(Integer.valueOf(paramInt));
      if (localBitmap != null)
      {
        j = paramInt / 2;
        localObject2 = new Bitmap[m];
        paramInt = k;
        for (;;)
        {
          i = j;
          if (paramInt >= j) {
            break;
          }
          localObject2[paramInt] = localBitmap;
          paramInt += 1;
        }
        while (i < m)
        {
          localObject2[i] = localObject1;
          i += 1;
        }
        return localObject2;
      }
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    Looper.myLooper();
    Looper.getMainLooper();
    int n = 1;
    if (paramInt % 2 == 1) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      i = paramInt - 1;
    } else {
      i = paramInt;
    }
    int k = i;
    if (i == 0) {
      k = 2;
    }
    int m;
    if (j != 0) {
      m = paramInt;
    } else {
      m = paramInt + 1;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.containsKey(Integer.valueOf(0)))
    {
      localObject1 = a(jdField_a_of_type_ArrayOfInt[0]);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.put(Integer.valueOf(0), localObject1);
      }
      else
      {
        i = 1;
        localObject2 = localObject1;
        break label141;
      }
    }
    else
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.get(Integer.valueOf(0));
    }
    int i = 0;
    Object localObject2 = localObject1;
    label141:
    Bitmap localBitmap = null;
    int j = i;
    Object localObject1 = localBitmap;
    if (k >= this.jdField_a_of_type_Int)
    {
      j = i;
      localObject1 = localBitmap;
      if (k <= this.jdField_b_of_type_Int) {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.containsKey(Integer.valueOf(k)))
        {
          int i1 = paramInt / 2;
          if (i1 <= 0)
          {
            j = 1;
          }
          else
          {
            localObject1 = jdField_a_of_type_ArrayOfInt;
            j = i1;
            if (i1 >= localObject1.length) {
              j = localObject1.length - 1;
            }
          }
          localObject1 = a(jdField_a_of_type_ArrayOfInt[j]);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.put(Integer.valueOf(k), localObject1);
            j = i;
          }
          else
          {
            j = 1;
          }
        }
        else
        {
          localObject1 = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.get(Integer.valueOf(k));
          j = i;
        }
      }
    }
    i = j;
    if (localObject2 != null)
    {
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if (m >= this.jdField_a_of_type_Int)
        {
          i = j;
          if (m <= this.jdField_b_of_type_Int) {
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.containsKey(Integer.valueOf(m)))
            {
              localBitmap = a((Bitmap)localObject1, localObject2);
              if (localBitmap != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.put(Integer.valueOf(m), localBitmap);
                i = j;
              }
              else
              {
                i = 1;
              }
            }
            else
            {
              localBitmap = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout$SizeableBitmapCache.get(Integer.valueOf(m));
              i = j;
            }
          }
        }
      }
    }
    if ((localObject2 == null) && (localObject1 == null)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i == 0) && (j == 0)) {
      i = n;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      ((Handler)localObject1).sendMessage(Message.obtain((Handler)localObject1, 101, paramInt, 0));
    }
  }
  
  public int a()
  {
    return (this.jdField_b_of_type_Int + 1) / 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 101)
    {
      if (i == 102) {
        b(paramMessage.arg1);
      }
    }
    else {
      a(paramMessage.arg1);
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n = getWidth();
    int i = getHeight();
    int k = getPaddingLeft();
    int i1 = getPaddingRight();
    int m = getPaddingTop();
    int j = getPaddingBottom();
    k = a(k, 0, n);
    n = a(n - i1, 0, n);
    m = a(m, 0, i);
    i = a(i - j, 0, i);
    j = n - k;
    i -= m;
    if (j > 0)
    {
      if (i <= 0) {
        return;
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        k = this.jdField_b_of_type_JavaUtilArrayList.size();
        if (k <= 0) {
          return;
        }
        j = (j - this.c * (k - 1)) / k;
        if (j <= 0) {
          return;
        }
        float f1 = i;
        float f2 = j;
        float f3 = f1 / f2;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeConstants.NIGHTMODE_COLORFILTER);
        }
        ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        i = 0;
        while (((Iterator)???).hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Iterator)???).next();
          if (localBitmap != null)
          {
            k = localBitmap.getHeight();
            m = localBitmap.getWidth();
            float f5 = k / m;
            Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
            ((Rect)localObject2).left = 0;
            ((Rect)localObject2).top = 0;
            ((Rect)localObject2).right = localBitmap.getWidth();
            this.jdField_a_of_type_AndroidGraphicsRect.bottom = localBitmap.getHeight();
            float f4;
            if (f3 > f5)
            {
              localObject2 = this.jdField_a_of_type_AndroidGraphicsRectF;
              f4 = i;
              ((RectF)localObject2).left = f4;
              f5 = (f1 - f5 * f2) / 2.0F;
              ((RectF)localObject2).top = f5;
              ((RectF)localObject2).right = (f4 + f2);
              ((RectF)localObject2).bottom = (f1 - f5);
            }
            else
            {
              f5 = f1 / f5;
              localObject2 = this.jdField_a_of_type_AndroidGraphicsRectF;
              f4 = i;
              f5 = (f2 - f5) / 2.0F;
              ((RectF)localObject2).left = (f4 + f5);
              ((RectF)localObject2).top = 0.0F;
              ((RectF)localObject2).right = (i + j - f5);
              ((RectF)localObject2).bottom = f1;
            }
            paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
            i += this.c + j;
          }
        }
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
  }
  
  public void setHotLevel(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_Int) && (paramInt <= this.jdField_b_of_type_Int))
    {
      this.d = paramInt;
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessage(Message.obtain(localHandler, 101, paramInt, 0));
      return;
    }
    throw new IllegalArgumentException(String.format("setHotLevel error, level[%s] is out of range", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopActiveLayout
 * JD-Core Version:    0.7.0.1
 */