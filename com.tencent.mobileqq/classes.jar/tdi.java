import android.database.DataSetObserver;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;

public class tdi
  extends DataSetObserver
{
  public tdi(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void onChanged()
  {
    int j = 0;
    Object localObject = LebaListMgrActivity.a(this.a);
    if (LebaListMgrActivity.a(this.a).getCount() > 0)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = LebaListMgrActivity.a(this.a);
      if (LebaListMgrActivity.a(this.a).a() <= 0) {
        break label65;
      }
    }
    label65:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdi
 * JD-Core Version:    0.7.0.1
 */