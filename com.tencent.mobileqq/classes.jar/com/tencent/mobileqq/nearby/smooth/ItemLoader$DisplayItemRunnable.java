package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import java.lang.ref.SoftReference;

final class ItemLoader$DisplayItemRunnable<Params, Result>
  implements Runnable
{
  private final ItemLoader.ItemRequest<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final boolean jdField_a_of_type_Boolean;
  
  public ItemLoader$DisplayItemRunnable(ItemLoader<Params, Result> paramItemLoader, ItemLoader.ItemRequest<Params, Result> paramItemRequest, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest = paramItemRequest;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.c != null)
    {
      View localView = (View)this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.b.get();
      if (localView == null) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.c.get();
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$ItemRequest.a.intValue(), this.jdField_a_of_type_Boolean);
      return;
    }
    throw new IllegalStateException("Result should not be null when displaying an item part");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.DisplayItemRunnable
 * JD-Core Version:    0.7.0.1
 */