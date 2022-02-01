package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileExtendFriendComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfileExtendFriendComponent";
  private CardObserver mCardObserver = new ProfileExtendFriendComponent.1(this);
  private Dialog mExtendFriendGuideDialog;
  private ExtendFriendObserver mExtendFriendObserver;
  private Dialog mExtendFriendQuestionDialog;
  private boolean mExtendRequested;
  private boolean mFromExtendFriend;
  private boolean mFromLimitChat;
  private boolean mFromLimitChatPlus;
  private Runnable mGetInfoTimeoutRunnable = new ProfileExtendFriendComponent.3(this);
  private Handler mHandler;
  private AtomicBoolean mHasScrollToExtendFriend = new AtomicBoolean(false);
  private ExtendFriendObserver mJSApiExtendFriendObserver = new ProfileExtendFriendComponent.2(this);
  private QQProgressDialog mProgressView;
  private boolean mScrollToExtendFriend;
  private Runnable mScrollToExtendFriendRunnable = new ProfileExtendFriendComponent.7(this);
  
  public ProfileExtendFriendComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void addFriend()
  {
    if (this.mDelegate != null) {
      this.mDelegate.addFriend();
    }
  }
  
  private boolean checkShowExtendFriend(Card paramCard)
  {
    boolean bool = true;
    if (paramCard == null) {}
    while ((!paramCard.isShowCard) || (paramCard.extendFriendFlag != 1)) {
      return false;
    }
    if (TextUtils.equals(paramCard.uin, this.mApp.getCurrentAccountUin())) {
      if (paramCard.extendFriendEntryAddFriend == 0) {
        bool = false;
      }
    }
    label138:
    for (;;)
    {
      paramCard = (ExtendFriendManager)this.mApp.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      return bool;
      SharedPreferences localSharedPreferences = SharedPreUtils.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785");
      if (localSharedPreferences.contains("sp_extend_friend_entry_add_friend")) {}
      for (int i = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);; i = 1)
      {
        if ((localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0) != 0) && (i == 1) && (!TextUtils.isEmpty(paramCard.declaration))) {
          break label138;
        }
        bool = false;
        break;
      }
    }
  }
  
  private boolean checkUpdateExtendInfo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("checkUpdateExtendInfo mExtendRequested=%s", new Object[] { Boolean.valueOf(this.mExtendRequested) }));
    }
    if ((this.mExtendRequested) || (this.mExtendFriendObserver != null)) {
      return false;
    }
    this.mExtendFriendObserver = new ProfileExtendFriendComponent.6(this);
    this.mApp.addObserver(this.mExtendFriendObserver);
    this.mProgressView = new QQProgressDialog(this.mActivity);
    this.mProgressView.c(true);
    this.mProgressView.show();
    ((ExtendFriendHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.mApp.getCurrentAccountUin(), false);
    if (this.mHandler != null) {
      this.mHandler.postDelayed(this.mGetInfoTimeoutRunnable, 10000L);
    }
    return true;
  }
  
  private void fillExtendFriendBeginnerGuide(ViewGroup paramViewGroup, Card paramCard)
  {
    if (paramViewGroup != null)
    {
      if ((paramCard != null) && (!TextUtils.isEmpty(paramCard.schoolName)))
      {
        paramViewGroup.setVisibility(8);
        CampusHelper.b(this.mApp, false);
      }
    }
    else {
      return;
    }
    if (CampusHelper.c(this.mApp))
    {
      paramViewGroup.setVisibility(0);
      paramCard = LayoutInflater.from(this.mActivity).inflate(2131561197, null);
      TextView localTextView = (TextView)paramCard.findViewById(2131380229);
      paramViewGroup.addView(paramCard);
      updateItemTheme(null, localTextView, null);
      return;
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void fillExtendFriendEmptyView(ProfileCardFavorShowView paramProfileCardFavorShowView, Card paramCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramProfileCardFavorShowView.getChildAt(0);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((localObject1 == null) || (!Boolean.TRUE.equals(((View)localObject1).getTag(0))) || (!Boolean.valueOf(paramBoolean1).equals(((View)localObject1).getTag(1))) || (!((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.equals(((View)localObject1).getTag(2))))
    {
      paramProfileCardFavorShowView.removeAllViews();
      if ((!paramBoolean1) && (!paramBoolean2)) {
        break label319;
      }
      localObject1 = LayoutInflater.from(this.mActivity).inflate(2131561505, null);
      ((View)localObject1).setTag(2131373519, Boolean.valueOf(true));
      ((View)localObject1).setTag(2131373520, Boolean.valueOf(paramBoolean1));
      ((View)localObject1).setTag(2131373518, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
      localObject2 = (TextView)((View)localObject1).findViewById(2131380151);
      localObject3 = (TextView)((View)localObject1).findViewById(2131380152);
      if (paramBoolean2)
      {
        localObject4 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a.get("commonItemContentColor");
        if (localObject4 != null)
        {
          if (!(localObject4 instanceof ColorStateList)) {
            break label270;
          }
          ((TextView)localObject2).setTextColor((ColorStateList)localObject4);
          ((TextView)localObject3).setTextColor((ColorStateList)localObject4);
        }
      }
    }
    for (;;)
    {
      ((View)localObject1).setClickable(true);
      localObject2 = ((View)localObject1).findViewById(2131380150);
      ((View)localObject2).setOnClickListener(new ProfileExtendFriendComponent.4(this, paramCard));
      paramProfileCardFavorShowView.addView((View)localObject1);
      if (paramBoolean1) {
        updateItemTheme(null, (View)localObject2, null);
      }
      return;
      label270:
      if ((localObject4 instanceof String))
      {
        localObject4 = (String)localObject4;
        if (((String)localObject4).startsWith("#"))
        {
          ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject4));
          ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject4));
          continue;
          label319:
          localObject2 = LayoutInflater.from(this.mActivity).inflate(2131561504, null);
          localObject3 = ((View)localObject2).findViewById(2131377256);
          localObject4 = ExtendFriendResourceUtil.a("expand_summary_default_bg.png");
          localObject1 = localObject2;
          if (FileUtil.a((String)localObject4))
          {
            localObject1 = ExtendFriendResourceUtil.a((String)localObject4, null);
            localObject4 = new BitmapDrawable((Bitmap)localObject1);
            float f = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
            ((View)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.mActivity.getResources().getDisplayMetrics().widthPixels / f)));
            ((View)localObject3).setBackgroundDrawable((Drawable)localObject4);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  private void fillExtendFriendInfoView(Card paramCard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    boolean bool2 = ThemeUtil.isInNightMode(this.mApp);
    int j;
    Object localObject;
    int i;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null)
    {
      j = 1;
      localObject = paramProfileCardFavorShowView.a(0);
      if (localObject == null) {
        break label517;
      }
      if (j == 0) {
        break label381;
      }
      ProfileCardTemplate localProfileCardTemplate = (ProfileCardTemplate)((View)localObject).getTag(2131373518);
      if ((localProfileCardTemplate != null) && (localProfileCardTemplate.equals(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate))) {
        break label517;
      }
      i = 1;
    }
    for (;;)
    {
      label80:
      boolean bool1;
      if ((localObject == null) || (!Boolean.FALSE.equals(((View)localObject).getTag(2131373519))) || (!Boolean.valueOf(bool2).equals(((View)localObject).getTag(2131373520))) || (i != 0))
      {
        paramProfileCardFavorShowView.removeAllViews();
        paramProfileCardFavorShowView.setFocusable(false);
        paramProfileCardFavorShowView.setClickable(false);
        if (j == 0) {
          break label511;
        }
        localObject = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a.get("commonItemContentColor");
        if (localObject == null) {
          break label506;
        }
        if ((localObject instanceof ColorStateList))
        {
          i = ((ColorStateList)localObject).getDefaultColor();
          label187:
          localObject = new float[3];
          Color.colorToHSV(i, (float[])localObject);
          if (localObject[2] <= 0.5F) {
            break label432;
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        label212:
        if (bool2)
        {
          localObject = new ProfileCardExtendFriendView(this.mActivity, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, true);
          label241:
          if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96) || (this.mFromExtendFriend)) {
            ((ProfileCardExtendFriendView)localObject).setFold(false);
          }
          ((ProfileCardExtendFriendView)localObject).setClickable(true);
          ((ProfileCardExtendFriendView)localObject).setTag(2131373519, Boolean.valueOf(false));
          ((ProfileCardExtendFriendView)localObject).setTag(2131373520, Boolean.valueOf(bool2));
          ((ProfileCardExtendFriendView)localObject).setTag(2131373518, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
          paramProfileCardFavorShowView.addView((View)localObject);
          if (!ProfileCardTemplate.a(((ProfileCardInfo)this.mData).jdField_a_of_type_Long)) {
            break label497;
          }
          ((ProfileCardExtendFriendView)localObject).setDiyCard(true);
          ((ProfileCardExtendFriendView)localObject).setProfileCardFavorShowView(paramProfileCardFavorShowView);
        }
        for (;;)
        {
          label327:
          ((ProfileCardExtendFriendView)localObject).setIsFromLimitChat(this.mFromLimitChat);
          ((ProfileCardExtendFriendView)localObject).a(paramCard, this.mApp);
          return;
          j = 0;
          break;
          label381:
          if (((View)localObject).getTag(2131373518) == null) {
            break label517;
          }
          i = 1;
          break label80;
          if (!(localObject instanceof String)) {
            break label506;
          }
          localObject = (String)localObject;
          if (!((String)localObject).startsWith("#")) {
            break label506;
          }
          i = Color.parseColor((String)localObject);
          break label187;
          label432:
          bool1 = false;
          break label212;
          if (j != 0)
          {
            localObject = new ProfileCardExtendFriendView(this.mActivity, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, bool1);
            break label241;
          }
          localObject = new ProfileCardExtendFriendView(this.mActivity);
          break label241;
          localObject = (ProfileCardExtendFriendView)localObject;
          break label327;
          label497:
          ((ProfileCardExtendFriendView)localObject).setDiyCard(false);
        }
        label506:
        i = 0;
        break label187;
        label511:
        bool1 = false;
      }
      label517:
      i = 0;
    }
  }
  
  private void handleExtendFriendTitleClick()
  {
    int i = 2;
    if (TextUtils.equals(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.uin, this.mApp.getCurrentAccountUin())) {
      if (showExtendFriendQuestionDialog()) {
        if (this.mFromExtendFriend) {
          ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
        }
      }
    }
    boolean bool;
    do
    {
      return;
      i = 1;
      break;
      ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_extend_friend_info", localExtendFriendInfo);
      PublicFragmentActivity.a(this.mActivity, localIntent, ExtendFriendEditFragment.class, 4097);
      return;
      bool = ExpandFriendChatUtil.a(this.mApp);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileExtendFriendComponent", 2, "handleExtendFriendTitleClick showEntry = " + bool);
      }
    } while ((this.mFromLimitChat) || (!bool));
    ExtendFriendLabelUtils.a(this.mActivity, this.mApp, 5);
    ExpandReportUtils.b("6");
  }
  
  private boolean makeOrRefreshExtendFriend(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (!checkShowExtendFriend(paramCard))
    {
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return true;
      }
    }
    else
    {
      ProfileCardFavorShowView localProfileCardFavorShowView1;
      if (this.mViewContainer == null)
      {
        ProfileCardFavorShowView localProfileCardFavorShowView2 = (ProfileCardFavorShowView)this.mDiyHelper.getDiyView(getProfileContentKey());
        localProfileCardFavorShowView1 = localProfileCardFavorShowView2;
        if (localProfileCardFavorShowView2 == null)
        {
          localProfileCardFavorShowView2 = new ProfileCardFavorShowView(this.mActivity);
          localProfileCardFavorShowView2.setTitle(this.mActivity.getString(2131691241));
          localProfileCardFavorShowView1 = localProfileCardFavorShowView2;
          if (this.mFromLimitChat)
          {
            localProfileCardFavorShowView2.setShowArrow(false);
            localProfileCardFavorShowView1 = localProfileCardFavorShowView2;
          }
        }
        this.mViewContainer = localProfileCardFavorShowView1;
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localProfileCardFavorShowView1 = (ProfileCardFavorShowView)this.mViewContainer;
        boolean bool2 = ThemeUtil.isInNightMode(this.mApp);
        if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null)
        {
          if (!TextUtils.equals(paramCard.uin, this.mApp.getCurrentAccountUin())) {
            break label249;
          }
          if (!TextUtils.isEmpty(paramCard.declaration)) {
            break label239;
          }
          fillExtendFriendEmptyView(localProfileCardFavorShowView1, paramCard, bool2, bool1);
        }
        for (;;)
        {
          paramCard = new DataTag(87, null);
          localProfileCardFavorShowView1.b.setTag(paramCard);
          localProfileCardFavorShowView1.b.setOnClickListener(this);
          updateItemTheme(localProfileCardFavorShowView1.jdField_a_of_type_AndroidWidgetTextView, null, localProfileCardFavorShowView1.jdField_a_of_type_AndroidWidgetImageView);
          scrollCardIfNeed(5000L);
          return paramBoolean;
          bool1 = false;
          break;
          label239:
          fillExtendFriendInfoView(paramCard, localProfileCardFavorShowView1);
          continue;
          label249:
          fillExtendFriendInfoView(paramCard, localProfileCardFavorShowView1);
        }
      }
    }
    return false;
  }
  
  private void scrollCardIfNeed(long paramLong)
  {
    if ((!this.mScrollToExtendFriend) && ((!this.mFromExtendFriend) || (this.mFromLimitChatPlus))) {}
    do
    {
      return;
      if (this.mHandler == null)
      {
        QLog.w("ProfileExtendFriendComponent", 1, "mHandler is null, can not scroll");
        return;
      }
    } while (!this.mHasScrollToExtendFriend.compareAndSet(false, true));
    this.mHandler.postDelayed(this.mScrollToExtendFriendRunnable, paramLong);
  }
  
  private boolean showExtendFriendProfileGuide()
  {
    if (this.mFromLimitChat) {}
    Card localCard;
    do
    {
      return false;
      localCard = ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.mApp.getCurrentUin());
    } while (localCard == null);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("showExtendFriendProfileGuide declaration=%s isShowCard=%s", new Object[] { localCard.declaration, Boolean.valueOf(localCard.isShowCard) }));
    }
    if ((TextUtils.isEmpty(localCard.declaration)) && (checkUpdateExtendInfo())) {
      return true;
    }
    int i;
    boolean bool;
    if ((TextUtils.isEmpty(localCard.declaration)) || (!localCard.isShowCard))
    {
      if (TextUtils.isEmpty(localCard.declaration))
      {
        i = 1;
        this.mExtendFriendGuideDialog = ProfileGuideDialogUtils.a(this.mActivity, i, new ProfileExtendFriendComponent.5(this, localCard));
      }
      try
      {
        this.mExtendFriendGuideDialog.show();
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ProfileExtendFriendComponent", 1, "showExtendFriendProfileGuide fail.", localException);
          bool = false;
          continue;
          ReportController.b(this.mApp, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
        }
      }
      if (TextUtils.isEmpty(localCard.declaration)) {
        ReportController.b(this.mApp, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return bool;
      i = 2;
      break;
      bool = false;
    }
  }
  
  private boolean showExtendFriendQuestionDialog()
  {
    boolean bool = false;
    if (ExtendFriendManager.a(this.mApp.getCurrentAccountUin()))
    {
      if (this.mExtendFriendQuestionDialog == null) {
        this.mExtendFriendQuestionDialog = ProfileGuideDialogUtils.a(this.mActivity);
      }
      if ((!this.mExtendFriendQuestionDialog.isShowing()) && (!this.mActivity.isFinishing())) {
        this.mExtendFriendQuestionDialog.show();
      }
      ReportController.b(this.mApp, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
      bool = true;
    }
    return bool;
  }
  
  public String getComponentName()
  {
    return "ProfileExtendFriendComponent";
  }
  
  public int getComponentType()
  {
    return 1008;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_extend_friend";
  }
  
  public boolean interceptAddFriend(ProfileCardInfo paramProfileCardInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.l));
    localHashMap.put("to_uid", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    ExpandReportUtils.a("click#data_page#add_friends_all", true, -1L, -1L, localHashMap, true, true);
    if (showExtendFriendQuestionDialog()) {
      ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DA", 2, 0, "", "", "", "");
    }
    while (showExtendFriendProfileGuide()) {
      return true;
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.mFromExtendFriend = true;
      this.mActivity.setResult(8193);
      if (this.mDelegate != null) {
        this.mDelegate.requestUpdateCard();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof DataTag)) && (((DataTag)paramView.getTag()).jdField_a_of_type_Int == 87)) {
      handleExtendFriendTitleClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null)
    {
      this.mFromExtendFriend = paramBaseActivity.getBooleanExtra("key_from_extends_friend", false);
      this.mFromLimitChat = paramBaseActivity.getBooleanExtra("key_from_extends_friend_limit_chat", false);
      this.mFromLimitChatPlus = paramBaseActivity.getBooleanExtra("key_from_limit_chat_plus", false);
      this.mScrollToExtendFriend = paramBaseActivity.getBooleanExtra("profile_scroll_to_extend_friend", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mApp.addObserver(this.mCardObserver);
    this.mApp.addObserver(this.mJSApiExtendFriendObserver);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshExtendFriend(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    this.mApp.removeObserver(this.mCardObserver);
    this.mApp.removeObserver(this.mJSApiExtendFriendObserver);
    if (this.mExtendFriendObserver != null)
    {
      this.mApp.removeObserver(this.mExtendFriendObserver);
      this.mExtendFriendObserver = null;
    }
    if (this.mProgressView != null)
    {
      this.mProgressView.dismiss();
      this.mProgressView = null;
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.mViewContainer != null) && ((this.mViewContainer instanceof ProfileCardFavorShowView)))
    {
      View localView = ((ProfileCardFavorShowView)this.mViewContainer).a(0);
      if ((localView instanceof ProfileCardExtendFriendView)) {
        ((ProfileCardExtendFriendView)localView).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent
 * JD-Core Version:    0.7.0.1
 */