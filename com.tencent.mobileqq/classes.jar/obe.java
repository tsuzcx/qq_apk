import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class obe
  implements obl
{
  obe(obd paramobd) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = obd.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      obd.a(this.a, paramGiftServiceBean);
      obd.a(this.a).setText(paramGiftServiceBean.t);
      obd.b(this.a, null);
      if (obd.a(this.a)) {
        obd.c(this.a, null);
      }
      obd.b(this.a).setText("");
      obd.c(this.a).setText("");
      obd.a(this.a, new ArrayList());
      localObject = obd.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          obd.b(this.a).add(localGiftServiceBean);
        }
      }
      if (obd.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = ajya.a(2131705282);
        paramGiftServiceBean.v = "0";
        obd.b(this.a).add(paramGiftServiceBean);
      }
      obd.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obe
 * JD-Core Version:    0.7.0.1
 */