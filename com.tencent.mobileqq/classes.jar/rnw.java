import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class rnw
  implements wxw
{
  rnw(rnu paramrnu) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("readinjoy_to_wx_config");
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "config = " + i);
    }
    if (i == 0) {
      WxShareHelperFromReadInjoy.a().a(rnu.b(this.a), rnu.a(this.a), 1, false);
    }
    for (;;)
    {
      rnu.a(this.a).recycle();
      rnu.a(this.a, null);
      return;
      WXShareHelper.a().a(rnu.b(this.a), rnu.a(this.a), 1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnw
 * JD-Core Version:    0.7.0.1
 */