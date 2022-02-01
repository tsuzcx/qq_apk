import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sln
  implements View.OnClickListener
{
  public sln(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a).setText("");
    ReadinjoyTabFrame.a(this.a).setVisibility(8);
    ubg.a(this.a.a, true);
    ((KandianMergeManager)this.a.a.getManager(162)).d(true);
    ozs.a(this.a.a(), 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sln
 * JD-Core Version:    0.7.0.1
 */