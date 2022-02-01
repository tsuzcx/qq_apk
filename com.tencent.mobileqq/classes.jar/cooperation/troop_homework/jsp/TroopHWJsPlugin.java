package cooperation.troop_homework.jsp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback, TroopHWFileDownloadManager.OnDownloadStateListener, TroopHWVoiceController.RecordCallback
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new TroopHWJsPlugin.5(this);
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private TroopHWFileDownloadManager jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager;
  TroopHWVoiceController jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController = null;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 540;
  String jdField_b_of_type_JavaLangString;
  HashMap<Integer, TroopHWJsPlugin.UploadMediaEntry> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 1;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int = -1;
  String jdField_e_of_type_JavaLangString;
  String f = null;
  String g = null;
  String h = null;
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_HOMEWORK_AUDIO + "homeworkTmp/";
  }
  
  public TroopHWJsPlugin()
  {
    this.mPluginNameSpace = "homework";
  }
  
  @TargetApi(12)
  public static int a(Bitmap paramBitmap)
  {
    int k = 100;
    int j;
    if (Build.VERSION.SDK_INT >= 12)
    {
      j = paramBitmap.getByteCount();
      if (j <= 41246720) {
        break label39;
      }
      k = 0;
    }
    label39:
    do
    {
      return k;
      j = paramBitmap.getRowBytes() * paramBitmap.getHeight();
      break;
      if (j > 6291456) {
        return 50;
      }
      if (j > 1048576) {
        return 80;
      }
    } while (j <= 102400);
    return 90;
  }
  
  @NonNull
  public static Intent a(int paramInt, Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 47);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", paramInt);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", true);
    return localIntent;
  }
  
  /* Error */
  private Bitmap a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 198	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   14: iload_1
    //   15: iconst_2
    //   16: ldc 200
    //   18: aconst_null
    //   19: iconst_m1
    //   20: invokevirtual 203	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   23: astore 6
    //   25: new 205	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 206	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 7
    //   34: aload 7
    //   36: aload_2
    //   37: invokevirtual 210	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   40: aload 7
    //   42: ldc2_w 211
    //   45: invokevirtual 216	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +385 -> 435
    //   53: aload_0
    //   54: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   57: ifgt +128 -> 185
    //   60: sipush 540
    //   63: istore_1
    //   64: aload_0
    //   65: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   68: ifgt +125 -> 193
    //   71: sipush 540
    //   74: istore_3
    //   75: aload_2
    //   76: iload_1
    //   77: iload_3
    //   78: invokestatic 222	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +59 -> 144
    //   88: aload 4
    //   90: aload 4
    //   92: invokestatic 224	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   95: invokestatic 227	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   98: astore 5
    //   100: aload 5
    //   102: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +39 -> 144
    //   108: aload 6
    //   110: ldc 229
    //   112: aload 5
    //   114: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload 6
    //   120: ldc 237
    //   122: aload 4
    //   124: invokevirtual 240	android/graphics/Bitmap:getWidth	()I
    //   127: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload 6
    //   133: ldc 245
    //   135: aload 4
    //   137: invokevirtual 125	android/graphics/Bitmap:getHeight	()I
    //   140: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload 7
    //   146: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 250	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_1
    //   155: anewarray 252	java/lang/String
    //   158: dup
    //   159: iconst_0
    //   160: aload 6
    //   162: invokevirtual 253	org/json/JSONObject:toString	()Ljava/lang/String;
    //   165: aastore
    //   166: invokevirtual 257	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   169: aload 4
    //   171: ifnull +209 -> 380
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   182: aload 4
    //   184: areturn
    //   185: aload_0
    //   186: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   189: istore_1
    //   190: goto -126 -> 64
    //   193: aload_0
    //   194: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   197: istore_3
    //   198: goto -123 -> 75
    //   201: astore 5
    //   203: aconst_null
    //   204: astore_2
    //   205: aconst_null
    //   206: astore 4
    //   208: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +34 -> 245
    //   214: ldc_w 268
    //   217: iconst_2
    //   218: new 34	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 270
    //   228: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 5
    //   233: invokevirtual 273	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 277	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 7
    //   247: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   250: goto -101 -> 149
    //   253: astore 5
    //   255: goto -106 -> 149
    //   258: astore 5
    //   260: aconst_null
    //   261: astore_2
    //   262: aconst_null
    //   263: astore 4
    //   265: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +34 -> 302
    //   271: ldc_w 268
    //   274: iconst_2
    //   275: new 34	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 270
    //   285: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 5
    //   290: invokevirtual 278	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   293: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 277	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload 7
    //   304: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   307: goto -158 -> 149
    //   310: astore 5
    //   312: goto -163 -> 149
    //   315: astore 5
    //   317: aconst_null
    //   318: astore_2
    //   319: aconst_null
    //   320: astore 4
    //   322: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +34 -> 359
    //   328: ldc_w 268
    //   331: iconst_2
    //   332: new 34	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 280
    //   342: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 5
    //   347: invokevirtual 281	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 277	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 7
    //   361: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   364: goto -215 -> 149
    //   367: astore 5
    //   369: goto -220 -> 149
    //   372: astore_2
    //   373: aload 7
    //   375: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   378: aload_2
    //   379: athrow
    //   380: aload_2
    //   381: ifnull -374 -> 7
    //   384: aload_2
    //   385: areturn
    //   386: astore 5
    //   388: goto -239 -> 149
    //   391: astore 4
    //   393: goto -15 -> 378
    //   396: astore 5
    //   398: aconst_null
    //   399: astore 4
    //   401: goto -79 -> 322
    //   404: astore 5
    //   406: goto -84 -> 322
    //   409: astore 5
    //   411: aconst_null
    //   412: astore 4
    //   414: goto -149 -> 265
    //   417: astore 5
    //   419: goto -154 -> 265
    //   422: astore 5
    //   424: aconst_null
    //   425: astore 4
    //   427: goto -219 -> 208
    //   430: astore 5
    //   432: goto -224 -> 208
    //   435: aconst_null
    //   436: astore 4
    //   438: goto -294 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	TroopHWJsPlugin
    //   0	441	1	paramInt	int
    //   0	441	2	paramString	String
    //   74	124	3	j	int
    //   81	240	4	localBitmap	Bitmap
    //   391	1	4	localRuntimeException1	java.lang.RuntimeException
    //   399	38	4	localObject	Object
    //   98	15	5	str	String
    //   201	31	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   253	1	5	localRuntimeException2	java.lang.RuntimeException
    //   258	31	5	localRuntimeException3	java.lang.RuntimeException
    //   310	1	5	localRuntimeException4	java.lang.RuntimeException
    //   315	31	5	localJSONException1	JSONException
    //   367	1	5	localRuntimeException5	java.lang.RuntimeException
    //   386	1	5	localRuntimeException6	java.lang.RuntimeException
    //   396	1	5	localJSONException2	JSONException
    //   404	1	5	localJSONException3	JSONException
    //   409	1	5	localRuntimeException7	java.lang.RuntimeException
    //   417	1	5	localRuntimeException8	java.lang.RuntimeException
    //   422	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   430	1	5	localIllegalArgumentException3	java.lang.IllegalArgumentException
    //   23	138	6	localJSONObject	JSONObject
    //   32	342	7	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   34	49	201	java/lang/IllegalArgumentException
    //   245	250	253	java/lang/RuntimeException
    //   34	49	258	java/lang/RuntimeException
    //   302	307	310	java/lang/RuntimeException
    //   34	49	315	org/json/JSONException
    //   359	364	367	java/lang/RuntimeException
    //   34	49	372	finally
    //   53	60	372	finally
    //   64	71	372	finally
    //   75	83	372	finally
    //   88	144	372	finally
    //   185	190	372	finally
    //   193	198	372	finally
    //   208	245	372	finally
    //   265	302	372	finally
    //   322	359	372	finally
    //   144	149	386	java/lang/RuntimeException
    //   373	378	391	java/lang/RuntimeException
    //   53	60	396	org/json/JSONException
    //   64	71	396	org/json/JSONException
    //   75	83	396	org/json/JSONException
    //   185	190	396	org/json/JSONException
    //   193	198	396	org/json/JSONException
    //   88	144	404	org/json/JSONException
    //   53	60	409	java/lang/RuntimeException
    //   64	71	409	java/lang/RuntimeException
    //   75	83	409	java/lang/RuntimeException
    //   185	190	409	java/lang/RuntimeException
    //   193	198	409	java/lang/RuntimeException
    //   88	144	417	java/lang/RuntimeException
    //   53	60	422	java/lang/IllegalArgumentException
    //   64	71	422	java/lang/IllegalArgumentException
    //   75	83	422	java/lang/IllegalArgumentException
    //   185	190	422	java/lang/IllegalArgumentException
    //   193	198	422	java/lang/IllegalArgumentException
    //   88	144	430	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString, int paramInt2, TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    // Byte code:
    //   0: new 292	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 298	java/io/File:length	()J
    //   11: ldc2_w 299
    //   14: lcmp
    //   15: ifle +290 -> 305
    //   18: aconst_null
    //   19: astore 12
    //   21: new 34	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   28: astore 15
    //   30: new 302	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 303	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_1
    //   42: putfield 306	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload 17
    //   47: getstatic 312	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   50: putfield 315	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   53: aload 17
    //   55: iconst_1
    //   56: putfield 318	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   59: aload_1
    //   60: aload 17
    //   62: invokestatic 324	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 17
    //   68: getfield 327	android/graphics/BitmapFactory$Options:outWidth	I
    //   71: istore 8
    //   73: aload 17
    //   75: getfield 330	android/graphics/BitmapFactory$Options:outHeight	I
    //   78: istore 10
    //   80: iload 8
    //   82: ifle +1194 -> 1276
    //   85: iload 10
    //   87: ifgt +6 -> 93
    //   90: goto +1186 -> 1276
    //   93: iload 8
    //   95: iload_2
    //   96: if_icmpgt +25 -> 121
    //   99: aload_1
    //   100: astore 11
    //   102: aload_3
    //   103: ifnull +1176 -> 1279
    //   106: aload_3
    //   107: getfield 198	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   110: iload_0
    //   111: aload_1
    //   112: iload 8
    //   114: iload 10
    //   116: aload_3
    //   117: invokestatic 333	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;ILjava/lang/String;IILcooperation/troop_homework/jsp/TroopHWJsPlugin;)Ljava/lang/String;
    //   120: areturn
    //   121: aconst_null
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 14
    //   127: new 335	android/graphics/Matrix
    //   130: dup
    //   131: invokespecial 336	android/graphics/Matrix:<init>	()V
    //   134: astore 16
    //   136: fconst_1
    //   137: fstore 5
    //   139: iconst_0
    //   140: istore 7
    //   142: aload_1
    //   143: invokestatic 342	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   146: istore 9
    //   148: iload 9
    //   150: iconst_5
    //   151: if_icmpeq +1131 -> 1282
    //   154: iload 9
    //   156: bipush 6
    //   158: if_icmpeq +1124 -> 1282
    //   161: iload 9
    //   163: bipush 7
    //   165: if_icmpeq +1117 -> 1282
    //   168: iload 9
    //   170: bipush 8
    //   172: if_icmpne +6 -> 178
    //   175: goto +1107 -> 1282
    //   178: iload 7
    //   180: ifeq +127 -> 307
    //   183: iload 10
    //   185: iload_2
    //   186: idiv
    //   187: istore 8
    //   189: aload 17
    //   191: iconst_0
    //   192: putfield 306	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   195: iload 8
    //   197: iload 8
    //   199: iconst_1
    //   200: iushr
    //   201: ior
    //   202: istore 8
    //   204: iload 8
    //   206: iload 8
    //   208: iconst_2
    //   209: iushr
    //   210: ior
    //   211: istore 8
    //   213: iload 8
    //   215: iload 8
    //   217: iconst_4
    //   218: iushr
    //   219: ior
    //   220: istore 8
    //   222: iload 8
    //   224: iload 8
    //   226: bipush 8
    //   228: iushr
    //   229: ior
    //   230: istore 8
    //   232: aload 17
    //   234: iload 8
    //   236: iload 8
    //   238: bipush 16
    //   240: iushr
    //   241: ior
    //   242: iconst_1
    //   243: iadd
    //   244: iconst_1
    //   245: iushr
    //   246: putfield 345	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   249: new 347	java/io/FileInputStream
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 348	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   257: astore 13
    //   259: fload 5
    //   261: fstore 4
    //   263: aload 14
    //   265: astore 12
    //   267: aload 13
    //   269: aconst_null
    //   270: aload 17
    //   272: invokestatic 352	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   275: astore 11
    //   277: aload 11
    //   279: ifnonnull +37 -> 316
    //   282: aconst_null
    //   283: astore 11
    //   285: aload 13
    //   287: ifnull +992 -> 1279
    //   290: aload 13
    //   292: invokevirtual 355	java/io/FileInputStream:close	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 358	java/lang/OutOfMemoryError:printStackTrace	()V
    //   302: invokestatic 363	java/lang/System:gc	()V
    //   305: aconst_null
    //   306: areturn
    //   307: iload 8
    //   309: iload_2
    //   310: idiv
    //   311: istore 8
    //   313: goto -124 -> 189
    //   316: iload 7
    //   318: ifeq +421 -> 739
    //   321: iload_2
    //   322: i2f
    //   323: fstore 6
    //   325: fload 5
    //   327: fstore 4
    //   329: aload 11
    //   331: astore 12
    //   333: aload 11
    //   335: invokevirtual 125	android/graphics/Bitmap:getHeight	()I
    //   338: i2f
    //   339: fstore 5
    //   341: fload 5
    //   343: fstore 4
    //   345: aload 11
    //   347: astore 12
    //   349: fload 6
    //   351: fload 5
    //   353: fdiv
    //   354: fstore 5
    //   356: fload 5
    //   358: fstore 4
    //   360: goto +928 -> 1288
    //   363: fload 5
    //   365: fstore 4
    //   367: aload 11
    //   369: astore 12
    //   371: aload 16
    //   373: fload 5
    //   375: fload 5
    //   377: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   380: aload 11
    //   382: astore 12
    //   384: aload 13
    //   386: ifnull +883 -> 1269
    //   389: aload 13
    //   391: invokevirtual 355	java/io/FileInputStream:close	()V
    //   394: aload 11
    //   396: iconst_0
    //   397: iconst_0
    //   398: aload 11
    //   400: invokevirtual 240	android/graphics/Bitmap:getWidth	()I
    //   403: aload 11
    //   405: invokevirtual 125	android/graphics/Bitmap:getHeight	()I
    //   408: aload 16
    //   410: iconst_1
    //   411: invokestatic 371	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   414: astore 14
    //   416: aload 11
    //   418: aload 14
    //   420: if_acmpeq +8 -> 428
    //   423: aload 11
    //   425: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   428: aload 14
    //   430: invokevirtual 240	android/graphics/Bitmap:getWidth	()I
    //   433: istore_2
    //   434: aload 14
    //   436: invokevirtual 125	android/graphics/Bitmap:getHeight	()I
    //   439: istore 7
    //   441: aconst_null
    //   442: astore 13
    //   444: aconst_null
    //   445: astore 12
    //   447: aload 14
    //   449: invokestatic 224	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   452: istore 8
    //   454: iload 8
    //   456: ifle +604 -> 1060
    //   459: new 373	java/io/ByteArrayOutputStream
    //   462: dup
    //   463: sipush 1024
    //   466: invokespecial 376	java/io/ByteArrayOutputStream:<init>	(I)V
    //   469: astore 11
    //   471: aload 14
    //   473: getstatic 382	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   476: iload 8
    //   478: aload 11
    //   480: invokevirtual 386	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   483: pop
    //   484: aload_3
    //   485: ifnull +781 -> 1266
    //   488: aload 15
    //   490: aload 11
    //   492: invokevirtual 390	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   495: iconst_2
    //   496: invokestatic 396	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   499: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +28 -> 534
    //   509: ldc_w 268
    //   512: iconst_2
    //   513: iconst_2
    //   514: anewarray 148	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: ldc_w 398
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: iload 8
    //   527: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: invokestatic 407	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   534: aload 14
    //   536: ifnull +8 -> 544
    //   539: aload 14
    //   541: invokevirtual 260	android/graphics/Bitmap:recycle	()V
    //   544: aload_3
    //   545: ifnull +79 -> 624
    //   548: aload_3
    //   549: aload_3
    //   550: getfield 198	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: iload_0
    //   554: iconst_1
    //   555: ldc 200
    //   557: aconst_null
    //   558: iconst_m1
    //   559: invokevirtual 203	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   562: astore 13
    //   564: aload 15
    //   566: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   572: ifne +13 -> 585
    //   575: aload 13
    //   577: ldc 229
    //   579: aload 15
    //   581: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   584: pop
    //   585: aload 13
    //   587: ldc 237
    //   589: iload_2
    //   590: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload 13
    //   596: ldc 245
    //   598: iload 7
    //   600: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   603: pop
    //   604: aload_3
    //   605: aload_3
    //   606: getfield 250	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   609: iconst_1
    //   610: anewarray 252	java/lang/String
    //   613: dup
    //   614: iconst_0
    //   615: aload 13
    //   617: invokevirtual 253	org/json/JSONObject:toString	()Ljava/lang/String;
    //   620: aastore
    //   621: invokevirtual 257	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   624: aload 11
    //   626: ifnull +633 -> 1259
    //   629: new 34	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   636: getstatic 54	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   639: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_1
    //   643: aload_1
    //   644: ldc_w 409
    //   647: invokevirtual 412	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   650: iconst_1
    //   651: iadd
    //   652: aload_1
    //   653: ldc_w 414
    //   656: invokevirtual 412	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   659: invokevirtual 418	java/lang/String:substring	(II)Ljava/lang/String;
    //   662: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokestatic 421	java/lang/System:currentTimeMillis	()J
    //   668: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: aload_1
    //   672: invokestatic 429	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   675: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: astore_3
    //   682: new 431	com/tencent/mm/vfs/VFSFileOutputStream
    //   685: dup
    //   686: aload_3
    //   687: invokespecial 432	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Ljava/lang/String;)V
    //   690: astore_1
    //   691: aload_1
    //   692: aload 11
    //   694: invokevirtual 390	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   697: invokevirtual 436	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   700: aload_3
    //   701: iconst_0
    //   702: invokestatic 442	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   705: astore 12
    //   707: aload_1
    //   708: astore_3
    //   709: aload 12
    //   711: astore_1
    //   712: aload 11
    //   714: ifnull +8 -> 722
    //   717: aload 11
    //   719: invokevirtual 443	java/io/ByteArrayOutputStream:close	()V
    //   722: aload_1
    //   723: astore 11
    //   725: aload_3
    //   726: ifnull +10 -> 736
    //   729: aload_3
    //   730: invokevirtual 444	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   733: aload_1
    //   734: astore 11
    //   736: aload 11
    //   738: areturn
    //   739: iload_2
    //   740: i2f
    //   741: fstore 6
    //   743: fload 5
    //   745: fstore 4
    //   747: aload 11
    //   749: astore 12
    //   751: aload 11
    //   753: invokevirtual 240	android/graphics/Bitmap:getWidth	()I
    //   756: i2f
    //   757: fstore 5
    //   759: fload 5
    //   761: fstore 4
    //   763: aload 11
    //   765: astore 12
    //   767: fload 6
    //   769: fload 5
    //   771: fdiv
    //   772: fstore 5
    //   774: fload 5
    //   776: fstore 4
    //   778: goto +510 -> 1288
    //   781: fload 5
    //   783: fstore 4
    //   785: aload 11
    //   787: astore 12
    //   789: aload 16
    //   791: fload 5
    //   793: fneg
    //   794: fload 5
    //   796: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   799: goto -419 -> 380
    //   802: astore 11
    //   804: aload 12
    //   806: astore 11
    //   808: aload 16
    //   810: fload 4
    //   812: fload 4
    //   814: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   817: aload 11
    //   819: astore 12
    //   821: aload 13
    //   823: ifnull +446 -> 1269
    //   826: aload 13
    //   828: invokevirtual 355	java/io/FileInputStream:close	()V
    //   831: goto -437 -> 394
    //   834: fload 5
    //   836: fstore 4
    //   838: aload 11
    //   840: astore 12
    //   842: aload 16
    //   844: fload 5
    //   846: fload 5
    //   848: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   851: fload 5
    //   853: fstore 4
    //   855: aload 11
    //   857: astore 12
    //   859: aload 16
    //   861: ldc_w 445
    //   864: invokevirtual 449	android/graphics/Matrix:postRotate	(F)Z
    //   867: pop
    //   868: goto -488 -> 380
    //   871: astore_1
    //   872: aload 13
    //   874: astore_3
    //   875: aload_3
    //   876: ifnull +7 -> 883
    //   879: aload_3
    //   880: invokevirtual 355	java/io/FileInputStream:close	()V
    //   883: aload_1
    //   884: athrow
    //   885: fload 5
    //   887: fneg
    //   888: fstore 6
    //   890: fload 5
    //   892: fstore 4
    //   894: aload 11
    //   896: astore 12
    //   898: aload 16
    //   900: fload 5
    //   902: fload 6
    //   904: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   907: goto -527 -> 380
    //   910: fload 5
    //   912: fstore 4
    //   914: aload 11
    //   916: astore 12
    //   918: aload 16
    //   920: fload 5
    //   922: fload 5
    //   924: fneg
    //   925: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   928: fload 5
    //   930: fstore 4
    //   932: aload 11
    //   934: astore 12
    //   936: aload 16
    //   938: ldc_w 450
    //   941: invokevirtual 449	android/graphics/Matrix:postRotate	(F)Z
    //   944: pop
    //   945: goto -565 -> 380
    //   948: fload 5
    //   950: fstore 4
    //   952: aload 11
    //   954: astore 12
    //   956: aload 16
    //   958: fload 5
    //   960: fload 5
    //   962: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   965: fload 5
    //   967: fstore 4
    //   969: aload 11
    //   971: astore 12
    //   973: aload 16
    //   975: ldc_w 450
    //   978: invokevirtual 449	android/graphics/Matrix:postRotate	(F)Z
    //   981: pop
    //   982: goto -602 -> 380
    //   985: fload 5
    //   987: fstore 4
    //   989: aload 11
    //   991: astore 12
    //   993: aload 16
    //   995: fload 5
    //   997: fneg
    //   998: fload 5
    //   1000: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   1003: fload 5
    //   1005: fstore 4
    //   1007: aload 11
    //   1009: astore 12
    //   1011: aload 16
    //   1013: ldc_w 450
    //   1016: invokevirtual 449	android/graphics/Matrix:postRotate	(F)Z
    //   1019: pop
    //   1020: goto -640 -> 380
    //   1023: fload 5
    //   1025: fstore 4
    //   1027: aload 11
    //   1029: astore 12
    //   1031: aload 16
    //   1033: fload 5
    //   1035: fload 5
    //   1037: invokevirtual 367	android/graphics/Matrix:setScale	(FF)V
    //   1040: fload 5
    //   1042: fstore 4
    //   1044: aload 11
    //   1046: astore 12
    //   1048: aload 16
    //   1050: ldc_w 451
    //   1053: invokevirtual 449	android/graphics/Matrix:postRotate	(F)Z
    //   1056: pop
    //   1057: goto -677 -> 380
    //   1060: iload 8
    //   1062: ifne +16 -> 1078
    //   1065: aload_3
    //   1066: ifnull +12 -> 1078
    //   1069: aload_3
    //   1070: getfield 98	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1073: iconst_1
    //   1074: invokevirtual 457	android/os/Handler:sendEmptyMessage	(I)Z
    //   1077: pop
    //   1078: aconst_null
    //   1079: astore 11
    //   1081: goto -578 -> 503
    //   1084: astore 11
    //   1086: aconst_null
    //   1087: astore_1
    //   1088: aload 13
    //   1090: astore_3
    //   1091: aload 11
    //   1093: invokevirtual 458	java/io/IOException:printStackTrace	()V
    //   1096: aconst_null
    //   1097: astore 12
    //   1099: aload_3
    //   1100: ifnull +7 -> 1107
    //   1103: aload_3
    //   1104: invokevirtual 443	java/io/ByteArrayOutputStream:close	()V
    //   1107: aload 12
    //   1109: astore 11
    //   1111: aload_1
    //   1112: ifnull -376 -> 736
    //   1115: aload_1
    //   1116: invokevirtual 444	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1119: aload 12
    //   1121: astore 11
    //   1123: goto -387 -> 736
    //   1126: aload 11
    //   1128: ifnull +8 -> 1136
    //   1131: aload 11
    //   1133: invokevirtual 443	java/io/ByteArrayOutputStream:close	()V
    //   1136: aload_3
    //   1137: ifnull +7 -> 1144
    //   1140: aload_3
    //   1141: invokevirtual 444	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1144: aload_1
    //   1145: athrow
    //   1146: astore_1
    //   1147: aload 12
    //   1149: astore_3
    //   1150: goto -24 -> 1126
    //   1153: astore_1
    //   1154: aload 12
    //   1156: astore_3
    //   1157: goto -31 -> 1126
    //   1160: astore 12
    //   1162: aload_1
    //   1163: astore_3
    //   1164: aload 12
    //   1166: astore_1
    //   1167: goto -41 -> 1126
    //   1170: astore 13
    //   1172: aload_1
    //   1173: astore 11
    //   1175: aload_3
    //   1176: astore 12
    //   1178: aload 13
    //   1180: astore_1
    //   1181: aload 11
    //   1183: astore_3
    //   1184: aload 12
    //   1186: astore 11
    //   1188: goto -62 -> 1126
    //   1191: astore_1
    //   1192: aload 11
    //   1194: astore_3
    //   1195: aconst_null
    //   1196: astore 12
    //   1198: aload_1
    //   1199: astore 11
    //   1201: aload 12
    //   1203: astore_1
    //   1204: goto -113 -> 1091
    //   1207: astore 12
    //   1209: aconst_null
    //   1210: astore_1
    //   1211: aload 11
    //   1213: astore_3
    //   1214: aload 12
    //   1216: astore 11
    //   1218: goto -127 -> 1091
    //   1221: astore 12
    //   1223: aload 11
    //   1225: astore_3
    //   1226: aload 12
    //   1228: astore 11
    //   1230: goto -139 -> 1091
    //   1233: astore_1
    //   1234: aconst_null
    //   1235: astore_3
    //   1236: goto -361 -> 875
    //   1239: astore_1
    //   1240: aload 13
    //   1242: astore_3
    //   1243: goto -368 -> 875
    //   1246: astore 13
    //   1248: fload 5
    //   1250: fstore 4
    //   1252: aload 12
    //   1254: astore 13
    //   1256: goto -448 -> 808
    //   1259: aconst_null
    //   1260: astore_3
    //   1261: aconst_null
    //   1262: astore_1
    //   1263: goto -551 -> 712
    //   1266: goto -763 -> 503
    //   1269: aload 12
    //   1271: astore 11
    //   1273: goto -879 -> 394
    //   1276: aconst_null
    //   1277: astore 11
    //   1279: aload 11
    //   1281: areturn
    //   1282: iconst_1
    //   1283: istore 7
    //   1285: goto -1107 -> 178
    //   1288: fload 4
    //   1290: f2d
    //   1291: ldc2_w 459
    //   1294: dcmpg
    //   1295: ifge +56 -> 1351
    //   1298: ldc_w 461
    //   1301: fstore 5
    //   1303: iload 9
    //   1305: tableswitch	default:+43 -> 1348, 2:+-524->781, 3:+-471->834, 4:+-420->885, 5:+-395->910, 6:+-357->948, 7:+-320->985, 8:+-282->1023
    //   1349: <illegal opcode>
    //   1350: dload_1
    //   1351: fconst_1
    //   1352: fstore 5
    //   1354: goto -51 -> 1303
    //   1357: astore_1
    //   1358: aconst_null
    //   1359: astore 11
    //   1361: aload 12
    //   1363: astore_3
    //   1364: goto -238 -> 1126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1367	0	paramInt1	int
    //   0	1367	1	paramString	String
    //   0	1367	2	paramInt2	int
    //   0	1367	3	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   261	1028	4	f1	float
    //   137	1216	5	f2	float
    //   323	580	6	f3	float
    //   140	1144	7	j	int
    //   71	990	8	k	int
    //   146	1158	9	m	int
    //   78	109	10	n	int
    //   100	686	11	localObject1	Object
    //   802	1	11	localIOException1	java.io.IOException
    //   806	274	11	localObject2	Object
    //   1084	8	11	localIOException2	java.io.IOException
    //   1109	251	11	localObject3	Object
    //   19	1136	12	localObject4	Object
    //   1160	5	12	localObject5	Object
    //   1176	26	12	localTroopHWJsPlugin	TroopHWJsPlugin
    //   1207	8	12	localIOException3	java.io.IOException
    //   1221	141	12	localIOException4	java.io.IOException
    //   257	832	13	localObject6	Object
    //   1170	71	13	localObject7	Object
    //   1246	1	13	localIOException5	java.io.IOException
    //   1254	1	13	localIOException6	java.io.IOException
    //   125	415	14	localBitmap	Bitmap
    //   28	552	15	localStringBuilder	StringBuilder
    //   134	915	16	localMatrix	android.graphics.Matrix
    //   37	234	17	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   30	80	297	java/lang/OutOfMemoryError
    //   106	121	297	java/lang/OutOfMemoryError
    //   127	136	297	java/lang/OutOfMemoryError
    //   290	295	297	java/lang/OutOfMemoryError
    //   389	394	297	java/lang/OutOfMemoryError
    //   394	416	297	java/lang/OutOfMemoryError
    //   423	428	297	java/lang/OutOfMemoryError
    //   428	441	297	java/lang/OutOfMemoryError
    //   447	454	297	java/lang/OutOfMemoryError
    //   717	722	297	java/lang/OutOfMemoryError
    //   729	733	297	java/lang/OutOfMemoryError
    //   826	831	297	java/lang/OutOfMemoryError
    //   879	883	297	java/lang/OutOfMemoryError
    //   883	885	297	java/lang/OutOfMemoryError
    //   1103	1107	297	java/lang/OutOfMemoryError
    //   1115	1119	297	java/lang/OutOfMemoryError
    //   1131	1136	297	java/lang/OutOfMemoryError
    //   1140	1144	297	java/lang/OutOfMemoryError
    //   1144	1146	297	java/lang/OutOfMemoryError
    //   267	277	802	java/io/IOException
    //   333	341	802	java/io/IOException
    //   349	356	802	java/io/IOException
    //   371	380	802	java/io/IOException
    //   751	759	802	java/io/IOException
    //   767	774	802	java/io/IOException
    //   789	799	802	java/io/IOException
    //   842	851	802	java/io/IOException
    //   859	868	802	java/io/IOException
    //   898	907	802	java/io/IOException
    //   918	928	802	java/io/IOException
    //   936	945	802	java/io/IOException
    //   956	965	802	java/io/IOException
    //   973	982	802	java/io/IOException
    //   993	1003	802	java/io/IOException
    //   1011	1020	802	java/io/IOException
    //   1031	1040	802	java/io/IOException
    //   1048	1057	802	java/io/IOException
    //   267	277	871	finally
    //   333	341	871	finally
    //   349	356	871	finally
    //   371	380	871	finally
    //   751	759	871	finally
    //   767	774	871	finally
    //   789	799	871	finally
    //   842	851	871	finally
    //   859	868	871	finally
    //   898	907	871	finally
    //   918	928	871	finally
    //   936	945	871	finally
    //   956	965	871	finally
    //   973	982	871	finally
    //   993	1003	871	finally
    //   1011	1020	871	finally
    //   1031	1040	871	finally
    //   1048	1057	871	finally
    //   459	471	1084	java/io/IOException
    //   1069	1078	1084	java/io/IOException
    //   471	484	1146	finally
    //   488	503	1146	finally
    //   503	534	1153	finally
    //   539	544	1153	finally
    //   548	585	1153	finally
    //   585	624	1153	finally
    //   629	691	1153	finally
    //   691	707	1160	finally
    //   1091	1096	1170	finally
    //   471	484	1191	java/io/IOException
    //   488	503	1191	java/io/IOException
    //   503	534	1207	java/io/IOException
    //   539	544	1207	java/io/IOException
    //   548	585	1207	java/io/IOException
    //   585	624	1207	java/io/IOException
    //   629	691	1207	java/io/IOException
    //   691	707	1221	java/io/IOException
    //   142	148	1233	finally
    //   183	189	1233	finally
    //   189	195	1233	finally
    //   232	259	1233	finally
    //   307	313	1233	finally
    //   808	817	1239	finally
    //   142	148	1246	java/io/IOException
    //   183	189	1246	java/io/IOException
    //   189	195	1246	java/io/IOException
    //   232	259	1246	java/io/IOException
    //   307	313	1246	java/io/IOException
    //   459	471	1357	finally
    //   1069	1078	1357	finally
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    Object localObject = "";
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    BaseApplication localBaseApplication;
    String str;
    Intent localIntent;
    do
    {
      return localObject;
      localBaseApplication = BaseApplicationImpl.getContext();
      str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE + System.currentTimeMillis() + ".jpg");
      localObject = new File(str).getParentFile();
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        QQToast.a(localBaseApplication, 2131718859, 0).a();
      }
      localIntent = new Intent();
      FileProvider7Helper.setSystemCapture(paramActivity, new File(str), localIntent);
      localObject = str;
    } while (paramActivity == null);
    try
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return str;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      QQToast.a(localBaseApplication, 2131690797, 0).a();
    }
    return str;
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: ifnull +128 -> 134
    //   9: new 373	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 376	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 382	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 386	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 390	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 396	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 524	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 443	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 458	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 520	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 524	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 443	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 458	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 524	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 443	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 458	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_0
    //   127: goto -23 -> 104
    //   130: astore_0
    //   131: goto -60 -> 71
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_2
    //   137: astore_0
    //   138: goto -95 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramBitmap	Bitmap
    //   0	141	1	paramInt	int
    //   4	56	2	localObject1	Object
    //   61	2	2	localIOException1	java.io.IOException
    //   72	41	2	localObject2	Object
    //   118	19	2	localIOException2	java.io.IOException
    //   19	117	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	77	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   9	20	68	java/lang/Exception
    //   84	92	94	java/io/IOException
    //   9	20	101	finally
    //   108	116	118	java/io/IOException
    //   22	32	126	finally
    //   34	43	126	finally
    //   73	77	126	finally
    //   22	32	130	java/lang/Exception
    //   34	43	130	java/lang/Exception
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    localStringBuilder = null;
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(paramString2);
        try
        {
          localStringBuilder = new StringBuilder();
          arrayOfByte1 = new byte[30720];
          int j = localFileInputStream.read(arrayOfByte1);
          if (j == -1) {
            continue;
          }
          if (j >= 30720) {
            continue;
          }
          byte[] arrayOfByte2 = new byte[j];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
          localStringBuilder.append(Base64Util.encodeToString(arrayOfByte2, 2));
          continue;
          if (paramString2 == null) {
            continue;
          }
        }
        finally
        {
          paramString2 = localFileInputStream;
        }
      }
      finally
      {
        FileInputStream localFileInputStream;
        byte[] arrayOfByte1;
        paramString2 = localStringBuilder;
        continue;
      }
      paramString2.close();
      throw paramString1;
      localStringBuilder.append(Base64Util.encodeToString(arrayOfByte1, 2));
    }
    if (paramTroopHWJsPlugin != null)
    {
      paramString1 = paramTroopHWJsPlugin.a(paramString1, paramInt1, 1, "stop", null, -1);
      if (!TextUtils.isEmpty(localStringBuilder.toString())) {
        paramString1.put("imgstr", localStringBuilder);
      }
      paramString1.put("width", paramInt2);
      paramString1.put("height", paramInt3);
      paramTroopHWJsPlugin.callJs(paramTroopHWJsPlugin.jdField_b_of_type_JavaLangString, new String[] { paramString1.toString() });
    }
    if (localFileInputStream != null) {
      localFileInputStream.close();
    }
    return paramString2;
  }
  
  public static void a()
  {
    int k = 0;
    Object localObject = new VFSFile(jdField_a_of_type_JavaLangString);
    int j;
    if (((VFSFile)localObject).exists())
    {
      localObject = ((VFSFile)localObject).listFiles();
      j = 0;
      while (j < localObject.length)
      {
        localObject[j].delete();
        j += 1;
      }
    }
    localObject = new VFSFile(AppConstants.SDCARD_HOMEWORK_AUDIO);
    if (((VFSFile)localObject).exists())
    {
      localObject = ((VFSFile)localObject).listFiles();
      j = k;
      while (j < localObject.length)
      {
        localObject[j].delete();
        j += 1;
      }
    }
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.mRuntime.a());
    localActionSheet.addButton(2131719037, 1);
    localActionSheet.addButton(2131719027, 1);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new TroopHWJsPlugin.2(this, paramInt, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  private void f(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131690797, 0).a();
      return;
    }
    int j;
    if ((localActivity instanceof AppActivity))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label132;
      }
      if (localActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        ((AppActivity)localActivity).requestPermissions(new TroopHWJsPlugin.3(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
        return;
        j = 0;
        continue;
      }
      this.jdField_c_of_type_JavaLangString = a(localActivity, paramInt);
      return;
      this.jdField_c_of_type_JavaLangString = a(localActivity, paramInt);
      return;
      label132:
      j = 1;
    }
  }
  
  public TroopHWJsPlugin.UploadMediaEntry a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, TroopHWJsPlugin.RequestSource paramRequestSource, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    TroopHWJsPlugin.UploadMediaEntry localUploadMediaEntry = new TroopHWJsPlugin.UploadMediaEntry(paramTroopHWJsPlugin);
    localUploadMediaEntry.jdField_a_of_type_Int = paramInt1;
    localUploadMediaEntry.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource = paramRequestSource;
    localUploadMediaEntry.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask = new TroopHomeworkHelper.UploadFileTask(paramTroopHWJsPlugin.mRuntime.a(), paramString, paramRequestSource.jdField_b_of_type_JavaLangString);
    localUploadMediaEntry.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a(localUploadMediaEntry.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback);
    localUploadMediaEntry.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    localUploadMediaEntry.jdField_b_of_type_JavaLangString = paramString;
    localUploadMediaEntry.jdField_b_of_type_Int = paramInt2;
    return localUploadMediaEntry;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = MD5Utils.toMD5(paramString2) + HWTroopUtils.a(paramString2);
    paramString1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_HOMEWORK_ATTACH + paramString1 + File.separator);
    File localFile = new File(paramString1);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString1 + paramString2;
  }
  
  public JSONObject a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("webid", paramString1);
      localJSONObject.put("state", paramString2);
      localJSONObject.put("path", "");
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("url", paramString3);
      }
      if (paramInt2 == 0)
      {
        localJSONObject.put("type", "record");
        localJSONObject.put("time", paramInt3);
        return localJSONObject;
      }
      if (paramInt2 == 2)
      {
        localJSONObject.put("type", "video");
        return localJSONObject;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return localJSONObject;
    }
    localJSONObject.put("type", "image");
    return localJSONObject;
  }
  
  protected void a(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.a())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    int j;
    if ((localActivity instanceof AppActivity))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label135;
      }
      if ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        ((AppActivity)localActivity).requestPermissions(new TroopHWJsPlugin.4(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        j = 0;
        continue;
      }
      b(paramInt);
      return;
      b(paramInt);
      return;
      label135:
      j = 1;
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    JSONObject localJSONObject = a(this.jdField_d_of_type_JavaLangString, paramInt, 2, "uploading", null, -1);
    try
    {
      localJSONObject.put("progress", paramFloat);
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString = "{'webid':'" + this.jdField_d_of_type_JavaLangString + "', 'type':'record', 'state':'downloaded', 'url':'" + paramString + "'}";
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramString });
      return;
      String str = "{'webid':'" + this.jdField_d_of_type_JavaLangString + "', 'type':'record', 'state':'stopPlay', 'url':'" + paramString + "'}";
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { str });
    } while ((this.f == null) || (!this.f.equals(paramString)));
    this.f = null;
  }
  
  public void a(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramString);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.jdField_d_of_type_Int);
      localJSONObject.put("state", "stop");
      localJSONObject.put("path", paramString);
      localJSONObject.put("time", Math.round(paramDouble / 1000.0D));
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      this.jdField_d_of_type_Int += 1;
      if (this.jdField_b_of_type_Boolean) {
        ThreadManager.post(new TroopHWJsPlugin.6(this, paramString), 2, null, false);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("url", paramString1);
      paramString2.put("state", paramInt1);
      paramString2.put("finishLen", 0);
      paramString2.put("fileLen", 0);
      if (paramInt1 == 3) {
        paramString2.put("filePath", paramString3);
      }
      callJs(this.i, new String[] { paramString2.toString() });
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("state", 2);
      localJSONObject.put("finishLen", paramLong1);
      localJSONObject.put("fileLen", paramLong2);
      callJs(this.i, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String b(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if (new File(paramString1).exists()) {
      return paramString1;
    }
    return "";
  }
  
  public void b() {}
  
  protected void b(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    WebViewProvider localWebViewProvider = this.mRuntime.a();
    if (((localActivity instanceof AbsBaseWebViewActivity)) || (localWebViewProvider != null))
    {
      Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 47);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
      localIntent.putExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
      if (paramInt == 1) {
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
      if ((localActivity instanceof AbsBaseWebViewActivity)) {
        ((AbsBaseWebViewActivity)localActivity).gotoSelectPicture(this, localIntent, (byte)3);
      }
      while (localWebViewProvider == null) {
        return;
      }
      WebViewUtil.a(this, localIntent, (byte)3, localWebViewProvider);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void b(int paramInt, String paramString)
  {
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { a(this.jdField_d_of_type_JavaLangString, paramInt, 0, "stopPlay", null, -1).toString() });
    if ((this.jdField_e_of_type_Int != -1) && (paramInt == this.jdField_e_of_type_Int)) {
      this.jdField_e_of_type_Int = -1;
    }
  }
  
  public void c() {}
  
  protected void c(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.a())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    }
    int j;
    if ((localActivity instanceof AppActivity))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label135;
      }
      if ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        ((AppActivity)localActivity).requestPermissions(new TroopHWJsPlugin.7(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        j = 0;
        continue;
      }
      d(paramInt);
      return;
      d(paramInt);
      return;
      label135:
      j = 1;
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (!TextUtils.isEmpty(paramString)) {
      super.callJs(paramString, paramVarArgs);
    }
  }
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while (!"getFileInfo".equals(paramBundle.getString("method"))) {
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(paramBundle.getLong("sessionId"));
    localForwardFileInfo.d(paramBundle.getInt("cloudType"));
    localForwardFileInfo.b(paramBundle.getInt("type"));
    localForwardFileInfo.a(paramBundle.getString("filePath"));
    localForwardFileInfo.d(paramBundle.getString("fileName"));
    localForwardFileInfo.d(paramBundle.getLong("fileSize"));
    localForwardFileInfo.a(paramBundle.getLong("troopCode"));
    paramBundle = new Intent();
    paramBundle.setClass(this.mRuntime.a(), TroopFileDetailBrowserActivity.class);
    paramBundle.putExtra("fileinfo", localForwardFileInfo);
    paramBundle.putExtra("removemementity", true);
    paramBundle.putExtra("forward_from_troop_file", true);
    paramBundle.putExtra("not_forward", true);
    paramBundle.putExtra("last_time", 0);
    this.mRuntime.a().startActivityForResult(paramBundle, 102);
  }
  
  protected void d(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    WebViewProvider localWebViewProvider = this.mRuntime.a();
    if (((localActivity instanceof AbsBaseWebViewActivity)) || (localWebViewProvider != null))
    {
      Intent localIntent = a(paramInt, localActivity, this.mRuntime.a().getCurrentAccountUin());
      if ((localActivity instanceof AbsBaseWebViewActivity)) {
        ((AbsBaseWebViewActivity)localActivity).gotoSelectPicture(this, localIntent, (byte)5);
      }
      while (localWebViewProvider == null) {
        return;
      }
      WebViewUtil.a(this, localIntent, (byte)5, localWebViewProvider);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 2L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934597L) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a();
    }
    while ((paramLong != 2L) || (!this.jdField_a_of_type_Boolean)) {
      return false;
    }
    paramString = "{'webid':" + this.jdField_d_of_type_JavaLangString + ", 'type':'home', 'state':'click'}";
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramString });
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +17 -> 18
    //   4: ldc 100
    //   6: aload_3
    //   7: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +8 -> 18
    //   13: aload 4
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 231	org/json/JSONObject
    //   23: dup
    //   24: aload 5
    //   26: iconst_0
    //   27: aaload
    //   28: invokespecial 863	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: ldc_w 865
    //   35: aload 4
    //   37: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +94 -> 134
    //   43: aload_1
    //   44: ifnull +46 -> 90
    //   47: aload_1
    //   48: ldc_w 866
    //   51: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_1
    //   58: anewarray 252	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 466
    //   66: aastore
    //   67: invokevirtual 257	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   74: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   77: astore_1
    //   78: aload_1
    //   79: ifnonnull +16 -> 95
    //   82: iconst_0
    //   83: ireturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_1
    //   87: goto -55 -> 32
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -37 -> 55
    //   95: new 133	android/content/Intent
    //   98: dup
    //   99: invokespecial 507	android/content/Intent:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc_w 871
    //   107: aload 5
    //   109: iconst_0
    //   110: aaload
    //   111: invokevirtual 160	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   114: pop
    //   115: aload_1
    //   116: iconst_m1
    //   117: aload_2
    //   118: invokevirtual 875	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   121: aload_1
    //   122: invokevirtual 878	android/app/Activity:isFinishing	()Z
    //   125: ifne +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 881	android/app/Activity:finish	()V
    //   132: iconst_1
    //   133: ireturn
    //   134: aload_1
    //   135: ifnull +102 -> 237
    //   138: aload_1
    //   139: ldc_w 883
    //   142: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 15
    //   147: aload_1
    //   148: ldc_w 660
    //   151: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 16
    //   156: aload_0
    //   157: aload 15
    //   159: putfield 250	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   162: aload_0
    //   163: aload 16
    //   165: putfield 198	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   168: aload_0
    //   169: aload_3
    //   170: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   173: aload_0
    //   174: aload_1
    //   175: ldc_w 885
    //   178: ldc_w 466
    //   181: invokevirtual 887	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   184: putfield 889	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload_0
    //   188: aload_1
    //   189: ldc_w 891
    //   192: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   195: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   198: aload_0
    //   199: aload_1
    //   200: ldc_w 896
    //   203: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   206: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   209: aload_0
    //   210: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   213: ifne +10 -> 223
    //   216: aload_0
    //   217: sipush 540
    //   220: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   223: aload_0
    //   224: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   227: ifne +10 -> 237
    //   230: aload_0
    //   231: sipush 540
    //   234: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   237: ldc_w 898
    //   240: aload 4
    //   242: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifeq +73 -> 318
    //   248: aload_0
    //   249: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   252: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   255: astore_1
    //   256: new 133	android/content/Intent
    //   259: dup
    //   260: invokespecial 507	android/content/Intent:<init>	()V
    //   263: astore_2
    //   264: aload_2
    //   265: new 900	android/content/ComponentName
    //   268: dup
    //   269: aload_1
    //   270: ldc_w 902
    //   273: invokespecial 903	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   276: invokevirtual 907	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 660
    //   284: aload_0
    //   285: getfield 198	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   288: invokevirtual 160	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   291: pop
    //   292: aload_0
    //   293: getfield 250	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   296: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifeq +10 -> 309
    //   302: aload_1
    //   303: aload_2
    //   304: invokevirtual 911	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   307: iconst_1
    //   308: ireturn
    //   309: aload_0
    //   310: aload_2
    //   311: iconst_1
    //   312: invokevirtual 914	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   315: goto -8 -> 307
    //   318: ldc_w 916
    //   321: aload 4
    //   323: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifeq +110 -> 436
    //   329: iconst_m1
    //   330: istore 6
    //   332: aload_1
    //   333: ifnull +12 -> 345
    //   336: aload_1
    //   337: ldc_w 658
    //   340: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   343: istore 6
    //   345: aload_0
    //   346: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   349: iconst_m1
    //   350: if_icmpne +36 -> 386
    //   353: aload_0
    //   354: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   357: iload 6
    //   359: aload_0
    //   360: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   363: iload 6
    //   365: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: invokevirtual 920	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 252	java/lang/String
    //   374: invokevirtual 922	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   377: aload_0
    //   378: iload 6
    //   380: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   383: goto -76 -> 307
    //   386: iload 6
    //   388: aload_0
    //   389: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   392: if_icmpeq -85 -> 307
    //   395: aload_0
    //   396: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   399: invokevirtual 852	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   402: pop
    //   403: aload_0
    //   404: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   407: iload 6
    //   409: aload_0
    //   410: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   413: iload 6
    //   415: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: invokevirtual 920	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   421: checkcast 252	java/lang/String
    //   424: invokevirtual 922	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   427: aload_0
    //   428: iload 6
    //   430: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   433: goto -126 -> 307
    //   436: ldc_w 924
    //   439: aload 4
    //   441: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   444: ifeq +49 -> 493
    //   447: aload_1
    //   448: ifnull +2479 -> 2927
    //   451: aload_1
    //   452: ldc_w 658
    //   455: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   458: istore 6
    //   460: aload_0
    //   461: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   464: iconst_m1
    //   465: if_icmpeq -158 -> 307
    //   468: iload 6
    //   470: aload_0
    //   471: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   474: if_icmpne -167 -> 307
    //   477: aload_0
    //   478: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   481: invokevirtual 852	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   484: pop
    //   485: aload_0
    //   486: iconst_m1
    //   487: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   490: goto -183 -> 307
    //   493: ldc_w 926
    //   496: aload 4
    //   498: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   501: ifeq +211 -> 712
    //   504: bipush 10
    //   506: istore 7
    //   508: iconst_0
    //   509: istore 6
    //   511: aload_1
    //   512: ifnull +34 -> 546
    //   515: aload_1
    //   516: ldc_w 928
    //   519: bipush 10
    //   521: invokevirtual 931	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   524: istore 7
    //   526: aload_0
    //   527: aload_1
    //   528: ldc_w 891
    //   531: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   534: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   537: aload_1
    //   538: ldc_w 933
    //   541: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   544: istore 6
    //   546: iload 6
    //   548: iconst_1
    //   549: if_icmpne +20 -> 569
    //   552: aload_0
    //   553: ldc 100
    //   555: invokestatic 935	com/tencent/mobileqq/webview/swift/WebViewUtil:a	(Ljava/lang/String;)I
    //   558: bipush 8
    //   560: ishl
    //   561: iconst_2
    //   562: iadd
    //   563: invokespecial 546	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	(I)V
    //   566: goto -259 -> 307
    //   569: iload 6
    //   571: iconst_2
    //   572: if_icmpne +12 -> 584
    //   575: aload_0
    //   576: iload 7
    //   578: invokevirtual 937	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   581: goto -274 -> 307
    //   584: iload 6
    //   586: iconst_3
    //   587: if_icmpne +116 -> 703
    //   590: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   593: ifeq +30 -> 623
    //   596: ldc_w 268
    //   599: iconst_2
    //   600: new 34	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   607: ldc_w 939
    //   610: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload_1
    //   614: invokevirtual 942	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload_0
    //   624: getfield 250	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   627: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   630: ifne +13 -> 643
    //   633: aload_0
    //   634: getfield 889	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   637: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   640: ifeq +54 -> 694
    //   643: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +46 -> 692
    //   649: ldc_w 268
    //   652: iconst_2
    //   653: new 34	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 946
    //   663: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_0
    //   667: getfield 250	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   670: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc_w 948
    //   676: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_0
    //   680: getfield 889	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   683: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 277	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: iconst_1
    //   693: ireturn
    //   694: aload_0
    //   695: iload 7
    //   697: invokevirtual 950	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   700: goto -393 -> 307
    //   703: aload_0
    //   704: iload 7
    //   706: invokespecial 952	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(I)V
    //   709: goto -402 -> 307
    //   712: ldc_w 954
    //   715: aload 4
    //   717: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   720: ifeq +187 -> 907
    //   723: lconst_0
    //   724: lstore 8
    //   726: bipush 102
    //   728: istore 6
    //   730: aconst_null
    //   731: astore 5
    //   733: aconst_null
    //   734: astore 4
    //   736: aload_1
    //   737: ifnull +2181 -> 2918
    //   740: aload_1
    //   741: ldc_w 956
    //   744: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   747: astore 5
    //   749: aload_1
    //   750: ldc_w 958
    //   753: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: astore 4
    //   758: aload_1
    //   759: ldc_w 885
    //   762: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   765: astore 15
    //   767: aload_1
    //   768: ldc_w 960
    //   771: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   774: astore_3
    //   775: aload_1
    //   776: ldc_w 962
    //   779: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   782: astore_2
    //   783: aload 15
    //   785: astore_1
    //   786: aload_3
    //   787: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   790: ifne +12 -> 802
    //   793: aload_3
    //   794: invokestatic 967	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   797: invokevirtual 970	java/lang/Long:longValue	()J
    //   800: lstore 8
    //   802: aload_2
    //   803: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   806: ifne +12 -> 818
    //   809: aload_2
    //   810: invokestatic 973	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   813: invokevirtual 976	java/lang/Integer:intValue	()I
    //   816: istore 6
    //   818: aload_1
    //   819: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   822: ifne +66 -> 888
    //   825: aload_0
    //   826: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   829: aload_1
    //   830: invokestatic 967	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   833: invokevirtual 970	java/lang/Long:longValue	()J
    //   836: aload 4
    //   838: aload 5
    //   840: lload 8
    //   842: iload 6
    //   844: aload_0
    //   845: invokevirtual 981	com/tencent/biz/troop/TroopMemberApiClient:a	(JLjava/lang/String;Ljava/lang/String;JILcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   848: goto -541 -> 307
    //   851: astore_2
    //   852: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq -548 -> 307
    //   858: ldc_w 268
    //   861: iconst_2
    //   862: new 34	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   869: ldc_w 983
    //   872: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: aload_1
    //   876: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokestatic 985	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: goto -578 -> 307
    //   888: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq -584 -> 307
    //   894: ldc_w 268
    //   897: iconst_2
    //   898: ldc_w 987
    //   901: invokestatic 985	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: goto -597 -> 307
    //   907: ldc_w 989
    //   910: aload 4
    //   912: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   915: ifeq +73 -> 988
    //   918: aload_1
    //   919: ifnull +1992 -> 2911
    //   922: aload_1
    //   923: ldc_w 666
    //   926: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   929: astore_1
    //   930: aload_0
    //   931: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   934: ifnonnull +19 -> 953
    //   937: aload_0
    //   938: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   941: aload_1
    //   942: invokevirtual 990	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(Ljava/lang/String;)V
    //   945: aload_0
    //   946: aload_1
    //   947: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   950: goto -643 -> 307
    //   953: aload_0
    //   954: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   957: aload_1
    //   958: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   961: ifne -654 -> 307
    //   964: aload_0
    //   965: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   968: invokevirtual 852	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   971: pop
    //   972: aload_0
    //   973: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   976: aload_1
    //   977: invokevirtual 990	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(Ljava/lang/String;)V
    //   980: aload_0
    //   981: aload_1
    //   982: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   985: goto -678 -> 307
    //   988: ldc_w 992
    //   991: aload 4
    //   993: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   996: ifeq +49 -> 1045
    //   999: aload_1
    //   1000: ifnull +1904 -> 2904
    //   1003: aload_1
    //   1004: ldc_w 666
    //   1007: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1010: astore_1
    //   1011: aload_0
    //   1012: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1015: ifnull -708 -> 307
    //   1018: aload_0
    //   1019: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1022: aload_1
    //   1023: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1026: ifeq -719 -> 307
    //   1029: aload_0
    //   1030: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1033: invokevirtual 852	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   1036: pop
    //   1037: aload_0
    //   1038: aconst_null
    //   1039: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1042: goto -735 -> 307
    //   1045: ldc_w 994
    //   1048: aload 4
    //   1050: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1053: ifeq +23 -> 1076
    //   1056: aload_0
    //   1057: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1060: aload_0
    //   1061: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1064: invokevirtual 620	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1067: invokevirtual 997	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1070: invokevirtual 998	cooperation/troop_homework/jsp/TroopHWVoiceController:d	(Ljava/lang/String;)V
    //   1073: goto -766 -> 307
    //   1076: ldc_w 1000
    //   1079: aload 4
    //   1081: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1084: ifeq +39 -> 1123
    //   1087: aload_1
    //   1088: ifnull +25 -> 1113
    //   1091: aload_0
    //   1092: aload_1
    //   1093: ldc_w 1002
    //   1096: invokevirtual 1006	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1099: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1102: aload_0
    //   1103: aload_1
    //   1104: ldc_w 1008
    //   1107: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1110: putfield 82	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1113: aload_0
    //   1114: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1117: invokevirtual 1010	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()V
    //   1120: goto -813 -> 307
    //   1123: ldc_w 1012
    //   1126: aload 4
    //   1128: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1131: ifeq +25 -> 1156
    //   1134: new 1014	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1137: dup
    //   1138: aload_0
    //   1139: aload_2
    //   1140: invokestatic 1019	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   1143: invokespecial 1020	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1146: bipush 8
    //   1148: aconst_null
    //   1149: iconst_0
    //   1150: invokestatic 735	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1153: goto -846 -> 307
    //   1156: ldc_w 1022
    //   1159: aload 4
    //   1161: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1164: ifeq +54 -> 1218
    //   1167: aload_1
    //   1168: ifnull -861 -> 307
    //   1171: aload_1
    //   1172: ldc_w 666
    //   1175: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1178: astore_2
    //   1179: aload_1
    //   1180: ldc_w 1024
    //   1183: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1186: astore_3
    //   1187: aload_0
    //   1188: aload_1
    //   1189: ldc_w 883
    //   1192: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1195: putfield 744	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1198: aload_0
    //   1199: aload_3
    //   1200: aload_2
    //   1201: invokevirtual 747	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1204: astore_1
    //   1205: aload_0
    //   1206: getfield 1026	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1209: aload_2
    //   1210: aload_1
    //   1211: aload_0
    //   1212: invokevirtual 1031	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;Ljava/lang/String;Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager$OnDownloadStateListener;)V
    //   1215: goto -908 -> 307
    //   1218: ldc_w 1033
    //   1221: aload 4
    //   1223: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1226: ifeq +26 -> 1252
    //   1229: aload_1
    //   1230: ifnull -923 -> 307
    //   1233: aload_1
    //   1234: ldc_w 666
    //   1237: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1240: astore_1
    //   1241: aload_0
    //   1242: getfield 1026	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1245: aload_1
    //   1246: invokevirtual 1034	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;)V
    //   1249: goto -942 -> 307
    //   1252: ldc_w 1036
    //   1255: aload 4
    //   1257: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1260: ifeq +194 -> 1454
    //   1263: aload_1
    //   1264: ifnull -957 -> 307
    //   1267: aload_1
    //   1268: ldc_w 1024
    //   1271: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1274: astore 4
    //   1276: aload_1
    //   1277: ldc_w 1038
    //   1280: invokevirtual 1042	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1283: astore 5
    //   1285: aload_1
    //   1286: ldc_w 883
    //   1289: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1292: astore_2
    //   1293: new 231	org/json/JSONObject
    //   1296: dup
    //   1297: invokespecial 656	org/json/JSONObject:<init>	()V
    //   1300: astore_3
    //   1301: new 1044	org/json/JSONArray
    //   1304: dup
    //   1305: invokespecial 1045	org/json/JSONArray:<init>	()V
    //   1308: astore 15
    //   1310: aload 5
    //   1312: invokevirtual 1047	org/json/JSONArray:length	()I
    //   1315: istore 7
    //   1317: iconst_0
    //   1318: istore 6
    //   1320: iload 6
    //   1322: iload 7
    //   1324: if_icmpge +33 -> 1357
    //   1327: aload 15
    //   1329: iload 6
    //   1331: aload_0
    //   1332: aload 4
    //   1334: aload 5
    //   1336: iload 6
    //   1338: invokevirtual 1050	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1341: invokevirtual 1052	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1344: invokevirtual 1055	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1347: pop
    //   1348: iload 6
    //   1350: iconst_1
    //   1351: iadd
    //   1352: istore 6
    //   1354: goto -34 -> 1320
    //   1357: aload_3
    //   1358: ldc_w 1057
    //   1361: aload 15
    //   1363: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1366: pop
    //   1367: aload_3
    //   1368: invokevirtual 253	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1371: astore_3
    //   1372: aload_0
    //   1373: aload_2
    //   1374: iconst_1
    //   1375: anewarray 252	java/lang/String
    //   1378: dup
    //   1379: iconst_0
    //   1380: aload_3
    //   1381: aastore
    //   1382: invokevirtual 257	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1385: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1388: ifeq -1081 -> 307
    //   1391: ldc_w 268
    //   1394: iconst_2
    //   1395: new 34	java/lang/StringBuilder
    //   1398: dup
    //   1399: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1402: ldc_w 1059
    //   1405: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: aload_1
    //   1409: invokevirtual 942	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1412: ldc_w 1061
    //   1415: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: aload_3
    //   1419: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1425: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1428: goto -1121 -> 307
    //   1431: astore 4
    //   1433: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1436: ifeq -69 -> 1367
    //   1439: ldc_w 268
    //   1442: iconst_2
    //   1443: ldc_w 1059
    //   1446: aload 4
    //   1448: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1451: goto -84 -> 1367
    //   1454: ldc_w 1066
    //   1457: aload 4
    //   1459: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1462: ifeq +68 -> 1530
    //   1465: aload_1
    //   1466: ifnull -1159 -> 307
    //   1469: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1472: ifeq +30 -> 1502
    //   1475: ldc_w 268
    //   1478: iconst_2
    //   1479: new 34	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1486: ldc_w 1068
    //   1489: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: aload_1
    //   1493: invokevirtual 942	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1502: aload_1
    //   1503: ldc_w 1070
    //   1506: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1509: astore_2
    //   1510: aload_1
    //   1511: ldc_w 1072
    //   1514: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1517: astore_1
    //   1518: aload_0
    //   1519: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1522: aload_2
    //   1523: aload_1
    //   1524: invokevirtual 1075	com/tencent/biz/troop/TroopMemberApiClient:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1527: goto -1220 -> 307
    //   1530: ldc_w 1077
    //   1533: aload 4
    //   1535: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1538: ifeq +58 -> 1596
    //   1541: aload_1
    //   1542: ifnull +54 -> 1596
    //   1545: aload_1
    //   1546: ldc_w 668
    //   1549: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1552: pop
    //   1553: aload_1
    //   1554: ldc_w 658
    //   1557: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1560: istore 6
    //   1562: aload_0
    //   1563: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1566: iload 6
    //   1568: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1571: invokevirtual 920	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1574: checkcast 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1577: astore_1
    //   1578: aload_1
    //   1579: ifnull -1272 -> 307
    //   1582: aload_1
    //   1583: getfield 1078	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Boolean	Z
    //   1586: ifne -1279 -> 307
    //   1589: aload_1
    //   1590: invokevirtual 1080	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:b	()V
    //   1593: goto -1286 -> 307
    //   1596: ldc_w 1082
    //   1599: aload 4
    //   1601: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1604: ifeq +62 -> 1666
    //   1607: aload_1
    //   1608: ifnull +58 -> 1666
    //   1611: aload_1
    //   1612: ldc_w 668
    //   1615: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1618: pop
    //   1619: aload_1
    //   1620: ldc_w 658
    //   1623: invokevirtual 894	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1626: istore 6
    //   1628: aload_0
    //   1629: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1632: iload 6
    //   1634: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1637: invokevirtual 920	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1640: checkcast 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1643: astore_1
    //   1644: aload_1
    //   1645: ifnull -1338 -> 307
    //   1648: aload_1
    //   1649: getfield 1078	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Boolean	Z
    //   1652: ifeq -1345 -> 307
    //   1655: aload_1
    //   1656: getfield 1085	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1659: iconst_1
    //   1660: invokevirtual 1091	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1663: goto -1356 -> 307
    //   1666: ldc_w 1093
    //   1669: aload 4
    //   1671: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1674: ifeq +83 -> 1757
    //   1677: aload_1
    //   1678: ifnull -1371 -> 307
    //   1681: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1684: ifeq +24 -> 1708
    //   1687: ldc_w 268
    //   1690: iconst_2
    //   1691: iconst_2
    //   1692: anewarray 148	java/lang/Object
    //   1695: dup
    //   1696: iconst_0
    //   1697: ldc_w 1095
    //   1700: aastore
    //   1701: dup
    //   1702: iconst_1
    //   1703: aload_1
    //   1704: aastore
    //   1705: invokestatic 407	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1708: aload_1
    //   1709: ldc_w 1024
    //   1712: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1715: astore_2
    //   1716: aload_1
    //   1717: ldc_w 668
    //   1720: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1723: astore_1
    //   1724: aload_0
    //   1725: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1728: aload_2
    //   1729: aload_1
    //   1730: invokevirtual 1097	com/tencent/biz/troop/TroopMemberApiClient:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1733: goto -1426 -> 307
    //   1736: astore_1
    //   1737: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1740: ifeq -1433 -> 307
    //   1743: ldc_w 268
    //   1746: iconst_2
    //   1747: ldc_w 1099
    //   1750: aload_1
    //   1751: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1754: goto -1447 -> 307
    //   1757: ldc_w 1101
    //   1760: aload 4
    //   1762: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1765: ifeq +167 -> 1932
    //   1768: aload_1
    //   1769: ifnull -1462 -> 307
    //   1772: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1775: ifeq +30 -> 1805
    //   1778: ldc_w 268
    //   1781: iconst_2
    //   1782: new 34	java/lang/StringBuilder
    //   1785: dup
    //   1786: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1789: ldc_w 1103
    //   1792: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: aload_1
    //   1796: invokevirtual 942	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1799: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1802: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1805: aload_1
    //   1806: ldc_w 658
    //   1809: iconst_0
    //   1810: invokevirtual 931	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1813: istore 6
    //   1815: aload_0
    //   1816: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1819: iload 6
    //   1821: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1824: invokevirtual 920	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1827: checkcast 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1830: astore_2
    //   1831: aload_2
    //   1832: ifnull +70 -> 1902
    //   1835: aload_2
    //   1836: getfield 639	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1839: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1842: ifne +60 -> 1902
    //   1845: new 784	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1848: dup
    //   1849: invokespecial 785	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1852: astore_1
    //   1853: aload_1
    //   1854: aload_2
    //   1855: getfield 639	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1858: invokevirtual 803	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1861: new 133	android/content/Intent
    //   1864: dup
    //   1865: aload_0
    //   1866: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1869: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1872: ldc_w 817
    //   1875: invokespecial 138	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1878: astore_2
    //   1879: aload_2
    //   1880: ldc_w 823
    //   1883: aload_1
    //   1884: invokevirtual 826	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1887: pop
    //   1888: aload_0
    //   1889: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1892: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1895: aload_2
    //   1896: invokevirtual 911	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1899: goto -1592 -> 307
    //   1902: ldc_w 268
    //   1905: iconst_1
    //   1906: new 34	java/lang/StringBuilder
    //   1909: dup
    //   1910: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1913: ldc_w 1105
    //   1916: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: aload_2
    //   1920: invokevirtual 942	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1923: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1926: invokestatic 985	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1929: goto -1622 -> 307
    //   1932: ldc_w 1107
    //   1935: aload 4
    //   1937: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1940: ifeq +18 -> 1958
    //   1943: aload_0
    //   1944: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1947: invokevirtual 1110	java/util/HashMap:clear	()V
    //   1950: aload_0
    //   1951: iconst_1
    //   1952: putfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   1955: goto -1648 -> 307
    //   1958: ldc_w 1112
    //   1961: aload 4
    //   1963: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1966: ifeq +77 -> 2043
    //   1969: aload_1
    //   1970: ifnull -1663 -> 307
    //   1973: aload_1
    //   1974: ldc_w 658
    //   1977: iconst_0
    //   1978: invokevirtual 931	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1981: istore 6
    //   1983: aload_0
    //   1984: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1987: iload 6
    //   1989: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1992: invokevirtual 920	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1995: checkcast 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1998: astore_1
    //   1999: aload_1
    //   2000: ifnull -1693 -> 307
    //   2003: aload_1
    //   2004: getfield 639	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2007: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2010: ifne -1703 -> 307
    //   2013: new 292	java/io/File
    //   2016: dup
    //   2017: aload_1
    //   2018: getfield 639	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2021: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   2024: astore_2
    //   2025: aload_0
    //   2026: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2029: aload_1
    //   2030: getfield 639	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2033: aload_2
    //   2034: invokevirtual 1113	java/io/File:getName	()Ljava/lang/String;
    //   2037: invokevirtual 1075	com/tencent/biz/troop/TroopMemberApiClient:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2040: goto -1733 -> 307
    //   2043: ldc_w 1115
    //   2046: aload 4
    //   2048: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2051: ifeq +94 -> 2145
    //   2054: aload_1
    //   2055: ifnull +78 -> 2133
    //   2058: ldc_w 268
    //   2061: ldc_w 1117
    //   2064: aload_1
    //   2065: invokestatic 1122	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   2068: aload_1
    //   2069: ldc_w 1124
    //   2072: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2075: astore_2
    //   2076: aload_1
    //   2077: ldc_w 1126
    //   2080: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2083: astore_3
    //   2084: aload_1
    //   2085: ldc_w 1128
    //   2088: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2091: astore 4
    //   2093: aload_1
    //   2094: ldc_w 1130
    //   2097: invokevirtual 869	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2100: astore_1
    //   2101: aload_0
    //   2102: aload_0
    //   2103: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2106: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2109: aload_2
    //   2110: aload_3
    //   2111: aload_0
    //   2112: getfield 250	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2115: aload 4
    //   2117: aload_0
    //   2118: getfield 889	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2121: aload_1
    //   2122: invokestatic 1135	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2125: bipush 6
    //   2127: invokevirtual 914	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2130: goto -1823 -> 307
    //   2133: ldc_w 268
    //   2136: ldc_w 1137
    //   2139: invokestatic 1138	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2142: goto -1835 -> 307
    //   2145: ldc_w 1140
    //   2148: aload 4
    //   2150: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2153: ifeq +186 -> 2339
    //   2156: new 231	org/json/JSONObject
    //   2159: dup
    //   2160: aload 5
    //   2162: iconst_0
    //   2163: aaload
    //   2164: invokespecial 863	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2167: ldc_w 1142
    //   2170: invokevirtual 1143	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2173: astore_2
    //   2174: aload_2
    //   2175: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2178: istore 14
    //   2180: iload 14
    //   2182: ifne -1875 -> 307
    //   2185: lconst_0
    //   2186: lstore 8
    //   2188: aload_2
    //   2189: invokestatic 1146	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2192: lstore 10
    //   2194: lload 10
    //   2196: lstore 8
    //   2198: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2201: ifeq +31 -> 2232
    //   2204: ldc_w 268
    //   2207: iconst_2
    //   2208: new 34	java/lang/StringBuilder
    //   2211: dup
    //   2212: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2215: ldc_w 1148
    //   2218: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2221: lload 8
    //   2223: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2226: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2229: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2232: lload 8
    //   2234: lconst_0
    //   2235: lcmp
    //   2236: ifle +67 -> 2303
    //   2239: aload_0
    //   2240: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2243: ifnull +55 -> 2298
    //   2246: aload_0
    //   2247: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2250: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2253: astore_1
    //   2254: aload_1
    //   2255: ifnull -1948 -> 307
    //   2258: aload_1
    //   2259: aconst_null
    //   2260: aload_2
    //   2261: invokestatic 1153	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2264: aload_1
    //   2265: ldc_w 1154
    //   2268: ldc_w 1155
    //   2271: invokevirtual 1158	android/app/Activity:overridePendingTransition	(II)V
    //   2274: goto -1967 -> 307
    //   2277: astore_1
    //   2278: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2281: ifeq -1974 -> 307
    //   2284: ldc_w 268
    //   2287: iconst_2
    //   2288: ldc_w 1160
    //   2291: aload_1
    //   2292: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2295: goto -1988 -> 307
    //   2298: aconst_null
    //   2299: astore_1
    //   2300: goto -46 -> 2254
    //   2303: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2306: ifeq -1999 -> 307
    //   2309: ldc_w 268
    //   2312: iconst_2
    //   2313: new 34	java/lang/StringBuilder
    //   2316: dup
    //   2317: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2320: ldc_w 1162
    //   2323: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: aload_2
    //   2327: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2333: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2336: goto -2029 -> 307
    //   2339: ldc_w 1164
    //   2342: aload 4
    //   2344: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2347: ifeq +245 -> 2592
    //   2350: new 231	org/json/JSONObject
    //   2353: dup
    //   2354: aload 5
    //   2356: iconst_0
    //   2357: aaload
    //   2358: invokespecial 863	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2361: astore_1
    //   2362: aload_1
    //   2363: ldc_w 1166
    //   2366: invokevirtual 1143	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2369: astore_2
    //   2370: aload_2
    //   2371: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2374: istore 14
    //   2376: iload 14
    //   2378: ifne -2071 -> 307
    //   2381: aload_2
    //   2382: invokestatic 1146	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2385: lstore 10
    //   2387: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2390: ifeq +31 -> 2421
    //   2393: ldc_w 268
    //   2396: iconst_2
    //   2397: new 34	java/lang/StringBuilder
    //   2400: dup
    //   2401: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2404: ldc_w 1168
    //   2407: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2410: lload 10
    //   2412: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2415: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2418: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2421: aload_1
    //   2422: ldc_w 1142
    //   2425: invokevirtual 1143	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2428: astore_1
    //   2429: lconst_0
    //   2430: lstore 8
    //   2432: aload_1
    //   2433: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2436: istore 14
    //   2438: lload 8
    //   2440: lstore 12
    //   2442: iload 14
    //   2444: ifne +55 -> 2499
    //   2447: aload_1
    //   2448: invokestatic 1146	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2451: lstore 12
    //   2453: lload 12
    //   2455: lstore 8
    //   2457: lload 8
    //   2459: lstore 12
    //   2461: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2464: ifeq +35 -> 2499
    //   2467: ldc_w 268
    //   2470: iconst_2
    //   2471: new 34	java/lang/StringBuilder
    //   2474: dup
    //   2475: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2478: ldc_w 1148
    //   2481: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2484: lload 8
    //   2486: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2489: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2492: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2495: lload 8
    //   2497: lstore 12
    //   2499: lload 10
    //   2501: lconst_0
    //   2502: lcmp
    //   2503: ifle -2196 -> 307
    //   2506: lload 12
    //   2508: lconst_0
    //   2509: lcmp
    //   2510: ifle -2203 -> 307
    //   2513: aload_0
    //   2514: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2517: ifnull +70 -> 2587
    //   2520: aload_0
    //   2521: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2524: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2527: astore_1
    //   2528: aload_0
    //   2529: aload_1
    //   2530: lload 12
    //   2532: lload 10
    //   2534: invokestatic 1173	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2537: bipush 7
    //   2539: invokevirtual 914	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2542: aload_1
    //   2543: ifnull -2236 -> 307
    //   2546: aload_1
    //   2547: ldc_w 1154
    //   2550: ldc_w 1155
    //   2553: invokevirtual 1158	android/app/Activity:overridePendingTransition	(II)V
    //   2556: goto -2249 -> 307
    //   2559: astore_1
    //   2560: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2563: ifeq -2256 -> 307
    //   2566: ldc_w 268
    //   2569: iconst_2
    //   2570: ldc_w 1160
    //   2573: aload_1
    //   2574: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2577: goto -2270 -> 307
    //   2580: astore_2
    //   2581: lconst_0
    //   2582: lstore 10
    //   2584: goto -197 -> 2387
    //   2587: aconst_null
    //   2588: astore_1
    //   2589: goto -61 -> 2528
    //   2592: ldc_w 1175
    //   2595: aload 4
    //   2597: invokevirtual 709	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2600: ifeq -2293 -> 307
    //   2603: new 231	org/json/JSONObject
    //   2606: dup
    //   2607: aload 5
    //   2609: iconst_0
    //   2610: aaload
    //   2611: invokespecial 863	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2614: astore_2
    //   2615: aload_2
    //   2616: ldc_w 1166
    //   2619: invokevirtual 1143	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2622: astore_1
    //   2623: aload_2
    //   2624: ldc_w 1142
    //   2627: invokevirtual 1143	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2630: astore_2
    //   2631: aload_1
    //   2632: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2635: ifne +211 -> 2846
    //   2638: aload_2
    //   2639: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2642: istore 14
    //   2644: iload 14
    //   2646: ifne +200 -> 2846
    //   2649: aload_1
    //   2650: invokestatic 1146	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2653: lstore 8
    //   2655: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2658: ifeq +31 -> 2689
    //   2661: ldc_w 268
    //   2664: iconst_2
    //   2665: new 34	java/lang/StringBuilder
    //   2668: dup
    //   2669: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2672: ldc_w 1177
    //   2675: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2678: lload 8
    //   2680: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2683: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2686: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2689: lconst_0
    //   2690: lstore 10
    //   2692: aload_2
    //   2693: invokestatic 1146	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2696: lstore 12
    //   2698: lload 12
    //   2700: lstore 10
    //   2702: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2705: ifeq +31 -> 2736
    //   2708: ldc_w 268
    //   2711: iconst_2
    //   2712: new 34	java/lang/StringBuilder
    //   2715: dup
    //   2716: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2719: ldc_w 1179
    //   2722: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2725: lload 10
    //   2727: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2730: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2733: invokestatic 944	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2736: lload 8
    //   2738: lconst_0
    //   2739: lcmp
    //   2740: ifle -2433 -> 307
    //   2743: lload 10
    //   2745: lconst_0
    //   2746: lcmp
    //   2747: ifle -2440 -> 307
    //   2750: aload_0
    //   2751: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2754: ifnull +87 -> 2841
    //   2757: aload_0
    //   2758: getfield 556	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2761: invokevirtual 561	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2764: astore_1
    //   2765: new 779	android/os/Bundle
    //   2768: dup
    //   2769: invokespecial 1180	android/os/Bundle:<init>	()V
    //   2772: astore_3
    //   2773: aload_3
    //   2774: ldc_w 1166
    //   2777: lload 8
    //   2779: invokevirtual 1184	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2782: aload_3
    //   2783: ldc_w 1186
    //   2786: iconst_2
    //   2787: invokevirtual 1190	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2790: aload_1
    //   2791: ifnull -2484 -> 307
    //   2794: aload_1
    //   2795: aload_3
    //   2796: aload_2
    //   2797: invokestatic 1153	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2800: aload_1
    //   2801: ldc_w 1154
    //   2804: ldc_w 1155
    //   2807: invokevirtual 1158	android/app/Activity:overridePendingTransition	(II)V
    //   2810: goto -2503 -> 307
    //   2813: astore_1
    //   2814: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2817: ifeq -2510 -> 307
    //   2820: ldc_w 268
    //   2823: iconst_2
    //   2824: ldc_w 1160
    //   2827: aload_1
    //   2828: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2831: goto -2524 -> 307
    //   2834: astore_1
    //   2835: lconst_0
    //   2836: lstore 8
    //   2838: goto -183 -> 2655
    //   2841: aconst_null
    //   2842: astore_1
    //   2843: goto -78 -> 2765
    //   2846: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2849: ifeq -2542 -> 307
    //   2852: ldc_w 268
    //   2855: iconst_2
    //   2856: new 34	java/lang/StringBuilder
    //   2859: dup
    //   2860: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2863: ldc_w 1192
    //   2866: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2869: aload_1
    //   2870: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: ldc_w 1194
    //   2876: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2879: aload_2
    //   2880: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2883: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2886: invokestatic 985	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2889: goto -2582 -> 307
    //   2892: astore_1
    //   2893: goto -695 -> 2198
    //   2896: astore_1
    //   2897: goto -440 -> 2457
    //   2900: astore_1
    //   2901: goto -199 -> 2702
    //   2904: ldc_w 466
    //   2907: astore_1
    //   2908: goto -1897 -> 1011
    //   2911: ldc_w 466
    //   2914: astore_1
    //   2915: goto -1985 -> 930
    //   2918: aconst_null
    //   2919: astore_2
    //   2920: aconst_null
    //   2921: astore_1
    //   2922: aconst_null
    //   2923: astore_3
    //   2924: goto -2138 -> 786
    //   2927: iconst_m1
    //   2928: istore 6
    //   2930: goto -2470 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2933	0	this	TroopHWJsPlugin
    //   0	2933	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2933	2	paramString1	String
    //   0	2933	3	paramString2	String
    //   0	2933	4	paramString3	String
    //   0	2933	5	paramVarArgs	String[]
    //   330	2599	6	j	int
    //   506	819	7	k	int
    //   724	2113	8	l1	long
    //   2192	552	10	l2	long
    //   2440	259	12	l3	long
    //   2178	467	14	bool	boolean
    //   145	1217	15	localObject	Object
    //   154	10	16	str	String
    // Exception table:
    //   from	to	target	type
    //   20	32	84	org/json/JSONException
    //   818	848	851	java/lang/NumberFormatException
    //   888	904	851	java/lang/NumberFormatException
    //   1301	1317	1431	java/lang/Exception
    //   1327	1348	1431	java/lang/Exception
    //   1357	1367	1431	java/lang/Exception
    //   1708	1733	1736	java/lang/Exception
    //   2156	2180	2277	java/lang/Exception
    //   2198	2232	2277	java/lang/Exception
    //   2239	2254	2277	java/lang/Exception
    //   2258	2274	2277	java/lang/Exception
    //   2303	2336	2277	java/lang/Exception
    //   2350	2376	2559	java/lang/Exception
    //   2387	2421	2559	java/lang/Exception
    //   2421	2429	2559	java/lang/Exception
    //   2432	2438	2559	java/lang/Exception
    //   2461	2495	2559	java/lang/Exception
    //   2513	2528	2559	java/lang/Exception
    //   2528	2542	2559	java/lang/Exception
    //   2546	2556	2559	java/lang/Exception
    //   2381	2387	2580	java/lang/Exception
    //   2603	2644	2813	java/lang/Exception
    //   2655	2689	2813	java/lang/Exception
    //   2702	2736	2813	java/lang/Exception
    //   2750	2765	2813	java/lang/Exception
    //   2765	2790	2813	java/lang/Exception
    //   2794	2810	2813	java/lang/Exception
    //   2846	2889	2813	java/lang/Exception
    //   2649	2655	2834	java/lang/Exception
    //   2188	2194	2892	java/lang/Exception
    //   2447	2453	2896	java/lang/Exception
    //   2692	2698	2900	java/lang/Exception
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    }
    label123:
    label635:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject1;
            do
            {
              do
              {
                return;
              } while (paramInt != -1);
              if (paramIntent == null) {
                localObject1 = "";
              }
              for (;;)
              {
                try
                {
                  localObject1 = new JSONObject((String)localObject1);
                }
                catch (JSONException localJSONException2)
                {
                  localObject1 = null;
                }
                try
                {
                  ((JSONObject)localObject1).put("id", this.jdField_d_of_type_Int);
                  if (localObject1 != null) {
                    break;
                  }
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
                  return;
                }
                catch (JSONException localJSONException3)
                {
                  HashMap localHashMap1;
                  HashMap localHashMap2;
                  Object localObject2;
                  break label123;
                }
                localObject1 = paramIntent.getStringExtra("jscallback");
                continue;
                localJSONException2.printStackTrace();
              }
              callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
              if (paramIntent == null) {}
              for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("localPath"))
              {
                this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
                localObject1 = new TroopHWJsPlugin.RequestSource(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
                paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (TroopHWJsPlugin.RequestSource)localObject1, 0);
                this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
                paramIntent.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a();
                this.jdField_d_of_type_Int += 1;
                return;
              }
            } while (paramInt != -1);
            localHashMap1 = new HashMap();
            localHashMap2 = new HashMap();
            if ((paramByte == 2) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
            {
              ImageUtil.a(this.mRuntime.a(), this.jdField_c_of_type_JavaLangString);
              localHashMap1.put(Integer.valueOf(this.jdField_d_of_type_Int), this.jdField_c_of_type_JavaLangString);
              this.jdField_d_of_type_Int += 1;
            }
            do
            {
              if (localHashMap2.size() <= 0) {
                break label845;
              }
              if (QLog.isColorLevel()) {
                QLog.e("TroopHWJsPlugin", 2, "video selected! size = " + localHashMap2.size());
              }
              paramIntent = new VFSFile(jdField_a_of_type_JavaLangString);
              if (!paramIntent.exists()) {
                paramIntent.mkdirs();
              }
              paramIntent = localHashMap2.entrySet().iterator();
              while (paramIntent.hasNext())
              {
                localObject1 = (Map.Entry)paramIntent.next();
                paramInt = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
                if (!TextUtils.isEmpty((String)((Map.Entry)localObject1).getValue())) {
                  try
                  {
                    callJs(this.jdField_b_of_type_JavaLangString, new String[] { a(this.jdField_d_of_type_JavaLangString, paramInt, 2, "select", null, -1).toString() });
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
                  }
                }
              }
              if (paramIntent != null) {}
              for (localObject2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"); (localObject2 == null) || (((ArrayList)localObject2).size() == 0); localObject2 = null)
              {
                QLog.e("TroopHWJsPlugin", 1, "selected list empty!");
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
                return;
              }
              paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
              Object localObject3;
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("selected pic or video! size = ");
                if (paramIntent != null)
                {
                  paramInt = paramIntent.size();
                  QLog.d("TroopHWJsPlugin", 2, paramInt);
                }
              }
              else
              {
                localObject2 = ((ArrayList)localObject2).iterator();
                if (!((Iterator)localObject2).hasNext()) {
                  continue;
                }
                localObject3 = (String)((Iterator)localObject2).next();
                paramInt = 0;
                if (paramIntent != null)
                {
                  if (AlbumUtil.getMediaType((LocalMediaInfo)paramIntent.get(localObject3)) != 1) {
                    break label718;
                  }
                  paramInt = 1;
                }
                if (paramInt == 0) {
                  break label723;
                }
                localHashMap2.put(Integer.valueOf(this.jdField_d_of_type_Int), localObject3);
              }
              for (;;)
              {
                this.jdField_d_of_type_Int += 1;
                break label635;
                paramInt = 0;
                break;
                paramInt = 0;
                break label681;
                localHashMap1.put(Integer.valueOf(this.jdField_d_of_type_Int), localObject3);
              }
            } while ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)));
          } while (!QLog.isColorLevel());
          QLog.w("TroopHWJsPlugin", 2, "mJsCallback == " + this.jdField_b_of_type_JavaLangString + ", mTroopUin == " + this.jdField_e_of_type_JavaLangString);
          return;
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new TroopHWJsPlugin.RequestSource(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
        } while (localHashMap1.size() <= 0);
        if (QLog.isColorLevel()) {
          QLog.e("TroopHWJsPlugin", 2, "pic selected! size = " + localHashMap1.size());
        }
        paramIntent = new VFSFile(jdField_a_of_type_JavaLangString);
        if (!paramIntent.exists()) {
          paramIntent.mkdirs();
        }
        paramIntent = localHashMap1.entrySet().iterator();
        while (paramIntent.hasNext())
        {
          localObject2 = (Map.Entry)paramIntent.next();
          paramInt = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
          if (!TextUtils.isEmpty((String)((Map.Entry)localObject2).getValue())) {
            try
            {
              callJs(this.jdField_b_of_type_JavaLangString, new String[] { a(this.jdField_d_of_type_JavaLangString, paramInt, 1, "select", null, -1).toString() });
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
            }
          }
        }
        ThreadManager.postImmediately(new TroopHWJsPlugin.CompressImageJob(this, localHashMap1), null, false);
        return;
        paramIntent = CheckArithHWResultFragment.a(paramIntent);
        try
        {
          paramIntent.put("webid", this.jdField_d_of_type_JavaLangString);
          callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramIntent.toString() });
          return;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      } while ((paramInt != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("SubmitHomeWorkFragment:js_callback");
    } while (TextUtils.isEmpty(paramIntent));
    label681:
    label718:
    label723:
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramIntent });
    label845:
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController = new TroopHWVoiceController(this.mRuntime.a(), this);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager = new TroopHWFileDownloadManager(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    int k = 0;
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
    if (this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager != null) {
      this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager.a(this.mRuntime.a());
    }
    if ("homework".equals(this.g))
    {
      Object localObject1 = new VFSFile(jdField_a_of_type_JavaLangString);
      int j;
      if (((VFSFile)localObject1).exists())
      {
        localObject1 = ((VFSFile)localObject1).listFiles();
        j = 0;
        while (j < localObject1.length)
        {
          localObject1[j].delete();
          j += 1;
        }
      }
      localObject1 = new VFSFile(AppConstants.SDCARD_HOMEWORK_AUDIO);
      if (((VFSFile)localObject1).exists())
      {
        localObject1 = ((VFSFile)localObject1).listFiles();
        j = k;
        while (j < localObject1.length)
        {
          localObject1[j].delete();
          j += 1;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("stream")))
        {
          localObject2 = new VFSFile((String)localObject2);
          if (((VFSFile)localObject2).exists()) {
            ((VFSFile)localObject2).delete();
          }
        }
      }
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = this.mRuntime.a();
    if ((paramCustomWebView != null) && (paramCustomWebView.getUrl() != null) && (paramCustomWebView.getUrl().contains("https://"))) {
      this.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */