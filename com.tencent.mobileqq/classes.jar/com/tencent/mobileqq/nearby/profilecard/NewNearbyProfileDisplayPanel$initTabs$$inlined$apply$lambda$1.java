package com.tencent.mobileqq.nearby.profilecard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"addTabBar", "", "strId", "", "invoke", "com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$initTabs$1$1"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileDisplayPanel$initTabs$$inlined$apply$lambda$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  NewNearbyProfileDisplayPanel$initTabs$$inlined$apply$lambda$1(ViewGroup paramViewGroup, NewNearbyProfileDisplayPanel paramNewNearbyProfileDisplayPanel)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    View localView = LayoutInflater.from(this.$this_apply.getContext()).inflate(1946484751, this.$this_apply, false);
    Object localObject = (TextView)localView.findViewById(1946419231);
    ((TextView)localObject).setText((CharSequence)HardCodeUtil.a(paramInt));
    localObject = new Pair(localObject, localView.findViewById(1946419204));
    NewNearbyProfileDisplayPanel.e(this.this$0).add(localObject);
    localView.setOnClickListener((View.OnClickListener)new NewNearbyProfileDisplayPanel.initTabs..inlined.apply.lambda.1.1((Pair)localObject, this, paramInt));
    this.$this_apply.addView(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.initTabs..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */