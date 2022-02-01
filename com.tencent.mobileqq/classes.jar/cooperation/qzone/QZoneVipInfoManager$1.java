package cooperation.qzone;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class QZoneVipInfoManager$1
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  QZoneVipInfoManager$1(QZoneVipInfoManager paramQZoneVipInfoManager) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!QZoneVipInfoManager.access$000(this.this$0)) && (QZoneVipInfoManager.access$100(this.this$0) != null))
      {
        if (QZoneVipInfoManager.access$200(this.this$0, paramSharedPreferences.getAccount()).equals(paramString)) {
          QZoneVipInfoManager.access$302(this.this$0, QZoneVipInfoManager.access$100(this.this$0).getInt(paramString, 0));
        }
        if (QZoneVipInfoManager.access$400(this.this$0, paramSharedPreferences.getAccount()).equals(paramString)) {
          QZoneVipInfoManager.access$502(this.this$0, QZoneVipInfoManager.access$100(this.this$0).getString(paramString, null));
        }
        if (QZoneVipInfoManager.access$600(this.this$0, paramSharedPreferences.getAccount()).equals(paramString)) {
          QZoneVipInfoManager.access$702(this.this$0, QZoneVipInfoManager.access$100(this.this$0).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + QZoneVipInfoManager.access$300(this.this$0) + " personlizedYellowVipUrl = " + QZoneVipInfoManager.access$500(this.this$0));
        }
      }
      QZoneVipInfoManager.access$002(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneVipInfoManager.1
 * JD-Core Version:    0.7.0.1
 */