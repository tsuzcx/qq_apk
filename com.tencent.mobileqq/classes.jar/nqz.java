import android.view.View;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public final class nqz
  implements yyc
{
  nqz(AppInterface paramAppInterface) {}
  
  public void reportImpression(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcshopAdHandler", 1, "--> reportImpression");
    }
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.getTag(2131364123);
    } while (paramView == null);
    ThreadManagerV2.executeOnSubThread(new EcshopAdHandler.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqz
 * JD-Core Version:    0.7.0.1
 */