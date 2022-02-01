package com.tencent.mobileqq.mini.launch;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class AppBrandLaunchManager$RecommendRunnable
  implements Runnable
{
  private String appId;
  private ArrayList<RecommendAppInfo> recommendAppInfos;
  private long useTime;
  private int verType;
  
  public AppBrandLaunchManager$RecommendRunnable(String paramString, int paramInt, long paramLong, ArrayList<RecommendAppInfo> paramArrayList)
  {
    this.appId = paramInt;
    this.verType = paramLong;
    this.useTime = ???;
    Object localObject;
    this.recommendAppInfos = localObject;
  }
  
  public void run()
  {
    COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
    Object localObject = MiniAppUtils.getSpDesktopGdtCookie();
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("gdt_cookie");
    localEntry.value.set((String)localObject);
    localStCommonExt.mapInfo.get().add(localEntry);
    if (this.recommendAppInfos.isEmpty())
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (DesktopDataManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
        if (localObject != null) {
          this.recommendAppInfos.addAll(((DesktopDataManager)localObject).parseRecommendExposureFromSp());
        }
      }
    }
    QLog.d("DesktopDataManager-Recommend", 2, "RecommendRunnable getRecommendAppList : " + this.appId + ", recommendAppList size: " + this.recommendAppInfos.size());
    MiniAppCmdUtil.getInstance().getRecommendAppList(localStCommonExt, this.appId, this.verType, this.useTime, this.recommendAppInfos, new AppBrandLaunchManager.RecommendRunnable.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.RecommendRunnable
 * JD-Core Version:    0.7.0.1
 */