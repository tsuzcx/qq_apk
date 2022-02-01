package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelItemInfo;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager;

class EditVideoStoryButton$1
  implements Runnable
{
  EditVideoStoryButton$1(EditVideoStoryButton paramEditVideoStoryButton, Intent paramIntent, boolean paramBoolean, SendPanelItemInfo paramSendPanelItemInfo) {}
  
  public void run()
  {
    boolean bool = false;
    if (!EditVideoStoryButton.a(this.this$0)) {
      this.this$0.i();
    }
    String str1;
    String str2;
    if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() != 102)
    {
      str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
      if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
        bool = true;
      }
      AEQLog.b("EditVideoStoryButton", "jumpQzoneShuoshuoDirect=" + bool);
      if (this.jdField_a_of_type_Boolean)
      {
        SendPanelManager.a().a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("widgetinfo"));
        String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_camera_material_name");
        AEQLog.b("EditVideoStoryButton", "onPostRun---takeSameName=" + str3);
        SendPanelManager.a().b(str3);
        SendPanelManager.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, str1, str2, true);
      }
    }
    else
    {
      return;
    }
    if (EditVideoStoryButton.a(this.this$0))
    {
      AEQLog.b("EditVideoStoryButton", "arkViewId is not empty, doUploadAndForwardVideoArkMsg");
      EditVideoStoryButton.a(this.this$0, str1);
      return;
    }
    ShortVideoForwardManager.a(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), str1, str2, bool, "caller_aecamera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1
 * JD-Core Version:    0.7.0.1
 */