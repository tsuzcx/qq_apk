package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.util.ContentSize;
import java.util.ArrayList;
import java.util.List;

public abstract class ViewDanmakuRender
  extends BaseDanmakuRender<ViewDanmaku>
{
  private SparseArray<List<ViewDanmakuRender.ViewHolder>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract ViewDanmakuRender.ViewHolder a(int paramInt);
  
  public ContentSize a(ViewDanmaku paramViewDanmaku)
  {
    int i = a(paramViewDanmaku.a());
    List localList = (List)this.a.get(i);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.a.put(i, localObject);
    }
    if (((List)localObject).isEmpty()) {
      ((List)localObject).add(a(i));
    }
    localObject = (ViewDanmakuRender.ViewHolder)((List)localObject).remove(0);
    a(i, (ViewDanmakuRender.ViewHolder)localObject, paramViewDanmaku);
    ((ViewDanmakuRender.ViewHolder)localObject).a(View.MeasureSpec.makeMeasureSpec(paramViewDanmaku.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramViewDanmaku.g(), -2147483648));
    ((ViewDanmakuRender.ViewHolder)localObject).a(0, 0, ((ViewDanmakuRender.ViewHolder)localObject).a(), ((ViewDanmakuRender.ViewHolder)localObject).b());
    paramViewDanmaku.a((ViewDanmakuRender.ViewHolder)localObject);
    paramViewDanmaku.b(((ViewDanmakuRender.ViewHolder)localObject).a());
    paramViewDanmaku.a(((ViewDanmakuRender.ViewHolder)localObject).b());
    return new ContentSize(((ViewDanmakuRender.ViewHolder)localObject).a(), ((ViewDanmakuRender.ViewHolder)localObject).b());
  }
  
  public abstract void a(int paramInt, ViewDanmakuRender.ViewHolder paramViewHolder, ViewDanmaku paramViewDanmaku);
  
  public void a(Canvas paramCanvas, ViewDanmaku paramViewDanmaku, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    paramDanmakuContext = paramViewDanmaku.a();
    if (paramDanmakuContext == null) {
      return;
    }
    if (!paramViewDanmaku.i())
    {
      paramDanmakuContext.a(View.MeasureSpec.makeMeasureSpec(paramDanmakuContext.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramDanmakuContext.b(), 1073741824));
      paramDanmakuContext.a(0, 0, paramDanmakuContext.a(), paramDanmakuContext.b());
      paramViewDanmaku.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramDanmakuContext.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(ViewDanmaku paramViewDanmaku)
  {
    ViewDanmakuRender.ViewHolder localViewHolder = paramViewDanmaku.a();
    if (localViewHolder != null)
    {
      int i = a(paramViewDanmaku.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localViewHolder);
      paramViewDanmaku.a(null);
    }
  }
  
  public boolean a(BaseDanmaku paramBaseDanmaku)
  {
    return paramBaseDanmaku instanceof ViewDanmaku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.ViewDanmakuRender
 * JD-Core Version:    0.7.0.1
 */