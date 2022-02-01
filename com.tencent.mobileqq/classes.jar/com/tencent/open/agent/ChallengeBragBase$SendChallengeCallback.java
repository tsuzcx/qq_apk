package com.tencent.open.agent;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.Constants;
import com.tencent.open.business.base.StaticAnalyz;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class ChallengeBragBase$SendChallengeCallback
  implements HttpCgiAsyncTask.Callback
{
  protected ChallengeBragBase$SendChallengeCallback(ChallengeBragBase paramChallengeBragBase) {}
  
  protected void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(this.a, paramIntent.getStringExtra("key_error_msg"), 0).show();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendChallengeComplete error:{KEY_ERROR_CODE:");
      localStringBuilder.append(i);
      localStringBuilder.append("; KEY_ERROR_MSG:");
      localStringBuilder.append(paramIntent.getStringExtra("key_error_msg"));
      localStringBuilder.append("}");
      LogUtility.e("qqBaseActivity", localStringBuilder.toString());
    }
    this.a.setResult(-1, paramIntent);
    this.a.finish();
  }
  
  public void a(Exception paramException)
  {
    this.a.e();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SendChallenge exception.");
    ((StringBuilder)localObject).append(paramException.getMessage());
    LogUtility.c("qqBaseActivity", ((StringBuilder)localObject).toString(), paramException);
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
    a((Intent)localObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.a.e();
        int j = paramJSONObject.getInt("ret");
        String str = paramJSONObject.getString("msg");
        if (j == 0)
        {
          localObject = null;
          if ("action_brag".equals(this.a.B))
          {
            localObject = "ANDROIDQQ.BRAG.ASSISTANT";
            i = 2131887917;
          }
          else
          {
            if (!"action_challenge".equals(this.a.B)) {
              break label237;
            }
            localObject = "ANDROIDQQ.PK.ASSISTANT";
            i = 2131887918;
          }
          if (localObject != null)
          {
            StaticAnalyz.a("400", (String)localObject, this.a.i, true);
            Toast.makeText(this.a, i, 0).show();
          }
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_error_code", j);
        ((Intent)localObject).putExtra("key_error_msg", str);
        ((Intent)localObject).putExtra("key_response", paramJSONObject.toString());
        a((Intent)localObject);
        return;
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SendChallenge exception.");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        LogUtility.c("qqBaseActivity", ((StringBuilder)localObject).toString(), paramJSONObject);
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", -4);
        paramJSONObject.putExtra("key_error_msg", Constants.b);
        a(paramJSONObject);
        return;
      }
      label237:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeBragBase.SendChallengeCallback
 * JD-Core Version:    0.7.0.1
 */