package com.tencent.mobileqq.utils.kapalaiadapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.support.v4.content.FileProvider.PathStrategy;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileProvider7Helper
{
  public static String sAuthority = null;
  public static Boolean sIsTargetThanN = null;
  
  public static String getPathFromUri(Context paramContext, String paramString, List<String> paramList)
  {
    String str = paramString;
    if (isTargetBeyondN(paramContext))
    {
      str = paramString;
      if (paramList != null)
      {
        str = paramString;
        if (paramList.size() > 0) {
          str = paramString.replace(File.separator + (String)paramList.get(0), "");
        }
      }
    }
    return str;
  }
  
  public static FileProvider.PathStrategy getPathStrategy(Context paramContext)
  {
    if (sAuthority == null) {
      sAuthority = paramContext.getApplicationContext().getPackageName() + ".fileprovider";
    }
    return FileProvider.getPathStrategy(paramContext, sAuthority);
  }
  
  /* Error */
  public static String getRealPathFromContentURI(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +244 -> 245
    //   4: ldc 54
    //   6: aload_1
    //   7: invokevirtual 85	android/net/Uri:toString	()Ljava/lang/String;
    //   10: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +232 -> 245
    //   16: aload_1
    //   17: invokevirtual 92	android/net/Uri:getScheme	()Ljava/lang/String;
    //   20: astore_3
    //   21: ldc 94
    //   23: aload_3
    //   24: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +10 -> 37
    //   30: aload_1
    //   31: invokevirtual 97	android/net/Uri:getPath	()Ljava/lang/String;
    //   34: astore_1
    //   35: aload_1
    //   36: areturn
    //   37: ldc 99
    //   39: aload_3
    //   40: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +188 -> 231
    //   46: aload_0
    //   47: invokevirtual 103	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   50: aload_1
    //   51: iconst_1
    //   52: anewarray 48	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc 105
    //   59: aastore
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 111	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore_3
    //   67: aload_3
    //   68: astore 4
    //   70: aload_3
    //   71: ldc 105
    //   73: invokeinterface 117 2 0
    //   78: istore_2
    //   79: aload_3
    //   80: astore 4
    //   82: aload_3
    //   83: invokeinterface 120 1 0
    //   88: ifle +42 -> 130
    //   91: aload_3
    //   92: astore 4
    //   94: aload_3
    //   95: invokeinterface 124 1 0
    //   100: pop
    //   101: aload_3
    //   102: astore 4
    //   104: aload_3
    //   105: iload_2
    //   106: invokeinterface 128 2 0
    //   111: astore 5
    //   113: aload 5
    //   115: astore_0
    //   116: aload_0
    //   117: astore_1
    //   118: aload_3
    //   119: ifnull -84 -> 35
    //   122: aload_3
    //   123: invokeinterface 131 1 0
    //   128: aload_0
    //   129: areturn
    //   130: ldc 54
    //   132: astore_0
    //   133: goto -17 -> 116
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: astore 4
    //   142: aload_0
    //   143: invokestatic 24	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:isTargetBeyondN	(Landroid/content/Context;)Z
    //   146: ifeq +34 -> 180
    //   149: aload_3
    //   150: astore 4
    //   152: aload_0
    //   153: invokestatic 133	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:getPathStrategy	(Landroid/content/Context;)Landroid/support/v4/content/FileProvider$PathStrategy;
    //   156: aload_1
    //   157: invokeinterface 139 2 0
    //   162: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   165: astore_0
    //   166: aload_0
    //   167: astore_1
    //   168: aload_3
    //   169: ifnull -134 -> 35
    //   172: aload_3
    //   173: invokeinterface 131 1 0
    //   178: aload_0
    //   179: areturn
    //   180: aload_3
    //   181: astore 4
    //   183: aload_0
    //   184: aload_1
    //   185: invokevirtual 97	android/net/Uri:getPath	()Ljava/lang/String;
    //   188: aload_1
    //   189: invokevirtual 146	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   192: invokestatic 148	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:getPathFromUri	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    //   195: astore_0
    //   196: goto -30 -> 166
    //   199: astore_0
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   207: ldc 54
    //   209: astore_0
    //   210: goto -44 -> 166
    //   213: astore_0
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 4
    //   219: ifnull +10 -> 229
    //   222: aload 4
    //   224: invokeinterface 131 1 0
    //   229: aload_0
    //   230: athrow
    //   231: aload_1
    //   232: invokevirtual 85	android/net/Uri:toString	()Ljava/lang/String;
    //   235: areturn
    //   236: astore_0
    //   237: goto -20 -> 217
    //   240: astore 4
    //   242: goto -103 -> 139
    //   245: ldc 54
    //   247: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramContext	Context
    //   0	248	1	paramUri	Uri
    //   78	28	2	i	int
    //   20	103	3	localObject1	Object
    //   136	1	3	localException1	java.lang.Exception
    //   138	63	3	localObject2	Object
    //   68	155	4	localObject3	Object
    //   240	1	4	localException2	java.lang.Exception
    //   111	3	5	str	String
    // Exception table:
    //   from	to	target	type
    //   46	67	136	java/lang/Exception
    //   142	149	199	java/lang/Exception
    //   152	166	199	java/lang/Exception
    //   183	196	199	java/lang/Exception
    //   46	67	213	finally
    //   70	79	236	finally
    //   82	91	236	finally
    //   94	101	236	finally
    //   104	113	236	finally
    //   142	149	236	finally
    //   152	166	236	finally
    //   183	196	236	finally
    //   203	207	236	finally
    //   70	79	240	java/lang/Exception
    //   82	91	240	java/lang/Exception
    //   94	101	240	java/lang/Exception
    //   104	113	240	java/lang/Exception
  }
  
  public static Uri getUriForFile(Context paramContext, File paramFile)
  {
    if (isTargetBeyondN(paramContext)) {
      return getUriForFile24(paramContext, paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  private static Uri getUriForFile24(Context paramContext, File paramFile)
  {
    if (sAuthority == null) {
      sAuthority = paramContext.getApplicationContext().getPackageName() + ".fileprovider";
    }
    return FileProvider.getUriForFile(paramContext, sAuthority, paramFile);
  }
  
  public static void grantPermissions(Context paramContext, Intent paramIntent, Uri paramUri, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 3;; i = 1)
    {
      paramIntent.addFlags(i);
      paramIntent = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).iterator();
      while (paramIntent.hasNext()) {
        paramContext.grantUriPermission(((ResolveInfo)paramIntent.next()).activityInfo.packageName, paramUri, i);
      }
      return;
    }
  }
  
  public static void installApkFile(Context paramContext, String paramString)
  {
    paramContext.startActivity(openApkIntent(paramContext, paramString));
  }
  
  public static void intentCompatForN(Context paramContext, Intent paramIntent)
  {
    if (isTargetBeyondN(paramContext))
    {
      paramIntent.getAction();
      Object localObject1 = paramIntent.getData();
      if ((localObject1 != null) && ("file".equals(((Uri)localObject1).getScheme())))
      {
        paramIntent.setDataAndType(getUriForFile24(paramContext, new File(getRealPathFromContentURI(paramContext, (Uri)localObject1))), paramIntent.getType());
        paramIntent.addFlags(1);
        paramIntent.addFlags(2);
      }
      localObject1 = new String[2];
      localObject1[0] = "output";
      localObject1[1] = "android.intent.extra.STREAM";
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject1[i];
        Object localObject2 = paramIntent.getParcelableExtra(str);
        Object localObject3;
        if ((localObject2 instanceof Uri))
        {
          localObject3 = (Uri)localObject2;
          if ("file".equals(((Uri)localObject3).getScheme()))
          {
            paramIntent.putExtra(str, getUriForFile24(paramContext, new File(getRealPathFromContentURI(paramContext, (Uri)localObject3))));
            paramIntent.addFlags(1);
            paramIntent.addFlags(2);
          }
        }
        if (localObject2 == null)
        {
          localObject3 = paramIntent.getParcelableArrayListExtra(str);
          if (localObject3 != null)
          {
            localObject2 = new ArrayList(((ArrayList)localObject3).size());
            paramIntent.addFlags(1);
            paramIntent.addFlags(2);
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = (Parcelable)((Iterator)localObject3).next();
              if ((localObject4 instanceof Uri))
              {
                Uri localUri = (Uri)localObject4;
                if ("file".equals(localUri.getScheme()))
                {
                  localObject4 = getUriForFile24(paramContext, new File(getRealPathFromContentURI(paramContext, localUri)));
                  paramIntent.putExtra(str, (Parcelable)localObject4);
                  ((ArrayList)localObject2).add(localObject4);
                }
                else
                {
                  ((ArrayList)localObject2).add(localObject4);
                }
              }
              else
              {
                ((ArrayList)localObject2).add(localObject4);
              }
            }
            paramIntent.putExtra(str, (Serializable)localObject2);
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean isTargetBeyondN(Context paramContext)
  {
    if (sIsTargetThanN == null) {
      if ((Build.VERSION.SDK_INT < 24) || (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion < 24)) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      sIsTargetThanN = Boolean.valueOf(bool);
      return sIsTargetThanN.booleanValue();
    }
  }
  
  public static Intent openApkIntent(Context paramContext, String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    setIntentDataAndType(paramContext, localIntent, "application/vnd.android.package-archive", new File(paramString));
    return localIntent;
  }
  
  public static Uri savePhotoToSysAlbum(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    paramFile = Uri.fromFile(paramFile);
    localIntent.setData(paramFile);
    paramContext.sendBroadcast(localIntent);
    return paramFile;
  }
  
  public static Uri savePhotoToSysAlbum(Context paramContext, String paramString)
  {
    return savePhotoToSysAlbum(paramContext, new File(paramString));
  }
  
  public static void setIntentDataAndType(Context paramContext, Intent paramIntent, String paramString, File paramFile)
  {
    if (isTargetBeyondN(paramContext))
    {
      paramIntent.setDataAndType(getUriForFile24(paramContext, paramFile), paramString);
      paramIntent.addFlags(1);
      paramIntent.addFlags(2);
      return;
    }
    paramIntent.setDataAndType(Uri.fromFile(paramFile), paramString);
  }
  
  public static Uri setSystemCapture(Context paramContext, File paramFile, Intent paramIntent)
  {
    paramIntent.setAction("android.media.action.IMAGE_CAPTURE");
    if (isTargetBeyondN(paramContext))
    {
      paramContext = getUriForFile24(paramContext, paramFile);
      paramIntent.addFlags(3);
    }
    for (;;)
    {
      paramIntent.putExtra("output", paramContext);
      paramIntent.putExtra("android.intent.extra.videoQuality", 100);
      return paramContext;
      paramContext = Uri.fromFile(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper
 * JD-Core Version:    0.7.0.1
 */