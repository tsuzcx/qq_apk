package cooperation.vip.qqbanner;

import BOSSStrategyCenter.tAdvDesc;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo.ResourceInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;
import org.json.JSONObject;

public class QbossADBannerCountDownImmersionInfo
  extends QbossADBannerConfigInfo
{
  public long a;
  public boolean a;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public QbossADBannerCountDownImmersionInfo(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    QbossADBannerConfigInfo.ResourceInfo localResourceInfo = new QbossADBannerConfigInfo.ResourceInfo();
    localResourceInfo.a = paramString1;
    localResourceInfo.b = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      localResourceInfo.c = QbossADBannerConfigManager.a().a(paramString1);
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localResourceInfo);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc == null) || (TextUtils.isEmpty(this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data)))
    {
      QLog.e("qboss_banner|QbossADBannerCountDownImmersionInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        this.f = localJSONObject.optString("topText");
        this.g = localJSONObject.optString("bottomText");
        this.h = localJSONObject.optString("text_png");
        this.jdField_a_of_type_Long = localJSONObject.optLong("end_time", -1L);
        this.i = localJSONObject.optString("end_timeColor");
        this.j = localJSONObject.optString("cartoon");
        this.k = localJSONObject.optString("cartoon_md5");
        this.l = localJSONObject.optString("end_pic");
        this.m = localJSONObject.optString("end_cartoon");
        this.n = localJSONObject.optString("end_res_url");
        if (localJSONObject.optInt("fixed_type", 1) != 0)
        {
          bool = true;
          this.jdField_a_of_type_Boolean = bool;
          a(5, this.j, this.k);
          a(3, this.h, "");
          a(6, this.m, "");
          a(4, this.l, "");
          a(7, this.n, "");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("qboss_banner|QbossADBannerCountDownImmersionInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
        QbossReportManager.getInstance().sendErrorReport(2741, this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id, 102, "CountDownBanner json parseError exception = " + localException.getMessage() + " json string = " + str);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownImmersionInfo
 * JD-Core Version:    0.7.0.1
 */