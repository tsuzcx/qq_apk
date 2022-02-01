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
  private static final int[] a = { 2130843576, 2130843577, 2130843577, 2130843578, 2130843579, 2130843580 };
  private Context b;
  private Handler c;
  private Handler d;
  private int e = 0;
  private int f = 10;
  private int g;
  private volatile int h = 0;
  private TroopActiveLayout.SizeableBitmapCache i;
  private volatile ArrayList<Bitmap> j;
  private final Object k = new Object();
  private Paint l;
  private ArrayList<Bitmap> m;
  private Rect n;
  private RectF o;
  private boolean p;
  
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
    Sizeable localSizeable = CommonImageCacheHelper.b("TroopActiveLayout_cache");
    paramAttributeSet = localSizeable;
    if (!(localSizeable instanceof TroopActiveLayout.SizeableBitmapCache))
    {
      paramAttributeSet = new TroopActiveLayout.SizeableBitmapCache(41702);
      CommonImageCacheHelper.a("TroopActiveLayout_cache", paramAttributeSet);
    }
    this.i = ((TroopActiveLayout.SizeableBitmapCache)paramAttributeSet);
    this.b = ???;
    this.c = new Handler(this);
    synchronized (this.k)
    {
      this.j = new ArrayList(this.f / 2 + 1);
      this.g = ScreenUtil.dip2px(3.0F);
      this.m = new ArrayList(this.f / 2 + 1);
      this.d = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
      this.l = new Paint();
      this.l.setAntiAlias(true);
      this.n = new Rect();
      this.o = new RectF();
      setHotLevel(this.h);
      this.p = "1103".equals(ThemeUtil.getCurrentThemeId());
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
    int i3 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    int i2 = 0;
    int i1 = 0;
    if ((i3 != -2147483648) && (i3 != 0))
    {
      if (i3 != 1073741824) {
        return 0;
      }
    }
    else {
      this.m.clear();
    }
    synchronized (this.k)
    {
      this.m.addAll(this.j);
      if (paramBoolean)
      {
        i2 = this.m.size();
        if (i2 <= 0) {
          return paramInt;
        }
        ??? = this.m.iterator();
        paramInt = i1;
        while (((Iterator)???).hasNext()) {
          paramInt += ((Bitmap)((Iterator)???).next()).getWidth();
        }
        paramInt += (i2 - 1) * this.g;
        i1 = getPaddingLeft();
        i2 = getPaddingRight();
      }
      else
      {
        ??? = this.m.iterator();
        for (paramInt = i2; ((Iterator)???).hasNext(); paramInt = Math.max(paramInt, ((Bitmap)((Iterator)???).next()).getHeight())) {}
        i1 = getPaddingTop();
        i2 = getPaddingBottom();
      }
      paramInt = i1 + i2 + paramInt;
      return paramInt;
    }
    for (;;)
    {
      throw localObject2;
    }
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
  
  private Bitmap[] a(int paramInt)
  {
    int i4 = getIconSize();
    Object localObject1 = this.i;
    int i3 = 0;
    int i2 = 0;
    localObject1 = (Bitmap)((TroopActiveLayout.SizeableBitmapCache)localObject1).get(Integer.valueOf(0));
    int i1;
    if (paramInt % 2 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Bitmap localBitmap;
    Object localObject2;
    if (i1 != 0)
    {
      localBitmap = (Bitmap)this.i.get(Integer.valueOf(paramInt));
      localObject2 = (Bitmap)this.i.get(Integer.valueOf(paramInt - 1));
      if ((localBitmap != null) && (localObject2 != null))
      {
        i1 = paramInt / 2;
        Bitmap[] arrayOfBitmap = new Bitmap[i4];
        paramInt = i2;
        while (paramInt < i1)
        {
          arrayOfBitmap[paramInt] = localObject2;
          paramInt += 1;
        }
        arrayOfBitmap[i1] = localBitmap;
        paramInt = i1 + 1;
        while (paramInt < i4)
        {
          arrayOfBitmap[paramInt] = localObject1;
          paramInt += 1;
        }
        return arrayOfBitmap;
      }
    }
    else
    {
      localBitmap = (Bitmap)this.i.get(Integer.valueOf(paramInt));
      if (localBitmap != null)
      {
        i2 = paramInt / 2;
        localObject2 = new Bitmap[i4];
        paramInt = i3;
        for (;;)
        {
          i1 = i2;
          if (paramInt >= i2) {
            break;
          }
          localObject2[paramInt] = localBitmap;
          paramInt += 1;
        }
        while (i1 < i4)
        {
          localObject2[i1] = localObject1;
          i1 += 1;
        }
        return localObject2;
      }
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    Bitmap[] arrayOfBitmap = a(paramInt);
    int i1 = 0;
    if (arrayOfBitmap == null)
    {
      ??? = this.d;
      ((Handler)???).sendMessage(Message.obtain((Handler)???, 102, paramInt, 0));
      return;
    }
    synchronized (this.k)
    {
      this.j.clear();
      int i2 = arrayOfBitmap.length;
      paramInt = i1;
      if (paramInt < i2)
      {
        Bitmap localBitmap = arrayOfBitmap[paramInt];
        if (localBitmap != null) {
          this.j.add(localBitmap);
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
  
  private void c(int paramInt)
  {
    Looper.myLooper();
    Looper.getMainLooper();
    int i5 = 1;
    if (paramInt % 2 == 1) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (i2 != 0) {
      i1 = paramInt - 1;
    } else {
      i1 = paramInt;
    }
    int i3 = i1;
    if (i1 == 0) {
      i3 = 2;
    }
    int i4;
    if (i2 != 0) {
      i4 = paramInt;
    } else {
      i4 = paramInt + 1;
    }
    if (!this.i.containsKey(Integer.valueOf(0)))
    {
      localObject1 = d(a[0]);
      if (localObject1 != null)
      {
        this.i.put(Integer.valueOf(0), localObject1);
      }
      else
      {
        i1 = 1;
        localObject2 = localObject1;
        break label141;
      }
    }
    else
    {
      localObject1 = (Bitmap)this.i.get(Integer.valueOf(0));
    }
    int i1 = 0;
    Object localObject2 = localObject1;
    label141:
    Bitmap localBitmap = null;
    int i2 = i1;
    Object localObject1 = localBitmap;
    if (i3 >= this.e)
    {
      i2 = i1;
      localObject1 = localBitmap;
      if (i3 <= this.f) {
        if (!this.i.containsKey(Integer.valueOf(i3)))
        {
          int i6 = paramInt / 2;
          if (i6 <= 0)
          {
            i2 = 1;
          }
          else
          {
            localObject1 = a;
            i2 = i6;
            if (i6 >= localObject1.length) {
              i2 = localObject1.length - 1;
            }
          }
          localObject1 = d(a[i2]);
          if (localObject1 != null)
          {
            this.i.put(Integer.valueOf(i3), localObject1);
            i2 = i1;
          }
          else
          {
            i2 = 1;
          }
        }
        else
        {
          localObject1 = (Bitmap)this.i.get(Integer.valueOf(i3));
          i2 = i1;
        }
      }
    }
    i1 = i2;
    if (localObject2 != null)
    {
      i1 = i2;
      if (localObject1 != null)
      {
        i1 = i2;
        if (i4 >= this.e)
        {
          i1 = i2;
          if (i4 <= this.f) {
            if (!this.i.containsKey(Integer.valueOf(i4)))
            {
              localBitmap = a((Bitmap)localObject1, localObject2);
              if (localBitmap != null)
              {
                this.i.put(Integer.valueOf(i4), localBitmap);
                i1 = i2;
              }
              else
              {
                i1 = 1;
              }
            }
            else
            {
              localBitmap = (Bitmap)this.i.get(Integer.valueOf(i4));
              i1 = i2;
            }
          }
        }
      }
    }
    if ((localObject2 == null) && (localObject1 == null)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i1 == 0) && (i2 == 0)) {
      i1 = i5;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      localObject1 = this.c;
      ((Handler)localObject1).sendMessage(Message.obtain((Handler)localObject1, 101, paramInt, 0));
    }
  }
  
  private Bitmap d(int paramInt)
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
  
  public int getHotLevel()
  {
    return this.h;
  }
  
  public int getIconSize()
  {
    return (this.f + 1) / 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 101)
    {
      if (i1 == 102) {
        c(paramMessage.arg1);
      }
    }
    else {
      b(paramMessage.arg1);
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i5 = getWidth();
    int i1 = getHeight();
    int i3 = getPaddingLeft();
    int i6 = getPaddingRight();
    int i4 = getPaddingTop();
    int i2 = getPaddingBottom();
    i3 = a(i3, 0, i5);
    i5 = a(i5 - i6, 0, i5);
    i4 = a(i4, 0, i1);
    i1 = a(i1 - i2, 0, i1);
    i2 = i5 - i3;
    i1 -= i4;
    if (i2 > 0)
    {
      if (i1 <= 0) {
        return;
      }
      this.m.clear();
      synchronized (this.k)
      {
        this.m.addAll(this.j);
        i3 = this.m.size();
        if (i3 <= 0) {
          return;
        }
        i2 = (i2 - this.g * (i3 - 1)) / i3;
        if (i2 <= 0) {
          return;
        }
        float f1 = i1;
        float f2 = i2;
        float f3 = f1 / f2;
        if (this.p) {
          this.l.setColorFilter(ThemeConstants.NIGHTMODE_COLORFILTER);
        }
        ??? = this.m.iterator();
        i1 = 0;
        while (((Iterator)???).hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Iterator)???).next();
          if (localBitmap != null)
          {
            i3 = localBitmap.getHeight();
            i4 = localBitmap.getWidth();
            float f5 = i3 / i4;
            Object localObject2 = this.n;
            ((Rect)localObject2).left = 0;
            ((Rect)localObject2).top = 0;
            ((Rect)localObject2).right = localBitmap.getWidth();
            this.n.bottom = localBitmap.getHeight();
            float f4;
            if (f3 > f5)
            {
              localObject2 = this.o;
              f4 = i1;
              ((RectF)localObject2).left = f4;
              f5 = (f1 - f5 * f2) / 2.0F;
              ((RectF)localObject2).top = f5;
              ((RectF)localObject2).right = (f4 + f2);
              ((RectF)localObject2).bottom = (f1 - f5);
            }
            else
            {
              f5 = f1 / f5;
              localObject2 = this.o;
              f4 = i1;
              f5 = (f2 - f5) / 2.0F;
              ((RectF)localObject2).left = (f4 + f5);
              ((RectF)localObject2).top = 0.0F;
              ((RectF)localObject2).right = (i1 + i2 - f5);
              ((RectF)localObject2).bottom = f1;
            }
            paramCanvas.drawBitmap(localBitmap, this.n, this.o, this.l);
            i1 += this.g + i2;
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
    if ((paramInt >= this.e) && (paramInt <= this.f))
    {
      this.h = paramInt;
      Handler localHandler = this.c;
      localHandler.sendMessage(Message.obtain(localHandler, 101, paramInt, 0));
      return;
    }
    throw new IllegalArgumentException(String.format("setHotLevel error, level[%s] is out of range", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopActiveLayout
 * JD-Core Version:    0.7.0.1
 */