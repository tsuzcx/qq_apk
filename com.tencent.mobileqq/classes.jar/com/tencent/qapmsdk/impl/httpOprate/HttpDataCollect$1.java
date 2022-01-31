package com.tencent.qapmsdk.impl.httpOprate;

import com.tencent.qapmsdk.impl.instrumentation.QAPMNetworkProcessHeader;
import okhttp3.Request;

final class HttpDataCollect$1
  implements QAPMNetworkProcessHeader
{
  HttpDataCollect$1(Request paramRequest) {}
  
  public String getFilterHeader(String paramString)
  {
    if ((this.val$request != null) && (paramString != null)) {
      return this.val$request.header(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.httpOprate.HttpDataCollect.1
 * JD-Core Version:    0.7.0.1
 */