package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Process;
import avoq;
import java.lang.ref.SoftReference;
import java.util.Map;

final class ItemLoader$LoadItemRunnable<Params, Result>
  implements Runnable
{
  private final avoq<Params, Result> jdField_a_of_type_Avoq;
  private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  
  public ItemLoader$LoadItemRunnable(ItemLoader<Params, Result> paramItemLoader, avoq<Params, Result> paramavoq)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
    this.jdField_a_of_type_Avoq = paramavoq;
  }
  
  public avoq<Params, Result> a()
  {
    return this.jdField_a_of_type_Avoq;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.b.remove(this.jdField_a_of_type_Avoq.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Avoq)) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Avoq.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Avoq.jdField_a_of_type_JavaLangInteger.intValue());
      this.jdField_a_of_type_Avoq.c = new SoftReference(localObject);
    } while ((this.jdField_a_of_type_Avoq.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Avoq)));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a.post(new ItemLoader.DisplayItemRunnable(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_Avoq, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader.LoadItemRunnable
 * JD-Core Version:    0.7.0.1
 */