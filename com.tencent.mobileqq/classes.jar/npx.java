import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class npx
  implements nqd
{
  npx(npv paramnpv) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = npv.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      npv.b(this.a, paramGiftServiceBean);
      npv.b(this.a).setText(paramGiftServiceBean.t);
      if (npv.a(this.a)) {
        npv.c(this.a, null);
      }
      npv.c(this.a).setText("");
      if (npv.c(this.a) != null) {
        npv.c(this.a).clear();
      }
      npv.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npx
 * JD-Core Version:    0.7.0.1
 */