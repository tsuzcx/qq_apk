import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class orp
  implements orw
{
  orp(oro paramoro) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = oro.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      oro.a(this.a, paramGiftServiceBean);
      oro.a(this.a).setText(paramGiftServiceBean.t);
      oro.b(this.a, null);
      if (oro.a(this.a)) {
        oro.c(this.a, null);
      }
      oro.b(this.a).setText("");
      oro.c(this.a).setText("");
      oro.a(this.a, new ArrayList());
      localObject = oro.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          oro.b(this.a).add(localGiftServiceBean);
        }
      }
      if (oro.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = anni.a(2131704061);
        paramGiftServiceBean.v = "0";
        oro.b(this.a).add(paramGiftServiceBean);
      }
      oro.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orp
 * JD-Core Version:    0.7.0.1
 */