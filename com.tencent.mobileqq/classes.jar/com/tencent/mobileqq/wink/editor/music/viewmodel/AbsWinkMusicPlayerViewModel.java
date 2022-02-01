package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_progressLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "progressLiveData", "Landroidx/lifecycle/LiveData;", "getProgressLiveData", "()Landroidx/lifecycle/LiveData;", "seekToPosition", "", "position", "startPlayer", "stopPlayer", "updateMusic", "musicInfoWrapper", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "updateVolume", "newValue", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsWinkMusicPlayerViewModel
  extends ViewModel
{
  private final MutableLiveData<Integer> a = new MutableLiveData();
  @NotNull
  private final LiveData<Integer> b;
  
  public AbsWinkMusicPlayerViewModel()
  {
    MutableLiveData localMutableLiveData = this.a;
    if (localMutableLiveData != null)
    {
      this.b = ((LiveData)localMutableLiveData);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
  }
  
  @NotNull
  public final LiveData<Integer> a()
  {
    return this.b;
  }
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(@NotNull MusicInfoWrapper paramMusicInfoWrapper);
  
  @NotNull
  protected final MutableLiveData<Integer> b()
  {
    return this.a;
  }
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel
 * JD-Core Version:    0.7.0.1
 */