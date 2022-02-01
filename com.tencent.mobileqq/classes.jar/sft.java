import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class sft
  extends aohg
{
  sft(sel paramsel) {}
  
  protected void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (prz.a(this.a.a(), str) < qxc.d)
    {
      this.a.a.c(6);
      return;
    }
    QQToast.a(this.a.a(), 0, this.a.a().getString(2131717314), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sft
 * JD-Core Version:    0.7.0.1
 */