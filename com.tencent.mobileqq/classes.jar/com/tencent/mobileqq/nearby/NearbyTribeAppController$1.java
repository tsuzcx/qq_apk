package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class NearbyTribeAppController$1
  implements Runnable
{
  NearbyTribeAppController$1(NearbyTribeAppController paramNearbyTribeAppController) {}
  
  public void run()
  {
    try
    {
      NearbyTribeAppController.a(this.this$0, false);
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("REFERER", " https://buluo.qq.com/");
      ((Bundle)localObject).putString("HOST", " buluo.qq.com");
      QLog.e(NearbyTribeAppController.a(this.this$0), 1, "这里已经下架，如果依然发现该log，异常case");
      localObject = new JSONObject(HttpUtil.openUrl(NearbyTribeAppController.a(this.this$0), "https://buluo.qq.com/cgi-bin/bar/post/get_entry?entry_ids=[18]", "POST", null, (Bundle)localObject));
      if (((JSONObject)localObject).getInt("retcode") == 0)
      {
        localObject = ((JSONObject)localObject).getJSONObject("result").getJSONObject("18").getString("download_link");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.a((String)localObject);
          return;
        }
      }
      QLog.e(NearbyTribeAppController.a(this.this$0), 1, "这里已经下架，如果依然发现该log，异常case");
      this.this$0.a("https://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e(NearbyTribeAppController.a(this.this$0), 1, "这里已经下架，如果依然发现该log，异常case");
      this.this$0.a("https://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTribeAppController.1
 * JD-Core Version:    0.7.0.1
 */