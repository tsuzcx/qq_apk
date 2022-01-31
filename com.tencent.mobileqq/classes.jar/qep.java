import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import java.util.List;

public class qep
  implements AdapterView.OnItemLongClickListener
{
  public qep(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!ReadInJoyDeliverUGCActivity.a(this.a).a().get(paramInt).equals(ReadInJoyDeliverUGCActivity.a(this.a))) {
      ReadInJoyDeliverUGCActivity.a(this.a).a(paramInt);
    }
    ReadInJoyDeliverUGCActivity.a(this.a, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qep
 * JD-Core Version:    0.7.0.1
 */