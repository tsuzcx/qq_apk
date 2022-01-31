package dov.com.tencent.biz.qqstory.takevideo;

import ancc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.qq.im.capture.util.CaptureFreqMonitorItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements EditVideoPartManager.IEditVideoPartManager, EditVideoUi
{
  public EditVideoPartManager a;
  public boolean a;
  
  public EditVideoActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    View localView1 = findViewById(2131363390);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131362498);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void c()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    SLog.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 10240L)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((TrimmableManager)SuperManager.a(26)).a(2);
      return;
    }
    ((TrimmableManager)SuperManager.a(26)).a(0);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  public Intent a(GenerateContext paramGenerateContext)
  {
    Object localObject3;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource))
    {
      localIntent = getIntent();
      localObject1 = localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      localObject3 = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) || (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a();
          localIntent.putExtra("need_combine_gif", paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c);
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString)) {
          break label504;
        }
        localIntent.putExtra("orign_path", localEditLocalGifSource.a());
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        localIntent.putExtra("gif_delay_time", paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Int);
        localIntent.putExtra("gif_has_antishake", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeGifSource)) {
          localIntent.putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        ((ArrayList)localObject3).add(localObject2);
        ImageUtil.a(this, (String)localObject2);
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject3).get(0));
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.addFlags(603979776);
        localIntent.putExtra("PhotoConst.SEND_FLAG", true);
        return localIntent;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
          if ((localEditLocalGifSource.b != null) && (localEditLocalGifSource.b.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.b.get(0);
          }
        }
        for (;;)
        {
          if (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c) {
            localIntent.putExtra("use_orign", true);
          }
          localIntent.putExtra("need_combine_gif", true);
          break;
          localObject1 = "";
          continue;
          if ((localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList != null) && (localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList.get(0);
          } else {
            localObject1 = "";
          }
        }
        localObject2 = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
        localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        localIntent.putExtra("need_combine_gif", true);
      }
      label504:
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d) {
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.b);
      }
      for (;;)
      {
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        localIntent.putExtra("gif_delay_time", paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Int);
        localIntent.putExtra("gif_has_antishake", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.d);
        break;
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    Intent localIntent = new Intent();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a() != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a() != null) {
          localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().jdField_a_of_type_JavaUtilArrayList;
        }
      }
    }
    localObject2 = new JSONArray();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (TextLayer.TextItem)((Iterator)localObject1).next();
        if ((((TextLayer.TextItem)localObject3).a != null) && (((TextLayer.TextItem)localObject3).a.a() != null)) {
          ((JSONArray)localObject2).put(((TextLayer.TextItem)localObject3).a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditVideoActivity getPublishIntent, content is: " + ((JSONArray)localObject2).toString());
    }
    localIntent.putExtra("dynamic_text", ((JSONArray)localObject2).toString());
    localIntent.putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam);
    return localIntent;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    VideoFilterTools.a().a(null, this, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c());
    int i = getIntent().getIntExtra("take_video_entrance_type", 99);
    Intent localIntent = paramIntent;
    if (i == 15)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("take_video_entrance_type", i);
    }
    setResult(paramInt1, localIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.y();
    c();
  }
  
  public void a(Bundle paramBundle) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = new EditVideoPartManager();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c()) {
      super.doOnBackPressed();
    }
    a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    VideoModule.init(BaseApplicationImpl.getContext());
    SLog.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
    b();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    GloableValue.a(QQStoryContext.a().a(), this);
    EditPicConstants.a(QQStoryContext.a().a(), this);
    for (;;)
    {
      try
      {
        PtvFilterSoLoad.a(VideoEnvironment.a(), false);
        if (VideoEnvironment.a("AVCodec", getApplicationContext()) != 0)
        {
          SLog.e("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed");
          finish();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed", paramBundle);
        finish();
        return true;
      }
      EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((getIntent().getBooleanExtra("extra_has_antishake", false)) && ((localEditVideoParams.a instanceof EditLocalGifSource)))
      {
        localObject = (EditLocalGifSource)localEditVideoParams.a;
        ((EditLocalGifSource)localObject).b = getIntent().getStringArrayListExtra("extra_antishake_gif_path_list");
        if ((((EditLocalGifSource)localObject).b != null) && (((EditLocalGifSource)localObject).b.size() > 1)) {
          ((EditLocalGifSource)localObject).jdField_a_of_type_Boolean = true;
        }
      }
      SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
      if (localEditVideoParams != null) {}
      for (Object localObject = localEditVideoParams.a(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
      {
        QQToast.a(this, "视频参数错误: " + (String)localObject, 0).a();
        finish();
        return true;
      }
      localObject = getIntent().getStringExtra("op_department");
      String str = getIntent().getStringExtra("op_type");
      SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str });
      try
      {
        VideoSourceHelper.nativeSetPlayStepFrameCount(1);
        VideoSourceHelper.nativeSetPlayGapFrameCount(1);
        getWindow().addFlags(1024);
        setContentViewC(2130968958);
        a(paramBundle);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(this, localEditVideoParams);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.i();
        int i = getIntent().getIntExtra("edit_video_way", 0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(i);
        FileUtils.a(QQStoryConstant.c);
        VideoEditReport.jdField_a_of_type_JavaLangString = (String)localObject;
        VideoEditReport.jdField_b_of_type_JavaLangString = str;
        if ((!VideoEditReport.a()) || (VideoEnvironment.b() < 21)) {}
      }
      catch (Throwable localThrowable)
      {
        try
        {
          VideoSourceHelper.nativeSetMaxPhotoFrameCount(3);
          SLog.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity set min frame!");
          VideoEditReport.a("0X80076B5");
          StoryReportor.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
          LpReportInfo_pf00064.allReport(628, 1);
          SLog.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
          paramBundle = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
          if (paramBundle.a() == null) {
            paramBundle.b();
          }
          StoryTransitionActivity.a(this, 3600000L);
          c();
          paramBundle = findViewById(2131363390);
          if ((paramBundle == null) || (!this.jdField_a_of_type_Boolean)) {
            continue;
          }
          paramBundle.post(new ancc(this));
          return true;
          localThrowable = localThrowable;
          QLog.w("Q.qqstory.publish.edit.EditVideoActivity", 1, "VideoSourceHelper error:", localThrowable);
        }
        catch (UnsatisfiedLinkError paramBundle)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "nativeSetMaxPhotoFrameCount:exp=", paramBundle);
            }
          }
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.n();
    VideoEditReport.jdField_a_of_type_JavaLangString = "";
    VideoEditReport.jdField_b_of_type_JavaLangString = "";
    ((QIMInformationPasterManager)QIMManager.a().c(12)).a("");
    CaptureFreqMonitor.d.c();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.l();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnRestoreInstanceState");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnResume");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.k();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnSaveInstanceState");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(paramBundle);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStart");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.j();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.m();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected void g()
  {
    super.g();
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "onOutOfMemory");
    c();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    c();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */