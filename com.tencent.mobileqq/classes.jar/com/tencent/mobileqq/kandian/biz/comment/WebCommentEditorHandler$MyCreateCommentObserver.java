package com.tencent.mobileqq.kandian.biz.comment;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class WebCommentEditorHandler$MyCreateCommentObserver
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  private final JSONObject a;
  private final WebCommentEditorHandler.EditorResultReceiver b;
  private final JSONArray c;
  private final BaseCommentData d;
  private final String e;
  
  private WebCommentEditorHandler$MyCreateCommentObserver(JSONObject paramJSONObject, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver, JSONArray paramJSONArray, BaseCommentData paramBaseCommentData, String paramString)
  {
    this.a = paramJSONObject;
    this.b = paramEditorResultReceiver;
    this.c = paramJSONArray;
    this.d = paramBaseCommentData;
    this.e = paramString;
  }
  
  public void a(CreateCommentResult paramCreateCommentResult)
  {
    try
    {
      boolean bool = paramCreateCommentResult.b;
      j = 0;
      if (!bool) {
        break label171;
      }
      i = 0;
    }
    catch (JSONException paramCreateCommentResult)
    {
      for (;;)
      {
        int j;
        label151:
        continue;
        label171:
        int i = -2;
      }
    }
    this.a.put("retCode", i);
    this.a.put("commentId", paramCreateCommentResult.e);
    this.a.put("comment", this.d.commentContent);
    if (this.c != null) {
      this.a.put("linkDataList", this.c);
    }
    i = j;
    if (paramCreateCommentResult.c == -4096) {
      i = 1;
    }
    this.a.put("errorType", i);
    this.a.put("errorCode", paramCreateCommentResult.c);
    this.a.put("rptDataList", RIJCommentRptDataUtil.a(this.d.commentRptDataList));
    break label151;
    QLog.w("WebCommentEditorHandler", 1, "handleCommentEditorNativeResult put create comment result error.");
    this.b.a(this.e, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler.MyCreateCommentObserver
 * JD-Core Version:    0.7.0.1
 */