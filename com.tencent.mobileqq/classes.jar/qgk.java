import android.database.DataSetObserver;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;

public class qgk
  extends DataSetObserver
{
  public qgk(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onChanged()
  {
    if (ReadInJoyVideoTagSelectionFragment.a(this.a).getCount() > 0)
    {
      ReadInJoyVideoTagSelectionFragment.a(this.a).setVisibility(0);
      String str = this.a.getString(2131718577, new Object[] { Integer.valueOf(ReadInJoyVideoTagSelectionFragment.a(this.a).getCount()), Integer.valueOf(5) });
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 5, str.length(), 0);
      ReadInJoyVideoTagSelectionFragment.a(this.a).setText(localSpannableStringBuilder);
      return;
    }
    ReadInJoyVideoTagSelectionFragment.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgk
 * JD-Core Version:    0.7.0.1
 */