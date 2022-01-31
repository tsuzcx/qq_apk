package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import atbg;
import java.lang.ref.SoftReference;

final class ItemLoader$DisplayItemRunnable<Params, Result>
  implements Runnable
{
  private final atbg<Params, Result> jdField_a_of_type_Atbg;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  private final boolean jdField_a_of_type_Boolean;
  
  public ItemLoader$DisplayItemRunnable(ItemLoader<Params, Result> paramItemLoader, atbg<Params, Result> paramatbg, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Atbg = paramatbg;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Atbg)) {}
    View localView;
    do
    {
      return;
      if (this.jdField_a_of_type_Atbg.c == null) {
        throw new IllegalStateException("Result should not be null when displaying an item part");
      }
      localView = (View)this.jdField_a_of_type_Atbg.b.get();
    } while (localView == null);
    Object localObject = this.jdField_a_of_type_Atbg.c.get();
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_Atbg.a.intValue(), this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.DisplayItemRunnable
 * JD-Core Version:    0.7.0.1
 */