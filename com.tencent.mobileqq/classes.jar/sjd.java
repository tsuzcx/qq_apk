import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

public class sjd
  implements AdapterView.OnItemClickListener
{
  public sjd(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.a.a()) && (this.a.isEnabled()) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.a) != null)) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.a).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sjd
 * JD-Core Version:    0.7.0.1
 */