import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class pgy
  extends anav
{
  pgy(pgx parampgx) {}
  
  protected void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (pxs.a(pgx.a(this.a).a().a(), str) < rea.d)
    {
      ((ReadInJoyXListView)pgx.a(this.a).a().a().a()).c(6);
      return;
    }
    QQToast.a(pgx.a(this.a).a().a(), 0, pgx.a(this.a).a().a().getString(2131717546), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgy
 * JD-Core Version:    0.7.0.1
 */