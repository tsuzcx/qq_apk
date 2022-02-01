import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tdn
  implements View.OnClickListener
{
  public tdn(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a, this.a.a(), (ViewGroup)ReadinjoyTabFrame.a(this.a));
    if (BaseApplicationImpl.sProcessId != 9) {
      bmux.a(BaseApplicationImpl.getContext());
    }
    pqb.a("1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdn
 * JD-Core Version:    0.7.0.1
 */