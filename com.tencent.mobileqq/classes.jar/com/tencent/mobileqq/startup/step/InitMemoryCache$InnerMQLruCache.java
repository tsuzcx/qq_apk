package com.tencent.mobileqq.startup.step;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.imageloader.Utils;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;

class InitMemoryCache$InnerMQLruCache
  extends MQLruCache<String, Object>
{
  public InitMemoryCache$InnerMQLruCache(Integer paramInteger)
  {
    super(paramInteger.intValue());
  }
  
  protected int a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Pair)) {
      return ((Integer)((Pair)paramObject).second).intValue();
    }
    if ((paramObject instanceof Bitmap))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    if ((paramObject instanceof BitmapDrawable))
    {
      paramObject = ((BitmapDrawable)paramObject).getBitmap();
      if (paramObject != null) {
        return paramObject.getRowBytes() * paramObject.getHeight();
      }
    }
    else if ((paramObject instanceof CloseableBitmap))
    {
      paramObject = ((CloseableBitmap)paramObject).b();
      if (paramObject != null) {
        return Utils.a(paramObject);
      }
    }
    else if ((paramObject instanceof Sizeable))
    {
      return ((Sizeable)paramObject).getByteSize();
    }
    MemoryClearManager.a(paramString, MemoryClearManager.v);
    return 204800;
  }
  
  public Object a(String paramString, Object paramObject, byte paramByte)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof CloseableBitmap)) {
      localObject = ((CloseableBitmap)paramObject).d();
    }
    return super.put(paramString, localObject, paramByte);
  }
  
  public void a(String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof CloseableBitmap)) {
      ((CloseableBitmap)paramObject1).a();
    }
  }
  
  public Object b(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof CloseableBitmap)) {
      localObject = ((CloseableBitmap)paramObject).d();
    }
    return super.put(paramString, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache.InnerMQLruCache
 * JD-Core Version:    0.7.0.1
 */