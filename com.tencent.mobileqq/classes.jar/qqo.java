import android.database.DataSetObserver;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;

public class qqo
  extends DataSetObserver
{
  public qqo(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqo
 * JD-Core Version:    0.7.0.1
 */