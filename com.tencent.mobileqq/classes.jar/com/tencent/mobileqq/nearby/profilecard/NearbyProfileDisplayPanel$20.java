package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$20
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$20(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.setAction("android.intent.action.VIEW");
      paramDialogInterface.setData(Uri.parse(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowJumpUri));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.startActivity(paramDialogInterface);
      return;
    }
    if ("com.tencent.now".equals(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowPackage))
    {
      paramDialogInterface = BaseApplicationImpl.getContext().getSharedPreferences("now_down_apk", 4);
      if (paramDialogInterface.getInt("state", 0) == 1) {
        try
        {
          ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).installAPK(paramDialogInterface.getString("filePath", ""));
          paramDialogInterface.edit().putInt("state", 0).apply();
          return;
        }
        catch (Exception paramDialogInterface)
        {
          QLog.e("NearbyProfileDisplayPanel", 1, paramDialogInterface, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowDownloadUrl, "now.apk", "now_down_apk");
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowDownloadUrl, "now.apk", "now_down_apk");
      return;
    }
    paramDialogInterface = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowPackage.replaceAll("\\.", "_") + "_apk";
    String str = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowPackage.replaceAll("\\.", "_") + ".apk";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(paramDialogInterface, 4);
    if (localSharedPreferences.getInt("state", 0) == 1) {
      try
      {
        ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).installAPK(localSharedPreferences.getString("filePath", ""));
        localSharedPreferences.edit().putInt("state", 0).apply();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("NearbyProfileDisplayPanel", 1, localException, new Object[0]);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowDownloadUrl, str, paramDialogInterface);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).guideAppNowDownloadUrl, str, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.20
 * JD-Core Version:    0.7.0.1
 */