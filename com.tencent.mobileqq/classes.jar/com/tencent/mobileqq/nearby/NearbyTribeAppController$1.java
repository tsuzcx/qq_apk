package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import android.text.TextUtils;
import atbk;
import nam;
import org.json.JSONObject;

public class NearbyTribeAppController$1
  implements Runnable
{
  public NearbyTribeAppController$1(atbk paramatbk) {}
  
  public void run()
  {
    try
    {
      atbk.a(this.this$0, false);
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("REFERER", " https://buluo.qq.com/");
      ((Bundle)localObject).putString("HOST", " buluo.qq.com");
      localObject = new JSONObject(nam.a(atbk.a(this.this$0), "http://buluo.qq.com/cgi-bin/bar/post/get_entry?entry_ids=[18]", "POST", null, (Bundle)localObject));
      if (((JSONObject)localObject).getInt("retcode") == 0)
      {
        localObject = ((JSONObject)localObject).getJSONObject("result").getJSONObject("18").getString("download_link");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.a((String)localObject);
          return;
        }
      }
      this.this$0.a("http://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.this$0.a("http://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTribeAppController.1
 * JD-Core Version:    0.7.0.1
 */