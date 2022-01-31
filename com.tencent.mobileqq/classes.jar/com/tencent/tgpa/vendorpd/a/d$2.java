package com.tencent.tgpa.vendorpd.a;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

class d$2
  implements Callback
{
  d$2(d paramd) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    g.b("onFailure: report data failed. ");
    paramIOException.printStackTrace();
  }
  
  public void onResponse(Response paramResponse)
  {
    g.b("onResponse: report data response code: " + paramResponse.code());
    paramResponse.body().close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.d.2
 * JD-Core Version:    0.7.0.1
 */