package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Process;
import atxm;
import java.lang.ref.SoftReference;
import java.util.Map;

final class ItemLoader$LoadItemRunnable<Params, Result>
  implements Runnable
{
  private final atxm<Params, Result> jdField_a_of_type_Atxm;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  
  public ItemLoader$LoadItemRunnable(ItemLoader<Params, Result> paramItemLoader, atxm<Params, Result> paramatxm)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Atxm = paramatxm;
  }
  
  public atxm<Params, Result> a()
  {
    return this.jdField_a_of_type_Atxm;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_Atxm.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Atxm)) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Atxm.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Atxm.jdField_a_of_type_JavaLangInteger.intValue());
      this.jdField_a_of_type_Atxm.c = new SoftReference(localObject);
    } while ((this.jdField_a_of_type_Atxm.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Atxm)));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new ItemLoader.DisplayItemRunnable(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_Atxm, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.LoadItemRunnable
 * JD-Core Version:    0.7.0.1
 */