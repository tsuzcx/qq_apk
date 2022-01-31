package com.tencent.mobileqq.mini.launch;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

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
    QLog.d("DesktopDataManager-Recommend", 2, "RecommendRunnable getRecommendAppList : " + this.appId);
    COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
    String str = MiniAppUtils.getSpDesktopGdtCookie();
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("gdt_cookie");
    localEntry.value.set(str);
    localStCommonExt.mapInfo.get().add(localEntry);
    MiniAppCmdUtil.getInstance().getRecommendAppList(localStCommonExt, this.appId, this.verType, this.useTime, this.recommendAppInfos, new AppBrandLaunchManager.RecommendRunnable.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.RecommendRunnable
 * JD-Core Version:    0.7.0.1
 */