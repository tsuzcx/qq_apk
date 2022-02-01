package com.tencent.mobileqq.profilecard.base.component;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.nearby.NearbyProxyUtils;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ZanDoubleDialog;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileFootPrintConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileFootPrintProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
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
  extends AbsQQProfileComponent<FrameLayout>
  implements View.OnClickListener, IProfileHeaderContainer
{
  private static final int SUB_THREAD_MSG_REQ_FAVORITE = 10;
  private static final Object S_CACHE_VOTE_LOCK = new Object();
  private static final String TAG = "AbsProfileHeaderComponent";
  private static final int UI_THREAD_MSG_SHOW_VOTE_RED_DOT = 1;
  private static final long VOTE_FAIL_TOAST_INTERVAL = 2000L;
  private final AvatarObserver mAvatarObserver = new AbsProfileHeaderComponent.4(this);
  private final AtomicInteger mCacheVoteNum = new AtomicInteger(0);
  protected AbsProfileHeaderView mHeaderView;
  private long mLastToastVoteFailTime;
  private AtomicBoolean mNeedSVipDialog = new AtomicBoolean(true);
  private AtomicBoolean mOpenSVipPay = new AtomicBoolean(false);
  protected ViewGroup mRootView;
  private SVIPObserver mSVipObserver = new AbsProfileHeaderComponent.3(this);
  private final Handler.Callback mSubCallback = new AbsProfileHeaderComponent.2(this);
  protected WeakReferenceHandler mSubHandler;
  private final Handler.Callback mUICallback = new AbsProfileHeaderComponent.1(this);
  protected WeakReferenceHandler mUIHandler;
  
  public AbsProfileHeaderComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void checkVoteRedTouch()
  {
    ThreadManager.post(new AbsProfileHeaderComponent.7(this), 5, null, false);
  }
  
  private String getGenderString(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo.card != null) && (paramProfileCardInfo.card.shGender == 1)) {
      return HardCodeUtil.a(2131693287);
    }
    return HardCodeUtil.a(2131693292);
  }
  
  private int guestAvatarClickReport()
  {
    int j = ((ProfileCardInfo)this.mData).allInOne.pa;
    int i = 1;
    if (j != 1) {
      if (((ProfileCardInfo)this.mData).allInOne.pa == 20) {
        i = 2;
      } else if (((ProfileCardInfo)this.mData).allInOne.pa == 21) {
        i = 3;
      } else if (((ProfileCardInfo)this.mData).allInOne.pa == 45) {
        i = 4;
      } else if (((ProfileCardInfo)this.mData).allInOne.pa == 46) {
        i = 5;
      } else if (((ProfileCardInfo)this.mData).allInOne.pa == 41) {
        i = 6;
      } else if (((ProfileCardInfo)this.mData).allInOne.pa == 42) {
        i = 7;
      } else {
        i = 0;
      }
    }
    ReportController.b(this.mApp, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
    return i;
  }
  
  private void handleAvatarClick()
  {
    Object localObject1;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      localObject1 = new Intent(this.mActivity, AvatarPendantActivity.class);
      ((Intent)localObject1).putExtra("AllInOne", ((ProfileCardInfo)this.mData).allInOne);
      this.mActivity.startActivity((Intent)localObject1);
    }
    else
    {
      if (((ProfileCardInfo)this.mData).allInOne.pa == 33) {
        return;
      }
      if (!ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo)this.mData).allInOne))
      {
        localObject1 = ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo)this.mData).allInOne);
        if (((((ProfileCardInfo)this.mData).allInOne.pa != 53) || (((ProfileCardInfo)this.mData).allInOne.bindQQ)) && (localObject1 != null))
        {
          Object localObject2 = this.mHeaderView;
          if (localObject2 != null)
          {
            localObject2 = ((AbsProfileHeaderView)localObject2).getChildView("map_key_face");
            if (localObject2 != null) {
              ProfileCardUtil.a(this.mActivity, (View)localObject2, (String)localObject1);
            }
          }
        }
      }
      else
      {
        handleAvatarClickInner();
      }
    }
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.mApp, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
  }
  
  private void handleAvatarClickInner()
  {
    Object localObject1 = this.mHeaderView;
    if (localObject1 != null)
    {
      localObject1 = ((AbsProfileHeaderView)localObject1).getChildView("map_key_face");
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((AvatarLayout)localObject1).a(0);
      }
      Object localObject2 = this.mHeaderView.getChildView("map_key_avatar_pendant");
      long l = this.mHeaderView.getPendantId();
      if ((((ProfileCardInfo)this.mData).allInOne.pa != 0) && (ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo)this.mData).allInOne)) && (localObject1 != null) && (localObject2 != null) && (((View)localObject2).getVisibility() == 0) && (l != 0L))
      {
        int i = guestAvatarClickReport();
        if ((localObject1 instanceof DynamicAvatarView))
        {
          localObject2 = (DynamicAvatarView)localObject1;
          if (((DynamicAvatarView)localObject2).a != null)
          {
            localObject2 = ((DynamicAvatarView)localObject2).a;
            if ((((DynamicFaceDrawable)localObject2).jdField_a_of_type_Boolean) && (((DynamicFaceDrawable)localObject2).jdField_a_of_type_ComTencentImageURLDrawable != null) && (!TextUtils.isEmpty(((DynamicFaceDrawable)localObject2).c)))
            {
              ProfileCardUtil.b(this.mActivity, (View)localObject1, ((DynamicFaceDrawable)localObject2).c);
              return;
            }
            localObject2 = new AllInOne(this.mApp.getAccount(), 1);
            ProfileCardUtil.a(this.mActivity, (View)localObject1, ((ProfileCardInfo)this.mData).allInOne.uin, l, i, (AllInOne)localObject2);
          }
        }
      }
      else if ((localObject1 instanceof DynamicAvatarView))
      {
        localObject2 = (DynamicAvatarView)localObject1;
        if (((DynamicAvatarView)localObject2).a != null)
        {
          localObject2 = ((DynamicAvatarView)localObject2).a;
          if ((((DynamicFaceDrawable)localObject2).jdField_a_of_type_Boolean) && (((DynamicFaceDrawable)localObject2).jdField_a_of_type_ComTencentImageURLDrawable != null) && (!TextUtils.isEmpty(((DynamicFaceDrawable)localObject2).c)))
          {
            ProfileCardUtil.b(this.mActivity, (View)localObject1, ((DynamicFaceDrawable)localObject2).c);
            return;
          }
          if ((((ProfileCardInfo)this.mData).allInOne.pa == 41) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).allInOne.uin)) && (((ProfileCardInfo)this.mData).allInOne.uin.equals("0")))
          {
            ProfileCardUtil.a(this.mActivity, (View)localObject1, ((ProfileCardInfo)this.mData).allInOne.uid, false, false, null);
            return;
          }
          localObject2 = new AllInOne(this.mApp.getAccount(), 1);
          ProfileCardUtil.a(this.mActivity, (View)localObject1, ((ProfileCardInfo)this.mData).allInOne.uin, false, false, (AllInOne)localObject2);
        }
      }
    }
  }
  
  private void handleEditNickActivityResult(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      paramInt = paramIntent.getIntExtra("edit_type", 0);
      paramIntent = paramIntent.getStringExtra("result");
      if (paramInt == 5)
      {
        ((ProfileCardInfo)this.mData).nameArray[1] = paramIntent;
        return;
      }
      if (paramInt == 3)
      {
        ((ProfileCardInfo)this.mData).nameArray[0] = paramIntent;
        return;
      }
      if (paramInt == 4) {
        ((ProfileCardInfo)this.mData).nameArray[4] = paramIntent;
      }
    }
  }
  
  private void handleEditNickClick()
  {
    if (Utils.b(((ProfileCardInfo)this.mData).allInOne.uin)) {
      return;
    }
    if (((ProfileCardInfo)this.mData).isTroopMemberCard)
    {
      showEditNickActionSheetForTroop();
      return;
    }
    showEditNickActionSheet();
  }
  
  private void handleTemplateOutOfDateClick(int paramInt)
  {
    if ((paramInt == 101107) || (paramInt == 101108))
    {
      int i;
      if (paramInt == 101108) {
        i = 5;
      } else {
        i = 2;
      }
      if (paramInt == 101108) {
        VipUtils.b(this.mActivity, 3, ProfileCardUtil.a(i));
      } else {
        VipUtils.a(this.mActivity, 3, ProfileCardUtil.a(i));
      }
    }
    if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
      VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "group_card", "guide_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    ReportController.b(this.mApp, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileEntryUtils.getProfileEntryType(((ProfileCardInfo)this.mData).allInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(((ProfileCardInfo)this.mData).allInOne)), "", "", "");
  }
  
  private void handleVoteBtnClick(Card paramCard)
  {
    if ((((ProfileCardInfo)this.mData).allInOne.pa != 0) && (!((ProfileCardInfo)this.mData).allInOne.uin.equals(this.mApp.getCurrentAccountUin())))
    {
      handleVoteBtnClickForGuestProfile(paramCard);
      if (QSecFramework.a().a(1001).booleanValue()) {
        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(24), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
      }
    }
    else
    {
      handleVoteBtnClickForMyProfile(paramCard);
    }
  }
  
  private void handleVoteBtnClickForGuestProfile(Card paramCard)
  {
    int j = 1;
    if (paramCard == null)
    {
      notifyUser(this.mActivity.getString(2131693371), 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("handleVoteBtnClickForGuestProfile availVoteCnt=%s haveVotedCnt=%s voteLimitedNotice=%s", new Object[] { Short.valueOf(paramCard.bAvailVoteCnt), Short.valueOf(paramCard.bHaveVotedCnt), paramCard.strVoteLimitedNotice }));
    }
    int i;
    if (paramCard.bAvailVoteCnt <= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramCard.lVoteCount += 1L;
        paramCard.bVoted = 1;
        paramCard.bAvailVoteCnt = ((short)(paramCard.bAvailVoteCnt - 1));
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
          if (this.mHeaderView == null) {
            return;
          }
          long l = paramCard.lVoteCount;
          this.mHeaderView.updateLiked((ProfileCardInfo)this.mData, l, true);
          return;
        }
      }
      notifyUser(this.mActivity.getString(2131720493), 1);
      return;
    }
    if (!VasUtil.a(this.mQQAppInterface).getVipStatus().isSVip())
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
      }
      else
      {
        paramCard = this.mActivity.getString(2131693371);
        i = j;
      }
      notifyUser(paramCard, i);
      this.mLastToastVoteFailTime = SystemClock.uptimeMillis();
    }
    if (this.mActivity.getIntent().hasExtra("troopUin")) {
      paramCard = "1";
    } else {
      paramCard = "0";
    }
    VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", paramCard, "");
  }
  
  private void handleVoteBtnClickForMyProfile(Card paramCard)
  {
    int i;
    if (paramCard == null) {
      i = 0;
    } else {
      i = (int)paramCard.lVoteCount;
    }
    Object localObject2 = QVipProfileFootPrintProcessor.a();
    int j;
    if ((localObject2 != null) && (((QVipProfileFootPrintConfig)localObject2).a()) && (!TextUtils.isEmpty(((QVipProfileFootPrintConfig)localObject2).a())) && (URLUtil.a(((QVipProfileFootPrintConfig)localObject2).a()))) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject1;
    if (j != 0)
    {
      localObject1 = this.mActivity;
      localObject2 = ((QVipProfileFootPrintConfig)localObject2).a();
      if (paramCard != null) {
        paramCard = paramCard.uin;
      } else {
        paramCard = "";
      }
      ProfileCardUtil.a((Context)localObject1, (String)localObject2, paramCard);
    }
    else
    {
      paramCard = new Intent(this.mActivity, VisitorsActivity.class);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("toUin", Long.valueOf(((ProfileCardInfo)this.mData).allInOne.uin).longValue());
      ((Bundle)localObject1).putLong("totalVoters", i);
      ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
      ((Bundle)localObject1).putBoolean("votersOnly", true);
      boolean bool;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((Bundle)localObject1).putBoolean("hasVoters", bool);
      ((Bundle)localObject1).putBoolean("extra_show_rank", true);
      ((Bundle)localObject1).putInt("extra_from", 1);
      ((Bundle)localObject1).putInt("frome_where", 5);
      paramCard.putExtras((Bundle)localObject1);
      this.mActivity.startActivity(paramCard);
    }
    NearbyProxyUtils.a(this.mQQAppInterface);
    paramCard = this.mHeaderView;
    if (paramCard != null)
    {
      paramCard = paramCard.getChildView("map_key_like");
      if ((paramCard instanceof VoteView))
      {
        paramCard = (VoteView)paramCard;
        paramCard.a(true, false, i, 0, null, false);
        paramCard.a(false);
      }
      else if ((paramCard instanceof VoteViewV2))
      {
        paramCard = (VoteViewV2)paramCard;
        paramCard.a(true, false, i, 0, null, false);
        paramCard.a(false);
      }
    }
    ReportController.b(this.mApp, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(((ProfileCardInfo)this.mData).allInOne)), "", "", "");
  }
  
  private void reqFavorite()
  {
    CardHandler localCardHandler = (CardHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if ((localCardHandler != null) && (((ProfileCardInfo)this.mData).card != null)) {
      synchronized (S_CACHE_VOTE_LOCK)
      {
        int i = this.mCacheVoteNum.get();
        this.mCacheVoteNum.set(0);
        if (QLog.isColorLevel()) {
          QLog.d("AbsProfileHeaderComponent", 2, String.format("reqFavorite cacheVoteNum=%s", new Object[] { Integer.valueOf(i) }));
        }
        if (i > 0)
        {
          localCardHandler.a(this.mApp.getLongAccountUin(), Long.parseLong(((ProfileCardInfo)this.mData).allInOne.uin), ((ProfileCardInfo)this.mData).card.vCookies, ((ProfileCardInfo)this.mData).card.favoriteSource, i, 0);
          return;
        }
      }
    }
  }
  
  private void reqFavoriteImmediately()
  {
    WeakReferenceHandler localWeakReferenceHandler = this.mSubHandler;
    if ((localWeakReferenceHandler != null) && (localWeakReferenceHandler.hasMessages(10)))
    {
      this.mSubHandler.removeMessages(10);
      reqFavorite();
    }
  }
  
  private void showEditNickActionSheet()
  {
    Object localObject1 = ((ProfileCardInfo)this.mData).nameArray[0];
    Object localObject2 = ((ProfileCardInfo)this.mData).nameArray;
    int i = 4;
    localObject2 = localObject2[4];
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("showEditNickActionSheet nickName=%s, remark=%s", new Object[] { localObject1, localObject2 }));
    }
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      i = 3;
      String str = this.mActivity.getString(2131693293);
      ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 1, 0, "", "", "", "");
      localObject2 = localObject1;
      localObject1 = str;
    }
    else
    {
      if (!ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)this.mData).allInOne)) {
        break label215;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.mActivity.getString(2131693288);
      } else {
        localObject1 = this.mActivity.getString(2131693360);
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 2, 0, "", "", "", "");
    }
    showEditNickActionSheetInner(false, i, (String)localObject2, (String)localObject1);
    return;
    label215:
    localObject1 = getGenderString((ProfileCardInfo)this.mData);
    notifyUser(this.mActivity.getString(2131693289, new Object[] { localObject1, localObject1 }), 1);
  }
  
  private void showEditNickActionSheetForTroop()
  {
    String str2 = ((ProfileCardInfo)this.mData).nameArray[1];
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("showEditNickActionSheetForTroop troopNick=%s", new Object[] { str2 }));
    }
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
    {
      str1 = this.mActivity.getString(2131693294);
      ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
    }
    else
    {
      str1 = this.mApp.getCurrentUin();
      TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).c(((ProfileCardInfo)this.mData).troopUin);
      int i;
      if ((localTroopInfo != null) && ((localTroopInfo.isTroopAdmin(str1)) || (localTroopInfo.isTroopOwner(str1)))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break label280;
      }
      if (!TextUtils.isEmpty(str2))
      {
        str1 = getGenderString((ProfileCardInfo)this.mData);
        str1 = this.mActivity.getString(2131693297, new Object[] { str1 });
      }
      else
      {
        str1 = getGenderString((ProfileCardInfo)this.mData);
        str1 = this.mActivity.getString(2131693361, new Object[] { str1 });
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
    }
    showEditNickActionSheetInner(true, 5, str2, str1);
    return;
    label280:
    String str1 = getGenderString((ProfileCardInfo)this.mData);
    notifyUser(this.mActivity.getString(2131693299, new Object[] { str1 }), 1);
  }
  
  private void showEditNickActionSheetInner(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mActivity, null);
      localActionSheet.addButton(paramString2, 1);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new AbsProfileHeaderComponent.5(this, paramString2, paramString1, paramInt, paramBoolean, localActionSheet));
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
  }
  
  private void showSVipVotePrivilegeTips()
  {
    Object localObject;
    if (VoteHelper.a(this.mQQAppInterface))
    {
      localObject = new ZanDoubleDialog(this.mActivity);
      ((ZanDoubleDialog)localObject).a(new AbsProfileHeaderComponent.6(this));
      ((ZanDoubleDialog)localObject).show();
      if (this.mActivity.getIntent().hasExtra("troopUin")) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)localObject, "");
      return;
    }
    if (this.mActivity.getIntent().hasExtra("troopUin")) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", (String)localObject, "");
    notifyUser("非SVIP用户每天只能点10个赞哦～", 0);
  }
  
  private void showVoteRedDot(Message paramMessage)
  {
    Object localObject = this.mHeaderView;
    if (localObject != null)
    {
      paramMessage = ((AbsProfileHeaderView)localObject).getChildView("map_key_like");
      if ((paramMessage instanceof VoteView))
      {
        ((VoteView)paramMessage).a(true);
        return;
      }
      if ((paramMessage instanceof VoteViewV2)) {
        ((VoteViewV2)paramMessage).a(true);
      }
    }
    else if (paramMessage.arg1 > 0)
    {
      localObject = this.mUIHandler.obtainMessage();
      ((Message)localObject).what = paramMessage.what;
      ((Message)localObject).arg1 = (paramMessage.arg1 - 1);
      this.mUIHandler.sendMessageDelayed((Message)localObject, 1000L);
    }
  }
  
  private void startVoteAnimation()
  {
    Object localObject = this.mHeaderView;
    if (localObject != null)
    {
      localObject = ((AbsProfileHeaderView)localObject).getChildView("map_key_like");
      if ((localObject instanceof VoteView))
      {
        ((VoteView)localObject).b(true);
        return;
      }
      if ((localObject instanceof VoteViewV2)) {
        ((VoteViewV2)localObject).b(true);
      }
    }
  }
  
  private void stopVoteAnimation()
  {
    Object localObject = this.mHeaderView;
    if (localObject != null)
    {
      localObject = ((AbsProfileHeaderView)localObject).getChildView("map_key_like");
      if ((localObject instanceof VoteView))
      {
        ((VoteView)localObject).b(false);
        return;
      }
      if ((localObject instanceof VoteViewV2)) {
        ((VoteViewV2)localObject).b(false);
      }
    }
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
  
  protected void handleUIMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      showVoteRedDot(paramMessage);
    }
  }
  
  public boolean hasPhotoWall()
  {
    return false;
  }
  
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
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      int i = localDataTag.jdField_a_of_type_Int;
      if (i != 1)
      {
        if (i != 3)
        {
          Object localObject;
          if (i != 10)
          {
            if (i != 24)
            {
              if (i != 88)
              {
                if (i == 97)
                {
                  localObject = (Pair)localDataTag.jdField_a_of_type_JavaLangObject;
                  ProfileSignatureUtils.handleSignatureCommonClick(paramView, ((Integer)((Pair)localObject).first).intValue(), (String)((Pair)localObject).second, this.mActivity, this.mQQAppInterface);
                }
              }
              else {
                handleEditNickClick();
              }
            }
            else {
              handleTemplateOutOfDateClick(((Integer)localDataTag.jdField_a_of_type_JavaLangObject).intValue());
            }
          }
          else
          {
            localObject = null;
            if ((localDataTag.jdField_a_of_type_JavaLangObject instanceof Card)) {
              localObject = (Card)localDataTag.jdField_a_of_type_JavaLangObject;
            }
            handleVoteBtnClick((Card)localObject);
          }
        }
        else
        {
          ProfileSignatureUtils.handleSignatureClick((ProfileCardInfo)this.mData, this.mActivity, this.mQQAppInterface);
        }
      }
      else {
        handleAvatarClick();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
    this.mSubHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.mSubCallback);
    this.mApp.addObserver(this.mSVipObserver);
    this.mApp.addObserver(this.mAvatarObserver);
    initHeaderView();
    if (this.mHeaderView != null)
    {
      paramQBaseActivity = this.mRootView.findViewById(2131369585);
      this.mHeaderView.addChildView("map_key_tag_jueban", paramQBaseActivity);
      this.mHeaderView.updateJueban((ProfileCardInfo)this.mData);
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    paramProfileCardInfo = this.mHeaderView;
    if (paramProfileCardInfo != null) {
      paramProfileCardInfo.onUpdate((ProfileCardInfo)this.mData, ((ProfileCardInfo)this.mData).isNetRet);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    Object localObject = this.mUIHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    localObject = this.mSubHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.mSubHandler = null;
    }
    localObject = this.mHeaderView;
    if (localObject != null) {
      ((AbsProfileHeaderView)localObject).onDestroy();
    }
    this.mApp.removeObserver(this.mSVipObserver);
    this.mApp.removeObserver(this.mAvatarObserver);
    super.onDestroy();
  }
  
  public void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    AbsProfileHeaderView localAbsProfileHeaderView = getHeaderView();
    if (localAbsProfileHeaderView != null) {
      localAbsProfileHeaderView.onGetQZoneCover(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbsProfileHeaderView localAbsProfileHeaderView = this.mHeaderView;
    if (localAbsProfileHeaderView != null) {
      localAbsProfileHeaderView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    checkVoteRedTouch();
    AbsProfileHeaderView localAbsProfileHeaderView = this.mHeaderView;
    if (localAbsProfileHeaderView != null) {
      localAbsProfileHeaderView.onResume();
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
    super.setProfileActivityDelegate(paramIProfileActivityDelegate);
    if (this.mDelegate != null) {
      this.mRootView = this.mDelegate.getRootView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
 * JD-Core Version:    0.7.0.1
 */