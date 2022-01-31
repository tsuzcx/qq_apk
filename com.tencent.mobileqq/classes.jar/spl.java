import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class spl
  implements View.OnLongClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new spn(this);
  DataTag jdField_a_of_type_ComTencentMobileqqProfileDataTag;
  
  public spl(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
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
      ((QQCustomMenu)localObject).a(2131375573, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131435093), 2130838305);
      BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, new spm(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spl
 * JD-Core Version:    0.7.0.1
 */