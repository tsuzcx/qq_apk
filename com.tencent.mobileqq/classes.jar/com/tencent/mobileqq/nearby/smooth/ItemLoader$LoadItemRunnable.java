package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.SoftReference;
import java.util.Map;

final class ItemLoader$LoadItemRunnable<Params, Result>
  implements Runnable
{
  private final ItemLoader<Params, Result> a;
  private final ItemLoader.ItemRequest<Params, Result> b;
  
  public ItemLoader$LoadItemRunnable(ItemLoader<Params, Result> paramItemLoader, ItemLoader.ItemRequest<Params, Result> paramItemRequest)
  {
    this.a = paramItemLoader;
    this.b = paramItemRequest;
  }
  
  public ItemLoader.ItemRequest<Params, Result> a()
  {
    return this.b;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.a.c.remove(this.b.f);
    if (this.a.a(this.b)) {
      return;
    }
    Object localObject = this.a.b(this.b.g, this.b.i.intValue());
    this.b.c = new SoftReference(localObject);
    if (this.b.b != null)
    {
      if (this.a.a(this.b)) {
        return;
      }
      this.a.a.post(new ItemLoader.DisplayItemRunnable(this.a, this.b, false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.LoadItemRunnable
 * JD-Core Version:    0.7.0.1
 */