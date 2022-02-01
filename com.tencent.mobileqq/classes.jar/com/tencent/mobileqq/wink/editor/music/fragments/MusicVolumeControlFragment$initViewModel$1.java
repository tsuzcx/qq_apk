package com.tencent.mobileqq.wink.editor.music.fragments;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Float;)V"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlFragment$initViewModel$1<T>
  implements Observer<Float>
{
  MusicVolumeControlFragment$initViewModel$1(MusicVolumeControlFragment paramMusicVolumeControlFragment) {}
  
  public final void a(Float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bgm data = ");
    ((StringBuilder)localObject).append(paramFloat);
    Log.d("steveyxu", ((StringBuilder)localObject).toString());
    localObject = MusicVolumeControlFragment.b(this.a);
    Intrinsics.checkExpressionValueIsNotNull(paramFloat, "it");
    ((AbsWinkMusicPlayerViewModel)localObject).a(paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.initViewModel.1
 * JD-Core Version:    0.7.0.1
 */