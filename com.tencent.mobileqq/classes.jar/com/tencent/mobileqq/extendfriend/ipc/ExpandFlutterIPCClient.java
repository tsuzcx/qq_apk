package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ExpandFlutterIPCClient
  extends QIPCModule
  implements EIPCResultCallback
{
  private static volatile ExpandFlutterIPCClient jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCClient;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public static volatile boolean a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ArrayList<IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  private ExpandFlutterIPCClient(String paramString)
  {
    super(paramString);
  }
  
  public static ExpandFlutterIPCClient a()
  {
    if (jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCClient == null) {
        jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCClient = new ExpandFlutterIPCClient("ExpandFlutterIPCClient");
      }
      return jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCClient;
    }
    finally {}
  }
  
  private String a(Map<String, byte[]> paramMap)
  {
    try
    {
      JsonArray localJsonArray = new JsonArray(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("uin", (String)localEntry.getKey());
        localJsonObject.addProperty("sig", new String((byte[])localEntry.getValue(), Charset.forName("ISO-8859-1")));
        localJsonArray.add(localJsonObject);
      }
      paramMap = localJsonArray.toString();
    }
    catch (Exception paramMap)
    {
      QLog.e("expand.ExpandFlutterIPCClient", 1, "transformMap2Json fail.", paramMap);
      return "";
    }
    return paramMap;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      QIPCClientHelper.getInstance().register(a());
      jdField_a_of_type_Boolean = true;
      QLog.d("expand.ExpandFlutterIPCClient", 1, "register");
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("expand.ExpandFlutterIPCClient", 1, "register", localException);
      }
    }
  }
  
  @MainThread
  private void a(int paramInt)
  {
    QLog.d("expand.ExpandFlutterIPCClient", 4, "handleRedPointEvent redPointNumber=" + paramInt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)localIterator.next()).a(paramInt);
    }
  }
  
  @MainThread
  private void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.ExpandFlutterIPCClient", 2, "handlePushEvent pushType=" + paramLong);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)localIterator.next()).a(paramLong, paramArrayOfByte);
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0)
    {
      QLog.d("expand.ExpandFlutterIPCClient", 1, "reference count: " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      return;
    }
    try
    {
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        jdField_a_of_type_Boolean = false;
      }
      a().jdField_a_of_type_JavaUtilArrayList.clear();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("expand.ExpandFlutterIPCClient", 1, "unregister", localException);
      }
    }
    QLog.d("expand.ExpandFlutterIPCClient", 1, "unregister");
  }
  
  public int a()
  {
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "getRedPoint", new Bundle());
    if (localEIPCResult == null)
    {
      QLog.e("expand.ExpandFlutterIPCClient", 1, "callGetRedPoint: res is null!");
      return 0;
    }
    return localEIPCResult.data.getInt("redPointNum", 0);
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    return QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", paramString, paramBundle).data;
  }
  
  public void a(IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener paramExpandIpcFlutterNotifyListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.ExpandFlutterIPCClient", 1, "addUpdateListener");
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramExpandIpcFlutterNotifyListener);
  }
  
  public void a(EIPCResultCallback paramEIPCResultCallback)
  {
    a("notifyGetMatchSwitch", new Bundle(), paramEIPCResultCallback);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("match_uin", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "METHOD_CREATE_MESSAGE_NODE_IF_NEED", localBundle);
  }
  
  public void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  public void a(String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("plan", paramString);
    a("notifySetTABTestPlan", localBundle, paramEIPCResultCallback);
  }
  
  public void a(Map<String, byte[]> paramMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("matchInfoMap", a(paramMap));
    QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyBatchCreateMessageNodeIfNeed", localBundle);
  }
  
  public boolean a()
  {
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "clearRedPoint", new Bundle());
    if (localEIPCResult == null)
    {
      QLog.e("expand.ExpandFlutterIPCClient", 1, "callClearPoint: res is null!");
      return EIPCResult.UNKNOW_RESULT.isSuccess();
    }
    return localEIPCResult.isSuccess();
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("match_uin", paramString);
    localBundle.putInt("from_page", paramInt1);
    localBundle.putInt("match_type", paramInt2);
    localBundle.putInt("accost_type", paramInt3);
    localBundle.putInt("is_passive", paramInt4);
    localBundle.putInt("choose_condition", paramInt5);
    localBundle.putInt("dating_purpose", paramInt6);
    localBundle.putByteArray("sig", paramArrayOfByte);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyOpenAio", localBundle);
    if (paramString == null)
    {
      QLog.e("expand.ExpandFlutterIPCClient", 1, "callFlutterOpenAio: res is null!");
      return EIPCResult.UNKNOW_RESULT.isSuccess();
    }
    return paramString.isSuccess();
  }
  
  public void b(IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener paramExpandIpcFlutterNotifyListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.ExpandFlutterIPCClient", 1, "removeUpdateListener");
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramExpandIpcFlutterNotifyListener);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("expand.ExpandFlutterIPCClient", 4, "onCall, action[" + paramString + "]");
    }
    if ("notifyPushEvent".equals(paramString)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.1(this, paramBundle));
    }
    if ("notifyRedPointEvent".equals(paramString)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.2(this, paramBundle));
    }
    if ("notifyGetExtendFriendInfoResponse".equals(paramString)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.3(this, paramBundle));
    }
    for (;;)
    {
      return null;
      if ("notifyGetOnLineStateResponse".equals(paramString)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.4(this, paramBundle));
      } else if ("notifyUpdateOnlineState".equals(paramString)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.5(this, paramBundle));
      } else if ("notifyConversationUpdate".equals(paramString)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.6(this, paramBundle));
      } else if ("notifyConversationDelete".equals(paramString)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.7(this, paramBundle));
      } else if ("notifyConversationRefresh".equals(paramString)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new ExpandFlutterIPCClient.8(this));
      }
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient
 * JD-Core Version:    0.7.0.1
 */