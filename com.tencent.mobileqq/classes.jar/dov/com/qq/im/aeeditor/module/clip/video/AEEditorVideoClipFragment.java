package dov.com.qq.im.aeeditor.module.clip.video;

import alud;
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
import bdgm;
import bdjz;
import bljn;
import bljy;
import blmf;
import blmg;
import blmh;
import blmi;
import blmj;
import blov;
import blox;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import java.util.ArrayList;

public class AEEditorVideoClipFragment
  extends AEEditorBaseFragment
{
  private static final String jdField_b_of_type_JavaLangString = AEEditorVideoClipFragment.class.getSimpleName();
  private Context jdField_a_of_type_AndroidContentContext;
  private blox jdField_a_of_type_Blox = blov.a();
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView;
  private AEEditorMvClipMenu jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu;
  private AEEditorTopBar jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar;
  private boolean jdField_a_of_type_Boolean;
  private CMTimeRange jdField_b_of_type_ComTencentTavCoremediaCMTimeRange;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
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
    this.c = d();
    this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = a();
    this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131377469));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165232));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new blmf(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    paramView = new SessionConfig();
    paramView.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    paramView.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    paramView.setMaxIntermediateRenderSize(this.jdField_a_of_type_Blox.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(paramView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.c);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(this.jdField_a_of_type_AndroidContentContext);
    d();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu = ((AEEditorMvClipMenu)paramView.findViewById(2131370928));
    i();
    c();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131378144));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(new blmg(this));
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorVideoEdit"));
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.setMvClipMenuListener(new blmh(this));
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != null) && (this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange != this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
  }
  
  private String d()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("PhotoConst.SELECTED_PATHS"))) {
      localArrayList = localBundle.getStringArrayList("PhotoConst.SELECTED_PATHS");
    }
    while (localArrayList.size() > 0)
    {
      return (String)localArrayList.get(0);
      bljn.d(jdField_b_of_type_JavaLangString, "no video paths");
    }
    return null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange == null) {
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() > 60000000L)
      {
        localObject = CMTime.convertTimeScale(CMTime.fromMs(0L), 1000);
        localCMTime = CMTime.convertTimeScale(CMTime.fromMs(60000L), 1000).sub((CMTime)localObject);
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange((CMTime)localObject, localCMTime));
      }
    }
    long l;
    do
    {
      return;
      localObject = Long.valueOf(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getStartUs());
      l = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getEndUs();
    } while ((localObject == null) || (localObject == null));
    Object localObject = CMTime.convertTimeScale(CMTime.fromMs(((Long)localObject).longValue() / 1000L), 1000);
    CMTime localCMTime = CMTime.convertTimeScale(CMTime.fromMs(Long.valueOf(l).longValue() / 1000L), 1000).sub((CMTime)localObject);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange((CMTime)localObject, localCMTime));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange == null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L, 0L, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs());
    }
    Long localLong1;
    Long localLong2;
    do
    {
      return;
      localLong1 = Long.valueOf(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getStartUs() / 1000L);
      localLong2 = Long.valueOf(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getEndUs() / 1000L);
    } while ((localLong1 == null) || (localLong1 == null) || (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null));
    long l = (localLong2.longValue() - localLong1.longValue()) / 1000L;
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L, localLong1.longValue(), localLong2.longValue());
  }
  
  private void f() {}
  
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
  
  public String a()
  {
    return "AEEditorVideoClip";
  }
  
  public boolean a()
  {
    if (!c()) {
      a().a(getActivity());
    }
    for (;;)
    {
      return true;
      Object localObject = getActivity();
      localObject = bdgm.a((Context)localObject, 230).setTitle(alud.a(2131689805)).setMessage(((Context)localObject).getString(2131689806)).setPositiveButton(((Context)localObject).getString(2131689805), new blmj(this)).setNegativeButton(((Context)localObject).getString(2131689792), new blmi(this));
      if (localObject != null) {
        try
        {
          if (!((bdjz)localObject).isShowing())
          {
            ((bdjz)localObject).show();
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
    bljn.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_b_of_type_Boolean = true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onCreateView");
    a(2131165232);
    paramLayoutInflater = paramLayoutInflater.inflate(2131558539, paramViewGroup, false);
    a(paramLayoutInflater);
    b(paramLayoutInflater);
    f();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bljn.b(jdField_b_of_type_JavaLangString, "onDestroy");
    l();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      a(2131165232);
      if ((!b()) || (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar == null)) {
        break label72;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setStyleAsCancelAndFinish();
    }
    while (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = a();
      this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
      d();
      if (this.jdField_b_of_type_Boolean) {
        j();
      }
      return;
      label72:
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setLeftButtonAsBackArray();
    }
    k();
  }
  
  public void onPause()
  {
    super.onPause();
    bljn.b(jdField_b_of_type_JavaLangString, "onPause");
    h();
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      bljn.a(jdField_b_of_type_JavaLangString, "onPause: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
      k();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bljn.b(jdField_b_of_type_JavaLangString, "onResume");
    g();
    bljn.a(jdField_b_of_type_JavaLangString, "onResume: mPreviousPlaying is " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment
 * JD-Core Version:    0.7.0.1
 */