package com.tencent.open.agent;

import aljw;
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
  protected final WeakReference a;
  
  public OpenSdkFriendService$GetFriendListCallback(OpenSdkFriendService paramOpenSdkFriendService, OpenSdkFriendService.GetFriendInfoListener paramGetFriendInfoListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGetFriendInfoListener);
  }
  
  public void a(Exception paramException)
  {
    LogUtility.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", "网络连接超时!");
    }
    for (;;)
    {
      paramException = (OpenSdkFriendService.GetFriendInfoListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", "网络连接超时!");
      }
      else if ((paramException instanceof MalformedURLException))
      {
        localIntent.putExtra("key_error_code", -3);
        localIntent.putExtra("key_error_msg", "访问url有误!");
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        localIntent.putExtra("key_error_code", -10);
        localIntent.putExtra("key_error_msg", "Http返回码异常!");
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        localIntent.putExtra("key_error_code", -9);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", "服务器返回数据格式有误!");
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", "未知错误!");
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    FriendResponseInfo localFriendResponseInfo = new FriendResponseInfo();
    for (;;)
    {
      Object localObject;
      try
      {
        localFriendResponseInfo.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localFriendResponseInfo.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localFriendResponseInfo.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localFriendResponseInfo.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localFriendResponseInfo.b = paramJSONObject.getInt("inv_max");
          localFriendResponseInfo.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localFriendResponseInfo.b = paramJSONObject.getInt("fgmax");
          localFriendResponseInfo.c = paramJSONObject.getInt("fgcur");
        }
        LogUtility.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localFriendResponseInfo.e = paramJSONObject.optInt("app_rid", -1);
        localFriendResponseInfo.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!OpensdkPreference.a(CommonDataAdapter.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)FriendGroup.c(paramJSONObject);
            localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new aljw(this, paramJSONObject, (String)localObject));
            paramJSONObject = (OpenSdkFriendService.GetFriendInfoListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localFriendResponseInfo);
            return;
          }
          localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a();
          if (localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a.putString("md5str", "0");
          this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a("0");
          paramJSONObject = (OpenSdkFriendService.GetFriendInfoListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new HttpCgiAsyncTask(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.c, "GET", new GetFriendListCallback(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService, paramJSONObject)).a(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.d)) || ("action_ask".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.d)) || ("action_voice".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.d)) || ("action_reactive".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.d)))
      {
        localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)FriendGroup.b(paramJSONObject));
      }
      else
      {
        localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)FriendGroup.a(paramJSONObject));
        continue;
        label486:
        localFriendResponseInfo.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localFriendResponseInfo.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localFriendResponseInfo.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localFriendResponseInfo.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (OpenSdkFriendService.GetFriendInfoListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((OpenSdkFriendService.GetFriendInfoListener)localObject).a(paramJSONObject);
        }
        label558:
        return;
        label559:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback
 * JD-Core Version:    0.7.0.1
 */