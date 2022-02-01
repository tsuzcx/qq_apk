package com.tencent.mobileqq.kandian.biz.tab;

import android.util.Pair;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/IKDBottomTabThemeHandler;", "", "getBottomTabIcon", "Landroid/util/Pair;", "", "tabTag", "", "bottomTabImmersive", "", "getBottomTabTitleColor", "isSelected", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IKDBottomTabThemeHandler
{
  public static final IKDBottomTabThemeHandler.Companion a = IKDBottomTabThemeHandler.Companion.a;
  
  public abstract int a(boolean paramBoolean1, boolean paramBoolean2);
  
  @Nullable
  public abstract Pair<Integer, Integer> a(@NotNull String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.IKDBottomTabThemeHandler
 * JD-Core Version:    0.7.0.1
 */