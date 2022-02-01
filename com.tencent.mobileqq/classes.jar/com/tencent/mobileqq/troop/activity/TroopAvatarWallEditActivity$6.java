package com.tencent.mobileqq.troop.activity;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.net.URL;

class TroopAvatarWallEditActivity$6
  implements Runnable
{
  TroopAvatarWallEditActivity$6(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, URLDrawable paramURLDrawable, ActionSheet paramActionSheet) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "QR Check Start!");
      }
      localObject2 = new Bundle();
      Object localObject1 = this.a.getURL().toString();
      if (this.this$0.r == null)
      {
        CookieSyncManager.createInstance(this.this$0.getApplicationContext());
        this.this$0.r = CookieManager.getInstance();
      }
      Object localObject3 = this.this$0.r.getCookie((String)localObject1);
      if (localObject3 != null)
      {
        ((Bundle)localObject2).putString("Cookie", (String)localObject3);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Get cookie: ");
          localStringBuilder.append(Util.c((String)localObject3, new String[0]));
          localStringBuilder.append(" from ");
          localStringBuilder.append(Util.b((String)localObject1, new String[0]));
          QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, localStringBuilder.toString());
        }
      }
      localObject2 = ImageUtil.a(BaseApplication.getContext(), (String)localObject1, (Bundle)localObject2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("saveTmpImage path = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, ((StringBuilder)localObject3).toString());
      }
      this.this$0.x = ((String)localObject2);
      com.tencent.qbar.QbarCrashCollector.sCurrentUrl = Util.b((String)localObject1, new String[0]);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("file://");
        ((StringBuilder)localObject1).append(new File((String)localObject2).getAbsolutePath());
        localObject1 = Uri.parse(((StringBuilder)localObject1).toString());
        localObject1 = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile((Uri)localObject1, this.this$0, 1, false);
        if ((localObject1 != null) && (((ScannerResult)localObject1).h()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "has QRCode ");
          }
          this.this$0.runOnUiThread(new TroopAvatarWallEditActivity.6.1(this));
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "no QRCode ");
      }
      com.tencent.qbar.QbarCrashCollector.sCurrentUrl = null;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showMenuActionSheet error : ");
        ((StringBuilder)localObject2).append(localUnsatisfiedLinkError.getMessage());
        QLog.e("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showMenuActionSheet error : ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.6
 * JD-Core Version:    0.7.0.1
 */