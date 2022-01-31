package com.tencent.mobileqq.gallery.presenter;

import aegr;
import aqmb;
import aqme;
import aqmg;
import aqmh;
import aqnd;
import aqod;
import aqoe;
import aqog;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.widget.Gallery;

public class AIOGalleryPresenter$1
  implements Runnable
{
  public AIOGalleryPresenter$1(aqnd paramaqnd, long paramLong, aqmg paramaqmg, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Aqmg.a.jdField_a_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      aqoe localaqoe = this.this$0.jdField_a_of_type_Aqog.a();
      if (localaqoe != null) {
        localaqoe.a(this.jdField_a_of_type_Long);
      }
      aegr.a(this.this$0.jdField_a_of_type_Aqog.jdField_a_of_type_AndroidAppActivity, this.this$0.jdField_a_of_type_Aqog.b);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Aqmh.b(this.jdField_a_of_type_Long) == null)
      {
        aqmb.a().a().b("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Aqmg.a.jdField_a_of_type_Long);
        return;
      }
      i = this.this$0.a(this.jdField_a_of_type_Aqmg.a.jdField_a_of_type_Long);
    } while ((i < 0) || (this.this$0.jdField_a_of_type_Aqog.jdField_a_of_type_Aqod == null));
    this.this$0.jdField_a_of_type_Aqog.jdField_a_of_type_Aqod.notifyDataSetChanged();
    this.this$0.jdField_a_of_type_Aqog.jdField_a_of_type_ComTencentWidgetGallery.setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.presenter.AIOGalleryPresenter.1
 * JD-Core Version:    0.7.0.1
 */