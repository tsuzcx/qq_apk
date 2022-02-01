package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.Iterator;
import java.util.List;

class EditWebVideoPartManager$1
  extends SimpleObserver<GenerateContext>
{
  EditWebVideoPartManager$1(EditWebVideoPartManager paramEditWebVideoPartManager) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().overridePendingTransition(0, 0);
    this.a.o();
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).b(paramGenerateContext);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
    localObject = (EditVideoPlayerExport)this.a.a(EditVideoPlayerExport.class);
    if (localObject != null) {
      ((EditVideoPlayerExport)localObject).m();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).a(HardCodeUtil.a(2131703993));
        EditWebVideoPartManager.a(this.a, (Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, paramGenerateContext.a);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703989), 0).a();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703992), 0).a();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.1
 * JD-Core Version:    0.7.0.1
 */