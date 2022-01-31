import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;

public class mhj
  implements Runnable
{
  public mhj(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (ReadInJoyListViewGroup.a(this.a) != null) {
      ReadInJoyListViewGroup.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhj
 * JD-Core Version:    0.7.0.1
 */