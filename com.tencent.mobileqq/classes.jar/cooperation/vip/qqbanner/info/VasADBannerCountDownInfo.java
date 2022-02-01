package cooperation.vip.qqbanner.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.data.CountDownData;
import cooperation.vip.qqbanner.data.VasADBannerData;
import java.util.Map;

public class VasADBannerCountDownInfo
  extends VasADBannerConfigInfo
{
  private CountDownData b;
  
  public VasADBannerCountDownInfo(Map<String, String> paramMap)
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
      CountDownData localCountDownData = CountDownData.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_top_text");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.a(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_bottom_text");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.b(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_text_color");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.c(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_cout_down_bg_color");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.d(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_cout_down_text_color");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.e(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_botton_title");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.f(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_enable_count_down");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.a(paramSharedPreferences.getInt(localStringBuilder.toString(), -1));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_count_down_min");
      localStringBuilder.append(paramString);
      localCountDownData = localCountDownData.b(paramSharedPreferences.getInt(localStringBuilder.toString(), -1));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_count_down_sec");
      localStringBuilder.append(paramString);
      this.b = localCountDownData.c(paramSharedPreferences.getInt(localStringBuilder.toString(), -1)).b();
      if (a() != null)
      {
        a().j = this.b;
        return;
      }
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
    Object localObject1 = BaseApplicationImpl.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("");
    localObject1 = VasSplashUtil.a((Context)localObject1, ((StringBuilder)localObject2).toString());
    if (localObject1 != null)
    {
      if (a() == null) {
        return;
      }
      super.a(paramString);
      localObject2 = a();
      if (localObject2 == null) {
        return;
      }
      paramString = ((SharedPreferences)localObject1).edit();
      localObject1 = ((VasADBannerData)localObject2).e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_top_text");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putString(((StringBuilder)localObject2).toString(), this.b.d);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_bottom_text");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putString(((StringBuilder)localObject2).toString(), this.b.e);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_text_color");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putString(((StringBuilder)localObject2).toString(), this.b.f);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_cout_down_bg_color");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putString(((StringBuilder)localObject2).toString(), this.b.g);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_cout_down_text_color");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putString(((StringBuilder)localObject2).toString(), this.b.h);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_botton_title");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putString(((StringBuilder)localObject2).toString(), this.b.i);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_enable_count_down");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putInt(((StringBuilder)localObject2).toString(), this.b.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_count_down_min");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putInt(((StringBuilder)localObject2).toString(), this.b.b);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("splash_union_banner_count_down_sec");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.putInt(((StringBuilder)localObject2).toString(), this.b.c);
      paramString.apply();
    }
  }
  
  protected void a(Map<String, String> paramMap)
  {
    super.a(paramMap);
    if (paramMap == null)
    {
      QLog.e("VasADBannerConfigInfo", 1, "buildData error with data = null");
      return;
    }
    try
    {
      this.b = CountDownData.a().a((String)paramMap.get("topText")).b((String)paramMap.get("bottomText")).c((String)paramMap.get("textColor")).d((String)paramMap.get("coutdownBgColor")).e((String)paramMap.get("coutdownTextColor")).f((String)paramMap.get("buttonTitle")).b();
      if (!TextUtils.isEmpty((CharSequence)paramMap.get("enableCountdown"))) {
        this.b.a = Integer.parseInt((String)paramMap.get("enableCountdown"));
      }
      if (!TextUtils.isEmpty((CharSequence)paramMap.get("countdownMinute"))) {
        this.b.b = Integer.parseInt((String)paramMap.get("countdownMinute"));
      }
      if (!TextUtils.isEmpty((CharSequence)paramMap.get("countdownSecond"))) {
        this.b.c = Integer.parseInt((String)paramMap.get("countdownSecond"));
      }
      a().j = this.b;
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qboss banner buildData error msg = ");
      localStringBuilder.append(paramMap.getMessage());
      QLog.e("VasADBannerConfigInfo", 1, localStringBuilder.toString());
    }
  }
  
  public CountDownData f()
  {
    if (a() != null)
    {
      CountDownData localCountDownData = this.b;
      if (localCountDownData != null) {
        return localCountDownData;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.info.VasADBannerCountDownInfo
 * JD-Core Version:    0.7.0.1
 */