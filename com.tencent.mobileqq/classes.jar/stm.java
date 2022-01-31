import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class stm
  implements nbs
{
  public stm(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptFeedsActivity", 2, "HtmlOffline.checkUpByBusinessId businessId=2278, code=" + paramInt);
    }
    this.a.app.getApplication();
    int i = bdee.a(MobileQQ.getContext());
    paramString = new HashMap();
    paramString.put("network", "" + i);
    paramString.put("status_code", "" + paramInt);
    azmz.a(this.a).a(null, "subscription_htmloffline", true, 0L, 0L, paramString, "", false);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     stm
 * JD-Core Version:    0.7.0.1
 */