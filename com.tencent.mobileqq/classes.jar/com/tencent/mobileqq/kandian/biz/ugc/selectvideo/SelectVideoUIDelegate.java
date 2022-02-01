package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class SelectVideoUIDelegate
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, PlayerStatusListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new SelectVideoUIDelegate.InnerHandler(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = (ViewGroup)LayoutInflater.from(BaseApplication.getContext()).inflate(2131560052, null, false);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AlbumUtils.LocalMediaInfo jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo;
  private IReadInJoyPlayer jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer;
  private boolean jdField_a_of_type_Boolean = false;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private int a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {
      return ((Integer)paramView).intValue();
    }
    return 1;
  }
  
  private void a(int paramInt)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    this.jdField_a_of_type_AndroidWidgetImageButton.clearAnimation();
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(localResources.getDrawable(2130843372));
      this.jdField_a_of_type_AndroidWidgetImageButton.setTag(Integer.valueOf(2));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(localResources.getDrawable(2130843373));
    this.jdField_a_of_type_AndroidWidgetImageButton.setTag(Integer.valueOf(1));
  }
  
  private void a(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(i));
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0;
  }
  
  private boolean b()
  {
    return this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377124));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380726));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372826));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380557));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380728));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380579));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365293));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379930));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void e()
  {
    int i = (int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a() / 1000;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(i);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(i);
    a(0L);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(i));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(0));
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer = ((IReadInJoyPlayerFactory)QRoute.api(IReadInJoyPlayerFactory.class)).createPlayer(1000);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.d(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e(false);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void i()
  {
    if (b())
    {
      h();
      return;
    }
    j();
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.g()) {
      a(1);
    } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.h()) {
      a(2);
    }
    VideoFeedsHelper.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, 300);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.h()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.l();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      QLog.e("RIJUGC.SelectVideoUIDelegate", 1, "attachVideoView failed for containerView is null.");
      return;
    }
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup.setEnabled(false);
    d();
    f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(paramViewGroup);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo = paramLocalMediaInfo;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramLocalMediaInfo.d);
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.1(this, paramLocalMediaInfo));
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.k();
  }
  
  public void beforeVideoStart() {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.m();
  }
  
  public void onBufferEnd() {}
  
  public void onBufferStart() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidWidgetImageButton.getId())
    {
      i = a(paramView);
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.d();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.c();
      return;
    }
    if (i == this.jdField_c_of_type_AndroidViewViewGroup.getId()) {
      i();
    }
  }
  
  public void onCompletion() {}
  
  public void onFirstFrameRendered() {}
  
  public void onProgressChanged(long paramLong)
  {
    a(paramLong);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_Boolean = false;
    int i = paramSeekBar.getProgress();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b(i * 1000);
  }
  
  public void onVideoEnd(int paramInt) {}
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onVideoOpen() {}
  
  public void onVideoPause()
  {
    if (a()) {
      a(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
  }
  
  public void onVideoPrepared()
  {
    g();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.c();
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.2(this));
  }
  
  public void onVideoRestart()
  {
    a(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void onVideoStart()
  {
    a(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void onVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoUIDelegate
 * JD-Core Version:    0.7.0.1
 */