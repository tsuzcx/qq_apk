package cooperation.vip.qqbanner;

import BOSSStrategyCenter.tAdvDesc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo.ResourceInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class QbossADBannerImmersionInfo
  extends QbossADBannerConfigInfo
{
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public QbossADBannerImmersionInfo(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
  }
  
  public QbossADBannerImmersionInfo(TianShuAccess.AdItem paramAdItem)
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
      Object localObject = new JSONObject(str);
      this.f = ((JSONObject)localObject).optString("topText");
      this.g = ((JSONObject)localObject).optString("bottomText");
      this.h = ((JSONObject)localObject).optString("textColor");
      this.i = ((JSONObject)localObject).optString("cartoon");
      this.j = ((JSONObject)localObject).optString("cartoon_md5");
      this.k = ((JSONObject)localObject).optString("cartoonNum");
      localObject = new QbossADBannerImmersionInfo.ZipResourcesinfo(this, null);
      ((QbossADBannerConfigInfo.ResourceInfo)localObject).a = this.i;
      ((QbossADBannerConfigInfo.ResourceInfo)localObject).b = this.j;
      if (!TextUtils.isEmpty(this.i)) {
        ((QbossADBannerConfigInfo.ResourceInfo)localObject).c = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.i.hashCode())) + ".zip");
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
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
      this.f = paramSharedPreferences.getString("splash_union_banner_top_text" + paramString, "");
      this.g = paramSharedPreferences.getString("splash_union_banner_bottom_text" + paramString, "");
      this.h = paramSharedPreferences.getString("splash_union_banner_text_color" + paramString, "");
      this.i = paramSharedPreferences.getString("splash_union_banner_cartoon_url" + paramString, "");
      this.j = paramSharedPreferences.getString("splash_union_banner_md5" + paramString, "");
      this.k = paramSharedPreferences.getString("splash_union_banner_cartoon_num" + paramString, "");
      paramSharedPreferences = new QbossADBannerImmersionInfo.ZipResourcesinfo(this, null);
      paramSharedPreferences.a = this.i;
      paramSharedPreferences.b = this.j;
      if (!TextUtils.isEmpty(this.i)) {
        paramSharedPreferences.c = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.i.hashCode())) + ".zip");
      }
      paramSharedPreferences.a();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, paramSharedPreferences);
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
    paramString.putString("splash_union_banner_top_text" + this.c, this.f);
    paramString.putString("splash_union_banner_bottom_text" + this.c, this.g);
    paramString.putString("splash_union_banner_text_color" + this.c, this.h);
    paramString.putString("splash_union_banner_cartoon_url" + this.c, this.i);
    paramString.putString("splash_union_banner_md5" + this.c, this.j);
    paramString.putString("splash_union_banner_cartoon_num" + this.c, this.k);
    paramString.apply();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null)
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    Object localObject = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    while (localIterator.hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)localIterator.next();
      ((HashMap)localObject).put(localMapEntry.key.get(), localMapEntry.value.get());
    }
    try
    {
      this.f = ((String)((HashMap)localObject).get("topText"));
      this.g = ((String)((HashMap)localObject).get("bottomText"));
      this.h = ((String)((HashMap)localObject).get("textColor"));
      this.i = ((String)((HashMap)localObject).get("cartoon"));
      this.j = ((String)((HashMap)localObject).get("cartoon_md5"));
      this.k = ((String)((HashMap)localObject).get("cartoonNum"));
      localObject = new QbossADBannerImmersionInfo.ZipResourcesinfo(this, null);
      ((QbossADBannerConfigInfo.ResourceInfo)localObject).a = this.i;
      ((QbossADBannerConfigInfo.ResourceInfo)localObject).b = this.j;
      if (!TextUtils.isEmpty(this.i)) {
        ((QbossADBannerConfigInfo.ResourceInfo)localObject).c = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.i.hashCode())) + ".zip");
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
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
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerImmersionInfo
 * JD-Core Version:    0.7.0.1
 */