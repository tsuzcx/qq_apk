import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class obf
  implements obl
{
  obf(obd paramobd) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = obd.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      obd.b(this.a, paramGiftServiceBean);
      obd.b(this.a).setText(paramGiftServiceBean.t);
      if (obd.a(this.a)) {
        obd.c(this.a, null);
      }
      obd.c(this.a).setText("");
      if (obd.c(this.a) != null) {
        obd.c(this.a).clear();
      }
      obd.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obf
 * JD-Core Version:    0.7.0.1
 */