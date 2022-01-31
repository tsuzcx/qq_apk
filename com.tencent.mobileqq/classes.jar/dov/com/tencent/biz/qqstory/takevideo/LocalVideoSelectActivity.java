package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import aoff;
import aofh;
import aofi;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.OnRangeValueChangeListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.qq.im.cropvideo.CropVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ScrollFrameSelectBar.OnRangeValueChangeListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
  private ScrollFrameSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  private void a()
  {
    finish();
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    Bosses.get().postJob(new aofi(this, paramLocalMediaInfo));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    if ((this.jdField_c_of_type_Int < 0) || (this.jdField_d_of_type_Int < 0))
    {
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt2;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)Math.floor((paramInt2 - paramInt1) / 1000.0F);
    paramInt2 = (int)Math.ceil(paramInt1 / 10.0F);
    if (this.jdField_c_of_type_Boolean) {}
    for (String str = String.format("已选中%d秒，拆分为%d个小视频", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = String.format("已选中%d秒小视频", new Object[] { Integer.valueOf(paramInt1) }))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    a();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_d_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", 2, "model=" + str);
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBoolean("mGoThrough", this.jdField_b_of_type_Boolean);
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    while (this.jdField_b_of_type_Boolean)
    {
      SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult go through, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      setResult(paramInt2, paramIntent);
      finish();
      return;
      if (paramInt2 == -1)
      {
        SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult from edit video activity, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        setResult(paramInt2, paramIntent);
        if (paramIntent != null) {
          paramIntent.putExtra("edit_video_type", getIntent().getIntExtra("edit_video_type", 10002));
        }
        finish();
        return;
      }
      if ((paramInt2 == 0) && (this.jdField_b_of_type_Boolean))
      {
        a();
        return;
      }
    }
    SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void onClick(View paramView)
  {
    String str = null;
    int j;
    int k;
    int m;
    int n;
    int i;
    boolean bool;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "publish the local video path=%s,start=%s,end=%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c()) });
      j = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
      k = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
      if (k - j > 10000) {
        StoryReportor.a("video_edit", "edit_split", 0, 0, new String[] { String.valueOf(Math.ceil((k - j) / 1000.0F)) });
      }
      m = getIntent().getIntExtra("entrance_type", 99);
      n = getIntent().getIntExtra("edit_video_type", 10002);
      Intent localIntent = getIntent();
      if (localIntent == null) {
        break label311;
      }
      i = localIntent.getIntExtra("shareGroupType", 0);
      paramView = localIntent.getStringExtra("shareGroupId");
      str = localIntent.getStringExtra("shareGroupName");
      bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
    }
    for (;;)
    {
      if (n == 10009)
      {
        CropVideoActivity.a(this, j, k, this.jdField_a_of_type_JavaLangString);
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a();
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.b();
        if ((i != this.jdField_c_of_type_Int) || (j != this.jdField_d_of_type_Int)) {
          StoryReportor.a("video_edit", "num_cut", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      }
      do
      {
        return;
        QQStoryFlowCallback.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, j, k, m, n, i, paramView, str, bool, this.jdField_e_of_type_Int);
        break;
      } while (paramView != this.jdField_b_of_type_AndroidWidgetTextView);
      a();
      return;
      label311:
      bool = false;
      paramView = null;
      i = 0;
    }
  }
  
  @TargetApi(11)
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    getWindow().addFlags(1024);
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    ShortVideoUtils.a(this.app);
    this.jdField_e_of_type_Int = getIntent().getIntExtra("edit_video_way", 0);
    if (paramBundle == null) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_b_of_type_Boolean = QQStoryFlowCallback.a(this, getIntent(), this.jdField_e_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label120;
      }
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, go through, start edit video activity directly");
      return;
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("mGoThrough");
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity re-create, do nothing");
      return;
    }
    label120:
    SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, init ui");
    setContentViewC(2130970776);
    SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371844));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)getIntent().getParcelableExtra("media_info"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path;
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371845));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371848));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371847));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar = ((ScrollFrameSelectBar)findViewById(2131371846));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)findViewById(2131371843));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setOnRangeValueChangeListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
    this.jdField_b_of_type_Int = Math.max(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("PhotoConst.ENABLE_MULTI_FRAGMENT_VIDEO", false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a(this.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Boolean, 0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLocalVideoView(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(new aoff(this));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnErrorListener(new aofh(this));
    StoryReportor.a("video_edit", "exp_cut", 0, 0, new String[0]);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.e();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */