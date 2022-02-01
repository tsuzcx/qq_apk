package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.OperationCallback;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog.WinkOperationCallback;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.WebCallback;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment;", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicMenuBaseFragment;", "()V", "menuInfoDelegate", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$MenuInfoDelegate;", "musicBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "getMusicBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "musicBroadcastReceiver$delegate", "Lkotlin/Lazy;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "getMusicSourceViewModel", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel$delegate", "playerCallback", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$PlayerControlCallback;", "getIntentToMusicWebView", "Landroid/content/Intent;", "handleEditModeChanged", "", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "registerMusicBroadcastReceiver", "setMenuInfoDelegate", "delegate", "setPlayerCallback", "callback", "updatePlayerProgress", "progress", "", "Companion", "MenuInfoDelegate", "PlayerControlCallback", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicSelectFragment
  extends MusicMenuBaseFragment
{
  public static final MusicSelectFragment.Companion b = new MusicSelectFragment.Companion(null);
  private static final Class<MusicSelectFragment> g = MusicSelectFragment.class;
  private final Lazy c = LazyKt.lazy((Function0)new MusicSelectFragment.musicSourceViewModel.2(this));
  private final Lazy d = LazyKt.lazy((Function0)new MusicSelectFragment.musicBroadcastReceiver.2(this));
  private MusicSelectFragment.PlayerControlCallback e;
  private MusicSelectFragment.MenuInfoDelegate f;
  private HashMap h;
  
  public MusicSelectFragment()
  {
    super(2131628267);
  }
  
  private final MusicSourceViewModel c()
  {
    return (MusicSourceViewModel)this.c.getValue();
  }
  
  private final BroadcastReceiver d()
  {
    return (BroadcastReceiver)this.d.getValue();
  }
  
  private final Intent e()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    QZoneHelper.addSource(localIntent);
    localIntent.putExtra("videoclipduration", (int)c().g());
    localIntent.putExtra("videofrom", "fromqqwink");
    if (c().e() == WinkEditorViewModel.EditMode.Image)
    {
      localIntent.putExtra("type", "photo");
      return localIntent;
    }
    localIntent.putExtra("type", "notphoto");
    return localIntent;
  }
  
  private final void f()
  {
    IntentFilter localIntentFilter = new IntentFilter("action_dispatch_music_event");
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.registerReceiver(d(), localIntentFilter);
    }
    c().a((MusicSourceViewModel.WebCallback)new MusicSelectFragment.registerMusicBroadcastReceiver.1(this));
  }
  
  public View a(int paramInt)
  {
    if (this.h == null) {
      this.h = new HashMap();
    }
    View localView2 = (View)this.h.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.h.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    HashMap localHashMap = this.h;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void a(long paramLong)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.runOnUiThread((Runnable)new MusicSelectFragment.updatePlayerProgress.1(this, paramLong));
    }
  }
  
  public final void a(@NotNull MusicSelectFragment.MenuInfoDelegate paramMenuInfoDelegate)
  {
    Intrinsics.checkParameterIsNotNull(paramMenuInfoDelegate, "delegate");
    this.f = paramMenuInfoDelegate;
  }
  
  public final void a(@NotNull MusicSelectFragment.PlayerControlCallback paramPlayerControlCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayerControlCallback, "callback");
    this.e = paramPlayerControlCallback;
  }
  
  public final void b()
  {
    WinkEditorMusicControlPanel localWinkEditorMusicControlPanel;
    if (c().e() != WinkEditorViewModel.EditMode.Image)
    {
      localWinkEditorMusicControlPanel = (WinkEditorMusicControlPanel)a(2131450175);
      if (localWinkEditorMusicControlPanel != null) {
        localWinkEditorMusicControlPanel.setMusicDisableEnable(true);
      }
      localWinkEditorMusicControlPanel = (WinkEditorMusicControlPanel)a(2131450175);
      if (localWinkEditorMusicControlPanel != null) {
        localWinkEditorMusicControlPanel.setClipEntranceVisible(true);
      }
    }
    else
    {
      localWinkEditorMusicControlPanel = (WinkEditorMusicControlPanel)a(2131450175);
      if (localWinkEditorMusicControlPanel != null) {
        localWinkEditorMusicControlPanel.setMusicDisableEnable(false);
      }
      localWinkEditorMusicControlPanel = (WinkEditorMusicControlPanel)a(2131450175);
      if (localWinkEditorMusicControlPanel != null) {
        localWinkEditorMusicControlPanel.setClipEntranceVisible(false);
      }
    }
  }
  
  public void onDestroyView()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.unregisterReceiver(d());
    }
    c().a((MusicSourceViewModel.WebCallback)null);
    super.onDestroyView();
    a();
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    c().a().observe(getViewLifecycleOwner(), (Observer)new MusicSelectFragment.onViewCreated.1(this));
    c().b().observe(getViewLifecycleOwner(), (Observer)new MusicSelectFragment.onViewCreated.2(this));
    c().p().observe(getViewLifecycleOwner(), (Observer)new MusicSelectFragment.onViewCreated.3(this));
    ((WinkEditorMusicControlPanel)a(2131450175)).setMusicListOperationCallback((WinkEditorMusicPanel.OperationCallback)new MusicSelectFragment.onViewCreated.4(this));
    ((WinkEditorMusicControlPanel)a(2131450175)).setMusicLyricOperationCallback((WinkLyricPanelDialog.WinkOperationCallback)new MusicSelectFragment.onViewCreated.5(this));
    c().c().observe(getViewLifecycleOwner(), (Observer)new MusicSelectFragment.onViewCreated.6(this));
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment
 * JD-Core Version:    0.7.0.1
 */