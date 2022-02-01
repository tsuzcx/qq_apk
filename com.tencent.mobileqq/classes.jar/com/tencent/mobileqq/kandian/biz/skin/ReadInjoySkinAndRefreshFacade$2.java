package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.mobileqq.app.ThreadManager;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

class ReadInjoySkinAndRefreshFacade$2
  extends ReadInJoySkinHandler.ReadInJoySkinObserver
{
  ReadInjoySkinAndRefreshFacade$2(ReadInjoySkinAndRefreshFacade paramReadInjoySkinAndRefreshFacade) {}
  
  public void a(boolean paramBoolean, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.GuideInfo paramGuideInfo2, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    if ((paramBoolean) && (paramInt == ReadInjoySkinAndRefreshFacade.a(this.a))) {
      ThreadManager.post(new ReadInjoySkinAndRefreshFacade.2.1(this, paramGuideInfo2, paramInt, paramRefreshInfo, paramSkinInfo, paramGuideInfo1), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInjoySkinAndRefreshFacade.2
 * JD-Core Version:    0.7.0.1
 */