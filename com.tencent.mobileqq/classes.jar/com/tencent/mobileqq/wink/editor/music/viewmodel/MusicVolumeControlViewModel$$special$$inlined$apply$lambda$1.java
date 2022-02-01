package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "enabled", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V", "com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$1$1"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlViewModel$$special$$inlined$apply$lambda$1<T>
  implements Observer<S>
{
  MusicVolumeControlViewModel$$special$$inlined$apply$lambda$1(MediatorLiveData paramMediatorLiveData, MusicVolumeControlViewModel paramMusicVolumeControlViewModel) {}
  
  public final void a(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue())
    {
      this.a.removeSource((LiveData)MusicVolumeControlViewModel.a(this.b));
      return;
    }
    this.a.addSource((LiveData)MusicVolumeControlViewModel.a(this.b), (Observer)new MusicVolumeControlViewModel..special..inlined.apply.lambda.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel..special..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */