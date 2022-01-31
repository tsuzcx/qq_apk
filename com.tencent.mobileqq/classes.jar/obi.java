import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class obi
  implements obo
{
  obi(obg paramobg) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = obg.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      obg.b(this.a, paramGiftServiceBean);
      obg.b(this.a).setText(paramGiftServiceBean.t);
      if (obg.a(this.a)) {
        obg.c(this.a, null);
      }
      obg.c(this.a).setText("");
      if (obg.c(this.a) != null) {
        obg.c(this.a).clear();
      }
      obg.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obi
 * JD-Core Version:    0.7.0.1
 */