package cooperation.qzone.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.ExifInterface;
import android.provider.MediaStore.Images.Media;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PhotoUtils
{
  private static final int CLOSE = 0;
  private static final String IMAGE_ORDER_BY = "date_modified DESC";
  private static final String KEY_NEW_PHOTO_CHECK_LASTTIME = "LocalRecentPhotoCheckManager.new_photo_check_lasttime";
  private static final String[] PROJECTION_IMAGE = { "DISTINCT _data" };
  public static final int RECENT_IMAGE_MIN_SIZE = 20480;
  private static final int SHOW = 4;
  private static final String TAG = "PhotoUtils";
  private static PhotoUtils mInstance;
  static Map<Long, Integer> map = new HashMap();
  private static long uin;
  
  public static void clearNewPicRuleMapCache()
  {
    Map localMap = map;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public static Bitmap decodeBitmapFromFile(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: ifnull +319 -> 326
    //   10: ldc 64
    //   12: aload_0
    //   13: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifne +310 -> 326
    //   19: aload_0
    //   20: invokevirtual 72	java/lang/String:length	()I
    //   23: ifgt +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +5 -> 37
    //   35: aconst_null
    //   36: areturn
    //   37: new 80	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 87	java/io/File:exists	()Z
    //   48: ifne +5 -> 53
    //   51: aconst_null
    //   52: areturn
    //   53: new 89	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 90	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 6
    //   62: aload 6
    //   64: iconst_1
    //   65: putfield 94	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   68: aload_0
    //   69: aload 6
    //   71: invokestatic 100	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   74: pop
    //   75: aload 6
    //   77: iconst_0
    //   78: putfield 94	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   81: iload_1
    //   82: ifeq +265 -> 347
    //   85: iload_2
    //   86: ifeq +261 -> 347
    //   89: iload_3
    //   90: ifeq +24 -> 114
    //   93: aload 6
    //   95: getfield 103	android/graphics/BitmapFactory$Options:outWidth	I
    //   98: iload_1
    //   99: idiv
    //   100: aload 6
    //   102: getfield 106	android/graphics/BitmapFactory$Options:outHeight	I
    //   105: iload_2
    //   106: idiv
    //   107: invokestatic 112	java/lang/Math:max	(II)I
    //   110: istore_1
    //   111: goto +24 -> 135
    //   114: aload 6
    //   116: getfield 103	android/graphics/BitmapFactory$Options:outWidth	I
    //   119: iload_1
    //   120: idiv
    //   121: aload 6
    //   123: getfield 106	android/graphics/BitmapFactory$Options:outHeight	I
    //   126: iload_2
    //   127: idiv
    //   128: invokestatic 115	java/lang/Math:min	(II)I
    //   131: istore_1
    //   132: goto +3 -> 135
    //   135: aload 6
    //   137: iload_1
    //   138: putfield 118	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   141: aload 6
    //   143: iconst_1
    //   144: putfield 121	android/graphics/BitmapFactory$Options:inMutable	Z
    //   147: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   150: bipush 11
    //   152: if_icmplt +15 -> 167
    //   155: aload 4
    //   157: ifnull +10 -> 167
    //   160: aload 6
    //   162: aload 4
    //   164: putfield 130	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   167: new 132	java/io/BufferedInputStream
    //   170: dup
    //   171: new 134	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   179: sipush 4096
    //   182: invokespecial 138	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   185: astore 4
    //   187: aload 4
    //   189: astore 5
    //   191: aload 4
    //   193: aconst_null
    //   194: aload 6
    //   196: invokestatic 142	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   199: astore 8
    //   201: aload 8
    //   203: astore_0
    //   204: aload 4
    //   206: invokevirtual 145	java/io/BufferedInputStream:close	()V
    //   209: aload 8
    //   211: areturn
    //   212: astore 4
    //   214: aload 4
    //   216: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   219: aload_0
    //   220: areturn
    //   221: aconst_null
    //   222: astore 4
    //   224: goto +14 -> 238
    //   227: astore_0
    //   228: goto +76 -> 304
    //   231: aconst_null
    //   232: astore 4
    //   234: aload 4
    //   236: astore 6
    //   238: aload 4
    //   240: astore 5
    //   242: invokestatic 153	java/lang/System:gc	()V
    //   245: aload 4
    //   247: astore 5
    //   249: aload_0
    //   250: aload 6
    //   252: invokestatic 100	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   255: astore_0
    //   256: aload_0
    //   257: astore 5
    //   259: goto +28 -> 287
    //   262: aload 4
    //   264: astore 5
    //   266: ldc 23
    //   268: iconst_1
    //   269: ldc 155
    //   271: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload 4
    //   276: astore 5
    //   278: invokestatic 153	java/lang/System:gc	()V
    //   281: aload 7
    //   283: astore_0
    //   284: goto -28 -> 256
    //   287: aload 4
    //   289: ifnull +11 -> 300
    //   292: aload 5
    //   294: astore_0
    //   295: aload 4
    //   297: invokevirtual 145	java/io/BufferedInputStream:close	()V
    //   300: aload 5
    //   302: areturn
    //   303: astore_0
    //   304: aload 5
    //   306: ifnull +18 -> 324
    //   309: aload 5
    //   311: invokevirtual 145	java/io/BufferedInputStream:close	()V
    //   314: goto +10 -> 324
    //   317: astore 4
    //   319: aload 4
    //   321: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   324: aload_0
    //   325: athrow
    //   326: aconst_null
    //   327: areturn
    //   328: astore 4
    //   330: goto -99 -> 231
    //   333: astore 4
    //   335: goto -114 -> 221
    //   338: astore 5
    //   340: goto -102 -> 238
    //   343: astore_0
    //   344: goto -82 -> 262
    //   347: iconst_1
    //   348: istore_1
    //   349: goto -214 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	paramString	String
    //   0	352	1	paramInt1	int
    //   0	352	2	paramInt2	int
    //   0	352	3	paramBoolean	boolean
    //   0	352	4	paramBitmap	Bitmap
    //   1	309	5	localObject1	Object
    //   338	1	5	localThrowable	Throwable
    //   60	191	6	localObject2	Object
    //   4	278	7	localObject3	Object
    //   199	11	8	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   204	209	212	java/io/IOException
    //   295	300	212	java/io/IOException
    //   53	62	227	finally
    //   62	81	227	finally
    //   93	111	227	finally
    //   114	132	227	finally
    //   135	155	227	finally
    //   160	167	227	finally
    //   167	187	227	finally
    //   191	201	303	finally
    //   242	245	303	finally
    //   249	256	303	finally
    //   266	274	303	finally
    //   278	281	303	finally
    //   309	314	317	java/io/IOException
    //   53	62	328	java/lang/Throwable
    //   62	81	333	java/lang/Throwable
    //   93	111	333	java/lang/Throwable
    //   114	132	333	java/lang/Throwable
    //   135	155	333	java/lang/Throwable
    //   160	167	333	java/lang/Throwable
    //   167	187	333	java/lang/Throwable
    //   191	201	338	java/lang/Throwable
    //   249	256	343	java/lang/Throwable
  }
  
  public static Bitmap decodeBitmapFromFile(String paramString, Bitmap paramBitmap)
  {
    return decodeBitmapFromFile(paramString, 0, 0, false, paramBitmap);
  }
  
  public static PhotoUtils get()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new PhotoUtils();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public static ExifInterface getExif(String paramString)
  {
    try
    {
      if (!JpegExifReader.isCrashJpeg(paramString))
      {
        paramString = new ExifInterface(paramString);
        return paramString;
      }
      return null;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  private long getLastCheckTime()
  {
    return LocalMultiProcConfig.getLong("LocalRecentPhotoCheckManager.new_photo_check_lasttime", 0L);
  }
  
  public static int getPicRotate(String paramString)
  {
    try
    {
      int i = JpegExifReader.readOrientation(paramString);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 270;
        }
        return 90;
      }
      return 180;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static String gpsInfoConvert(double paramDouble)
  {
    String[] arrayOfString = Location.convert(Math.abs(paramDouble), 2).split(":");
    Object localObject = arrayOfString[2].split("\\.");
    if (localObject.length == 0) {
      localObject = arrayOfString[2];
    } else {
      localObject = localObject[0];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(arrayOfString[0]);
    localStringBuilder.append("/1,");
    localStringBuilder.append(arrayOfString[1]);
    localStringBuilder.append("/1,");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/1");
    return localStringBuilder.toString();
  }
  
  public static boolean isCurrentDayInQzone()
  {
    long l = LocalMultiProcConfig.getLong("key_photo_guide_enter_qzone_date", 0L);
    if (l <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
      }
      return false;
    }
    l = System.currentTimeMillis() - l;
    if ((l <= 86400000L) && (l > 0L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isCurrentDayInQzone");
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
    }
    return false;
  }
  
  private static boolean isExifValuable(ExifInterface paramExifInterface)
  {
    if (paramExifInterface == null) {
      return false;
    }
    paramExifInterface = paramExifInterface.getAttribute("DateTime");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FDateTime:");
      localStringBuilder.append(paramExifInterface);
      QLog.d("PhotoUtils", 4, localStringBuilder.toString());
    }
    return paramExifInterface != null;
  }
  
  public static boolean isInCheckTimeQuantum()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_album_photo_show_start_hour", 19);
    int j = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_album_photo_show_end_hour", 22);
    int k = Calendar.getInstance().get(11);
    return (k >= i) && (k < j);
  }
  
  public static boolean isNewPicRule()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    boolean bool = false;
    if (localAppRuntime == null) {
      return false;
    }
    uin = localAppRuntime.getLongAccountUin();
    int i;
    if (map.get(Long.valueOf(uin)) != null)
    {
      i = ((Integer)map.get(Long.valueOf(uin))).intValue();
    }
    else
    {
      i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, uin);
      map.put(Long.valueOf(uin), Integer.valueOf(i));
    }
    if ((i & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isOverLastCheck()
  {
    long l1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadGuideScanTimeInterval", 1) * 60 * 60 * 1000;
    long l2 = LocalMultiProcConfig.getLong("key_photo_guide_last_check", 0L);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KEY_PHOTO_GUIDE_LAST_CHECK get:");
      localStringBuilder.append(l2);
      QLog.d("PhotoUtils", 2, localStringBuilder.toString());
    }
    if (l2 <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck");
      }
      return true;
    }
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isOverLastCheck S-L:");
      localStringBuilder.append(System.currentTimeMillis() - l2);
      QLog.d("PhotoUtils", 4, localStringBuilder.toString());
    }
    if (System.currentTimeMillis() - l2 < l1)
    {
      if (System.currentTimeMillis() - l2 <= 0L) {
        return true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck false");
      }
      return false;
    }
    return true;
  }
  
  private static Cursor queryLatestImageCursor(Context paramContext, int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoChangeStrategy", 1);
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoMinSize", 300);
    long l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoMaxSize", 20000) * 1024;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bucket_display_name");
    ((StringBuilder)localObject).append(" != 'Screenshots' ");
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("_size");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(i * 1024);
    if (paramInt == 1)
    {
      ((StringBuilder)localObject).append(" and ");
      ((StringBuilder)localObject).append("_size");
      ((StringBuilder)localObject).append("<=");
      ((StringBuilder)localObject).append(l);
    }
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(paramLong1 / 1000L);
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(" <= ");
    ((StringBuilder)localObject).append(paramLong2 / 1000L);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      paramContext = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_IMAGE, (String)localObject, null, "date_modified DESC LIMIT 0,50");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label265:
      break label265;
    }
    return null;
  }
  
  /* Error */
  public static ArrayList<String> queryLatestImages(Context paramContext, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: iload_1
    //   8: lload_2
    //   9: lload 4
    //   11: invokestatic 400	cooperation/qzone/util/PhotoUtils:queryLatestImageCursor	(Landroid/content/Context;IJJ)Landroid/database/Cursor;
    //   14: astore 9
    //   16: aload 9
    //   18: invokeinterface 405 1 0
    //   23: istore_1
    //   24: iload_1
    //   25: ifle +238 -> 263
    //   28: new 407	java/util/ArrayList
    //   31: dup
    //   32: iload_1
    //   33: invokespecial 410	java/util/ArrayList:<init>	(I)V
    //   36: astore 10
    //   38: aload 9
    //   40: ldc_w 412
    //   43: invokeinterface 415 2 0
    //   48: istore_1
    //   49: new 407	java/util/ArrayList
    //   52: dup
    //   53: invokespecial 416	java/util/ArrayList:<init>	()V
    //   56: astore_0
    //   57: iload 7
    //   59: ifeq +38 -> 97
    //   62: iload 7
    //   64: iconst_1
    //   65: if_icmpeq +22 -> 87
    //   68: iload 7
    //   70: iconst_2
    //   71: if_icmpeq +6 -> 77
    //   74: goto +30 -> 104
    //   77: ldc_w 418
    //   80: invokestatic 424	cooperation/qzone/util/RecentPhotoManger:getRecentPhotoBlackListPath	(Ljava/lang/String;)Ljava/util/List;
    //   83: astore_0
    //   84: goto +20 -> 104
    //   87: ldc_w 426
    //   90: invokestatic 424	cooperation/qzone/util/RecentPhotoManger:getRecentPhotoBlackListPath	(Ljava/lang/String;)Ljava/util/List;
    //   93: astore_0
    //   94: goto +10 -> 104
    //   97: ldc_w 428
    //   100: invokestatic 424	cooperation/qzone/util/RecentPhotoManger:getRecentPhotoBlackListPath	(Ljava/lang/String;)Ljava/util/List;
    //   103: astore_0
    //   104: invokestatic 266	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   107: ldc_w 268
    //   110: ldc_w 351
    //   113: iconst_1
    //   114: invokevirtual 274	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   117: istore 7
    //   119: aload 10
    //   121: astore 8
    //   123: aload 9
    //   125: invokeinterface 431 1 0
    //   130: ifeq +136 -> 266
    //   133: aload 9
    //   135: iload_1
    //   136: invokeinterface 435 2 0
    //   141: astore 8
    //   143: aload 8
    //   145: ifnull -26 -> 119
    //   148: aload_0
    //   149: aload 8
    //   151: invokeinterface 440 2 0
    //   156: ifeq +6 -> 162
    //   159: goto -40 -> 119
    //   162: new 80	java/io/File
    //   165: dup
    //   166: aload 8
    //   168: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: astore 11
    //   173: aload 11
    //   175: invokevirtual 87	java/io/File:exists	()Z
    //   178: ifeq -59 -> 119
    //   181: aload 11
    //   183: invokevirtual 443	java/io/File:isDirectory	()Z
    //   186: ifeq +6 -> 192
    //   189: goto -70 -> 119
    //   192: iload 7
    //   194: ifne +17 -> 211
    //   197: aload 8
    //   199: invokestatic 445	cooperation/qzone/util/PhotoUtils:getExif	(Ljava/lang/String;)Landroid/media/ExifInterface;
    //   202: invokestatic 447	cooperation/qzone/util/PhotoUtils:isExifValuable	(Landroid/media/ExifInterface;)Z
    //   205: ifne +6 -> 211
    //   208: goto -89 -> 119
    //   211: aload 10
    //   213: aload 8
    //   215: invokevirtual 450	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: aload 10
    //   221: invokevirtual 453	java/util/ArrayList:size	()I
    //   224: iload 6
    //   226: if_icmplt -107 -> 119
    //   229: aload 10
    //   231: astore 8
    //   233: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   236: ifeq +30 -> 266
    //   239: ldc 23
    //   241: iconst_4
    //   242: ldc_w 455
    //   245: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload 10
    //   250: astore 8
    //   252: goto +14 -> 266
    //   255: astore 8
    //   257: aload 10
    //   259: astore_0
    //   260: goto +45 -> 305
    //   263: aconst_null
    //   264: astore 8
    //   266: aload 8
    //   268: astore 10
    //   270: aload 9
    //   272: ifnull +86 -> 358
    //   275: aload 8
    //   277: astore 10
    //   279: aload 9
    //   281: invokeinterface 456 1 0
    //   286: aload 8
    //   288: areturn
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   294: aload 10
    //   296: areturn
    //   297: astore_0
    //   298: goto +63 -> 361
    //   301: astore 8
    //   303: aconst_null
    //   304: astore_0
    //   305: aload 8
    //   307: astore 10
    //   309: goto +19 -> 328
    //   312: astore_0
    //   313: aload 8
    //   315: astore 9
    //   317: goto +44 -> 361
    //   320: astore 10
    //   322: aconst_null
    //   323: astore_0
    //   324: aload 11
    //   326: astore 9
    //   328: aload 9
    //   330: astore 8
    //   332: aload 10
    //   334: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   337: aload_0
    //   338: astore 10
    //   340: aload 9
    //   342: ifnull +16 -> 358
    //   345: aload_0
    //   346: astore 10
    //   348: aload 9
    //   350: invokeinterface 456 1 0
    //   355: aload_0
    //   356: astore 10
    //   358: aload 10
    //   360: areturn
    //   361: aload 9
    //   363: ifnull +20 -> 383
    //   366: aload 9
    //   368: invokeinterface 456 1 0
    //   373: goto +10 -> 383
    //   376: astore 8
    //   378: aload 8
    //   380: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   383: goto +5 -> 388
    //   386: aload_0
    //   387: athrow
    //   388: goto -2 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramContext	Context
    //   0	391	1	paramInt1	int
    //   0	391	2	paramLong1	long
    //   0	391	4	paramLong2	long
    //   0	391	6	paramInt2	int
    //   0	391	7	paramInt3	int
    //   4	247	8	localObject1	Object
    //   255	1	8	localException1	Exception
    //   264	23	8	localArrayList	ArrayList<String>
    //   301	13	8	localException2	Exception
    //   330	1	8	localObject2	Object
    //   376	3	8	localException3	Exception
    //   14	353	9	localObject3	Object
    //   36	272	10	localObject4	Object
    //   320	13	10	localException4	Exception
    //   338	21	10	localContext	Context
    //   1	324	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	57	255	java/lang/Exception
    //   77	84	255	java/lang/Exception
    //   87	94	255	java/lang/Exception
    //   97	104	255	java/lang/Exception
    //   104	119	255	java/lang/Exception
    //   123	143	255	java/lang/Exception
    //   148	159	255	java/lang/Exception
    //   162	189	255	java/lang/Exception
    //   197	208	255	java/lang/Exception
    //   211	229	255	java/lang/Exception
    //   233	248	255	java/lang/Exception
    //   279	286	289	java/lang/Exception
    //   348	355	289	java/lang/Exception
    //   16	24	297	finally
    //   28	38	297	finally
    //   38	57	297	finally
    //   77	84	297	finally
    //   87	94	297	finally
    //   97	104	297	finally
    //   104	119	297	finally
    //   123	143	297	finally
    //   148	159	297	finally
    //   162	189	297	finally
    //   197	208	297	finally
    //   211	229	297	finally
    //   233	248	297	finally
    //   16	24	301	java/lang/Exception
    //   28	38	301	java/lang/Exception
    //   6	16	312	finally
    //   332	337	312	finally
    //   6	16	320	java/lang/Exception
    //   366	373	376	java/lang/Exception
  }
  
  /* Error */
  public static boolean saveBitmapToFile(Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 80	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aload 7
    //   12: invokevirtual 87	java/io/File:exists	()Z
    //   15: ifne +23 -> 38
    //   18: aload 7
    //   20: invokevirtual 463	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: goto +14 -> 38
    //   27: astore_1
    //   28: ldc 23
    //   30: iconst_1
    //   31: ldc_w 465
    //   34: aload_1
    //   35: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 5
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore_1
    //   49: new 471	java/io/BufferedOutputStream
    //   52: dup
    //   53: new 473	java/io/FileOutputStream
    //   56: dup
    //   57: aload 7
    //   59: invokespecial 476	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 479	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore 7
    //   67: aload_0
    //   68: aload_2
    //   69: iload_3
    //   70: aload 7
    //   72: invokevirtual 485	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   75: istore 6
    //   77: iload 6
    //   79: istore 5
    //   81: aload 7
    //   83: invokevirtual 488	java/io/BufferedOutputStream:flush	()V
    //   86: iload 4
    //   88: ifeq +11 -> 99
    //   91: iload 6
    //   93: istore 5
    //   95: aload_0
    //   96: invokevirtual 491	android/graphics/Bitmap:recycle	()V
    //   99: iload 6
    //   101: istore 4
    //   103: aload 7
    //   105: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   108: iload 6
    //   110: ireturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   116: iload 4
    //   118: ireturn
    //   119: astore_0
    //   120: aload 7
    //   122: astore_1
    //   123: goto +49 -> 172
    //   126: astore_2
    //   127: aload 7
    //   129: astore_0
    //   130: goto +15 -> 145
    //   133: astore_0
    //   134: goto +38 -> 172
    //   137: astore_2
    //   138: iload 6
    //   140: istore 5
    //   142: aload 8
    //   144: astore_0
    //   145: aload_0
    //   146: astore_1
    //   147: ldc 23
    //   149: iconst_1
    //   150: ldc_w 494
    //   153: aload_2
    //   154: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_0
    //   158: ifnull +11 -> 169
    //   161: iload 5
    //   163: istore 4
    //   165: aload_0
    //   166: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   169: iload 5
    //   171: ireturn
    //   172: aload_1
    //   173: ifnull +15 -> 188
    //   176: aload_1
    //   177: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   180: goto +8 -> 188
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   188: aload_0
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramBitmap	Bitmap
    //   0	190	1	paramString	String
    //   0	190	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	190	3	paramInt	int
    //   0	190	4	paramBoolean	boolean
    //   42	128	5	bool1	boolean
    //   39	100	6	bool2	boolean
    //   8	120	7	localObject1	Object
    //   45	98	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	24	27	java/lang/Exception
    //   103	108	111	java/io/IOException
    //   165	169	111	java/io/IOException
    //   67	77	119	finally
    //   81	86	119	finally
    //   95	99	119	finally
    //   67	77	126	java/lang/Exception
    //   81	86	126	java/lang/Exception
    //   95	99	126	java/lang/Exception
    //   49	67	133	finally
    //   147	157	133	finally
    //   49	67	137	java/lang/Exception
    //   176	180	183	java/io/IOException
  }
  
  public boolean checkNewImages()
  {
    if ((QzoneConfig.getInstance().getConfig("PhotoUpload", "GuideShowOpen", 7) & 0x4) == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "showGuide == CLOSE");
      }
      return false;
    }
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoMinCount", 10);
    long l4 = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoTimeRange", 6) * 60 * 60 * 1000;
    long l3 = getLastCheckTime();
    long l2 = System.currentTimeMillis();
    long l1;
    if (l3 != 0L)
    {
      l1 = l3;
      if (l2 >= l3) {}
    }
    else
    {
      l1 = l2;
    }
    if (l1 == l2) {
      l1 = l2 - l4;
    } else {
      l1 = Math.max(l1, l2 - l4);
    }
    if (l1 != l2 - l4)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l4);
        ((StringBuilder)localObject).append("秒以内");
        QLog.d("PhotoUtils", 4, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("filterTime:");
      ((StringBuilder)localObject).append(l1);
      QLog.d("PhotoUtils", 4, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("nowTime:");
      ((StringBuilder)localObject).append(l2);
      QLog.d("PhotoUtils", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = queryLatestImages(BaseApplication.getContext(), 20480, l1, l2, i, 0);
    if ((localObject != null) && (((ArrayList)localObject).size() >= i))
    {
      LocalMultiProcConfig.putLong("key_photo_guide_first_photo", new File((String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).lastModified());
      return true;
    }
    if (localObject == null)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("PhotoUtils", 4, "no pics");
        return false;
      }
    }
    else if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pics count:");
      localStringBuilder.append(((ArrayList)localObject).size());
      QLog.d("PhotoUtils", 4, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */