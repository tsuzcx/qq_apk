import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class oyr
  extends TroopGiftCallback
{
  oyr(oyq paramoyq, long paramLong, TroopGiftManager paramTroopGiftManager, AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGiftPanelContainer", 2, "onGetExtraData() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", configURL = " + paramString);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(this.jdField_a_of_type_Oyq.jdField_a_of_type_Int);
    this.jdField_a_of_type_Oyq.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = TroopGiftAioPanelData.a(this.jdField_a_of_type_Oyq.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, this.jdField_a_of_type_Oyq.jdField_a_of_type_Int);
    if ((paramInt <= i) && (this.jdField_a_of_type_Oyq.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null)) {
      this.jdField_a_of_type_Oyq.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a(0);
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new File(AppConstants.ba);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = AppConstants.ba + "troopGiftConfig.tmp";
    paramString = new DownloadTask(paramString, new File((String)localObject));
    paramString.b = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a().a(paramString, new oys(this, paramInt), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyr
 * JD-Core Version:    0.7.0.1
 */