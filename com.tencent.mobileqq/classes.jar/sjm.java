import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class sjm
  implements View.OnClickListener
{
  public sjm(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    WSPublicAccReport.getInstance().reportPublicAccDetailClick();
    paramView = new Intent(this.a.getActivity(), AccountDetailActivity.class);
    paramView.putExtra("uin", String.valueOf(2062433139L));
    paramView.putExtra("uintype", 1008);
    paramView.putExtra("source", 119);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjm
 * JD-Core Version:    0.7.0.1
 */