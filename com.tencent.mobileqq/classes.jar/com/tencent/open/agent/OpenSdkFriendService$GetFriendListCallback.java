package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.FriendGroup;
import com.tencent.open.agent.datamodel.FriendResponseInfo;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.Constants;
import com.tencent.open.settings.OpensdkPreference;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFriendService$GetFriendListCallback
  implements HttpCgiAsyncTask.Callback
{
  protected final WeakReference<OpenSdkFriendService.GetFriendInfoListener> a;
  
  public OpenSdkFriendService$GetFriendListCallback(OpenSdkFriendService paramOpenSdkFriendService, OpenSdkFriendService.GetFriendInfoListener paramGetFriendInfoListener)
  {
    this.a = new WeakReference(paramGetFriendInfoListener);
  }
  
  public void a(Exception paramException)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GetFriendListCallback exception.");
    ((StringBuilder)localObject).append(paramException.getMessage());
    LogUtility.c("OpenSdkFriendService", ((StringBuilder)localObject).toString(), paramException);
    localObject = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      ((Intent)localObject).putExtra("key_error_code", -7);
      ((Intent)localObject).putExtra("key_error_msg", Constants.e);
    }
    else if ((paramException instanceof SocketTimeoutException))
    {
      ((Intent)localObject).putExtra("key_error_code", -8);
      ((Intent)localObject).putExtra("key_error_msg", Constants.f);
    }
    else if ((paramException instanceof MalformedURLException))
    {
      ((Intent)localObject).putExtra("key_error_code", -3);
      ((Intent)localObject).putExtra("key_error_msg", "访问url有误!");
    }
    else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
    {
      ((Intent)localObject).putExtra("key_error_code", -10);
      ((Intent)localObject).putExtra("key_error_msg", "Http返回码异常!");
    }
    else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
    {
      ((Intent)localObject).putExtra("key_error_code", -9);
      ((Intent)localObject).putExtra("key_error_msg", Constants.g);
    }
    else if ((paramException instanceof JSONException))
    {
      ((Intent)localObject).putExtra("key_error_code", -4);
      ((Intent)localObject).putExtra("key_error_msg", Constants.b);
    }
    else if ((paramException instanceof IOException))
    {
      ((Intent)localObject).putExtra("key_error_code", -2);
      ((Intent)localObject).putExtra("key_error_msg", Constants.a);
    }
    else
    {
      ((Intent)localObject).putExtra("key_error_code", -6);
      ((Intent)localObject).putExtra("key_error_msg", Constants.d);
    }
    paramException = (OpenSdkFriendService.GetFriendInfoListener)this.a.get();
    if (paramException != null) {
      paramException.a((Intent)localObject);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    FriendResponseInfo localFriendResponseInfo = new FriendResponseInfo();
    for (;;)
    {
      try
      {
        localFriendResponseInfo.a = paramJSONObject.getInt("ret");
        localFriendResponseInfo.b = paramJSONObject.getString("msg");
        if (localFriendResponseInfo.a == 0)
        {
          if (paramJSONObject.has("conc_max")) {
            localFriendResponseInfo.e = paramJSONObject.getInt("conc_max");
          }
          if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
          {
            localFriendResponseInfo.c = paramJSONObject.getInt("inv_max");
            localFriendResponseInfo.d = paramJSONObject.getInt("inv_count");
          }
          if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
          {
            localFriendResponseInfo.c = paramJSONObject.getInt("fgmax");
            localFriendResponseInfo.d = paramJSONObject.getInt("fgcur");
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("-->result = ");
          ((StringBuilder)localObject).append(paramJSONObject);
          LogUtility.c("OpenSdkFriendService", ((StringBuilder)localObject).toString());
          localFriendResponseInfo.h = paramJSONObject.optInt("app_rid", -1);
          localFriendResponseInfo.i = paramJSONObject.optInt("app_tid", -1);
          if ("action_invite".equals(this.b.j))
          {
            if (!paramJSONObject.has("md5str")) {
              break label572;
            }
            localObject = paramJSONObject.getString("md5str");
            if (!OpensdkPreference.a(CommonDataAdapter.a().b(), "invite_friend_list_md5").getString(this.b.f, "").equals(localObject))
            {
              paramJSONObject = (ArrayList)FriendGroup.c(paramJSONObject);
              localFriendResponseInfo.f = paramJSONObject;
              ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            }
            else
            {
              localFriendResponseInfo.f = this.b.b();
              if (localFriendResponseInfo.f.size() == 0)
              {
                this.b.h.putString("md5str", "0");
                this.b.a("0");
                paramJSONObject = (OpenSdkFriendService.GetFriendInfoListener)this.a.get();
                if (paramJSONObject == null) {
                  break;
                }
                new HttpCgiAsyncTask(this.b.i, "GET", new GetFriendListCallback(this.b, paramJSONObject), true).a(this.b.h);
              }
            }
          }
          else if ((!"action_gift".equals(this.b.j)) && (!"action_ask".equals(this.b.j)) && (!"action_voice".equals(this.b.j)) && (!"action_reactive".equals(this.b.j)))
          {
            localFriendResponseInfo.f = ((ArrayList)FriendGroup.a(paramJSONObject));
          }
          else
          {
            localFriendResponseInfo.f = ((ArrayList)FriendGroup.b(paramJSONObject));
          }
          paramJSONObject = (OpenSdkFriendService.GetFriendInfoListener)this.a.get();
          if (paramJSONObject != null) {
            paramJSONObject.a(localFriendResponseInfo);
          }
        }
        else
        {
          localFriendResponseInfo.g = paramJSONObject;
          paramJSONObject = new Intent();
          paramJSONObject.putExtra("key_error_code", localFriendResponseInfo.a);
          paramJSONObject.putExtra("key_error_msg", localFriendResponseInfo.b);
          paramJSONObject.putExtra("key_error_detail", localFriendResponseInfo.g.toString());
          localObject = (OpenSdkFriendService.GetFriendInfoListener)this.a.get();
          if (localObject != null)
          {
            ((OpenSdkFriendService.GetFriendInfoListener)localObject).a(paramJSONObject);
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
      }
      return;
      label572:
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback
 * JD-Core Version:    0.7.0.1
 */