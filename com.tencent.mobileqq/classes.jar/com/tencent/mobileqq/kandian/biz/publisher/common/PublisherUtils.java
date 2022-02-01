package com.tencent.mobileqq.kandian.biz.publisher.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.ugc.RIJVideoPublishConfig;
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
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/common/PublisherUtils;", "", "()V", "convertEditObjectsToBiuCommentInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo;", "uin", "", "prependColon", "", "editObjects", "Lcom/tencent/tkd/weibo/bean/EditObject;", "getCommentAfterObject", "position", "", "getCreateTopicInnerBundle", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "extra", "Lorg/json/JSONObject;", "getEditTopicInnerBundle", "getManageColumnConfigs", "getPublishArticleConfigs", "getPublishArticleInnerBundle", "putAtObjectIntoInfoList", "", "currentObject", "infoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "commentInfo", "putTopicObjectIntoInfoList", "putUrlObjectIntoInfoList", "putAddToTopic", "putAuthorityConfig", "putBottomPanelConfig", "putDeliverKDCommunityConfig", "putPrivacyConfig", "putTopicSubmitConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublisherUtils
{
  public static final PublisherUtils a = new PublisherUtils();
  
  private final String a(int paramInt, List<EditObject> paramList)
  {
    if (paramInt < paramList.size() - 1)
    {
      paramInt += 1;
      if (((EditObject)paramList.get(paramInt)).getType() == EditObject.EditObjectType.TYPE_NORMAL) {
        return ((EditObject)paramList.get(paramInt)).getWording();
      }
    }
    return "";
  }
  
  private final JSONObject a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("publishScene", "rijugc");
    a.a(localJSONObject, paramContext);
    return localJSONObject;
  }
  
  private final void a(EditObject paramEditObject, ArrayList<BiuCommentInfo> paramArrayList, String paramString)
  {
    Object localObject = StringsKt.toLongOrNull(paramEditObject.getId());
    long l;
    if (localObject != null) {
      l = ((Long)localObject).longValue();
    } else {
      l = 0L;
    }
    localObject = new JumpInfo(l, paramEditObject.getWording(), "");
    paramArrayList.add(new BiuCommentInfo(paramEditObject.getId(), Long.valueOf(paramEditObject.getAtType()), paramString, 1, (JumpInfo)localObject));
  }
  
  private final void a(EditObject paramEditObject, ArrayList<BiuCommentInfo> paramArrayList, String paramString1, String paramString2)
  {
    Long localLong = StringsKt.toLongOrNull(paramEditObject.getId());
    long l;
    if (localLong != null) {
      l = localLong.longValue();
    } else {
      l = 0L;
    }
    paramArrayList.add(new BiuCommentInfo(paramString1, Long.valueOf(0L), paramString2, 2, new JumpInfo(l, paramEditObject.getWording(), paramEditObject.getHref())));
  }
  
  private final void a(@NotNull JSONObject paramJSONObject)
  {
    int i;
    if (RIJVideoPublishConfig.d()) {
      i = 8;
    } else {
      i = 0;
    }
    int j = i;
    if (RIJVideoPublishConfig.c()) {
      j = i + 16;
    }
    paramJSONObject.put("inputPanelConfig", j);
  }
  
  private final void a(@NotNull JSONObject paramJSONObject, Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("titleCountLimit", RIJUgcUtils.c());
    localJSONObject.put("titleHint", paramContext.getResources().getString(2097807459));
    localJSONObject.put("briefCountLimit", RIJUgcUtils.d());
    localJSONObject.put("briefHint", paramContext.getResources().getString(2097807458));
    paramJSONObject.put("topicPageConfig", localJSONObject);
    localJSONObject = new JSONObject();
    int i;
    if (RIJUgcUtils.a() != 0) {
      i = 1;
    } else {
      i = 0;
    }
    localJSONObject.put("showSubmit", i);
    localJSONObject.put("allowSubmit", 0);
    localJSONObject.put("allowSubmitTitle", RIJUgcUtils.a(1, paramContext));
    localJSONObject.put("allowSubmitDesc", RIJUgcUtils.b(1, paramContext));
    localJSONObject.put("forbidSubmitTitle", RIJUgcUtils.a(0, paramContext));
    localJSONObject.put("forbidSubmitDesc", RIJUgcUtils.b(0, paramContext));
    paramJSONObject.put("topicSubmitConfig", localJSONObject);
  }
  
  private final JSONObject b(Context paramContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final void b(EditObject paramEditObject, ArrayList<BiuCommentInfo> paramArrayList, String paramString1, String paramString2)
  {
    paramArrayList.add(new BiuCommentInfo(paramString1, Long.valueOf(0L), paramString2, 3, new JumpInfo(0L, HardCodeUtil.a(2131715777), paramEditObject.getId())));
  }
  
  private final void b(@NotNull JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("showAuthority", RIJVideoPublishConfig.a());
    localJSONObject.put("allowReprint", RIJVideoPublishConfig.b());
    paramJSONObject.put("authorityConfig", localJSONObject);
  }
  
  private final void b(@NotNull JSONObject paramJSONObject, Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    boolean bool;
    if (RIJUgcUtils.f() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localJSONObject.put("showPrivacy", bool);
    localJSONObject.put("defaultPrivacy", RIJUgcUtils.g());
    localJSONObject.put("publicAndNotifyTitle", RIJUgcUtils.d(paramContext));
    localJSONObject.put("publicAndNotifyDesc", RIJUgcUtils.e(paramContext));
    localJSONObject.put("publicTitle", RIJUgcUtils.f(paramContext));
    localJSONObject.put("publicDesc", RIJUgcUtils.g(paramContext));
    localJSONObject.put("privateTitle", RIJUgcUtils.h(paramContext));
    localJSONObject.put("privateDesc", RIJUgcUtils.i(paramContext));
    paramJSONObject.put("privacyConfig", localJSONObject);
  }
  
  private final void c(@NotNull JSONObject paramJSONObject)
  {
    if (RIJVideoPublishConfig.a.f()) {
      paramJSONObject.put("showKDCommunity", true);
    }
  }
  
  private final void d(@NotNull JSONObject paramJSONObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
  public final List<BiuCommentInfo> a(@NotNull String paramString, boolean paramBoolean, @NotNull List<EditObject> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramList, "editObjects");
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramList.isEmpty();
    String str1 = "";
    Long localLong = Long.valueOf(0L);
    if (bool)
    {
      localArrayList.add(new BiuCommentInfo(paramString, localLong, ""));
      return (List)localArrayList;
    }
    if (paramBoolean) {
      str1 = "：";
    }
    int j = ((Collection)paramList).size();
    int i = 0;
    while (i < j)
    {
      Object localObject;
      if (i == 0)
      {
        if (((EditObject)paramList.get(0)).getType() == EditObject.EditObjectType.TYPE_NORMAL)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(((EditObject)paramList.get(0)).getWording());
          localArrayList.add(new BiuCommentInfo(paramString, localLong, ((StringBuilder)localObject).toString(), 0));
        }
        else
        {
          localArrayList.add(new BiuCommentInfo(paramString, localLong, str1, 0));
        }
      }
      else
      {
        localObject = (EditObject)paramList.get(i);
        String str2 = a(i, paramList);
        EditObject.EditObjectType localEditObjectType = ((EditObject)localObject).getType();
        int k = PublisherUtils.WhenMappings.a[localEditObjectType.ordinal()];
        if (k != 1)
        {
          if (k != 2)
          {
            if (k == 3) {
              b((EditObject)localObject, localArrayList, paramString, str2);
            }
          }
          else {
            a((EditObject)localObject, localArrayList, paramString, str2);
          }
        }
        else {
          a((EditObject)localObject, localArrayList, str2);
        }
      }
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtils
 * JD-Core Version:    0.7.0.1
 */