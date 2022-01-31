import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class srw
  implements View.OnClickListener
{
  public srw(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362740)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
        localActionSheet.a(2131435885, 3);
        localActionSheet.c(2131433015);
        localActionSheet.a(new srx(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srw
 * JD-Core Version:    0.7.0.1
 */