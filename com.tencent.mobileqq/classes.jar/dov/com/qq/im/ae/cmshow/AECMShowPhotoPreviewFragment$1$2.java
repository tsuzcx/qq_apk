package dov.com.qq.im.ae.cmshow;

import dov.com.qq.im.ae.report.AEBaseDataReporter;

class AECMShowPhotoPreviewFragment$1$2
  implements Runnable
{
  AECMShowPhotoPreviewFragment$1$2(AECMShowPhotoPreviewFragment.1 param1, int paramInt, AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper != null))
    {
      if (!AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a))
      {
        AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a.getActivity(), this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper);
        return;
      }
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a, this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper);
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a, 2);
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a, System.currentTimeMillis());
    AEBaseDataReporter.a().d(1);
    if (this.jdField_a_of_type_Int == 4)
    {
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a).a(2, this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a.getString(2131689685));
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a).a(2, this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment$1.a.getString(2131690964));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment.1.2
 * JD-Core Version:    0.7.0.1
 */