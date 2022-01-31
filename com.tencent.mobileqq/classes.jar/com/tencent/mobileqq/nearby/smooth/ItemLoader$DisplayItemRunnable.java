package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import atxm;
import java.lang.ref.SoftReference;

final class ItemLoader$DisplayItemRunnable<Params, Result>
  implements Runnable
{
  private final atxm<Params, Result> jdField_a_of_type_Atxm;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final boolean jdField_a_of_type_Boolean;
  
  public ItemLoader$DisplayItemRunnable(ItemLoader<Params, Result> paramItemLoader, atxm<Params, Result> paramatxm, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Atxm = paramatxm;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Atxm)) {}
    View localView;
    do
    {
      return;
      if (this.jdField_a_of_type_Atxm.c == null) {
        throw new IllegalStateException("Result should not be null when displaying an item part");
      }
      localView = (View)this.jdField_a_of_type_Atxm.b.get();
    } while (localView == null);
    Object localObject = this.jdField_a_of_type_Atxm.c.get();
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_Atxm.a.intValue(), this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.DisplayItemRunnable
 * JD-Core Version:    0.7.0.1
 */