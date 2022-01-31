import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import cooperation.readinjoy.ReadInJoyHelper;

public class lwa
  implements View.OnClickListener
{
  public lwa(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, ReadInJoyHelper.a(), "", "", ReadInJoyUtils.c(), false);
    if (this.a.a.a != null) {
      this.a.a.a.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwa
 * JD-Core Version:    0.7.0.1
 */