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
  private CountDownImmersionData a;
  
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
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localResourceInfo);
  }
  
  public CountDownImmersionData a()
  {
    if (a() == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData;
  }
  
  protected void a(Map<String, String> paramMap)
  {
    super.a(paramMap);
    if ((paramMap != null) && (!paramMap.isEmpty())) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData = CountDownImmersionData.a().a((String)paramMap.get("topText")).b((String)paramMap.get("bottomText")).c((String)paramMap.get("text_png")).d((String)paramMap.get("end_timeColor")).e((String)paramMap.get("cartoon")).f((String)paramMap.get("cartoon_md5")).g((String)paramMap.get("end_pic")).h((String)paramMap.get("end_cartoon")).i((String)paramMap.get("end_res_url")).b();
        if (!TextUtils.isEmpty((CharSequence)paramMap.get("end_time"))) {
          this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData.jdField_a_of_type_Long = Integer.parseInt((String)paramMap.get("end_time"));
        }
        if (!TextUtils.isEmpty((CharSequence)paramMap.get("fixed_type")))
        {
          localObject = this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData;
          if (Integer.parseInt((String)paramMap.get("fixed_type")) != 1) {
            break label373;
          }
          bool = true;
          ((CountDownImmersionData)localObject).jdField_a_of_type_Boolean = bool;
        }
        a(5, this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData.f, this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData.g);
        a(3, this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData.d, "");
        a(6, this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData.i, "");
        a(4, this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData.h, "");
        a(7, this.jdField_a_of_type_CooperationVipQqbannerDataCountDownImmersionData.j, "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.info.VasADBannerCountDownImmersionInfo
 * JD-Core Version:    0.7.0.1
 */