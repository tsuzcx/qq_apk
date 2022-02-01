package com.tencent.open.base.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import atwl;
import bitk;
import bitl;
import bitv;
import bitw;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class AvatarUpdateService$1
  implements Runnable
{
  public AvatarUpdateService$1(bitk parambitk, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext, bitw parambitw) {}
  
  public void run()
  {
    Object localObject1 = new DefaultHttpClient();
    int i;
    int j;
    try
    {
      ??? = new HttpGet(MsfSdkUtils.insertMtype("yingyongbao", this.jdField_a_of_type_JavaLangString));
      ((HttpGet)???).addHeader("Cookie", this.b);
      localObject1 = EntityUtils.toString(((HttpClient)localObject1).execute((HttpUriRequest)???).getEntity(), "utf-8");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--jsonp is empty");
        return;
      }
      i = ((String)localObject1).indexOf('{');
      j = ((String)localObject1).lastIndexOf('}');
      if ((i < 0) || (i > j) || (j < 0))
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--can not find json string");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AvatarUpdateService", 1, new Object[] { "-->updateAvatar---", localException.getMessage() });
      return;
    }
    String str = new JSONObject(localException.substring(i, j + 1)).getString(this.c);
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AvatarUpdateService", 1, "-->updateAvatar--image url is empty");
      return;
    }
    ??? = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.c, "");
    if ((!atwl.a(this.d)) || (!str.equals(???)))
    {
      QLog.d("AvatarUpdateService", 1, "-->updateAvatar--avatar not exist or need update, will download new avatar");
      synchronized (this.this$0.jdField_a_of_type_JavaUtilHashMap)
      {
        if (!this.this$0.jdField_a_of_type_JavaUtilHashMap.containsKey(this.c))
        {
          this.this$0.jdField_a_of_type_JavaUtilHashMap.put(this.c, new bitl(this.this$0, this.jdField_a_of_type_AndroidContentContext, this.c, this.d, str, this.jdField_a_of_type_Bitw));
          new bitv(this.c, str, null, "GET", this.this$0).execute(new Void[0]);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.http.AvatarUpdateService.1
 * JD-Core Version:    0.7.0.1
 */