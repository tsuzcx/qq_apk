package com.tencent.ttpic.baseutils.url;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;

public class UriUtils
{
  private static final String FILE_ROOT = "/file_root";
  private static final String SCHEME_CONTENT = "content://";
  private static final String SCHEME_FILE = "file://";
  private static final String SCHEME_RES = "res://";
  private static final String TAG = UriUtils.class.getSimpleName();
  
  public static Uri buildUriForShare(Context paramContext, String paramString)
  {
    if (ApiHelper.hasNougat()) {
      return FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".fileProvider", new File(paramString));
    }
    return Uri.parse("file://" + paramString);
  }
  
  /* Error */
  public static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: iconst_1
    //   6: anewarray 84	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: ldc 86
    //   13: aastore
    //   14: aload_2
    //   15: aload_3
    //   16: aconst_null
    //   17: invokevirtual 92	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +43 -> 65
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: invokeinterface 97 1 0
    //   33: ifeq +32 -> 65
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: aload_1
    //   40: ldc 86
    //   42: invokeinterface 101 2 0
    //   47: invokeinterface 105 2 0
    //   52: astore_2
    //   53: aload_1
    //   54: ifnull +9 -> 63
    //   57: aload_1
    //   58: invokeinterface 108 1 0
    //   63: aload_2
    //   64: areturn
    //   65: aload_1
    //   66: ifnull +9 -> 75
    //   69: aload_1
    //   70: invokeinterface 108 1 0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   86: aload_1
    //   87: ifnull -12 -> 75
    //   90: aload_1
    //   91: invokeinterface 108 1 0
    //   96: goto -21 -> 75
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 108 1 0
    //   112: aload_1
    //   113: athrow
    //   114: astore_1
    //   115: goto -13 -> 102
    //   118: astore_2
    //   119: goto -39 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramUri	Uri
    //   0	122	2	paramString	String
    //   0	122	3	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	21	77	java/lang/Exception
    //   0	21	99	finally
    //   27	36	114	finally
    //   38	53	114	finally
    //   82	86	114	finally
    //   27	36	118	java/lang/Exception
    //   38	53	118	java/lang/Exception
  }
  
  public static String getFileProviderUriToPath(Context paramContext, Uri paramUri)
  {
    String str1 = "";
    paramContext = str1;
    String str2;
    if (paramUri != null)
    {
      str2 = paramUri.getScheme();
      if (!TextUtils.isEmpty(str2)) {
        break label55;
      }
      paramContext = paramUri.getPath();
    }
    for (;;)
    {
      LogUtils.d(TAG, "[getFileProviderUriToPath] path = " + paramContext);
      return paramContext;
      label55:
      if ("content://".contains(str2))
      {
        int i = "/file_root".length();
        paramContext = paramUri.getPath().substring(i);
      }
      else
      {
        paramContext = str1;
        if ("file://".contains(str2)) {
          paramContext = paramUri.getPath();
        }
      }
    }
  }
  
  /* Error */
  public static String getMediaImagePathFromURI(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: iconst_1
    //   6: anewarray 84	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: ldc 86
    //   13: aastore
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 92	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +91 -> 113
    //   25: aload_0
    //   26: astore_1
    //   27: aload_0
    //   28: invokeinterface 97 1 0
    //   33: ifeq +80 -> 113
    //   36: aload_0
    //   37: astore_1
    //   38: aload_0
    //   39: aload_0
    //   40: ldc 86
    //   42: invokeinterface 101 2 0
    //   47: invokeinterface 105 2 0
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: ifnull +9 -> 65
    //   59: aload_0
    //   60: invokeinterface 108 1 0
    //   65: aload_1
    //   66: areturn
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_0
    //   71: astore_1
    //   72: aload_2
    //   73: invokestatic 150	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: ifnull +34 -> 111
    //   80: aload_0
    //   81: invokeinterface 108 1 0
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +9 -> 101
    //   95: aload_1
    //   96: invokeinterface 108 1 0
    //   101: aload_0
    //   102: athrow
    //   103: astore_0
    //   104: goto -13 -> 91
    //   107: astore_2
    //   108: goto -38 -> 70
    //   111: aconst_null
    //   112: areturn
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -60 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramContext	Context
    //   0	118	1	paramUri	Uri
    //   52	2	2	str	String
    //   67	6	2	localException1	java.lang.Exception
    //   107	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	67	java/lang/Exception
    //   0	21	88	finally
    //   27	36	103	finally
    //   38	53	103	finally
    //   72	76	103	finally
    //   27	36	107	java/lang/Exception
    //   38	53	107	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public static String getMediaPathByUri(Context paramContext, Uri paramUri)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = 1;
      if ((i == 0) || (!DocumentsContract.isDocumentUri(paramContext, paramUri))) {
        break label215;
      }
      if (!isExternalStorageDocument(paramUri)) {
        break label90;
      }
      paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
      if ("primary".equalsIgnoreCase(paramContext[0])) {
        localObject1 = Environment.getExternalStorageDirectory() + "/" + paramContext[1];
      }
    }
    label90:
    do
    {
      do
      {
        return localObject1;
        i = 0;
        break;
        if (isDownloadsDocument(paramUri))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          return getDataColumn(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
        }
      } while (!isMediaDocument(paramUri));
      localObject1 = DocumentsContract.getDocumentId(paramUri).split(":");
      Object localObject3 = localObject1[0];
      if ("image".equals(localObject3)) {
        paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      }
      for (;;)
      {
        return getDataColumn(paramContext, paramUri, "_id=?", new String[] { localObject1[1] });
        if ("video".equals(localObject3))
        {
          paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        else
        {
          paramUri = localObject2;
          if ("audio".equals(localObject3)) {
            paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
      if ("content".equalsIgnoreCase(paramUri.getScheme())) {
        return getDataColumn(paramContext, paramUri, null, null);
      }
    } while (!"file".equalsIgnoreCase(paramUri.getScheme()));
    label215:
    return paramUri.getPath();
  }
  
  public static boolean isDownloadsDocument(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isExternalStorageDocument(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isMediaDocument(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.url.UriUtils
 * JD-Core Version:    0.7.0.1
 */