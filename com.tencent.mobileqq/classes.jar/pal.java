import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment;

public class pal
  implements View.OnClickListener
{
  public pal(ReadInJoyProteusFamilyFragment paramReadInJoyProteusFamilyFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadInJoyProteusFamilyFragment.a(this.a) != null) {
      ReadInJoyProteusFamilyFragment.a(this.a).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pal
 * JD-Core Version:    0.7.0.1
 */