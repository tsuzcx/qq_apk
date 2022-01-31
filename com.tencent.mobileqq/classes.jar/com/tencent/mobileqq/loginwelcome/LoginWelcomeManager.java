package com.tencent.mobileqq.loginwelcome;

import SecurityAccountServer.RecommendedContactInfo;
import aeci;
import aecj;
import aeck;
import aecl;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONArray;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.ContactBindInfo;

public class LoginWelcomeManager
  implements BusinessObserver, PhoneContactManager.IPhoneContactListener, Runnable, Manager
{
  static long jdField_a_of_type_Long;
  int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aecl(this);
  PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new aecj(this);
  private LoginWelcomeHandler jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler;
  public NearbyCardObserver a;
  public String a;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  
  public LoginWelcomeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new aeci(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler = ((LoginWelcomeHandler)paramQQAppInterface.a(84));
  }
  
  public static LoginWelcomeManager a(QQAppInterface paramQQAppInterface)
  {
    return (LoginWelcomeManager)paramQQAppInterface.getManager(145);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 98	java/io/File
    //   6: dup
    //   7: getstatic 103	com/tencent/mobileqq/app/AppConstants:cu	Ljava/lang/String;
    //   10: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 110	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_2
    //   22: invokevirtual 113	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 98	java/io/File
    //   29: dup
    //   30: aload_2
    //   31: ldc 115
    //   33: invokespecial 118	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 110	java/io/File:exists	()Z
    //   43: ifeq +9 -> 52
    //   46: aload 5
    //   48: invokevirtual 121	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_1
    //   53: invokestatic 127	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   56: sipush 200
    //   59: sipush 200
    //   62: iconst_1
    //   63: invokestatic 133	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   66: astore 7
    //   68: new 135	java/io/FileOutputStream
    //   71: dup
    //   72: aload 5
    //   74: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   77: astore_2
    //   78: new 140	java/io/BufferedOutputStream
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 143	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore_1
    //   87: aload_1
    //   88: astore 4
    //   90: aload_2
    //   91: astore_3
    //   92: aload 7
    //   94: getstatic 149	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 100
    //   99: aload_1
    //   100: invokevirtual 153	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload_1
    //   105: astore 4
    //   107: aload_2
    //   108: astore_3
    //   109: aload_1
    //   110: invokevirtual 156	java/io/BufferedOutputStream:flush	()V
    //   113: aload_1
    //   114: astore 4
    //   116: aload_2
    //   117: astore_3
    //   118: aload 5
    //   120: invokevirtual 160	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: astore 5
    //   125: aload 5
    //   127: astore_3
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 163	java/io/FileOutputStream:close	()V
    //   136: aload_3
    //   137: astore_2
    //   138: aload_1
    //   139: ifnull +9 -> 148
    //   142: aload_1
    //   143: invokevirtual 164	java/io/BufferedOutputStream:close	()V
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
    //   161: ldc 166
    //   163: iconst_1
    //   164: ldc 168
    //   166: aload 5
    //   168: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 163	java/io/FileOutputStream:close	()V
    //   179: aload 6
    //   181: astore_2
    //   182: aload_1
    //   183: ifnull -35 -> 148
    //   186: aload_1
    //   187: invokevirtual 164	java/io/BufferedOutputStream:close	()V
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
    //   206: invokevirtual 163	java/io/FileOutputStream:close	()V
    //   209: aload 4
    //   211: ifnull +8 -> 219
    //   214: aload 4
    //   216: invokevirtual 164	java/io/BufferedOutputStream:close	()V
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
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    run();
  }
  
  private void d(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("path");
    boolean bool = paramBundle.getBoolean("PhotoConst.SYNCQZONE", false);
    String str2 = paramBundle.getString("PhotoConst.SOURCE_FROM");
    this.jdField_b_of_type_JavaLangString = a(str1);
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
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("loginwelcome_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("first_login", 0);
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "requestIsFirstLogin state=" + i);
    }
    if (i != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this, true);
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeHandler.b();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putBoolean("first_device", false);
      localEditor.putInt("bubble_tips_time", 0);
      localEditor.putInt("first_login", 1);
      localEditor.commit();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onBindStateChanged" + paramInt);
    }
    if ((paramInt != 8) && (paramInt != 4))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("LoginWelcomeManager", 2, "upload end");
        QLog.d("LoginWelcomeManager", 2, "cost " + (SystemClock.uptimeMillis() - jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
        if (paramInt != 9) {
          break label121;
        }
        d();
      }
    }
    return;
    label121:
    if (paramInt == 2)
    {
      e();
      return;
    }
    a(null);
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "startWebPage " + paramInt + paramContext.getClass().getSimpleName());
    }
    String str = String.format("http://ti.qq.com/newguide/index.html?_wv=16777217&bind=%s&appid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AppSetting.jdField_a_of_type_Int) });
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    NearbyCardHandler localNearbyCardHandler = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(60);
    long l = paramBundle.getLong("tinyId");
    NearbyProfileUtil.a(localNearbyCardHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, null, 100, null, 0L, false, 0L);
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
    if (str.equals("getRecommendedList"))
    {
      this.jdField_b_of_type_AndroidOsBundle = paramBundle;
      c();
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidOsBundle != null);
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
      if (str.equals("sayHi"))
      {
        a(paramMessengerService);
        return;
      }
    } while (!"setAvatar".equals(str));
    d(paramMessengerService);
  }
  
  public void a(List paramList)
  {
    Object localObject = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    int i;
    if (paramList == null)
    {
      ((Bundle)localObject).putString("op_result", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("resp Recommended ");
        if (paramList != null) {
          break label246;
        }
        i = 0;
        label51:
        QLog.d("LoginWelcomeManager", 2, i);
      }
      paramList = (MessengerService)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramList == null) {
        break label256;
      }
      paramList.a(this.jdField_b_of_type_AndroidOsBundle);
    }
    label246:
    while (!QLog.isColorLevel())
    {
      return;
      QQHeadDownloadHandler localQQHeadDownloadHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)localIterator.next();
        String str = MsfSdkUtils.insertMtype("QQHeadIcon", localRecommendedContactInfo.faceUrl + localQQHeadDownloadHandler.a((byte)(int)localRecommendedContactInfo.faceFlag));
        localRecommendedContactInfo.url = (str + "&t=" + System.currentTimeMillis());
        localJSONArray.put(localRecommendedContactInfo.toJson());
      }
      ((Bundle)localObject).putString("op_result", localJSONArray.toString());
      break;
      i = paramList.size();
      break label51;
    }
    label256:
    QLog.d("LoginWelcomeManager", 2, "no service");
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c >= 2))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("LoginWelcomeManager", 2, "onUpdateMatchProgress >4");
        QLog.d("LoginWelcomeManager", 2, "cost " + (SystemClock.uptimeMillis() - jdField_a_of_type_Long));
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      if ((paramInt != 8) && (paramInt != 9)) {
        break label103;
      }
      d();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
      return;
      label103:
      if ((paramInt == 4) || (paramInt == 2)) {
        e();
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      localTroopHandler.a(Long.parseLong(paramBundle), 8390784);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LoginWelcomeManager", 2, "joinTroop err", paramBundle);
    }
  }
  
  public void c()
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c() == 9)
      {
        d();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h();
  }
  
  public void c(int paramInt) {}
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str, new aeck(this, paramBundle), true, 15);
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_AndroidOsBundle == null) {
      return;
    }
    Bundle localBundle = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 36);
    localNewIntent.putExtra("unique_phone_no", ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a());
    int i = localBundle.getInt("wantCount");
    if (i > 0) {}
    for (;;)
    {
      localNewIntent.putExtra("wantCount", i);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedList " + i);
      return;
      i = 21;
    }
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_AndroidOsBundle == null) {
      return;
    }
    Bundle localBundle = this.jdField_b_of_type_AndroidOsBundle.getBundle("request");
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 40);
    localNewIntent.putExtra("unique_phone_no", ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a());
    int i = localBundle.getInt("wantCount");
    if (i > 0) {}
    for (;;)
    {
      localNewIntent.putExtra("wantCount", i);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedListNotBind " + i);
      return;
      i = 21;
    }
  }
  
  public void onDestroy() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 558) {
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 2)
        {
          Object localObject = paramObject[0];
          if ((localObject != null) && ((localObject instanceof String))) {
            this.jdField_a_of_type_JavaLangString = ((String)localObject);
          }
          paramObject = paramObject[1];
          if ((paramObject == null) || (!(paramObject instanceof oidb_0x59f.ContactBindInfo))) {
            break label227;
          }
          paramObject = (oidb_0x59f.ContactBindInfo)paramObject;
          if ((!paramObject.mobile.has()) || (TextUtils.isEmpty(paramObject.mobile.get()))) {
            break label227;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006E3A", "0X8006E3A", 0, 0, "", "", "", "");
        }
      }
    }
    label227:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onUpdate mRegisterNumber=%s bind=%s", new Object[] { this.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramBoolean) }));
      }
      paramObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramObject.putBoolean("first_device", true);
      paramObject.commit();
      this.jdField_a_of_type_Boolean = true;
      a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
      return;
    }
  }
  
  public void run()
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i > 10)
      {
        QLog.d("LoginWelcomeManager", 1, "retry max");
        return;
      }
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity == null) || (!(localBaseActivity instanceof RegisterQQNumberActivity))) {
        break label75;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 200L);
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label231;
      }
    }
    QLog.d("LoginWelcomeManager", 2, localException, new Object[0]);
    return;
    label75:
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "real start guide " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "no permission");
      }
      a(localException, 0);
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", localException, localException, 0, 0, "", "", "", "");
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        a(localException, 1);
        i = 1;
      }
      else
      {
        a(localException, 3);
        i = 1;
      }
      label231:
      while (i == 0)
      {
        str = "0X8006E39";
        break;
        return;
      }
      String str = "0X8006E38";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager
 * JD-Core Version:    0.7.0.1
 */