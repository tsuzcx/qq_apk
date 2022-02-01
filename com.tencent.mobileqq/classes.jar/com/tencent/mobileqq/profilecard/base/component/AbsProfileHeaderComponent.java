package com.tencent.mobileqq.profilecard.base.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.config.business.qvip.QVipProfileFootPrintConfig;
import com.tencent.mobileqq.config.business.qvip.QVipProfileFootPrintProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ZanDoubleDialog;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.Pair;
import com.tencent.util.URLUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbsProfileHeaderComponent
  extends AbsProfileComponent<FrameLayout>
  implements View.OnClickListener
{
  private static final int SUB_THREAD_MSG_REQ_FAVORITE = 10;
  private static final Object S_CACHE_VOTE_LOCK = new Object();
  private static final String TAG = "AbsProfileHeaderComponent";
  private static final long VOTE_FAIL_TOAST_INTERVAL = 2000L;
  private AtomicInteger mCacheVoteNum = new AtomicInteger(0);
  protected IProfileActivityDelegate mDelegate;
  protected AbsProfileHeaderView mHeaderView;
  private long mLastToastVoteFailTime;
  private AtomicBoolean mNeedSVipDialog = new AtomicBoolean(true);
  private AtomicBoolean mOpenSVipPay = new AtomicBoolean(false);
  protected ViewGroup mRootView;
  private SVIPObserver mSVipObserver = new AbsProfileHeaderComponent.3(this);
  private Handler.Callback mSubCallback = new AbsProfileHeaderComponent.2(this);
  protected WeakReferenceHandler mSubHandler;
  private Handler.Callback mUICallback = new AbsProfileHeaderComponent.1(this);
  public WeakReferenceHandler mUIHandler;
  
  public AbsProfileHeaderComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private String getGenderString(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1)) {
      return HardCodeUtil.a(2131693332);
    }
    return HardCodeUtil.a(2131693337);
  }
  
  private int guestAvatarClickReport()
  {
    int i = 1;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
      return i;
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) {
        i = 2;
      } else if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) {
        i = 3;
      } else if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45) {
        i = 4;
      } else if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) {
        i = 5;
      } else if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
        i = 6;
      } else if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) {
        i = 7;
      } else {
        i = 0;
      }
    }
  }
  
  private void handleAvatarClick()
  {
    Object localObject;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = new Intent(this.mActivity, AvatarPendantActivity.class);
      ((Intent)localObject).putExtra("AllInOne", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.mActivity.startActivity((Intent)localObject);
    }
    while (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
      do
      {
        return;
      } while (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33);
      if (!ProfileActivity.AllInOne.g(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = FriendProfileCardActivity.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b)) && (localObject != null) && (this.mHeaderView != null))
        {
          View localView = this.mHeaderView.getChildView("map_key_face");
          if (localView != null) {
            ProfileCardUtil.a(this.mActivity, localView, (String)localObject);
          }
        }
      }
      else
      {
        handleAvatarClickInner();
      }
    }
    ReportController.b(this.mApp, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
  }
  
  private void handleAvatarClickInner()
  {
    View localView;
    long l;
    int i;
    if (this.mHeaderView != null)
    {
      localView = this.mHeaderView.getChildView("map_key_face");
      if (localView != null) {
        break label178;
      }
      localView = null;
      localObject = this.mHeaderView.getChildView("map_key_avatar_pendant");
      l = this.mHeaderView.getPendantId();
      if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (!ProfileActivity.AllInOne.g(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localView == null) || (localObject == null) || (((View)localObject).getVisibility() != 0) || (l == 0L)) {
        break label236;
      }
      i = guestAvatarClickReport();
      if ((localView instanceof DynamicAvatarView))
      {
        localObject = (DynamicAvatarView)localView;
        if (((DynamicAvatarView)localObject).a != null)
        {
          localObject = ((DynamicAvatarView)localObject).a;
          if ((!((DynamicFaceDrawable)localObject).jdField_a_of_type_Boolean) || (((DynamicFaceDrawable)localObject).jdField_a_of_type_ComTencentImageURLDrawable == null) || (TextUtils.isEmpty(((DynamicFaceDrawable)localObject).c))) {
            break label192;
          }
          ProfileCardUtil.b(this.mActivity, localView, ((DynamicFaceDrawable)localObject).c);
        }
      }
    }
    label178:
    label192:
    label236:
    do
    {
      do
      {
        return;
        localView = ((AvatarLayout)localView).a(0);
        break;
        localObject = new ProfileActivity.AllInOne(this.mApp.getAccount(), 1);
        ProfileCardUtil.a(this.mActivity, localView, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, l, i, (ProfileActivity.AllInOne)localObject);
        return;
      } while (!(localView instanceof DynamicAvatarView));
      localObject = (DynamicAvatarView)localView;
    } while (((DynamicAvatarView)localObject).a == null);
    Object localObject = ((DynamicAvatarView)localObject).a;
    if ((((DynamicFaceDrawable)localObject).jdField_a_of_type_Boolean) && (((DynamicFaceDrawable)localObject).jdField_a_of_type_ComTencentImageURLDrawable != null) && (!TextUtils.isEmpty(((DynamicFaceDrawable)localObject).c)))
    {
      ProfileCardUtil.b(this.mActivity, localView, ((DynamicFaceDrawable)localObject).c);
      return;
    }
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
    {
      ProfileCardUtil.a(this.mActivity, localView, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p, false, false, null);
      return;
    }
    localObject = new ProfileActivity.AllInOne(this.mApp.getAccount(), 1);
    ProfileCardUtil.a(this.mActivity, localView, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, false, (ProfileActivity.AllInOne)localObject);
  }
  
  private void handleEditNickActivityResult(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      paramInt = paramIntent.getIntExtra("edit_action", 0);
      paramIntent = paramIntent.getStringExtra("nick");
      if ((paramInt != 3) && (paramInt != 4)) {
        break label46;
      }
      ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[1] = paramIntent;
    }
    label46:
    do
    {
      return;
      if (paramInt == 1)
      {
        ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[0] = paramIntent;
        return;
      }
    } while (paramInt != 2);
    ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[4] = paramIntent;
  }
  
  private void handleEditNickClick()
  {
    if (Utils.b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (((ProfileCardInfo)this.mData).b)
    {
      showEditNickActionSheetForTroop();
      return;
    }
    showEditNickActionSheet();
  }
  
  private void handleTemplateOutOfDateClick(int paramInt)
  {
    int i;
    if ((paramInt == 101107) || (paramInt == 101108))
    {
      if (paramInt != 101108) {
        break label155;
      }
      i = 5;
      if (paramInt != 101108) {
        break label160;
      }
      VipUtils.b(this.mActivity, 3, ProfileCardUtil.a(i));
    }
    for (;;)
    {
      if (((ProfileCardInfo)this.mData).b) {
        VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "guide_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      ReportController.b(this.mApp, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      label155:
      i = 2;
      break;
      label160:
      VipUtils.a(this.mActivity, 3, ProfileCardUtil.a(i));
    }
  }
  
  private void handleVoteBtnClick(Card paramCard)
  {
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.mApp.getCurrentAccountUin()))) {
      handleVoteBtnClickForMyProfile(paramCard);
    }
    do
    {
      return;
      handleVoteBtnClickForGuestProfile(paramCard);
    } while (!QSecFramework.a().a(1001).booleanValue());
    QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(24), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
  }
  
  private void handleVoteBtnClickForGuestProfile(Card paramCard)
  {
    if (paramCard == null) {
      notifyUser(this.mActivity.getString(2131693416), 1);
    }
    int i;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("handleVoteBtnClickForGuestProfile availVoteCnt=%s haveVotedCnt=%s voteLimitedNotice=%s", new Object[] { Short.valueOf(paramCard.bAvailVoteCnt), Short.valueOf(paramCard.bHaveVotedCnt), paramCard.strVoteLimitedNotice }));
      }
      if (paramCard.bAvailVoteCnt <= 0)
      {
        i = 1;
        if (i != 0) {
          break label275;
        }
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          paramCard.lVoteCount += 1L;
          paramCard.bVoted = 1;
          paramCard.bAvailVoteCnt = ((short)(paramCard.bAvailVoteCnt - 1));
        }
      }
      else
      {
        synchronized (S_CACHE_VOTE_LOCK)
        {
          this.mCacheVoteNum.incrementAndGet();
          if (QLog.isColorLevel()) {
            QLog.d("AbsProfileHeaderComponent", 2, String.format("handleVoteBtnClick uin=%s voteCount=%s mCacheVoteNum=%s", new Object[] { paramCard.uin, Long.valueOf(paramCard.lVoteCount), this.mCacheVoteNum }));
          }
          if (!this.mSubHandler.hasMessages(10))
          {
            ??? = Message.obtain();
            ((Message)???).what = 10;
            this.mSubHandler.sendMessageDelayed((Message)???, 2000L);
          }
          if (this.mHeaderView != null)
          {
            long l = paramCard.lVoteCount;
            this.mHeaderView.updateLiked((ProfileCardInfo)this.mData, l, true);
            return;
            i = 0;
          }
        }
      }
    }
    notifyUser(this.mActivity.getString(2131720768), 1);
    return;
    label275:
    if (!VipUtils.b(this.mApp))
    {
      showSVipVotePrivilegeTips();
      return;
    }
    if (SystemClock.uptimeMillis() - this.mLastToastVoteFailTime > 2000L)
    {
      if (paramCard.strVoteLimitedNotice != null)
      {
        paramCard = paramCard.strVoteLimitedNotice;
        i = 0;
        notifyUser(paramCard, i);
        this.mLastToastVoteFailTime = SystemClock.uptimeMillis();
      }
    }
    else {
      if (!this.mActivity.getIntent().hasExtra("troopUin")) {
        break label395;
      }
    }
    label395:
    for (paramCard = "1";; paramCard = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", paramCard, "");
      return;
      paramCard = this.mActivity.getString(2131693416);
      i = 1;
      break;
    }
  }
  
  private void handleVoteBtnClickForMyProfile(Card paramCard)
  {
    int i;
    int j;
    label48:
    Object localObject1;
    if (paramCard == null)
    {
      i = 0;
      Object localObject2 = QVipProfileFootPrintProcessor.a();
      if ((localObject2 == null) || (!((QVipProfileFootPrintConfig)localObject2).a()) || (TextUtils.isEmpty(((QVipProfileFootPrintConfig)localObject2).a())) || (!URLUtil.a(((QVipProfileFootPrintConfig)localObject2).a()))) {
        break label187;
      }
      j = 1;
      if (j == 0) {
        break label198;
      }
      localObject1 = this.mActivity;
      localObject2 = ((QVipProfileFootPrintConfig)localObject2).a();
      if (paramCard == null) {
        break label192;
      }
      paramCard = paramCard.uin;
      label74:
      ProfileCardUtil.a((Context)localObject1, (String)localObject2, paramCard);
      NearbyProxy.a(this.mApp);
      if (this.mHeaderView != null)
      {
        paramCard = this.mHeaderView.getChildView("map_key_like");
        if (!(paramCard instanceof VoteView)) {
          break label345;
        }
        paramCard = (VoteView)paramCard;
        paramCard.a(true, false, i, 0, null, false);
        paramCard.a(false);
      }
    }
    for (;;)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(ProfileActivity.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      i = (int)paramCard.lVoteCount;
      break;
      label187:
      j = 0;
      break label48;
      label192:
      paramCard = "";
      break label74;
      label198:
      paramCard = new Intent(this.mActivity, VisitorsActivity.class);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("toUin", Long.valueOf(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue());
      ((Bundle)localObject1).putLong("totalVoters", i);
      ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
      ((Bundle)localObject1).putBoolean("votersOnly", true);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject1).putBoolean("hasVoters", bool);
        ((Bundle)localObject1).putBoolean("extra_show_rank", true);
        ((Bundle)localObject1).putInt("extra_from", 1);
        ((Bundle)localObject1).putInt("frome_where", 5);
        paramCard.putExtras((Bundle)localObject1);
        this.mActivity.startActivity(paramCard);
        break;
      }
      label345:
      if ((paramCard instanceof VoteViewV2))
      {
        paramCard = (VoteViewV2)paramCard;
        paramCard.a(true, false, i, 0, null, false);
        paramCard.a(false);
      }
    }
  }
  
  private void reqFavorite()
  {
    CardHandler localCardHandler = (CardHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if ((localCardHandler != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
    synchronized (S_CACHE_VOTE_LOCK)
    {
      int i = this.mCacheVoteNum.get();
      this.mCacheVoteNum.set(0);
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("reqFavorite cacheVoteNum=%s", new Object[] { Integer.valueOf(i) }));
      }
      if (i > 0) {
        localCardHandler.a(this.mApp.getLongAccountUin(), Long.parseLong(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, i, 0);
      }
      return;
    }
  }
  
  private void reqFavoriteImmediately()
  {
    if ((this.mSubHandler != null) && (this.mSubHandler.hasMessages(10)))
    {
      this.mSubHandler.removeMessages(10);
      reqFavorite();
    }
  }
  
  private void showEditNickActionSheet()
  {
    String str3 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[0];
    String str1 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[4];
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("showEditNickActionSheet nickName=%s, remark=%s", new Object[] { str3, str1 }));
    }
    String str2 = "";
    int i;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      str2 = this.mActivity.getString(2131693338);
      ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 1, 0, "", "", "", "");
      str1 = str3;
      i = 1;
    }
    for (;;)
    {
      showEditNickActionSheetInner(false, i, str1, str2);
      return;
      if (ProfileActivity.AllInOne.b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!TextUtils.isEmpty(str1)) {}
        for (str2 = this.mActivity.getString(2131693333);; str2 = this.mActivity.getString(2131693405))
        {
          ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 2, 0, "", "", "", "");
          i = 2;
          break;
        }
      }
      str1 = getGenderString((ProfileCardInfo)this.mData);
      notifyUser(this.mActivity.getString(2131693334, new Object[] { str1, str1 }), 1);
      str1 = "";
      i = 0;
    }
  }
  
  private void showEditNickActionSheetForTroop()
  {
    String str1 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[1];
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("showEditNickActionSheetForTroop troopNick=%s", new Object[] { str1 }));
    }
    String str2 = "";
    int i;
    boolean bool;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      str2 = this.mActivity.getString(2131693339);
      ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
      i = 3;
      bool = true;
    }
    for (;;)
    {
      showEditNickActionSheetInner(bool, i, str1, str2);
      return;
      String str3 = this.mApp.getCurrentUin();
      TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).c(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
      if ((localTroopInfo != null) && ((localTroopInfo.isTroopAdmin(str3)) || (localTroopInfo.isTroopOwner(str3))))
      {
        i = 1;
        label179:
        if (i == 0) {
          break label303;
        }
        if (TextUtils.isEmpty(str1)) {
          break label266;
        }
        str2 = getGenderString((ProfileCardInfo)this.mData);
      }
      for (str2 = this.mActivity.getString(2131693342, new Object[] { str2 });; str2 = this.mActivity.getString(2131693406, new Object[] { str2 }))
      {
        ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
        i = 4;
        bool = true;
        break;
        i = 0;
        break label179;
        label266:
        str2 = getGenderString((ProfileCardInfo)this.mData);
      }
      label303:
      str1 = getGenderString((ProfileCardInfo)this.mData);
      notifyUser(this.mActivity.getString(2131693344, new Object[] { str1 }), 1);
      str1 = "";
      i = 0;
      bool = false;
    }
  }
  
  private void showEditNickActionSheetInner(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    ActionSheet localActionSheet;
    if (!TextUtils.isEmpty(paramString2))
    {
      localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mActivity, null);
      localActionSheet.addButton(paramString2, 1);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new AbsProfileHeaderComponent.4(this, paramString2, paramString1, paramInt, paramBoolean, localActionSheet));
    }
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.d("AbsProfileHeaderComponent", 1, "showEditNickActionSheet fail.", paramString1);
    }
  }
  
  private void showSVipVotePrivilegeTips()
  {
    if (VoteHelper.a(this.mApp))
    {
      localObject = new ZanDoubleDialog(this.mActivity);
      ((ZanDoubleDialog)localObject).a(new AbsProfileHeaderComponent.5(this));
      ((ZanDoubleDialog)localObject).show();
      if (this.mActivity.getIntent().hasExtra("troopUin")) {}
      for (localObject = "1";; localObject = "0")
      {
        VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)localObject, "");
        return;
      }
    }
    if (this.mActivity.getIntent().hasExtra("troopUin")) {}
    for (Object localObject = "1";; localObject = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", (String)localObject, "");
      notifyUser("非SVIP用户每天只能点10个赞哦～", 0);
      return;
    }
  }
  
  private void startVoteAnimation()
  {
    View localView;
    if (this.mHeaderView != null)
    {
      localView = this.mHeaderView.getChildView("map_key_like");
      if (!(localView instanceof VoteView)) {
        break label34;
      }
      ((VoteView)localView).b(true);
    }
    label34:
    while (!(localView instanceof VoteViewV2)) {
      return;
    }
    ((VoteViewV2)localView).b(true);
  }
  
  private void stopVoteAnimation()
  {
    View localView;
    if (this.mHeaderView != null)
    {
      localView = this.mHeaderView.getChildView("map_key_like");
      if (!(localView instanceof VoteView)) {
        break label34;
      }
      ((VoteView)localView).b(false);
    }
    label34:
    while (!(localView instanceof VoteViewV2)) {
      return;
    }
    ((VoteViewV2)localView).b(false);
  }
  
  public AbsProfileHeaderView getHeaderView()
  {
    return this.mHeaderView;
  }
  
  protected void handleSubMessage(Message paramMessage)
  {
    if (paramMessage.what == 10) {
      reqFavorite();
    }
  }
  
  protected void handleUIMessage(Message paramMessage) {}
  
  protected abstract void initHeaderView();
  
  protected void notifyUser(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1034) {
      handleEditNickActivityResult(paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag)) {
      localObject = (DataTag)paramView.getTag();
    }
    switch (((DataTag)localObject).jdField_a_of_type_Int)
    {
    default: 
    case 88: 
    case 3: 
    case 97: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        handleEditNickClick();
        continue;
        ProfileSignatureUtils.handleSignatureClick((ProfileCardInfo)this.mData, this.mActivity, this.mApp);
        continue;
        localObject = (Pair)((DataTag)localObject).jdField_a_of_type_JavaLangObject;
        ProfileSignatureUtils.handleSignatureCommonClick(paramView, ((Integer)((Pair)localObject).first).intValue(), (String)((Pair)localObject).second, this.mActivity, this.mApp);
      }
    case 10: 
      if (!(((DataTag)localObject).jdField_a_of_type_JavaLangObject instanceof Card)) {
        break;
      }
    }
    for (Object localObject = (Card)((DataTag)localObject).jdField_a_of_type_JavaLangObject;; localObject = null)
    {
      handleVoteBtnClick((Card)localObject);
      break;
      handleTemplateOutOfDateClick(((Integer)((DataTag)localObject).jdField_a_of_type_JavaLangObject).intValue());
      break;
      handleAvatarClick();
      break;
    }
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
    this.mSubHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.mSubCallback);
    this.mApp.addObserver(this.mSVipObserver);
    initHeaderView();
    if (this.mHeaderView != null)
    {
      paramBaseActivity = this.mRootView.findViewById(2131369900);
      this.mHeaderView.addChildView("map_key_tag_jueban", paramBaseActivity);
      this.mHeaderView.updateJueban((ProfileCardInfo)this.mData);
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    if (this.mHeaderView != null) {
      this.mHeaderView.onUpdate((ProfileCardInfo)this.mData, ((ProfileCardInfo)this.mData).d);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    if (this.mSubHandler != null)
    {
      this.mSubHandler.removeCallbacksAndMessages(null);
      this.mSubHandler = null;
    }
    if (this.mHeaderView != null) {
      this.mHeaderView.onDestroy();
    }
    this.mApp.removeObserver(this.mSVipObserver);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mHeaderView != null) {
      this.mHeaderView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mHeaderView != null) {
      this.mHeaderView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    startVoteAnimation();
  }
  
  public void onStop()
  {
    super.onStop();
    stopVoteAnimation();
    reqFavoriteImmediately();
  }
  
  public void setProfileActivityDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    this.mDelegate = paramIProfileActivityDelegate;
  }
  
  public void setProfileRootView(ViewGroup paramViewGroup)
  {
    this.mRootView = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
 * JD-Core Version:    0.7.0.1
 */