package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

final class RIJCommentAegisHelper$1
  implements Callback
{
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("fail: ");
    paramCall.append(paramIOException.toString());
    QLog.d("RIJCommentAegisHelper", 1, paramCall.toString());
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = new StringBuilder();
    paramCall.append("success: ");
    paramCall.append(paramResponse.message());
    QLog.d("RIJCommentAegisHelper", 1, paramCall.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentAegisHelper.1
 * JD-Core Version:    0.7.0.1
 */