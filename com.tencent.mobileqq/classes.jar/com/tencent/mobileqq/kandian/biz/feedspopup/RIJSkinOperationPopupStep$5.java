package com.tencent.mobileqq.kandian.biz.feedspopup;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinHandler.ReadInJoySkinObserver;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

class RIJSkinOperationPopupStep$5
  extends ReadInJoySkinHandler.ReadInJoySkinObserver
{
  RIJSkinOperationPopupStep$5(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep) {}
  
  public void a(boolean paramBoolean, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.GuideInfo paramGuideInfo2, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      ThreadManager.excute(new RIJSkinOperationPopupStep.5.1(this, paramGuideInfo2, paramInt, paramRefreshInfo, paramSkinInfo, paramGuideInfo1), 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep.5
 * JD-Core Version:    0.7.0.1
 */