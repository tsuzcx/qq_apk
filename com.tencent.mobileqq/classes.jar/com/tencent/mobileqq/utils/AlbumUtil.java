package com.tencent.mobileqq.utils;

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
    if (paramLocalMediaInfo == null) {
      return -1;
    }
    String[] arrayOfString = MimeHelper.a(paramLocalMediaInfo.mMimeType);
    if (arrayOfString == null) {
      return 0;
    }
    Integer localInteger = (Integer)d.get(arrayOfString[0]);
    if (localInteger == null)
    {
      QLog.w("AlbumUtil", 1, "getMediaType fail : " + paramLocalMediaInfo.mMimeType + " - " + arrayOfString[0]);
      return -1;
    }
    return localInteger.intValue();
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
    //   0: invokestatic 375	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 132
    //   13: iconst_2
    //   14: new 134	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 377
    //   24: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 6
    //   29: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 9
    //   41: iload_2
    //   42: ifgt +14 -> 56
    //   45: new 384	java/lang/IllegalArgumentException
    //   48: dup
    //   49: ldc_w 386
    //   52: invokespecial 387	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: new 290	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 291	java/util/ArrayList:<init>	()V
    //   63: astore 11
    //   65: getstatic 390	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   68: invokevirtual 169	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   71: astore 10
    //   73: aload 10
    //   75: ldc 171
    //   77: iload_2
    //   78: bipush 6
    //   80: imul
    //   81: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 180	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   87: pop
    //   88: aload 10
    //   90: invokevirtual 184	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   93: astore 10
    //   95: aload_0
    //   96: invokevirtual 190	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   99: aload 10
    //   101: getstatic 89	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   104: ldc_w 392
    //   107: aconst_null
    //   108: ldc 192
    //   110: invokevirtual 198	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore_0
    //   114: aload_0
    //   115: astore 9
    //   117: aload 9
    //   119: astore_0
    //   120: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   123: bipush 16
    //   125: if_icmplt +188 -> 313
    //   128: iconst_1
    //   129: istore 8
    //   131: aload 9
    //   133: astore_0
    //   134: aload 9
    //   136: aload 11
    //   138: iload_2
    //   139: aload_3
    //   140: iload 8
    //   142: lload 4
    //   144: invokestatic 294	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   147: pop
    //   148: aload 9
    //   150: ifnull +10 -> 160
    //   153: aload 9
    //   155: invokeinterface 397 1 0
    //   160: invokestatic 313	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   163: invokestatic 318	com/tencent/mobileqq/activity/photo/MediaScanner:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   166: astore_0
    //   167: aload_0
    //   168: ifnull +212 -> 380
    //   171: aload_0
    //   172: iconst_1
    //   173: bipush 100
    //   175: invokevirtual 321	com/tencent/mobileqq/activity/photo/MediaScanner:a	(ZI)Ljava/util/ArrayList;
    //   178: astore_0
    //   179: aload_0
    //   180: ifnull +200 -> 380
    //   183: aload_0
    //   184: invokevirtual 322	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   187: astore_0
    //   188: aload_0
    //   189: invokeinterface 238 1 0
    //   194: ifeq +186 -> 380
    //   197: aload_0
    //   198: invokeinterface 242 1 0
    //   203: checkcast 324	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   206: astore 9
    //   208: new 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   211: dup
    //   212: invokespecial 325	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   215: astore 10
    //   217: aload 10
    //   219: aload 9
    //   221: getfield 327	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Int	I
    //   224: i2l
    //   225: putfield 329	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   228: aload 10
    //   230: aload 9
    //   232: getfield 331	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_Long	J
    //   235: putfield 334	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   238: aload 10
    //   240: aload 9
    //   242: getfield 336	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Long	J
    //   245: putfield 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   248: aload 10
    //   250: aload 9
    //   252: getfield 341	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   255: putfield 268	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   258: aload 10
    //   260: aload 9
    //   262: getfield 343	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_b_of_type_Long	J
    //   265: putfield 346	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   268: aload 10
    //   270: aload 9
    //   272: getfield 348	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   275: putfield 121	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   278: aload 10
    //   280: iconst_0
    //   281: putfield 352	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   284: aload_3
    //   285: ifnull +15 -> 300
    //   288: aload_3
    //   289: aload 9
    //   291: getfield 348	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   294: invokevirtual 402	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	(Ljava/lang/String;)Z
    //   297: ifne -109 -> 188
    //   300: aload 11
    //   302: aload 10
    //   304: invokeinterface 403 2 0
    //   309: pop
    //   310: goto -122 -> 188
    //   313: iconst_0
    //   314: istore 8
    //   316: goto -185 -> 131
    //   319: astore 10
    //   321: aconst_null
    //   322: astore 9
    //   324: aload 9
    //   326: astore_0
    //   327: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +19 -> 349
    //   333: aload 9
    //   335: astore_0
    //   336: ldc 132
    //   338: iconst_2
    //   339: aload 10
    //   341: invokevirtual 404	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   344: aload 10
    //   346: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   349: aload 9
    //   351: ifnull -191 -> 160
    //   354: aload 9
    //   356: invokeinterface 397 1 0
    //   361: goto -201 -> 160
    //   364: astore_0
    //   365: aload 9
    //   367: astore_3
    //   368: aload_3
    //   369: ifnull +9 -> 378
    //   372: aload_3
    //   373: invokeinterface 397 1 0
    //   378: aload_0
    //   379: athrow
    //   380: aload 11
    //   382: invokestatic 362	java/util/Collections:sort	(Ljava/util/List;)V
    //   385: new 290	java/util/ArrayList
    //   388: dup
    //   389: invokespecial 291	java/util/ArrayList:<init>	()V
    //   392: astore_0
    //   393: iload_2
    //   394: aload 11
    //   396: invokeinterface 226 1 0
    //   401: invokestatic 410	java/lang/Math:min	(II)I
    //   404: istore_2
    //   405: iconst_0
    //   406: istore_1
    //   407: iload_1
    //   408: iload_2
    //   409: if_icmpge +25 -> 434
    //   412: aload_0
    //   413: aload 11
    //   415: iload_1
    //   416: invokeinterface 413 2 0
    //   421: invokeinterface 403 2 0
    //   426: pop
    //   427: iload_1
    //   428: iconst_1
    //   429: iadd
    //   430: istore_1
    //   431: goto -24 -> 407
    //   434: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +34 -> 471
    //   440: ldc 132
    //   442: iconst_2
    //   443: new 134	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 415
    //   453: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokestatic 375	android/os/SystemClock:uptimeMillis	()J
    //   459: lload 6
    //   461: lsub
    //   462: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   465: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: aload_0
    //   472: areturn
    //   473: astore 9
    //   475: aload_0
    //   476: astore_3
    //   477: aload 9
    //   479: astore_0
    //   480: goto -112 -> 368
    //   483: astore 10
    //   485: goto -161 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramContext	Context
    //   0	488	1	paramInt1	int
    //   0	488	2	paramInt2	int
    //   0	488	3	paramMediaFileFilter	MediaFileFilter
    //   0	488	4	paramLong	long
    //   3	457	6	l	long
    //   129	186	8	bool	boolean
    //   39	327	9	localObject1	Object
    //   473	5	9	localObject2	Object
    //   71	232	10	localObject3	Object
    //   319	26	10	localException1	Exception
    //   483	1	10	localException2	Exception
    //   63	351	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   65	114	319	java/lang/Exception
    //   65	114	364	finally
    //   120	128	473	finally
    //   134	148	473	finally
    //   327	333	473	finally
    //   336	349	473	finally
    //   120	128	483	java/lang/Exception
    //   134	148	483	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, boolean paramBoolean1, int paramInt3, ArrayList paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 375	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 9
    //   5: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 132
    //   13: iconst_2
    //   14: new 134	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 417
    //   24: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 9
    //   29: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 12
    //   41: iload_2
    //   42: ifgt +14 -> 56
    //   45: new 384	java/lang/IllegalArgumentException
    //   48: dup
    //   49: ldc_w 386
    //   52: invokespecial 387	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: new 290	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 291	java/util/ArrayList:<init>	()V
    //   63: astore 13
    //   65: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   68: bipush 16
    //   70: if_icmplt +299 -> 369
    //   73: iconst_1
    //   74: istore 8
    //   76: iload 8
    //   78: ifeq +120 -> 198
    //   81: iload 4
    //   83: ifeq +107 -> 190
    //   86: ldc_w 419
    //   89: astore 11
    //   91: aload_0
    //   92: aload 11
    //   94: iconst_3
    //   95: anewarray 61	java/lang/String
    //   98: dup
    //   99: iconst_0
    //   100: iload 5
    //   102: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: iload_1
    //   109: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: iload_1
    //   116: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   119: aastore
    //   120: iload_2
    //   121: invokestatic 421	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   124: astore_0
    //   125: aload_0
    //   126: aload 13
    //   128: iload_1
    //   129: iload_2
    //   130: iload 8
    //   132: aload_3
    //   133: aload 6
    //   135: iload 7
    //   137: invokestatic 424	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   140: aload_0
    //   141: ifnull +9 -> 150
    //   144: aload_0
    //   145: invokeinterface 397 1 0
    //   150: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +34 -> 187
    //   156: ldc 132
    //   158: iconst_2
    //   159: new 134	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 426
    //   169: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokestatic 375	android/os/SystemClock:uptimeMillis	()J
    //   175: lload 9
    //   177: lsub
    //   178: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   181: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 13
    //   189: areturn
    //   190: ldc_w 428
    //   193: astore 11
    //   195: goto -104 -> 91
    //   198: iload 5
    //   200: ifle +88 -> 288
    //   203: new 134	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 430
    //   213: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 5
    //   218: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: ldc_w 432
    //   224: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 65
    //   229: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 11
    //   237: getstatic 163	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   240: invokevirtual 169	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   243: astore 14
    //   245: aload 14
    //   247: ldc 171
    //   249: iload_2
    //   250: bipush 6
    //   252: imul
    //   253: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   256: invokevirtual 180	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   259: pop
    //   260: aload 14
    //   262: invokevirtual 184	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   265: astore 14
    //   267: aload_0
    //   268: invokevirtual 190	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   271: aload 14
    //   273: getstatic 85	com/tencent/mobileqq/utils/AlbumUtil:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   276: aload 11
    //   278: aconst_null
    //   279: ldc 192
    //   281: invokevirtual 198	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   284: astore_0
    //   285: goto -160 -> 125
    //   288: ldc_w 392
    //   291: astore 11
    //   293: goto -56 -> 237
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_0
    //   299: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +14 -> 316
    //   305: ldc 132
    //   307: iconst_2
    //   308: aload_3
    //   309: invokevirtual 404	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: aload_3
    //   313: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload_0
    //   317: ifnull -167 -> 150
    //   320: aload_0
    //   321: invokeinterface 397 1 0
    //   326: goto -176 -> 150
    //   329: astore_0
    //   330: aload 12
    //   332: astore_3
    //   333: aload_3
    //   334: ifnull +9 -> 343
    //   337: aload_3
    //   338: invokeinterface 397 1 0
    //   343: aload_0
    //   344: athrow
    //   345: astore 6
    //   347: aload_0
    //   348: astore_3
    //   349: aload 6
    //   351: astore_0
    //   352: goto -19 -> 333
    //   355: astore 6
    //   357: aload_0
    //   358: astore_3
    //   359: aload 6
    //   361: astore_0
    //   362: goto -29 -> 333
    //   365: astore_3
    //   366: goto -67 -> 299
    //   369: iconst_0
    //   370: istore 8
    //   372: goto -296 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramContext	Context
    //   0	375	1	paramInt1	int
    //   0	375	2	paramInt2	int
    //   0	375	3	paramMediaFileFilter	MediaFileFilter
    //   0	375	4	paramBoolean1	boolean
    //   0	375	5	paramInt3	int
    //   0	375	6	paramArrayList	ArrayList
    //   0	375	7	paramBoolean2	boolean
    //   74	297	8	bool	boolean
    //   3	173	9	l	long
    //   89	203	11	str	String
    //   39	292	12	localObject1	Object
    //   63	125	13	localArrayList	ArrayList
    //   243	29	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   91	125	296	java/lang/Exception
    //   203	237	296	java/lang/Exception
    //   237	285	296	java/lang/Exception
    //   91	125	329	finally
    //   203	237	329	finally
    //   237	285	329	finally
    //   125	140	345	finally
    //   299	316	355	finally
    //   125	140	365	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt, List paramList, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 290	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 291	java/util/ArrayList:<init>	()V
    //   10: astore 5
    //   12: aload_2
    //   13: invokestatic 435	com/tencent/mobileqq/utils/AlbumUtil:a	(Ljava/util/List;)Ljava/lang/String;
    //   16: astore_2
    //   17: getstatic 163	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: invokevirtual 169	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   23: astore 6
    //   25: aload 6
    //   27: ldc 171
    //   29: iload_1
    //   30: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: invokevirtual 180	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   36: pop
    //   37: aload 6
    //   39: invokevirtual 184	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   42: astore 6
    //   44: aload_0
    //   45: invokevirtual 190	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   48: aload 6
    //   50: getstatic 85	com/tencent/mobileqq/utils/AlbumUtil:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   53: aload_2
    //   54: aconst_null
    //   55: ldc 192
    //   57: invokevirtual 198	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore_0
    //   61: aload_0
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_1
    //   66: iconst_0
    //   67: aload_3
    //   68: aconst_null
    //   69: iconst_0
    //   70: invokestatic 424	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   73: aload_0
    //   74: ifnull +9 -> 83
    //   77: aload_0
    //   78: invokeinterface 397 1 0
    //   83: aload 5
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +14 -> 106
    //   95: ldc 132
    //   97: iconst_2
    //   98: aload_2
    //   99: invokevirtual 404	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: aload_2
    //   103: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: ifnull -24 -> 83
    //   110: aload_0
    //   111: invokeinterface 397 1 0
    //   116: aload 5
    //   118: areturn
    //   119: astore_0
    //   120: aload 4
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 397 1 0
    //   133: aload_0
    //   134: athrow
    //   135: astore_3
    //   136: aload_0
    //   137: astore_2
    //   138: aload_3
    //   139: astore_0
    //   140: goto -17 -> 123
    //   143: astore_3
    //   144: aload_0
    //   145: astore_2
    //   146: aload_3
    //   147: astore_0
    //   148: goto -25 -> 123
    //   151: astore_2
    //   152: goto -63 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramContext	Context
    //   0	155	1	paramInt	int
    //   0	155	2	paramList	List
    //   0	155	3	paramMediaFileFilter	MediaFileFilter
    //   1	120	4	localObject1	Object
    //   10	107	5	localArrayList	ArrayList
    //   23	26	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	61	86	java/lang/Exception
    //   44	61	119	finally
    //   61	73	135	finally
    //   89	106	143	finally
    //   61	73	151	java/lang/Exception
  }
  
  /* Error */
  private static List a(Context paramContext, String paramString, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 290	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 291	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 421	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
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
    //   42: invokestatic 439	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 397 1 0
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
    //   71: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +17 -> 91
    //   77: aload_0
    //   78: astore 5
    //   80: ldc 132
    //   82: iconst_2
    //   83: aload_1
    //   84: invokevirtual 404	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: aload_1
    //   88: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_0
    //   92: ifnull -37 -> 55
    //   95: aload_0
    //   96: invokeinterface 397 1 0
    //   101: aload 7
    //   103: areturn
    //   104: astore_1
    //   105: aload 5
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull +9 -> 118
    //   112: aload_0
    //   113: invokeinterface 397 1 0
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -13 -> 108
    //   124: astore_1
    //   125: goto -57 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramString	String
    //   0	128	2	paramInt	int
    //   0	128	3	paramMediaFileFilter	MediaFileFilter
    //   32	28	4	bool	boolean
    //   1	105	5	localContext	Context
    //   4	62	6	localObject	Object
    //   13	89	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	104	finally
    //   71	77	104	finally
    //   80	91	104	finally
    //   23	31	120	finally
    //   34	45	120	finally
    //   23	31	124	java/lang/Exception
    //   34	45	124	java/lang/Exception
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
    //   3: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc 132
    //   11: iconst_2
    //   12: ldc_w 458
    //   15: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: ldc_w 460
    //   21: aload_1
    //   22: invokevirtual 447	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +126 -> 151
    //   28: aload_0
    //   29: invokevirtual 190	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   32: getstatic 390	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   35: getstatic 89	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   38: aconst_null
    //   39: aconst_null
    //   40: ldc 192
    //   42: invokevirtual 198	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 16
    //   47: aload 16
    //   49: astore 17
    //   51: getstatic 59	android/os/Build$VERSION:SDK_INT	I
    //   54: bipush 16
    //   56: if_icmplt +47 -> 103
    //   59: iconst_1
    //   60: istore 15
    //   62: aload 16
    //   64: astore 17
    //   66: aload_0
    //   67: aload 16
    //   69: aconst_null
    //   70: iload_3
    //   71: aload 4
    //   73: iload 15
    //   75: lload 10
    //   77: invokestatic 462	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/ArrayList;
    //   80: astore 18
    //   82: aload 18
    //   84: astore_0
    //   85: aload_0
    //   86: astore_1
    //   87: aload 16
    //   89: ifnull +12 -> 101
    //   92: aload 16
    //   94: invokeinterface 397 1 0
    //   99: aload_0
    //   100: astore_1
    //   101: aload_1
    //   102: areturn
    //   103: iconst_0
    //   104: istore 15
    //   106: goto -44 -> 62
    //   109: astore 18
    //   111: aconst_null
    //   112: astore 16
    //   114: aload 16
    //   116: astore 17
    //   118: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +18 -> 139
    //   124: aload 16
    //   126: astore 17
    //   128: ldc 132
    //   130: iconst_2
    //   131: ldc_w 464
    //   134: aload 18
    //   136: invokestatic 466	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload 16
    //   141: ifnull +10 -> 151
    //   144: aload 16
    //   146: invokeinterface 397 1 0
    //   151: aload 19
    //   153: astore 16
    //   155: aload 4
    //   157: ifnull +36 -> 193
    //   160: aload 19
    //   162: astore 16
    //   164: aload 4
    //   166: invokevirtual 468	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	()Z
    //   169: ifeq +24 -> 193
    //   172: aload_0
    //   173: aload_1
    //   174: aload_2
    //   175: iload_3
    //   176: aload 4
    //   178: iload 5
    //   180: iload 6
    //   182: iload 7
    //   184: aload 8
    //   186: iload 9
    //   188: invokestatic 470	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   191: astore 16
    //   193: aload 4
    //   195: ifnull +462 -> 657
    //   198: aload 4
    //   200: invokevirtual 472	com/tencent/mobileqq/activity/photo/MediaFileFilter:b	()Z
    //   203: ifeq +454 -> 657
    //   206: aload_0
    //   207: aload_1
    //   208: aload_2
    //   209: iload_3
    //   210: aload 4
    //   212: lload 10
    //   214: invokestatic 475	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   217: astore_0
    //   218: ldc_w 444
    //   221: aload_1
    //   222: invokevirtual 447	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifeq +63 -> 288
    //   228: invokestatic 375	android/os/SystemClock:uptimeMillis	()J
    //   231: lstore 10
    //   233: aload 16
    //   235: ifnull +8 -> 243
    //   238: aload 16
    //   240: invokestatic 362	java/util/Collections:sort	(Ljava/util/List;)V
    //   243: aload_0
    //   244: ifnull +7 -> 251
    //   247: aload_0
    //   248: invokestatic 362	java/util/Collections:sort	(Ljava/util/List;)V
    //   251: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +34 -> 288
    //   257: ldc 132
    //   259: iconst_2
    //   260: new 134	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 477
    //   270: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokestatic 375	android/os/SystemClock:uptimeMillis	()J
    //   276: lload 10
    //   278: lsub
    //   279: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: ifnull +12 -> 301
    //   292: aload_0
    //   293: invokeinterface 480 1 0
    //   298: ifeq +24 -> 322
    //   301: aload 16
    //   303: areturn
    //   304: astore_0
    //   305: aconst_null
    //   306: astore 17
    //   308: aload 17
    //   310: ifnull +10 -> 320
    //   313: aload 17
    //   315: invokeinterface 397 1 0
    //   320: aload_0
    //   321: athrow
    //   322: aload_0
    //   323: astore_1
    //   324: aload 16
    //   326: ifnull -225 -> 101
    //   329: aload_0
    //   330: astore_1
    //   331: aload 16
    //   333: invokeinterface 480 1 0
    //   338: ifne -237 -> 101
    //   341: aload 16
    //   343: invokeinterface 226 1 0
    //   348: istore 5
    //   350: iconst_0
    //   351: istore 6
    //   353: iconst_0
    //   354: istore 12
    //   356: iload 12
    //   358: aload_0
    //   359: invokeinterface 226 1 0
    //   364: if_icmpge +266 -> 630
    //   367: aload_0
    //   368: iload 12
    //   370: invokeinterface 413 2 0
    //   375: checkcast 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   378: astore_1
    //   379: aload 16
    //   381: iload 5
    //   383: iconst_1
    //   384: isub
    //   385: invokeinterface 413 2 0
    //   390: checkcast 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   393: astore_2
    //   394: aload_1
    //   395: getfield 346	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   398: aload_2
    //   399: getfield 346	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   402: lcmp
    //   403: ifgt +95 -> 498
    //   406: iload_3
    //   407: iconst_m1
    //   408: if_icmpne +39 -> 447
    //   411: iload 12
    //   413: aload_0
    //   414: invokeinterface 226 1 0
    //   419: if_icmpge +211 -> 630
    //   422: aload 16
    //   424: aload_0
    //   425: iload 12
    //   427: invokeinterface 413 2 0
    //   432: invokeinterface 403 2 0
    //   437: pop
    //   438: iload 12
    //   440: iconst_1
    //   441: iadd
    //   442: istore 12
    //   444: goto -33 -> 411
    //   447: aload_0
    //   448: invokeinterface 226 1 0
    //   453: iload 12
    //   455: isub
    //   456: iload_3
    //   457: iload 5
    //   459: isub
    //   460: invokestatic 410	java/lang/Math:min	(II)I
    //   463: istore 5
    //   465: iconst_0
    //   466: istore_3
    //   467: iload_3
    //   468: iload 5
    //   470: if_icmpge +160 -> 630
    //   473: aload 16
    //   475: aload_0
    //   476: iload_3
    //   477: iload 12
    //   479: iadd
    //   480: invokeinterface 413 2 0
    //   485: invokeinterface 403 2 0
    //   490: pop
    //   491: iload_3
    //   492: iconst_1
    //   493: iadd
    //   494: istore_3
    //   495: goto -28 -> 467
    //   498: iload 6
    //   500: istore 13
    //   502: iload 13
    //   504: iload 5
    //   506: if_icmpge +136 -> 642
    //   509: aload 16
    //   511: iload 13
    //   513: invokeinterface 413 2 0
    //   518: checkcast 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   521: astore_2
    //   522: aload_1
    //   523: getfield 346	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   526: aload_2
    //   527: getfield 346	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   530: lcmp
    //   531: ifgt +12 -> 543
    //   534: iload 13
    //   536: iconst_1
    //   537: iadd
    //   538: istore 13
    //   540: goto -38 -> 502
    //   543: aload 16
    //   545: iload 13
    //   547: aload_1
    //   548: invokeinterface 483 3 0
    //   553: iload_3
    //   554: iconst_m1
    //   555: if_icmpeq +24 -> 579
    //   558: aload 16
    //   560: invokeinterface 226 1 0
    //   565: iload_3
    //   566: if_icmple +13 -> 579
    //   569: aload 16
    //   571: iload 5
    //   573: invokeinterface 486 2 0
    //   578: pop
    //   579: aload 16
    //   581: invokeinterface 226 1 0
    //   586: istore 14
    //   588: iload 5
    //   590: istore 6
    //   592: iload 5
    //   594: iload 14
    //   596: if_icmpeq +7 -> 603
    //   599: iload 14
    //   601: istore 6
    //   603: iload 13
    //   605: iconst_1
    //   606: iadd
    //   607: istore 5
    //   609: iload 12
    //   611: iconst_1
    //   612: iadd
    //   613: istore 12
    //   615: iload 6
    //   617: istore 13
    //   619: iload 5
    //   621: istore 6
    //   623: iload 13
    //   625: istore 5
    //   627: goto -271 -> 356
    //   630: aload 16
    //   632: areturn
    //   633: astore_0
    //   634: goto -326 -> 308
    //   637: astore 18
    //   639: goto -525 -> 114
    //   642: iload 5
    //   644: istore 13
    //   646: iload 6
    //   648: istore 5
    //   650: iload 13
    //   652: istore 6
    //   654: goto -45 -> 609
    //   657: aconst_null
    //   658: astore_0
    //   659: goto -441 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	paramContext	Context
    //   0	662	1	paramString1	String
    //   0	662	2	paramString2	String
    //   0	662	3	paramInt1	int
    //   0	662	4	paramMediaFileFilter	MediaFileFilter
    //   0	662	5	paramInt2	int
    //   0	662	6	paramInt3	int
    //   0	662	7	paramBoolean1	boolean
    //   0	662	8	paramArrayList	ArrayList
    //   0	662	9	paramBoolean2	boolean
    //   0	662	10	paramLong	long
    //   354	260	12	i	int
    //   500	151	13	j	int
    //   586	14	14	k	int
    //   60	45	15	bool	boolean
    //   45	586	16	localObject1	Object
    //   49	265	17	localObject2	Object
    //   80	3	18	localArrayList	ArrayList
    //   109	26	18	localException1	Exception
    //   637	1	18	localException2	Exception
    //   1	160	19	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	47	109	java/lang/Exception
    //   28	47	304	finally
    //   51	59	633	finally
    //   66	82	633	finally
    //   118	124	633	finally
    //   128	139	633	finally
    //   51	59	637	java/lang/Exception
    //   66	82	637	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: ldc_w 444
    //   7: aload_1
    //   8: invokevirtual 447	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: sipush 210
    //   18: iload_3
    //   19: aload 4
    //   21: lload 5
    //   23: invokestatic 488	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   26: areturn
    //   27: new 290	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 291	java/util/ArrayList:<init>	()V
    //   34: astore 8
    //   36: new 134	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 449
    //   46: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 451
    //   56: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 190	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: getstatic 390	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   70: getstatic 89	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   73: aload_1
    //   74: aconst_null
    //   75: ldc 192
    //   77: invokevirtual 198	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   106: invokestatic 294	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   109: pop
    //   110: aload_1
    //   111: ifnull +77 -> 188
    //   114: aload_1
    //   115: invokeinterface 397 1 0
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
    //   134: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +15 -> 152
    //   140: aload_1
    //   141: astore_0
    //   142: ldc 132
    //   144: iconst_2
    //   145: ldc_w 464
    //   148: aload_2
    //   149: invokestatic 466	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload_1
    //   153: ifnull +35 -> 188
    //   156: aload_1
    //   157: invokeinterface 397 1 0
    //   162: aload 8
    //   164: areturn
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +9 -> 178
    //   172: aload_0
    //   173: invokeinterface 397 1 0
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: goto -13 -> 168
    //   184: astore_2
    //   185: goto -53 -> 132
    //   188: aload 8
    //   190: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramContext	Context
    //   0	191	1	paramString1	String
    //   0	191	2	paramString2	String
    //   0	191	3	paramInt	int
    //   0	191	4	paramMediaFileFilter	MediaFileFilter
    //   0	191	5	paramLong	long
    //   92	33	7	bool	boolean
    //   34	155	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   63	81	129	java/lang/Exception
    //   63	81	165	finally
    //   83	91	180	finally
    //   96	110	180	finally
    //   134	140	180	finally
    //   142	152	180	finally
    //   83	91	184	java/lang/Exception
    //   96	110	184	java/lang/Exception
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
              break label547;
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
      label547:
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
    int k;
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
        break label1058;
      }
      k = paramCursor.getColumnIndexOrThrow("width");
    }
    for (int j = paramCursor.getColumnIndexOrThrow("height");; j = 0)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      int i = 0;
      label1049:
      label1056:
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
        for (int m = 1;; m = 0)
        {
          if (m != 0) {
            break label1056;
          }
          Object localObject2 = paramCursor.getString(i6);
          paramList = (List)localObject2;
          if (paramMediaFileFilter != null)
          {
            paramList = (List)localObject2;
            if (paramMediaFileFilter.a((String)localObject2))
            {
              if ((!"*/*".equals(localObject2)) && (!"image/*".equals(localObject2))) {
                break label740;
              }
              if ((str.indexOf(".jpg") == -1) && (str.indexOf(".jpeg") == -1)) {
                break label636;
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
          m = n;
          if (paramBoolean1)
          {
            m = n;
            if (paramCursor.getInt(k) == 0) {
              m = 1;
            }
          }
          long l3 = paramCursor.getLong(i1);
          if ((paramInt1 > 0) && ((!paramBoolean1) || (m != 0)))
          {
            a(str, localOptions, arrayOfInt);
            if ((arrayOfInt[0] < paramInt1) && (arrayOfInt[1] < paramInt1)) {
              break label1049;
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
            if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
              QLog.i("AlbumUtil", 2, "no size " + str);
            }
            ((List)localObject1).add(localObject2);
            i += 1;
          }
          for (;;)
          {
            if ((paramInt2 > 0) && (i >= paramInt2))
            {
              return;
              label636:
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
              label740:
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("AlbumUtil", 2, "Filter unknown " + (String)localObject2 + ", path is " + str);
              break;
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
                ((LocalMediaInfo)localObject2).mediaWidth = paramCursor.getInt(k);
                ((LocalMediaInfo)localObject2).mediaHeight = paramCursor.getInt(j);
              }
              if ((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0))
              {
                a(str, localOptions, arrayOfInt);
                ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
                ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
              }
              if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
                QLog.i("AlbumUtil", 2, "no size " + str);
              }
              ((List)localObject1).add(localObject2);
              i += 1;
              continue;
            }
            break;
          }
        }
      }
      label1058:
      k = 0;
    }
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