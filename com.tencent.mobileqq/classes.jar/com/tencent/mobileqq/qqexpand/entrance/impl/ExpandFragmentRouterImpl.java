package com.tencent.mobileqq.qqexpand.entrance.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.fragment.ExpandOldEditFragment;
import com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/entrance/impl/ExpandFragmentRouterImpl;", "Lcom/tencent/mobileqq/qqexpand/entrance/IExpandFragmentRouter;", "()V", "launchExpandEditFragment", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "launchExpandEditFragmentForResult", "requestCode", "", "launchNewEditFragmentForResult", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFragmentRouterImpl
  implements IExpandFragmentRouter
{
  public void launchExpandEditFragment(@NotNull Activity paramActivity, @Nullable Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    QPublicFragmentActivity.Launcher.a((Context)paramActivity, paramIntent, QPublicFragmentActivity.class, ExpandOldEditFragment.class);
  }
  
  public void launchExpandEditFragmentForResult(@NotNull Activity paramActivity, @Nullable Intent paramIntent, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    QPublicFragmentActivity.startForResult(paramActivity, paramIntent, ExpandOldEditFragment.class, paramInt);
  }
  
  public void launchNewEditFragmentForResult(@NotNull Activity paramActivity, @Nullable Intent paramIntent, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    QPublicFragmentActivity.startForResult(paramActivity, paramIntent, ExtendFriendNewEditFragment.class, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.impl.ExpandFragmentRouterImpl
 * JD-Core Version:    0.7.0.1
 */