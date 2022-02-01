package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJPopupWindowUtil;", "", "()V", "TAG", "", "setCloseBtnListener", "", "bottomDialog", "Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJBottomDialog;", "setRecommendTitle", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "showFollowRecommendPopup", "context", "Landroid/content/Context;", "activityHashCode", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPopupWindowUtil
{
  public static final RIJPopupWindowUtil a = new RIJPopupWindowUtil();
  
  private final void a(RIJBottomDialog paramRIJBottomDialog)
  {
    Object localObject = paramRIJBottomDialog.a();
    if (localObject != null) {
      localObject = (ImageView)((View)localObject).findViewById(2131363892);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new RIJPopupWindowUtil.setCloseBtnListener..inlined.let.lambda.1(paramRIJBottomDialog));
    }
  }
  
  private final void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJBottomDialog paramRIJBottomDialog)
  {
    paramRIJBottomDialog = paramRIJBottomDialog.a();
    Object localObject2 = null;
    if (paramRIJBottomDialog != null) {
      paramRIJBottomDialog = (TextView)paramRIJBottomDialog.findViewById(2131379930);
    } else {
      paramRIJBottomDialog = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setRecommendTitle] recommendTitle = ");
    Object localObject1 = paramAbsBaseArticleInfo.mRecommendFollowInfos;
    if (localObject1 != null) {
      localObject1 = ((RecommendFollowInfos)localObject1).a;
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    QLog.i("RIJPopupWindowUtil", 1, localStringBuilder.toString());
    localObject1 = paramAbsBaseArticleInfo.mRecommendFollowInfos;
    if (localObject1 != null) {
      localObject1 = ((RecommendFollowInfos)localObject1).a;
    } else {
      localObject1 = null;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramRIJBottomDialog != null))
    {
      localObject1 = paramAbsBaseArticleInfo.mRecommendFollowInfos;
      paramAbsBaseArticleInfo = localObject2;
      if (localObject1 != null) {
        paramAbsBaseArticleInfo = ((RecommendFollowInfos)localObject1).a;
      }
      paramRIJBottomDialog.setText((CharSequence)paramAbsBaseArticleInfo);
    }
  }
  
  public final void a(@Nullable Context paramContext, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    if (!FastWebPTSDataConverter.a(paramAbsBaseArticleInfo))
    {
      QLog.i("RIJPopupWindowUtil", 1, "showFollowRecommendPopup error! no recommend data!");
      return;
    }
    if ((paramContext != null) && (paramInt == paramContext.hashCode()) && ((!(paramContext instanceof Activity)) || (!((Activity)paramContext).isFinishing())))
    {
      ThreadManager.getUIHandler().post((Runnable)new RIJPopupWindowUtil.showFollowRecommendPopup.1(paramContext, paramAbsBaseArticleInfo));
      return;
    }
    QLog.i("RIJPopupWindowUtil", 1, "showFollowRecommendPopup error! activity changed or finishing!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJPopupWindowUtil
 * JD-Core Version:    0.7.0.1
 */