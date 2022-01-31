package com.tencent.open.base.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import arso;
import bfmb;
import bfmc;
import bfmm;
import bfmn;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarUpdateService$1
  implements Runnable
{
  public AvatarUpdateService$1(bfmb parambfmb, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext, bfmn parambfmn) {}
  
  public void run()
  {
    Object localObject1 = new DefaultHttpClient();
    label346:
    try
    {
      ??? = new HttpGet(MsfSdkUtils.insertMtype("yingyongbao", this.jdField_a_of_type_JavaLangString));
      ((HttpGet)???).addHeader("Cookie", this.b);
      localObject1 = EntityUtils.toString(((HttpClient)localObject1).execute((HttpUriRequest)???).getEntity(), "utf-8");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarUpdateService", 1, "-->updateAvatar--jsonp is empty");
        }
      }
      else
      {
        i = ((String)localObject1).indexOf('{');
        j = ((String)localObject1).lastIndexOf('}');
        if ((i < 0) || (i > j) || (j < 0))
        {
          if (!QLog.isColorLevel()) {
            break label346;
          }
          QLog.e("AvatarUpdateService", 1, "-->updateAvatar--can not find json string");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      int i;
      int j;
      if (QLog.isColorLevel())
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--parse json failed");
        return;
        String str = new JSONObject(localJSONException.substring(i, j + 1)).getString(this.c);
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.e("AvatarUpdateService", 1, "-->updateAvatar--image url is empty");
          }
        }
        else
        {
          ??? = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.c, "");
          if ((!arso.a(this.d)) || (!str.equals(???)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AvatarUpdateService", 2, "-->updateAvatar--avatar not exist or need update, will download new avatar");
            }
            synchronized (this.this$0.jdField_a_of_type_JavaUtilHashMap)
            {
              if (!this.this$0.jdField_a_of_type_JavaUtilHashMap.containsKey(this.c))
              {
                this.this$0.jdField_a_of_type_JavaUtilHashMap.put(this.c, new bfmc(this.this$0, this.jdField_a_of_type_AndroidContentContext, this.c, this.d, str, this.jdField_a_of_type_Bfmn));
                new bfmm(this.c, str, null, "GET", this.this$0).execute(new Void[0]);
              }
              return;
            }
          }
        }
      }
    }
    catch (ParseException localParseException) {}catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.http.AvatarUpdateService.1
 * JD-Core Version:    0.7.0.1
 */