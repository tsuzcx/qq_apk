import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;

public class mmk
  implements Runnable
{
  public mmk(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (ReadInJoyListViewGroup.a(this.a) != null) {
      ReadInJoyListViewGroup.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmk
 * JD-Core Version:    0.7.0.1
 */