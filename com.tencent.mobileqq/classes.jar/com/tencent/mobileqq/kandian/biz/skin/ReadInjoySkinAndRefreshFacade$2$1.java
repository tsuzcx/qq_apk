package com.tencent.mobileqq.kandian.biz.skin;

import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

class ReadInjoySkinAndRefreshFacade$2$1
  implements Runnable
{
  ReadInjoySkinAndRefreshFacade$2$1(ReadInjoySkinAndRefreshFacade.2 param2, oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    ReadInjoySkinAndRefreshFacade.a(this.f.a, i, this.a, this.b);
    RefreshData localRefreshData = ReadInjoySkinAndRefreshFacade.a(this.f.a, i, this.c, this.b);
    ReadInjoySkinAndRefreshFacade.a(this.f.a, i, localRefreshData, this.d, this.e, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInjoySkinAndRefreshFacade.2.1
 * JD-Core Version:    0.7.0.1
 */