package com.tencent.mobileqq.kandian.biz.tab;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/KDDefaultThemeModeBottomTabHandler;", "Lcom/tencent/mobileqq/kandian/biz/tab/IKDBottomTabThemeHandler;", "()V", "localInitIconMap", "Ljava/util/HashMap;", "", "", "", "Landroid/util/Pair;", "", "Lkotlin/collections/HashMap;", "getBottomTabIcon", "tabTag", "bottomTabImmersive", "getBottomTabTitleColor", "isSelected", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDDefaultThemeModeBottomTabHandler
  implements IKDBottomTabThemeHandler
{
  public static final KDDefaultThemeModeBottomTabHandler b = new KDDefaultThemeModeBottomTabHandler();
  private static final HashMap<String, Map<Boolean, android.util.Pair<Integer, Integer>>> c = new HashMap();
  
  static
  {
    Object localObject2 = Boolean.valueOf(false);
    Object localObject1 = Integer.valueOf(2130852560);
    Object localObject3 = TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852558), localObject1));
    Object localObject7 = Boolean.valueOf(true);
    Object localObject5 = MapsKt.hashMapOf(new kotlin.Pair[] { localObject3, TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848904), localObject1)) });
    localObject1 = TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852554), Integer.valueOf(2130852556)));
    localObject3 = Integer.valueOf(2130848903);
    Object localObject6 = MapsKt.hashMapOf(new kotlin.Pair[] { localObject1, TuplesKt.to(localObject7, new android.util.Pair(localObject3, localObject3)) });
    localObject1 = Integer.valueOf(2130852572);
    Object localObject4 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852570), localObject1)), TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848905), localObject1)) });
    localObject1 = Integer.valueOf(2130852576);
    localObject3 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852574), localObject1)), TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848906), localObject1)) });
    localObject1 = Integer.valueOf(2130852578);
    localObject1 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(localObject1, Integer.valueOf(2130852580))), TuplesKt.to(localObject7, new android.util.Pair(localObject1, Integer.valueOf(2130852580))) });
    localObject2 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852562), Integer.valueOf(2130852566))), TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130852562), Integer.valueOf(2130852566))) });
    localObject7 = (Map)c;
    String str = FrameControllerUtil.l;
    Intrinsics.checkExpressionValueIsNotNull(str, "FrameControllerUtil.TAB_TAG_CONVERSATOIN");
    ((Map)localObject7).put(str, localObject5);
    localObject5 = (Map)c;
    localObject7 = FrameControllerUtil.m;
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "FrameControllerUtil.TAB_TAG_CONTACT");
    ((Map)localObject5).put(localObject7, localObject6);
    localObject5 = (Map)c;
    localObject6 = FrameControllerUtil.o;
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "FrameControllerUtil.TAB_TAG_LEBA");
    ((Map)localObject5).put(localObject6, localObject4);
    localObject4 = (Map)c;
    localObject5 = FrameControllerUtil.q;
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "FrameControllerUtil.TAB_TAG_KANDIAN");
    ((Map)localObject4).put(localObject5, localObject3);
    localObject3 = (Map)c;
    localObject4 = FrameControllerUtil.r;
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "FrameControllerUtil.TAB_TAG_QCIRCLE");
    ((Map)localObject3).put(localObject4, localObject1);
    localObject1 = (Map)c;
    localObject3 = FrameControllerUtil.s;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "FrameControllerUtil.TAB_TAG_GUILD");
    ((Map)localObject1).put(localObject3, localObject2);
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        localBaseApplicationImpl = BaseApplicationImpl.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
        return localBaseApplicationImpl.getResources().getColor(2131168196);
      }
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
      return localBaseApplicationImpl.getResources().getColor(2131168264);
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
    return localBaseApplicationImpl.getResources().getColor(2131168263);
  }
  
  @Nullable
  public android.util.Pair<Integer, Integer> a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tabTag");
    paramString = (Map)c.get(paramString);
    if (paramString != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString, "localInitIconMap[tabTag] ?: return null");
      return (android.util.Pair)paramString.get(Boolean.valueOf(paramBoolean));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.KDDefaultThemeModeBottomTabHandler
 * JD-Core Version:    0.7.0.1
 */