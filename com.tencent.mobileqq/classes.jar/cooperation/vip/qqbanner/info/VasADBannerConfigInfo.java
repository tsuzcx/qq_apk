package cooperation.vip.qqbanner.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.data.VasADBannerData;
import cooperation.vip.qqbanner.manager.VasADBannerCountDownManager;
import cooperation.vip.qqbanner.manager.VasADBannerManager;
import cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager;
import cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager;
import cooperation.vip.qqbanner.manager.VasADImmersionBannerManager;
import java.util.Map;

public class VasADBannerConfigInfo
{
  public SparseArray<VasADBannerConfigInfo.ResourceInfo> a = new SparseArray();
  private VasADBannerData b;
  private int c;
  
  public VasADBannerConfigInfo(Map<String, String> paramMap)
  {
    a(paramMap);
  }
  
  public static VasADBannerConfigInfo a(Map<String, String> paramMap, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1508607: 
      if (paramString.equals("1176")) {
        i = 5;
      }
      break;
    case 1508454: 
      if (paramString.equals("1128")) {
        i = 3;
      }
      break;
    case 1508392: 
      if (paramString.equals("1108")) {
        i = 1;
      }
      break;
    case 1507456: 
      if (paramString.equals("1012")) {
        i = 0;
      }
      break;
    case 50: 
      if (paramString.equals("2")) {
        i = 2;
      }
      break;
    case 49: 
      if (paramString.equals("1")) {
        i = 4;
      }
      break;
    }
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 5) {
            return null;
          }
          return new VasADBannerCountDownImmersionInfo(paramMap);
        }
        return new VasADBannerImmersionInfo(paramMap);
      }
      return new VasADBannerCountDownInfo(paramMap);
    }
    return new VasADBannerConfigInfo(paramMap);
  }
  
  public VasADBannerData a()
  {
    return this.b;
  }
  
  public void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        VasADBannerData localVasADBannerData = VasADBannerData.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("splash_union_banner_type_res_type");
        localStringBuilder.append(paramString);
        localVasADBannerData = localVasADBannerData.a(paramSharedPreferences.getInt(localStringBuilder.toString(), 0));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("splash_union_banner_jump_url_");
        localStringBuilder.append(paramString);
        localVasADBannerData = localVasADBannerData.a(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("splash_union_banner_jump_type_");
        localStringBuilder.append(paramString);
        localVasADBannerData = localVasADBannerData.b(paramSharedPreferences.getInt(localStringBuilder.toString(), -1));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("splash_union_banner_traceinfo_");
        localStringBuilder.append(paramString);
        localVasADBannerData = localVasADBannerData.b(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("splash_union_banner_adid_");
        localStringBuilder.append(paramString);
        localVasADBannerData = localVasADBannerData.c(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("splash_union_banner_res_path_");
        localStringBuilder.append(paramString);
        localVasADBannerData = localVasADBannerData.e(paramSharedPreferences.getString(localStringBuilder.toString(), ""));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("splash_union_banner_type_");
        localStringBuilder.append(paramString);
        paramSharedPreferences = localVasADBannerData.d(paramSharedPreferences.getString(localStringBuilder.toString(), "-1")).b();
        paramString = new VasADBannerConfigInfo.ResourceInfo();
        paramString.c = paramSharedPreferences.g;
        this.b = paramSharedPreferences;
        this.a.put(1, paramString);
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
  }
  
  public void a(String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("");
    localObject2 = VasSplashUtil.a((Context)localObject1, ((StringBuilder)localObject2).toString());
    if (localObject2 != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = this.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString.e);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = ((SharedPreferences)localObject2).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_type_res_type");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), paramString.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_jump_url_");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramString.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_jump_type_");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), paramString.c);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_traceinfo_");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramString.d);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_adid_");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramString.e);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_type_");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramString.f);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splash_union_banner_res_path_");
      localStringBuilder.append((String)localObject1);
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramString.g);
      ((SharedPreferences.Editor)localObject2).apply();
    }
  }
  
  protected void a(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      QLog.e("VasADBannerConfigInfo", 1, "buildData error with bannerData is null");
      return;
    }
    try
    {
      localObject = new VasADBannerConfigInfo.ResourceInfo();
      ((VasADBannerConfigInfo.ResourceInfo)localObject).a = ((String)paramMap.get("res_url"));
      ((VasADBannerConfigInfo.ResourceInfo)localObject).b = ((String)paramMap.get("res_url_md5"));
      ((VasADBannerConfigInfo.ResourceInfo)localObject).c = VasADBannerResDownloadManager.a().a(((VasADBannerConfigInfo.ResourceInfo)localObject).a);
      this.a.put(1, localObject);
      this.b = VasADBannerData.a().a((String)paramMap.get("jump_url")).b((String)paramMap.get("traceinfo")).c((String)paramMap.get("adId")).d((String)paramMap.get("bannertype")).e(((VasADBannerConfigInfo.ResourceInfo)localObject).c).b();
      if (!TextUtils.isEmpty((CharSequence)paramMap.get("res_type"))) {
        this.b.a = Integer.parseInt((String)paramMap.get("res_type"));
      }
      if (!TextUtils.isEmpty((CharSequence)paramMap.get("jump_type"))) {
        this.b.c = Integer.parseInt((String)paramMap.get("jump_type"));
      }
      if (!TextUtils.isEmpty((CharSequence)paramMap.get("WebViewPreloadFlag")))
      {
        this.c = Integer.parseInt((String)paramMap.get("WebViewPreloadFlag"));
        return;
      }
      this.c = 1;
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildData error msg = ");
      ((StringBuilder)localObject).append(paramMap.getMessage());
      QLog.e("VasADBannerConfigInfo", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean b()
  {
    return this.c == 1;
  }
  
  public VasADBannerManager c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((VasADBannerData)localObject).f)) {
        return null;
      }
      localObject = this.b.f;
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 1508607: 
        if (((String)localObject).equals("1176")) {
          i = 5;
        }
        break;
      case 1508454: 
        if (((String)localObject).equals("1128")) {
          i = 3;
        }
        break;
      case 1508392: 
        if (((String)localObject).equals("1108")) {
          i = 1;
        }
        break;
      case 1507456: 
        if (((String)localObject).equals("1012")) {
          i = 0;
        }
        break;
      case 50: 
        if (((String)localObject).equals("2")) {
          i = 2;
        }
        break;
      case 49: 
        if (((String)localObject).equals("1")) {
          i = 4;
        }
        break;
      }
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if ((i != 3) && (i != 4))
          {
            if (i != 5) {
              return null;
            }
            return new VasADCountDownInmersionBannerManager();
          }
          return new VasADImmersionBannerManager();
        }
        return new VasADBannerCountDownManager();
      }
      return new VasADBannerManager();
    }
    return null;
  }
  
  public boolean d()
  {
    VasADBannerData localVasADBannerData = this.b;
    return (localVasADBannerData != null) && (("1".equals(localVasADBannerData.f)) || ("2".equals(this.b.f)));
  }
  
  public boolean e()
  {
    int i = 0;
    while (i < this.a.size())
    {
      VasADBannerConfigInfo.ResourceInfo localResourceInfo = (VasADBannerConfigInfo.ResourceInfo)this.a.valueAt(i);
      if ((localResourceInfo != null) && (!TextUtils.isEmpty(localResourceInfo.c)))
      {
        if (!localResourceInfo.a()) {
          return false;
        }
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.info.VasADBannerConfigInfo
 * JD-Core Version:    0.7.0.1
 */