import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class pqj
  extends aodk
{
  pqj(pqi parampqi) {}
  
  protected void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (qjw.a(pqi.a(this.a).a().a(), str) < rqh.d)
    {
      ((ReadInJoyXListView)pqi.a(this.a).a().a().a()).c(6);
      return;
    }
    QQToast.a(pqi.a(this.a).a().a(), 0, pqi.a(this.a).a().a().getString(2131717912), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqj
 * JD-Core Version:    0.7.0.1
 */