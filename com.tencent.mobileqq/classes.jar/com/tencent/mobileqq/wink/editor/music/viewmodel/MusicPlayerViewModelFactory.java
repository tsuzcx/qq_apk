package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.media.AudioManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "am", "Landroid/media/AudioManager;", "scene", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "(Landroid/media/AudioManager;Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;)V", "getAm", "()Landroid/media/AudioManager;", "getScene", "()Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "produceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicPlayerViewModelFactory
  implements ViewModelProvider.Factory
{
  @NotNull
  private final AudioManager a;
  @NotNull
  private final Scene b;
  
  public MusicPlayerViewModelFactory(@NotNull AudioManager paramAudioManager, @NotNull Scene paramScene)
  {
    this.a = paramAudioManager;
    this.b = paramScene;
  }
  
  private final AbsWinkMusicPlayerViewModel a()
  {
    if (this.b == Scene.CAMERA) {
      return (AbsWinkMusicPlayerViewModel)new MusicPlayerViewModel(this.a);
    }
    if (this.b == Scene.EDIT) {
      return (AbsWinkMusicPlayerViewModel)new EditMusicPlayerViewModel();
    }
    throw ((Throwable)new InvalidParameterException("Invalid scene"));
  }
  
  public <T extends ViewModel> T create(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "modelClass");
    if (AbsWinkMusicPlayerViewModel.class.isAssignableFrom(paramClass)) {
      return (ViewModel)a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can not found ");
    localStringBuilder.append(paramClass);
    throw ((Throwable)new InvalidParameterException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModelFactory
 * JD-Core Version:    0.7.0.1
 */