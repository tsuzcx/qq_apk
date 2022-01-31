import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class mbt
{
  static int a;
  public static final String[] a;
  static int jdField_b_of_type_Int;
  static String[] jdField_b_of_type_ArrayOfJavaLangString = { "com.qzone.preview.BasePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.QZoneVideoFloatActivity", "com.tencent.mobileqq.activity.FriendProfileImageActivity", "com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity", "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity", "com.tencent.av.gaudio.GaInviteDialogActivity", "com.tencent.av.ui.MultiIncomingCallsActivity", "com.tencent.av.ui.GAudioMembersCtrlActivity", "com.tencent.av.ui.VideoInviteActivity", "com.tencent.mobileqq.activity.selectmember.SelectMemberActivity", "cooperation.qzone.QzonePicturePluginProxyActivity", "com.tencent.av.utils.PopupDialog", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "com.meizu.safe.security.AppSecActivity", "com.android.settings.Settings$AppDrawOverlaySettingsActivity", "com.tencent.biz.qrcode.activity.QRDisplayActivity", "com.tencent.mobileqq.activity.ForwardRecentActivity", "cooperation.qzone.share.QZoneShareActivity" };
  static int c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "vivo Y51A", "2014011" };
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    c = -1;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return 2130772157;
    case 1: 
      return 2130772154;
    case 2: 
      return 2130772155;
    case 3: 
      return 2130772153;
    case 4: 
      return 2130772152;
    case 5: 
      return 2130772151;
    case 6: 
      return 2130772159;
    case 7: 
      return 2130772160;
    case 8: 
      return 2130772158;
    }
    return 2130772156;
  }
  
  /* Error */
  public static int a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 92	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 4
    //   6: ldc 94
    //   8: invokestatic 100	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   11: astore 5
    //   13: new 102	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   20: ldc 107
    //   22: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 115	android/content/Context:getPackageName	()Ljava/lang/String;
    //   29: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 117
    //   34: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 6
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_1
    //   47: anewarray 13	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc 122
    //   54: aastore
    //   55: aload 6
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 128	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +174 -> 240
    //   69: aload 5
    //   71: astore 4
    //   73: aload 5
    //   75: invokeinterface 134 1 0
    //   80: ifeq +160 -> 240
    //   83: aload 5
    //   85: astore 4
    //   87: aload 5
    //   89: iconst_0
    //   90: invokeinterface 137 2 0
    //   95: istore_3
    //   96: iload_3
    //   97: ifne +66 -> 163
    //   100: iconst_0
    //   101: istore_2
    //   102: aload 5
    //   104: astore 4
    //   106: ldc 139
    //   108: iconst_1
    //   109: new 102	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   116: ldc 141
    //   118: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_3
    //   122: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc 146
    //   127: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_2
    //   131: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: ldc 148
    //   136: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: iload_2
    //   146: istore_1
    //   147: aload 5
    //   149: ifnull +12 -> 161
    //   152: aload 5
    //   154: invokeinterface 157 1 0
    //   159: iload_2
    //   160: istore_1
    //   161: iload_1
    //   162: ireturn
    //   163: iconst_2
    //   164: istore_2
    //   165: goto -63 -> 102
    //   168: astore 6
    //   170: aconst_null
    //   171: astore 5
    //   173: aload 5
    //   175: astore 4
    //   177: ldc 139
    //   179: iconst_1
    //   180: ldc 159
    //   182: aload 6
    //   184: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload 5
    //   189: astore 4
    //   191: aload_0
    //   192: iload_1
    //   193: invokestatic 164	mbt:b	(Landroid/content/Context;I)I
    //   196: istore_2
    //   197: iload_2
    //   198: istore_1
    //   199: aload 5
    //   201: ifnull -40 -> 161
    //   204: aload 5
    //   206: invokeinterface 157 1 0
    //   211: iload_2
    //   212: ireturn
    //   213: astore_0
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 4
    //   219: ifnull +10 -> 229
    //   222: aload 4
    //   224: invokeinterface 157 1 0
    //   229: aload_0
    //   230: athrow
    //   231: astore_0
    //   232: goto -15 -> 217
    //   235: astore 6
    //   237: goto -64 -> 173
    //   240: iconst_0
    //   241: istore_2
    //   242: goto -97 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	Context
    //   0	245	1	paramInt	int
    //   101	141	2	i	int
    //   95	27	3	j	int
    //   4	219	4	localObject1	Object
    //   11	194	5	localObject2	Object
    //   40	16	6	str	String
    //   168	15	6	localThrowable1	Throwable
    //   235	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	64	168	java/lang/Throwable
    //   0	64	213	finally
    //   73	83	231	finally
    //   87	96	231	finally
    //   106	145	231	finally
    //   177	187	231	finally
    //   191	197	231	finally
    //   73	83	235	java/lang/Throwable
    //   87	96	235	java/lang/Throwable
    //   106	145	235	java/lang/Throwable
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(paramString);
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      int i = localSharedPreferences.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "getPrefShowDialog result = " + i);
      }
      return i;
    }
  }
  
  static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("com.tencent.av.smallscreen" + paramString, 0);
  }
  
  static mcd a()
  {
    lnc locallnc = lim.a(BaseApplicationImpl.getContext());
    mcd localmcd;
    if (!locallnc.a())
    {
      localmcd = new mcd();
      if (localmcd.a(locallnc)) {}
    }
    while (!QLog.isColorLevel())
    {
      return null;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> parseConfig fail");
      return localmcd;
    }
    QLog.d("SmallScreenUtils", 2, "getSmallScreenConfigParser --> Can not get PlayLoad Config");
    return null;
    return localmcd;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      String str = "";
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        str = str + "ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
        i += 1;
      }
      QLog.d("SmallScreenUtils", 2, str);
    }
  }
  
  public static void a(long paramLong, Context paramContext)
  {
    QLog.w("SmallScreenUtils", 1, "avideo actionOff, seq[" + paramLong + "]");
    Intent localIntent = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SmallScreenUtils", 2, "actionOff e = " + paramContext);
    }
  }
  
  public static void a(long paramLong, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService(localIntent);
      paramContext.startService(localIntent);
      if (!b(BaseApplicationImpl.getContext())) {
        lkx.a(32);
      }
      if (AudioHelper.e()) {
        QLog.w("SmallScreenUtils", 1, "actionOn isFloatWindowOpAllowed, isFloatWindowOpAllowed[" + c(paramContext) + "], isCalling[" + muz.d(paramContext) + "], isHome[" + a(paramContext) + "], isNeedStartDialog[" + paramBoolean1 + "], seq[" + paramLong + "]");
      }
      if (a(paramContext, paramBoolean1, paramString, paramBoolean2)) {
        azqs.b(null, "CliOper", "", "", "0X80057D8", "0X80057D8", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "actionOn e = " + localException);
        }
      }
    }
  }
  
  public static void a(Context paramContext, lid paramlid)
  {
    int i = paramlid.jdField_d_of_type_Int;
    int j = paramlid.E;
    int k = paramlid.jdField_g_of_type_Int;
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenUtils", 2, "reportActionOn SessionType = " + i);
      QLog.d("SmallScreenUtils", 2, "reportActionOn relationType = " + j);
      QLog.d("SmallScreenUtils", 2, "reportActionOn state = " + k);
    }
    if (paramlid.jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) {
      if (paramlid.jdField_a_of_type_Lif.a > 0L) {
        paramlid = "0X8005A49";
      }
    }
    for (;;)
    {
      if ((paramlid != null) && (c(paramContext))) {
        azqs.b(null, "CliOper", "", "", paramlid, paramlid, 0, 0, "", "", "", "");
      }
      return;
      if (paramlid.jdField_a_of_type_Lie.jdField_b_of_type_Int == 5)
      {
        paramlid = "0X8005A48";
      }
      else
      {
        paramlid = "0X8005A47";
        continue;
        switch (i)
        {
        }
        for (;;)
        {
          paramlid = null;
          break;
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramlid = null;
          }
          for (;;)
          {
            break;
            paramlid = "0X8005A44";
            continue;
            paramlid = "0X8005A43";
          }
          switch (k)
          {
          case 2: 
          case 3: 
          default: 
            paramlid = null;
          }
          for (;;)
          {
            break;
            paramlid = "0X80057DE";
            continue;
            paramlid = "0X80057DD";
          }
          switch (j)
          {
          default: 
            paramlid = null;
          }
          for (;;)
          {
            break;
            paramlid = "0X8005A46";
            continue;
            paramlid = "0X8005A45";
          }
          switch (j)
          {
          }
        }
        paramlid = "0X80057E0";
        continue;
        paramlid = "0X80057DF";
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("isResume", paramBoolean);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "sendHideSmallScreenBroadcast:" + paramBoolean);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    boolean bool;
    label49:
    label64:
    AnimationSet localAnimationSet;
    if (paramView != null)
    {
      localObject = paramView.getTag(2131372567);
      if (localObject != null) {
        break label190;
      }
      bool = false;
      if ((!paramBoolean2) || (!bool)) {
        break label236;
      }
      localObject = paramView.getTag(2131372568);
      if (localObject != null) {
        break label203;
      }
      bool = false;
      if ((paramView.getVisibility() != 0) || (!bool)) {
        break label216;
      }
      bool = true;
      if (bool != paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "startSetVisibleAnimation isVisible = " + paramBoolean1);
        }
        localAnimationSet = new AnimationSet(true);
        if (!paramBoolean1) {
          break label222;
        }
      }
    }
    label190:
    label203:
    label216:
    label222:
    for (Object localObject = new AlphaAnimation(0.0F, 1.0F);; localObject = new AlphaAnimation(1.0F, 0.0F))
    {
      ((AlphaAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setAnimationListener(new mbu(paramView, paramBoolean1));
      paramView.startAnimation(localAnimationSet);
      paramView.setVisibility(0);
      paramView.setTag(2131372568, Boolean.valueOf(paramBoolean1));
      paramView.setTag(2131372567, Boolean.valueOf(paramBoolean2));
      return;
      bool = ((Boolean)localObject).booleanValue();
      break;
      bool = ((Boolean)localObject).booleanValue();
      break label49;
      bool = false;
      break label64;
    }
    label236:
    paramView.clearAnimation();
    if (paramBoolean1) {}
    for (;;)
    {
      paramView.setVisibility(i);
      break;
      i = 8;
    }
  }
  
  public static void a(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    paramString = "" + "getTrace[" + paramString + "]\n";
    int i = 1;
    while (i < j)
    {
      paramString = paramString + "ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
      i += 1;
    }
    QLog.d("SmallScreenUtils", 1, paramString);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a(paramString).edit();
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      localEditor.putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "setPrefShowDialog value = " + paramInt);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equals(str))
      {
        QLog.w("SmallScreenUtils", 1, "useTypeToast, model[" + Build.MODEL + "]");
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    boolean bool2 = false;
    SmallScreenService.g = false;
    boolean bool1 = bool2;
    if (paramVideoAppInterface != null)
    {
      bool1 = bool2;
      if (paramVideoAppInterface.getApplication() != null)
      {
        bool1 = bool2;
        if (paramVideoAppInterface.getApp() != null)
        {
          bool1 = bool2;
          if (paramVideoAppInterface.a() != null)
          {
            bool1 = bool2;
            if (paramVideoAppInterface.a().a() != null)
            {
              Object localObject = paramVideoAppInterface.a().a();
              String str = ((lid)localObject).jdField_d_of_type_JavaLangString;
              if ((((lid)localObject).jdField_d_of_type_Int == 3) || (((lid)localObject).jdField_d_of_type_Int == 4)) {
                str = String.valueOf(((lid)localObject).jdField_g_of_type_Long);
              }
              localObject = new Intent("tencent.video.v2q.SmallScreenState");
              ((Intent)localObject).setPackage(paramVideoAppInterface.getApplication().getPackageName());
              ((Intent)localObject).putExtra("SmallScreenState", paramInt);
              mwd.a((Intent)localObject, paramLong);
              ((Intent)localObject).putExtra("uin", str);
              paramVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.w("SmallScreenUtils", 1, "sendSmallScreenStateBroadcast, state[" + paramInt + "], seq[" + paramLong + "]");
              }
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    try
    {
      List localList = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.HOME"), 0);
      bool2 = bool4;
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if (paramContext != null)
      {
        bool2 = bool4;
        paramContext = paramContext.iterator();
        bool2 = bool1;
        bool3 = bool1;
        if (paramContext.hasNext())
        {
          bool2 = bool1;
          String str = ((ActivityManager.RunningTaskInfo)paramContext.next()).topActivity.getClassName();
          bool2 = bool1;
          Iterator localIterator = localList.iterator();
          do
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            bool2 = bool1;
            bool3 = ((ResolveInfo)localIterator.next()).activityInfo.name.equals(str);
          } while (!bool3);
          bool1 = true;
          for (;;)
          {
            if (bool1) {
              return bool1;
            }
            break;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      lek.e("SmallScreenUtils", paramContext.getMessage());
      return bool2;
    }
    return bool3;
  }
  
  public static boolean a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (e()) {}
    for (;;)
    {
      return false;
      if (d()) {
        paramInt = a(paramContext, paramInt);
      }
      while (paramInt == 0)
      {
        return true;
        int i = b(paramContext, paramInt);
        paramInt = i;
        if (!paramBoolean)
        {
          paramInt = i;
          if (i != 0) {
            if (c()) {
              paramInt = 0;
            } else {
              paramInt = 2;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 5;
    boolean bool = false;
    if (!paramBoolean1)
    {
      paramBoolean1 = true;
      i = 1;
    }
    for (;;)
    {
      if (AudioHelper.e()) {
        QLog.w("SmallScreenUtils", 1, "startSmallScreenDialogActivity, ret[" + paramBoolean1 + "], code[" + i + "]");
      }
      return paramBoolean1;
      if (e())
      {
        i = 7;
        paramBoolean1 = bool;
      }
      else if (c(paramContext))
      {
        i = 2;
        paramBoolean1 = bool;
      }
      else if (muz.d(paramContext))
      {
        i = 3;
        paramBoolean1 = bool;
      }
      else if (a(paramContext))
      {
        i = 4;
        paramBoolean1 = bool;
      }
      else
      {
        paramBoolean1 = bool;
        if (!e(paramContext)) {
          if ((!TextUtils.isEmpty(paramString)) && (a(paramString, paramBoolean2) >= 5))
          {
            i = 6;
            paramBoolean1 = bool;
          }
          else
          {
            paramString = new Intent(paramContext, SmallScreenDialogActivity.class);
            paramString.addFlags(268435456);
            paramString.addFlags(536870912);
            paramString.addFlags(67108864);
            paramString.addFlags(131072);
            paramString.putExtra("is_video", paramBoolean2);
            paramContext.startActivity(paramString);
            i = 100;
            paramBoolean1 = true;
          }
        }
      }
    }
  }
  
  @TargetApi(23)
  public static int b(Context paramContext, int paramInt)
  {
    do
    {
      for (;;)
      {
        try
        {
          if (b())
          {
            boolean bool = Settings.canDrawOverlays(paramContext);
            if (bool)
            {
              i = 0;
              k = i;
              m = i;
            }
          }
        }
        catch (InvocationTargetException paramContext)
        {
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenUtils", 2, "checkOp_Common InvocationTargetException", paramContext);
          }
          return 2;
          int i = j;
          continue;
        }
        catch (Exception paramContext)
        {
          int m = 0;
          int k = m;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("SmallScreenUtils", 2, "checkOp_Common Exception", paramContext);
          return m;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            m = i;
            QLog.w("SmallScreenUtils", 1, "checkOp_Common canDrawOve rlays, op[" + paramInt + "], result[" + i + "]");
            k = i;
          }
          return k;
        }
        catch (Exception paramContext)
        {
          continue;
          j = 0;
          continue;
        }
        i = 2;
      }
      localObject = paramContext.getSystemService("appops");
      paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramContext.getApplicationInfo().uid), paramContext.getPackageName() });
      if (paramContext == null) {
        break label315;
      }
      j = ((Integer)paramContext).intValue();
      if (3 != j) {
        break label279;
      }
      i = Build.VERSION.SDK_INT;
      if (i >= 23) {
        break label279;
      }
      i = 0;
      k = i;
      m = i;
    } while (!QLog.isColorLevel());
    m = i;
    QLog.w("SmallScreenUtils", 1, "checkOp_Common suc, op[" + paramInt + "], mode[" + j + "], result[" + i + "]");
    return i;
  }
  
  @TargetApi(23)
  static boolean b()
  {
    if (jdField_a_of_type_Int == -1)
    {
      jdField_a_of_type_Int = 0;
      if (Build.VERSION.SDK_INT < 28) {
        break label32;
      }
      jdField_a_of_type_Int = 1;
    }
    while (jdField_a_of_type_Int == 1)
    {
      return true;
      label32:
      if (Build.VERSION.SDK_INT < 23) {}
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = VideoController.a(paramContext);
    if (((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("HM NOTE 1TD"))) || (Build.MODEL.equals("MI 3C")) || (Build.MODEL.equals("HM NOTE 1S"))) {}
    for (int i = 1; (bool) && (i == 0); i = 0) {
      return true;
    }
    return false;
  }
  
  static boolean c()
  {
    if (jdField_b_of_type_Int == -1)
    {
      jdField_b_of_type_Int = 0;
      if ((Build.MANUFACTURER.equals("vivo")) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL)) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL))) {
        break label56;
      }
    }
    while (jdField_b_of_type_Int == 1)
    {
      return true;
      label56:
      jdField_b_of_type_Int = 1;
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = false;
    if ((a(paramContext, 24, false)) || (a())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d()
  {
    return (Build.VERSION.SDK_INT >= 21) && (Build.MANUFACTURER.equalsIgnoreCase("vivo"));
  }
  
  public static boolean d(Context paramContext)
  {
    return (a(paramContext, 24, true)) || (a());
  }
  
  public static boolean e()
  {
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool1;
    if (paramContext == null)
    {
      bool1 = false;
      return bool1;
    }
    label121:
    do
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
        if ((paramContext == null) || (paramContext.size() <= 0)) {
          break label121;
        }
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
      }
      catch (Throwable paramContext)
      {
        boolean bool2;
        return false;
      }
      bool2 = mtj.a(jdField_b_of_type_ArrayOfJavaLangString, paramContext.getClassName());
      bool1 = bool2;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("SmallScreenUtils", 1, "checkTopActivityHideSmallScreen, topActivity[" + paramContext.getClassName() + "], check[" + bool2 + "]");
      return bool2;
      paramContext = null;
    } while (paramContext != null);
    return false;
  }
  
  public static boolean f()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!lno.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreen --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreen result = " + bool1);
      }
      return bool1;
      mcd localmcd = a();
      bool1 = bool2;
      if (localmcd != null)
      {
        bool1 = bool2;
        if (localmcd.jdField_b_of_type_Int > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean f(Context paramContext)
  {
    boolean bool2 = false;
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localRunningAppProcessInfo = null;
        paramContext = localRunningAppProcessInfo;
        if (localList != null)
        {
          paramContext = localRunningAppProcessInfo;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label260;
        }
        if (!QLog.isDevelopLevel()) {
          break label265;
        }
        QLog.d("SmallScreenUtils", 2, "isAppOnForeground componentName = " + paramContext);
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        bool1 = bool2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("SmallScreenUtils", 2, "isAppOnForeground e = " + paramContext);
        return false;
      }
      if (bool1)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SmallScreenUtils", 2, "isAppOnForeground appProcess.processName = " + localRunningAppProcessInfo.processName);
            }
            bool1 = true;
            return bool1;
          }
        }
        bool1 = false;
        continue;
      }
      continue;
      label260:
      boolean bool1 = false;
      continue;
      label265:
      bool1 = true;
    }
  }
  
  public static boolean g()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!lno.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenVideo --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreenVideo result = " + bool1);
      }
      return bool1;
      mcd localmcd = a();
      bool1 = bool2;
      if (localmcd != null)
      {
        bool1 = bool2;
        if (localmcd.jdField_d_of_type_Int > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean h()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!lno.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "isSupportSmallScreenAudio --> Small Screen Switch Is Closed");
      }
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenUtils", 2, "isSupportSmallScreenAudio result = " + bool1);
      }
      return bool1;
      mcd localmcd = a();
      bool1 = bool2;
      if (localmcd != null)
      {
        bool1 = bool2;
        if (localmcd.e > 0) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean i()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {}
    boolean bool1;
    try
    {
      bool1 = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      if (Build.DEVICE.equals("mx2"))
      {
        bool2 = true;
        return bool2;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            bool1 = false;
          }
          bool2 = bool3;
        } while (Build.DEVICE.equals("mx"));
        bool2 = bool3;
      } while (Build.DEVICE.equals("m9"));
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mbt
 * JD-Core Version:    0.7.0.1
 */