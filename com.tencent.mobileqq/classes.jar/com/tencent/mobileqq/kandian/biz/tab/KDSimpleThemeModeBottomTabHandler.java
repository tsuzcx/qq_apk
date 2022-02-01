package com.tencent.mobileqq.kandian.biz.tab;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/KDSimpleThemeModeBottomTabHandler;", "Lcom/tencent/mobileqq/kandian/biz/tab/IKDBottomTabThemeHandler;", "()V", "localInitIconMap", "Ljava/util/HashMap;", "", "", "", "Landroid/util/Pair;", "", "Lkotlin/collections/HashMap;", "getBottomTabIcon", "tabTag", "bottomTabImmersive", "getBottomTabTitleColor", "isSelected", "getSimpleModeTabTitleSelectedColor", "resources", "Landroid/content/res/Resources;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDSimpleThemeModeBottomTabHandler
  implements IKDBottomTabThemeHandler
{
  public static final KDSimpleThemeModeBottomTabHandler b = new KDSimpleThemeModeBottomTabHandler();
  private static final HashMap<String, Map<Boolean, android.util.Pair<Integer, Integer>>> c = new HashMap();
  
  static
  {
    Object localObject2 = Boolean.valueOf(false);
    Object localObject1 = Integer.valueOf(2130852561);
    Object localObject3 = TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852559), localObject1));
    Object localObject7 = Boolean.valueOf(true);
    Object localObject6 = MapsKt.hashMapOf(new kotlin.Pair[] { localObject3, TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848895), localObject1)) });
    localObject1 = Integer.valueOf(2130852557);
    Object localObject5 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852555), localObject1)), TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848892), localObject1)) });
    localObject1 = Integer.valueOf(2130852573);
    Object localObject4 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852571), localObject1)), TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848893), localObject1)) });
    localObject1 = Integer.valueOf(2130852577);
    localObject3 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852575), localObject1)), TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848891), localObject1)) });
    localObject1 = Integer.valueOf(2130852579);
    localObject1 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(localObject1, Integer.valueOf(2130852581))), TuplesKt.to(localObject7, new android.util.Pair(localObject1, Integer.valueOf(2130852581))) });
    localObject2 = MapsKt.hashMapOf(new kotlin.Pair[] { TuplesKt.to(localObject2, new android.util.Pair(Integer.valueOf(2130852564), Integer.valueOf(2130852567))), TuplesKt.to(localObject7, new android.util.Pair(Integer.valueOf(2130848894), Integer.valueOf(2130852567))) });
    localObject7 = (Map)c;
    String str = FrameControllerUtil.l;
    Intrinsics.checkExpressionValueIsNotNull(str, "FrameControllerUtil.TAB_TAG_CONVERSATOIN");
    ((Map)localObject7).put(str, localObject6);
    localObject6 = (Map)c;
    localObject7 = FrameControllerUtil.m;
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "FrameControllerUtil.TAB_TAG_CONTACT");
    ((Map)localObject6).put(localObject7, localObject5);
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
  
  private final int a(Resources paramResources)
  {
    if (paramResources == null)
    {
      QLog.e("KDSimpleThemeModeBottomTabHandler", 1, "getTabTextViewColor called error: resources == null");
      return Color.parseColor("#000000");
    }
    String str = QQTheme.getCurrentThemeId();
    if (TextUtils.isEmpty((CharSequence)str)) {
      return paramResources.getColor(2131168196);
    }
    if (TabDragAnimationView.q == null)
    {
      TabDragAnimationView.q = new HashMap();
      HashMap localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("2971", "#0099FF");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("2921", "#0099FF");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("3491", "#19497D");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("3063", "#12D6BC");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("3064", "#FFE454");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("3066", "#FF779A");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("3065", "#6532D7");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("3067", "#FF6772");
      localHashMap = TabDragAnimationView.q;
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "TabDragAnimationView.sSimpleUITabTVColor");
      ((Map)localHashMap).put("2920", "#0066CC");
    }
    str = (String)TabDragAnimationView.q.get(str);
    if (!TextUtils.isEmpty((CharSequence)str)) {
      return Color.parseColor(str);
    }
    return paramResources.getColor(2131168196);
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
      return a(localBaseApplicationImpl.getResources());
    }
    if (paramBoolean2)
    {
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
      return localBaseApplicationImpl.getResources().getColor(2131168263);
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
    return localBaseApplicationImpl.getResources().getColor(2131168264);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.KDSimpleThemeModeBottomTabHandler
 * JD-Core Version:    0.7.0.1
 */