import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class rns
  implements wxt
{
  rns(rnr paramrnr) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("readinjoy_to_wx_config");
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "config = " + i);
    }
    if (i == 0) {
      WxShareHelperFromReadInjoy.a().a(rnr.b(this.a), rnr.a(this.a), 0, false);
    }
    for (;;)
    {
      rnr.a(this.a).recycle();
      rnr.a(this.a, null);
      return;
      WXShareHelper.a().a(rnr.b(this.a), rnr.a(this.a), 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rns
 * JD-Core Version:    0.7.0.1
 */