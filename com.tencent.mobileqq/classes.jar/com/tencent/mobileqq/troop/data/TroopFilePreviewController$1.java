package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class TroopFilePreviewController$1
  extends BizTroopObserver
{
  TroopFilePreviewController$1(TroopFilePreviewController paramTroopFilePreviewController) {}
  
  protected void c(Object paramObject)
  {
    TroopFileTransferManager.PreviewInfo localPreviewInfo = (TroopFileTransferManager.PreviewInfo)paramObject;
    Object localObject1 = localPreviewInfo.d;
    if (!NetworkUtil.isNetworkAvailable(this.a.b.getApp())) {
      localObject1 = this.a.b.getApp().getString(2131889577);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.b.getApp().getString(2131891374);
    }
    if (((IFMConfig)QRoute.api(IFMConfig.class)).getUserHarCodeIp())
    {
      localPreviewInfo.b = "183.61.37.13";
      localPreviewInfo.c = "443";
    }
    if ((TroopFileUtils.a(this.a.b)) && (!TextUtils.isEmpty(localPreviewInfo.h)))
    {
      short s2 = localPreviewInfo.i;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localPreviewInfo.h);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    else
    {
      localObject1 = null;
    }
    if (this.a.a != null) {
      this.a.a.a(localPreviewInfo.a, localPreviewInfo.b, localPreviewInfo.c, localPreviewInfo.f, (String)localObject2, localPreviewInfo.e, null, localPreviewInfo.g, (Bundle)localObject1);
    }
    super.c(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFilePreviewController.1
 * JD-Core Version:    0.7.0.1
 */