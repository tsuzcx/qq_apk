package dov.com.qq.im.aeeditor.module.clip.video;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;

public class AEEditorVideoClipFragment
  extends AEEditorBaseFragment
{
  private static final String jdField_b_of_type_JavaLangString = AEEditorVideoClipFragment.class.getSimpleName();
  float jdField_a_of_type_Float = 1.0F;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = null;
  private AEEditorMvClipMenu jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu;
  private VideoParamStrategy jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy = ParamFactory.a();
  Float jdField_a_of_type_JavaLangFloat = null;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private CMTimeRange jdField_b_of_type_ComTencentTavCoremediaCMTimeRange;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  
  private float a()
  {
    Bundle localBundle = getArguments();
    if (getActivity().getIntent().getExtras() != null) {}
    for (float f2 = getActivity().getIntent().getFloatExtra("endSpeedEdit", -1.0F);; f2 = -1.0F)
    {
      float f1 = f2;
      if (f2 == -1.0F)
      {
        f1 = f2;
        if (localBundle != null)
        {
          f1 = f2;
          if (localBundle.containsKey("speed")) {
            f1 = localBundle.getFloat("speed", -1.0F);
          }
        }
      }
      f2 = f1;
      if (f1 == -1.0F)
      {
        f2 = f1;
        if (localBundle != null)
        {
          f2 = f1;
          if (localBundle.containsKey("video_edit_clip_speed")) {
            f2 = localBundle.getFloat("video_edit_clip_speed", -1.0F);
          }
        }
      }
      f1 = f2;
      if (f2 == -1.0F) {
        f1 = 1.0F;
      }
      return f1;
    }
  }
  
  private CMTimeRange a()
  {
    Bundle localBundle = getArguments();
    long l4;
    long l3;
    if (getActivity().getIntent().getExtras() != null)
    {
      l4 = getActivity().getIntent().getLongExtra("startTimeEdit", -1L);
      l3 = getActivity().getIntent().getLongExtra("endTimeEdit", -1L);
    }
    for (;;)
    {
      long l2;
      long l1;
      if (l4 != -1L)
      {
        l2 = l3;
        l1 = l4;
        if (l3 != -1L) {}
      }
      else
      {
        l2 = l3;
        l1 = l4;
        if (localBundle != null)
        {
          l2 = l3;
          l1 = l4;
          if (localBundle.containsKey("starttime"))
          {
            l2 = l3;
            l1 = l4;
            if (localBundle.containsKey("endtime"))
            {
              l1 = localBundle.getLong("starttime");
              l2 = localBundle.getLong("endtime");
            }
          }
        }
      }
      if (l1 != -1L)
      {
        l4 = l2;
        l3 = l1;
        if (l2 != -1L) {}
      }
      else
      {
        l4 = l2;
        l3 = l1;
        if (localBundle != null)
        {
          l4 = l2;
          l3 = l1;
          if (localBundle.containsKey("video_edit_clip_end_time"))
          {
            l4 = l2;
            l3 = l1;
            if (localBundle.containsKey("video_edit_clip_start_time"))
            {
              l3 = localBundle.getLong("video_edit_clip_start_time");
              l4 = localBundle.getLong("video_edit_clip_end_time");
            }
          }
        }
      }
      if ((l3 == -1L) || (l4 == -1L)) {
        return null;
      }
      return CMTimeRange.fromUs(l3, l4 - l3);
      l3 = -1L;
      l4 = -1L;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_c_of_type_JavaLangString = c();
    this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = a();
    this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378947));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new AEEditorVideoClipFragment.1(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    paramView = new SessionConfig();
    paramView.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    paramView.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    paramView.setMaxIntermediateRenderSize(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(paramView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(this.jdField_a_of_type_AndroidContentContext);
    e();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu = ((AEEditorMvClipMenu)paramView.findViewById(2131372070));
    i();
    c();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369463));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorVideoClipFragment.3(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369466));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorVideoClipFragment.4(this));
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorVideoEdit"));
  }
  
  private String c()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("PhotoConst.SELECTED_PATHS"))) {
      localArrayList = localBundle.getStringArrayList("PhotoConst.SELECTED_PATHS");
    }
    while (localArrayList.size() > 0)
    {
      return (String)localArrayList.get(0);
      AEQLog.d(jdField_b_of_type_JavaLangString, "no video paths");
    }
    return null;
  }
  
  private void c()
  {
    boolean bool = false;
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setMvClipMenuListener(new AEEditorVideoClipFragment.5(this));
    if (!getArguments().getBoolean("ae_editor_is_light_model", false)) {
      bool = true;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setSpeedEnable(bool);
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != null) && (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
  }
  
  private void d()
  {
    VideoSetSpeedDialog localVideoSetSpeedDialog = new VideoSetSpeedDialog(getActivity(), 2131755194);
    if (this.jdField_a_of_type_JavaLangFloat == null) {}
    for (float f = this.jdField_a_of_type_Float;; f = this.jdField_a_of_type_JavaLangFloat.floatValue())
    {
      localVideoSetSpeedDialog.a(f);
      localVideoSetSpeedDialog.c(83);
      localVideoSetSpeedDialog.b(DisplayUtil.b(getActivity(), 60.0F));
      localVideoSetSpeedDialog.a(DisplayUtil.b(getActivity(), 42.0F));
      localVideoSetSpeedDialog.a(new AEEditorVideoClipFragment.6(this, localVideoSetSpeedDialog));
      localVideoSetSpeedDialog.show();
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange == null) {
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() > 60000000L)
      {
        localObject1 = CMTime.convertTimeScale(CMTime.fromMs(0L), 1000);
        localObject2 = CMTime.convertTimeScale(CMTime.fromMs(60000L), 1000).sub((CMTime)localObject1);
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange((CMTime)localObject1, (CMTime)localObject2));
      }
    }
    do
    {
      return;
      localObject2 = Long.valueOf(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getStartUs());
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getEndUs());
    } while ((localObject2 == null) || (localObject1 == null));
    Object localObject2 = CMTime.convertTimeScale(CMTime.fromMs(((Long)localObject2).longValue() / 1000L), 1000);
    Object localObject1 = CMTime.convertTimeScale(CMTime.fromMs(((Long)localObject1).longValue() / 1000L), 1000).sub((CMTime)localObject2);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange((CMTime)localObject2, (CMTime)localObject1));
  }
  
  private void f()
  {
    long l2 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().size() > 0)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().get(0) != null) {
          l1 = ((MediaClipModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getSourceTimeDurationUs() / 1000L;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange == null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource(), l1, 0L, l1);
    }
    Long localLong1;
    Long localLong2;
    do
    {
      return;
      localLong1 = Long.valueOf(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getStartUs() / 1000L);
      localLong2 = Long.valueOf(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getEndUs() / 1000L);
    } while ((localLong1 == null) || (localLong2 == null) || (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null));
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource(), localLong1.longValue(), localLong2.longValue());
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    new IntentFilter().addAction("android.media.AUDIO_BECOMING_NOISY");
    new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  private void h() {}
  
  private void i()
  {
    long l1 = -1L;
    long l2;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setTime(new CMTimeRange(CMTime.CMTimeZero, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration()));
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setTAVSource(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource());
      if (this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange == null) {
        break label108;
      }
      l2 = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getStartUs() / 1000L;
      l1 = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getEndUs() / 1000L;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.a(l2, l1);
      if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.a(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
      }
      return;
      label108:
      l2 = -1L;
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.a();
    }
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    }
  }
  
  private void m()
  {
    String str1;
    String str2;
    label20:
    String str3;
    if (b())
    {
      str1 = "video_edit_clip_start_time";
      if (!b()) {
        break label86;
      }
      str2 = "video_edit_clip_end_time";
      if (!b()) {
        break label92;
      }
      str3 = "video_edit_clip_speed";
      label30:
      if (this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange == null) {
        break label98;
      }
      getArguments().putLong(str1, this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getStartUs());
      getArguments().putLong(str2, this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getEndUs());
    }
    for (;;)
    {
      getArguments().putFloat(str3, this.jdField_a_of_type_Float);
      return;
      str1 = "starttime";
      break;
      label86:
      str2 = "endtime";
      break label20;
      label92:
      str3 = "speed";
      break label30;
      label98:
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
      {
        getArguments().putLong(str1, 0L);
        getArguments().putLong(str2, Math.min(60000000L, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs()));
      }
    }
  }
  
  public String a()
  {
    return "AEEditorVideoClip";
  }
  
  public boolean a()
  {
    if (!c())
    {
      m();
      a().a(getActivity());
    }
    for (;;)
    {
      return true;
      Object localObject = getActivity();
      localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2131689758)).setMessage(((Context)localObject).getString(2131689759)).setPositiveButton(((Context)localObject).getString(2131689715), new AEEditorVideoClipFragment.8(this)).setNegativeButton(((Context)localObject).getString(2131689713), new AEEditorVideoClipFragment.7(this));
      if (localObject != null) {
        try
        {
          if (!((QQCustomDialog)localObject).isShowing())
          {
            ((QQCustomDialog)localObject).show();
            return true;
          }
        }
        catch (Throwable localThrowable) {}
      }
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_b_of_type_Boolean = true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    AEQLog.b(jdField_b_of_type_JavaLangString, "onCreateView");
    this.jdField_c_of_type_Boolean = AEThemeUtil.a();
    paramLayoutInflater = paramLayoutInflater.inflate(2131558601, paramViewGroup, false);
    a(paramLayoutInflater);
    b(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AEQLog.b(jdField_b_of_type_JavaLangString, "onDestroy");
    l();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    boolean bool = false;
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.onResume();
      this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = a();
      this.jdField_a_of_type_Float = a();
      this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setTimeLineViewSpeed(this.jdField_a_of_type_Float, new AEEditorVideoClipFragment.2(this));
      e();
      f();
      if (this.jdField_b_of_type_Boolean) {
        j();
      }
      paramBoolean = bool;
      if (!getArguments().getBoolean("ae_editor_is_light_model", false)) {
        paramBoolean = true;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setSpeedEnable(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.onPause();
    k();
  }
  
  public void onPause()
  {
    super.onPause();
    AEQLog.b(jdField_b_of_type_JavaLangString, "onPause");
    h();
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      AEQLog.a(jdField_b_of_type_JavaLangString, "onPause: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
      k();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AEQLog.b(jdField_b_of_type_JavaLangString, "onResume");
    g();
    AEQLog.a(jdField_b_of_type_JavaLangString, "onResume: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
    AEReportUtils.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment
 * JD-Core Version:    0.7.0.1
 */