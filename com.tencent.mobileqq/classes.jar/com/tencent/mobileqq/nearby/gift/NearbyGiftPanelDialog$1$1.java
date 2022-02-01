package com.tencent.mobileqq.nearby.gift;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyGiftPanelDialog$1$1
  extends DownloadListener
{
  NearbyGiftPanelDialog$1$1(NearbyGiftPanelDialog.1 param1, int paramInt) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject1;
    Object localObject2;
    if (paramDownloadTask.jdField_a_of_type_Int == 0)
    {
      localObject1 = paramDownloadTask.a().getString("filePath");
      try
      {
        paramDownloadTask = new File((String)localObject1);
        localObject2 = FileUtils.readFileToString(paramDownloadTask);
        if (QLog.isColorLevel())
        {
          String str = NearbyGiftPanelDialog.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDone() content =  ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(", filePath = ");
          localStringBuilder.append((String)localObject1);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        localObject1 = new TroopGiftAioPanelData(new JSONObject((String)localObject2), "");
        ((TroopGiftAioPanelData)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog$1.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog$1.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog$1.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog$1.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog$1.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog$1.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.post(new NearbyGiftPanelDialog.1.1.1(this, (TroopGiftAioPanelData)localObject1));
        }
        paramDownloadTask.deleteOnExit();
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(NearbyGiftPanelDialog.a(), 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
      catch (IOException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d(NearbyGiftPanelDialog.a(), 2, QLog.getStackTraceString(paramDownloadTask));
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = NearbyGiftPanelDialog.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onError() time =  ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog$1.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append(", errorCode = ");
      ((StringBuilder)localObject2).append(paramDownloadTask.jdField_a_of_type_Int);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog.1.1
 * JD-Core Version:    0.7.0.1
 */