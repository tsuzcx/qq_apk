package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import org.json.JSONException;
import org.json.JSONObject;

final class QQViewBridgeImpl$FuncReportRunnable
  implements Runnable
{
  private final String a;
  
  private QQViewBridgeImpl$FuncReportRunnable(QQViewBridgeImpl paramQQViewBridgeImpl, String paramString)
  {
    this.a = paramString;
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", 1);
      localJSONObject.put("entry", QQViewBridgeImpl.a(this.this$0).getEntry());
      localJSONObject.put("comment_level", QQViewBridgeImpl.a(this.this$0).getCommentLevel());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public void run()
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1 = ReadInJoyCommentUtils.a(QQViewBridgeImpl.a(this.this$0).a);
    String str2 = this.a;
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, str2, str2, 0, 0, "", "", "", a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.FuncReportRunnable
 * JD-Core Version:    0.7.0.1
 */