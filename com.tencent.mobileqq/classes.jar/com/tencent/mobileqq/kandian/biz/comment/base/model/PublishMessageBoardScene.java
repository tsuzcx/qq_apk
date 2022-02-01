package com.tencent.mobileqq.kandian.biz.comment.base.model;

import android.content.Intent;
import android.text.Editable;
import com.tencent.mobileqq.kandian.biz.comment.msgboard.data.RIJMessageBoardEditorParams;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/base/model/PublishMessageBoardScene;", "Lcom/tencent/mobileqq/kandian/biz/comment/base/model/BasePublishScene;", "()V", "params", "Lcom/tencent/mobileqq/kandian/biz/comment/msgboard/data/RIJMessageBoardEditorParams;", "enableLink", "", "getQQDraftId", "", "init", "", "commentArgumentModel", "Lcom/tencent/mobileqq/kandian/biz/comment/base/model/CommentArgumentModel;", "intent", "Landroid/content/Intent;", "reportCommentCancelEvent", "reportCommon", "actionCode", "jsonObject", "Lorg/json/JSONObject;", "reportDeleteGif", "reportDeleteLink", "reportDeliver", "text", "Landroid/text/Editable;", "linkDataList", "", "Lcom/tencent/tkd/comment/publisher/qq/model/TkdCommentLinkData;", "reportOpenCommentComponent", "topicVisible", "atVisible", "reportOpenEmotionPanel", "reportOpenGifPanel", "reportOpenLink", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishMessageBoardScene
  extends BasePublishScene
{
  public static final PublishMessageBoardScene.Companion a = new PublishMessageBoardScene.Companion(null);
  private RIJMessageBoardEditorParams b;
  
  public void a(@NotNull CommentArgumentModel paramCommentArgumentModel, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentArgumentModel, "commentArgumentModel");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramCommentArgumentModel = paramIntent.getParcelableExtra("messageBoardParam");
    Intrinsics.checkExpressionValueIsNotNull(paramCommentArgumentModel, "intent.getParcelableExtr….KEY_MESSAGE_BOARD_PARAM)");
    this.b = ((RIJMessageBoardEditorParams)paramCommentArgumentModel);
  }
  
  public void a(@Nullable String paramString, @Nullable JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return;
    }
    paramJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramJSONObject.put("os", 1);
        Object localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        paramJSONObject.put("chatting_id", ((RIJMessageBoardEditorParams)localObject).g);
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        localObject = (CharSequence)((RIJMessageBoardEditorParams)localObject).d;
        if (localObject == null) {
          break label157;
        }
        if (((CharSequence)localObject).length() != 0) {
          break label152;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.w("PublishMessageBoardScene", 1, localJSONException.getMessage(), (Throwable)localJSONException);
      }
      paramJSONObject.put("chatting_type", i);
      paramJSONObject = paramJSONObject.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "JSONObject().apply {\n   …   }\n        }.toString()");
      PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", paramJSONObject, false);
      return;
      label152:
      int i = 0;
      break label159;
      label157:
      i = 1;
      label159:
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  @Nullable
  public String c()
  {
    String str = (String)null;
    try
    {
      Object localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      localObject = ((RIJMessageBoardEditorParams)localObject).b(null).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("PublishMessageBoardScene", 1, localThrowable.getMessage(), localThrowable);
    }
    return str;
  }
  
  public void reportCommentCancelEvent() {}
  
  public void reportDeleteGif() {}
  
  public void reportDeleteLink() {}
  
  public void reportDeliver(@Nullable Editable paramEditable, @Nullable List<TkdCommentLinkData> paramList)
  {
    IPublishScene.DefaultImpls.a(this, "0X800BCC5", null, 2, null);
  }
  
  public void reportOpenCommentComponent(boolean paramBoolean1, boolean paramBoolean2)
  {
    IPublishScene.DefaultImpls.a(this, "0X800BCC4", null, 2, null);
  }
  
  public void reportOpenEmotionPanel() {}
  
  public void reportOpenGifPanel() {}
  
  public void reportOpenLink() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.model.PublishMessageBoardScene
 * JD-Core Version:    0.7.0.1
 */