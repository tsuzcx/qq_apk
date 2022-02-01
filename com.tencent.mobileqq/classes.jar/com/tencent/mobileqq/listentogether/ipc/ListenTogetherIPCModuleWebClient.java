package com.tencent.mobileqq.listentogether.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ListenTogetherIPCModuleWebClient
  extends QIPCModule
{
  private ArrayList<ListenTogetherIPCModuleWebClient.ListenTogetherClient2WebCallback> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  private ListenTogetherIPCModuleWebClient()
  {
    super("ListenTogetherIPCModuleWebClient");
  }
  
  public static ListenTogetherIPCModuleWebClient a()
  {
    return ListenTogetherIPCModuleWebClient.Holder.a();
  }
  
  private EIPCResult a(String arg1, Bundle paramBundle, int paramInt)
  {
    if ("action_status_changed".equals(???))
    {
      if (paramBundle == null) {
        return null;
      }
      paramBundle = paramBundle.getString("data");
      Object localObject;
      try
      {
        paramBundle = new JSONObject(paramBundle);
      }
      catch (JSONException paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("statusChanged error:");
        ((StringBuilder)localObject).append(paramBundle.getMessage());
        QLog.i("ListenTogetherIPCModuleWebClient", 1, ((StringBuilder)localObject).toString());
        paramBundle = null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("statusChanged action:");
        ((StringBuilder)localObject).append(???);
        ((StringBuilder)localObject).append(" data=");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.d("ListenTogetherIPCModuleWebClient", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBundle != null) {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ListenTogetherIPCModuleWebClient.ListenTogetherClient2WebCallback localListenTogetherClient2WebCallback = (ListenTogetherIPCModuleWebClient.ListenTogetherClient2WebCallback)((Iterator)localObject).next();
            if (localListenTogetherClient2WebCallback != null) {
              localListenTogetherClient2WebCallback.a(paramBundle);
            }
          }
          ??? = new EIPCResult();
          ???.code = 0;
          return ???;
        }
      }
    }
    return null;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", "action_status_changed", localBundle, null);
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", paramString, localBundle, paramEIPCResultCallback);
  }
  
  public void a(ListenTogetherIPCModuleWebClient.ListenTogetherClient2WebCallback paramListenTogetherClient2WebCallback)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("register callback:");
      ((StringBuilder)localObject).append(paramListenTogetherClient2WebCallback);
      QLog.d("ListenTogetherIPCModuleWebClient", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramListenTogetherClient2WebCallback)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localObject = a();
      try
      {
        QIPCClientHelper.getInstance().register((QIPCModule)localObject);
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogetherIPCModuleWebClient", 2, "register real");
        }
      }
      catch (Exception localException)
      {
        QLog.e("ListenTogetherIPCModuleWebClient", 1, "register ipc module error.", localException);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramListenTogetherClient2WebCallback);
      if (QLog.isColorLevel())
      {
        paramListenTogetherClient2WebCallback = new StringBuilder();
        paramListenTogetherClient2WebCallback.append("register mListenTogetherClient2WebCallbacks.size:");
        paramListenTogetherClient2WebCallback.append(this.jdField_a_of_type_JavaUtilArrayList.size());
        QLog.d("ListenTogetherIPCModuleWebClient", 2, paramListenTogetherClient2WebCallback.toString());
      }
      return;
    }
  }
  
  public void b(ListenTogetherIPCModuleWebClient.ListenTogetherClient2WebCallback paramListenTogetherClient2WebCallback)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("unregister callback:");
      ((StringBuilder)???).append(paramListenTogetherClient2WebCallback);
      ((StringBuilder)???).append(" mHasRegistered:");
      ((StringBuilder)???).append(this.jdField_a_of_type_Boolean);
      QLog.d("ListenTogetherIPCModuleWebClient", 2, ((StringBuilder)???).toString());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramListenTogetherClient2WebCallback)) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramListenTogetherClient2WebCallback);
      }
    }
    if (QLog.isColorLevel())
    {
      paramListenTogetherClient2WebCallback = new StringBuilder();
      paramListenTogetherClient2WebCallback.append("unregister mListenTogetherClient2WebCallbacks.size:");
      paramListenTogetherClient2WebCallback.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("ListenTogetherIPCModuleWebClient", 2, paramListenTogetherClient2WebCallback.toString());
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Boolean)) {
      try
      {
        if (QIPCClientHelper.getInstance().getClient() != null)
        {
          QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
          this.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel())
          {
            QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister real");
            return;
          }
        }
      }
      catch (Exception paramListenTogetherClient2WebCallback)
      {
        QLog.e("ListenTogetherIPCModuleWebClient", 1, "unregister ipc module error.", paramListenTogetherClient2WebCallback);
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, params=");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(", action=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", callBackId=");
      localStringBuilder.append(paramInt);
      QLog.d("ListenTogetherIPCModuleWebClient", 2, localStringBuilder.toString());
    }
    if (paramBundle == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCall, param is null, action=");
      paramBundle.append(paramString);
      paramBundle.append(", callBackId=");
      paramBundle.append(paramInt);
      QLog.i("ListenTogetherIPCModuleWebClient", 1, paramBundle.toString());
      return null;
    }
    if ("action_status_changed".equals(paramString)) {
      return a(paramString, paramBundle, paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient
 * JD-Core Version:    0.7.0.1
 */