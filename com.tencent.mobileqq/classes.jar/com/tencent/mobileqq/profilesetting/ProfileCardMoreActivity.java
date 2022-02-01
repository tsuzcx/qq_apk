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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.relationx.friendclue.FriendClueConfigHelper;
import com.tencent.mobileqq.relationx.friendclue.FriendClueReporter;
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
import java.util.ArrayList;
import java.util.List;
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
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ProfileCardMoreActivity.9(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ProfileCardMoreActivity.7(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ProfileCardMoreActivity.5(this);
  ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new ProfileCardMoreActivity.6(this);
  BusinessCardManager jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new ProfileCardMoreActivity.8(this);
  BusinessCard jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new ProfileCardMoreActivity.11(this);
  private ProfileCardShareHelper jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper;
  AllInOne jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne;
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
  public AllInOne b;
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
      Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
      if ((localBundle != null) && (bool1)) {
        localBundle.putBoolean("key_weishi_switch", true);
      }
      localBundle = this.jdField_a_of_type_AndroidOsBundle;
      if ((localBundle != null) && (bool2)) {
        localBundle.putBoolean("key_personality_label_switch", paramIntent.getBooleanExtra("key_personality_label_switch", false));
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("handleActivityResultForInterestSwitch mHasInterestStateChanged:");
        paramIntent.append(this.jdField_b_of_type_JavaLangBoolean);
        paramIntent.append(" isWeiShiChangeToOpen:");
        paramIntent.append(bool1);
        paramIntent.append(" isPersonalityLabelChanged:");
        paramIntent.append(bool2);
        QLog.i("IphoneTitleBarActivity", 2, paramIntent.toString());
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      notifyUser(2131692183, 1);
      d();
      return;
    }
    int m = 0;
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    long l;
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 0L;
    }
    if (l > 0L)
    {
      localFriendListHandler.changeFriendShieldFlag(l, paramBoolean ^ true);
      m = 1;
    }
    if (m != 0)
    {
      this.jdField_a_of_type_Boolean = (paramBoolean ^ true);
      this.jdField_a_of_type_Int |= 0x2;
      e();
      return;
    }
    if (paramBoolean) {
      notifyUser(2131719046, 1);
    } else {
      notifyUser(2131719048, 1);
    }
    d();
  }
  
  private void j()
  {
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = MutualMarkDataCenter.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, true);
      int m = 0;
      Object localObject;
      boolean bool;
      if (localMutualMarkForDisplayInfo != null)
      {
        localObject = IntimateUtil.a(this, localMutualMarkForDisplayInfo.a);
        m = localMutualMarkForDisplayInfo.c;
        bool = localMutualMarkForDisplayInfo.b();
      }
      else
      {
        localObject = "";
        bool = false;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      if (m != 0)
      {
        localObject = getResources().getDrawable(m);
        if ((localObject instanceof SkinnableBitmapDrawable)) {
          localObject = ((SkinnableBitmapDrawable)localObject).mutate2();
        } else {
          localObject = ((Drawable)localObject).mutate();
        }
        if (bool) {
          ((Drawable)localObject).setAlpha(102);
        } else {
          ((Drawable)localObject).setAlpha(255);
        }
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
        return;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  private void k()
  {
    startActivityForResult(new Intent(this, InterestSwitchEditActivity.class), 1008);
  }
  
  private void l()
  {
    boolean bool = FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, this.app);
    FormSwitchItem localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690711));
      }
    }
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: ldc_w 354
    //   3: astore 12
    //   5: ldc_w 356
    //   8: astore 14
    //   10: aload_1
    //   11: ifnull +4022 -> 4033
    //   14: aload_1
    //   15: invokevirtual 361	java/lang/String:trim	()Ljava/lang/String;
    //   18: invokevirtual 364	java/lang/String:length	()I
    //   21: ifne +6 -> 27
    //   24: goto +4009 -> 4033
    //   27: aload_0
    //   28: getfield 215	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 368	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   34: invokevirtual 374	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: astore 11
    //   39: aload 11
    //   41: ifnull +20 -> 61
    //   44: aload 11
    //   46: ldc_w 376
    //   49: aload_1
    //   50: invokevirtual 382	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   53: checkcast 376	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   56: astore 17
    //   58: goto +6 -> 64
    //   61: aconst_null
    //   62: astore 17
    //   64: aload 11
    //   66: ifnull +8 -> 74
    //   69: aload 11
    //   71: invokevirtual 385	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   74: aload 17
    //   76: ifnonnull +5 -> 81
    //   79: iconst_m1
    //   80: ireturn
    //   81: aload_0
    //   82: getfield 387	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   85: invokestatic 393	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +16 -> 104
    //   91: aload_0
    //   92: getfield 387	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   95: astore 11
    //   97: aload 11
    //   99: astore 16
    //   101: goto +37 -> 138
    //   104: aload 17
    //   106: getfield 396	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   109: ifnull +13 -> 122
    //   112: aload 17
    //   114: getfield 396	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   117: astore 11
    //   119: goto -22 -> 97
    //   122: aload_1
    //   123: invokestatic 393	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +9 -> 135
    //   129: aload_1
    //   130: astore 16
    //   132: goto +6 -> 138
    //   135: aconst_null
    //   136: astore 16
    //   138: lconst_0
    //   139: lstore 8
    //   141: aload_0
    //   142: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   145: astore 11
    //   147: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   150: astore 13
    //   152: new 161	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   159: astore 15
    //   161: aload 15
    //   163: ldc_w 408
    //   166: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 15
    //   172: aload 16
    //   174: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 15
    //   180: ldc_w 354
    //   183: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 15
    //   189: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore 15
    //   194: aload 11
    //   196: aload 13
    //   198: iconst_4
    //   199: anewarray 358	java/lang/String
    //   202: dup
    //   203: iconst_0
    //   204: ldc_w 410
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: ldc_w 412
    //   213: aastore
    //   214: dup
    //   215: iconst_2
    //   216: ldc_w 414
    //   219: aastore
    //   220: dup
    //   221: iconst_3
    //   222: ldc_w 416
    //   225: aastore
    //   226: aload 15
    //   228: aconst_null
    //   229: aconst_null
    //   230: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   233: astore 13
    //   235: iconst_0
    //   236: istore 4
    //   238: iconst_0
    //   239: istore_2
    //   240: aload 14
    //   242: astore 11
    //   244: aload 13
    //   246: ifnull +437 -> 683
    //   249: aload 13
    //   251: invokeinterface 427 1 0
    //   256: istore 10
    //   258: iload 10
    //   260: ifeq +423 -> 683
    //   263: aload 13
    //   265: iconst_0
    //   266: invokeinterface 431 2 0
    //   271: lstore 6
    //   273: aload 17
    //   275: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   278: astore 14
    //   280: aload 14
    //   282: ifnull +367 -> 649
    //   285: aload_0
    //   286: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   289: astore 18
    //   291: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   294: astore 19
    //   296: new 161	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   303: astore 20
    //   305: aload 20
    //   307: ldc_w 436
    //   310: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 20
    //   316: lload 6
    //   318: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 20
    //   324: ldc_w 441
    //   327: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 20
    //   333: ldc_w 414
    //   336: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 20
    //   342: ldc_w 443
    //   345: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 20
    //   351: ldc_w 445
    //   354: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: lload 6
    //   360: lstore 8
    //   362: aload 11
    //   364: astore 15
    //   366: aload 20
    //   368: aload 15
    //   370: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 20
    //   376: ldc_w 416
    //   379: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 20
    //   385: ldc_w 443
    //   388: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 20
    //   394: aload 17
    //   396: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   399: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 20
    //   405: aload 15
    //   407: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 20
    //   413: ldc_w 447
    //   416: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 20
    //   422: ldc_w 443
    //   425: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 20
    //   431: iconst_2
    //   432: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 12
    //   438: astore 14
    //   440: aload 20
    //   442: aload 14
    //   444: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 20
    //   450: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: astore 20
    //   455: aload 18
    //   457: aload 19
    //   459: iconst_5
    //   460: anewarray 358	java/lang/String
    //   463: dup
    //   464: iconst_0
    //   465: ldc_w 410
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: ldc_w 412
    //   474: aastore
    //   475: dup
    //   476: iconst_2
    //   477: ldc_w 414
    //   480: aastore
    //   481: dup
    //   482: iconst_3
    //   483: ldc_w 416
    //   486: aastore
    //   487: dup
    //   488: iconst_4
    //   489: ldc_w 447
    //   492: aastore
    //   493: aload 20
    //   495: aconst_null
    //   496: aconst_null
    //   497: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   500: astore 18
    //   502: aload 18
    //   504: ifnull +51 -> 555
    //   507: aload 18
    //   509: invokeinterface 453 1 0
    //   514: istore 10
    //   516: iload 10
    //   518: ifeq +37 -> 555
    //   521: aload 18
    //   523: invokeinterface 454 1 0
    //   528: iconst_1
    //   529: istore_2
    //   530: iconst_1
    //   531: istore_3
    //   532: goto +156 -> 688
    //   535: astore 14
    //   537: iconst_1
    //   538: istore_2
    //   539: goto +67 -> 606
    //   542: iconst_1
    //   543: istore_2
    //   544: goto +81 -> 625
    //   547: astore 14
    //   549: goto +57 -> 606
    //   552: goto +73 -> 625
    //   555: aload 18
    //   557: ifnull +26 -> 583
    //   560: aload 18
    //   562: invokeinterface 454 1 0
    //   567: goto +16 -> 583
    //   570: iconst_1
    //   571: istore_2
    //   572: aload 15
    //   574: astore 11
    //   576: aload 14
    //   578: astore 12
    //   580: goto +171 -> 751
    //   583: iconst_0
    //   584: istore_2
    //   585: goto +54 -> 639
    //   588: astore 14
    //   590: goto +13 -> 603
    //   593: astore 14
    //   595: goto +8 -> 603
    //   598: goto +3613 -> 4211
    //   601: astore 14
    //   603: aconst_null
    //   604: astore 18
    //   606: aload 18
    //   608: ifnull +12 -> 620
    //   611: iload_2
    //   612: istore_3
    //   613: aload 18
    //   615: invokeinterface 454 1 0
    //   620: iload_2
    //   621: istore_3
    //   622: aload 14
    //   624: athrow
    //   625: aload 18
    //   627: ifnull +12 -> 639
    //   630: iload_2
    //   631: istore_3
    //   632: aload 18
    //   634: invokeinterface 454 1 0
    //   639: iconst_1
    //   640: istore 4
    //   642: lload 6
    //   644: lstore 8
    //   646: goto -402 -> 244
    //   649: iconst_1
    //   650: istore_2
    //   651: iconst_0
    //   652: istore_3
    //   653: lload 6
    //   655: lstore 8
    //   657: goto +31 -> 688
    //   660: lload 6
    //   662: lstore 8
    //   664: iload_2
    //   665: istore_3
    //   666: iconst_1
    //   667: istore_2
    //   668: goto +85 -> 753
    //   671: astore_1
    //   672: goto +50 -> 722
    //   675: iload_2
    //   676: istore_3
    //   677: iload 4
    //   679: istore_2
    //   680: goto +73 -> 753
    //   683: iload_2
    //   684: istore_3
    //   685: iload 4
    //   687: istore_2
    //   688: iload_2
    //   689: istore 5
    //   691: aload 11
    //   693: astore 14
    //   695: aload 12
    //   697: astore 15
    //   699: lload 8
    //   701: lstore 6
    //   703: iload_3
    //   704: istore 4
    //   706: aload 13
    //   708: ifnull +93 -> 801
    //   711: lload 8
    //   713: lstore 6
    //   715: goto +65 -> 780
    //   718: astore_1
    //   719: aconst_null
    //   720: astore 13
    //   722: aload 13
    //   724: ifnull +10 -> 734
    //   727: aload 13
    //   729: invokeinterface 454 1 0
    //   734: aload_1
    //   735: athrow
    //   736: ldc_w 354
    //   739: astore 12
    //   741: ldc_w 356
    //   744: astore 11
    //   746: iconst_0
    //   747: istore_2
    //   748: aconst_null
    //   749: astore 13
    //   751: iconst_0
    //   752: istore_3
    //   753: iload_2
    //   754: istore 5
    //   756: aload 11
    //   758: astore 14
    //   760: aload 12
    //   762: astore 15
    //   764: lload 8
    //   766: lstore 6
    //   768: iload_3
    //   769: istore 4
    //   771: aload 13
    //   773: ifnull +28 -> 801
    //   776: lload 8
    //   778: lstore 6
    //   780: aload 13
    //   782: invokeinterface 454 1 0
    //   787: iload_3
    //   788: istore 4
    //   790: aload 12
    //   792: astore 15
    //   794: aload 11
    //   796: astore 14
    //   798: iload_2
    //   799: istore 5
    //   801: iload 5
    //   803: ifne +10 -> 813
    //   806: iconst_1
    //   807: istore_2
    //   808: iconst_0
    //   809: istore_3
    //   810: goto +15 -> 825
    //   813: iload 4
    //   815: ifne +6 -> 821
    //   818: goto -12 -> 806
    //   821: iconst_0
    //   822: istore_2
    //   823: iconst_1
    //   824: istore_3
    //   825: new 456	android/content/ContentValues
    //   828: dup
    //   829: invokespecial 457	android/content/ContentValues:<init>	()V
    //   832: astore 18
    //   834: iload_2
    //   835: iconst_1
    //   836: if_icmpne +482 -> 1318
    //   839: aload_0
    //   840: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   843: getstatic 460	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   846: aload 18
    //   848: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   851: invokestatic 470	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   854: lstore 6
    //   856: aload 16
    //   858: invokestatic 393	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   861: ifne +55 -> 916
    //   864: aload 18
    //   866: invokevirtual 473	android/content/ContentValues:clear	()V
    //   869: aload 18
    //   871: ldc_w 410
    //   874: lload 6
    //   876: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   879: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   882: aload 18
    //   884: ldc_w 414
    //   887: ldc_w 482
    //   890: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload 18
    //   895: ldc_w 416
    //   898: aload 16
    //   900: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload_0
    //   904: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   907: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   910: aload 18
    //   912: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   915: pop
    //   916: aload 17
    //   918: getfield 488	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   921: ifnonnull +11 -> 932
    //   924: aload 17
    //   926: getfield 491	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   929: ifnull +99 -> 1028
    //   932: aload 18
    //   934: invokevirtual 473	android/content/ContentValues:clear	()V
    //   937: aload 18
    //   939: ldc_w 410
    //   942: lload 6
    //   944: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   947: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   950: aload 18
    //   952: ldc_w 414
    //   955: ldc_w 493
    //   958: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   961: aload 17
    //   963: getfield 491	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   966: ifnull +16 -> 982
    //   969: aload 18
    //   971: ldc_w 416
    //   974: aload 17
    //   976: getfield 491	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   979: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   982: aload 17
    //   984: getfield 488	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   987: ifnull +16 -> 1003
    //   990: aload 18
    //   992: ldc_w 495
    //   995: aload 17
    //   997: getfield 488	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1000: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1003: aload 18
    //   1005: ldc_w 447
    //   1008: iconst_1
    //   1009: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1012: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1015: aload_0
    //   1016: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1019: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1022: aload 18
    //   1024: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1027: pop
    //   1028: aload 17
    //   1030: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1033: ifnull +70 -> 1103
    //   1036: aload 18
    //   1038: invokevirtual 473	android/content/ContentValues:clear	()V
    //   1041: aload 18
    //   1043: ldc_w 410
    //   1046: lload 6
    //   1048: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1051: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1054: aload 18
    //   1056: ldc_w 414
    //   1059: ldc_w 445
    //   1062: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1065: aload 18
    //   1067: ldc_w 416
    //   1070: aload 17
    //   1072: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1075: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1078: aload 18
    //   1080: ldc_w 447
    //   1083: iconst_2
    //   1084: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1087: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1090: aload_0
    //   1091: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1094: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1097: aload 18
    //   1099: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1102: pop
    //   1103: aload 17
    //   1105: getfield 506	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1108: ifnull +70 -> 1178
    //   1111: aload 18
    //   1113: invokevirtual 473	android/content/ContentValues:clear	()V
    //   1116: aload 18
    //   1118: ldc_w 410
    //   1121: lload 6
    //   1123: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1126: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1129: aload 18
    //   1131: ldc_w 414
    //   1134: ldc_w 445
    //   1137: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1140: aload 18
    //   1142: ldc_w 416
    //   1145: aload 17
    //   1147: getfield 506	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1150: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1153: aload 18
    //   1155: ldc_w 447
    //   1158: iconst_3
    //   1159: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1162: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1165: aload_0
    //   1166: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1169: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1172: aload 18
    //   1174: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1177: pop
    //   1178: aload 17
    //   1180: getfield 509	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   1183: ifnull +70 -> 1253
    //   1186: aload 18
    //   1188: invokevirtual 473	android/content/ContentValues:clear	()V
    //   1191: aload 18
    //   1193: ldc_w 410
    //   1196: lload 6
    //   1198: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1201: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1204: aload 18
    //   1206: ldc_w 414
    //   1209: ldc_w 511
    //   1212: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1215: aload 18
    //   1217: ldc_w 416
    //   1220: aload 17
    //   1222: getfield 509	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   1225: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1228: aload 18
    //   1230: ldc_w 447
    //   1233: iconst_2
    //   1234: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1237: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1240: aload_0
    //   1241: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1244: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1247: aload 18
    //   1249: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1252: pop
    //   1253: aload 18
    //   1255: invokevirtual 473	android/content/ContentValues:clear	()V
    //   1258: aload 18
    //   1260: ldc_w 410
    //   1263: lload 6
    //   1265: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1268: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1271: aload 18
    //   1273: ldc_w 414
    //   1276: ldc_w 513
    //   1279: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1282: aload 18
    //   1284: ldc_w 416
    //   1287: aload_1
    //   1288: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1291: aload 18
    //   1293: ldc_w 447
    //   1296: iconst_2
    //   1297: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1300: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1303: aload_0
    //   1304: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1307: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1310: aload 18
    //   1312: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1315: pop
    //   1316: iconst_0
    //   1317: ireturn
    //   1318: iload_3
    //   1319: iconst_1
    //   1320: if_icmpne +2711 -> 4031
    //   1323: aload 17
    //   1325: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1328: ifnull +180 -> 1508
    //   1331: aload 18
    //   1333: invokevirtual 473	android/content/ContentValues:clear	()V
    //   1336: aload 18
    //   1338: ldc_w 414
    //   1341: ldc_w 445
    //   1344: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1347: aload 18
    //   1349: ldc_w 416
    //   1352: aload 17
    //   1354: getfield 434	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1357: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1360: aload 18
    //   1362: ldc_w 447
    //   1365: iconst_2
    //   1366: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1369: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1372: aload_0
    //   1373: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1376: astore 11
    //   1378: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1381: astore 12
    //   1383: new 161	java/lang/StringBuilder
    //   1386: dup
    //   1387: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1390: astore 13
    //   1392: aload 13
    //   1394: ldc_w 436
    //   1397: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: pop
    //   1401: aload 13
    //   1403: lload 6
    //   1405: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload 13
    //   1411: ldc_w 441
    //   1414: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload 13
    //   1420: ldc_w 414
    //   1423: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: pop
    //   1427: ldc_w 443
    //   1430: astore 16
    //   1432: aload 13
    //   1434: aload 16
    //   1436: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 13
    //   1442: ldc_w 445
    //   1445: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: pop
    //   1449: aload 13
    //   1451: aload 14
    //   1453: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: aload 13
    //   1459: ldc_w 447
    //   1462: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1465: pop
    //   1466: aload 13
    //   1468: aload 16
    //   1470: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: pop
    //   1474: aload 13
    //   1476: iconst_2
    //   1477: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: aload 13
    //   1483: aload 15
    //   1485: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: pop
    //   1489: aload 11
    //   1491: aload 12
    //   1493: aload 18
    //   1495: aload 13
    //   1497: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1500: aconst_null
    //   1501: invokevirtual 517	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1504: pop
    //   1505: goto +3 -> 1508
    //   1508: aload 17
    //   1510: getfield 488	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1513: ifnull +476 -> 1989
    //   1516: aload_0
    //   1517: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1520: astore 11
    //   1522: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1525: astore 12
    //   1527: new 161	java/lang/StringBuilder
    //   1530: dup
    //   1531: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1534: astore 13
    //   1536: aload 13
    //   1538: ldc_w 436
    //   1541: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: pop
    //   1545: aload 13
    //   1547: lload 6
    //   1549: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1552: pop
    //   1553: aload 13
    //   1555: ldc_w 441
    //   1558: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: pop
    //   1562: aload 13
    //   1564: ldc_w 414
    //   1567: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: pop
    //   1571: aload 13
    //   1573: ldc_w 443
    //   1576: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: pop
    //   1580: aload 13
    //   1582: ldc_w 493
    //   1585: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: pop
    //   1589: aload 13
    //   1591: aload 14
    //   1593: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: pop
    //   1597: aload 13
    //   1599: ldc_w 447
    //   1602: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload 13
    //   1608: ldc_w 443
    //   1611: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: pop
    //   1615: aload 13
    //   1617: iconst_1
    //   1618: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1621: pop
    //   1622: aload 13
    //   1624: aload 15
    //   1626: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: pop
    //   1630: aload 13
    //   1632: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: astore 13
    //   1637: aload 11
    //   1639: aload 12
    //   1641: iconst_5
    //   1642: anewarray 358	java/lang/String
    //   1645: dup
    //   1646: iconst_0
    //   1647: ldc_w 410
    //   1650: aastore
    //   1651: dup
    //   1652: iconst_1
    //   1653: ldc_w 412
    //   1656: aastore
    //   1657: dup
    //   1658: iconst_2
    //   1659: ldc_w 414
    //   1662: aastore
    //   1663: dup
    //   1664: iconst_3
    //   1665: ldc_w 495
    //   1668: aastore
    //   1669: dup
    //   1670: iconst_4
    //   1671: ldc_w 447
    //   1674: aastore
    //   1675: aload 13
    //   1677: aconst_null
    //   1678: aconst_null
    //   1679: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1682: astore 11
    //   1684: aload 11
    //   1686: invokeinterface 453 1 0
    //   1691: ifeq +177 -> 1868
    //   1694: aload 18
    //   1696: invokevirtual 473	android/content/ContentValues:clear	()V
    //   1699: aload 18
    //   1701: ldc_w 414
    //   1704: ldc_w 493
    //   1707: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1710: aload 18
    //   1712: ldc_w 495
    //   1715: aload 17
    //   1717: getfield 488	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1720: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1723: aload 18
    //   1725: ldc_w 447
    //   1728: iconst_1
    //   1729: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1732: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1735: aload_0
    //   1736: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1739: astore 12
    //   1741: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1744: astore 13
    //   1746: new 161	java/lang/StringBuilder
    //   1749: dup
    //   1750: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1753: astore 16
    //   1755: aload 16
    //   1757: ldc_w 436
    //   1760: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: pop
    //   1764: aload 16
    //   1766: lload 6
    //   1768: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1771: pop
    //   1772: aload 16
    //   1774: ldc_w 441
    //   1777: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: pop
    //   1781: aload 16
    //   1783: ldc_w 414
    //   1786: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: pop
    //   1790: aload 16
    //   1792: ldc_w 443
    //   1795: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: pop
    //   1799: aload 16
    //   1801: ldc_w 493
    //   1804: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: pop
    //   1808: aload 16
    //   1810: aload 14
    //   1812: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: pop
    //   1816: aload 16
    //   1818: ldc_w 447
    //   1821: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: pop
    //   1825: aload 16
    //   1827: ldc_w 443
    //   1830: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: pop
    //   1834: aload 16
    //   1836: iconst_1
    //   1837: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1840: pop
    //   1841: aload 16
    //   1843: aload 15
    //   1845: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: pop
    //   1849: aload 12
    //   1851: aload 13
    //   1853: aload 18
    //   1855: aload 16
    //   1857: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1860: aconst_null
    //   1861: invokevirtual 517	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1864: pop
    //   1865: goto +70 -> 1935
    //   1868: aload 18
    //   1870: invokevirtual 473	android/content/ContentValues:clear	()V
    //   1873: aload 18
    //   1875: ldc_w 410
    //   1878: lload 6
    //   1880: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1883: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1886: aload 18
    //   1888: ldc_w 414
    //   1891: ldc_w 493
    //   1894: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1897: aload 18
    //   1899: ldc_w 495
    //   1902: aload 17
    //   1904: getfield 488	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1907: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1910: aload 18
    //   1912: ldc_w 447
    //   1915: iconst_1
    //   1916: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1919: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1922: aload_0
    //   1923: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1926: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1929: aload 18
    //   1931: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1934: pop
    //   1935: aload 11
    //   1937: ifnull +52 -> 1989
    //   1940: goto +39 -> 1979
    //   1943: goto +31 -> 1974
    //   1946: astore_1
    //   1947: goto +10 -> 1957
    //   1950: goto +24 -> 1974
    //   1953: astore_1
    //   1954: aconst_null
    //   1955: astore 11
    //   1957: aload 11
    //   1959: ifnull +10 -> 1969
    //   1962: aload 11
    //   1964: invokeinterface 454 1 0
    //   1969: aload_1
    //   1970: athrow
    //   1971: aconst_null
    //   1972: astore 11
    //   1974: aload 11
    //   1976: ifnull +13 -> 1989
    //   1979: aload 11
    //   1981: invokeinterface 454 1 0
    //   1986: goto +3 -> 1989
    //   1989: ldc_w 441
    //   1992: astore 11
    //   1994: aload 17
    //   1996: getfield 491	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1999: ifnull +530 -> 2529
    //   2002: aload_0
    //   2003: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2006: astore 12
    //   2008: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2011: astore 13
    //   2013: new 161	java/lang/StringBuilder
    //   2016: dup
    //   2017: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2020: astore 16
    //   2022: aload 16
    //   2024: ldc_w 436
    //   2027: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: pop
    //   2031: aload 16
    //   2033: lload 6
    //   2035: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2038: pop
    //   2039: aload 16
    //   2041: ldc_w 441
    //   2044: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: pop
    //   2048: aload 16
    //   2050: ldc_w 414
    //   2053: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: pop
    //   2057: aload 16
    //   2059: ldc_w 443
    //   2062: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: pop
    //   2066: aload 16
    //   2068: ldc_w 493
    //   2071: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2074: pop
    //   2075: aload 16
    //   2077: aload 14
    //   2079: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: pop
    //   2083: aload 16
    //   2085: ldc_w 447
    //   2088: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: pop
    //   2092: aload 16
    //   2094: ldc_w 443
    //   2097: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2100: pop
    //   2101: aload 16
    //   2103: iconst_1
    //   2104: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2107: pop
    //   2108: aload 16
    //   2110: aload 15
    //   2112: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: pop
    //   2116: aload 16
    //   2118: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2121: astore 11
    //   2123: aload 12
    //   2125: aload 13
    //   2127: iconst_5
    //   2128: anewarray 358	java/lang/String
    //   2131: dup
    //   2132: iconst_0
    //   2133: ldc_w 410
    //   2136: aastore
    //   2137: dup
    //   2138: iconst_1
    //   2139: ldc_w 412
    //   2142: aastore
    //   2143: dup
    //   2144: iconst_2
    //   2145: ldc_w 414
    //   2148: aastore
    //   2149: dup
    //   2150: iconst_3
    //   2151: ldc_w 416
    //   2154: aastore
    //   2155: dup
    //   2156: iconst_4
    //   2157: ldc_w 447
    //   2160: aastore
    //   2161: aload 11
    //   2163: aconst_null
    //   2164: aconst_null
    //   2165: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2168: astore 11
    //   2170: aload 11
    //   2172: invokeinterface 453 1 0
    //   2177: ifeq +181 -> 2358
    //   2180: aload 18
    //   2182: invokevirtual 473	android/content/ContentValues:clear	()V
    //   2185: aload 18
    //   2187: ldc_w 414
    //   2190: ldc_w 493
    //   2193: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2196: aload 17
    //   2198: getfield 491	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2201: astore 12
    //   2203: aload 18
    //   2205: ldc_w 416
    //   2208: aload 12
    //   2210: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2213: aload 18
    //   2215: ldc_w 447
    //   2218: iconst_1
    //   2219: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2222: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2225: aload_0
    //   2226: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2229: astore 12
    //   2231: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2234: astore 13
    //   2236: new 161	java/lang/StringBuilder
    //   2239: dup
    //   2240: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2243: astore 16
    //   2245: aload 16
    //   2247: ldc_w 436
    //   2250: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: pop
    //   2254: aload 16
    //   2256: lload 6
    //   2258: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2261: pop
    //   2262: aload 16
    //   2264: ldc_w 441
    //   2267: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: pop
    //   2271: aload 16
    //   2273: ldc_w 414
    //   2276: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: pop
    //   2280: aload 16
    //   2282: ldc_w 443
    //   2285: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: pop
    //   2289: aload 16
    //   2291: ldc_w 493
    //   2294: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: pop
    //   2298: aload 16
    //   2300: aload 14
    //   2302: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: pop
    //   2306: aload 16
    //   2308: ldc_w 447
    //   2311: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: pop
    //   2315: aload 16
    //   2317: ldc_w 443
    //   2320: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: pop
    //   2324: aload 16
    //   2326: iconst_1
    //   2327: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2330: pop
    //   2331: aload 16
    //   2333: aload 15
    //   2335: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2338: pop
    //   2339: aload 12
    //   2341: aload 13
    //   2343: aload 18
    //   2345: aload 16
    //   2347: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2350: aconst_null
    //   2351: invokevirtual 517	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2354: pop
    //   2355: goto +70 -> 2425
    //   2358: aload 18
    //   2360: invokevirtual 473	android/content/ContentValues:clear	()V
    //   2363: aload 18
    //   2365: ldc_w 410
    //   2368: lload 6
    //   2370: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2373: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2376: aload 18
    //   2378: ldc_w 414
    //   2381: ldc_w 493
    //   2384: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2387: aload 18
    //   2389: ldc_w 416
    //   2392: aload 17
    //   2394: getfield 491	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2397: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2400: aload 18
    //   2402: ldc_w 447
    //   2405: iconst_1
    //   2406: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2409: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2412: aload_0
    //   2413: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2416: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2419: aload 18
    //   2421: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2424: pop
    //   2425: ldc_w 441
    //   2428: astore 12
    //   2430: aload 11
    //   2432: astore 13
    //   2434: aload 12
    //   2436: astore 11
    //   2438: aload 13
    //   2440: ifnull +89 -> 2529
    //   2443: aload 12
    //   2445: astore 11
    //   2447: goto +72 -> 2519
    //   2450: astore_1
    //   2451: goto +38 -> 2489
    //   2454: aload 11
    //   2456: astore 13
    //   2458: goto +48 -> 2506
    //   2461: astore_1
    //   2462: goto +27 -> 2489
    //   2465: ldc_w 441
    //   2468: astore 12
    //   2470: aload 11
    //   2472: astore 13
    //   2474: goto +32 -> 2506
    //   2477: ldc_w 441
    //   2480: astore 12
    //   2482: goto +21 -> 2503
    //   2485: astore_1
    //   2486: aconst_null
    //   2487: astore 11
    //   2489: aload 11
    //   2491: ifnull +10 -> 2501
    //   2494: aload 11
    //   2496: invokeinterface 454 1 0
    //   2501: aload_1
    //   2502: athrow
    //   2503: aconst_null
    //   2504: astore 13
    //   2506: aload 12
    //   2508: astore 11
    //   2510: aload 13
    //   2512: ifnull +17 -> 2529
    //   2515: aload 12
    //   2517: astore 11
    //   2519: aload 13
    //   2521: invokeinterface 454 1 0
    //   2526: goto +3 -> 2529
    //   2529: ldc_w 416
    //   2532: astore 19
    //   2534: aload 17
    //   2536: getfield 506	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2539: ifnull +532 -> 3071
    //   2542: aload_0
    //   2543: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2546: astore 12
    //   2548: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2551: astore 13
    //   2553: new 161	java/lang/StringBuilder
    //   2556: dup
    //   2557: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2560: astore 20
    //   2562: aload 20
    //   2564: ldc_w 436
    //   2567: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: pop
    //   2571: aload 20
    //   2573: lload 6
    //   2575: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2578: pop
    //   2579: aload 11
    //   2581: astore 16
    //   2583: aload 20
    //   2585: aload 16
    //   2587: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2590: pop
    //   2591: aload 20
    //   2593: ldc_w 414
    //   2596: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2599: pop
    //   2600: aload 20
    //   2602: ldc_w 443
    //   2605: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: pop
    //   2609: aload 20
    //   2611: ldc_w 445
    //   2614: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2617: pop
    //   2618: aload 20
    //   2620: aload 14
    //   2622: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2625: pop
    //   2626: aload 20
    //   2628: ldc_w 447
    //   2631: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2634: pop
    //   2635: aload 20
    //   2637: ldc_w 443
    //   2640: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2643: pop
    //   2644: aload 20
    //   2646: iconst_3
    //   2647: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2650: pop
    //   2651: aload 20
    //   2653: aload 15
    //   2655: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2658: pop
    //   2659: aload 20
    //   2661: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2664: astore 20
    //   2666: aload 12
    //   2668: aload 13
    //   2670: iconst_5
    //   2671: anewarray 358	java/lang/String
    //   2674: dup
    //   2675: iconst_0
    //   2676: ldc_w 410
    //   2679: aastore
    //   2680: dup
    //   2681: iconst_1
    //   2682: ldc_w 412
    //   2685: aastore
    //   2686: dup
    //   2687: iconst_2
    //   2688: ldc_w 414
    //   2691: aastore
    //   2692: dup
    //   2693: iconst_3
    //   2694: aload 19
    //   2696: aastore
    //   2697: dup
    //   2698: iconst_4
    //   2699: ldc_w 447
    //   2702: aastore
    //   2703: aload 20
    //   2705: aconst_null
    //   2706: aconst_null
    //   2707: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2710: astore 12
    //   2712: aload 12
    //   2714: invokeinterface 453 1 0
    //   2719: ifeq +206 -> 2925
    //   2722: aload 18
    //   2724: invokevirtual 473	android/content/ContentValues:clear	()V
    //   2727: aload 18
    //   2729: ldc_w 410
    //   2732: lload 6
    //   2734: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2737: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2740: aload 18
    //   2742: ldc_w 414
    //   2745: ldc_w 445
    //   2748: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2751: aload 18
    //   2753: aload 19
    //   2755: aload 17
    //   2757: getfield 506	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2760: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2763: aload 18
    //   2765: ldc_w 447
    //   2768: iconst_3
    //   2769: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2772: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2775: aload_0
    //   2776: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2779: astore 20
    //   2781: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2784: astore 21
    //   2786: aload 12
    //   2788: astore 13
    //   2790: new 161	java/lang/StringBuilder
    //   2793: dup
    //   2794: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2797: astore 22
    //   2799: aload 22
    //   2801: ldc_w 436
    //   2804: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: pop
    //   2808: aload 22
    //   2810: lload 6
    //   2812: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2815: pop
    //   2816: aload 22
    //   2818: aload 16
    //   2820: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2823: pop
    //   2824: aload 22
    //   2826: ldc_w 414
    //   2829: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: pop
    //   2833: aload 22
    //   2835: ldc_w 443
    //   2838: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2841: pop
    //   2842: aload 22
    //   2844: ldc_w 445
    //   2847: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2850: pop
    //   2851: aload 22
    //   2853: aload 14
    //   2855: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2858: pop
    //   2859: aload 22
    //   2861: ldc_w 447
    //   2864: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2867: pop
    //   2868: aload 22
    //   2870: ldc_w 443
    //   2873: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: pop
    //   2877: aload 22
    //   2879: iconst_3
    //   2880: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2883: pop
    //   2884: aload 22
    //   2886: aload 15
    //   2888: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2891: pop
    //   2892: aload 20
    //   2894: aload 21
    //   2896: aload 18
    //   2898: aload 22
    //   2900: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2903: aconst_null
    //   2904: invokevirtual 517	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2907: pop
    //   2908: goto +87 -> 2995
    //   2911: aload 13
    //   2913: astore 12
    //   2915: goto +141 -> 3056
    //   2918: aload 13
    //   2920: astore 12
    //   2922: goto +134 -> 3056
    //   2925: aload 12
    //   2927: astore 13
    //   2929: aload 18
    //   2931: invokevirtual 473	android/content/ContentValues:clear	()V
    //   2934: aload 18
    //   2936: ldc_w 410
    //   2939: lload 6
    //   2941: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2944: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2947: aload 18
    //   2949: ldc_w 414
    //   2952: ldc_w 445
    //   2955: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2958: aload 18
    //   2960: aload 19
    //   2962: aload 17
    //   2964: getfield 506	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2967: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2970: aload 18
    //   2972: ldc_w 447
    //   2975: iconst_3
    //   2976: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2979: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2982: aload_0
    //   2983: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2986: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2989: aload 18
    //   2991: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2994: pop
    //   2995: aload 12
    //   2997: ifnull +74 -> 3071
    //   3000: goto +61 -> 3061
    //   3003: aload 12
    //   3005: astore 11
    //   3007: astore_1
    //   3008: goto +31 -> 3039
    //   3011: aload 13
    //   3013: astore 12
    //   3015: goto +41 -> 3056
    //   3018: astore_1
    //   3019: aload 12
    //   3021: astore 11
    //   3023: goto +16 -> 3039
    //   3026: goto +30 -> 3056
    //   3029: goto +24 -> 3053
    //   3032: goto +21 -> 3053
    //   3035: astore_1
    //   3036: aconst_null
    //   3037: astore 11
    //   3039: aload 11
    //   3041: ifnull +10 -> 3051
    //   3044: aload 11
    //   3046: invokeinterface 454 1 0
    //   3051: aload_1
    //   3052: athrow
    //   3053: aconst_null
    //   3054: astore 12
    //   3056: aload 12
    //   3058: ifnull +13 -> 3071
    //   3061: aload 12
    //   3063: invokeinterface 454 1 0
    //   3068: goto +3 -> 3071
    //   3071: aload 11
    //   3073: astore 12
    //   3075: aload 17
    //   3077: getfield 509	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3080: ifnull +484 -> 3564
    //   3083: aload_0
    //   3084: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3087: astore 11
    //   3089: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3092: astore 13
    //   3094: new 161	java/lang/StringBuilder
    //   3097: dup
    //   3098: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3101: astore 16
    //   3103: aload 16
    //   3105: ldc_w 436
    //   3108: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3111: pop
    //   3112: aload 16
    //   3114: lload 6
    //   3116: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3119: pop
    //   3120: aload 16
    //   3122: aload 12
    //   3124: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: pop
    //   3128: aload 16
    //   3130: ldc_w 414
    //   3133: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3136: pop
    //   3137: aload 16
    //   3139: ldc_w 443
    //   3142: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: pop
    //   3146: aload 16
    //   3148: ldc_w 511
    //   3151: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3154: pop
    //   3155: aload 16
    //   3157: aload 14
    //   3159: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3162: pop
    //   3163: aload 16
    //   3165: ldc_w 447
    //   3168: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3171: pop
    //   3172: aload 16
    //   3174: ldc_w 443
    //   3177: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3180: pop
    //   3181: aload 16
    //   3183: iconst_2
    //   3184: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3187: pop
    //   3188: aload 16
    //   3190: aload 15
    //   3192: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3195: pop
    //   3196: aload 16
    //   3198: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3201: astore 16
    //   3203: aload 11
    //   3205: aload 13
    //   3207: iconst_5
    //   3208: anewarray 358	java/lang/String
    //   3211: dup
    //   3212: iconst_0
    //   3213: ldc_w 410
    //   3216: aastore
    //   3217: dup
    //   3218: iconst_1
    //   3219: ldc_w 412
    //   3222: aastore
    //   3223: dup
    //   3224: iconst_2
    //   3225: ldc_w 414
    //   3228: aastore
    //   3229: dup
    //   3230: iconst_3
    //   3231: aload 19
    //   3233: aastore
    //   3234: dup
    //   3235: iconst_4
    //   3236: ldc_w 447
    //   3239: aastore
    //   3240: aload 16
    //   3242: aconst_null
    //   3243: aconst_null
    //   3244: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   3247: astore 11
    //   3249: aload 11
    //   3251: invokeinterface 453 1 0
    //   3256: ifeq +188 -> 3444
    //   3259: aload 18
    //   3261: invokevirtual 473	android/content/ContentValues:clear	()V
    //   3264: aload 18
    //   3266: ldc_w 410
    //   3269: lload 6
    //   3271: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3274: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3277: aload 18
    //   3279: ldc_w 414
    //   3282: ldc_w 511
    //   3285: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3288: aload 18
    //   3290: aload 19
    //   3292: aload 17
    //   3294: getfield 509	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3297: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3300: aload 18
    //   3302: ldc_w 447
    //   3305: iconst_2
    //   3306: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3309: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3312: aload_0
    //   3313: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3316: astore 13
    //   3318: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3321: astore 16
    //   3323: new 161	java/lang/StringBuilder
    //   3326: dup
    //   3327: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3330: astore 17
    //   3332: aload 17
    //   3334: ldc_w 436
    //   3337: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3340: pop
    //   3341: aload 17
    //   3343: lload 6
    //   3345: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3348: pop
    //   3349: aload 17
    //   3351: aload 12
    //   3353: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3356: pop
    //   3357: aload 17
    //   3359: ldc_w 414
    //   3362: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3365: pop
    //   3366: aload 17
    //   3368: ldc_w 443
    //   3371: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3374: pop
    //   3375: aload 17
    //   3377: ldc_w 511
    //   3380: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3383: pop
    //   3384: aload 17
    //   3386: aload 14
    //   3388: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3391: pop
    //   3392: aload 17
    //   3394: ldc_w 447
    //   3397: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3400: pop
    //   3401: aload 17
    //   3403: ldc_w 443
    //   3406: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3409: pop
    //   3410: aload 17
    //   3412: iconst_2
    //   3413: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3416: pop
    //   3417: aload 17
    //   3419: aload 15
    //   3421: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: pop
    //   3425: aload 13
    //   3427: aload 16
    //   3429: aload 18
    //   3431: aload 17
    //   3433: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3436: aconst_null
    //   3437: invokevirtual 517	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3440: pop
    //   3441: goto +69 -> 3510
    //   3444: aload 18
    //   3446: invokevirtual 473	android/content/ContentValues:clear	()V
    //   3449: aload 18
    //   3451: ldc_w 410
    //   3454: lload 6
    //   3456: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3459: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3462: aload 18
    //   3464: ldc_w 414
    //   3467: ldc_w 511
    //   3470: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3473: aload 18
    //   3475: aload 19
    //   3477: aload 17
    //   3479: getfield 509	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3482: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3485: aload 18
    //   3487: ldc_w 447
    //   3490: iconst_2
    //   3491: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3494: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3497: aload_0
    //   3498: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3501: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3504: aload 18
    //   3506: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3509: pop
    //   3510: aload 11
    //   3512: ifnull +52 -> 3564
    //   3515: goto +39 -> 3554
    //   3518: goto +31 -> 3549
    //   3521: astore_1
    //   3522: goto +10 -> 3532
    //   3525: goto +24 -> 3549
    //   3528: astore_1
    //   3529: aconst_null
    //   3530: astore 11
    //   3532: aload 11
    //   3534: ifnull +10 -> 3544
    //   3537: aload 11
    //   3539: invokeinterface 454 1 0
    //   3544: aload_1
    //   3545: athrow
    //   3546: aconst_null
    //   3547: astore 11
    //   3549: aload 11
    //   3551: ifnull +13 -> 3564
    //   3554: aload 11
    //   3556: invokeinterface 454 1 0
    //   3561: goto +3 -> 3564
    //   3564: aload_0
    //   3565: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3568: astore 11
    //   3570: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3573: astore 13
    //   3575: new 161	java/lang/StringBuilder
    //   3578: dup
    //   3579: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3582: astore 16
    //   3584: aload 16
    //   3586: ldc_w 436
    //   3589: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: pop
    //   3593: aload 16
    //   3595: lload 6
    //   3597: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3600: pop
    //   3601: aload 16
    //   3603: aload 12
    //   3605: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3608: pop
    //   3609: aload 16
    //   3611: ldc_w 414
    //   3614: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3617: pop
    //   3618: aload 16
    //   3620: ldc_w 443
    //   3623: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3626: pop
    //   3627: aload 16
    //   3629: ldc_w 513
    //   3632: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3635: pop
    //   3636: aload 16
    //   3638: aload 14
    //   3640: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: pop
    //   3644: aload 16
    //   3646: ldc_w 447
    //   3649: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3652: pop
    //   3653: aload 16
    //   3655: ldc_w 443
    //   3658: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3661: pop
    //   3662: aload 16
    //   3664: iconst_2
    //   3665: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3668: pop
    //   3669: aload 16
    //   3671: aload 15
    //   3673: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3676: pop
    //   3677: aload 16
    //   3679: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3682: astore 16
    //   3684: aload 11
    //   3686: aload 13
    //   3688: iconst_5
    //   3689: anewarray 358	java/lang/String
    //   3692: dup
    //   3693: iconst_0
    //   3694: ldc_w 410
    //   3697: aastore
    //   3698: dup
    //   3699: iconst_1
    //   3700: ldc_w 412
    //   3703: aastore
    //   3704: dup
    //   3705: iconst_2
    //   3706: ldc_w 414
    //   3709: aastore
    //   3710: dup
    //   3711: iconst_3
    //   3712: aload 19
    //   3714: aastore
    //   3715: dup
    //   3716: iconst_4
    //   3717: ldc_w 447
    //   3720: aastore
    //   3721: aload 16
    //   3723: aconst_null
    //   3724: aconst_null
    //   3725: invokevirtual 422	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   3728: astore 11
    //   3730: aload 11
    //   3732: invokeinterface 453 1 0
    //   3737: ifeq +182 -> 3919
    //   3740: aload 18
    //   3742: invokevirtual 473	android/content/ContentValues:clear	()V
    //   3745: aload 18
    //   3747: ldc_w 410
    //   3750: lload 6
    //   3752: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3755: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3758: aload 18
    //   3760: ldc_w 414
    //   3763: ldc_w 513
    //   3766: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3769: aload 18
    //   3771: aload 19
    //   3773: aload_1
    //   3774: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3777: aload 18
    //   3779: ldc_w 447
    //   3782: iconst_2
    //   3783: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3786: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3789: aload_0
    //   3790: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3793: astore_1
    //   3794: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3797: astore 13
    //   3799: new 161	java/lang/StringBuilder
    //   3802: dup
    //   3803: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   3806: astore 16
    //   3808: aload 16
    //   3810: ldc_w 436
    //   3813: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3816: pop
    //   3817: aload 16
    //   3819: lload 6
    //   3821: invokevirtual 439	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3824: pop
    //   3825: aload 16
    //   3827: aload 12
    //   3829: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3832: pop
    //   3833: aload 16
    //   3835: ldc_w 414
    //   3838: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3841: pop
    //   3842: aload 16
    //   3844: ldc_w 443
    //   3847: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: pop
    //   3851: aload 16
    //   3853: ldc_w 513
    //   3856: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3859: pop
    //   3860: aload 16
    //   3862: aload 14
    //   3864: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: pop
    //   3868: aload 16
    //   3870: ldc_w 447
    //   3873: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3876: pop
    //   3877: aload 16
    //   3879: ldc_w 443
    //   3882: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3885: pop
    //   3886: aload 16
    //   3888: iconst_2
    //   3889: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3892: pop
    //   3893: aload 16
    //   3895: aload 15
    //   3897: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3900: pop
    //   3901: aload_1
    //   3902: aload 13
    //   3904: aload 18
    //   3906: aload 16
    //   3908: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3911: aconst_null
    //   3912: invokevirtual 517	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3915: pop
    //   3916: goto +65 -> 3981
    //   3919: aload 18
    //   3921: invokevirtual 473	android/content/ContentValues:clear	()V
    //   3924: aload 18
    //   3926: ldc_w 410
    //   3929: lload 6
    //   3931: invokestatic 476	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3934: invokevirtual 480	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3937: aload 18
    //   3939: ldc_w 414
    //   3942: ldc_w 513
    //   3945: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3948: aload 18
    //   3950: aload 19
    //   3952: aload_1
    //   3953: invokevirtual 485	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3956: aload 18
    //   3958: ldc_w 447
    //   3961: iconst_2
    //   3962: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3965: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3968: aload_0
    //   3969: invokevirtual 400	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3972: getstatic 406	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3975: aload 18
    //   3977: invokevirtual 464	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3980: pop
    //   3981: aload 11
    //   3983: ifnull +46 -> 4029
    //   3986: goto +36 -> 4022
    //   3989: astore_1
    //   3990: goto +10 -> 4000
    //   3993: goto +24 -> 4017
    //   3996: astore_1
    //   3997: aconst_null
    //   3998: astore 11
    //   4000: aload 11
    //   4002: ifnull +10 -> 4012
    //   4005: aload 11
    //   4007: invokeinterface 454 1 0
    //   4012: aload_1
    //   4013: athrow
    //   4014: aconst_null
    //   4015: astore 11
    //   4017: aload 11
    //   4019: ifnull +10 -> 4029
    //   4022: aload 11
    //   4024: invokeinterface 454 1 0
    //   4029: iconst_1
    //   4030: ireturn
    //   4031: iconst_m1
    //   4032: ireturn
    //   4033: iconst_m1
    //   4034: ireturn
    //   4035: astore 11
    //   4037: goto -3301 -> 736
    //   4040: astore 14
    //   4042: goto -3367 -> 675
    //   4045: astore 14
    //   4047: goto -3383 -> 664
    //   4050: astore 14
    //   4052: goto -3392 -> 660
    //   4055: astore 14
    //   4057: goto +154 -> 4211
    //   4060: astore 14
    //   4062: goto -3464 -> 598
    //   4065: astore 14
    //   4067: goto +144 -> 4211
    //   4070: astore 14
    //   4072: goto -3520 -> 552
    //   4075: astore 14
    //   4077: goto -3535 -> 542
    //   4080: astore 11
    //   4082: goto -3512 -> 570
    //   4085: astore 14
    //   4087: lload 6
    //   4089: lstore 8
    //   4091: goto -3425 -> 666
    //   4094: astore 11
    //   4096: goto -2125 -> 1971
    //   4099: astore 12
    //   4101: goto -2151 -> 1950
    //   4104: astore 12
    //   4106: goto -2163 -> 1943
    //   4109: astore 12
    //   4111: aload 11
    //   4113: astore 12
    //   4115: goto -1612 -> 2503
    //   4118: astore 11
    //   4120: goto -1643 -> 2477
    //   4123: astore 12
    //   4125: goto -1660 -> 2465
    //   4128: astore 12
    //   4130: goto +87 -> 4217
    //   4133: astore 12
    //   4135: goto +82 -> 4217
    //   4138: ldc_w 441
    //   4141: astore 12
    //   4143: astore 13
    //   4145: goto -1691 -> 2454
    //   4148: astore 12
    //   4150: goto -1097 -> 3053
    //   4153: astore 12
    //   4155: goto -1123 -> 3032
    //   4158: astore 12
    //   4160: goto -1131 -> 3029
    //   4163: astore 13
    //   4165: goto -1139 -> 3026
    //   4168: astore 13
    //   4170: goto -1144 -> 3026
    //   4173: astore 12
    //   4175: goto -1257 -> 2918
    //   4178: astore 12
    //   4180: goto -1269 -> 2911
    //   4183: astore 12
    //   4185: goto -1174 -> 3011
    //   4188: astore 11
    //   4190: goto -644 -> 3546
    //   4193: astore 13
    //   4195: goto -670 -> 3525
    //   4198: astore 13
    //   4200: goto -682 -> 3518
    //   4203: astore_1
    //   4204: goto -190 -> 4014
    //   4207: astore_1
    //   4208: goto -215 -> 3993
    //   4211: aconst_null
    //   4212: astore 18
    //   4214: goto -3589 -> 625
    //   4217: ldc_w 441
    //   4220: astore 12
    //   4222: aload 11
    //   4224: astore 13
    //   4226: goto -1720 -> 2506
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4229	0	this	ProfileCardMoreActivity
    //   0	4229	1	paramString	String
    //   239	598	2	m	int
    //   531	790	3	n	int
    //   236	578	4	i1	int
    //   689	113	5	i2	int
    //   271	3817	6	l1	long
    //   139	3951	8	l2	long
    //   256	261	10	bool	boolean
    //   37	3986	11	localObject1	Object
    //   4035	1	11	localException1	Exception
    //   4080	1	11	localException2	Exception
    //   4094	18	11	localException3	Exception
    //   4118	1	11	localException4	Exception
    //   4188	35	11	localException5	Exception
    //   3	3825	12	localObject2	Object
    //   4099	1	12	localException6	Exception
    //   4104	1	12	localException7	Exception
    //   4109	1	12	localException8	Exception
    //   4113	1	12	localObject3	Object
    //   4123	1	12	localException9	Exception
    //   4128	1	12	localException10	Exception
    //   4133	1	12	localException11	Exception
    //   4141	1	12	str1	String
    //   4148	1	12	localException12	Exception
    //   4153	1	12	localException13	Exception
    //   4158	1	12	localException14	Exception
    //   4173	1	12	localException15	Exception
    //   4178	1	12	localException16	Exception
    //   4183	1	12	localException17	Exception
    //   4220	1	12	str2	String
    //   150	3753	13	localObject4	Object
    //   4143	1	13	localException18	Exception
    //   4163	1	13	localException19	Exception
    //   4168	1	13	localException20	Exception
    //   4193	1	13	localException21	Exception
    //   4198	1	13	localException22	Exception
    //   4224	1	13	localException23	Exception
    //   8	435	14	localObject5	Object
    //   535	1	14	localObject6	Object
    //   547	30	14	localObject7	Object
    //   588	1	14	localObject8	Object
    //   593	1	14	localObject9	Object
    //   601	22	14	localObject10	Object
    //   693	3170	14	localObject11	Object
    //   4040	1	14	localException24	Exception
    //   4045	1	14	localException25	Exception
    //   4050	1	14	localException26	Exception
    //   4055	1	14	localException27	Exception
    //   4060	1	14	localException28	Exception
    //   4065	1	14	localException29	Exception
    //   4070	1	14	localException30	Exception
    //   4075	1	14	localException31	Exception
    //   4085	1	14	localException32	Exception
    //   159	3737	15	localObject12	Object
    //   99	3808	16	localObject13	Object
    //   56	3422	17	localObject14	Object
    //   289	3924	18	localObject15	Object
    //   294	3657	19	localObject16	Object
    //   303	2590	20	localObject17	Object
    //   2784	111	21	localUri	android.net.Uri
    //   2797	102	22	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   521	528	535	finally
    //   507	516	547	finally
    //   440	502	588	finally
    //   366	436	593	finally
    //   285	358	601	finally
    //   249	258	671	finally
    //   263	273	671	finally
    //   273	280	671	finally
    //   560	567	671	finally
    //   613	620	671	finally
    //   622	625	671	finally
    //   632	639	671	finally
    //   141	235	718	finally
    //   1684	1799	1946	finally
    //   1799	1865	1946	finally
    //   1868	1935	1946	finally
    //   1516	1684	1953	finally
    //   2236	2289	2450	finally
    //   2289	2355	2450	finally
    //   2358	2425	2450	finally
    //   2170	2203	2461	finally
    //   2203	2236	2461	finally
    //   2002	2039	2485	finally
    //   2039	2170	2485	finally
    //   2790	2851	3003	finally
    //   2851	2877	3003	finally
    //   2877	2908	3003	finally
    //   2929	2995	3003	finally
    //   2712	2786	3018	finally
    //   2542	2579	3035	finally
    //   2583	2644	3035	finally
    //   2644	2712	3035	finally
    //   3249	3375	3521	finally
    //   3375	3441	3521	finally
    //   3444	3510	3521	finally
    //   3083	3249	3528	finally
    //   3730	3916	3989	finally
    //   3919	3981	3989	finally
    //   3564	3730	3996	finally
    //   141	235	4035	java/lang/Exception
    //   249	258	4040	java/lang/Exception
    //   263	273	4045	java/lang/Exception
    //   273	280	4050	java/lang/Exception
    //   285	358	4055	java/lang/Exception
    //   366	436	4060	java/lang/Exception
    //   440	502	4065	java/lang/Exception
    //   507	516	4070	java/lang/Exception
    //   521	528	4075	java/lang/Exception
    //   560	567	4080	java/lang/Exception
    //   613	620	4085	java/lang/Exception
    //   622	625	4085	java/lang/Exception
    //   632	639	4085	java/lang/Exception
    //   1516	1684	4094	java/lang/Exception
    //   1684	1799	4099	java/lang/Exception
    //   1799	1865	4104	java/lang/Exception
    //   1868	1935	4104	java/lang/Exception
    //   2002	2039	4109	java/lang/Exception
    //   2039	2170	4118	java/lang/Exception
    //   2170	2203	4123	java/lang/Exception
    //   2203	2236	4128	java/lang/Exception
    //   2236	2289	4133	java/lang/Exception
    //   2289	2355	4138	java/lang/Exception
    //   2358	2425	4138	java/lang/Exception
    //   2542	2579	4148	java/lang/Exception
    //   2583	2644	4153	java/lang/Exception
    //   2644	2712	4158	java/lang/Exception
    //   2712	2786	4163	java/lang/Exception
    //   2790	2851	4168	java/lang/Exception
    //   2851	2877	4173	java/lang/Exception
    //   2877	2908	4178	java/lang/Exception
    //   2929	2995	4183	java/lang/Exception
    //   3083	3249	4188	java/lang/Exception
    //   3249	3375	4193	java/lang/Exception
    //   3375	3441	4198	java/lang/Exception
    //   3444	3510	4198	java/lang/Exception
    //   3564	3730	4203	java/lang/Exception
    //   3730	3916	4207	java/lang/Exception
    //   3919	3981	4207	java/lang/Exception
  }
  
  protected ProfileContactInfo a()
  {
    AllInOne localAllInOne = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne;
    if ((localAllInOne != null) && (localAllInOne.contactArray != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.contactArray.size() > 0)) {
      return (ProfileContactInfo)this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.contactArray.get(0);
    }
    return null;
  }
  
  String a()
  {
    try
    {
      String str = ContactUtils.b(this.app, this.jdField_a_of_type_JavaLangString);
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
      }
    }
    return null;
  }
  
  void a()
  {
    setContentViewB(2131561335);
    if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString)) {
      setTitle(HardCodeUtil.a(2131708439));
    } else {
      setTitle(2131695128);
    }
    Object localObject1 = this.mLeftBackText;
    Object localObject2 = "";
    if (localObject1 != null)
    {
      this.mLeftBackText.setText("");
      this.mLeftBackText.setContentDescription(HardCodeUtil.a(2131708449));
    }
    enableRightHighlight(false);
    localObject1 = findViewById(2131365495);
    if (this.jdField_a_of_type_ArrayOfInt[14] == 1)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
    }
    else
    {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = findViewById(2131377938);
    if (this.jdField_a_of_type_ArrayOfInt[15] == 1)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
    }
    else
    {
      ((View)localObject1).setVisibility(8);
    }
    int i5 = -1;
    int m = 0;
    int n = -1;
    int i3;
    int i4;
    int i1;
    for (int i2 = -1; m <= 3; i2 = i4)
    {
      i3 = n;
      i4 = i2;
      if (this.jdField_a_of_type_ArrayOfInt[m] == 1)
      {
        i1 = n;
        if (n < 0) {
          i1 = m;
        }
        i3 = i1;
        i4 = i2;
        if (i2 < m)
        {
          i4 = m;
          i3 = i1;
        }
      }
      m += 1;
      n = i3;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131369155));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376391));
    a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout, n, i2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369005));
    a(1, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369168));
    a(2, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368997));
    a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369116));
    a(4, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
    if (this.app.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin)) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(HardCodeUtil.a(2131708472));
    } else if (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(HardCodeUtil.a(2131708461));
    }
    this.i = ((FormSimpleItem)findViewById(2131369000));
    this.j = ((FormSimpleItem)findViewById(2131369012));
    a(16, this.i, 16, 17);
    a(17, this.j, 16, 17);
    Object localObject3 = null;
    a(null);
    this.k = ((FormSimpleItem)findViewById(2131369112));
    a(18, this.k, 18, 18);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369115));
    a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 5, 5);
    m = 6;
    i2 = -1;
    n = i5;
    while (m <= 13)
    {
      i3 = n;
      i4 = i2;
      if (this.jdField_a_of_type_ArrayOfInt[m] == 1)
      {
        i1 = n;
        if (n < 0) {
          i1 = m;
        }
        i3 = i1;
        i4 = i2;
        if (i2 < m)
        {
          i4 = m;
          i3 = i1;
        }
      }
      m += 1;
      n = i3;
      i2 = i4;
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377747));
    a(7, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369080));
    a(8, this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
      ReportController.b(null, "dc00898", "", "", "0X8009F70", "0X8009F70", 0, 0, "", "", "", "");
    }
    this.h = ((FormSimpleItem)findViewById(2131369079));
    a(9, this.h, n, i2);
    if (this.h.getVisibility() == 0) {
      FriendClueReporter.a(2);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377284));
    a(11, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, i2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377287));
    a(10, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, i2);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371568));
    a(12, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, i2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377290));
    a(13, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, i2);
    if (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager == null) {
        localObject1 = null;
      } else {
        localObject1 = localFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      }
      Object localObject4;
      if (localObject1 != null)
      {
        this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
        this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localObject4 = localFriendsManager.a(String.valueOf(((Friends)localObject1).groupid));
        if ((localObject4 != null) && (!Utils.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject4).group_name))) {
          this.jdField_c_of_type_JavaLangString = ((Groups)localObject4).group_name;
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
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          localObject1 = localObject2;
        } else {
          localObject1 = this.jdField_c_of_type_JavaLangString;
        }
        ((FormSimpleItem)localObject4).setRightText((CharSequence)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.post(new ProfileCardMoreActivity.2(this));
      }
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
      {
        if (localFriendsManager == null) {
          localObject1 = localObject3;
        } else {
          localObject1 = localFriendsManager.b(AppConstants.BABY_Q_UIN);
        }
        localObject2 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        boolean bool;
        if ((localObject1 != null) && (((Card)localObject1).babyQSwitch)) {
          bool = true;
        } else {
          bool = false;
        }
        ((FormSwitchItem)localObject2).setChecked(bool);
        localObject1 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
        if (localObject1 != null) {
          ((TempGetProfileDetailProcessor)localObject1).getBabyQSwitch();
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
      {
        if ((localFriendsManager != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin))) {
          this.jdField_a_of_type_Boolean = localFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
        } else {
          this.jdField_a_of_type_Boolean = false;
        }
        d();
      }
      if ((localFriendsManager != null) && (localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin))) {
        l();
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
    {
      this.jdField_a_of_type_Boolean = a();
      d();
    }
    if (AppSetting.d)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718769));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716891));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131695061));
      this.h.setContentDescription(getString(2131695052));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131708422));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690711));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131708432));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695147));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F));
  }
  
  void a(int paramInt1, RelativeLayout paramRelativeLayout, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (paramInt1 < arrayOfInt.length)
    {
      if (paramRelativeLayout == null) {
        return;
      }
      if (arrayOfInt[paramInt1] == 1)
      {
        paramRelativeLayout.setVisibility(0);
        paramRelativeLayout.setOnClickListener(this);
        if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
        {
          paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839433));
          return;
        }
        if (paramInt1 == paramInt2)
        {
          paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839449));
          return;
        }
        if (paramInt1 == paramInt3)
        {
          paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839440));
          return;
        }
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839443));
        return;
      }
      paramRelativeLayout.setVisibility(8);
    }
  }
  
  void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (paramInt1 < arrayOfInt.length)
    {
      if (paramFormSimpleItem == null) {
        return;
      }
      if (arrayOfInt[paramInt1] == 1)
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
  }
  
  void a(int paramInt1, FormSwitchItem paramFormSwitchItem, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (paramInt1 < arrayOfInt.length)
    {
      if (paramFormSwitchItem == null) {
        return;
      }
      if (arrayOfInt[paramInt1] == 1)
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
  }
  
  void a(TextView paramTextView, Drawable paramDrawable)
  {
    if (paramTextView != null)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
        return;
      }
      paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
    }
  }
  
  void a(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
    }
    if ((localObject != null) && (((Friends)localObject).remark != null) && (((Friends)localObject).isRemark == 1)) {
      localObject = ((Friends)localObject).remark;
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty(paramBusinessCard.picUrl)) {
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130845959));
    } else {
      a(this.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramBusinessCard.company))
    {
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("，");
      }
      localStringBuilder.append(paramBusinessCard.company);
    }
    List localList = paramBusinessCard.mobilesNum;
    int n = 0;
    int m;
    if ((localList != null) && (!paramBusinessCard.mobilesNum.isEmpty()))
    {
      m = 0;
      while (m < paramBusinessCard.mobilesNum.size())
      {
        if (localStringBuilder.length() != 0) {
          localStringBuilder.append("，");
        }
        localStringBuilder.append((String)paramBusinessCard.mobilesNum.get(m));
        m += 1;
      }
    }
    if ((paramBusinessCard.descs != null) && (!paramBusinessCard.descs.isEmpty()))
    {
      m = n;
      if (localStringBuilder.length() != 0)
      {
        localStringBuilder.append("，");
        m = n;
      }
      while (m < paramBusinessCard.descs.size())
      {
        localStringBuilder.append((String)paramBusinessCard.descs.get(m));
        m += 1;
      }
    }
    this.jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    b((String)localObject);
  }
  
  void a(Card paramCard)
  {
    FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
    if (localFriendProfilePhotoHelper != null) {
      localFriendProfilePhotoHelper.a(paramCard);
    }
  }
  
  void a(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(this);
    if (Utils.b(paramString))
    {
      localActionSheet.setMainTitle(2131690632);
    }
    else
    {
      Boolean localBoolean = this.jdField_a_of_type_JavaLangBoolean;
      if ((localBoolean != null) && (localBoolean.booleanValue())) {
        localActionSheet.setMainTitle(2131690634);
      } else {
        localActionSheet.setMainTitle(2131690633);
      }
    }
    localActionSheet.addButton(2131691488, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new ProfileCardMoreActivity.3(this, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1);
    int m;
    if (localObject1 != null) {
      m = ((Friends)localObject1).cSpecialFlag;
    } else {
      m = 17;
    }
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("&cspecialflag=");
    ((StringBuilder)localObject1).append(m);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=");
    ((StringBuilder)localObject3).append(paramString1);
    ((StringBuilder)localObject3).append("&version=1&cspecialflag=");
    ((StringBuilder)localObject3).append(m);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("https://share.mp.qq.com/cgi/share.php?uin=");
    ((StringBuilder)localObject4).append(paramString1);
    ((StringBuilder)localObject4).append("&account_flag=");
    ((StringBuilder)localObject4).append(-7);
    ((StringBuilder)localObject4).append("&jumptype=1&card_type=crm&cspecialflag=");
    ((StringBuilder)localObject4).append(m);
    String str = ((StringBuilder)localObject4).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
    ((StringBuilder)localObject4).append(paramString1);
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject2 = ((AbsShareMsg.Builder)localObject2).c(14).a(2).a(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131708424));
    localStringBuilder.append(paramString2);
    localObject1 = ((AbsShareMsg.Builder)localObject2).a(localStringBuilder.toString()).a("plugin", str, "", (String)localObject1, (String)localObject3).d(getResources().getString(2131718140)).a();
    localObject2 = new StructMsgItemLayout2();
    ((AbsStructMsgItem)localObject2).b(1);
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover((String)localObject4));
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
    paramString2 = new StringBuilder();
    paramString2.append(HardCodeUtil.a(2131708421));
    paramString2.append(QidianManager.b(this.app, paramString1));
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(paramString2.toString()));
    ((AbsShareMsg)localObject1).addItem(a(HardCodeUtil.a(2131708469)));
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    ForwardBaseOption.a(this, paramString2, 21);
  }
  
  void a(boolean paramBoolean)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      int n = 0;
      Object localObject2 = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      int m = n;
      if (localObject2 != null) {
        try
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin;
          if (ProfilePAUtils.isPaTypeStrangerInContact(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
            localObject1 = a();
          }
          long l = Long.parseLong((String)localObject1);
          localObject1 = new ArrayList();
          ((List)localObject1).add(Long.valueOf(l));
          m = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne);
          if (paramBoolean) {
            ((ShieldMsgManger)localObject2).b(m, (List)localObject1);
          } else {
            ((ShieldMsgManger)localObject2).a(m, (List)localObject1);
          }
          m = 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          m = n;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("shieldMsg() ");
            ((StringBuilder)localObject2).append(localNumberFormatException.toString());
            QLog.e("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject2).toString());
            m = n;
          }
        }
      }
      n = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa;
      if ((n != 41) && (n != 42) && (n != 86))
      {
        n = m;
      }
      else
      {
        n = m;
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin != null)
        {
          n = m;
          if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin.length() > 0)
          {
            if (paramBoolean) {
              this.app.getMsgHandler().d(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
            } else {
              this.app.getMsgHandler().c(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
            }
            n = 1;
          }
        }
      }
      if (n != 0)
      {
        this.jdField_a_of_type_Boolean = (paramBoolean ^ true);
        this.jdField_a_of_type_Int |= 0x2;
        e();
        return;
      }
      if (paramBoolean) {
        notifyUser(2131719046, 1);
      } else {
        notifyUser(2131719048, 1);
      }
      d();
      return;
    }
    notifyUser(2131692183, 1);
    d();
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    f();
    if ((this.jdField_a_of_type_Int & 0x2) == 2) {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          notifyUser(2131719047, 2);
        } else {
          notifyUser(2131719059, 2);
        }
      }
      else if (paramBoolean2) {
        notifyUser(2131719046, 1);
      } else {
        notifyUser(2131719048, 1);
      }
    }
    this.jdField_a_of_type_Int &= 0xFFFFFFFD;
    if (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localFriendsManager != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin))) {
        this.jdField_a_of_type_Boolean = localFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      } else {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = a();
    }
    d();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
    if (localFriendProfilePhotoHelper != null) {
      localFriendProfilePhotoHelper.a(paramArrayOfByte);
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
    int m = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa;
    ShieldMsgManger localShieldMsgManger = null;
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1;
    if ((m != 41) && (m != 42) && (m != 86))
    {
      localShieldMsgManger = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      bool1 = bool2;
      if (localShieldMsgManger != null)
      {
        if (ProfilePAUtils.isPaTypeHasUin(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin;
        } else if (ProfilePAUtils.isPaTypeStrangerInContact(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
          localObject = a();
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          return localShieldMsgManger.a((String)localObject);
        }
      }
    }
    else
    {
      localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        localObject = localShieldMsgManger;
      } else {
        localObject = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      }
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((Friends)localObject).groupid == -1002) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    Object localObject;
    if (this.app.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin))
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[1] = 1;
      localObject[16] = 1;
      localObject[17] = 1;
      localObject[18] = 1;
    }
    else if (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne))
    {
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin))
      {
        localObject = this.jdField_a_of_type_ArrayOfInt;
        localObject[2] = 1;
        localObject[12] = 1;
        localObject[14] = 1;
      }
      else
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        if ((!BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin)) && (!QidianManager.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin))) {
          m = 0;
        } else {
          m = 1;
        }
        if (m != 0) {
          if (((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin)) {
            this.jdField_a_of_type_ArrayOfInt[3] = 0;
          } else {
            this.jdField_a_of_type_ArrayOfInt[3] = 1;
          }
        }
        localObject = this.jdField_a_of_type_ArrayOfInt;
        localObject[4] = 1;
        if (m == 0)
        {
          localObject[5] = 1;
          localObject[11] = 1;
        }
        localObject = this.jdField_a_of_type_ArrayOfInt;
        localObject[6] = 1;
        localObject[7] = 1;
        if (FriendIntimateRelationshipHelper.a(this.app.getCurrentUin())) {
          this.jdField_a_of_type_ArrayOfInt[8] = 1;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper;
        if (FriendClueConfigHelper.a()) {
          this.jdField_a_of_type_ArrayOfInt[9] = 1;
        }
        localObject = this.jdField_a_of_type_ArrayOfInt;
        localObject[10] = 1;
        localObject[13] = 1;
        localObject[14] = 1;
        localObject[15] = 1;
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 21) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 22) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 46) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 47) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 3) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 2) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 74))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 41) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 42) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 86) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 57) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 58))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 34))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 71) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 72) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa != 27))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa == 96)
            {
              localObject = this.jdField_a_of_type_ArrayOfInt;
              localObject[13] = 1;
              localObject[15] = 1;
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa == 78)
            {
              this.jdField_a_of_type_ArrayOfInt[15] = 1;
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa == 95)
            {
              this.jdField_a_of_type_ArrayOfInt[15] = 1;
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa == 117)
            {
              localObject = this.jdField_a_of_type_ArrayOfInt;
              localObject[13] = 1;
              localObject[15] = 1;
            }
            else if (ProfilePAUtils.isPaTypeShowAccount(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne))
            {
              this.jdField_a_of_type_ArrayOfInt[15] = 1;
            }
          }
          else
          {
            localObject = this.jdField_a_of_type_ArrayOfInt;
            localObject[13] = 1;
            localObject[15] = 1;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ArrayOfInt;
          localObject[13] = 1;
          localObject[15] = 1;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ArrayOfInt;
        localObject[13] = 1;
        localObject[15] = 1;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[13] = 1;
      localObject[15] = 1;
    }
    if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString)) {
      this.jdField_a_of_type_ArrayOfInt[4] = 0;
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(SharePreferenceUtils.a(this, "bc_remark_first"))) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
    if (localObject != null)
    {
      if (((FormItemRelativeLayout)localObject).getVisibility() == 8) {
        return;
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366000));
      }
      if (paramInt1 < 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = AIOUtils.b(10.0F, getResources());
      }
      int m = paramInt2;
      if (paramInt2 < 0) {
        m = 0;
      }
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt1, m, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      SharePreferenceUtils.a(this, "bc_remark_first", "false");
    }
  }
  
  void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    boolean bool = TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString);
    paramString = "";
    TextView localTextView;
    if (!bool)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(this.jdField_f_of_type_JavaLangString);
        paramString = paramString.toString();
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(this.jdField_b_of_type_JavaLangString);
        paramString.append("，");
        paramString.append(this.jdField_f_of_type_JavaLangString);
        paramString = paramString.toString();
      }
      localTextView.setText(paramString);
    }
    else
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        paramString = this.jdField_b_of_type_JavaLangString;
      }
      localTextView.setText(paramString);
    }
    if (this.jdField_a_of_type_AndroidContentIntent == null) {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_b_of_type_JavaLangString);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  void c()
  {
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
    }
    if (localObject != null) {
      startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      return;
    }
    if ((ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) && (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin)))
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, resultCode : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode : ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", data : ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 == -1)
    {
      localObject = null;
      if (paramInt1 != 21)
      {
        if (paramInt1 != 1003)
        {
          if (paramInt1 != 1008)
          {
            if (paramInt1 != 1024) {
              return;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
            if (localObject != null) {
              ((FriendProfilePhotoHelper)localObject).a(paramInt2, paramIntent);
            }
          }
          else if (paramIntent != null)
          {
            a(paramInt2, paramIntent);
          }
        }
        else
        {
          boolean bool;
          if (paramIntent != null)
          {
            localObject = paramIntent.getStringExtra("result");
            bool = paramIntent.getBooleanExtra("hasChange", false);
            paramIntent = (Intent)localObject;
          }
          else
          {
            bool = false;
            paramIntent = (Intent)localObject;
          }
          localObject = paramIntent;
          if (paramIntent == null) {
            localObject = "";
          }
          if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            if ((!bool) && (((String)localObject).equals(this.jdField_e_of_type_JavaLangString))) {
              return;
            }
            if (!((String)localObject).equals(this.jdField_b_of_type_JavaLangString))
            {
              paramIntent = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
              if (paramIntent != null)
              {
                paramIntent.setFriendComment(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, (String)localObject, false);
                this.jdField_a_of_type_Int |= 0x1;
                b((String)localObject);
                QZoneHelper.restartQzone();
                return;
              }
              notifyUser(2131693362, 1);
              return;
            }
            notifyUser(2131693348, 0);
            return;
          }
          notifyUser(2131694473, 1);
        }
      }
      else
      {
        paramIntent.putExtra("selfSet_leftViewText", getString(2131719442));
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne = ((AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("from");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_nick_name");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne;
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.uin)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, String.format("check params [%s, %s, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa), this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.reportExtra }));
      }
      this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper = new FriendClueConfigHelper(this.app);
    }
    try
    {
      b();
      a();
    }
    catch (NoSuchFieldError paramBundle)
    {
      label171:
      break label171;
    }
    super.finish();
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper = new FriendProfilePhotoHelper(this, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.jdField_a_of_type_Int = getIntent().getIntExtra("coverTimeStamp", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("coverUrl");
    this.jdField_b_of_type_ComTencentMobileqqProfilecardDataAllInOne = ((AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if (this.jdField_b_of_type_ComTencentMobileqqProfilecardDataAllInOne == null) {
      this.jdField_b_of_type_ComTencentMobileqqProfilecardDataAllInOne = new AllInOne(this.app.getCurrentUin(), 0);
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
    if ((this.jdField_d_of_type_JavaLangString == null) || (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne))) {
      ThreadManager.excute(new ProfileCardMoreActivity.1(this), 16, null, true);
    }
    SpecialCareUtils.a(this.app);
    return true;
    super.finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
    if (localFriendProfilePhotoHelper != null)
    {
      localFriendProfilePhotoHelper.a();
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
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
      if (localFriendProfilePhotoHelper != null) {
        localFriendProfilePhotoHelper.a(paramIntent, localArrayList);
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718660));
      } else {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718659));
      }
    }
    j();
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void f()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
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
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.jdField_b_of_type_JavaLangBoolean.booleanValue()) {
      localIntent.putExtra("param_switches_changed", true);
    }
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject != null) {
      localIntent.putExtra("result", (Bundle)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
    if ((localObject != null) && (((FriendProfilePhotoHelper)localObject).jdField_a_of_type_Boolean))
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
    Object localObject = super.getClassLoader();
    ClassLoader localClassLoader2 = this.jdField_a_of_type_JavaLangClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.jdField_a_of_type_JavaLangClassLoader = localClassLoader1;
      localObject = localClassLoader1;
    }
    return localObject;
  }
  
  protected void h()
  {
    Object localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject3 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
    }
    if ((localObject1 != null) && (((Card)localObject1).strReMark != null) && (((Card)localObject1).strReMark.length() > 0)) {
      localObject1 = ((Card)localObject1).strReMark;
    } else {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() > 0) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa == 30)
      {
        localObject2 = a();
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((ProfileContactInfo)localObject2).phoneName;
        }
        localObject2 = localObject1;
      }
    }
    this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initRemark, ");
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
      QLog.i("IphoneTitleBarActivity", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void i()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.troopCode;
    Object localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.discussUin;
    }
    String str;
    if (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
      str = "1";
    } else {
      str = "0";
    }
    Object localObject2 = null;
    localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.reportExtra != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.reportExtra.containsKey("chatuin"))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.reportExtra.containsKey("chattype")) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.reportExtra;
        }
      }
    }
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa == 96)
    {
      m = 20005;
    }
    else if (ProfilePAUtils.isFromTroopMemberCard(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.troopCode, 1);
      }
      localObject1 = localObject2;
      m = 20008;
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa == 117)
    {
      m = 25028;
    }
    else if (ProfilePAUtils.isFromDiscussion(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.discussUin, 3000);
      }
      localObject1 = localObject2;
      m = 20013;
    }
    else if (localObject1 != null)
    {
      if (((Bundle)localObject1).containsKey("chattype")) {
        m = NewReportPlugin.a(((Bundle)localObject1).getInt("chattype"));
      } else if (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)) {
        m = 21000;
      } else {
        m = 20002;
      }
    }
    else if (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne))
    {
      m = 21001;
    }
    else
    {
      m = 20001;
    }
    if ((m != 20005) && (m != 20015) && (m != 25020)) {
      NewReportPlugin.a(this, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, null, str, (String)localObject3, this.app.getAccount(), m, null, (Bundle)localObject1);
    } else {
      NewReportPlugin.a(this, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, NewReportPlugin.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, NewReportPlugin.b(2)), str, null, this.app.getCurrentAccountUin(), m, null, (Bundle)localObject1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.pa), Integer.valueOf(m), str, localObject3, localObject1 }));
    }
    ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)), "", "", "");
  }
  
  public void notifyUser(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a(getTitleBarHeight()).show();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int m;
    if (paramView == null) {
      m = 0;
    } else {
      m = paramView.getId();
    }
    Object localObject4;
    Object localObject1;
    Object localObject2;
    switch (m)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "case default do nothing");
      }
      break;
    case 2131377938: 
      i();
      break;
    case 2131377747: 
      SpecialCareUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, 3);
      ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
      break;
    case 2131369155: 
      ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne);
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)), "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
      break;
    case 2131369116: 
      if (((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.nickname)) {
          this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.nickname = ContactUtils.e(this.app, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
        }
        localObject4 = getIntent().getStringExtra("key_nick_name");
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.nickname;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, (String)localObject1, 14);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper == null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper = new ProfileCardShareHelper(this, this.app, 0, new ProfileCardMoreActivity.13(this));
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.nickname)) {
          this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.nickname = ContactUtils.e(this.app, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.nickname);
      }
      ReportController.b(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
      break;
    case 2131369115: 
      try
      {
        localObject1 = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject1).qzone_uin = this.app.getCurrentAccountUin();
        ((QZoneHelper.UserInfo)localObject1).nickname = this.app.getCurrentNickname();
        QZoneHelper.forwardToSinglePermissionSetting(this, (QZoneHelper.UserInfo)localObject1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin).longValue(), -1);
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)), "", "", "");
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.i("Q.profilecard.FrdProfileCard", 2, localException1.toString());
      break;
    case 2131369112: 
      k();
      ReportController.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
      break;
    case 2131369080: 
      ReportController.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
      localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      if (localObject2 != null) {
        if (IntimateUtil.a(((ExtensionInfo)localObject2).intimate_type))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
          PublicFragmentActivity.Launcher.a(this, (Intent)localObject2, PublicFragmentActivity.class, IntimateInfoFragment.class);
          if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarActivity", 2, "jumpIntimatePage");
          }
        }
        else
        {
          localObject2 = FriendIntimateRelationshipHelper.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("click item_friend_intimate url:");
            ((StringBuilder)localObject4).append((String)localObject2);
            QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject4).toString());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject2));
          }
        }
      }
      break;
    case 2131369079: 
      this.jdField_a_of_type_ComTencentMobileqqRelationxFriendclueFriendClueConfigHelper.a(this, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      FriendClueReporter.b(2);
      break;
    case 2131369012: 
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper;
      if (localObject2 != null)
      {
        if (((FriendProfilePhotoHelper)localObject2).jdField_a_of_type_Int == 0) {
          bool = true;
        }
        ((FriendProfilePhotoHelper)localObject2).a(bool);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
      break;
    case 2131369005: 
      c();
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)), "", "", "");
      break;
    case 2131369000: 
      localObject2 = new Intent(this, AvatarPendantActivity.class);
      ((Intent)localObject2).putExtra("AllInOne", this.jdField_b_of_type_ComTencentMobileqqProfilecardDataAllInOne);
      ((Intent)localObject2).putExtra("showActionSheet", true);
      startActivity((Intent)localObject2);
      ReportController.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
      break;
    case 2131368997: 
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (checkSelfPermission("android.permission.WRITE_CONTACTS") != 0) {
          requestPermissions(new ProfileCardMoreActivity.12(this, this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        } else {
          g();
        }
      }
      else {
        g();
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne == null) {
          break label1217;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin;
        a((String)localObject2);
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, localException2, new Object[0]);
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label1217:
      Object localObject3 = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */