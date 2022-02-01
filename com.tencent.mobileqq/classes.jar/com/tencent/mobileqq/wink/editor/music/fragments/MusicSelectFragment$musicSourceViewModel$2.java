package com.tencent.mobileqq.wink.editor.music.fragments;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "invoke"}, k=3, mv={1, 1, 16})
final class MusicSelectFragment$musicSourceViewModel$2
  extends Lambda
  implements Function0<MusicSourceViewModel>
{
  MusicSelectFragment$musicSourceViewModel$2(MusicSelectFragment paramMusicSelectFragment)
  {
    super(0);
  }
  
  @NotNull
  public final MusicSourceViewModel invoke()
  {
    return (MusicSourceViewModel)new ViewModelProvider((ViewModelStoreOwner)this.this$0.requireActivity()).get(MusicSourceViewModel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.musicSourceViewModel.2
 * JD-Core Version:    0.7.0.1
 */