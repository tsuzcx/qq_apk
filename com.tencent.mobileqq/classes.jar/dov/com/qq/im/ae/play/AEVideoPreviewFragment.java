package dov.com.qq.im.ae.play;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import bhlq;
import bhpc;
import boxq;
import boxr;
import boxs;
import boxt;
import bpkx;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

public class AEVideoPreviewFragment
  extends AbsAEPublishVideoProcessFragment
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  public TextView a;
  boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  
  private void a()
  {
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
  }
  
  private void b()
  {
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
  }
  
  private void c()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "UploadGiveUpVideo", "放弃上传这个视频吗？");
    try
    {
      bhlq.a(getActivity(), 230, str, null, getResources().getString(2131690580), getResources().getString(2131690912), new boxs(this), new boxt(this)).show();
      return;
    }
    catch (Exception localException)
    {
      QZLog.w(localException);
    }
  }
  
  protected int a()
  {
    return 2131558568;
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378461));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376897));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369171));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369190));
    this.c = ((ImageView)paramView.findViewById(2131369315));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131377251));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380157));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379768));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new boxr(this));
  }
  
  void a(VideoResourceModel paramVideoResourceModel)
  {
    b();
    if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration() != null))
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bpkx.a((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeSeconds() * 1000.0F)));
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setVideoProgressListener(new boxq(this));
  }
  
  protected int b()
  {
    return getResources().getColor(2131165343);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      getActivity().finish();
      continue;
      c();
      continue;
      if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
      {
        b();
        continue;
        if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
          a();
        } else if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
          b();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying();
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()) {
      a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */