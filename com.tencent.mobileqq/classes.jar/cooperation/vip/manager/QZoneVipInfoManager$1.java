package cooperation.vip.manager;

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
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSharedPreferenceChanged key = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QZoneVipInfoManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((!QZoneVipInfoManager.a(this.a)) && (QZoneVipInfoManager.b(this.a) != null))
      {
        if (QZoneVipInfoManager.a(this.a, paramSharedPreferences.getAccount()).equals(paramString))
        {
          localObject = this.a;
          QZoneVipInfoManager.a((QZoneVipInfoManager)localObject, QZoneVipInfoManager.b((QZoneVipInfoManager)localObject).getInt(paramString, 0));
        }
        if (QZoneVipInfoManager.b(this.a, paramSharedPreferences.getAccount()).equals(paramString))
        {
          localObject = this.a;
          QZoneVipInfoManager.c((QZoneVipInfoManager)localObject, QZoneVipInfoManager.b((QZoneVipInfoManager)localObject).getString(paramString, null));
        }
        if (QZoneVipInfoManager.d(this.a, paramSharedPreferences.getAccount()).equals(paramString))
        {
          paramSharedPreferences = this.a;
          QZoneVipInfoManager.e(paramSharedPreferences, QZoneVipInfoManager.b(paramSharedPreferences).getString(paramString, null));
        }
        if (QLog.isColorLevel())
        {
          paramSharedPreferences = new StringBuilder();
          paramSharedPreferences.append("onSharedPreferenceChanged value = ");
          paramSharedPreferences.append(QZoneVipInfoManager.c(this.a));
          paramSharedPreferences.append(" personlizedYellowVipUrl = ");
          paramSharedPreferences.append(QZoneVipInfoManager.d(this.a));
          QLog.d("QZoneVipInfoManager", 2, paramSharedPreferences.toString());
        }
      }
      QZoneVipInfoManager.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.QZoneVipInfoManager.1
 * JD-Core Version:    0.7.0.1
 */