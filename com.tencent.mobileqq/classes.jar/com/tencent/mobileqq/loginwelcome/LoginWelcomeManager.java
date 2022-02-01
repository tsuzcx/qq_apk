package com.tencent.mobileqq.loginwelcome;

import SecurityAccountServer.RecommendedContactInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import antf;
import anui;
import anum;
import anuw;
import aoip;
import aojs;
import apaw;
import aran;
import awvo;
import awvp;
import awvq;
import awvr;
import awvs;
import awvt;
import awvu;
import awvv;
import awvw;
import awvx;
import awvy;
import awvz;
import awwa;
import axfs;
import axxj;
import axxn;
import azou;
import azow;
import azox;
import bdll;
import bhhu;
import bhhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.BindContactInfo;
import tzq;
import yzv;

public class LoginWelcomeManager
  implements anui, axfs, Runnable, Manager
{
  public static int a;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private anuw jdField_a_of_type_Anuw = new awvs(this);
  public aojs a;
  private awvo jdField_a_of_type_Awvo;
  awvw jdField_a_of_type_Awvw = null;
  awvx jdField_a_of_type_Awvx = null;
  public awvz a;
  awwa jdField_a_of_type_Awwa;
  public axxn a;
  private azow jdField_a_of_type_Azow = new awvt(this);
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private WeakReference<MessengerService> jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  private int jdField_b_of_type_Int;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private String c;
  public boolean c;
  private boolean d;
  private boolean e;
  
  public LoginWelcomeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Axxn = new awvp(this);
    this.jdField_a_of_type_Aojs = new awvq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awvo = ((awvo)paramQQAppInterface.a(84));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this, true);
  }
  
  public static LoginWelcomeManager a(QQAppInterface paramQQAppInterface)
  {
    return (LoginWelcomeManager)paramQQAppInterface.getManager(146);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 118	java/io/File
    //   6: dup
    //   7: getstatic 123	antf:cR	Ljava/lang/String;
    //   10: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 130	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_2
    //   22: invokevirtual 133	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 118	java/io/File
    //   29: dup
    //   30: aload_2
    //   31: ldc 135
    //   33: invokespecial 138	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 130	java/io/File:exists	()Z
    //   43: ifeq +9 -> 52
    //   46: aload 5
    //   48: invokevirtual 141	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_1
    //   53: invokestatic 147	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   56: sipush 200
    //   59: sipush 200
    //   62: iconst_1
    //   63: invokestatic 153	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   66: astore 7
    //   68: new 155	java/io/FileOutputStream
    //   71: dup
    //   72: aload 5
    //   74: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   77: astore_2
    //   78: new 160	java/io/BufferedOutputStream
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 163	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore_1
    //   87: aload_1
    //   88: astore 4
    //   90: aload_2
    //   91: astore_3
    //   92: aload 7
    //   94: getstatic 169	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 100
    //   99: aload_1
    //   100: invokevirtual 173	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload_1
    //   105: astore 4
    //   107: aload_2
    //   108: astore_3
    //   109: aload_1
    //   110: invokevirtual 176	java/io/BufferedOutputStream:flush	()V
    //   113: aload_1
    //   114: astore 4
    //   116: aload_2
    //   117: astore_3
    //   118: aload 5
    //   120: invokevirtual 180	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: astore 5
    //   125: aload 5
    //   127: astore_3
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   136: aload_3
    //   137: astore_2
    //   138: aload_1
    //   139: ifnull +9 -> 148
    //   142: aload_1
    //   143: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   146: aload_3
    //   147: astore_2
    //   148: aload_2
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_1
    //   157: astore 4
    //   159: aload_2
    //   160: astore_3
    //   161: ldc 186
    //   163: iconst_1
    //   164: ldc 188
    //   166: aload 5
    //   168: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   179: aload 6
    //   181: astore_2
    //   182: aload_1
    //   183: ifnull -35 -> 148
    //   186: aload_1
    //   187: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_1
    //   193: aconst_null
    //   194: areturn
    //   195: astore_1
    //   196: aconst_null
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_2
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   209: aload 4
    //   211: ifnull +8 -> 219
    //   214: aload 4
    //   216: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_2
    //   222: goto -86 -> 136
    //   225: astore_1
    //   226: aload_3
    //   227: areturn
    //   228: astore_2
    //   229: goto -50 -> 179
    //   232: astore_2
    //   233: goto -24 -> 209
    //   236: astore_2
    //   237: goto -18 -> 219
    //   240: astore_1
    //   241: aconst_null
    //   242: astore 4
    //   244: goto -43 -> 201
    //   247: astore_1
    //   248: aload_3
    //   249: astore_2
    //   250: goto -49 -> 201
    //   253: astore 5
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -101 -> 156
    //   260: astore 5
    //   262: goto -106 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	LoginWelcomeManager
    //   0	265	1	paramString	String
    //   13	193	2	localObject1	Object
    //   221	1	2	localException1	Exception
    //   228	1	2	localException2	Exception
    //   232	1	2	localException3	Exception
    //   236	1	2	localException4	Exception
    //   249	1	2	localObject2	Object
    //   91	158	3	localObject3	Object
    //   88	155	4	str	String
    //   36	90	5	localObject4	Object
    //   150	17	5	localException5	Exception
    //   253	1	5	localException6	Exception
    //   260	1	5	localException7	Exception
    //   1	179	6	localObject5	Object
    //   66	27	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   3	26	150	java/lang/Exception
    //   26	52	150	java/lang/Exception
    //   52	78	150	java/lang/Exception
    //   186	190	192	java/lang/Exception
    //   3	26	195	finally
    //   26	52	195	finally
    //   52	78	195	finally
    //   132	136	221	java/lang/Exception
    //   142	146	225	java/lang/Exception
    //   175	179	228	java/lang/Exception
    //   205	209	232	java/lang/Exception
    //   214	219	236	java/lang/Exception
    //   78	87	240	finally
    //   92	104	247	finally
    //   109	113	247	finally
    //   118	125	247	finally
    //   161	171	247	finally
    //   78	87	253	java/lang/Exception
    //   92	104	260	java/lang/Exception
    //   109	113	260	java/lang/Exception
    //   118	125	260	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((azou)paramQQAppInterface.a(134)).b(paramQQAppInterface.getCurrentAccountUin());
    a(paramQQAppInterface, true);
    bdll.b(paramQQAppInterface, "dc00898", "", "", "0X8009F49", "0X8009F49", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((azou)paramQQAppInterface.a(134)).a(paramQQAppInterface.getCurrentAccountUin(), paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "saveContactsGuidePopWindowState，hasAlert=" + paramBoolean);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("sp_key_contactsguide_popwindow_state", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  private void a(RecentUser paramRecentUser)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realShowCGRU");
    }
    apaw localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    paramRecentUser.lastmsgtime = -1L;
    paramRecentUser.lastmsgdrafttime = -1L;
    paramRecentUser.opTime = -1L;
    paramRecentUser.showUpTime = -1L;
    localapaw.saveRecentUser(paramRecentUser);
    paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (paramRecentUser != null) {
      paramRecentUser.sendEmptyMessage(1009);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1;
    if (paramQQAppInterface == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.getPreferences().getBoolean("sp_key_contactsguide_popwindow_state", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "hasContactsGuidePopWindow，hasAlert=" + bool2);
    return bool2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool;
    if ((paramQQAppInterface == null) || (paramRecentUser == null) || (paramRecentUser.extraInfo == null) || (!(paramRecentUser.extraInfo instanceof awvy))) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "contactsGuideRecenUserUiReady, result=" + bool);
      }
      return bool;
      paramQQAppInterface = (awvy)paramRecentUser.extraInfo;
      if ((paramQQAppInterface.jdField_a_of_type_Boolean) && (paramQQAppInterface.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramQQAppInterface.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Int > 0) {
      bdll.b(paramQQAppInterface, "dc00898", "", "", "0X8009F4B", "0X8009F4B", 0, jdField_a_of_type_Int, 0, "", "", "", "");
    }
    jdField_a_of_type_Int = 0;
  }
  
  private void f(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("path");
    boolean bool = paramBundle.getBoolean("PhotoConst.SYNCQZONE", false);
    String str2 = paramBundle.getString("PhotoConst.SOURCE_FROM");
    this.jdField_c_of_type_JavaLangString = a(str1);
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SYNCQZONE", bool);
    localIntent.putExtra("PhotoConst.SOURCE_FROM", str2);
    if (bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, localIntent))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
      return;
    }
    paramBundle.putInt("result", 0);
    b();
  }
  
  public awvw a()
  {
    if (this.jdField_a_of_type_Awvw == null)
    {
      this.jdField_a_of_type_Awvw = new awvw();
      this.jdField_a_of_type_Awvw.jdField_a_of_type_Int = 0;
    }
    return this.jdField_a_of_type_Awvw;
  }
  
  public awvx a()
  {
    if (this.jdField_a_of_type_Awvx == null)
    {
      this.jdField_a_of_type_Awvx = new awvx();
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("loginwelcome_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
      }
      this.jdField_a_of_type_Awvx.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_convguide_entrance", false);
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "getContactsGuideInfo, \n" + this.jdField_a_of_type_Awvx);
      }
    }
    return this.jdField_a_of_type_Awvx;
  }
  
  public awwa a()
  {
    if (this.jdField_a_of_type_Awwa == null)
    {
      this.jdField_a_of_type_Awwa = ((awwa)aran.a().a(454));
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "getWelcomeIntervalConfig, \n" + this.jdField_a_of_type_Awwa);
      }
    }
    return this.jdField_a_of_type_Awwa;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("loginwelcome_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("first_login", 0);
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "requestIsFirstLogin state=" + i);
    }
    if (i != 1)
    {
      this.jdField_a_of_type_Awvo.a(true);
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putBoolean("first_device", false);
      localEditor.putInt("bubble_tips_time", 0);
      localEditor.putInt("first_login", 1);
      localEditor.commit();
    }
    label323:
    label329:
    label334:
    for (;;)
    {
      return;
      a();
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_key_contactsguide_last_req_time", 0L);
      long l2;
      boolean bool1;
      if (this.jdField_a_of_type_Awwa != null)
      {
        i = this.jdField_a_of_type_Awwa.jdField_a_of_type_Int;
        l2 = System.currentTimeMillis();
        if (Math.abs(l2 - l1) <= i * 60 * 1000) {
          break label323;
        }
        bool1 = true;
        label218:
        boolean bool2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("request_state", true);
        if ((!bool1) || (!bool2)) {
          break label329;
        }
        this.jdField_a_of_type_Awvo.a(false);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label334;
        }
        QLog.d("LoginWelcomeManager", 2, "requestIsFirstLogin, doReq=" + bool1 + ",curTime=" + l2 + ",lastReqTime=" + l1 + ",reqInternal=" + i);
        return;
        i = 360;
        break;
        bool1 = false;
        break label218;
        e();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onBindStateChanged bindState=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((paramInt != 8) && (paramInt != 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onBindStateChanged upload end, time cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) }));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp != null)
      {
        if (paramInt != 9) {
          break label122;
        }
        if (!this.d) {
          break label115;
        }
        b(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = null;
      return;
      label115:
      c();
      continue;
      label122:
      if (paramInt == 2)
      {
        if (this.d) {
          b(true);
        } else {
          d();
        }
      }
      else if (this.d) {
        b(false);
      } else {
        a(null);
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext)
  {
    String str = this.jdField_b_of_type_JavaLangString + String.format(Locale.getDefault(), "&appid=%d", new Object[] { Integer.valueOf(AppSetting.a()) });
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("startNewerGuideWebPage url=%s", new Object[] { str }));
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axxn);
    axxj localaxxj = (axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(60);
    long l = paramBundle.getLong("tinyId");
    bhhu.a(localaxxj, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "", 100, null, 0L, false, 0L, false, 0L, 0);
  }
  
  public void a(awvz paramawvz)
  {
    this.jdField_a_of_type_Awvz = paramawvz;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "setConvListener, listener=" + paramawvz);
    }
    if (this.jdField_a_of_type_Awvz != null) {
      ThreadManagerV2.postImmediately(new LoginWelcomeManager.6(this), null, true);
    }
  }
  
  public void a(awwa paramawwa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onUpdateConfig, \n" + paramawwa);
    }
    this.jdField_a_of_type_Awwa = paramawwa;
  }
  
  public void a(MessengerService paramMessengerService, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() != paramMessengerService)) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramMessengerService);
    }
    paramMessengerService = paramBundle.getBundle("request");
    String str = paramMessengerService.getString("key_action");
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "handleWebRequest method=" + str);
    }
    if ((str.equals("uploadContacts")) || (str.equals("getRecommendedList")))
    {
      this.jdField_b_of_type_AndroidOsBundle = paramBundle;
      a(str.equals("uploadContacts"));
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidOsBundle == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LoginWelcomeManager", 2, "last request has not return.");
      return;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      if (str.equals("followPublicAccount"))
      {
        c(paramMessengerService);
        return;
      }
      if (str.equals("joinTroop"))
      {
        b(paramMessengerService);
        return;
      }
      if (str.equals("joinTroopByTap"))
      {
        d(paramMessengerService);
        return;
      }
      if (str.equals("sayHi"))
      {
        a(paramMessengerService);
        return;
      }
      if (str.equals("setAvatar"))
      {
        f(paramMessengerService);
        return;
      }
    } while (!str.equals("getRecommendedListNew"));
    e(paramMessengerService);
  }
  
  public void a(List<RecommendedContactInfo> paramList)
  {
    int i = 0;
    if (QLog.isColorLevel())
    {
      if (paramList != null) {
        i = paramList.size();
      }
      QLog.d("LoginWelcomeManager", 2, String.format("onGetNewerGuideRecommended list=%s, count=%s", new Object[] { paramList, Integer.valueOf(i) }));
    }
    if (this.jdField_b_of_type_AndroidOsBundle == null) {}
    do
    {
      return;
      Object localObject = "";
      if (paramList != null)
      {
        localObject = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a();
        JSONArray localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)paramList.next();
          String str = MsfSdkUtils.insertMtype("QQHeadIcon", localRecommendedContactInfo.faceUrl + ((QQHeadDownloadHandler)localObject).a((byte)(int)localRecommendedContactInfo.faceFlag));
          localRecommendedContactInfo.url = (str + "&t=" + System.currentTimeMillis());
          localJSONArray.put(localRecommendedContactInfo.toJson());
        }
        localObject = localJSONArray.toString();
      }
      paramList = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
      if (paramList != null) {
        paramList.putString("op_result", (String)localObject);
      }
      paramList = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (paramList == null);
    paramList.a(this.jdField_b_of_type_AndroidOsBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.d = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.m();
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("getRecommendedList uploadContactsOnly=%s hasPermission=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.i())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d() == 9)
        {
          if (this.d)
          {
            b(true);
            return;
          }
          c();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.c();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.j();
      return;
    }
    if (this.d)
    {
      b(false);
      return;
    }
    a(null);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 1) && (paramObject[0] != null))
      {
        this.jdField_a_of_type_Awvx = ((awvx)paramObject[0]);
        h();
        e();
        paramObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        paramObject.putBoolean("sp_key_show_convguide_entrance", this.jdField_a_of_type_Awvx.jdField_b_of_type_Boolean);
        paramObject.commit();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onGetContactsGuide，isSuccess=" + paramBoolean + ", mContactsGuideInfo=" + a());
    }
  }
  
  public boolean a()
  {
    if (!a().jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, needShow is false");
      }
      return false;
    }
    if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).k())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, has ReadContactPer");
      }
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = (RecentUser)((apaw)localObject).findRecentUser(antf.ag, 8111);
    localObject = (RecentUser)((apaw)localObject).findRecentUser("sp_uin_for_title", 8112);
    if ((localRecentUser != null) || (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU， mayKnowFriend has show");
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    MessengerService localMessengerService = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localMessengerService != null)
    {
      localMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidOsBundle = null;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LoginWelcomeManager", 2, "respToWeb no service");
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress percentage=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.c >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress upload packages >= 2, time cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) }));
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d();
      if ((paramInt != 8) && (paramInt != 9)) {
        break label136;
      }
      if (!this.d) {
        break label129;
      }
      b(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = null;
      return;
      label129:
      c();
      continue;
      label136:
      if ((paramInt == 4) || (paramInt == 2)) {
        if (this.d) {
          b(true);
        } else {
          d();
        }
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    aoip localaoip = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localaoip != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
      localaoip.a(Long.parseLong(paramBundle), 8390784);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LoginWelcomeManager", 2, "joinTroop err", paramBundle);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onUploadContactsCompleted success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_b_of_type_AndroidOsBundle == null) {
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    if (localObject != null) {
      if (!paramBoolean) {
        break label90;
      }
    }
    for (;;)
    {
      ((Bundle)localObject).putInt("result", i);
      localObject = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localObject == null) {
        break;
      }
      ((MessengerService)localObject).a(this.jdField_b_of_type_AndroidOsBundle);
      return;
      label90:
      i = 0;
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 2) && (paramObject[1] != null) && ((paramObject[1] instanceof awvw)))
      {
        this.jdField_a_of_type_Awvw = ((awvw)paramObject[1]);
        i();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onGetCommonGuide，isSuccess=" + paramBoolean + ", mCommonGuideInfo=" + a());
    }
  }
  
  public boolean b()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=false, hasPopWindow");
      }
    }
    do
    {
      return false;
      Object localObject = a();
      boolean bool = ((awvx)localObject).jdField_a_of_type_Boolean;
      localObject = ((awvx)localObject).jdField_a_of_type_JavaLangString;
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=true, showWelcomepage");
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=false");
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedList");
    }
    if (this.jdField_b_of_type_AndroidOsBundle == null) {
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    if (localObject != null) {}
    for (int i = ((Bundle)localObject).getInt("wantCount");; i = 0)
    {
      if (i > 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedList wantCount=%s", new Object[] { Integer.valueOf(i) }));
        }
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azox.class);
        ((NewIntent)localObject).putExtra("req_type", 36);
        ((NewIntent)localObject).putExtra("unique_phone_no", this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a());
        ((NewIntent)localObject).putExtra("wantCount", i);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
        i = 21;
      }
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str, new awvr(this, paramBundle), true, 15);
  }
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 3) && (paramObject[2].equals(Boolean.FALSE)))
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putBoolean("request_state", false);
        localEditor.commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "onSetRequestOpen，reqOpen=" + paramObject[2]);
      }
    }
  }
  
  public boolean c()
  {
    if (a().jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "NotCommonGuideWeb, showType is 0");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "allowCommonGuideWeb，result=true");
    }
    return true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedListNotBind");
    }
    if (this.jdField_b_of_type_AndroidOsBundle == null) {
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    if (localObject != null) {}
    for (int i = ((Bundle)localObject).getInt("wantCount");; i = 0)
    {
      if (i > 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedListNotBind wantCount=%s", new Object[] { Integer.valueOf(i) }));
        }
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azox.class);
        ((NewIntent)localObject).putExtra("req_type", 40);
        ((NewIntent)localObject).putExtra("unique_phone_no", this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a());
        ((NewIntent)localObject).putExtra("wantCount", i);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
        i = 21;
      }
    }
  }
  
  public void d(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "joinGroupByTap");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
    ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU");
    }
    if (!a())
    {
      f();
      return;
    }
    a();
    RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().findRecentUser(antf.aS, 8114);
    if (localRecentUser == null) {
      localRecentUser = new RecentUser(antf.aS, 8114);
    }
    for (;;)
    {
      awvy localawvy;
      Object localObject;
      if ((localRecentUser.extraInfo != null) && ((localRecentUser.extraInfo instanceof awvy)))
      {
        localawvy = (awvy)localRecentUser.extraInfo;
        localRecentUser.extraInfo = localawvy;
        localObject = localawvy.jdField_a_of_type_ComTencentImageURLDrawable;
        if (localObject != null) {
          break label312;
        }
        if ((this.jdField_a_of_type_Awwa == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Awwa.jdField_b_of_type_JavaLangString))) {
          break label296;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = yzv.a(BaseApplicationImpl.getApplication().getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)(((URLDrawable.URLDrawableOptions)localObject).mRequestWidth * 0.5D + 0.5D));
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Awwa.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setURLDrawableListener(new awvu(this, localawvy, localRecentUser));
        i = ((URLDrawable)localObject).getStatus();
        if (i != 1) {
          break label287;
        }
        localawvy.jdField_a_of_type_Boolean = true;
        localawvy.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
        localawvy.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
        a(localRecentUser);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label294;
        }
        QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable need init, drawableStatus" + i);
        return;
        localawvy = new awvy();
        break;
        label287:
        ((URLDrawable)localObject).downloadImediatly(true);
      }
      label294:
      break;
      label296:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU, url is empty");
      return;
      label312:
      int i = ((URLDrawable)localObject).getStatus();
      if ((i == 2) || (i == 3)) {
        ((URLDrawable)localObject).restartDownload();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable is not null, drawableStatus" + i);
        return;
        if (i == 1)
        {
          localawvy.jdField_a_of_type_Boolean = true;
          localawvy.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
          localawvy.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
          a(localRecentUser);
        }
      }
      break;
    }
  }
  
  public void e(Bundle paramBundle)
  {
    try
    {
      long l = paramBundle.getLong("uin");
      int i = paramBundle.getInt("startIndex");
      int j = paramBundle.getInt("num");
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("getRecommendedListNew uin=%s startIndex=%s num=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azow);
      paramBundle = (azou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(134);
      if (paramBundle != null) {
        paramBundle.a(l, i, j);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("LoginWelcomeManager", 1, "getRecommendedListNew fail.", paramBundle);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "removeCGRU");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if ((RecentUser)((apaw)localObject).findRecentUser(antf.aS, 8114) != null)
    {
      ((apaw)localObject).deleteRecentUserByType(8114);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "relCGDrawable");
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer");
    }
    if (!b()) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      int i;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
      {
        awwa localawwa = a();
        if ((localawwa != null) && (!TextUtils.isEmpty(localawwa.jdField_a_of_type_JavaLangString)))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseAutoScaleParams = false;
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localawwa.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new awvv(this));
          i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
          if (i == 1)
          {
            if (this.jdField_a_of_type_Awvz != null) {
              this.jdField_a_of_type_Awvz.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
            }
            g();
          }
          while (QLog.isColorLevel())
          {
            QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer drawable need init, drawableStatus" + i);
            return;
            this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(true);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer, url is empty");
        }
      }
      else
      {
        i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
        if ((i == 2) || (i == 3)) {
          this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer restartDownload, drawableStatus" + i);
          return;
          if (i == 1)
          {
            if (this.jdField_a_of_type_Awvz != null) {
              this.jdField_a_of_type_Awvz.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
            }
            g();
          }
        }
      }
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCommonGuide");
    }
    if (!c()) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Awvz == null);
    this.jdField_a_of_type_Awvz.a(this.jdField_a_of_type_Awvw);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    }
    jdField_a_of_type_Int = 0;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (paramInt == 558)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginWelcomeManager", 2, String.format("TYPE_GET_REQUEST_GUIDE_FIRST [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
      }
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length >= 4)
        {
          boolean bool = false;
          localObject = paramObject[0];
          if ((localObject instanceof String)) {
            this.jdField_a_of_type_JavaLangString = ((String)localObject);
          }
          localObject = paramObject[1];
          paramBoolean = bool;
          if ((localObject instanceof oidb_0x59f.BindContactInfo))
          {
            localObject = (oidb_0x59f.BindContactInfo)localObject;
            paramBoolean = bool;
            if (((oidb_0x59f.BindContactInfo)localObject).str_mobile.has())
            {
              paramBoolean = bool;
              if (!TextUtils.isEmpty(((oidb_0x59f.BindContactInfo)localObject).str_mobile.get()))
              {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006E3A", "0X8006E3A", 0, 0, "", "", "", "");
                paramBoolean = true;
              }
            }
          }
          localObject = paramObject[2];
          if (!(localObject instanceof Integer)) {
            break label359;
          }
        }
      }
    }
    label359:
    for (paramInt = ((Integer)localObject).intValue();; paramInt = 0)
    {
      paramObject = paramObject[3];
      if ((paramObject instanceof String)) {}
      for (paramObject = (String)paramObject;; paramObject = null)
      {
        localObject = paramObject;
        if (TextUtils.isEmpty(paramObject)) {
          localObject = "https://ti.qq.com/newguide/index.html?_wv=16777217";
        }
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("onUpdate bind=%s grayFlag=%s guideUrl=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), localObject }));
        }
        paramObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        paramObject.putBoolean("first_device", true);
        paramObject.commit();
        do
        {
          return;
        } while (paramInt != 559);
        a(paramBoolean, paramObject);
        b(paramBoolean, paramObject);
        c(paramBoolean, paramObject);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_key_contactsguide_last_req_time", System.currentTimeMillis()).commit();
        return;
      }
    }
  }
  
  public void run()
  {
    int i;
    BaseActivity localBaseActivity;
    try
    {
      i = this.jdField_b_of_type_Int + 1;
      this.jdField_b_of_type_Int = i;
      if (i > 10)
      {
        QLog.d("LoginWelcomeManager", 1, "handleNewerGuide retry max");
        return;
      }
      localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity != null) && ((localBaseActivity instanceof RegisterQQNumberActivity)))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 200L);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("LoginWelcomeManager", 2, "handleNewerGuide fail.", localException);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("handleNewerGuide real start guide, mBind=%s", new Object[] { Boolean.valueOf(this.e) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.m()) {
      i = 0;
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", localException, localException, 0, 0, "", "", "", "");
      a(localBaseActivity);
      return;
      do
      {
        str = "0X8006E39";
        break;
        i = 1;
      } while (i == 0);
      String str = "0X8006E38";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager
 * JD-Core Version:    0.7.0.1
 */