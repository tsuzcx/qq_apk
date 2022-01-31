import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;

class obj
  implements obo
{
  obj(obg paramobg) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = obg.c(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      obg.c(this.a, paramGiftServiceBean);
      obg.c(this.a).setText(paramGiftServiceBean.t);
    }
    obg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obj
 * JD-Core Version:    0.7.0.1
 */