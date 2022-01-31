import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.app.ThreadManager;

public class mme
  implements View.OnClickListener
{
  public mme(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    ThreadManager.executeOnSubThread(new mmf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mme
 * JD-Core Version:    0.7.0.1
 */