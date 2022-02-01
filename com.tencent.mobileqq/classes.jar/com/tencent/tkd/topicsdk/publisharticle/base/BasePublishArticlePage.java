package com.tencent.tkd.topicsdk.publisharticle.base;

import android.app.Activity;
import android.content.Context;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.common.NetworkUtils;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData.Companion;
import com.tencent.tkd.topicsdk.framework.BasePage;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.publisharticle.PublishArticleUtils;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.richEditText.EditObjectListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/base/BasePublishArticlePage;", "Lcom/tencent/tkd/topicsdk/framework/BasePage;", "Lcom/tencent/tkd/topicsdk/publisharticle/base/BasePublishArticleContract$IPublishArticleView;", "Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;", "()V", "addRichEditObjectFailed", "", "editObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "extraInfo", "Lorg/json/JSONObject;", "handlePublishErrCode", "errCode", "", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "hasInternet", "", "onRichEditObjectChanged", "isAdd", "type", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "id", "", "openCoverSelectPageForResult", "item", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "coverRatio", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "Lkotlin/ParameterName;", "name", "data", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class BasePublishArticlePage
  extends BasePage
  implements BasePublishArticleContract.IPublishArticleView, EditObjectListener
{
  public void a(int paramInt, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      if (paramInt == 0)
      {
        localActivity.setResult(-1);
        TopicSDKHelperKt.c().a(localActivity, paramPublishArticleInfo);
        l();
        return;
      }
      paramPublishArticleInfo = paramPublishArticleInfo.getPublishScene();
      PublishArticleUtils.a.a(localActivity, paramInt, paramPublishArticleInfo);
    }
  }
  
  public void a(@NotNull DisplayItem paramDisplayItem, float paramFloat, @NotNull Function1<? super CoverSelectData, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "item");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      if (paramDisplayItem.getMedia().getType() != MediaType.VIDEO)
      {
        paramFunction1 = new StringBuilder();
        paramFunction1.append("onCoverSelectListener error. ");
        paramFunction1.append(paramDisplayItem);
        paramFunction1.append(" is not a video");
        TLog.d("BasePage", paramFunction1.toString());
        return;
      }
      paramDisplayItem = CoverSelectData.Companion.a(paramDisplayItem);
      if (paramFloat > 0) {
        paramDisplayItem.setCoverRatio(paramFloat);
      }
      TopicSDKHelperKt.c().a(localActivity, paramDisplayItem, (Function1)new BasePublishArticlePage.openCoverSelectPageForResult.1(paramFunction1));
    }
  }
  
  public void a(@NotNull EditObject paramEditObject, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObject, "editObject");
  }
  
  public void a(boolean paramBoolean, @NotNull EditObject.EditObjectType paramEditObjectType, @NotNull String paramString, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "type");
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    BasePublishArticleReportUtils.a.a(paramBoolean, paramString, paramEditObjectType, paramJSONObject);
  }
  
  public boolean dO_()
  {
    Activity localActivity = b();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return false");
      return NetworkUtils.a.a((Context)localActivity);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticlePage
 * JD-Core Version:    0.7.0.1
 */