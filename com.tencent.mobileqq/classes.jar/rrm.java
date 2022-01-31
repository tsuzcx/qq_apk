import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class rrm
  implements View.OnClickListener
{
  public rrm(ChannelTopPositionView paramChannelTopPositionView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChannelTopPositionView", 2, "onclick");
    }
    if (ChannelTopPositionView.a(this.a) != null) {
      PublicFragmentActivity.a(ChannelTopPositionView.a(this.a), ReadInJoySelectPositionFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrm
 * JD-Core Version:    0.7.0.1
 */