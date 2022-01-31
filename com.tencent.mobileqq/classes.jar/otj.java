import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class otj
  implements WXShareHelper.WXShareListener
{
  public otj(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.g == null) || (!this.a.g.equals(paramBaseResp.transaction))) {
      return;
    }
    String str1;
    label53:
    String str3;
    int i;
    if (this.a.jdField_c_of_type_Int == 2)
    {
      if (this.a.h != 2) {
        break label151;
      }
      str1 = "qr_wechat";
      str3 = this.a.jdField_c_of_type_JavaLangString;
      i = this.a.a;
      if (paramBaseResp.errCode != 0) {
        break label157;
      }
    }
    label151:
    label157:
    for (String str2 = "0";; str2 = "1")
    {
      TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, String.valueOf(i), str2 });
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        QRUtils.a(1, 2131435303);
        return;
        str1 = "qr_circle";
        break label53;
      }
    }
    QRUtils.a(2, 2131435302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otj
 * JD-Core Version:    0.7.0.1
 */