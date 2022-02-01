package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import aymv;
import java.lang.ref.SoftReference;

final class ItemLoader$DisplayItemRunnable<Params, Result>
  implements Runnable
{
  private final aymv<Params, Result> jdField_a_of_type_Aymv;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final boolean jdField_a_of_type_Boolean;
  
  public ItemLoader$DisplayItemRunnable(ItemLoader<Params, Result> paramItemLoader, aymv<Params, Result> paramaymv, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Aymv = paramaymv;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aymv)) {}
    View localView;
    do
    {
      return;
      if (this.jdField_a_of_type_Aymv.c == null) {
        throw new IllegalStateException("Result should not be null when displaying an item part");
      }
      localView = (View)this.jdField_a_of_type_Aymv.b.get();
    } while (localView == null);
    Object localObject = this.jdField_a_of_type_Aymv.c.get();
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_Aymv.a.intValue(), this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.DisplayItemRunnable
 * JD-Core Version:    0.7.0.1
 */