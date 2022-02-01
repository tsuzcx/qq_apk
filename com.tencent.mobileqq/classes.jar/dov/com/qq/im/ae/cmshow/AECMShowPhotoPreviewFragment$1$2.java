package dov.com.qq.im.ae.cmshow;

import bniq;
import bnqm;

public class AECMShowPhotoPreviewFragment$1$2
  implements Runnable
{
  public AECMShowPhotoPreviewFragment$1$2(bniq parambniq, int paramInt, AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper != null))
    {
      if (!AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_Bniq.a))
      {
        AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_Bniq.a.getActivity(), this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper);
        return;
      }
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_Bniq.a, this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper);
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_Bniq.a, 2);
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_Bniq.a, System.currentTimeMillis());
    bnqm.a().g(1);
    if (this.jdField_a_of_type_Int == 4)
    {
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_Bniq.a).a(2, this.jdField_a_of_type_Bniq.a.getString(2131689677));
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_Bniq.a).a(2, this.jdField_a_of_type_Bniq.a.getString(2131690863));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment.1.2
 * JD-Core Version:    0.7.0.1
 */