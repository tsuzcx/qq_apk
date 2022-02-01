package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsTabs;
import com.tencent.mobileqq.activity.contacts.base.tabs.InterceptListener;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.mobileqq.widget.UnderlineIndicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView.OnSpringBackListener;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class SimpleModeHelper
{
  public static final int[] a = { 2130852213, 2130839697, 2130839703, 2130839703, 2130852214, 2130852214, 2130839697, 2130839703, 2130839703, 2130839699, 2130839701, 2130839705 };
  static boolean b = false;
  static boolean c = false;
  
  public static int a(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    int j = paramPlusPanelAppInfo.defaultDrawableID();
    int i = 2130844780;
    if (j > 0) {
      return paramPlusPanelAppInfo.defaultDrawableID();
    }
    if (!QQTheme.isNowSimpleUI()) {
      return 2130844780;
    }
    if (paramPlusPanelAppInfo.appid == 1108481457) {
      return 2130839291;
    }
    if (paramPlusPanelAppInfo.appid == 101458937) {
      return 2130839303;
    }
    if (paramPlusPanelAppInfo.appid == 1106551782) {
      return 2130839284;
    }
    if (paramPlusPanelAppInfo.appid == 100729587) {
      return 2130839285;
    }
    if ((paramPlusPanelAppInfo.appid == 1108961705) || (paramPlusPanelAppInfo.appid == 101849720)) {
      i = 2130845615;
    }
    return i;
  }
  
  public static int a(boolean paramBoolean)
  {
    boolean bool = b();
    int i = 2130852486;
    if (bool) {
      return 2130852486;
    }
    if (paramBoolean) {
      i = 2130852487;
    }
    return i;
  }
  
  public static int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        return 2130852127;
      }
      return 2130851945;
    }
    if (paramBoolean1) {
      return 2130852126;
    }
    return 2130851944;
  }
  
  public static ColorStateList a(Resources paramResources)
  {
    if (b()) {
      return paramResources.getColorStateList(2131168060);
    }
    return paramResources.getColorStateList(2131168122);
  }
  
  public static Drawable a(PlusPanelAppLoader paramPlusPanelAppLoader, QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo, String paramString1, String paramString2, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      if (b())
      {
        paramPlusPanelAppLoader = BaseApplicationImpl.getContext().getResources().getDrawable(a(paramPlusPanelAppInfo));
      }
      else if (TextUtils.isEmpty(paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PlusPanelAppLoader", 2, "plusPanel reload simpleNightUrl is null!");
        }
        paramPlusPanelAppLoader = paramPlusPanelAppLoader.a(paramQQAppInterface, paramPlusPanelAppInfo, paramURLDrawableOptions);
      }
      else
      {
        paramPlusPanelAppLoader = URLDrawable.getDrawable(paramString2, paramURLDrawableOptions);
      }
    }
    else if (b())
    {
      paramPlusPanelAppLoader = BaseApplicationImpl.getContext().getResources().getDrawable(a(paramPlusPanelAppInfo));
    }
    else if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelAppLoader", 2, "plusPanel reload simpleDayUrl is null!");
      }
      paramPlusPanelAppLoader = paramPlusPanelAppLoader.a(paramQQAppInterface, paramPlusPanelAppInfo, paramURLDrawableOptions);
    }
    else
    {
      paramPlusPanelAppLoader = URLDrawable.getDrawable(paramString1, paramURLDrawableOptions);
    }
    if ((b()) && (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))) {
      paramPlusPanelAppLoader.setColorFilter(-6710887, PorterDuff.Mode.SRC_ATOP);
    }
    return paramPlusPanelAppLoader;
  }
  
  public static View a(ViewGroup paramViewGroup, View paramView)
  {
    if (paramViewGroup == null) {
      return paramView;
    }
    if ((QQTheme.isNowSimpleUI()) && (!QQTheme.isNowThemeIsNight()))
    {
      View localView = paramView;
      if (paramView == null)
      {
        Context localContext = paramViewGroup.getContext();
        if (localContext == null) {
          return null;
        }
        paramView = paramViewGroup.findViewById(16908307);
        if (paramView == null) {
          return null;
        }
        ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131431325);
        if (localViewGroup == null) {
          return null;
        }
        localView = new View(localContext);
        localView.setBackgroundColor(localContext.getResources().getColor(2131168061));
        localView.setId(2131446748);
        paramViewGroup.removeView(localView);
        localViewGroup.addView(localView);
        paramViewGroup = new FrameLayout.LayoutParams(-1, 1);
        paramViewGroup.gravity = 80;
        paramViewGroup.bottomMargin = paramView.getHeight();
        localView.setLayoutParams(paramViewGroup);
      }
      localView.setVisibility(0);
      return localView;
    }
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    return paramView;
  }
  
  public static AbsSlidingIndicator a(AbsSlidingIndicator paramAbsSlidingIndicator, ViewGroup paramViewGroup, Object paramObject, ContactsTabs paramContactsTabs)
  {
    int i = paramViewGroup.indexOfChild(paramAbsSlidingIndicator);
    paramViewGroup.removeView(paramAbsSlidingIndicator);
    if (QQTheme.isNowSimpleUI()) {
      paramAbsSlidingIndicator = new UnderlineIndicator(BaseApplication.getContext());
    } else {
      paramAbsSlidingIndicator = new SimpleSlidingIndicator(BaseApplication.getContext());
    }
    paramViewGroup.addView(paramAbsSlidingIndicator, i, new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(56.0F)));
    paramAbsSlidingIndicator.setTabData(paramContactsTabs.a, paramContactsTabs.b);
    if ((paramObject instanceof AbsSlidingIndicator.OnTabListener)) {
      paramAbsSlidingIndicator.setOnTabListener((AbsSlidingIndicator.OnTabListener)paramObject);
    }
    if ((paramObject instanceof InterceptListener)) {
      paramAbsSlidingIndicator.setInterceptListener((InterceptListener)paramObject);
    }
    return paramAbsSlidingIndicator;
  }
  
  public static IPullRefreshHeaderControl a(CommonRefreshLayout paramCommonRefreshLayout)
  {
    Object localObject = paramCommonRefreshLayout.getContext();
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2131624564;
    } else {
      i = 2131624561;
    }
    localObject = (IPullRefreshHeaderControl)View.inflate((Context)localObject, i, null);
    ((IPullRefreshHeaderControl)localObject).a(19, null);
    paramCommonRefreshLayout.a((ViewGroup)localObject);
    return localObject;
  }
  
  public static IPullRefreshHeaderControl a(FPSSwipListView paramFPSSwipListView)
  {
    Object localObject = LayoutInflater.from(paramFPSSwipListView.getContext());
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2131629288;
    } else {
      i = 2131625671;
    }
    localObject = (IPullRefreshHeaderControl)((LayoutInflater)localObject).inflate(i, paramFPSSwipListView, false);
    if (paramFPSSwipListView != null)
    {
      paramFPSSwipListView.setOverScrollHeader((View)localObject);
      if ((localObject instanceof ListView.OnSpringBackListener)) {
        paramFPSSwipListView.setOnSpringBackListener((ListView.OnSpringBackListener)localObject);
      }
    }
    return localObject;
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (b())
    {
      paramView.setBackgroundResource(2130851871);
      return;
    }
    paramView.setBackgroundResource(2130839578);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2130852487;
    } else {
      i = 2130852486;
    }
    int j;
    if (paramBoolean) {
      j = 2130852499;
    } else {
      j = 2130852498;
    }
    paramView.setBackgroundResource(i);
    paramView.findViewById(2131432634).setBackgroundResource(j);
  }
  
  public static void a(Button paramButton)
  {
    if (!b()) {
      return;
    }
    if (paramButton == null) {
      return;
    }
    Resources localResources = paramButton.getResources();
    if (localResources == null) {
      return;
    }
    paramButton.setBackground(localResources.getDrawable(2130839460));
  }
  
  private static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (!b()) {
      return;
    }
    Context localContext = paramImageView.getContext();
    paramImageView.setImageResource(2130840437);
    paramImageView = paramImageView.getLayoutParams();
    int i = DisplayUtil.a(localContext, 16.0F);
    int j = DisplayUtil.a(localContext, 16.0F);
    paramImageView.width = i;
    paramImageView.height = j;
  }
  
  public static void a(LinearLayout paramLinearLayout, boolean paramBoolean, int paramInt)
  {
    Object localObject = paramLinearLayout.findViewById(2131448065);
    int i = AIOUtils.b(0.5F, BaseApplication.getContext().getResources());
    if (localObject != null)
    {
      localObject = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      int j;
      if (paramBoolean) {
        j = i;
      } else {
        j = paramInt;
      }
      ((LinearLayout.LayoutParams)localObject).bottomMargin = j;
    }
    paramLinearLayout = paramLinearLayout.findViewById(2131431253);
    if (paramLinearLayout != null)
    {
      paramLinearLayout = paramLinearLayout.findViewById(2131446070);
      if (paramLinearLayout != null)
      {
        paramLinearLayout = (ViewGroup.MarginLayoutParams)paramLinearLayout.getLayoutParams();
        if (paramBoolean) {
          paramInt = i;
        }
        paramLinearLayout.bottomMargin = paramInt;
      }
    }
  }
  
  public static void a(TextView paramTextView)
  {
    if (!b()) {
      return;
    }
    if (paramTextView == null) {
      return;
    }
    if (paramTextView.getResources() == null) {
      return;
    }
    paramTextView.setTextSize(2, 16.0F);
  }
  
  public static void a(TextView paramTextView, Context paramContext)
  {
    if (paramTextView != null)
    {
      if (paramContext == null) {
        return;
      }
      int i;
      if (QQTheme.isNowSimpleUI()) {
        i = 2131168194;
      } else {
        i = 2131167990;
      }
      paramTextView.setTextColor(paramContext.getResources().getColor(i));
    }
  }
  
  public static void a(TextView paramTextView, ColorStateList paramColorStateList)
  {
    if (paramTextView == null) {
      return;
    }
    Context localContext = paramTextView.getContext();
    if (localContext == null) {
      return;
    }
    if (localContext.getResources() == null) {
      return;
    }
    paramTextView.getLayoutParams().height = DisplayUtil.a(localContext, 16.0F);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(DisplayUtil.a(localContext, 8.0F));
    localGradientDrawable.setStroke(DisplayUtil.a(localContext, 1.0F), paramColorStateList);
    localGradientDrawable.setSize(DisplayUtil.a(localContext, 16.0F), DisplayUtil.a(localContext, 16.0F));
    paramTextView.setBackground(localGradientDrawable);
    paramTextView.setTextSize(2, 10.0F);
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
    int i = DisplayUtil.a(localContext, 5.0F);
    paramTextView.setPadding(i, 0, i, 0);
    paramTextView.setGravity(17);
    paramTextView.setIncludeFontPadding(false);
  }
  
  public static void a(TextView paramTextView, ImageView paramImageView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramImageView == null) {
      return;
    }
    if (!b()) {
      return;
    }
    Context localContext = paramImageView.getContext();
    paramImageView.setImageResource(2130840437);
    int i = DisplayUtil.a(localContext, 16.0F);
    int j = DisplayUtil.a(localContext, 16.0F);
    paramLayoutParams.width = i;
    paramLayoutParams.height = j;
    if (paramTextView != null) {
      paramTextView.setTextColor(localContext.getResources().getColorStateList(2131168059));
    }
  }
  
  public static void a(TextView paramTextView, ImageView paramImageView, RedTouch paramRedTouch, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    Object localObject = paramTextView.getResources();
    int i;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 2131168058;
      } else {
        i = 2131168059;
      }
      paramTextView.setTextColor(((Resources)localObject).getColor(i));
    }
    localObject = paramTextView.getContext();
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 11;
      } else {
        i = 10;
      }
      float f = DisplayUtil.a(paramTextView.getContext(), i);
      i = 0;
      paramTextView.setTextSize(0, f);
      paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      if (!paramBoolean) {
        i = DisplayUtil.a((Context)localObject, 5.0F);
      }
      paramTextView.bottomMargin = i;
      i = DisplayUtil.a((Context)localObject, 32.5F);
      int j = DisplayUtil.a((Context)localObject, 32.5F);
      if (paramImageView != null)
      {
        paramTextView = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
        paramTextView.width = i;
        paramTextView.height = j;
        paramTextView.gravity = 1;
        paramImageView.setImageDrawable(null);
      }
      if (paramRedTouch != null)
      {
        paramTextView = (RelativeLayout.LayoutParams)paramRedTouch.getLayoutParams();
        paramTextView.width = i;
        paramTextView.height = j;
        if (paramBoolean)
        {
          paramTextView.bottomMargin = ((int)(XPanelContainer.getSpaceHeight() * 14.0F / 296.0F));
          return;
        }
        paramTextView.bottomMargin = DisplayUtil.a((Context)localObject, 8.0F);
      }
    }
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramImageView == null) {
      return;
    }
    if (!b()) {
      return;
    }
    Context localContext = paramImageView.getContext();
    paramImageView.setImageResource(2130840437);
    int i = DisplayUtil.a(localContext, 16.0F);
    int j = DisplayUtil.a(localContext, 16.0F);
    paramLayoutParams.width = i;
    paramLayoutParams.height = j;
    paramImageView = localContext.getResources().getColorStateList(2131168059);
    if (paramTextView1 != null) {
      paramTextView1.setTextColor(paramImageView);
    }
    if (paramTextView2 != null) {
      paramTextView2.setTextColor(paramImageView);
    }
  }
  
  public static void a(InputLinearLayout paramInputLinearLayout)
  {
    if (a())
    {
      paramInputLinearLayout.setBackgroundColor(0);
      return;
    }
    AIOUtils.a(paramInputLinearLayout, 2130851968);
  }
  
  public static void a(AIOContext paramAIOContext)
  {
    try
    {
      paramAIOContext = paramAIOContext.b();
      if ((paramAIOContext instanceof SplashActivity))
      {
        paramAIOContext = paramAIOContext.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        if ((paramAIOContext != null) && (paramAIOContext.isVisible()))
        {
          ((ChatFragment)paramAIOContext).k().bm().b();
          return;
        }
      }
    }
    catch (Exception paramAIOContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SimpleModeHelper", 2, "hideKeyboard", paramAIOContext);
      }
    }
  }
  
  public static void a(Conversation paramConversation, boolean paramBoolean)
  {
    if (!QQTheme.isNowSimpleUI())
    {
      paramConversation.b(800L);
      if (paramConversation.x != null)
      {
        paramConversation = paramConversation.x;
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = 2;
        }
        paramConversation.a(i);
      }
    }
    else if (paramConversation.x != null)
    {
      paramConversation.x.a(27, new SimpleModeHelper.1(paramConversation));
    }
  }
  
  public static void a(RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.a.getLayoutParams();
    int i = ViewUtils.dpToPx(52.0F);
    if (ThemeUtil.isNowThemeIsSimple(null, false, null)) {
      i = ViewUtils.dpToPx(46.799999F);
    }
    if (localLayoutParams != null)
    {
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    }
    if (paramRecentEfficientItemBuilderHolder.c != null)
    {
      paramRecentEfficientItemBuilderHolder = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.c.getLayoutParams();
      if (paramRecentEfficientItemBuilderHolder != null)
      {
        paramRecentEfficientItemBuilderHolder.height = i;
        paramRecentEfficientItemBuilderHolder.width = i;
      }
    }
  }
  
  public static void a(RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Resources paramResources)
  {
    ColorStateList localColorStateList1 = paramResources.getColorStateList(2131168001);
    ColorStateList localColorStateList2 = a(paramResources);
    ColorStateList localColorStateList3 = b(paramResources);
    paramResources = paramResources.getColorStateList(2131168001);
    paramRecentEfficientItemBuilderHolder.d.setTextColor(localColorStateList1);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      paramRecentEfficientItemBuilderHolder.d.setExtendTextColor(paramResources, 0);
    } else {
      paramRecentEfficientItemBuilderHolder.d.setExtendTextColor(localColorStateList2, 0);
    }
    paramRecentEfficientItemBuilderHolder.d.setExtendTextColor(localColorStateList2, 2);
    paramRecentEfficientItemBuilderHolder.g.setTextColor(localColorStateList3);
  }
  
  public static void a(RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Resources paramResources, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    if (b())
    {
      paramColorStateList1 = a(paramResources);
      paramResources = b(paramResources);
      paramRecentEfficientItemBuilderHolder.d.setExtendTextColor(paramColorStateList1, 0);
      paramRecentEfficientItemBuilderHolder.g.setTextColor(paramResources);
      return;
    }
    if (ThemeUtil.isNowThemeIsDefault(null, false, null))
    {
      paramRecentEfficientItemBuilderHolder.d.setExtendTextColor(paramColorStateList2, 0);
      return;
    }
    paramRecentEfficientItemBuilderHolder.d.setExtendTextColor(paramColorStateList1, 0);
  }
  
  public static void a(Frame paramFrame, ImmersiveTitleBar2 paramImmersiveTitleBar2, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2)
  {
    if ((QQTheme.isSimpleWhite()) && (BlurUtil.a()))
    {
      paramImmersiveTitleBar2.setBackgroundColor(0);
      paramRelativeLayout2.setBackgroundColor(0);
      paramRelativeLayout1.setBackgroundColor(0);
      return;
    }
    paramFrame.a(paramImmersiveTitleBar2, false);
    paramFrame.a(paramRelativeLayout2, false);
    paramRelativeLayout1.setBackgroundResource(2130852228);
  }
  
  public static void a(QQCustomDialog paramQQCustomDialog)
  {
    if (paramQQCustomDialog == null) {
      return;
    }
    if (!QQTheme.isNowSimpleUI()) {
      return;
    }
    Object localObject1 = paramQQCustomDialog.getContext();
    Resources localResources = ((Context)localObject1).getResources();
    if (localResources == null) {
      return;
    }
    Object localObject2 = paramQQCustomDialog.findViewById(2131433638);
    if (localObject2 == null) {
      paramQQCustomDialog = paramQQCustomDialog.findViewById(2131431871);
    } else {
      paramQQCustomDialog = ((View)localObject2).findViewById(2131431871);
    }
    if (paramQQCustomDialog == null) {
      return;
    }
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setColor(localResources.getColor(2131168094));
    ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a((Context)localObject1, 4.0F));
    paramQQCustomDialog.setBackgroundDrawable((Drawable)localObject2);
    localObject2 = (LinearLayout)paramQQCustomDialog.findViewById(2131435825);
    if (localObject2 != null)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(localResources.getColor(2131168065));
      localGradientDrawable.setCornerRadius(DisplayUtil.a((Context)localObject1, 2.0F));
      ((LinearLayout)localObject2).setBackgroundDrawable(localGradientDrawable);
    }
    a((ImageView)paramQQCustomDialog.findViewById(2131435629));
    localObject2 = paramQQCustomDialog.findViewById(2131447483);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(localResources.getColor(2131168063));
    }
    localObject2 = paramQQCustomDialog.findViewById(2131431855);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(localResources.getColor(2131168063));
    }
    localObject2 = (EditText)paramQQCustomDialog.findViewById(2131435808);
    if (localObject2 != null)
    {
      ((EditText)localObject2).setHintTextColor(localResources.getColor(2131168060));
      ((EditText)localObject2).setPadding(DisplayUtil.a((Context)localObject1, 11.0F), ((EditText)localObject2).getPaddingTop(), ((EditText)localObject2).getPaddingRight(), ((EditText)localObject2).getPaddingBottom());
      ((EditText)localObject2).setTextSize(2, 13.0F);
    }
    localObject1 = (TextView)paramQQCustomDialog.findViewById(2131449007);
    if (localObject1 != null) {
      ((TextView)localObject1).setTextColor(localResources.getColor(2131168056));
    }
    localObject1 = (TextView)paramQQCustomDialog.findViewById(2131449004);
    if (localObject1 != null) {
      ((TextView)localObject1).setTextColor(localResources.getColor(2131168056));
    }
    localObject1 = (TextView)paramQQCustomDialog.findViewById(2131431864);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setTextColor(localResources.getColor(2131168056));
      if (QQTheme.isNowThemeIsNight()) {
        ((TextView)localObject1).setBackgroundResource(2130840444);
      } else {
        ((TextView)localObject1).setBackgroundResource(2130840443);
      }
    }
    paramQQCustomDialog = (TextView)paramQQCustomDialog.findViewById(2131431870);
    if (paramQQCustomDialog != null)
    {
      paramQQCustomDialog.setTextColor(localResources.getColor(2131168056));
      if (QQTheme.isNowThemeIsNight())
      {
        paramQQCustomDialog.setBackgroundResource(2130840444);
        return;
      }
      paramQQCustomDialog.setBackgroundResource(2130840443);
    }
  }
  
  public static void a(SwipRightMenuBuilder paramSwipRightMenuBuilder)
  {
    if ((paramSwipRightMenuBuilder instanceof SwipTextViewMenuBuilder))
    {
      if (b())
      {
        ((SwipTextViewMenuBuilder)paramSwipRightMenuBuilder).setMENU_BG_IDS(a);
        return;
      }
      ((SwipTextViewMenuBuilder)paramSwipRightMenuBuilder).setMENU_BG_IDS(RecentItemBaseBuilder.d);
    }
  }
  
  public static void a(boolean paramBoolean, View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setVisibility(8);
      return;
    }
    if ((b()) && (!QQTheme.isNowThemeSimpleNight()))
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public static void a(boolean paramBoolean, View paramView, int paramInt)
  {
    paramView = paramView.findViewById(2131432020);
    paramView.setBackgroundResource(paramInt);
    if (paramBoolean) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    paramView.setVisibility(paramInt);
  }
  
  public static boolean a()
  {
    return (QQTheme.isNowSimpleUI()) && (!QQTheme.isNowThemeSimpleNight()) && (BlurUtil.a());
  }
  
  public static ColorStateList b(Resources paramResources)
  {
    if (b()) {
      return paramResources.getColorStateList(2131168059);
    }
    return paramResources.getColorStateList(2131168122);
  }
  
  public static void b(View paramView)
  {
    paramView.setOnTouchListener(new SimpleModeHelper.3(paramView, new GestureDetector(null, new SimpleModeHelper.2(paramView))));
  }
  
  public static boolean b()
  {
    return QQTheme.isNowSimpleUI();
  }
  
  public static int c()
  {
    if (QQTheme.isNowSimpleUI()) {
      return 2130839254;
    }
    return 2130839253;
  }
  
  public static Drawable c(Resources paramResources)
  {
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2130838261;
    } else {
      i = 2130838258;
    }
    return paramResources.getDrawable(i);
  }
  
  public static void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setOnTouchListener(null);
  }
  
  public static Drawable d(Resources paramResources)
  {
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2130838260;
    } else {
      i = 2130838259;
    }
    return paramResources.getDrawable(i);
  }
  
  public static View d(View paramView)
  {
    View localView = null;
    if (paramView == null) {
      return null;
    }
    Object localObject = BaseApplication.getContext();
    if (localObject == null) {
      return null;
    }
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ViewGroup))
    {
      localView = new View((Context)localObject);
      localView.setBackgroundColor(((Context)localObject).getResources().getColor(2131168061));
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramView.getId());
      ((ViewGroup)localViewParent).addView(localView, (ViewGroup.LayoutParams)localObject);
      localView.setVisibility(8);
    }
    return localView;
  }
  
  public static void e(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getContext() == null) {
      return;
    }
    paramView.setBackgroundColor(paramView.getResources().getColor(2131168061));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SimpleModeHelper
 * JD-Core Version:    0.7.0.1
 */