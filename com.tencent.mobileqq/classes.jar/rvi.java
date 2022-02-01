import android.view.View;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment;

public class rvi
  implements SimpleAdapter.ViewBinder
{
  public rvi(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public boolean setViewValue(View paramView, Object paramObject, String paramString)
  {
    if (((paramView instanceof TextView)) && ((paramObject instanceof CharSequence)))
    {
      ((TextView)paramView).setText((CharSequence)paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvi
 * JD-Core Version:    0.7.0.1
 */