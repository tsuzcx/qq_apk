package com.tencent.mobileqq.nearby.now.send.capturepart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class StoryLaunchEditPart
  extends StoryCapturePart
{
  private final int jdField_a_of_type_Int = a();
  CaptureVideoFilterViewPager jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager;
  
  public StoryLaunchEditPart(@NonNull SmallVideoCameraCaptureFragment paramSmallVideoCameraCaptureFragment)
  {
    super(paramSmallVideoCameraCaptureFragment);
  }
  
  private void a(@NonNull EditVideoParams.EditSource paramEditSource)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.a();
    }
    if (a() != null)
    {
      Object localObject = a();
      if (!((Bundle)localObject).containsKey("enable_hw_encode")) {
        ((Bundle)localObject).putBoolean("enable_hw_encode", true);
      }
      int i = a().getInt("entrance_type", 99);
      if ((i != 16) || (i == 5)) {}
      a().getBoolean("ignorePersonalPublish", false);
      i = 365;
      if ((paramEditSource instanceof EditTakePhotoSource)) {
        i = 320;
      }
      paramEditSource = new EditVideoParams(9, i, paramEditSource, (Bundle)localObject);
      SLog.d("story.publish.StoryLaunchEditPart", "launchEditActivity, %s", new Object[] { paramEditSource });
      localObject = new Intent(a(), EditVideoActivity.class);
      ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramEditSource);
      ((Intent)localObject).putExtra("op_department", "grp_now");
      ((Intent)localObject).putExtra("op_type", "now_smallvideo_edit");
      a((Intent)localObject, this.jdField_a_of_type_Int);
      a().overridePendingTransition(2131034128, 2131034139);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoCameraCaptureFragment.a(paramInt1, paramInt2, paramIntent);
    }
    while (paramInt1 != 1030) {
      return;
    }
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoCameraCaptureFragment.getActivity();
    localFragmentActivity.setResult(paramInt2, paramIntent);
    localFragmentActivity.finish();
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager = ((CaptureVideoFilterViewPager)paramView.findViewById(2131368928));
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    a(new EditTakePhotoSource(paramPhotoCaptureResult.a));
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    a(new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.capturepart.StoryLaunchEditPart
 * JD-Core Version:    0.7.0.1
 */