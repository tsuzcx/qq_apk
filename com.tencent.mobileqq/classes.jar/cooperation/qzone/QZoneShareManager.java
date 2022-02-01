package cooperation.qzone;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneShareManager
{
  public static final String AVATAR_URL_PREFIX = "avatar://";
  public static final String GLORY_OF_KINGS = "1104466820";
  public static final String KEY_IS_THIRDPARTYSHARE = "key_share_is_third_party";
  public static final String KEY_SAHRE_DATA = "share_data";
  public static final String KUOLIE_SHARE_APPID = "101735437";
  public static final int MSG_QZONE_SHARE_IMAGE_UPLOAD_OK = 55555;
  public static final int MSG_QZONE_SHARE_LATER_CREATE_DIALOG = 55556;
  public static final int MSG_QZONE_SHARE_OPEN_ID_OK = 55557;
  public static final int MSG_QZONE_SHARE_UPLOAD_IMAGE_SKEY_ERROR = 55558;
  public static final String QQ_SHARE_APPID = "1103584836";
  public static final String QZONE_SHARE_ACTION = "share_action";
  public static final String QZONE_SHARE_APPNAME = "app_name";
  public static final String QZONE_SHARE_AT_FRIEND = "at_friend";
  public static final String QZONE_SHARE_EVENT_TAG = "event_tag";
  public static final String QZONE_SHARE_EXTSTRING = "share_ext_string";
  public static final int QZONE_SHARE_FREQUENTLY_ERROR = -11210;
  public static final String QZONE_SHARE_FROM_MINI_APP = "from_mini_app";
  public static final String QZONE_SHARE_FROM_WEB = "from_web";
  public static final String QZONE_SHARE_HULIAN_APPID = "hulian_appid";
  public static final String QZONE_SHARE_IMAGES = "images";
  public static final String QZONE_SHARE_KEY_MINI_APPID = "key_mini_appid";
  public static final String QZONE_SHARE_KEY_MINI_APP_TAIL = "key_mini_app_tail";
  public static final String QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION = "key_require_storage_permission";
  public static final int QZONE_SHARE_MAX_PIC = 9;
  public static final int QZONE_SHARE_NETWORK_INVALID_ERROR = -1;
  public static final String QZONE_SHARE_OPENID = "open_id";
  public static final int QZONE_SHARE_SENSITIVE_WORD_ERROR1 = -11207;
  public static final int QZONE_SHARE_SENSITIVE_WORD_ERROR2 = -11215;
  public static final int QZONE_SHARE_SUMMARY_MAX = 40;
  public static final String QZONE_SHARE_SUMMERY = "summary";
  public static final int QZONE_SHARE_TITLE_MAX = 30;
  public static final int QZONE_SHARE_TYPE_IMAGE = 5;
  public static final int QZONE_SHARE_TYPE_SHUOSHUO = 3;
  public static final int QZONE_SHARE_TYPE_VIDEO = 4;
  public static final int QZONE_SHARE_UPLOAD_IMAGE_SKEY_ERROR = -2;
  public static final String QZONE_SHARE_VIDEO_PATH = "file_send_path";
  public static final String QZONE_SHARE_VIDEO_TEXT = "defaultText";
  public static int QZONE_UPLOAD_FAIL_RESULT_CODE = 0;
  public static String QZONE_UPLOAD_FAIL_RESULT_TEXT = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "UploadFail", "上传失败");
  public static final String TAG = TAG;
  public static final int THIRD_PART_SHARE_APPID = 2020014;
  private static ConcurrentHashMap<String, OpenID> mOpenIDCache = new ConcurrentHashMap();
  
  public static final ArrayList<String> batchUploadImages(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    QZONE_UPLOAD_FAIL_RESULT_CODE = 0;
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return paramArrayList;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject2 = (String)paramArrayList.get(i);
        if (FileUtils.fileExists((String)localObject2))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("local url:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject1 = localObject2;
          if (FileUtils.getFileOrFolderSize((String)localObject2) > 2097152L)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = TAG;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("file length:");
              ((StringBuilder)localObject3).append(FileUtils.getFileOrFolderSize((String)localObject2));
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
            }
            localObject2 = compressImages((String)localObject2, i);
            if (localObject2 != null)
            {
              localObject1 = ((File)localObject2).getAbsolutePath();
              localObject3 = TAG;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("compressImages new Path:");
              ((StringBuilder)localObject4).append((String)localObject1);
              QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
              localArrayList.add(localObject2);
            }
            else
            {
              QLog.d(TAG, 1, "compressImages error");
              return paramArrayList;
            }
          }
          localObject2 = new HashMap();
          ((Map)localObject2).put("Connection", "keep-alive");
          ((Map)localObject2).put("Referer", "https://www.qq.com");
          Object localObject3 = new HashMap();
          ((Map)localObject3).put("type", paramString3);
          Object localObject4 = new HashMap();
          ((Map)localObject4).put("share_image", localObject1);
          localObject1 = HttpUtil.uploadImageWithHttps(MsfSdkUtils.insertMtype("qzPicu", "https://cgi.connect.qq.com/qqconnectopen/upload_share_image"), "cgi.connect.qq.com", paramString1, paramString2, (Map)localObject3, (Map)localObject4, (Map)localObject2, true);
          if (localObject1 != null)
          {
            try
            {
              localObject1 = new JSONObject((String)localObject1);
              if (((JSONObject)localObject1).getInt("retcode") == 0)
              {
                localObject1 = ((JSONObject)localObject1).getJSONObject("result");
                if (localObject1 != null)
                {
                  paramArrayList.set(i, ((JSONObject)localObject1).getString("url"));
                  if (QLog.isColorLevel())
                  {
                    localObject2 = TAG;
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("target url:");
                    ((StringBuilder)localObject3).append(((JSONObject)localObject1).getString("url"));
                    QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
                  }
                }
              }
              else
              {
                QZONE_UPLOAD_FAIL_RESULT_CODE = ((JSONObject)localObject1).getInt("retcode");
                localObject1 = TAG;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("upload fail, code = ");
                ((StringBuilder)localObject2).append(QZONE_UPLOAD_FAIL_RESULT_CODE);
                QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
              }
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                break label568;
              }
            }
            QLog.d(TAG, 2, localJSONException.getMessage());
          }
          else
          {
            QLog.e(TAG, 1, "uploadImageWithHttps error");
          }
        }
        else
        {
          QLog.e(TAG, 1, "uploadImageWithHttps file not exist");
        }
        label568:
        i += 1;
      }
      deleteTempFile(localArrayList);
    }
    return paramArrayList;
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int i = paramOptions.outWidth;
    if ((j <= paramInt2) && (i <= paramInt1))
    {
      paramInt1 = 2;
    }
    else
    {
      paramInt2 = Math.round(j / paramInt2);
      i = Math.round(i / paramInt1);
      paramInt1 = i;
      if (paramInt2 < i) {
        paramInt1 = paramInt2;
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 <= 0) {
      paramInt2 = 2;
    }
    return paramInt2;
  }
  
  public static final Bundle checkQzoneShareParams(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("desc");
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (localArrayList != null) && (!localArrayList.isEmpty())) {
      paramBundle.remove("detail_url");
    }
    resetQzoneShareImages(paramBundle);
    return paramBundle;
  }
  
  /* Error */
  public static File compressImages(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 361	com/tencent/mobileqq/utils/FileUtils:getFileDirectoryOf	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 4
    //   6: aload_0
    //   7: invokestatic 364	com/tencent/mobileqq/utils/FileUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: new 314	android/graphics/BitmapFactory$Options
    //   17: dup
    //   18: invokespecial 365	android/graphics/BitmapFactory$Options:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: iconst_1
    //   24: putfield 369	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   27: aload_0
    //   28: aload_2
    //   29: invokestatic 375	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: pop
    //   33: aload_2
    //   34: aload_2
    //   35: sipush 640
    //   38: sipush 640
    //   41: invokestatic 377	cooperation/qzone/QZoneShareManager:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   44: putfield 380	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   47: aload_2
    //   48: iconst_0
    //   49: putfield 369	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   52: aload_0
    //   53: aload_2
    //   54: invokestatic 375	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: astore_2
    //   58: aload_3
    //   59: astore_0
    //   60: aload_2
    //   61: ifnull +108 -> 169
    //   64: aload_3
    //   65: astore_0
    //   66: aload 4
    //   68: ifnull +101 -> 169
    //   71: aload_2
    //   72: astore_0
    //   73: new 178	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   80: astore_3
    //   81: aload_2
    //   82: astore_0
    //   83: aload_3
    //   84: iload_1
    //   85: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: astore_0
    //   91: aload_3
    //   92: aload 5
    //   94: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_2
    //   99: astore_0
    //   100: new 210	java/io/File
    //   103: dup
    //   104: aload 4
    //   106: aload_3
    //   107: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 383	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: astore_3
    //   114: aload_2
    //   115: astore_0
    //   116: new 385	java/io/FileOutputStream
    //   119: dup
    //   120: aload_3
    //   121: invokespecial 388	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: astore 4
    //   126: aload_2
    //   127: astore_0
    //   128: aload_2
    //   129: getstatic 394	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   132: bipush 50
    //   134: aload 4
    //   136: invokevirtual 400	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   139: ifeq +10 -> 149
    //   142: aload_2
    //   143: astore_0
    //   144: aload 4
    //   146: invokevirtual 403	java/io/FileOutputStream:flush	()V
    //   149: aload_2
    //   150: astore_0
    //   151: aload 4
    //   153: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   156: aload_3
    //   157: astore_0
    //   158: goto +11 -> 169
    //   161: astore_3
    //   162: goto +36 -> 198
    //   165: astore_3
    //   166: goto +76 -> 242
    //   169: aload_2
    //   170: ifnull +17 -> 187
    //   173: aload_2
    //   174: invokevirtual 409	android/graphics/Bitmap:isRecycled	()Z
    //   177: ifne +10 -> 187
    //   180: aload_2
    //   181: invokevirtual 412	android/graphics/Bitmap:recycle	()V
    //   184: invokestatic 417	java/lang/System:gc	()V
    //   187: aload_0
    //   188: areturn
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_0
    //   192: goto +92 -> 284
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_2
    //   198: aload_2
    //   199: astore_0
    //   200: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +16 -> 219
    //   206: aload_2
    //   207: astore_0
    //   208: getstatic 115	cooperation/qzone/QZoneShareManager:TAG	Ljava/lang/String;
    //   211: iconst_2
    //   212: ldc_w 419
    //   215: aload_3
    //   216: invokestatic 422	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_2
    //   220: ifnull +17 -> 237
    //   223: aload_2
    //   224: invokevirtual 409	android/graphics/Bitmap:isRecycled	()Z
    //   227: ifne +10 -> 237
    //   230: aload_2
    //   231: invokevirtual 412	android/graphics/Bitmap:recycle	()V
    //   234: invokestatic 417	java/lang/System:gc	()V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_3
    //   240: aconst_null
    //   241: astore_2
    //   242: aload_2
    //   243: astore_0
    //   244: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +16 -> 263
    //   250: aload_2
    //   251: astore_0
    //   252: getstatic 115	cooperation/qzone/QZoneShareManager:TAG	Ljava/lang/String;
    //   255: iconst_2
    //   256: ldc_w 424
    //   259: aload_3
    //   260: invokestatic 422	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: aload_2
    //   264: ifnull +17 -> 281
    //   267: aload_2
    //   268: invokevirtual 409	android/graphics/Bitmap:isRecycled	()Z
    //   271: ifne +10 -> 281
    //   274: aload_2
    //   275: invokevirtual 412	android/graphics/Bitmap:recycle	()V
    //   278: invokestatic 417	java/lang/System:gc	()V
    //   281: aconst_null
    //   282: areturn
    //   283: astore_2
    //   284: aload_0
    //   285: ifnull +17 -> 302
    //   288: aload_0
    //   289: invokevirtual 409	android/graphics/Bitmap:isRecycled	()Z
    //   292: ifne +10 -> 302
    //   295: aload_0
    //   296: invokevirtual 412	android/graphics/Bitmap:recycle	()V
    //   299: invokestatic 417	java/lang/System:gc	()V
    //   302: aload_2
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString	String
    //   0	304	1	paramInt	int
    //   21	160	2	localObject1	Object
    //   189	1	2	localObject2	Object
    //   197	78	2	localObject3	Object
    //   283	20	2	localObject4	Object
    //   13	144	3	localObject5	Object
    //   161	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   165	1	3	localException1	java.lang.Exception
    //   195	21	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   239	21	3	localException2	java.lang.Exception
    //   4	148	4	localObject6	Object
    //   10	83	5	str	String
    // Exception table:
    //   from	to	target	type
    //   73	81	161	java/lang/OutOfMemoryError
    //   83	89	161	java/lang/OutOfMemoryError
    //   91	98	161	java/lang/OutOfMemoryError
    //   100	114	161	java/lang/OutOfMemoryError
    //   116	126	161	java/lang/OutOfMemoryError
    //   128	142	161	java/lang/OutOfMemoryError
    //   144	149	161	java/lang/OutOfMemoryError
    //   151	156	161	java/lang/OutOfMemoryError
    //   73	81	165	java/lang/Exception
    //   83	89	165	java/lang/Exception
    //   91	98	165	java/lang/Exception
    //   100	114	165	java/lang/Exception
    //   116	126	165	java/lang/Exception
    //   128	142	165	java/lang/Exception
    //   144	149	165	java/lang/Exception
    //   151	156	165	java/lang/Exception
    //   14	58	189	finally
    //   14	58	195	java/lang/OutOfMemoryError
    //   14	58	239	java/lang/Exception
    //   73	81	283	finally
    //   83	89	283	finally
    //   91	98	283	finally
    //   100	114	283	finally
    //   116	126	283	finally
    //   128	142	283	finally
    //   144	149	283	finally
    //   151	156	283	finally
    //   200	206	283	finally
    //   208	219	283	finally
    //   244	250	283	finally
    //   252	263	283	finally
  }
  
  public static void deleteTempFile(ArrayList<File> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        FileUtils.deleteFile((File)localIterator.next());
      }
      paramArrayList.clear();
    }
  }
  
  public static OpenID getOpenID(AppRuntime paramAppRuntime, String paramString, BusinessObserver paramBusinessObserver)
  {
    Object localObject1 = (OpenID)mOpenIDCache.get(paramString);
    if (localObject1 != null) {
      return localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get openid key = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    paramAppRuntime = (AccountManager)paramAppRuntime.getManager(0);
    localObject1 = new HashMap();
    Object localObject2 = new RequestCustomSig();
    ((RequestCustomSig)localObject2).ulCustumFlag = 8192L;
    ((RequestCustomSig)localObject2).ulSType = 1L;
    ((RequestCustomSig)localObject2).reserved = new byte[0];
    ((HashMap)localObject1).put("RequestCustomSig", localObject2);
    ((HashMap)localObject1).put("OpenAppid", paramString);
    paramAppRuntime.changeToken((HashMap)localObject1, new QZoneShareManager.1(paramString, paramBusinessObserver));
    return null;
  }
  
  public static final long getShareAppId(Intent paramIntent)
  {
    long l = 0L;
    if (paramIntent == null) {
      return 0L;
    }
    paramIntent = paramIntent.getBundleExtra("share_data");
    if (paramIntent != null) {
      l = paramIntent.getLong("req_share_id", 0L);
    }
    return l;
  }
  
  public static boolean isQzoneShareWhite(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "sharewhitelist", "100733645,1101218289,100497308,1103394134,1106611629,1105705811,1104466820");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(localObject[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static boolean isValidUrl(String paramString)
  {
    return (HttpUtil.isValidUrl(paramString)) || ((paramString != null) && (paramString.startsWith("avatar://")));
  }
  
  @Deprecated
  public static final boolean jumpToQzoneShare(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return jumpToQzoneShare(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  @Deprecated
  public static final boolean jumpToQzoneShare(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    return jumpToQzoneShare(paramAppInterface.getCurrentAccountUin(), paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  @Deprecated
  public static final boolean jumpToQzoneShare(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    return ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(paramString, paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  public static final void publishToQzone(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    publishToQzone(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  public static final void publishToQzone(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).publishToQzone(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  public static final void publishToQzoneFromMiniApp(Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).publishToQzoneFromMiniApp(paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  public static final Bundle resetQzoneShareImages(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        String str = (String)localArrayList.get(i);
        if ((!isValidUrl(str)) && (!FileUtils.fileExists(str))) {
          localArrayList.remove(i);
        }
        i -= 1;
      }
      while (localArrayList.size() > 9) {
        localArrayList.remove(9);
      }
      if (localArrayList.size() > 0)
      {
        if (isValidUrl((String)localArrayList.get(0)))
        {
          i = localArrayList.size() - 1;
          while (i >= 0)
          {
            if (!isValidUrl((String)localArrayList.get(i))) {
              localArrayList.remove(i);
            }
            i -= 1;
          }
        }
        i = localArrayList.size() - 1;
        while (i >= 0)
        {
          if (i != 0) {
            localArrayList.remove(i);
          }
          i -= 1;
        }
      }
      paramBundle.putStringArrayList("image_url", localArrayList);
    }
    return paramBundle;
  }
  
  public static final void shareToQZoneForRedPocket(Context paramContext, String paramString1, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt, String paramString2, String paramString3)
  {
    paramString3 = new QZoneShareData();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(HardCodeUtil.a(2131712270));
    paramString3.mTitle = localStringBuilder.toString();
    paramString3.mSummary = HardCodeUtil.a(2131712262);
    paramString3.mImageUrls = new ArrayList();
    paramString3.mImageUrls.add("https://qzonestyle.gtimg.cn/aoi/sola/20161111222053_4wlQcl1Eta.png");
    paramString2 = new StringBuilder();
    paramString2.append("https://h5.qzone.qq.com/redpacket/share?_wv=1&_ws=1&uin=");
    paramString2.append(paramString1);
    paramString3.targetUrl = paramString2.toString();
    paramString3.from = 0;
    paramString3.shareUin = paramString1;
    shareToQzone(paramContext, paramString1, paramString3, paramOnDismissListener, paramInt);
  }
  
  public static final void shareToQzone(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).shareToQzone(paramContext, paramString, paramQZoneShareData, paramOnDismissListener, paramInt);
  }
  
  public static void shareToQzoneFromAskAnonymously(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, int paramInt)
  {
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).shareToQzoneFromAskAnonymously(paramContext, paramString, paramQZoneShareData, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneShareManager
 * JD-Core Version:    0.7.0.1
 */