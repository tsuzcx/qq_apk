package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class EditVideoSave$3
  extends SimpleObserver<GenerateContext>
{
  EditVideoSave$3(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.a(5);
    paramGenerateContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateContext.a;
    SLog.b("EditVideoSave", "publishParam = " + paramGenerateContext);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), paramGenerateContext.b, i, j, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
      EditVideoSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave, paramGenerateContext.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (paramGenerateContext.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Int != 19) {
          break label296;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.b = (50000.0F / (float)paramGenerateContext.a);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.b == 0.0F) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.b = 1.0F;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.c();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.d();
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703854), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, HardCodeUtil.a(2131703766) + paramError, 0).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.3
 * JD-Core Version:    0.7.0.1
 */