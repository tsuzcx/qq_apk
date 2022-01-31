import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloManager.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class srn
  implements Runnable
{
  WeakReference a;
  
  public srn(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    this.a = new WeakReference(paramFriendProfileCardActivity);
  }
  
  public void run()
  {
    boolean bool2 = false;
    int[] arrayOfInt = null;
    if ((this.a == null) || (this.a.get() == null)) {}
    FriendProfileCardActivity localFriendProfileCardActivity;
    do
    {
      do
      {
        return;
        localFriendProfileCardActivity = (FriendProfileCardActivity)this.a.get();
      } while ((localFriendProfileCardActivity == null) || (localFriendProfileCardActivity.app == null) || (localFriendProfileCardActivity.b == null));
      if (((ApolloManager)localFriendProfileCardActivity.app.getManager(152) == null) || (localFriendProfileCardActivity.a == null) || (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
        break;
      }
      if ((!localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(localFriendProfileCardActivity.app.getCurrentAccountUin())) && ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(localFriendProfileCardActivity.app.getCurrentAccountUin())))) {
        break label333;
      }
    } while (ApolloManager.a(localFriendProfileCardActivity.app, "mycard", null) <= 0);
    label167:
    ApolloSoLoader.a("FriendCard");
    if ((localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (String str = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;; str = null)
    {
      if ((TextUtils.isEmpty(str)) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        str = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        Object localObject = ((ApolloManager)localFriendProfileCardActivity.app.getManager(152)).a(str);
        int i;
        if (localObject != null)
        {
          localFriendProfileCardActivity.m = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = ((ApolloBaseInfo)localObject).getApolloDress();
          if (localObject != null)
          {
            i = ((ApolloDress)localObject).jdField_a_of_type_Int;
            arrayOfInt = ((ApolloDress)localObject).a();
          }
        }
        for (;;)
        {
          if (!ApolloActionHelper.a(localFriendProfileCardActivity.app, 7))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("FriendProfileCardActivity", 2, "checkDrawerBasicApolloAction up and down not ready");
            return;
            label333:
            if (ApolloManager.a(localFriendProfileCardActivity.app, "friendcard", null) > 0) {
              break label167;
            }
            return;
          }
          localObject = localFriendProfileCardActivity.b.obtainMessage(101);
          localFriendProfileCardActivity.o = ((FriendsManager)localFriendProfileCardActivity.app.getManager(50)).b(str);
          boolean bool1;
          if ((ApolloManager.a(localFriendProfileCardActivity.app) == 1) && (!localFriendProfileCardActivity.o))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(str))
            {
              bool1 = bool2;
              if (!str.equals(localFriendProfileCardActivity.app.c())) {}
            }
          }
          else
          {
            bool1 = true;
          }
          localFriendProfileCardActivity.n = bool1;
          ApolloManager.CheckApolloInfoResult localCheckApolloInfoResult = new ApolloManager.CheckApolloInfoResult();
          ((Message)localObject).obj = localCheckApolloInfoResult;
          localCheckApolloInfoResult.jdField_a_of_type_Int = i;
          localCheckApolloInfoResult.jdField_a_of_type_ArrayOfInt = arrayOfInt;
          if ((i <= 0) || (arrayOfInt == null) || (arrayOfInt.length <= 0) || (localFriendProfileCardActivity.m != 1) || ((i > 0) && (arrayOfInt != null) && (!ApolloActionHelper.a(str, i, arrayOfInt, localFriendProfileCardActivity.app))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendProfileCardActivity", 2, "roleId->" + i + " dressIds->" + arrayOfInt + " apolloStatus->" + localFriendProfileCardActivity.m);
            }
            localCheckApolloInfoResult.jdField_a_of_type_Boolean = true;
            return;
          }
          if (!ApolloEngine.a())
          {
            localCheckApolloInfoResult.jdField_a_of_type_Boolean = true;
            return;
          }
          localFriendProfileCardActivity.b.sendMessage((Message)localObject);
          return;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srn
 * JD-Core Version:    0.7.0.1
 */