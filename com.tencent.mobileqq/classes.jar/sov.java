import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import friendlist.GetOnlineInfoResp;

public class sov
  extends FriendListObserver
{
  public sov(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramString)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      FriendProfileCardActivity.a(this.a);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null))
    {
      paramString1 = (FriendsManager)this.a.app.getManager(50);
      if ((ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramString1 != null))
      {
        paramString2 = paramString1.c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramString2 != null)
        {
          paramString1 = "";
          if (paramString2.remark != null) {
            paramString1 = paramString2.remark;
          }
          this.a.d(paramString1);
          if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
          }
        }
      }
    }
  }
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.app.getManager(50)).a(this.a.app.getCurrentAccountUin());
      if (localExtensionInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setNewSignature(localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("result_uin");
      if ((ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne).equals(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramBundle + ", mobileNum = " + paramString);
        }
        paramString = this.a.a(paramBundle, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        if (paramString == null) {
          paramString = paramBundle;
        }
        for (;;)
        {
          localMessage.obj = paramString;
          this.a.b.sendMessage(localMessage);
          return;
        }
      }
    } while ((paramBundle == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!paramBundle.equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
    ThreadManager.post(new sox(this, paramBundle, paramString), 8, null, true);
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    Object localObject2;
    label57:
    label221:
    label223:
    do
    {
      return;
      if (ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject2 = (PhoneContactManager)this.a.app.getManager(10);
        if (localObject2 == null)
        {
          if ((localObject1 == null) || (((PhoneContact)localObject1).mobileNo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!((PhoneContact)localObject1).mobileNo.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
            break label221;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString + ", pc.mobileNo = " + ((PhoneContact)localObject1).mobileNo);
          }
          localObject1 = this.a.a(paramString, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          localObject2 = Message.obtain();
          ((Message)localObject2).what = 3;
          if (localObject1 != null) {
            break label223;
          }
        }
        for (;;)
        {
          ((Message)localObject2).obj = paramString;
          this.a.b.sendMessage((Message)localObject2);
          return;
          localObject1 = ((PhoneContactManager)localObject2).a(paramString);
          break label57;
          break;
          paramString = (String)localObject1;
        }
      }
    } while ((paramString == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    localObject1 = (FriendsManager)this.a.app.getManager(50);
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 3;
      if (localObject1 != null) {
        break label381;
      }
    }
    for (;;)
    {
      ((Message)localObject2).obj = paramString;
      this.a.b.sendMessage((Message)localObject2);
      return;
      localObject1 = ((FriendsManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label381:
      paramString = (String)localObject1;
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131433261, 2);
      this.a.finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onUpdateFriendList " + paramBoolean1 + ", " + paramBoolean2);
    }
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null))
    {
      localObject2 = (FriendsManager)this.a.app.getManager(50);
      if (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label156;
      }
      if (localObject2 != null)
      {
        localObject2 = ((FriendsManager)localObject2).c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (localObject2 != null)
        {
          localObject1 = "";
          if (((Friends)localObject2).remark != null) {
            localObject1 = ((Friends)localObject2).remark;
          }
          this.a.d((String)localObject1);
        }
      }
    }
    label156:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          this.a.a(0L, null, null, false);
          return;
        }
        Object localObject3 = (PhoneContactManager)this.a.app.getManager(10);
        if (localObject3 == null) {}
        while ((localObject2 != null) && (localObject1 != null) && (((FriendsManager)localObject2).b(((PhoneContact)localObject1).uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, pc.uin: " + ((PhoneContact)localObject1).uin);
          }
          localObject3 = this.a.a(((PhoneContact)localObject1).uin, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          Message localMessage = Message.obtain();
          localMessage.what = 3;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = ((PhoneContact)localObject1).uin;
          }
          localMessage.obj = localObject2;
          this.a.b.sendMessage(localMessage);
          return;
          localObject1 = ((PhoneContactManager)localObject3).c(FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        }
      }
    } while ((localObject2 == null) || (!((FriendsManager)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.post(new sow(this), 5, null, false);
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    String str;
    do
    {
      return;
      str = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    } while ((str == null) || (!str.equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, 1, str, false);
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      FriendProfileCardActivity.a(this.a);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((paramArrayOfString[i] == null) || (!paramArrayOfString[i].equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label99;
        }
        paramArrayOfString = ((FriendsManager)this.a.app.getManager(50)).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramArrayOfString != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramArrayOfString.getRichStatus());
        }
      }
      return;
      label99:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sov
 * JD-Core Version:    0.7.0.1
 */