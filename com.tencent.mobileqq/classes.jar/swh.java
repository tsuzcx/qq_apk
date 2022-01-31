import android.content.res.Resources;
import com.tencent.mobileqq.activity.KPLProfileCardActivity;
import com.tencent.mobileqq.widget.QQToast;

public class swh
  implements Runnable
{
  public swh(KPLProfileCardActivity paramKPLProfileCardActivity) {}
  
  public void run()
  {
    QQToast.a(this.a, this.a.getResources().getString(2131437758), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swh
 * JD-Core Version:    0.7.0.1
 */