package com.tencent.mobileqq.kandian.biz.video;

import java.net.URL;
import org.json.JSONObject;

class ReadInJoyWebDataManager$3
  implements Runnable
{
  ReadInJoyWebDataManager$3(ReadInJoyWebDataManager paramReadInJoyWebDataManager, URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = ReadInJoyWebDataManager.f();
    try
    {
      ReadInJoyWebDataManager.a(l);
      if (ReadInJoyWebDataManager.g() > 52428800L) {
        return;
      }
      this.this$0.a(this.a.toString(), this.b, this.c, this.d);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager.3
 * JD-Core Version:    0.7.0.1
 */