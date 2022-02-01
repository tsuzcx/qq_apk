package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.ui.utils.ResUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/TestGiftFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TestGiftFragment
  extends QPublicBaseFragment
{
  private HashMap a;
  
  public void a()
  {
    HashMap localHashMap = this.a;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = getActivity();
    boolean bool = paramLayoutInflater instanceof QBaseActivity;
    paramViewGroup = null;
    if (!bool) {
      paramLayoutInflater = null;
    }
    paramBundle = (QBaseActivity)paramLayoutInflater;
    paramLayoutInflater = paramViewGroup;
    if (paramBundle != null)
    {
      paramViewGroup = (Context)paramBundle;
      paramLayoutInflater = new FrameLayout(paramViewGroup);
      paramLayoutInflater.setBackgroundColor(ResUtils.b(2131168297));
      paramViewGroup = new Button(paramViewGroup);
      paramLayoutInflater.addView((View)paramViewGroup, new ViewGroup.LayoutParams(-1, -2));
      paramBundle = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "qBaseActivity");
      paramBundle = new GiftLayerBuilder((Context)paramBundle).a(10001).a(123456789L).b(1);
      QBaseActivity localQBaseActivity = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
      paramViewGroup.setOnClickListener((View.OnClickListener)new TestGiftFragment.onCreateView.1(paramBundle.a(localQBaseActivity).a((ViewGroup)paramLayoutInflater)));
      paramLayoutInflater = (View)paramLayoutInflater;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TestGiftFragment
 * JD-Core Version:    0.7.0.1
 */