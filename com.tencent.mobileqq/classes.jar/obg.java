import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;

class obg
  implements obl
{
  obg(obd paramobd) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = obd.c(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      obd.c(this.a, paramGiftServiceBean);
      obd.c(this.a).setText(paramGiftServiceBean.t);
    }
    obd.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obg
 * JD-Core Version:    0.7.0.1
 */