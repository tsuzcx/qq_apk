package com.tencent.mobileqq.troop.activity;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import bkzi;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.io.File;
import java.net.URL;
import nwh;
import nwo;
import zmk;

class TroopAvatarWallPreviewActivity$7
  implements Runnable
{
  TroopAvatarWallPreviewActivity$7(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, bkzi parambkzi) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "QR Check Start!");
      }
      Object localObject2 = new Bundle();
      Object localObject1 = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
      if (this.this$0.a == null)
      {
        CookieSyncManager.createInstance(this.this$0.getApplicationContext());
        this.this$0.a = CookieManager.getInstance();
      }
      String str = this.this$0.a.getCookie((String)localObject1);
      if (str != null)
      {
        ((Bundle)localObject2).putString("Cookie", str);
        if (QLog.isColorLevel()) {
          QLog.d("TroopAvatarWallPreviewActivity", 2, "Get cookie: " + nwo.c(str, new String[0]) + " from " + nwo.b((String)localObject1, new String[0]));
        }
      }
      localObject2 = nwh.a(BaseApplication.getContext(), (String)localObject1, (Bundle)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "saveTmpImage path = " + (String)localObject2);
      }
      this.this$0.d = ((String)localObject2);
      bjup.a = nwo.b((String)localObject1, new String[0]);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = zmk.a(Uri.parse("file://" + new File((String)localObject2).getAbsolutePath()), this.this$0, 1);
        if ((localObject1 != null) && (((ScannerResult)localObject1).d()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAvatarWallPreviewActivity", 2, "has QRCode ");
          }
          this.this$0.runOnUiThread(new TroopAvatarWallPreviewActivity.7.1(this));
        }
      }
      for (;;)
      {
        bjup.a = null;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TroopAvatarWallPreviewActivity", 2, "no QRCode ");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("TroopAvatarWallPreviewActivity", 2, "showActionSheet error : " + localException.getMessage());
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAvatarWallPreviewActivity", 2, "showActionSheet error : " + localUnsatisfiedLinkError.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */