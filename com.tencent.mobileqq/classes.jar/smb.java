import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class smb
  implements View.OnClickListener
{
  public smb(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a, this.a.a(), (ViewGroup)ReadinjoyTabFrame.a(this.a));
    if (BaseApplicationImpl.sProcessId != 9) {
      bodt.a(BaseApplicationImpl.getContext());
    }
    ozs.e("1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smb
 * JD-Core Version:    0.7.0.1
 */