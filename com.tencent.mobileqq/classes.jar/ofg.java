import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPart;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

public class ofg
  extends SimpleObserver
{
  public ofg(EditWebVideoPartManager paramEditWebVideoPartManager, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.f();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.p();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.h = false;
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramGenerateContext);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.h = false;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.f();
    paramGenerateContext = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.a(EditVideoPlayerExport.class);
    if (paramGenerateContext != null) {
      paramGenerateContext.j();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.b.isEmpty())
    {
      paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if (paramGenerateContext != null)
      {
        ((EditWebVideoActivity)paramGenerateContext).d("视频合成中...");
        EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager, paramGenerateContext, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), "对不起，视频发送失败...", 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.b.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), "对不起，视频发送失败...", 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofg
 * JD-Core Version:    0.7.0.1
 */