package com.tencent.mobileqq.profilesetting;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper.ProfilePhotoCallback;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.IntimateInfoFragment;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.specialcare.SpecialCareUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.profile.ProfileCardShareHelper;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.relationx.friendclue.FriendClueConfigHelper;
import com.tencent.mobileqq.relationx.friendclue.FriendClueReporter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, FriendProfilePhotoHelper.ProfilePhotoCallback
{
  int jdField_a_of_type_Int = 0;
  Intent jdField_a_of_type_AndroidContentIntent;
  Bundle jdField_a_of_type_AndroidOsBundle;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public FriendProfilePhotoHelper a;
  ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ProfileCardMoreActivity.9(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ProfileCardMoreActivity.7(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ProfileCardMoreActivity.5(this);
  ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new ProfileCardMoreActivity.6(this);
  BusinessCardManager jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new ProfileCardMoreActivity.8(this);
  BusinessCard jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new ProfileCardMoreActivity.11(this);
  private ProfileCardShareHelper jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper;
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new ProfileCardMoreActivity.10(this);
  FriendClueConfigHelper jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader = null;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ProfileCardMoreActivity.15(this);
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ProfileActivity.AllInOne b;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  String jdField_c_of_type_JavaLangString;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  String jdField_d_of_type_JavaLangString;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_e_of_type_JavaLangString;
  FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_f_of_type_JavaLangString = "";
  FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_g_of_type_JavaLangString = "";
  FormSimpleItem h;
  FormSimpleItem i;
  FormSimpleItem j;
  FormSimpleItem k;
  
  private static AbsStructMsgItem a(String paramString)
  {
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
    localStructMsgItemLayoutDefault.b(1);
    localStructMsgItemLayoutDefault.a(paramString);
    return localStructMsgItemLayoutDefault;
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(paramIntent.getBooleanExtra("param_switches_changed", false));
      boolean bool1 = paramIntent.getBooleanExtra("key_weishi_switch", false);
      boolean bool2 = paramIntent.hasExtra("key_personality_label_switch");
      if ((this.jdField_a_of_type_AndroidOsBundle == null) && ((bool1) || (bool2))) {
        this.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (bool1)) {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("key_weishi_switch", true);
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (bool2)) {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("key_personality_label_switch", paramIntent.getBooleanExtra("key_personality_label_switch", false));
      }
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "handleActivityResultForInterestSwitch mHasInterestStateChanged:" + this.jdField_b_of_type_JavaLangBoolean + " isWeiShiChangeToOpen:" + bool1 + " isPersonalityLabelChanged:" + bool2);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      notifyUser(2131692257, 1);
      d();
      return;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (l > 0L) {
        if (!paramBoolean)
        {
          bool1 = true;
          localFriendListHandler.changeFriendShieldFlag(l, bool1);
          m = 1;
          if (m == 0) {
            break label128;
          }
          if (paramBoolean) {
            break label123;
          }
          paramBoolean = bool2;
          this.jdField_a_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_Int |= 0x2;
          e();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
        continue;
        boolean bool1 = false;
        continue;
        label123:
        paramBoolean = false;
        continue;
        label128:
        if (paramBoolean) {
          notifyUser(2131719328, 1);
        }
        for (;;)
        {
          d();
          return;
          notifyUser(2131719330, 1);
        }
        int m = 0;
      }
    }
  }
  
  private void j()
  {
    boolean bool = false;
    Object localObject;
    int m;
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      localObject = "";
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = MutualMarkDataCenter.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
      if (localMutualMarkForDisplayInfo == null) {
        break label141;
      }
      localObject = IntimateUtil.a(this, localMutualMarkForDisplayInfo.a);
      m = localMutualMarkForDisplayInfo.c;
      bool = localMutualMarkForDisplayInfo.b();
    }
    for (;;)
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      if (m != 0)
      {
        localObject = getResources().getDrawable(m);
        if ((localObject instanceof SkinnableBitmapDrawable))
        {
          localObject = ((SkinnableBitmapDrawable)localObject).mutate2();
          if (!bool) {
            break label122;
          }
          ((Drawable)localObject).setAlpha(102);
        }
        for (;;)
        {
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
          return;
          localObject = ((Drawable)localObject).mutate();
          break;
          label122:
          ((Drawable)localObject).setAlpha(255);
        }
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      return;
      label141:
      m = 0;
    }
  }
  
  private void k()
  {
    startActivityForResult(new Intent(this, InterestSwitchEditActivity.class), 1008);
  }
  
  private void l()
  {
    boolean bool = FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690783));
      }
    }
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 355	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 358	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 214	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 362	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   23: invokevirtual 368	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3441 -> 3471
    //   33: aload 11
    //   35: ldc_w 370
    //   38: aload_1
    //   39: invokevirtual 376	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   42: checkcast 370	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   45: astore 15
    //   47: aload 11
    //   49: ifnull +8 -> 57
    //   52: aload 11
    //   54: invokevirtual 379	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   57: aload 15
    //   59: ifnonnull +5 -> 64
    //   62: iconst_m1
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 381	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   68: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +879 -> 950
    //   74: aload_0
    //   75: getfield 381	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: astore 12
    //   80: iconst_0
    //   81: istore_2
    //   82: iconst_0
    //   83: istore_3
    //   84: aconst_null
    //   85: astore 13
    //   87: aload_0
    //   88: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   91: astore 11
    //   93: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   96: astore 14
    //   98: new 163	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 399
    //   108: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 12
    //   113: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 401
    //   119: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 16
    //   127: aload 11
    //   129: aload 14
    //   131: iconst_4
    //   132: anewarray 352	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: ldc_w 403
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: ldc_w 405
    //   146: aastore
    //   147: dup
    //   148: iconst_2
    //   149: ldc_w 407
    //   152: aastore
    //   153: dup
    //   154: iconst_3
    //   155: ldc_w 409
    //   158: aastore
    //   159: aload 16
    //   161: aconst_null
    //   162: aconst_null
    //   163: invokevirtual 415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   166: astore 11
    //   168: iconst_0
    //   169: istore 4
    //   171: lconst_0
    //   172: lstore 8
    //   174: iload_3
    //   175: istore_2
    //   176: iload 4
    //   178: istore_3
    //   179: aload 11
    //   181: ifnull +3277 -> 3458
    //   184: aload 11
    //   186: invokeinterface 420 1 0
    //   191: istore 10
    //   193: iload 10
    //   195: ifeq +3263 -> 3458
    //   198: aload 11
    //   200: iconst_0
    //   201: invokeinterface 424 2 0
    //   206: lstore 6
    //   208: iload_2
    //   209: istore 4
    //   211: aload 15
    //   213: getfield 427	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   216: astore 13
    //   218: aload 13
    //   220: ifnull +873 -> 1093
    //   223: aconst_null
    //   224: astore 14
    //   226: aload_0
    //   227: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   230: astore 17
    //   232: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   235: astore 13
    //   237: new 163	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 429
    //   247: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: lload 6
    //   252: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: ldc_w 434
    //   258: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 407
    //   264: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 436
    //   270: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 438
    //   276: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 440
    //   282: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 409
    //   288: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 436
    //   294: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 15
    //   299: getfield 427	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   302: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 440
    //   308: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 442
    //   314: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 436
    //   320: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iconst_2
    //   324: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 401
    //   330: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: astore 16
    //   338: aload 17
    //   340: aload 13
    //   342: iconst_5
    //   343: anewarray 352	java/lang/String
    //   346: dup
    //   347: iconst_0
    //   348: ldc_w 403
    //   351: aastore
    //   352: dup
    //   353: iconst_1
    //   354: ldc_w 405
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: ldc_w 407
    //   363: aastore
    //   364: dup
    //   365: iconst_3
    //   366: ldc_w 409
    //   369: aastore
    //   370: dup
    //   371: iconst_4
    //   372: ldc_w 442
    //   375: aastore
    //   376: aload 16
    //   378: aconst_null
    //   379: aconst_null
    //   380: invokevirtual 415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   383: astore 13
    //   385: aload 13
    //   387: ifnull +594 -> 981
    //   390: aload 13
    //   392: invokeinterface 448 1 0
    //   397: istore 10
    //   399: iload 10
    //   401: ifeq +580 -> 981
    //   404: iconst_1
    //   405: istore_3
    //   406: iconst_1
    //   407: istore_2
    //   408: aload 13
    //   410: invokeinterface 449 1 0
    //   415: iconst_0
    //   416: ifeq +3035 -> 3451
    //   419: new 451	java/lang/NullPointerException
    //   422: dup
    //   423: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   426: athrow
    //   427: iload_3
    //   428: istore 5
    //   430: lload 6
    //   432: lstore 8
    //   434: iload_2
    //   435: istore 4
    //   437: aload 11
    //   439: ifnull +2999 -> 3438
    //   442: aload 11
    //   444: invokeinterface 449 1 0
    //   449: iload_3
    //   450: ifne +669 -> 1119
    //   453: iconst_1
    //   454: istore_3
    //   455: iconst_0
    //   456: istore_2
    //   457: new 454	android/content/ContentValues
    //   460: dup
    //   461: invokespecial 455	android/content/ContentValues:<init>	()V
    //   464: astore 13
    //   466: iload_3
    //   467: iconst_1
    //   468: if_icmpne +669 -> 1137
    //   471: aload_0
    //   472: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   475: getstatic 458	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   478: aload 13
    //   480: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   483: invokestatic 468	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   486: lstore 6
    //   488: aload 12
    //   490: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   493: ifne +55 -> 548
    //   496: aload 13
    //   498: invokevirtual 471	android/content/ContentValues:clear	()V
    //   501: aload 13
    //   503: ldc_w 403
    //   506: lload 6
    //   508: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   514: aload 13
    //   516: ldc_w 407
    //   519: ldc_w 480
    //   522: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 13
    //   527: ldc_w 409
    //   530: aload 12
    //   532: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_0
    //   536: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   539: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   542: aload 13
    //   544: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   547: pop
    //   548: aload 15
    //   550: getfield 486	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   553: ifnonnull +11 -> 564
    //   556: aload 15
    //   558: getfield 489	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   561: ifnull +99 -> 660
    //   564: aload 13
    //   566: invokevirtual 471	android/content/ContentValues:clear	()V
    //   569: aload 13
    //   571: ldc_w 403
    //   574: lload 6
    //   576: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   579: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   582: aload 13
    //   584: ldc_w 407
    //   587: ldc_w 491
    //   590: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload 15
    //   595: getfield 489	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   598: ifnull +16 -> 614
    //   601: aload 13
    //   603: ldc_w 409
    //   606: aload 15
    //   608: getfield 489	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   611: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 15
    //   616: getfield 486	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   619: ifnull +16 -> 635
    //   622: aload 13
    //   624: ldc_w 493
    //   627: aload 15
    //   629: getfield 486	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   632: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 13
    //   637: ldc_w 442
    //   640: iconst_1
    //   641: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   647: aload_0
    //   648: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   651: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   654: aload 13
    //   656: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   659: pop
    //   660: aload 15
    //   662: getfield 427	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   665: ifnull +70 -> 735
    //   668: aload 13
    //   670: invokevirtual 471	android/content/ContentValues:clear	()V
    //   673: aload 13
    //   675: ldc_w 403
    //   678: lload 6
    //   680: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   683: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   686: aload 13
    //   688: ldc_w 407
    //   691: ldc_w 438
    //   694: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 13
    //   699: ldc_w 409
    //   702: aload 15
    //   704: getfield 427	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   707: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload 13
    //   712: ldc_w 442
    //   715: iconst_2
    //   716: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   719: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   722: aload_0
    //   723: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   726: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   729: aload 13
    //   731: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   734: pop
    //   735: aload 15
    //   737: getfield 504	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   740: ifnull +70 -> 810
    //   743: aload 13
    //   745: invokevirtual 471	android/content/ContentValues:clear	()V
    //   748: aload 13
    //   750: ldc_w 403
    //   753: lload 6
    //   755: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   758: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   761: aload 13
    //   763: ldc_w 407
    //   766: ldc_w 438
    //   769: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload 13
    //   774: ldc_w 409
    //   777: aload 15
    //   779: getfield 504	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   782: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 13
    //   787: ldc_w 442
    //   790: iconst_3
    //   791: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   794: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   797: aload_0
    //   798: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   801: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   804: aload 13
    //   806: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   809: pop
    //   810: aload 15
    //   812: getfield 507	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   815: ifnull +70 -> 885
    //   818: aload 13
    //   820: invokevirtual 471	android/content/ContentValues:clear	()V
    //   823: aload 13
    //   825: ldc_w 403
    //   828: lload 6
    //   830: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   833: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   836: aload 13
    //   838: ldc_w 407
    //   841: ldc_w 509
    //   844: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: aload 13
    //   849: ldc_w 409
    //   852: aload 15
    //   854: getfield 507	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   857: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: aload 13
    //   862: ldc_w 442
    //   865: iconst_2
    //   866: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   869: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   872: aload_0
    //   873: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   876: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   879: aload 13
    //   881: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   884: pop
    //   885: aload 13
    //   887: invokevirtual 471	android/content/ContentValues:clear	()V
    //   890: aload 13
    //   892: ldc_w 403
    //   895: lload 6
    //   897: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   900: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   903: aload 13
    //   905: ldc_w 407
    //   908: ldc_w 511
    //   911: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: aload 13
    //   916: ldc_w 409
    //   919: aload_1
    //   920: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload 13
    //   925: ldc_w 442
    //   928: iconst_2
    //   929: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   932: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   935: aload_0
    //   936: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   939: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   942: aload 13
    //   944: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   947: pop
    //   948: iconst_0
    //   949: ireturn
    //   950: aload 15
    //   952: getfield 514	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   955: ifnull +13 -> 968
    //   958: aload 15
    //   960: getfield 514	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   963: astore 12
    //   965: goto -885 -> 80
    //   968: aload_1
    //   969: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifne +2493 -> 3465
    //   975: aload_1
    //   976: astore 12
    //   978: goto -898 -> 80
    //   981: iconst_0
    //   982: istore_2
    //   983: iconst_0
    //   984: istore 4
    //   986: iload_2
    //   987: istore_3
    //   988: aload 13
    //   990: ifnull +2487 -> 3477
    //   993: iload 4
    //   995: istore_3
    //   996: aload 13
    //   998: invokeinterface 449 1 0
    //   1003: iload_2
    //   1004: istore_3
    //   1005: goto +2472 -> 3477
    //   1008: iload_2
    //   1009: istore_3
    //   1010: aload 13
    //   1012: ifnull +2465 -> 3477
    //   1015: iload_2
    //   1016: istore_3
    //   1017: aload 13
    //   1019: invokeinterface 449 1 0
    //   1024: iload_2
    //   1025: istore_3
    //   1026: goto +2451 -> 3477
    //   1029: astore 13
    //   1031: iload_3
    //   1032: istore_2
    //   1033: iconst_1
    //   1034: istore_3
    //   1035: iload_3
    //   1036: istore 5
    //   1038: lload 6
    //   1040: lstore 8
    //   1042: iload_2
    //   1043: istore 4
    //   1045: aload 11
    //   1047: ifnull +2391 -> 3438
    //   1050: aload 11
    //   1052: invokeinterface 449 1 0
    //   1057: goto -608 -> 449
    //   1060: astore 13
    //   1062: aload 14
    //   1064: ifnull +13 -> 1077
    //   1067: iload_2
    //   1068: istore 4
    //   1070: aload 14
    //   1072: invokeinterface 449 1 0
    //   1077: iload_2
    //   1078: istore 4
    //   1080: aload 13
    //   1082: athrow
    //   1083: astore 13
    //   1085: iconst_1
    //   1086: istore_3
    //   1087: iload 4
    //   1089: istore_2
    //   1090: goto -55 -> 1035
    //   1093: iconst_0
    //   1094: istore_2
    //   1095: iconst_1
    //   1096: istore_3
    //   1097: goto -670 -> 427
    //   1100: astore_1
    //   1101: aload 13
    //   1103: astore 11
    //   1105: aload 11
    //   1107: ifnull +10 -> 1117
    //   1110: aload 11
    //   1112: invokeinterface 449 1 0
    //   1117: aload_1
    //   1118: athrow
    //   1119: iload_2
    //   1120: ifne +10 -> 1130
    //   1123: iconst_1
    //   1124: istore_3
    //   1125: iconst_0
    //   1126: istore_2
    //   1127: goto -670 -> 457
    //   1130: iconst_1
    //   1131: istore_2
    //   1132: iconst_0
    //   1133: istore_3
    //   1134: goto -677 -> 457
    //   1137: iload_2
    //   1138: iconst_1
    //   1139: if_icmpne +2163 -> 3302
    //   1142: aload 15
    //   1144: getfield 427	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1147: ifnull +131 -> 1278
    //   1150: aload 13
    //   1152: invokevirtual 471	android/content/ContentValues:clear	()V
    //   1155: aload 13
    //   1157: ldc_w 407
    //   1160: ldc_w 438
    //   1163: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1166: aload 13
    //   1168: ldc_w 409
    //   1171: aload 15
    //   1173: getfield 427	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1176: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1179: aload 13
    //   1181: ldc_w 442
    //   1184: iconst_2
    //   1185: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1188: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1191: aload_0
    //   1192: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1195: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1198: aload 13
    //   1200: new 163	java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1207: ldc_w 429
    //   1210: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: lload 6
    //   1215: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1218: ldc_w 434
    //   1221: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: ldc_w 407
    //   1227: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: ldc_w 436
    //   1233: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: ldc_w 438
    //   1239: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: ldc_w 440
    //   1245: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: ldc_w 442
    //   1251: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: ldc_w 436
    //   1257: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: iconst_2
    //   1261: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1264: ldc_w 401
    //   1267: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: aconst_null
    //   1274: invokevirtual 518	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1277: pop
    //   1278: aload 15
    //   1280: getfield 486	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1283: ifnull +293 -> 1576
    //   1286: aconst_null
    //   1287: astore 11
    //   1289: aload_0
    //   1290: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1293: astore 12
    //   1295: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1298: astore 16
    //   1300: new 163	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1307: ldc_w 429
    //   1310: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: lload 6
    //   1315: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1318: ldc_w 434
    //   1321: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: ldc_w 407
    //   1327: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: ldc_w 436
    //   1333: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: ldc_w 491
    //   1339: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: ldc_w 440
    //   1345: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: ldc_w 442
    //   1351: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: ldc_w 436
    //   1357: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: iconst_1
    //   1361: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1364: ldc_w 401
    //   1367: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1373: astore 14
    //   1375: aload 12
    //   1377: aload 16
    //   1379: iconst_5
    //   1380: anewarray 352	java/lang/String
    //   1383: dup
    //   1384: iconst_0
    //   1385: ldc_w 403
    //   1388: aastore
    //   1389: dup
    //   1390: iconst_1
    //   1391: ldc_w 405
    //   1394: aastore
    //   1395: dup
    //   1396: iconst_2
    //   1397: ldc_w 407
    //   1400: aastore
    //   1401: dup
    //   1402: iconst_3
    //   1403: ldc_w 493
    //   1406: aastore
    //   1407: dup
    //   1408: iconst_4
    //   1409: ldc_w 442
    //   1412: aastore
    //   1413: aload 14
    //   1415: aconst_null
    //   1416: aconst_null
    //   1417: invokevirtual 415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1420: astore 12
    //   1422: aload 12
    //   1424: astore 11
    //   1426: aload 11
    //   1428: invokeinterface 448 1 0
    //   1433: ifeq +1364 -> 2797
    //   1436: aload 13
    //   1438: invokevirtual 471	android/content/ContentValues:clear	()V
    //   1441: aload 13
    //   1443: ldc_w 407
    //   1446: ldc_w 491
    //   1449: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1452: aload 13
    //   1454: ldc_w 493
    //   1457: aload 15
    //   1459: getfield 486	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1462: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 13
    //   1467: ldc_w 442
    //   1470: iconst_1
    //   1471: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1474: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1477: aload_0
    //   1478: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1481: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1484: aload 13
    //   1486: new 163	java/lang/StringBuilder
    //   1489: dup
    //   1490: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1493: ldc_w 429
    //   1496: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: lload 6
    //   1501: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1504: ldc_w 434
    //   1507: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: ldc_w 407
    //   1513: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: ldc_w 436
    //   1519: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1522: ldc_w 491
    //   1525: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: ldc_w 440
    //   1531: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: ldc_w 442
    //   1537: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: ldc_w 436
    //   1543: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: iconst_1
    //   1547: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1550: ldc_w 401
    //   1553: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1559: aconst_null
    //   1560: invokevirtual 518	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1563: pop
    //   1564: aload 11
    //   1566: ifnull +10 -> 1576
    //   1569: aload 11
    //   1571: invokeinterface 449 1 0
    //   1576: aload 15
    //   1578: getfield 489	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1581: ifnull +293 -> 1874
    //   1584: aconst_null
    //   1585: astore 11
    //   1587: aload_0
    //   1588: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1591: astore 16
    //   1593: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1596: astore 12
    //   1598: new 163	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1605: ldc_w 429
    //   1608: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: lload 6
    //   1613: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1616: ldc_w 434
    //   1619: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: ldc_w 407
    //   1625: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: ldc_w 436
    //   1631: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: ldc_w 491
    //   1637: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: ldc_w 440
    //   1643: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1646: ldc_w 442
    //   1649: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: ldc_w 436
    //   1655: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: iconst_1
    //   1659: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1662: ldc_w 401
    //   1665: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1671: astore 14
    //   1673: aload 16
    //   1675: aload 12
    //   1677: iconst_5
    //   1678: anewarray 352	java/lang/String
    //   1681: dup
    //   1682: iconst_0
    //   1683: ldc_w 403
    //   1686: aastore
    //   1687: dup
    //   1688: iconst_1
    //   1689: ldc_w 405
    //   1692: aastore
    //   1693: dup
    //   1694: iconst_2
    //   1695: ldc_w 407
    //   1698: aastore
    //   1699: dup
    //   1700: iconst_3
    //   1701: ldc_w 409
    //   1704: aastore
    //   1705: dup
    //   1706: iconst_4
    //   1707: ldc_w 442
    //   1710: aastore
    //   1711: aload 14
    //   1713: aconst_null
    //   1714: aconst_null
    //   1715: invokevirtual 415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1718: astore 12
    //   1720: aload 12
    //   1722: astore 11
    //   1724: aload 11
    //   1726: invokeinterface 448 1 0
    //   1731: ifeq +1168 -> 2899
    //   1734: aload 13
    //   1736: invokevirtual 471	android/content/ContentValues:clear	()V
    //   1739: aload 13
    //   1741: ldc_w 407
    //   1744: ldc_w 491
    //   1747: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1750: aload 13
    //   1752: ldc_w 409
    //   1755: aload 15
    //   1757: getfield 489	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1760: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1763: aload 13
    //   1765: ldc_w 442
    //   1768: iconst_1
    //   1769: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1772: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1775: aload_0
    //   1776: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1779: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1782: aload 13
    //   1784: new 163	java/lang/StringBuilder
    //   1787: dup
    //   1788: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1791: ldc_w 429
    //   1794: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: lload 6
    //   1799: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1802: ldc_w 434
    //   1805: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: ldc_w 407
    //   1811: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: ldc_w 436
    //   1817: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: ldc_w 491
    //   1823: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: ldc_w 440
    //   1829: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: ldc_w 442
    //   1835: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: ldc_w 436
    //   1841: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: iconst_1
    //   1845: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1848: ldc_w 401
    //   1851: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: aconst_null
    //   1858: invokevirtual 518	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1861: pop
    //   1862: aload 11
    //   1864: ifnull +10 -> 1874
    //   1867: aload 11
    //   1869: invokeinterface 449 1 0
    //   1874: aload 15
    //   1876: getfield 504	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1879: ifnull +306 -> 2185
    //   1882: aconst_null
    //   1883: astore 11
    //   1885: aload_0
    //   1886: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1889: astore 16
    //   1891: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1894: astore 14
    //   1896: new 163	java/lang/StringBuilder
    //   1899: dup
    //   1900: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1903: ldc_w 429
    //   1906: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: lload 6
    //   1911: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1914: ldc_w 434
    //   1917: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: ldc_w 407
    //   1923: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: ldc_w 436
    //   1929: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: ldc_w 438
    //   1935: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: ldc_w 440
    //   1941: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: ldc_w 442
    //   1947: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: ldc_w 436
    //   1953: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: iconst_3
    //   1957: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1960: ldc_w 401
    //   1963: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: astore 12
    //   1971: aload 16
    //   1973: aload 14
    //   1975: iconst_5
    //   1976: anewarray 352	java/lang/String
    //   1979: dup
    //   1980: iconst_0
    //   1981: ldc_w 403
    //   1984: aastore
    //   1985: dup
    //   1986: iconst_1
    //   1987: ldc_w 405
    //   1990: aastore
    //   1991: dup
    //   1992: iconst_2
    //   1993: ldc_w 407
    //   1996: aastore
    //   1997: dup
    //   1998: iconst_3
    //   1999: ldc_w 409
    //   2002: aastore
    //   2003: dup
    //   2004: iconst_4
    //   2005: ldc_w 442
    //   2008: aastore
    //   2009: aload 12
    //   2011: aconst_null
    //   2012: aconst_null
    //   2013: invokevirtual 415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2016: astore 12
    //   2018: aload 12
    //   2020: astore 11
    //   2022: aload 11
    //   2024: invokeinterface 448 1 0
    //   2029: ifeq +972 -> 3001
    //   2032: aload 13
    //   2034: invokevirtual 471	android/content/ContentValues:clear	()V
    //   2037: aload 13
    //   2039: ldc_w 403
    //   2042: lload 6
    //   2044: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2047: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2050: aload 13
    //   2052: ldc_w 407
    //   2055: ldc_w 438
    //   2058: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2061: aload 13
    //   2063: ldc_w 409
    //   2066: aload 15
    //   2068: getfield 504	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2071: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2074: aload 13
    //   2076: ldc_w 442
    //   2079: iconst_3
    //   2080: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2083: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2086: aload_0
    //   2087: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2090: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2093: aload 13
    //   2095: new 163	java/lang/StringBuilder
    //   2098: dup
    //   2099: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2102: ldc_w 429
    //   2105: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: lload 6
    //   2110: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2113: ldc_w 434
    //   2116: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: ldc_w 407
    //   2122: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: ldc_w 436
    //   2128: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: ldc_w 438
    //   2134: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: ldc_w 440
    //   2140: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: ldc_w 442
    //   2146: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: ldc_w 436
    //   2152: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: iconst_3
    //   2156: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2159: ldc_w 401
    //   2162: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2168: aconst_null
    //   2169: invokevirtual 518	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2172: pop
    //   2173: aload 11
    //   2175: ifnull +10 -> 2185
    //   2178: aload 11
    //   2180: invokeinterface 449 1 0
    //   2185: aload 15
    //   2187: getfield 507	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2190: ifnull +306 -> 2496
    //   2193: aconst_null
    //   2194: astore 11
    //   2196: aload_0
    //   2197: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2200: astore 16
    //   2202: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2205: astore 12
    //   2207: new 163	java/lang/StringBuilder
    //   2210: dup
    //   2211: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2214: ldc_w 429
    //   2217: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2220: lload 6
    //   2222: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2225: ldc_w 434
    //   2228: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: ldc_w 407
    //   2234: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: ldc_w 436
    //   2240: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: ldc_w 509
    //   2246: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: ldc_w 440
    //   2252: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: ldc_w 442
    //   2258: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: ldc_w 436
    //   2264: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2267: iconst_2
    //   2268: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2271: ldc_w 401
    //   2274: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2280: astore 14
    //   2282: aload 16
    //   2284: aload 12
    //   2286: iconst_5
    //   2287: anewarray 352	java/lang/String
    //   2290: dup
    //   2291: iconst_0
    //   2292: ldc_w 403
    //   2295: aastore
    //   2296: dup
    //   2297: iconst_1
    //   2298: ldc_w 405
    //   2301: aastore
    //   2302: dup
    //   2303: iconst_2
    //   2304: ldc_w 407
    //   2307: aastore
    //   2308: dup
    //   2309: iconst_3
    //   2310: ldc_w 409
    //   2313: aastore
    //   2314: dup
    //   2315: iconst_4
    //   2316: ldc_w 442
    //   2319: aastore
    //   2320: aload 14
    //   2322: aconst_null
    //   2323: aconst_null
    //   2324: invokevirtual 415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2327: astore 12
    //   2329: aload 12
    //   2331: astore 11
    //   2333: aload 11
    //   2335: invokeinterface 448 1 0
    //   2340: ifeq +763 -> 3103
    //   2343: aload 13
    //   2345: invokevirtual 471	android/content/ContentValues:clear	()V
    //   2348: aload 13
    //   2350: ldc_w 403
    //   2353: lload 6
    //   2355: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2358: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2361: aload 13
    //   2363: ldc_w 407
    //   2366: ldc_w 509
    //   2369: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2372: aload 13
    //   2374: ldc_w 409
    //   2377: aload 15
    //   2379: getfield 507	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2382: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2385: aload 13
    //   2387: ldc_w 442
    //   2390: iconst_2
    //   2391: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2394: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2397: aload_0
    //   2398: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2401: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2404: aload 13
    //   2406: new 163	java/lang/StringBuilder
    //   2409: dup
    //   2410: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2413: ldc_w 429
    //   2416: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2419: lload 6
    //   2421: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2424: ldc_w 434
    //   2427: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2430: ldc_w 407
    //   2433: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: ldc_w 436
    //   2439: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: ldc_w 509
    //   2445: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: ldc_w 440
    //   2451: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: ldc_w 442
    //   2457: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2460: ldc_w 436
    //   2463: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: iconst_2
    //   2467: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2470: ldc_w 401
    //   2473: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2479: aconst_null
    //   2480: invokevirtual 518	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2483: pop
    //   2484: aload 11
    //   2486: ifnull +10 -> 2496
    //   2489: aload 11
    //   2491: invokeinterface 449 1 0
    //   2496: aconst_null
    //   2497: astore 11
    //   2499: aload_0
    //   2500: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2503: astore 15
    //   2505: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2508: astore 12
    //   2510: new 163	java/lang/StringBuilder
    //   2513: dup
    //   2514: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2517: ldc_w 429
    //   2520: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2523: lload 6
    //   2525: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2528: ldc_w 434
    //   2531: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: ldc_w 407
    //   2537: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2540: ldc_w 436
    //   2543: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: ldc_w 511
    //   2549: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2552: ldc_w 440
    //   2555: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2558: ldc_w 442
    //   2561: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2564: ldc_w 436
    //   2567: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: iconst_2
    //   2571: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2574: ldc_w 401
    //   2577: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2583: astore 14
    //   2585: aload 15
    //   2587: aload 12
    //   2589: iconst_5
    //   2590: anewarray 352	java/lang/String
    //   2593: dup
    //   2594: iconst_0
    //   2595: ldc_w 403
    //   2598: aastore
    //   2599: dup
    //   2600: iconst_1
    //   2601: ldc_w 405
    //   2604: aastore
    //   2605: dup
    //   2606: iconst_2
    //   2607: ldc_w 407
    //   2610: aastore
    //   2611: dup
    //   2612: iconst_3
    //   2613: ldc_w 409
    //   2616: aastore
    //   2617: dup
    //   2618: iconst_4
    //   2619: ldc_w 442
    //   2622: aastore
    //   2623: aload 14
    //   2625: aconst_null
    //   2626: aconst_null
    //   2627: invokevirtual 415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2630: astore 12
    //   2632: aload 12
    //   2634: astore 11
    //   2636: aload 11
    //   2638: invokeinterface 448 1 0
    //   2643: ifeq +562 -> 3205
    //   2646: aload 13
    //   2648: invokevirtual 471	android/content/ContentValues:clear	()V
    //   2651: aload 13
    //   2653: ldc_w 403
    //   2656: lload 6
    //   2658: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2661: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2664: aload 13
    //   2666: ldc_w 407
    //   2669: ldc_w 511
    //   2672: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2675: aload 13
    //   2677: ldc_w 409
    //   2680: aload_1
    //   2681: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2684: aload 13
    //   2686: ldc_w 442
    //   2689: iconst_2
    //   2690: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2693: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2696: aload_0
    //   2697: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2700: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2703: aload 13
    //   2705: new 163	java/lang/StringBuilder
    //   2708: dup
    //   2709: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   2712: ldc_w 429
    //   2715: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2718: lload 6
    //   2720: invokevirtual 432	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2723: ldc_w 434
    //   2726: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2729: ldc_w 407
    //   2732: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2735: ldc_w 436
    //   2738: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2741: ldc_w 511
    //   2744: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: ldc_w 440
    //   2750: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: ldc_w 442
    //   2756: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: ldc_w 436
    //   2762: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2765: iconst_2
    //   2766: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2769: ldc_w 401
    //   2772: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2775: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2778: aconst_null
    //   2779: invokevirtual 518	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2782: pop
    //   2783: aload 11
    //   2785: ifnull +10 -> 2795
    //   2788: aload 11
    //   2790: invokeinterface 449 1 0
    //   2795: iconst_1
    //   2796: ireturn
    //   2797: aload 13
    //   2799: invokevirtual 471	android/content/ContentValues:clear	()V
    //   2802: aload 13
    //   2804: ldc_w 403
    //   2807: lload 6
    //   2809: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2812: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2815: aload 13
    //   2817: ldc_w 407
    //   2820: ldc_w 491
    //   2823: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2826: aload 13
    //   2828: ldc_w 493
    //   2831: aload 15
    //   2833: getfield 486	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2836: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2839: aload 13
    //   2841: ldc_w 442
    //   2844: iconst_1
    //   2845: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2848: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2851: aload_0
    //   2852: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2855: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2858: aload 13
    //   2860: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2863: pop
    //   2864: goto -1300 -> 1564
    //   2867: astore 12
    //   2869: aload 11
    //   2871: ifnull -1295 -> 1576
    //   2874: aload 11
    //   2876: invokeinterface 449 1 0
    //   2881: goto -1305 -> 1576
    //   2884: astore_1
    //   2885: aload 11
    //   2887: ifnull +10 -> 2897
    //   2890: aload 11
    //   2892: invokeinterface 449 1 0
    //   2897: aload_1
    //   2898: athrow
    //   2899: aload 13
    //   2901: invokevirtual 471	android/content/ContentValues:clear	()V
    //   2904: aload 13
    //   2906: ldc_w 403
    //   2909: lload 6
    //   2911: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2914: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2917: aload 13
    //   2919: ldc_w 407
    //   2922: ldc_w 491
    //   2925: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2928: aload 13
    //   2930: ldc_w 409
    //   2933: aload 15
    //   2935: getfield 489	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2938: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2941: aload 13
    //   2943: ldc_w 442
    //   2946: iconst_1
    //   2947: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2950: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2953: aload_0
    //   2954: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2957: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2960: aload 13
    //   2962: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2965: pop
    //   2966: goto -1104 -> 1862
    //   2969: astore 12
    //   2971: aload 11
    //   2973: ifnull -1099 -> 1874
    //   2976: aload 11
    //   2978: invokeinterface 449 1 0
    //   2983: goto -1109 -> 1874
    //   2986: astore_1
    //   2987: aload 11
    //   2989: ifnull +10 -> 2999
    //   2992: aload 11
    //   2994: invokeinterface 449 1 0
    //   2999: aload_1
    //   3000: athrow
    //   3001: aload 13
    //   3003: invokevirtual 471	android/content/ContentValues:clear	()V
    //   3006: aload 13
    //   3008: ldc_w 403
    //   3011: lload 6
    //   3013: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3016: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3019: aload 13
    //   3021: ldc_w 407
    //   3024: ldc_w 438
    //   3027: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3030: aload 13
    //   3032: ldc_w 409
    //   3035: aload 15
    //   3037: getfield 504	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   3040: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3043: aload 13
    //   3045: ldc_w 442
    //   3048: iconst_3
    //   3049: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3052: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3055: aload_0
    //   3056: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3059: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3062: aload 13
    //   3064: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3067: pop
    //   3068: goto -895 -> 2173
    //   3071: astore 12
    //   3073: aload 11
    //   3075: ifnull -890 -> 2185
    //   3078: aload 11
    //   3080: invokeinterface 449 1 0
    //   3085: goto -900 -> 2185
    //   3088: astore_1
    //   3089: aload 11
    //   3091: ifnull +10 -> 3101
    //   3094: aload 11
    //   3096: invokeinterface 449 1 0
    //   3101: aload_1
    //   3102: athrow
    //   3103: aload 13
    //   3105: invokevirtual 471	android/content/ContentValues:clear	()V
    //   3108: aload 13
    //   3110: ldc_w 403
    //   3113: lload 6
    //   3115: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3118: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3121: aload 13
    //   3123: ldc_w 407
    //   3126: ldc_w 509
    //   3129: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3132: aload 13
    //   3134: ldc_w 409
    //   3137: aload 15
    //   3139: getfield 507	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3142: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3145: aload 13
    //   3147: ldc_w 442
    //   3150: iconst_2
    //   3151: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3154: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3157: aload_0
    //   3158: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3161: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3164: aload 13
    //   3166: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3169: pop
    //   3170: goto -686 -> 2484
    //   3173: astore 12
    //   3175: aload 11
    //   3177: ifnull -681 -> 2496
    //   3180: aload 11
    //   3182: invokeinterface 449 1 0
    //   3187: goto -691 -> 2496
    //   3190: astore_1
    //   3191: aload 11
    //   3193: ifnull +10 -> 3203
    //   3196: aload 11
    //   3198: invokeinterface 449 1 0
    //   3203: aload_1
    //   3204: athrow
    //   3205: aload 13
    //   3207: invokevirtual 471	android/content/ContentValues:clear	()V
    //   3210: aload 13
    //   3212: ldc_w 403
    //   3215: lload 6
    //   3217: invokestatic 474	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3220: invokevirtual 478	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3223: aload 13
    //   3225: ldc_w 407
    //   3228: ldc_w 511
    //   3231: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3234: aload 13
    //   3236: ldc_w 409
    //   3239: aload_1
    //   3240: invokevirtual 483	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3243: aload 13
    //   3245: ldc_w 442
    //   3248: iconst_2
    //   3249: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3252: invokevirtual 501	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3255: aload_0
    //   3256: invokevirtual 391	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3259: getstatic 397	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3262: aload 13
    //   3264: invokevirtual 462	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3267: pop
    //   3268: goto -485 -> 2783
    //   3271: astore_1
    //   3272: aload 11
    //   3274: ifnull -479 -> 2795
    //   3277: aload 11
    //   3279: invokeinterface 449 1 0
    //   3284: goto -489 -> 2795
    //   3287: astore_1
    //   3288: aload 11
    //   3290: ifnull +10 -> 3300
    //   3293: aload 11
    //   3295: invokeinterface 449 1 0
    //   3300: aload_1
    //   3301: athrow
    //   3302: iconst_m1
    //   3303: ireturn
    //   3304: astore_1
    //   3305: goto -17 -> 3288
    //   3308: astore_1
    //   3309: aconst_null
    //   3310: astore 11
    //   3312: goto -40 -> 3272
    //   3315: astore_1
    //   3316: goto -125 -> 3191
    //   3319: astore 11
    //   3321: aconst_null
    //   3322: astore 11
    //   3324: goto -149 -> 3175
    //   3327: astore_1
    //   3328: goto -239 -> 3089
    //   3331: astore 11
    //   3333: aconst_null
    //   3334: astore 11
    //   3336: goto -263 -> 3073
    //   3339: astore_1
    //   3340: goto -353 -> 2987
    //   3343: astore 11
    //   3345: aconst_null
    //   3346: astore 11
    //   3348: goto -377 -> 2971
    //   3351: astore_1
    //   3352: goto -467 -> 2885
    //   3355: astore 11
    //   3357: aconst_null
    //   3358: astore 11
    //   3360: goto -491 -> 2869
    //   3363: astore_1
    //   3364: goto -2259 -> 1105
    //   3367: astore 11
    //   3369: aconst_null
    //   3370: astore 11
    //   3372: iconst_0
    //   3373: istore_3
    //   3374: lconst_0
    //   3375: lstore 6
    //   3377: goto -2342 -> 1035
    //   3380: astore 13
    //   3382: lload 8
    //   3384: lstore 6
    //   3386: goto -2351 -> 1035
    //   3389: astore 13
    //   3391: iconst_1
    //   3392: istore_3
    //   3393: lload 8
    //   3395: lstore 6
    //   3397: goto -2362 -> 1035
    //   3400: astore 16
    //   3402: aload 13
    //   3404: astore 14
    //   3406: aload 16
    //   3408: astore 13
    //   3410: goto -2348 -> 1062
    //   3413: astore 16
    //   3415: aload 13
    //   3417: astore 14
    //   3419: iconst_1
    //   3420: istore_2
    //   3421: aload 16
    //   3423: astore 13
    //   3425: goto -2363 -> 1062
    //   3428: astore 14
    //   3430: goto -2422 -> 1008
    //   3433: astore 14
    //   3435: goto -2427 -> 1008
    //   3438: lload 8
    //   3440: lstore 6
    //   3442: iload 5
    //   3444: istore_3
    //   3445: iload 4
    //   3447: istore_2
    //   3448: goto -2999 -> 449
    //   3451: iconst_1
    //   3452: istore_2
    //   3453: iconst_1
    //   3454: istore_3
    //   3455: goto -3028 -> 427
    //   3458: lload 8
    //   3460: lstore 6
    //   3462: goto -3035 -> 427
    //   3465: aconst_null
    //   3466: astore 12
    //   3468: goto -3388 -> 80
    //   3471: aconst_null
    //   3472: astore 15
    //   3474: goto -3427 -> 47
    //   3477: iload_3
    //   3478: istore_2
    //   3479: iconst_1
    //   3480: istore_3
    //   3481: lload 6
    //   3483: lstore 8
    //   3485: goto -3306 -> 179
    //   3488: astore 13
    //   3490: aconst_null
    //   3491: astore 13
    //   3493: goto -2485 -> 1008
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3496	0	this	ProfileCardMoreActivity
    //   0	3496	1	paramString	String
    //   81	3398	2	m	int
    //   83	3398	3	n	int
    //   169	3277	4	i1	int
    //   428	3015	5	i2	int
    //   206	3276	6	l1	long
    //   172	3312	8	l2	long
    //   191	209	10	bool	boolean
    //   26	3285	11	localObject1	Object
    //   3319	1	11	localException1	Exception
    //   3322	1	11	localObject2	Object
    //   3331	1	11	localException2	Exception
    //   3334	1	11	localObject3	Object
    //   3343	1	11	localException3	Exception
    //   3346	1	11	localObject4	Object
    //   3355	1	11	localException4	Exception
    //   3358	1	11	localObject5	Object
    //   3367	1	11	localException5	Exception
    //   3370	1	11	localObject6	Object
    //   78	2555	12	localObject7	Object
    //   2867	1	12	localException6	Exception
    //   2969	1	12	localException7	Exception
    //   3071	1	12	localException8	Exception
    //   3173	1	12	localException9	Exception
    //   3466	1	12	localObject8	Object
    //   85	933	13	localObject9	Object
    //   1029	1	13	localException10	Exception
    //   1060	21	13	localObject10	Object
    //   1083	2180	13	localException11	Exception
    //   3380	1	13	localException12	Exception
    //   3389	14	13	localException13	Exception
    //   3408	16	13	localObject11	Object
    //   3488	1	13	localException14	Exception
    //   3491	1	13	localObject12	Object
    //   96	3322	14	localObject13	Object
    //   3428	1	14	localException15	Exception
    //   3433	1	14	localException16	Exception
    //   45	3428	15	localObject14	Object
    //   125	2158	16	localObject15	Object
    //   3400	7	16	localObject16	Object
    //   3413	9	16	localObject17	Object
    //   230	109	17	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   419	427	1029	java/lang/Exception
    //   996	1003	1029	java/lang/Exception
    //   1017	1024	1029	java/lang/Exception
    //   226	385	1060	finally
    //   211	218	1083	java/lang/Exception
    //   1070	1077	1083	java/lang/Exception
    //   1080	1083	1083	java/lang/Exception
    //   87	168	1100	finally
    //   1426	1564	2867	java/lang/Exception
    //   2797	2864	2867	java/lang/Exception
    //   1289	1422	2884	finally
    //   1724	1862	2969	java/lang/Exception
    //   2899	2966	2969	java/lang/Exception
    //   1587	1720	2986	finally
    //   2022	2173	3071	java/lang/Exception
    //   3001	3068	3071	java/lang/Exception
    //   1885	2018	3088	finally
    //   2333	2484	3173	java/lang/Exception
    //   3103	3170	3173	java/lang/Exception
    //   2196	2329	3190	finally
    //   2636	2783	3271	java/lang/Exception
    //   3205	3268	3271	java/lang/Exception
    //   2499	2632	3287	finally
    //   2636	2783	3304	finally
    //   3205	3268	3304	finally
    //   2499	2632	3308	java/lang/Exception
    //   2333	2484	3315	finally
    //   3103	3170	3315	finally
    //   2196	2329	3319	java/lang/Exception
    //   2022	2173	3327	finally
    //   3001	3068	3327	finally
    //   1885	2018	3331	java/lang/Exception
    //   1724	1862	3339	finally
    //   2899	2966	3339	finally
    //   1587	1720	3343	java/lang/Exception
    //   1426	1564	3351	finally
    //   2797	2864	3351	finally
    //   1289	1422	3355	java/lang/Exception
    //   184	193	3363	finally
    //   198	208	3363	finally
    //   211	218	3363	finally
    //   419	427	3363	finally
    //   996	1003	3363	finally
    //   1017	1024	3363	finally
    //   1070	1077	3363	finally
    //   1080	1083	3363	finally
    //   87	168	3367	java/lang/Exception
    //   184	193	3380	java/lang/Exception
    //   198	208	3389	java/lang/Exception
    //   390	399	3400	finally
    //   408	415	3413	finally
    //   390	399	3428	java/lang/Exception
    //   408	415	3433	java/lang/Exception
    //   226	385	3488	java/lang/Exception
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  String a()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.e(this.app, this.jdField_a_of_type_JavaLangString);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  void a()
  {
    setContentViewB(2131561491);
    Object localObject1;
    label97:
    int i1;
    label129:
    int n;
    int m;
    if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString))
    {
      setTitle(HardCodeUtil.a(2131708433));
      if (this.mLeftBackText != null)
      {
        this.mLeftBackText.setText("");
        this.mLeftBackText.setContentDescription(HardCodeUtil.a(2131708443));
      }
      enableRightHighlight(false);
      localObject1 = findViewById(2131365651);
      if (this.jdField_a_of_type_ArrayOfInt[14] != 1) {
        break label180;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131378527);
      if (this.jdField_a_of_type_ArrayOfInt[15] != 1) {
        break label190;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      i1 = -1;
      n = -1;
      m = 0;
      label135:
      if (m > 3) {
        break label200;
      }
      if (this.jdField_a_of_type_ArrayOfInt[m] != 1) {
        break label1385;
      }
      if (i1 >= 0) {
        break label1382;
      }
      i1 = m;
      label156:
      if (n >= m) {
        break label1379;
      }
      n = m;
    }
    label180:
    label190:
    label200:
    label1115:
    label1373:
    label1376:
    label1379:
    label1382:
    label1385:
    for (;;)
    {
      m += 1;
      break label135;
      setTitle(2131695138);
      break;
      ((View)localObject1).setVisibility(8);
      break label97;
      ((View)localObject1).setVisibility(8);
      break label129;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131369427));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376902));
      a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout, i1, n);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369276));
      a(1, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369440));
      a(2, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369268));
      a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369388));
      a(4, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
      if (this.app.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(HardCodeUtil.a(2131708466));
        this.i = ((FormSimpleItem)findViewById(2131369271));
        this.j = ((FormSimpleItem)findViewById(2131369283));
        a(16, this.i, 16, 17);
        a(17, this.j, 16, 17);
        a(null);
        this.k = ((FormSimpleItem)findViewById(2131369384));
        a(18, this.k, 18, 18);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369387));
        a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 5, 5);
        i1 = -1;
        n = -1;
        m = 6;
        label501:
        if (m > 13) {
          break label563;
        }
        if (this.jdField_a_of_type_ArrayOfInt[m] != 1) {
          break label1376;
        }
        if (i1 >= 0) {
          break label1373;
        }
        i1 = m;
        if (n >= m) {
          break label1370;
        }
        n = m;
      }
      for (;;)
      {
        m += 1;
        break label501;
        if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(HardCodeUtil.a(2131708455));
        break;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378338));
        a(7, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369348));
        a(8, this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
        if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          ReportController.b(null, "dc00898", "", "", "0X8009F70", "0X8009F70", 0, 0, "", "", "", "");
        }
        this.h = ((FormSimpleItem)findViewById(2131369347));
        a(9, this.h, i1, n);
        if (this.h.getVisibility() == 0) {
          FriendClueReporter.a(2);
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377858));
        a(11, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377861));
        a(10, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371960));
        a(12, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377864));
        a(13, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        FriendsManager localFriendsManager;
        label1017:
        boolean bool;
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localFriendsManager == null)
          {
            localObject1 = null;
            Object localObject2;
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
              this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localObject2 = localFriendsManager.a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!Utils.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
                this.jdField_c_of_type_JavaLangString = ((Groups)localObject2).group_name;
              }
              if (((Friends)localObject1).gathtertype == 1)
              {
                this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
                this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
                this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
              if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                break label1309;
              }
              localObject1 = "";
              ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 0)
            {
              a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.post(new ProfileCardMoreActivity.2(this));
            }
            if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
            {
              if (localFriendsManager != null) {
                break label1318;
              }
              localObject1 = null;
              localObject2 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if ((localObject1 == null) || (!((Card)localObject1).babyQSwitch)) {
                break label1331;
              }
              bool = true;
              ((FormSwitchItem)localObject2).setChecked(bool);
              localObject1 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
              if (localObject1 != null) {
                ((TempGetProfileDetailProcessor)localObject1).getBabyQSwitch();
              }
            }
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
            {
              if ((localFriendsManager == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
                break label1337;
              }
              this.jdField_a_of_type_Boolean = localFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              d();
            }
            if ((localFriendsManager != null) && (localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
              l();
            }
          }
        }
        for (;;)
        {
          if (AppSetting.d)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719053));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717232));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131695071));
            this.h.setContentDescription(getString(2131695062));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131708416));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690783));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131708426));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695157));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
          }
          return;
          localObject1 = localFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break;
          localObject1 = this.jdField_c_of_type_JavaLangString;
          break label958;
          localObject1 = localFriendsManager.b(AppConstants.BABY_Q_UIN);
          break label1017;
          bool = false;
          break label1039;
          this.jdField_a_of_type_Boolean = false;
          break label1115;
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
          {
            this.jdField_a_of_type_Boolean = a();
            d();
          }
        }
        continue;
        break label523;
      }
      continue;
      break label156;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F));
  }
  
  void a(int paramInt1, RelativeLayout paramRelativeLayout, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramRelativeLayout == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramRelativeLayout.setVisibility(0);
      paramRelativeLayout.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839575));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839591));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839582));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839585));
      return;
    }
    paramRelativeLayout.setVisibility(8);
  }
  
  void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSimpleItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSimpleItem.setVisibility(0);
      paramFormSimpleItem.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSimpleItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSimpleItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSimpleItem.setBgType(3);
        return;
      }
      paramFormSimpleItem.setBgType(2);
      return;
    }
    paramFormSimpleItem.setVisibility(8);
  }
  
  void a(int paramInt1, FormSwitchItem paramFormSwitchItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSwitchItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSwitchItem.setVisibility(0);
      paramFormSwitchItem.setOnCheckedChangeListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSwitchItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSwitchItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSwitchItem.setBgType(3);
        return;
      }
      paramFormSwitchItem.setBgType(2);
      return;
    }
    paramFormSwitchItem.setVisibility(8);
  }
  
  void a(TextView paramTextView, Drawable paramDrawable)
  {
    if (paramTextView != null)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
      }
    }
    else {
      return;
    }
    paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  void a(BusinessCard paramBusinessCard)
  {
    int n = 0;
    if (paramBusinessCard == null) {
      return;
    }
    String str = "";
    Object localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((Friends)localObject2).remark != null)
        {
          localObject1 = str;
          if (((Friends)localObject2).isRemark == 1) {
            localObject1 = ((Friends)localObject2).remark;
          }
        }
      }
      if (TextUtils.isEmpty(paramBusinessCard.picUrl)) {
        break label243;
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130846082));
    }
    int m;
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (!TextUtils.isEmpty(paramBusinessCard.company))
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append(paramBusinessCard.company);
      }
      if ((paramBusinessCard.mobilesNum == null) || (paramBusinessCard.mobilesNum.isEmpty())) {
        break label255;
      }
      m = 0;
      while (m < paramBusinessCard.mobilesNum.size())
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append((String)paramBusinessCard.mobilesNum.get(m));
        m += 1;
      }
      localObject2 = ((FriendsManager)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label243:
      a(this.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    label255:
    if ((paramBusinessCard.descs != null) && (!paramBusinessCard.descs.isEmpty()))
    {
      m = n;
      if (((StringBuilder)localObject2).length() != 0)
      {
        ((StringBuilder)localObject2).append("，");
        m = n;
      }
      while (m < paramBusinessCard.descs.size())
      {
        ((StringBuilder)localObject2).append((String)paramBusinessCard.descs.get(m));
        m += 1;
      }
    }
    this.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    b((String)localObject1);
  }
  
  void a(Card paramCard)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.a(paramCard);
    }
  }
  
  void a(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(this);
    if (Utils.b(paramString)) {
      localActionSheet.setMainTitle(2131690704);
    }
    for (;;)
    {
      localActionSheet.addButton(2131691567, 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ProfileCardMoreActivity.3(this, paramString, localActionSheet));
      localActionSheet.show();
      return;
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        localActionSheet.setMainTitle(2131690706);
      } else {
        localActionSheet.setMainTitle(2131690705);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1);
    int m = 17;
    if (localObject1 != null) {
      m = ((Friends)localObject1).cSpecialFlag;
    }
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    Object localObject3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + m;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + m;
    String str2 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + m;
    localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    localObject2 = ((AbsShareMsg.Builder)localObject2).c(14).a(2).a(1).a(HardCodeUtil.a(2131708418) + paramString2).a("plugin", str2, "", (String)localObject3, str1).d(getResources().getString(2131718475)).a();
    localObject3 = new StructMsgItemLayout2();
    ((AbsStructMsgItem)localObject3).b(1);
    ((AbsStructMsgItem)localObject3).a(new StructMsgItemCover((String)localObject1));
    ((AbsStructMsgItem)localObject3).a(new StructMsgItemTitle(paramString2));
    ((AbsStructMsgItem)localObject3).a(new StructMsgItemSummary(HardCodeUtil.a(2131708415) + QidianManager.b(this.app, paramString1)));
    ((AbsShareMsg)localObject2).addItem(a(HardCodeUtil.a(2131708463)));
    ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    ForwardBaseOption.a(this, paramString2, 21);
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if (localShieldMsgManger != null) {}
      for (;;)
      {
        int m;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = a();
          }
          long l = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          m = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localShieldMsgManger.b(m, (List)localObject);
            m = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            n = m;
            if (n == 0) {
              break label314;
            }
            if (paramBoolean) {
              break label309;
            }
            paramBoolean = bool;
            this.jdField_a_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_Int |= 0x2;
            e();
            return;
            localShieldMsgManger.a(m, (List)localObject);
            continue;
            m = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int n = m;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          n = m;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.getMsgHandler().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              n = 1;
              break;
              this.app.getMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label309:
            paramBoolean = false;
          }
        }
      }
      label314:
      if (paramBoolean) {
        notifyUser(2131719328, 1);
      }
      for (;;)
      {
        d();
        return;
        notifyUser(2131719330, 1);
      }
    }
    notifyUser(2131692257, 1);
    d();
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    f();
    if ((this.jdField_a_of_type_Int & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label113;
      }
      if (paramBoolean2) {
        notifyUser(2131719329, 2);
      }
    }
    else
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFD;
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label145;
      }
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localFriendsManager == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label137;
      }
      this.jdField_a_of_type_Boolean = localFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      d();
      return;
      notifyUser(2131719341, 2);
      break;
      label113:
      if (paramBoolean2)
      {
        notifyUser(2131719328, 1);
        break;
      }
      notifyUser(2131719330, 1);
      break;
      label137:
      this.jdField_a_of_type_Boolean = false;
      continue;
      label145:
      this.jdField_a_of_type_Boolean = a();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.a(paramArrayOfByte);
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      a(null);
      return;
    }
    runOnUiThread(new ProfileCardMoreActivity.4(this));
  }
  
  boolean a()
  {
    ShieldMsgManger localShieldMsgManger = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localShieldMsgManger = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if (localShieldMsgManger == null) {
        break label164;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localShieldMsgManger.a((String)localObject);
      localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {}
      for (localObject = localShieldMsgManger; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = a();
      }
    }
    label164:
    return false;
  }
  
  void b()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[19];
    int m = 0;
    while (m < 19)
    {
      this.jdField_a_of_type_ArrayOfInt[m] = 0;
      m += 1;
    }
    if (this.app.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[16] = 1;
      this.jdField_a_of_type_ArrayOfInt[17] = 1;
      this.jdField_a_of_type_ArrayOfInt[18] = 1;
    }
    for (;;)
    {
      if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString)) {
        this.jdField_a_of_type_ArrayOfInt[4] = 0;
      }
      return;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ArrayOfInt[2] = 1;
          this.jdField_a_of_type_ArrayOfInt[12] = 1;
          this.jdField_a_of_type_ArrayOfInt[14] = 1;
        }
        else
        {
          this.jdField_a_of_type_ArrayOfInt[0] = 1;
          if ((BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (QidianManager.b(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
          {
            m = 1;
            label197:
            if (m != 0)
            {
              if (!((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
                break label356;
              }
              this.jdField_a_of_type_ArrayOfInt[3] = 0;
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfInt[4] = 1;
            if (m == 0)
            {
              this.jdField_a_of_type_ArrayOfInt[5] = 1;
              this.jdField_a_of_type_ArrayOfInt[11] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[6] = 1;
            this.jdField_a_of_type_ArrayOfInt[7] = 1;
            if (FriendIntimateRelationshipHelper.a(this.app.getCurrentUin())) {
              this.jdField_a_of_type_ArrayOfInt[8] = 1;
            }
            FriendClueConfigHelper localFriendClueConfigHelper = this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper;
            if (FriendClueConfigHelper.a()) {
              this.jdField_a_of_type_ArrayOfInt[9] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[10] = 1;
            this.jdField_a_of_type_ArrayOfInt[13] = 1;
            this.jdField_a_of_type_ArrayOfInt[14] = 1;
            this.jdField_a_of_type_ArrayOfInt[15] = 1;
            break;
            m = 0;
            break label197;
            label356:
            this.jdField_a_of_type_ArrayOfInt[3] = 1;
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
      {
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27))
      {
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
      {
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 78)
      {
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 95)
      {
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 117)
      {
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(SharePreferenceUtils.a(this, "bc_remark_first"))) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 8)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366083));
    }
    if (paramInt1 < 0) {}
    for (paramInt1 = 0;; paramInt1 = AIOUtils.a(10.0F, getResources()))
    {
      int m = paramInt2;
      if (paramInt2 < 0) {
        m = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramInt1, m, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      SharePreferenceUtils.a(this, "bc_remark_first", "false");
      return;
    }
  }
  
  void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
      for (paramString = "" + this.jdField_f_of_type_JavaLangString;; paramString = this.jdField_b_of_type_JavaLangString + "，" + this.jdField_f_of_type_JavaLangString)
      {
        localTextView.setText(paramString);
        if (this.jdField_a_of_type_AndroidContentIntent == null) {
          this.jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_b_of_type_JavaLangString);
        setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
        return;
      }
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (paramString = "";; paramString = this.jdField_b_of_type_JavaLangString)
    {
      localTextView.setText(paramString);
      break;
    }
  }
  
  void c()
  {
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    while ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt2 == -1) {}
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return;
    case 1003: 
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("result");
        bool = paramIntent.getBooleanExtra("hasChange", false);
      }
      break;
    }
    for (paramIntent = (Intent)localObject;; paramIntent = (Intent)localObject)
    {
      if (paramIntent == null) {
        paramIntent = "";
      }
      for (;;)
      {
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          if ((!bool) && (paramIntent.equals(this.jdField_e_of_type_JavaLangString))) {
            break;
          }
          if (!paramIntent.equals(this.jdField_b_of_type_JavaLangString))
          {
            localObject = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            if (localObject != null)
            {
              ((FriendListHandler)localObject).setFriendComment(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent, false);
              this.jdField_a_of_type_Int |= 0x1;
              b(paramIntent);
              paramIntent = new QZoneDistributedAppCtrl.Control();
              paramIntent.cmd = 5;
              QZoneDistributedAppCtrl.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).submitCtrl(paramIntent);
              return;
            }
            notifyUser(2131693407, 1);
            return;
          }
          notifyUser(2131693393, 0);
          return;
        }
        notifyUser(2131694507, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131719718));
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.a(paramInt2, paramIntent);
        return;
        if (paramIntent == null) {
          break;
        }
        a(paramInt2, paramIntent);
        return;
      }
      bool = false;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("from");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_nick_name");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      super.finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, String.format("check params [%s, %s, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle }));
    }
    this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper = new FriendClueConfigHelper(this.app);
    try
    {
      b();
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper = new FriendProfilePhotoHelper(this, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.jdField_a_of_type_Int = getIntent().getIntExtra("coverTimeStamp", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("coverUrl");
      this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(this.app.getCurrentUin(), 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER));
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
      this.app.setHandler(ProfileCardMoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      if ((this.jdField_d_of_type_JavaLangString == null) || (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        ThreadManager.excute(new ProfileCardMoreActivity.1(this), 16, null, true);
      }
      SpecialCareUtils.a(this.app);
      return true;
    }
    catch (NoSuchFieldError paramBundle)
    {
      for (;;)
      {
        super.finish();
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper = null;
    }
    f();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    this.app.removeHandler(ProfileCardMoreActivity.class);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.a(paramIntent, localArrayList);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label68;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718943));
    }
    for (;;)
    {
      j();
      return;
      label68:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718944));
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719050);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.jdField_b_of_type_JavaLangBoolean.booleanValue()) {
      localIntent.putExtra("param_switches_changed", true);
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_a_of_type_AndroidOsBundle);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.jdField_a_of_type_Boolean))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.jdField_a_of_type_ArrayOfByte);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  public void g()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.getFileThreadHandler().post(new ProfileCardMoreActivity.14(this));
    }
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader3 = super.getClassLoader();
    ClassLoader localClassLoader2 = this.jdField_a_of_type_JavaLangClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.jdField_a_of_type_JavaLangClassLoader = localClassLoader1;
      return localClassLoader1;
    }
    return localClassLoader3;
  }
  
  protected void h()
  {
    Object localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label148;
      }
    }
    label143:
    label148:
    for (localObject1 = ((Card)localObject1).strReMark;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 30)
        {
          localObject1 = a();
          if (localObject1 == null) {
            break label143;
          }
        }
      }
      for (Object localObject2 = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;; localObject2 = null)
      {
        this.jdField_d_of_type_JavaLangString = ((String)localObject2);
        if (QLog.isDevelopLevel()) {
          QLog.i("IphoneTitleBarActivity", 4, "initRemark, " + this.jdField_d_of_type_JavaLangString);
        }
        return;
        localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
    }
  }
  
  public void i()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
    }
    label302:
    for (;;)
    {
      String str2;
      Object localObject1;
      int m;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        str2 = "1";
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle.containsKey("chatuin"))
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle.containsKey("chattype")) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 96) {
          break label302;
        }
        m = 20005;
      }
      label119:
      label508:
      for (;;)
      {
        if ((m == 20005) || (m == 20015) || (m == 25020)) {
          NewReportPlugin.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, NewReportPlugin.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, NewReportPlugin.b(2)), str2, null, this.app.getCurrentAccountUin(), m, null, (Bundle)localObject1);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), Integer.valueOf(m), str2, str1, localObject1 }));
          }
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          str2 = "0";
          break;
          int n;
          if (ProfileActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            n = 20008;
            m = n;
            if (localObject1 != null) {
              break label508;
            }
            localObject1 = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, 1);
            m = n;
            break label119;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 117)
          {
            m = 25028;
            break label119;
          }
          if (ProfileActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            n = 20013;
            m = n;
            if (localObject1 != null) {
              break label508;
            }
            localObject1 = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString, 3000);
            m = n;
            break label119;
          }
          if (localObject1 != null)
          {
            if (((Bundle)localObject1).containsKey("chattype"))
            {
              m = NewReportPlugin.a(((Bundle)localObject1).getInt("chattype"));
              break label119;
            }
            if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              m = 21000;
              break label119;
            }
            m = 20002;
            break label119;
          }
          if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            m = 21001;
            break label119;
          }
          m = 20001;
          break label119;
          NewReportPlugin.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, null, str2, str1, this.app.getAccount(), m, null, (Bundle)localObject1);
        }
      }
    }
  }
  
  public void notifyUser(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a(getTitleBarHeight()).show();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    int m = 1;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      localObject1 = this.app;
      if (paramBoolean)
      {
        m = 1;
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, m, "0", "0", "", "");
        if (this.jdField_a_of_type_Boolean != paramBoolean) {
          break label92;
        }
      }
    }
    label92:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        m = 2;
        break;
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          if (!paramBoolean) {}
          for (;;)
          {
            b(bool1);
            break;
            bool1 = false;
          }
        }
        if (!paramBoolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(bool1);
          break;
        }
        if (paramCompoundButton != this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label333;
        }
        if (!NetworkUtil.d(BaseApplication.getContext())) {
          break label280;
        }
        localObject1 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        ((FriendListHandler)localObject1).gatherContacts((short)1, (List)localObject2, paramBoolean);
        if (paramBoolean) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
        }
      }
      notifyUser(2131692257, 1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject1 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!paramBoolean) {}
      for (bool1 = bool3;; bool1 = false)
      {
        ((FormSwitchItem)localObject1).setChecked(bool1);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        break;
      }
      if (paramCompoundButton == this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).m(paramBoolean);
          localObject1 = this.app;
          if (paramBoolean) {}
          for (;;)
          {
            ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
            break;
            m = 0;
          }
        }
        notifyUser(2131692257, 1);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        localObject1 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!paramBoolean) {}
        for (bool1 = bool4;; bool1 = false)
        {
          ((FormSwitchItem)localObject1).setChecked(bool1);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          break;
        }
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton));
    label280:
    label333:
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      notifyUser(2131692257, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!paramCompoundButton.isChecked()) {}
      for (bool1 = bool5;; bool1 = false)
      {
        ((FormSwitchItem)localObject1).setChecked(bool1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, new Object[] { "mDoNotDisturb switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
    }
    Object localObject1 = this.app;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    long l;
    if (paramCompoundButton.isChecked())
    {
      l = MessageCache.a();
      label613:
      FriendsStatusUtil.b((QQAppInterface)localObject1, (String)localObject2, 0, l, true, false);
      localObject1 = this.app;
      if (!paramCompoundButton.isChecked()) {
        break label679;
      }
    }
    label679:
    for (m = 1;; m = 2)
    {
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, m, "0", "0", "", "");
      break;
      l = 0L;
      break label613;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int m;
    if (paramView == null)
    {
      m = 0;
      switch (m)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, "case default do nothing");
        }
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      m = paramView.getId();
      break;
      ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
      continue;
      c();
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      continue;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (checkSelfPermission("android.permission.WRITE_CONTACTS") != 0) {
          requestPermissions(new ProfileCardMoreActivity.12(this, this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        } else {
          g();
        }
      }
      else
      {
        g();
        continue;
        if (((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = ContactUtils.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          String str = getIntent().getStringExtra("key_nick_name");
          localObject1 = str;
          if (str == null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject1, 14);
        }
        for (;;)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper == null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper = new ProfileCardShareHelper(this, this.app, 0, new ProfileCardMoreActivity.13(this));
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = ContactUtils.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          }
          a((String)localObject1);
        }
        catch (Exception localException1) {}
        if (QLog.isColorLevel())
        {
          QLog.d("IphoneTitleBarActivity", 2, localException1, new Object[0]);
          continue;
          i();
          continue;
          try
          {
            QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
            localUserInfo.qzone_uin = this.app.getCurrentAccountUin();
            localUserInfo.nickname = this.app.getCurrentNickname();
            QZoneHelper.forwardToSinglePermissionSetting(this, localUserInfo, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
            ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.FrdProfileCard", 2, localException2.toString());
            continue;
            SpecialCareUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 3);
            ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
            continue;
            ReportController.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
            Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            if (localObject2 != null) {
              if (IntimateUtil.a(((ExtensionInfo)localObject2).intimate_type))
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                PublicFragmentActivity.Launcher.a(this, (Intent)localObject2, PublicFragmentActivity.class, IntimateInfoFragment.class);
                if (QLog.isColorLevel()) {
                  QLog.d("IphoneTitleBarActivity", 2, "jumpIntimatePage");
                }
              }
              else
              {
                localObject2 = FriendIntimateRelationshipHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("IphoneTitleBarActivity", 2, "click item_friend_intimate url:" + (String)localObject2);
                }
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject2));
                  continue;
                  this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                  FriendClueReporter.b(2);
                  continue;
                  localObject2 = new Intent(this, AvatarPendantActivity.class);
                  ((Intent)localObject2).putExtra("AllInOne", this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
                  ((Intent)localObject2).putExtra("showActionSheet", true);
                  startActivity((Intent)localObject2);
                  ReportController.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
                  continue;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper != null)
                  {
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.jdField_a_of_type_Int != 0) {
                      break label1171;
                    }
                  }
                  label1171:
                  for (boolean bool = true;; bool = false)
                  {
                    ((FriendProfilePhotoHelper)localObject2).a(bool);
                    ReportController.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
                    break;
                  }
                  k();
                  ReportController.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onUploadResult(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      a(paramArrayOfByte);
    }
  }
  
  public void updateCover(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */