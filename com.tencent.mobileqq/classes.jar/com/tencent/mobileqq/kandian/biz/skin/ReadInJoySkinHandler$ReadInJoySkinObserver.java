package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.mobileqq.app.BusinessObserver;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInJoySkinHandler$ReadInJoySkinObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.GuideInfo paramGuideInfo2, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (oidb_0x5bd.SkinInfo)paramObject[0], (oidb_0x5bd.GuideInfo)paramObject[1], (oidb_0x5bd.GuideInfo)paramObject[2], (oidb_0x5bd.RefreshInfo)paramObject[3], ((Integer)paramObject[4]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinHandler.ReadInJoySkinObserver
 * JD-Core Version:    0.7.0.1
 */