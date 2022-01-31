import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class sug
  implements View.OnLongClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new sui(this);
  DataTag jdField_a_of_type_ComTencentMobileqqProfileDataTag;
  
  public sug(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof DataTag))) {
      return false;
    }
    Object localObject = (DataTag)paramView.getTag();
    switch (((DataTag)localObject).a)
    {
    }
    for (;;)
    {
      return true;
      paramView.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqProfileDataTag = ((DataTag)localObject);
      localObject = new QQCustomMenu();
      ((QQCustomMenu)localObject).a(2131375639, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131435109), 2130838310);
      BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, new suh(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sug
 * JD-Core Version:    0.7.0.1
 */