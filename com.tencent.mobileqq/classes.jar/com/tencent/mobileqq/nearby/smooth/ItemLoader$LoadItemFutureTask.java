package com.tencent.mobileqq.nearby.smooth;

import java.util.concurrent.FutureTask;

final class ItemLoader$LoadItemFutureTask<Params, Result>
  extends FutureTask<ItemLoader.LoadItemRunnable<Params, Result>>
  implements Comparable<LoadItemFutureTask<Params, Result>>
{
  private final ItemLoader.LoadItemRunnable<Params, Result> a;
  
  public ItemLoader$LoadItemFutureTask(ItemLoader.LoadItemRunnable<Params, Result> paramLoadItemRunnable)
  {
    super(paramLoadItemRunnable, null);
    this.a = paramLoadItemRunnable;
  }
  
  public int a(LoadItemFutureTask<Params, Result> paramLoadItemFutureTask)
  {
    ItemLoader.ItemRequest localItemRequest = this.a.a();
    paramLoadItemFutureTask = paramLoadItemFutureTask.a.a();
    if ((localItemRequest.b != null) && (paramLoadItemFutureTask.b == null)) {
      return -1;
    }
    if ((localItemRequest.b == null) && (paramLoadItemFutureTask.b != null)) {
      return 1;
    }
    if (!localItemRequest.jdField_a_of_type_JavaLangInteger.equals(paramLoadItemFutureTask.jdField_a_of_type_JavaLangInteger)) {
      return localItemRequest.jdField_a_of_type_JavaLangInteger.compareTo(paramLoadItemFutureTask.jdField_a_of_type_JavaLangInteger);
    }
    return localItemRequest.jdField_a_of_type_JavaLangLong.compareTo(paramLoadItemFutureTask.jdField_a_of_type_JavaLangLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.LoadItemFutureTask
 * JD-Core Version:    0.7.0.1
 */