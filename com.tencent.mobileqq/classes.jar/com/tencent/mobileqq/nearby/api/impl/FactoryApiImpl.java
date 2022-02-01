package com.tencent.mobileqq.nearby.api.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.troopgift.TroopGiftPanel.OnShowOrHideListerner;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelperUtil;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.gift.ITroopGiftPanelForNearby;
import com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import mqq.app.MobileQQ;

public class FactoryApiImpl
  implements IFactoryApi
{
  public IHuayangDowanloadHelper getHuaYangDownLoadHelper(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return HuayangDowanloadHelperUtil.a(((QQAppInterface)paramAppInterface).getApp(), paramString1, paramString2);
  }
  
  public IVPluginReportInterface getIVPluginReportInterface()
  {
    return new IVPluginDataReporter();
  }
  
  public INearbyAppInterface getNearbyAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    return new NearbyAppInterfaceImpl((BaseApplicationImpl)paramMobileQQ, paramString);
  }
  
  public INearbyGiftPanelDialog getNearbyGiftPanelDialog(AppInterface paramAppInterface, Context paramContext, Object paramObject1, Object paramObject2, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new NearbyGiftPanelDialog(paramAppInterface, paramContext, paramObject1, paramObject2, paramViewGroup, paramBoolean1, paramBoolean2);
  }
  
  public INearbyProcManager getNearbyProcManager(AppInterface paramAppInterface)
  {
    return new NearbyProcManager(paramAppInterface);
  }
  
  public INearbyProxy getNearbyProxy(Object paramObject)
  {
    return NearbyManagerHelper.a((QQAppInterface)paramObject);
  }
  
  public ITroopGiftPanelForNearby getTroopGiftPanelForNearby(Object paramObject1, Context paramContext, Object paramObject2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject3)
  {
    return new TroopGiftPanelForNearby((QQAppInterface)paramObject1, paramContext, (TroopGiftPanel.OnShowOrHideListerner)paramObject2, paramBoolean1, paramBoolean2, paramBoolean3, (BaseChatPie)paramObject3);
  }
  
  public void monitorReport(String paramString)
  {
    Monitor.b(paramString);
  }
  
  public void monitorTrigger(String paramString)
  {
    Monitor.a(paramString);
  }
  
  public INearbyTabInfo parserFormJson(String paramString)
  {
    return NearbyTabInfo.fromJson(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.FactoryApiImpl
 * JD-Core Version:    0.7.0.1
 */