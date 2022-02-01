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
    paramActivity = new ReportDialog(paramActivity, 2131756189);
    paramActivity.setContentView(2131561177);
    TextView localTextView3 = (TextView)paramActivity.findViewById(2131380032);
    TextView localTextView4 = (TextView)paramActivity.findViewById(2131380014);
    TextView localTextView1 = (TextView)paramActivity.findViewById(2131380005);
    TextView localTextView2 = (TextView)paramActivity.findViewById(2131380001);
    localTextView3.setText(paramString1);
    localTextView4.setText(new SpannableString(paramString2));
    paramString1 = (ImageView)paramActivity.findViewById(2131364474);
    ((ImageButton)paramActivity.findViewById(2131364715)).setOnClickListener(new QQUtils.4(paramActivity));
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
  
  /* Error */
  public static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 173	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 175	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 181	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: astore_0
    //   18: aload_0
    //   19: aload_2
    //   20: invokestatic 187	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   23: aconst_null
    //   24: ldc 189
    //   26: iconst_1
    //   27: anewarray 68	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: aconst_null
    //   35: invokevirtual 195	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +62 -> 102
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_0
    //   46: astore_1
    //   47: aload_0
    //   48: invokeinterface 201 1 0
    //   53: ifeq +33 -> 86
    //   56: aload_0
    //   57: astore_1
    //   58: aload_0
    //   59: aload_0
    //   60: ldc 203
    //   62: invokeinterface 207 2 0
    //   67: invokeinterface 211 2 0
    //   72: astore_2
    //   73: aload_0
    //   74: astore_1
    //   75: aload_2
    //   76: iconst_0
    //   77: aload_2
    //   78: arraylength
    //   79: invokestatic 216	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   82: astore_2
    //   83: goto -38 -> 45
    //   86: aload_0
    //   87: ifnull +9 -> 96
    //   90: aload_0
    //   91: invokeinterface 219 1 0
    //   96: aload_2
    //   97: areturn
    //   98: astore_2
    //   99: goto +19 -> 118
    //   102: aload_0
    //   103: ifnull +84 -> 187
    //   106: goto +75 -> 181
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: goto +78 -> 190
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: astore_1
    //   120: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +54 -> 177
    //   126: aload_0
    //   127: astore_1
    //   128: getstatic 225	com/tencent/mobileqq/utils/QQUtils:a	Ljava/lang/String;
    //   131: astore_3
    //   132: aload_0
    //   133: astore_1
    //   134: new 227	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   141: astore 4
    //   143: aload_0
    //   144: astore_1
    //   145: aload 4
    //   147: ldc 230
    //   149: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_0
    //   154: astore_1
    //   155: aload 4
    //   157: aload_2
    //   158: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   161: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_0
    //   166: astore_1
    //   167: aload_3
    //   168: iconst_2
    //   169: aload 4
    //   171: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload_0
    //   178: ifnull +9 -> 187
    //   181: aload_0
    //   182: invokeinterface 219 1 0
    //   187: aconst_null
    //   188: areturn
    //   189: astore_0
    //   190: aload_1
    //   191: ifnull +9 -> 200
    //   194: aload_1
    //   195: invokeinterface 219 1 0
    //   200: goto +5 -> 205
    //   203: aload_0
    //   204: athrow
    //   205: goto -2 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramContext	Context
    //   0	208	1	paramString	String
    //   12	85	2	localObject	Object
    //   98	1	2	localException1	java.lang.Exception
    //   115	43	2	localException2	java.lang.Exception
    //   131	37	3	str	String
    //   141	29	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   47	56	98	java/lang/Exception
    //   58	73	98	java/lang/Exception
    //   75	83	98	java/lang/Exception
    //   18	39	109	finally
    //   18	39	115	java/lang/Exception
    //   47	56	189	finally
    //   58	73	189	finally
    //   75	83	189	finally
    //   120	126	189	finally
    //   128	132	189	finally
    //   134	143	189	finally
    //   145	153	189	finally
    //   155	165	189	finally
    //   167	177	189	finally
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramString2 = a(paramString2);
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      if (paramBoolean) {
        return QQAppInterface.getCircleFaceBitmap(a(paramQQAppInterface.getApp(), paramString3), 50, 50);
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
  
  /* Error */
  public static SparseArray<String> a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 173	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 175	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 181	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: astore_0
    //   18: aload_2
    //   19: invokestatic 187	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   22: astore_2
    //   23: new 227	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: ldc_w 271
    //   35: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: aload_1
    //   41: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: ldc_w 273
    //   49: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: aload_2
    //   60: iconst_2
    //   61: anewarray 68	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc_w 275
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: ldc_w 277
    //   75: aastore
    //   76: aload_1
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 195	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +83 -> 167
    //   87: aload_0
    //   88: astore_1
    //   89: new 279	android/util/SparseArray
    //   92: dup
    //   93: invokespecial 280	android/util/SparseArray:<init>	()V
    //   96: astore_2
    //   97: aload_0
    //   98: astore_1
    //   99: aload_0
    //   100: invokeinterface 201 1 0
    //   105: ifeq +46 -> 151
    //   108: aload_0
    //   109: astore_1
    //   110: aload_0
    //   111: aload_0
    //   112: ldc_w 275
    //   115: invokeinterface 207 2 0
    //   120: invokeinterface 283 2 0
    //   125: astore_3
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: aload_0
    //   130: aload_0
    //   131: ldc_w 277
    //   134: invokeinterface 207 2 0
    //   139: invokeinterface 287 2 0
    //   144: aload_3
    //   145: invokevirtual 291	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   148: goto -51 -> 97
    //   151: aload_0
    //   152: ifnull +9 -> 161
    //   155: aload_0
    //   156: invokeinterface 219 1 0
    //   161: aload_2
    //   162: areturn
    //   163: astore_2
    //   164: goto +19 -> 183
    //   167: aload_0
    //   168: ifnull +84 -> 252
    //   171: goto +75 -> 246
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_1
    //   177: goto +78 -> 255
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_0
    //   183: aload_0
    //   184: astore_1
    //   185: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +54 -> 242
    //   191: aload_0
    //   192: astore_1
    //   193: getstatic 225	com/tencent/mobileqq/utils/QQUtils:a	Ljava/lang/String;
    //   196: astore_3
    //   197: aload_0
    //   198: astore_1
    //   199: new 227	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   206: astore 4
    //   208: aload_0
    //   209: astore_1
    //   210: aload 4
    //   212: ldc 230
    //   214: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_0
    //   219: astore_1
    //   220: aload 4
    //   222: aload_2
    //   223: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   226: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_0
    //   231: astore_1
    //   232: aload_3
    //   233: iconst_2
    //   234: aload 4
    //   236: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload_0
    //   243: ifnull +9 -> 252
    //   246: aload_0
    //   247: invokeinterface 219 1 0
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: aload_1
    //   256: ifnull +9 -> 265
    //   259: aload_1
    //   260: invokeinterface 219 1 0
    //   265: goto +5 -> 270
    //   268: aload_0
    //   269: athrow
    //   270: goto -2 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramContext	Context
    //   0	273	1	paramString	String
    //   12	150	2	localObject1	Object
    //   163	1	2	localException1	java.lang.Exception
    //   180	43	2	localException2	java.lang.Exception
    //   30	203	3	localObject2	Object
    //   206	29	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   89	97	163	java/lang/Exception
    //   99	108	163	java/lang/Exception
    //   110	126	163	java/lang/Exception
    //   128	148	163	java/lang/Exception
    //   18	83	174	finally
    //   18	83	180	java/lang/Exception
    //   89	97	254	finally
    //   99	108	254	finally
    //   110	126	254	finally
    //   128	148	254	finally
    //   185	191	254	finally
    //   193	197	254	finally
    //   199	208	254	finally
    //   210	218	254	finally
    //   220	230	254	finally
    //   232	242	254	finally
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
    KapalaiAdapterUtil.a().a(paramIntent);
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
    KapalaiAdapterUtil.a().a(paramIntent);
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
    SparseArray localSparseArray = a(paramQQAppInterface.getApp(), paramString);
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
      paramString1 = ImageUtil.f();
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
      paramString1 = paramQQAppInterface.getApp().getString(2131692087);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils
 * JD-Core Version:    0.7.0.1
 */