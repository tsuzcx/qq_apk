package cooperation.vip.qqbanner.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.vip.qqbanner.data.ImmersionData;
import cooperation.vip.qqbanner.data.VasADBannerData;
import java.util.Map;

public class VasADBannerImmersionInfo
  extends VasADBannerConfigInfo
{
  public ImmersionData b;
  
  public VasADBannerImmersionInfo(Map<String, String> paramMap)
  {
    super(paramMap);
  }
  
  public void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    super.a(paramSharedPreferences, paramString);
    try
    {
      ImmersionData localImmersionData = ImmersionData.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_top_text");
      localStringBuilder.append(paramString);
      localImmersionData = localImmersionData.a(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_bottom_text");
      localStringBuilder.append(paramString);
      localImmersionData = localImmersionData.b(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_text_color");
      localStringBuilder.append(paramString);
      localImmersionData = localImmersionData.c(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_cartoon_url");
      localStringBuilder.append(paramString);
      localImmersionData = localImmersionData.d(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_md5");
      localStringBuilder.append(paramString);
      localImmersionData = localImmersionData.e(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_cartoon_num");
      localStringBuilder.append(paramString);
      this.b = localImmersionData.f(paramSharedPreferences.getString(localStringBuilder.toString(), "")).b();
      if (a() != null) {
        a().k = this.b;
      }
      paramSharedPreferences = new VasADBannerImmersionInfo.ZipResourcesinfo(this, null);
      paramSharedPreferences.a = this.b.d;
      paramSharedPreferences.b = this.b.e;
      if (!TextUtils.isEmpty(this.b.d))
      {
        paramString = new StringBuilder();
        paramString.append(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(this.b.d.hashCode())));
        paramString.append(".zip");
        paramSharedPreferences.c = paramString.toString();
      }
      paramSharedPreferences.a();
      this.a.put(2, paramSharedPreferences);
      return;
    }
    catch (Exception paramSharedPreferences)
    {
      paramSharedPreferences.printStackTrace();
      paramString = new StringBuilder();
      paramString.append("buildUnionBannerFromSP error msg = ");
      paramString.append(paramSharedPreferences.getMessage());
      QLog.e("VasADBannerConfigInfo", 1, paramString.toString());
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    localObject = VasSplashUtil.a((Context)localObject, localStringBuilder.toString());
    if (localObject != null)
    {
      if (a() == null) {
        return;
      }
      super.a(paramString);
      paramString = ((SharedPreferences)localObject).edit();
      localObject = a().e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_top_text");
      localStringBuilder.append((String)localObject);
      paramString.putString(localStringBuilder.toString(), this.b.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_bottom_text");
      localStringBuilder.append((String)localObject);
      paramString.putString(localStringBuilder.toString(), this.b.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_text_color");
      localStringBuilder.append((String)localObject);
      paramString.putString(localStringBuilder.toString(), this.b.c);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_cartoon_url");
      localStringBuilder.append((String)localObject);
      paramString.putString(localStringBuilder.toString(), this.b.d);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_md5");
      localStringBuilder.append((String)localObject);
      paramString.putString(localStringBuilder.toString(), this.b.e);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_cartoon_num");
      localStringBuilder.append((String)localObject);
      paramString.putString(localStringBuilder.toString(), this.b.f);
      paramString.apply();
    }
  }
  
  protected void a(Map<String, String> paramMap)
  {
    super.a(paramMap);
    if ((paramMap != null) && (a() != null)) {
      try
      {
        this.b = ImmersionData.a().a((String)paramMap.get("topText")).b((String)paramMap.get("bottomText")).c((String)paramMap.get("textColor")).d((String)paramMap.get("cartoon")).e((String)paramMap.get("cartoon_md5")).f((String)paramMap.get("cartoonNum")).b();
        paramMap = new VasADBannerImmersionInfo.ZipResourcesinfo(this, null);
        paramMap.a = this.b.d;
        paramMap.b = this.b.e;
        if (!TextUtils.isEmpty(this.b.d))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(this.b.d.hashCode())));
          localStringBuilder.append(".zip");
          paramMap.c = localStringBuilder.toString();
        }
        if (a() != null) {
          a().k = this.b;
        }
        this.a.put(2, paramMap);
        return;
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vas banner buildData error msg = ");
        localStringBuilder.append(paramMap.getMessage());
        QLog.e("VasADBannerConfigInfo", 1, localStringBuilder.toString());
        return;
      }
    }
    QLog.e("VasADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.info.VasADBannerImmersionInfo
 * JD-Core Version:    0.7.0.1
 */