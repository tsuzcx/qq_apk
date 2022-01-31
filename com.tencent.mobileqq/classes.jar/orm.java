import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class orm
  implements AdapterView.OnItemClickListener
{
  public orm(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QRDisplayActivity.a(this.a).b();
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131435302;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(this.a, this.a.getString(i), 0).b(this.a.getTitleBarHeight());
        if (this.a.jdField_c_of_type_Int == 2) {
          if (paramLong != 2L) {
            break label165;
          }
        }
        label165:
        for (paramAdapterView = "qr_wechat";; paramAdapterView = "qr_circle")
        {
          TroopReportor.a("Grp_share", "grpData_admin", paramAdapterView, 0, 0, new String[] { this.a.jdField_c_of_type_JavaLangString, String.valueOf(this.a.a), "1" });
          this.a.h = -1;
          return;
          if (WXShareHelper.a().b()) {
            break label230;
          }
          i = 2131435303;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
      }
      this.a.h = ((int)paramLong);
      QRDisplayActivity.a(this.a);
      return;
      label230:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orm
 * JD-Core Version:    0.7.0.1
 */