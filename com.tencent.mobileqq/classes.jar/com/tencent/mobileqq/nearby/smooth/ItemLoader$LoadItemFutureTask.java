package com.tencent.mobileqq.nearby.smooth;

import atbg;
import java.util.concurrent.FutureTask;

final class ItemLoader$LoadItemFutureTask<Params, Result>
  extends FutureTask<ItemLoader.LoadItemRunnable<Params, Result>>
  implements Comparable<LoadItemFutureTask<Params, Result>>
{
  private final ItemLoader.LoadItemRunnable<Params, Result> a;
  
  public int a(LoadItemFutureTask<Params, Result> paramLoadItemFutureTask)
  {
    atbg localatbg = this.a.a();
    paramLoadItemFutureTask = paramLoadItemFutureTask.a.a();
    if ((localatbg.b != null) && (paramLoadItemFutureTask.b == null)) {
      return -1;
    }
    if ((localatbg.b == null) && (paramLoadItemFutureTask.b != null)) {
      return 1;
    }
    if (!localatbg.jdField_a_of_type_JavaLangInteger.equals(paramLoadItemFutureTask.jdField_a_of_type_JavaLangInteger)) {
      return localatbg.jdField_a_of_type_JavaLangInteger.compareTo(paramLoadItemFutureTask.jdField_a_of_type_JavaLangInteger);
    }
    return localatbg.jdField_a_of_type_JavaLangLong.compareTo(paramLoadItemFutureTask.jdField_a_of_type_JavaLangLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.LoadItemFutureTask
 * JD-Core Version:    0.7.0.1
 */