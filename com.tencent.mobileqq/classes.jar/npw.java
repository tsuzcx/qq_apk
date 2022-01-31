import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class npw
  implements nqd
{
  npw(npv paramnpv) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = npv.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      npv.a(this.a, paramGiftServiceBean);
      npv.a(this.a).setText(paramGiftServiceBean.t);
      npv.b(this.a, null);
      if (npv.a(this.a)) {
        npv.c(this.a, null);
      }
      npv.b(this.a).setText("");
      npv.c(this.a).setText("");
      npv.a(this.a, new ArrayList());
      localObject = npv.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          npv.b(this.a).add(localGiftServiceBean);
        }
      }
      if (npv.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = ajjy.a(2131639486);
        paramGiftServiceBean.v = "0";
        npv.b(this.a).add(paramGiftServiceBean);
      }
      npv.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npw
 * JD-Core Version:    0.7.0.1
 */