package dov.com.qq.im.capture.paster;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.HashMap;

final class CaptureComboNormalPaster$2
  implements URLDrawable.URLDrawableListener
{
  CaptureComboNormalPaster$2(String paramString1, String paramString2, NormalFacePackage paramNormalFacePackage, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener, int paramInt3) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    CaptureComboNormalPaster.a.remove(this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "applyNormalPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "urlDrawableListener onLoadSuccessed");
    }
    CaptureComboNormalPaster.a(paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper, this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener, this.jdField_c_of_type_Int);
    CaptureComboNormalPaster.a.remove(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboNormalPaster.2
 * JD-Core Version:    0.7.0.1
 */