import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oan
  implements View.OnClickListener
{
  public oan(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getActivity(), AccountDetailActivity.class);
    localIntent.putExtra("uin", this.a.b);
    localIntent.putExtra("uinname", this.a.b);
    localIntent.putExtra("uintype", this.a.c);
    localIntent.addFlags(67108864);
    this.a.getActivity().startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oan
 * JD-Core Version:    0.7.0.1
 */