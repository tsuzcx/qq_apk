package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import java.lang.ref.SoftReference;

final class ItemLoader$DisplayItemRunnable<Params, Result>
  implements Runnable
{
  private final ItemLoader<Params, Result> a;
  private final ItemLoader.ItemRequest<Params, Result> b;
  private final boolean c;
  
  public ItemLoader$DisplayItemRunnable(ItemLoader<Params, Result> paramItemLoader, ItemLoader.ItemRequest<Params, Result> paramItemRequest, boolean paramBoolean)
  {
    this.a = paramItemLoader;
    this.b = paramItemRequest;
    this.c = paramBoolean;
  }
  
  public void run()
  {
    if (this.a.a(this.b)) {
      return;
    }
    if (this.b.c != null)
    {
      View localView = (View)this.b.b.get();
      if (localView == null) {
        return;
      }
      Object localObject = this.b.c.get();
      this.a.a(localView, localObject, this.b.i.intValue(), this.c);
      return;
    }
    throw new IllegalStateException("Result should not be null when displaying an item part");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.DisplayItemRunnable
 * JD-Core Version:    0.7.0.1
 */