package com.tencent.open.base.http;

import java.util.HashMap;
import org.json.JSONObject;

class HttpCgiAsyncTask$1
  implements Runnable
{
  HttpCgiAsyncTask$1(HttpCgiAsyncTask paramHttpCgiAsyncTask, HashMap paramHashMap) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      if (((Integer)this.a.get("ResultType")).intValue() == 1)
      {
        this.this$0.b.a((JSONObject)this.a.get("ResultValue"));
        return;
      }
      this.this$0.b.a((Exception)this.a.get("ResultValue"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCgiAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */