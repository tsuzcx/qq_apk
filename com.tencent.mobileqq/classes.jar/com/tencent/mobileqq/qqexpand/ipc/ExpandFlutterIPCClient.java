package com.tencent.mobileqq.qqexpand.ipc;

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
import java.nio.charset.StandardCharsets;
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
  public static volatile boolean a = false;
  private static final AtomicInteger b = new AtomicInteger(0);
  private static volatile ExpandFlutterIPCClient c;
  private final Handler d = new Handler(Looper.getMainLooper());
  private final ArrayList<IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener> e = new ArrayList();
  
  private ExpandFlutterIPCClient(String paramString)
  {
    super(paramString);
  }
  
  public static ExpandFlutterIPCClient a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new ExpandFlutterIPCClient("ExpandFlutterIPCClient");
        }
      }
      finally {}
    }
    return c;
  }
  
  @MainThread
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleRedPointEvent redPointNumber=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("expand.ExpandFlutterIPCClient", 4, ((StringBuilder)localObject).toString());
    localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)((Iterator)localObject).next()).a(paramInt);
    }
  }
  
  @MainThread
  private void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePushEvent pushType=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("expand.ExpandFlutterIPCClient", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)((Iterator)localObject).next()).a(paramLong, paramArrayOfByte);
    }
  }
  
  private String b(Map<String, byte[]> paramMap)
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
        localJsonObject.addProperty("sig", new String((byte[])localEntry.getValue(), StandardCharsets.ISO_8859_1));
        localJsonArray.add(localJsonObject);
      }
      paramMap = localJsonArray.toString();
      return paramMap;
    }
    catch (Exception paramMap)
    {
      QLog.e("expand.ExpandFlutterIPCClient", 1, "transformMap2Json fail.", paramMap);
    }
    return "";
  }
  
  public static void b()
  {
    if (!a) {
      try
      {
        QIPCClientHelper.getInstance().register(a());
        a = true;
      }
      catch (Exception localException)
      {
        QLog.d("expand.ExpandFlutterIPCClient", 1, "register", localException);
      }
    }
    QLog.d("expand.ExpandFlutterIPCClient", 1, "register");
    b.addAndGet(1);
  }
  
  public static void c()
  {
    if (b.decrementAndGet() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reference count: ");
      localStringBuilder.append(b.get());
      QLog.d("expand.ExpandFlutterIPCClient", 1, localStringBuilder.toString());
      return;
    }
    try
    {
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        a = false;
      }
      a().e.clear();
    }
    catch (Exception localException)
    {
      QLog.d("expand.ExpandFlutterIPCClient", 1, "unregister", localException);
    }
    QLog.d("expand.ExpandFlutterIPCClient", 1, "unregister");
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
    this.e.add(paramExpandIpcFlutterNotifyListener);
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
    localBundle.putString("matchInfoMap", b(paramMap));
    QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyBatchCreateMessageNodeIfNeed", localBundle);
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
    this.e.remove(paramExpandIpcFlutterNotifyListener);
  }
  
  public int d()
  {
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "getRedPoint", new Bundle());
    if (localEIPCResult == null)
    {
      QLog.e("expand.ExpandFlutterIPCClient", 1, "callGetRedPoint: res is null!");
      return 0;
    }
    return localEIPCResult.data.getInt("redPointNum", 0);
  }
  
  public boolean e()
  {
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "clearRedPoint", new Bundle());
    if (localEIPCResult == null)
    {
      QLog.e("expand.ExpandFlutterIPCClient", 1, "callClearPoint: res is null!");
      return EIPCResult.UNKNOW_RESULT.isSuccess();
    }
    return localEIPCResult.isSuccess();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, action[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("expand.ExpandFlutterIPCClient", 4, localStringBuilder.toString());
    }
    if ("notifyPushEvent".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.1(this, paramBundle));
    }
    if ("notifyRedPointEvent".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.2(this, paramBundle));
    }
    if ("notifyGetExtendFriendInfoResponse".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.3(this, paramBundle));
    } else if ("notifyGetOnLineStateResponse".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.4(this, paramBundle));
    } else if ("notifyUpdateOnlineState".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.5(this, paramBundle));
    } else if ("notifyConversationUpdate".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.6(this, paramBundle));
    } else if ("notifyConversationDelete".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.7(this, paramBundle));
    } else if ("notifyConversationRefresh".equals(paramString)) {
      this.d.post(new ExpandFlutterIPCClient.8(this));
    }
    return null;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient
 * JD-Core Version:    0.7.0.1
 */