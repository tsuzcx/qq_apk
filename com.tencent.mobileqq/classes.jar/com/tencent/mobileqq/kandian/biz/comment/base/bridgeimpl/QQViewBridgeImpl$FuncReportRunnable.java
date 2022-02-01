package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.base.model.IPublishScene;
import com.tencent.qphone.base.util.QLog;
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
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        int j = QQViewBridgeImpl.b(this.this$0).f;
        i = 2;
        if (j != 2) {
          break label74;
        }
        localJSONObject.put("place", i);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("QQViewBridgeImpl", 4, localJSONException.getMessage());
      }
      QQViewBridgeImpl.b(this.this$0).d.a(this.a, localJSONObject);
      return;
      label74:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.FuncReportRunnable
 * JD-Core Version:    0.7.0.1
 */