package com.tencent.mobileqq.utils;

import akbe;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.XMPCoreUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AlbumUtil
{
  public static long a;
  public static String a;
  public static HashMap a;
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public static final int[] a;
  static String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static long jdField_b_of_type_Long;
  public static String b;
  public static HashMap b;
  private static String[] jdField_b_of_type_ArrayOfJavaLangString = { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" };
  private static long c;
  public static String c;
  public static HashMap c;
  public static final HashMap d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    d = new HashMap();
    d.put("image", Integer.valueOf(0));
    d.put("video", Integer.valueOf(1));
    d.put("mobileqq", Integer.valueOf(2));
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3000, 1 };
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size", "width", "height" }; Build.VERSION.SDK_INT >= 16; jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size" })
    {
      jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size", "width", "height" };
      return;
    }
  }
  
  public static float a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "photoGroupListImageCropSpaceRatio", 0.25F);
  }
  
  public static int a()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "MaxSelectVideoNum", 50);
  }
  
  public static int a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = 0;
    if (paramLocalMediaInfo == null) {
      i = -1;
    }
    do
    {
      return i;
      paramLocalMediaInfo = MimeHelper.a(paramLocalMediaInfo.mMimeType);
    } while (paramLocalMediaInfo == null);
    return ((Integer)d.get(paramLocalMediaInfo[0])).intValue();
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, jdField_a_of_type_ArrayOfJavaLangString, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static String a(List paramList)
  {
    Object localObject1 = new StringBuilder("_data");
    ((StringBuilder)localObject1).append(" IS NOT NULL AND ");
    ((StringBuilder)localObject1).append("_size");
    ((StringBuilder)localObject1).append(" > 0 ");
    Object localObject2 = localObject1;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (paramList.size() > 0)
      {
        ((StringBuilder)localObject1).append(" AND (");
        localObject2 = paramList.iterator();
        paramList = (List)localObject1;
        int i = 1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          if (i == 0) {
            paramList.append(" OR ");
          }
          for (;;)
          {
            paramList.append(" ( ");
            paramList = a("bucket_id", paramList, (String)localObject1);
            paramList.append(" ) ");
            break;
            i = 0;
          }
        }
        paramList.append(" ) ");
        localObject2 = paramList;
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  private static StringBuilder a(String paramString1, StringBuilder paramStringBuilder, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" = ");
    paramStringBuilder.append(paramString2);
    return paramStringBuilder;
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo)
  {
    return a(paramLocalMediaInfo, null);
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumb");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.path);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public static URL a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("videocover");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  private static ArrayList a(Context paramContext, Cursor paramCursor, List paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    paramContext = new ArrayList();
    paramCursor = (ArrayList)a(paramCursor, paramList, paramInt, paramMediaFileFilter, paramBoolean, paramLong);
    if (paramCursor != null) {
      paramContext.addAll(paramCursor);
    }
    if (QLog.isColorLevel()) {
      QLog.e("AlbumUtil", 2, "getSystemAndAppVideoList listsize=" + paramContext.size());
    }
    paramCursor = MediaScanner.a(BaseApplicationImpl.getContext());
    if (paramCursor != null)
    {
      paramCursor = paramCursor.a(false, -1);
      if (paramCursor != null)
      {
        paramCursor = paramCursor.iterator();
        while (paramCursor.hasNext())
        {
          paramList = (MediaScannerInfo)paramCursor.next();
          paramMediaFileFilter = new LocalMediaInfo();
          paramMediaFileFilter._id = paramList.jdField_a_of_type_Int;
          paramMediaFileFilter.mDuration = paramList.jdField_c_of_type_Long;
          paramMediaFileFilter.fileSize = paramList.jdField_a_of_type_Long;
          paramMediaFileFilter.path = paramList.jdField_c_of_type_JavaLangString;
          paramMediaFileFilter.modifiedDate = paramList.jdField_b_of_type_Long;
          paramMediaFileFilter.mMimeType = paramList.d;
          paramMediaFileFilter.isSystemMeidaStore = false;
          paramContext.add(paramMediaFileFilter);
        }
      }
    }
    Collections.sort(paramContext);
    return paramContext;
  }
  
  public static List a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, false, 0, null, false);
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 368	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +31 -> 39
    //   11: ldc_w 289
    //   14: iconst_2
    //   15: new 193	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 370
    //   25: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: lload 6
    //   30: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: astore 9
    //   42: iload_2
    //   43: ifgt +14 -> 57
    //   46: new 377	java/lang/IllegalArgumentException
    //   49: dup
    //   50: ldc_w 379
    //   53: invokespecial 380	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: new 279	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 280	java/util/ArrayList:<init>	()V
    //   64: astore 11
    //   66: getstatic 383	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   69: invokevirtual 146	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   72: astore 10
    //   74: aload 10
    //   76: ldc 148
    //   78: iload_2
    //   79: bipush 6
    //   81: imul
    //   82: invokestatic 151	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 157	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   88: pop
    //   89: aload 10
    //   91: invokevirtual 161	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   94: astore 10
    //   96: aload_0
    //   97: invokevirtual 167	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: aload 10
    //   102: getstatic 89	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   105: ldc_w 385
    //   108: aconst_null
    //   109: ldc 169
    //   111: invokevirtual 175	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore_0
    //   115: aload_0
    //   116: astore 9
    //   118: aload 9
    //   120: astore_0
    //   121: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   124: bipush 16
    //   126: if_icmplt +188 -> 314
    //   129: iconst_1
    //   130: istore 8
    //   132: aload 9
    //   134: astore_0
    //   135: aload 9
    //   137: aload 11
    //   139: iload_2
    //   140: aload_3
    //   141: iload 8
    //   143: lload 4
    //   145: invokestatic 283	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   148: pop
    //   149: aload 9
    //   151: ifnull +10 -> 161
    //   154: aload 9
    //   156: invokeinterface 390 1 0
    //   161: invokestatic 306	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   164: invokestatic 311	com/tencent/mobileqq/activity/photo/MediaScanner:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +213 -> 382
    //   172: aload_0
    //   173: iconst_1
    //   174: bipush 100
    //   176: invokevirtual 314	com/tencent/mobileqq/activity/photo/MediaScanner:a	(ZI)Ljava/util/ArrayList;
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +201 -> 382
    //   184: aload_0
    //   185: invokevirtual 315	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   188: astore_0
    //   189: aload_0
    //   190: invokeinterface 221 1 0
    //   195: ifeq +187 -> 382
    //   198: aload_0
    //   199: invokeinterface 225 1 0
    //   204: checkcast 317	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   207: astore 9
    //   209: new 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   212: dup
    //   213: invokespecial 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   216: astore 10
    //   218: aload 10
    //   220: aload 9
    //   222: getfield 320	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Int	I
    //   225: i2l
    //   226: putfield 322	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   229: aload 10
    //   231: aload 9
    //   233: getfield 324	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_Long	J
    //   236: putfield 327	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   239: aload 10
    //   241: aload 9
    //   243: getfield 329	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Long	J
    //   246: putfield 332	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   249: aload 10
    //   251: aload 9
    //   253: getfield 334	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   256: putfield 255	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   259: aload 10
    //   261: aload 9
    //   263: getfield 336	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_b_of_type_Long	J
    //   266: putfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   269: aload 10
    //   271: aload 9
    //   273: getfield 341	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   276: putfield 121	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   279: aload 10
    //   281: iconst_0
    //   282: putfield 345	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   285: aload_3
    //   286: ifnull +15 -> 301
    //   289: aload_3
    //   290: aload 9
    //   292: getfield 341	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   295: invokevirtual 395	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	(Ljava/lang/String;)Z
    //   298: ifne -109 -> 189
    //   301: aload 11
    //   303: aload 10
    //   305: invokeinterface 396 2 0
    //   310: pop
    //   311: goto -122 -> 189
    //   314: iconst_0
    //   315: istore 8
    //   317: goto -185 -> 132
    //   320: astore 10
    //   322: aconst_null
    //   323: astore 9
    //   325: aload 9
    //   327: astore_0
    //   328: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +20 -> 351
    //   334: aload 9
    //   336: astore_0
    //   337: ldc_w 289
    //   340: iconst_2
    //   341: aload 10
    //   343: invokevirtual 397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   346: aload 10
    //   348: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload 9
    //   353: ifnull -192 -> 161
    //   356: aload 9
    //   358: invokeinterface 390 1 0
    //   363: goto -202 -> 161
    //   366: astore_0
    //   367: aload 9
    //   369: astore_3
    //   370: aload_3
    //   371: ifnull +9 -> 380
    //   374: aload_3
    //   375: invokeinterface 390 1 0
    //   380: aload_0
    //   381: athrow
    //   382: aload 11
    //   384: invokestatic 355	java/util/Collections:sort	(Ljava/util/List;)V
    //   387: new 279	java/util/ArrayList
    //   390: dup
    //   391: invokespecial 280	java/util/ArrayList:<init>	()V
    //   394: astore_0
    //   395: iload_2
    //   396: aload 11
    //   398: invokeinterface 209 1 0
    //   403: invokestatic 403	java/lang/Math:min	(II)I
    //   406: istore_2
    //   407: iconst_0
    //   408: istore_1
    //   409: iload_1
    //   410: iload_2
    //   411: if_icmpge +25 -> 436
    //   414: aload_0
    //   415: aload 11
    //   417: iload_1
    //   418: invokeinterface 406 2 0
    //   423: invokeinterface 396 2 0
    //   428: pop
    //   429: iload_1
    //   430: iconst_1
    //   431: iadd
    //   432: istore_1
    //   433: goto -24 -> 409
    //   436: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +35 -> 474
    //   442: ldc_w 289
    //   445: iconst_2
    //   446: new 193	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 408
    //   456: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokestatic 368	android/os/SystemClock:uptimeMillis	()J
    //   462: lload 6
    //   464: lsub
    //   465: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   468: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: aload_0
    //   475: areturn
    //   476: astore 9
    //   478: aload_0
    //   479: astore_3
    //   480: aload 9
    //   482: astore_0
    //   483: goto -113 -> 370
    //   486: astore 10
    //   488: goto -163 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	paramContext	Context
    //   0	491	1	paramInt1	int
    //   0	491	2	paramInt2	int
    //   0	491	3	paramMediaFileFilter	MediaFileFilter
    //   0	491	4	paramLong	long
    //   3	460	6	l	long
    //   130	186	8	bool	boolean
    //   40	328	9	localObject1	Object
    //   476	5	9	localObject2	Object
    //   72	232	10	localObject3	Object
    //   320	27	10	localException1	Exception
    //   486	1	10	localException2	Exception
    //   64	352	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   66	115	320	java/lang/Exception
    //   66	115	366	finally
    //   121	129	476	finally
    //   135	149	476	finally
    //   328	334	476	finally
    //   337	351	476	finally
    //   121	129	486	java/lang/Exception
    //   135	149	486	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, boolean paramBoolean1, int paramInt3, ArrayList paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 368	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 9
    //   5: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +31 -> 39
    //   11: ldc_w 289
    //   14: iconst_2
    //   15: new 193	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 410
    //   25: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: lload 9
    //   30: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: astore 12
    //   42: iload_2
    //   43: ifgt +14 -> 57
    //   46: new 377	java/lang/IllegalArgumentException
    //   49: dup
    //   50: ldc_w 379
    //   53: invokespecial 380	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: new 279	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 280	java/util/ArrayList:<init>	()V
    //   64: astore 13
    //   66: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   69: bipush 16
    //   71: if_icmplt +301 -> 372
    //   74: iconst_1
    //   75: istore 8
    //   77: iload 8
    //   79: ifeq +121 -> 200
    //   82: iload 4
    //   84: ifeq +108 -> 192
    //   87: ldc_w 412
    //   90: astore 11
    //   92: aload_0
    //   93: aload 11
    //   95: iconst_3
    //   96: anewarray 61	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: iload 5
    //   103: invokestatic 151	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: iload_1
    //   110: invokestatic 151	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: iload_1
    //   117: invokestatic 151	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: aastore
    //   121: iload_2
    //   122: invokestatic 414	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   125: astore_0
    //   126: aload_0
    //   127: aload 13
    //   129: iload_1
    //   130: iload_2
    //   131: iload 8
    //   133: aload_3
    //   134: aload 6
    //   136: iload 7
    //   138: invokestatic 417	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   141: aload_0
    //   142: ifnull +9 -> 151
    //   145: aload_0
    //   146: invokeinterface 390 1 0
    //   151: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +35 -> 189
    //   157: ldc_w 289
    //   160: iconst_2
    //   161: new 193	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 419
    //   171: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokestatic 368	android/os/SystemClock:uptimeMillis	()J
    //   177: lload 9
    //   179: lsub
    //   180: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   183: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 13
    //   191: areturn
    //   192: ldc_w 421
    //   195: astore 11
    //   197: goto -105 -> 92
    //   200: iload 5
    //   202: ifle +88 -> 290
    //   205: new 193	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 423
    //   215: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 5
    //   220: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: ldc_w 425
    //   226: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 65
    //   231: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: astore 11
    //   239: getstatic 140	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   242: invokevirtual 146	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   245: astore 14
    //   247: aload 14
    //   249: ldc 148
    //   251: iload_2
    //   252: bipush 6
    //   254: imul
    //   255: invokestatic 151	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   258: invokevirtual 157	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   261: pop
    //   262: aload 14
    //   264: invokevirtual 161	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   267: astore 14
    //   269: aload_0
    //   270: invokevirtual 167	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   273: aload 14
    //   275: getstatic 85	com/tencent/mobileqq/utils/AlbumUtil:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   278: aload 11
    //   280: aconst_null
    //   281: ldc 169
    //   283: invokevirtual 175	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   286: astore_0
    //   287: goto -161 -> 126
    //   290: ldc_w 385
    //   293: astore 11
    //   295: goto -56 -> 239
    //   298: astore_3
    //   299: aconst_null
    //   300: astore_0
    //   301: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +15 -> 319
    //   307: ldc_w 289
    //   310: iconst_2
    //   311: aload_3
    //   312: invokevirtual 397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   315: aload_3
    //   316: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: aload_0
    //   320: ifnull -169 -> 151
    //   323: aload_0
    //   324: invokeinterface 390 1 0
    //   329: goto -178 -> 151
    //   332: astore_0
    //   333: aload 12
    //   335: astore_3
    //   336: aload_3
    //   337: ifnull +9 -> 346
    //   340: aload_3
    //   341: invokeinterface 390 1 0
    //   346: aload_0
    //   347: athrow
    //   348: astore 6
    //   350: aload_0
    //   351: astore_3
    //   352: aload 6
    //   354: astore_0
    //   355: goto -19 -> 336
    //   358: astore 6
    //   360: aload_0
    //   361: astore_3
    //   362: aload 6
    //   364: astore_0
    //   365: goto -29 -> 336
    //   368: astore_3
    //   369: goto -68 -> 301
    //   372: iconst_0
    //   373: istore 8
    //   375: goto -298 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramContext	Context
    //   0	378	1	paramInt1	int
    //   0	378	2	paramInt2	int
    //   0	378	3	paramMediaFileFilter	MediaFileFilter
    //   0	378	4	paramBoolean1	boolean
    //   0	378	5	paramInt3	int
    //   0	378	6	paramArrayList	ArrayList
    //   0	378	7	paramBoolean2	boolean
    //   75	299	8	bool	boolean
    //   3	175	9	l	long
    //   90	204	11	str	String
    //   40	294	12	localObject1	Object
    //   64	126	13	localArrayList	ArrayList
    //   245	29	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   92	126	298	java/lang/Exception
    //   205	239	298	java/lang/Exception
    //   239	287	298	java/lang/Exception
    //   92	126	332	finally
    //   205	239	332	finally
    //   239	287	332	finally
    //   126	141	348	finally
    //   301	319	358	finally
    //   126	141	368	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt, List paramList, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 279	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 280	java/util/ArrayList:<init>	()V
    //   10: astore 5
    //   12: aload_2
    //   13: invokestatic 428	com/tencent/mobileqq/utils/AlbumUtil:a	(Ljava/util/List;)Ljava/lang/String;
    //   16: astore_2
    //   17: getstatic 140	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: invokevirtual 146	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   23: astore 6
    //   25: aload 6
    //   27: ldc 148
    //   29: iload_1
    //   30: invokestatic 151	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: invokevirtual 157	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   36: pop
    //   37: aload 6
    //   39: invokevirtual 161	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   42: astore 6
    //   44: aload_0
    //   45: invokevirtual 167	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   48: aload 6
    //   50: getstatic 85	com/tencent/mobileqq/utils/AlbumUtil:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   53: aload_2
    //   54: aconst_null
    //   55: ldc 169
    //   57: invokevirtual 175	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore_0
    //   61: aload_0
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_1
    //   66: iconst_0
    //   67: aload_3
    //   68: aconst_null
    //   69: iconst_0
    //   70: invokestatic 417	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   73: aload_0
    //   74: ifnull +9 -> 83
    //   77: aload_0
    //   78: invokeinterface 390 1 0
    //   83: aload 5
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +15 -> 107
    //   95: ldc_w 289
    //   98: iconst_2
    //   99: aload_2
    //   100: invokevirtual 397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull -25 -> 83
    //   111: aload_0
    //   112: invokeinterface 390 1 0
    //   117: aload 5
    //   119: areturn
    //   120: astore_0
    //   121: aload 4
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull +9 -> 134
    //   128: aload_2
    //   129: invokeinterface 390 1 0
    //   134: aload_0
    //   135: athrow
    //   136: astore_3
    //   137: aload_0
    //   138: astore_2
    //   139: aload_3
    //   140: astore_0
    //   141: goto -17 -> 124
    //   144: astore_3
    //   145: aload_0
    //   146: astore_2
    //   147: aload_3
    //   148: astore_0
    //   149: goto -25 -> 124
    //   152: astore_2
    //   153: goto -64 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramContext	Context
    //   0	156	1	paramInt	int
    //   0	156	2	paramList	List
    //   0	156	3	paramMediaFileFilter	MediaFileFilter
    //   1	121	4	localObject1	Object
    //   10	108	5	localArrayList	ArrayList
    //   23	26	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	61	86	java/lang/Exception
    //   44	61	120	finally
    //   61	73	136	finally
    //   89	107	144	finally
    //   61	73	152	java/lang/Exception
  }
  
  /* Error */
  private static List a(Context paramContext, String paramString, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 279	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 280	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 414	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +30 -> 58
    //   31: iconst_1
    //   32: istore 4
    //   34: aload_0
    //   35: aload 7
    //   37: iconst_m1
    //   38: iload_2
    //   39: iload 4
    //   41: aload_3
    //   42: invokestatic 432	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 390 1 0
    //   55: aload 7
    //   57: areturn
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -27 -> 34
    //   64: astore_1
    //   65: aload 6
    //   67: astore_0
    //   68: aload_0
    //   69: astore 5
    //   71: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +18 -> 92
    //   77: aload_0
    //   78: astore 5
    //   80: ldc_w 289
    //   83: iconst_2
    //   84: aload_1
    //   85: invokevirtual 397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: aload_1
    //   89: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: ifnull -38 -> 55
    //   96: aload_0
    //   97: invokeinterface 390 1 0
    //   102: aload 7
    //   104: areturn
    //   105: astore_1
    //   106: aload 5
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +9 -> 119
    //   113: aload_0
    //   114: invokeinterface 390 1 0
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -13 -> 109
    //   125: astore_1
    //   126: goto -58 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramString	String
    //   0	129	2	paramInt	int
    //   0	129	3	paramMediaFileFilter	MediaFileFilter
    //   32	28	4	bool	boolean
    //   1	106	5	localContext	Context
    //   4	62	6	localObject	Object
    //   13	90	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	105	finally
    //   71	77	105	finally
    //   80	92	105	finally
    //   23	31	121	finally
    //   34	45	121	finally
    //   23	31	125	java/lang/Exception
    //   34	45	125	java/lang/Exception
  }
  
  public static List a(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AlbumUtil", 2, "getAlbumPhotos");
    }
    if ((paramString2 == null) || ("$RecentAlbumId".equals(paramString1))) {
      paramContext = a(paramContext, paramInt3, paramInt1, paramMediaFileFilter, paramBoolean1, paramInt2, paramArrayList, paramBoolean2);
    }
    do
    {
      do
      {
        return paramContext;
        paramString1 = a(paramContext, "bucket_id='" + paramString1 + "'", paramInt1, paramMediaFileFilter);
        paramContext = paramString1;
      } while (paramString1 == null);
      paramContext = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("AlbumUtil", 2, "photo list size is:" + paramString1.size());
    return paramString1;
  }
  
  /* Error */
  public static List a(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 19
    //   3: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: ldc_w 289
    //   12: iconst_2
    //   13: ldc_w 451
    //   16: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: ldc_w 453
    //   22: aload_1
    //   23: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +127 -> 153
    //   29: aload_0
    //   30: invokevirtual 167	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   33: getstatic 383	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: getstatic 89	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   39: aconst_null
    //   40: aconst_null
    //   41: ldc 169
    //   43: invokevirtual 175	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore 16
    //   48: aload 16
    //   50: astore 17
    //   52: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +47 -> 104
    //   60: iconst_1
    //   61: istore 15
    //   63: aload 16
    //   65: astore 17
    //   67: aload_0
    //   68: aload 16
    //   70: aconst_null
    //   71: iload_3
    //   72: aload 4
    //   74: iload 15
    //   76: lload 10
    //   78: invokestatic 455	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/ArrayList;
    //   81: astore 18
    //   83: aload 18
    //   85: astore_0
    //   86: aload_0
    //   87: astore_1
    //   88: aload 16
    //   90: ifnull +12 -> 102
    //   93: aload 16
    //   95: invokeinterface 390 1 0
    //   100: aload_0
    //   101: astore_1
    //   102: aload_1
    //   103: areturn
    //   104: iconst_0
    //   105: istore 15
    //   107: goto -44 -> 63
    //   110: astore 18
    //   112: aconst_null
    //   113: astore 16
    //   115: aload 16
    //   117: astore 17
    //   119: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +19 -> 141
    //   125: aload 16
    //   127: astore 17
    //   129: ldc_w 289
    //   132: iconst_2
    //   133: ldc_w 457
    //   136: aload 18
    //   138: invokestatic 459	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload 16
    //   143: ifnull +10 -> 153
    //   146: aload 16
    //   148: invokeinterface 390 1 0
    //   153: aload 19
    //   155: astore 16
    //   157: aload 4
    //   159: ifnull +36 -> 195
    //   162: aload 19
    //   164: astore 16
    //   166: aload 4
    //   168: invokevirtual 461	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	()Z
    //   171: ifeq +24 -> 195
    //   174: aload_0
    //   175: aload_1
    //   176: aload_2
    //   177: iload_3
    //   178: aload 4
    //   180: iload 5
    //   182: iload 6
    //   184: iload 7
    //   186: aload 8
    //   188: iload 9
    //   190: invokestatic 463	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   193: astore 16
    //   195: aload 4
    //   197: ifnull +463 -> 660
    //   200: aload 4
    //   202: invokevirtual 465	com/tencent/mobileqq/activity/photo/MediaFileFilter:b	()Z
    //   205: ifeq +455 -> 660
    //   208: aload_0
    //   209: aload_1
    //   210: aload_2
    //   211: iload_3
    //   212: aload 4
    //   214: lload 10
    //   216: invokestatic 468	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   219: astore_0
    //   220: ldc_w 437
    //   223: aload_1
    //   224: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifeq +64 -> 291
    //   230: invokestatic 368	android/os/SystemClock:uptimeMillis	()J
    //   233: lstore 10
    //   235: aload 16
    //   237: ifnull +8 -> 245
    //   240: aload 16
    //   242: invokestatic 355	java/util/Collections:sort	(Ljava/util/List;)V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokestatic 355	java/util/Collections:sort	(Ljava/util/List;)V
    //   253: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +35 -> 291
    //   259: ldc_w 289
    //   262: iconst_2
    //   263: new 193	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 470
    //   273: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokestatic 368	android/os/SystemClock:uptimeMillis	()J
    //   279: lload 10
    //   281: lsub
    //   282: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   285: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: aload_0
    //   292: ifnull +12 -> 304
    //   295: aload_0
    //   296: invokeinterface 473 1 0
    //   301: ifeq +24 -> 325
    //   304: aload 16
    //   306: areturn
    //   307: astore_0
    //   308: aconst_null
    //   309: astore 17
    //   311: aload 17
    //   313: ifnull +10 -> 323
    //   316: aload 17
    //   318: invokeinterface 390 1 0
    //   323: aload_0
    //   324: athrow
    //   325: aload_0
    //   326: astore_1
    //   327: aload 16
    //   329: ifnull -227 -> 102
    //   332: aload_0
    //   333: astore_1
    //   334: aload 16
    //   336: invokeinterface 473 1 0
    //   341: ifne -239 -> 102
    //   344: aload 16
    //   346: invokeinterface 209 1 0
    //   351: istore 5
    //   353: iconst_0
    //   354: istore 6
    //   356: iconst_0
    //   357: istore 12
    //   359: iload 12
    //   361: aload_0
    //   362: invokeinterface 209 1 0
    //   367: if_icmpge +266 -> 633
    //   370: aload_0
    //   371: iload 12
    //   373: invokeinterface 406 2 0
    //   378: checkcast 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   381: astore_1
    //   382: aload 16
    //   384: iload 5
    //   386: iconst_1
    //   387: isub
    //   388: invokeinterface 406 2 0
    //   393: checkcast 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   396: astore_2
    //   397: aload_1
    //   398: getfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   401: aload_2
    //   402: getfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   405: lcmp
    //   406: ifgt +95 -> 501
    //   409: iload_3
    //   410: iconst_m1
    //   411: if_icmpne +39 -> 450
    //   414: iload 12
    //   416: aload_0
    //   417: invokeinterface 209 1 0
    //   422: if_icmpge +211 -> 633
    //   425: aload 16
    //   427: aload_0
    //   428: iload 12
    //   430: invokeinterface 406 2 0
    //   435: invokeinterface 396 2 0
    //   440: pop
    //   441: iload 12
    //   443: iconst_1
    //   444: iadd
    //   445: istore 12
    //   447: goto -33 -> 414
    //   450: aload_0
    //   451: invokeinterface 209 1 0
    //   456: iload 12
    //   458: isub
    //   459: iload_3
    //   460: iload 5
    //   462: isub
    //   463: invokestatic 403	java/lang/Math:min	(II)I
    //   466: istore 5
    //   468: iconst_0
    //   469: istore_3
    //   470: iload_3
    //   471: iload 5
    //   473: if_icmpge +160 -> 633
    //   476: aload 16
    //   478: aload_0
    //   479: iload_3
    //   480: iload 12
    //   482: iadd
    //   483: invokeinterface 406 2 0
    //   488: invokeinterface 396 2 0
    //   493: pop
    //   494: iload_3
    //   495: iconst_1
    //   496: iadd
    //   497: istore_3
    //   498: goto -28 -> 470
    //   501: iload 6
    //   503: istore 13
    //   505: iload 13
    //   507: iload 5
    //   509: if_icmpge +136 -> 645
    //   512: aload 16
    //   514: iload 13
    //   516: invokeinterface 406 2 0
    //   521: checkcast 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   524: astore_2
    //   525: aload_1
    //   526: getfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   529: aload_2
    //   530: getfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   533: lcmp
    //   534: ifgt +12 -> 546
    //   537: iload 13
    //   539: iconst_1
    //   540: iadd
    //   541: istore 13
    //   543: goto -38 -> 505
    //   546: aload 16
    //   548: iload 13
    //   550: aload_1
    //   551: invokeinterface 476 3 0
    //   556: iload_3
    //   557: iconst_m1
    //   558: if_icmpeq +24 -> 582
    //   561: aload 16
    //   563: invokeinterface 209 1 0
    //   568: iload_3
    //   569: if_icmple +13 -> 582
    //   572: aload 16
    //   574: iload 5
    //   576: invokeinterface 479 2 0
    //   581: pop
    //   582: aload 16
    //   584: invokeinterface 209 1 0
    //   589: istore 14
    //   591: iload 5
    //   593: istore 6
    //   595: iload 5
    //   597: iload 14
    //   599: if_icmpeq +7 -> 606
    //   602: iload 14
    //   604: istore 6
    //   606: iload 13
    //   608: iconst_1
    //   609: iadd
    //   610: istore 5
    //   612: iload 12
    //   614: iconst_1
    //   615: iadd
    //   616: istore 12
    //   618: iload 6
    //   620: istore 13
    //   622: iload 5
    //   624: istore 6
    //   626: iload 13
    //   628: istore 5
    //   630: goto -271 -> 359
    //   633: aload 16
    //   635: areturn
    //   636: astore_0
    //   637: goto -326 -> 311
    //   640: astore 18
    //   642: goto -527 -> 115
    //   645: iload 5
    //   647: istore 13
    //   649: iload 6
    //   651: istore 5
    //   653: iload 13
    //   655: istore 6
    //   657: goto -45 -> 612
    //   660: aconst_null
    //   661: astore_0
    //   662: goto -442 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	paramContext	Context
    //   0	665	1	paramString1	String
    //   0	665	2	paramString2	String
    //   0	665	3	paramInt1	int
    //   0	665	4	paramMediaFileFilter	MediaFileFilter
    //   0	665	5	paramInt2	int
    //   0	665	6	paramInt3	int
    //   0	665	7	paramBoolean1	boolean
    //   0	665	8	paramArrayList	ArrayList
    //   0	665	9	paramBoolean2	boolean
    //   0	665	10	paramLong	long
    //   357	260	12	i	int
    //   503	151	13	j	int
    //   589	14	14	k	int
    //   61	45	15	bool	boolean
    //   46	588	16	localObject1	Object
    //   50	267	17	localObject2	Object
    //   81	3	18	localArrayList	ArrayList
    //   110	27	18	localException1	Exception
    //   640	1	18	localException2	Exception
    //   1	162	19	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   29	48	110	java/lang/Exception
    //   29	48	307	finally
    //   52	60	636	finally
    //   67	83	636	finally
    //   119	125	636	finally
    //   129	141	636	finally
    //   52	60	640	java/lang/Exception
    //   67	83	640	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: ldc_w 437
    //   7: aload_1
    //   8: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: sipush 210
    //   18: iload_3
    //   19: aload 4
    //   21: lload 5
    //   23: invokestatic 481	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   26: areturn
    //   27: new 279	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 280	java/util/ArrayList:<init>	()V
    //   34: astore 8
    //   36: new 193	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 442
    //   46: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 444
    //   56: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 167	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: getstatic 383	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   70: getstatic 89	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   73: aload_1
    //   74: aconst_null
    //   75: ldc 169
    //   77: invokevirtual 175	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   86: bipush 16
    //   88: if_icmplt +35 -> 123
    //   91: iconst_1
    //   92: istore 7
    //   94: aload_1
    //   95: astore_0
    //   96: aload_1
    //   97: aload 8
    //   99: iload_3
    //   100: aload 4
    //   102: iload 7
    //   104: lload 5
    //   106: invokestatic 283	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   109: pop
    //   110: aload_1
    //   111: ifnull +78 -> 189
    //   114: aload_1
    //   115: invokeinterface 390 1 0
    //   120: aload 8
    //   122: areturn
    //   123: iconst_0
    //   124: istore 7
    //   126: goto -32 -> 94
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: astore_0
    //   134: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +16 -> 153
    //   140: aload_1
    //   141: astore_0
    //   142: ldc_w 289
    //   145: iconst_2
    //   146: ldc_w 457
    //   149: aload_2
    //   150: invokestatic 459	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_1
    //   154: ifnull +35 -> 189
    //   157: aload_1
    //   158: invokeinterface 390 1 0
    //   163: aload 8
    //   165: areturn
    //   166: astore_1
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +9 -> 179
    //   173: aload_0
    //   174: invokeinterface 390 1 0
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: goto -13 -> 169
    //   185: astore_2
    //   186: goto -54 -> 132
    //   189: aload 8
    //   191: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString1	String
    //   0	192	2	paramString2	String
    //   0	192	3	paramInt	int
    //   0	192	4	paramMediaFileFilter	MediaFileFilter
    //   0	192	5	paramLong	long
    //   92	33	7	bool	boolean
    //   34	156	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   63	81	129	java/lang/Exception
    //   63	81	166	finally
    //   83	91	181	finally
    //   96	110	181	finally
    //   134	140	181	finally
    //   142	153	181	finally
    //   83	91	185	java/lang/Exception
    //   96	110	185	java/lang/Exception
  }
  
  @TargetApi(10)
  private static List a(Cursor paramCursor, List paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    if (paramCursor.getCount() <= 0)
    {
      paramCursor = null;
      return paramCursor;
    }
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList();
    }
    int n = paramCursor.getColumnIndexOrThrow("_id");
    int i1 = paramCursor.getColumnIndexOrThrow("_data");
    int i2 = paramCursor.getColumnIndexOrThrow("date_added");
    int i3 = paramCursor.getColumnIndexOrThrow("date_modified");
    int i4 = paramCursor.getColumnIndexOrThrow("duration");
    int i5 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i6 = paramCursor.getColumnIndexOrThrow("_size");
    int j = 0;
    int i = 0;
    if (paramBoolean)
    {
      j = paramCursor.getColumnIndexOrThrow("width");
      i = paramCursor.getColumnIndexOrThrow("height");
    }
    int k = 0;
    paramList = null;
    label135:
    String str1;
    Object localObject3;
    Object localObject2;
    long l2;
    for (;;)
    {
      if (paramCursor.moveToNext())
      {
        str1 = paramCursor.getString(i1);
        if ((!TextUtils.isEmpty(str1)) && (new File(str1).exists()))
        {
          localObject3 = paramCursor.getString(i5);
          if ((paramMediaFileFilter != null) && (paramMediaFileFilter.a((String)localObject3)))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = paramList;
              if (paramList == null) {
                localObject2 = new StringBuilder();
              }
              ((StringBuilder)localObject2).append("Filter mime type:").append((String)localObject3).append(", path is ").append(str1).append("\n");
              paramList = (List)localObject2;
            }
          }
          else
          {
            long l1 = paramCursor.getLong(i2);
            l2 = paramCursor.getLong(i3);
            localObject2 = new LocalMediaInfo();
            ((LocalMediaInfo)localObject2)._id = paramCursor.getLong(n);
            ((LocalMediaInfo)localObject2).path = str1;
            ((LocalMediaInfo)localObject2).mMimeType = ((String)localObject3);
            ((LocalMediaInfo)localObject2).addedDate = l1;
            ((LocalMediaInfo)localObject2).modifiedDate = l2;
            ((LocalMediaInfo)localObject2).mDuration = paramCursor.getLong(i4);
            ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i6);
            if (!paramBoolean) {
              break label549;
            }
            ((LocalMediaInfo)localObject2).mediaWidth = paramCursor.getInt(j);
            ((LocalMediaInfo)localObject2).mediaHeight = paramCursor.getInt(i);
            if (((LocalMediaInfo)localObject2).mDuration != 0L) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject3).setDataSource(str1);
        ((LocalMediaInfo)localObject2).mDuration = Long.parseLong(((MediaMetadataRetriever)localObject3).extractMetadata(9));
        if ((paramLong > 0L) && (((LocalMediaInfo)localObject2).mDuration > paramLong)) {
          break label135;
        }
        ((List)localObject1).add(localObject2);
        int m = k + 1;
        if (jdField_b_of_type_Long < l2) {
          jdField_b_of_type_Long = l2;
        }
        k = m;
        if (paramInt <= 0) {
          break label135;
        }
        k = m;
        if (m < paramInt) {
          break label135;
        }
        paramCursor = (Cursor)localObject1;
        if (paramList == null) {
          break;
        }
        paramCursor = (Cursor)localObject1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AlbumUtil", 2, paramList.toString());
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("AlbumUtil", 2, "get timeString failed");
        continue;
      }
      label549:
      if (VersionUtils.d())
      {
        localObject3 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject3).setDataSource(localException);
        String str2 = ((MediaMetadataRetriever)localObject3).extractMetadata(18);
        localObject3 = ((MediaMetadataRetriever)localObject3).extractMetadata(19);
        try
        {
          ((LocalMediaInfo)localObject2).mediaWidth = Integer.parseInt(str2);
          ((LocalMediaInfo)localObject2).mediaHeight = Integer.parseInt((String)localObject3);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          ((LocalMediaInfo)localObject2).mediaWidth = 0;
          ((LocalMediaInfo)localObject2).mediaHeight = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AlbumUtil", 2, "Video size is not number format...");
        }
      }
    }
  }
  
  public static void a() {}
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2131034132, 2131034133);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a(paramActivity);
        return;
      }
      b(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      c(paramActivity);
      return;
    }
    d(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("album_file", 0).edit();
    paramContext.putString("album_key_id", jdField_b_of_type_JavaLangString);
    paramContext.putString("album_key_name", jdField_c_of_type_JavaLangString);
    paramContext.commit();
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false))
    {
      String str = paramIntent.getStringExtra("ALBUM_ID");
      paramIntent = paramIntent.getStringExtra("PhotoConst.LAST_ALBUMPATH");
      if ((paramIntent != null) && (str != null))
      {
        jdField_a_of_type_JavaLangString = paramIntent;
        jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  private static void a(Cursor paramCursor, List paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    a(paramCursor, paramList, paramInt1, paramInt2, paramBoolean, paramMediaFileFilter, null, false);
  }
  
  private static void a(Cursor paramCursor, List paramList, int paramInt1, int paramInt2, boolean paramBoolean1, MediaFileFilter paramMediaFileFilter, ArrayList paramArrayList, boolean paramBoolean2)
  {
    Object localObject1;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int m;
    if (paramCursor.getCount() > 0)
    {
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      i1 = paramCursor.getColumnIndexOrThrow("_id");
      i2 = paramCursor.getColumnIndexOrThrow("_data");
      i3 = paramCursor.getColumnIndexOrThrow("orientation");
      i4 = paramCursor.getColumnIndexOrThrow("date_added");
      i5 = paramCursor.getColumnIndexOrThrow("date_modified");
      i6 = paramCursor.getColumnIndexOrThrow("mime_type");
      i7 = paramCursor.getColumnIndexOrThrow("_size");
      i8 = paramCursor.getColumnIndexOrThrow("latitude");
      i9 = paramCursor.getColumnIndexOrThrow("longitude");
      if (!paramBoolean1) {
        break label1174;
      }
      m = paramCursor.getColumnIndexOrThrow("width");
    }
    for (int k = paramCursor.getColumnIndexOrThrow("height");; k = 0)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      int i = 0;
      label657:
      label1172:
      for (;;)
      {
        String str;
        if (paramCursor.moveToNext())
        {
          str = paramCursor.getString(i2);
          if (!FileUtil.b(str)) {
            continue;
          }
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            paramList = paramArrayList.iterator();
            do
            {
              if (!paramList.hasNext()) {
                break;
              }
            } while (!str.contains((String)paramList.next()));
          }
        }
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            break label1172;
          }
          Object localObject2 = paramCursor.getString(i6);
          paramList = (List)localObject2;
          if (paramMediaFileFilter != null)
          {
            paramList = (List)localObject2;
            if (paramMediaFileFilter.a((String)localObject2))
            {
              if ((!"*/*".equals(localObject2)) && (!"image/*".equals(localObject2))) {
                break label777;
              }
              if ((str.indexOf(".jpg") == -1) && (str.indexOf(".jpeg") == -1)) {
                break label672;
              }
              paramList = "image/jpeg";
            }
          }
          label324:
          long l1 = paramCursor.getLong(i4);
          long l2 = paramCursor.getLong(i5);
          if (jdField_b_of_type_Long < l2) {
            jdField_b_of_type_Long = l2;
          }
          int n = 0;
          j = n;
          if (paramBoolean1)
          {
            j = n;
            if (paramCursor.getInt(m) == 0) {
              j = 1;
            }
          }
          long l3 = paramCursor.getLong(i1);
          if ((paramInt1 > 0) && ((!paramBoolean1) || (j != 0)))
          {
            a(str, localOptions, arrayOfInt);
            if ((arrayOfInt[0] < paramInt1) && (arrayOfInt[1] < paramInt1)) {
              break label1165;
            }
            localObject2 = new LocalMediaInfo();
            ((LocalMediaInfo)localObject2)._id = l3;
            ((LocalMediaInfo)localObject2).path = str;
            ((LocalMediaInfo)localObject2).addedDate = l1;
            ((LocalMediaInfo)localObject2).modifiedDate = l2;
            ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i3);
            ((LocalMediaInfo)localObject2).mMimeType = paramList;
            ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i7);
            ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
            ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
            ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i8) * 1000000.0D));
            ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i9) * 1000000.0D));
            if ((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0))
            {
              if (QLog.isColorLevel()) {
                QLog.i("AlbumUtil", 2, "no size " + str);
              }
              label610:
              if (!paramBoolean2) {
                break label833;
              }
              j = i;
              if (((LocalMediaInfo)localObject2).panoramaPhotoType != 1)
              {
                j = i;
                if (((LocalMediaInfo)localObject2).panoramaPhotoType != 2)
                {
                  ((List)localObject1).add(localObject2);
                  j = i + 1;
                }
              }
              i = j;
            }
          }
          for (;;)
          {
            if ((paramInt2 > 0) && (i >= paramInt2))
            {
              return;
              label672:
              if (str.indexOf(".gif") != -1)
              {
                paramList = "image/gif";
                break label324;
              }
              if (str.indexOf(".bmp") != -1)
              {
                paramList = "image/bmp";
                break label324;
              }
              if (str.indexOf(".png") != -1)
              {
                paramList = "image/png";
                break label324;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("AlbumUtil", 2, "Filter mime type:" + (String)localObject2 + ", path is " + str);
              break;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("AlbumUtil", 2, "Filter unknown " + (String)localObject2 + ", path is " + str);
              break;
              a((LocalMediaInfo)localObject2);
              break label610;
              label833:
              ((List)localObject1).add(localObject2);
              j = i + 1;
              break label657;
              localObject2 = new LocalMediaInfo();
              ((LocalMediaInfo)localObject2)._id = l3;
              ((LocalMediaInfo)localObject2).path = str;
              ((LocalMediaInfo)localObject2).addedDate = paramCursor.getLong(i4);
              ((LocalMediaInfo)localObject2).modifiedDate = paramCursor.getLong(i5);
              ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i3);
              ((LocalMediaInfo)localObject2).mMimeType = paramList;
              ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i7);
              ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i8) * 1000000.0D));
              ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i9) * 1000000.0D));
              if (paramBoolean1)
              {
                ((LocalMediaInfo)localObject2).mediaWidth = paramCursor.getInt(m);
                ((LocalMediaInfo)localObject2).mediaHeight = paramCursor.getInt(k);
              }
              if ((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0))
              {
                a(str, localOptions, arrayOfInt);
                ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
                ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
              }
              if ((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) {
                if (QLog.isColorLevel()) {
                  QLog.i("AlbumUtil", 2, "no size " + str);
                }
              }
              for (;;)
              {
                if (!paramBoolean2) {
                  break label1143;
                }
                if ((((LocalMediaInfo)localObject2).panoramaPhotoType == 1) || (((LocalMediaInfo)localObject2).panoramaPhotoType == 2)) {
                  break label1165;
                }
                ((List)localObject1).add(localObject2);
                i += 1;
                break;
                a((LocalMediaInfo)localObject2);
              }
              label1143:
              ((List)localObject1).add(localObject2);
              i += 1;
              continue;
            }
            break;
          }
        }
      }
      label777:
      label1165:
      label1174:
      m = 0;
    }
  }
  
  private static void a(LocalMediaInfo paramLocalMediaInfo)
  {
    XMPCoreUtil.a().a(new akbe(paramLocalMediaInfo));
  }
  
  public static void a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      paramLocalMediaInfo.mediaHeight = localOptions.outHeight;
      paramLocalMediaInfo.mediaWidth = localOptions.outWidth;
      paramLocalMediaInfo.mMimeType = localOptions.outMimeType;
      paramLocalMediaInfo.addedDate = System.currentTimeMillis();
      paramLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      paramLocalMediaInfo.path = paramString;
      paramLocalMediaInfo.panoramaPhotoType = 3;
      paramLocalMediaInfo.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramLocalMediaInfo)
    {
      QLog.e("AlbumUtil", 2, "decode image error", paramLocalMediaInfo);
    }
  }
  
  private static void a(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localInteger == null) {}
    for (;;)
    {
      try
      {
        SafeBitmapFactory.decodeFile(paramString, paramOptions);
        k = paramOptions.outWidth;
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = 0;
        continue;
      }
      try
      {
        m = paramOptions.outHeight;
        i = m;
        j = k;
        if (k <= 65535)
        {
          i = m;
          j = k;
          if (m > 65535) {}
        }
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = k;
        continue;
      }
      try
      {
        i = paramOptions.outWidth;
        j = paramOptions.outHeight;
        jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i << 16 & 0xFFFF0000 | j & 0xFFFF));
        j = k;
        i = m;
      }
      catch (OutOfMemoryError paramString)
      {
        i = m;
        j = k;
        continue;
      }
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      return;
      j = localInteger.intValue() >> 16 & 0xFFFF;
      i = localInteger.intValue() & 0xFFFF;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext, int paramInt, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramLocalMediaInfo != null) && (a(paramLocalMediaInfo) == 1)) {
      if (!paramBoolean) {
        break label182;
      }
    }
    label182:
    for (int i = b();; i = a())
    {
      paramBoolean = bool;
      if (paramInt >= i)
      {
        if (System.currentTimeMillis() - jdField_c_of_type_Long > 2000L)
        {
          QQToast.a(paramContext, "不能上传超过" + i + "个视频", 0).a();
          jdField_c_of_type_Long = System.currentTimeMillis();
        }
        paramBoolean = false;
      }
      long l = QZoneHelper.b();
      if (paramLocalMediaInfo.fileSize > l)
      {
        QQToast.a(paramContext, "请上传不超过" + (float)l / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).a();
        paramBoolean = false;
      }
      if (paramLocalMediaInfo.mDuration <= 600000L) {
        break;
      }
      QQToast.a(paramContext, "请上传不超过10分钟的视频", 0).a();
      return false;
    }
    return paramBoolean;
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "ShuoShuoMaxSelectVideoNum", 10);
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  public static List b(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    return a(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter, 0, -1, false, null, false, paramLong);
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
  }
  
  private static void b(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2131034129, 2131034130);
  }
  
  public static void c()
  {
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  private static void c(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2131034123, 2131034124);
  }
  
  private static void d(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2131034121, 2131034122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */