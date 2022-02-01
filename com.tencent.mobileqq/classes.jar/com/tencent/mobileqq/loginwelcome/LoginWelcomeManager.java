package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.RecommendContactInfo;
import com.tencent.mobileqq.phonecontact.handler.ContactBindHandler;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver2;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
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

public class LoginWelcomeManager
  implements BusinessObserver, IPhoneContactListener, Runnable, Manager
{
  public static int a;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new LoginWelcomeManager.4(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LoginWelcomeHandler jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler;
  LoginWelcomeManager.CommonGuideInfo jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$CommonGuideInfo = null;
  LoginWelcomeManager.ContactsGuideInfo jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo = null;
  LoginWelcomeManager.ConvListener jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener;
  LoginWelcomeManager.WelcomeIntervalConfig jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig;
  public NearbyCardObserver a;
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = null;
  private ContactBindObserver2 jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver2 = new LoginWelcomeManager.6(this);
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new LoginWelcomeManager.7(this);
  private final ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new LoginWelcomeManager.5(this);
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new LoginWelcomeManager.2(this);
  public String a;
  private WeakReference<MessengerService> jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private String c;
  public boolean c;
  private boolean d;
  private boolean e;
  
  public LoginWelcomeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new LoginWelcomeManager.1(this);
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler = ((LoginWelcomeHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOGIN_WELCOME_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
  }
  
  public static LoginWelcomeManager a(QQAppInterface paramQQAppInterface)
  {
    return (LoginWelcomeManager)paramQQAppInterface.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: new 153	java/io/File
    //   8: dup
    //   9: getstatic 158	com/tencent/mobileqq/app/AppConstants:PATH_NEWER_GUIDE_DIR_NAME	Ljava/lang/String;
    //   12: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 165	java/io/File:exists	()Z
    //   20: ifne +8 -> 28
    //   23: aload_3
    //   24: invokevirtual 168	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: new 153	java/io/File
    //   31: dup
    //   32: aload_3
    //   33: ldc 170
    //   35: invokespecial 173	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: astore 5
    //   40: aload 5
    //   42: invokevirtual 165	java/io/File:exists	()Z
    //   45: ifeq +9 -> 54
    //   48: aload 5
    //   50: invokevirtual 176	java/io/File:delete	()Z
    //   53: pop
    //   54: aload_1
    //   55: invokestatic 182	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   58: sipush 200
    //   61: sipush 200
    //   64: iconst_1
    //   65: invokestatic 188	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   68: astore 7
    //   70: new 190	java/io/FileOutputStream
    //   73: dup
    //   74: aload 5
    //   76: invokespecial 193	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore_1
    //   80: new 195	java/io/BufferedOutputStream
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 198	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: astore 4
    //   90: aload_1
    //   91: astore_2
    //   92: aload 4
    //   94: astore_3
    //   95: aload 7
    //   97: getstatic 204	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   100: bipush 100
    //   102: aload 4
    //   104: invokevirtual 208	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   107: pop
    //   108: aload_1
    //   109: astore_2
    //   110: aload 4
    //   112: astore_3
    //   113: aload 4
    //   115: invokevirtual 211	java/io/BufferedOutputStream:flush	()V
    //   118: aload_1
    //   119: astore_2
    //   120: aload 4
    //   122: astore_3
    //   123: aload 5
    //   125: invokevirtual 215	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: astore 5
    //   130: aload_1
    //   131: invokevirtual 218	java/io/FileOutputStream:close	()V
    //   134: aload 4
    //   136: astore_1
    //   137: aload 5
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   144: aload_2
    //   145: areturn
    //   146: astore_2
    //   147: aload_1
    //   148: astore 5
    //   150: aload 4
    //   152: astore_1
    //   153: aload_2
    //   154: astore 4
    //   156: goto +41 -> 197
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_3
    //   163: aload_1
    //   164: astore_2
    //   165: aload 4
    //   167: astore_1
    //   168: goto +70 -> 238
    //   171: astore 4
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_1
    //   176: astore 5
    //   178: aload_2
    //   179: astore_1
    //   180: goto +17 -> 197
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_3
    //   186: goto +52 -> 238
    //   189: astore 4
    //   191: aconst_null
    //   192: astore 5
    //   194: aload 5
    //   196: astore_1
    //   197: aload 5
    //   199: astore_2
    //   200: aload_1
    //   201: astore_3
    //   202: ldc 221
    //   204: iconst_1
    //   205: ldc 223
    //   207: aload 4
    //   209: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload 5
    //   214: ifnull +11 -> 225
    //   217: aload 5
    //   219: invokevirtual 218	java/io/FileOutputStream:close	()V
    //   222: goto +3 -> 225
    //   225: aload_1
    //   226: ifnull +9 -> 235
    //   229: aload 6
    //   231: astore_2
    //   232: goto -92 -> 140
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aload_2
    //   239: ifnull +10 -> 249
    //   242: aload_2
    //   243: invokevirtual 218	java/io/FileOutputStream:close	()V
    //   246: goto +3 -> 249
    //   249: aload_3
    //   250: ifnull +7 -> 257
    //   253: aload_3
    //   254: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   257: goto +5 -> 262
    //   260: aload_1
    //   261: athrow
    //   262: goto -2 -> 260
    //   265: astore_1
    //   266: aload 5
    //   268: astore_2
    //   269: aload 4
    //   271: astore_1
    //   272: goto -132 -> 140
    //   275: astore_1
    //   276: aload_2
    //   277: areturn
    //   278: astore_2
    //   279: goto -54 -> 225
    //   282: astore_2
    //   283: goto -34 -> 249
    //   286: astore_2
    //   287: goto -30 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	LoginWelcomeManager
    //   0	290	1	paramString	String
    //   1	144	2	localObject1	Object
    //   146	8	2	localException1	Exception
    //   164	113	2	localObject2	Object
    //   278	1	2	localException2	Exception
    //   282	1	2	localException3	Exception
    //   286	1	2	localException4	Exception
    //   15	239	3	localObject3	Object
    //   88	67	4	localObject4	Object
    //   159	7	4	localObject5	Object
    //   171	1	4	localException5	Exception
    //   189	81	4	localException6	Exception
    //   38	229	5	localObject6	Object
    //   3	227	6	localObject7	Object
    //   68	28	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   95	108	146	java/lang/Exception
    //   113	118	146	java/lang/Exception
    //   123	130	146	java/lang/Exception
    //   80	90	159	finally
    //   80	90	171	java/lang/Exception
    //   5	28	183	finally
    //   28	54	183	finally
    //   54	80	183	finally
    //   5	28	189	java/lang/Exception
    //   28	54	189	java/lang/Exception
    //   54	80	189	java/lang/Exception
    //   95	108	237	finally
    //   113	118	237	finally
    //   123	130	237	finally
    //   202	212	237	finally
    //   130	134	265	java/lang/Exception
    //   140	144	275	java/lang/Exception
    //   217	222	278	java/lang/Exception
    //   242	246	282	java/lang/Exception
    //   253	257	286	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((ContactBindHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER)).b(paramQQAppInterface.getCurrentAccountUin());
    a(paramQQAppInterface, true);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009F49", "0X8009F49", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((ContactBindHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER)).a(paramQQAppInterface.getCurrentAccountUin(), paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveContactsGuidePopWindowState，hasAlert=");
      localStringBuilder.append(paramBoolean);
      QLog.d("LoginWelcomeManager", 2, localStringBuilder.toString());
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
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    paramRecentUser.lastmsgtime = -1L;
    paramRecentUser.lastmsgdrafttime = -1L;
    paramRecentUser.opTime = -1L;
    paramRecentUser.showUpTime = -1L;
    localRecentUserProxy.b(paramRecentUser);
    paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (paramRecentUser != null) {
      paramRecentUser.sendEmptyMessage(1009);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    boolean bool = paramQQAppInterface.getPreferences().getBoolean("sp_key_contactsguide_popwindow_state", false);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("hasContactsGuidePopWindow，hasAlert=");
      paramQQAppInterface.append(bool);
      QLog.d("LoginWelcomeManager", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramRecentUser != null)
      {
        bool1 = bool2;
        if (paramRecentUser.extraInfo != null) {
          if (!(paramRecentUser.extraInfo instanceof LoginWelcomeManager.ContactsGuideRecenUserObj))
          {
            bool1 = bool2;
          }
          else
          {
            paramQQAppInterface = (LoginWelcomeManager.ContactsGuideRecenUserObj)paramRecentUser.extraInfo;
            bool1 = bool2;
            if (paramQQAppInterface.jdField_a_of_type_Boolean)
            {
              bool1 = bool2;
              if (paramQQAppInterface.jdField_a_of_type_ComTencentImageURLDrawable != null)
              {
                bool1 = bool2;
                if (paramQQAppInterface.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("contactsGuideRecenUserUiReady, result=");
      paramQQAppInterface.append(bool1);
      QLog.d("LoginWelcomeManager", 2, paramQQAppInterface.toString());
    }
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    int i = jdField_a_of_type_Int;
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009F4B", "0X8009F4B", 0, i, 0, "", "", "", "");
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
    if (ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, localIntent))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      return;
    }
    paramBundle.putInt("result", 0);
    b();
  }
  
  public LoginWelcomeManager.CommonGuideInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$CommonGuideInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$CommonGuideInfo = new LoginWelcomeManager.CommonGuideInfo();
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$CommonGuideInfo.jdField_a_of_type_Int = 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$CommonGuideInfo;
  }
  
  public LoginWelcomeManager.ContactsGuideInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo = new LoginWelcomeManager.ContactsGuideInfo();
      Object localObject;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loginwelcome_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        this.jdField_a_of_type_AndroidContentSharedPreferences = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_convguide_entrance", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getContactsGuideInfo, \n");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo;
  }
  
  public LoginWelcomeManager.WelcomeIntervalConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig = ((LoginWelcomeManager.WelcomeIntervalConfig)QConfigManager.a().a(454));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWelcomeIntervalConfig, \n");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig);
        QLog.d("LoginWelcomeManager", 2, localStringBuilder.toString());
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loginwelcome_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    this.jdField_a_of_type_AndroidContentSharedPreferences = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("first_login", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestIsFirstLogin state=");
      ((StringBuilder)localObject).append(i);
      QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler.a(true);
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("first_device", false);
      ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", 0);
      ((SharedPreferences.Editor)localObject).putInt("first_login", 1);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    a();
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_key_contactsguide_last_req_time", 0L);
    localObject = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig;
    if (localObject != null) {
      i = ((LoginWelcomeManager.WelcomeIntervalConfig)localObject).jdField_a_of_type_Int;
    } else {
      i = 360;
    }
    long l2 = System.currentTimeMillis();
    boolean bool1;
    if (Math.abs(l2 - l1) > i * 60 * 1000) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("request_state", true);
    if ((bool1) && (bool2)) {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler.a(false);
    } else {
      e();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestIsFirstLogin, doReq=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",curTime=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(",lastReqTime=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(",reqInternal=");
      ((StringBuilder)localObject).append(i);
      QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
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
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService != null)
      {
        if (paramInt == 9)
        {
          if (this.d) {
            b(true);
          } else {
            c();
          }
        }
        else if (paramInt == 2)
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
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.removeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = null;
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(String.format(Locale.getDefault(), "&appid=%d", new Object[] { Integer.valueOf(AppSetting.a()) }));
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("startNewerGuideWebPage url=%s", new Object[] { localObject }));
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("url", (String)localObject);
    paramContext.startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    INearbyCardHandler localINearbyCardHandler = (INearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
    long l = paramBundle.getLong("tinyId");
    NearbyProfileUtil.a(localINearbyCardHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "", 100, null, 0L, false, 0L, false, 0L, 0);
  }
  
  public void a(MessengerService paramMessengerService, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject == null) || (((WeakReference)localObject).get() != paramMessengerService)) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramMessengerService);
    }
    paramMessengerService = paramBundle.getBundle("request");
    localObject = paramMessengerService.getString("key_action");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleWebRequest method=");
      localStringBuilder.append((String)localObject);
      QLog.d("LoginWelcomeManager", 2, localStringBuilder.toString());
    }
    if ((!((String)localObject).equals("uploadContacts")) && (!((String)localObject).equals("getRecommendedList")))
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, "last request has not return.");
        }
        return;
      }
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      if (((String)localObject).equals("followPublicAccount"))
      {
        c(paramMessengerService);
        return;
      }
      if (((String)localObject).equals("joinTroop"))
      {
        b(paramMessengerService);
        return;
      }
      if (((String)localObject).equals("joinTroopByTap"))
      {
        d(paramMessengerService);
        return;
      }
      if (((String)localObject).equals("sayHi"))
      {
        a(paramMessengerService);
        return;
      }
      if (((String)localObject).equals("setAvatar"))
      {
        f(paramMessengerService);
        return;
      }
      if (((String)localObject).equals("getRecommendedListNew")) {
        e(paramMessengerService);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidOsBundle = paramBundle;
      a(((String)localObject).equals("uploadContacts"));
    }
  }
  
  public void a(LoginWelcomeManager.ConvListener paramConvListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener = paramConvListener;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setConvListener, listener=");
      localStringBuilder.append(paramConvListener);
      QLog.d("LoginWelcomeManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener != null) {
      ThreadManagerV2.postImmediately(new LoginWelcomeManager.8(this), null, true);
    }
  }
  
  public void a(LoginWelcomeManager.WelcomeIntervalConfig paramWelcomeIntervalConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateConfig, \n");
      localStringBuilder.append(paramWelcomeIntervalConfig);
      QLog.d("LoginWelcomeManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig = paramWelcomeIntervalConfig;
  }
  
  public void a(List<RecommendContactInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      int i = 0;
      if (paramList != null) {
        i = paramList.size();
      }
      QLog.d("LoginWelcomeManager", 2, String.format("onGetNewerGuideRecommended list=%s, count=%s", new Object[] { paramList, Integer.valueOf(i) }));
    }
    if (this.jdField_b_of_type_AndroidOsBundle == null) {
      return;
    }
    if (paramList != null)
    {
      localObject1 = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecommendContactInfo localRecommendContactInfo = (RecommendContactInfo)paramList.next();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localRecommendContactInfo.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(AvatarDownloadUtil.getQQHeadImageSize((byte)(int)localRecommendContactInfo.jdField_a_of_type_Long));
        localObject2 = MsfSdkUtils.insertMtype("QQHeadIcon", ((StringBuilder)localObject2).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("&t=");
        localStringBuilder.append(System.currentTimeMillis());
        localRecommendContactInfo.e = localStringBuilder.toString();
        ((JSONArray)localObject1).put(localRecommendContactInfo.a());
      }
      paramList = ((JSONArray)localObject1).toString();
    }
    else
    {
      paramList = "";
    }
    Object localObject1 = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    if (localObject1 != null) {
      ((Bundle)localObject1).putString("op_result", paramList);
    }
    paramList = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramList != null) {
      paramList.a(this.jdField_b_of_type_AndroidOsBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.d = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class));
    }
    boolean bool = PermissionChecker.a().c();
    QLog.d("LoginWelcomeManager", 1, String.format("getRecommendedList uploadContactsOnly=%s hasPermission=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.addListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.isBindedIgnoreUpload())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState() == 9)
        {
          if (this.d)
          {
            b(true);
            return;
          }
          c();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.uploadPhoneContact();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.uploadPhoneContactNotBind();
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
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo = ((LoginWelcomeManager.ContactsGuideInfo)paramObject[0]);
        h();
        e();
        paramObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        paramObject.putBoolean("sp_key_show_convguide_entrance", this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideInfo.jdField_b_of_type_Boolean);
        paramObject.commit();
      }
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetContactsGuide，isSuccess=");
      paramObject.append(paramBoolean);
      paramObject.append(", mContactsGuideInfo=");
      paramObject.append(a());
      QLog.d("LoginWelcomeManager", 2, paramObject.toString());
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
    Object localObject1 = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (PermissionChecker.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, has ReadContactPer");
      }
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    localObject1 = ((RecentUserProxy)localObject2).b(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, 8111);
    localObject2 = ((RecentUserProxy)localObject2).b("sp_uin_for_title", 8112);
    if ((localObject1 == null) && (localObject2 == null)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "allowShowCGRU， mayKnowFriend has show");
    }
    return false;
  }
  
  public void b()
  {
    MessengerService localMessengerService = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localMessengerService != null)
    {
      localMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidOsBundle = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "respToWeb no service");
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress percentage=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    IPhoneContactService localIPhoneContactService = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
    if ((localIPhoneContactService != null) && (localIPhoneContactService.getUploadPackages() >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress upload packages >= 2, time cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) }));
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
      if ((paramInt != 8) && (paramInt != 9))
      {
        if ((paramInt == 4) || (paramInt == 2)) {
          if (this.d) {
            b(true);
          } else {
            d();
          }
        }
      }
      else if (this.d) {
        b(true);
      } else {
        c();
      }
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.removeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = null;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    ITroopMngHandler localITroopMngHandler = (ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    if (localITroopMngHandler != null) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
        localITroopMngHandler.a(Long.parseLong(paramBundle), 8390784);
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, "joinTroop err", paramBundle);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 2) && (paramObject[1] != null) && ((paramObject[1] instanceof LoginWelcomeManager.CommonGuideInfo)))
      {
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$CommonGuideInfo = ((LoginWelcomeManager.CommonGuideInfo)paramObject[1]);
        i();
      }
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetCommonGuide，isSuccess=");
      paramObject.append(paramBoolean);
      paramObject.append(", mCommonGuideInfo=");
      paramObject.append(a());
      QLog.d("LoginWelcomeManager", 2, paramObject.toString());
    }
  }
  
  public boolean b()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=false, hasPopWindow");
      }
      return false;
    }
    Object localObject = a();
    boolean bool = ((LoginWelcomeManager.ContactsGuideInfo)localObject).jdField_a_of_type_Boolean;
    localObject = ((LoginWelcomeManager.ContactsGuideInfo)localObject).jdField_a_of_type_JavaLangString;
    if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=true, showWelcomepage");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=false");
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedList");
    }
    Object localObject = this.jdField_b_of_type_AndroidOsBundle;
    if (localObject == null) {
      return;
    }
    localObject = ((Bundle)localObject).getBundle("request");
    int i;
    if (localObject != null) {
      i = ((Bundle)localObject).getInt("wantCount");
    } else {
      i = 0;
    }
    if (i <= 0) {
      i = 21;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedList wantCount=%s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    ((NewIntent)localObject).putExtra("req_type", 36);
    ((NewIntent)localObject).putExtra("unique_phone_no", this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getUNIQUE_NO());
    ((NewIntent)localObject).putExtra("wantCount", i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void c(int paramInt) {}
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
    localIPublicAccountObserver.setOnCallback(new LoginWelcomeManager.3(this, paramBundle));
    paramBundle = (IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBundle.followUin(localQQAppInterface, localQQAppInterface.getApp(), str, localIPublicAccountObserver, true, 15);
  }
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      Object localObject;
      if ((paramObject.length >= 3) && (paramObject[2].equals(Boolean.FALSE)))
      {
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putBoolean("request_state", false);
        ((SharedPreferences.Editor)localObject).commit();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSetRequestOpen，reqOpen=");
        ((StringBuilder)localObject).append(paramObject[2]);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = this.jdField_b_of_type_AndroidOsBundle;
    if (localObject == null) {
      return;
    }
    localObject = ((Bundle)localObject).getBundle("request");
    int i;
    if (localObject != null) {
      i = ((Bundle)localObject).getInt("wantCount");
    } else {
      i = 0;
    }
    if (i <= 0) {
      i = 21;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedListNotBind wantCount=%s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    ((NewIntent)localObject).putExtra("req_type", 40);
    ((NewIntent)localObject).putExtra("unique_phone_no", this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getUNIQUE_NO());
    ((NewIntent)localObject).putExtra("wantCount", i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "joinGroupByTap");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().b(AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN, 8114);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new RecentUser(AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN, 8114);
    }
    if ((((RecentUser)localObject1).extraInfo != null) && ((((RecentUser)localObject1).extraInfo instanceof LoginWelcomeManager.ContactsGuideRecenUserObj))) {
      localObject2 = (LoginWelcomeManager.ContactsGuideRecenUserObj)((RecentUser)localObject1).extraInfo;
    } else {
      localObject2 = new LoginWelcomeManager.ContactsGuideRecenUserObj();
    }
    ((RecentUser)localObject1).extraInfo = localObject2;
    Object localObject3 = ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).jdField_a_of_type_ComTencentImageURLDrawable;
    int i;
    if (localObject3 == null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig;
      if ((localObject3 != null) && (!TextUtils.isEmpty(((LoginWelcomeManager.WelcomeIntervalConfig)localObject3).jdField_b_of_type_JavaLangString)))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = TakeVideoUtils.a(BaseApplicationImpl.getApplication().getResources());
        double d1 = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
        Double.isNaN(d1);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((int)(d1 * 0.5D + 0.5D));
        ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
        localObject3 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$WelcomeIntervalConfig.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject3).setURLDrawableListener(new LoginWelcomeManager.9(this, (LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2, (RecentUser)localObject1));
        i = ((URLDrawable)localObject3).getStatus();
        if (i == 1)
        {
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).jdField_a_of_type_Boolean = true;
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject3);
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
          a((RecentUser)localObject1);
        }
        else
        {
          ((URLDrawable)localObject3).downloadImediatly(true);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("tryShowCGRU drawable need init, drawableStatus");
          ((StringBuilder)localObject1).append(i);
          QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("LoginWelcomeManager", 2, "tryShowCGRU, url is empty");
      }
    }
    else
    {
      i = ((URLDrawable)localObject3).getStatus();
      if ((i != 2) && (i != 3))
      {
        if (i == 1)
        {
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).jdField_a_of_type_Boolean = true;
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject3);
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
          a((RecentUser)localObject1);
        }
      }
      else {
        ((URLDrawable)localObject3).restartDownload();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("tryShowCGRU drawable is not null, drawableStatus");
        ((StringBuilder)localObject1).append(i);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject1).toString());
      }
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver2);
      paramBundle = (ContactBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER);
      if (paramBundle != null)
      {
        paramBundle.a(l, i, j);
        return;
      }
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (((RecentUserProxy)localObject).b(AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN, 8114) != null)
    {
      ((RecentUserProxy)localObject).a(8114);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
    }
  }
  
  public void g()
  {
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null)
    {
      localURLDrawable.setURLDrawableListener(null);
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
    if (!b()) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    int i;
    if (localObject == null)
    {
      localObject = a();
      if ((localObject != null) && (!TextUtils.isEmpty(((LoginWelcomeManager.WelcomeIntervalConfig)localObject).jdField_a_of_type_JavaLangString)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseAutoScaleParams = false;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(((LoginWelcomeManager.WelcomeIntervalConfig)localObject).jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new LoginWelcomeManager.10(this));
        i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
        if (i == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener;
          if (localObject != null) {
            ((LoginWelcomeManager.ConvListener)localObject).a(this.jdField_a_of_type_ComTencentImageURLDrawable);
          }
          g();
        }
        else
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(true);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tryToShowCGLayer drawable need init, drawableStatus");
          ((StringBuilder)localObject).append(i);
          QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer, url is empty");
      }
    }
    else
    {
      i = ((URLDrawable)localObject).getStatus();
      if ((i != 2) && (i != 3))
      {
        if (i == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener;
          if (localObject != null) {
            ((LoginWelcomeManager.ConvListener)localObject).a(this.jdField_a_of_type_ComTencentImageURLDrawable);
          }
          g();
        }
      }
      else {
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tryToShowCGLayer restartDownload, drawableStatus");
        ((StringBuilder)localObject).append(i);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCommonGuide");
    }
    if (!c()) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    LoginWelcomeManager.ConvListener localConvListener = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener;
    if (localConvListener != null) {
      localConvListener.a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$CommonGuideInfo);
    }
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    }
    jdField_a_of_type_Int = 0;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 558)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginWelcomeManager", 2, String.format("TYPE_GET_REQUEST_GUIDE_FIRST [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
      }
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        Object localObject = (Object[])paramObject;
        if (localObject.length >= 4)
        {
          paramObject = null;
          oidb_0x59f.BindContactInfo localBindContactInfo = localObject[0];
          if ((localBindContactInfo instanceof String)) {
            this.jdField_a_of_type_JavaLangString = ((String)localBindContactInfo);
          }
          localBindContactInfo = localObject[1];
          if ((localBindContactInfo instanceof oidb_0x59f.BindContactInfo))
          {
            localBindContactInfo = (oidb_0x59f.BindContactInfo)localBindContactInfo;
            if ((localBindContactInfo.str_mobile.has()) && (!TextUtils.isEmpty(localBindContactInfo.str_mobile.get())))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006E3A", "0X8006E3A", 0, 0, "", "", "", "");
              paramBoolean = true;
              break label178;
            }
          }
          paramBoolean = false;
          label178:
          localBindContactInfo = localObject[2];
          if ((localBindContactInfo instanceof Integer)) {
            paramInt = ((Integer)localBindContactInfo).intValue();
          } else {
            paramInt = 0;
          }
          localObject = localObject[3];
          if ((localObject instanceof String)) {
            paramObject = (String)localObject;
          }
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
        }
      }
    }
    else if (paramInt == 559)
    {
      a(paramBoolean, paramObject);
      b(paramBoolean, paramObject);
      c(paramBoolean, paramObject);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_key_contactsguide_last_req_time", System.currentTimeMillis()).commit();
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_b_of_type_Int + 1;
        this.jdField_b_of_type_Int = i;
        if (i > 10)
        {
          QLog.d("LoginWelcomeManager", 1, "handleNewerGuide retry max");
          return;
        }
        BaseActivity localBaseActivity = BaseActivity.sTopActivity;
        Object localObject = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
        if ((localBaseActivity != null) && (((ILoginRegisterApi)localObject).getRegisterQQNumberActivity().isInstance(localBaseActivity)))
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 200L);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("handleNewerGuide real start guide, mBind=%s", new Object[] { Boolean.valueOf(this.e) }));
        }
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, ""));
        if (PermissionChecker.a().c())
        {
          localObject = "0X8006E38";
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          a(localBaseActivity);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("LoginWelcomeManager", 2, "handleNewerGuide fail.", localException);
        return;
      }
      String str = "0X8006E39";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager
 * JD-Core Version:    0.7.0.1
 */