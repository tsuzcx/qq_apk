import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPart;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.tribe.view.TribeEditVideoButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import cooperation.qzone.QZoneHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class okg
  extends SimpleObserver
{
  public okg(EditVideoPartManager paramEditVideoPartManager, GenerateContext paramGenerateContext, long paramLong) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.p();
    if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.h = false;
    }
    if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.h = false;
    }
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EditVideoPart)((Iterator)localObject1).next()).b(paramGenerateContext);
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      StoryReportor.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      i = ((Intent)localObject3).getIntExtra("uintype", -1);
      localObject2 = "";
      localObject1 = localObject2;
      if (i != -1)
      {
        localObject1 = localObject2;
        if (i != 1)
        {
          localObject1 = localObject2;
          if (i != 3000) {
            localObject1 = ((Intent)localObject3).getStringExtra("uin");
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (CameraControl.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        CaptureReportUtil.b(i, (String)localObject1);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (CameraControl.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      CaptureReportUtil.a(i, (String)localObject1);
      if (EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager, paramGenerateContext)) {
        EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      i = 2;
      break label242;
    }
    label406:
    if ((EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (EditVideoPartManager.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager) > 0))
    {
      i = EditVideoPartManager.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject1 = "0";; localObject1 = "1")
    {
      StoryReportor.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.h = false;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.f();
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b.isEmpty()) {
        break label918;
      }
      paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if (paramGenerateContext == null) {
        break;
      }
      if (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext);
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label648;
      }
      QZoneHelper.a(paramGenerateContext, "", (Intent)localObject1, -1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2131034158, 0);
      return;
    }
    label648:
    paramGenerateContext.startActivity((Intent)localObject1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2131034158, 0);
    return;
    label672:
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramGenerateContext);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject2);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent == null)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra(PublishParam.a, (Parcelable)localObject2);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() != 10) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList == null)) {
        break label896;
      }
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
      paramGenerateContext = null;
      i = -1;
      label797:
      if (!((Iterator)localObject3).hasNext()) {
        break label860;
      }
      EditVideoPart localEditVideoPart = (EditVideoPart)((Iterator)localObject3).next();
      if (!(localEditVideoPart instanceof TribeEditVideoButton)) {
        break label1044;
      }
      i = ((TribeEditVideoButton)localEditVideoPart).a();
      paramGenerateContext = ((TribeEditVideoButton)localEditVideoPart).a();
    }
    label896:
    label1044:
    for (;;)
    {
      break label797;
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidContentIntent;
      break;
      label860:
      ((Intent)localObject1).putExtra("theme_id", i);
      ((Intent)localObject1).putExtra("theme_name", paramGenerateContext);
      ((Intent)localObject1).putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a((Intent)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject2);
      return;
      label918:
      paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b.iterator();
      while (paramGenerateContext.hasNext()) {
        SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramGenerateContext.next());
      }
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b.size() + "次发表失败，请重试", 0).a();
      paramGenerateContext = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (paramGenerateContext != null) {
        paramGenerateContext.j();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.h = false;
      return;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(paramError);
    }
    StoryReportor.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b.add(paramError);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.h = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.f();
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), "发表失败，请重试", 0).a();
      paramError = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    } while (paramError == null);
    paramError.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okg
 * JD-Core Version:    0.7.0.1
 */