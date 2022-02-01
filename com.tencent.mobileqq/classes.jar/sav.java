import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import java.util.List;
import java.util.Map;

public class sav
  extends sau
{
  public sav(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramList, paramInt, paramArrayOfString, paramArrayOfInt, arrayOfInt);
  }
  
  protected void a(View paramView, ResultRecord paramResultRecord)
  {
    if ((paramView == null) || (FollowingListFragment.a(this.b) == null) || (FollowingListFragment.a(this.b).a() == null) || (FollowingListFragment.a(this.b).a().isEmpty())) {
      return;
    }
    paramView = (CheckBox)paramView.findViewById(2131364612);
    paramView.setBackgroundResource(2130849413);
    if (FollowingListFragment.a(this.b).a().contains(paramResultRecord.a()))
    {
      paramView.setEnabled(false);
      return;
    }
    paramView.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sav
 * JD-Core Version:    0.7.0.1
 */