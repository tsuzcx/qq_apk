import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tco
  implements View.OnClickListener
{
  tco(tcn paramtcn) {}
  
  public void onClick(View paramView)
  {
    pha.a(paramView.getContext(), this.a.a.a);
    oat.a(null, "", "0X8009BA1", "0X8009BA1", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tco
 * JD-Core Version:    0.7.0.1
 */