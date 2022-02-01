package com.tencent.mobileqq.kandian.biz.comment.base.model;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/base/model/PublishCommentScene;", "Lcom/tencent/mobileqq/kandian/biz/comment/base/model/BasePublishScene;", "()V", "baseArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "clickCommentEditViewSrc", "", "commentArgumentModel", "Lcom/tencent/mobileqq/kandian/biz/comment/base/model/CommentArgumentModel;", "commentAuthorUin", "", "commentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "commentId", "commentType", "isGalleryChannel", "", "isNativeCommentComponent", "isNewCommentComponentType", "isPgcAuthor", "isSecondCommentReply", "isSecondCommentReplyUin", "linkReply", "parentCommentAuthorUin", "sourceType", "directCommentArticle", "enableLink", "fillR5OnDeliver", "", "jsonObject", "Lorg/json/JSONObject;", "editable", "Landroid/text/Editable;", "getCommentId", "getConsumeTime", "", "getEntry", "getFolderStatus", "getFolderStatusInt", "getInputHint", "getQQDraftId", "getR5Data", "getScene", "getToUin", "init", "intent", "Landroid/content/Intent;", "onDeliver", "result", "packageDataInfo", "resultJson", "text", "reportCommentCancelEvent", "reportCommon", "actionCode", "reportCommon2", "reportDeleteGif", "reportDeleteLink", "reportDeliver", "linkDataList", "", "Lcom/tencent/tkd/comment/publisher/qq/model/TkdCommentLinkData;", "reportOpenCommentComponent", "topicVisible", "atVisible", "reportOpenEmotionPanel", "reportOpenGifPanel", "reportOpenLink", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishCommentScene
  extends BasePublishScene
{
  public static final PublishCommentScene.Companion a = new PublishCommentScene.Companion(null);
  private boolean b;
  private String c = "";
  private int d = -1;
  private int e;
  private String f;
  private boolean g;
  private String h;
  private String i;
  private boolean j;
  private int k;
  private int l;
  private SimpleCommentData m;
  private boolean n;
  private AbsBaseArticleInfo o;
  private boolean p;
  private CommentArgumentModel q;
  
  private final String a(String paramString, SimpleCommentData paramSimpleCommentData)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i1;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0) {
      return paramString;
    }
    if ((paramSimpleCommentData instanceof SubCommentCreateData)) {
      return ((SubCommentCreateData)paramSimpleCommentData).a();
    }
    return "";
  }
  
  private final String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    try
    {
      paramJSONObject.put("os", 1);
      paramJSONObject.put("entry", f());
      paramJSONObject.put("comment_level", ReadInJoyCommentUtils.a(this.g, this.m, this.h));
    }
    catch (JSONException localJSONException)
    {
      QLog.w("PublishCommentScene", 1, localJSONException.getMessage(), (Throwable)localJSONException);
    }
    paramJSONObject = paramJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "(jsonObject ?: JSONObjec…       }\n    }.toString()");
    return paramJSONObject;
  }
  
  private final void a(JSONObject paramJSONObject, Editable paramEditable)
  {
    RIJEmotionUtil.a((Spanned)paramEditable, paramJSONObject);
  }
  
  private final JSONObject b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    try
    {
      paramJSONObject.put("folder_status", h());
      paramJSONObject.put("os", 1);
      paramJSONObject.put("entry", f());
      paramJSONObject.put("scene", g());
      return paramJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.w("PublishCommentScene", 1, localJSONException.getMessage(), (Throwable)localJSONException);
    }
    return paramJSONObject;
  }
  
  private final void b(String paramString, JSONObject paramJSONObject)
  {
    PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", b(paramJSONObject).toString(), false);
  }
  
  private final boolean d()
  {
    return ((CharSequence)a(this.h, this.m)).length() == 0;
  }
  
  private final String e()
  {
    Object localObject2 = this.o;
    String str = "";
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject2 = ReadInJoyCommentUtils.a((AbsBaseArticleInfo)localObject2);
      localObject1 = str;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private final int f()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return ((SimpleCommentData)localObject).j();
    }
    localObject = ReadInJoyCommentDataManager.a(this.o);
    if (localObject != null) {
      return ((ReadInJoyCommentDataManager)localObject).a();
    }
    return 0;
  }
  
  private final int g()
  {
    SimpleCommentData localSimpleCommentData = this.m;
    if (localSimpleCommentData != null) {
      return localSimpleCommentData.f();
    }
    return 0;
  }
  
  private final int h()
  {
    return RIJKanDianFolderStatus.reportFolderStatus;
  }
  
  private final long i()
  {
    Object localObject = this.o;
    if (localObject != null) {
      localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
    } else {
      localObject = null;
    }
    return TimeSliceHelper.a((String)localObject, false) / 1000L;
  }
  
  @NotNull
  public String a()
  {
    boolean bool = d();
    String str = "";
    Object localObject1 = str;
    if (bool)
    {
      Object localObject2 = this.o;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject2 = ReadInJoyCommentDataManager.a((AbsBaseArticleInfo)localObject2);
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject2 = ((ReadInJoyCommentDataManager)localObject2).d();
          localObject1 = str;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(@NotNull Intent paramIntent, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    super.a(paramIntent, paramString);
    paramIntent.putExtra("comment_article_info", (Parcelable)this.o);
    paramIntent.putExtra("comment_gallery_channel", this.n);
    paramString = (CharSequence)this.c;
    int i1;
    if ((paramString != null) && (paramString.length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    paramIntent.putExtra("click_comment_edit_src", i1);
  }
  
  public void a(@NotNull CommentArgumentModel paramCommentArgumentModel, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentArgumentModel, "commentArgumentModel");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    this.q = paramCommentArgumentModel;
    boolean bool2 = false;
    this.g = paramIntent.getBooleanExtra("comment_reply_second", false);
    if (this.g) {
      this.f = paramIntent.getStringExtra("comment_reply_second_uin");
    }
    this.b = paramIntent.getBooleanExtra("comment_native", false);
    boolean bool1;
    if (this.b)
    {
      this.o = ((AbsBaseArticleInfo)paramIntent.getParcelableExtra("comment_article_info"));
      this.c = paramIntent.getStringExtra("comment_author_uin");
      this.h = paramIntent.getStringExtra("comment_id");
      this.i = paramIntent.getStringExtra("first_comment_uin");
      paramCommentArgumentModel = this.o;
      if (paramCommentArgumentModel != null) {
        bool1 = paramCommentArgumentModel.mIsGalleryChannel;
      } else {
        bool1 = false;
      }
      this.n = bool1;
    }
    paramCommentArgumentModel = paramIntent.getExtras();
    if (paramCommentArgumentModel != null)
    {
      this.k = paramCommentArgumentModel.getInt("commentType", 0);
      this.e = paramCommentArgumentModel.getInt("sourceType", 0);
      this.d = paramCommentArgumentModel.getInt("click_comment_edit_src");
      this.j = paramCommentArgumentModel.getBoolean("comment_type", true);
      this.m = ((SimpleCommentData)paramCommentArgumentModel.getParcelable("comment_create_data"));
      this.l = paramIntent.getIntExtra("comment_to_reply_contain_link", 2);
      if (paramCommentArgumentModel.containsKey("isPgcAuthor"))
      {
        bool1 = paramCommentArgumentModel.getBoolean("isPgcAuthor");
      }
      else
      {
        paramCommentArgumentModel = this.o;
        bool1 = bool2;
        if (paramCommentArgumentModel != null)
        {
          if (paramCommentArgumentModel != null) {
            paramCommentArgumentModel = paramCommentArgumentModel.innerUniqueID;
          } else {
            paramCommentArgumentModel = null;
          }
          bool1 = bool2;
          if (ReadInJoyCommentDataManager.c(paramCommentArgumentModel)) {
            bool1 = true;
          }
        }
      }
      this.p = bool1;
    }
  }
  
  public void a(@Nullable String paramString, @Nullable JSONObject paramJSONObject)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i1;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return;
    }
    PublicAccountReportUtils.a(null, e(), paramString, paramString, 0, 0, "", "", "", a(paramJSONObject), false);
  }
  
  public void a(@NotNull JSONObject paramJSONObject, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "resultJson");
    super.a(paramJSONObject, paramString);
    paramString = (CharSequence)paramString;
    int i1;
    if ((paramString != null) && (paramString.length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return;
    }
    if (this.b)
    {
      if (TextUtils.isEmpty((CharSequence)this.f)) {
        paramString = "";
      } else {
        paramString = this.f;
      }
      paramJSONObject.put("replyUin", paramString);
      paramJSONObject.put("isSecondReply", this.g);
      paramJSONObject.put("commentId", this.h);
      paramJSONObject.put("commentUin", this.i);
    }
  }
  
  public boolean b()
  {
    return this.p;
  }
  
  @Nullable
  public String c()
  {
    return CommentArgumentModel.a(this.o, this.h, this.m);
  }
  
  public void reportCommentCancelEvent()
  {
    if (this.d == -1) {
      return;
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = "";
    if (this.d == 1) {
      localObjectRef.element = "0X80094C4";
    }
    ThreadManager.getSubThreadHandler().post((Runnable)new PublishCommentScene.reportCommentCancelEvent.1(this, localObjectRef));
  }
  
  public void reportDeleteGif()
  {
    a(this, "0X800844D", null, 2, null);
  }
  
  public void reportDeleteLink()
  {
    IPublishScene.DefaultImpls.a(this, "0X800B086", null, 2, null);
  }
  
  public void reportDeliver(@Nullable Editable paramEditable, @Nullable List<TkdCommentLinkData> paramList)
  {
    boolean bool = TextUtils.isEmpty((CharSequence)QQViewBridgeImpl.a((CharSequence)paramEditable));
    int i3 = 0;
    int i1;
    if (!bool) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    String str;
    if (this.d == 1) {
      str = "0X80094A1";
    } else {
      str = "0X800844E";
    }
    JSONObject localJSONObject = a(this, null, 1, null);
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if (!paramList.isEmpty()) {
          continue;
        }
      }
      catch (JSONException paramEditable)
      {
        StringBuilder localStringBuilder;
        continue;
      }
      localJSONObject.put("link", i3);
      if (i2 == 0)
      {
        localStringBuilder = new StringBuilder();
        if (paramList == null) {
          Intrinsics.throwNpe();
        }
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localStringBuilder.append(((TkdCommentLinkData)paramList.next()).type);
          localStringBuilder.append(',');
          continue;
        }
        localJSONObject.put("link_type", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
      a(localJSONObject, paramEditable);
      continue;
      QLog.w("PublishCommentScene", 1, paramEditable.getMessage(), (Throwable)paramEditable);
      PublicAccountReportUtils.a(null, e(), str, str, 0, 0, String.valueOf(this.k), String.valueOf(i1), "", localJSONObject.toString(), false);
      return;
      int i2 = 0;
      break label248;
      i2 = 1;
      label248:
      if (i2 == 0) {
        i3 = 1;
      }
    }
  }
  
  public void reportOpenCommentComponent(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.q;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("commentArgumentModel");
    }
    localObject1 = (CharSequence)((CommentArgumentModel)localObject1).e;
    int i3 = 0;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int i2 = 2;
    Object localObject2;
    if (i1 == 0)
    {
      localObject1 = this.q;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("commentArgumentModel");
      }
      localObject1 = ((CommentArgumentModel)localObject1).e;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "commentArgumentModel.placeHolder");
      localObject1 = (CharSequence)localObject1;
      localObject2 = HardCodeUtil.a(2131915287);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "HardCodeUtil.qqStr(R.str….readinjoy_comment_reply)");
      if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)localObject2, false, 2, null))
      {
        i1 = i2;
        break label141;
      }
    }
    int i1 = 1;
    label141:
    localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("folder_status", h());
        if (this.o != null) {
          ((JSONObject)localObject1).put("consume_time", i());
        }
        ((JSONObject)localObject1).put("os", 1);
        ((JSONObject)localObject1).put("link_reply", this.l);
        ((JSONObject)localObject1).put("entry", f());
        ((JSONObject)localObject1).put("scene", g());
        localObject2 = this.q;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("commentArgumentModel");
        }
        if (!((CommentArgumentModel)localObject2).a) {
          break label382;
        }
        i2 = 1;
        ((JSONObject)localObject1).put("link_entry", i2);
        if (!paramBoolean1) {
          break label388;
        }
        i2 = 1;
        ((JSONObject)localObject1).put("subject", i2);
        i2 = i3;
        if (paramBoolean2) {
          i2 = 1;
        }
        ((JSONObject)localObject1).put("at_entry", i2);
      }
      catch (JSONException localJSONException)
      {
        QLog.w("PublishCommentScene", 1, localJSONException.getMessage(), (Throwable)localJSONException);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "JSONObject().apply {\n   …   }\n        }.toString()");
      PublicAccountReportUtils.a(null, e(), "0X800844A", "0X800844A", 0, 0, String.valueOf(i1), String.valueOf(this.e), "", (String)localObject1, false);
      return;
      label382:
      i2 = 0;
      continue;
      label388:
      i2 = 0;
    }
  }
  
  public void reportOpenEmotionPanel()
  {
    JSONObject localJSONObject = new JSONObject();
    CommentArgumentModel localCommentArgumentModel = this.q;
    if (localCommentArgumentModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("commentArgumentModel");
    }
    int i1 = localCommentArgumentModel.f;
    int i2 = 1;
    if (i1 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 1)
    {
      i1 = 2;
    }
    else
    {
      if (i1 != 0) {
        break label79;
      }
      i1 = i2;
    }
    try
    {
      localJSONObject.put("place", i1);
      label70:
      b("0X800844B", localJSONObject);
      return;
      label79:
      throw new NoWhenBranchMatchedException();
    }
    catch (JSONException localJSONException)
    {
      break label70;
    }
  }
  
  public void reportOpenGifPanel()
  {
    a(this, "0X800844C", null, 2, null);
  }
  
  public void reportOpenLink()
  {
    IPublishScene.DefaultImpls.a(this, "0X800B085", null, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.model.PublishCommentScene
 * JD-Core Version:    0.7.0.1
 */