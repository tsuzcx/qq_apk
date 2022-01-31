package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import anss;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter.CaptureMode;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CapturePicParams;
import dov.com.qq.im.setting.CapturePicParams.CapturePicParamsBuilder;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import java.util.ArrayList;
import java.util.List;

public class QIMStoryEffectCameraCaptureUnit
  extends QIMEffectCameraCaptureUnit
{
  private BroadcastReceiver a;
  protected TextView a;
  
  public QIMStoryEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_Int = 3;
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("dov.com.qq.im.finish_capture_action");
    localIntent.setPackage("com.tencent.mobileqq");
    paramContext.sendBroadcast(localIntent);
  }
  
  protected int a()
  {
    return 2130970102;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364018));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    return localView;
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    CameraCaptureView.CaptureParam localCaptureParam = super.a();
    localCaptureParam.b(false);
    return localCaptureParam;
  }
  
  protected List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_AndroidWidgetTextView);
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      if (localPublishParam != null) {
        paramIntent.putExtra("new_video_extra_info", localPublishParam.c);
      }
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().setResult(paramInt2, paramIntent);
    }
    if ((paramInt1 == 10002) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().finish();
      return;
    }
    if ((paramInt1 == 1012) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().finish();
      return;
    }
    if ((paramInt1 == 10006) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().finish();
      return;
    }
    SLog.d("QIMStoryEffectCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10002, this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("entrance_type", 1), 1);
    super.a(paramBundle);
    if (BaseApplicationImpl.sProcessId != 9) {
      SubmitHomeWorkFragment.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
    }
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    boolean bool2 = false;
    super.a(paramPhotoCaptureResult);
    if (this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.b != 102) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.b != 102) {
        bool2 = true;
      }
      CapturePicParams localCapturePicParams = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).c(bool1).d(bool2).e(true).a();
      this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCapturePicParams);
      JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
      return;
    }
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool1;
    boolean bool2;
    label30:
    Object localObject;
    if (this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.b != 102)
    {
      bool1 = true;
      if (this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.b == 102) {
        break label156;
      }
      bool2 = true;
      localObject = new CaptureVideoParams.CaptureVideoParamsBuilder().a(false).d(bool1).e(bool2).f(true).h(this.b).a();
      this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a((CaptureVideoParams)localObject);
      localObject = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent();
      if (!this.b) {
        break label162;
      }
    }
    label156:
    label162:
    for (int i = 2;; i = -1)
    {
      ((Intent)localObject).putExtra("extra_transiton_src_from", i);
      JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getExtras());
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label30;
    }
  }
  
  protected void e()
  {
    super.e();
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void m()
  {
    super.m();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void o()
  {
    super.o();
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_c_of_type_JavaUtilList.size())
      {
        if (1 == ((CaptureModeAdapter.CaptureMode)this.jdField_c_of_type_JavaUtilList.get(i)).a()) {
          this.jdField_c_of_type_JavaUtilList.add(i + 1, new CaptureModeAdapter.CaptureMode(2));
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void w()
  {
    Object localObject = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    Intent localIntent = new Intent((Context)localObject, PhotoListActivity.class);
    StoryIntentUtils.a(localIntent, ((Activity)localObject).getIntent().getExtras());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 4);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("from_qqstory_slideshow", true);
    localIntent.putExtra("ALBUM_NAME", "最近照片");
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
    localIntent.putExtra("report_first_exposure", true);
    ((Activity)localObject).startActivity(localIntent);
    ((Activity)localObject).overridePendingTransition(2131034380, 2131034131);
    StoryReportor.a("video_shoot", "clk_slides_entry", 0, 0, new String[0]);
    StoryReportor.a("video_shoot_slides", "clk_slides_entry", 0, 0, new String[0]);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new anss(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("dov.com.qq.im.finish_capture_action");
    }
    try
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMStoryEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */