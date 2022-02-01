package com.tencent.mobileqq.flutter.channel.zanranking;

import android.os.Bundle;
import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ZanRankingIpcClient
  extends QIPCModule
  implements EIPCResultCallback
{
  WeakReference<ZanRankingIpcClient.ICallback> a = null;
  private volatile boolean b = false;
  
  private ZanRankingIpcClient()
  {
    super("ZanRankingIpcClient");
  }
  
  public static ZanRankingIpcClient a()
  {
    return ZanRankingIpcClient.Holder.a();
  }
  
  public Map<String, String> a(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putStringArrayList("uins", paramArrayList);
    paramArrayList = QIPCClientHelper.getInstance().getClient().callServer("ZanRankingIpcServer", "action_get_frd_nicks", (Bundle)localObject1);
    if (paramArrayList.isSuccess())
    {
      Object localObject2 = paramArrayList.data;
      localObject1 = ((Bundle)localObject2).getStringArrayList("uins");
      localObject2 = ((Bundle)localObject2).getStringArrayList("nicks");
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localHashMap.put(((ArrayList)localObject1).get(i), ((ArrayList)localObject2).get(i));
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ZanRankingIpcClient", 2, String.format("getFrdNicks suc=%b nicks.size=%d", new Object[] { Boolean.valueOf(paramArrayList.isSuccess()), Integer.valueOf(localHashMap.size()) }));
    }
    return localHashMap;
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "action_get_card_cover");
    localBundle.putString("uin", paramString);
    localBundle.putBoolean("fromCache", paramBoolean);
    localBundle.putInt("seq", paramInt);
    QIPCClientHelper.getInstance().getClient().callServer("ZanRankingIpcServer", "action_get_card_cover", localBundle, this);
  }
  
  public void a(ZanRankingIpcClient.ICallback paramICallback)
  {
    if (paramICallback != null) {
      this.a = new WeakReference(paramICallback);
    }
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        return;
      }
      ZanRankingIpcClient localZanRankingIpcClient = a();
      try
      {
        QIPCClientHelper.getInstance().register(localZanRankingIpcClient);
        this.b = true;
        if (QLog.isColorLevel()) {
          QLog.d("ZanRankingIpcClient", 2, "init");
        }
      }
      catch (Exception localException)
      {
        QLog.e("ZanRankingIpcClient", 1, "register ipc module error.", localException);
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        try
        {
          if (QIPCClientHelper.getInstance().getClient() != null)
          {
            QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
            this.b = false;
            if (QLog.isColorLevel()) {
              QLog.d("ZanRankingIpcClient", 2, "unInit");
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("ZanRankingIpcClient", 1, "unregister ipc module error.", localException);
        }
      }
      return;
    }
    finally {}
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
      QLog.d("ZanRankingIpcClient", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
        {
          paramEIPCResult = paramEIPCResult.data;
          String str = paramEIPCResult.getString("action", "");
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onCallback result action= ");
          ((StringBuilder)localObject).append(str);
          QLog.d("ZanRankingIpcClient", 1, ((StringBuilder)localObject).toString());
          if (str.equals("action_get_card_cover"))
          {
            int i = paramEIPCResult.getInt("seq");
            str = paramEIPCResult.getString("uin");
            boolean bool = paramEIPCResult.getBoolean("fromCache");
            localObject = new CardCoverData(paramEIPCResult.getInt("type"), paramEIPCResult.getString("text"));
            if (this.a == null) {
              break label163;
            }
            paramEIPCResult = (ZanRankingIpcClient.ICallback)this.a.get();
            if (paramEIPCResult != null) {
              paramEIPCResult.a(i, str, bool, (CardCoverData)localObject);
            }
          }
        }
        return;
      }
      catch (Exception paramEIPCResult)
      {
        return;
      }
      label163:
      paramEIPCResult = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcClient
 * JD-Core Version:    0.7.0.1
 */