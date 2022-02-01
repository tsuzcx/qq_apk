package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import bgsp;
import bndd;
import bnwz;
import bnzw;
import bohn;
import bohp;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

public abstract class AbsAEPublishVideoProcessFragment
  extends PublicBaseFragment
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private bohp jdField_a_of_type_Bohp = bohn.a();
  public MoviePlayer a;
  public TAVCutVideoSession a;
  protected TAVCutVideoView a;
  protected String a;
  
  private void a()
  {
    Log.d("AbsAEPublishVideoProces", "initTavCutAndPlayer: 开始初始化tavcutsession、moviePlayer");
    MediaModel localMediaModel = bnzw.a().a(this.jdField_a_of_type_JavaLangString);
    if ((bgsp.a(this.jdField_a_of_type_JavaLangString)) || (a(localMediaModel)))
    {
      Log.e("AbsAEPublishVideoProces", "missionId异常！合成model损坏：" + a(localMediaModel));
      QQToast.a(getActivity(), "视频合成信息异常", 0).a();
      return;
    }
    VideoResourceModel localVideoResourceModel = ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(b());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Bohp.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(localVideoResourceModel.getPath());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMediaModel(localMediaModel);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(getActivity());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(localVideoResourceModel.getSelectTimeStart()), Long.valueOf(localVideoResourceModel.getSelectTimeDuration()), true);
    a(localVideoResourceModel);
  }
  
  private boolean a(MediaModel paramMediaModel)
  {
    boolean bool2 = false;
    Log.e("AbsAEPublishVideoProces", "检查损坏：mediaModel = " + paramMediaModel);
    StringBuilder localStringBuilder;
    if (paramMediaModel != null)
    {
      localStringBuilder = new StringBuilder().append("损坏原因：videos.size = 0 ");
      if (paramMediaModel.getMediaResourceModel().getVideos().size() != 0) {
        break label165;
      }
      bool1 = true;
      Log.e("AbsAEPublishVideoProces", bool1);
      localStringBuilder = new StringBuilder().append("损坏原因：video == null ");
      if (paramMediaModel.getMediaResourceModel().getVideos().get(0) != null) {
        break label170;
      }
    }
    label165:
    label170:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.e("AbsAEPublishVideoProces", bool1);
      if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel().getVideos().size() != 0))
      {
        bool1 = bool2;
        if (paramMediaModel.getMediaResourceModel().getVideos().get(0) != null) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  private String b()
  {
    Log.d("AbsAEPublishVideoProces", "missionId尝试获取");
    Bundle localBundle = getArguments();
    String str1 = "";
    if (getActivity().getIntent().getExtras() != null) {
      str1 = getActivity().getIntent().getStringExtra("key_ae_video_mission_id");
    }
    String str2 = str1;
    if (bgsp.a(str1))
    {
      str2 = str1;
      if (localBundle != null)
      {
        str2 = str1;
        if (localBundle.containsKey("key_ae_video_mission_id")) {
          str2 = localBundle.getString("key_ae_video_mission_id");
        }
      }
    }
    return str2;
  }
  
  protected abstract int a();
  
  protected String a()
  {
    Log.d("AbsAEPublishVideoProces", "MediaPath尝试获取");
    Bundle localBundle = getArguments();
    String str1 = "";
    if (getActivity().getIntent().getExtras() != null) {
      str1 = getActivity().getIntent().getStringExtra("key_video_media_path");
    }
    String str2 = str1;
    if (bgsp.a(str1))
    {
      str2 = str1;
      if (localBundle != null)
      {
        str2 = str1;
        if (localBundle.containsKey("key_video_media_path")) {
          str2 = localBundle.getString("key_video_media_path");
        }
      }
    }
    return str2;
  }
  
  abstract void a(View paramView);
  
  abstract void a(VideoResourceModel paramVideoResourceModel);
  
  protected void a(boolean paramBoolean)
  {
    if (!getActivity().isFinishing())
    {
      if (!paramBoolean) {
        break label92;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755823);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559567);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372466)).setText("正在保存封面...");
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label92:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  protected int b()
  {
    return getResources().getColor(2131165261);
  }
  
  public int c()
  {
    Log.d("AbsAEPublishVideoProces", "mediaPosition尝试获取");
    Bundle localBundle = getArguments();
    if (getActivity().getIntent().getExtras() != null) {}
    for (int i = getActivity().getIntent().getIntExtra("key_video_media_position", -1);; i = 0)
    {
      int j = i;
      if (i == -1)
      {
        j = i;
        if (localBundle != null)
        {
          j = i;
          if (localBundle.containsKey("key_video_media_position")) {
            j = localBundle.getInt("key_video_media_position", 0);
          }
        }
      }
      return j;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      getActivity().setResult(0);
      getActivity().finish();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      getActivity().setResult(0);
      getActivity().finish();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = b();
    bndd.a();
    TAVCut.initTAVCut(getActivity(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bnwz(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    super.onFinish();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AbsAEPublishVideoProcessFragment
 * JD-Core Version:    0.7.0.1
 */