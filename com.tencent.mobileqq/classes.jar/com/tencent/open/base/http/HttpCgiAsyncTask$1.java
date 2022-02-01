package com.tencent.open.base.http;

import bjlg;
import bjlh;
import java.util.HashMap;
import org.json.JSONObject;

public class HttpCgiAsyncTask$1
  implements Runnable
{
  public HttpCgiAsyncTask$1(bjlg parambjlg, HashMap paramHashMap) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (((Integer)this.a.get("ResultType")).intValue() == 1) {
        this.this$0.a.a((JSONObject)this.a.get("ResultValue"));
      }
    }
    else {
      return;
    }
    this.this$0.a.a((Exception)this.a.get("ResultValue"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCgiAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */