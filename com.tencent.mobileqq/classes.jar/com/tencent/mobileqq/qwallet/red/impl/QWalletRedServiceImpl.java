package com.tencent.mobileqq.qwallet.red.impl;

import Wallet.RedInfo;
import Wallet.RedInfoSyncReq;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.qwallet.ipc.impl.ComIPCUtilsImpl;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;

public class QWalletRedServiceImpl
  implements IQWalletConfigService.ConfigUpdateListener, IQWalletRedService
{
  private static final String TAG = "QWalletRedService";
  private BaseQQAppInterface mApp;
  private QWRedConfig mConfig;
  
  public static void doClickIPC(String paramString)
  {
    if (!(QWalletHelperImpl.getAppRuntime() instanceof BaseQQAppInterface)) {
      ComIPCUtilsImpl.redPointDoClick(paramString);
    }
  }
  
  private void syncData()
  {
    ThreadManager.executeOnSubThread(new QWalletRedServiceImpl.1(this));
  }
  
  public void doClick(String paramString)
  {
    List localList = this.mConfig.getCurShowRedInfosByPath(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doClick");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(localList);
      QLog.d("QWalletRedService", 2, ((StringBuilder)localObject).toString());
    }
    paramString = new LinkedList();
    Object localObject = localList.iterator();
    QWRedConfig.RedInfo localRedInfo;
    while (((Iterator)localObject).hasNext())
    {
      localRedInfo = (QWRedConfig.RedInfo)((Iterator)localObject).next();
      if (localRedInfo.doClick()) {
        paramString.add(localRedInfo);
      }
    }
    if (paramString.size() > 0)
    {
      this.mConfig.saveConfig();
      localObject = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localRedInfo = (QWRedConfig.RedInfo)paramString.next();
        ((ArrayList)localObject).add(new RedInfo(localRedInfo.path, localRedInfo.taskId, localRedInfo.isShow));
      }
      QWalletCommonServlet.a(new RedInfoSyncReq(1, DeviceInfoUtil.c(), DeviceInfoUtil.e(), DeviceInfoUtil.i(), (ArrayList)localObject), new QWalletRedServiceImpl.2(this));
    }
    if (localList.size() > 0) {
      VACDReportUtil.a(null, "QWalletStat", "QWalletRedClick", "QWalletRedClick", QWRedConfig.RedInfo.transToReportStr(localList), 0, null);
    }
  }
  
  public void doShowReport(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    doShowReport(localLinkedList);
  }
  
  public void doShowReport(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localLinkedList.addAll(this.mConfig.getCurShowRedInfosByPath(str));
    }
    if (localLinkedList.size() > 0) {
      VACDReportUtil.a(null, "QWalletStat", "QWalletRedShow", "QWalletRedShow", QWRedConfig.RedInfo.transToReportStr(localLinkedList), 0, null);
    }
  }
  
  public String getNotShowListStr()
  {
    return this.mConfig.getNotShowListStr();
  }
  
  public IQWalletRedService.ShowInfo getShowInfo(String paramString)
  {
    IQWalletRedService.ShowInfo localShowInfo = this.mConfig.getShowInfoByPath(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getShowInfo path=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",res=");
      localStringBuilder.append(localShowInfo);
      QLog.d("QWalletRedService", 2, localStringBuilder.toString());
    }
    return localShowInfo;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedService", 2, "QWalletRedServiceImpl init");
    }
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
    this.mConfig = QWRedConfig.readConfig(this.mApp);
    syncData();
  }
  
  public void onDestroy()
  {
    IQWalletConfigService localIQWalletConfigService = (IQWalletConfigService)this.mApp.getRuntimeService(IQWalletConfigService.class, "");
    if (localIQWalletConfigService != null) {
      localIQWalletConfigService.unRegisterUpdateListener("redPoint", this);
    }
  }
  
  public void onUpdate(String paramString1, String paramString2, ConfigInfo paramConfigInfo)
  {
    this.mConfig.parseConfig(paramConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.impl.QWalletRedServiceImpl
 * JD-Core Version:    0.7.0.1
 */