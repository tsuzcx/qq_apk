package com.tencent.mobileqq.kandian.biz.video;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJViewInterceptor;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/RIJVideoViewInterceptor;", "Lcom/tencent/mobileqq/kandian/biz/framework/RIJViewInterceptor;", "()V", "fetchFollowStatus", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "innerPreloadAvatar", "onBindView", "position", "", "preloadAvatarByImageManager", "avatarUrl", "", "preloadData", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "shouldIntercept", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoViewInterceptor
  implements RIJViewInterceptor
{
  public static final RIJVideoViewInterceptor.Companion a = new RIJVideoViewInterceptor.Companion(null);
  
  private final void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJVideoViewInterceptor.preloadData.1(this, paramAbsBaseArticleInfo));
  }
  
  private final void a(ReadInJoyUserInfo paramReadInJoyUserInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramReadInJoyUserInfo, "headUrl");
    a(paramReadInJoyUserInfo);
    paramAbsBaseArticleInfo.preloadAvatarUrl = paramReadInJoyUserInfo;
    if (QLog.isColorLevel())
    {
      paramReadInJoyUserInfo = new StringBuilder();
      paramReadInJoyUserInfo.append("preloadAvatarByImageManager url:");
      paramReadInJoyUserInfo.append(paramAbsBaseArticleInfo.preloadAvatarUrl);
      paramReadInJoyUserInfo.append(" title:");
      paramReadInJoyUserInfo.append(paramAbsBaseArticleInfo.mTitle);
      QLog.d("RIJVideoViewInterceptor", 2, paramReadInJoyUserInfo.toString());
    }
  }
  
  private final void a(String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      try
      {
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.b = true;
        RIJImageTypeOptHelper.a.a(localImageRequest, paramString);
        ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, (IBitmapCallback)new RIJVideoViewInterceptor.preloadAvatarByImageManager.1(paramString));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("RIJVideoViewInterceptor", 1, "preloadAvatarByImageManager exception", (Throwable)paramString);
      }
    }
  }
  
  private final void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo.getSubscribeUin();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    ReadInJoyUserInfoModule localReadInJoyUserInfoModule = UserOperationModule.getUserInfoModule();
    if (localReadInJoyUserInfoModule != null)
    {
      List localList = (List)new ArrayList();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "uin");
      localList.add(localObject);
      localObject = localReadInJoyUserInfoModule.a(localList, (IReadInJoyUserInfoModule.RefreshUserInfoCallBack)new RIJVideoViewInterceptor.innerPreloadAvatar.userInfo.1(this, paramAbsBaseArticleInfo));
      if ((localObject instanceof ReadInJoyUserInfo)) {
        a((ReadInJoyUserInfo)localObject, paramAbsBaseArticleInfo);
      }
    }
  }
  
  private final void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.hasRequestFollowStatus) {
      return;
    }
    FollowListInfoModule.a(paramAbsBaseArticleInfo.getSubscribeUin(), (IFollowStatusObserver)new RIJVideoViewInterceptor.fetchFollowStatus.1(paramAbsBaseArticleInfo));
  }
  
  public void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    a(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo.mSubArticleList != null)
    {
      Object localObject = paramAbsBaseArticleInfo.mSubArticleList;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "articleInfo.mSubArticleList");
      if ((((Collection)localObject).isEmpty() ^ true))
      {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.iterator();
        while (paramAbsBaseArticleInfo.hasNext())
        {
          localObject = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.next();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "info");
          a((AbsBaseArticleInfo)localObject);
        }
      }
    }
  }
  
  public boolean a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJFeedsType.M(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJVideoViewInterceptor
 * JD-Core Version:    0.7.0.1
 */