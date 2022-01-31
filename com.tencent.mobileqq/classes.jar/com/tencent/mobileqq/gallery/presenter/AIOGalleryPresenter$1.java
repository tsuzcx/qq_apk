package com.tencent.mobileqq.gallery.presenter;

import advs;
import apsm;
import apsp;
import apsr;
import apss;
import apte;
import apud;
import apue;
import apug;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.widget.Gallery;

public class AIOGalleryPresenter$1
  implements Runnable
{
  public AIOGalleryPresenter$1(apte paramapte, long paramLong, apsr paramapsr, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Apsr.a.jdField_a_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      apue localapue = this.this$0.jdField_a_of_type_Apug.a();
      if (localapue != null) {
        localapue.a(this.jdField_a_of_type_Long);
      }
      advs.a(this.this$0.jdField_a_of_type_Apug.jdField_a_of_type_AndroidAppActivity, this.this$0.jdField_a_of_type_Apug.b);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Apss.b(this.jdField_a_of_type_Long) == null)
      {
        apsm.a().a().b("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Apsr.a.jdField_a_of_type_Long);
        return;
      }
      i = this.this$0.a(this.jdField_a_of_type_Apsr.a.jdField_a_of_type_Long);
    } while ((i < 0) || (this.this$0.jdField_a_of_type_Apug.jdField_a_of_type_Apud == null));
    this.this$0.jdField_a_of_type_Apug.jdField_a_of_type_Apud.notifyDataSetChanged();
    this.this$0.jdField_a_of_type_Apug.jdField_a_of_type_ComTencentWidgetGallery.setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.presenter.AIOGalleryPresenter.1
 * JD-Core Version:    0.7.0.1
 */