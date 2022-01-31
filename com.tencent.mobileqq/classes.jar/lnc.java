import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public final class lnc
  implements PopupMenuDialog.OnClickActionListener
{
  public lnc(Activity paramActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      paramMenuItem = new Intent(this.a, ReadInJoyDeliverUGCActivity.class);
      paramMenuItem.putExtra("is_from_dian_dian", true);
      this.a.startActivity(paramMenuItem);
      PublicAccountReportUtils.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", ReadInJoyUtils.c(1), false);
      return;
    }
    ReadInJoyUtils.b(this.a);
    PublicAccountReportUtils.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", ReadInJoyUtils.c(2), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnc
 * JD-Core Version:    0.7.0.1
 */