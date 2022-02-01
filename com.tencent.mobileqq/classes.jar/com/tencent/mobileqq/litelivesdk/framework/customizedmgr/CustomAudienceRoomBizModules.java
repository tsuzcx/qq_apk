package com.tencent.mobileqq.litelivesdk.framework.customizedmgr;

import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule;
import com.tencent.ilive.base.bizmodule.BaseBizModule;
import com.tencent.ilive.litepages.room.roomconfig.AudienceLiteEntBootModules;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.landscape.CustomLanscapeModule;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import java.util.Iterator;
import java.util.List;

public class CustomAudienceRoomBizModules
  extends AudienceLiteEntBootModules
{
  private BaseSDKPageBizBootModules jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules;
  private CustomLanscapeModule jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesLandscapeCustomLanscapeModule;
  
  public CustomAudienceRoomBizModules(BaseSDKPageBizBootModules paramBaseSDKPageBizBootModules)
  {
    paramBaseSDKPageBizBootModules.e();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules = paramBaseSDKPageBizBootModules;
  }
  
  public void onCreateBottomBizModules()
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.c();
    List localList = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.a();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      addBottomLayoutBizModules((BaseBizModule)localIterator.next());
    }
    addBottomLayoutBizModules(new AVPlayerModule());
    localList.clear();
  }
  
  public void onCreateNormalBizModules()
  {
    LogFactory.a().e("CustomAudienceRoomBizModules", "onCreateNormalBizModules----this = " + this);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.a();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.d();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesLandscapeCustomLanscapeModule = new CustomLanscapeModule();
    List localList = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.c();
    LogFactory.a().c("CustomAudienceRoomBizModules", "onCreateNormalBizModules---start add bizModules");
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      addNormalLayoutBizModules((BaseBizModule)localIterator.next());
    }
    localList.clear();
    LogFactory.a().c("CustomAudienceRoomBizModules", "onCreateNormalBizModules---end add bizModules");
  }
  
  public void onCreateNormalBizModules(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    addNormalLayoutBizModules(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesLandscapeCustomLanscapeModule, true);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.a(true);
  }
  
  public ViewGroup onCreateNormalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.a(BaseApplicationImpl.getContext());
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.a();
  }
  
  public void onCreateTopBizModules()
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.b();
    List localList = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiCustomizedBaseSDKPageBizBootModules.b();
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