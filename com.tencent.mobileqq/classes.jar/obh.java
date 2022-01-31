import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class obh
  implements obo
{
  obh(obg paramobg) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = obg.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      obg.a(this.a, paramGiftServiceBean);
      obg.a(this.a).setText(paramGiftServiceBean.t);
      obg.b(this.a, null);
      if (obg.a(this.a)) {
        obg.c(this.a, null);
      }
      obg.b(this.a).setText("");
      obg.c(this.a).setText("");
      obg.a(this.a, new ArrayList());
      localObject = obg.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          obg.b(this.a).add(localGiftServiceBean);
        }
      }
      if (obg.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = ajyc.a(2131705271);
        paramGiftServiceBean.v = "0";
        obg.b(this.a).add(paramGiftServiceBean);
      }
      obg.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obh
 * JD-Core Version:    0.7.0.1
 */