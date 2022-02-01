package cooperation.vip.qqbanner.info;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.data.CountDownImmersionData;
import cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager;
import java.util.Map;

public class VasADBannerCountDownImmersionInfo
  extends VasADBannerConfigInfo
{
  private CountDownImmersionData b;
  
  public VasADBannerCountDownImmersionInfo(Map<String, String> paramMap)
  {
    super(paramMap);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    VasADBannerConfigInfo.ResourceInfo localResourceInfo = new VasADBannerConfigInfo.ResourceInfo();
    localResourceInfo.a = paramString1;
    localResourceInfo.b = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      localResourceInfo.c = VasADBannerResDownloadManager.a().a(paramString1);
    }
    this.a.put(paramInt, localResourceInfo);
  }
  
  protected void a(Map<String, String> paramMap)
  {
    super.a(paramMap);
    if ((paramMap != null) && (!paramMap.isEmpty())) {}
    for (;;)
    {
      try
      {
        this.b = CountDownImmersionData.a().a((String)paramMap.get("topText")).b((String)paramMap.get("bottomText")).c((String)paramMap.get("text_png")).d((String)paramMap.get("end_timeColor")).e((String)paramMap.get("cartoon")).f((String)paramMap.get("cartoon_md5")).g((String)paramMap.get("end_pic")).h((String)paramMap.get("end_cartoon")).i((String)paramMap.get("end_res_url")).b();
        if (!TextUtils.isEmpty((CharSequence)paramMap.get("end_time"))) {
          this.b.e = Integer.parseInt((String)paramMap.get("end_time"));
        }
        if (!TextUtils.isEmpty((CharSequence)paramMap.get("fixed_type")))
        {
          localObject = this.b;
          if (Integer.parseInt((String)paramMap.get("fixed_type")) != 1) {
            break label373;
          }
          bool = true;
          ((CountDownImmersionData)localObject).l = bool;
        }
        a(5, this.b.g, this.b.h);
        a(3, this.b.d, "");
        a(6, this.b.j, "");
        a(4, this.b.i, "");
        a(7, this.b.k, "");
        return;
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("banner parseJson error msg = ");
        ((StringBuilder)localObject).append(paramMap.getMessage());
        QLog.e("vas_banner|VasADBannerCountDownImmersionInfo", 1, ((StringBuilder)localObject).toString());
        return;
      }
      QLog.e("vas_banner|VasADBannerCountDownImmersionInfo", 1, "bannerData is empty");
      return;
      label373:
      boolean bool = false;
    }
  }
  
  public CountDownImmersionData f()
  {
    if (a() == null) {
      return null;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.info.VasADBannerCountDownImmersionInfo
 * JD-Core Version:    0.7.0.1
 */