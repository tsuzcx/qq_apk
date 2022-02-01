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
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class ProfileTitleContainer
  extends AbsProfileComponent<FrameLayout>
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
  private IProfileActivityDelegate mProfileDelegate;
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
    paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((paramTroopInfo != null) && (paramProfileCardInfo != null) && (ProfileActivity.f(paramProfileCardInfo.jdField_a_of_type_Int)) && (TextUtils.isEmpty(paramProfileCardInfo.jdField_d_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTitleContainer", 2, String.format("checkAndUpdateTroopInfo troopuin=%s troopcode=%s", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
      paramProfileCardInfo.jdField_d_of_type_JavaLangString = paramTroopInfo.troopcode;
      paramProfileCardInfo.c = paramTroopInfo.troopuin;
    }
  }
  
  private void checkToSwitchTitle(int paramInt)
  {
    if ((paramInt != 0) || (this.mCenterTextView == null)) {
      return;
    }
    label32:
    Object localObject1;
    int i;
    Object localObject2;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramInt = 1;
      if ((paramInt != 0) || (isInNoCoverMode())) {
        break label176;
      }
      if (this.mContentVisibleRect == null) {
        this.mContentVisibleRect = new Rect();
      }
      localObject1 = this.mListView.getChildAt(0);
      if (localObject1 != null) {
        ((View)localObject1).getLocalVisibleRect(this.mContentVisibleRect);
      }
      paramInt = this.mContentVisibleRect.top;
      i = this.mCenterTextView.getVisibility();
      localObject2 = null;
      if ((paramInt < 0) || (paramInt <= this.mContentScrollOffset) || (paramInt < this.mFadeInOutLine) || (i != 4)) {
        break label178;
      }
      localObject1 = this.mFadeInAnimation;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.mCenterTextView.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.mCenterTextView.startAnimation((Animation)localObject1);
        this.mImmersiveTitleBar.startAnimation((Animation)localObject1);
      }
      this.mContentScrollOffset = paramInt;
      return;
      paramInt = 0;
      break label32;
      label176:
      break;
      label178:
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
  }
  
  private void dismissHideContactDialog()
  {
    try
    {
      if ((this.mHideContactSettingDialog != null) && (this.mHideContactSettingDialog.isShowing())) {
        this.mHideContactSettingDialog.dismiss();
      }
      this.mHideContactSettingDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProfileTitleContainer", 1, "dismissHideContactDialog fail.", localException);
      }
    }
  }
  
  private View expandRedTouchTargetView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mActivity == null) {
      return null;
    }
    Object localObject = this.mActivity.getResources();
    FrameLayout localFrameLayout = new FrameLayout(paramView.getContext());
    localFrameLayout.setLayoutParams(paramView.getLayoutParams());
    localFrameLayout.setPadding(AIOUtils.a(paramInt1, (Resources)localObject), AIOUtils.a(paramInt2, (Resources)localObject), AIOUtils.a(paramInt3, (Resources)localObject), AIOUtils.a(paramInt4, (Resources)localObject));
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
    if (this.mBackDrawable == null) {}
    try
    {
      Object localObject1 = this.mActivity.getResources();
      Object localObject2 = BitmapFactory.decodeResource((Resources)localObject1, 2130850521);
      Bitmap localBitmap = BitmapFactory.decodeResource((Resources)localObject1, 2130850525);
      localObject2 = new NinePatchDrawable((Resources)localObject1, (Bitmap)localObject2, ((Bitmap)localObject2).getNinePatchChunk(), new Rect(), null);
      localObject1 = new NinePatchDrawable((Resources)localObject1, localBitmap, localBitmap.getNinePatchChunk(), new Rect(), null);
      this.mBackDrawable = new StateListDrawable();
      this.mBackDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
      this.mBackDrawable.addState(new int[0], (Drawable)localObject2);
      return this.mBackDrawable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProfileTitleContainer", 1, "getBackDrawable fail.", localException);
      }
    }
  }
  
  private String getContactStrangerUin(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(FriendProfileCardActivity.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.uin;
      }
    }
    return null;
  }
  
  private int getDIYTemplateTitleBarColorResource()
  {
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardVasVasDiyData != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardVasVasDiyData.getTitleStyle() == 0)) {
      return 2131166726;
    }
    return 2131166582;
  }
  
  private void handleHideContact(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean)
  {
    if (NetworkUtil.d(this.mApp.getApplication().getApplicationContext()))
    {
      String str = FriendProfileCardActivity.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool;
      QQAppInterface localQQAppInterface;
      if (!paramBoolean)
      {
        bool = true;
        paramPhoneContactManagerImp.a(str, bool);
        showHideContactProgressDialog();
        localQQAppInterface = this.mApp;
        if (!paramBoolean) {
          break label102;
        }
        paramPhoneContactManagerImp = "0X800603E";
        label62:
        if (!paramBoolean) {
          break label109;
        }
      }
      label102:
      label109:
      for (str = "0X800603E";; str = "0X800603D")
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", paramPhoneContactManagerImp, str, 0, 0, "", "", "", "");
        return;
        bool = false;
        break;
        paramPhoneContactManagerImp = "0X800603D";
        break label62;
      }
    }
    paramPhoneContactManagerImp = HardCodeUtil.a(2131704924);
    QQToast.a(this.mActivity, 1, paramPhoneContactManagerImp, 1000).a();
  }
  
  private void handleRecommendContact()
  {
    if (NetworkUtil.d(this.mApp.getApplication().getApplicationContext()))
    {
      Object localObject2 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[3];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equals(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
      }
      else
      {
        localObject1 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
      }
      else
      {
        localObject2 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataContactCard.nickName;
      }
      localObject2 = ForwardShareCardOption.a(this.mApp, this.mActivity, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject2, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo);
      ((Bundle)localObject1).putInt("uintype", 1006);
      ((Bundle)localObject1).putInt("forward_type", 20);
      ((Bundle)localObject1).putInt("structmsg_service_id", ((AbsShareMsg)localObject2).mMsgServiceID);
      ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      ((Bundle)localObject1).putBoolean("k_dataline", false);
      ((Bundle)localObject1).putInt("pa_type", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ForwardBaseOption.a(this.mActivity, (Intent)localObject2, 21);
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        ReportController.b(this.mApp, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.mApp, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
      return;
    }
    Object localObject1 = HardCodeUtil.a(2131704939);
    QQToast.a(this.mActivity, 1, (CharSequence)localObject1, 1000).a();
  }
  
  private void handleRecommendContactActivityResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    AIOUtils.a(localIntent, null);
    paramIntent.putExtra("selfSet_leftViewText", this.mActivity.getString(2131719718));
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a(localIntent);
    ForwardUtils.a(this.mApp, this.mActivity, paramIntent, localIntent);
  }
  
  private void handleTroopMoreActivityResult(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool1;
    boolean bool4;
    do
    {
      return;
      bool1 = paramIntent.getBooleanExtra("extra_is_deleted", false);
      boolean bool2 = paramIntent.getBooleanExtra("extra_is_msg_tip_modify", false);
      boolean bool3 = paramIntent.getBooleanExtra("extra_is_admin_modify", false);
      bool4 = paramIntent.getBooleanExtra("isNeedFinish", false);
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
    } while (!bool4);
    paramIntent = new Intent();
    if (!bool1)
    {
      paramIntent.putExtra("isNeedFinish", bool4);
      this.mActivity.setResult(-1, paramIntent);
    }
    for (;;)
    {
      this.mActivity.finish();
      return;
      if (this.mTroopFromFlag == 8)
      {
        paramIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
        paramIntent.putExtra("callback", this.mCallback4TroopFee);
        this.mActivity.setResult(-1, paramIntent);
      }
    }
  }
  
  private void initViews()
  {
    if (this.mViewContainer != null)
    {
      this.mActivity.getLayoutInflater().inflate(2131561548, (ViewGroup)this.mViewContainer);
      this.mImmersiveTitleBar = ((ImmersiveTitleBar2)((FrameLayout)this.mViewContainer).findViewById(2131379533));
      this.mLeftTextView = ((TextView)((FrameLayout)this.mViewContainer).findViewById(2131369487));
      this.mCenterTextView = ((TextView)((FrameLayout)this.mViewContainer).findViewById(2131369534));
      this.mRightTextView = ((TextView)((FrameLayout)this.mViewContainer).findViewById(2131369518));
      this.mRightImageView = ((ImageView)((FrameLayout)this.mViewContainer).findViewById(2131369501));
      Resources localResources = this.mActivity.getResources();
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      int i = localResources.getDimensionPixelSize(2131299166);
      this.mFadeInOutLine = (localResources.getDimensionPixelSize(2131297622) - i - (int)(localDisplayMetrics.density * 66.0F));
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
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1)
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramQQAppInterface == null) {}
      for (paramQQAppInterface = null; (paramQQAppInterface != null) && (paramQQAppInterface.gathtertype == 1); paramQQAppInterface = paramQQAppInterface.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
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
  
  private boolean isPaTypeStrangerShowTitleRight(ProfileActivity.AllInOne paramAllInOne)
  {
    return (paramAllInOne.jdField_a_of_type_Int == 72) || (paramAllInOne.jdField_a_of_type_Int == 71) || (paramAllInOne.jdField_a_of_type_Int == 70) || (paramAllInOne.jdField_a_of_type_Int == 21) || (paramAllInOne.jdField_a_of_type_Int == 58) || (paramAllInOne.jdField_a_of_type_Int == 22) || (paramAllInOne.jdField_a_of_type_Int == 46) || (paramAllInOne.jdField_a_of_type_Int == 47) || (paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 42) || (paramAllInOne.jdField_a_of_type_Int == 86) || (paramAllInOne.jdField_a_of_type_Int == 56) || (paramAllInOne.jdField_a_of_type_Int == 57) || (paramAllInOne.jdField_a_of_type_Int == 2) || (paramAllInOne.jdField_a_of_type_Int == 74) || (paramAllInOne.jdField_a_of_type_Int == 96) || (paramAllInOne.jdField_a_of_type_Int == 95);
  }
  
  private void openProfileMore()
  {
    Intent localIntent = new Intent(this.mActivity, ProfileCardMoreActivity.class);
    BusinessCard localBusinessCard = BusinessCardUtils.a(this.mApp, (ProfileCardInfo)this.mData);
    localIntent = ProfileCardUtil.a(localIntent, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.mApp, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, localBusinessCard);
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.size() > 0)) {
      localIntent.putExtra("SHARE_NICK_NAME", ((MQQName)((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.get(0)).jdField_a_of_type_JavaLangString);
    }
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
      localIntent.putExtra("cur_add_source", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
    }
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      localIntent.putExtra("key_nick_name", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
    }
    localIntent.addFlags(536870912);
    this.mActivity.startActivityForResult(localIntent, 1012);
    ReportController.b(this.mApp, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
  }
  
  private void openQRCode()
  {
    String str1 = this.mActivity.getString(2131717061);
    String str2 = this.mApp.getCurrentAccountUin();
    String str3 = ContactUtils.h(this.mApp, str2);
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
    boolean bool2 = false;
    new ReportTask(this.mApp).a("dc00899").b("Grp_mem_card").c("page").d("more_clk").a(new String[] { ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString }).a();
    Object localObject1 = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = ((TroopManager)localObject1).b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
    Intent localIntent;
    label761:
    int i;
    if (localObject2 != null)
    {
      checkAndUpdateTroopInfo((TroopInfo)localObject2, (ProfileCardInfo)this.mData);
      localIntent = new Intent();
      localIntent.putExtra("troopUin", ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
      localIntent.putExtra("memberUin", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      localIntent.putExtra("fromFlag", this.mTroopFromFlag);
      localIntent.putExtra("troopMemberCard", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard);
      localIntent.putExtra("troopCode", ((TroopInfo)localObject2).troopcode);
      localIntent.putExtra("troopName", ((TroopInfo)localObject2).getTroopDisplayName());
      localIntent.putExtra("hwCard", ((TroopManager)localObject1).a(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.uin));
      localIntent.putExtra("qidian_private_troop", ((TroopManager)localObject1).n(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString));
      localIntent.putExtra("AllInOne", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      localIntent.putExtra("detailProfileUrl", ProfileCardUtil.a(this.mApp, this.mActivity, (ProfileCardInfo)this.mData));
      localIntent.putExtra("qidianshowUin", QidianManager.b(this.mApp, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      if (TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
        ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ContactUtils.h(this.mApp, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      localObject2 = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
      boolean bool3 = ((FriendsManager)localObject2).b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("isFriend", bool3);
      localIntent.putExtra("isQidianMaster", ((QidianManager)this.mApp.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      Friends localFriends = ((FriendsManager)localObject2).b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (localFriends != null)
      {
        localIntent.putExtra("specialFlag", localFriends.cSpecialFlag);
        if (localFriends.isFriend())
        {
          localIntent.putExtra("key_remark", localFriends.remark);
          localIntent.putExtra("key_group_id", localFriends.groupid);
          localIntent.putExtra("key_current_nick", ContactUtils.j(this.mApp, this.mApp.getCurrentAccountUin()));
          localObject1 = ((FriendsManager)localObject2).a(String.valueOf(localFriends.groupid));
          if (localObject1 != null) {
            break label1221;
          }
          localObject1 = "";
          localIntent.putExtra("key_group_name", (String)localObject1);
          localIntent.putExtra("key_not_disturb", FriendsStatusUtil.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.mApp));
          localIntent.putExtra("key_is_shield", ((FriendsManager)localObject2).e(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          localIntent.putExtra("key_type_gather", localFriends.gathtertype);
          localIntent.putExtra("key_is_has_interaction", MutualMarkDataCenter.a(this.mApp, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true));
          localObject1 = ((FriendsManager)localObject2).a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((localObject1 == null) || (((SpecialCareInfo)localObject1).globalSwitch == 0)) {
            break label1231;
          }
          bool1 = true;
          localIntent.putExtra("key_is_specialcare", bool1);
        }
      }
      localIntent.putExtra("businessCard", BusinessCardUtils.a(this.mApp, (ProfileCardInfo)this.mData));
      if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.size() > 0)) {
        localIntent.putExtra("SHARE_NICK_NAME", ((MQQName)((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.get(0)).jdField_a_of_type_JavaLangString);
      }
      if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
        localIntent.putExtra("cur_add_source", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
      }
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        localIntent.putExtra("key_nick_name", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      }
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText().toString();
        if (!TextUtils.isEmpty(paramView)) {
          localIntent.putExtra("title", paramView);
        }
      }
      if (bool3)
      {
        if (!FriendIntimateRelationshipHelper.a(this.mApp.getCurrentUin())) {
          break label1236;
        }
        bool1 = true;
        label1008:
        localIntent.putExtra("friend_intimate_open", bool1);
        localIntent.putExtra("friend_intimate_bind_url", FriendIntimateRelationshipHelper.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        localObject1 = MutualMarkDataCenter.a(this.mApp, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
        if (localObject1 == null) {
          break label1241;
        }
        paramView = IntimateUtil.a(this.mActivity, ((MutualMarkForDisplayInfo)localObject1).jdField_a_of_type_Long);
        i = ((MutualMarkForDisplayInfo)localObject1).c;
      }
    }
    for (boolean bool1 = ((MutualMarkForDisplayInfo)localObject1).b();; bool1 = bool2)
    {
      localIntent.putExtra("friend_intimate_bind_name", paramView);
      localIntent.putExtra("friend_intimate_isExtinguish", bool1);
      localIntent.putExtra("friend_intimate_bind_res_icon", i);
      localIntent.putExtra("isMsgShielded", isMsgShielded(this.mApp, (ProfileCardInfo)this.mData));
      localIntent.putExtra("isGather", isGatherFriend(this.mApp, (ProfileCardInfo)this.mData));
      paramView = TroopBaseProxyActivity.a(this.mActivity);
      TroopMemberCardProxyActivity.a(this.mApp, "troop_member_card_plugin.apk", HardCodeUtil.a(2131704913), TroopMemberCardProxyActivity.class, this.mActivity, localIntent, paramView, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.mApp.getCurrentAccountUin(), 8);
      return;
      label1221:
      localObject1 = ((Groups)localObject1).group_name;
      break;
      label1231:
      bool1 = false;
      break label761;
      label1236:
      bool1 = false;
      break label1008;
      label1241:
      paramView = "";
      i = 0;
    }
  }
  
  private void showContactActionSheet()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.mApp.getManager(QQManagerFactory.CONTACT_MANAGER);
    PhoneContact localPhoneContact = localPhoneContactManagerImp.c(FriendProfileCardActivity.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    if ((localPhoneContact != null) && (localPhoneContact.isHiden)) {}
    for (boolean bool = true;; bool = false)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mActivity, null);
      localActionSheet.addButton(2131693389);
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      ReportController.b(this.mApp, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ProfileTitleContainer.8(this, localPhoneContactManagerImp, bool, localActionSheet));
      try
      {
        if (!this.mActivity.isFinishing()) {
          localActionSheet.show();
        }
        return;
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("ProfileTitleContainer", 1, "", localException);
      }
    }
    if ((!TextUtils.isEmpty(getContactStrangerUin(this.mApp, (ProfileCardInfo)this.mData))) && (localPhoneContact != null)) {
      if (!localPhoneContact.isHiden) {
        break label240;
      }
    }
    label240:
    for (i = 2131693390;; i = 2131693388)
    {
      localActionSheet.addButton(i);
      ReportController.b(this.mApp, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
      break;
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
        this.mHideContactSettingDialog.c(2131695142);
        this.mHideContactSettingDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTitleContainer", 1, "showHideContactProgressDialog fail.", localException);
    }
  }
  
  private void showMoreActionSheet()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mActivity, null);
    localActionSheet.addButton(2131699062, 1);
    localActionSheet.addButton(2131699061, 1);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new ProfileTitleContainer.5(this, localActionSheet));
    localActionSheet.setOnBottomCancelListener(new ProfileTitleContainer.6(this, localActionSheet));
    localActionSheet.setOnPreShowListener(new ProfileTitleContainer.7(this, localActionSheet));
    try
    {
      if (!this.mActivity.isFinishing()) {
        localActionSheet.show();
      }
      return;
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
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bool = true;
      if (!bool) {
        break label67;
      }
      this.mCenterTextView.setText(2131693413);
    }
    for (;;)
    {
      updateTitleRight(bool);
      return;
      bool = false;
      break;
      label67:
      this.mCenterTextView.setText(2131693412);
    }
  }
  
  private void updateTitleMode()
  {
    boolean bool1;
    boolean bool3;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      bool1 = true;
      bool3 = isInNoCoverMode();
      if (this.mContentScrollOffset < this.mFadeInOutLine) {
        break label104;
      }
    }
    label104:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTitleContainer", 2, String.format("updateTitleMode contactStranger=%s isInNoCoverMode=%s titleHasFadeIn=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
      }
      if ((!bool1) && (!bool3) && (!bool2)) {
        break label109;
      }
      updateTitleMode(0);
      return;
      bool1 = false;
      break;
    }
    label109:
    updateTitleMode(1);
  }
  
  private void updateTitleMode(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTitleContainer", 2, String.format("updateTitleMode mode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.mActivity.getResources();
    if (paramInt == 1) {
      if (ProfileCardTemplate.a(((ProfileCardInfo)this.mData).jdField_a_of_type_Long))
      {
        int i = getDIYTemplateTitleBarColorResource();
        paramInt = ((Resources)localObject).getColor(i);
        this.mLeftTextView.setTextColor(((Resources)localObject).getColorStateList(i));
        this.mRightTextView.setTextColor(((Resources)localObject).getColorStateList(i));
        this.mCenterTextView.setVisibility(4);
        this.mImmersiveTitleBar.setVisibility(4);
        ImmersiveUtils.setStatusTextColor(false, this.mActivity.getWindow());
      }
    }
    for (;;)
    {
      localObject = getBackDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, paramInt));
        this.mLeftTextView.setBackgroundDrawable((Drawable)localObject);
      }
      this.mRightImageView.setColorFilter(paramInt);
      return;
      if (ThemeUtil.isInNightMode(this.mApp)) {}
      for (paramInt = 2131167027;; paramInt = 2131166726)
      {
        paramInt = ((Resources)localObject).getColor(paramInt);
        this.mLeftTextView.setTextColor(paramInt);
        this.mRightTextView.setTextColor(paramInt);
        break;
      }
      if (paramInt == 0)
      {
        paramInt = ((Resources)localObject).getColor(2131167027);
        this.mLeftTextView.setTextColor(((Resources)localObject).getColorStateList(2131167027));
        this.mRightTextView.setTextColor(((Resources)localObject).getColorStateList(2131167027));
        this.mCenterTextView.setVisibility(0);
        this.mImmersiveTitleBar.setVisibility(0);
        SimpleUIUtil.a(this.mImmersiveTitleBar, this.mActivity.getWindow());
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  private void updateTitleRedTouch()
  {
    if ((this.mRightTextView.getTag() instanceof DataTag))
    {
      Object localObject = (DataTag)this.mRightTextView.getTag();
      if ((((DataTag)localObject).jdField_a_of_type_Int == 98) || (((DataTag)localObject).jdField_a_of_type_Int == 99))
      {
        localObject = ProfileCardUtil.a();
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
    while (localTitleRightStatus.showImageView)
    {
      this.mRightImageView.setVisibility(0);
      this.mRightImageView.setTag(new DataTag(localTitleRightStatus.imageTagType, null));
      this.mRightImageView.setOnClickListener(this);
      if (paramBoolean)
      {
        this.mRightImageView.setImageResource(2130840486);
        this.mRightImageView.setContentDescription(HardCodeUtil.a(2131704916));
        return;
        this.mRightTextView.setVisibility(8);
      }
      else
      {
        this.mRightImageView.setBackgroundResource(2130840478);
        this.mRightImageView.setContentDescription(HardCodeUtil.a(2131704950));
        return;
      }
    }
    this.mRightImageView.setVisibility(8);
  }
  
  private ProfileTitleContainer.TitleRightStatus updateTitleRightStatus(boolean paramBoolean, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = true;
    ProfileTitleContainer.TitleRightStatus localTitleRightStatus = new ProfileTitleContainer.TitleRightStatus(null);
    localTitleRightStatus.showTextView = false;
    localTitleRightStatus.showImageView = false;
    localTitleRightStatus.textTagType = 16;
    localTitleRightStatus.textResId = 2131695138;
    localTitleRightStatus.imageTagType = 16;
    if (paramBoolean) {
      if (paramProfileCardInfo.b)
      {
        localTitleRightStatus.showTextView = true;
        localTitleRightStatus.showImageView = false;
        localTitleRightStatus.textTagType = 16;
      }
    }
    for (;;)
    {
      if ((paramProfileCardInfo.b) && (localTitleRightStatus.showTextView)) {
        localTitleRightStatus.showTextView = paramProfileCardInfo.c;
      }
      return localTitleRightStatus;
      localTitleRightStatus.showTextView = true;
      localTitleRightStatus.showImageView = true;
      localTitleRightStatus.textTagType = 98;
      localTitleRightStatus.textResId = 2131695165;
      localTitleRightStatus.imageTagType = 65;
      continue;
      if (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!this.mIsFromArkBabyQ) {
          localTitleRightStatus.showTextView = true;
        }
      }
      else if ((isPaTypeStrangerShowTitleRight(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localTitleRightStatus.showTextView = true;
      }
      else
      {
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 0) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            localTitleRightStatus.showTextView = paramBoolean;
            break;
          }
        }
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
        {
          localTitleRightStatus.showImageView = true;
          localTitleRightStatus.imageTagType = 44;
        }
        else if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.mApp.getCurrentAccountUin())))
        {
          localTitleRightStatus.showImageView = true;
          localTitleRightStatus.imageTagType = 44;
        }
      }
    }
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
    String str = null;
    Object localObject = null;
    boolean bool2 = false;
    switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject != null) && (((FriendsManager)localObject).b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        bool1 = ((FriendsManager)localObject).e(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      break;
    case 41: 
    case 42: 
    case 86: 
    case 1: 
      do
      {
        return bool1;
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramQQAppInterface == null) {}
        for (paramQQAppInterface = (QQAppInterface)localObject;; paramQQAppInterface = paramQQAppInterface.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (paramQQAppInterface == null) {
            break;
          }
          bool1 = bool2;
          if (paramQQAppInterface.groupid != -1002) {
            break;
          }
          return true;
        }
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool1 = bool2;
      } while (paramQQAppInterface == null);
      return paramQQAppInterface.e(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    localObject = (ShieldMsgManger)paramQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if (localObject != null) {
      if (ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(str)) {
          break label267;
        }
      }
    }
    label267:
    for (boolean bool1 = ((ShieldMsgManger)localObject).a(str);; bool1 = false)
    {
      return bool1;
      if (!ProfileActivity.AllInOne.i(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break;
      }
      str = getContactStrangerUin(paramQQAppInterface, paramProfileCardInfo);
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 8) {
      handleTroopMoreActivityResult(paramIntent);
    }
    while (paramInt1 != 21) {
      return;
    }
    handleRecommendContactActivityResult(paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag)) {
      switch (((DataTag)paramView.getTag()).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((ProfileCardInfo)this.mData).b)
      {
        openTroopMore(paramView);
      }
      else
      {
        openProfileMore();
        continue;
        if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          showMoreActionSheet();
          int j = 2;
          int i = j;
          if (this.mRightViewRedTouch != null)
          {
            i = j;
            if (this.mRightViewRedTouch.c()) {
              i = 1;
            }
          }
          ReportController.b(this.mApp, "dc00898", "", "", "0X800A97C", "0X800A97C", i, 0, "0", "0", "", "");
          continue;
          ProfileCardUtil.a(this.mActivity);
          continue;
          openQRCode();
          ReportController.b(this.mApp, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
          continue;
          showContactActionSheet();
        }
      }
    }
  }
  
  public void onCreate(@NotNull BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null)
    {
      this.mIsFromArkBabyQ = paramBaseActivity.getBooleanExtra("key_from_ark_babyq", false);
      this.mTroopFromFlag = paramBaseActivity.getIntExtra("fromFlag", -1);
      if (this.mTroopFromFlag == 8) {
        this.mCallback4TroopFee = paramBaseActivity.getStringExtra("callback");
      }
    }
    this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
    if (this.mProfileDelegate != null) {
      this.mProfileDelegate.addProfileScrollListener(this);
    }
    if (this.mApp != null) {
      this.mApp.registObserver(this.mContactObserver);
    }
    initViews();
    updateTitle();
    updateTitleMode();
    paramBaseActivity = HardCodeUtil.a(2131704942);
    AccessibilityUtil.a(this.mLeftTextView, paramBaseActivity);
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
    if (this.mProfileDelegate != null) {
      this.mProfileDelegate.removeProfileScrollListener(this);
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
  
  public void setProfileArgs(PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.mListView = paramPullToZoomHeaderListView;
  }
  
  public void setProfileDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    this.mProfileDelegate = paramIProfileActivityDelegate;
  }
  
  protected void setTroopOperationResult(int paramInt)
  {
    if ((this.mTroopFromFlag == 1) || (this.mTroopFromFlag == 7))
    {
      int i = this.mTroopOperationIntent.getIntExtra("memberOperationFlag", 0);
      this.mTroopOperationIntent.putExtra("memberOperationFlag", i | paramInt);
      this.mTroopOperationIntent.putExtra("memberOperateUin", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      this.mActivity.setResult(-1, this.mTroopOperationIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer
 * JD-Core Version:    0.7.0.1
 */