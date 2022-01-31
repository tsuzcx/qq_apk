import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment;

public class lnm
  implements View.OnClickListener
{
  public lnm(ReadInJoyBBCircleFragment paramReadInJoyBBCircleFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyUtils.a(this.a.getActivity(), (ViewGroup)this.a.c());
    PublicAccountReportUtils.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnm
 * JD-Core Version:    0.7.0.1
 */