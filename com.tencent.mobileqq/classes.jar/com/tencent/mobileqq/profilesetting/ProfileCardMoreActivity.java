package com.tencent.mobileqq.profilesetting;

import Override;
import abao;
import aeij;
import aeil;
import aevv;
import afur;
import alyw;
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
import anhk;
import anip;
import aniz;
import anmu;
import anmw;
import anni;
import anqd;
import anuw;
import apyx;
import apyy;
import aufz;
import aupb;
import awhl;
import awzp;
import axap;
import axas;
import azfh;
import azrz;
import azsa;
import azsb;
import azsc;
import azsd;
import azse;
import azsf;
import azsg;
import azsh;
import azsi;
import bbyp;
import bcst;
import bcvp;
import bcvs;
import bcvt;
import bcxv;
import bcyl;
import bczv;
import bdaq;
import bghy;
import bgjb;
import bgjw;
import bglf;
import bgnt;
import biau;
import bjft;
import bkho;
import blsb;
import blsi;
import bmjh;
import bmji;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.IntimateInfoFragment;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
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
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nki;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements aeil, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  public aeij a;
  public Intent a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aniz jdField_a_of_type_Aniz = new azsi(this);
  anmu jdField_a_of_type_Anmu = new azsg(this);
  anqd jdField_a_of_type_Anqd = new azse(this);
  anuw jdField_a_of_type_Anuw = new azsf(this);
  apyx jdField_a_of_type_Apyx;
  apyy jdField_a_of_type_Apyy = new azsh(this);
  aupb jdField_a_of_type_Aupb = new azrz(this);
  private azfh jdField_a_of_type_Azfh;
  public biau a;
  public ProfileActivity.AllInOne a;
  public BusinessCard a;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public FormSimpleItem a;
  public FormSwitchItem a;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new azsc(this);
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
  
  public ProfileCardMoreActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private static bcvt a(String paramString)
  {
    bczv localbczv = new bczv();
    localbczv.b(1);
    localbczv.a(paramString);
    return localbczv;
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(paramIntent.getBooleanExtra("param_switches_changed", false));
      boolean bool1 = paramIntent.getBooleanExtra("key_weishi_switch", false);
      boolean bool2 = paramIntent.hasExtra("key_personality_label_switch");
      if ((this.jdField_a_of_type_AndroidOsBundle == null) && ((bool1) || (bool1))) {
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
    if (!bgnt.d(BaseApplication.getContext()))
    {
      a(2131691985, 1);
      d();
      return;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (l > 0L) {
        if (!paramBoolean)
        {
          bool1 = true;
          localFriendListHandler.a(l, bool1);
          k = 1;
          if (k == 0) {
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
          a(2131718043, 1);
        }
        for (;;)
        {
          d();
          return;
          a(2131718045, 1);
        }
        int k = 0;
      }
    }
  }
  
  private void j()
  {
    boolean bool = false;
    Object localObject;
    axap localaxap;
    int k;
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      localObject = "";
      localaxap = awzp.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
      if (localaxap == null) {
        break label194;
      }
      if (localaxap.a != 1L) {
        break label121;
      }
      localObject = getString(2131693066);
      k = localaxap.c;
      bool = localaxap.c();
    }
    for (;;)
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      if (k != 0)
      {
        localObject = getResources().getDrawable(k);
        if ((localObject instanceof SkinnableBitmapDrawable))
        {
          localObject = ((SkinnableBitmapDrawable)localObject).mutate2();
          label102:
          if (!bool) {
            break label175;
          }
          ((Drawable)localObject).setAlpha(102);
        }
        for (;;)
        {
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
          return;
          label121:
          if (localaxap.a == 2L)
          {
            localObject = getString(2131693064);
            break;
          }
          if (localaxap.a != 3L) {
            break;
          }
          localObject = getString(2131693065);
          break;
          localObject = ((Drawable)localObject).mutate();
          break label102;
          label175:
          ((Drawable)localObject).setAlpha(255);
        }
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      return;
      label194:
      k = 0;
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690568));
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
    //   5: invokevirtual 339	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 342	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 202	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   23: invokevirtual 351	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3448 -> 3478
    //   33: aload 11
    //   35: ldc_w 353
    //   38: aload_1
    //   39: invokevirtual 359	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   42: checkcast 353	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   45: astore 15
    //   47: aload 11
    //   49: ifnull +8 -> 57
    //   52: aload 11
    //   54: invokevirtual 362	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   57: aload 15
    //   59: ifnonnull +5 -> 64
    //   62: iconst_m1
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 364	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   68: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +879 -> 950
    //   74: aload_0
    //   75: getfield 364	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: astore 12
    //   80: iconst_0
    //   81: istore_2
    //   82: iconst_0
    //   83: istore_3
    //   84: aconst_null
    //   85: astore 13
    //   87: aload_0
    //   88: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   91: astore 11
    //   93: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   96: astore 16
    //   98: new 152	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 382
    //   108: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 12
    //   113: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 384
    //   119: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 14
    //   127: aload 11
    //   129: aload 16
    //   131: iconst_4
    //   132: anewarray 336	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: ldc_w 386
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: ldc_w 388
    //   146: aastore
    //   147: dup
    //   148: iconst_2
    //   149: ldc_w 390
    //   152: aastore
    //   153: dup
    //   154: iconst_3
    //   155: ldc_w 392
    //   158: aastore
    //   159: aload 14
    //   161: aconst_null
    //   162: aconst_null
    //   163: invokevirtual 398	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   166: astore 11
    //   168: iconst_0
    //   169: istore 4
    //   171: lconst_0
    //   172: lstore 9
    //   174: iload_3
    //   175: istore_2
    //   176: iload 4
    //   178: istore_3
    //   179: aload 11
    //   181: ifnull +3284 -> 3465
    //   184: aload 11
    //   186: invokeinterface 403 1 0
    //   191: istore 6
    //   193: iload 6
    //   195: ifeq +3270 -> 3465
    //   198: aload 11
    //   200: iconst_0
    //   201: invokeinterface 407 2 0
    //   206: lstore 7
    //   208: iload_2
    //   209: istore 4
    //   211: aload 15
    //   213: getfield 410	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   216: astore 13
    //   218: aload 13
    //   220: ifnull +873 -> 1093
    //   223: aconst_null
    //   224: astore 14
    //   226: aload_0
    //   227: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   230: astore 17
    //   232: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   235: astore 16
    //   237: new 152	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 412
    //   247: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: lload 7
    //   252: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: ldc_w 417
    //   258: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 390
    //   264: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 419
    //   270: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 421
    //   276: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 423
    //   282: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 392
    //   288: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 419
    //   294: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 15
    //   299: getfield 410	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   302: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 423
    //   308: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 425
    //   314: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 419
    //   320: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iconst_2
    //   324: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 384
    //   330: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: astore 13
    //   338: aload 17
    //   340: aload 16
    //   342: iconst_5
    //   343: anewarray 336	java/lang/String
    //   346: dup
    //   347: iconst_0
    //   348: ldc_w 386
    //   351: aastore
    //   352: dup
    //   353: iconst_1
    //   354: ldc_w 388
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: ldc_w 390
    //   363: aastore
    //   364: dup
    //   365: iconst_3
    //   366: ldc_w 392
    //   369: aastore
    //   370: dup
    //   371: iconst_4
    //   372: ldc_w 425
    //   375: aastore
    //   376: aload 13
    //   378: aconst_null
    //   379: aconst_null
    //   380: invokevirtual 398	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   383: astore 13
    //   385: aload 13
    //   387: ifnull +594 -> 981
    //   390: aload 13
    //   392: invokeinterface 431 1 0
    //   397: istore 6
    //   399: iload 6
    //   401: ifeq +580 -> 981
    //   404: iconst_1
    //   405: istore_3
    //   406: iconst_1
    //   407: istore_2
    //   408: aload 13
    //   410: invokeinterface 432 1 0
    //   415: iconst_0
    //   416: ifeq +3042 -> 3458
    //   419: new 434	java/lang/NullPointerException
    //   422: dup
    //   423: invokespecial 435	java/lang/NullPointerException:<init>	()V
    //   426: athrow
    //   427: iload_3
    //   428: istore 5
    //   430: lload 7
    //   432: lstore 9
    //   434: iload_2
    //   435: istore 4
    //   437: aload 11
    //   439: ifnull +3006 -> 3445
    //   442: aload 11
    //   444: invokeinterface 432 1 0
    //   449: iload_3
    //   450: ifne +668 -> 1118
    //   453: iconst_1
    //   454: istore_3
    //   455: iconst_0
    //   456: istore_2
    //   457: new 437	android/content/ContentValues
    //   460: dup
    //   461: invokespecial 438	android/content/ContentValues:<init>	()V
    //   464: astore 13
    //   466: iload_3
    //   467: iconst_1
    //   468: if_icmpne +668 -> 1136
    //   471: aload_0
    //   472: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   475: getstatic 441	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   478: aload 13
    //   480: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   483: invokestatic 451	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   486: lstore 7
    //   488: aload 12
    //   490: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   493: ifne +55 -> 548
    //   496: aload 13
    //   498: invokevirtual 454	android/content/ContentValues:clear	()V
    //   501: aload 13
    //   503: ldc_w 386
    //   506: lload 7
    //   508: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   514: aload 13
    //   516: ldc_w 390
    //   519: ldc_w 463
    //   522: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 13
    //   527: ldc_w 392
    //   530: aload 12
    //   532: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_0
    //   536: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   539: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   542: aload 13
    //   544: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   547: pop
    //   548: aload 15
    //   550: getfield 469	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   553: ifnonnull +11 -> 564
    //   556: aload 15
    //   558: getfield 472	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   561: ifnull +99 -> 660
    //   564: aload 13
    //   566: invokevirtual 454	android/content/ContentValues:clear	()V
    //   569: aload 13
    //   571: ldc_w 386
    //   574: lload 7
    //   576: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   579: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   582: aload 13
    //   584: ldc_w 390
    //   587: ldc_w 474
    //   590: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload 15
    //   595: getfield 472	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   598: ifnull +16 -> 614
    //   601: aload 13
    //   603: ldc_w 392
    //   606: aload 15
    //   608: getfield 472	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   611: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 15
    //   616: getfield 469	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   619: ifnull +16 -> 635
    //   622: aload 13
    //   624: ldc_w 476
    //   627: aload 15
    //   629: getfield 469	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   632: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 13
    //   637: ldc_w 425
    //   640: iconst_1
    //   641: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   647: aload_0
    //   648: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   651: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   654: aload 13
    //   656: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   659: pop
    //   660: aload 15
    //   662: getfield 410	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   665: ifnull +70 -> 735
    //   668: aload 13
    //   670: invokevirtual 454	android/content/ContentValues:clear	()V
    //   673: aload 13
    //   675: ldc_w 386
    //   678: lload 7
    //   680: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   683: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   686: aload 13
    //   688: ldc_w 390
    //   691: ldc_w 421
    //   694: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 13
    //   699: ldc_w 392
    //   702: aload 15
    //   704: getfield 410	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   707: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload 13
    //   712: ldc_w 425
    //   715: iconst_2
    //   716: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   719: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   722: aload_0
    //   723: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   726: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   729: aload 13
    //   731: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   734: pop
    //   735: aload 15
    //   737: getfield 487	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   740: ifnull +70 -> 810
    //   743: aload 13
    //   745: invokevirtual 454	android/content/ContentValues:clear	()V
    //   748: aload 13
    //   750: ldc_w 386
    //   753: lload 7
    //   755: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   758: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   761: aload 13
    //   763: ldc_w 390
    //   766: ldc_w 421
    //   769: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload 13
    //   774: ldc_w 392
    //   777: aload 15
    //   779: getfield 487	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   782: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 13
    //   787: ldc_w 425
    //   790: iconst_3
    //   791: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   794: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   797: aload_0
    //   798: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   801: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   804: aload 13
    //   806: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   809: pop
    //   810: aload 15
    //   812: getfield 490	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   815: ifnull +70 -> 885
    //   818: aload 13
    //   820: invokevirtual 454	android/content/ContentValues:clear	()V
    //   823: aload 13
    //   825: ldc_w 386
    //   828: lload 7
    //   830: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   833: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   836: aload 13
    //   838: ldc_w 390
    //   841: ldc_w 492
    //   844: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: aload 13
    //   849: ldc_w 392
    //   852: aload 15
    //   854: getfield 490	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   857: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: aload 13
    //   862: ldc_w 425
    //   865: iconst_2
    //   866: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   869: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   872: aload_0
    //   873: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   876: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   879: aload 13
    //   881: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   884: pop
    //   885: aload 13
    //   887: invokevirtual 454	android/content/ContentValues:clear	()V
    //   890: aload 13
    //   892: ldc_w 386
    //   895: lload 7
    //   897: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   900: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   903: aload 13
    //   905: ldc_w 390
    //   908: ldc_w 494
    //   911: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: aload 13
    //   916: ldc_w 392
    //   919: aload_1
    //   920: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload 13
    //   925: ldc_w 425
    //   928: iconst_2
    //   929: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   932: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   935: aload_0
    //   936: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   939: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   942: aload 13
    //   944: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   947: pop
    //   948: iconst_0
    //   949: ireturn
    //   950: aload 15
    //   952: getfield 497	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   955: ifnull +13 -> 968
    //   958: aload 15
    //   960: getfield 497	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   963: astore 12
    //   965: goto -885 -> 80
    //   968: aload_1
    //   969: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifne +2500 -> 3472
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
    //   990: ifnull +2494 -> 3484
    //   993: iload 4
    //   995: istore_3
    //   996: aload 13
    //   998: invokeinterface 432 1 0
    //   1003: iload_2
    //   1004: istore_3
    //   1005: goto +2479 -> 3484
    //   1008: iload_2
    //   1009: istore_3
    //   1010: aload 13
    //   1012: ifnull +2472 -> 3484
    //   1015: iload_2
    //   1016: istore_3
    //   1017: aload 13
    //   1019: invokeinterface 432 1 0
    //   1024: iload_2
    //   1025: istore_3
    //   1026: goto +2458 -> 3484
    //   1029: astore 13
    //   1031: iload_3
    //   1032: istore_2
    //   1033: iconst_1
    //   1034: istore_3
    //   1035: iload_3
    //   1036: istore 5
    //   1038: lload 7
    //   1040: lstore 9
    //   1042: iload_2
    //   1043: istore 4
    //   1045: aload 11
    //   1047: ifnull +2398 -> 3445
    //   1050: aload 11
    //   1052: invokeinterface 432 1 0
    //   1057: goto -608 -> 449
    //   1060: astore 13
    //   1062: aload 14
    //   1064: ifnull +13 -> 1077
    //   1067: iload_2
    //   1068: istore 4
    //   1070: aload 14
    //   1072: invokeinterface 432 1 0
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
    //   1100: astore 11
    //   1102: aload 13
    //   1104: astore_1
    //   1105: aload_1
    //   1106: ifnull +9 -> 1115
    //   1109: aload_1
    //   1110: invokeinterface 432 1 0
    //   1115: aload 11
    //   1117: athrow
    //   1118: iload_2
    //   1119: ifne +10 -> 1129
    //   1122: iconst_1
    //   1123: istore_3
    //   1124: iconst_0
    //   1125: istore_2
    //   1126: goto -669 -> 457
    //   1129: iconst_1
    //   1130: istore_2
    //   1131: iconst_0
    //   1132: istore_3
    //   1133: goto -676 -> 457
    //   1136: iload_2
    //   1137: iconst_1
    //   1138: if_icmpne +2163 -> 3301
    //   1141: aload 15
    //   1143: getfield 410	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1146: ifnull +131 -> 1277
    //   1149: aload 13
    //   1151: invokevirtual 454	android/content/ContentValues:clear	()V
    //   1154: aload 13
    //   1156: ldc_w 390
    //   1159: ldc_w 421
    //   1162: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1165: aload 13
    //   1167: ldc_w 392
    //   1170: aload 15
    //   1172: getfield 410	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1175: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: aload 13
    //   1180: ldc_w 425
    //   1183: iconst_2
    //   1184: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1187: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1190: aload_0
    //   1191: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1194: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1197: aload 13
    //   1199: new 152	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1206: ldc_w 412
    //   1209: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: lload 7
    //   1214: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1217: ldc_w 417
    //   1220: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: ldc_w 390
    //   1226: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: ldc_w 419
    //   1232: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: ldc_w 421
    //   1238: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: ldc_w 423
    //   1244: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: ldc_w 425
    //   1250: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: ldc_w 419
    //   1256: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: iconst_2
    //   1260: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1263: ldc_w 384
    //   1266: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: aconst_null
    //   1273: invokevirtual 501	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1276: pop
    //   1277: aload 15
    //   1279: getfield 469	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1282: ifnull +293 -> 1575
    //   1285: aconst_null
    //   1286: astore 11
    //   1288: aload_0
    //   1289: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1292: astore 16
    //   1294: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1297: astore 12
    //   1299: new 152	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1306: ldc_w 412
    //   1309: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: lload 7
    //   1314: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1317: ldc_w 417
    //   1320: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: ldc_w 390
    //   1326: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: ldc_w 419
    //   1332: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: ldc_w 474
    //   1338: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: ldc_w 423
    //   1344: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: ldc_w 425
    //   1350: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: ldc_w 419
    //   1356: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: iconst_1
    //   1360: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1363: ldc_w 384
    //   1366: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1372: astore 14
    //   1374: aload 16
    //   1376: aload 12
    //   1378: iconst_5
    //   1379: anewarray 336	java/lang/String
    //   1382: dup
    //   1383: iconst_0
    //   1384: ldc_w 386
    //   1387: aastore
    //   1388: dup
    //   1389: iconst_1
    //   1390: ldc_w 388
    //   1393: aastore
    //   1394: dup
    //   1395: iconst_2
    //   1396: ldc_w 390
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_3
    //   1402: ldc_w 476
    //   1405: aastore
    //   1406: dup
    //   1407: iconst_4
    //   1408: ldc_w 425
    //   1411: aastore
    //   1412: aload 14
    //   1414: aconst_null
    //   1415: aconst_null
    //   1416: invokevirtual 398	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1419: astore 12
    //   1421: aload 12
    //   1423: astore 11
    //   1425: aload 11
    //   1427: invokeinterface 431 1 0
    //   1432: ifeq +1364 -> 2796
    //   1435: aload 13
    //   1437: invokevirtual 454	android/content/ContentValues:clear	()V
    //   1440: aload 13
    //   1442: ldc_w 390
    //   1445: ldc_w 474
    //   1448: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1451: aload 13
    //   1453: ldc_w 476
    //   1456: aload 15
    //   1458: getfield 469	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1461: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1464: aload 13
    //   1466: ldc_w 425
    //   1469: iconst_1
    //   1470: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1473: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1476: aload_0
    //   1477: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1480: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1483: aload 13
    //   1485: new 152	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1492: ldc_w 412
    //   1495: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: lload 7
    //   1500: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1503: ldc_w 417
    //   1506: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1509: ldc_w 390
    //   1512: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: ldc_w 419
    //   1518: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: ldc_w 474
    //   1524: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: ldc_w 423
    //   1530: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: ldc_w 425
    //   1536: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: ldc_w 419
    //   1542: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: iconst_1
    //   1546: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1549: ldc_w 384
    //   1552: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1558: aconst_null
    //   1559: invokevirtual 501	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1562: pop
    //   1563: aload 11
    //   1565: ifnull +10 -> 1575
    //   1568: aload 11
    //   1570: invokeinterface 432 1 0
    //   1575: aload 15
    //   1577: getfield 472	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1580: ifnull +293 -> 1873
    //   1583: aconst_null
    //   1584: astore 11
    //   1586: aload_0
    //   1587: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1590: astore 14
    //   1592: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1595: astore 12
    //   1597: new 152	java/lang/StringBuilder
    //   1600: dup
    //   1601: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1604: ldc_w 412
    //   1607: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: lload 7
    //   1612: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1615: ldc_w 417
    //   1618: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: ldc_w 390
    //   1624: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: ldc_w 419
    //   1630: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: ldc_w 474
    //   1636: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: ldc_w 423
    //   1642: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: ldc_w 425
    //   1648: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: ldc_w 419
    //   1654: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1657: iconst_1
    //   1658: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1661: ldc_w 384
    //   1664: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1670: astore 16
    //   1672: aload 14
    //   1674: aload 12
    //   1676: iconst_5
    //   1677: anewarray 336	java/lang/String
    //   1680: dup
    //   1681: iconst_0
    //   1682: ldc_w 386
    //   1685: aastore
    //   1686: dup
    //   1687: iconst_1
    //   1688: ldc_w 388
    //   1691: aastore
    //   1692: dup
    //   1693: iconst_2
    //   1694: ldc_w 390
    //   1697: aastore
    //   1698: dup
    //   1699: iconst_3
    //   1700: ldc_w 392
    //   1703: aastore
    //   1704: dup
    //   1705: iconst_4
    //   1706: ldc_w 425
    //   1709: aastore
    //   1710: aload 16
    //   1712: aconst_null
    //   1713: aconst_null
    //   1714: invokevirtual 398	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1717: astore 12
    //   1719: aload 12
    //   1721: astore 11
    //   1723: aload 11
    //   1725: invokeinterface 431 1 0
    //   1730: ifeq +1168 -> 2898
    //   1733: aload 13
    //   1735: invokevirtual 454	android/content/ContentValues:clear	()V
    //   1738: aload 13
    //   1740: ldc_w 390
    //   1743: ldc_w 474
    //   1746: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1749: aload 13
    //   1751: ldc_w 392
    //   1754: aload 15
    //   1756: getfield 472	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1759: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1762: aload 13
    //   1764: ldc_w 425
    //   1767: iconst_1
    //   1768: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1771: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1774: aload_0
    //   1775: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1778: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1781: aload 13
    //   1783: new 152	java/lang/StringBuilder
    //   1786: dup
    //   1787: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1790: ldc_w 412
    //   1793: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: lload 7
    //   1798: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1801: ldc_w 417
    //   1804: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: ldc_w 390
    //   1810: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: ldc_w 419
    //   1816: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: ldc_w 474
    //   1822: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: ldc_w 423
    //   1828: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1831: ldc_w 425
    //   1834: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: ldc_w 419
    //   1840: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: iconst_1
    //   1844: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1847: ldc_w 384
    //   1850: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: aconst_null
    //   1857: invokevirtual 501	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1860: pop
    //   1861: aload 11
    //   1863: ifnull +10 -> 1873
    //   1866: aload 11
    //   1868: invokeinterface 432 1 0
    //   1873: aload 15
    //   1875: getfield 487	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1878: ifnull +306 -> 2184
    //   1881: aconst_null
    //   1882: astore 11
    //   1884: aload_0
    //   1885: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1888: astore 14
    //   1890: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1893: astore 12
    //   1895: new 152	java/lang/StringBuilder
    //   1898: dup
    //   1899: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1902: ldc_w 412
    //   1905: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: lload 7
    //   1910: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1913: ldc_w 417
    //   1916: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: ldc_w 390
    //   1922: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: ldc_w 419
    //   1928: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: ldc_w 421
    //   1934: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1937: ldc_w 423
    //   1940: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: ldc_w 425
    //   1946: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: ldc_w 419
    //   1952: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: iconst_3
    //   1956: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1959: ldc_w 384
    //   1962: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: astore 16
    //   1970: aload 14
    //   1972: aload 12
    //   1974: iconst_5
    //   1975: anewarray 336	java/lang/String
    //   1978: dup
    //   1979: iconst_0
    //   1980: ldc_w 386
    //   1983: aastore
    //   1984: dup
    //   1985: iconst_1
    //   1986: ldc_w 388
    //   1989: aastore
    //   1990: dup
    //   1991: iconst_2
    //   1992: ldc_w 390
    //   1995: aastore
    //   1996: dup
    //   1997: iconst_3
    //   1998: ldc_w 392
    //   2001: aastore
    //   2002: dup
    //   2003: iconst_4
    //   2004: ldc_w 425
    //   2007: aastore
    //   2008: aload 16
    //   2010: aconst_null
    //   2011: aconst_null
    //   2012: invokevirtual 398	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2015: astore 12
    //   2017: aload 12
    //   2019: astore 11
    //   2021: aload 11
    //   2023: invokeinterface 431 1 0
    //   2028: ifeq +972 -> 3000
    //   2031: aload 13
    //   2033: invokevirtual 454	android/content/ContentValues:clear	()V
    //   2036: aload 13
    //   2038: ldc_w 386
    //   2041: lload 7
    //   2043: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2046: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2049: aload 13
    //   2051: ldc_w 390
    //   2054: ldc_w 421
    //   2057: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2060: aload 13
    //   2062: ldc_w 392
    //   2065: aload 15
    //   2067: getfield 487	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2070: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2073: aload 13
    //   2075: ldc_w 425
    //   2078: iconst_3
    //   2079: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2082: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2085: aload_0
    //   2086: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2089: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2092: aload 13
    //   2094: new 152	java/lang/StringBuilder
    //   2097: dup
    //   2098: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2101: ldc_w 412
    //   2104: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: lload 7
    //   2109: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2112: ldc_w 417
    //   2115: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: ldc_w 390
    //   2121: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: ldc_w 419
    //   2127: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: ldc_w 421
    //   2133: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: ldc_w 423
    //   2139: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2142: ldc_w 425
    //   2145: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: ldc_w 419
    //   2151: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: iconst_3
    //   2155: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2158: ldc_w 384
    //   2161: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2167: aconst_null
    //   2168: invokevirtual 501	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2171: pop
    //   2172: aload 11
    //   2174: ifnull +10 -> 2184
    //   2177: aload 11
    //   2179: invokeinterface 432 1 0
    //   2184: aload 15
    //   2186: getfield 490	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2189: ifnull +306 -> 2495
    //   2192: aconst_null
    //   2193: astore 11
    //   2195: aload_0
    //   2196: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2199: astore 12
    //   2201: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2204: astore 16
    //   2206: new 152	java/lang/StringBuilder
    //   2209: dup
    //   2210: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2213: ldc_w 412
    //   2216: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2219: lload 7
    //   2221: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2224: ldc_w 417
    //   2227: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2230: ldc_w 390
    //   2233: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2236: ldc_w 419
    //   2239: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2242: ldc_w 492
    //   2245: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: ldc_w 423
    //   2251: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: ldc_w 425
    //   2257: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: ldc_w 419
    //   2263: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: iconst_2
    //   2267: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2270: ldc_w 384
    //   2273: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2276: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2279: astore 14
    //   2281: aload 12
    //   2283: aload 16
    //   2285: iconst_5
    //   2286: anewarray 336	java/lang/String
    //   2289: dup
    //   2290: iconst_0
    //   2291: ldc_w 386
    //   2294: aastore
    //   2295: dup
    //   2296: iconst_1
    //   2297: ldc_w 388
    //   2300: aastore
    //   2301: dup
    //   2302: iconst_2
    //   2303: ldc_w 390
    //   2306: aastore
    //   2307: dup
    //   2308: iconst_3
    //   2309: ldc_w 392
    //   2312: aastore
    //   2313: dup
    //   2314: iconst_4
    //   2315: ldc_w 425
    //   2318: aastore
    //   2319: aload 14
    //   2321: aconst_null
    //   2322: aconst_null
    //   2323: invokevirtual 398	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2326: astore 12
    //   2328: aload 12
    //   2330: astore 11
    //   2332: aload 11
    //   2334: invokeinterface 431 1 0
    //   2339: ifeq +763 -> 3102
    //   2342: aload 13
    //   2344: invokevirtual 454	android/content/ContentValues:clear	()V
    //   2347: aload 13
    //   2349: ldc_w 386
    //   2352: lload 7
    //   2354: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2357: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2360: aload 13
    //   2362: ldc_w 390
    //   2365: ldc_w 492
    //   2368: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2371: aload 13
    //   2373: ldc_w 392
    //   2376: aload 15
    //   2378: getfield 490	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2381: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2384: aload 13
    //   2386: ldc_w 425
    //   2389: iconst_2
    //   2390: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2393: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2396: aload_0
    //   2397: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2400: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2403: aload 13
    //   2405: new 152	java/lang/StringBuilder
    //   2408: dup
    //   2409: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2412: ldc_w 412
    //   2415: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2418: lload 7
    //   2420: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2423: ldc_w 417
    //   2426: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2429: ldc_w 390
    //   2432: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2435: ldc_w 419
    //   2438: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2441: ldc_w 492
    //   2444: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2447: ldc_w 423
    //   2450: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2453: ldc_w 425
    //   2456: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2459: ldc_w 419
    //   2462: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: iconst_2
    //   2466: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2469: ldc_w 384
    //   2472: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2475: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2478: aconst_null
    //   2479: invokevirtual 501	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2482: pop
    //   2483: aload 11
    //   2485: ifnull +10 -> 2495
    //   2488: aload 11
    //   2490: invokeinterface 432 1 0
    //   2495: aconst_null
    //   2496: astore 11
    //   2498: aload_0
    //   2499: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2502: astore 12
    //   2504: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2507: astore 14
    //   2509: new 152	java/lang/StringBuilder
    //   2512: dup
    //   2513: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2516: ldc_w 412
    //   2519: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2522: lload 7
    //   2524: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2527: ldc_w 417
    //   2530: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2533: ldc_w 390
    //   2536: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: ldc_w 419
    //   2542: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2545: ldc_w 494
    //   2548: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: ldc_w 423
    //   2554: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: ldc_w 425
    //   2560: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: ldc_w 419
    //   2566: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2569: iconst_2
    //   2570: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2573: ldc_w 384
    //   2576: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2579: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2582: astore 15
    //   2584: aload 12
    //   2586: aload 14
    //   2588: iconst_5
    //   2589: anewarray 336	java/lang/String
    //   2592: dup
    //   2593: iconst_0
    //   2594: ldc_w 386
    //   2597: aastore
    //   2598: dup
    //   2599: iconst_1
    //   2600: ldc_w 388
    //   2603: aastore
    //   2604: dup
    //   2605: iconst_2
    //   2606: ldc_w 390
    //   2609: aastore
    //   2610: dup
    //   2611: iconst_3
    //   2612: ldc_w 392
    //   2615: aastore
    //   2616: dup
    //   2617: iconst_4
    //   2618: ldc_w 425
    //   2621: aastore
    //   2622: aload 15
    //   2624: aconst_null
    //   2625: aconst_null
    //   2626: invokevirtual 398	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2629: astore 12
    //   2631: aload 12
    //   2633: astore 11
    //   2635: aload 11
    //   2637: invokeinterface 431 1 0
    //   2642: ifeq +562 -> 3204
    //   2645: aload 13
    //   2647: invokevirtual 454	android/content/ContentValues:clear	()V
    //   2650: aload 13
    //   2652: ldc_w 386
    //   2655: lload 7
    //   2657: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2660: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2663: aload 13
    //   2665: ldc_w 390
    //   2668: ldc_w 494
    //   2671: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2674: aload 13
    //   2676: ldc_w 392
    //   2679: aload_1
    //   2680: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2683: aload 13
    //   2685: ldc_w 425
    //   2688: iconst_2
    //   2689: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2692: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2695: aload_0
    //   2696: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2699: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2702: aload 13
    //   2704: new 152	java/lang/StringBuilder
    //   2707: dup
    //   2708: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2711: ldc_w 412
    //   2714: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: lload 7
    //   2719: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2722: ldc_w 417
    //   2725: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: ldc_w 390
    //   2731: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2734: ldc_w 419
    //   2737: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2740: ldc_w 494
    //   2743: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: ldc_w 423
    //   2749: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: ldc_w 425
    //   2755: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2758: ldc_w 419
    //   2761: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2764: iconst_2
    //   2765: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2768: ldc_w 384
    //   2771: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2774: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2777: aconst_null
    //   2778: invokevirtual 501	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2781: pop
    //   2782: aload 11
    //   2784: ifnull +10 -> 2794
    //   2787: aload 11
    //   2789: invokeinterface 432 1 0
    //   2794: iconst_1
    //   2795: ireturn
    //   2796: aload 13
    //   2798: invokevirtual 454	android/content/ContentValues:clear	()V
    //   2801: aload 13
    //   2803: ldc_w 386
    //   2806: lload 7
    //   2808: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2811: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2814: aload 13
    //   2816: ldc_w 390
    //   2819: ldc_w 474
    //   2822: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2825: aload 13
    //   2827: ldc_w 476
    //   2830: aload 15
    //   2832: getfield 469	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2835: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2838: aload 13
    //   2840: ldc_w 425
    //   2843: iconst_1
    //   2844: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2847: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2850: aload_0
    //   2851: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2854: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2857: aload 13
    //   2859: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2862: pop
    //   2863: goto -1300 -> 1563
    //   2866: astore 12
    //   2868: aload 11
    //   2870: ifnull -1295 -> 1575
    //   2873: aload 11
    //   2875: invokeinterface 432 1 0
    //   2880: goto -1305 -> 1575
    //   2883: astore_1
    //   2884: aload 11
    //   2886: ifnull +10 -> 2896
    //   2889: aload 11
    //   2891: invokeinterface 432 1 0
    //   2896: aload_1
    //   2897: athrow
    //   2898: aload 13
    //   2900: invokevirtual 454	android/content/ContentValues:clear	()V
    //   2903: aload 13
    //   2905: ldc_w 386
    //   2908: lload 7
    //   2910: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2913: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2916: aload 13
    //   2918: ldc_w 390
    //   2921: ldc_w 474
    //   2924: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2927: aload 13
    //   2929: ldc_w 392
    //   2932: aload 15
    //   2934: getfield 472	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2937: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2940: aload 13
    //   2942: ldc_w 425
    //   2945: iconst_1
    //   2946: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2949: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2952: aload_0
    //   2953: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2956: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2959: aload 13
    //   2961: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2964: pop
    //   2965: goto -1104 -> 1861
    //   2968: astore 12
    //   2970: aload 11
    //   2972: ifnull -1099 -> 1873
    //   2975: aload 11
    //   2977: invokeinterface 432 1 0
    //   2982: goto -1109 -> 1873
    //   2985: astore_1
    //   2986: aload 11
    //   2988: ifnull +10 -> 2998
    //   2991: aload 11
    //   2993: invokeinterface 432 1 0
    //   2998: aload_1
    //   2999: athrow
    //   3000: aload 13
    //   3002: invokevirtual 454	android/content/ContentValues:clear	()V
    //   3005: aload 13
    //   3007: ldc_w 386
    //   3010: lload 7
    //   3012: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3015: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3018: aload 13
    //   3020: ldc_w 390
    //   3023: ldc_w 421
    //   3026: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3029: aload 13
    //   3031: ldc_w 392
    //   3034: aload 15
    //   3036: getfield 487	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   3039: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3042: aload 13
    //   3044: ldc_w 425
    //   3047: iconst_3
    //   3048: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3051: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3054: aload_0
    //   3055: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3058: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3061: aload 13
    //   3063: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3066: pop
    //   3067: goto -895 -> 2172
    //   3070: astore 12
    //   3072: aload 11
    //   3074: ifnull -890 -> 2184
    //   3077: aload 11
    //   3079: invokeinterface 432 1 0
    //   3084: goto -900 -> 2184
    //   3087: astore_1
    //   3088: aload 11
    //   3090: ifnull +10 -> 3100
    //   3093: aload 11
    //   3095: invokeinterface 432 1 0
    //   3100: aload_1
    //   3101: athrow
    //   3102: aload 13
    //   3104: invokevirtual 454	android/content/ContentValues:clear	()V
    //   3107: aload 13
    //   3109: ldc_w 386
    //   3112: lload 7
    //   3114: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3117: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3120: aload 13
    //   3122: ldc_w 390
    //   3125: ldc_w 492
    //   3128: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3131: aload 13
    //   3133: ldc_w 392
    //   3136: aload 15
    //   3138: getfield 490	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3141: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3144: aload 13
    //   3146: ldc_w 425
    //   3149: iconst_2
    //   3150: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3153: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3156: aload_0
    //   3157: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3160: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3163: aload 13
    //   3165: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3168: pop
    //   3169: goto -686 -> 2483
    //   3172: astore 12
    //   3174: aload 11
    //   3176: ifnull -681 -> 2495
    //   3179: aload 11
    //   3181: invokeinterface 432 1 0
    //   3186: goto -691 -> 2495
    //   3189: astore_1
    //   3190: aload 11
    //   3192: ifnull +10 -> 3202
    //   3195: aload 11
    //   3197: invokeinterface 432 1 0
    //   3202: aload_1
    //   3203: athrow
    //   3204: aload 13
    //   3206: invokevirtual 454	android/content/ContentValues:clear	()V
    //   3209: aload 13
    //   3211: ldc_w 386
    //   3214: lload 7
    //   3216: invokestatic 457	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3219: invokevirtual 461	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3222: aload 13
    //   3224: ldc_w 390
    //   3227: ldc_w 494
    //   3230: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3233: aload 13
    //   3235: ldc_w 392
    //   3238: aload_1
    //   3239: invokevirtual 466	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3242: aload 13
    //   3244: ldc_w 425
    //   3247: iconst_2
    //   3248: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3251: invokevirtual 484	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3254: aload_0
    //   3255: invokevirtual 374	com/tencent/mobileqq/profilesetting/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3258: getstatic 380	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3261: aload 13
    //   3263: invokevirtual 445	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3266: pop
    //   3267: goto -485 -> 2782
    //   3270: astore_1
    //   3271: aload 11
    //   3273: ifnull -479 -> 2794
    //   3276: aload 11
    //   3278: invokeinterface 432 1 0
    //   3283: goto -489 -> 2794
    //   3286: astore_1
    //   3287: aload 11
    //   3289: ifnull +10 -> 3299
    //   3292: aload 11
    //   3294: invokeinterface 432 1 0
    //   3299: aload_1
    //   3300: athrow
    //   3301: iconst_m1
    //   3302: ireturn
    //   3303: astore_1
    //   3304: goto -17 -> 3287
    //   3307: astore_1
    //   3308: aconst_null
    //   3309: astore 11
    //   3311: goto -40 -> 3271
    //   3314: astore_1
    //   3315: goto -125 -> 3190
    //   3318: astore 11
    //   3320: aconst_null
    //   3321: astore 11
    //   3323: goto -149 -> 3174
    //   3326: astore_1
    //   3327: goto -239 -> 3088
    //   3330: astore 11
    //   3332: aconst_null
    //   3333: astore 11
    //   3335: goto -263 -> 3072
    //   3338: astore_1
    //   3339: goto -353 -> 2986
    //   3342: astore 11
    //   3344: aconst_null
    //   3345: astore 11
    //   3347: goto -377 -> 2970
    //   3350: astore_1
    //   3351: goto -467 -> 2884
    //   3354: astore 11
    //   3356: aconst_null
    //   3357: astore 11
    //   3359: goto -491 -> 2868
    //   3362: astore 12
    //   3364: aload 11
    //   3366: astore_1
    //   3367: aload 12
    //   3369: astore 11
    //   3371: goto -2266 -> 1105
    //   3374: astore 11
    //   3376: aconst_null
    //   3377: astore 11
    //   3379: iconst_0
    //   3380: istore_3
    //   3381: lconst_0
    //   3382: lstore 7
    //   3384: goto -2349 -> 1035
    //   3387: astore 13
    //   3389: lload 9
    //   3391: lstore 7
    //   3393: goto -2358 -> 1035
    //   3396: astore 13
    //   3398: iconst_1
    //   3399: istore_3
    //   3400: lload 9
    //   3402: lstore 7
    //   3404: goto -2369 -> 1035
    //   3407: astore 16
    //   3409: aload 13
    //   3411: astore 14
    //   3413: aload 16
    //   3415: astore 13
    //   3417: goto -2355 -> 1062
    //   3420: astore 16
    //   3422: aload 13
    //   3424: astore 14
    //   3426: iconst_1
    //   3427: istore_2
    //   3428: aload 16
    //   3430: astore 13
    //   3432: goto -2370 -> 1062
    //   3435: astore 14
    //   3437: goto -2429 -> 1008
    //   3440: astore 14
    //   3442: goto -2434 -> 1008
    //   3445: lload 9
    //   3447: lstore 7
    //   3449: iload 5
    //   3451: istore_3
    //   3452: iload 4
    //   3454: istore_2
    //   3455: goto -3006 -> 449
    //   3458: iconst_1
    //   3459: istore_2
    //   3460: iconst_1
    //   3461: istore_3
    //   3462: goto -3035 -> 427
    //   3465: lload 9
    //   3467: lstore 7
    //   3469: goto -3042 -> 427
    //   3472: aconst_null
    //   3473: astore 12
    //   3475: goto -3395 -> 80
    //   3478: aconst_null
    //   3479: astore 15
    //   3481: goto -3434 -> 47
    //   3484: iload_3
    //   3485: istore_2
    //   3486: iconst_1
    //   3487: istore_3
    //   3488: lload 7
    //   3490: lstore 9
    //   3492: goto -3313 -> 179
    //   3495: astore 13
    //   3497: aconst_null
    //   3498: astore 13
    //   3500: goto -2492 -> 1008
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3503	0	this	ProfileCardMoreActivity
    //   0	3503	1	paramString	String
    //   81	3405	2	k	int
    //   83	3405	3	m	int
    //   169	3284	4	n	int
    //   428	3022	5	i1	int
    //   191	209	6	bool	boolean
    //   206	3283	7	l1	long
    //   172	3319	9	l2	long
    //   26	1025	11	localObject1	Object
    //   1100	16	11	localObject2	Object
    //   1286	2024	11	localObject3	Object
    //   3318	1	11	localException1	Exception
    //   3321	1	11	localObject4	Object
    //   3330	1	11	localException2	Exception
    //   3333	1	11	localObject5	Object
    //   3342	1	11	localException3	Exception
    //   3345	1	11	localObject6	Object
    //   3354	1	11	localException4	Exception
    //   3357	13	11	localObject7	Object
    //   3374	1	11	localException5	Exception
    //   3377	1	11	localObject8	Object
    //   78	2554	12	localObject9	Object
    //   2866	1	12	localException6	Exception
    //   2968	1	12	localException7	Exception
    //   3070	1	12	localException8	Exception
    //   3172	1	12	localException9	Exception
    //   3362	6	12	localObject10	Object
    //   3473	1	12	localObject11	Object
    //   85	933	13	localObject12	Object
    //   1029	1	13	localException10	Exception
    //   1060	21	13	localObject13	Object
    //   1083	2179	13	localException11	Exception
    //   3387	1	13	localException12	Exception
    //   3396	14	13	localException13	Exception
    //   3415	16	13	localObject14	Object
    //   3495	1	13	localException14	Exception
    //   3498	1	13	localObject15	Object
    //   125	3300	14	localObject16	Object
    //   3435	1	14	localException15	Exception
    //   3440	1	14	localException16	Exception
    //   45	3435	15	localObject17	Object
    //   96	2188	16	localObject18	Object
    //   3407	7	16	localObject19	Object
    //   3420	9	16	localObject20	Object
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
    //   1425	1563	2866	java/lang/Exception
    //   2796	2863	2866	java/lang/Exception
    //   1288	1421	2883	finally
    //   1723	1861	2968	java/lang/Exception
    //   2898	2965	2968	java/lang/Exception
    //   1586	1719	2985	finally
    //   2021	2172	3070	java/lang/Exception
    //   3000	3067	3070	java/lang/Exception
    //   1884	2017	3087	finally
    //   2332	2483	3172	java/lang/Exception
    //   3102	3169	3172	java/lang/Exception
    //   2195	2328	3189	finally
    //   2635	2782	3270	java/lang/Exception
    //   3204	3267	3270	java/lang/Exception
    //   2498	2631	3286	finally
    //   2635	2782	3303	finally
    //   3204	3267	3303	finally
    //   2498	2631	3307	java/lang/Exception
    //   2332	2483	3314	finally
    //   3102	3169	3314	finally
    //   2195	2328	3318	java/lang/Exception
    //   2021	2172	3326	finally
    //   3000	3067	3326	finally
    //   1884	2017	3330	java/lang/Exception
    //   1723	1861	3338	finally
    //   2898	2965	3338	finally
    //   1586	1719	3342	java/lang/Exception
    //   1425	1563	3350	finally
    //   2796	2863	3350	finally
    //   1288	1421	3354	java/lang/Exception
    //   184	193	3362	finally
    //   198	208	3362	finally
    //   211	218	3362	finally
    //   419	427	3362	finally
    //   996	1003	3362	finally
    //   1017	1024	3362	finally
    //   1070	1077	3362	finally
    //   1080	1083	3362	finally
    //   87	168	3374	java/lang/Exception
    //   184	193	3387	java/lang/Exception
    //   198	208	3396	java/lang/Exception
    //   390	399	3407	finally
    //   408	415	3420	finally
    //   390	399	3435	java/lang/Exception
    //   408	415	3440	java/lang/Exception
    //   226	385	3495	java/lang/Exception
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
      String str = bglf.e(this.app, this.jdField_a_of_type_JavaLangString);
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
    setContentViewB(2131561398);
    Object localObject1;
    label97:
    int n;
    label129:
    int m;
    int k;
    if ("troopMembercard".equals(this.jdField_g_of_type_JavaLangString))
    {
      setTitle(anni.a(2131707218));
      if (this.mLeftBackText != null)
      {
        this.mLeftBackText.setText("");
        this.mLeftBackText.setContentDescription(anni.a(2131707228));
      }
      enableRightHighlight(false);
      localObject1 = findViewById(2131365320);
      if (this.jdField_a_of_type_ArrayOfInt[13] != 1) {
        break label180;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131377901);
      if (this.jdField_a_of_type_ArrayOfInt[14] != 1) {
        break label190;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      n = -1;
      m = -1;
      k = 0;
      label135:
      if (k > 3) {
        break label200;
      }
      if (this.jdField_a_of_type_ArrayOfInt[k] != 1) {
        break label1319;
      }
      if (n >= 0) {
        break label1316;
      }
      n = k;
      label156:
      if (m >= k) {
        break label1313;
      }
      m = k;
    }
    label523:
    label917:
    label1304:
    label1307:
    label1310:
    label1313:
    label1316:
    label1319:
    for (;;)
    {
      k += 1;
      break label135;
      setTitle(2131694539);
      break;
      label180:
      ((View)localObject1).setVisibility(8);
      break label97;
      label190:
      ((View)localObject1).setVisibility(8);
      break label129;
      label200:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131368894));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376360));
      a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout, n, m);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368787));
      a(1, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368909));
      a(2, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368779));
      a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368858));
      a(4, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
      if (this.app.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(anni.a(2131707251));
        this.h = ((FormSimpleItem)findViewById(2131368782));
        this.i = ((FormSimpleItem)findViewById(2131368792));
        a(15, this.h, 15, 16);
        a(16, this.i, 15, 16);
        a(null);
        this.j = ((FormSimpleItem)findViewById(2131368854));
        a(17, this.j, 17, 17);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368857));
        a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 5, 5);
        n = -1;
        m = -1;
        k = 6;
        label501:
        if (k > 12) {
          break label563;
        }
        if (this.jdField_a_of_type_ArrayOfInt[k] != 1) {
          break label1310;
        }
        if (n >= 0) {
          break label1307;
        }
        n = k;
        if (m >= k) {
          break label1304;
        }
        m = k;
      }
      for (;;)
      {
        k += 1;
        break label501;
        if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(anni.a(2131707240));
        break;
        label563:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377731));
        a(7, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368823));
        a(8, this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, m);
        if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          bcst.b(null, "dc00898", "", "", "0X8009F70", "0X8009F70", 0, 0, "", "", "", "");
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377263));
        a(10, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377266));
        a(9, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371386));
        a(11, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377269));
        a(12, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, n, m);
        anmw localanmw;
        label976:
        boolean bool;
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localanmw = (anmw)this.app.getManager(51);
          if (localanmw == null)
          {
            localObject1 = null;
            Object localObject2;
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
              this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localObject2 = localanmw.a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!bgjw.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
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
                break label1243;
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
              if (localanmw != null) {
                break label1252;
              }
              localObject1 = null;
              localObject2 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if ((localObject1 == null) || (!((Card)localObject1).babyQSwitch)) {
                break label1265;
              }
              bool = true;
              label998:
              ((FormSwitchItem)localObject2).setChecked(bool);
              ((anip)this.app.a(2)).v();
            }
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 0)
            {
              if ((localanmw == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
                break label1271;
              }
              this.jdField_a_of_type_Boolean = localanmw.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              label1063:
              d();
            }
            if ((localanmw != null) && (localanmw.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
              l();
            }
          }
        }
        for (;;)
        {
          if (AppSetting.c)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131717774));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716033));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694475));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131707201));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690568));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anni.a(2131707211));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694558));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
          }
          return;
          localObject1 = localanmw.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break;
          label1243:
          localObject1 = this.jdField_c_of_type_JavaLangString;
          break label917;
          label1252:
          localObject1 = localanmw.c(anhk.aC);
          break label976;
          label1265:
          bool = false;
          break label998;
          label1271:
          this.jdField_a_of_type_Boolean = false;
          break label1063;
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
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839432));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839448));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839439));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839442));
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
    int m = 0;
    if (paramBusinessCard == null) {
      return;
    }
    String str = "";
    Object localObject1 = (anmw)this.app.getManager(51);
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
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130845760));
    }
    int k;
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
      k = 0;
      while (k < paramBusinessCard.mobilesNum.size())
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append((String)paramBusinessCard.mobilesNum.get(k));
        k += 1;
      }
      localObject2 = ((anmw)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label242:
      a(this.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    label254:
    if ((paramBusinessCard.descs != null) && (!paramBusinessCard.descs.isEmpty()))
    {
      k = m;
      if (((StringBuilder)localObject2).length() != 0)
      {
        ((StringBuilder)localObject2).append("，");
        k = m;
      }
      while (k < paramBusinessCard.descs.size())
      {
        ((StringBuilder)localObject2).append((String)paramBusinessCard.descs.get(k));
        k += 1;
      }
    }
    this.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    b((String)localObject1);
  }
  
  void a(Card paramCard)
  {
    if (this.jdField_a_of_type_Aeij != null) {
      this.jdField_a_of_type_Aeij.a(paramCard);
    }
  }
  
  void a(String paramString)
  {
    bkho localbkho = bkho.a(this);
    if (bgjw.b(paramString)) {
      localbkho.a(2131690492);
    }
    for (;;)
    {
      localbkho.a(2131691329, 3);
      localbkho.c(2131690582);
      localbkho.a(new azsd(this, paramString, localbkho));
      localbkho.show();
      return;
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        localbkho.a(2131690494);
      } else {
        localbkho.a(2131690493);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((anmw)this.app.getManager(51)).b(paramString1);
    int k = 17;
    if (localObject1 != null) {
      k = ((Friends)localObject1).cSpecialFlag;
    }
    Object localObject2 = new bcvp(StructMsgForGeneralShare.class);
    Object localObject3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + k;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + k;
    String str2 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + k;
    localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    localObject2 = ((bcvp)localObject2).c(14).a(2).a(1).a(anni.a(2131707203) + paramString2).a("plugin", str2, "", (String)localObject3, str1).d(getResources().getString(2131717269)).a();
    localObject3 = new bcyl();
    ((bcvt)localObject3).b(1);
    ((bcvt)localObject3).a(new bcxv((String)localObject1));
    ((bcvt)localObject3).a(new StructMsgItemTitle(paramString2));
    ((bcvt)localObject3).a(new bdaq(anni.a(2131707200) + bjft.b(this.app, paramString1)));
    ((AbsShareMsg)localObject2).addItem(a(anni.a(2131707248)));
    ((AbsShareMsg)localObject2).addItem((bcvs)localObject3);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    aufz.a(this, paramString2, 21);
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (bgnt.d(BaseApplication.getContext()))
    {
      awhl localawhl = (awhl)this.app.getManager(16);
      if (localawhl != null) {}
      for (;;)
      {
        int k;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = a();
          }
          long l = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          k = bghy.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localawhl.b(k, (List)localObject);
            k = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            m = k;
            if (m == 0) {
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
            localawhl.a(k, (List)localObject);
            continue;
            k = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int m = k;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          m = k;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              m = 1;
              break;
              this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label309:
            paramBoolean = false;
          }
        }
      }
      label314:
      if (paramBoolean) {
        a(2131718043, 1);
      }
      for (;;)
      {
        d();
        return;
        a(2131718045, 1);
      }
    }
    a(2131691985, 1);
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
        a(2131718044, 2);
      }
    }
    else
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFD;
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label144;
      }
      anmw localanmw = (anmw)this.app.getManager(51);
      if ((localanmw == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label136;
      }
      this.jdField_a_of_type_Boolean = localanmw.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      d();
      return;
      a(2131718056, 2);
      break;
      label112:
      if (paramBoolean2)
      {
        a(2131718043, 1);
        break;
      }
      a(2131718045, 1);
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
    awhl localawhl = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localawhl = (awhl)this.app.getManager(16);
      if (localawhl == null) {
        break label162;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localawhl.a((String)localObject);
      localObject = (anmw)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = localawhl; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((anmw)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
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
    this.jdField_a_of_type_ArrayOfInt = new int[18];
    int k = 0;
    while (k < 18)
    {
      this.jdField_a_of_type_ArrayOfInt[k] = 0;
      k += 1;
    }
    if (this.app.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[15] = 1;
      this.jdField_a_of_type_ArrayOfInt[16] = 1;
      this.jdField_a_of_type_ArrayOfInt[17] = 1;
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
        if (bgjw.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ArrayOfInt[2] = 1;
          this.jdField_a_of_type_ArrayOfInt[11] = 1;
          this.jdField_a_of_type_ArrayOfInt[13] = 1;
        }
        else
        {
          this.jdField_a_of_type_ArrayOfInt[0] = 1;
          if ((nki.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (bjft.b(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
          {
            k = 1;
            label197:
            if (k != 0)
            {
              if (!((bjft)this.app.getManager(165)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
                break label337;
              }
              this.jdField_a_of_type_ArrayOfInt[3] = 0;
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfInt[4] = 1;
            if (k == 0)
            {
              this.jdField_a_of_type_ArrayOfInt[5] = 1;
              this.jdField_a_of_type_ArrayOfInt[10] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[6] = 1;
            this.jdField_a_of_type_ArrayOfInt[7] = 1;
            if (axas.a(this.app.c())) {
              this.jdField_a_of_type_ArrayOfInt[8] = 1;
            }
            this.jdField_a_of_type_ArrayOfInt[9] = 1;
            this.jdField_a_of_type_ArrayOfInt[12] = 1;
            this.jdField_a_of_type_ArrayOfInt[13] = 1;
            this.jdField_a_of_type_ArrayOfInt[14] = 1;
            break;
            k = 0;
            break label197;
            label337:
            this.jdField_a_of_type_ArrayOfInt[3] = 1;
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27))
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 78)
      {
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 95)
      {
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 117)
      {
        this.jdField_a_of_type_ArrayOfInt[12] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
      else if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
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
    Object localObject = (anmw)this.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((anmw)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  void c(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(bgjb.a(this, "bc_remark_first"))) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.getVisibility() == 8)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365746));
    }
    if (paramInt1 < 0) {}
    for (paramInt1 = 0;; paramInt1 = afur.a(10.0F, getResources()))
    {
      int k = paramInt2;
      if (paramInt2 < 0) {
        k = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramInt1, k, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      bgjb.a(this, "bc_remark_first", "false");
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Aeij != null) {
      this.jdField_a_of_type_Aeij.a(paramArrayOfByte);
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
    while ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (bgjw.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
        if (bgnt.d(BaseApplication.getContext()))
        {
          if ((!bool) && (paramIntent.equals(this.jdField_e_of_type_JavaLangString))) {
            break;
          }
          if (!paramIntent.equals(this.jdField_b_of_type_JavaLangString))
          {
            localObject = (FriendListHandler)this.app.a(1);
            if (localObject != null)
            {
              ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent, false);
              this.jdField_a_of_type_Int |= 0x1;
              b(paramIntent);
              paramIntent = new bmji();
              paramIntent.jdField_a_of_type_Int = 5;
              bmjh.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a(paramIntent);
              return;
            }
            a(2131693026, 1);
            return;
          }
          a(2131693012, 0);
          return;
        }
        a(2131693988, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131718387));
        localObject = afur.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
        if (this.jdField_a_of_type_Aeij == null) {
          break;
        }
        this.jdField_a_of_type_Aeij.a(paramInt2, paramIntent);
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
    try
    {
      b();
      a();
      this.jdField_a_of_type_Aeij = new aeij(this, this);
      this.jdField_a_of_type_Aeij.jdField_a_of_type_Int = getIntent().getIntExtra("coverTimeStamp", 0);
      this.jdField_a_of_type_Aeij.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("coverUrl");
      this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(this.app.c(), 0);
      }
      this.jdField_a_of_type_Apyx = ((apyx)this.app.getManager(112));
      addObserver(this.jdField_a_of_type_Anqd);
      addObserver(this.jdField_a_of_type_Anuw);
      addObserver(this.jdField_a_of_type_Aniz);
      addObserver(this.jdField_a_of_type_Anmu);
      addObserver(this.jdField_a_of_type_Aupb);
      this.app.registObserver(this.jdField_a_of_type_Apyy);
      this.app.setHandler(ProfileCardMoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      if ((this.jdField_d_of_type_JavaLangString == null) || (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        ThreadManager.excute(new ProfileCardMoreActivity.1(this), 16, null, true);
      }
      alyw.a(this.app);
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
    if (this.jdField_a_of_type_Aeij != null)
    {
      this.jdField_a_of_type_Aeij.a();
      this.jdField_a_of_type_Aeij = null;
    }
    f();
    removeObserver(this.jdField_a_of_type_Anqd);
    removeObserver(this.jdField_a_of_type_Anuw);
    removeObserver(this.jdField_a_of_type_Aniz);
    removeObserver(this.jdField_a_of_type_Anmu);
    removeObserver(this.jdField_a_of_type_Aupb);
    this.app.unRegistObserver(this.jdField_a_of_type_Apyy);
    this.app.removeHandler(ProfileCardMoreActivity.class);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Aeij != null)) {
      this.jdField_a_of_type_Aeij.a(paramIntent, localArrayList);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((anmw)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
    {
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label67;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131717666));
    }
    for (;;)
    {
      j();
      return;
      label67:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131717667));
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Biau == null)
    {
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
      this.jdField_a_of_type_Biau.c(2131717771);
    }
    this.jdField_a_of_type_Biau.show();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Biau.cancel();
      this.jdField_a_of_type_Biau = null;
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
    if ((this.jdField_a_of_type_Aeij != null) && (this.jdField_a_of_type_Aeij.jdField_a_of_type_Boolean))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Aeij.jdField_a_of_type_ArrayOfByte);
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
    Object localObject1 = (anmw)this.app.getManager(51);
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
        localObject1 = ((anmw)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      int k;
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
        k = 20005;
      }
      label119:
      label508:
      for (;;)
      {
        if ((k == 20005) || (k == 20015) || (k == 25020)) {
          abao.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, abao.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, abao.b(2)), str2, null, this.app.getCurrentAccountUin(), k, null, (Bundle)localObject1);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int), Integer.valueOf(k), str2, str1, localObject1 }));
          }
          bcst.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          str2 = "0";
          break;
          int m;
          if (ProfileActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            m = 20008;
            k = m;
            if (localObject1 != null) {
              break label508;
            }
            localObject1 = abao.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, 1);
            k = m;
            break label119;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 117)
          {
            k = 25028;
            break label119;
          }
          if (ProfileActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            m = 20013;
            k = m;
            if (localObject1 != null) {
              break label508;
            }
            localObject1 = abao.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString, 3000);
            k = m;
            break label119;
          }
          if (localObject1 != null)
          {
            if (((Bundle)localObject1).containsKey("chattype"))
            {
              k = abao.a(((Bundle)localObject1).getInt("chattype"));
              break label119;
            }
            if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              k = 21000;
              break label119;
            }
            k = 20002;
            break label119;
          }
          if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            k = 21001;
            break label119;
          }
          k = 20001;
          break label119;
          abao.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, null, str2, str1, this.app.getAccount(), k, null, (Bundle)localObject1);
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    int k = 1;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      localObject1 = this.app;
      if (paramBoolean)
      {
        k = 1;
        bcst.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, k, "0", "0", "", "");
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
        k = 2;
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
        if (!bgnt.d(BaseApplication.getContext())) {
          break label278;
        }
        localObject1 = (FriendListHandler)this.app.a(1);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        ((FriendListHandler)localObject1).a((short)1, (List)localObject2, paramBoolean);
        if (paramBoolean) {
          bcst.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
        } else {
          bcst.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
        }
      }
      a(2131691985, 1);
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
        if (bgnt.d(BaseApplication.getContext()))
        {
          ((anip)this.app.a(2)).m(paramBoolean);
          localObject1 = this.app;
          if (paramBoolean) {}
          for (;;)
          {
            bcst.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(k), "", "", "");
            break;
            k = 0;
          }
        }
        a(2131691985, 1);
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
    if (!bgnt.d(BaseApplication.getContext()))
    {
      a(2131691985, 1);
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
      l = bbyp.a();
      label609:
      FriendsStatusUtil.b((QQAppInterface)localObject1, (String)localObject2, 0, l, true, false);
      localObject1 = this.app;
      if (!paramCompoundButton.isChecked()) {
        break label675;
      }
    }
    label675:
    for (k = 1;; k = 2)
    {
      bcst.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, k, "0", "0", "", "");
      break;
      l = 0L;
      break label609;
    }
  }
  
  public void onClick(View paramView)
  {
    int k;
    if (paramView == null)
    {
      k = 0;
      switch (k)
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
      k = paramView.getId();
      break;
      bghy.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      bcst.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      bcst.b(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
      continue;
      c();
      bcst.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      continue;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (checkSelfPermission("android.permission.WRITE_CONTACTS") != 0) {
          requestPermissions(new azsa(this, this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        } else {
          g();
        }
      }
      else
      {
        g();
        continue;
        String str1;
        if (((bjft)this.app.getManager(165)).f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = bglf.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
          bcst.b(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
          break;
          if (this.jdField_a_of_type_Azfh == null) {
            this.jdField_a_of_type_Azfh = new azfh(this, this.app, 0, new azsb(this));
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = bglf.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_Azfh.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
        }
        label623:
        blsi localblsi;
        for (;;)
        {
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
              break label623;
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
          localblsi = null;
        }
        i();
        continue;
        try
        {
          localblsi = blsi.a();
          localblsi.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
          localblsi.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
          blsb.a(this, localblsi, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
          bcst.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        }
        catch (Exception localException2) {}
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, localException2.toString());
          continue;
          alyw.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 3);
          bcst.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
          continue;
          bcst.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
          Object localObject = ((anmw)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if (localObject != null) {
            if ((((ExtensionInfo)localObject).intimate_type == 2) || (((ExtensionInfo)localObject).intimate_type == 3) || (((ExtensionInfo)localObject).intimate_type == 1))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              aevv.a(this, (Intent)localObject, PublicFragmentActivity.class, IntimateInfoFragment.class);
              if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "jumpIntimatePage");
              }
            }
            else
            {
              localObject = axas.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "click item_friend_intimate url:" + (String)localObject);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject));
                continue;
                localObject = new Intent(this, AvatarPendantActivity.class);
                ((Intent)localObject).putExtra("AllInOne", this.jdField_b_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
                ((Intent)localObject).putExtra("showActionSheet", true);
                startActivity((Intent)localObject);
                bcst.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
                continue;
                if (this.jdField_a_of_type_Aeij != null)
                {
                  localObject = this.jdField_a_of_type_Aeij;
                  if (this.jdField_a_of_type_Aeij.jdField_a_of_type_Int != 0) {
                    break label1157;
                  }
                }
                label1157:
                for (boolean bool = true;; bool = false)
                {
                  ((aeij)localObject).a(bool);
                  bcst.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
                  break;
                }
                k();
                bcst.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
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