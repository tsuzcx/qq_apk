package com.tencent.mobileqq.litelivesdk.framework.customizedmgr;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.base.bizmodule.BaseBizModule;
import com.tencent.ilive.litepages.room.roomconfig.AudienceLiteEntBootModules;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules.GetEnterRoomExtDataCallback;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.avmodule.CustomAVModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.landscape.CustomLanscapeModule;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import java.util.Iterator;
import java.util.List;

public class CustomAudienceRoomBizModules
  extends AudienceLiteEntBootModules
  implements BaseSDKPageBizBootModules.GetEnterRoomExtDataCallback
{
  private BaseSDKPageBizBootModules a;
  private CustomLanscapeModule b;
  
  public CustomAudienceRoomBizModules(BaseSDKPageBizBootModules paramBaseSDKPageBizBootModules)
  {
    paramBaseSDKPageBizBootModules.e();
    this.a = paramBaseSDKPageBizBootModules;
    this.a.a(this);
  }
  
  public Object a(String paramString)
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null) && (getRoomBizContext().getEnterRoomInfo().extData != null)) {
      return getRoomBizContext().getEnterRoomInfo().extData.get(paramString);
    }
    return Integer.valueOf(0);
  }
  
  protected void onCreateBottomBizModules()
  {
    this.a.c();
    List localList = this.a.g();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      addBottomLayoutBizModules((BaseBizModule)localIterator.next());
    }
    if (!BusinessManager.a.e()) {
      addBottomLayoutBizModules(new CustomAVModule());
    }
    localList.clear();
  }
  
  protected void onCreateNormalBizModules()
  {
    Object localObject1 = LogFactory.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onCreateNormalBizModules----this = ");
    ((StringBuilder)localObject2).append(this);
    ((LogInterface)localObject1).e("CustomAudienceRoomBizModules", ((StringBuilder)localObject2).toString());
    this.a.a();
    this.a.d();
    this.b = new CustomLanscapeModule();
    localObject1 = this.a.i();
    LogFactory.a().c("CustomAudienceRoomBizModules", "onCreateNormalBizModules---start add bizModules");
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      addNormalLayoutBizModules((BaseBizModule)((Iterator)localObject2).next());
    }
    ((List)localObject1).clear();
    LogFactory.a().c("CustomAudienceRoomBizModules", "onCreateNormalBizModules---end add bizModules");
  }
  
  public void onCreateNormalBizModules(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    addNormalLayoutBizModules(this.b, true);
    this.a.a(true);
  }
  
  protected ViewGroup onCreateNormalLayout()
  {
    this.a.a(BaseApplicationImpl.getContext());
    return this.a.f();
  }
  
  protected void onCreateTopBizModules()
  {
    this.a.b();
    List localList = this.a.h();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      addTopLayoutBizModules((BaseBizModule)localIterator.next());
    }
    localList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.customizedmgr.CustomAudienceRoomBizModules
 * JD-Core Version:    0.7.0.1
 */