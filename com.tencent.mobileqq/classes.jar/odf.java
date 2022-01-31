import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditPicPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import cooperation.qzone.QZoneHelper;

public class odf
  extends SimpleObserver
{
  public odf(EditPicPartManager paramEditPicPartManager, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    int i = 1;
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.f();
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a.a)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.f = paramGenerateContext.a.jdField_b_of_type_JavaLangString;
    }
    paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramGenerateContext != null) && (!paramGenerateContext.isFinishing()))
    {
      SLog.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label369;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramGenerateContext, PhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramGenerateContext.startActivity((Intent)localObject1);
        paramGenerateContext.setResult(-1);
        paramGenerateContext.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramGenerateContext = (GenerateContext)localObject1;
      if (j != -1)
      {
        paramGenerateContext = (GenerateContext)localObject1;
        if (j != 1)
        {
          paramGenerateContext = (GenerateContext)localObject1;
          if (j != 3000) {
            paramGenerateContext = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (CameraControl.a().a != 1) {
        break label392;
      }
    }
    for (;;)
    {
      CaptureReportUtil.a(i, paramGenerateContext);
      return;
      if (!bool2)
      {
        QZoneHelper.a(paramGenerateContext, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2131034158, 0);
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(-1, (Intent)localObject1, 2131034158, 0);
      break;
      label369:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.a(paramGenerateContext, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label392:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.f();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), "取消编辑", 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.f();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), "图片合成失败，请重试 : " + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odf
 * JD-Core Version:    0.7.0.1
 */