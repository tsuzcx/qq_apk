package com.tencent.mobileqq.nearby.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.gift.ITroopGiftPanelForNearby;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.MobileQQ;

@QAPI(process={"all"})
public abstract interface IFactoryApi
  extends QRouteApi
{
  public abstract IHuayangDowanloadHelper getHuaYangDownLoadHelper(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract IVPluginReportInterface getIVPluginReportInterface();
  
  public abstract INearbyAppInterface getNearbyAppInterface(MobileQQ paramMobileQQ, String paramString);
  
  public abstract INearbyGiftPanelDialog getNearbyGiftPanelDialog(AppInterface paramAppInterface, Context paramContext, Object paramObject1, Object paramObject2, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract INearbyProcManager getNearbyProcManager(AppInterface paramAppInterface);
  
  public abstract INearbyProxy getNearbyProxy(Object paramObject);
  
  public abstract ITroopGiftPanelForNearby getTroopGiftPanelForNearby(Object paramObject1, Context paramContext, Object paramObject2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject3);
  
  public abstract void monitorReport(String paramString);
  
  public abstract void monitorTrigger(String paramString);
  
  public abstract INearbyTabInfo parserFormJson(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.IFactoryApi
 * JD-Core Version:    0.7.0.1
 */