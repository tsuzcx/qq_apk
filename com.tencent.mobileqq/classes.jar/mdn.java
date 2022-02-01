import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class mdn
  implements View.OnClickListener
{
  public mdn(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.a.d, 1, "quit double screen from reset clicker");
    if ((this.a.a != null) && (this.a.a.get() != null) && ((this.a.a.get() instanceof AVActivity))) {
      ((AVActivity)this.a.a.get()).BtnOnClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mdn
 * JD-Core Version:    0.7.0.1
 */