package com.tencent.timi.game.component.chat.input;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class ExpandHallInputBoxView$isSpeakerMutableObserver$1<T>
  implements Observer<Boolean>
{
  ExpandHallInputBoxView$isSpeakerMutableObserver$1(ExpandHallInputBoxView paramExpandHallInputBoxView) {}
  
  public final void a(Boolean paramBoolean)
  {
    ImageView localImageView = ExpandHallInputBoxView.c(this.a);
    if (localImageView != null)
    {
      int i;
      if (Intrinsics.areEqual(paramBoolean, Boolean.valueOf(true))) {
        i = 2130852955;
      } else {
        i = 2130852956;
      }
      localImageView.setImageResource(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView.isSpeakerMutableObserver.1
 * JD-Core Version:    0.7.0.1
 */