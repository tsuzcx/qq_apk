package com.tencent.mobileqq.flashshow.manager;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.helper.FSGlobalInfoHelper;
import com.tencent.mobileqq.flashshow.request.FSGetTabListRequest;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class FSMainTabInfoManager
{
  private static volatile FSMainTabInfoManager d;
  private final ConcurrentHashMap<String, List<QQCircleFeedBase.StTabInfo>> a = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
  private final int c = FSConfig.b();
  
  public FSMainTabInfoManager()
  {
    c();
    d();
  }
  
  public static FSMainTabInfoManager a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new FSMainTabInfoManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void a(FSGetTabListRequest paramFSGetTabListRequest)
  {
    VSNetworkHelper.getInstance().sendRequest(paramFSGetTabListRequest, new FSMainTabInfoManager.2(this));
  }
  
  private void a(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      int i = ((Integer)this.b.get(paramString)).intValue();
      FSGlobalInfoHelper.a(i);
      QLog.d("FSMainTabInfoManager", 1, new Object[] { "setJumpTabType:", Integer.valueOf(i) });
    }
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    QQCircleFeedBase.StTabInfo localStTabInfo = new QQCircleFeedBase.StTabInfo();
    localStTabInfo.sourceType.set(41);
    localStTabInfo.tabName.set(FSHardCodeUtil.a(2131889722));
    localStTabInfo.serverCallee.set("QflashSvr.trpc.qflash.commreader.ComReader.GetFeedListRecom");
    localStTabInfo.dtPgID.set("pg_ks_explore_page");
    paramList.add(localStTabInfo);
  }
  
  private void a(QQCircleFeedBase.StBusiInfoData paramStBusiInfoData)
  {
    if (paramStBusiInfoData != null)
    {
      if (!paramStBusiInfoData.tabInfos.has()) {
        return;
      }
      List localList = paramStBusiInfoData.tabInfos.get();
      int i = b(paramStBusiInfoData);
      RFThreadManager.getUIHandler().post(new FSMainTabInfoManager.3(this, i, localList));
    }
  }
  
  private int b(QQCircleFeedBase.StBusiInfoData paramStBusiInfoData)
  {
    if (!paramStBusiInfoData.defaultTabSourceType.has())
    {
      QLog.d("FSMainTabInfoManager", 1, "parseJumpTabType defaultTabIndex not set,use default");
      return this.c;
    }
    return paramStBusiInfoData.defaultTabSourceType.get();
  }
  
  public static void b()
  {
    QLog.d("FSMainTabInfoManager", 1, "releaseInstance");
    if (d != null) {
      try
      {
        if (d != null) {
          d = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void b(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    QQCircleFeedBase.StTabInfo localStTabInfo = new QQCircleFeedBase.StTabInfo();
    localStTabInfo.sourceType.set(40);
    localStTabInfo.tabName.set(FSHardCodeUtil.a(2131889721));
    localStTabInfo.serverCallee.set("QflashSvr.trpc.qflash.commreader.ComReader.GetFeedListFollow");
    localStTabInfo.dtPgID.set("pg_ks_following_page");
    paramList.add(localStTabInfo);
  }
  
  private boolean b(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTabInfo in ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" level");
      QLog.d("FSMainTabInfoManager", 1, localStringBuilder.toString());
      a(paramString);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    ArrayList localArrayList = new ArrayList();
    b(localArrayList);
    a(localArrayList);
    this.a.put("default", localArrayList);
    this.b.put("default", Integer.valueOf(this.c));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDefaultTabInfo size:");
    localStringBuilder.append(localArrayList.size());
    localStringBuilder.append(",jumpTabType:");
    localStringBuilder.append(this.c);
    QLog.d("FSMainTabInfoManager", 1, localStringBuilder.toString());
  }
  
  private void d()
  {
    QQCircleFeedBase.StBusiInfoData localStBusiInfoData = FSConfig.c();
    if ((localStBusiInfoData != null) && (!localStBusiInfoData.tabInfos.isEmpty()))
    {
      this.a.put("cache", localStBusiInfoData.tabInfos.get());
      int i = b(localStBusiInfoData);
      this.b.put("cache", Integer.valueOf(i));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initCacheTabInfo done,size:");
      localStringBuilder.append(localStBusiInfoData.tabInfos.size());
      localStringBuilder.append(",jumpTabType:");
      localStringBuilder.append(i);
      QLog.d("FSMainTabInfoManager", 1, localStringBuilder.toString());
      return;
    }
    QLog.e("FSMainTabInfoManager", 1, "initCacheTabInfo error,no cache tabInfo data");
  }
  
  private void e()
  {
    QLog.i("FSMainTabInfoManager", 1, "fetchNewDataFromPreload");
    PreLoader.addListener("3002", new FSMainTabInfoManager.1(this));
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2, FSFolderBean paramFSFolderBean)
  {
    boolean bool = PreLoader.exists("3002");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchNewData from Preload:");
    localStringBuilder.append(bool);
    QLog.d("FSMainTabInfoManager", 1, localStringBuilder.toString());
    if (bool)
    {
      e();
      return;
    }
    b(paramStGPSV2, paramFSFolderBean);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetBusiInfoRsp != null))
    {
      paramString = new QQCircleFeedBase.StBusiInfoData();
      paramStGetBusiInfoRsp = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
      try
      {
        paramString.mergeFrom(paramStGetBusiInfoRsp);
        FSConfig.a(paramStGetBusiInfoRsp);
        a(paramString);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        QLog.d("FSMainTabInfoManager", 1, new Object[] { "handleTabListResponse parse setBusiInfoData exception:", paramString.toString() });
        return;
      }
    }
    QLog.d("FSMainTabInfoManager", 1, new Object[] { "handleTabListRsp isSuc:", Boolean.valueOf(paramBoolean), ",retCode:", Long.valueOf(paramLong), ",errMsg:", paramString });
  }
  
  public void b(FeedCloudMeta.StGPSV2 paramStGPSV2, FSFolderBean paramFSFolderBean)
  {
    paramStGPSV2 = new FSGetTabListRequest(paramStGPSV2, paramFSFolderBean);
    paramStGPSV2.setRetryCount(2);
    paramFSFolderBean = new StringBuilder();
    paramFSFolderBean.append("requestTabData(),CmdName:");
    paramFSFolderBean.append(paramStGPSV2.getCmdName());
    paramFSFolderBean.append(" | TraceId:");
    paramFSFolderBean.append(paramStGPSV2.getTraceId());
    paramFSFolderBean.append(" | SeqId:");
    paramFSFolderBean.append(paramStGPSV2.getCurrentSeq());
    QLog.d("FSMainTabInfoManager", 1, paramFSFolderBean.toString());
    a(paramStGPSV2);
  }
  
  public List<QQCircleFeedBase.StTabInfo> c(FeedCloudMeta.StGPSV2 paramStGPSV2, FSFolderBean paramFSFolderBean)
  {
    a(paramStGPSV2, paramFSFolderBean);
    if (b("new")) {
      return (List)this.a.get("new");
    }
    if (b("cache")) {
      return (List)this.a.get("cache");
    }
    QLog.d("FSMainTabInfoManager", 1, "getTabInfo in default level");
    a("default");
    return (List)this.a.get("default");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSMainTabInfoManager
 * JD-Core Version:    0.7.0.1
 */