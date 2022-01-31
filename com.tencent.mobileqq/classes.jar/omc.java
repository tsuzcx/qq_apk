import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class omc
  implements AdapterView.OnItemClickListener
{
  public omc(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    HorizontalSelectColorLayout.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omc
 * JD-Core Version:    0.7.0.1
 */