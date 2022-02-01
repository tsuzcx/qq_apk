package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment;
import com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew.DoShareClick;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleTopicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJSocialBottomUtils$Companion;", "", "()V", "TAG", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "bottomSocialView", "Lcom/tencent/mobileqq/kandian/biz/fastweb/ReadInJoyFastWebBottomSocialViewNew;", "bottomViewHeight", "", "callBack", "Lcom/tencent/mobileqq/kandian/biz/common/RIJSocialBottomUtils$CommentAndLikeCallBack;", "fastWebInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "hasRepeatRequest", "", "observer", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "getObserver", "()Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "setObserver", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;)V", "webViewLayout", "Landroid/view/ViewGroup;", "addSocialBottomView", "", "activity", "Landroid/app/Activity;", "contentView", "Landroid/view/View;", "doShareClick", "Lcom/tencent/mobileqq/kandian/biz/fastweb/ReadInJoyFastWebBottomSocialViewNew$DoShareClick;", "webInfo", "viewGroup", "adjustWebViewMargin", "isVisibile", "canShowSocialBottomView", "isWxArticle", "destroy", "generateArticleInfoForBiu", "originArticleinfo", "initBottomData", "bundle", "Landroid/os/Bundle;", "initParams", "openBiuActivity", "from", "biuState", "fastBiu", "context", "Landroid/content/Context;", "requestCode", "openCommentListFragment", "openCommentEdit", "refreshBottomView", "repeatRequest", "needRequest", "requestCommentNum", "callback", "requestLikeStatus", "webModule", "Lcom/tencent/mobileqq/kandian/repo/fastweb/FastWebModule;", "Lcom/tencent/mobileqq/kandian/repo/fastweb/FastWebModule$FastWebArticleRichReqCallback;", "setSocialBottomViewStatus", "isFirstInit", "originUrl", "currentUrl", "showSocialBottomView", "syncCommentAndLike", "syncWebInfoCache", "updateWebInfoCache", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJSocialBottomUtils$Companion
{
  private final AbsBaseArticleInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    List localList = null;
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    if (paramFastWebArticleInfo != null) {
      localList = paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList;
    }
    if ((localList != null) && (paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localBaseArticleInfo.businessId = ((ArticleTopicInfo)paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).a;
    }
    localBaseArticleInfo.innerUniqueID = paramAbsBaseArticleInfo.innerUniqueID;
    localBaseArticleInfo.mRecommendSeq = paramAbsBaseArticleInfo.mRecommendSeq;
    localBaseArticleInfo.mAlgorithmID = paramAbsBaseArticleInfo.mAlgorithmID;
    localBaseArticleInfo.mChannelID = paramAbsBaseArticleInfo.mChannelID;
    localBaseArticleInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    localBaseArticleInfo.mTitle = paramAbsBaseArticleInfo.mTitle;
    localBaseArticleInfo.mSubscribeName = paramAbsBaseArticleInfo.mSubscribeName;
    localBaseArticleInfo.mFirstPagePicUrl = paramAbsBaseArticleInfo.mFirstPagePicUrl;
    localBaseArticleInfo.mArticleID = paramAbsBaseArticleInfo.mArticleID;
    localBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    localBaseArticleInfo.mSocialFeedInfo.a = new BiuInfo();
    localBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localBaseArticleInfo.mSocialFeedInfo.a.b = Long.valueOf(1L);
    localBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    return (AbsBaseArticleInfo)localBaseArticleInfo;
  }
  
  private final void a(Activity paramActivity, View paramView, ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramView instanceof ViewGroup))
    {
      Companion localCompanion = (Companion)this;
      RIJSocialBottomUtils.a(localCompanion.a((ViewGroup)paramView, paramActivity, paramFastWebArticleInfo, paramAbsBaseArticleInfo, paramDoShareClick));
      if (RIJSocialBottomUtils.a() == null) {
        return;
      }
      RIJSocialBottomUtils.a(new RIJSocialBottomUtils.CommentAndLikeCallBack(paramAbsBaseArticleInfo.innerUniqueID, RIJSocialBottomUtils.a(), paramAbsBaseArticleInfo, paramFastWebArticleInfo));
      localCompanion.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, RIJSocialBottomUtils.a());
    }
  }
  
  private final void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramBoolean) && (!RIJSocialBottomUtils.a()))
    {
      ThreadManager.getSubThreadHandler().postDelayed((Runnable)new RIJSocialBottomUtils.Companion.repeatRequest.1(paramAbsBaseArticleInfo, paramFastWebArticleInfo), 1000L);
      RIJSocialBottomUtils.a(true);
    }
  }
  
  private final void b()
  {
    Object localObject1 = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ReadInJoyLogicEngine.getInstance()");
    FastWebModule localFastWebModule = ((ReadInJoyLogicEngine)localObject1).a();
    Object localObject2 = null;
    if (localFastWebModule != null)
    {
      localObject1 = RIJSocialBottomUtils.a();
      if (localObject1 != null) {
        localObject1 = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
      } else {
        localObject1 = null;
      }
      localObject1 = localFastWebModule.a((String)localObject1);
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Object localObject3 = RIJSocialBottomUtils.a();
      if (localObject3 != null) {
        ((FastWebArticleInfo)localObject3).jdField_a_of_type_Boolean = ((FastWebArticleInfo)localObject1).jdField_a_of_type_Boolean;
      }
      localObject3 = RIJSocialBottomUtils.a();
      if (localObject3 != null) {
        ((FastWebArticleInfo)localObject3).jdField_a_of_type_Int = ((FastWebArticleInfo)localObject1).jdField_a_of_type_Int;
      }
      localObject3 = RIJSocialBottomUtils.a();
      if (localObject3 != null) {
        ((FastWebArticleInfo)localObject3).c = ((FastWebArticleInfo)localObject1).c;
      }
      localObject3 = RIJSocialBottomUtils.a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((AbsBaseArticleInfo)localObject3).innerUniqueID;
      }
      localFastWebModule.a((String)localObject1, RIJSocialBottomUtils.a());
    }
  }
  
  private final void c()
  {
    RIJSocialBottomUtils.a((AbsBaseArticleInfo)null);
    RIJSocialBottomUtils.a((FastWebArticleInfo)null);
    RIJSocialBottomUtils.a((ReadInJoyFastWebBottomSocialViewNew)null);
    RIJSocialBottomUtils.a((RIJSocialBottomUtils.CommentAndLikeCallBack)null);
    RIJSocialBottomUtils.a((ViewGroup)null);
  }
  
  private final void d()
  {
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    FastWebModule localFastWebModule = ((ReadInJoyLogicEngine)localObject).a();
    if ((RIJSocialBottomUtils.a() != null) && (RIJSocialBottomUtils.a() != null) && (localFastWebModule != null))
    {
      localObject = RIJSocialBottomUtils.a();
      if (localObject != null) {
        localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
      } else {
        localObject = null;
      }
      localFastWebModule.a((String)localObject, RIJSocialBottomUtils.a());
    }
  }
  
  @Nullable
  public final ReadInJoyFastWebBottomSocialViewNew a(@NotNull ViewGroup paramViewGroup, @NotNull Activity paramActivity, @NotNull FastWebArticleInfo paramFastWebArticleInfo, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFastWebArticleInfo, "webInfo");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    try
    {
      if ((paramViewGroup instanceof RelativeLayout))
      {
        paramAbsBaseArticleInfo.mArticleContentUrl = paramFastWebArticleInfo.t;
        Object localObject = paramActivity.getResources();
        if (localObject != null)
        {
          int i = (int)((Resources)localObject).getDimension(2131298855);
          localObject = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
          RIJSocialBottomUtils.a(paramViewGroup);
          RIJSocialBottomUtils.a(i);
          ((Companion)this).a(true);
          ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = new ReadInJoyFastWebBottomSocialViewNew((Context)paramActivity);
          localReadInJoyFastWebBottomSocialViewNew.setIsWebBottomView(true);
          localReadInJoyFastWebBottomSocialViewNew.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramViewGroup.addView((View)localReadInJoyFastWebBottomSocialViewNew);
          ((Companion)this).b();
          localReadInJoyFastWebBottomSocialViewNew.setData((Context)paramActivity, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
          localReadInJoyFastWebBottomSocialViewNew.a(paramDoShareClick);
          QLog.d("RIJSocialBottomUtils", 1, "addSocialBottomView!");
          ReadInJoyLogicEngineEventDispatcher.a().a(((Companion)this).a());
          return localReadInJoyFastWebBottomSocialViewNew;
        }
      }
    }
    catch (Exception paramViewGroup)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("addSocialBottomView error!  msg=");
      paramActivity.append(paramViewGroup);
      QLog.d("RIJSocialBottomUtils", 1, paramActivity.toString());
    }
    return null;
  }
  
  @NotNull
  public final ReadInJoyObserver a()
  {
    return RIJSocialBottomUtils.a();
  }
  
  public final void a()
  {
    Object localObject1 = RIJSocialBottomUtils.a();
    if (localObject1 != null) {
      ((ReadInJoyFastWebBottomSocialViewNew)localObject1).a();
    }
    localObject1 = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ReadInJoyLogicEngine.getInstance()");
    localObject1 = ((ReadInJoyLogicEngine)localObject1).a();
    if (localObject1 != null) {
      ((FastWebModule)localObject1).a(RIJSocialBottomUtils.a());
    }
    Object localObject2 = ReadInJoyLogicEngineEventDispatcher.a();
    localObject1 = (Companion)this;
    ((ReadInJoyLogicEngineEventDispatcher)localObject2).b(((Companion)localObject1).a());
    localObject2 = ReadInJoyCommentDataManager.a(RIJSocialBottomUtils.a(), 10);
    if (localObject2 != null) {
      ((ReadInJoyCommentDataManager)localObject2).ap_();
    }
    localObject2 = RIJSocialBottomUtils.a();
    if (localObject2 != null) {
      ((RIJSocialBottomUtils.CommentAndLikeCallBack)localObject2).a((ReadInJoyFastWebBottomSocialViewNew)null);
    }
    ((Companion)localObject1).c();
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, @NotNull Context paramContext, int paramInt3, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable FastWebArticleInfo paramFastWebArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (!(paramContext instanceof Activity)) {
      return;
    }
    paramFastWebArticleInfo = ((Companion)this).a(paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    paramAbsBaseArticleInfo = new Intent(paramContext, ReadInJoyDeliverBiuActivity.class);
    paramAbsBaseArticleInfo.putExtra("arg_article_info", (Parcelable)paramFastWebArticleInfo);
    paramAbsBaseArticleInfo.putExtra("biu_src", 100);
    paramAbsBaseArticleInfo.putExtra("arg_from_type", paramInt1);
    paramAbsBaseArticleInfo.putExtra("arg_biu_state", paramInt2);
    paramAbsBaseArticleInfo.putExtra("feedsType", 1);
    paramAbsBaseArticleInfo.putExtra("fast_biu_type", paramBoolean);
    paramAbsBaseArticleInfo.putExtra("should_show_dialog", true);
    paramAbsBaseArticleInfo.putExtra("is_modified_biu", false);
    paramAbsBaseArticleInfo.putExtra("modified_feeds_id", 0);
    paramContext = (Activity)paramContext;
    paramContext.startActivityForResult(paramAbsBaseArticleInfo, paramInt3);
    paramContext.overridePendingTransition(0, 0);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("source", 10);
      localBundle.putParcelable("articleInfo", (Parcelable)paramAbsBaseArticleInfo);
      int i = UIUtils.c(paramContext);
      if (i > 0) {
        localBundle.putInt("comment_layout_height", i * 2 / 3);
      }
      ReadInJoyAtlasCommentFragment.a(paramContext, paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo.mTitle, null, paramAbsBaseArticleInfo.mFirstPagePicUrl, null, paramBoolean, false, localBundle);
      return;
    }
    catch (Exception paramContext)
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("openCommentListFragment error!  msg=");
      paramAbsBaseArticleInfo.append(paramContext);
      QLog.d("RIJSocialBottomUtils", 1, paramAbsBaseArticleInfo.toString());
    }
  }
  
  public final void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    try
    {
      RIJSocialBottomUtils.a((AbsBaseArticleInfo)paramBundle.getParcelable("articleinfo"));
      RIJSocialBottomUtils.a((FastWebArticleInfo)paramBundle.getParcelable("fastwebinfo"));
      return;
    }
    catch (Throwable paramBundle)
    {
      String str = ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData error!  msg=");
      localStringBuilder.append(paramBundle);
      QLog.i(str, 1, localStringBuilder.toString());
    }
  }
  
  public final void a(@Nullable Bundle paramBundle, @Nullable Activity paramActivity, @Nullable View paramView, @Nullable ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick)
  {
    if (paramBundle == null) {
      return;
    }
    boolean bool = false;
    if (paramBundle.getInt("article_source", 0) == 1) {
      bool = true;
    }
    Companion localCompanion = (Companion)this;
    if (!localCompanion.a(bool)) {
      return;
    }
    localCompanion.a(paramBundle);
    if ((paramActivity != null) && (paramView != null) && (RIJSocialBottomUtils.a() != null))
    {
      if (RIJSocialBottomUtils.a() == null) {
        return;
      }
      paramBundle = RIJSocialBottomUtils.a();
      if (paramBundle == null) {
        Intrinsics.throwNpe();
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = RIJSocialBottomUtils.a();
      if (localAbsBaseArticleInfo == null) {
        Intrinsics.throwNpe();
      }
      localCompanion.a(paramActivity, paramView, paramDoShareClick, paramBundle, localAbsBaseArticleInfo);
    }
  }
  
  public final void a(@NotNull FastWebModule paramFastWebModule, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull FastWebArticleInfo paramFastWebArticleInfo, @Nullable FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramFastWebModule, "webModule");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFastWebArticleInfo, "webInfo");
    paramFastWebModule.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback, false);
    QLog.d("RIJSocialBottomUtils", 1, "requestLikeStatus!");
  }
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable RIJSocialBottomUtils.CommentAndLikeCallBack paramCommentAndLikeCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    paramAbsBaseArticleInfo = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo, 10);
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo.a(5, 1);
      paramAbsBaseArticleInfo.a((ReadInJoyCommentDataManager.OnDataChangeListener)paramCommentAndLikeCallBack);
      QLog.d("RIJSocialBottomUtils", 1, "requestCommentNum!");
    }
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
      {
        ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = RIJSocialBottomUtils.a();
        if (localReadInJoyFastWebBottomSocialViewNew != null) {
          localReadInJoyFastWebBottomSocialViewNew.setData(paramFastWebArticleInfo, paramAbsBaseArticleInfo);
        }
      }
      else
      {
        ThreadManager.getUIHandler().post((Runnable)new RIJSocialBottomUtils.Companion.refreshBottomView.1(paramFastWebArticleInfo, paramAbsBaseArticleInfo));
      }
      ((Companion)this).d();
    }
  }
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull FastWebArticleInfo paramFastWebArticleInfo, @Nullable RIJSocialBottomUtils.CommentAndLikeCallBack paramCommentAndLikeCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFastWebArticleInfo, "webInfo");
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).a();
    boolean bool = true;
    if (localObject != null)
    {
      Companion localCompanion = (Companion)this;
      localCompanion.a((FastWebModule)localObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo, (FastWebModule.FastWebArticleRichReqCallback)paramCommentAndLikeCallBack);
      localCompanion.a(paramAbsBaseArticleInfo, paramCommentAndLikeCallBack);
      bool = false;
    }
    else
    {
      QLog.d("RIJSocialBottomUtils", 1, "syncCommentAndLike, webModule is null!");
    }
    ((Companion)this).a(bool, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  public final void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        ViewGroup localViewGroup = RIJSocialBottomUtils.a();
        localObject2 = null;
        if (localViewGroup == null) {
          break label138;
        }
        localViewGroup = (ViewGroup)localViewGroup.findViewById(2131381085);
        if (localViewGroup != null) {
          localObject2 = localViewGroup.getLayoutParams();
        }
        if ((localObject2 instanceof FrameLayout.LayoutParams))
        {
          localObject2 = localViewGroup.getLayoutParams();
          if (localObject2 != null)
          {
            localObject2 = (FrameLayout.LayoutParams)localObject2;
            if (!paramBoolean) {
              break label143;
            }
            i = RIJSocialBottomUtils.a();
            ((FrameLayout.LayoutParams)localObject2).bottomMargin = i;
            localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("adjustMarginBottom error!  msg = ");
        ((StringBuilder)localObject2).append(localException);
        QLog.d("RIJSocialBottomUtils", 1, ((StringBuilder)localObject2).toString());
      }
      return;
      label138:
      Object localObject1 = null;
      continue;
      label143:
      int i = 0;
    }
  }
  
  public final void a(boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2)
  {
    int i = 0;
    if (paramBoolean) {}
    while ((!TextUtils.isEmpty((CharSequence)paramString1)) && (!TextUtils.isEmpty((CharSequence)paramString2)) && (StringsKt.equals$default(paramString1, paramString2, false, 2, null)))
    {
      bool = true;
      break;
    }
    boolean bool = false;
    ((Companion)this).a(bool);
    Object localObject = RIJSocialBottomUtils.a();
    if (localObject != null)
    {
      if (!bool) {
        i = 8;
      }
      ((ReadInJoyFastWebBottomSocialViewNew)localObject).setVisibility(i);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSocialBottomViewStatus, isFirstInit=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", show=");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(", originUrl=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", currentUrl=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("RIJSocialBottomUtils", 1, ((StringBuilder)localObject).toString());
  }
  
  public final boolean a(boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool1;
    try
    {
      RIJMaybeInitializedAladdinConfig.a();
      int i = Aladdin.getConfig(442).getIntegerFromString("can_add_social_bottom", 0);
      if (i == 1) {
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("canShowSocialBottomView error!  msg=");
      localStringBuilder2.append(localException);
      QLog.d("RIJSocialBottomUtils", 1, localStringBuilder2.toString());
      bool1 = false;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("canShowSocialBottomView, isWxArticle=");
    localStringBuilder1.append(paramBoolean);
    localStringBuilder1.append(" ,switchOpen=");
    localStringBuilder1.append(bool1);
    QLog.d("RIJSocialBottomUtils", 1, localStringBuilder1.toString());
    boolean bool2 = bool3;
    if (paramBoolean)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils.Companion
 * JD-Core Version:    0.7.0.1
 */