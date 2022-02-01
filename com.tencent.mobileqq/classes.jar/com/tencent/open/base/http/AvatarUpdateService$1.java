package com.tencent.open.base.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class AvatarUpdateService$1
  implements Runnable
{
  AvatarUpdateService$1(AvatarUpdateService paramAvatarUpdateService, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback) {}
  
  public void run()
  {
    Object localObject1 = new DefaultHttpClient();
    try
    {
      ??? = new HttpGet(MsfSdkUtils.insertMtype("yingyongbao", this.a));
      ((HttpGet)???).addHeader("Cookie", this.b);
      localObject1 = EntityUtils.toString(((HttpClient)localObject1).execute((HttpUriRequest)???).getEntity(), "utf-8");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--jsonp is empty");
        return;
      }
      int i = ((String)localObject1).indexOf('{');
      int j = ((String)localObject1).lastIndexOf('}');
      if ((i >= 0) && (i <= j) && (j >= 0))
      {
        localObject1 = new JSONObject(((String)localObject1).substring(i, j + 1)).getString(this.c);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("AvatarUpdateService", 1, "-->updateAvatar--image url is empty");
          return;
        }
        ??? = this.this$0.b.getString(this.c, "");
        if ((!FileUtils.fileExists(this.d)) || (!((String)localObject1).equals(???)))
        {
          QLog.d("AvatarUpdateService", 1, "-->updateAvatar--avatar not exist or need update, will download new avatar");
          synchronized (this.this$0.a)
          {
            if (!this.this$0.a.containsKey(this.c))
            {
              this.this$0.a.put(this.c, new AvatarUpdateService.AvatarUpdateTask(this.this$0, this.e, this.c, this.d, (String)localObject1, this.f));
              new HttpImageDownloadAsyncTask(this.c, (String)localObject1, null, "GET", this.this$0).execute(new Void[0]);
            }
            return;
          }
        }
      }
      else
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--can not find json string");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AvatarUpdateService", 1, new Object[] { "-->updateAvatar---", localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.AvatarUpdateService.1
 * JD-Core Version:    0.7.0.1
 */