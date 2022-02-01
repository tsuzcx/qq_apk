package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Process;
import aymv;
import java.lang.ref.SoftReference;
import java.util.Map;

final class ItemLoader$LoadItemRunnable<Params, Result>
  implements Runnable
{
  private final aymv<Params, Result> jdField_a_of_type_Aymv;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  
  public ItemLoader$LoadItemRunnable(ItemLoader<Params, Result> paramItemLoader, aymv<Params, Result> paramaymv)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Aymv = paramaymv;
  }
  
  public aymv<Params, Result> a()
  {
    return this.jdField_a_of_type_Aymv;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_Aymv.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aymv)) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aymv.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aymv.jdField_a_of_type_JavaLangInteger.intValue());
      this.jdField_a_of_type_Aymv.c = new SoftReference(localObject);
    } while ((this.jdField_a_of_type_Aymv.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aymv)));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new ItemLoader.DisplayItemRunnable(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_Aymv, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.LoadItemRunnable
 * JD-Core Version:    0.7.0.1
 */