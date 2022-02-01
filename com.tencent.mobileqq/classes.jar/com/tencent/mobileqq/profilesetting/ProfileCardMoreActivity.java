package com.tencent.mobileqq.profilesetting;

import Override;
import aabc;
import adkk;
import adkm;
import adxr;
import alfl;
import amov;
import amsu;
import amsw;
import amtj;
import amwl;
import anax;
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
import apgi;
import apgj;
import atky;
import atuh;
import avnk;
import awfp;
import awgq;
import awgt;
import aymj;
import azap;
import azaq;
import azar;
import azas;
import azat;
import azau;
import azav;
import azaw;
import azax;
import azay;
import azwn;
import bbko;
import bcef;
import bcgt;
import bcgw;
import bcgx;
import bciz;
import bcjp;
import bcla;
import bclv;
import bfrj;
import bftf;
import bhht;
import bily;
import bjnw;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.IntimateInfoFragment;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nns;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements adkm, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  public adkk a;
  amsu jdField_a_of_type_Amsu = new azaw(this);
  amwl jdField_a_of_type_Amwl = new azau(this);
  anax jdField_a_of_type_Anax = new azav(this);
  public Intent a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  apgi jdField_a_of_type_Apgi;
  apgj jdField_a_of_type_Apgj = new azax(this);
  atuh jdField_a_of_type_Atuh = new azap(this);
  private aymj jdField_a_of_type_Aymj;
  azwn jdField_a_of_type_Azwn;
  public bhht a;
  public ProfileActivity.AllInOne a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new azay(this);
  public BusinessCard a;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public FormSimpleItem a;
  public FormSwitchItem a;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new azas(this);
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ProfileActivity.AllInOne b;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  FormSimpleItem c;
  public FormSwitchItem c;
  public String c;
  FormSimpleItem d;
  public FormSwitchItem d;
  public String d;
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
  
  public ProfileCardMoreActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private static bcgx a(String paramString)
  {
    bcla localbcla = new bcla();
    localbcla.b(1);
    localbcla.a(paramString);
    return localbcla;
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692035, 1);
      d();
      return;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
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
            break label126;
          }
          if (paramBoolean) {
            break label121;
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
        label121:
        paramBoolean = false;
        continue;
        label126:
        if (paramBoolean) {
          a(2131718417, 1);
        }
        for (;;)
        {
          d();
          return;
          a(2131718419, 1);
        }
        int m = 0;
      }
    }
  }
  
  private void j()
  {
    boolean bool = false;
    Object localObject;
    awgq localawgq;
    int m;
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      localObject = "";
      localawgq = awfp.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
      if (localawgq == null) {
        break label218;
      }
      if (localawgq.a != 1L) {
        break label122;
      }
      localObject = getString(2131693134);
      m = localawgq.c;
      bool = localawgq.c();
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
          label103:
          if (!bool) {
            break label199;
          }
          ((Drawable)localObject).setAlpha(102);
        }
        for (;;)
        {
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
          return;
          label122:
          if (localawgq.a == 2L)
          {
            localObject = getString(2131693132);
            break;
          }
          if (localawgq.a == 3L)
          {
            localObject = getString(2131693133);
            break;
          }
          if (localawgq.a != 26L) {
            break;
          }
          localObject = getString(2131693135);
          break;
          localObject = ((Drawable)localObject).mutate();
          break label103;
          label199:
          ((Drawable)localObject).setAlpha(255);
        }
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      return;
      label218:
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
      if (AppSetting.c) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690604));
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
    //   5: invokevirtual 346	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 349	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 205	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   23: invokevirtual 359	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3439 -> 3469
    //   33: aload 11
    //   35: ldc_w 361
    //   38: aload_1
    //   39: invokevirtual 367	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   42: checkcast 361	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   45: astore 15
    //   47: aload 11
    //   49: ifnull +8 -> 57
    //   52: aload 11
    //   54: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   57: aload 15
    //   59: ifnonnull +5 -> 64
    //   62: iconst_m1
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 372	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   68: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +877 -> 948
    //   74: aload_0
    //   75: getfield 372	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: astore 12
    //   80: iconst_0
    //   81: istore_2
    //   82: iconst_0
    //   83: istore 4
    //   85: aconst_null
    //   86: astore 13
    //   88: aload_0
    //   89: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   92: astore 14
    //   94: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   97: astore 11
    //   99: new 154	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 390
    //   109: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 12
    //   114: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 392
    //   120: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 16
    //   128: aload 14
    //   130: aload 11
    //   132: iconst_4
    //   133: anewarray 343	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: ldc_w 394
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: ldc_w 396
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: ldc_w 398
    //   153: aastore
    //   154: dup
    //   155: iconst_3
    //   156: ldc_w 400
    //   159: aastore
    //   160: aload 16
    //   162: aconst_null
    //   163: aconst_null
    //   164: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   167: astore 11
    //   169: iconst_0
    //   170: istore_3
    //   171: lconst_0
    //   172: lstore 8
    //   174: iload 4
    //   176: istore_2
    //   177: aload 11
    //   179: ifnull +3277 -> 3456
    //   182: aload 11
    //   184: invokeinterface 411 1 0
    //   189: istore 10
    //   191: iload 10
    //   193: ifeq +3263 -> 3456
    //   196: aload 11
    //   198: iconst_0
    //   199: invokeinterface 415 2 0
    //   204: lstore 6
    //   206: iload_2
    //   207: istore 4
    //   209: aload 15
    //   211: getfield 418	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   214: astore 13
    //   216: aload 13
    //   218: ifnull +873 -> 1091
    //   221: aconst_null
    //   222: astore 14
    //   224: aload_0
    //   225: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   228: astore 16
    //   230: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   233: astore 17
    //   235: new 154	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 420
    //   245: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: lload 6
    //   250: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: ldc_w 425
    //   256: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 398
    //   262: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 427
    //   268: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 429
    //   274: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc_w 431
    //   280: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 400
    //   286: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 427
    //   292: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 15
    //   297: getfield 418	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   300: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc_w 431
    //   306: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 433
    //   312: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 427
    //   318: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iconst_2
    //   322: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: ldc_w 392
    //   328: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore 13
    //   336: aload 16
    //   338: aload 17
    //   340: iconst_5
    //   341: anewarray 343	java/lang/String
    //   344: dup
    //   345: iconst_0
    //   346: ldc_w 394
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: ldc_w 396
    //   355: aastore
    //   356: dup
    //   357: iconst_2
    //   358: ldc_w 398
    //   361: aastore
    //   362: dup
    //   363: iconst_3
    //   364: ldc_w 400
    //   367: aastore
    //   368: dup
    //   369: iconst_4
    //   370: ldc_w 433
    //   373: aastore
    //   374: aload 13
    //   376: aconst_null
    //   377: aconst_null
    //   378: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   381: astore 13
    //   383: aload 13
    //   385: ifnull +594 -> 979
    //   388: aload 13
    //   390: invokeinterface 439 1 0
    //   395: istore 10
    //   397: iload 10
    //   399: ifeq +580 -> 979
    //   402: iconst_1
    //   403: istore_3
    //   404: iconst_1
    //   405: istore_2
    //   406: aload 13
    //   408: invokeinterface 440 1 0
    //   413: iconst_0
    //   414: ifeq +3035 -> 3449
    //   417: new 442	java/lang/NullPointerException
    //   420: dup
    //   421: invokespecial 443	java/lang/NullPointerException:<init>	()V
    //   424: athrow
    //   425: iload_3
    //   426: istore 5
    //   428: lload 6
    //   430: lstore 8
    //   432: iload_2
    //   433: istore 4
    //   435: aload 11
    //   437: ifnull +2999 -> 3436
    //   440: aload 11
    //   442: invokeinterface 440 1 0
    //   447: iload_3
    //   448: ifne +669 -> 1117
    //   451: iconst_1
    //   452: istore_3
    //   453: iconst_0
    //   454: istore_2
    //   455: new 445	android/content/ContentValues
    //   458: dup
    //   459: invokespecial 446	android/content/ContentValues:<init>	()V
    //   462: astore 13
    //   464: iload_3
    //   465: iconst_1
    //   466: if_icmpne +669 -> 1135
    //   469: aload_0
    //   470: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   473: getstatic 449	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   476: aload 13
    //   478: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   481: invokestatic 459	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   484: lstore 6
    //   486: aload 12
    //   488: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   491: ifne +55 -> 546
    //   494: aload 13
    //   496: invokevirtual 462	android/content/ContentValues:clear	()V
    //   499: aload 13
    //   501: ldc_w 394
    //   504: lload 6
    //   506: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   512: aload 13
    //   514: ldc_w 398
    //   517: ldc_w 471
    //   520: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload 13
    //   525: ldc_w 400
    //   528: aload 12
    //   530: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   537: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   540: aload 13
    //   542: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   545: pop
    //   546: aload 15
    //   548: getfield 477	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   551: ifnonnull +11 -> 562
    //   554: aload 15
    //   556: getfield 480	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   559: ifnull +99 -> 658
    //   562: aload 13
    //   564: invokevirtual 462	android/content/ContentValues:clear	()V
    //   567: aload 13
    //   569: ldc_w 394
    //   572: lload 6
    //   574: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   577: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   580: aload 13
    //   582: ldc_w 398
    //   585: ldc_w 482
    //   588: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: aload 15
    //   593: getfield 480	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   596: ifnull +16 -> 612
    //   599: aload 13
    //   601: ldc_w 400
    //   604: aload 15
    //   606: getfield 480	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   609: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: aload 15
    //   614: getfield 477	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   617: ifnull +16 -> 633
    //   620: aload 13
    //   622: ldc_w 484
    //   625: aload 15
    //   627: getfield 477	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   630: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload 13
    //   635: ldc_w 433
    //   638: iconst_1
    //   639: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   645: aload_0
    //   646: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   649: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   652: aload 13
    //   654: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   657: pop
    //   658: aload 15
    //   660: getfield 418	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   663: ifnull +70 -> 733
    //   666: aload 13
    //   668: invokevirtual 462	android/content/ContentValues:clear	()V
    //   671: aload 13
    //   673: ldc_w 394
    //   676: lload 6
    //   678: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   681: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   684: aload 13
    //   686: ldc_w 398
    //   689: ldc_w 429
    //   692: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: aload 13
    //   697: ldc_w 400
    //   700: aload 15
    //   702: getfield 418	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   705: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload 13
    //   710: ldc_w 433
    //   713: iconst_2
    //   714: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   720: aload_0
    //   721: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   724: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   727: aload 13
    //   729: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   732: pop
    //   733: aload 15
    //   735: getfield 495	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   738: ifnull +70 -> 808
    //   741: aload 13
    //   743: invokevirtual 462	android/content/ContentValues:clear	()V
    //   746: aload 13
    //   748: ldc_w 394
    //   751: lload 6
    //   753: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   756: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   759: aload 13
    //   761: ldc_w 398
    //   764: ldc_w 429
    //   767: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: aload 13
    //   772: ldc_w 400
    //   775: aload 15
    //   777: getfield 495	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   780: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload 13
    //   785: ldc_w 433
    //   788: iconst_3
    //   789: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   795: aload_0
    //   796: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   799: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   802: aload 13
    //   804: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   807: pop
    //   808: aload 15
    //   810: getfield 498	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   813: ifnull +70 -> 883
    //   816: aload 13
    //   818: invokevirtual 462	android/content/ContentValues:clear	()V
    //   821: aload 13
    //   823: ldc_w 394
    //   826: lload 6
    //   828: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   831: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   834: aload 13
    //   836: ldc_w 398
    //   839: ldc_w 500
    //   842: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: aload 13
    //   847: ldc_w 400
    //   850: aload 15
    //   852: getfield 498	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   855: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload 13
    //   860: ldc_w 433
    //   863: iconst_2
    //   864: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   870: aload_0
    //   871: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   874: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   877: aload 13
    //   879: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   882: pop
    //   883: aload 13
    //   885: invokevirtual 462	android/content/ContentValues:clear	()V
    //   888: aload 13
    //   890: ldc_w 394
    //   893: lload 6
    //   895: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   898: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   901: aload 13
    //   903: ldc_w 398
    //   906: ldc_w 502
    //   909: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: aload 13
    //   914: ldc_w 400
    //   917: aload_1
    //   918: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   921: aload 13
    //   923: ldc_w 433
    //   926: iconst_2
    //   927: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   930: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   933: aload_0
    //   934: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   937: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   940: aload 13
    //   942: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   945: pop
    //   946: iconst_0
    //   947: ireturn
    //   948: aload 15
    //   950: getfield 505	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   953: ifnull +13 -> 966
    //   956: aload 15
    //   958: getfield 505	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   961: astore 12
    //   963: goto -883 -> 80
    //   966: aload_1
    //   967: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   970: ifne +2493 -> 3463
    //   973: aload_1
    //   974: astore 12
    //   976: goto -896 -> 80
    //   979: iconst_0
    //   980: istore_2
    //   981: iconst_0
    //   982: istore 4
    //   984: iload_2
    //   985: istore_3
    //   986: aload 13
    //   988: ifnull +2487 -> 3475
    //   991: iload 4
    //   993: istore_3
    //   994: aload 13
    //   996: invokeinterface 440 1 0
    //   1001: iload_2
    //   1002: istore_3
    //   1003: goto +2472 -> 3475
    //   1006: iload_2
    //   1007: istore_3
    //   1008: aload 13
    //   1010: ifnull +2465 -> 3475
    //   1013: iload_2
    //   1014: istore_3
    //   1015: aload 13
    //   1017: invokeinterface 440 1 0
    //   1022: iload_2
    //   1023: istore_3
    //   1024: goto +2451 -> 3475
    //   1027: astore 13
    //   1029: iload_3
    //   1030: istore_2
    //   1031: iconst_1
    //   1032: istore_3
    //   1033: iload_3
    //   1034: istore 5
    //   1036: lload 6
    //   1038: lstore 8
    //   1040: iload_2
    //   1041: istore 4
    //   1043: aload 11
    //   1045: ifnull +2391 -> 3436
    //   1048: aload 11
    //   1050: invokeinterface 440 1 0
    //   1055: goto -608 -> 447
    //   1058: astore 13
    //   1060: aload 14
    //   1062: ifnull +13 -> 1075
    //   1065: iload_2
    //   1066: istore 4
    //   1068: aload 14
    //   1070: invokeinterface 440 1 0
    //   1075: iload_2
    //   1076: istore 4
    //   1078: aload 13
    //   1080: athrow
    //   1081: astore 13
    //   1083: iconst_1
    //   1084: istore_3
    //   1085: iload 4
    //   1087: istore_2
    //   1088: goto -55 -> 1033
    //   1091: iconst_0
    //   1092: istore_2
    //   1093: iconst_1
    //   1094: istore_3
    //   1095: goto -670 -> 425
    //   1098: astore_1
    //   1099: aload 13
    //   1101: astore 11
    //   1103: aload 11
    //   1105: ifnull +10 -> 1115
    //   1108: aload 11
    //   1110: invokeinterface 440 1 0
    //   1115: aload_1
    //   1116: athrow
    //   1117: iload_2
    //   1118: ifne +10 -> 1128
    //   1121: iconst_1
    //   1122: istore_3
    //   1123: iconst_0
    //   1124: istore_2
    //   1125: goto -670 -> 455
    //   1128: iconst_1
    //   1129: istore_2
    //   1130: iconst_0
    //   1131: istore_3
    //   1132: goto -677 -> 455
    //   1135: iload_2
    //   1136: iconst_1
    //   1137: if_icmpne +2163 -> 3300
    //   1140: aload 15
    //   1142: getfield 418	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1145: ifnull +131 -> 1276
    //   1148: aload 13
    //   1150: invokevirtual 462	android/content/ContentValues:clear	()V
    //   1153: aload 13
    //   1155: ldc_w 398
    //   1158: ldc_w 429
    //   1161: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1164: aload 13
    //   1166: ldc_w 400
    //   1169: aload 15
    //   1171: getfield 418	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1174: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1177: aload 13
    //   1179: ldc_w 433
    //   1182: iconst_2
    //   1183: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1186: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1189: aload_0
    //   1190: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1193: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1196: aload 13
    //   1198: new 154	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1205: ldc_w 420
    //   1208: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: lload 6
    //   1213: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1216: ldc_w 425
    //   1219: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: ldc_w 398
    //   1225: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: ldc_w 427
    //   1231: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 429
    //   1237: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: ldc_w 431
    //   1243: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: ldc_w 433
    //   1249: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: ldc_w 427
    //   1255: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: iconst_2
    //   1259: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1262: ldc_w 392
    //   1265: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: aconst_null
    //   1272: invokevirtual 509	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1275: pop
    //   1276: aload 15
    //   1278: getfield 477	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1281: ifnull +293 -> 1574
    //   1284: aconst_null
    //   1285: astore 11
    //   1287: aload_0
    //   1288: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1291: astore 14
    //   1293: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1296: astore 12
    //   1298: new 154	java/lang/StringBuilder
    //   1301: dup
    //   1302: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1305: ldc_w 420
    //   1308: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: lload 6
    //   1313: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1316: ldc_w 425
    //   1319: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: ldc_w 398
    //   1325: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: ldc_w 427
    //   1331: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: ldc_w 482
    //   1337: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: ldc_w 431
    //   1343: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: ldc_w 433
    //   1349: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: ldc_w 427
    //   1355: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: iconst_1
    //   1359: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1362: ldc_w 392
    //   1365: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: astore 16
    //   1373: aload 14
    //   1375: aload 12
    //   1377: iconst_5
    //   1378: anewarray 343	java/lang/String
    //   1381: dup
    //   1382: iconst_0
    //   1383: ldc_w 394
    //   1386: aastore
    //   1387: dup
    //   1388: iconst_1
    //   1389: ldc_w 396
    //   1392: aastore
    //   1393: dup
    //   1394: iconst_2
    //   1395: ldc_w 398
    //   1398: aastore
    //   1399: dup
    //   1400: iconst_3
    //   1401: ldc_w 484
    //   1404: aastore
    //   1405: dup
    //   1406: iconst_4
    //   1407: ldc_w 433
    //   1410: aastore
    //   1411: aload 16
    //   1413: aconst_null
    //   1414: aconst_null
    //   1415: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1418: astore 12
    //   1420: aload 12
    //   1422: astore 11
    //   1424: aload 11
    //   1426: invokeinterface 439 1 0
    //   1431: ifeq +1364 -> 2795
    //   1434: aload 13
    //   1436: invokevirtual 462	android/content/ContentValues:clear	()V
    //   1439: aload 13
    //   1441: ldc_w 398
    //   1444: ldc_w 482
    //   1447: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1450: aload 13
    //   1452: ldc_w 484
    //   1455: aload 15
    //   1457: getfield 477	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1460: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1463: aload 13
    //   1465: ldc_w 433
    //   1468: iconst_1
    //   1469: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1472: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1475: aload_0
    //   1476: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1479: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1482: aload 13
    //   1484: new 154	java/lang/StringBuilder
    //   1487: dup
    //   1488: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1491: ldc_w 420
    //   1494: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: lload 6
    //   1499: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1502: ldc_w 425
    //   1505: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: ldc_w 398
    //   1511: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: ldc_w 427
    //   1517: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: ldc_w 482
    //   1523: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: ldc_w 431
    //   1529: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: ldc_w 433
    //   1535: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: ldc_w 427
    //   1541: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: iconst_1
    //   1545: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1548: ldc_w 392
    //   1551: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: aconst_null
    //   1558: invokevirtual 509	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1561: pop
    //   1562: aload 11
    //   1564: ifnull +10 -> 1574
    //   1567: aload 11
    //   1569: invokeinterface 440 1 0
    //   1574: aload 15
    //   1576: getfield 480	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1579: ifnull +293 -> 1872
    //   1582: aconst_null
    //   1583: astore 11
    //   1585: aload_0
    //   1586: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1589: astore 16
    //   1591: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1594: astore 14
    //   1596: new 154	java/lang/StringBuilder
    //   1599: dup
    //   1600: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1603: ldc_w 420
    //   1606: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: lload 6
    //   1611: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1614: ldc_w 425
    //   1617: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: ldc_w 398
    //   1623: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: ldc_w 427
    //   1629: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: ldc_w 482
    //   1635: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: ldc_w 431
    //   1641: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: ldc_w 433
    //   1647: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: ldc_w 427
    //   1653: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: iconst_1
    //   1657: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1660: ldc_w 392
    //   1663: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: astore 12
    //   1671: aload 16
    //   1673: aload 14
    //   1675: iconst_5
    //   1676: anewarray 343	java/lang/String
    //   1679: dup
    //   1680: iconst_0
    //   1681: ldc_w 394
    //   1684: aastore
    //   1685: dup
    //   1686: iconst_1
    //   1687: ldc_w 396
    //   1690: aastore
    //   1691: dup
    //   1692: iconst_2
    //   1693: ldc_w 398
    //   1696: aastore
    //   1697: dup
    //   1698: iconst_3
    //   1699: ldc_w 400
    //   1702: aastore
    //   1703: dup
    //   1704: iconst_4
    //   1705: ldc_w 433
    //   1708: aastore
    //   1709: aload 12
    //   1711: aconst_null
    //   1712: aconst_null
    //   1713: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1716: astore 12
    //   1718: aload 12
    //   1720: astore 11
    //   1722: aload 11
    //   1724: invokeinterface 439 1 0
    //   1729: ifeq +1168 -> 2897
    //   1732: aload 13
    //   1734: invokevirtual 462	android/content/ContentValues:clear	()V
    //   1737: aload 13
    //   1739: ldc_w 398
    //   1742: ldc_w 482
    //   1745: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1748: aload 13
    //   1750: ldc_w 400
    //   1753: aload 15
    //   1755: getfield 480	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1758: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1761: aload 13
    //   1763: ldc_w 433
    //   1766: iconst_1
    //   1767: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1770: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1773: aload_0
    //   1774: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1777: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1780: aload 13
    //   1782: new 154	java/lang/StringBuilder
    //   1785: dup
    //   1786: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1789: ldc_w 420
    //   1792: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: lload 6
    //   1797: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1800: ldc_w 425
    //   1803: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: ldc_w 398
    //   1809: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: ldc_w 427
    //   1815: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: ldc_w 482
    //   1821: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: ldc_w 431
    //   1827: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: ldc_w 433
    //   1833: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: ldc_w 427
    //   1839: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: iconst_1
    //   1843: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1846: ldc_w 392
    //   1849: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1855: aconst_null
    //   1856: invokevirtual 509	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1859: pop
    //   1860: aload 11
    //   1862: ifnull +10 -> 1872
    //   1865: aload 11
    //   1867: invokeinterface 440 1 0
    //   1872: aload 15
    //   1874: getfield 495	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1877: ifnull +306 -> 2183
    //   1880: aconst_null
    //   1881: astore 11
    //   1883: aload_0
    //   1884: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1887: astore 14
    //   1889: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1892: astore 16
    //   1894: new 154	java/lang/StringBuilder
    //   1897: dup
    //   1898: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1901: ldc_w 420
    //   1904: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: lload 6
    //   1909: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1912: ldc_w 425
    //   1915: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: ldc_w 398
    //   1921: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: ldc_w 427
    //   1927: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: ldc_w 429
    //   1933: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: ldc_w 431
    //   1939: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: ldc_w 433
    //   1945: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: ldc_w 427
    //   1951: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1954: iconst_3
    //   1955: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1958: ldc_w 392
    //   1961: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1967: astore 12
    //   1969: aload 14
    //   1971: aload 16
    //   1973: iconst_5
    //   1974: anewarray 343	java/lang/String
    //   1977: dup
    //   1978: iconst_0
    //   1979: ldc_w 394
    //   1982: aastore
    //   1983: dup
    //   1984: iconst_1
    //   1985: ldc_w 396
    //   1988: aastore
    //   1989: dup
    //   1990: iconst_2
    //   1991: ldc_w 398
    //   1994: aastore
    //   1995: dup
    //   1996: iconst_3
    //   1997: ldc_w 400
    //   2000: aastore
    //   2001: dup
    //   2002: iconst_4
    //   2003: ldc_w 433
    //   2006: aastore
    //   2007: aload 12
    //   2009: aconst_null
    //   2010: aconst_null
    //   2011: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2014: astore 12
    //   2016: aload 12
    //   2018: astore 11
    //   2020: aload 11
    //   2022: invokeinterface 439 1 0
    //   2027: ifeq +972 -> 2999
    //   2030: aload 13
    //   2032: invokevirtual 462	android/content/ContentValues:clear	()V
    //   2035: aload 13
    //   2037: ldc_w 394
    //   2040: lload 6
    //   2042: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2045: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2048: aload 13
    //   2050: ldc_w 398
    //   2053: ldc_w 429
    //   2056: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2059: aload 13
    //   2061: ldc_w 400
    //   2064: aload 15
    //   2066: getfield 495	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2069: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2072: aload 13
    //   2074: ldc_w 433
    //   2077: iconst_3
    //   2078: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2081: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2084: aload_0
    //   2085: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2088: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2091: aload 13
    //   2093: new 154	java/lang/StringBuilder
    //   2096: dup
    //   2097: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2100: ldc_w 420
    //   2103: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: lload 6
    //   2108: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2111: ldc_w 425
    //   2114: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2117: ldc_w 398
    //   2120: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: ldc_w 427
    //   2126: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: ldc_w 429
    //   2132: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: ldc_w 431
    //   2138: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2141: ldc_w 433
    //   2144: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2147: ldc_w 427
    //   2150: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2153: iconst_3
    //   2154: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2157: ldc_w 392
    //   2160: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2166: aconst_null
    //   2167: invokevirtual 509	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2170: pop
    //   2171: aload 11
    //   2173: ifnull +10 -> 2183
    //   2176: aload 11
    //   2178: invokeinterface 440 1 0
    //   2183: aload 15
    //   2185: getfield 498	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2188: ifnull +306 -> 2494
    //   2191: aconst_null
    //   2192: astore 11
    //   2194: aload_0
    //   2195: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2198: astore 16
    //   2200: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2203: astore 14
    //   2205: new 154	java/lang/StringBuilder
    //   2208: dup
    //   2209: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2212: ldc_w 420
    //   2215: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: lload 6
    //   2220: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2223: ldc_w 425
    //   2226: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: ldc_w 398
    //   2232: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: ldc_w 427
    //   2238: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: ldc_w 500
    //   2244: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2247: ldc_w 431
    //   2250: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: ldc_w 433
    //   2256: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2259: ldc_w 427
    //   2262: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: iconst_2
    //   2266: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2269: ldc_w 392
    //   2272: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2278: astore 12
    //   2280: aload 16
    //   2282: aload 14
    //   2284: iconst_5
    //   2285: anewarray 343	java/lang/String
    //   2288: dup
    //   2289: iconst_0
    //   2290: ldc_w 394
    //   2293: aastore
    //   2294: dup
    //   2295: iconst_1
    //   2296: ldc_w 396
    //   2299: aastore
    //   2300: dup
    //   2301: iconst_2
    //   2302: ldc_w 398
    //   2305: aastore
    //   2306: dup
    //   2307: iconst_3
    //   2308: ldc_w 400
    //   2311: aastore
    //   2312: dup
    //   2313: iconst_4
    //   2314: ldc_w 433
    //   2317: aastore
    //   2318: aload 12
    //   2320: aconst_null
    //   2321: aconst_null
    //   2322: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2325: astore 12
    //   2327: aload 12
    //   2329: astore 11
    //   2331: aload 11
    //   2333: invokeinterface 439 1 0
    //   2338: ifeq +763 -> 3101
    //   2341: aload 13
    //   2343: invokevirtual 462	android/content/ContentValues:clear	()V
    //   2346: aload 13
    //   2348: ldc_w 394
    //   2351: lload 6
    //   2353: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2356: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2359: aload 13
    //   2361: ldc_w 398
    //   2364: ldc_w 500
    //   2367: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2370: aload 13
    //   2372: ldc_w 400
    //   2375: aload 15
    //   2377: getfield 498	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2380: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2383: aload 13
    //   2385: ldc_w 433
    //   2388: iconst_2
    //   2389: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2392: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2395: aload_0
    //   2396: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2399: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2402: aload 13
    //   2404: new 154	java/lang/StringBuilder
    //   2407: dup
    //   2408: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2411: ldc_w 420
    //   2414: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2417: lload 6
    //   2419: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2422: ldc_w 425
    //   2425: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2428: ldc_w 398
    //   2431: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2434: ldc_w 427
    //   2437: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: ldc_w 500
    //   2443: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2446: ldc_w 431
    //   2449: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2452: ldc_w 433
    //   2455: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2458: ldc_w 427
    //   2461: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2464: iconst_2
    //   2465: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2468: ldc_w 392
    //   2471: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2477: aconst_null
    //   2478: invokevirtual 509	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2481: pop
    //   2482: aload 11
    //   2484: ifnull +10 -> 2494
    //   2487: aload 11
    //   2489: invokeinterface 440 1 0
    //   2494: aconst_null
    //   2495: astore 11
    //   2497: aload_0
    //   2498: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2501: astore 14
    //   2503: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2506: astore 12
    //   2508: new 154	java/lang/StringBuilder
    //   2511: dup
    //   2512: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2515: ldc_w 420
    //   2518: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: lload 6
    //   2523: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2526: ldc_w 425
    //   2529: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: ldc_w 398
    //   2535: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: ldc_w 427
    //   2541: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: ldc_w 502
    //   2547: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2550: ldc_w 431
    //   2553: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: ldc_w 433
    //   2559: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2562: ldc_w 427
    //   2565: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2568: iconst_2
    //   2569: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2572: ldc_w 392
    //   2575: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2578: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2581: astore 15
    //   2583: aload 14
    //   2585: aload 12
    //   2587: iconst_5
    //   2588: anewarray 343	java/lang/String
    //   2591: dup
    //   2592: iconst_0
    //   2593: ldc_w 394
    //   2596: aastore
    //   2597: dup
    //   2598: iconst_1
    //   2599: ldc_w 396
    //   2602: aastore
    //   2603: dup
    //   2604: iconst_2
    //   2605: ldc_w 398
    //   2608: aastore
    //   2609: dup
    //   2610: iconst_3
    //   2611: ldc_w 400
    //   2614: aastore
    //   2615: dup
    //   2616: iconst_4
    //   2617: ldc_w 433
    //   2620: aastore
    //   2621: aload 15
    //   2623: aconst_null
    //   2624: aconst_null
    //   2625: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2628: astore 12
    //   2630: aload 12
    //   2632: astore 11
    //   2634: aload 11
    //   2636: invokeinterface 439 1 0
    //   2641: ifeq +562 -> 3203
    //   2644: aload 13
    //   2646: invokevirtual 462	android/content/ContentValues:clear	()V
    //   2649: aload 13
    //   2651: ldc_w 394
    //   2654: lload 6
    //   2656: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2659: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2662: aload 13
    //   2664: ldc_w 398
    //   2667: ldc_w 502
    //   2670: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2673: aload 13
    //   2675: ldc_w 400
    //   2678: aload_1
    //   2679: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2682: aload 13
    //   2684: ldc_w 433
    //   2687: iconst_2
    //   2688: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2691: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2694: aload_0
    //   2695: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2698: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2701: aload 13
    //   2703: new 154	java/lang/StringBuilder
    //   2706: dup
    //   2707: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   2710: ldc_w 420
    //   2713: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2716: lload 6
    //   2718: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2721: ldc_w 425
    //   2724: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2727: ldc_w 398
    //   2730: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2733: ldc_w 427
    //   2736: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2739: ldc_w 502
    //   2742: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2745: ldc_w 431
    //   2748: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2751: ldc_w 433
    //   2754: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2757: ldc_w 427
    //   2760: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: iconst_2
    //   2764: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2767: ldc_w 392
    //   2770: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2773: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2776: aconst_null
    //   2777: invokevirtual 509	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2780: pop
    //   2781: aload 11
    //   2783: ifnull +10 -> 2793
    //   2786: aload 11
    //   2788: invokeinterface 440 1 0
    //   2793: iconst_1
    //   2794: ireturn
    //   2795: aload 13
    //   2797: invokevirtual 462	android/content/ContentValues:clear	()V
    //   2800: aload 13
    //   2802: ldc_w 394
    //   2805: lload 6
    //   2807: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2810: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2813: aload 13
    //   2815: ldc_w 398
    //   2818: ldc_w 482
    //   2821: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2824: aload 13
    //   2826: ldc_w 484
    //   2829: aload 15
    //   2831: getfield 477	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2834: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2837: aload 13
    //   2839: ldc_w 433
    //   2842: iconst_1
    //   2843: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2846: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2849: aload_0
    //   2850: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2853: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2856: aload 13
    //   2858: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2861: pop
    //   2862: goto -1300 -> 1562
    //   2865: astore 12
    //   2867: aload 11
    //   2869: ifnull -1295 -> 1574
    //   2872: aload 11
    //   2874: invokeinterface 440 1 0
    //   2879: goto -1305 -> 1574
    //   2882: astore_1
    //   2883: aload 11
    //   2885: ifnull +10 -> 2895
    //   2888: aload 11
    //   2890: invokeinterface 440 1 0
    //   2895: aload_1
    //   2896: athrow
    //   2897: aload 13
    //   2899: invokevirtual 462	android/content/ContentValues:clear	()V
    //   2902: aload 13
    //   2904: ldc_w 394
    //   2907: lload 6
    //   2909: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2912: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2915: aload 13
    //   2917: ldc_w 398
    //   2920: ldc_w 482
    //   2923: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2926: aload 13
    //   2928: ldc_w 400
    //   2931: aload 15
    //   2933: getfield 480	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2936: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2939: aload 13
    //   2941: ldc_w 433
    //   2944: iconst_1
    //   2945: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2948: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2951: aload_0
    //   2952: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2955: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2958: aload 13
    //   2960: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2963: pop
    //   2964: goto -1104 -> 1860
    //   2967: astore 12
    //   2969: aload 11
    //   2971: ifnull -1099 -> 1872
    //   2974: aload 11
    //   2976: invokeinterface 440 1 0
    //   2981: goto -1109 -> 1872
    //   2984: astore_1
    //   2985: aload 11
    //   2987: ifnull +10 -> 2997
    //   2990: aload 11
    //   2992: invokeinterface 440 1 0
    //   2997: aload_1
    //   2998: athrow
    //   2999: aload 13
    //   3001: invokevirtual 462	android/content/ContentValues:clear	()V
    //   3004: aload 13
    //   3006: ldc_w 394
    //   3009: lload 6
    //   3011: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3014: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3017: aload 13
    //   3019: ldc_w 398
    //   3022: ldc_w 429
    //   3025: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3028: aload 13
    //   3030: ldc_w 400
    //   3033: aload 15
    //   3035: getfield 495	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   3038: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3041: aload 13
    //   3043: ldc_w 433
    //   3046: iconst_3
    //   3047: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3050: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3053: aload_0
    //   3054: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3057: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3060: aload 13
    //   3062: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3065: pop
    //   3066: goto -895 -> 2171
    //   3069: astore 12
    //   3071: aload 11
    //   3073: ifnull -890 -> 2183
    //   3076: aload 11
    //   3078: invokeinterface 440 1 0
    //   3083: goto -900 -> 2183
    //   3086: astore_1
    //   3087: aload 11
    //   3089: ifnull +10 -> 3099
    //   3092: aload 11
    //   3094: invokeinterface 440 1 0
    //   3099: aload_1
    //   3100: athrow
    //   3101: aload 13
    //   3103: invokevirtual 462	android/content/ContentValues:clear	()V
    //   3106: aload 13
    //   3108: ldc_w 394
    //   3111: lload 6
    //   3113: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3116: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3119: aload 13
    //   3121: ldc_w 398
    //   3124: ldc_w 500
    //   3127: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3130: aload 13
    //   3132: ldc_w 400
    //   3135: aload 15
    //   3137: getfield 498	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3140: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3143: aload 13
    //   3145: ldc_w 433
    //   3148: iconst_2
    //   3149: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3152: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3155: aload_0
    //   3156: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3159: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3162: aload 13
    //   3164: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3167: pop
    //   3168: goto -686 -> 2482
    //   3171: astore 12
    //   3173: aload 11
    //   3175: ifnull -681 -> 2494
    //   3178: aload 11
    //   3180: invokeinterface 440 1 0
    //   3185: goto -691 -> 2494
    //   3188: astore_1
    //   3189: aload 11
    //   3191: ifnull +10 -> 3201
    //   3194: aload 11
    //   3196: invokeinterface 440 1 0
    //   3201: aload_1
    //   3202: athrow
    //   3203: aload 13
    //   3205: invokevirtual 462	android/content/ContentValues:clear	()V
    //   3208: aload 13
    //   3210: ldc_w 394
    //   3213: lload 6
    //   3215: invokestatic 465	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3218: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3221: aload 13
    //   3223: ldc_w 398
    //   3226: ldc_w 502
    //   3229: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3232: aload 13
    //   3234: ldc_w 400
    //   3237: aload_1
    //   3238: invokevirtual 474	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3241: aload 13
    //   3243: ldc_w 433
    //   3246: iconst_2
    //   3247: invokestatic 489	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3250: invokevirtual 492	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3253: aload_0
    //   3254: invokevirtual 382	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3257: getstatic 388	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3260: aload 13
    //   3262: invokevirtual 453	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3265: pop
    //   3266: goto -485 -> 2781
    //   3269: astore_1
    //   3270: aload 11
    //   3272: ifnull -479 -> 2793
    //   3275: aload 11
    //   3277: invokeinterface 440 1 0
    //   3282: goto -489 -> 2793
    //   3285: astore_1
    //   3286: aload 11
    //   3288: ifnull +10 -> 3298
    //   3291: aload 11
    //   3293: invokeinterface 440 1 0
    //   3298: aload_1
    //   3299: athrow
    //   3300: iconst_m1
    //   3301: ireturn
    //   3302: astore_1
    //   3303: goto -17 -> 3286
    //   3306: astore_1
    //   3307: aconst_null
    //   3308: astore 11
    //   3310: goto -40 -> 3270
    //   3313: astore_1
    //   3314: goto -125 -> 3189
    //   3317: astore 11
    //   3319: aconst_null
    //   3320: astore 11
    //   3322: goto -149 -> 3173
    //   3325: astore_1
    //   3326: goto -239 -> 3087
    //   3329: astore 11
    //   3331: aconst_null
    //   3332: astore 11
    //   3334: goto -263 -> 3071
    //   3337: astore_1
    //   3338: goto -353 -> 2985
    //   3341: astore 11
    //   3343: aconst_null
    //   3344: astore 11
    //   3346: goto -377 -> 2969
    //   3349: astore_1
    //   3350: goto -467 -> 2883
    //   3353: astore 11
    //   3355: aconst_null
    //   3356: astore 11
    //   3358: goto -491 -> 2867
    //   3361: astore_1
    //   3362: goto -2259 -> 1103
    //   3365: astore 11
    //   3367: aconst_null
    //   3368: astore 11
    //   3370: iconst_0
    //   3371: istore_3
    //   3372: lconst_0
    //   3373: lstore 6
    //   3375: goto -2342 -> 1033
    //   3378: astore 13
    //   3380: lload 8
    //   3382: lstore 6
    //   3384: goto -2351 -> 1033
    //   3387: astore 13
    //   3389: iconst_1
    //   3390: istore_3
    //   3391: lload 8
    //   3393: lstore 6
    //   3395: goto -2362 -> 1033
    //   3398: astore 16
    //   3400: aload 13
    //   3402: astore 14
    //   3404: aload 16
    //   3406: astore 13
    //   3408: goto -2348 -> 1060
    //   3411: astore 16
    //   3413: aload 13
    //   3415: astore 14
    //   3417: iconst_1
    //   3418: istore_2
    //   3419: aload 16
    //   3421: astore 13
    //   3423: goto -2363 -> 1060
    //   3426: astore 14
    //   3428: goto -2422 -> 1006
    //   3431: astore 14
    //   3433: goto -2427 -> 1006
    //   3436: lload 8
    //   3438: lstore 6
    //   3440: iload 5
    //   3442: istore_3
    //   3443: iload 4
    //   3445: istore_2
    //   3446: goto -2999 -> 447
    //   3449: iconst_1
    //   3450: istore_2
    //   3451: iconst_1
    //   3452: istore_3
    //   3453: goto -3028 -> 425
    //   3456: lload 8
    //   3458: lstore 6
    //   3460: goto -3035 -> 425
    //   3463: aconst_null
    //   3464: astore 12
    //   3466: goto -3386 -> 80
    //   3469: aconst_null
    //   3470: astore 15
    //   3472: goto -3425 -> 47
    //   3475: iload_3
    //   3476: istore_2
    //   3477: iconst_1
    //   3478: istore_3
    //   3479: lload 6
    //   3481: lstore 8
    //   3483: goto -3306 -> 177
    //   3486: astore 13
    //   3488: aconst_null
    //   3489: astore 13
    //   3491: goto -2485 -> 1006
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3494	0	this	ProfileCardMoreActivity
    //   0	3494	1	paramString	String
    //   81	3396	2	m	int
    //   170	3309	3	n	int
    //   83	3361	4	i1	int
    //   426	3015	5	i2	int
    //   204	3276	6	l1	long
    //   172	3310	8	l2	long
    //   189	209	10	bool	boolean
    //   26	3283	11	localObject1	Object
    //   3317	1	11	localException1	Exception
    //   3320	1	11	localObject2	Object
    //   3329	1	11	localException2	Exception
    //   3332	1	11	localObject3	Object
    //   3341	1	11	localException3	Exception
    //   3344	1	11	localObject4	Object
    //   3353	1	11	localException4	Exception
    //   3356	1	11	localObject5	Object
    //   3365	1	11	localException5	Exception
    //   3368	1	11	localObject6	Object
    //   78	2553	12	localObject7	Object
    //   2865	1	12	localException6	Exception
    //   2967	1	12	localException7	Exception
    //   3069	1	12	localException8	Exception
    //   3171	1	12	localException9	Exception
    //   3464	1	12	localObject8	Object
    //   86	930	13	localObject9	Object
    //   1027	1	13	localException10	Exception
    //   1058	21	13	localObject10	Object
    //   1081	2180	13	localException11	Exception
    //   3378	1	13	localException12	Exception
    //   3387	14	13	localException13	Exception
    //   3406	16	13	localObject11	Object
    //   3486	1	13	localException14	Exception
    //   3489	1	13	localObject12	Object
    //   92	3324	14	localObject13	Object
    //   3426	1	14	localException15	Exception
    //   3431	1	14	localException16	Exception
    //   45	3426	15	localObject14	Object
    //   126	2155	16	localObject15	Object
    //   3398	7	16	localObject16	Object
    //   3411	9	16	localObject17	Object
    //   233	106	17	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   417	425	1027	java/lang/Exception
    //   994	1001	1027	java/lang/Exception
    //   1015	1022	1027	java/lang/Exception
    //   224	383	1058	finally
    //   209	216	1081	java/lang/Exception
    //   1068	1075	1081	java/lang/Exception
    //   1078	1081	1081	java/lang/Exception
    //   88	169	1098	finally
    //   1424	1562	2865	java/lang/Exception
    //   2795	2862	2865	java/lang/Exception
    //   1287	1420	2882	finally
    //   1722	1860	2967	java/lang/Exception
    //   2897	2964	2967	java/lang/Exception
    //   1585	1718	2984	finally
    //   2020	2171	3069	java/lang/Exception
    //   2999	3066	3069	java/lang/Exception
    //   1883	2016	3086	finally
    //   2331	2482	3171	java/lang/Exception
    //   3101	3168	3171	java/lang/Exception
    //   2194	2327	3188	finally
    //   2634	2781	3269	java/lang/Exception
    //   3203	3266	3269	java/lang/Exception
    //   2497	2630	3285	finally
    //   2634	2781	3302	finally
    //   3203	3266	3302	finally
    //   2497	2630	3306	java/lang/Exception
    //   2331	2482	3313	finally
    //   3101	3168	3313	finally
    //   2194	2327	3317	java/lang/Exception
    //   2020	2171	3325	finally
    //   2999	3066	3325	finally
    //   1883	2016	3329	java/lang/Exception
    //   1722	1860	3337	finally
    //   2897	2964	3337	finally
    //   1585	1718	3341	java/lang/Exception
    //   1424	1562	3349	finally
    //   2795	2862	3349	finally
    //   1287	1420	3353	java/lang/Exception
    //   182	191	3361	finally
    //   196	206	3361	finally
    //   209	216	3361	finally
    //   417	425	3361	finally
    //   994	1001	3361	finally
    //   1015	1022	3361	finally
    //   1068	1075	3361	finally
    //   1078	1081	3361	finally
    //   88	169	3365	java/lang/Exception
    //   182	191	3378	java/lang/Exception
    //   196	206	3387	java/lang/Exception
    //   388	397	3398	finally
    //   406	413	3411	finally
    //   388	397	3426	java/lang/Exception
    //   406	413	3431	java/lang/Exception
    //   224	383	3486	java/lang/Exception
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
  
  public String a()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.getUinByPhoneNum(this.app, this.jdField_a_of_type_JavaLangString);
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
    setContentViewB(2131561323);
    Object localObject1;
    label97:
    int i1;
    label129:
    int n;
    int m;
    if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString))
    {
      setTitle(amtj.a(2131707559));
      if (this.mLeftBackText != null)
      {
        this.mLeftBackText.setText("");
        this.mLeftBackText.setContentDescription(amtj.a(2131707569));
      }
      enableRightHighlight(false);
      localObject1 = findViewById(2131365397);
      if (this.jdField_a_of_type_ArrayOfInt[14] != 1) {
        break label180;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131377824);
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
        break label1359;
      }
      if (i1 >= 0) {
        break label1356;
      }
      i1 = m;
      label156:
      if (n >= m) {
        break label1353;
      }
      n = m;
    }
    label180:
    label190:
    label200:
    label1353:
    label1356:
    label1359:
    for (;;)
    {
      m += 1;
      break label135;
      setTitle(2131694697);
      break;
      ((View)localObject1).setVisibility(8);
      break label97;
      ((View)localObject1).setVisibility(8);
      break label129;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131369013));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376260));
      a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout, i1, n);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368886));
      a(1, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369028));
      a(2, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368878));
      a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368976));
      a(4, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
      if (this.app.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(amtj.a(2131707592));
        this.i = ((FormSimpleItem)findViewById(2131368881));
        this.j = ((FormSimpleItem)findViewById(2131368892));
        a(16, this.i, 16, 17);
        a(17, this.j, 16, 17);
        a(null);
        this.k = ((FormSimpleItem)findViewById(2131368972));
        a(18, this.k, 18, 18);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368975));
        a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 5, 5);
        i1 = -1;
        n = -1;
        m = 6;
        label501:
        if (m > 13) {
          break label563;
        }
        if (this.jdField_a_of_type_ArrayOfInt[m] != 1) {
          break label1350;
        }
        if (i1 >= 0) {
          break label1347;
        }
        i1 = m;
        if (n >= m) {
          break label1344;
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
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(amtj.a(2131707581));
        break;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377649));
        a(7, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368936));
        a(8, this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
        if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          bcef.b(null, "dc00898", "", "", "0X8009F70", "0X8009F70", 0, 0, "", "", "", "");
        }
        this.h = ((FormSimpleItem)findViewById(2131368935));
        a(9, this.h, i1, n);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377166));
        a(11, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377169));
        a(10, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371461));
        a(12, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377172));
        a(13, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, i1, n);
        amsw localamsw;
        label1002:
        boolean bool;
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localamsw = (amsw)this.app.getManager(51);
          if (localamsw == null)
          {
            localObject1 = null;
            Object localObject2;
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
              this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localObject2 = localamsw.a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!bftf.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
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
                break label1283;
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
              if (localamsw != null) {
                break label1292;
              }
              localObject1 = null;
              localObject2 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if ((localObject1 == null) || (!((Card)localObject1).babyQSwitch)) {
                break label1305;
              }
              bool = true;
              ((FormSwitchItem)localObject2).setChecked(bool);
              ((amov)this.app.getBusinessHandler(2)).v();
            }
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
            {
              if ((localamsw == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
                break label1311;
              }
              this.jdField_a_of_type_Boolean = localamsw.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              d();
            }
            if ((localamsw != null) && (localamsw.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
              l();
            }
          }
        }
        for (;;)
        {
          if (AppSetting.c)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718145));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716376));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694632));
            this.h.setContentDescription(getString(2131694623));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(amtj.a(2131707542));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690604));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(amtj.a(2131707552));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694716));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
          }
          return;
          localObject1 = localamsw.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break;
          localObject1 = this.jdField_c_of_type_JavaLangString;
          break label943;
          localObject1 = localamsw.c(AppConstants.BABY_Q_UIN);
          break label1002;
          bool = false;
          break label1024;
          this.jdField_a_of_type_Boolean = false;
          break label1089;
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
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a(getTitleBarHeight()).show();
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
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839475));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839491));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839482));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839485));
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
  
  public void a(BusinessCard paramBusinessCard)
  {
    int n = 0;
    if (paramBusinessCard == null) {
      return;
    }
    String str = "";
    Object localObject1 = (amsw)this.app.getManager(51);
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
        break label242;
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130845675));
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
        break label254;
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
      localObject2 = ((amsw)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label242:
      a(this.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    label254:
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
    if (this.jdField_a_of_type_Adkk != null) {
      this.jdField_a_of_type_Adkk.a(paramCard);
    }
  }
  
  void a(String paramString)
  {
    bjnw localbjnw = bjnw.a(this);
    if (bftf.b(paramString)) {
      localbjnw.a(2131690527);
    }
    for (;;)
    {
      localbjnw.a(2131691372, 3);
      localbjnw.c(2131690620);
      localbjnw.a(new azat(this, paramString, localbjnw));
      localbjnw.show();
      return;
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        localbjnw.a(2131690529);
      } else {
        localbjnw.a(2131690528);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((amsw)this.app.getManager(51)).b(paramString1);
    int m = 17;
    if (localObject1 != null) {
      m = ((Friends)localObject1).cSpecialFlag;
    }
    Object localObject2 = new bcgt(StructMsgForGeneralShare.class);
    Object localObject3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + m;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + m;
    String str2 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + m;
    localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    localObject2 = ((bcgt)localObject2).c(14).a(2).a(1).a(amtj.a(2131707544) + paramString2).a("plugin", str2, "", (String)localObject3, str1).d(getResources().getString(2131717617)).a();
    localObject3 = new bcjp();
    ((bcgx)localObject3).b(1);
    ((bcgx)localObject3).a(new bciz((String)localObject1));
    ((bcgx)localObject3).a(new StructMsgItemTitle(paramString2));
    ((bcgx)localObject3).a(new bclv(amtj.a(2131707541) + bily.b(this.app, paramString1)));
    ((AbsShareMsg)localObject2).addItem(a(amtj.a(2131707589)));
    ((AbsShareMsg)localObject2).addItem((bcgw)localObject3);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    atky.a(this, paramString2, 21);
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      avnk localavnk = (avnk)this.app.getManager(16);
      if (localavnk != null) {}
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
          m = bfrj.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localavnk.b(m, (List)localObject);
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
            localavnk.a(m, (List)localObject);
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
        a(2131718417, 1);
      }
      for (;;)
      {
        d();
        return;
        a(2131718419, 1);
      }
    }
    a(2131692035, 1);
    d();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    f();
    if ((this.jdField_a_of_type_Int & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label112;
      }
      if (paramBoolean2) {
        a(2131718418, 2);
      }
    }
    else
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFD;
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label144;
      }
      amsw localamsw = (amsw)this.app.getManager(51);
      if ((localamsw == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label136;
      }
      this.jdField_a_of_type_Boolean = localamsw.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      d();
      return;
      a(2131718430, 2);
      break;
      label112:
      if (paramBoolean2)
      {
        a(2131718417, 1);
        break;
      }
      a(2131718419, 1);
      break;
      label136:
      this.jdField_a_of_type_Boolean = false;
      continue;
      label144:
      this.jdField_a_of_type_Boolean = a();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      c(paramArrayOfByte);
    }
  }
  
  boolean a()
  {
    avnk localavnk = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localavnk = (avnk)this.app.getManager(16);
      if (localavnk == null) {
        break label162;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localavnk.a((String)localObject);
      localObject = (amsw)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = localavnk; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((amsw)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = a();
      }
    }
    label162:
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
        if (bftf.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ArrayOfInt[2] = 1;
          this.jdField_a_of_type_ArrayOfInt[12] = 1;
          this.jdField_a_of_type_ArrayOfInt[14] = 1;
        }
        else
        {
          this.jdField_a_of_type_ArrayOfInt[0] = 1;
          if ((nns.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (bily.b(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
          {
            m = 1;
            label197:
            if (m != 0)
            {
              if (!((bily)this.app.getManager(165)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
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
            if (awgt.a(this.app.getCurrentUin())) {
              this.jdField_a_of_type_ArrayOfInt[8] = 1;
            }
            azwn localazwn = this.jdField_a_of_type_Azwn;
            if (azwn.a()) {
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
  
  public void b(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F));
  }
  
  public void b(String paramString)
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
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      c(paramArrayOfByte);
    }
  }
  
  void c()
  {
    Object localObject = (amsw)this.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((amsw)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  void c(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(SharePreferenceUtils.get(this, "bc_remark_first"))) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 8)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365821));
    }
    if (paramInt1 < 0) {}
    for (paramInt1 = 0;; paramInt1 = AIOUtils.dp2px(10.0F, getResources()))
    {
      int m = paramInt2;
      if (paramInt2 < 0) {
        m = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramInt1, m, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      SharePreferenceUtils.set(this, "bc_remark_first", "false");
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Adkk != null) {
      this.jdField_a_of_type_Adkk.a(paramArrayOfByte);
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      a(null);
      return;
    }
    runOnUiThread(new ProfileCardMoreActivity.4(this));
  }
  
  public void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    while ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (bftf.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
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
        if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          if ((!bool) && (paramIntent.equals(this.jdField_e_of_type_JavaLangString))) {
            break;
          }
          if (!paramIntent.equals(this.jdField_b_of_type_JavaLangString))
          {
            localObject = (FriendListHandler)this.app.getBusinessHandler(1);
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
            a(2131693090, 1);
            return;
          }
          a(2131693076, 0);
          return;
        }
        a(2131694105, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131718771));
        localObject = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.sessionFromIntent((Intent)localObject);
        ForwardUtils.handleAppShareAction(this.app, this, paramIntent, (Intent)localObject);
        return;
        if (this.jdField_a_of_type_Adkk == null) {
          break;
        }
        this.jdField_a_of_type_Adkk.a(paramInt2, paramIntent);
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
    this.jdField_a_of_type_Azwn = new azwn(this.app);
    try
    {
      b();
      a();
      this.jdField_a_of_type_Adkk = new adkk(this, this);
      this.jdField_a_of_type_Adkk.jdField_a_of_type_Int = getIntent().getIntExtra("coverTimeStamp", 0);
      this.jdField_a_of_type_Adkk.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("coverUrl");
      this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(this.app.getCurrentUin(), 0);
      }
      this.jdField_a_of_type_Apgi = ((apgi)this.app.getManager(112));
      addObserver(this.jdField_a_of_type_Amwl);
      addObserver(this.jdField_a_of_type_Anax);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      addObserver(this.jdField_a_of_type_Amsu);
      addObserver(this.jdField_a_of_type_Atuh);
      this.app.registObserver(this.jdField_a_of_type_Apgj);
      this.app.setHandler(ProfileCardMoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      if ((this.jdField_d_of_type_JavaLangString == null) || (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        ThreadManager.excute(new ProfileCardMoreActivity.1(this), 16, null, true);
      }
      alfl.a(this.app);
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
    if (this.jdField_a_of_type_Adkk != null)
    {
      this.jdField_a_of_type_Adkk.a();
      this.jdField_a_of_type_Adkk = null;
    }
    f();
    removeObserver(this.jdField_a_of_type_Amwl);
    removeObserver(this.jdField_a_of_type_Anax);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_Amsu);
    removeObserver(this.jdField_a_of_type_Atuh);
    this.app.unRegistObserver(this.jdField_a_of_type_Apgj);
    this.app.removeHandler(ProfileCardMoreActivity.class);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Adkk != null)) {
      this.jdField_a_of_type_Adkk.a(paramIntent, localArrayList);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((amsw)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label67;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718035));
    }
    for (;;)
    {
      j();
      return;
      label67:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718036));
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Bhht == null)
    {
      this.jdField_a_of_type_Bhht = new bhht(this, getTitleBarHeight());
      this.jdField_a_of_type_Bhht.c(2131718142);
    }
    this.jdField_a_of_type_Bhht.show();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhht.cancel();
      this.jdField_a_of_type_Bhht = null;
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
    if ((this.jdField_a_of_type_Adkk != null) && (this.jdField_a_of_type_Adkk.jdField_a_of_type_Boolean))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Adkk.jdField_a_of_type_ArrayOfByte);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  public void g()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.getFileThreadHandler().post(new ProfileCardMoreActivity.13(this));
    }
  }
  
  protected void h()
  {
    Object localObject1 = (amsw)this.app.getManager(51);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label147;
      }
    }
    label142:
    label147:
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
            break label142;
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
        localObject1 = ((amsw)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
          aabc.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, aabc.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, aabc.b(2)), str2, null, this.app.getCurrentAccountUin(), m, null, (Bundle)localObject1);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), Integer.valueOf(m), str2, str1, localObject1 }));
          }
          bcef.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
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
            localObject1 = aabc.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, 1);
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
            localObject1 = aabc.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString, 3000);
            m = n;
            break label119;
          }
          if (localObject1 != null)
          {
            if (((Bundle)localObject1).containsKey("chattype"))
            {
              m = aabc.a(((Bundle)localObject1).getInt("chattype"));
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
          aabc.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, null, str2, str1, this.app.getAccount(), m, null, (Bundle)localObject1);
        }
      }
    }
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
        bcef.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, m, "0", "0", "", "");
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
          break label331;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
          break label278;
        }
        localObject1 = (FriendListHandler)this.app.getBusinessHandler(1);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        ((FriendListHandler)localObject1).gatherContacts((short)1, (List)localObject2, paramBoolean);
        if (paramBoolean) {
          bcef.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
        } else {
          bcef.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
        }
      }
      a(2131692035, 1);
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
        if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          ((amov)this.app.getBusinessHandler(2)).m(paramBoolean);
          localObject1 = this.app;
          if (paramBoolean) {}
          for (;;)
          {
            bcef.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
            break;
            m = 0;
          }
        }
        a(2131692035, 1);
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
    label278:
    label331:
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692035, 1);
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
      l = bbko.a();
      label609:
      FriendsStatusUtil.b((QQAppInterface)localObject1, (String)localObject2, 0, l, true, false);
      localObject1 = this.app;
      if (!paramCompoundButton.isChecked()) {
        break label675;
      }
    }
    label675:
    for (m = 1;; m = 2)
    {
      bcef.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, m, "0", "0", "", "");
      break;
      l = 0L;
      break label609;
    }
  }
  
  public void onClick(View paramView)
  {
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
      bfrj.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      bcef.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      bcef.b(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
      continue;
      c();
      bcef.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      continue;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (checkSelfPermission("android.permission.WRITE_CONTACTS") != 0) {
          requestPermissions(new azaq(this, this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        } else {
          g();
        }
      }
      else
      {
        g();
        continue;
        String str1;
        if (((bily)this.app.getManager(165)).f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = ContactUtils.getAccountNickName(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          String str2 = getIntent().getStringExtra("key_nick_name");
          str1 = str2;
          if (str2 == null) {
            str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, str1, 14);
        }
        for (;;)
        {
          bcef.b(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
          break;
          if (this.jdField_a_of_type_Aymj == null) {
            this.jdField_a_of_type_Aymj = new aymj(this, this.app, 0, new azar(this));
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = ContactUtils.getAccountNickName(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_Aymj.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
        }
        label631:
        QZoneHelper.UserInfo localUserInfo;
        for (;;)
        {
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
              break label631;
            }
            str1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            a(str1);
          }
          catch (Exception localException1) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("IphoneTitleBarActivity", 2, localException1, new Object[0]);
          break;
          localUserInfo = null;
        }
        i();
        continue;
        try
        {
          localUserInfo = QZoneHelper.UserInfo.getInstance();
          localUserInfo.qzone_uin = this.app.getCurrentAccountUin();
          localUserInfo.nickname = this.app.getCurrentNickname();
          QZoneHelper.forwardToSinglePermissionSetting(this, localUserInfo, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
          bcef.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        }
        catch (Exception localException2) {}
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, localException2.toString());
          continue;
          alfl.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 3);
          bcef.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
          continue;
          bcef.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
          Object localObject = ((amsw)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if (localObject != null) {
            if ((((ExtensionInfo)localObject).intimate_type == 2) || (((ExtensionInfo)localObject).intimate_type == 3) || (((ExtensionInfo)localObject).intimate_type == 26) || (((ExtensionInfo)localObject).intimate_type == 1))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              adxr.a(this, (Intent)localObject, PublicFragmentActivity.class, IntimateInfoFragment.class);
              if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "jumpIntimatePage");
              }
            }
            else
            {
              localObject = awgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "click item_friend_intimate url:" + (String)localObject);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject));
                continue;
                this.jdField_a_of_type_Azwn.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                continue;
                localObject = new Intent(this, AvatarPendantActivity.class);
                ((Intent)localObject).putExtra("AllInOne", this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
                ((Intent)localObject).putExtra("showActionSheet", true);
                startActivity((Intent)localObject);
                bcef.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
                continue;
                if (this.jdField_a_of_type_Adkk != null)
                {
                  localObject = this.jdField_a_of_type_Adkk;
                  if (this.jdField_a_of_type_Adkk.jdField_a_of_type_Int != 0) {
                    break label1193;
                  }
                }
                label1193:
                for (boolean bool = true;; bool = false)
                {
                  ((adkk)localObject).a(bool);
                  bcef.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
                  break;
                }
                k();
                bcef.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */