import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;

public class mop
  implements View.OnClickListener
{
  public mop(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null)
    {
      this.a.a().c();
      PublicAccountReportUtils.a(this.a.a, "CliOper", "", "", "0X8009160", "0X8009160", 0, 1, null, null, null, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mop
 * JD-Core Version:    0.7.0.1
 */