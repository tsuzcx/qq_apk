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
import anvx;
import bhdj;
import bnrh;
import bnri;
import bnsm;
import bnwu;
import bnwv;
import bnww;
import bnwx;
import bnwy;
import bnxa;
import bnxb;
import bnxc;
import bobw;
import boby;
import bpdd;
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
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import java.util.ArrayList;
import java.util.List;

public class AEEditorVideoClipFragment
  extends AEEditorBaseFragment
{
  private static final String jdField_b_of_type_JavaLangString = AEEditorVideoClipFragment.class.getSimpleName();
  public float a;
  private Context jdField_a_of_type_AndroidContentContext;
  private boby jdField_a_of_type_Boby = bobw.a();
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView;
  private AEEditorMvClipMenu jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu;
  private AEEditorTopBar jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar;
  public Float a;
  private boolean jdField_a_of_type_Boolean;
  private CMTimeRange jdField_b_of_type_ComTencentTavCoremediaCMTimeRange;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public AEEditorVideoClipFragment()
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaLangFloat = null;
  }
  
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
      if (f1 == -1.0F) {
        f2 = 1.0F;
      }
      return f2;
    }
  }
  
  private CMTimeRange a()
  {
    Bundle localBundle = getArguments();
    long l2;
    long l1;
    if (getActivity().getIntent().getExtras() != null)
    {
      l2 = getActivity().getIntent().getLongExtra("startTimeEdit", -1L);
      l1 = getActivity().getIntent().getLongExtra("endTimeEdit", -1L);
    }
    for (;;)
    {
      long l4;
      long l3;
      if (l2 != -1L)
      {
        l4 = l1;
        l3 = l2;
        if (l1 != -1L) {}
      }
      else
      {
        l4 = l1;
        l3 = l2;
        if (localBundle != null)
        {
          l4 = l1;
          l3 = l2;
          if (localBundle.containsKey("starttime"))
          {
            l4 = l1;
            l3 = l2;
            if (localBundle.containsKey("endtime"))
            {
              l3 = localBundle.getLong("starttime");
              l4 = localBundle.getLong("endtime");
            }
          }
        }
      }
      if ((l3 == -1L) || (l4 == -1L)) {
        return null;
      }
      return CMTimeRange.fromUs(l3, l4 - l3);
      l1 = -1L;
      l2 = -1L;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_c_of_type_JavaLangString = c();
    this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = a();
    this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378516));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bnwu(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    paramView = new SessionConfig();
    paramView.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    paramView.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    paramView.setMaxIntermediateRenderSize(this.jdField_a_of_type_Boby.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(paramView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(this.jdField_a_of_type_AndroidContentContext);
    e();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu = ((AEEditorMvClipMenu)paramView.findViewById(2131371755));
    i();
    c();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131379218));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(new bnww(this));
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
      bnrh.d(jdField_b_of_type_JavaLangString, "no video paths");
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setMvClipMenuListener(new bnwx(this));
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != null) && (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
  }
  
  private void d()
  {
    bnxc localbnxc = new bnxc(getActivity(), 2131755189);
    if (this.jdField_a_of_type_JavaLangFloat == null) {}
    for (float f = this.jdField_a_of_type_Float;; f = this.jdField_a_of_type_JavaLangFloat.floatValue())
    {
      localbnxc.a(f);
      localbnxc.c(85);
      localbnxc.b(bpdd.b(getActivity(), 20.0F));
      localbnxc.a(bpdd.b(getActivity(), 212.0F));
      localbnxc.a(new bnwy(this, localbnxc));
      localbnxc.show();
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
    label22:
    String str3;
    if (b())
    {
      str1 = "video_edit_clip_start_time";
      if (!b()) {
        break label89;
      }
      str2 = "video_edit_clip_end_time";
      if (!b()) {
        break label95;
      }
      str3 = "video_edit_clip_speed";
      label33:
      if (this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange == null) {
        break label101;
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
      label89:
      str2 = "endtime";
      break label22;
      label95:
      str3 = "speed";
      break label33;
      label101:
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
      localObject = bhdj.a((Context)localObject, 230).setTitle(anvx.a(2131689726)).setMessage(((Context)localObject).getString(2131689727)).setPositiveButton(((Context)localObject).getString(2131689726), new bnxb(this)).setNegativeButton(((Context)localObject).getString(2131689698), new bnxa(this));
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
    bnrh.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_b_of_type_Boolean = true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    bnrh.b(jdField_b_of_type_JavaLangString, "onCreateView");
    this.jdField_c_of_type_Boolean = bnri.a();
    paramLayoutInflater = paramLayoutInflater.inflate(2131558578, paramViewGroup, false);
    a(paramLayoutInflater);
    b(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bnrh.b(jdField_b_of_type_JavaLangString, "onDestroy");
    l();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      if (!b()) {
        break label104;
      }
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setStyleAsCancelAndFinish();
      }
    }
    while (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.onResume();
      this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = a();
      this.jdField_a_of_type_Float = a();
      this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setTimeLineViewSpeed(this.jdField_a_of_type_Float, new bnwv(this));
      e();
      f();
      if (this.jdField_b_of_type_Boolean) {
        j();
      }
      return;
      label104:
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setLeftButtonAsBackArray();
      }
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.onPause();
    k();
  }
  
  public void onPause()
  {
    super.onPause();
    bnrh.b(jdField_b_of_type_JavaLangString, "onPause");
    h();
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      bnrh.a(jdField_b_of_type_JavaLangString, "onPause: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
      k();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bnrh.b(jdField_b_of_type_JavaLangString, "onResume");
    g();
    bnrh.a(jdField_b_of_type_JavaLangString, "onResume: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment
 * JD-Core Version:    0.7.0.1
 */