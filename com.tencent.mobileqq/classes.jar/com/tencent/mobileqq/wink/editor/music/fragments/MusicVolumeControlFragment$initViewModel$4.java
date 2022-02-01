package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.res.Resources;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlFragment$initViewModel$4<T>
  implements Observer<MusicVolumeControlViewModel.VolumeType>
{
  MusicVolumeControlFragment$initViewModel$4(MusicVolumeControlFragment paramMusicVolumeControlFragment) {}
  
  public final void a(MusicVolumeControlViewModel.VolumeType paramVolumeType)
  {
    float f;
    if (paramVolumeType != MusicVolumeControlViewModel.VolumeType.NONE)
    {
      localObject1 = this.a;
      localObject2 = (StartPointSeekBar)((MusicVolumeControlFragment)localObject1).a(2131446065);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "sldMusic");
      MusicVolumeControlFragment.a((MusicVolumeControlFragment)localObject1, (StartPointSeekBar)localObject2, true);
      localObject2 = this.a;
      localObject1 = (Float)MusicVolumeControlFragment.a((MusicVolumeControlFragment)localObject2).d().getValue();
      if (localObject1 == null) {
        localObject1 = Float.valueOf(0.5F);
      }
      f = MusicVolumeControlFragment.b((MusicVolumeControlFragment)localObject2, ((Float)localObject1).floatValue());
    }
    else
    {
      localObject1 = this.a;
      localObject2 = (StartPointSeekBar)((MusicVolumeControlFragment)localObject1).a(2131446065);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "sldMusic");
      MusicVolumeControlFragment.a((MusicVolumeControlFragment)localObject1, (StartPointSeekBar)localObject2, false);
      f = 0.0F;
    }
    double d = f;
    if (paramVolumeType != MusicVolumeControlViewModel.VolumeType.NONE) {
      ((TextView)this.a.a(2131448229)).setTextColor(this.a.getResources().getColor(2131165865));
    } else {
      ((TextView)this.a.a(2131448229)).setTextColor(this.a.getResources().getColor(2131165866));
    }
    paramVolumeType = this.a;
    Object localObject1 = (StartPointSeekBar)paramVolumeType.a(2131446065);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "sldMusic");
    Object localObject2 = (TextView)this.a.a(2131448230);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "tvMusicTip");
    MusicVolumeControlFragment.a(paramVolumeType, (StartPointSeekBar)localObject1, d, (TextView)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.initViewModel.4
 * JD-Core Version:    0.7.0.1
 */