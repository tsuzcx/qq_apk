package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.SkinInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import java.util.Iterator;
import java.util.List;

public class HbSkinInfo$HbSkinFactory
{
  public static HbSkinInfo a(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo(HardCodeUtil.a(R.string.aT));
    localHbSkinInfo.b = -2;
    localHbSkinInfo.f.skin_id = -2;
    localHbSkinInfo.f.skin_permission_state = 1L;
    localHbSkinInfo.g.title = paramString;
    localHbSkinInfo.g.icon = null;
    localHbSkinInfo.a = 0;
    return localHbSkinInfo;
  }
  
  public static HbSkinInfo a(List<HbSkinInfo> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HbSkinInfo localHbSkinInfo = (HbSkinInfo)paramList.next();
      if (localHbSkinInfo.f.skin_id == paramInt) {
        return localHbSkinInfo;
      }
    }
    return null;
  }
  
  public static HbSkinInfo b(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo(HardCodeUtil.a(R.string.aV));
    localHbSkinInfo.b = -1;
    localHbSkinInfo.f.skin_id = 0;
    localHbSkinInfo.f.skin_permission_state = 1L;
    localHbSkinInfo.f.is_hide_title = 0;
    localHbSkinInfo.f.blessing = HardCodeUtil.a(R.string.L);
    localHbSkinInfo.g.title = paramString;
    localHbSkinInfo.a = -1;
    return localHbSkinInfo;
  }
  
  public static HbSkinInfo c(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo(HardCodeUtil.a(R.string.aU));
    localHbSkinInfo.h = paramString;
    localHbSkinInfo.b = 1;
    localHbSkinInfo.a = 1000;
    localHbSkinInfo.f.skin_id = -1;
    localHbSkinInfo.f.skin_permission_state = 1L;
    return localHbSkinInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinInfo.HbSkinFactory
 * JD-Core Version:    0.7.0.1
 */