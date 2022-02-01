package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class EditVideoPartManager$4
  extends SimpleObserver<GenerateContext>
{
  EditVideoPartManager$4(EditVideoPartManager paramEditVideoPartManager, long paramLong) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    boolean bool = true;
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.o();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Boolean = false;
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EditVideoPart)((Iterator)localObject1).next()).b(paramGenerateContext);
    }
    int i;
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      StoryReportor.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      StoryReportor.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label235;
      }
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    label235:
    do
    {
      return;
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label907;
      }
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() == null);
    Object localObject2;
    label380:
    int j;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
      localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      if ((AECameraEntry.a((Intent)localObject2)) && (!AECameraEntry.e((Intent)localObject2)) && (!AECameraEntry.f((Intent)localObject2)) && (!AECameraEntry.d((Intent)localObject2))) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().sendBroadcast(new Intent("action_fire_create_video_story"));
      }
      do
      {
        do
        {
          localObject1 = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
          SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(paramGenerateContext);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a((Intent)localObject2, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject1, paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
        } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton == null);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton.a(HardCodeUtil.a(2131703780), false, 0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton.a(2);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton.a(5);
        localObject1 = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() == null);
      paramGenerateContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      if (paramGenerateContext == null) {
        break label1028;
      }
      j = paramGenerateContext.getIntExtra("sv_total_frame_count", 0);
      i = paramGenerateContext.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), ((PublishParam)localObject1).b, i, j, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton.a(((PublishParam)localObject1).b);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).e != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (paramGenerateContext != null)
        {
          localIntent.putExtra("widgetinfo", paramGenerateContext.getStringExtra("widgetinfo"));
          localObject2 = paramGenerateContext.getStringExtra("key_camera_material_name");
          AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", paramGenerateContext.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!AECameraEntry.l.a(i)) && (!AECameraEntry.k.a(i))) {
          break label843;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton.a(5, ((PublishParam)localObject1).jdField_a_of_type_Long);
        return;
        bool = false;
        break;
        label843:
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 211);
      }
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() != 2) || (!EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager))) {
        break label380;
      }
      AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "in AIO sending video ark msg process");
      EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, paramGenerateContext);
      return;
      label907:
      paramGenerateContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.iterator();
      while (paramGenerateContext.hasNext()) {
        SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramGenerateContext.next());
      }
      QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_JavaUtilList.size() + HardCodeUtil.a(2131703893), 0).a();
      paramGenerateContext = (EditVideoPlayerExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (paramGenerateContext == null) {
        break;
      }
      paramGenerateContext.m();
      return;
      label1028:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    StoryReportor.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.4
 * JD-Core Version:    0.7.0.1
 */