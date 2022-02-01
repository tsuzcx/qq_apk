package com.tencent.mobileqq.wink.editor.music.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/adapter/MusicMenuPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "scene", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "(Landroidx/fragment/app/FragmentManager;Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;)V", "musicSelectFragment", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment;", "getMusicSelectFragment", "()Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment;", "musicSelectFragment$delegate", "Lkotlin/Lazy;", "musicVolumeControlFragment", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "getMusicVolumeControlFragment", "()Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "musicVolumeControlFragment$delegate", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicMenuPagerAdapter
  extends FragmentPagerAdapter
{
  private final Lazy a = LazyKt.lazy((Function0)MusicMenuPagerAdapter.musicSelectFragment.2.INSTANCE);
  private final Lazy b;
  
  public MusicMenuPagerAdapter(@NotNull FragmentManager paramFragmentManager, @NotNull Scene paramScene)
  {
    super(paramFragmentManager);
    this.b = LazyKt.lazy((Function0)new MusicMenuPagerAdapter.musicVolumeControlFragment.2(paramScene));
  }
  
  private final MusicSelectFragment a()
  {
    return (MusicSelectFragment)this.a.getValue();
  }
  
  private final MusicVolumeControlFragment b()
  {
    return (MusicVolumeControlFragment)this.b.getValue();
  }
  
  public int getCount()
  {
    return 2;
  }
  
  @NotNull
  public Fragment getItem(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return (Fragment)a();
      }
      return (Fragment)b();
    }
    return (Fragment)a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter
 * JD-Core Version:    0.7.0.1
 */