package com.tencent.mobileqq.profilecard.base.container;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.util.List;
import mqq.app.MobileQQ;

public class ProfileTitleContainer
  extends AbsQQProfileContainer
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  private static final int MSG_UPDATE_RIGHT_MORE_RED_TOUCH = 100;
  private static final String TAG = "ProfileTitleContainer";
  private static final int TITLE_MODE_DEFAULT = 0;
  private static final int TITLE_MODE_TRANS = 1;
  private StateListDrawable mBackDrawable;
  protected String mCallback4TroopFee = "";
  private TextView mCenterTextView;
  private ContactBindObserver mContactObserver = new ProfileTitleContainer.3(this);
  private int mContentScrollOffset;
  private Rect mContentVisibleRect;
  private AlphaAnimation mFadeInAnimation;
  private int mFadeInOutLine;
  private AlphaAnimation mFadeOutAnimation;
  private QQProgressDialog mHideContactSettingDialog;
  private ImmersiveTitleBar2 mImmersiveTitleBar;
  private boolean mIsFromArkBabyQ;
  private TextView mLeftTextView;
  private PullToZoomHeaderListView mListView;
  private LinearLayout mProfileCardTitleBar;
  private ImageView mRightImageView;
  private TextView mRightTextView;
  private RedTouch mRightViewRedTouch;
  private Animation.AnimationListener mTitleFadeAnimListener = new ProfileTitleContainer.1(this);
  public int mTroopFromFlag = -1;
  protected Intent mTroopOperationIntent = new Intent();
  private Handler.Callback mUICallback = new ProfileTitleContainer.2(this);
  private WeakReferenceHandler mUIHandler;
  
  public ProfileTitleContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void checkAndUpdateTroopInfo(TroopInfo paramTroopInfo, ProfileCardInfo paramProfileCardInfo)
  {
    paramProfileCardInfo = paramProfileCardInfo.allInOne;
    if ((paramTroopInfo != null) && (paramProfileCardInfo != null) && (ProfilePAUtils.isFromTroopMemberCard(paramProfileCardInfo.pa)) && (TextUtils.isEmpty(paramProfileCardInfo.troopUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTitleContainer", 2, String.format("checkAndUpdateTroopInfo troopuin=%s troopcode=%s", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
      paramProfileCardInfo.troopUin = paramTroopInfo.troopcode;
      paramProfileCardInfo.troopCode = paramTroopInfo.troopuin;
    }
  }
  
  private void checkToSwitchTitle(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.mCenterTextView == null) {
        return;
      }
      if (((ProfileCardInfo)this.mData).allInOne.pa == 33) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt == 0)
      {
        if (isInNoCoverMode()) {
          return;
        }
        if (this.mContentVisibleRect == null) {
          this.mContentVisibleRect = new Rect();
        }
        Object localObject1 = this.mListView.getChildAt(0);
        if (localObject1 != null) {
          ((View)localObject1).getLocalVisibleRect(this.mContentVisibleRect);
        }
        paramInt = this.mContentVisibleRect.top;
        int i = this.mCenterTextView.getVisibility();
        Object localObject2 = null;
        if ((paramInt >= 0) && (paramInt > this.mContentScrollOffset) && (paramInt >= this.mFadeInOutLine) && (i == 4))
        {
          localObject1 = this.mFadeInAnimation;
        }
        else
        {
          localObject1 = localObject2;
          if (paramInt >= 0)
          {
            localObject1 = localObject2;
            if (paramInt < this.mContentScrollOffset)
            {
              localObject1 = localObject2;
              if (paramInt <= this.mFadeInOutLine)
              {
                localObject1 = localObject2;
                if (i == 0) {
                  localObject1 = this.mFadeOutAnimation;
                }
              }
            }
          }
        }
        if ((localObject1 != null) && (localObject1 != this.mCenterTextView.getAnimation()))
        {
          ((Animation)localObject1).reset();
          this.mCenterTextView.startAnimation((Animation)localObject1);
          this.mImmersiveTitleBar.startAnimation((Animation)localObject1);
        }
        this.mContentScrollOffset = paramInt;
      }
    }
  }
  
  private void dismissHideContactDialog()
  {
    try
    {
      if ((this.mHideContactSettingDialog != null) && (this.mHideContactSettingDialog.isShowing())) {
        this.mHideContactSettingDialog.dismiss();
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTitleContainer", 1, "dismissHideContactDialog fail.", localException);
    }
    this.mHideContactSettingDialog = null;
  }
  
  private View expandRedTouchTargetView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mActivity == null) {
      return null;
    }
    Object localObject = this.mActivity.getResources();
    FrameLayout localFrameLayout = new FrameLayout(paramView.getContext());
    localFrameLayout.setLayoutParams(paramView.getLayoutParams());
    localFrameLayout.setPadding(AIOUtils.b(paramInt1, (Resources)localObject), AIOUtils.b(paramInt2, (Resources)localObject), AIOUtils.b(paramInt3, (Resources)localObject), AIOUtils.b(paramInt4, (Resources)localObject));
    localObject = (ViewGroup)paramView.getParent();
    paramInt1 = ((ViewGroup)localObject).indexOfChild(paramView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject).removeView(paramView);
    localFrameLayout.addView(paramView, localLayoutParams);
    ((ViewGroup)localObject).addView(localFrameLayout, paramInt1);
    return localFrameLayout;
  }
  
  private Drawable getBackDrawable()
  {
    if (this.mBackDrawable == null) {
      try
      {
        Object localObject1 = this.mActivity.getResources();
        Object localObject2 = BitmapFactory.decodeResource((Resources)localObject1, 2130852243);
        Bitmap localBitmap = BitmapFactory.decodeResource((Resources)localObject1, 2130852247);
        localObject2 = new NinePatchDrawable((Resources)localObject1, (Bitmap)localObject2, ((Bitmap)localObject2).getNinePatchChunk(), new Rect(), null);
        localObject1 = new NinePatchDrawable((Resources)localObject1, localBitmap, localBitmap.getNinePatchChunk(), new Rect(), null);
        this.mBackDrawable = new StateListDrawable();
        this.mBackDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        this.mBackDrawable.addState(new int[0], (Drawable)localObject2);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileTitleContainer", 1, "getBackDrawable fail.", localException);
      }
    }
    return this.mBackDrawable;
  }
  
  private String getContactStrangerUin(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.queryContactByCodeNumber(ProfileUtils.getMobileNumberWithNationCode(paramProfileCardInfo.allInOne));
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.uin;
      }
    }
    return null;
  }
  
  private int getDIYTemplateTitleBarColorResource()
  {
    VasDiyData localVasDiyData = (VasDiyData)((ProfileCardInfo)this.mData).getBusinessInfo(VasDiyData.class);
    if ((localVasDiyData != null) && (localVasDiyData.getTitleStyle() == 0)) {
      return 2131167662;
    }
    return 2131167517;
  }
  
  private void handleHideContact(IPhoneContactService paramIPhoneContactService, boolean paramBoolean)
  {
    if (NetworkUtil.isNetSupport(this.mApp.getApplication().getApplicationContext()))
    {
      paramIPhoneContactService.hideContact(ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo)this.mData).allInOne), paramBoolean ^ true);
      showHideContactProgressDialog();
      AppInterface localAppInterface = this.mApp;
      if (paramBoolean) {
        paramIPhoneContactService = "0X800603E";
      } else {
        paramIPhoneContactService = "0X800603D";
      }
      String str;
      if (paramBoolean) {
        str = "0X800603E";
      } else {
        str = "0X800603D";
      }
      ReportController.b(localAppInterface, "CliOper", "", "", paramIPhoneContactService, str, 0, 0, "", "", "", "");
      return;
    }
    paramIPhoneContactService = HardCodeUtil.a(2131902891);
    QQToast.makeText(this.mActivity, 1, paramIPhoneContactService, 1000).show();
  }
  
  private void handleRecommendContact()
  {
    if (NetworkUtil.isNetSupport(this.mApp.getApplication().getApplicationContext()))
    {
      Object localObject2 = ((ProfileCardInfo)this.mData).nameArray[3];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equals(((ProfileCardInfo)this.mData).contactCard.mobileNo)) {}
      }
      else
      {
        localObject1 = ((ProfileCardInfo)this.mData).allInOne.contactName;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(((ProfileCardInfo)this.mData).contactCard.mobileNo)) {}
      }
      else
      {
        localObject2 = ((ProfileCardInfo)this.mData).contactCard.nickName;
      }
      localObject2 = ForwardShareCardOption.a(this.mQQAppInterface, this.mActivity, ((ProfileCardInfo)this.mData).allInOne.uin, (String)localObject2, ((ProfileCardInfo)this.mData).contactCard.bindQQ);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", ((ProfileCardInfo)this.mData).contactCard.mobileNo);
      ((Bundle)localObject1).putInt("uintype", 1006);
      ((Bundle)localObject1).putInt("forward_type", 20);
      ((Bundle)localObject1).putInt("structmsg_service_id", ((AbsShareMsg)localObject2).mMsgServiceID);
      ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      ((Bundle)localObject1).putBoolean("k_dataline", false);
      ((Bundle)localObject1).putInt("pa_type", ((ProfileCardInfo)this.mData).allInOne.pa);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ForwardBaseOption.a(this.mActivity, (Intent)localObject2, 21);
      if (((ProfileCardInfo)this.mData).allInOne.pa == 53)
      {
        ReportController.b(this.mApp, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.mApp, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
      return;
    }
    Object localObject1 = HardCodeUtil.a(2131902906);
    QQToast.makeText(this.mActivity, 1, (CharSequence)localObject1, 1000).show();
  }
  
  private void handleRecommendContactActivityResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    AIOUtils.a(localIntent, null);
    paramIntent.putExtra("selfSet_leftViewText", this.mActivity.getString(2131917002));
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a(localIntent);
    ForwardUtils.a(this.mQQAppInterface, this.mActivity, paramIntent, localIntent);
  }
  
  private void handleTroopMoreActivityResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    boolean bool1 = paramIntent.getBooleanExtra("extra_is_deleted", false);
    boolean bool2 = paramIntent.getBooleanExtra("extra_is_msg_tip_modify", false);
    boolean bool3 = paramIntent.getBooleanExtra("extra_is_admin_modify", false);
    boolean bool4 = paramIntent.getBooleanExtra("isNeedFinish", false);
    boolean bool5 = paramIntent.getBooleanExtra("extra_is_level_modify", false);
    if ((bool2) || (bool5)) {
      setTroopOperationResult(2);
    }
    if (bool3) {
      setTroopOperationResult(4);
    }
    if (bool1) {
      setTroopOperationResult(1);
    }
    if (bool4)
    {
      paramIntent = new Intent();
      if (!bool1)
      {
        paramIntent.putExtra("isNeedFinish", bool4);
        this.mActivity.setResult(-1, paramIntent);
      }
      else if (this.mTroopFromFlag == 8)
      {
        paramIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
        paramIntent.putExtra("callback", this.mCallback4TroopFee);
        this.mActivity.setResult(-1, paramIntent);
      }
      this.mActivity.finish();
    }
  }
  
  private void initViews()
  {
    if (this.mViewContainer != null)
    {
      this.mActivity.getLayoutInflater().inflate(2131627745, (ViewGroup)this.mViewContainer);
      this.mImmersiveTitleBar = ((ImmersiveTitleBar2)((FrameLayout)this.mViewContainer).findViewById(2131447582));
      this.mLeftTextView = ((TextView)((FrameLayout)this.mViewContainer).findViewById(2131436180));
      this.mCenterTextView = ((TextView)((FrameLayout)this.mViewContainer).findViewById(2131436227));
      this.mRightTextView = ((TextView)((FrameLayout)this.mViewContainer).findViewById(2131436211));
      this.mRightImageView = ((ImageView)((FrameLayout)this.mViewContainer).findViewById(2131436194));
      this.mProfileCardTitleBar = ((LinearLayout)((FrameLayout)this.mViewContainer).findViewById(2131440700));
      this.mProfileCardTitleBar.setClickable(true);
      Resources localResources = this.mActivity.getResources();
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      int i = localResources.getDimensionPixelSize(2131299920);
      this.mFadeInOutLine = (localResources.getDimensionPixelSize(2131298277) - i - (int)(localDisplayMetrics.density * 66.0F));
      this.mFadeInAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.mFadeInAnimation.setDuration(300L);
      this.mFadeInAnimation.setInterpolator(this.mActivity, 17432581);
      this.mFadeInAnimation.setAnimationListener(this.mTitleFadeAnimListener);
      this.mFadeOutAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.mFadeOutAnimation.setDuration(300L);
      this.mFadeOutAnimation.setInterpolator(this.mActivity, 17432581);
      this.mFadeOutAnimation.setAnimationListener(this.mTitleFadeAnimListener);
    }
  }
  
  private boolean isGatherFriend(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.allInOne.pa == 1)
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramQQAppInterface == null) {
        paramQQAppInterface = null;
      } else {
        paramQQAppInterface = paramQQAppInterface.b(paramProfileCardInfo.allInOne.uin);
      }
      if ((paramQQAppInterface != null) && (paramQQAppInterface.gathtertype == 1)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isInNoCoverMode()
  {
    Object localObject = (AbsProfileHeaderComponent)this.mComponentCenter.getComponent(1002);
    if (localObject != null)
    {
      localObject = ((AbsProfileHeaderComponent)localObject).getHeaderView();
      if (((localObject instanceof ProfileBaseView)) && (((ProfileBaseView)localObject).isInNoCoverMode())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isPaTypeStrangerShowTitleRight(AllInOne paramAllInOne)
  {
    return (paramAllInOne.pa == 72) || (paramAllInOne.pa == 71) || (paramAllInOne.pa == 70) || (paramAllInOne.pa == 21) || (paramAllInOne.pa == 58) || (paramAllInOne.pa == 22) || (paramAllInOne.pa == 46) || (paramAllInOne.pa == 47) || (paramAllInOne.pa == 41) || (paramAllInOne.pa == 42) || (paramAllInOne.pa == 86) || (paramAllInOne.pa == 56) || (paramAllInOne.pa == 57) || (paramAllInOne.pa == 2) || (paramAllInOne.pa == 74) || (paramAllInOne.pa == 96) || (paramAllInOne.pa == 95);
  }
  
  private void openProfileMore()
  {
    Intent localIntent = new Intent(this.mActivity, ProfileCardMoreActivity.class);
    BusinessCard localBusinessCard = BusinessCardUtils.a(this.mQQAppInterface, (ProfileCardInfo)this.mData);
    localIntent = ProfileCardUtil.a(localIntent, ((ProfileCardInfo)this.mData).allInOne.uin, this.mQQAppInterface, ((ProfileCardInfo)this.mData).allInOne, localBusinessCard);
    if ((((ProfileCardInfo)this.mData).profileName != null) && (((ProfileCardInfo)this.mData).profileName.b.size() > 0)) {
      localIntent.putExtra("SHARE_NICK_NAME", ((MQQName)((ProfileCardInfo)this.mData).profileName.b.get(0)).b);
    }
    if ((((ProfileCardInfo)this.mData).card != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).card.addSrcName))) {
      localIntent.putExtra("cur_add_source", ((ProfileCardInfo)this.mData).card.addSrcName);
    }
    if (((ProfileCardInfo)this.mData).card != null) {
      localIntent.putExtra("key_nick_name", ((ProfileCardInfo)this.mData).card.strNick);
    }
    localIntent.addFlags(536870912);
    this.mActivity.startActivityForResult(localIntent, 1012);
    ReportController.b(this.mApp, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
  }
  
  private void openQRCode()
  {
    String str1 = this.mActivity.getString(2131914184);
    String str2 = this.mApp.getCurrentAccountUin();
    String str3 = ContactUtils.f(this.mQQAppInterface, str2);
    Intent localIntent = new Intent(this.mActivity, QRDisplayActivity.class);
    localIntent.putExtra("title", str1);
    localIntent.putExtra("uin", str2);
    localIntent.putExtra("nick", str3);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    this.mActivity.startActivity(localIntent);
  }
  
  private void openTroopMore(View paramView)
  {
    Object localObject1 = new ReportTask(this.mQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("more_clk");
    Object localObject2 = ((ProfileCardInfo)this.mData).troopUin;
    int i = 0;
    ((ReportTask)localObject1).a(new String[] { localObject2 }).a();
    localObject1 = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    localObject2 = ((TroopManager)localObject1).f(((ProfileCardInfo)this.mData).troopUin);
    if (localObject2 != null)
    {
      checkAndUpdateTroopInfo((TroopInfo)localObject2, (ProfileCardInfo)this.mData);
      Intent localIntent = new Intent();
      localIntent.putExtra("troopUin", ((ProfileCardInfo)this.mData).troopUin);
      localIntent.putExtra("memberUin", ((ProfileCardInfo)this.mData).card.uin);
      localIntent.putExtra("fromFlag", this.mTroopFromFlag);
      localIntent.putExtra("troopMemberCard", ((ProfileCardInfo)this.mData).troopMemberCard);
      localIntent.putExtra("troopCode", ((TroopInfo)localObject2).troopcode);
      localIntent.putExtra("troopName", ((TroopInfo)localObject2).getTroopDisplayName());
      Object localObject3 = this.mApp;
      localObject2 = "";
      localIntent.putExtra("hwCard", ((IBizTroopMemberInfoService)((AppInterface)localObject3).getRuntimeService(IBizTroopMemberInfoService.class, "")).getHWTroopMemberCard(((ProfileCardInfo)this.mData).troopUin, ((ProfileCardInfo)this.mData).card.uin));
      localIntent.putExtra("qidian_private_troop", ((TroopManager)localObject1).Z(((ProfileCardInfo)this.mData).troopUin));
      localIntent.putExtra("AllInOne", ((ProfileCardInfo)this.mData).allInOne);
      localIntent.putExtra("detailProfileUrl", ProfileCardUtil.a(this.mQQAppInterface, this.mActivity, (ProfileCardInfo)this.mData));
      localIntent.putExtra("qidianshowUin", QidianManager.d(this.mQQAppInterface, ((ProfileCardInfo)this.mData).allInOne.uin));
      if (TextUtils.isEmpty(((ProfileCardInfo)this.mData).allInOne.nickname)) {
        ((ProfileCardInfo)this.mData).allInOne.nickname = ContactUtils.f(this.mQQAppInterface, ((ProfileCardInfo)this.mData).allInOne.uin);
      }
      localObject3 = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
      boolean bool2 = ((FriendsManager)localObject3).n(((ProfileCardInfo)this.mData).allInOne.uin);
      localIntent.putExtra("isFriend", bool2);
      localIntent.putExtra("isQidianMaster", ((QidianManager)this.mApp.getManager(QQManagerFactory.QIDIAN_MANAGER)).m(((ProfileCardInfo)this.mData).allInOne.uin));
      Friends localFriends = ((FriendsManager)localObject3).c(((ProfileCardInfo)this.mData).allInOne.uin);
      boolean bool1;
      if (localFriends != null)
      {
        localIntent.putExtra("specialFlag", localFriends.cSpecialFlag);
        if (localFriends.isFriend())
        {
          localIntent.putExtra("key_remark", localFriends.remark);
          localIntent.putExtra("key_group_id", localFriends.groupid);
          localIntent.putExtra("key_current_nick", ContactUtils.d(this.mQQAppInterface, this.mApp.getCurrentAccountUin()));
          localObject1 = ((FriendsManager)localObject3).u(String.valueOf(localFriends.groupid));
          if (localObject1 == null) {
            localObject1 = "";
          } else {
            localObject1 = ((Groups)localObject1).group_name;
          }
          localIntent.putExtra("key_group_name", (String)localObject1);
          localIntent.putExtra("key_not_disturb", FriendsStatusUtil.a(((ProfileCardInfo)this.mData).allInOne.uin, this.mQQAppInterface));
          localIntent.putExtra("key_is_shield", ((FriendsManager)localObject3).w(((ProfileCardInfo)this.mData).allInOne.uin));
          localIntent.putExtra("key_type_gather", localFriends.gathtertype);
          localIntent.putExtra("key_is_has_interaction", MutualMarkDataCenter.b(this.mQQAppInterface, ((ProfileCardInfo)this.mData).allInOne.uin, true));
          localObject1 = ((FriendsManager)localObject3).y(((ProfileCardInfo)this.mData).allInOne.uin);
          if ((localObject1 != null) && (((SpecialCareInfo)localObject1).globalSwitch != 0)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localIntent.putExtra("key_is_specialcare", bool1);
        }
      }
      localIntent.putExtra("businessCard", BusinessCardUtils.a(this.mQQAppInterface, (ProfileCardInfo)this.mData));
      if ((((ProfileCardInfo)this.mData).profileName != null) && (((ProfileCardInfo)this.mData).profileName.b.size() > 0)) {
        localIntent.putExtra("SHARE_NICK_NAME", ((MQQName)((ProfileCardInfo)this.mData).profileName.b.get(0)).b);
      }
      if ((((ProfileCardInfo)this.mData).card != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).card.addSrcName))) {
        localIntent.putExtra("cur_add_source", ((ProfileCardInfo)this.mData).card.addSrcName);
      }
      if (((ProfileCardInfo)this.mData).card != null) {
        localIntent.putExtra("key_nick_name", ((ProfileCardInfo)this.mData).card.strNick);
      }
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText().toString();
        if (!TextUtils.isEmpty(paramView)) {
          localIntent.putExtra("title", paramView);
        }
      }
      if (bool2)
      {
        localIntent.putExtra("friend_intimate_open", FriendIntimateRelationshipHelper.a(this.mApp.getCurrentUin()));
        localIntent.putExtra("friend_intimate_bind_url", FriendIntimateRelationshipHelper.b(((ProfileCardInfo)this.mData).allInOne.uin));
        localObject1 = MutualMarkDataCenter.a(this.mQQAppInterface, ((ProfileCardInfo)this.mData).allInOne.uin, true);
        if (localObject1 != null)
        {
          paramView = IntimateUtil.a(this.mActivity, ((MutualMarkForDisplayInfo)localObject1).a);
          i = ((MutualMarkForDisplayInfo)localObject1).q;
          bool1 = ((MutualMarkForDisplayInfo)localObject1).b();
        }
        else
        {
          bool1 = false;
          paramView = (View)localObject2;
        }
        localIntent.putExtra("friend_intimate_bind_name", paramView);
        localIntent.putExtra("friend_intimate_isExtinguish", bool1);
        localIntent.putExtra("friend_intimate_bind_res_icon", i);
      }
      localIntent.putExtra("isMsgShielded", isMsgShielded(this.mQQAppInterface, (ProfileCardInfo)this.mData));
      localIntent.putExtra("isGather", isGatherFriend(this.mQQAppInterface, (ProfileCardInfo)this.mData));
      paramView = TroopBaseProxyActivity.a(this.mActivity);
      TroopMemberCardProxyActivity.a(this.mQQAppInterface, "troop_member_card_plugin.apk", HardCodeUtil.a(2131902880), TroopMemberCardProxyActivity.class, this.mActivity, localIntent, paramView, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.mApp.getCurrentAccountUin(), 8);
    }
  }
  
  private void showContactActionSheet()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.mApp.getRuntimeService(IPhoneContactService.class, "");
    PhoneContact localPhoneContact = localIPhoneContactService.queryContactByCodeNumber(ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo)this.mData).allInOne));
    boolean bool;
    if ((localPhoneContact != null) && (localPhoneContact.isHiden)) {
      bool = true;
    } else {
      bool = false;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.mActivity, null);
    localActionSheet.addButton(2131890893);
    if (((ProfileCardInfo)this.mData).allInOne.pa == 53)
    {
      ReportController.b(this.mApp, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
    }
    else
    {
      if ((!TextUtils.isEmpty(getContactStrangerUin(this.mQQAppInterface, (ProfileCardInfo)this.mData))) && (localPhoneContact != null))
      {
        int i;
        if (localPhoneContact.isHiden) {
          i = 2131890894;
        } else {
          i = 2131890892;
        }
        localActionSheet.addButton(i);
      }
      ReportController.b(this.mApp, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ProfileTitleContainer.8(this, localIPhoneContactService, bool, localActionSheet));
    try
    {
      if (!this.mActivity.isFinishing())
      {
        localActionSheet.show();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTitleContainer", 1, "", localException);
    }
  }
  
  private void showHideContactProgressDialog()
  {
    try
    {
      if (!this.mActivity.isFinishing())
      {
        this.mHideContactSettingDialog = new QQProgressDialog(this.mActivity);
        this.mHideContactSettingDialog.setCancelable(false);
        this.mHideContactSettingDialog.c(2131892860);
        this.mHideContactSettingDialog.show();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTitleContainer", 1, "showHideContactProgressDialog fail.", localException);
    }
  }
  
  private void showMoreActionSheet()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.mActivity, null);
    localActionSheet.addButton(2131897183, 1);
    localActionSheet.addButton(2131897182, 1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ProfileTitleContainer.5(this, localActionSheet));
    localActionSheet.setOnBottomCancelListener(new ProfileTitleContainer.6(this, localActionSheet));
    localActionSheet.setOnPreShowListener(new ProfileTitleContainer.7(this, localActionSheet));
    try
    {
      if (!this.mActivity.isFinishing())
      {
        localActionSheet.show();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTitleContainer", 1, "showMoreActionSheet actionSheet show fail.", localException);
    }
  }
  
  private void updateTitle()
  {
    this.mLeftTextView.setText("");
    this.mLeftTextView.setOnClickListener(new ProfileTitleContainer.4(this));
    boolean bool;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.mCenterTextView.setText(2131890917);
    } else {
      this.mCenterTextView.setText(2131890916);
    }
    updateTitleRight(bool);
  }
  
  private void updateTitleMode()
  {
    boolean bool1;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 33) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = isInNoCoverMode();
    boolean bool2;
    if (this.mContentScrollOffset >= this.mFadeInOutLine) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTitleContainer", 2, String.format("updateTitleMode contactStranger=%s isInNoCoverMode=%s titleHasFadeIn=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
    }
    if ((!bool1) && (!bool3) && (!bool2))
    {
      updateTitleMode(1);
      return;
    }
    updateTitleMode(0);
  }
  
  private void updateTitleMode(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTitleContainer", 2, String.format("updateTitleMode mode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.mActivity.getResources();
    int i = 2131167987;
    if (paramInt == 1)
    {
      if (ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo)this.mData).curUseStyleId))
      {
        i = getDIYTemplateTitleBarColorResource();
        paramInt = ((Resources)localObject).getColor(i);
        this.mLeftTextView.setTextColor(((Resources)localObject).getColorStateList(i));
        this.mRightTextView.setTextColor(((Resources)localObject).getColorStateList(i));
      }
      else
      {
        if (ThemeUtil.isInNightMode(this.mApp)) {
          paramInt = i;
        } else {
          paramInt = 2131167662;
        }
        paramInt = ((Resources)localObject).getColor(paramInt);
        this.mLeftTextView.setTextColor(paramInt);
        this.mRightTextView.setTextColor(paramInt);
      }
      this.mCenterTextView.setVisibility(4);
      this.mImmersiveTitleBar.setVisibility(4);
      ImmersiveUtils.setStatusTextColor(false, this.mActivity.getWindow());
    }
    else if (paramInt == 0)
    {
      paramInt = ((Resources)localObject).getColor(2131167987);
      this.mLeftTextView.setTextColor(((Resources)localObject).getColorStateList(2131167987));
      this.mRightTextView.setTextColor(((Resources)localObject).getColorStateList(2131167987));
      this.mCenterTextView.setVisibility(0);
      this.mImmersiveTitleBar.setVisibility(0);
      SimpleUIUtil.a(this.mImmersiveTitleBar, this.mActivity.getWindow());
    }
    else
    {
      paramInt = 0;
    }
    localObject = getBackDrawable();
    if (localObject != null)
    {
      ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, paramInt));
      this.mLeftTextView.setBackgroundDrawable((Drawable)localObject);
    }
    this.mRightImageView.setColorFilter(paramInt);
  }
  
  private void updateTitleRedTouch()
  {
    if ((this.mRightTextView.getTag() instanceof DataTag))
    {
      Object localObject = (DataTag)this.mRightTextView.getTag();
      if ((((DataTag)localObject).a == 98) || (((DataTag)localObject).a == 99))
      {
        localObject = ProfileCardUtil.d();
        this.mUIHandler.obtainMessage(100, localObject).sendToTarget();
      }
    }
  }
  
  private void updateTitleRight(boolean paramBoolean)
  {
    ProfileTitleContainer.TitleRightStatus localTitleRightStatus = updateTitleRightStatus(paramBoolean, (ProfileCardInfo)this.mData);
    if (localTitleRightStatus.showTextView)
    {
      this.mRightTextView.setVisibility(0);
      this.mRightTextView.setTag(new DataTag(localTitleRightStatus.textTagType, null));
      this.mRightTextView.setOnClickListener(this);
      this.mRightTextView.setText(localTitleRightStatus.textResId);
    }
    else
    {
      this.mRightTextView.setVisibility(8);
    }
    if (localTitleRightStatus.showImageView)
    {
      this.mRightImageView.setVisibility(0);
      this.mRightImageView.setTag(new DataTag(localTitleRightStatus.imageTagType, null));
      this.mRightImageView.setOnClickListener(this);
      if (paramBoolean)
      {
        this.mRightImageView.setImageResource(2130841095);
        this.mRightImageView.setContentDescription(HardCodeUtil.a(2131902883));
        return;
      }
      this.mRightImageView.setBackgroundResource(2130841087);
      this.mRightImageView.setContentDescription(HardCodeUtil.a(2131902916));
      return;
    }
    this.mRightImageView.setVisibility(8);
  }
  
  private ProfileTitleContainer.TitleRightStatus updateTitleRightStatus(boolean paramBoolean, ProfileCardInfo paramProfileCardInfo)
  {
    ProfileTitleContainer.TitleRightStatus localTitleRightStatus = new ProfileTitleContainer.TitleRightStatus(null);
    boolean bool = false;
    localTitleRightStatus.showTextView = false;
    localTitleRightStatus.showImageView = false;
    localTitleRightStatus.textTagType = 16;
    localTitleRightStatus.textResId = 2131892856;
    localTitleRightStatus.imageTagType = 16;
    if (paramBoolean)
    {
      if (paramProfileCardInfo.isTroopMemberCard)
      {
        localTitleRightStatus.showTextView = true;
        localTitleRightStatus.showImageView = false;
        localTitleRightStatus.textTagType = 16;
      }
      else
      {
        localTitleRightStatus.showTextView = true;
        localTitleRightStatus.showImageView = true;
        localTitleRightStatus.textTagType = 98;
        localTitleRightStatus.textResId = 2131892888;
        localTitleRightStatus.imageTagType = 65;
      }
    }
    else if (ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne))
    {
      if (!this.mIsFromArkBabyQ) {
        localTitleRightStatus.showTextView = true;
      }
    }
    else if ((!isPaTypeStrangerShowTitleRight(paramProfileCardInfo.allInOne)) && (!ProfilePAUtils.isPaTypeShowAccount(paramProfileCardInfo.allInOne)))
    {
      if (paramProfileCardInfo.allInOne.pa == 3)
      {
        paramBoolean = bool;
        if (paramProfileCardInfo.allInOne.chatAbility != 0) {
          paramBoolean = true;
        }
        localTitleRightStatus.showTextView = paramBoolean;
      }
      else if ((paramProfileCardInfo.allInOne.pa != 32) && (paramProfileCardInfo.allInOne.pa != 31) && (paramProfileCardInfo.allInOne.pa != 50) && (paramProfileCardInfo.allInOne.pa != 51) && (paramProfileCardInfo.allInOne.pa != 34))
      {
        if ((paramProfileCardInfo.allInOne.pa == 53) && (paramProfileCardInfo.contactCard != null) && (!TextUtils.equals(paramProfileCardInfo.contactCard.uin, this.mApp.getCurrentAccountUin())))
        {
          localTitleRightStatus.showImageView = true;
          localTitleRightStatus.imageTagType = 44;
        }
      }
      else
      {
        localTitleRightStatus.showImageView = true;
        localTitleRightStatus.imageTagType = 44;
      }
    }
    else {
      localTitleRightStatus.showTextView = true;
    }
    if ((paramProfileCardInfo.isTroopMemberCard) && (localTitleRightStatus.showTextView)) {
      localTitleRightStatus.showTextView = paramProfileCardInfo.troopShowMoreBtn;
    }
    return localTitleRightStatus;
  }
  
  public String getComponentName()
  {
    return "ProfileTitleContainer";
  }
  
  public int getComponentType()
  {
    return 106;
  }
  
  boolean isMsgShielded(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 1)
    {
      Object localObject = null;
      String str = null;
      if ((i != 86) && (i != 41) && (i != 42))
      {
        localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject != null) && (((FriendsManager)localObject).n(paramProfileCardInfo.allInOne.uin))) {
          return ((FriendsManager)localObject).w(paramProfileCardInfo.allInOne.uin);
        }
        localObject = (ShieldMsgManger)paramQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        if (localObject != null)
        {
          if (ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne)) {
            str = paramProfileCardInfo.allInOne.uin;
          } else if (ProfilePAUtils.isPaTypeStrangerInContact(paramProfileCardInfo.allInOne)) {
            str = getContactStrangerUin(paramQQAppInterface, paramProfileCardInfo);
          }
          if (!TextUtils.isEmpty(str)) {
            return ((ShieldMsgManger)localObject).a(str);
          }
        }
      }
      else
      {
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramQQAppInterface == null) {
          paramQQAppInterface = (QQAppInterface)localObject;
        } else {
          paramQQAppInterface = paramQQAppInterface.b(paramProfileCardInfo.allInOne.uin);
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.groupid == -1002)) {
          return true;
        }
      }
    }
    else
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.w(paramProfileCardInfo.allInOne.uin);
      }
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 8)
    {
      handleTroopMoreActivityResult(paramIntent);
      return;
    }
    if (paramInt1 == 21) {
      handleRecommendContactActivityResult(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag))
    {
      int i = ((DataTag)paramView.getTag()).a;
      if (i != 16)
      {
        if (i != 44)
        {
          if (i != 65)
          {
            if (i != 98)
            {
              if (i == 99) {
                ProfileCardUtil.c(this.mActivity);
              }
            }
            else if (((ProfileCardInfo)this.mData).allInOne.pa == 0)
            {
              showMoreActionSheet();
              RedTouch localRedTouch = this.mRightViewRedTouch;
              if ((localRedTouch != null) && (localRedTouch.h())) {
                i = 1;
              } else {
                i = 2;
              }
              ReportController.b(this.mApp, "dc00898", "", "", "0X800A97C", "0X800A97C", i, 0, "0", "0", "", "");
            }
          }
          else
          {
            openQRCode();
            ReportController.b(this.mApp, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
          }
        }
        else {
          showContactActionSheet();
        }
      }
      else if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
        openTroopMore(paramView);
      } else {
        openProfileMore();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null)
    {
      this.mIsFromArkBabyQ = paramQBaseActivity.getBooleanExtra("key_from_ark_babyq", false);
      this.mTroopFromFlag = paramQBaseActivity.getIntExtra("fromFlag", -1);
      if (this.mTroopFromFlag == 8) {
        this.mCallback4TroopFee = paramQBaseActivity.getStringExtra("callback");
      }
    }
    this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
    if (this.mDelegate != null) {
      this.mDelegate.addProfileScrollListener(this);
    }
    if (this.mApp != null) {
      this.mApp.registObserver(this.mContactObserver);
    }
    initViews();
    updateTitle();
    updateTitleMode();
    paramQBaseActivity = HardCodeUtil.a(2131902909);
    AccessibilityUtil.a(this.mLeftTextView, paramQBaseActivity);
    AccessibilityUtil.a(this.mLeftTextView);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    updateTitle();
    updateTitleMode();
    return true;
  }
  
  public void onDestroy()
  {
    if (this.mDelegate != null) {
      this.mDelegate.removeProfileScrollListener(this);
    }
    if (this.mApp != null) {
      this.mApp.unRegistObserver(this.mContactObserver);
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    updateTitleRedTouch();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    checkToSwitchTitle(paramInt1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void setProfileActivityDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    super.setProfileActivityDelegate(paramIProfileActivityDelegate);
    if (this.mDelegate != null) {
      this.mListView = this.mDelegate.getListView();
    }
  }
  
  protected void setTroopOperationResult(int paramInt)
  {
    int i = this.mTroopFromFlag;
    if ((i == 1) || (i == 7))
    {
      i = this.mTroopOperationIntent.getIntExtra("memberOperationFlag", 0);
      this.mTroopOperationIntent.putExtra("memberOperationFlag", paramInt | i);
      this.mTroopOperationIntent.putExtra("memberOperateUin", ((ProfileCardInfo)this.mData).allInOne.uin);
      this.mActivity.setResult(-1, this.mTroopOperationIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer
 * JD-Core Version:    0.7.0.1
 */