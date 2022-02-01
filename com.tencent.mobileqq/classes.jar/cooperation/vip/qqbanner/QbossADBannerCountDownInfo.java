package cooperation.vip.qqbanner;

import BOSSStrategyCenter.tAdvDesc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class QbossADBannerCountDownInfo
  extends QbossADBannerConfigInfo
{
  public int d;
  public int e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public QbossADBannerCountDownInfo(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
  }
  
  public QbossADBannerCountDownInfo(TianShuAccess.AdItem paramAdItem)
  {
    super(paramAdItem);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc == null) || (TextUtils.isEmpty(this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data)))
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data;
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      this.d = localJSONObject.optInt("enableCountdown");
      this.e = localJSONObject.optInt("countdownMinute");
      this.jdField_f_of_type_Int = localJSONObject.optInt("countdownSecond");
      this.jdField_f_of_type_JavaLangString = localJSONObject.optString("topText");
      this.g = localJSONObject.optString("bottomText");
      this.h = localJSONObject.optString("textColor");
      this.i = localJSONObject.optString("coutdownBgColor");
      this.j = localJSONObject.optString("coutdownTextColor");
      this.k = localJSONObject.optString("buttonTitle");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      QbossReportManager.getInstance().sendErrorReport(2741, this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id, 102, "CountDownBanner json parseError exception = " + localException.getMessage() + " json string = " + str);
    }
  }
  
  public void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    super.a(paramSharedPreferences, paramString);
    try
    {
      this.jdField_f_of_type_JavaLangString = paramSharedPreferences.getString("splash_union_banner_top_text" + this.c, "");
      this.g = paramSharedPreferences.getString("splash_union_banner_bottom_text" + this.c, "");
      this.h = paramSharedPreferences.getString("splash_union_banner_text_color" + this.c, "");
      this.i = paramSharedPreferences.getString("splash_union_banner_cout_down_bg_color" + this.c, "");
      this.j = paramSharedPreferences.getString("splash_union_banner_cout_down_text_color" + this.c, "");
      this.k = paramSharedPreferences.getString("splash_union_banner_botton_title" + this.c, "");
      this.d = paramSharedPreferences.getInt("splash_union_banner_enable_count_down" + this.c, -1);
      this.e = paramSharedPreferences.getInt("splash_union_banner_count_down_min" + this.c, -1);
      this.jdField_f_of_type_Int = paramSharedPreferences.getInt("splash_union_banner_count_down_sec" + this.c, -1);
      return;
    }
    catch (Exception paramSharedPreferences)
    {
      paramSharedPreferences.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "buildUnionBannerFromSP error msg = " + paramSharedPreferences.getMessage());
    }
  }
  
  public void a(String paramString, SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    super.a(paramString, paramSharedPreferences);
    paramString = paramSharedPreferences.edit();
    paramString.putString("splash_union_banner_top_text" + this.c, this.jdField_f_of_type_JavaLangString);
    paramString.putString("splash_union_banner_bottom_text" + this.c, this.g);
    paramString.putString("splash_union_banner_text_color" + this.c, this.h);
    paramString.putString("splash_union_banner_cout_down_bg_color" + this.c, this.i);
    paramString.putString("splash_union_banner_cout_down_text_color" + this.c, this.j);
    paramString.putString("splash_union_banner_botton_title" + this.c, this.k);
    paramString.putInt("splash_union_banner_enable_count_down" + this.c, this.d);
    paramString.putInt("splash_union_banner_count_down_min" + this.c, this.e);
    paramString.putInt("splash_union_banner_count_down_sec" + this.c, this.jdField_f_of_type_Int);
    paramString.apply();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null)
    {
      QLog.e("QbossADBannerConfigInfo", 1, "fillDataFromUnionSplashItem error with data = null");
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    while (localIterator.hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)localIterator.next();
      localHashMap.put(localMapEntry.key.get(), localMapEntry.value.get());
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localHashMap.get("enableCountdown"))) {
        this.d = Integer.parseInt((String)localHashMap.get("enableCountdown"));
      }
      if (!TextUtils.isEmpty((CharSequence)localHashMap.get("countdownMinute"))) {
        this.e = Integer.parseInt((String)localHashMap.get("countdownMinute"));
      }
      if (!TextUtils.isEmpty((CharSequence)localHashMap.get("countdownSecond"))) {
        this.jdField_f_of_type_Int = Integer.parseInt((String)localHashMap.get("countdownSecond"));
      }
      this.jdField_f_of_type_JavaLangString = ((String)localHashMap.get("topText"));
      this.g = ((String)localHashMap.get("bottomText"));
      this.h = ((String)localHashMap.get("textColor"));
      this.i = ((String)localHashMap.get("coutdownBgColor"));
      this.j = ((String)localHashMap.get("coutdownTextColor"));
      this.k = ((String)localHashMap.get("buttonTitle"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner fillDataFromUnionSplashItem error msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownInfo
 * JD-Core Version:    0.7.0.1
 */