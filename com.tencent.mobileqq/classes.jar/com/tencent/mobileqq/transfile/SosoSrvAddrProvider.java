package com.tencent.mobileqq.transfile;

import ConfigPush.FileStorageServerListInfo;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.transfile.svraddr.ISvrAddr;
import com.tencent.mobileqq.transfile.svraddr.SvrAddr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class SosoSrvAddrProvider
{
  public static final String ACTION_SOSO = "com.tencent.receiver.soso";
  public static int ACTION_SOSO_TYPE_CLEAR = ACTION_SOSO_TYPE_UPDATE + 1;
  public static final String ACTION_SOSO_TYPE_KEY = "com.tencent.receiver.soso.type";
  public static int ACTION_SOSO_TYPE_UPDATE = 0;
  public static final String TAG = "SosoSrvAddrProvider";
  private static SosoSrvAddrProvider sInstance;
  Application app;
  private boolean bFetchedHttpsList;
  SosoSrvAddrProvider.SrvAddrChooser mChooser = new SosoSrvAddrProvider.SrvAddrChooser(this);
  private List<ISvrAddr> mSvcList;
  
  private SosoSrvAddrProvider(Application paramApplication)
  {
    this.app = paramApplication;
  }
  
  public static SosoSrvAddrProvider getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new SosoSrvAddrProvider(BaseApplicationImpl.getApplication());
      }
      return sInstance;
    }
    finally {}
  }
  
  private List<ISvrAddr> getSvcList(int paramInt)
  {
    if (paramInt == 0) {
      return this.mSvcList;
    }
    return null;
  }
  
  public void clear()
  {
    try
    {
      setSvcList(null);
      this.mChooser.clear();
      QLog.d("SosoSrvAddrProvider", 1, "FMT SERVER LIST CLEARED!!!");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearSpAndBrocast()
  {
    Object localObject = this.app.getSharedPreferences("SosoSrvAddrList", 0).edit();
    if (localObject != null) {
      ((SharedPreferences.Editor)localObject).remove("SosoSrvAddrList_key").commit();
    }
    localObject = new Intent("com.tencent.receiver.soso");
    ((Intent)localObject).putExtra("com.tencent.receiver.soso.type", ACTION_SOSO_TYPE_CLEAR);
    this.app.sendBroadcast((Intent)localObject);
  }
  
  public String getSrvAddr(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        ISvrAddr localISvrAddr = this.mChooser.getAddr(paramInt, paramBoolean1);
        if (localISvrAddr != null)
        {
          str = localISvrAddr.getIp();
          paramInt = localISvrAddr.getPort();
          localObject1 = str;
          if (str == null) {
            localObject1 = "";
          }
          if ((((String)localObject1).indexOf(':') < 0) || (((String)localObject1).startsWith("["))) {
            break label156;
          }
          localObject1 = "[" + (String)localObject1 + "]";
          break label156;
          localObject1 = str + (String)localObject1 + ":" + paramInt + "/";
        }
        return localObject1;
      }
      finally {}
      String str = "http://";
      continue;
      label156:
      if (paramBoolean2) {
        str = "https://";
      }
    }
  }
  
  public String getSrvAddrHttps(AppInterface paramAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = null;
    if (paramAppInterface == null) {
      paramAppInterface = (AppInterface)localObject;
    }
    for (;;)
    {
      return paramAppInterface;
      String str = "";
      for (;;)
      {
        try
        {
          localObject = ConfigManager.getInstance(BaseApplication.getContext(), paramAppInterface.getHwEngine());
          if (localObject == null) {
            break label292;
          }
          localObject = ((ConfigManager)localObject).getOtherTypeIp(paramAppInterface.getApp().getBaseContext(), 21, paramBoolean1);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            paramAppInterface = ((EndPoint)((List)localObject).get(0)).host;
            paramInt = ((EndPoint)((List)localObject).get(0)).port;
            if ((TextUtils.isEmpty(paramAppInterface)) || (paramInt == -1)) {
              break label276;
            }
            if ((paramAppInterface.indexOf(':') >= 0) && (!paramAppInterface.startsWith("[")))
            {
              paramAppInterface = "[" + paramAppInterface + "]";
              break label298;
              paramAppInterface = (String)localObject + paramAppInterface + ":" + paramInt + "/";
              break;
            }
          }
          else
          {
            if ((!this.bFetchedHttpsList) && (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())))
            {
              HwServlet.getConfig(paramAppInterface, paramAppInterface.getCurrentAccountUin());
              this.bFetchedHttpsList = true;
            }
            localObject = this.mChooser.getAddr(paramInt, paramBoolean1);
            if (localObject == null) {
              break label281;
            }
            paramAppInterface = ((ISvrAddr)localObject).getIp();
            paramInt = ((ISvrAddr)localObject).getPort();
            paramBoolean2 = false;
            continue;
            localObject = "http://";
            continue;
          }
        }
        finally {}
        label276:
        paramAppInterface = null;
        break;
        label281:
        paramInt = -1;
        paramBoolean2 = false;
        paramAppInterface = str;
        continue;
        label292:
        localObject = null;
        continue;
        label298:
        if (paramBoolean2) {
          localObject = "https://";
        }
      }
    }
  }
  
  public void init()
  {
    ArrayList localArrayList = new ArrayList();
    HwConfig localHwConfig = FMTSrvAddrProvider.getInstance().getHighwayConfig();
    if (localHwConfig != null)
    {
      int i;
      SvrAddr localSvrAddr;
      if ((localHwConfig.ipv6List != null) && (localHwConfig.ipv6List.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipv6List.size())
        {
          localSvrAddr = new SvrAddr();
          localSvrAddr.ip = ((EndPoint)localHwConfig.ipv6List.get(i)).host;
          localSvrAddr.port = ((EndPoint)localHwConfig.ipv6List.get(i)).port;
          localSvrAddr.bIpv6 = true;
          localArrayList.add(localSvrAddr);
          i += 1;
        }
      }
      if ((localHwConfig.ipList != null) && (localHwConfig.ipList.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipList.size())
        {
          localSvrAddr = new SvrAddr();
          localSvrAddr.ip = ((EndPoint)localHwConfig.ipList.get(i)).host;
          localSvrAddr.port = ((EndPoint)localHwConfig.ipList.get(i)).port;
          localSvrAddr.bIpv6 = false;
          localArrayList.add(localSvrAddr);
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SosoSrvAddrProvider", 2, String.format("init iplist=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    setSvcList(localArrayList);
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    try
    {
      this.mChooser.onFailed(paramInt, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  @NotNull
  public List<ISvrAddr> readFromSp()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.app;
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((Application)localObject).getSharedPreferences("SosoSrvAddrList", i).getString("SosoSrvAddrList_key", null);
      if (localObject == null) {
        return localArrayList;
      }
      localObject = ((String)localObject).split("\\|");
      i = 0;
      label53:
      if (i >= localObject.length) {
        return localArrayList;
      }
      String[] arrayOfString = localObject[i].split("\\:");
      if (arrayOfString.length != 2) {
        break label129;
      }
      SvrAddr localSvrAddr = new SvrAddr();
      localSvrAddr.ip = arrayOfString[0];
      localSvrAddr.port = Integer.valueOf(arrayOfString[1]).intValue();
      localArrayList.add(localSvrAddr);
    }
    for (;;)
    {
      i += 1;
      break label53;
      i = 0;
      break;
      label129:
      if (QLog.isColorLevel()) {
        QLog.e("SosoSrvAddrProvider", 2, "ip info datais error,please check the push ipList data");
      }
    }
    return localArrayList;
  }
  
  public void setSvcList(List<ISvrAddr> paramList)
  {
    try
    {
      this.mSvcList = paramList;
      this.mChooser.init(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void writeToSp(ArrayList<FileStorageServerListInfo> paramArrayList)
  {
    Object localObject = this.app;
    if (Build.VERSION.SDK_INT > 10) {}
    StringBuilder localStringBuilder;
    for (int i = 4;; i = 0)
    {
      localObject = ((Application)localObject).getSharedPreferences("SosoSrvAddrList", i);
      if (paramArrayList == null) {
        return;
      }
      localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)paramArrayList.next();
        localStringBuilder.append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append("|");
      }
    }
    ((SharedPreferences)localObject).edit().putString("SosoSrvAddrList_key", localStringBuilder.toString()).commit();
    paramArrayList = new Intent("com.tencent.receiver.soso");
    paramArrayList.putExtra("com.tencent.receiver.soso.type", ACTION_SOSO_TYPE_UPDATE);
    this.app.sendBroadcast(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SosoSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */