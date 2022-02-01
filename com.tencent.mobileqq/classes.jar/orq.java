import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class orq
  implements orw
{
  orq(oro paramoro) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = oro.b(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      oro.b(this.a, paramGiftServiceBean);
      oro.b(this.a).setText(paramGiftServiceBean.t);
      if (oro.a(this.a)) {
        oro.c(this.a, null);
      }
      oro.c(this.a).setText("");
      if (oro.c(this.a) != null) {
        oro.c(this.a).clear();
      }
      oro.a(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orq
 * JD-Core Version:    0.7.0.1
 */