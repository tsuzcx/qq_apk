package com.tencent.mobileqq.qqexpand.profilecard;

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
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.container.IProfileBottomContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileExtendFriendComponent
  extends AbsQQProfileContentComponent
  implements View.OnClickListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PhotoWallObserver jdField_a_of_type_ComTencentMobileqqProfilecardBussinessPhotowallHandlerPhotoWallObserver = new ProfileExtendFriendComponent.1(this);
  private ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ProfileExtendFriendComponent.3(this);
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private final ExpandObserver jdField_b_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ProfileExtendFriendComponent.2(this);
  private final Runnable jdField_b_of_type_JavaLangRunnable = new ProfileExtendFriendComponent.4(this);
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public ProfileExtendFriendComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void a()
  {
    Object localObject;
    if (TextUtils.equals(((ProfileCardInfo)this.mData).card.uin, this.mApp.getCurrentAccountUin()))
    {
      if (a())
      {
        int i;
        if (this.jdField_b_of_type_Boolean) {
          i = 2;
        } else {
          i = 1;
        }
        ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
        return;
      }
      localObject = new ExtendFriendInfo(((ProfileCardInfo)this.mData).card);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
      ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(this.mActivity, localIntent, 4097);
      return;
    }
    boolean bool = ExpandChatUtil.a(this.mQQAppInterface);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleExtendFriendTitleClick showEntry = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ProfileExtendFriendComponent", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.c) && (bool))
    {
      ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.mActivity, this.mApp, 5);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("6");
    }
  }
  
  private void a(long paramLong)
  {
    if ((!this.jdField_a_of_type_Boolean) && ((!this.jdField_b_of_type_Boolean) || (this.d))) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      QLog.w("ProfileExtendFriendComponent", 1, "mHandler is null, can not scroll");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramLong);
    }
  }
  
  private void a(Card paramCard, ProfileContentTitleView paramProfileContentTitleView)
  {
    boolean bool2 = ThemeUtil.isInNightMode(this.mApp);
    int j;
    if (((ProfileCardInfo)this.mData).currentTemplate != null) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject = paramProfileContentTitleView.getContentView();
    if (localObject != null)
    {
      if (j != 0)
      {
        ProfileCardTemplate localProfileCardTemplate = (ProfileCardTemplate)((View)localObject).getTag(1912930347);
        if (localProfileCardTemplate != null) {
          if (localProfileCardTemplate.equals(((ProfileCardInfo)this.mData).currentTemplate)) {
            break label100;
          }
        }
      }
      else
      {
        if (((View)localObject).getTag(1912930347) == null) {
          break label100;
        }
      }
      i = 1;
      break label102;
    }
    label100:
    int i = 0;
    label102:
    if ((localObject != null) && (Boolean.FALSE.equals(((View)localObject).getTag(1912930348))) && (Boolean.valueOf(bool2).equals(((View)localObject).getTag(1912930349))) && (i == 0))
    {
      localObject = (ProfileCardExtendFriendView)localObject;
    }
    else
    {
      paramProfileContentTitleView.removeContentViews();
      paramProfileContentTitleView.setFocusable(false);
      paramProfileContentTitleView.setClickable(false);
      if (j != 0)
      {
        localObject = ((ProfileCardInfo)this.mData).currentTemplate.templateAttr.get("commonItemContentColor");
        if (localObject != null)
        {
          if ((localObject instanceof ColorStateList))
          {
            i = ((ColorStateList)localObject).getDefaultColor();
            break label262;
          }
          if ((localObject instanceof String))
          {
            localObject = (String)localObject;
            if (((String)localObject).startsWith("#"))
            {
              i = Color.parseColor((String)localObject);
              break label262;
            }
          }
        }
        i = 0;
        localObject = new float[3];
        Color.colorToHSV(i, (float[])localObject);
        if (localObject[2] > 0.5F)
        {
          bool1 = true;
          break label293;
        }
      }
      boolean bool1 = false;
      if (bool2) {
        localObject = new ProfileCardExtendFriendView(this.mActivity, ((ProfileCardInfo)this.mData).currentTemplate, true);
      }
      for (;;)
      {
        break;
        if (j != 0) {
          localObject = new ProfileCardExtendFriendView(this.mActivity, ((ProfileCardInfo)this.mData).currentTemplate, bool1);
        } else {
          localObject = new ProfileCardExtendFriendView(this.mActivity);
        }
      }
      ((ProfileCardExtendFriendView)localObject).a(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      ((ProfileCardExtendFriendView)localObject).setFromExtendFriend(this.jdField_b_of_type_Boolean);
      if ((((ProfileCardInfo)this.mData).allInOne.pa == 96) || (this.jdField_b_of_type_Boolean)) {
        ((ProfileCardExtendFriendView)localObject).setFold(false);
      }
      ((ProfileCardExtendFriendView)localObject).setClickable(true);
      ((ProfileCardExtendFriendView)localObject).setTag(1912930348, Boolean.valueOf(false));
      ((ProfileCardExtendFriendView)localObject).setTag(1912930349, Boolean.valueOf(bool2));
      ((ProfileCardExtendFriendView)localObject).setTag(1912930347, ((ProfileCardInfo)this.mData).currentTemplate);
      paramProfileContentTitleView.addContentView((View)localObject);
    }
    label262:
    label293:
    if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy())
    {
      ((ProfileCardExtendFriendView)localObject).setDiyCard(true);
      ((ProfileCardExtendFriendView)localObject).setProfileCardFavorShowView(paramProfileContentTitleView);
    }
    else
    {
      ((ProfileCardExtendFriendView)localObject).setDiyCard(false);
    }
    ((ProfileCardExtendFriendView)localObject).setIsFromLimitChat(this.c);
    ((ProfileCardExtendFriendView)localObject).a(paramCard, this.mQQAppInterface);
  }
  
  private void a(ProfileContentTitleView paramProfileContentTitleView, Card paramCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramProfileContentTitleView.getChildAt(0);
    if ((localObject1 == null) || (!Boolean.TRUE.equals(((View)localObject1).getTag(0))) || (!Boolean.valueOf(paramBoolean1).equals(((View)localObject1).getTag(1))) || (!((ProfileCardInfo)this.mData).currentTemplate.equals(((View)localObject1).getTag(2))))
    {
      paramProfileContentTitleView.removeContentViews();
      Object localObject3;
      Object localObject4;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        localObject2 = LayoutInflater.from(this.mActivity).inflate(1912995849, null);
        localObject3 = ((View)localObject2).findViewById(1912930354);
        localObject4 = ExpandResourceUtil.a("expand_summary_default_bg.png");
        localObject1 = localObject2;
        if (FileUtil.b((String)localObject4))
        {
          localObject1 = ExpandResourceUtil.a((String)localObject4, null);
          localObject4 = new BitmapDrawable((Bitmap)localObject1);
          float f = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
          ((View)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.mActivity.getResources().getDisplayMetrics().widthPixels / f)));
          ((View)localObject3).setBackgroundDrawable((Drawable)localObject4);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = LayoutInflater.from(this.mActivity).inflate(1912995850, null);
        ((View)localObject1).setTag(1912930348, Boolean.valueOf(true));
        ((View)localObject1).setTag(1912930349, Boolean.valueOf(paramBoolean1));
        ((View)localObject1).setTag(1912930347, ((ProfileCardInfo)this.mData).currentTemplate);
        localObject2 = (TextView)((View)localObject1).findViewById(1912930371);
        localObject3 = (TextView)((View)localObject1).findViewById(1912930372);
        if (paramBoolean2)
        {
          localObject4 = ((ProfileCardInfo)this.mData).currentTemplate.templateAttr.get("commonItemContentColor");
          if (localObject4 != null) {
            if ((localObject4 instanceof ColorStateList))
            {
              localObject4 = (ColorStateList)localObject4;
              ((TextView)localObject2).setTextColor((ColorStateList)localObject4);
              ((TextView)localObject3).setTextColor((ColorStateList)localObject4);
            }
            else if ((localObject4 instanceof String))
            {
              localObject4 = (String)localObject4;
              if (((String)localObject4).startsWith("#"))
              {
                ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject4));
                ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject4));
              }
            }
          }
        }
      }
      ((View)localObject1).setClickable(true);
      Object localObject2 = ((View)localObject1).findViewById(1912930370);
      ((View)localObject2).setOnClickListener(new ProfileExtendFriendComponent.5(this, paramCard));
      paramProfileContentTitleView.addContentView((View)localObject1);
      if (paramBoolean1) {
        updateItemTheme(null, (View)localObject2, null);
      }
    }
  }
  
  private boolean a()
  {
    if (((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(this.mApp.getCurrentAccountUin()))
    {
      if (this.jdField_b_of_type_AndroidAppDialog == null) {
        this.jdField_b_of_type_AndroidAppDialog = ProfileGuideDialogUtils.a(this.mActivity);
      }
      if ((!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.mActivity.isFinishing())) {
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      ReportController.b(this.mApp, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramCard == null) {
      return false;
    }
    if (paramCard.isShowCard)
    {
      if (paramCard.extendFriendFlag != 1) {
        return false;
      }
      if (TextUtils.equals(paramCard.uin, this.mApp.getCurrentAccountUin()))
      {
        if (paramCard.extendFriendEntryAddFriend == 0)
        {
          bool1 = bool2;
          break label146;
        }
      }
      else
      {
        SharedPreferences localSharedPreferences = SharedPreUtils.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785");
        int i;
        if (localSharedPreferences.contains("sp_extend_friend_entry_add_friend")) {
          i = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);
        } else {
          i = 1;
        }
        bool1 = bool2;
        if (localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0) == 0) {
          break label146;
        }
        bool1 = bool2;
        if (i != 1) {
          break label146;
        }
        if (TextUtils.isEmpty(paramCard.declaration))
        {
          bool1 = bool2;
          break label146;
        }
      }
      bool1 = true;
      label146:
      paramCard = (IExpandManager)this.mApp.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    }
    return bool1;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = a(paramCard);
    boolean bool1 = false;
    if (!paramBoolean)
    {
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return true;
      }
      return false;
    }
    if (this.mViewContainer == null)
    {
      localProfileContentTitleView = new ProfileContentTitleView(this.mActivity);
      localProfileContentTitleView.setTitle(this.mActivity.getString(1913061377));
      if (this.c) {
        localProfileContentTitleView.setArrowEnable(false);
      }
      this.mViewContainer = localProfileContentTitleView;
      paramBoolean = true;
    }
    else
    {
      paramBoolean = false;
    }
    ProfileContentTitleView localProfileContentTitleView = (ProfileContentTitleView)this.mViewContainer;
    boolean bool2 = ThemeUtil.isInNightMode(this.mApp);
    if (((ProfileCardInfo)this.mData).currentTemplate != null) {
      bool1 = true;
    }
    if (TextUtils.equals(paramCard.uin, this.mApp.getCurrentAccountUin()))
    {
      if (TextUtils.isEmpty(paramCard.declaration)) {
        a(localProfileContentTitleView, paramCard, bool2, bool1);
      } else {
        a(paramCard, localProfileContentTitleView);
      }
    }
    else {
      a(paramCard, localProfileContentTitleView);
    }
    paramCard = new DataTag(87, null);
    localProfileContentTitleView.mTitleContainer.setTag(paramCard);
    localProfileContentTitleView.mTitleContainer.setOnClickListener(this);
    updateItemTheme(localProfileContentTitleView, true);
    a(5000L);
    return paramBoolean;
  }
  
  private void b()
  {
    IComponent localIComponent = getComponentCenter().getComponent(107);
    if ((localIComponent instanceof IProfileBottomContainer)) {
      ((IProfileBottomContainer)localIComponent).addFriend();
    }
  }
  
  private boolean b()
  {
    boolean bool3 = this.c;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3) {
      return false;
    }
    Card localCard = ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.mApp.getCurrentUin());
    if (localCard == null) {
      return false;
    }
    bool3 = QLog.isColorLevel();
    int i = 2;
    if (bool3) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("showExtendFriendProfileGuide declaration=%s isShowCard=%s", new Object[] { localCard.declaration, Boolean.valueOf(localCard.isShowCard) }));
    }
    if ((TextUtils.isEmpty(localCard.declaration)) && (c())) {
      return true;
    }
    if ((TextUtils.isEmpty(localCard.declaration)) || (!localCard.isShowCard))
    {
      if (TextUtils.isEmpty(localCard.declaration)) {
        i = 1;
      }
      this.jdField_a_of_type_AndroidAppDialog = ProfileGuideDialogUtils.a(this.mActivity, i, new ProfileExtendFriendComponent.6(this, localCard));
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        bool1 = true;
      }
      catch (Exception localException)
      {
        QLog.e("ProfileExtendFriendComponent", 1, "showExtendFriendProfileGuide fail.", localException);
        bool1 = bool2;
      }
      if (TextUtils.isEmpty(localCard.declaration))
      {
        ReportController.b(this.mApp, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
        return bool1;
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
    }
    return bool1;
  }
  
  private boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("checkUpdateExtendInfo mExtendRequested=%s", new Object[] { Boolean.valueOf(this.e) }));
    }
    if (!this.e)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver != null) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ProfileExtendFriendComponent.7(this);
      this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.mActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      ((IExpandHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.mApp.getCurrentAccountUin(), false);
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | a(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
  }
  
  public boolean b(ProfileCardInfo paramProfileCardInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(paramProfileCardInfo.allInOne.subSourceId));
    localHashMap.put("to_uid", paramProfileCardInfo.allInOne.uin);
    localHashMap.put("session_id", LimitChatUtil.a(this.mApp.getCurrentAccountUin(), paramProfileCardInfo.allInOne.uin));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#add_friends_all", true, -1L, -1L, localHashMap, true, true);
    if (a())
    {
      ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DA", 2, 0, "", "", "", "");
      return true;
    }
    return b();
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.jdField_b_of_type_Boolean = true;
      this.mActivity.setResult(8193);
      if (this.mDelegate != null) {
        this.mDelegate.requestUpdateCard();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof DataTag)) && (((DataTag)paramView.getTag()).a == 87)) {
      a();
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null)
    {
      this.jdField_b_of_type_Boolean = paramQBaseActivity.getBooleanExtra("key_from_extends_friend", false);
      this.c = paramQBaseActivity.getBooleanExtra("key_from_extends_friend_limit_chat", false);
      this.d = paramQBaseActivity.getBooleanExtra("key_from_limit_chat_plus", false);
      this.jdField_a_of_type_Boolean = paramQBaseActivity.getBooleanExtra("profile_scroll_to_extend_friend", false);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessPhotowallHandlerPhotoWallObserver);
    this.mApp.addObserver(this.jdField_b_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessPhotowallHandlerPhotoWallObserver);
    this.mApp.removeObserver(this.jdField_b_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.mViewContainer != null) && ((this.mViewContainer instanceof ProfileContentTitleView)))
    {
      View localView = ((ProfileContentTitleView)this.mViewContainer).getContentView();
      if ((localView instanceof ProfileCardExtendFriendView)) {
        ((ProfileCardExtendFriendView)localView).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent
 * JD-Core Version:    0.7.0.1
 */