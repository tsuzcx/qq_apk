package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.res.Resources;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlFragment$initViewModel$3<T>
  implements Observer<Boolean>
{
  MusicVolumeControlFragment$initViewModel$3(MusicVolumeControlFragment paramMusicVolumeControlFragment) {}
  
  public final void a(Boolean paramBoolean)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "it");
    float f;
    if (paramBoolean.booleanValue())
    {
      localObject2 = this.a;
      localObject1 = (Float)MusicVolumeControlFragment.a((MusicVolumeControlFragment)localObject2).b().getValue();
      if (localObject1 == null) {
        localObject1 = Float.valueOf(0.5F);
      }
      f = MusicVolumeControlFragment.b((MusicVolumeControlFragment)localObject2, ((Float)localObject1).floatValue());
    }
    else
    {
      f = 0.0F;
    }
    double d = f;
    Object localObject1 = this.a;
    Object localObject2 = (StartPointSeekBar)((MusicVolumeControlFragment)localObject1).a(2131446067);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "sldOrigin");
    MusicVolumeControlFragment.a((MusicVolumeControlFragment)localObject1, (StartPointSeekBar)localObject2, paramBoolean.booleanValue());
    if (paramBoolean.booleanValue()) {
      ((TextView)this.a.a(2131448232)).setTextColor(this.a.getResources().getColor(2131165865));
    } else {
      ((TextView)this.a.a(2131448232)).setTextColor(this.a.getResources().getColor(2131165866));
    }
    paramBoolean = this.a;
    localObject1 = (StartPointSeekBar)paramBoolean.a(2131446067);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "sldOrigin");
    localObject2 = (TextView)this.a.a(2131448233);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "tvOriginTip");
    MusicVolumeControlFragment.a(paramBoolean, (StartPointSeekBar)localObject1, d, (TextView)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.initViewModel.3
 * JD-Core Version:    0.7.0.1
 */