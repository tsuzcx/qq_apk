package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$2$1"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlViewModel$$special$$inlined$apply$lambda$2<T>
  implements Observer<S>
{
  MusicVolumeControlViewModel$$special$$inlined$apply$lambda$2(MediatorLiveData paramMediatorLiveData, MusicVolumeControlViewModel paramMusicVolumeControlViewModel) {}
  
  public final void a(MusicVolumeControlViewModel.VolumeType paramVolumeType)
  {
    if ((paramVolumeType != MusicVolumeControlViewModel.VolumeType.BGM) && (paramVolumeType != MusicVolumeControlViewModel.VolumeType.TEMPLATE))
    {
      if (paramVolumeType == MusicVolumeControlViewModel.VolumeType.NONE) {
        this.a.removeSource((LiveData)MusicVolumeControlViewModel.b(this.b));
      }
    }
    else
    {
      this.a.removeSource((LiveData)MusicVolumeControlViewModel.b(this.b));
      this.a.addSource((LiveData)MusicVolumeControlViewModel.b(this.b), (Observer)new MusicVolumeControlViewModel..special..inlined.apply.lambda.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel..special..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */