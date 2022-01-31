package com.tencent.mobileqq.gallery.view;

import apsm;
import apsp;
import apte;
import apub;

public class AIOGalleryActivity$2$1
  implements Runnable
{
  public AIOGalleryActivity$2$1(apub paramapub, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.jdField_a_of_type_Apub.a) != null)
    {
      apsm.a().a().a("IAIOImageProviderCallBack", 4, "IAIOImageProviderCallBack.notifyImageResult():isPart " + this.jdField_a_of_type_Boolean);
      AIOGalleryActivity.a(this.jdField_a_of_type_Apub.a).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.AIOGalleryActivity.2.1
 * JD-Core Version:    0.7.0.1
 */