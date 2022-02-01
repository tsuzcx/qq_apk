import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;

class orr
  implements orw
{
  orr(oro paramoro) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = oro.c(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      oro.c(this.a, paramGiftServiceBean);
      oro.c(this.a).setText(paramGiftServiceBean.t);
    }
    oro.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orr
 * JD-Core Version:    0.7.0.1
 */