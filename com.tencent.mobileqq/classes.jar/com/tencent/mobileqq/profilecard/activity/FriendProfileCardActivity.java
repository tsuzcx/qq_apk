package com.tencent.mobileqq.profilecard.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.bmqq.api.IBmqqSegmentApi;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.enterpriseqq.api.IEnterpriseQQService;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfigListener;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ITemplateManager;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qidian.api.IQidianApi;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView.MotionEventInterceptor;
import com.tencent.widget.XSimpleListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendProfileCardActivity
  extends QBaseActivity
  implements TopGestureLayout.OnGestureListener, XListView.MotionEventInterceptor
{
  private static final int[] HANDLE_REQUEST_PROFILE_CARD_TYPE = { 0, 60, 1, 78, 40, 41, 42, 73, 86, 36, 30, 32, 31, 50, 51, 34, 53, 29, 45, 46, 47, 20, 21, 58, 22, 3, 2, 74, 35, 37, 75, 61, 70, 25, 27, 28, 108, 26, 95, 4, 77, 52, 19, 23, 24, 120, 104, 111, 105, 106, 97, 98, 55, 56, 57, 72, 71, 82, 81, 83, 84, 101, 103, 102, 107, 110, 96, 112, 113, 115, 117 };
  private static final int MAX_REQUEST_CARD_COUNT = 5;
  private static final int SUB_MSG_INIT_CARD = 1;
  private static final int SUB_MSG_INIT_CONTACT_CARD = 2;
  private static final int SUB_MSG_UPDATE_CARD = 3;
  private static final String TAG = "FriendProfileCardActivity";
  private static final int UI_MSG_INIT_HEADER_VIEW_TIMEOUT = 103;
  private static final int UI_MSG_SWITCH_TO_FRIEND = 100;
  private static final int UI_MSG_UPDATE_CARD = 102;
  private static final int UI_MSG_UPDATE_CONTACT_CARD = 101;
  private AppInterface mApp;
  private View mBgContainerView;
  private View mBottomContainerView;
  private ClassLoader mClassLoader = null;
  private IComponentCenter mComponentCenter;
  private IProfileConfig mConfigHelper;
  private View mContentContainerView;
  private View mContentView;
  private BroadcastReceiver mDetailModifyReceiver = null;
  private View mFgContainerView;
  private boolean mHasUpdateFriendsDetail = false;
  private View mHeaderContainerView;
  private boolean mInterceptTouchEvent = true;
  private View mNightModeMask;
  private final ProfileCardInfo mProfileCardInfo = new ProfileCardInfo();
  private final IProfileConfigListener mProfileConfigListener = new FriendProfileCardActivity.2(this);
  private List<AbsProfileComponent> mProfileContainers;
  private final IProfileActivityDelegate mProfileDelegate = new FriendProfileCardActivity.9(this);
  private PullToZoomHeaderListView mProfileListView;
  private List<AbsListView.OnScrollListener> mProfileScrollListeners;
  private int mRequestCardCount = 0;
  private View mRootView;
  private final Handler.Callback mSubCallback = new FriendProfileCardActivity.4(this);
  private WeakReferenceHandler mSubHandler;
  private View mTitleContainerView;
  private TopGestureLayout mTopView;
  private final Handler.Callback mUICallback = new FriendProfileCardActivity.5(this);
  private WeakReferenceHandler mUIHandler;
  private final AbsListView.OnScrollListener onScrollListener = new FriendProfileCardActivity.1(this);
  private final ProfileCardObserver profileCardObserver = new FriendProfileCardActivity.3(this);
  
  private String addNationCodeIfNeeded(String paramString)
  {
    return ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).addNationCodeIfNeeded(this.mApp, paramString);
  }
  
  private void addProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.mProfileScrollListeners == null) {
      this.mProfileScrollListeners = new ArrayList();
    }
    this.mProfileScrollListeners.add(paramOnScrollListener);
  }
  
  private void backAndUpdateCard(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.mProfileCardInfo.card != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
    {
      paramIntent = null;
      if ((this.mProfileCardInfo.allInOne.pa != 56) && (this.mProfileCardInfo.allInOne.pa != 57))
      {
        if ((this.mProfileCardInfo.allInOne.pa == 35) || (this.mProfileCardInfo.allInOne.pa == 37) || (this.mProfileCardInfo.allInOne.pa == 36)) {
          paramIntent = this.mProfileCardInfo.allInOne.chatCookie;
        }
      }
      else {
        paramIntent = this.mProfileCardInfo.allInOne.chatCookie;
      }
      requestUpdateCard(this.mProfileCardInfo.card.feedPreviewTime, this.mProfileCardInfo.card.vSeed, paramIntent, true);
    }
  }
  
  private void checkAndSwitch2Friend(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((this.mApp != null) && (this.mUIHandler != null))
    {
      if (this.mProfileCardInfo.allInOne == null) {
        return;
      }
      if ((!ProfilePAUtils.isPaTypeFriend(this.mProfileCardInfo.allInOne)) && (this.mProfileCardInfo.allInOne.pa != 0) && (!TextUtils.equals(paramString, this.mApp.getCurrentAccountUin())))
      {
        if (TextUtils.equals(this.mProfileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin())) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendProfileCardActivity", 2, String.format("checkAndSwitch2Friend isFromContactCard=%s needCheckFriend=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
        }
        Object localObject;
        if (paramBoolean1)
        {
          Card localCard = switchContactCardToFriendCard(paramString, ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne));
          Message localMessage = Message.obtain();
          localMessage.what = 100;
          localObject = localCard;
          if (localCard == null) {
            localObject = paramString;
          }
          localMessage.obj = localObject;
          this.mUIHandler.sendMessage(localMessage);
          return;
        }
        paramBoolean2 ^= true;
        paramBoolean1 = paramBoolean2;
        if (!paramBoolean2) {
          paramBoolean1 = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).isFriend(this.mProfileCardInfo.allInOne.uin);
        }
        if (paramBoolean1)
        {
          paramString = ((IProfileDataService)this.mApp.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(this.mProfileCardInfo.allInOne.uin, true);
          localObject = Message.obtain();
          ((Message)localObject).what = 100;
          ((Message)localObject).obj = paramString;
          this.mUIHandler.sendMessage((Message)localObject);
        }
      }
    }
  }
  
  private boolean checkGotoCrmMainProfile(AppInterface paramAppInterface, String paramString)
  {
    ICrmApi localICrmApi = (ICrmApi)paramAppInterface.getRuntimeService(ICrmApi.class, "");
    IQidianManagerApi localIQidianManagerApi = (IQidianManagerApi)paramAppInterface.getRuntimeService(IQidianManagerApi.class, "");
    if ((!localICrmApi.isCrmMainUinAndGetSimpleInfoIfNeed(paramString)) && (!localIQidianManagerApi.isQidianMaster(paramString))) {
      return false;
    }
    localICrmApi.gotoCrmMainProfile(paramAppInterface.getApplicationContext(), null, paramString, false, -1, true, -1);
    return true;
  }
  
  private boolean checkParamValidate(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("checkParamValidate allInOne=%s", new Object[] { paramProfileCardInfo.allInOne }));
    }
    if (paramProfileCardInfo.allInOne == null) {
      return false;
    }
    return !TextUtils.isEmpty(paramProfileCardInfo.allInOne.uin);
  }
  
  private boolean checkToJumpOther(Intent paramIntent, AllInOne paramAllInOne)
  {
    if (paramIntent.hasExtra("param_wzry_data"))
    {
      paramIntent = paramIntent.getSerializableExtra("param_wzry_data");
      if (paramIntent != null)
      {
        paramAllInOne = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).getKPLProfileCardIntent(this);
        paramAllInOne.putExtra("param_wzry_data", paramIntent);
        startActivity(paramAllInOne);
        finish();
        return true;
      }
    }
    if (Utils.b(paramAllInOne.uin))
    {
      paramIntent = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).getBabyQProfileCardIntent(this, paramAllInOne);
      if (paramIntent != null)
      {
        startActivity(paramIntent);
        overridePendingTransition(0, 0);
        finish();
        return true;
      }
    }
    if ((((IBmqqSegmentApi)QRoute.api(IBmqqSegmentApi.class)).isBmqqUinNoBlock(this.mProfileCardInfo.allInOne.uin)) && (!this.mProfileCardInfo.isTroopMemberCard))
    {
      startActivity(((IQidianApi)QRoute.api(IQidianApi.class)).getProfileCardIntent(this, this.mProfileCardInfo.allInOne));
      finish();
      return true;
    }
    return false;
  }
  
  private void clearProfileRedDot()
  {
    ThreadManager.post(new FriendProfileCardActivity.7(this), 5, null, false);
  }
  
  private void dealQQBrowserActivityIntent(Intent paramIntent)
  {
    try
    {
      String str = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).getQQBrowserActivityClass().getName();
      Object localObject = paramIntent.getComponent();
      if ((localObject != null) && (TextUtils.equals(((ComponentName)localObject).getClassName(), str)))
      {
        str = paramIntent.getStringExtra("url");
        localObject = paramIntent.getStringExtra("big_brother_source_key");
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, String.format("dealQQBrowserActivityIntent url=%s key=%s", new Object[] { str, localObject }));
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
          return;
        }
      }
    }
    catch (Exception paramIntent)
    {
      QLog.d("FriendProfileCardActivity", 1, "", paramIntent);
    }
  }
  
  private void destroyProfileContainer()
  {
    Object localObject = this.mProfileContainers;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsProfileComponent localAbsProfileComponent = (AbsProfileComponent)((Iterator)localObject).next();
        try
        {
          localAbsProfileComponent.detachFromComponentCenter();
        }
        catch (Exception localException)
        {
          QLog.e("FriendProfileCardActivity", 1, "destroyProfileContainer fail.", localException);
        }
      }
      this.mProfileContainers.clear();
    }
  }
  
  private void fixProfilePA()
  {
    if (this.mProfileCardInfo.allInOne.pa == 90)
    {
      IFriendDataService localIFriendDataService = (IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all");
      if ((localIFriendDataService != null) && (localIFriendDataService.isFriend(this.mProfileCardInfo.allInOne.uin))) {
        this.mProfileCardInfo.allInOne.pa = 1;
      } else {
        this.mProfileCardInfo.allInOne.pa = 19;
      }
    }
    if ((this.mProfileCardInfo.allInOne.profileEntryType == 100) && (this.mProfileCardInfo.allInOne.pa == 34) && (!((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).isBindedIgnoreUpload(this.mApp))) {
      this.mProfileCardInfo.allInOne.pa = 29;
    }
    if ((this.mProfileCardInfo.allInOne.pa != 53) && (TextUtils.equals(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin))) {
      this.mProfileCardInfo.allInOne.pa = 0;
    }
  }
  
  private AllInOne getAllInOneForTroop(Intent paramIntent, AllInOne paramAllInOne)
  {
    this.mProfileCardInfo.isTroopMemberCard = paramIntent.hasExtra("troopUin");
    Object localObject = paramAllInOne;
    if (this.mProfileCardInfo.isTroopMemberCard)
    {
      this.mProfileCardInfo.troopUin = paramIntent.getStringExtra("troopUin");
      this.mProfileCardInfo.troopMemberCard = new TroopMemberCard();
      AllInOne localAllInOne = paramAllInOne;
      if (paramAllInOne == null)
      {
        paramAllInOne = paramIntent.getStringExtra("memberUin");
        paramIntent = paramAllInOne;
        if (TextUtils.isEmpty(paramAllInOne)) {
          paramIntent = this.mProfileCardInfo.allInOne.uin;
        }
        paramAllInOne = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).getFriend(paramIntent);
        if ((paramAllInOne != null) && (paramAllInOne.isFriend()))
        {
          localAllInOne = new AllInOne(paramIntent, 1);
          localAllInOne.nickname = paramAllInOne.name;
          localAllInOne.remark = paramAllInOne.remark;
        }
        else
        {
          localAllInOne = new AllInOne(paramIntent, 21);
          localAllInOne.subSourceId = 11;
        }
      }
      if ((!TextUtils.isEmpty(this.mProfileCardInfo.troopUin)) && (TextUtils.isEmpty(localAllInOne.troopCode))) {
        localAllInOne.troopCode = this.mProfileCardInfo.troopUin;
      }
      localObject = localAllInOne;
      if (!TextUtils.isEmpty(localAllInOne.troopCode))
      {
        localObject = localAllInOne;
        if (TextUtils.isEmpty(localAllInOne.troopUin))
        {
          localAllInOne.troopUin = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(localAllInOne.troopCode);
          localObject = localAllInOne;
        }
      }
    }
    return localObject;
  }
  
  private List<Integer> getContainerTypeList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(102));
    localArrayList.add(Integer.valueOf(103));
    localArrayList.add(Integer.valueOf(104));
    localArrayList.add(Integer.valueOf(105));
    localArrayList.add(Integer.valueOf(106));
    localArrayList.add(Integer.valueOf(107));
    localArrayList.add(Integer.valueOf(108));
    return localArrayList;
  }
  
  private View getContainerView(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 107: 
      return this.mBottomContainerView;
    case 106: 
      return this.mTitleContainerView;
    case 105: 
      return this.mFgContainerView;
    case 104: 
      return this.mBgContainerView;
    case 103: 
      return this.mContentContainerView;
    }
    return this.mHeaderContainerView;
  }
  
  private AllInOne getProfileAllInOne(Intent paramIntent)
  {
    return getAllInOneForTroop(paramIntent, (AllInOne)paramIntent.getParcelableExtra("AllInOne"));
  }
  
  private void handleGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool3 = false;
    if (bool1) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onGetProfileCard isSuccess=%s data=%s", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
    }
    if (checkGotoCrmMainProfile(this.mApp, this.mProfileCardInfo.allInOne.uin))
    {
      finish();
      return;
    }
    bool1 = ProfilePAUtils.isPaTypeHasUin(this.mProfileCardInfo.allInOne);
    boolean bool2 = bool1;
    if (this.mProfileCardInfo.allInOne.pa == 41) {
      if (!TextUtils.isEmpty(this.mProfileCardInfo.allInOne.uin))
      {
        bool2 = bool1;
        if (!this.mProfileCardInfo.allInOne.uin.equals("0")) {}
      }
      else
      {
        bool2 = false;
      }
    }
    boolean bool4 = paramObject instanceof Card;
    Object localObject1 = null;
    if ((bool4) && (bool2))
    {
      paramObject = (Card)paramObject;
      bool1 = Utils.a(this.mProfileCardInfo.allInOne.uin, paramObject.uin);
      if ((paramObject.lUserFlag & 1L) != 0L) {
        ((IEnterpriseQQService)this.mApp.getRuntimeService(IEnterpriseQQService.class, "")).getMenuFromNet(paramObject.uin, false);
      }
    }
    for (;;)
    {
      Object localObject2 = null;
      localObject1 = paramObject;
      paramObject = localObject2;
      break label447;
      if (((paramObject instanceof ContactCard)) && (!bool2))
      {
        localObject2 = addNationCodeIfNeeded(ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne));
        paramObject = (ContactCard)paramObject;
        bool1 = Utils.a(paramObject.mobileNo, localObject2);
        this.mProfileCardInfo.allInOne.uin = paramObject.mobileNo;
        localObject2 = this.mProfileCardInfo.allInOne;
        if ((((AllInOne)localObject2).contactArray != null) && (((AllInOne)localObject2).contactArray.size() > 0)) {
          ((ProfileContactInfo)((AllInOne)localObject2).contactArray.get(0)).phoneNumber = paramObject.mobileNo;
        }
        break label447;
      }
      if ((paramObject instanceof String))
      {
        localObject2 = ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne);
        paramObject = (String)paramObject;
        if (bool2) {
          bool1 = Utils.a(paramObject, this.mProfileCardInfo.allInOne.uin);
        } else {
          bool1 = Utils.a(paramObject, localObject2);
        }
        break;
      }
      bool1 = bool3;
      if (!bool4) {
        break;
      }
      bool1 = bool3;
      if (bool2) {
        break;
      }
      paramObject = (Card)paramObject;
      bool1 = Utils.a(this.mProfileCardInfo.allInOne.encId, paramObject.encId);
      this.mProfileCardInfo.allInOne.uin = paramObject.uin;
    }
    paramObject = null;
    label447:
    handleNotifyProfileCard(paramBoolean, localObject1, paramObject, bool1);
  }
  
  private void handleNotifyProfileCard(boolean paramBoolean1, Card paramCard, ContactCard paramContactCard, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((paramBoolean2) && (paramCard != null))
      {
        paramContactCard = this.mSubHandler;
        if (paramContactCard != null)
        {
          paramContactCard = paramContactCard.obtainMessage();
          paramContactCard.what = 3;
          paramContactCard.obj = paramCard;
          this.mSubHandler.sendMessage(paramContactCard);
        }
        paramCard = (IQQAvatarHandlerService)this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
        if (paramCard != null) {
          if (this.mProfileCardInfo.allInOne.discussUin != null)
          {
            if (ProfilePAUtils.isPaTypeHasUin(this.mProfileCardInfo.allInOne)) {
              paramCard.getCustomHead(this.mProfileCardInfo.allInOne.uin);
            }
          }
          else {
            paramCard.getCustomHead(this.mProfileCardInfo.allInOne.uin);
          }
        }
      }
      else if ((paramBoolean2) && (paramContactCard != null))
      {
        if (TextUtils.isEmpty(this.mProfileCardInfo.allInOne.contactName)) {
          this.mProfileCardInfo.allInOne.contactName = this.mProfileCardInfo.allInOne.nickname;
        }
        if (!TextUtils.isEmpty(paramContactCard.nickName)) {
          this.mProfileCardInfo.allInOne.nickname = paramContactCard.nickName;
        }
        if (!TextUtils.isEmpty(paramContactCard.uin))
        {
          paramCard = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).getFriend(paramContactCard.uin);
          if (paramCard != null) {
            this.mProfileCardInfo.allInOne.remark = paramCard.remark;
          }
        }
        this.mProfileCardInfo.allInOne.bindQQ = paramContactCard.bindQQ;
        this.mProfileCardInfo.contactCard = paramContactCard;
        paramCard = this.mUIHandler;
        if (paramCard != null)
        {
          paramCard = paramCard.obtainMessage();
          paramCard.what = 101;
          paramCard.obj = paramContactCard;
          paramCard.arg1 = 1;
          this.mUIHandler.sendMessage(paramCard);
        }
        paramCard = (IQQAvatarHandlerService)this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
        if ((paramCard != null) && (!TextUtils.isEmpty(paramContactCard.mobileNo))) {
          paramCard.getMobileQQHead(paramContactCard.mobileNo);
        }
      }
    }
    else if ((this.mProfileCardInfo.card != null) && (this.mProfileCardInfo.card.lCurrentStyleId == -1L))
    {
      this.mProfileCardInfo.card.lCurrentStyleId = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
      this.mProfileCardInfo.card.templateRet = 0;
      paramCard = this.mSubHandler;
      if (paramCard != null)
      {
        paramCard = paramCard.obtainMessage();
        paramCard.what = 3;
        paramCard.obj = this.mProfileCardInfo.card;
        this.mSubHandler.sendMessage(paramCard);
      }
    }
  }
  
  private void handleRequestProfileCard1(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 40)
        {
          if (paramInt != 60)
          {
            if (paramInt != 78) {
              return;
            }
            paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 24, paramLong1, (byte)1, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3022, paramArrayOfByte2, (byte)0);
            return;
          }
          paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 26, paramLong1, (byte)1, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
          return;
        }
        paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 1, paramLong1, (byte)1, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
        return;
      }
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 1, paramLong1, (byte)1, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
      return;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 0, paramLong1, (byte)1, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
  }
  
  private void handleRequestProfileCard10(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 96)
    {
      if ((paramInt != 107) && (paramInt != 110))
      {
        if (paramInt != 112) {}
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return;
            paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3004, paramArrayOfByte2, (byte)0);
            return;
          }
          break;
        }
      }
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 25, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3045, paramArrayOfByte2, (byte)0);
      return;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 53, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3094, paramArrayOfByte2, (byte)0);
  }
  
  private void handleRequestProfileCard11(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 113)
    {
      if (paramInt != 115)
      {
        if (paramInt != 117) {
          return;
        }
        paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3076, paramArrayOfByte2, (byte)0);
        return;
      }
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3050, paramArrayOfByte2, (byte)0);
      return;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3004, paramArrayOfByte2, (byte)0);
  }
  
  private void handleRequestProfileCard2(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 30)
    {
      if (paramInt != 36)
      {
        if ((paramInt != 73) && (paramInt != 86)) {
          if (paramInt != 41)
          {
            if (paramInt == 42) {}
          }
          else
          {
            if ((!TextUtils.isEmpty(this.mProfileCardInfo.allInOne.uin)) && (!this.mProfileCardInfo.allInOne.uin.equals("0")))
            {
              str = "";
              paramInt = 6;
            }
            else
            {
              str = this.mProfileCardInfo.allInOne.encId;
              paramInt = 37;
            }
            paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, paramInt, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, str, paramLong2, 10004, paramArrayOfByte2, (byte)0);
            return;
          }
        }
        paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 8, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
        return;
      }
      String str = ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne);
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), "0", 32, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, str, paramLong2, 3014, paramArrayOfByte2, (byte)0);
      return;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 15, paramLong1, (byte)1, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
  }
  
  private void handleRequestProfileCard3(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if ((paramInt != 29) && (paramInt != 34) && (paramInt != 53) && (paramInt != 31) && (paramInt != 32) && (paramInt != 50) && (paramInt != 51)) {
      return;
    }
    if (this.mProfileCardInfo.allInOne.pa == 34) {
      paramInt = 17;
    } else if (this.mProfileCardInfo.allInOne.pa == 53) {
      paramInt = 50;
    } else {
      paramInt = 16;
    }
    paramArrayOfByte2 = addNationCodeIfNeeded(ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne));
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), "0", paramInt, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, paramArrayOfByte2, paramLong2, 10004, null, (byte)0);
  }
  
  private void handleRequestProfileCard4(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    long l1;
    if (this.mProfileCardInfo.allInOne.discussUin != null) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.mProfileCardInfo.allInOne.discussUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label64:
      int i;
      break label64;
    }
    if (this.mProfileCardInfo.allInOne.pa == 45)
    {
      paramInt = 1;
      i = 13;
    }
    else if (this.mProfileCardInfo.allInOne.pa == 46)
    {
      paramInt = 0;
      i = 4;
    }
    else
    {
      paramInt = 0;
      i = 14;
    }
    if (paramInt != 1) {
      paramByte = 0;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, i, paramLong1, (byte)0, l1, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
  }
  
  private void handleRequestProfileCard5(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 3)
    {
      if (paramInt != 58) {
        switch (paramInt)
        {
        default: 
          return;
        }
      }
      long l = ProfileUtils.getTroopCode(this.mApp, this.mProfileCardInfo.allInOne);
      byte b;
      if (this.mProfileCardInfo.allInOne.pa == 20)
      {
        paramInt = 2;
        b = 1;
      }
      else
      {
        if ((this.mProfileCardInfo.allInOne.pa != 21) && (this.mProfileCardInfo.allInOne.pa != 58))
        {
          if (this.mProfileCardInfo.allInOne.pa == 22) {
            paramInt = 7;
          } else {
            paramInt = 12;
          }
        }
        else {
          paramInt = 5;
        }
        b = 0;
      }
      if (b != 1) {
        paramByte = 0;
      }
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, paramInt, paramLong1, b, l, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
      return;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 21, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
  }
  
  private void handleRequestProfileCard6(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 2)
    {
      if ((paramInt != 35) && (paramInt != 37))
      {
        if (paramInt != 61)
        {
          if (paramInt != 70)
          {
            if (paramInt != 74)
            {
              if (paramInt != 75) {
                return;
              }
              paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 38, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3017, paramArrayOfByte2, (byte)0);
              return;
            }
            paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 10, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
            return;
          }
          paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 36, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
          return;
        }
        paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 27, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
        return;
      }
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 31, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3001, paramArrayOfByte2, (byte)0);
      return;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 10, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
  }
  
  private void handleRequestProfileCard7(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 108) {
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    if (this.mProfileCardInfo.allInOne.pa == 27) {
      paramInt = 35;
    } else {
      paramInt = 11;
    }
    paramByte = this.mProfileCardInfo.allInOne.sourceID;
    String str2 = "0";
    String str1;
    if ((paramByte != 3004) && (this.mProfileCardInfo.allInOne.sourceID != 2004))
    {
      if (this.mProfileCardInfo.allInOne.sourceID != 3005)
      {
        str1 = str2;
        if (this.mProfileCardInfo.allInOne.sourceID != 2005) {}
      }
      else
      {
        str1 = this.mProfileCardInfo.allInOne.troopCode;
      }
    }
    else
    {
      if (!TextUtils.isEmpty(this.mProfileCardInfo.allInOne.troopCode)) {
        str1 = this.mProfileCardInfo.allInOne.troopCode;
      } else if (!TextUtils.isEmpty(this.mProfileCardInfo.allInOne.troopUin)) {
        str1 = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(this.mProfileCardInfo.allInOne.troopUin);
      } else {
        str1 = "0";
      }
      if (str1 == null) {
        str1 = str2;
      }
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(str1);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label270:
      break label270;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, paramInt, paramLong1, (byte)0, l1, 0L, paramArrayOfByte1, "", paramLong2, this.mProfileCardInfo.allInOne.sourceID, paramArrayOfByte2, (byte)0);
  }
  
  private void handleRequestProfileCard8(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 4)
    {
      if (paramInt != 19)
      {
        if (paramInt != 52)
        {
          if ((paramInt == 77) || (paramInt == 95)) {
            break label218;
          }
          if (paramInt != 97) {
            if ((paramInt == 111) || (paramInt == 120) || (paramInt == 23) || (paramInt == 24)) {
              break label175;
            }
          }
        }
        switch (paramInt)
        {
        default: 
          return;
          paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3095, paramArrayOfByte2, (byte)0);
          return;
          paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 24, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
          return;
        }
      }
      label175:
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
      return;
    }
    label218:
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 25, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
  }
  
  private void handleRequestProfileCard9(int paramInt, IProfileProtocolService paramIProfileProtocolService, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong2, byte paramByte)
  {
    if (paramInt != 71)
    {
      if (paramInt != 72)
      {
        if (paramInt != 98)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 57: 
            paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 30, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
            return;
          case 56: 
            paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 29, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
            return;
          }
          paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 28, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, paramByte);
          return;
        }
        paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 3096, paramArrayOfByte2, (byte)0);
        return;
      }
      paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 34, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
      return;
    }
    paramIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 33, paramLong1, (byte)0, 0L, 0L, paramArrayOfByte1, "", paramLong2, 10004, paramArrayOfByte2, (byte)0);
  }
  
  private void initCardInfo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "send async message to init card in db");
    }
    if (this.mSubHandler != null)
    {
      Message localMessage = null;
      if (this.mProfileCardInfo.allInOne.pa != 33) {
        if (ProfilePAUtils.isPaTypeHasUin(this.mProfileCardInfo.allInOne))
        {
          localMessage = this.mSubHandler.obtainMessage();
          localMessage.what = 1;
          localMessage.obj = this.mProfileCardInfo.allInOne.uin;
        }
        else
        {
          localMessage = this.mSubHandler.obtainMessage();
          localMessage.what = 2;
          localMessage.obj = this.mProfileCardInfo.allInOne.uin;
        }
      }
      if (localMessage != null) {
        this.mSubHandler.sendMessage(localMessage);
      }
    }
  }
  
  private void initComponentCenter()
  {
    if (this.mComponentCenter == null)
    {
      this.mComponentCenter = new ComponentCenter();
      this.mComponentCenter.init(this);
    }
  }
  
  private void initContactCard()
  {
    Object localObject1 = addNationCodeIfNeeded(ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne));
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      Object localObject2 = (IProfileDataService)this.mApp.getRuntimeService(IProfileDataService.class, "all");
      localObject1 = ((IProfileDataService)localObject2).getContactCardByMobileNo((String)localObject1, true);
      ProfileContactInfo localProfileContactInfo = ProfileUtils.getCardContactInfo(this.mProfileCardInfo.allInOne);
      if (localProfileContactInfo != null)
      {
        ((ContactCard)localObject1).nationCode = localProfileContactInfo.phoneNationalCode;
        ((ContactCard)localObject1).mobileCode = localProfileContactInfo.phoneNumber;
        ((ContactCard)localObject1).strContactName = localProfileContactInfo.phoneName;
      }
      if (TextUtils.isEmpty(((ContactCard)localObject1).nickName)) {
        ((ContactCard)localObject1).nickName = this.mProfileCardInfo.allInOne.nickname;
      }
      ((IProfileDataService)localObject2).saveContactCard((ContactCard)localObject1);
      this.mProfileCardInfo.allInOne.bindQQ = ((ContactCard)localObject1).bindQQ;
      if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
      {
        localObject2 = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).getFriend(((ContactCard)localObject1).uin);
        if (localObject2 != null) {
          this.mProfileCardInfo.allInOne.remark = ((Friends)localObject2).remark;
        }
      }
      updateNameArrayByContactCard((ContactCard)localObject1, false);
      ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 101;
      ((Message)localObject2).obj = localObject1;
      ((Message)localObject2).arg1 = 0;
      this.mUIHandler.sendMessage((Message)localObject2);
      requestUpdateCard(0L, null, null, false);
    }
  }
  
  private void initContactCardInfoList(boolean paramBoolean)
  {
    ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).initContactCardInfoList(this.mApp, this.mProfileCardInfo, paramBoolean);
  }
  
  private void initProfileCard(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("initProfileCard uin=%s", new Object[] { paramString }));
    }
    Card localCard = ((IProfileDataService)this.mApp.getRuntimeService(IProfileDataService.class, "")).getProfileCard(paramString, true);
    if (localCard != null)
    {
      if ((((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).isFriend(localCard.uin)) && (!this.mProfileCardInfo.allInOne.uin.equals(this.mApp.getCurrentAccountUin())) && (!ProfilePAUtils.isPaTypeFriend(this.mProfileCardInfo.allInOne))) {
        this.mProfileCardInfo.allInOne.pa = 1;
      }
      this.mProfileCardInfo.card = localCard;
      onCardUpdate(localCard, false, 1);
      byte[] arrayOfByte = localCard.vSeed;
      paramString = null;
      if ((this.mProfileCardInfo.allInOne.pa != 56) && (this.mProfileCardInfo.allInOne.pa != 57))
      {
        if ((this.mProfileCardInfo.allInOne.pa == 35) || (this.mProfileCardInfo.allInOne.pa == 37) || (this.mProfileCardInfo.allInOne.pa == 36)) {
          paramString = this.mProfileCardInfo.allInOne.chatCookie;
        }
      }
      else {
        paramString = this.mProfileCardInfo.allInOne.chatCookie;
      }
      requestUpdateCard(localCard.feedPreviewTime, arrayOfByte, paramString, false);
    }
  }
  
  private void initProfileCardLayout()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "initProfileCardLayout");
    }
    this.mRootView = View.inflate(this, 2131561378, null);
    this.mBgContainerView = this.mRootView.findViewById(2131373095);
    this.mFgContainerView = this.mRootView.findViewById(2131373108);
    this.mTitleContainerView = this.mRootView.findViewById(2131373117);
    this.mBottomContainerView = this.mRootView.findViewById(2131373096);
    this.mProfileListView = ((PullToZoomHeaderListView)this.mRootView.findViewById(2131365037));
    this.mProfileListView.setVerticalScrollBarEnabled(false);
    this.mProfileListView.setMotionEventInterceptor(this);
    this.mProfileListView.setNeedCheckSpringback(true);
    this.mProfileListView.setOnScrollListener(this.onScrollListener);
    this.mNightModeMask = this.mRootView.findViewById(2131374298);
    this.mContentView = View.inflate(this, 2131561333, null);
    this.mHeaderContainerView = this.mContentView.findViewById(2131368785);
    this.mContentContainerView = this.mContentView.findViewById(2131368793);
    this.mContentContainerView.setVisibility(0);
    Object localObject = (ImageView)this.mContentView.findViewById(2131368779);
    if (localObject != null) {}
    try
    {
      localObject = (Animatable)((ImageView)localObject).getDrawable();
      if (!((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).start();
      }
    }
    catch (Exception localException)
    {
      label241:
      break label241;
    }
    this.mProfileListView.addHeaderView(this.mContentView);
    this.mProfileListView.setAdapter(new XSimpleListAdapter(null));
    this.mTopView = new TopGestureLayout(this);
    this.mTopView.setOnFlingGesture(this);
    this.mTopView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mTopView.addView(this.mRootView);
    setContentView(this.mTopView);
    localObject = (FrameLayout)findViewById(16908290);
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundResource(2130845954);
    }
    localObject = this.mUIHandler;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage(103);
      this.mUIHandler.sendMessageDelayed((Message)localObject, 10000L);
    }
  }
  
  private void initProfileContainer()
  {
    if (this.mProfileContainers == null) {
      this.mProfileContainers = new ArrayList();
    }
    this.mProfileContainers.clear();
    Iterator localIterator = getContainerTypeList().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      AbsProfileComponent localAbsProfileComponent1;
      try
      {
        AbsProfileComponent localAbsProfileComponent2 = ProfileUtils.create(i, this.mComponentCenter, this.mProfileCardInfo, this.mProfileDelegate);
        localAbsProfileComponent1 = localAbsProfileComponent2;
        if (localAbsProfileComponent2 != null)
        {
          localAbsProfileComponent2.setContainerView(getContainerView(i));
          localAbsProfileComponent2.attachToComponentCenter();
          localAbsProfileComponent1 = localAbsProfileComponent2;
        }
      }
      catch (Exception localException)
      {
        localAbsProfileComponent1 = null;
        QLog.e("FriendProfileCardActivity", 1, "initProfileContainer fail.", localException);
      }
      if (localAbsProfileComponent1 != null) {
        this.mProfileContainers.add(localAbsProfileComponent1);
      }
    }
  }
  
  private void initProfileFramework()
  {
    try
    {
      initComponentCenter();
      initProfileContainer();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FriendProfileCardActivity", 1, "initComponentCenter fail.", localException);
      finish();
    }
  }
  
  private boolean isNeedHandleRequestProfileCardDefault(int paramInt)
  {
    int[] arrayOfInt = HANDLE_REQUEST_PROFILE_CARD_TYPE;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private byte needReqMedalWall()
  {
    byte b2 = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).needReqMedalWall(this, this.mApp);
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "");
    byte b1 = b2;
    if (this.mProfileCardInfo.isTroopMemberCard)
    {
      b1 = b2;
      if (localITroopInfoService.isQidianPrivateTroop(this.mProfileCardInfo.troopUin)) {
        b1 = 0;
      }
    }
    return b1;
  }
  
  private void notifyCardUpdate(Card paramCard)
  {
    Object localObject = this.mSubHandler;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 3;
      ((Message)localObject).obj = paramCard;
      this.mSubHandler.sendMessage((Message)localObject);
    }
  }
  
  private void notifyComponentDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = this.mProfileContainers;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsProfileComponent localAbsProfileComponent = (AbsProfileComponent)((Iterator)localObject).next();
        try
        {
          localAbsProfileComponent.onDataUpdate(paramProfileCardInfo);
        }
        catch (Exception localException)
        {
          QLog.e("FriendProfileCardActivity", 1, "notifyComponentDataUpdate fail.", localException);
        }
      }
    }
  }
  
  private void onCardUpdate(Card paramCard, boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = QLog.isColorLevel();
        i = 1;
        if (bool) {
          QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate card=%s isNetCard=%s msgType=%s", new Object[] { paramCard, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
        }
        if (paramCard != null)
        {
          updateNameArrayByCard(paramCard, paramBoolean);
          ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
          if ((paramCard.tempChatSig != null) && (paramCard.tempChatSig.length > 0)) {
            this.mProfileCardInfo.allInOne.chatCookie = paramCard.tempChatSig;
          }
          updateFriendDetail(paramCard, paramBoolean);
          this.mProfileCardInfo.card = paramCard;
          ProfileTemplateApi.getTemplateManager(this.mComponentCenter).preNotifyOnCardUpdate(this, this.mProfileCardInfo);
          if (this.mUIHandler != null)
          {
            this.mUIHandler.removeMessages(103);
            if (!paramBoolean) {
              break label174;
            }
            this.mUIHandler.obtainMessage(102, i, paramInt, paramCard).sendToTarget();
          }
        }
        return;
      }
      finally {}
      label174:
      int i = 0;
    }
  }
  
  private void profileEntryReport()
  {
    if (Utils.b(this.mProfileCardInfo.allInOne.uin))
    {
      int i;
      if (this.mProfileCardInfo.allInOne.profileEntryType == 59) {
        i = 1;
      } else if (this.mProfileCardInfo.allInOne.profileEntryType == 1) {
        i = 2;
      } else if (this.mProfileCardInfo.allInOne.profileEntryType == 8) {
        i = 3;
      } else {
        i = 0;
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X800723B", "0X800723B", i, 0, "", "", "", "");
    }
    if (this.mProfileCardInfo.allInOne.profileEntryType == 118) {
      ReportController.b(null, "dc00898", "", "", "0X800A11E", "0X800A11E", 0, 0, "", "", "", "");
    } else if (this.mProfileCardInfo.allInOne.profileEntryType == 121) {
      ReportController.b(this.mApp, "dc00898", "", "", "0X800A51D", "0X800A51D", 0, 0, "", "", "", "");
    }
    ReportController.b(this.mApp, "dc00898", "", "", "", "0X800A4BF", 0, 0, "", "", "", "");
    ProfileCardReport.reportProfileEntry(this.mApp, this.mProfileCardInfo);
  }
  
  private void registerDetailModifyReceiver()
  {
    if (this.mDetailModifyReceiver == null)
    {
      this.mDetailModifyReceiver = new FriendProfileCardActivity.8(this);
      try
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
        localIntentFilter.setPriority(2147483647);
        registerReceiver(this.mDetailModifyReceiver, localIntentFilter);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("FriendProfileCardActivity", 1, "registerDetailModifyReceiver fail.", localThrowable);
      }
    }
  }
  
  private void removeProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    List localList = this.mProfileScrollListeners;
    if (localList != null) {
      localList.remove(paramOnScrollListener);
    }
  }
  
  private void requestUpdateCard(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("requestUpdateCard forceRequest=%s mRequestCardCount=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mRequestCardCount) }));
    }
    if ((this.mRequestCardCount > 5) && (!paramBoolean)) {
      return;
    }
    this.mRequestCardCount += 1;
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[] { 0 };
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = new byte[] { 0 };
    }
    boolean bool = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).needReqOCRCard(this.mApp);
    long l = ProfileUtils.getControl(this.mProfileCardInfo.allInOne, bool);
    byte b = needReqMedalWall();
    IProfileProtocolService localIProfileProtocolService = (IProfileProtocolService)this.mApp.getRuntimeService(IProfileProtocolService.class, "all");
    handleRequestProfileCard1(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard2(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard3(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard4(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard5(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard6(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard7(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard8(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard9(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard10(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    handleRequestProfileCard11(this.mProfileCardInfo.allInOne.pa, localIProfileProtocolService, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramBoolean, l, b);
    if (!isNeedHandleRequestProfileCardDefault(this.mProfileCardInfo.allInOne.pa)) {
      localIProfileProtocolService.requestProfileCard(this.mApp.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 65535, paramLong, (byte)0, 0L, 0L, paramArrayOfByte1, "", l, 3999, paramArrayOfByte2, (byte)0);
    }
  }
  
  private void scrollToListTop()
  {
    this.mProfileListView.smoothScrollToPosition(0);
  }
  
  private void scrollToMoreInfoView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    paramInt = paramInt + this.mHeaderContainerView.getHeight() - getTitleBarHeight();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("scrollToMoreInfoView offset=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    PullToZoomHeaderListView localPullToZoomHeaderListView = this.mProfileListView;
    if (localPullToZoomHeaderListView != null) {
      localPullToZoomHeaderListView.smoothScrollToPositionFromTop(0, -paramInt);
    }
  }
  
  private void setInterceptTouchEvent(boolean paramBoolean)
  {
    QLog.e("FriendProfileCardActivity", 1, String.format("setInterceptTouchEvent intercept=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.mInterceptTouchEvent = paramBoolean;
    TopGestureLayout localTopGestureLayout = this.mTopView;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(this.mInterceptTouchEvent);
    }
  }
  
  private void setNewRemark(String paramString)
  {
    this.mProfileCardInfo.allInOne.remark = paramString;
    ProfileNameUtils.updateNameArray(this.mProfileCardInfo, 4, paramString);
    ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
    notifyCardUpdate(null);
  }
  
  private Card switchContactCardToFriendCard(String paramString1, String paramString2)
  {
    IProfileDataService localIProfileDataService = (IProfileDataService)this.mApp.getRuntimeService(IProfileDataService.class, "all");
    paramString2 = localIProfileDataService.getContactCardByMobileNo(paramString2, false);
    if (paramString2 != null)
    {
      paramString1 = localIProfileDataService.getProfileCard(paramString1, true);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localIProfileDataService.saveProfileCard(paramString1);
      return paramString1;
    }
    return null;
  }
  
  private void switchedToFriend(Card paramCard, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("switchedToFriend card=%s uin=%s", new Object[] { paramCard, paramString }));
    }
    this.mProfileCardInfo.allInOne.pa = 1;
    this.mProfileCardInfo.allInOne.uin = paramString;
    initContactCardInfoList(true);
    long l = 0L;
    paramString = null;
    if (paramCard != null)
    {
      l = paramCard.feedPreviewTime;
      byte[] arrayOfByte = paramCard.vSeed;
      this.mProfileCardInfo.card = paramCard;
      updateCardInfo(paramCard, false);
      paramCard = arrayOfByte;
    }
    else
    {
      initProfileCardLayout();
      destroyProfileContainer();
      initProfileFramework();
      paramCard = null;
    }
    if ((this.mProfileCardInfo.allInOne.pa == 56) || (this.mProfileCardInfo.allInOne.pa == 57)) {
      paramString = this.mProfileCardInfo.allInOne.chatCookie;
    }
    requestUpdateCard(l, paramCard, paramString, true);
  }
  
  private void unregisterDetailModifyReceiver()
  {
    BroadcastReceiver localBroadcastReceiver = this.mDetailModifyReceiver;
    if (localBroadcastReceiver != null)
    {
      try
      {
        unregisterReceiver(localBroadcastReceiver);
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "unregisterDetailModifyReceiver fail.", localException);
      }
      this.mDetailModifyReceiver = null;
    }
  }
  
  private void updateCardInfo(Card paramCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateCardInfo card=%s isNetRet=%s", new Object[] { paramCard, Boolean.valueOf(paramBoolean) }));
    }
    ProfileCardInfo localProfileCardInfo = this.mProfileCardInfo;
    localProfileCardInfo.card = paramCard;
    localProfileCardInfo.isNetRet = paramBoolean;
    updateTheme();
    notifyComponentDataUpdate(this.mProfileCardInfo);
    int i;
    if ((paramCard != null) && (paramCard.mQQLevelType != 0)) {
      i = paramCard.mQQLevelType;
    } else {
      i = 99999;
    }
    if (this.mProfileCardInfo.allInOne.pa == 0)
    {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A777", i, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A776", i, 0, "", "", "", "");
  }
  
  private void updateContactCardInfo(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateContactCardInfo card=%s isNetRet=%s", new Object[] { paramContactCard, Boolean.valueOf(paramBoolean) }));
    }
    ProfileCardInfo localProfileCardInfo = this.mProfileCardInfo;
    localProfileCardInfo.contactCard = paramContactCard;
    localProfileCardInfo.isNetRet = paramBoolean;
    updateNameArrayByContactCard(paramContactCard, paramBoolean);
    ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
    notifyComponentDataUpdate(this.mProfileCardInfo);
  }
  
  private void updateFriendDetail(Card paramCard, boolean paramBoolean)
  {
    if ((this.mProfileCardInfo.allInOne.pa != 0) && (paramBoolean) && (!this.mHasUpdateFriendsDetail))
    {
      this.mHasUpdateFriendsDetail = true;
      boolean bool = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).isFriend(paramCard.uin);
      if ((paramCard.lUserFlag & 0x800) != 0L) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate isFriend=%s profileFriend=%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
      }
      if (paramBoolean != bool) {
        ((IFriendHandlerService)this.mApp.getRuntimeService(IFriendHandlerService.class, "all")).requestFriendInfo(paramCard.uin);
      }
    }
  }
  
  private void updateNameArrayByCard(Card paramCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateNameArrayByCard card=%s isNetRet=%s", new Object[] { paramCard, Boolean.valueOf(paramBoolean) }));
    }
    if (paramCard == null) {
      return;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      this.mProfileCardInfo.nameArray[0] = paramCard.strNick;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strReMark))) {
      this.mProfileCardInfo.nameArray[4] = paramCard.strReMark;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strAutoRemark))) {
      this.mProfileCardInfo.nameArray[6] = paramCard.strAutoRemark;
    }
    if (!TextUtils.isEmpty(paramCard.strContactName)) {
      this.mProfileCardInfo.nameArray[3] = paramCard.strContactName;
    }
    if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
      this.mProfileCardInfo.nameArray[2] = paramCard.strAutoRemark;
    }
    if (QLog.isColorLevel())
    {
      paramCard = new StringBuilder();
      paramCard.append("updateNameArray()");
      paramCard.append(", strNick = ");
      paramCard.append(Utils.a(this.mProfileCardInfo.nameArray[0]));
      paramCard.append(", strRemark = ");
      paramCard.append(Utils.a(this.mProfileCardInfo.nameArray[4]));
      paramCard.append(", strContactName = ");
      paramCard.append(Utils.a(this.mProfileCardInfo.nameArray[3]));
      paramCard.append(", strCircleName = ");
      paramCard.append(Utils.a(this.mProfileCardInfo.nameArray[2]));
      paramCard.append(", strRecommenName = ");
      paramCard.append(Utils.a(this.mProfileCardInfo.nameArray[5]));
      paramCard.append(", strTroopNickName = ");
      paramCard.append(Utils.a(this.mProfileCardInfo.nameArray[1]));
      paramCard.append(", strAutoRemark = ");
      paramCard.append(Utils.a(this.mProfileCardInfo.nameArray[6]));
      QLog.d("FriendProfileCardActivity", 2, paramCard.toString());
    }
  }
  
  private void updateNameArrayByContactCard(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateNameArrayByContactCard card=%s isNetRet=%s", new Object[] { paramContactCard, Boolean.valueOf(paramBoolean) }));
    }
    if (paramContactCard == null) {
      return;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      this.mProfileCardInfo.nameArray[0] = paramContactCard.nickName;
    }
    if (!TextUtils.isEmpty(paramContactCard.strContactName)) {
      this.mProfileCardInfo.nameArray[3] = paramContactCard.strContactName;
    }
  }
  
  private void updateTheme()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "updateTheme");
    }
    try
    {
      ITemplateUtils localITemplateUtils = ProfileTemplateApi.getTemplateUtils(this.mComponentCenter);
      FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
      if (this.mProfileCardInfo.currentTemplate != null)
      {
        localFrameLayout.setForeground(null);
        this.mContentView.setBackgroundResource(0);
        localITemplateUtils.updateViewAttr(this.mContentView, "background", this.mProfileCardInfo.currentTemplate, "background");
        if (ProfileTemplateApi.isDiyTemplateStyleID(this.mProfileCardInfo.card.lCurrentStyleId)) {
          this.mContentContainerView.setBackgroundDrawable(null);
        } else {
          localITemplateUtils.updateViewAttr(this.mContentContainerView, "background", this.mProfileCardInfo.currentTemplate, "commonMaskBackground");
        }
        if (ThemeUtil.isInNightMode(this.mApp))
        {
          if (this.mNightModeMask != null) {
            this.mNightModeMask.setVisibility(0);
          }
        }
        else if (this.mNightModeMask != null) {
          this.mNightModeMask.setVisibility(8);
        }
      }
      else if (ProfileTemplateApi.isDiyTemplateStyleID(this.mProfileCardInfo.card.lCurrentStyleId))
      {
        localFrameLayout.setForeground(null);
        localFrameLayout.setBackgroundDrawable(null);
        this.mContentView.setBackgroundResource(0);
        this.mContentContainerView.setBackgroundResource(0);
        if (ThemeUtil.isInNightMode(this.mApp))
        {
          if (this.mNightModeMask != null) {
            this.mNightModeMask.setVisibility(0);
          }
        }
        else if (this.mNightModeMask != null) {
          this.mNightModeMask.setVisibility(8);
        }
      }
      else
      {
        localFrameLayout.setForeground(getResources().getDrawable(2130850439));
        this.mContentView.setBackgroundResource(0);
        this.mContentContainerView.setBackgroundResource(0);
        if (this.mNightModeMask != null)
        {
          this.mNightModeMask.setVisibility(8);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("FriendProfileCardActivity", 1, "updateTheme fail.", localException);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("doOnActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    Object localObject = this.mComponentCenter;
    if (localObject != null) {
      ((IComponentCenter)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt1 == 1022)
    {
      backAndUpdateCard(paramIntent);
      return;
    }
    if (paramInt1 == 1012)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        if (paramIntent.getBooleanExtra("finchat", false))
        {
          finish();
        }
        else
        {
          localObject = paramIntent.getStringExtra("remark");
          if (!Utils.a(this.mProfileCardInfo.allInOne.remark, localObject)) {
            setNewRemark((String)localObject);
          }
        }
        backAndUpdateCard(paramIntent);
      }
    }
    else if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      setResult(-1);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-3);
    getWindow().setBackgroundDrawable(new ColorDrawable(-1));
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.mApp = ((AppInterface)getAppRuntime());
    Intent localIntent = getIntent();
    Object localObject = this.mApp;
    if ((localObject != null) && (!TextUtils.isEmpty(((AppInterface)localObject).getAccount())) && (localIntent != null))
    {
      localObject = getProfileAllInOne(localIntent);
      this.mProfileCardInfo.allInOne = ((AllInOne)localObject);
      this.mConfigHelper = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).createProfileConfig(this.mApp, this.mProfileConfigListener);
      this.mSubHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.mSubCallback);
      this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
      if (!checkParamValidate(this.mProfileCardInfo))
      {
        QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 2.");
        finish();
        return false;
      }
      if (checkToJumpOther(localIntent, (AllInOne)localObject))
      {
        QLog.e("FriendProfileCardActivity", 1, "doOnCreate jump to other.");
        return false;
      }
      fixProfilePA();
      clearProfileRedDot();
      registerDetailModifyReceiver();
      addObserver(this.profileCardObserver);
      try
      {
        initContactCardInfoList(false);
        this.mProfileCardInfo.nameArray = new String[8];
        ThreadManager.excute(new FriendProfileCardActivity.6(this), 16, null, true);
        initProfileCardLayout();
        initProfileFramework();
        if (this.mComponentCenter != null) {
          this.mComponentCenter.onCreate(this, paramBundle);
        }
        if (this.mProfileCardInfo.allInOne.pa != 33) {
          initCardInfo();
        } else {
          updateCardInfo(this.mProfileCardInfo.card, false);
        }
        profileEntryReport();
        return true;
      }
      catch (Exception paramBundle)
      {
        QLog.e("FriendProfileCardActivity", 1, "doOnCreate fail.", paramBundle);
        finish();
        return false;
      }
    }
    QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 1.");
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.mUIHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.mUIHandler.removeMessages(0);
    }
    localObject = this.mSubHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.mSubHandler.removeMessages(0);
      this.mSubHandler = null;
    }
    localObject = this.mConfigHelper;
    if (localObject != null) {
      ((IProfileConfig)localObject).destroy();
    }
    removeObserver(this.profileCardObserver);
    unregisterDetailModifyReceiver();
    localObject = this.mComponentCenter;
    if (localObject != null) {
      ((IComponentCenter)localObject).onDestroy();
    }
    destroyProfileContainer();
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.onNewIntent(paramIntent);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.onPause();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(9);
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.onResume();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.onStart();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.onStop();
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void flingLToR()
  {
    if (this.mInterceptTouchEvent) {
      doOnBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public ClassLoader getClassLoader()
  {
    Object localObject = super.getClassLoader();
    ClassLoader localClassLoader3 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader3;
    ClassLoader localClassLoader2;
    if (localClassLoader3 == null) {
      try
      {
        localClassLoader1 = ((IQzonePluginProxyActivity)QRoute.api(IQzonePluginProxyActivity.class)).getQZonePluginClassLoader(getApplicationContext());
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 2, "getClassLoader fail.", localException);
        localClassLoader2 = localClassLoader3;
      }
    }
    if (localClassLoader2 != null)
    {
      this.mClassLoader = localClassLoader2;
      localObject = localClassLoader2;
    }
    return localObject;
  }
  
  public int getTitleBarHeight()
  {
    View localView = this.mTitleContainerView;
    if (localView != null) {
      return localView.getHeight();
    }
    return 0;
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    return this.mInterceptTouchEvent ^ true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if ((localIComponentCenter != null) && (localIComponentCenter.onBackPressed()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "onBackEvent event cost by component");
      }
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    View localView;
    if (ThemeUtil.isInNightMode(this.mApp))
    {
      localView = this.mNightModeMask;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.mNightModeMask;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onRestart");
    }
    if ((this.mProfileCardInfo.allInOne != null) && (this.mProfileCardInfo.allInOne.pa != 33))
    {
      Object localObject = this.mSubHandler;
      if (localObject != null)
      {
        localObject = ((WeakReferenceHandler)localObject).obtainMessage();
        if (ProfilePAUtils.isPaTypeHasUin(this.mProfileCardInfo.allInOne))
        {
          ((Message)localObject).what = 1;
          ((Message)localObject).obj = this.mProfileCardInfo.allInOne.uin;
          this.mSubHandler.sendMessage((Message)localObject);
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    dealQQBrowserActivityIntent(paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */