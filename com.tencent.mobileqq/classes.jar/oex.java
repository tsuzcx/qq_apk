import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class oex
  implements ofd
{
  oex(oev paramoev) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = oev.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      oev.b(this.a, paramGiftServiceBean);
      oev.b(this.a).setText(paramGiftServiceBean.t);
      if (oev.a(this.a)) {
        oev.c(this.a, null);
      }
      oev.c(this.a).setText("");
      if (oev.c(this.a) != null) {
        oev.c(this.a).clear();
      }
      oev.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oex
 * JD-Core Version:    0.7.0.1
 */