package com.tencent.mobileqq.profilesetting;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.List;

class ProfileCardMoreActivity$7
  extends FriendListObserver
{
  ProfileCardMoreActivity$7(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean)
    {
      this.a.notifyUser(2131718794, 1);
      this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean)
    {
      this.a.notifyUser(2131718794, 1);
      this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin.equals(paramString1))
    {
      if (!ProfilePAUtils.isPaTypeFriend(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
        return;
      }
      if (paramBoolean)
      {
        paramString1 = this.a;
        paramString1.d = paramString2;
        paramString1.b(paramString2);
      }
      else
      {
        paramString1 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramString1 == null) {
          paramString1 = null;
        } else {
          paramString1 = paramString1.e(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
        }
        if (paramString1 != null)
        {
          if (paramString1.remark != null) {
            this.a.d = paramString1.remark;
          }
          paramString1 = this.a;
          paramString1.b(paramString1.d);
        }
      }
      paramByte = this.a.jdField_a_of_type_Int;
      int i = 1;
      if ((paramByte & 0x1) == 1)
      {
        paramString1 = this.a;
        if (paramBoolean) {
          paramByte = 2131693363;
        } else {
          paramByte = 2131693362;
        }
        if (paramBoolean) {
          i = 2;
        }
        paramString1.notifyUser(paramByte, i);
      }
      paramString1 = this.a;
      paramString1.jdField_a_of_type_Int &= 0xFFFFFFFE;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin.equals(String.valueOf(paramObject))))
    {
      this.a.notifyUser(2131691465, 2);
      if (this.a.jdField_a_of_type_AndroidContentIntent == null) {
        this.a.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
      paramObject = this.a;
      paramObject.setResult(-1, paramObject.jdField_a_of_type_AndroidContentIntent);
      this.a.finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin != null) && (ProfilePAUtils.isPaTypeFriend(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)))
    {
      Object localObject2 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject1;
      if (localObject2 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FriendsManager)localObject2).e(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      }
      if (localObject1 != null)
      {
        if (((Friends)localObject1).remark != null) {
          this.a.d = ((Friends)localObject1).remark;
        }
        ProfileCardMoreActivity localProfileCardMoreActivity = this.a;
        localProfileCardMoreActivity.b(localProfileCardMoreActivity.d);
        localObject1 = ((FriendsManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
        if ((localObject1 != null) && (!Utils.a(this.a.jdField_c_of_type_JavaLangString, ((Groups)localObject1).group_name)))
        {
          this.a.jdField_c_of_type_JavaLangString = ((Groups)localObject1).group_name;
          localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          if (TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) {
            localObject1 = "";
          } else {
            localObject1 = this.a.jdField_c_of_type_JavaLangString;
          }
          ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
        }
      }
    }
  }
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (!String.valueOf(paramLong).equals(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin)) {
      return;
    }
    paramBoolean1 ^= true;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.a.a(paramBoolean2, paramBoolean1);
      return;
    }
    if (this.a.b != null) {
      this.a.b.post(new ProfileCardMoreActivity.7.2(this, paramBoolean2, paramBoolean1));
    }
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin)))
    {
      if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, paramString)) {
        return;
      }
      paramString = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.a(String.valueOf(paramByte1));
      }
      if ((paramString != null) && (!Utils.a(this.a.jdField_c_of_type_JavaLangString, paramString.group_name)))
      {
        this.a.jdField_c_of_type_JavaLangString = paramString.group_name;
        this.a.runOnUiThread(new ProfileCardMoreActivity.7.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.7
 * JD-Core Version:    0.7.0.1
 */