import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class rbl
  implements View.OnClickListener
{
  rbl(rbk paramrbk) {}
  
  public void onClick(View paramView)
  {
    obz.a(paramView.getContext(), this.a.a.a);
    ndn.a(null, "", "0X8009BA1", "0X8009BA1", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rbl
 * JD-Core Version:    0.7.0.1
 */