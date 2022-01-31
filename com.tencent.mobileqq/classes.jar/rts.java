import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import mqq.app.AppRuntime;

public class rts
  implements View.OnClickListener
{
  public rts(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyListViewGroup.b(this.a);
    paramView = ((KandianMergeManager)ors.a().getManager(162)).a();
    if ((paramView != null) && (paramView.isFromNotification))
    {
      ors.a(this.a.getContext(), 5, false, paramView.mMsgId);
      return;
    }
    ors.a(this.a.getContext(), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rts
 * JD-Core Version:    0.7.0.1
 */