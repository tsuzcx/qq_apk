package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.OnRangeValueChangeListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.qq.im.QIMTribeEffectsCameraCaptureUnit;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ScrollFrameSelectBar.OnRangeValueChangeListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
  private ScrollFrameSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e;
  private int g;
  
  private void a()
  {
    finish();
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    Bosses.get().postJob(new LocalVideoSelectActivity.5(this, "Q.qqstory.publish.edit.LocalVideoSelectActivity", paramLocalMediaInfo));
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
    for (String str = String.format(HardCodeUtil.a(2131706321), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = String.format(HardCodeUtil.a(2131706324), new Object[] { Integer.valueOf(paramInt1) }))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
    }
  }
  
  public void doOnResume()
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(false);
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
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
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    String str2;
    int i;
    int k;
    int m;
    int n;
    int i1;
    Object localObject;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "publish the local video path=%s,start=%s,end=%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c()) });
      str2 = getIntent().getStringExtra("video_refer");
      if ("tribe".equals(str2))
      {
        i = QIMTribeEffectsCameraCaptureUnit.jdField_a_of_type_Int;
        k = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
        m = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
        if (m - k > i) {
          StoryReportor.a("video_edit", "edit_split", 0, 0, new String[] { String.valueOf(Math.ceil((m - k) / 1000.0F)) });
        }
        n = getIntent().getIntExtra("entrance_type", 99);
        i1 = getIntent().getIntExtra("edit_video_type", 10002);
        int j = 0;
        localObject = null;
        String str1 = null;
        boolean bool = false;
        Intent localIntent = getIntent();
        if (localIntent != null)
        {
          j = localIntent.getIntExtra("shareGroupType", 0);
          localObject = localIntent.getStringExtra("shareGroupId");
          str1 = localIntent.getStringExtra("shareGroupName");
          bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
        }
        if (!"tribe".equals(str2)) {
          break label347;
        }
        i = 11;
        label246:
        QQStoryFlowCallback.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, k, m, n, i1, j, (String)localObject, str1, bool, this.g, i);
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a();
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.b();
        if ((i != this.jdField_c_of_type_Int) || (j != this.jdField_d_of_type_Int)) {
          StoryReportor.a("video_edit", "num_cut", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 20000;
      break;
      label347:
      if ("READINJOY_VIDEO".equals(str2))
      {
        i = 12;
        break label246;
      }
      if (i1 == 10023)
      {
        b(2131694444);
        localObject = new FrameVideoHelper(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        ((FrameVideoHelper)localObject).a(k, new LocalVideoSelectActivity.4(this, k, m, n, i1, 14, (FrameVideoHelper)localObject));
        VSReporter.a("mystatus_localupload", "cut_page_confirm", 0, 0, new String[0]);
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      }
      else
      {
        i = 2;
        break label246;
        if (paramView == this.jdField_a_of_type_AndroidWidgetLinearLayout) {
          a();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @TargetApi(11)
  public void onCreate(@Nullable Bundle paramBundle)
  {
    getWindow().addFlags(1024);
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.onCreate(paramBundle);
    VideoEnvironment.loadAVCodecSo();
    this.g = getIntent().getIntExtra("edit_video_way", 0);
    int i;
    if (paramBundle == null)
    {
      i = 1;
      if (i == 0) {
        break label96;
      }
      this.jdField_b_of_type_Boolean = QQStoryFlowCallback.a(this, getIntent(), this.g);
      if (!this.jdField_b_of_type_Boolean) {
        break label122;
      }
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, go through, start edit video activity directly");
    }
    label96:
    label122:
    do
    {
      return;
      i = 0;
      break;
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("mGoThrough");
      if (this.jdField_b_of_type_Boolean)
      {
        SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity re-create, do nothing");
        return;
      }
      SLog.c("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, init ui");
      setContentViewC(2131561841);
      SLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375019));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)getIntent().getParcelableExtra("media_info"));
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375018));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375021));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375020));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar = ((ScrollFrameSelectBar)findViewById(2131374994));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)findViewById(2131370776));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
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
      if (getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setMaxVideoDuration(60000);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.post(new LocalVideoSelectActivity.1(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(new LocalVideoSelectActivity.2(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnErrorListener(new LocalVideoSelectActivity.3(this));
      StoryReportor.a("video_edit", "exp_cut", 0, 0, new String[0]);
    } while (getIntent().getIntExtra("edit_video_type", 10002) != 10023);
    VSReporter.a("mystatus_localupload", "cut_page_exp", 0, 0, new String[0]);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.e();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */