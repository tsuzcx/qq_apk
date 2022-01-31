import android.view.View;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class stw
  implements AdapterView.OnItemClickListener
{
  public stw(Leba paramLeba) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.c()) {
      ThreadManager.post(new stx(this, paramView, paramInt), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     stw
 * JD-Core Version:    0.7.0.1
 */