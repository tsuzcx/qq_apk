package com.tencent.mobileqq.kandian.biz.common;

import android.view.View;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.widget.QQTabHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJWindowUtils;", "", "()V", "getTabHeight", "", "mf", "Lcom/tencent/mobileqq/activity/home/MainFragment;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWindowUtils
{
  public static final RIJWindowUtils a = new RIJWindowUtils();
  
  public final int a(@NotNull MainFragment paramMainFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramMainFragment, "mf");
    paramMainFragment = paramMainFragment.getView();
    if (paramMainFragment != null)
    {
      paramMainFragment = paramMainFragment.findViewById(16908306);
      if ((paramMainFragment instanceof QQTabHost))
      {
        paramMainFragment = (View)((QQTabHost)paramMainFragment).getTabWidget();
        if (paramMainFragment != null) {
          return paramMainFragment.getHeight();
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJWindowUtils
 * JD-Core Version:    0.7.0.1
 */