import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class t
  implements View.OnClickListener
{
  public t(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.getCurrentAccountUin(), "dl_ckadv");
    paramView = new Intent(this.a, LiteAdvanceActivity.class);
    paramView.putExtra("targetUin", this.a.b);
    this.a.startActivityForResult(paramView, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     t
 * JD-Core Version:    0.7.0.1
 */