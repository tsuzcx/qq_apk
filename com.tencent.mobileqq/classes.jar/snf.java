import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.model.CoverCacheData;
import java.util.Locale;
import mqq.app.MobileQQ;

public class snf
  implements Handler.Callback
{
  public snf(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = (FriendsManager)this.a.app.getManager(50);
    switch (paramMessage.what)
    {
    case 11: 
    case 12: 
    case 13: 
    case 17: 
    case 18: 
    default: 
    case 1: 
      do
      {
        return true;
        localObject2 = ProfilePerformanceReport.a;
        if ((localObject2 != null) && (((ProfilePerformanceReport)localObject2).a()))
        {
          ((ProfilePerformanceReport)localObject2).b(4);
          ((ProfilePerformanceReport)localObject2).a(5);
          ((ProfilePerformanceReport)localObject2).a(8);
        }
        paramMessage = (String)paramMessage.obj;
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardByDbStart", true);
        localObject1 = ProfileCardUtil.a(this.a.app, paramMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardByDbEnd", "initCardByDbStart", false);
      } while ((localObject1 == null) || (localObject3 == null));
      if ((((FriendsManager)localObject3).b(((Card)localObject1).uin)) && (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
      if ((localObject2 != null) && (((ProfilePerformanceReport)localObject2).a()))
      {
        ((ProfilePerformanceReport)localObject2).b(5);
        ((ProfilePerformanceReport)localObject2).a(6);
        ((ProfilePerformanceReport)localObject2).a(9);
      }
      if ((ProfileActivity.AllInOne.i(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (((Card)localObject1).tempChatSig != null) && (((Card)localObject1).tempChatSig.length > 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte = ((Card)localObject1).tempChatSig;
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "SUBTHREAD_MSG_INIT_CARD pa: %d uin: %s sig: %s", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), Utils.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte) }));
        }
      }
      this.a.a((Card)localObject1, false, 1);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardBySSOStart", true);
      localObject2 = ((Card)localObject1).vSeed;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57)) {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
      }
      break;
    }
    for (;;)
    {
      this.a.a(((Card)localObject1).feedPreviewTime, (byte[])localObject2, paramMessage, false);
      FriendProfileCardActivity.b(this.a);
      return true;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 37) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
        continue;
        localObject1 = this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        if ((localObject3 == null) || (localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break;
        }
        paramMessage = ProfilePerformanceReport.a;
        if ((paramMessage != null) && (paramMessage.a()))
        {
          paramMessage.b(4);
          paramMessage.a(8);
          paramMessage.a(5);
        }
        localObject1 = ((FriendsManager)localObject3).b((String)localObject1);
        localObject2 = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (localObject2 != null)
        {
          ((ContactCard)localObject1).nationCode = ((ProfileActivity.CardContactInfo)localObject2).b;
          ((ContactCard)localObject1).mobileCode = ((ProfileActivity.CardContactInfo)localObject2).c;
          ((ContactCard)localObject1).strContactName = ((ProfileActivity.CardContactInfo)localObject2).jdField_a_of_type_JavaLangString;
        }
        if ((((ContactCard)localObject1).nickName == null) || (((ContactCard)localObject1).nickName.length() == 0)) {
          ((ContactCard)localObject1).nickName = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
        }
        ((FriendsManager)localObject3).a((ContactCard)localObject1);
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Boolean = ((ContactCard)localObject1).bindQQ;
        if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
        {
          localObject2 = ((FriendsManager)localObject3).c(((ContactCard)localObject1).uin);
          if (localObject2 != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = ((Friends)localObject2).remark;
          }
        }
        this.a.a((ContactCard)localObject1, false);
        FriendProfileCardActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 4;
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).arg1 = 0;
        this.a.b.sendMessage((Message)localObject2);
        if ((paramMessage != null) && (paramMessage.a()))
        {
          paramMessage.b(5);
          paramMessage.a(6);
          paramMessage.a(9);
          paramMessage.a(7);
          paramMessage.b(7);
        }
        this.a.a(0L, null, null, false);
        return true;
        localObject2 = (QCallCardManager)this.a.app.getManager(139);
        paramMessage = (Message)localObject1;
        if (localObject2 != null)
        {
          paramMessage = ((QCallCardManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if (paramMessage != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo = paramMessage;
          }
          ((QCallCardManager)localObject2).a(paramMessage);
        }
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 6;
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).arg1 = 0;
        this.a.b.sendMessage((Message)localObject1);
        return true;
        if (paramMessage.arg1 == 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
        }
        if (paramMessage.arg2 == 1)
        {
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, true, 13);
          return true;
        }
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, 7);
        return true;
        if ((paramMessage.obj instanceof Card))
        {
          this.a.a((Card)paramMessage.obj, true, 8);
          return true;
        }
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, true, 8);
        return true;
        localObject2 = (CoverCacheData)paramMessage.obj;
        localObject3 = this.a.app.getEntityManagerFactory().createEntityManager();
        if (localObject3 == null)
        {
          paramMessage = null;
          localObject1 = paramMessage;
          if (paramMessage == null)
          {
            localObject1 = new QZoneCover();
            ((QZoneCover)localObject1).uin = Long.toString(((CoverCacheData)localObject2).a);
          }
          ((QZoneCover)localObject1).updateQzoneCover((CoverCacheData)localObject2);
          if (((QZoneCover)localObject1).getStatus() != 1000) {
            break label1263;
          }
          ((EntityManager)localObject3).a((Entity)localObject1);
        }
        for (;;)
        {
          ((EntityManager)localObject3).a();
          return true;
          paramMessage = (QZoneCover)((EntityManager)localObject3).a(QZoneCover.class, Long.toString(((CoverCacheData)localObject2).a));
          break;
          label1263:
          ((EntityManager)localObject3).a((Entity)localObject1);
        }
        if ((this.a.app == null) || (localObject3 == null)) {
          break;
        }
        paramMessage = ((FriendsManager)localObject3).a(this.a.app.getCurrentAccountUin());
        if (paramMessage == null) {
          break;
        }
        this.a.a(paramMessage.feedPreviewTime, paramMessage.vSeed, null, false);
        return true;
        localObject1 = this.a.app.getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
        localObject1 = this.a.app.getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
        this.a.N();
        return true;
        paramMessage = new Intent(this.a, QQBrowserActivity.class);
        paramMessage.putExtra("url", this.a.app.getApplication().getSharedPreferences("public_account_qq_mail_" + this.a.app.getCurrentAccountUin(), 0).getString("profile_card_tim_online_url", FriendProfileCardActivity.f));
        paramMessage.putExtra("hide_operation_bar", true);
        this.a.startActivity(paramMessage);
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007F24", "0X8007F24", 0, 0, "", "", "", "");
        return true;
        paramMessage = new Intent(this.a, QQBrowserActivity.class);
        paramMessage.putExtra("url", this.a.app.getApplication().getSharedPreferences("public_account_qq_mail_" + this.a.app.getCurrentAccountUin(), 0).getString("profile_card_qim_online_url", FriendProfileCardActivity.g));
        paramMessage.putExtra("hide_operation_bar", true);
        this.a.startActivity(paramMessage);
        return true;
        localObject3 = this.a.app.getApplication().getSharedPreferences("public_account_qq_mail_" + this.a.app.getCurrentAccountUin(), 0);
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Int == 10)
        {
          localObject1 = ((SharedPreferences)localObject3).getString("profile_card_tim_online_url", null);
          paramMessage = ((SharedPreferences)localObject3).getString("profile_card_tim_online_icon_725_url", null);
          localObject2 = ((SharedPreferences)localObject3).getString("profile_card_tim_online_wording", null);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.c = ((String)localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.b = paramMessage;
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "url_jump:" + (String)localObject1 + "; " + (String)localObject2 + "; " + paramMessage + "; " + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Int);
          }
          this.a.runOnUiThread(new sng(this));
          return true;
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Int == 11)
          {
            localObject1 = ((SharedPreferences)localObject3).getString("profile_card_qim_online_url", null);
            paramMessage = ((SharedPreferences)localObject3).getString("profile_card_qim_online_icon_url_720", null);
            localObject2 = ((SharedPreferences)localObject3).getString("profile_card_qim_online_wording", null);
            continue;
            ((PersonalityLabelHandler)this.a.app.a(112)).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0);
            return true;
          }
          else
          {
            paramMessage = null;
            localObject1 = null;
          }
        }
      }
      paramMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snf
 * JD-Core Version:    0.7.0.1
 */