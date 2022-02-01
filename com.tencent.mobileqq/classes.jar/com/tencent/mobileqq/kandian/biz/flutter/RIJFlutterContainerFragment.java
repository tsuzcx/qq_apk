package com.tencent.mobileqq.kandian.biz.flutter;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/flutter/RIJFlutterContainerFragment;", "Lcom/tencent/mobileqq/flutter/container/QFlutterContainerFragment;", "()V", "onBackEvent", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFlutterContainerFragment
  extends QFlutterContainerFragment
{
  public static final RIJFlutterContainerFragment.Companion a = new RIJFlutterContainerFragment.Companion(null);
  
  public boolean onBackEvent()
  {
    Bundle localBundle = getArguments();
    boolean bool;
    if (localBundle != null) {
      bool = localBundle.getBoolean("key_extra_support_back_event", true);
    } else {
      bool = true;
    }
    if (bool) {
      return super.onBackEvent();
    }
    return true;
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView.setFitsSystemWindows(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */