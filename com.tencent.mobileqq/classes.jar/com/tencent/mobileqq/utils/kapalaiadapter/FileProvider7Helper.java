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
  public static String sAuthority;
  public static Boolean sIsTargetThanN;
  
  public static String getPathFromUri(Context paramContext, String paramString, List<String> paramList)
  {
    if ((isTargetBeyondN(paramContext)) && (paramList != null) && (paramList.size() > 0))
    {
      paramContext = new StringBuilder();
      paramContext.append(File.separator);
      paramContext.append((String)paramList.get(0));
      return paramString.replace(paramContext.toString(), "");
    }
    return paramString;
  }
  
  public static FileProvider.PathStrategy getPathStrategy(Context paramContext)
  {
    if (sAuthority == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationContext().getPackageName());
      localStringBuilder.append(".fileprovider");
      sAuthority = localStringBuilder.toString();
    }
    return FileProvider.getPathStrategy(paramContext, sAuthority);
  }
  
  /* Error */
  public static String getRealPathFromContentURI(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 50
    //   2: astore 6
    //   4: aload 6
    //   6: astore 5
    //   8: aload_1
    //   9: ifnull +261 -> 270
    //   12: aload 6
    //   14: astore 5
    //   16: ldc 50
    //   18: aload_1
    //   19: invokevirtual 83	android/net/Uri:toString	()Ljava/lang/String;
    //   22: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifne +245 -> 270
    //   28: aload_1
    //   29: invokevirtual 90	android/net/Uri:getScheme	()Ljava/lang/String;
    //   32: astore_3
    //   33: ldc 92
    //   35: aload_3
    //   36: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +8 -> 47
    //   42: aload_1
    //   43: invokevirtual 95	android/net/Uri:getPath	()Ljava/lang/String;
    //   46: areturn
    //   47: ldc 97
    //   49: aload_3
    //   50: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +211 -> 264
    //   56: aconst_null
    //   57: astore_3
    //   58: aconst_null
    //   59: astore 5
    //   61: aload_0
    //   62: invokevirtual 101	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   65: aload_1
    //   66: iconst_1
    //   67: anewarray 44	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: ldc 103
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokevirtual 109	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore 7
    //   83: aload 7
    //   85: astore 5
    //   87: aload 7
    //   89: astore_3
    //   90: aload 7
    //   92: ldc 103
    //   94: invokeinterface 115 2 0
    //   99: istore_2
    //   100: aload 6
    //   102: astore 4
    //   104: aload 7
    //   106: astore 5
    //   108: aload 7
    //   110: astore_3
    //   111: aload 7
    //   113: invokeinterface 118 1 0
    //   118: ifle +35 -> 153
    //   121: aload 7
    //   123: astore 5
    //   125: aload 7
    //   127: astore_3
    //   128: aload 7
    //   130: invokeinterface 122 1 0
    //   135: pop
    //   136: aload 7
    //   138: astore 5
    //   140: aload 7
    //   142: astore_3
    //   143: aload 7
    //   145: iload_2
    //   146: invokeinterface 126 2 0
    //   151: astore 4
    //   153: aload 4
    //   155: astore 5
    //   157: aload 7
    //   159: ifnull +111 -> 270
    //   162: aload 7
    //   164: astore_3
    //   165: aload 4
    //   167: astore_0
    //   168: aload_3
    //   169: invokeinterface 129 1 0
    //   174: aload_0
    //   175: areturn
    //   176: astore_0
    //   177: goto +73 -> 250
    //   180: aload_3
    //   181: astore 5
    //   183: aload_0
    //   184: invokestatic 20	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:isTargetBeyondN	(Landroid/content/Context;)Z
    //   187: ifeq +23 -> 210
    //   190: aload_3
    //   191: astore 5
    //   193: aload_0
    //   194: invokestatic 131	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:getPathStrategy	(Landroid/content/Context;)Landroid/support/v4/content/FileProvider$PathStrategy;
    //   197: aload_1
    //   198: invokeinterface 137 2 0
    //   203: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   206: astore_0
    //   207: goto +19 -> 226
    //   210: aload_3
    //   211: astore 5
    //   213: aload_0
    //   214: aload_1
    //   215: invokevirtual 95	android/net/Uri:getPath	()Ljava/lang/String;
    //   218: aload_1
    //   219: invokevirtual 144	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   222: invokestatic 146	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:getPathFromUri	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    //   225: astore_0
    //   226: goto +14 -> 240
    //   229: astore_0
    //   230: aload_3
    //   231: astore 5
    //   233: aload_0
    //   234: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   237: aload 6
    //   239: astore_0
    //   240: aload_0
    //   241: astore 5
    //   243: aload_3
    //   244: ifnull +26 -> 270
    //   247: goto -79 -> 168
    //   250: aload 5
    //   252: ifnull +10 -> 262
    //   255: aload 5
    //   257: invokeinterface 129 1 0
    //   262: aload_0
    //   263: athrow
    //   264: aload_1
    //   265: invokevirtual 83	android/net/Uri:toString	()Ljava/lang/String;
    //   268: astore 5
    //   270: aload 5
    //   272: areturn
    //   273: astore 4
    //   275: goto -95 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   0	278	1	paramUri	Uri
    //   99	47	2	i	int
    //   32	212	3	localObject1	Object
    //   102	64	4	str1	String
    //   273	1	4	localException	java.lang.Exception
    //   6	265	5	localObject2	Object
    //   2	236	6	str2	String
    //   81	82	7	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   61	83	176	finally
    //   90	100	176	finally
    //   111	121	176	finally
    //   128	136	176	finally
    //   143	153	176	finally
    //   183	190	176	finally
    //   193	207	176	finally
    //   213	226	176	finally
    //   233	237	176	finally
    //   183	190	229	java/lang/Exception
    //   193	207	229	java/lang/Exception
    //   213	226	229	java/lang/Exception
    //   61	83	273	java/lang/Exception
    //   90	100	273	java/lang/Exception
    //   111	121	273	java/lang/Exception
    //   128	136	273	java/lang/Exception
    //   143	153	273	java/lang/Exception
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
    if (sAuthority == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationContext().getPackageName());
      localStringBuilder.append(".fileprovider");
      sAuthority = localStringBuilder.toString();
    }
    return FileProvider.getUriForFile(paramContext, sAuthority, paramFile);
  }
  
  public static void grantPermissions(Context paramContext, Intent paramIntent, Uri paramUri, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 1;
    }
    paramIntent.addFlags(i);
    paramIntent = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).iterator();
    while (paramIntent.hasNext()) {
      paramContext.grantUriPermission(((ResolveInfo)paramIntent.next()).activityInfo.packageName, paramUri, i);
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
      int i = 0;
      localObject1[0] = "output";
      localObject1[1] = "android.intent.extra.STREAM";
      int j = localObject1.length;
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
    if (sIsTargetThanN == null)
    {
      boolean bool;
      if ((Build.VERSION.SDK_INT >= 24) && (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion >= 24)) {
        bool = true;
      } else {
        bool = false;
      }
      sIsTargetThanN = Boolean.valueOf(bool);
    }
    return sIsTargetThanN.booleanValue();
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
    else
    {
      paramContext = Uri.fromFile(paramFile);
    }
    paramIntent.putExtra("output", paramContext);
    paramIntent.putExtra("android.intent.extra.videoQuality", 100);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper
 * JD-Core Version:    0.7.0.1
 */