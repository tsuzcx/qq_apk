package com.tencent.mobileqq.kandian.biz.comment;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.msgboard.data.RIJMessageBoardEditorParams;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xfa3.oidb_0xfa3.RspBody;

final class WebCommentEditorHandler$MessageBoardNetCallback
  implements Function3<Integer, String, oidb_0xfa3.RspBody, Unit>
{
  private final String a;
  private final RIJMessageBoardEditorParams b;
  private final List<BaseCommentData.CommentRptData> c;
  private final WebCommentEditorHandler.EditorResultReceiver d;
  
  private WebCommentEditorHandler$MessageBoardNetCallback(String paramString, @NonNull RIJMessageBoardEditorParams paramRIJMessageBoardEditorParams, @NonNull List<BaseCommentData.CommentRptData> paramList, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver)
  {
    this.a = paramString;
    this.d = paramEditorResultReceiver;
    this.b = paramRIJMessageBoardEditorParams;
    this.c = paramList;
  }
  
  private static String a(oidb_0xfa3.RspBody paramRspBody)
  {
    if (paramRspBody != null) {
      return paramRspBody.message_id.get();
    }
    throw new NullPointerException("rspBody can not be null");
  }
  
  public Unit a(@NonNull Integer paramInteger, String paramString, oidb_0xfa3.RspBody paramRspBody)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageBoardNetCallback#invoke: errorCode=");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append(", errorMsg=");
    localStringBuilder.append(paramString);
    QLog.d("WebCommentEditorHandler", 1, localStringBuilder.toString());
    int i = paramInteger.intValue();
    int j = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramInteger = new JSONObject();
    if (i == 0) {
      j = -2;
    }
    try
    {
      paramInteger.put("retCode", j);
      this.b.b(paramInteger);
      if (i != 0)
      {
        paramInteger.put("message_id", a(paramRspBody));
        paramInteger.put("rptDataList", RIJCommentRptDataUtil.a(this.c));
      }
    }
    catch (Throwable paramString)
    {
      QLog.w("WebCommentEditorHandler", 1, paramString.getMessage(), paramString);
    }
    paramString = new StringBuilder();
    paramString.append("MessageBoardNetCallback#invoke: jsonObject=");
    paramString.append(paramInteger);
    QLog.d("WebCommentEditorHandler", 1, paramString.toString());
    this.d.a(this.a, paramInteger);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler.MessageBoardNetCallback
 * JD-Core Version:    0.7.0.1
 */