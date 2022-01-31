import android.content.res.Resources;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SelectLimitListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class ruh
  implements PhotoListPanel.SelectLimitListener
{
  public ruh(BaseChatPie paramBaseChatPie) {}
  
  public boolean a(int paramInt)
  {
    String str = String.format(this.a.a().getString(2131439024), new Object[] { Integer.valueOf(paramInt) });
    QQToast.a(this.a.a(), str, 0).b(this.a.a().getResources().getDimensionPixelSize(2131558448));
    ReportController.b(this.a.a, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ruh
 * JD-Core Version:    0.7.0.1
 */