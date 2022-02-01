package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ShortcutUtils
{
  static String a;
  private static String b = "QQUtils";
  private static int c;
  
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setClassName(paramActivity, paramString);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.addFlags(268435456);
      localIntent.addFlags(2097152);
      paramString = new Intent();
      paramString.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
      paramString.putExtra("android.intent.extra.shortcut.NAME", paramActivity.getResources().getString(2131886912));
      paramString.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramActivity.getApplicationContext(), 2130841158));
      paramString.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
      paramActivity.sendOrderedBroadcast(paramString, null);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.d("mqq", 1, "remvoShortcut Exception: ", paramActivity);
    }
  }
  
  static boolean a(Context paramContext)
  {
    if (a == null)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("from", "hasLuncherAuthority");
        QQBeaconReport.a("", "getAuthorityFromPermission", localHashMap);
      }
      catch (Throwable localThrowable)
      {
        QLog.e(b, 1, "hasLuncherAuthority getAuthorityFromPermission report err:", localThrowable);
      }
      a = QQShortCutUtils.a(paramContext);
    }
    if ("empty".equals(a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "cannot find authority");
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 158	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: getstatic 106	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   12: astore 7
    //   14: aload_0
    //   15: invokevirtual 164	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 8
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 5
    //   26: aload 5
    //   28: astore_3
    //   29: aload 6
    //   31: astore_0
    //   32: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +184 -> 219
    //   38: ldc 119
    //   40: astore_0
    //   41: aload_0
    //   42: astore 4
    //   44: aload_1
    //   45: ifnull +75 -> 120
    //   48: aload_0
    //   49: astore 4
    //   51: aload 5
    //   53: astore_3
    //   54: aload 6
    //   56: astore_0
    //   57: aload_1
    //   58: arraylength
    //   59: iconst_1
    //   60: if_icmplt +60 -> 120
    //   63: aload 5
    //   65: astore_3
    //   66: aload 6
    //   68: astore_0
    //   69: new 166	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   76: astore 4
    //   78: aload 5
    //   80: astore_3
    //   81: aload 6
    //   83: astore_0
    //   84: aload 4
    //   86: ldc 119
    //   88: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 5
    //   94: astore_3
    //   95: aload 6
    //   97: astore_0
    //   98: aload 4
    //   100: aload_1
    //   101: iconst_0
    //   102: aaload
    //   103: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 5
    //   109: astore_3
    //   110: aload 6
    //   112: astore_0
    //   113: aload 4
    //   115: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 4
    //   120: aload 5
    //   122: astore_3
    //   123: aload 6
    //   125: astore_0
    //   126: getstatic 20	com/tencent/mobileqq/utils/ShortcutUtils:b	Ljava/lang/String;
    //   129: astore 9
    //   131: aload 5
    //   133: astore_3
    //   134: aload 6
    //   136: astore_0
    //   137: new 166	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   144: astore 10
    //   146: aload 5
    //   148: astore_3
    //   149: aload 6
    //   151: astore_0
    //   152: aload 10
    //   154: ldc 176
    //   156: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 5
    //   162: astore_3
    //   163: aload 6
    //   165: astore_0
    //   166: aload 10
    //   168: aload 7
    //   170: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 5
    //   176: astore_3
    //   177: aload 6
    //   179: astore_0
    //   180: aload 10
    //   182: ldc 178
    //   184: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 5
    //   190: astore_3
    //   191: aload 6
    //   193: astore_0
    //   194: aload 10
    //   196: aload 4
    //   198: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 5
    //   204: astore_3
    //   205: aload 6
    //   207: astore_0
    //   208: aload 9
    //   210: iconst_2
    //   211: aload 10
    //   213: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload 5
    //   221: astore_3
    //   222: aload 6
    //   224: astore_0
    //   225: aload 8
    //   227: aload 7
    //   229: invokestatic 184	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   232: aconst_null
    //   233: ldc 186
    //   235: aload_1
    //   236: aconst_null
    //   237: invokevirtual 192	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +26 -> 268
    //   245: aload_1
    //   246: astore_3
    //   247: aload_1
    //   248: astore_0
    //   249: aload_1
    //   250: invokeinterface 197 1 0
    //   255: istore_2
    //   256: aload_1
    //   257: ifnull +9 -> 266
    //   260: aload_1
    //   261: invokeinterface 200 1 0
    //   266: iload_2
    //   267: ireturn
    //   268: aload_1
    //   269: ifnull +84 -> 353
    //   272: aload_1
    //   273: astore_0
    //   274: goto +73 -> 347
    //   277: astore_0
    //   278: goto +77 -> 355
    //   281: astore_1
    //   282: aload_0
    //   283: astore_3
    //   284: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +56 -> 343
    //   290: aload_0
    //   291: astore_3
    //   292: getstatic 20	com/tencent/mobileqq/utils/ShortcutUtils:b	Ljava/lang/String;
    //   295: astore 4
    //   297: aload_0
    //   298: astore_3
    //   299: new 166	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   306: astore 5
    //   308: aload_0
    //   309: astore_3
    //   310: aload 5
    //   312: ldc 202
    //   314: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_0
    //   319: astore_3
    //   320: aload 5
    //   322: aload_1
    //   323: invokevirtual 203	java/lang/Exception:toString	()Ljava/lang/String;
    //   326: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_0
    //   331: astore_3
    //   332: aload 4
    //   334: iconst_2
    //   335: aload 5
    //   337: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_0
    //   344: ifnull +9 -> 353
    //   347: aload_0
    //   348: invokeinterface 200 1 0
    //   353: iconst_0
    //   354: ireturn
    //   355: aload_3
    //   356: ifnull +9 -> 365
    //   359: aload_3
    //   360: invokeinterface 200 1 0
    //   365: aload_0
    //   366: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramContext	Context
    //   0	367	1	paramArrayOfString	String[]
    //   255	12	2	bool	boolean
    //   28	332	3	localObject1	Object
    //   42	291	4	localObject2	Object
    //   24	312	5	localStringBuilder1	java.lang.StringBuilder
    //   21	202	6	localObject3	Object
    //   12	216	7	str1	String
    //   18	208	8	localContentResolver	android.content.ContentResolver
    //   129	80	9	str2	String
    //   144	68	10	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   32	38	277	finally
    //   57	63	277	finally
    //   69	78	277	finally
    //   84	92	277	finally
    //   98	107	277	finally
    //   113	120	277	finally
    //   126	131	277	finally
    //   137	146	277	finally
    //   152	160	277	finally
    //   166	174	277	finally
    //   180	188	277	finally
    //   194	202	277	finally
    //   208	219	277	finally
    //   225	241	277	finally
    //   249	256	277	finally
    //   284	290	277	finally
    //   292	297	277	finally
    //   299	308	277	finally
    //   310	318	277	finally
    //   320	330	277	finally
    //   332	343	277	finally
    //   32	38	281	java/lang/Exception
    //   57	63	281	java/lang/Exception
    //   69	78	281	java/lang/Exception
    //   84	92	281	java/lang/Exception
    //   98	107	281	java/lang/Exception
    //   113	120	281	java/lang/Exception
    //   126	131	281	java/lang/Exception
    //   137	146	281	java/lang/Exception
    //   152	160	281	java/lang/Exception
    //   166	174	281	java/lang/Exception
    //   180	188	281	java/lang/Exception
    //   194	202	281	java/lang/Exception
    //   208	219	281	java/lang/Exception
    //   225	241	281	java/lang/Exception
    //   249	256	281	java/lang/Exception
  }
  
  /* Error */
  public static String b(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 158	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: iload_2
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: getstatic 106	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   16: astore 5
    //   18: aload_0
    //   19: invokevirtual 164	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: astore 6
    //   24: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +107 -> 134
    //   30: ldc 119
    //   32: astore 4
    //   34: aload 4
    //   36: astore_0
    //   37: aload_1
    //   38: ifnull +40 -> 78
    //   41: aload 4
    //   43: astore_0
    //   44: aload_1
    //   45: arraylength
    //   46: iconst_1
    //   47: if_icmplt +31 -> 78
    //   50: new 166	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   57: astore_0
    //   58: aload_0
    //   59: ldc 119
    //   61: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_0
    //   66: aload_1
    //   67: iconst_0
    //   68: aaload
    //   69: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_0
    //   74: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_0
    //   78: getstatic 20	com/tencent/mobileqq/utils/ShortcutUtils:b	Ljava/lang/String;
    //   81: astore 4
    //   83: new 166	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   90: astore 7
    //   92: aload 7
    //   94: ldc 176
    //   96: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 7
    //   102: aload 5
    //   104: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 7
    //   110: ldc 178
    //   112: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 7
    //   118: aload_0
    //   119: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: iconst_2
    //   126: aload 7
    //   128: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload 6
    //   136: aload 5
    //   138: invokestatic 184	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   141: aconst_null
    //   142: ldc 186
    //   144: aload_1
    //   145: aconst_null
    //   146: invokevirtual 192	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   149: astore_0
    //   150: aload_0
    //   151: ifnull +45 -> 196
    //   154: aload_0
    //   155: invokeinterface 197 1 0
    //   160: pop
    //   161: aload_0
    //   162: aload_0
    //   163: ldc 209
    //   165: invokeinterface 213 2 0
    //   170: invokeinterface 214 2 0
    //   175: astore_1
    //   176: aload_0
    //   177: ifnull +9 -> 186
    //   180: aload_0
    //   181: invokeinterface 200 1 0
    //   186: aload_1
    //   187: areturn
    //   188: astore_1
    //   189: goto +88 -> 277
    //   192: astore_1
    //   193: goto +24 -> 217
    //   196: aload_0
    //   197: ifnull +77 -> 274
    //   200: aload_0
    //   201: invokeinterface 200 1 0
    //   206: aconst_null
    //   207: areturn
    //   208: astore_1
    //   209: aload_3
    //   210: astore_0
    //   211: goto +66 -> 277
    //   214: astore_1
    //   215: aconst_null
    //   216: astore_0
    //   217: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +44 -> 264
    //   223: getstatic 20	com/tencent/mobileqq/utils/ShortcutUtils:b	Ljava/lang/String;
    //   226: astore_3
    //   227: new 166	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   234: astore 4
    //   236: aload 4
    //   238: ldc 202
    //   240: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 4
    //   246: aload_1
    //   247: invokevirtual 203	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_3
    //   255: iconst_2
    //   256: aload 4
    //   258: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: ifnull +9 -> 274
    //   268: aload_0
    //   269: invokeinterface 200 1 0
    //   274: aconst_null
    //   275: areturn
    //   276: astore_1
    //   277: aload_0
    //   278: ifnull +9 -> 287
    //   281: aload_0
    //   282: invokeinterface 200 1 0
    //   287: aload_1
    //   288: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramContext	Context
    //   0	289	1	paramArrayOfString	String[]
    //   4	4	2	bool	boolean
    //   6	249	3	str1	String
    //   32	225	4	localObject	Object
    //   16	121	5	str2	String
    //   22	113	6	localContentResolver	android.content.ContentResolver
    //   90	37	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   154	176	188	finally
    //   154	176	192	java/lang/Exception
    //   24	30	208	finally
    //   44	78	208	finally
    //   78	134	208	finally
    //   134	150	208	finally
    //   24	30	214	java/lang/Exception
    //   44	78	214	java/lang/Exception
    //   78	134	214	java/lang/Exception
    //   134	150	214	java/lang/Exception
    //   217	264	276	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShortcutUtils
 * JD-Core Version:    0.7.0.1
 */