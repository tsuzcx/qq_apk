package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;

class InformationFaceAdapter$1
  implements URLDrawable.URLDrawableListener
{
  InformationFaceAdapter$1(InformationFaceAdapter paramInformationFaceAdapter, String paramString, InfomationFacePackage.Item paramItem) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    InformationFaceAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SLog.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    InformationFaceAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    InformationFaceAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage$Item.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.1
 * JD-Core Version:    0.7.0.1
 */