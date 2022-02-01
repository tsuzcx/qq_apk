package com.tencent.mobileqq.kandian.biz.publisher.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.config.RIJVideoPublishConfig;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig.Companion;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo.Companion;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/common/PublisherUtils;", "", "()V", "convertEditObjectsToBiuCommentInfoList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo;", "uin", "", "prependColon", "", "editObjects", "Lcom/tencent/tkd/weibo/bean/EditObject;", "getCreateTopicInnerBundle", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "extra", "Lorg/json/JSONObject;", "getEditTopicInnerBundle", "getManageColumnConfigs", "getPublishArticleConfigs", "getPublishArticleInnerBundle", "putAddToTopic", "", "putAuthorityConfig", "putBottomPanelConfig", "putPrivacyConfig", "putTopicSubmitConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublisherUtils
{
  public static final PublisherUtils a = new PublisherUtils();
  
  private final JSONObject a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("publishScene", "rijugc");
    a.a(localJSONObject, paramContext);
    return localJSONObject;
  }
  
  private final void a(@NotNull JSONObject paramJSONObject)
  {
    int i = 0;
    if (RIJVideoPublishConfig.c()) {
      i = 8;
    }
    int j = i;
    if (RIJVideoPublishConfig.b()) {
      j = i + 16;
    }
    paramJSONObject.put("inputPanelConfig", j);
  }
  
  private final void a(@NotNull JSONObject paramJSONObject, Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("titleCountLimit", RIJUgcUtils.d());
    localJSONObject.put("titleHint", paramContext.getResources().getString(2114453581));
    localJSONObject.put("briefCountLimit", RIJUgcUtils.e());
    localJSONObject.put("briefHint", paramContext.getResources().getString(2114453580));
    paramJSONObject.put("topicPageConfig", localJSONObject);
    localJSONObject = new JSONObject();
    if (RIJUgcUtils.a() != 0)
    {
      i = 1;
      if (i == 0) {
        break label182;
      }
    }
    label182:
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("showSubmit", i);
      localJSONObject.put("allowSubmit", 0);
      localJSONObject.put("allowSubmitTitle", RIJUgcUtils.a(1, paramContext));
      localJSONObject.put("allowSubmitDesc", RIJUgcUtils.b(1, paramContext));
      localJSONObject.put("forbidSubmitTitle", RIJUgcUtils.a(0, paramContext));
      localJSONObject.put("forbidSubmitDesc", RIJUgcUtils.b(0, paramContext));
      paramJSONObject.put("topicSubmitConfig", localJSONObject);
      return;
      i = 0;
      break;
    }
  }
  
  private final JSONObject b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("publishScene", "rijugc");
    localJSONObject.put("textCountLimit", RIJUgcUtils.f());
    localJSONObject.put("showToolBarLBS", RIJVideoPublishConfig.d());
    a.a(localJSONObject);
    a.c(localJSONObject);
    a.b(localJSONObject);
    a.b(localJSONObject, paramContext);
    return localJSONObject;
  }
  
  private final void b(@NotNull JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (RIJVideoPublishConfig.a() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("showAuthority", bool);
      localJSONObject.put("allowReprint", RIJVideoPublishConfig.a());
      paramJSONObject.put("authorityConfig", localJSONObject);
      return;
    }
  }
  
  private final void b(@NotNull JSONObject paramJSONObject, Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    if (RIJUgcUtils.g() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("showPrivacy", bool);
      localJSONObject.put("defaultPrivacy", RIJUgcUtils.h());
      localJSONObject.put("publicAndNotifyTitle", RIJUgcUtils.d(paramContext));
      localJSONObject.put("publicAndNotifyDesc", RIJUgcUtils.e(paramContext));
      localJSONObject.put("publicTitle", RIJUgcUtils.f(paramContext));
      localJSONObject.put("publicDesc", RIJUgcUtils.g(paramContext));
      localJSONObject.put("privateTitle", RIJUgcUtils.h(paramContext));
      localJSONObject.put("privateDesc", RIJUgcUtils.i(paramContext));
      paramJSONObject.put("privacyConfig", localJSONObject);
      return;
    }
  }
  
  private final void c(@NotNull JSONObject paramJSONObject)
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    if (RIJUgcUtils.k())
    {
      i = 1;
      localJSONObject.put("showAddToTopic", i);
      if (!RIJUgcUtils.c()) {
        break label60;
      }
    }
    label60:
    for (int i = j;; i = 0)
    {
      localJSONObject.put("default_column", i);
      paramJSONObject.put("addToTopicConfig", localJSONObject);
      return;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public final Bundle a(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    JSONObject localJSONObject = a(paramContext);
    if (paramJSONObject != null) {
      PublisherUtilsKt.a(localJSONObject, paramJSONObject);
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putSerializable("global_publisher_config", (Serializable)GlobalPublisherConfig.Companion.a(GlobalPublisherConfig.Companion, a.a(paramContext), null, 2, null));
    return paramJSONObject;
  }
  
  @NotNull
  public final List<SocializeFeedsInfo.BiuCommentInfo> a(@NotNull String paramString, boolean paramBoolean, @NotNull List<EditObject> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramList, "editObjects");
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "："; paramList.isEmpty(); str = "")
    {
      localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), ""));
      return (List)localArrayList;
    }
    int j = ((Collection)paramList).size();
    int i = 0;
    if (i < j)
    {
      if (i == 0) {
        if (((EditObject)paramList.get(0)).getType() == EditObject.EditObjectType.TYPE_NORMAL) {
          localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), str + ((EditObject)paramList.get(0)).getWording(), 0));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), str, 0));
        Object localObject2 = "";
        Object localObject1 = localObject2;
        if (i < paramList.size() - 1)
        {
          localObject1 = localObject2;
          if (((EditObject)paramList.get(i + 1)).getType() == EditObject.EditObjectType.TYPE_NORMAL) {
            localObject1 = ((EditObject)paramList.get(i + 1)).getWording();
          }
        }
        localObject2 = ((EditObject)paramList.get(i)).getType();
        switch (PublisherUtils.WhenMappings.a[localObject2.ordinal()])
        {
        default: 
          break;
        case 1: 
          localObject2 = new SocializeFeedsInfo.JumpInfo(Long.parseLong(((EditObject)paramList.get(i)).getId()), ((EditObject)paramList.get(i)).getWording(), "");
          localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(((EditObject)paramList.get(i)).getId(), Long.valueOf(((EditObject)paramList.get(i)).getAtType()), (String)localObject1, 1, (SocializeFeedsInfo.JumpInfo)localObject2));
          break;
        case 2: 
          localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), (String)localObject1, 2, new SocializeFeedsInfo.JumpInfo(Long.parseLong(((EditObject)paramList.get(i)).getId()), ((EditObject)paramList.get(i)).getWording(), ((EditObject)paramList.get(i)).getHref())));
          break;
        case 3: 
          localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), (String)localObject1, 3, new SocializeFeedsInfo.JumpInfo(0L, HardCodeUtil.a(2131715853), ((EditObject)paramList.get(i)).getId())));
        }
      }
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public final Bundle b(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = a(paramContext);
    if (paramJSONObject != null) {
      PublisherUtilsKt.a(paramContext, paramJSONObject);
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putParcelable("topic_info", (Parcelable)TopicInfo.Companion.a(paramContext));
    paramJSONObject.putSerializable("global_publisher_config", (Serializable)GlobalPublisherConfig.Companion.a(GlobalPublisherConfig.Companion, paramContext, null, 2, null));
    return paramJSONObject;
  }
  
  @NotNull
  public final Bundle c(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Bundle localBundle = new Bundle();
    paramContext = b(paramContext);
    if (paramJSONObject != null) {
      PublisherUtilsKt.a(paramContext, paramJSONObject);
    }
    localBundle.putSerializable("global_publisher_config", (Serializable)GlobalPublisherConfig.Companion.a(GlobalPublisherConfig.Companion, paramContext, null, 2, null));
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtils
 * JD-Core Version:    0.7.0.1
 */