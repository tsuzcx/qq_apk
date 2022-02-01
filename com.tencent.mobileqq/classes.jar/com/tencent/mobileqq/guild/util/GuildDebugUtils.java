package com.tencent.mobileqq.guild.util;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/util/GuildDebugUtils;", "", "()V", "TAG", "", "fragmentDebugLog", "Lkotlin/Lazy;", "fragment", "Landroidx/fragment/app/Fragment;", "name", "method", "logFragmentDebugInfo", "", "methodContext", "logFunction", "T", "message", "func", "Lkotlin/Function0;", "(Lkotlin/Lazy;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeChildFragmentManagerOf", "Landroidx/fragment/app/FragmentManager;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildDebugUtils
{
  public static final GuildDebugUtils a = new GuildDebugUtils();
  
  @Nullable
  public final FragmentManager a(@Nullable Fragment paramFragment)
  {
    FragmentManager localFragmentManager = null;
    if (paramFragment != null) {}
    try
    {
      localFragmentManager = paramFragment.getChildFragmentManager();
      return localFragmentManager;
    }
    catch (IllegalStateException paramFragment) {}
    return null;
  }
  
  @NotNull
  public final Lazy<String> a(@Nullable Fragment paramFragment, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "method");
    View localView2 = null;
    View localView1;
    if (paramFragment != null) {
      localView1 = paramFragment.getView();
    } else {
      localView1 = null;
    }
    Object localObject = a(paramFragment);
    if (localObject != null) {
      localObject = ((FragmentManager)localObject).findFragmentByTag("GuildDiscoverController_QQGuildDiscoverFragment");
    } else {
      localObject = null;
    }
    if (localView1 != null) {
      localView2 = localView1.findViewById(2131434689);
    }
    return LazyKt.lazy((Function0)new GuildDebugUtils.fragmentDebugLog.1(paramString1, paramFragment, localView2, (Fragment)localObject, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildDebugUtils
 * JD-Core Version:    0.7.0.1
 */