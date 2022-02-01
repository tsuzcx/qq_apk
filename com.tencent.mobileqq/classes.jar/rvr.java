import android.database.DataSetObserver;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;

public class rvr
  extends DataSetObserver
{
  public rvr(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onChanged()
  {
    if (ReadInJoyVideoTagSelectionFragment.a(this.a).getCount() > 0)
    {
      ReadInJoyVideoTagSelectionFragment.b(this.a).setVisibility(0);
      return;
    }
    ReadInJoyVideoTagSelectionFragment.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvr
 * JD-Core Version:    0.7.0.1
 */