package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import java.lang.ref.SoftReference;
import java.util.concurrent.Future;

final class ItemLoader$ItemRequest<Params, Result>
{
  public SoftReference<View> a;
  public SoftReference<View> b;
  public SoftReference<Result> c;
  public Future<?> d;
  public Long e;
  public final String f;
  public final Params g;
  public final int h;
  public final Integer i;
  
  public ItemLoader$ItemRequest(String paramString, View paramView1, View paramView2, Params paramParams, int paramInt1, int paramInt2, long paramLong)
  {
    this.f = paramString;
    this.a = new SoftReference(paramView1);
    if (paramView2 != null) {
      paramString = new SoftReference(paramView2);
    } else {
      paramString = null;
    }
    this.b = paramString;
    this.g = paramParams;
    this.h = paramInt1;
    this.i = Integer.valueOf(paramInt2);
    this.c = null;
    this.e = Long.valueOf(paramLong);
    this.d = null;
  }
  
  public ItemLoader$ItemRequest(String paramString, View paramView, Params paramParams, int paramInt1, int paramInt2, long paramLong)
  {
    this(paramString, paramView, null, paramParams, paramInt1, paramInt2, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.ItemRequest
 * JD-Core Version:    0.7.0.1
 */