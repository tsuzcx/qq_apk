package cooperation.qzone.webviewplugin;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.io.File;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class QzoneUploadInterface
{
  public static final String JS_UPLOAD_TAG = "js-upload: ";
  private static final String TAG = "js-upload: QzoneWebUploadInterface";
  public static final String UPLOAD_TEMP_DIR = "uploader";
  public static final int UPLOAD_TEMP_SPACE_THRESHOLD = 5;
  public static final String UPLOAD_TEMP_SUFFIX = ".qtmp";
  private static final String WEB_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
  private static final String WEB_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
  private static final String WEB_BASE64_PREFIX_PNG = "data:image/png;base64,";
  
  private static File getExternalFilesDir(Context paramContext)
  {
    File localFile = new File(VFSAssistantUtils.getSDKPrivatePath("uploader"));
    paramContext = localFile;
    if (!localFile.isDirectory())
    {
      if (localFile.mkdirs()) {
        return localFile;
      }
      paramContext = null;
    }
    return paramContext;
  }
  
  public static int getInternalAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d1 = localStatFs.getAvailableBlocks();
    Double.isNaN(d1);
    double d2 = i;
    Double.isNaN(d2);
    return (int)(d1 * 1.0D * d2 / 1024.0D / 1024.0D);
  }
  
  public static int getSdCardAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d1 = localStatFs.getAvailableBlocks();
    Double.isNaN(d1);
    double d2 = i;
    Double.isNaN(d2);
    return (int)(d1 * 1.0D * d2 / 1024.0D / 1024.0D);
  }
  
  public static final String getTempFileAbsolutePath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(8);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".qtmp");
    return localStringBuilder.toString();
  }
  
  public static String getTempFilePath(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (("mounted".equals(Environment.getExternalStorageState())) && (getSdCardAvailableSize() > 5))
    {
      File localFile = getExternalFilesDir(paramContext);
      if (localFile != null) {
        return getTempFileAbsolutePath(localFile.getAbsolutePath(), paramString);
      }
    }
    if (getInternalAvailableSize() > 5)
    {
      paramContext = paramContext.getDir("uploader", 0);
      if (paramContext != null) {
        return getTempFileAbsolutePath(paramContext.getAbsolutePath(), paramString);
      }
    }
    return null;
  }
  
  /* Error */
  protected static boolean saveByteBufferToLocalFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 4
    //   16: astore_2
    //   17: new 38	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload 4
    //   28: astore_2
    //   29: aload_1
    //   30: invokevirtual 149	java/io/File:exists	()Z
    //   33: ifne +11 -> 44
    //   36: aload 4
    //   38: astore_2
    //   39: aload_1
    //   40: invokevirtual 152	java/io/File:createNewFile	()Z
    //   43: pop
    //   44: aload 4
    //   46: astore_2
    //   47: new 154	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: aload_1
    //   57: aload_0
    //   58: invokevirtual 161	java/io/FileOutputStream:write	([B)V
    //   61: aload_1
    //   62: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   65: goto +35 -> 100
    //   68: astore_0
    //   69: new 91	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc 167
    //   80: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc 11
    //   92: iconst_1
    //   93: aload_1
    //   94: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: iconst_1
    //   101: ireturn
    //   102: astore_0
    //   103: aload_1
    //   104: astore_2
    //   105: goto +101 -> 206
    //   108: astore_2
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: astore_1
    //   113: goto +10 -> 123
    //   116: astore_0
    //   117: goto +89 -> 206
    //   120: astore_1
    //   121: aload_3
    //   122: astore_0
    //   123: aload_0
    //   124: astore_2
    //   125: new 91	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_0
    //   134: astore_2
    //   135: aload_3
    //   136: ldc 178
    //   138: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_0
    //   143: astore_2
    //   144: aload_3
    //   145: aload_1
    //   146: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_0
    //   151: astore_2
    //   152: ldc 11
    //   154: iconst_1
    //   155: aload_3
    //   156: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: ifnull +41 -> 204
    //   166: aload_0
    //   167: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_0
    //   173: new 91	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   180: astore_1
    //   181: aload_1
    //   182: ldc 167
    //   184: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: aload_0
    //   190: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: ldc 11
    //   196: iconst_1
    //   197: aload_1
    //   198: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: iconst_0
    //   205: ireturn
    //   206: aload_2
    //   207: ifnull +42 -> 249
    //   210: aload_2
    //   211: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   214: goto +35 -> 249
    //   217: astore_1
    //   218: new 91	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   225: astore_2
    //   226: aload_2
    //   227: ldc 167
    //   229: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: aload_1
    //   235: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 11
    //   241: iconst_1
    //   242: aload_2
    //   243: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramArrayOfByte	byte[]
    //   0	251	1	paramString	String
    //   16	89	2	localObject1	Object
    //   108	4	2	localIOException	java.io.IOException
    //   124	119	2	localObject2	Object
    //   10	146	3	localStringBuilder	StringBuilder
    //   12	33	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	68	java/lang/Exception
    //   56	61	102	finally
    //   56	61	108	java/io/IOException
    //   17	26	116	finally
    //   29	36	116	finally
    //   39	44	116	finally
    //   47	56	116	finally
    //   125	133	116	finally
    //   135	142	116	finally
    //   144	150	116	finally
    //   152	162	116	finally
    //   17	26	120	java/io/IOException
    //   29	36	120	java/io/IOException
    //   39	44	120	java/io/IOException
    //   47	56	120	java/io/IOException
    //   166	170	172	java/lang/Exception
    //   210	214	217	java/lang/Exception
  }
  
  protected static String toLocal(Context paramContext, String paramString)
  {
    paramString = paramString.replace("data:image/jpg;base64,", "").replace("data:image/jpeg;base64,", "").replace("data:image/png;base64,", "");
    paramContext = getTempFilePath(paramContext, UUID.randomUUID().toString());
    if (TextUtils.isEmpty(paramContext))
    {
      QLog.e("js-upload: QzoneWebUploadInterface", 1, "getTempFilePath return null !");
      return null;
    }
    try
    {
      boolean bool = saveByteBufferToLocalFile(Base64.decode(paramString.getBytes(), 2), paramContext);
      paramString = new StringBuilder();
      paramString.append("saveByteBufferToLocalFile ret:");
      paramString.append(bool);
      QLog.d("js-upload: QzoneWebUploadInterface", 1, paramString.toString());
      if (bool) {
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("Base64.decode Exception: ");
      paramString.append(paramContext.toString());
      QLog.d("js-upload: QzoneWebUploadInterface", 1, paramString.toString());
    }
    return null;
  }
  
  public static boolean upload(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!new File(paramString1).exists())
      {
        paramString2 = new StringBuilder();
        paramString2.append("upload file not exist! localPath:");
        paramString2.append(paramString1);
        QLog.w("js-upload: QzoneWebUploadInterface", 1, paramString2.toString());
        return false;
      }
      localObject1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (localObject1 == null)
      {
        QLog.w("js-upload: QzoneWebUploadInterface", 1, "app == null");
        return false;
      }
      Object localObject2 = (TicketManager)((AppInterface)localObject1).getManager(2);
      String str = ((AppInterface)localObject1).getAccount();
      localObject1 = ((TicketManager)localObject2).getSkey(str);
      localObject2 = ((TicketManager)localObject2).getA2(str);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        RemoteHandleManager.getInstance().getSender().uploadUps(paramString1, paramString2);
        return true;
      }
      paramString1 = new StringBuilder();
      paramString1.append("mSkey == null || mA2 == null, mSkey=");
      paramString1.append((String)localObject1);
      paramString1.append(" mA2=");
      paramString1.append((String)localObject2);
      QLog.w("js-upload: QzoneWebUploadInterface", 1, paramString1.toString());
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("localPath: ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" bid:");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.w("js-upload: QzoneWebUploadInterface", 1, ((StringBuilder)localObject1).toString());
    return false;
  }
  
  public static boolean uploadAudio(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("localPath is empty : ");
      paramArrayOfByte.append(paramString);
      QLog.w("js-upload: QzoneWebUploadInterface", 1, paramArrayOfByte.toString());
      return false;
    }
    if (!new File(paramString).exists())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("upload file not exist! localPath : ");
      paramArrayOfByte.append(paramString);
      QLog.w("js-upload: QzoneWebUploadInterface", 1, paramArrayOfByte.toString());
      return false;
    }
    RemoteHandleManager.getInstance().getSender().uploadAudio(paramString, paramInt1, paramInt2, paramArrayOfByte);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUploadInterface
 * JD-Core Version:    0.7.0.1
 */