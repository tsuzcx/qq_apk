package com.tencent.mobileqq.troop.activity;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import bhpy;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.io.File;
import java.net.URL;
import ndi;
import ndq;
import xwb;

class TroopAvatarWallPreviewActivity$8
  implements Runnable
{
  TroopAvatarWallPreviewActivity$8(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, bhpy parambhpy) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "QR Check Start!");
      }
      Object localObject = new Bundle();
      String str1 = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
      if (this.this$0.a == null)
      {
        CookieSyncManager.createInstance(this.this$0.getApplicationContext());
        this.this$0.a = CookieManager.getInstance();
      }
      String str2 = this.this$0.a.getCookie(str1);
      if (str2 != null)
      {
        ((Bundle)localObject).putString("Cookie", str2);
        if (QLog.isColorLevel()) {
          QLog.d("TroopAvatarWallPreviewActivity", 2, "Get cookie: " + ndq.c(str2, new String[0]) + " from " + ndq.b(str1, new String[0]));
        }
      }
      localObject = ndi.a(BaseApplication.getContext(), str1, (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "saveTmpImage path = " + (String)localObject);
      }
      this.this$0.d = ((String)localObject);
      bfrs.a = ndq.b(str1, new String[0]);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (xwb.a(Uri.parse("file://" + new File((String)localObject).getAbsolutePath()), this.this$0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAvatarWallPreviewActivity", 2, "has QRCode ");
          }
          this.this$0.runOnUiThread(new TroopAvatarWallPreviewActivity.8.1(this));
        }
      }
      for (;;)
      {
        bfrs.a = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */