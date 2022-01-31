import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailCustomModuleBaseWrapper;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class kqs
  implements View.OnClickListener
{
  public kqs(AccountDetailCustomModuleBaseWrapper paramAccountDetailCustomModuleBaseWrapper) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof PaConfigAttr.PaConfigInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "click!");
      }
      paramView = (PaConfigAttr.PaConfigInfo)paramView;
      if (this.a.a != null) {
        this.a.a.a(paramView);
      }
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqs
 * JD-Core Version:    0.7.0.1
 */