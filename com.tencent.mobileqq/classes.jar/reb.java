import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import mqq.app.AppRuntime;

public class reb
  implements View.OnClickListener
{
  public reb(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyListViewGroup.b(this.a);
    paramView = ((KandianMergeManager)onk.a().getManager(162)).a();
    if ((paramView != null) && (paramView.isFromNotification))
    {
      onk.a(this.a.getContext(), 5, false, paramView.mMsgId);
      return;
    }
    onk.a(this.a.getContext(), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     reb
 * JD-Core Version:    0.7.0.1
 */