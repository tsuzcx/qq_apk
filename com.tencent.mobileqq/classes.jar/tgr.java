import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.List;

public class tgr
  extends FriendListObserver
{
  public tgr(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List paramList)
  {
    if (!paramBoolean)
    {
      this.a.a(2131437762, 1);
      this.a.b.setOnCheckedChangeListener(null);
      this.a.b.setChecked(true);
      this.a.b.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List paramList)
  {
    if (!paramBoolean)
    {
      this.a.a(2131437762, 1);
      this.a.b.setOnCheckedChangeListener(null);
      this.a.b.setChecked(false);
      this.a.b.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(paramString1)) || (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
      return;
    }
    if (paramBoolean)
    {
      this.a.d = paramString2;
      this.a.b(paramString2);
      if ((this.a.jdField_a_of_type_Int & 0x1) == 1)
      {
        paramString1 = this.a;
        if (!paramBoolean) {
          break label189;
        }
        paramByte = 2131435779;
        label77:
        if (!paramBoolean) {
          break label196;
        }
      }
    }
    label187:
    label189:
    label196:
    for (int i = 2;; i = 1)
    {
      paramString1.a(paramByte, i);
      this.a.jdField_a_of_type_Int &= 0xFFFFFFFE;
      return;
      paramString1 = (FriendsManager)this.a.app.getManager(50);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = paramString1.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
      {
        if (paramString1 == null) {
          break label187;
        }
        if (paramString1.remark != null) {
          this.a.d = paramString1.remark;
        }
        this.a.b(this.a.d);
        break;
      }
      break;
      paramByte = 2131435781;
      break label77;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131433261, 2);
      if (this.a.jdField_a_of_type_AndroidContentIntent == null) {
        this.a.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
      this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
      this.a.finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != null) && (ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
    {
      localObject2 = (FriendsManager)this.a.app.getManager(50);
      if (localObject2 != null) {
        break label171;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        if (((Friends)localObject1).remark != null) {
          this.a.d = ((Friends)localObject1).remark;
        }
        this.a.b(this.a.d);
        localObject1 = ((FriendsManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
        if ((localObject1 != null) && (!Utils.a(this.a.jdField_c_of_type_JavaLangString, ((Groups)localObject1).group_name)))
        {
          this.a.jdField_c_of_type_JavaLangString = ((Groups)localObject1).group_name;
          localObject2 = this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          if (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) {
            break label190;
          }
        }
      }
    }
    label171:
    label190:
    for (Object localObject1 = "";; localObject1 = this.a.jdField_c_of_type_JavaLangString)
    {
      ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
      return;
      localObject1 = ((FriendsManager)localObject2).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      break;
    }
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) || (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramString))) {}
    for (;;)
    {
      return;
      paramString = (FriendsManager)this.a.app.getManager(50);
      if (paramString == null) {}
      for (paramString = null; (paramString != null) && (!Utils.a(this.a.jdField_c_of_type_JavaLangString, paramString.group_name)); paramString = paramString.a(String.valueOf(paramByte1)))
      {
        this.a.jdField_c_of_type_JavaLangString = paramString.group_name;
        this.a.runOnUiThread(new tgs(this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgr
 * JD-Core Version:    0.7.0.1
 */