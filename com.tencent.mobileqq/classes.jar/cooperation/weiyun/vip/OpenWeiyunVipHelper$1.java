package cooperation.weiyun.vip;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class OpenWeiyunVipHelper$1
  implements DialogInterface.OnClickListener
{
  OpenWeiyunVipHelper$1(int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (OpenWeiyunVipHelper.b(this.jdField_a_of_type_Int))
    {
      OpenWeiyunVipHelper.a(this.jdField_a_of_type_AndroidAppActivity, null, false);
      return;
    }
    OpenWeiyunVipHelper.b(this.jdField_a_of_type_AndroidAppActivity, "mvip.n.a.zcwy_popup", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.vip.OpenWeiyunVipHelper.1
 * JD-Core Version:    0.7.0.1
 */