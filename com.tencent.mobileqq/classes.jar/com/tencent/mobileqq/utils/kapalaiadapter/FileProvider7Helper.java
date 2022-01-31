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
  
  /* Error */
  public static String getRealPathFromContentURI(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 54
    //   2: astore 4
    //   4: aload 4
    //   6: astore_3
    //   7: aload_1
    //   8: ifnull +37 -> 45
    //   11: aload 4
    //   13: astore_3
    //   14: ldc 54
    //   16: aload_1
    //   17: invokevirtual 67	android/net/Uri:toString	()Ljava/lang/String;
    //   20: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne +22 -> 45
    //   26: aload_1
    //   27: invokevirtual 74	android/net/Uri:getScheme	()Ljava/lang/String;
    //   30: astore_3
    //   31: ldc 76
    //   33: aload_3
    //   34: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +10 -> 47
    //   40: aload_1
    //   41: invokevirtual 79	android/net/Uri:getPath	()Ljava/lang/String;
    //   44: astore_3
    //   45: aload_3
    //   46: areturn
    //   47: ldc 81
    //   49: aload_3
    //   50: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +151 -> 204
    //   56: aload_0
    //   57: invokevirtual 87	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: aload_1
    //   61: iconst_1
    //   62: anewarray 48	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: ldc 89
    //   69: aastore
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 95	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore 4
    //   78: aload 4
    //   80: astore_3
    //   81: aload 4
    //   83: ldc 89
    //   85: invokeinterface 101 2 0
    //   90: istore_2
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: invokeinterface 104 1 0
    //   101: ifle +46 -> 147
    //   104: aload 4
    //   106: astore_3
    //   107: aload 4
    //   109: invokeinterface 108 1 0
    //   114: pop
    //   115: aload 4
    //   117: astore_3
    //   118: aload 4
    //   120: iload_2
    //   121: invokeinterface 112 2 0
    //   126: astore 5
    //   128: aload 5
    //   130: astore_0
    //   131: aload_0
    //   132: astore_3
    //   133: aload 4
    //   135: ifnull -90 -> 45
    //   138: aload 4
    //   140: invokeinterface 115 1 0
    //   145: aload_0
    //   146: areturn
    //   147: ldc 54
    //   149: astore_0
    //   150: goto -19 -> 131
    //   153: astore_3
    //   154: aconst_null
    //   155: astore 4
    //   157: aload 4
    //   159: astore_3
    //   160: aload_0
    //   161: aload_1
    //   162: invokevirtual 79	android/net/Uri:getPath	()Ljava/lang/String;
    //   165: aload_1
    //   166: invokevirtual 119	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   169: invokestatic 121	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:getPathFromUri	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    //   172: astore_0
    //   173: aload_0
    //   174: astore_3
    //   175: aload 4
    //   177: ifnull -132 -> 45
    //   180: aload 4
    //   182: invokeinterface 115 1 0
    //   187: aload_0
    //   188: areturn
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_3
    //   192: aload_3
    //   193: ifnull +9 -> 202
    //   196: aload_3
    //   197: invokeinterface 115 1 0
    //   202: aload_0
    //   203: athrow
    //   204: aload_1
    //   205: invokevirtual 67	android/net/Uri:toString	()Ljava/lang/String;
    //   208: areturn
    //   209: astore_0
    //   210: goto -18 -> 192
    //   213: astore_3
    //   214: goto -57 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramContext	Context
    //   0	217	1	paramUri	Uri
    //   90	31	2	i	int
    //   6	127	3	localObject1	Object
    //   153	1	3	localException1	java.lang.Exception
    //   159	38	3	localObject2	Object
    //   213	1	3	localException2	java.lang.Exception
    //   2	179	4	localObject3	Object
    //   126	3	5	str	String
    // Exception table:
    //   from	to	target	type
    //   56	78	153	java/lang/Exception
    //   56	78	189	finally
    //   81	91	209	finally
    //   94	104	209	finally
    //   107	115	209	finally
    //   118	128	209	finally
    //   160	173	209	finally
    //   81	91	213	java/lang/Exception
    //   94	104	213	java/lang/Exception
    //   107	115	213	java/lang/Exception
    //   118	128	213	java/lang/Exception
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