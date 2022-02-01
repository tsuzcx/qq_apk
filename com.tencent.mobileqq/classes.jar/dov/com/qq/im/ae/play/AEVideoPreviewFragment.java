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
import bhdj;
import bodl;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  private ImageView ivClose;
  private ImageView ivDelete;
  private ImageView ivPlayOrPause;
  boolean needPlayWhenResume = false;
  private RelativeLayout rlVideoController;
  private SeekBar seekBarVideoProgress;
  TextView tvCurrentDuration;
  TextView tvTotalDuration;
  
  private void pause()
  {
    this.ivPlayOrPause.setVisibility(0);
    this.mMoviePlayer.pause();
  }
  
  private void play()
  {
    this.ivPlayOrPause.setVisibility(8);
    this.mMoviePlayer.play();
  }
  
  private void showCustomAlertDialog()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "UploadGiveUpVideo", "放弃上传这个视频吗？");
    try
    {
      bhdj.a(getActivity(), 230, str, null, getResources().getString(2131690697), getResources().getString(2131691037), new AEVideoPreviewFragment.3(this), new AEVideoPreviewFragment.4(this)).show();
      return;
    }
    catch (Exception localException)
    {
      QZLog.w(localException);
    }
  }
  
  void bindViews(View paramView)
  {
    this.tavCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378516));
    this.rlVideoController = ((RelativeLayout)paramView.findViewById(2131376913));
    this.ivClose = ((ImageView)paramView.findViewById(2131369356));
    this.ivDelete = ((ImageView)paramView.findViewById(2131369375));
    this.ivPlayOrPause = ((ImageView)paramView.findViewById(2131369492));
    this.seekBarVideoProgress = ((SeekBar)paramView.findViewById(2131377274));
    this.tvTotalDuration = ((TextView)paramView.findViewById(2131380227));
    this.tvCurrentDuration = ((TextView)paramView.findViewById(2131379863));
    this.rlVideoController.setOnClickListener(this);
    this.ivClose.setOnClickListener(this);
    this.ivDelete.setOnClickListener(this);
    this.ivPlayOrPause.setOnClickListener(this);
    this.seekBarVideoProgress.setOnSeekBarChangeListener(new AEVideoPreviewFragment.2(this));
  }
  
  void customizeBindingData(VideoResourceModel paramVideoResourceModel)
  {
    play();
    if ((this.tavCutVideoSession != null) && (this.tavCutVideoSession.getDuration() != null))
    {
      this.seekBarVideoProgress.setMax((int)this.tavCutVideoSession.getDuration().getTimeUs());
      this.tvTotalDuration.setText(bodl.a((this.tavCutVideoSession.getDuration().getTimeSeconds() * 1000.0F)));
    }
    this.mMoviePlayer.setVideoProgressListener(new AEVideoPreviewFragment.1(this));
  }
  
  protected int getLayoutId()
  {
    return 2131558581;
  }
  
  protected int getPlayerBackColor()
  {
    return getResources().getColor(2131165357);
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
      showCustomAlertDialog();
      continue;
      if (this.mMoviePlayer != null)
      {
        play();
        continue;
        if ((this.mMoviePlayer != null) && (this.mMoviePlayer.isPlaying())) {
          pause();
        } else if (this.mMoviePlayer != null) {
          play();
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
    this.needPlayWhenResume = this.mMoviePlayer.isPlaying();
    if (this.mMoviePlayer.isPlaying()) {
      pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.needPlayWhenResume) {
      play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */