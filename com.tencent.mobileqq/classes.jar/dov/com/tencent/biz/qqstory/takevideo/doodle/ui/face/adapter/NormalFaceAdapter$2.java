package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;

class NormalFaceAdapter$2
  implements URLDrawable.URLDrawableListener
{
  NormalFaceAdapter$2(NormalFaceAdapter paramNormalFaceAdapter, String paramString1, NormalFacePackage paramNormalFacePackage, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.b("NormalFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SLog.b("NormalFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    NormalFaceAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    NormalFaceAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage, paramURLDrawable, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter.2
 * JD-Core Version:    0.7.0.1
 */