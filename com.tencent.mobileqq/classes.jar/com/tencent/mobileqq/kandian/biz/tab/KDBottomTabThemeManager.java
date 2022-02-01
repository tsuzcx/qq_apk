package com.tencent.mobileqq.kandian.biz.tab;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInitBean;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.kandian.base.ktx.CacheDelegateKt;
import com.tencent.mobileqq.kandian.base.ktx.CacheLazy;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/KDBottomTabThemeManager;", "", "()V", "TAG", "", "enable", "", "getEnable", "()Z", "enable$delegate", "Lkotlin/Lazy;", "sInitBean", "Lcom/tencent/mobileqq/activity/home/impl/FrameInitBean;", "sMainFragment", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/app/FrameFragment;", "changeBottomSingleTab", "", "isSelected", "tabTag", "tabIcon", "Lcom/tencent/mobileqq/widget/TabDragAnimationView;", "tabTxt", "Landroid/widget/TextView;", "isBottomTabImmersive", "changeBottomTabBackground", "frameFragment", "bottomTabImmersive", "changeBottomTabIcons", "doChangeIcon", "resourcePair", "Landroid/util/Pair;", "", "getHandlerByThemeMode", "Lcom/tencent/mobileqq/kandian/biz/tab/IKDBottomTabThemeHandler;", "getTagFromView", "view", "Landroid/view/View;", "tabText", "init", "bean", "isKanDianTabSelected", "isTabSelected", "recoverTab", "tabWidget", "tryChangeBottomTabTheme", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDBottomTabThemeManager
{
  public static final KDBottomTabThemeManager a = new KDBottomTabThemeManager();
  private static FrameInitBean b;
  private static WeakReference<FrameFragment> c;
  private static final Lazy d = (Lazy)new CacheLazy((Function0)KDBottomTabThemeManager.enable.2.INSTANCE, CacheDelegateKt.a());
  
  private final String a(View paramView, TextView paramTextView)
  {
    boolean bool = paramView instanceof RedTouchTab;
    String str = "";
    Object localObject;
    if (bool)
    {
      paramView = ((RedTouchTab)paramView).getTarget();
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.target");
      paramView = paramView.getContentDescription();
      localObject = str;
      if (paramView != null)
      {
        paramView = paramView.toString();
        localObject = str;
        if (paramView != null) {
          localObject = paramView;
        }
      }
      paramView = new StringBuilder();
      paramView.append("getTag form RedTouchTab:");
      paramView.append((String)localObject);
      QLog.i("TabFrameControllerImpl", 1, paramView.toString());
    }
    else
    {
      localObject = str;
      if ((paramView instanceof RedTouch))
      {
        paramView = ((RedTouch)paramView).getTarget();
        Intrinsics.checkExpressionValueIsNotNull(paramView, "view.target");
        paramView = paramView.getContentDescription();
        localObject = str;
        if (paramView != null)
        {
          paramView = paramView.toString();
          localObject = str;
          if (paramView != null) {
            localObject = paramView;
          }
        }
        paramView = new StringBuilder();
        paramView.append("getTag form RedTouch:");
        paramView.append((String)localObject);
        QLog.i("TabFrameControllerImpl", 1, paramView.toString());
      }
    }
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView = paramTextView.getText().toString();
      paramTextView = new StringBuilder();
      paramTextView.append("getTag form tabText:");
      paramTextView.append(paramView);
      QLog.i("TabFrameControllerImpl", 1, paramTextView.toString());
    }
    return paramView;
  }
  
  @JvmStatic
  public static final void a()
  {
    if (!a.b())
    {
      QLog.d("KDBottomTabThemeManager", 1, "tryChangeBottomTabTheme disable");
      return;
    }
    Object localObject1 = c;
    if (localObject1 != null)
    {
      localObject1 = (FrameFragment)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "sMainFragment?.get() ?: return");
        Object localObject2 = b;
        if (localObject2 != null)
        {
          boolean bool1 = ((FrameInitBean)localObject2).a();
          boolean bool3 = false;
          if (!bool1)
          {
            TabDragAnimationView.setIsKDImmersiveMode(false);
            QLog.d("KDBottomTabThemeManager", 1, "isShowKanDianTab: false");
            return;
          }
          if (QQTheme.isNowThemeIsNight())
          {
            TabDragAnimationView.setIsKDImmersiveMode(false);
            QLog.d("KDBottomTabThemeManager", 1, "isNowThemeIsNight: true");
            return;
          }
          if ((!QQTheme.isDefaultTheme()) && (!QQTheme.isNowSimpleUI()))
          {
            TabDragAnimationView.setIsKDImmersiveMode(false);
            QLog.d("KDBottomTabThemeManager", 1, "isNowThemeIsOther: true");
            return;
          }
          localObject2 = a;
          String str = FrameControllerUtil.r;
          Intrinsics.checkExpressionValueIsNotNull(str, "FrameControllerUtil.TAB_TAG_QCIRCLE");
          if (((KDBottomTabThemeManager)localObject2).a((FrameFragment)localObject1, str))
          {
            TabDragAnimationView.setIsKDImmersiveMode(false);
            QLog.d("KDBottomTabThemeManager", 1, "isNowInQCircleTab: true");
            return;
          }
          TabDragAnimationView.setIsKDImmersiveMode(true);
          boolean bool4 = a.a((FrameFragment)localObject1);
          localObject2 = RIJAppSetting.f;
          if ((localObject2 != null) && (((TabChannelCoverInfo)localObject2).isImmersive == true)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          boolean bool2 = bool3;
          if (bool4)
          {
            bool2 = bool3;
            if (bool1) {
              bool2 = true;
            }
          }
          a.b((FrameFragment)localObject1, bool2);
          a.a((FrameFragment)localObject1, bool2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("tryChangeBottomTabTheme: ");
          ((StringBuilder)localObject1).append("isKanDianTabSelected:");
          ((StringBuilder)localObject1).append(bool4);
          ((StringBuilder)localObject1).append(' ');
          ((StringBuilder)localObject1).append("isKdImmersive:");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).append(' ');
          ((StringBuilder)localObject1).append("bottomTabImmersive:");
          ((StringBuilder)localObject1).append(bool2);
          QLog.d("KDBottomTabThemeManager", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  @JvmStatic
  public static final void a(@Nullable FrameInitBean paramFrameInitBean, @NotNull FrameFragment paramFrameFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFrameFragment, "frameFragment");
    b = paramFrameInitBean;
    c = new WeakReference(paramFrameFragment);
  }
  
  private final void a(FrameFragment paramFrameFragment, View paramView)
  {
    if (paramFrameFragment.W == null) {
      return;
    }
    View localView = paramFrameFragment.W.findViewById(16908305);
    paramFrameFragment.K = ((QQBlurView)paramFrameFragment.W.findViewById(2131449311));
    if (paramFrameFragment.K != null)
    {
      if (localView == null) {
        return;
      }
      paramFrameFragment.K.setDebugTag("TAB");
      QQBlurView localQQBlurView = paramFrameFragment.K;
      Intrinsics.checkExpressionValueIsNotNull(localQQBlurView, "frameFragment.mTabBlurView");
      localQQBlurView.setVisibility(8);
      paramFrameFragment.K.b();
      paramFrameFragment.K.c();
      if (paramFrameFragment.u())
      {
        paramFrameFragment.a(paramView, localView);
        return;
      }
      paramFrameFragment.a(paramView);
    }
  }
  
  private final void a(FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    if (paramFrameFragment.s == null)
    {
      QLog.d("KDBottomTabThemeManager", 1, "changeTabHostBackGround failed, tabHost is null");
      return;
    }
    View localView = paramFrameFragment.s.findViewById(16908307);
    if (localView == null)
    {
      QLog.d("KDBottomTabThemeManager", 1, "changeTabHostBackGround failed NO widget");
      return;
    }
    if (paramBoolean)
    {
      localView.setBackgroundDrawable((Drawable)new ColorDrawable(-16777216));
      return;
    }
    a(paramFrameFragment, localView);
  }
  
  private final void a(TabDragAnimationView paramTabDragAnimationView, Pair<Integer, Integer> paramPair)
  {
    Object localObject = paramPair.second;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "resourcePair.second");
    paramTabDragAnimationView.setBgPressedDrawable(((Number)localObject).intValue());
    localObject = paramPair.first;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "resourcePair.first");
    paramTabDragAnimationView.setBgDrawable(((Number)localObject).intValue());
    localObject = (Integer)paramPair.first;
    int i = -1;
    if ((localObject == null) || (((Integer)localObject).intValue() != -1))
    {
      localObject = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext()");
      localObject = ((BaseApplication)localObject).getResources();
      paramPair = paramPair.first;
      Intrinsics.checkExpressionValueIsNotNull(paramPair, "resourcePair.first");
      paramPair = ((Resources)localObject).getDrawable(((Number)paramPair).intValue());
      Intrinsics.checkExpressionValueIsNotNull(paramPair, "BaseApplication.getConte…wable(resourcePair.first)");
      i = paramPair.getIntrinsicWidth();
    }
    paramPair = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramPair, "BaseApplication.getContext()");
    paramPair = paramPair.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramPair, "BaseApplication.getContext().resources");
    float f = paramPair.getDisplayMetrics().density;
    int j;
    if ((!QQTheme.isDefaultTheme()) && (!QQTheme.isNowSimpleUI())) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      i = (int)(29 * f + 0.5F);
    }
    int k;
    if (j != 0) {
      k = (int)(f * 5 + 0.5F);
    } else {
      k = 0;
    }
    paramTabDragAnimationView.setPadding(0, k, 0, k);
    paramTabDragAnimationView.setIconSize(i, i);
    paramTabDragAnimationView.setIconGravity(j);
  }
  
  private final void a(boolean paramBoolean1, String paramString, TabDragAnimationView paramTabDragAnimationView, TextView paramTextView, boolean paramBoolean2)
  {
    IKDBottomTabThemeHandler localIKDBottomTabThemeHandler = c();
    if (localIKDBottomTabThemeHandler != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHandlerByThemeMode: ");
      localStringBuilder.append(Reflection.getOrCreateKotlinClass(localIKDBottomTabThemeHandler.getClass()).getSimpleName());
      QLog.d("KDBottomTabThemeManager", 1, localStringBuilder.toString());
      paramString = localIKDBottomTabThemeHandler.a(paramString, paramBoolean2);
      if (paramString != null) {
        a.a(paramTabDragAnimationView, paramString);
      }
      paramTextView.setTextColor(localIKDBottomTabThemeHandler.a(paramBoolean1, paramBoolean2));
    }
  }
  
  private final boolean a(FrameFragment paramFrameFragment)
  {
    String str = FrameControllerUtil.q;
    Intrinsics.checkExpressionValueIsNotNull(str, "FrameControllerUtil.TAB_TAG_KANDIAN");
    return a(paramFrameFragment, str);
  }
  
  private final boolean a(FrameFragment paramFrameFragment, String paramString)
  {
    String str = IKDBottomTabThemeHandler.a.b(paramString);
    paramFrameFragment = paramFrameFragment.z();
    boolean bool3 = Intrinsics.areEqual(paramString, FrameControllerUtil.o);
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if ((Intrinsics.areEqual(paramFrameFragment, "com.tencent.mobileqq.leba.Leba")) || (Intrinsics.areEqual(paramFrameFragment, "com.tencent.mobileqq.activity.leba.QzoneFrame"))) {
        bool1 = true;
      }
      return bool1;
    }
    if (Intrinsics.areEqual(paramString, FrameControllerUtil.q))
    {
      if (!Intrinsics.areEqual(paramFrameFragment, "com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame"))
      {
        bool1 = bool2;
        if (!Intrinsics.areEqual(paramFrameFragment, "com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame")) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    return Intrinsics.areEqual(paramFrameFragment, str);
  }
  
  private final void b(FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    Object localObject1 = paramFrameFragment.z();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("changeBottomTabIcon currentTabName:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("KDBottomTabThemeManager", 1, ((StringBuilder)localObject2).toString());
    localObject1 = paramFrameFragment.z;
    if (localObject1 != null)
    {
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject1[i];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("changeBottomTabIcon index：");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" | ");
        ((StringBuilder)localObject2).append(localObject1.length);
        QLog.i("KDBottomTabThemeManager", 1, ((StringBuilder)localObject2).toString());
        if (localObject3 != null)
        {
          localObject2 = (TabDragAnimationView)((View)localObject3).findViewById(2131446751);
          TextView localTextView = (TextView)((View)localObject3).findViewById(2131448791);
          if ((localObject2 != null) && (localTextView != null))
          {
            localObject3 = a((View)localObject3, localTextView);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("changeBottomTabIcon index：");
            localStringBuilder.append(i);
            localStringBuilder.append("| ");
            localStringBuilder.append((String)localObject3);
            QLog.i("KDBottomTabThemeManager", 1, localStringBuilder.toString());
            if (IKDBottomTabThemeHandler.a.a((String)localObject3)) {
              a(a(paramFrameFragment, (String)localObject3), (String)localObject3, (TabDragAnimationView)localObject2, localTextView, paramBoolean);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private final boolean b()
  {
    return ((Boolean)d.getValue()).booleanValue();
  }
  
  private final IKDBottomTabThemeHandler c()
  {
    boolean bool1 = QQTheme.isNowSimpleUI();
    boolean bool2 = QQTheme.isDefaultTheme();
    if (bool1) {
      return (IKDBottomTabThemeHandler)KDSimpleThemeModeBottomTabHandler.b;
    }
    if (bool2) {
      return (IKDBottomTabThemeHandler)KDDefaultThemeModeBottomTabHandler.b;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.KDBottomTabThemeManager
 * JD-Core Version:    0.7.0.1
 */