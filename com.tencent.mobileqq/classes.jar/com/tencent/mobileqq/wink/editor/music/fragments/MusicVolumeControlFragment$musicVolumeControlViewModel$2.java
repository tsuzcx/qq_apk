package com.tencent.mobileqq.wink.editor.music.fragments;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "invoke"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlFragment$musicVolumeControlViewModel$2
  extends Lambda
  implements Function0<MusicVolumeControlViewModel>
{
  MusicVolumeControlFragment$musicVolumeControlViewModel$2(MusicVolumeControlFragment paramMusicVolumeControlFragment)
  {
    super(0);
  }
  
  @NotNull
  public final MusicVolumeControlViewModel invoke()
  {
    return (MusicVolumeControlViewModel)new ViewModelProvider((ViewModelStoreOwner)this.this$0.requireActivity()).get(MusicVolumeControlViewModel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.musicVolumeControlViewModel.2
 * JD-Core Version:    0.7.0.1
 */