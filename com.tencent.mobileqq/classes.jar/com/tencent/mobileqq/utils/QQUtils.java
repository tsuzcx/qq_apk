package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QQUtils
{
  private static String a = "QQUtils";
  
  public static Dialog a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    paramActivity = new ReportDialog(paramActivity, 2131953338);
    paramActivity.setContentView(2131627529);
    TextView localTextView3 = (TextView)paramActivity.findViewById(2131448938);
    TextView localTextView4 = (TextView)paramActivity.findViewById(2131448918);
    TextView localTextView1 = (TextView)paramActivity.findViewById(2131448907);
    TextView localTextView2 = (TextView)paramActivity.findViewById(2131448903);
    localTextView3.setText(paramString1);
    localTextView4.setText(new SpannableString(paramString2));
    paramString1 = (ImageView)paramActivity.findViewById(2131430531);
    ((ImageButton)paramActivity.findViewById(2131430821)).setOnClickListener(new QQUtils.4(paramActivity));
    if (paramInt >= 0)
    {
      paramString1.setVisibility(0);
      localTextView2.setText("+");
      localTextView1.setText(String.valueOf(paramInt));
      return paramActivity;
    }
    localTextView2.setText("-");
    localTextView1.setText(String.valueOf(0 - paramInt));
    return paramActivity;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, String paramString, Map<String, Object> paramMap)
  {
    Intent localIntent = new Intent("intent.start.shortcut.guide");
    localIntent.setClassName(paramQQAppInterface.getApp(), ShortcutGuideActivity.class.getName());
    localIntent.addCategory("android.intent.category.LAUNCHER");
    String str = (String)paramMap.get("nickname");
    if (paramString.endsWith("sid"))
    {
      paramQQAppInterface = (String)paramMap.get("starHomeUrl");
      localIntent.putExtra("sid", (String)paramMap.get("starId"));
      localIntent.putExtra("from", "starShortcut");
      localIntent.putExtra("starhomeurl", paramQQAppInterface);
      paramQQAppInterface = str;
    }
    else
    {
      paramString = (String)paramMap.get("uin");
      int i = Integer.valueOf(paramMap.get("uinType").toString()).intValue();
      localIntent.putExtra("uin", paramString);
      if (str != null)
      {
        paramQQAppInterface = str;
        if (str.trim().length() != 0) {}
      }
      else
      {
        paramQQAppInterface = paramString;
      }
      if (i == 1024) {
        localIntent.putExtra("uintype", 1024);
      } else {
        localIntent.putExtra("uintype", 0);
      }
    }
    localIntent.putExtra("uinname", paramQQAppInterface);
    return localIntent;
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramString2 = a(paramString2);
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      if (paramBoolean) {
        return QQAppInterface.getCircleFaceBitmap(c(paramQQAppInterface.getApp(), paramString3), 50, 50);
      }
      if (!HttpDownloadUtil.download(paramQQAppInterface, paramString1, localFile))
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        return null;
      }
    }
    return QQAppInterface.getCircleFaceBitmap(BitmapManager.a(paramString2), 50, 50);
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null) {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return "0";
    }
    if (((AppRuntime)localObject).getAccount() == null) {
      return "0";
    }
    return ((AppRuntime)localObject).getAccount();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("from", "QQUtils");
      QQBeaconReport.a("", "getAuthorityFromPermission", localHashMap);
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a, 1, "getAuthorityFromPermission report err:", localThrowable);
    }
    paramContext = paramContext.getPackageManager().getInstalledPackages(8);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
        if (arrayOfProviderInfo != null)
        {
          int j = arrayOfProviderInfo.length;
          int i = 0;
          while (i < j)
          {
            ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
            if (paramString.equals(localProviderInfo.readPermission)) {
              return localProviderInfo.authority;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(256);
    localStringBuilder1.append(AppConstants.SDCARD_STAR_HEAD);
    String str = MD5.toMD5(paramString);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append(paramString);
    str = MD5.toMD5(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append(paramString);
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append(".png");
    return localStringBuilder1.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().b(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", "QQ");
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "deleteShortcut.finish.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().b(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    int i = DisplayUtils.a(paramQQAppInterface.getApp());
    paramIntent = paramBitmap;
    if (i != paramBitmap.getWidth()) {
      if (!MobileIssueSettings.c) {
        paramIntent = KapalaiAdapterUtil.a().a(paramBitmap, i);
      } else {
        paramIntent = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
      }
    }
    localIntent.putExtra("android.intent.extra.shortcut.ICON", paramIntent);
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "createShortcut.finish.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    SparseArray localSparseArray = b(paramQQAppInterface.getApp(), paramString);
    if (localSparseArray == null) {
      return;
    }
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      int k = localSparseArray.keyAt(i);
      Object localObject1 = (String)localSparseArray.get(k);
      Object localObject2;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = Intent.parseUri((String)localObject1, 0);
          try
          {
            ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
            ((Intent)localObject2).setComponent(null);
            localObject1 = localObject2;
            if (Build.VERSION.SDK_INT < 15) {
              break label181;
            }
            ((Intent)localObject2).setSelector(null);
            localObject1 = localObject2;
          }
          catch (URISyntaxException localURISyntaxException1)
          {
            break label122;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      catch (URISyntaxException localURISyntaxException2)
      {
        localObject2 = null;
        label122:
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = a;
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("shortcutIntent parse exception ");
          localStringBuilder1.append(localURISyntaxException2.getMessage());
          QLog.d((String)localObject1, 2, localStringBuilder1.toString());
          localObject1 = localObject2;
        }
      }
      label181:
      if (localObject1 == null) {
        return;
      }
      Object localObject3 = ((Intent)localObject1).getStringExtra("uinname");
      if (paramString.endsWith("sid")) {
        localObject2 = a(null, ((Intent)localObject1).getStringExtra("sid"), String.valueOf(k), paramQQAppInterface, true);
      } else {
        localObject2 = SkinUtils.a(paramQQAppInterface.getFaceDrawable(((Intent)localObject1).getStringExtra("uin")));
      }
      a(paramQQAppInterface, (Intent)localObject1);
      try
      {
        Thread.sleep(1000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        if (QLog.isColorLevel())
        {
          String str = a;
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("thread sleep exception ");
          localStringBuilder2.append(localInterruptedException2.getMessage());
          QLog.d(str, 2, localStringBuilder2.toString());
        }
      }
      a(paramQQAppInterface, (Intent)localObject1, (String)localObject3, (Bitmap)localObject2);
      try
      {
        Thread.sleep(1000L);
      }
      catch (InterruptedException localInterruptedException1)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("thread sleep exception ");
          ((StringBuilder)localObject3).append(localInterruptedException1.getMessage());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("uin", paramString1);
    ((Map)localObject).put("nickname", paramString2);
    ((Map)localObject).put("uinType", Integer.valueOf(paramInt));
    Intent localIntent = a(paramQQAppInterface, "uin", (Map)localObject);
    localObject = paramQQAppInterface.getFaceBitmap(1, paramString1, (byte)3, true, 0);
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = ImageUtil.k();
    }
    a(paramQQAppInterface, localIntent, paramString2, paramString1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, MqqHandler paramMqqHandler, int paramInt2, String paramString3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "createShortcutWhihTips.begin.");
    }
    if (a(paramQQAppInterface.getApp(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.getApp().getString(2131889065);
      if (paramString1 != null) {
        paramMqqHandler.post(new QQUtils.1(paramQQAppInterface, paramString1, paramInt1));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "createShortcutWhihTips.no shortcut.");
      }
      a(paramQQAppInterface, paramString1, paramString2, paramInt3);
      paramMqqHandler.postDelayed(new QQUtils.2(a(paramQQAppInterface.getApp(), new String[] { paramString2 }), paramQQAppInterface, paramInt1, paramString3), paramInt2);
    }
  }
  
  public static final boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    return ShortcutUtils.a(paramContext, paramArrayOfString);
  }
  
  /* Error */
  public static SparseArray<String> b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 533	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 534	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 538	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: astore_0
    //   18: aload_2
    //   19: invokestatic 544	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   22: astore_2
    //   23: new 291	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: ldc_w 546
    //   35: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: aload_1
    //   41: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: ldc_w 548
    //   49: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: aload_2
    //   60: iconst_2
    //   61: anewarray 68	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc_w 550
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: ldc_w 552
    //   75: aastore
    //   76: aload_1
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 558	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +83 -> 167
    //   87: aload_0
    //   88: astore_1
    //   89: new 395	android/util/SparseArray
    //   92: dup
    //   93: invokespecial 559	android/util/SparseArray:<init>	()V
    //   96: astore_2
    //   97: aload_0
    //   98: astore_1
    //   99: aload_0
    //   100: invokeinterface 564 1 0
    //   105: ifeq +46 -> 151
    //   108: aload_0
    //   109: astore_1
    //   110: aload_0
    //   111: aload_0
    //   112: ldc_w 550
    //   115: invokeinterface 568 2 0
    //   120: invokeinterface 569 2 0
    //   125: astore_3
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: aload_0
    //   130: aload_0
    //   131: ldc_w 552
    //   134: invokeinterface 568 2 0
    //   139: invokeinterface 572 2 0
    //   144: aload_3
    //   145: invokevirtual 575	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   148: goto -51 -> 97
    //   151: aload_0
    //   152: ifnull +9 -> 161
    //   155: aload_0
    //   156: invokeinterface 578 1 0
    //   161: aload_2
    //   162: areturn
    //   163: astore_2
    //   164: goto +19 -> 183
    //   167: aload_0
    //   168: ifnull +85 -> 253
    //   171: goto +76 -> 247
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_1
    //   177: goto +79 -> 256
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_0
    //   183: aload_0
    //   184: astore_1
    //   185: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +55 -> 243
    //   191: aload_0
    //   192: astore_1
    //   193: getstatic 236	com/tencent/mobileqq/utils/QQUtils:a	Ljava/lang/String;
    //   196: astore_3
    //   197: aload_0
    //   198: astore_1
    //   199: new 291	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   206: astore 4
    //   208: aload_0
    //   209: astore_1
    //   210: aload 4
    //   212: ldc_w 580
    //   215: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_0
    //   220: astore_1
    //   221: aload 4
    //   223: aload_2
    //   224: invokevirtual 581	java/lang/Exception:toString	()Ljava/lang/String;
    //   227: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_0
    //   232: astore_1
    //   233: aload_3
    //   234: iconst_2
    //   235: aload 4
    //   237: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 356	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: ifnull +9 -> 253
    //   247: aload_0
    //   248: invokeinterface 578 1 0
    //   253: aconst_null
    //   254: areturn
    //   255: astore_0
    //   256: aload_1
    //   257: ifnull +9 -> 266
    //   260: aload_1
    //   261: invokeinterface 578 1 0
    //   266: goto +5 -> 271
    //   269: aload_0
    //   270: athrow
    //   271: goto -2 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramContext	Context
    //   0	274	1	paramString	String
    //   12	150	2	localObject1	Object
    //   163	1	2	localException1	java.lang.Exception
    //   180	44	2	localException2	java.lang.Exception
    //   30	204	3	localObject2	Object
    //   206	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   89	97	163	java/lang/Exception
    //   99	108	163	java/lang/Exception
    //   110	126	163	java/lang/Exception
    //   128	148	163	java/lang/Exception
    //   18	83	174	finally
    //   18	83	180	java/lang/Exception
    //   89	97	255	finally
    //   99	108	255	finally
    //   110	126	255	finally
    //   128	148	255	finally
    //   185	191	255	finally
    //   193	197	255	finally
    //   199	208	255	finally
    //   210	219	255	finally
    //   221	231	255	finally
    //   233	243	255	finally
  }
  
  /* Error */
  public static Bitmap c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 533	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 534	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 538	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: astore_0
    //   18: aload_0
    //   19: aload_2
    //   20: invokestatic 544	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   23: aconst_null
    //   24: ldc_w 584
    //   27: iconst_1
    //   28: anewarray 68	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: aconst_null
    //   36: invokevirtual 558	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +63 -> 104
    //   44: aconst_null
    //   45: astore_2
    //   46: aload_0
    //   47: astore_1
    //   48: aload_0
    //   49: invokeinterface 564 1 0
    //   54: ifeq +34 -> 88
    //   57: aload_0
    //   58: astore_1
    //   59: aload_0
    //   60: aload_0
    //   61: ldc_w 586
    //   64: invokeinterface 568 2 0
    //   69: invokeinterface 590 2 0
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: iconst_0
    //   79: aload_2
    //   80: arraylength
    //   81: invokestatic 593	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   84: astore_2
    //   85: goto -39 -> 46
    //   88: aload_0
    //   89: ifnull +9 -> 98
    //   92: aload_0
    //   93: invokeinterface 578 1 0
    //   98: aload_2
    //   99: areturn
    //   100: astore_2
    //   101: goto +19 -> 120
    //   104: aload_0
    //   105: ifnull +85 -> 190
    //   108: goto +76 -> 184
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: goto +79 -> 193
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: astore_1
    //   122: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +55 -> 180
    //   128: aload_0
    //   129: astore_1
    //   130: getstatic 236	com/tencent/mobileqq/utils/QQUtils:a	Ljava/lang/String;
    //   133: astore_3
    //   134: aload_0
    //   135: astore_1
    //   136: new 291	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   143: astore 4
    //   145: aload_0
    //   146: astore_1
    //   147: aload 4
    //   149: ldc_w 580
    //   152: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_0
    //   157: astore_1
    //   158: aload 4
    //   160: aload_2
    //   161: invokevirtual 581	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: astore_1
    //   170: aload_3
    //   171: iconst_2
    //   172: aload 4
    //   174: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 356	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_0
    //   181: ifnull +9 -> 190
    //   184: aload_0
    //   185: invokeinterface 578 1 0
    //   190: aconst_null
    //   191: areturn
    //   192: astore_0
    //   193: aload_1
    //   194: ifnull +9 -> 203
    //   197: aload_1
    //   198: invokeinterface 578 1 0
    //   203: goto +5 -> 208
    //   206: aload_0
    //   207: athrow
    //   208: goto -2 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramContext	Context
    //   0	211	1	paramString	String
    //   12	87	2	localObject	Object
    //   100	1	2	localException1	java.lang.Exception
    //   117	44	2	localException2	java.lang.Exception
    //   133	38	3	str	String
    //   143	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	57	100	java/lang/Exception
    //   59	75	100	java/lang/Exception
    //   77	85	100	java/lang/Exception
    //   18	40	111	finally
    //   18	40	117	java/lang/Exception
    //   48	57	192	finally
    //   59	75	192	finally
    //   77	85	192	finally
    //   122	128	192	finally
    //   130	134	192	finally
    //   136	145	192	finally
    //   147	156	192	finally
    //   158	168	192	finally
    //   170	180	192	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils
 * JD-Core Version:    0.7.0.1
 */