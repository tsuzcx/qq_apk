import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class oew
  implements ofd
{
  oew(oev paramoev) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = oev.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      oev.a(this.a, paramGiftServiceBean);
      oev.a(this.a).setText(paramGiftServiceBean.t);
      oev.b(this.a, null);
      if (oev.a(this.a)) {
        oev.c(this.a, null);
      }
      oev.b(this.a).setText("");
      oev.c(this.a).setText("");
      oev.a(this.a, new ArrayList());
      localObject = oev.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          oev.b(this.a).add(localGiftServiceBean);
        }
      }
      if (oev.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = alud.a(2131705666);
        paramGiftServiceBean.v = "0";
        oev.b(this.a).add(paramGiftServiceBean);
      }
      oev.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oew
 * JD-Core Version:    0.7.0.1
 */