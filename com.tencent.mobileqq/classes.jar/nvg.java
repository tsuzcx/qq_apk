import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;

public class nvg
  implements bexc
{
  public nvg(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 4))
    {
      paramView = new Intent(this.a.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", "3046055438");
      paramView.putExtra("from_tab", true);
      this.a.startActivity(paramView);
    }
    while (paramInt != 1) {
      return;
    }
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvg
 * JD-Core Version:    0.7.0.1
 */