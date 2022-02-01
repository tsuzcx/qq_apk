package com.tencent.mobileqq.nearby.gift;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class NearbyGiftPanelDialog$1
  extends TroopGiftCallback
{
  NearbyGiftPanelDialog$1(NearbyGiftPanelDialog paramNearbyGiftPanelDialog, TroopGiftManager paramTroopGiftManager, long paramLong, AIOAnimationControlManager paramAIOAnimationControlManager, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = NearbyGiftPanelDialog.c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError() time =  ");
      localStringBuilder.append(System.currentTimeMillis() - this.b);
      localStringBuilder.append(", errorCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errorMsg = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i = this.a.a(this.e.i);
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = NearbyGiftPanelDialog.c();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGetExtraData() time =  ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.b);
      ((StringBuilder)localObject2).append(", configURL = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", version:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", oldVersion:");
      ((StringBuilder)localObject2).append(i);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramInt <= i) && (TroopGiftAioPanelData.b(this.e.g, this.e.i) != null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = new File(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
      ((StringBuilder)localObject1).append("troopGiftConfig.tmp");
      localObject1 = ((StringBuilder)localObject1).toString();
      paramString = new DownloadTask(paramString, new File((String)localObject1));
      paramString.e = 3;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("filePath", (String)localObject1);
      this.c.i().startDownload(paramString, new NearbyGiftPanelDialog.1.1(this, paramInt), (Bundle)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog.1
 * JD-Core Version:    0.7.0.1
 */