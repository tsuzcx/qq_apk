package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.Context;
import android.media.AudioManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModelFactory;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "invoke"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlFragment$musicPlayViewModel$2
  extends Lambda
  implements Function0<AbsWinkMusicPlayerViewModel>
{
  MusicVolumeControlFragment$musicPlayViewModel$2(MusicVolumeControlFragment paramMusicVolumeControlFragment)
  {
    super(0);
  }
  
  @NotNull
  public final AbsWinkMusicPlayerViewModel invoke()
  {
    Object localObject = this.this$0.requireContext().getSystemService("audio");
    if (localObject != null)
    {
      localObject = (AudioManager)localObject;
      Scene localScene = MusicVolumeControlFragment.c(this.this$0);
      return (AbsWinkMusicPlayerViewModel)new ViewModelProvider((ViewModelStoreOwner)this.this$0.requireActivity(), (ViewModelProvider.Factory)new MusicPlayerViewModelFactory((AudioManager)localObject, localScene)).get(AbsWinkMusicPlayerViewModel.class);
    }
    throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.musicPlayViewModel.2
 * JD-Core Version:    0.7.0.1
 */