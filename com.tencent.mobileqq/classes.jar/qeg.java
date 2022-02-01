import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeUsersCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qeg
  implements View.OnClickListener
{
  public qeg(NativeUsersCommentsView paramNativeUsersCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.a.callOnClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qeg
 * JD-Core Version:    0.7.0.1
 */