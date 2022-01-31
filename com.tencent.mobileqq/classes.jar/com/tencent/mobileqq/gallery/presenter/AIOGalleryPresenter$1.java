package com.tencent.mobileqq.gallery.presenter;

import aegp;
import aqmd;
import aqmg;
import aqmi;
import aqmj;
import aqnf;
import aqof;
import aqog;
import aqoi;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.widget.Gallery;

public class AIOGalleryPresenter$1
  implements Runnable
{
  public AIOGalleryPresenter$1(aqnf paramaqnf, long paramLong, aqmi paramaqmi, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Aqmi.a.jdField_a_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      aqog localaqog = this.this$0.jdField_a_of_type_Aqoi.a();
      if (localaqog != null) {
        localaqog.a(this.jdField_a_of_type_Long);
      }
      aegp.a(this.this$0.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidAppActivity, this.this$0.jdField_a_of_type_Aqoi.b);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Aqmj.b(this.jdField_a_of_type_Long) == null)
      {
        aqmd.a().a().b("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Aqmi.a.jdField_a_of_type_Long);
        return;
      }
      i = this.this$0.a(this.jdField_a_of_type_Aqmi.a.jdField_a_of_type_Long);
    } while ((i < 0) || (this.this$0.jdField_a_of_type_Aqoi.jdField_a_of_type_Aqof == null));
    this.this$0.jdField_a_of_type_Aqoi.jdField_a_of_type_Aqof.notifyDataSetChanged();
    this.this$0.jdField_a_of_type_Aqoi.jdField_a_of_type_ComTencentWidgetGallery.setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.presenter.AIOGalleryPresenter.1
 * JD-Core Version:    0.7.0.1
 */