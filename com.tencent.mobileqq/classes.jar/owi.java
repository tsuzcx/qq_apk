import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class owi
  implements HttpWebCgiAsyncTask.Callback
{
  public owi(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("requstTroopNotifyAd", 2, "result = " + paramJSONObject + ", requestCode = " + paramInt);
    }
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("8020205751015455");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("list");
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
          {
            paramJSONObject = TroopFeedsDataManager.TroopNotifyAd.a(paramJSONObject.optJSONObject(0));
            if (paramJSONObject != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd = paramJSONObject;
              this.a.d = true;
              if (QLog.isColorLevel()) {
                QLog.d("requstTroopNotifyAd", 2, "apurl = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd.a + ", img = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd.c + ", rl = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd.b);
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopTipsPopWindow", 2, "requestTroopNotifyAd result ready -----------");
            }
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "requestTroopNotifyAd result null -----------");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owi
 * JD-Core Version:    0.7.0.1
 */