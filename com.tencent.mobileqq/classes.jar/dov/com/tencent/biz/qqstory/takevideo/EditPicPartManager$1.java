package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.AutoSaveUtils;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;

class EditPicPartManager$1
  extends SimpleObserver<GenerateContext>
{
  EditPicPartManager$1(EditPicPartManager paramEditPicPartManager) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
    Activity localActivity = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      SLog.b("EditPicActivity.EditPicPartManager", "picDestPath = " + paramGenerateContext.a.b);
      localIntent = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(paramGenerateContext);
      if (!paramGenerateContext.a.c)
      {
        if (paramGenerateContext.a.c) {
          break label292;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.a.b();
      SLog.b("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b());
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) {
        switch (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
        case 108: 
        case 109: 
        default: 
          if (paramGenerateContext.a()) {
            AutoSaveUtils.b(true, paramGenerateContext.a.b);
          }
          break;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      EditPicPartManager.a(this.a);
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject)) || (!bool)) {
        break label332;
      }
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, localIntent, 2130772034, 0);
      return;
      label292:
      bool = false;
      break;
      AutoSaveUtils.b(true, paramGenerateContext.a.b);
      continue;
      if (paramGenerateContext.a()) {
        AutoSaveUtils.a(paramGenerateContext.a.b, true);
      }
    }
    label332:
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 133)))
    {
      paramGenerateContext = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      EditPicPartManager.a(this.a, localIntent);
      AIOLongShotHelper.a(localActivity, paramGenerateContext, new EditPicPartManager.1.1(this));
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 125))
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, localIntent, 2130772034, 0, false);
      ReportController.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()))
      {
        EditPicPartManager.a(this.a, localIntent);
        ReportController.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 2) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h()))
    {
      if (!paramGenerateContext.a()) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, localIntent, 2130772034, 0, false);
        return;
      }
    }
    if (localIntent.getBooleanExtra("input_full_screen_mode", false))
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, localIntent, 2130772034, 0, false);
      return;
    }
    this.a.a(localActivity, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703709), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager.1
 * JD-Core Version:    0.7.0.1
 */