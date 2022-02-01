package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/util/Observable;", "kotlin.jvm.PlatformType", "arg", "", "update"}, k=3, mv={1, 1, 16})
final class AudienceOperationBarView$followStateObserver$1
  implements Observer
{
  AudienceOperationBarView$followStateObserver$1(AudienceOperationBarView paramAudienceOperationBarView) {}
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject != null)
    {
      boolean bool = ((Boolean)paramObject).booleanValue();
      paramObservable = (ImageView)this.a.a(2131433508);
      int i;
      if (bool) {
        i = 2130853024;
      } else {
        i = 2130853023;
      }
      paramObservable.setImageResource(i);
      ((FrameLayout)this.a.a(2131433509)).setOnClickListener((View.OnClickListener)new AudienceOperationBarView.followStateObserver.1.1(this, bool));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.followStateObserver.1
 * JD-Core Version:    0.7.0.1
 */