package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/IKDBottomTabThemeHandler$Companion;", "", "()V", "TAB_NAME_CONTACT", "", "TAB_NAME_CONVERSATION", "TAB_NAME_GUILD", "TAB_NAME_KANDIAN", "TAB_NAME_KANDIAN_RIJ_FRAME", "TAB_NAME_LEBA", "TAB_NAME_QCIRCLE", "TAB_NAME_QZONE", "TAG", "tabNameMap", "Ljava/util/HashMap;", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashMap;", "getTabNameByTag", "tabTag", "isSupportTab", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class IKDBottomTabThemeHandler$Companion
{
  private static final HashMap<String, String> b = MapsKt.hashMapOf(new Pair[] { TuplesKt.to(FrameControllerUtil.l, "com.tencent.mobileqq.activity.home.Conversation"), TuplesKt.to(FrameControllerUtil.m, "com.tencent.mobileqq.activity.contacts.base.Contacts"), TuplesKt.to(FrameControllerUtil.o, "com.tencent.mobileqq.leba.Leba"), TuplesKt.to(FrameControllerUtil.q, "com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame"), TuplesKt.to(FrameControllerUtil.r, "com.tencent.mobileqq.activity.qcircle.QCircleFrame"), TuplesKt.to(FrameControllerUtil.s, "com.tencent.mobileqq.guild.mainframe.GuildMainFrame") });
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tabTag");
    return b.containsKey(paramString);
  }
  
  @Nullable
  public final String b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tabTag");
    return (String)b.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.IKDBottomTabThemeHandler.Companion
 * JD-Core Version:    0.7.0.1
 */