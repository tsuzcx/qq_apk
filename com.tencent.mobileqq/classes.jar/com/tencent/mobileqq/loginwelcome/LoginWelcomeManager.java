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
  public static int j;
  private CardObserver A = new LoginWelcomeManager.4(this);
  private final ProfileCardObserver B = new LoginWelcomeManager.5(this);
  private ContactBindObserver2 C = new LoginWelcomeManager.6(this);
  private ContactBindObserver D = new LoginWelcomeManager.7(this);
  public String a;
  public boolean b = false;
  public NearbyCardObserver c = new LoginWelcomeManager.1(this);
  TroopMngObserver d = new LoginWelcomeManager.2(this);
  LoginWelcomeManager.WelcomeIntervalConfig e;
  LoginWelcomeManager.ContactsGuideInfo f = null;
  URLDrawable g;
  LoginWelcomeManager.ConvListener h;
  public boolean i;
  public boolean k;
  LoginWelcomeManager.CommonGuideInfo l = null;
  private QQAppInterface m;
  private LoginWelcomeHandler n;
  private SharedPreferences o;
  private WeakReference<MessengerService> p;
  private Bundle q;
  private Bundle r;
  private IPhoneContactService s = null;
  private long t;
  private boolean u;
  private Handler v = new Handler(Looper.getMainLooper());
  private boolean w;
  private String x;
  private int y = 0;
  private String z = null;
  
  public LoginWelcomeManager(QQAppInterface paramQQAppInterface)
  {
    this.m = paramQQAppInterface;
    this.n = ((LoginWelcomeHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOGIN_WELCOME_HANDLER));
    this.m.addObserver(this, true);
    this.m.registObserver(this.D);
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
    //   5: new 173	java/io/File
    //   8: dup
    //   9: getstatic 178	com/tencent/mobileqq/app/AppConstants:PATH_NEWER_GUIDE_DIR_NAME	Ljava/lang/String;
    //   12: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 185	java/io/File:exists	()Z
    //   20: ifne +8 -> 28
    //   23: aload_3
    //   24: invokevirtual 188	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: new 173	java/io/File
    //   31: dup
    //   32: aload_3
    //   33: ldc 190
    //   35: invokespecial 193	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: astore 5
    //   40: aload 5
    //   42: invokevirtual 185	java/io/File:exists	()Z
    //   45: ifeq +9 -> 54
    //   48: aload 5
    //   50: invokevirtual 196	java/io/File:delete	()Z
    //   53: pop
    //   54: aload_1
    //   55: invokestatic 202	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   58: sipush 200
    //   61: sipush 200
    //   64: iconst_1
    //   65: invokestatic 208	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   68: astore 7
    //   70: new 210	java/io/FileOutputStream
    //   73: dup
    //   74: aload 5
    //   76: invokespecial 213	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore_1
    //   80: new 215	java/io/BufferedOutputStream
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 218	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: astore 4
    //   90: aload_1
    //   91: astore_2
    //   92: aload 4
    //   94: astore_3
    //   95: aload 7
    //   97: getstatic 224	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   100: bipush 100
    //   102: aload 4
    //   104: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   107: pop
    //   108: aload_1
    //   109: astore_2
    //   110: aload 4
    //   112: astore_3
    //   113: aload 4
    //   115: invokevirtual 231	java/io/BufferedOutputStream:flush	()V
    //   118: aload_1
    //   119: astore_2
    //   120: aload 4
    //   122: astore_3
    //   123: aload 5
    //   125: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: astore 5
    //   130: aload_1
    //   131: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   134: aload 4
    //   136: astore_1
    //   137: aload 5
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 239	java/io/BufferedOutputStream:close	()V
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
    //   202: ldc 241
    //   204: iconst_1
    //   205: ldc 243
    //   207: aload 4
    //   209: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload 5
    //   214: ifnull +11 -> 225
    //   217: aload 5
    //   219: invokevirtual 238	java/io/FileOutputStream:close	()V
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
    //   243: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   246: goto +3 -> 249
    //   249: aload_3
    //   250: ifnull +7 -> 257
    //   253: aload_3
    //   254: invokevirtual 239	java/io/BufferedOutputStream:close	()V
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
    RecentUserProxy localRecentUserProxy = this.m.getProxyManager().g();
    paramRecentUser.lastmsgtime = -1L;
    paramRecentUser.lastmsgdrafttime = -1L;
    paramRecentUser.opTime = -1L;
    paramRecentUser.showUpTime = -1L;
    localRecentUserProxy.b(paramRecentUser);
    paramRecentUser = this.m.getHandler(Conversation.class);
    if (paramRecentUser != null) {
      paramRecentUser.sendEmptyMessage(1009);
    }
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
            if (paramQQAppInterface.a)
            {
              bool1 = bool2;
              if (paramQQAppInterface.b != null)
              {
                bool1 = bool2;
                if (paramQQAppInterface.b.getStatus() == 1) {
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
  
  public static boolean b(QQAppInterface paramQQAppInterface)
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
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((ContactBindHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER)).b(paramQQAppInterface.getCurrentAccountUin());
    a(paramQQAppInterface, true);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009F49", "0X8009F49", 0, 0, "", "", "", "");
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    int i1 = j;
    if (i1 > 0) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009F4B", "0X8009F4B", 0, i1, 0, "", "", "", "");
    }
    j = 0;
  }
  
  private void f(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("path");
    boolean bool = paramBundle.getBoolean("PhotoConst.SYNCQZONE", false);
    String str2 = paramBundle.getString("PhotoConst.SOURCE_FROM");
    this.z = a(str1);
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SYNCQZONE", bool);
    localIntent.putExtra("PhotoConst.SOURCE_FROM", str2);
    if (ProfileCardUtil.a(this.m, str1, localIntent))
    {
      this.m.addObserver(this.A);
      return;
    }
    paramBundle.putInt("result", 0);
    b();
  }
  
  public void a()
  {
    Object localObject = this.m.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loginwelcome_");
    localStringBuilder.append(this.m.getCurrentUin());
    this.o = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    int i1 = this.o.getInt("first_login", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestIsFirstLogin state=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
    }
    if (i1 != 1)
    {
      this.n.a(true);
      localObject = this.o.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("first_device", false);
      ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", 0);
      ((SharedPreferences.Editor)localObject).putInt("first_login", 1);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    e();
    long l1 = this.o.getLong("sp_key_contactsguide_last_req_time", 0L);
    localObject = this.e;
    if (localObject != null) {
      i1 = ((LoginWelcomeManager.WelcomeIntervalConfig)localObject).c;
    } else {
      i1 = 360;
    }
    long l2 = System.currentTimeMillis();
    boolean bool1;
    if (Math.abs(l2 - l1) > i1 * 60 * 1000) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = this.o.getBoolean("request_state", true);
    if ((bool1) && (bool2)) {
      this.n.a(false);
    } else {
      h();
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
      ((StringBuilder)localObject).append(i1);
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
        QLog.d("LoginWelcomeManager", 2, String.format("onBindStateChanged upload end, time cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.t) }));
      }
      if (this.s != null)
      {
        if (paramInt == 9)
        {
          if (this.u) {
            b(true);
          } else {
            c();
          }
        }
        else if (paramInt == 2)
        {
          if (this.u) {
            b(true);
          } else {
            d();
          }
        }
        else if (this.u) {
          b(false);
        } else {
          a(null);
        }
        this.s.removeListener(this);
        this.s = null;
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.x);
    ((StringBuilder)localObject).append(String.format(Locale.getDefault(), "&appid=%d", new Object[] { Integer.valueOf(AppSetting.d()) }));
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
    this.m.addObserver(this.c);
    INearbyCardHandler localINearbyCardHandler = (INearbyCardHandler)this.m.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
    long l1 = paramBundle.getLong("tinyId");
    NearbyProfileUtil.a(localINearbyCardHandler, this.m, l1, "", 100, null, 0L, false, 0L, false, 0L, 0);
  }
  
  public void a(MessengerService paramMessengerService, Bundle paramBundle)
  {
    Object localObject = this.p;
    if ((localObject == null) || (((WeakReference)localObject).get() != paramMessengerService)) {
      this.p = new WeakReference(paramMessengerService);
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
      if (this.q != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, "last request has not return.");
        }
        return;
      }
      this.q = paramBundle;
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
      this.r = paramBundle;
      a(((String)localObject).equals("uploadContacts"));
    }
  }
  
  public void a(LoginWelcomeManager.ConvListener paramConvListener)
  {
    this.h = paramConvListener;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setConvListener, listener=");
      localStringBuilder.append(paramConvListener);
      QLog.d("LoginWelcomeManager", 2, localStringBuilder.toString());
    }
    if (this.h != null) {
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
    this.e = paramWelcomeIntervalConfig;
  }
  
  public void a(List<RecommendContactInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      int i1 = 0;
      if (paramList != null) {
        i1 = paramList.size();
      }
      QLog.d("LoginWelcomeManager", 2, String.format("onGetNewerGuideRecommended list=%s, count=%s", new Object[] { paramList, Integer.valueOf(i1) }));
    }
    if (this.r == null) {
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
        ((StringBuilder)localObject2).append(localRecommendContactInfo.e);
        ((StringBuilder)localObject2).append(AvatarDownloadUtil.getQQHeadImageSize((byte)(int)localRecommendContactInfo.f));
        localObject2 = MsfSdkUtils.insertMtype("QQHeadIcon", ((StringBuilder)localObject2).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("&t=");
        localStringBuilder.append(System.currentTimeMillis());
        localRecommendContactInfo.i = localStringBuilder.toString();
        ((JSONArray)localObject1).put(localRecommendContactInfo.a());
      }
      paramList = ((JSONArray)localObject1).toString();
    }
    else
    {
      paramList = "";
    }
    Object localObject1 = this.r.getBundle("request");
    if (localObject1 != null) {
      ((Bundle)localObject1).putString("op_result", paramList);
    }
    paramList = (MessengerService)this.p.get();
    if (paramList != null) {
      paramList.a(this.r);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = SystemClock.uptimeMillis();
    this.u = paramBoolean;
    if (this.s == null) {
      this.s = ((IPhoneContactService)this.m.getRuntimeService(IPhoneContactService.class));
    }
    boolean bool = PermissionChecker.a().e();
    QLog.d("LoginWelcomeManager", 1, String.format("getRecommendedList uploadContactsOnly=%s hasPermission=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
    if (bool)
    {
      this.s.addListener(this);
      if (this.s.isBindedIgnoreUpload())
      {
        if (this.s.getSelfBindState() == 9)
        {
          if (this.u)
          {
            b(true);
            return;
          }
          c();
          return;
        }
        this.s.uploadPhoneContact();
        return;
      }
      this.s.uploadPhoneContactNotBind();
      return;
    }
    if (this.u)
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
        this.f = ((LoginWelcomeManager.ContactsGuideInfo)paramObject[0]);
        l();
        h();
        paramObject = this.o.edit();
        paramObject.putBoolean("sp_key_show_convguide_entrance", this.f.b);
        paramObject.commit();
      }
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetContactsGuide，isSuccess=");
      paramObject.append(paramBoolean);
      paramObject.append(", mContactsGuideInfo=");
      paramObject.append(f());
      QLog.d("LoginWelcomeManager", 2, paramObject.toString());
    }
  }
  
  public void b()
  {
    MessengerService localMessengerService = (MessengerService)this.p.get();
    if (localMessengerService != null)
    {
      localMessengerService.a(this.q);
      this.q = null;
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
    IPhoneContactService localIPhoneContactService = this.s;
    if ((localIPhoneContactService != null) && (localIPhoneContactService.getUploadPackages() >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress upload packages >= 2, time cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.t) }));
      }
      paramInt = this.s.getSelfBindState();
      if ((paramInt != 8) && (paramInt != 9))
      {
        if ((paramInt == 4) || (paramInt == 2)) {
          if (this.u) {
            b(true);
          } else {
            d();
          }
        }
      }
      else if (this.u) {
        b(true);
      } else {
        c();
      }
      this.s.removeListener(this);
      this.s = null;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    ITroopMngHandler localITroopMngHandler = (ITroopMngHandler)this.m.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    if (localITroopMngHandler != null) {
      try
      {
        this.m.addObserver(this.d);
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
        this.l = ((LoginWelcomeManager.CommonGuideInfo)paramObject[1]);
        n();
      }
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetCommonGuide，isSuccess=");
      paramObject.append(paramBoolean);
      paramObject.append(", mCommonGuideInfo=");
      paramObject.append(m());
      QLog.d("LoginWelcomeManager", 2, paramObject.toString());
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedList");
    }
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    localObject = ((Bundle)localObject).getBundle("request");
    int i1;
    if (localObject != null) {
      i1 = ((Bundle)localObject).getInt("wantCount");
    } else {
      i1 = 0;
    }
    if (i1 <= 0) {
      i1 = 21;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedList wantCount=%s", new Object[] { Integer.valueOf(i1) }));
    }
    localObject = new NewIntent(this.m.getApplication(), ContactBindServlet.class);
    ((NewIntent)localObject).putExtra("req_type", 36);
    ((NewIntent)localObject).putExtra("unique_phone_no", this.s.getUNIQUE_NO());
    ((NewIntent)localObject).putExtra("wantCount", i1);
    this.m.startServlet((NewIntent)localObject);
  }
  
  public void c(int paramInt) {}
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
    localIPublicAccountObserver.setOnCallback(new LoginWelcomeManager.3(this, paramBundle));
    paramBundle = (IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class);
    QQAppInterface localQQAppInterface = this.m;
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
        localObject = this.o.edit();
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
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedListNotBind");
    }
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    localObject = ((Bundle)localObject).getBundle("request");
    int i1;
    if (localObject != null) {
      i1 = ((Bundle)localObject).getInt("wantCount");
    } else {
      i1 = 0;
    }
    if (i1 <= 0) {
      i1 = 21;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedListNotBind wantCount=%s", new Object[] { Integer.valueOf(i1) }));
    }
    localObject = new NewIntent(this.m.getApplication(), ContactBindServlet.class);
    ((NewIntent)localObject).putExtra("req_type", 40);
    ((NewIntent)localObject).putExtra("unique_phone_no", this.s.getUNIQUE_NO());
    ((NewIntent)localObject).putExtra("wantCount", i1);
    this.m.startServlet((NewIntent)localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "joinGroupByTap");
    }
    this.m.addObserver(this.B);
    ((CardHandler)this.m.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.m.getCurrentAccountUin(), this.m.getCurrentUin(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
  }
  
  public LoginWelcomeManager.WelcomeIntervalConfig e()
  {
    if (this.e == null)
    {
      this.e = ((LoginWelcomeManager.WelcomeIntervalConfig)QConfigManager.b().b(454));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWelcomeIntervalConfig, \n");
        localStringBuilder.append(this.e);
        QLog.d("LoginWelcomeManager", 2, localStringBuilder.toString());
      }
    }
    return this.e;
  }
  
  public void e(Bundle paramBundle)
  {
    try
    {
      long l1 = paramBundle.getLong("uin");
      int i1 = paramBundle.getInt("startIndex");
      int i2 = paramBundle.getInt("num");
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("getRecommendedListNew uin=%s startIndex=%s num=%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2) }));
      }
      this.m.addObserver(this.C);
      paramBundle = (ContactBindHandler)this.m.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER);
      if (paramBundle != null)
      {
        paramBundle.a(l1, i1, i2);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      QLog.e("LoginWelcomeManager", 1, "getRecommendedListNew fail.", paramBundle);
    }
  }
  
  public LoginWelcomeManager.ContactsGuideInfo f()
  {
    if (this.f == null)
    {
      this.f = new LoginWelcomeManager.ContactsGuideInfo();
      Object localObject;
      if (this.o == null)
      {
        localObject = this.m.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loginwelcome_");
        localStringBuilder.append(this.m.getCurrentUin());
        this.o = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      }
      this.f.b = this.o.getBoolean("sp_key_show_convguide_entrance", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getContactsGuideInfo, \n");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this.f;
  }
  
  public boolean g()
  {
    if (!f().b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, needShow is false");
      }
      return false;
    }
    Object localObject1 = (IPhoneContactService)this.m.getRuntimeService(IPhoneContactService.class, "");
    if (PermissionChecker.a().d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, has ReadContactPer");
      }
      return false;
    }
    Object localObject2 = this.m.getProxyManager().g();
    localObject1 = ((RecentUserProxy)localObject2).c(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, 8111);
    localObject2 = ((RecentUserProxy)localObject2).c("sp_uin_for_title", 8112);
    if ((localObject1 == null) && (localObject2 == null)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "allowShowCGRU， mayKnowFriend has show");
    }
    return false;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU");
    }
    if (!g())
    {
      i();
      return;
    }
    e();
    Object localObject2 = this.m.getProxyManager().g().c(AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN, 8114);
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
    Object localObject3 = ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).b;
    int i1;
    if (localObject3 == null)
    {
      localObject3 = this.e;
      if ((localObject3 != null) && (!TextUtils.isEmpty(((LoginWelcomeManager.WelcomeIntervalConfig)localObject3).b)))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = TakeVideoUtils.a(BaseApplicationImpl.getApplication().getResources());
        double d1 = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
        Double.isNaN(d1);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((int)(d1 * 0.5D + 0.5D));
        ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
        localObject3 = URLDrawable.getDrawable(this.e.b, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject3).setURLDrawableListener(new LoginWelcomeManager.9(this, (LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2, (RecentUser)localObject1));
        i1 = ((URLDrawable)localObject3).getStatus();
        if (i1 == 1)
        {
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).a = true;
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).b = ((URLDrawable)localObject3);
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).b.setURLDrawableListener(null);
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
          ((StringBuilder)localObject1).append(i1);
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
      i1 = ((URLDrawable)localObject3).getStatus();
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 == 1)
        {
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).a = true;
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).b = ((URLDrawable)localObject3);
          ((LoginWelcomeManager.ContactsGuideRecenUserObj)localObject2).b.setURLDrawableListener(null);
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
        ((StringBuilder)localObject1).append(i1);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "removeCGRU");
    }
    Object localObject = this.m.getProxyManager().g();
    if (((RecentUserProxy)localObject).c(AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN, 8114) != null)
    {
      ((RecentUserProxy)localObject).a(8114);
      localObject = this.m.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
    }
  }
  
  public void j()
  {
    URLDrawable localURLDrawable = this.g;
    if (localURLDrawable != null)
    {
      localURLDrawable.setURLDrawableListener(null);
      this.g = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "relCGDrawable");
    }
  }
  
  public boolean k()
  {
    if (b(this.m))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=false, hasPopWindow");
      }
      return false;
    }
    Object localObject = f();
    boolean bool = ((LoginWelcomeManager.ContactsGuideInfo)localObject).a;
    localObject = ((LoginWelcomeManager.ContactsGuideInfo)localObject).c;
    if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      e();
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
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer");
    }
    if (!k()) {
      return;
    }
    this.i = true;
    Object localObject = this.g;
    int i1;
    if (localObject == null)
    {
      localObject = e();
      if ((localObject != null) && (!TextUtils.isEmpty(((LoginWelcomeManager.WelcomeIntervalConfig)localObject).a)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseAutoScaleParams = false;
        this.g = URLDrawable.getDrawable(((LoginWelcomeManager.WelcomeIntervalConfig)localObject).a, localURLDrawableOptions);
        this.g.setURLDrawableListener(new LoginWelcomeManager.10(this));
        i1 = this.g.getStatus();
        if (i1 == 1)
        {
          localObject = this.h;
          if (localObject != null) {
            ((LoginWelcomeManager.ConvListener)localObject).a(this.g);
          }
          j();
        }
        else
        {
          this.g.downloadImediatly(true);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tryToShowCGLayer drawable need init, drawableStatus");
          ((StringBuilder)localObject).append(i1);
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
      i1 = ((URLDrawable)localObject).getStatus();
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 == 1)
        {
          localObject = this.h;
          if (localObject != null) {
            ((LoginWelcomeManager.ConvListener)localObject).a(this.g);
          }
          j();
        }
      }
      else {
        this.g.restartDownload();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tryToShowCGLayer restartDownload, drawableStatus");
        ((StringBuilder)localObject).append(i1);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public LoginWelcomeManager.CommonGuideInfo m()
  {
    if (this.l == null)
    {
      this.l = new LoginWelcomeManager.CommonGuideInfo();
      this.l.a = 0;
    }
    return this.l;
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCommonGuide");
    }
    if (!o()) {
      return;
    }
    this.k = true;
    LoginWelcomeManager.ConvListener localConvListener = this.h;
    if (localConvListener != null) {
      localConvListener.a(this.l);
    }
  }
  
  public boolean o()
  {
    if (m().a == 0)
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
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.m;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this);
      this.m.unRegistObserver(this.D);
    }
    j = 0;
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
            this.a = ((String)localBindContactInfo);
          }
          localBindContactInfo = localObject[1];
          if ((localBindContactInfo instanceof oidb_0x59f.BindContactInfo))
          {
            localBindContactInfo = (oidb_0x59f.BindContactInfo)localBindContactInfo;
            if ((localBindContactInfo.str_mobile.has()) && (!TextUtils.isEmpty(localBindContactInfo.str_mobile.get())))
            {
              ReportController.b(this.m, "dc00898", "", "", "0X8006E3A", "0X8006E3A", 0, 0, "", "", "", "");
              paramBoolean = true;
              break label185;
            }
          }
          paramBoolean = false;
          label185:
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
          paramObject = this.o.edit();
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
      this.o.edit().putLong("sp_key_contactsguide_last_req_time", System.currentTimeMillis()).commit();
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        int i1 = this.y + 1;
        this.y = i1;
        if (i1 > 10)
        {
          QLog.d("LoginWelcomeManager", 1, "handleNewerGuide retry max");
          return;
        }
        BaseActivity localBaseActivity = BaseActivity.sTopActivity;
        Object localObject = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
        if ((localBaseActivity != null) && (((ILoginRegisterApi)localObject).getRegisterQQNumberActivity().isInstance(localBaseActivity)))
        {
          this.v.postDelayed(this, 200L);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("handleNewerGuide real start guide, mBind=%s", new Object[] { Boolean.valueOf(this.w) }));
        }
        this.s = ((IPhoneContactService)this.m.getRuntimeService(IPhoneContactService.class, ""));
        if (PermissionChecker.a().e())
        {
          localObject = "0X8006E38";
          ReportController.b(this.m, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager
 * JD-Core Version:    0.7.0.1
 */