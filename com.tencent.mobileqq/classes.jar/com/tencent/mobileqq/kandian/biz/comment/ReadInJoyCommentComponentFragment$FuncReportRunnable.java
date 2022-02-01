package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class ReadInJoyCommentComponentFragment$FuncReportRunnable
  implements Runnable
{
  private final String a;
  
  private ReadInJoyCommentComponentFragment$FuncReportRunnable(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString)
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
        int j = ReadInJoyCommentComponentFragment.k(this.this$0);
        i = 2;
        if (j != 2) {
          break label96;
        }
        localJSONObject.put("place", i);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 4, localJSONException.getMessage());
      }
      String str1 = ReadInJoyCommentUtils.a(ReadInJoyCommentComponentFragment.l(this.this$0));
      String str2 = this.a;
      PublicAccountReportUtils.a(null, str1, str2, str2, 0, 0, "", "", "", ReadInJoyCommentComponentFragment.a(this.this$0, localJSONObject), false);
      return;
      label96:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.FuncReportRunnable
 * JD-Core Version:    0.7.0.1
 */