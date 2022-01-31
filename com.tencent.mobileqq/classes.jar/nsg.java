import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class nsg
  implements View.OnClickListener
{
  nsg(nsc paramnsc) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToRefresh");
    nsc.a(this.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsg
 * JD-Core Version:    0.7.0.1
 */