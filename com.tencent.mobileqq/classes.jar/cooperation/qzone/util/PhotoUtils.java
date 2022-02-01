package cooperation.qzone.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.ExifInterface;
import android.provider.MediaStore.Images.Media;
import com.tencent.common.app.BaseApplicationImpl;
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
    if (map != null) {
      map.clear();
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public static Bitmap decodeBitmapFromFile(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aload 8
    //   11: astore 7
    //   13: aload_0
    //   14: ifnull +27 -> 41
    //   17: aload 8
    //   19: astore 7
    //   21: ldc 64
    //   23: aload_0
    //   24: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifne +14 -> 41
    //   30: aload_0
    //   31: invokevirtual 72	java/lang/String:length	()I
    //   34: ifgt +10 -> 44
    //   37: aload 8
    //   39: astore 7
    //   41: aload 7
    //   43: areturn
    //   44: aload 8
    //   46: astore 7
    //   48: aload_0
    //   49: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne -11 -> 41
    //   55: aload 8
    //   57: astore 7
    //   59: new 80	java/io/File
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: invokevirtual 87	java/io/File:exists	()Z
    //   70: ifeq -29 -> 41
    //   73: new 89	android/graphics/BitmapFactory$Options
    //   76: dup
    //   77: invokespecial 90	android/graphics/BitmapFactory$Options:<init>	()V
    //   80: astore 8
    //   82: aload 8
    //   84: iconst_1
    //   85: putfield 94	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   88: aload_0
    //   89: aload 8
    //   91: invokestatic 100	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   94: pop
    //   95: aload 8
    //   97: iconst_0
    //   98: putfield 94	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   101: iload 6
    //   103: istore 5
    //   105: iload_1
    //   106: ifeq +34 -> 140
    //   109: iload 6
    //   111: istore 5
    //   113: iload_2
    //   114: ifeq +26 -> 140
    //   117: iload_3
    //   118: ifeq +116 -> 234
    //   121: aload 8
    //   123: getfield 103	android/graphics/BitmapFactory$Options:outWidth	I
    //   126: iload_1
    //   127: idiv
    //   128: aload 8
    //   130: getfield 106	android/graphics/BitmapFactory$Options:outHeight	I
    //   133: iload_2
    //   134: idiv
    //   135: invokestatic 112	java/lang/Math:max	(II)I
    //   138: istore 5
    //   140: aload 8
    //   142: iload 5
    //   144: putfield 115	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   147: aload 8
    //   149: iconst_1
    //   150: putfield 118	android/graphics/BitmapFactory$Options:inMutable	Z
    //   153: getstatic 123	android/os/Build$VERSION:SDK_INT	I
    //   156: bipush 11
    //   158: if_icmplt +15 -> 173
    //   161: aload 4
    //   163: ifnull +10 -> 173
    //   166: aload 8
    //   168: aload 4
    //   170: putfield 127	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   173: new 129	java/io/BufferedInputStream
    //   176: dup
    //   177: new 131	java/io/FileInputStream
    //   180: dup
    //   181: aload_0
    //   182: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   185: sipush 4096
    //   188: invokespecial 135	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   191: astore 4
    //   193: aload 4
    //   195: astore 7
    //   197: aload 4
    //   199: aconst_null
    //   200: aload 8
    //   202: invokestatic 139	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   205: astore 10
    //   207: aload 10
    //   209: astore_0
    //   210: aload_0
    //   211: astore 7
    //   213: aload 4
    //   215: ifnull -174 -> 41
    //   218: aload 4
    //   220: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   223: aload_0
    //   224: areturn
    //   225: astore 4
    //   227: aload 4
    //   229: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: areturn
    //   234: aload 8
    //   236: getfield 103	android/graphics/BitmapFactory$Options:outWidth	I
    //   239: iload_1
    //   240: idiv
    //   241: aload 8
    //   243: getfield 106	android/graphics/BitmapFactory$Options:outHeight	I
    //   246: iload_2
    //   247: idiv
    //   248: invokestatic 148	java/lang/Math:min	(II)I
    //   251: istore 5
    //   253: goto -113 -> 140
    //   256: astore 4
    //   258: aconst_null
    //   259: astore 4
    //   261: aconst_null
    //   262: astore 8
    //   264: aload 4
    //   266: astore 7
    //   268: invokestatic 153	java/lang/System:gc	()V
    //   271: aload 4
    //   273: astore 7
    //   275: aload_0
    //   276: aload 8
    //   278: invokestatic 100	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   281: astore_0
    //   282: aload_0
    //   283: astore 7
    //   285: aload 4
    //   287: ifnull -246 -> 41
    //   290: aload 4
    //   292: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   295: aload_0
    //   296: areturn
    //   297: astore 4
    //   299: aload 4
    //   301: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   304: aload_0
    //   305: areturn
    //   306: astore_0
    //   307: aload 4
    //   309: astore 7
    //   311: ldc 23
    //   313: iconst_1
    //   314: ldc 155
    //   316: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 4
    //   321: astore 7
    //   323: invokestatic 153	java/lang/System:gc	()V
    //   326: aload 9
    //   328: astore_0
    //   329: goto -47 -> 282
    //   332: astore_0
    //   333: aload 7
    //   335: ifnull +8 -> 343
    //   338: aload 7
    //   340: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   343: aload_0
    //   344: athrow
    //   345: astore 4
    //   347: aload 4
    //   349: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   352: goto -9 -> 343
    //   355: astore_0
    //   356: aconst_null
    //   357: astore 7
    //   359: goto -26 -> 333
    //   362: astore 4
    //   364: aconst_null
    //   365: astore 4
    //   367: goto -103 -> 264
    //   370: astore 7
    //   372: goto -108 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString	String
    //   0	375	1	paramInt1	int
    //   0	375	2	paramInt2	int
    //   0	375	3	paramBoolean	boolean
    //   0	375	4	paramBitmap	Bitmap
    //   103	149	5	i	int
    //   1	109	6	j	int
    //   11	347	7	localObject1	Object
    //   370	1	7	localThrowable	Throwable
    //   7	270	8	localOptions	android.graphics.BitmapFactory.Options
    //   4	323	9	localObject2	Object
    //   205	3	10	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   218	223	225	java/io/IOException
    //   73	82	256	java/lang/Throwable
    //   290	295	297	java/io/IOException
    //   275	282	306	java/lang/Throwable
    //   197	207	332	finally
    //   268	271	332	finally
    //   275	282	332	finally
    //   311	319	332	finally
    //   323	326	332	finally
    //   338	343	345	java/io/IOException
    //   73	82	355	finally
    //   82	101	355	finally
    //   121	140	355	finally
    //   140	161	355	finally
    //   166	173	355	finally
    //   173	193	355	finally
    //   234	253	355	finally
    //   82	101	362	java/lang/Throwable
    //   121	140	362	java/lang/Throwable
    //   140	161	362	java/lang/Throwable
    //   166	173	362	java/lang/Throwable
    //   173	193	362	java/lang/Throwable
    //   234	253	362	java/lang/Throwable
    //   197	207	370	java/lang/Throwable
  }
  
  public static Bitmap decodeBitmapFromFile(String paramString, Bitmap paramBitmap)
  {
    return decodeBitmapFromFile(paramString, 0, 0, false, paramBitmap);
  }
  
  public static PhotoUtils get()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new PhotoUtils();
      }
      return mInstance;
    }
    finally {}
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
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
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
    if (localObject.length == 0) {}
    for (localObject = arrayOfString[2];; localObject = localObject[0]) {
      return arrayOfString[0] + "/1," + arrayOfString[1] + "/1," + (String)localObject + "/1";
    }
  }
  
  public static boolean isCurrentDayInQzone()
  {
    long l = LocalMultiProcConfig.getLong("key_photo_guide_enter_qzone_date", 0L);
    if (l <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
      }
    }
    do
    {
      return false;
      l = System.currentTimeMillis() - l;
      if ((l <= 86400000L) && (l > 0L)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isCurrentDayInQzone");
    }
    return true;
  }
  
  private static boolean isExifValuable(ExifInterface paramExifInterface)
  {
    if (paramExifInterface == null) {}
    do
    {
      return false;
      paramExifInterface = paramExifInterface.getAttribute("DateTime");
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "FDateTime:" + paramExifInterface);
      }
    } while (paramExifInterface == null);
    return true;
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
    uin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    int i;
    if (map.get(Long.valueOf(uin)) != null) {
      i = ((Integer)map.get(Long.valueOf(uin))).intValue();
    }
    while ((i & 0x2) != 0)
    {
      return true;
      i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, uin);
      map.put(Long.valueOf(uin), Integer.valueOf(i));
    }
    return false;
  }
  
  public static boolean isOverLastCheck()
  {
    long l1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadGuideScanTimeInterval", 1) * 60 * 60 * 1000;
    long l2 = LocalMultiProcConfig.getLong("key_photo_guide_last_check", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "KEY_PHOTO_GUIDE_LAST_CHECK get:" + l2);
    }
    if (l2 <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck");
      }
    }
    do
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck S-L:" + (System.currentTimeMillis() - l2));
      }
    } while ((System.currentTimeMillis() - l2 >= l1) || (System.currentTimeMillis() - l2 <= 0L));
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isOverLastCheck false");
    }
    return false;
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
    catch (Throwable paramContext) {}
    return null;
  }
  
  /* Error */
  public static ArrayList<String> queryLatestImages(Context paramContext, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: lload_2
    //   3: lload 4
    //   5: invokestatic 400	cooperation/qzone/util/PhotoUtils:queryLatestImageCursor	(Landroid/content/Context;IJJ)Landroid/database/Cursor;
    //   8: astore_0
    //   9: aload_0
    //   10: invokeinterface 405 1 0
    //   15: istore_1
    //   16: iload_1
    //   17: ifle +372 -> 389
    //   20: new 407	java/util/ArrayList
    //   23: dup
    //   24: iload_1
    //   25: invokespecial 410	java/util/ArrayList:<init>	(I)V
    //   28: astore 9
    //   30: aload_0
    //   31: ldc_w 412
    //   34: invokeinterface 415 2 0
    //   39: istore_1
    //   40: new 407	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 416	java/util/ArrayList:<init>	()V
    //   47: astore 8
    //   49: iload 7
    //   51: tableswitch	default:+344 -> 395, 0:+181->232, 1:+192->243, 2:+203->254
    //   77: aconst_null
    //   78: lconst_1
    //   79: ldc_w 268
    //   82: ldc_w 351
    //   85: iconst_1
    //   86: invokevirtual 274	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   89: istore 7
    //   91: aload_0
    //   92: invokeinterface 419 1 0
    //   97: ifeq +285 -> 382
    //   100: aload_0
    //   101: iload_1
    //   102: invokeinterface 423 2 0
    //   107: astore 10
    //   109: aload 10
    //   111: ifnull -20 -> 91
    //   114: aload 8
    //   116: aload 10
    //   118: invokeinterface 428 2 0
    //   123: ifne -32 -> 91
    //   126: new 80	java/io/File
    //   129: dup
    //   130: aload 10
    //   132: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   135: astore 11
    //   137: aload 11
    //   139: ifnull -48 -> 91
    //   142: aload 11
    //   144: invokevirtual 87	java/io/File:exists	()Z
    //   147: ifeq -56 -> 91
    //   150: aload 11
    //   152: invokevirtual 431	java/io/File:isDirectory	()Z
    //   155: ifne -64 -> 91
    //   158: iload 7
    //   160: ifne +14 -> 174
    //   163: aload 10
    //   165: invokestatic 433	cooperation/qzone/util/PhotoUtils:getExif	(Ljava/lang/String;)Landroid/media/ExifInterface;
    //   168: invokestatic 435	cooperation/qzone/util/PhotoUtils:isExifValuable	(Landroid/media/ExifInterface;)Z
    //   171: ifeq -80 -> 91
    //   174: aload 9
    //   176: aload 10
    //   178: invokevirtual 438	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 9
    //   184: invokevirtual 441	java/util/ArrayList:size	()I
    //   187: iload 6
    //   189: if_icmplt -98 -> 91
    //   192: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   195: ifeq +187 -> 382
    //   198: ldc 23
    //   200: iconst_4
    //   201: ldc_w 443
    //   204: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 9
    //   209: astore 8
    //   211: aload 8
    //   213: astore 9
    //   215: aload_0
    //   216: ifnull +13 -> 229
    //   219: aload_0
    //   220: invokeinterface 444 1 0
    //   225: aload 8
    //   227: astore 9
    //   229: aload 9
    //   231: areturn
    //   232: ldc_w 446
    //   235: invokestatic 452	cooperation/qzone/util/RecentPhotoManger:getRecentPhotoBlackListPath	(Ljava/lang/String;)Ljava/util/List;
    //   238: astore 8
    //   240: goto -164 -> 76
    //   243: ldc_w 454
    //   246: invokestatic 452	cooperation/qzone/util/RecentPhotoManger:getRecentPhotoBlackListPath	(Ljava/lang/String;)Ljava/util/List;
    //   249: astore 8
    //   251: goto -175 -> 76
    //   254: ldc_w 456
    //   257: invokestatic 452	cooperation/qzone/util/RecentPhotoManger:getRecentPhotoBlackListPath	(Ljava/lang/String;)Ljava/util/List;
    //   260: astore 8
    //   262: goto -186 -> 76
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   270: aload 8
    //   272: areturn
    //   273: astore 9
    //   275: aconst_null
    //   276: astore_0
    //   277: aconst_null
    //   278: astore 8
    //   280: aload 9
    //   282: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   285: aload_0
    //   286: astore 9
    //   288: aload 8
    //   290: ifnull -61 -> 229
    //   293: aload 8
    //   295: invokeinterface 444 1 0
    //   300: aload_0
    //   301: areturn
    //   302: astore 8
    //   304: aload 8
    //   306: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   309: aload_0
    //   310: areturn
    //   311: astore 8
    //   313: aconst_null
    //   314: astore_0
    //   315: aload_0
    //   316: ifnull +9 -> 325
    //   319: aload_0
    //   320: invokeinterface 444 1 0
    //   325: aload 8
    //   327: athrow
    //   328: astore_0
    //   329: aload_0
    //   330: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   333: goto -8 -> 325
    //   336: astore 8
    //   338: goto -23 -> 315
    //   341: astore 9
    //   343: aload 8
    //   345: astore_0
    //   346: aload 9
    //   348: astore 8
    //   350: goto -35 -> 315
    //   353: astore 9
    //   355: aconst_null
    //   356: astore 10
    //   358: aload_0
    //   359: astore 8
    //   361: aload 10
    //   363: astore_0
    //   364: goto -84 -> 280
    //   367: astore 10
    //   369: aload_0
    //   370: astore 8
    //   372: aload 9
    //   374: astore_0
    //   375: aload 10
    //   377: astore 9
    //   379: goto -99 -> 280
    //   382: aload 9
    //   384: astore 8
    //   386: goto -175 -> 211
    //   389: aconst_null
    //   390: astore 8
    //   392: goto -181 -> 211
    //   395: goto -319 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	paramContext	Context
    //   0	398	1	paramInt1	int
    //   0	398	2	paramLong1	long
    //   0	398	4	paramLong2	long
    //   0	398	6	paramInt2	int
    //   0	398	7	paramInt3	int
    //   47	247	8	localObject1	Object
    //   302	3	8	localException1	Exception
    //   311	15	8	localObject2	Object
    //   336	8	8	localObject3	Object
    //   348	43	8	localObject4	Object
    //   28	202	9	localObject5	Object
    //   273	8	9	localException2	Exception
    //   286	1	9	localContext	Context
    //   341	6	9	localObject6	Object
    //   353	20	9	localException3	Exception
    //   377	6	9	localObject7	Object
    //   107	255	10	str	String
    //   367	9	10	localException4	Exception
    //   135	16	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   219	225	265	java/lang/Exception
    //   0	9	273	java/lang/Exception
    //   293	300	302	java/lang/Exception
    //   0	9	311	finally
    //   319	325	328	java/lang/Exception
    //   9	16	336	finally
    //   20	30	336	finally
    //   30	49	336	finally
    //   76	91	336	finally
    //   91	109	336	finally
    //   114	137	336	finally
    //   142	158	336	finally
    //   163	174	336	finally
    //   174	207	336	finally
    //   232	240	336	finally
    //   243	251	336	finally
    //   254	262	336	finally
    //   280	285	341	finally
    //   9	16	353	java/lang/Exception
    //   20	30	353	java/lang/Exception
    //   30	49	367	java/lang/Exception
    //   76	91	367	java/lang/Exception
    //   91	109	367	java/lang/Exception
    //   114	137	367	java/lang/Exception
    //   142	158	367	java/lang/Exception
    //   163	174	367	java/lang/Exception
    //   174	207	367	java/lang/Exception
    //   232	240	367	java/lang/Exception
    //   243	251	367	java/lang/Exception
    //   254	262	367	java/lang/Exception
  }
  
  /* Error */
  public static boolean saveBitmapToFile(Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 80	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 87	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 463	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: new 465	java/io/BufferedOutputStream
    //   24: dup
    //   25: new 467	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 470	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 473	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore_1
    //   41: aload_0
    //   42: aload_2
    //   43: iload_3
    //   44: aload 7
    //   46: invokevirtual 479	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   49: istore 5
    //   51: aload 7
    //   53: astore_1
    //   54: aload 7
    //   56: invokevirtual 482	java/io/BufferedOutputStream:flush	()V
    //   59: iload 4
    //   61: ifeq +10 -> 71
    //   64: aload 7
    //   66: astore_1
    //   67: aload_0
    //   68: invokevirtual 485	android/graphics/Bitmap:recycle	()V
    //   71: iload 5
    //   73: istore 6
    //   75: aload 7
    //   77: ifnull +12 -> 89
    //   80: aload 7
    //   82: invokevirtual 486	java/io/BufferedOutputStream:close	()V
    //   85: iload 5
    //   87: istore 6
    //   89: iload 6
    //   91: ireturn
    //   92: astore 7
    //   94: ldc 23
    //   96: iconst_1
    //   97: ldc_w 488
    //   100: aload 7
    //   102: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: goto -84 -> 21
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   113: iload 5
    //   115: ireturn
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_2
    //   119: iconst_0
    //   120: istore 4
    //   122: aload_2
    //   123: astore_1
    //   124: ldc 23
    //   126: iconst_1
    //   127: ldc_w 494
    //   130: aload_0
    //   131: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: iload 4
    //   136: istore 6
    //   138: aload_2
    //   139: ifnull -50 -> 89
    //   142: aload_2
    //   143: invokevirtual 486	java/io/BufferedOutputStream:close	()V
    //   146: iload 4
    //   148: ireturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   154: iload 4
    //   156: ireturn
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 486	java/io/BufferedOutputStream:close	()V
    //   168: aload_0
    //   169: athrow
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   175: goto -7 -> 168
    //   178: astore_0
    //   179: goto -19 -> 160
    //   182: astore_0
    //   183: iconst_0
    //   184: istore 4
    //   186: aload 7
    //   188: astore_2
    //   189: goto -67 -> 122
    //   192: astore_0
    //   193: iload 5
    //   195: istore 4
    //   197: aload 7
    //   199: astore_2
    //   200: goto -78 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramBitmap	Bitmap
    //   0	203	1	paramString	String
    //   0	203	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	203	3	paramInt	int
    //   0	203	4	paramBoolean	boolean
    //   49	145	5	bool1	boolean
    //   73	64	6	bool2	boolean
    //   36	45	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   92	106	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	21	92	java/lang/Exception
    //   80	85	108	java/io/IOException
    //   21	38	116	java/lang/Exception
    //   142	146	149	java/io/IOException
    //   21	38	157	finally
    //   164	168	170	java/io/IOException
    //   41	51	178	finally
    //   54	59	178	finally
    //   67	71	178	finally
    //   124	134	178	finally
    //   41	51	182	java/lang/Exception
    //   54	59	192	java/lang/Exception
    //   67	71	192	java/lang/Exception
  }
  
  public boolean checkNewImages()
  {
    if ((QzoneConfig.getInstance().getConfig("PhotoUpload", "GuideShowOpen", 7) & 0x4) == 0) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "showGuide == CLOSE");
      }
    }
    label181:
    ArrayList localArrayList;
    do
    {
      do
      {
        return false;
        int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoMinCount", 10);
        long l4 = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoTimeRange", 6) * 60 * 60 * 1000;
        long l3 = getLastCheckTime();
        long l2 = System.currentTimeMillis();
        if (l3 != 0L)
        {
          l1 = l3;
          if (l2 >= l3) {}
        }
        else
        {
          l1 = l2;
        }
        if (l1 == l2) {}
        for (long l1 = l2 - l4;; l1 = Math.max(l1, l2 - l4))
        {
          if (l1 == l2 - l4) {
            break label181;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("PhotoUtils", 4, l4 + "秒以内");
          return false;
        }
        if (QLog.isDevelopLevel())
        {
          QLog.d("PhotoUtils", 4, "filterTime:" + l1);
          QLog.d("PhotoUtils", 4, "nowTime:" + l2);
        }
        localArrayList = queryLatestImages(BaseApplication.getContext(), 20480, l1, l2, i, 0);
        if ((localArrayList != null) && (localArrayList.size() >= i))
        {
          LocalMultiProcConfig.putLong("key_photo_guide_first_photo", new File((String)localArrayList.get(localArrayList.size() - 1)).lastModified());
          return true;
        }
        if (localArrayList != null) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("PhotoUtils", 4, "no pics");
      return false;
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "pics count:" + localArrayList.size());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */