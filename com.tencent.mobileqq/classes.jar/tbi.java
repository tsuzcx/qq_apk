import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class tbi
  implements tob
{
  public tbi(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(toa paramtoa)
  {
    if (paramtoa != null) {}
    switch (paramtoa.a)
    {
    default: 
      return;
    case 2131721486: 
      WSPublicAccReport.getInstance().reportNotificationClick();
      WSHomeFragment.b(this.a);
      ((tij)this.a.b()).a(this.a.getActivity(), 602);
      return;
    }
    WSPublicAccReport.getInstance().reportPersonHomeClick();
    ((tij)this.a.b()).a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbi
 * JD-Core Version:    0.7.0.1
 */