import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.1.1;
import com.tencent.mobileqq.app.ThreadManager;

public class oya
  implements View.OnClickListener
{
  oya(oxz paramoxz) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    ThreadManager.executeOnSubThread(new FrameworkHandler.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oya
 * JD-Core Version:    0.7.0.1
 */