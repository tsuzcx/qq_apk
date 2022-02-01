import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class qvy
  implements AdapterView.OnItemClickListener
{
  public qvy(NativeGridImageView paramNativeGridImageView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    NativeGridImageView.a(this.a, paramInt, NativeGridImageView.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvy
 * JD-Core Version:    0.7.0.1
 */