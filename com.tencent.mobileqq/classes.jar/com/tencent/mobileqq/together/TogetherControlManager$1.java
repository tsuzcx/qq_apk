package com.tencent.mobileqq.together;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.util.ArrayList;

class TogetherControlManager$1
  implements TianShuGetAdvCallback
{
  TogetherControlManager$1(TogetherControlManager paramTogetherControlManager) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    QLog.d("TogetherControlManager", 2, new Object[] { "ongetAdvs result:", Boolean.valueOf(paramBoolean), " rsp:", paramGetAdsRsp.toString() });
    if (paramBoolean)
    {
      paramGetAdsRsp = TogetherControlManager.EntryBannerInfo.a(paramBoolean, paramGetAdsRsp);
      if (paramGetAdsRsp != null)
      {
        this.a.a.add(paramGetAdsRsp);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable.getDrawable(paramGetAdsRsp.c, localURLDrawableOptions).startDownload();
      }
    }
    else
    {
      return;
    }
    QLog.d("TogetherControlManager", 2, "ongetAdvs banner is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager.1
 * JD-Core Version:    0.7.0.1
 */