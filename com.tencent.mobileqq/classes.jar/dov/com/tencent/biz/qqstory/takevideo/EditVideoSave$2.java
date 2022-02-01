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

class EditVideoSave$2
  extends SimpleObserver<GenerateContext>
{
  EditVideoSave$2(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.a(5);
    paramGenerateContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateContext.a;
    SLog.b("EditVideoSave", "publishParam = " + paramGenerateContext);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      if (localIntent == null) {
        break label292;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), paramGenerateContext.b, i, j, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
      boolean bool;
      if (paramGenerateContext.e != 0)
      {
        bool = true;
        localIntent.putExtra("video_edit_flag", bool);
        EditVideoSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave, paramGenerateContext.b);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Int != 19) {
          break label260;
        }
        localIntent.putExtra("requestCode", 222);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.b = (7000.0F / (float)paramGenerateContext.a * 4.0F);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.c();
        return;
        bool = false;
        break;
        label260:
        localIntent.putExtra("requestCode", 111);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 111);
      }
      label292:
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
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703811), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, HardCodeUtil.a(2131703774) + paramError, 0).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.2
 * JD-Core Version:    0.7.0.1
 */