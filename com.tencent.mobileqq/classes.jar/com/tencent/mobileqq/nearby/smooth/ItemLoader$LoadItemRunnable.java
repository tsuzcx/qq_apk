package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.SoftReference;
import java.util.Map;

final class ItemLoader$LoadItemRunnable<Params, Result>
  implements Runnable
{
  private final ItemLoader.ItemRequest<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  
  public ItemLoader$LoadItemRunnable(ItemLoader<Params, Result> paramItemLoader, ItemLoader.ItemRequest<Params, Result> paramItemRequest)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest = paramItemRequest;
  }
  
  public ItemLoader.ItemRequest<Params, Result> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.jdField_a_of_type_JavaLangInteger.intValue());
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.c = new SoftReference(localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.b != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new ItemLoader.DisplayItemRunnable(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest, false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.LoadItemRunnable
 * JD-Core Version:    0.7.0.1
 */