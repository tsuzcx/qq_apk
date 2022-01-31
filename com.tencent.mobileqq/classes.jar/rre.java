import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class rre
  extends alxv
{
  rre(rqj paramrqj) {}
  
  protected void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (pid.a(this.a.a(), str) < qlx.d)
    {
      this.a.a.c(6);
      return;
    }
    QQToast.a(this.a.a(), 0, this.a.a().getString(2131719054), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rre
 * JD-Core Version:    0.7.0.1
 */