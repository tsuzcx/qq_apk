import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mfi
  implements View.OnClickListener
{
  public mfi(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.a.d, 1, "quit double screen from reset clicker");
    if ((this.a.a != null) && (this.a.a.get() != null) && ((this.a.a.get() instanceof AVActivity))) {
      ((AVActivity)this.a.a.get()).BtnOnClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfi
 * JD-Core Version:    0.7.0.1
 */