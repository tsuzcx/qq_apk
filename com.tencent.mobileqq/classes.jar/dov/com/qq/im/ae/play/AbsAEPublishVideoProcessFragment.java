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
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.StringUtil;
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
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.aeeditor.AEEditorProcessManager;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsAEPublishVideoProcessFragment
  extends PublicBaseFragment
{
  private static final String TAG = "AbsAEPublishVideoProces";
  private Dialog mLoadingDialog;
  protected MoviePlayer mMoviePlayer;
  protected String missionId;
  protected TAVCutVideoSession tavCutVideoSession;
  protected TAVCutVideoView tavCutVideoView;
  private VideoParamStrategy videoParam = ParamFactory.a();
  
  private String getMissionId()
  {
    Log.d("AbsAEPublishVideoProces", "missionId尝试获取");
    Bundle localBundle = getArguments();
    String str1 = "";
    if (getActivity().getIntent().getExtras() != null) {
      str1 = getActivity().getIntent().getStringExtra("key_ae_video_mission_id");
    }
    String str2 = str1;
    if (StringUtil.a(str1))
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
  
  private void initTavCutAndPlayer()
  {
    Log.d("AbsAEPublishVideoProces", "initTavCutAndPlayer: 开始初始化tavcutsession、moviePlayer");
    MediaModel localMediaModel = AEEditorProcessManager.a().a(this.missionId);
    if ((StringUtil.a(this.missionId)) || (isMediaModelBroken(localMediaModel)))
    {
      Log.e("AbsAEPublishVideoProces", "missionId异常！合成model损坏：" + isMediaModelBroken(localMediaModel));
      QQToast.a(getActivity(), "视频合成信息异常", 0).a();
      return;
    }
    VideoResourceModel localVideoResourceModel = ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource();
    this.mMoviePlayer = new MoviePlayer();
    this.mMoviePlayer.setLoopPlay(true);
    this.mMoviePlayer.setBackColor(getPlayerBackColor());
    this.tavCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.videoParam.a());
    if ((this.missionId != null) && (this.missionId.startsWith("multi_video_")))
    {
      AEEditorMultiVideoEditFragment.a(getActivity(), this.tavCutVideoSession, this.videoParam, localMediaModel, this.mMoviePlayer, this.tavCutVideoView);
      this.tavCutVideoSession.restoreStickersWithLyric(new ArrayList(localMediaModel.getMediaEffectModel().getStickerModelList()));
    }
    for (;;)
    {
      this.tavCutVideoSession.setStickerTouchEnable(false);
      customizeBindingData(localVideoResourceModel);
      return;
      this.tavCutVideoSession.setSessionConfig(localSessionConfig);
      this.tavCutVideoSession.setVideoPath(localVideoResourceModel.getPath());
      this.tavCutVideoSession.setMediaModel(localMediaModel);
      this.tavCutVideoSession.addPlayer(this.mMoviePlayer);
      this.tavCutVideoSession.setTAVCutVideoView(this.tavCutVideoView);
      this.tavCutVideoSession.init(getActivity());
      this.tavCutVideoSession.setClip(Long.valueOf(localVideoResourceModel.getSelectTimeStart()), Long.valueOf(localVideoResourceModel.getSelectTimeDuration()), true);
    }
  }
  
  private boolean isMediaModelBroken(MediaModel paramMediaModel)
  {
    boolean bool2 = false;
    Log.e("AbsAEPublishVideoProces", "检查损坏：mediaModel = " + paramMediaModel);
    StringBuilder localStringBuilder;
    if (paramMediaModel != null)
    {
      localStringBuilder = new StringBuilder().append("损坏原因：videos.size = 0 ");
      if (paramMediaModel.getMediaResourceModel().getVideos().size() != 0) {
        break label168;
      }
      bool1 = true;
      Log.e("AbsAEPublishVideoProces", bool1);
      localStringBuilder = new StringBuilder().append("损坏原因：video == null ");
      if (paramMediaModel.getMediaResourceModel().getVideos().get(0) != null) {
        break label173;
      }
    }
    label168:
    label173:
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
  
  abstract void bindViews(View paramView);
  
  abstract void customizeBindingData(VideoResourceModel paramVideoResourceModel);
  
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
  
  protected abstract int getLayoutId();
  
  protected String getMediaPath()
  {
    Log.d("AbsAEPublishVideoProces", "MediaPath尝试获取");
    Bundle localBundle = getArguments();
    String str1 = "";
    if (getActivity().getIntent().getExtras() != null) {
      str1 = getActivity().getIntent().getStringExtra("key_video_media_path");
    }
    String str2 = str1;
    if (StringUtil.a(str1))
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
  
  protected int getMediaPosition()
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
  
  protected int getPlayerBackColor()
  {
    return getResources().getColor(2131165272);
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
    this.missionId = getMissionId();
    AEKitForQQ.a();
    FeatureManager.Features.YT_COMMON.init();
    FeatureManager.Features.PTU_TOOLS.init();
    FeatureManager.Features.PTU_ALGO.init();
    FeatureManager.Features.LIGHT_SDK.init();
    FeatureManager.Features.IMAGE_ALGO.init();
    TAVCut.initTAVCut(getActivity(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AbsAEPublishVideoProcessFragment.1(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    this.mMoviePlayer.release();
    this.tavCutVideoSession.release();
    super.onFinish();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    bindViews(paramView);
    initTavCutAndPlayer();
  }
  
  protected void showLoading(boolean paramBoolean)
  {
    if (!getActivity().isFinishing())
    {
      if (!paramBoolean) {
        break label92;
      }
      if (this.mLoadingDialog == null)
      {
        this.mLoadingDialog = new ReportDialog(getActivity(), 2131755842);
        this.mLoadingDialog.setCancelable(false);
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
        this.mLoadingDialog.setContentView(2131559683);
        ((TextView)this.mLoadingDialog.findViewById(2131373066)).setText("正在保存封面...");
      }
      this.mLoadingDialog.show();
    }
    label92:
    while ((this.mLoadingDialog == null) || (!this.mLoadingDialog.isShowing())) {
      return;
    }
    this.mLoadingDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AbsAEPublishVideoProcessFragment
 * JD-Core Version:    0.7.0.1
 */