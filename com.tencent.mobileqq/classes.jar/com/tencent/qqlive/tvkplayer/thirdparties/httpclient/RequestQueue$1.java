package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

class RequestQueue$1
  implements RequestQueue.RequestFilter
{
  RequestQueue$1(RequestQueue paramRequestQueue, Object paramObject) {}
  
  public boolean apply(Request paramRequest)
  {
    return paramRequest.getTag() == this.val$tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.RequestQueue.1
 * JD-Core Version:    0.7.0.1
 */