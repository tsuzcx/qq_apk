package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelItemInfo;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager;

class EditPicSave$1$1
  implements Runnable
{
  EditPicSave$1$1(EditPicSave.1 param1) {}
  
  public void run()
  {
    boolean bool = true;
    if (EditPicSave.a(this.a.a)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (EditPicSave.a(this.a.a) == 20) {}
      for (i = 1;; i = 0)
      {
        localObject1 = EditPicSave.a(this.a.a);
        this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.c();
        if (this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() != 102) {
          break;
        }
        EditPicSave.a(this.a.a, this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
        return;
      }
      if ((AECameraEntry.e(this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())) || (AECameraEntry.f(this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", EditPicSave.a(this.a.a));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().sendBroadcast((Intent)localObject1);
        this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().setResult(-1, this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent());
        this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() != 14) {
        break;
      }
      localObject2 = this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    } while (AECameraEntry.a((Intent)localObject2));
    this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b = false;
    this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    if (EditPicSave.b(this.a.a))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        ShortVideoForwardManager.a(this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), EditPicSave.a(this.a.a), bool);
        return;
        bool = false;
      }
      SendPanelManager.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      AEQLog.b("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      SendPanelManager.a().b((String)localObject2);
      SendPanelManager.a().a(((SendPanelItemInfo)localObject1).jdField_a_of_type_JavaLangString, ((SendPanelItemInfo)localObject1).jdField_a_of_type_Int, EditPicSave.a(this.a.a), "", false);
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, HardCodeUtil.a(2131703714), 0).a();
    return;
    QQToast.a(this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 2, HardCodeUtil.a(2131703716), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */