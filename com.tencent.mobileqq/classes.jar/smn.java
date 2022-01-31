import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class smn
  implements View.OnLongClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new smp(this);
  DataTag jdField_a_of_type_ComTencentMobileqqProfileDataTag;
  
  public smn(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
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
      ((QQCustomMenu)localObject).a(2131375342, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131435076), 2130838301);
      BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, new smo(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smn
 * JD-Core Version:    0.7.0.1
 */