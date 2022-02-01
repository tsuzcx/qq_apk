package cooperation.qzone.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.File;
import mqq.app.MobileQQ;

public class MediaUtil
{
  private static final int REQUEST_STORAGE = 1;
  private static final String TAG = "MediaUtil";
  
  public static String getCameraPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QZoneFilePath.DCIM_CAMERA_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static Activity getRealActivity(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    return localActivity;
  }
  
  public static boolean saveBitmapToSystemAlbumJpg(Activity paramActivity, Bitmap paramBitmap, int paramInt, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 23)
    {
      bool1 = bool2;
      if (paramActivity != null) {
        bool1 = QZonePermission.requestStoragePermission(paramActivity, new MediaUtil.2(paramBitmap, paramInt, paramString, paramActivity), 1);
      }
    }
    if (bool1) {
      return saveBitmapToSystemAlbumJpg(paramBitmap, paramInt, paramString);
    }
    return false;
  }
  
  /* Error */
  private static boolean saveBitmapToSystemAlbumJpg(Bitmap paramBitmap, int paramInt, String paramString)
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getstatic 41	cooperation/qzone/cache/QZoneFilePath:DCIM_CAMERA_PATH	Ljava/lang/String;
    //   12: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: getstatic 50	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: aload_2
    //   26: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: new 47	java/io/File
    //   33: dup
    //   34: aload_3
    //   35: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 5
    //   43: aload 5
    //   45: invokevirtual 88	java/io/File:exists	()Z
    //   48: ifne +136 -> 184
    //   51: aload_0
    //   52: ifnonnull +5 -> 57
    //   55: iconst_0
    //   56: ireturn
    //   57: aconst_null
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_3
    //   62: aload_3
    //   63: astore_2
    //   64: aload 5
    //   66: invokevirtual 91	java/io/File:createNewFile	()Z
    //   69: ifne +5 -> 74
    //   72: iconst_0
    //   73: ireturn
    //   74: aload_3
    //   75: astore_2
    //   76: new 93	java/io/BufferedOutputStream
    //   79: dup
    //   80: new 95	java/io/FileOutputStream
    //   83: dup
    //   84: aload 5
    //   86: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 101	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   92: astore_3
    //   93: aload_0
    //   94: getstatic 107	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: iload_1
    //   98: aload_3
    //   99: invokevirtual 113	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   102: pop
    //   103: new 115	android/content/Intent
    //   106: dup
    //   107: ldc 117
    //   109: aload 5
    //   111: invokestatic 123	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   114: invokespecial 126	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   117: astore_0
    //   118: getstatic 132	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   121: aload_0
    //   122: invokevirtual 136	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   125: aload_3
    //   126: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_0
    //   132: aload_3
    //   133: astore_2
    //   134: goto +40 -> 174
    //   137: astore_2
    //   138: aload_3
    //   139: astore_0
    //   140: aload_2
    //   141: astore_3
    //   142: goto +11 -> 153
    //   145: astore_0
    //   146: goto +28 -> 174
    //   149: astore_3
    //   150: aload 4
    //   152: astore_0
    //   153: aload_0
    //   154: astore_2
    //   155: ldc 11
    //   157: iconst_1
    //   158: ldc 141
    //   160: aload_3
    //   161: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_0
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_0
    //   190: goto -18 -> 172
    //   193: astore_2
    //   194: goto -12 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramBitmap	Bitmap
    //   0	197	1	paramInt	int
    //   0	197	2	paramString	String
    //   7	135	3	localObject1	Object
    //   149	12	3	localException	java.lang.Exception
    //   58	93	4	localObject2	Object
    //   41	69	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   93	125	131	finally
    //   93	125	137	java/lang/Exception
    //   64	72	145	finally
    //   76	93	145	finally
    //   155	164	145	finally
    //   64	72	149	java/lang/Exception
    //   76	93	149	java/lang/Exception
    //   125	129	186	java/io/IOException
    //   168	172	189	java/io/IOException
    //   178	182	193	java/io/IOException
  }
  
  public static boolean saveFileToQqAlbum(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 23)
    {
      bool1 = bool2;
      if (paramActivity != null) {
        bool1 = QZonePermission.requestStoragePermission(paramActivity, new MediaUtil.3(paramString1, paramString2, paramString3, paramActivity), 1);
      }
    }
    if (bool1) {
      return saveFileToQqAlbum(paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  public static boolean saveFileToQqAlbum(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return false;
    }
    try
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists())
      {
        QLog.e("MediaUtil", 1, "srcFile not exists, SaveFileToQqAlbum failed.");
        return false;
      }
      Object localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (((File)localObject).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramString3);
        paramString2 = new File(((StringBuilder)localObject).toString());
        FileUtils.copyFile(paramString1, paramString2);
        paramString1 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(paramString2));
        MobileQQ.sMobileQQ.sendBroadcast(paramString1);
        return true;
      }
      QLog.e("MediaUtil", 1, "mkdirs failed, SaveFileToQqAlbum failed.");
      return true;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MediaUtil", 1, "saveFileToQqAlbum failed:", paramString1);
    }
    return false;
  }
  
  public static boolean saveFileToSystemAlbum(Activity paramActivity, String paramString1, String paramString2)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 23)
    {
      bool1 = bool2;
      if (paramActivity != null) {
        bool1 = QZonePermission.requestStoragePermission(paramActivity, new MediaUtil.1(paramString1, paramString2, paramActivity), 1);
      }
    }
    if (bool1) {
      return saveFileToSystemAlbum(paramString1, paramString2);
    }
    return false;
  }
  
  private static boolean saveFileToSystemAlbum(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new File(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(QZoneFilePath.DCIM_CAMERA_PATH);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString2);
      paramString2 = new File(localStringBuilder.toString());
      FileUtils.copyFile(paramString1, paramString2);
      paramString1 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(paramString2));
      MobileQQ.sMobileQQ.sendBroadcast(paramString1);
      return true;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MediaUtil", 1, "saveFileToSystemAlbum failed:", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.MediaUtil
 * JD-Core Version:    0.7.0.1
 */