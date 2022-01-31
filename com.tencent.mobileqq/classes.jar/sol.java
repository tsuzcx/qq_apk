import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.utils.UIThreadPool;
import com.tencent.mobileqq.widget.OnGetPhotoWallListener;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class sol
  extends CardObserver
{
  public sol(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "shoppingNo=" + paramString1 + "seq=" + paramInt);
          }
        } while ((!paramBoolean) || (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2)));
        if (!"0".equals(paramString1)) {
          break;
        }
        paramString1 = this.a.getSharedPreferences("is_binding_shop", 1).edit();
        paramString1.putBoolean(this.a.jdField_e_of_type_JavaLangString, false);
        paramString1.commit();
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.h));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.a.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.a.jdField_a_of_type_AndroidWidgetTextView, FriendProfileCardActivity.a(this.a));
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
    } while (this.a.isFinishing());
    this.a.z();
    this.a.a(true);
    return;
    paramString2 = ProfileShoppingPhotoInfo.getPhotoInfo(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (paramString2 != null)
    {
      this.a.h = paramString2.followType;
      this.a.c = paramString2.bindShoppingNo;
    }
    paramString2 = (CardHandler)this.a.app.a(2);
    if (paramString2 != null)
    {
      this.a.c = paramString1;
      paramString2.a(paramInt, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    paramString1 = this.a.getSharedPreferences("is_binding_shop", 1).edit();
    paramString1.putBoolean(this.a.jdField_e_of_type_JavaLangString, true);
    paramString1.commit();
  }
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    Locale localLocale;
    Object localObject1;
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (paramCard != null) {
        break label141;
      }
      localObject1 = "null";
      if (paramCard != null) {
        break label152;
      }
      localObject2 = "null";
      label26:
      if (paramCard != null) {
        break label164;
      }
    }
    label141:
    label152:
    label164:
    for (Object localObject3 = "null";; localObject3 = Integer.valueOf(paramCard.iUpgradeCount))
    {
      QLog.i("MedalWallMng", 4, String.format(localLocale, "onMedalChange isSuc: %s, iMedalCount: %s, iNewCount: %s, iUpgradeCount:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject1, localObject2, localObject3 }));
      if ((paramCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (Utils.a(paramCard.uin, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
        this.a.c();
      }
      return;
      localObject1 = Integer.valueOf(paramCard.iMedalCount);
      break;
      localObject2 = Integer.valueOf(paramCard.iNewCount);
      break label26;
    }
  }
  
  protected void a(boolean paramBoolean, Card paramCard, long paramLong)
  {
    super.a(paramBoolean, paramCard, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("zivzhou", 2, "set the status of label = " + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Object localObject1 = ProfilePerformanceReport.a;
    if ((localObject1 != null) && (((ProfilePerformanceReport)localObject1).a())) {
      ((ProfilePerformanceReport)localObject1).b(6);
    }
    if ((CrmUtils.c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (QidianManager.b(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      CrmUtils.a(this.a, null, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, -1, true, -1);
      this.a.finish();
    }
    boolean bool1 = ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))) {
      bool1 = false;
    }
    for (;;)
    {
      Object localObject2;
      if (((paramObject instanceof Card)) && (bool1))
      {
        localObject2 = (Card)paramObject;
        boolean bool2 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ((Card)localObject2).uin);
        localObject1 = localObject2;
        bool1 = bool2;
        if ((((Card)localObject2).lUserFlag & 1L) == 0L) {
          break label838;
        }
        EnterpriseQQManager.a(this.a.app).a(this.a.app, ((Card)localObject2).uin, false);
        localObject1 = localObject2;
        bool1 = bool2;
        localObject2 = localObject3;
      }
      for (;;)
      {
        label347:
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardBySSOEnd", "initCardBySSOStart", false);
        if ((bool1) && (localObject1 != null) && (paramBoolean))
        {
          localObject2 = (FriendListHandler)this.a.app.a(1);
          if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) && (localObject2 != null))
          {
            if (ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
              ((FriendListHandler)localObject2).c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label448:
            if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
            {
              localObject2 = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
              ((Message)localObject2).what = 8;
              ((Message)localObject2).obj = localObject1;
              this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject2);
            }
          }
        }
        for (;;)
        {
          this.a.b.removeMessages(100);
          this.a.b.sendEmptyMessageDelayed(100, 100L);
          if ((!paramBoolean) || (!(paramObject instanceof Card)) || (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(((Card)paramObject).uin)) || (MusicPendantManager.a() == null)) {
            break;
          }
          MusicPendantManager.a().a((Card)paramObject);
          return;
          if (((paramObject instanceof ContactCard)) && (!bool1))
          {
            localObject2 = (ContactCard)paramObject;
            bool1 = Utils.a(((ContactCard)localObject2).mobileNo, this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)));
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((ContactCard)localObject2).mobileNo;
            localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
            if ((localObject1 != null) && (((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
              ((ProfileActivity.CardContactInfo)((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_JavaUtilArrayList.get(0)).c = ((ContactCard)localObject2).mobileNo;
            }
            localObject1 = null;
            break label347;
          }
          if ((paramObject instanceof String))
          {
            localObject1 = (String)paramObject;
            if (bool1) {}
            for (bool1 = Utils.a(localObject1, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; bool1 = Utils.a(localObject1, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
            {
              localObject1 = null;
              localObject2 = localObject3;
              break;
            }
          }
          if ((!(paramObject instanceof Card)) || (bool1)) {
            break label1343;
          }
          localObject1 = (Card)paramObject;
          bool1 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o, ((Card)localObject1).encId);
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((Card)localObject1).uin;
          this.a.jdField_e_of_type_Boolean = true;
          label838:
          localObject2 = localObject3;
          break label347;
          if (localObject2 == null) {
            break label448;
          }
          ((FriendListHandler)localObject2).c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break label448;
          if ((bool1) && (localObject2 != null) && (paramBoolean))
          {
            localObject1 = (FriendListHandler)this.a.app.a(1);
            if ((localObject1 != null) && (!TextUtils.isEmpty(((ContactCard)localObject2).mobileNo))) {
              ((FriendListHandler)localObject1).e(((ContactCard)localObject2).mobileNo);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = ((ContactCard)localObject2).bindQQ;
            if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k)) {
              this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            }
            if (!TextUtils.isEmpty(((ContactCard)localObject2).nickName)) {
              this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ((ContactCard)localObject2).nickName;
            }
            localObject1 = (FriendsManager)this.a.app.getManager(50);
            if (!TextUtils.isEmpty(((ContactCard)localObject2).uin))
            {
              localObject1 = ((FriendsManager)localObject1).c(((ContactCard)localObject2).uin);
              if (localObject1 != null) {
                this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = ((Friends)localObject1).remark;
              }
            }
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = ((ContactCard)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("ContactCard", 2, "contactCard .bindQQ = " + ((ContactCard)localObject2).bindQQ + " contactCard.uin  = " + ((ContactCard)localObject2).uin);
            }
            localObject1 = Message.obtain();
            ((Message)localObject1).what = 4;
            ((Message)localObject1).obj = localObject2;
            ((Message)localObject1).arg1 = 1;
            this.a.b.sendMessage((Message)localObject1);
          }
          else if ((!paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == -1L))
          {
            QLog.e("Q.profilecard.FrdProfileCard", 1, "onCardDownload isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
            if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
            {
              localObject1 = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
              ((Message)localObject1).what = 8;
              ((Message)localObject1).obj = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
              this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject1);
            }
          }
        }
        label1343:
        bool1 = false;
        localObject1 = null;
        localObject2 = localObject3;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    this.a.d(false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onGetQZonePhotoWall isSuc:" + paramBoolean + " uin:" + paramString2);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        break label97;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramBoolean, paramString2, parammobile_sub_get_photo_wall_rsp);
    }
    label97:
    while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetOnGetPhotoWallListener == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetOnGetPhotoWallListener.a(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramCard.uin)) && (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null))
    {
      paramString = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
      paramString.what = 8;
      paramString.obj = paramCard;
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!Utils.a(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (!Utils.a(paramString1, this.a.app.getCurrentAccountUin())));
      if (!paramBoolean) {
        break;
      }
      if ((paramInt2 == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
      {
        paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
        paramString1.lVoteCount += paramInt1;
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted = 1;
        paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
        paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt - paramInt1));
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt < 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt = 0;
        }
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, -1L, false);
    return;
    UIThreadPool.a(new son(this));
  }
  
  protected void a(boolean paramBoolean, String paramString, List paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "shopName=" + paramString + ",accountFlag=" + paramInt1 + "follow_type=" + paramInt2 + ",certifiedGrade:" + paramInt3);
    }
    if (paramBoolean)
    {
      this.a.g = paramInt1;
      this.a.h = paramInt2;
      this.a.d = paramString;
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, paramInt3, paramList);
        if (paramList.size() != 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.setShoppingBgBlur(true);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, true);
    }
  }
  
  protected void b(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onUpdateMusicPendantSettings isSuccess=%s card=%s", new Object[] { Boolean.valueOf(paramBoolean), paramCard }));
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {}
    while ((!paramBoolean) || (MusicPendantManager.a() == null)) {
      return;
    }
    MusicPendantManager.a().a(paramCard);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "onGetCampusInfo isSuc: %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && ((paramObject instanceof Card)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(((Card)paramObject).uin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)paramObject);
      this.a.runOnUiThread(new som(this));
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAvatar " + paramBoolean);
      }
      if (!paramBoolean) {
        this.a.a(2131434555, 1);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
  }
  
  protected void b(boolean paramBoolean, String paramString, Card paramCard)
  {
    d(paramBoolean, paramString, paramCard);
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    this.a.I();
    if (paramBoolean) {
      this.a.a("已上传", 0);
    }
    CardHandler localCardHandler;
    for (;;)
    {
      localCardHandler = (CardHandler)this.a.app.a(2);
      if (paramBoolean) {
        break;
      }
      paramObject = (String)((Object[])(Object[])paramObject)[0];
      this.a.runOnUiThread(new sop(this, localCardHandler, paramObject));
      return;
      this.a.a("上传失败", 1);
    }
    localCardHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
  }
  
  protected void c(boolean paramBoolean, String paramString, Card paramCard)
  {
    d(paramBoolean, paramString, paramCard);
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {}
    for (;;)
    {
      return;
      if ((paramBoolean) && (paramObject != null)) {}
      try
      {
        if (!(paramObject instanceof Bundle))
        {
          QLog.e("FriendProfileCardActivity", 1, "onUpdateMusicPendantSongs data is null or is not Bundle:" + paramBoolean);
          return;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("FriendProfileCardActivity", 1, "onUpdateMusicPendantSongs：" + paramBoolean);
        return;
      }
      paramObject = (Bundle)paramObject;
      if (paramObject.containsKey("songList")) {}
      for (paramObject = (SongInfo[])paramObject.getSerializable("songList"); MusicPendantManager.a() != null; paramObject = null)
      {
        MusicPendantManager.a().a(paramObject);
        return;
      }
    }
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a("已删除", 2);
    }
    for (;;)
    {
      ((CardHandler)this.a.app.a(2)).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
      return;
      this.a.a("删除失败", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sol
 * JD-Core Version:    0.7.0.1
 */