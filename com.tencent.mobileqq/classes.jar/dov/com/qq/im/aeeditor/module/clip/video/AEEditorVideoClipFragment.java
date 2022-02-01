package dov.com.qq.im.aeeditor.module.clip.video;

import amtj;
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
import bfur;
import bmbx;
import bmby;
import bmcu;
import bmhc;
import bmhd;
import bmhe;
import bmhf;
import bmhg;
import bmhi;
import bmhj;
import bmhk;
import bmme;
import bmmg;
import bnnl;
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
  private bmmg jdField_a_of_type_Bmmg = bmme.a();
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
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378228));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bmhc(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    paramView = new SessionConfig();
    paramView.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    paramView.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    paramView.setMaxIntermediateRenderSize(this.jdField_a_of_type_Bmmg.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(paramView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(this.jdField_a_of_type_AndroidContentContext);
    e();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu = ((AEEditorMvClipMenu)paramView.findViewById(2131371569));
    i();
    c();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131378924));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(new bmhe(this));
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
      bmbx.d(jdField_b_of_type_JavaLangString, "no video paths");
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setMvClipMenuListener(new bmhf(this));
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != null) && (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
  }
  
  private void d()
  {
    bmhk localbmhk = new bmhk(getActivity(), 2131755189);
    if (this.jdField_a_of_type_JavaLangFloat == null) {}
    for (float f = this.jdField_a_of_type_Float;; f = this.jdField_a_of_type_JavaLangFloat.floatValue())
    {
      localbmhk.a(f);
      localbmhk.c(85);
      localbmhk.b(bnnl.b(getActivity(), 20.0F));
      localbmhk.a(bnnl.b(getActivity(), 212.0F));
      localbmhk.a(new bmhg(this, localbmhk));
      localbmhk.show();
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
      localObject = bfur.a((Context)localObject, 230).setTitle(amtj.a(2131689718)).setMessage(((Context)localObject).getString(2131689719)).setPositiveButton(((Context)localObject).getString(2131689718), new bmhj(this)).setNegativeButton(((Context)localObject).getString(2131689690), new bmhi(this));
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
    bmbx.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_b_of_type_Boolean = true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    bmbx.b(jdField_b_of_type_JavaLangString, "onCreateView");
    this.jdField_c_of_type_Boolean = bmby.a();
    paramLayoutInflater = paramLayoutInflater.inflate(2131558567, paramViewGroup, false);
    a(paramLayoutInflater);
    b(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bmbx.b(jdField_b_of_type_JavaLangString, "onDestroy");
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
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setTimeLineViewSpeed(this.jdField_a_of_type_Float, new bmhd(this));
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
    bmbx.b(jdField_b_of_type_JavaLangString, "onPause");
    h();
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      bmbx.a(jdField_b_of_type_JavaLangString, "onPause: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
      k();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bmbx.b(jdField_b_of_type_JavaLangString, "onResume");
    g();
    bmbx.a(jdField_b_of_type_JavaLangString, "onResume: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment
 * JD-Core Version:    0.7.0.1
 */