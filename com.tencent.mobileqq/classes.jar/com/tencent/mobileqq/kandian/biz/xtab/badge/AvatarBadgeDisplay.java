package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.VisibleForTesting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.kandian.base.ktx.ViewGroupExtensionKt;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/AvatarBadgeDisplay;", "Lcom/tencent/mobileqq/kandian/biz/xtab/badge/IRIJXTabBadgeDisplay;", "", "badgeContainer", "Landroid/widget/RelativeLayout;", "(Landroid/widget/RelativeLayout;)V", "context", "Landroid/content/Context;", "currentUin", "displayListener", "Lcom/tencent/mobileqq/kandian/biz/xtab/badge/AvatarBadgeDisplay$IDisplayListener;", "getDisplayListener", "()Lcom/tencent/mobileqq/kandian/biz/xtab/badge/AvatarBadgeDisplay$IDisplayListener;", "setDisplayListener", "(Lcom/tencent/mobileqq/kandian/biz/xtab/badge/AvatarBadgeDisplay$IDisplayListener;)V", "isShowing", "", "addAvatar", "", "drawable", "Landroid/graphics/drawable/Drawable;", "withAnim", "addEmptyBadge", "withAnimate", "fetchAvatar", "uin", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "avatar", "handleLoadUserInfoFailed", "", "errMsg", "handleLoadUserInfoSucceed", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "hide", "needAddAvatar", "oldUin", "removeAvatar", "removeEmptyBadge", "show", "Companion", "IDisplayListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AvatarBadgeDisplay
  implements IRIJXTabBadgeDisplay<Long>
{
  public static final AvatarBadgeDisplay.Companion a = new AvatarBadgeDisplay.Companion(null);
  private final Context b;
  private boolean c;
  private long d;
  @Nullable
  private AvatarBadgeDisplay.IDisplayListener e;
  private final RelativeLayout f;
  
  public AvatarBadgeDisplay(@NotNull RelativeLayout paramRelativeLayout)
  {
    this.f = paramRelativeLayout;
    paramRelativeLayout = this.f.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramRelativeLayout, "badgeContainer.context");
    this.b = paramRelativeLayout;
    paramRelativeLayout = this.f.getParent();
    if ((paramRelativeLayout instanceof ViewGroup))
    {
      paramRelativeLayout = (ViewGroup)paramRelativeLayout;
      paramRelativeLayout.setClipChildren(false);
      paramRelativeLayout.setClipToPadding(false);
    }
  }
  
  private final void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo, Function2<? super Long, ? super Drawable, Unit> paramFunction2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleLoadUserInfoSucceed, uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", userInfo:");
      ((StringBuilder)localObject).append(paramReadInJoyUserInfo);
      QLog.i("AvatarBadgeDisplay", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (paramReadInJoyUserInfo != null))
    {
      localObject = (CharSequence)paramReadInJoyUserInfo.qqHeadUrl;
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        paramReadInJoyUserInfo = paramReadInJoyUserInfo.faceUrl;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramReadInJoyUserInfo.qqHeadUrl);
        ((StringBuilder)localObject).append(100);
        paramReadInJoyUserInfo = ((StringBuilder)localObject).toString();
      }
      paramReadInJoyUserInfo = URLDrawable.getDrawable(paramReadInJoyUserInfo, URLDrawable.URLDrawableOptions.obtain());
      Intrinsics.checkExpressionValueIsNotNull(paramReadInJoyUserInfo, "urlDrawable");
      if (paramReadInJoyUserInfo.getStatus() == 1)
      {
        long l = Long.parseLong(paramString);
        paramString = paramReadInJoyUserInfo.getCurrDrawable();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "urlDrawable.currDrawable");
        paramFunction2.invoke(Long.valueOf(l), paramString);
        return;
      }
      paramReadInJoyUserInfo.setURLDrawableListener((URLDrawable.URLDrawableListener)new AvatarBadgeDisplay.handleLoadUserInfoSucceed.1(paramFunction2, paramString));
      ThreadManagerV2.excute((Runnable)new AvatarBadgeDisplay.handleLoadUserInfoSucceed.2(paramReadInJoyUserInfo), 128, null, true);
    }
  }
  
  private final void a(String paramString1, String paramString2, Function2<? super Long, ? super Drawable, Unit> paramFunction2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleLoadUserInfoFailed, uin:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString2);
    QLog.e("AvatarBadgeDisplay", 2, localStringBuilder.toString());
    if (paramString1 != null)
    {
      long l = Long.parseLong(paramString1);
      paramString1 = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "QRoute.api(IQQAvatarUtil…DefaultFaceDrawable(true)");
      paramFunction2.invoke(Long.valueOf(l), paramString1);
    }
  }
  
  @Nullable
  public final AvatarBadgeDisplay.IDisplayListener a()
  {
    return this.e;
  }
  
  @VisibleForTesting
  public final void a(long paramLong, @NotNull Function2<? super Long, ? super Drawable, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    Object localObject = RIJQQAppInterfaceUtil.e();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((AppRuntime)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
        if (localObject != null) {
          localObject = ((ReadInJoyLogicEngine)localObject).e();
        } else {
          localObject = null;
        }
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).a((List)CollectionsKt.arrayListOf(new String[] { String.valueOf(paramLong) }), 1, 1, 1, 0, false, 1, (IReadInJoyUserInfoModule.RefreshUserInfoCallBack)new AvatarBadgeDisplay.fetchAvatar.1(this, paramFunction2));
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager");
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchAvatar fail, current app is ");
      localStringBuilder.append(localObject);
      QLog.e("AvatarBadgeDisplay", 1, localStringBuilder.toString());
      localObject = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IQQAvatarUtil…DefaultFaceDrawable(true)");
      paramFunction2.invoke(Long.valueOf(paramLong), localObject);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this.d == paramLong)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("show, sameUin=");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(", return");
        QLog.i("AvatarBadgeDisplay", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("show, uin=");
      localStringBuilder.append(paramLong);
      QLog.i("AvatarBadgeDisplay", 2, localStringBuilder.toString());
    }
    this.d = paramLong;
    if (!this.c)
    {
      this.c = true;
      a(this.d, (Function2)new AvatarBadgeDisplay.show.1(this));
      return;
    }
    a(this.d, (Function2)new AvatarBadgeDisplay.show.2(this));
  }
  
  @VisibleForTesting
  public final void a(@NotNull Drawable paramDrawable, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "drawable");
    Object localObject1 = new RoundImageView(this.b);
    ((RoundImageView)localObject1).setId(2131444280);
    ((RoundImageView)localObject1).setmRadius(LayoutAttrsKt.getDp(16), false);
    ((RoundImageView)localObject1).setImageDrawable(paramDrawable);
    Object localObject2 = new RelativeLayout.LayoutParams(LayoutAttrsKt.getDp(26), LayoutAttrsKt.getDp(26));
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((RoundImageView)localObject1).setTranslationY(-LayoutAttrsKt.getDp(2));
    paramDrawable = AnimationUtils.loadAnimation(this.b, 2130772303);
    if (paramBoolean)
    {
      ViewGroup localViewGroup = (ViewGroup)this.f;
      localObject1 = (View)localObject1;
      localObject2 = (ViewGroup.LayoutParams)localObject2;
      Intrinsics.checkExpressionValueIsNotNull(paramDrawable, "breathShowAnim");
      ViewGroupExtensionKt.a(localViewGroup, (View)localObject1, 0, (ViewGroup.LayoutParams)localObject2, paramDrawable);
      return;
    }
    this.f.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
  }
  
  public final void a(@Nullable AvatarBadgeDisplay.IDisplayListener paramIDisplayListener)
  {
    this.e = paramIDisplayListener;
  }
  
  @VisibleForTesting
  public final void a(boolean paramBoolean)
  {
    View localView = this.f.findViewById(2131444280);
    if (localView != null)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this.b, 2130772302);
      if (paramBoolean)
      {
        ViewGroup localViewGroup = (ViewGroup)this.f;
        Intrinsics.checkExpressionValueIsNotNull(localAnimation, "breathHideAnim");
        ViewGroupExtensionKt.a(localViewGroup, localView, localAnimation, null);
        return;
      }
      this.f.removeView(localView);
    }
  }
  
  @VisibleForTesting
  public final boolean a(long paramLong)
  {
    return (this.d == paramLong) && (this.c);
  }
  
  @VisibleForTesting
  public final void b()
  {
    View localView = this.f.findViewById(2131444281);
    if (localView != null) {
      this.f.removeView(localView);
    }
  }
  
  @VisibleForTesting
  public final void b(boolean paramBoolean)
  {
    View localView = new View(this.b);
    localView.setId(2131444281);
    localView.setBackgroundResource(2130852588);
    Object localObject = new RelativeLayout.LayoutParams(LayoutAttrsKt.getDp(9), LayoutAttrsKt.getDp(9));
    ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131444280);
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131444280);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = LayoutAttrsKt.getDp(-4);
    ((RelativeLayout.LayoutParams)localObject).topMargin = LayoutAttrsKt.getDp(-4);
    Animation localAnimation = AnimationUtils.loadAnimation(this.b, 2130772303);
    if (paramBoolean)
    {
      ViewGroup localViewGroup = (ViewGroup)this.f;
      localObject = (ViewGroup.LayoutParams)localObject;
      Intrinsics.checkExpressionValueIsNotNull(localAnimation, "breathShowAnim");
      ViewGroupExtensionKt.a(localViewGroup, localView, (ViewGroup.LayoutParams)localObject, localAnimation);
      return;
    }
    this.f.addView(localView, (ViewGroup.LayoutParams)localObject);
  }
  
  public void c(boolean paramBoolean)
  {
    AvatarBadgeDisplay.IDisplayListener localIDisplayListener = this.e;
    if (localIDisplayListener != null) {
      localIDisplayListener.a(paramBoolean);
    }
    a(paramBoolean);
    b();
    this.c = false;
    this.d = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay
 * JD-Core Version:    0.7.0.1
 */