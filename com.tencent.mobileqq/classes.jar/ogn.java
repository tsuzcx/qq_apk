import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoSave;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class ogn
  extends SimpleObserver
{
  public ogn(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.a(5);
    paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a;
    SLog.b("EditVideoSave", "publishParam = " + paramGenerateContext);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      if (localIntent == null) {
        break label199;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), paramGenerateContext.b, i, j);
      EditVideoSave.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave, paramGenerateContext.b);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.b = ((int)(7000.0D / paramGenerateContext.a * 4.0D));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.e();
      return;
      label199:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.h();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), "取消保存", 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, "保存失败，请重试 : " + paramError, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogn
 * JD-Core Version:    0.7.0.1
 */