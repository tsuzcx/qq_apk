import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class smk
  implements View.OnLayoutChangeListener
{
  public smk(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.a.post(new sml(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smk
 * JD-Core Version:    0.7.0.1
 */