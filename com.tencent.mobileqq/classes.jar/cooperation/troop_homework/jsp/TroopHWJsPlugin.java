package cooperation.troop_homework.jsp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import annu;
import annv;
import annw;
import annx;
import anny;
import annz;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
import org.json.JSONException;
import org.json.JSONObject;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback, TroopHWFileDownloadManager.OnDownloadStateListener, TroopHWVoiceController.RecordCallback
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new annv(this);
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private TroopHWFileDownloadManager jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager;
  TroopHWVoiceController jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController = null;
  public HashMap a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 540;
  public String b;
  public HashMap b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public String c;
  public int d;
  public String d;
  int e;
  public String e;
  String f = null;
  String g = null;
  public String h = null;
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.bf + "homeworkTmp/";
  }
  
  public TroopHWJsPlugin()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", paramInt);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.IS_FROM_TROOP_REWARD", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", 1024L);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 600000L);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", true);
    return localIntent;
  }
  
  /* Error */
  private Bitmap a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 207	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   14: iload_1
    //   15: iconst_2
    //   16: ldc 209
    //   18: aconst_null
    //   19: iconst_m1
    //   20: invokevirtual 212	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   23: astore 5
    //   25: new 214	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 215	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 6
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 219	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   40: aload 6
    //   42: ldc2_w 220
    //   45: invokevirtual 225	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +99 -> 149
    //   53: aload_0
    //   54: getfield 56	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   57: ifgt +119 -> 176
    //   60: sipush 540
    //   63: istore_1
    //   64: aload_0
    //   65: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   68: ifgt +116 -> 184
    //   71: sipush 540
    //   74: istore_3
    //   75: aload_2
    //   76: iload_1
    //   77: iload_3
    //   78: invokestatic 231	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +64 -> 149
    //   88: aload 4
    //   90: aload 4
    //   92: invokestatic 233	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   95: invokestatic 236	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   98: astore 7
    //   100: aload 7
    //   102: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +39 -> 144
    //   108: aload 5
    //   110: ldc 238
    //   112: aload 7
    //   114: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload 5
    //   120: ldc 246
    //   122: aload 4
    //   124: invokevirtual 249	android/graphics/Bitmap:getWidth	()I
    //   127: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload 5
    //   133: ldc 254
    //   135: aload 4
    //   137: invokevirtual 121	android/graphics/Bitmap:getHeight	()I
    //   140: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload 4
    //   146: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   149: aload 6
    //   151: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 262	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   159: iconst_1
    //   160: anewarray 264	java/lang/String
    //   163: dup
    //   164: iconst_0
    //   165: aload 5
    //   167: invokevirtual 265	org/json/JSONObject:toString	()Ljava/lang/String;
    //   170: aastore
    //   171: invokevirtual 269	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   174: aload_2
    //   175: areturn
    //   176: aload_0
    //   177: getfield 56	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   180: istore_1
    //   181: goto -117 -> 64
    //   184: aload_0
    //   185: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   188: istore_3
    //   189: goto -114 -> 75
    //   192: astore 4
    //   194: aconst_null
    //   195: astore_2
    //   196: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +34 -> 233
    //   202: ldc_w 277
    //   205: iconst_2
    //   206: new 32	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 279
    //   216: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 4
    //   221: invokevirtual 282	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   224: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 286	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload 6
    //   235: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   238: goto -84 -> 154
    //   241: astore 4
    //   243: goto -89 -> 154
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_2
    //   250: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +34 -> 287
    //   256: ldc_w 277
    //   259: iconst_2
    //   260: new 32	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 279
    //   270: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 4
    //   275: invokevirtual 287	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 286	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 6
    //   289: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   292: goto -138 -> 154
    //   295: astore 4
    //   297: goto -143 -> 154
    //   300: astore 4
    //   302: aconst_null
    //   303: astore_2
    //   304: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +34 -> 341
    //   310: ldc_w 277
    //   313: iconst_2
    //   314: new 32	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 289
    //   324: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 4
    //   329: invokevirtual 290	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 286	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 6
    //   343: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   346: goto -192 -> 154
    //   349: astore 4
    //   351: goto -197 -> 154
    //   354: astore_2
    //   355: aload 6
    //   357: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   360: aload_2
    //   361: athrow
    //   362: astore 4
    //   364: goto -210 -> 154
    //   367: astore 4
    //   369: goto -9 -> 360
    //   372: astore 4
    //   374: goto -70 -> 304
    //   377: astore 4
    //   379: goto -129 -> 250
    //   382: astore 4
    //   384: goto -188 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	TroopHWJsPlugin
    //   0	387	1	paramInt	int
    //   0	387	2	paramString	String
    //   74	115	3	j	int
    //   81	64	4	localBitmap	Bitmap
    //   192	28	4	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   241	1	4	localRuntimeException1	java.lang.RuntimeException
    //   246	28	4	localRuntimeException2	java.lang.RuntimeException
    //   295	1	4	localRuntimeException3	java.lang.RuntimeException
    //   300	28	4	localJSONException1	JSONException
    //   349	1	4	localRuntimeException4	java.lang.RuntimeException
    //   362	1	4	localRuntimeException5	java.lang.RuntimeException
    //   367	1	4	localRuntimeException6	java.lang.RuntimeException
    //   372	1	4	localJSONException2	JSONException
    //   377	1	4	localRuntimeException7	java.lang.RuntimeException
    //   382	1	4	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   23	143	5	localJSONObject	JSONObject
    //   32	324	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   98	15	7	str	String
    // Exception table:
    //   from	to	target	type
    //   34	49	192	java/lang/IllegalArgumentException
    //   233	238	241	java/lang/RuntimeException
    //   34	49	246	java/lang/RuntimeException
    //   287	292	295	java/lang/RuntimeException
    //   34	49	300	org/json/JSONException
    //   341	346	349	java/lang/RuntimeException
    //   34	49	354	finally
    //   53	60	354	finally
    //   64	71	354	finally
    //   75	83	354	finally
    //   88	144	354	finally
    //   144	149	354	finally
    //   176	181	354	finally
    //   184	189	354	finally
    //   196	233	354	finally
    //   250	287	354	finally
    //   304	341	354	finally
    //   149	154	362	java/lang/RuntimeException
    //   355	360	367	java/lang/RuntimeException
    //   53	60	372	org/json/JSONException
    //   64	71	372	org/json/JSONException
    //   75	83	372	org/json/JSONException
    //   88	144	372	org/json/JSONException
    //   144	149	372	org/json/JSONException
    //   176	181	372	org/json/JSONException
    //   184	189	372	org/json/JSONException
    //   53	60	377	java/lang/RuntimeException
    //   64	71	377	java/lang/RuntimeException
    //   75	83	377	java/lang/RuntimeException
    //   88	144	377	java/lang/RuntimeException
    //   144	149	377	java/lang/RuntimeException
    //   176	181	377	java/lang/RuntimeException
    //   184	189	377	java/lang/RuntimeException
    //   53	60	382	java/lang/IllegalArgumentException
    //   64	71	382	java/lang/IllegalArgumentException
    //   75	83	382	java/lang/IllegalArgumentException
    //   88	144	382	java/lang/IllegalArgumentException
    //   144	149	382	java/lang/IllegalArgumentException
    //   176	181	382	java/lang/IllegalArgumentException
    //   184	189	382	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString, int paramInt2, TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    // Byte code:
    //   0: new 301	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 307	java/io/File:length	()J
    //   11: ldc2_w 308
    //   14: lcmp
    //   15: ifle +290 -> 305
    //   18: aconst_null
    //   19: astore 12
    //   21: new 32	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   28: astore 15
    //   30: new 311	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 312	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_1
    //   42: putfield 315	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload 17
    //   47: getstatic 321	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   50: putfield 324	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   53: aload 17
    //   55: iconst_1
    //   56: putfield 327	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   59: aload_1
    //   60: aload 17
    //   62: invokestatic 333	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 17
    //   68: getfield 336	android/graphics/BitmapFactory$Options:outWidth	I
    //   71: istore 8
    //   73: aload 17
    //   75: getfield 339	android/graphics/BitmapFactory$Options:outHeight	I
    //   78: istore 10
    //   80: iload 8
    //   82: ifle +1189 -> 1271
    //   85: iload 10
    //   87: ifgt +6 -> 93
    //   90: goto +1181 -> 1271
    //   93: iload 8
    //   95: iload_2
    //   96: if_icmpgt +25 -> 121
    //   99: aload_1
    //   100: astore 11
    //   102: aload_3
    //   103: ifnull +1171 -> 1274
    //   106: aload_3
    //   107: getfield 207	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   110: iload_0
    //   111: aload_1
    //   112: iload 8
    //   114: iload 10
    //   116: aload_3
    //   117: invokestatic 342	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;ILjava/lang/String;IILcooperation/troop_homework/jsp/TroopHWJsPlugin;)Ljava/lang/String;
    //   120: areturn
    //   121: aconst_null
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 14
    //   127: new 344	android/graphics/Matrix
    //   130: dup
    //   131: invokespecial 345	android/graphics/Matrix:<init>	()V
    //   134: astore 16
    //   136: fconst_1
    //   137: fstore 5
    //   139: iconst_0
    //   140: istore 7
    //   142: aload_1
    //   143: invokestatic 351	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   146: istore 9
    //   148: iload 9
    //   150: iconst_5
    //   151: if_icmpeq +1126 -> 1277
    //   154: iload 9
    //   156: bipush 6
    //   158: if_icmpeq +1119 -> 1277
    //   161: iload 9
    //   163: bipush 7
    //   165: if_icmpeq +1112 -> 1277
    //   168: iload 9
    //   170: bipush 8
    //   172: if_icmpne +6 -> 178
    //   175: goto +1102 -> 1277
    //   178: iload 7
    //   180: ifeq +127 -> 307
    //   183: iload 10
    //   185: iload_2
    //   186: idiv
    //   187: istore 8
    //   189: aload 17
    //   191: iconst_0
    //   192: putfield 315	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
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
    //   246: putfield 354	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   249: new 356	java/io/FileInputStream
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 357	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   257: astore 13
    //   259: fload 5
    //   261: fstore 4
    //   263: aload 14
    //   265: astore 12
    //   267: aload 13
    //   269: aconst_null
    //   270: aload 17
    //   272: invokestatic 361	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   275: astore 11
    //   277: aload 11
    //   279: ifnonnull +37 -> 316
    //   282: aconst_null
    //   283: astore 11
    //   285: aload 13
    //   287: ifnull +987 -> 1274
    //   290: aload 13
    //   292: invokevirtual 364	java/io/FileInputStream:close	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 367	java/lang/OutOfMemoryError:printStackTrace	()V
    //   302: invokestatic 372	java/lang/System:gc	()V
    //   305: aconst_null
    //   306: areturn
    //   307: iload 8
    //   309: iload_2
    //   310: idiv
    //   311: istore 8
    //   313: goto -124 -> 189
    //   316: iload 7
    //   318: ifeq +416 -> 734
    //   321: iload_2
    //   322: i2f
    //   323: fstore 6
    //   325: fload 5
    //   327: fstore 4
    //   329: aload 11
    //   331: astore 12
    //   333: aload 11
    //   335: invokevirtual 121	android/graphics/Bitmap:getHeight	()I
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
    //   360: goto +923 -> 1283
    //   363: fload 5
    //   365: fstore 4
    //   367: aload 11
    //   369: astore 12
    //   371: aload 16
    //   373: fload 5
    //   375: fload 5
    //   377: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   380: aload 11
    //   382: astore 12
    //   384: aload 13
    //   386: ifnull +878 -> 1264
    //   389: aload 13
    //   391: invokevirtual 364	java/io/FileInputStream:close	()V
    //   394: aload 11
    //   396: iconst_0
    //   397: iconst_0
    //   398: aload 11
    //   400: invokevirtual 249	android/graphics/Bitmap:getWidth	()I
    //   403: aload 11
    //   405: invokevirtual 121	android/graphics/Bitmap:getHeight	()I
    //   408: aload 16
    //   410: iconst_1
    //   411: invokestatic 380	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   414: astore 14
    //   416: aload 11
    //   418: aload 14
    //   420: if_acmpeq +8 -> 428
    //   423: aload 11
    //   425: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   428: aload 14
    //   430: invokevirtual 249	android/graphics/Bitmap:getWidth	()I
    //   433: istore_2
    //   434: aload 14
    //   436: invokevirtual 121	android/graphics/Bitmap:getHeight	()I
    //   439: istore 7
    //   441: aconst_null
    //   442: astore 13
    //   444: aconst_null
    //   445: astore 12
    //   447: aload 14
    //   449: invokestatic 233	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   452: istore 8
    //   454: iload 8
    //   456: ifle +599 -> 1055
    //   459: new 382	java/io/ByteArrayOutputStream
    //   462: dup
    //   463: sipush 1024
    //   466: invokespecial 385	java/io/ByteArrayOutputStream:<init>	(I)V
    //   469: astore 11
    //   471: aload 14
    //   473: getstatic 391	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   476: iload 8
    //   478: aload 11
    //   480: invokevirtual 395	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   483: pop
    //   484: aload_3
    //   485: ifnull +776 -> 1261
    //   488: aload 15
    //   490: aload 11
    //   492: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   495: iconst_2
    //   496: invokestatic 405	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   499: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +28 -> 534
    //   509: ldc_w 277
    //   512: iconst_2
    //   513: iconst_2
    //   514: anewarray 140	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: ldc_w 407
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: iload 8
    //   527: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: invokestatic 416	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   534: aload 14
    //   536: ifnull +8 -> 544
    //   539: aload 14
    //   541: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   544: aload_3
    //   545: ifnull +79 -> 624
    //   548: aload_3
    //   549: aload_3
    //   550: getfield 207	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: iload_0
    //   554: iconst_1
    //   555: ldc 209
    //   557: aconst_null
    //   558: iconst_m1
    //   559: invokevirtual 212	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   562: astore 13
    //   564: aload 15
    //   566: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   572: ifne +13 -> 585
    //   575: aload 13
    //   577: ldc 238
    //   579: aload 15
    //   581: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   584: pop
    //   585: aload 13
    //   587: ldc 246
    //   589: iload_2
    //   590: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload 13
    //   596: ldc 254
    //   598: iload 7
    //   600: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   603: pop
    //   604: aload_3
    //   605: aload_3
    //   606: getfield 262	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   609: iconst_1
    //   610: anewarray 264	java/lang/String
    //   613: dup
    //   614: iconst_0
    //   615: aload 13
    //   617: invokevirtual 265	org/json/JSONObject:toString	()Ljava/lang/String;
    //   620: aastore
    //   621: invokevirtual 269	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   624: aload 11
    //   626: ifnull +628 -> 1254
    //   629: new 32	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   636: getstatic 52	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   639: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_1
    //   643: aload_1
    //   644: ldc_w 418
    //   647: invokevirtual 421	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   650: iconst_1
    //   651: iadd
    //   652: aload_1
    //   653: ldc_w 423
    //   656: invokevirtual 421	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   659: invokevirtual 427	java/lang/String:substring	(II)Ljava/lang/String;
    //   662: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   668: invokevirtual 433	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: aload_1
    //   672: invokestatic 438	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   675: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: astore 13
    //   683: new 440	java/io/FileOutputStream
    //   686: dup
    //   687: aload 13
    //   689: invokespecial 441	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   692: astore_1
    //   693: aload_1
    //   694: aload 11
    //   696: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   699: invokevirtual 445	java/io/FileOutputStream:write	([B)V
    //   702: aload_1
    //   703: astore_3
    //   704: aload 13
    //   706: astore_1
    //   707: aload 11
    //   709: ifnull +8 -> 717
    //   712: aload 11
    //   714: invokevirtual 446	java/io/ByteArrayOutputStream:close	()V
    //   717: aload_1
    //   718: astore 11
    //   720: aload_3
    //   721: ifnull +10 -> 731
    //   724: aload_3
    //   725: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   728: aload_1
    //   729: astore 11
    //   731: aload 11
    //   733: areturn
    //   734: iload_2
    //   735: i2f
    //   736: fstore 6
    //   738: fload 5
    //   740: fstore 4
    //   742: aload 11
    //   744: astore 12
    //   746: aload 11
    //   748: invokevirtual 249	android/graphics/Bitmap:getWidth	()I
    //   751: i2f
    //   752: fstore 5
    //   754: fload 5
    //   756: fstore 4
    //   758: aload 11
    //   760: astore 12
    //   762: fload 6
    //   764: fload 5
    //   766: fdiv
    //   767: fstore 5
    //   769: fload 5
    //   771: fstore 4
    //   773: goto +510 -> 1283
    //   776: fload 5
    //   778: fstore 4
    //   780: aload 11
    //   782: astore 12
    //   784: aload 16
    //   786: fload 5
    //   788: fneg
    //   789: fload 5
    //   791: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   794: goto -414 -> 380
    //   797: astore 11
    //   799: aload 12
    //   801: astore 11
    //   803: aload 16
    //   805: fload 4
    //   807: fload 4
    //   809: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   812: aload 11
    //   814: astore 12
    //   816: aload 13
    //   818: ifnull +446 -> 1264
    //   821: aload 13
    //   823: invokevirtual 364	java/io/FileInputStream:close	()V
    //   826: goto -432 -> 394
    //   829: fload 5
    //   831: fstore 4
    //   833: aload 11
    //   835: astore 12
    //   837: aload 16
    //   839: fload 5
    //   841: fload 5
    //   843: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   846: fload 5
    //   848: fstore 4
    //   850: aload 11
    //   852: astore 12
    //   854: aload 16
    //   856: ldc_w 448
    //   859: invokevirtual 452	android/graphics/Matrix:postRotate	(F)Z
    //   862: pop
    //   863: goto -483 -> 380
    //   866: astore_1
    //   867: aload 13
    //   869: astore_3
    //   870: aload_3
    //   871: ifnull +7 -> 878
    //   874: aload_3
    //   875: invokevirtual 364	java/io/FileInputStream:close	()V
    //   878: aload_1
    //   879: athrow
    //   880: fload 5
    //   882: fneg
    //   883: fstore 6
    //   885: fload 5
    //   887: fstore 4
    //   889: aload 11
    //   891: astore 12
    //   893: aload 16
    //   895: fload 5
    //   897: fload 6
    //   899: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   902: goto -522 -> 380
    //   905: fload 5
    //   907: fstore 4
    //   909: aload 11
    //   911: astore 12
    //   913: aload 16
    //   915: fload 5
    //   917: fload 5
    //   919: fneg
    //   920: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   923: fload 5
    //   925: fstore 4
    //   927: aload 11
    //   929: astore 12
    //   931: aload 16
    //   933: ldc_w 453
    //   936: invokevirtual 452	android/graphics/Matrix:postRotate	(F)Z
    //   939: pop
    //   940: goto -560 -> 380
    //   943: fload 5
    //   945: fstore 4
    //   947: aload 11
    //   949: astore 12
    //   951: aload 16
    //   953: fload 5
    //   955: fload 5
    //   957: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   960: fload 5
    //   962: fstore 4
    //   964: aload 11
    //   966: astore 12
    //   968: aload 16
    //   970: ldc_w 453
    //   973: invokevirtual 452	android/graphics/Matrix:postRotate	(F)Z
    //   976: pop
    //   977: goto -597 -> 380
    //   980: fload 5
    //   982: fstore 4
    //   984: aload 11
    //   986: astore 12
    //   988: aload 16
    //   990: fload 5
    //   992: fneg
    //   993: fload 5
    //   995: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   998: fload 5
    //   1000: fstore 4
    //   1002: aload 11
    //   1004: astore 12
    //   1006: aload 16
    //   1008: ldc_w 453
    //   1011: invokevirtual 452	android/graphics/Matrix:postRotate	(F)Z
    //   1014: pop
    //   1015: goto -635 -> 380
    //   1018: fload 5
    //   1020: fstore 4
    //   1022: aload 11
    //   1024: astore 12
    //   1026: aload 16
    //   1028: fload 5
    //   1030: fload 5
    //   1032: invokevirtual 376	android/graphics/Matrix:setScale	(FF)V
    //   1035: fload 5
    //   1037: fstore 4
    //   1039: aload 11
    //   1041: astore 12
    //   1043: aload 16
    //   1045: ldc_w 454
    //   1048: invokevirtual 452	android/graphics/Matrix:postRotate	(F)Z
    //   1051: pop
    //   1052: goto -672 -> 380
    //   1055: iload 8
    //   1057: ifne +16 -> 1073
    //   1060: aload_3
    //   1061: ifnull +12 -> 1073
    //   1064: aload_3
    //   1065: getfield 94	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1068: iconst_1
    //   1069: invokevirtual 460	android/os/Handler:sendEmptyMessage	(I)Z
    //   1072: pop
    //   1073: aconst_null
    //   1074: astore 11
    //   1076: goto -573 -> 503
    //   1079: astore 11
    //   1081: aconst_null
    //   1082: astore_1
    //   1083: aload 13
    //   1085: astore_3
    //   1086: aload 11
    //   1088: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   1091: aconst_null
    //   1092: astore 12
    //   1094: aload_3
    //   1095: ifnull +7 -> 1102
    //   1098: aload_3
    //   1099: invokevirtual 446	java/io/ByteArrayOutputStream:close	()V
    //   1102: aload 12
    //   1104: astore 11
    //   1106: aload_1
    //   1107: ifnull -376 -> 731
    //   1110: aload_1
    //   1111: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   1114: aload 12
    //   1116: astore 11
    //   1118: goto -387 -> 731
    //   1121: aload 11
    //   1123: ifnull +8 -> 1131
    //   1126: aload 11
    //   1128: invokevirtual 446	java/io/ByteArrayOutputStream:close	()V
    //   1131: aload_3
    //   1132: ifnull +7 -> 1139
    //   1135: aload_3
    //   1136: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   1139: aload_1
    //   1140: athrow
    //   1141: astore_1
    //   1142: aload 12
    //   1144: astore_3
    //   1145: goto -24 -> 1121
    //   1148: astore_1
    //   1149: aload 12
    //   1151: astore_3
    //   1152: goto -31 -> 1121
    //   1155: astore 12
    //   1157: aload_1
    //   1158: astore_3
    //   1159: aload 12
    //   1161: astore_1
    //   1162: goto -41 -> 1121
    //   1165: astore 13
    //   1167: aload_1
    //   1168: astore 11
    //   1170: aload_3
    //   1171: astore 12
    //   1173: aload 13
    //   1175: astore_1
    //   1176: aload 11
    //   1178: astore_3
    //   1179: aload 12
    //   1181: astore 11
    //   1183: goto -62 -> 1121
    //   1186: astore_1
    //   1187: aload 11
    //   1189: astore_3
    //   1190: aconst_null
    //   1191: astore 12
    //   1193: aload_1
    //   1194: astore 11
    //   1196: aload 12
    //   1198: astore_1
    //   1199: goto -113 -> 1086
    //   1202: astore 12
    //   1204: aconst_null
    //   1205: astore_1
    //   1206: aload 11
    //   1208: astore_3
    //   1209: aload 12
    //   1211: astore 11
    //   1213: goto -127 -> 1086
    //   1216: astore 12
    //   1218: aload 11
    //   1220: astore_3
    //   1221: aload 12
    //   1223: astore 11
    //   1225: goto -139 -> 1086
    //   1228: astore_1
    //   1229: aconst_null
    //   1230: astore_3
    //   1231: goto -361 -> 870
    //   1234: astore_1
    //   1235: aload 13
    //   1237: astore_3
    //   1238: goto -368 -> 870
    //   1241: astore 13
    //   1243: fload 5
    //   1245: fstore 4
    //   1247: aload 12
    //   1249: astore 13
    //   1251: goto -448 -> 803
    //   1254: aconst_null
    //   1255: astore_3
    //   1256: aconst_null
    //   1257: astore_1
    //   1258: goto -551 -> 707
    //   1261: goto -758 -> 503
    //   1264: aload 12
    //   1266: astore 11
    //   1268: goto -874 -> 394
    //   1271: aconst_null
    //   1272: astore 11
    //   1274: aload 11
    //   1276: areturn
    //   1277: iconst_1
    //   1278: istore 7
    //   1280: goto -1102 -> 178
    //   1283: fload 4
    //   1285: f2d
    //   1286: ldc2_w 462
    //   1289: dcmpg
    //   1290: ifge +57 -> 1347
    //   1293: ldc_w 464
    //   1296: fstore 5
    //   1298: iload 9
    //   1300: tableswitch	default:+44 -> 1344, 2:+-524->776, 3:+-471->829, 4:+-420->880, 5:+-395->905, 6:+-357->943, 7:+-320->980, 8:+-282->1018
    //   1345: <illegal opcode>
    //   1346: aload_1
    //   1347: fconst_1
    //   1348: fstore 5
    //   1350: goto -52 -> 1298
    //   1353: astore_1
    //   1354: aconst_null
    //   1355: astore 11
    //   1357: aload 12
    //   1359: astore_3
    //   1360: goto -239 -> 1121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1363	0	paramInt1	int
    //   0	1363	1	paramString	String
    //   0	1363	2	paramInt2	int
    //   0	1363	3	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   261	1023	4	f1	float
    //   137	1212	5	f2	float
    //   323	575	6	f3	float
    //   140	1139	7	j	int
    //   71	985	8	k	int
    //   146	1153	9	m	int
    //   78	109	10	n	int
    //   100	681	11	localObject1	Object
    //   797	1	11	localIOException1	java.io.IOException
    //   801	274	11	localObject2	Object
    //   1079	8	11	localIOException2	java.io.IOException
    //   1104	252	11	localObject3	Object
    //   19	1131	12	localObject4	Object
    //   1155	5	12	localObject5	Object
    //   1171	26	12	localTroopHWJsPlugin	TroopHWJsPlugin
    //   1202	8	12	localIOException3	java.io.IOException
    //   1216	142	12	localIOException4	java.io.IOException
    //   257	827	13	localObject6	Object
    //   1165	71	13	localObject7	Object
    //   1241	1	13	localIOException5	java.io.IOException
    //   1249	1	13	localIOException6	java.io.IOException
    //   125	415	14	localBitmap	Bitmap
    //   28	552	15	localStringBuilder	StringBuilder
    //   134	910	16	localMatrix	android.graphics.Matrix
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
    //   712	717	297	java/lang/OutOfMemoryError
    //   724	728	297	java/lang/OutOfMemoryError
    //   821	826	297	java/lang/OutOfMemoryError
    //   874	878	297	java/lang/OutOfMemoryError
    //   878	880	297	java/lang/OutOfMemoryError
    //   1098	1102	297	java/lang/OutOfMemoryError
    //   1110	1114	297	java/lang/OutOfMemoryError
    //   1126	1131	297	java/lang/OutOfMemoryError
    //   1135	1139	297	java/lang/OutOfMemoryError
    //   1139	1141	297	java/lang/OutOfMemoryError
    //   267	277	797	java/io/IOException
    //   333	341	797	java/io/IOException
    //   349	356	797	java/io/IOException
    //   371	380	797	java/io/IOException
    //   746	754	797	java/io/IOException
    //   762	769	797	java/io/IOException
    //   784	794	797	java/io/IOException
    //   837	846	797	java/io/IOException
    //   854	863	797	java/io/IOException
    //   893	902	797	java/io/IOException
    //   913	923	797	java/io/IOException
    //   931	940	797	java/io/IOException
    //   951	960	797	java/io/IOException
    //   968	977	797	java/io/IOException
    //   988	998	797	java/io/IOException
    //   1006	1015	797	java/io/IOException
    //   1026	1035	797	java/io/IOException
    //   1043	1052	797	java/io/IOException
    //   267	277	866	finally
    //   333	341	866	finally
    //   349	356	866	finally
    //   371	380	866	finally
    //   746	754	866	finally
    //   762	769	866	finally
    //   784	794	866	finally
    //   837	846	866	finally
    //   854	863	866	finally
    //   893	902	866	finally
    //   913	923	866	finally
    //   931	940	866	finally
    //   951	960	866	finally
    //   968	977	866	finally
    //   988	998	866	finally
    //   1006	1015	866	finally
    //   1026	1035	866	finally
    //   1043	1052	866	finally
    //   459	471	1079	java/io/IOException
    //   1064	1073	1079	java/io/IOException
    //   471	484	1141	finally
    //   488	503	1141	finally
    //   503	534	1148	finally
    //   539	544	1148	finally
    //   548	585	1148	finally
    //   585	624	1148	finally
    //   629	693	1148	finally
    //   693	702	1155	finally
    //   1086	1091	1165	finally
    //   471	484	1186	java/io/IOException
    //   488	503	1186	java/io/IOException
    //   503	534	1202	java/io/IOException
    //   539	544	1202	java/io/IOException
    //   548	585	1202	java/io/IOException
    //   585	624	1202	java/io/IOException
    //   629	693	1202	java/io/IOException
    //   693	702	1216	java/io/IOException
    //   142	148	1228	finally
    //   183	189	1228	finally
    //   189	195	1228	finally
    //   232	259	1228	finally
    //   307	313	1228	finally
    //   803	812	1234	finally
    //   142	148	1241	java/io/IOException
    //   183	189	1241	java/io/IOException
    //   189	195	1241	java/io/IOException
    //   232	259	1241	java/io/IOException
    //   307	313	1241	java/io/IOException
    //   459	471	1353	finally
    //   1064	1073	1353	finally
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
      localObject = new File(AppConstants.aQ);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        QQToast.a(localBaseApplication, 2131434786, 0).a();
      }
      str = AppConstants.aQ + System.currentTimeMillis() + ".jpg";
      localObject = Uri.fromFile(new File(str));
      localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.putExtra("output", (Parcelable)localObject);
      localIntent.putExtra("android.intent.extra.videoQuality", 100);
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
      QQToast.a(localBaseApplication, 2131434809, 0).a();
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
    //   9: new 382	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 385	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 391	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 395	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 405	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 527	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 446	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 523	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 527	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 446	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 461	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 527	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 446	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 461	java/io/IOException:printStackTrace	()V
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
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    int j;
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      j = 0;
      while (j < localObject.length)
      {
        localObject[j].delete();
        j += 1;
      }
    }
    localObject = new File(AppConstants.bf);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      j = k;
      while (j < localObject.length)
      {
        localObject[j].delete();
        j += 1;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this.mRuntime.a());
    localActionSheet.a(2131436176, 1);
    localActionSheet.a(2131436178, 1);
    localActionSheet.c(2131433029);
    localActionSheet.a(new annu(this, paramInt, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  public TroopHWJsPlugin.UploadMediaEntry a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, annz paramannz, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    TroopHWJsPlugin.UploadMediaEntry localUploadMediaEntry = new TroopHWJsPlugin.UploadMediaEntry(paramTroopHWJsPlugin);
    localUploadMediaEntry.jdField_a_of_type_Int = paramInt1;
    localUploadMediaEntry.jdField_a_of_type_Annz = paramannz;
    localUploadMediaEntry.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask = new TroopHomeworkHelper.UploadFileTask(paramTroopHWJsPlugin.mRuntime.a(), paramString, paramannz.jdField_b_of_type_JavaLangString);
    localUploadMediaEntry.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a(localUploadMediaEntry.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback);
    localUploadMediaEntry.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    localUploadMediaEntry.jdField_b_of_type_JavaLangString = paramString;
    localUploadMediaEntry.jdField_b_of_type_Int = paramInt2;
    return localUploadMediaEntry;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = MD5Utils.d(paramString2) + HWTroopUtils.a(paramString2);
    paramString1 = AppConstants.bg + paramString1 + File.separator;
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
  
  public void a(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    WebViewFragment localWebViewFragment = this.mRuntime.a();
    if (((localActivity instanceof AbsBaseWebViewActivity)) || (localWebViewFragment != null))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(localActivity, PhotoListActivity.class);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
      localIntent.putExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
      if (paramInt == 1) {
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
      if (localWebViewFragment != null)
      {
        localWebViewFragment.a(this, localIntent, (byte)3);
        return;
      }
      ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)3);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
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
  
  public void a(Bundle paramBundle)
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
        ThreadManager.post(new annw(this, paramString), 2, null, false);
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
    WebViewFragment localWebViewFragment = this.mRuntime.a();
    if (((localActivity instanceof AbsBaseWebViewActivity)) || (localWebViewFragment != null))
    {
      Intent localIntent = a(paramInt, localActivity, this.mRuntime.a().getCurrentAccountUin());
      if ((localActivity instanceof AbsBaseWebViewActivity)) {
        ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)5);
      }
      while (localWebViewFragment == null) {
        return;
      }
      localWebViewFragment.a(this, localIntent, (byte)5);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void b(int paramInt, String paramString)
  {
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { a(this.jdField_d_of_type_JavaLangString, paramInt, 0, "stopPlay", null, -1).toString() });
    if ((this.jdField_e_of_type_Int != -1) && (paramInt == this.jdField_e_of_type_Int)) {
      this.jdField_e_of_type_Int = -1;
    }
  }
  
  public void c() {}
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (!TextUtils.isEmpty(paramString)) {
      super.callJs(paramString, paramVarArgs);
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
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
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +17 -> 18
    //   4: ldc 96
    //   6: aload_3
    //   7: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +8 -> 18
    //   13: aload 4
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 240	org/json/JSONObject
    //   23: dup
    //   24: aload 5
    //   26: iconst_0
    //   27: aaload
    //   28: invokespecial 805	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +102 -> 135
    //   36: aload_1
    //   37: ldc_w 807
    //   40: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 15
    //   45: aload_1
    //   46: ldc_w 630
    //   49: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 16
    //   54: aload_0
    //   55: aload 15
    //   57: putfield 262	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   60: aload_0
    //   61: aload 16
    //   63: putfield 207	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   71: aload_0
    //   72: aload_1
    //   73: ldc_w 812
    //   76: ldc_w 469
    //   79: invokevirtual 814	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: putfield 816	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload_0
    //   86: aload_1
    //   87: ldc_w 818
    //   90: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   93: putfield 56	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   96: aload_0
    //   97: aload_1
    //   98: ldc_w 823
    //   101: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   104: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   107: aload_0
    //   108: getfield 56	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: sipush 540
    //   118: putfield 56	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   121: aload_0
    //   122: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   125: ifne +10 -> 135
    //   128: aload_0
    //   129: sipush 540
    //   132: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   135: ldc_w 825
    //   138: aload 4
    //   140: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +79 -> 222
    //   146: aload_0
    //   147: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   150: invokevirtual 556	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   153: astore_1
    //   154: new 129	android/content/Intent
    //   157: dup
    //   158: invokespecial 130	android/content/Intent:<init>	()V
    //   161: astore_2
    //   162: aload_2
    //   163: new 827	android/content/ComponentName
    //   166: dup
    //   167: aload_1
    //   168: ldc_w 829
    //   171: invokespecial 832	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   174: invokevirtual 836	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   177: pop
    //   178: aload_2
    //   179: ldc_w 630
    //   182: aload_0
    //   183: getfield 207	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   186: invokevirtual 153	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   189: pop
    //   190: aload_0
    //   191: getfield 262	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   194: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +16 -> 213
    //   200: aload_1
    //   201: aload_2
    //   202: invokevirtual 840	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -178 -> 32
    //   213: aload_0
    //   214: aload_2
    //   215: iconst_1
    //   216: invokevirtual 843	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   219: goto -14 -> 205
    //   222: ldc_w 845
    //   225: aload 4
    //   227: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +107 -> 337
    //   233: aload_1
    //   234: ifnull +2302 -> 2536
    //   237: aload_1
    //   238: ldc_w 628
    //   241: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   244: istore 6
    //   246: aload_0
    //   247: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   250: iconst_m1
    //   251: if_icmpne +36 -> 287
    //   254: aload_0
    //   255: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   258: iload 6
    //   260: aload_0
    //   261: getfield 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   264: iload 6
    //   266: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: invokevirtual 849	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 264	java/lang/String
    //   275: invokevirtual 851	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   278: aload_0
    //   279: iload 6
    //   281: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   284: goto -79 -> 205
    //   287: iload 6
    //   289: aload_0
    //   290: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   293: if_icmpeq -88 -> 205
    //   296: aload_0
    //   297: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   300: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   303: pop
    //   304: aload_0
    //   305: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   308: iload 6
    //   310: aload_0
    //   311: getfield 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   314: iload 6
    //   316: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: invokevirtual 849	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 264	java/lang/String
    //   325: invokevirtual 851	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   328: aload_0
    //   329: iload 6
    //   331: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   334: goto -129 -> 205
    //   337: ldc_w 853
    //   340: aload 4
    //   342: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   345: ifeq +52 -> 397
    //   348: iconst_m1
    //   349: istore 6
    //   351: aload_1
    //   352: ifnull +12 -> 364
    //   355: aload_1
    //   356: ldc_w 628
    //   359: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   362: istore 6
    //   364: aload_0
    //   365: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   368: iconst_m1
    //   369: if_icmpeq -164 -> 205
    //   372: iload 6
    //   374: aload_0
    //   375: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   378: if_icmpne -173 -> 205
    //   381: aload_0
    //   382: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   385: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   388: pop
    //   389: aload_0
    //   390: iconst_m1
    //   391: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   394: goto -189 -> 205
    //   397: ldc_w 855
    //   400: aload 4
    //   402: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   405: ifeq +226 -> 631
    //   408: bipush 10
    //   410: istore 7
    //   412: iconst_0
    //   413: istore 6
    //   415: aload_1
    //   416: ifnull +34 -> 450
    //   419: aload_1
    //   420: ldc_w 857
    //   423: bipush 10
    //   425: invokevirtual 860	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   428: istore 7
    //   430: aload_0
    //   431: aload_1
    //   432: ldc_w 818
    //   435: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   438: putfield 64	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   441: aload_1
    //   442: ldc_w 862
    //   445: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   448: istore 6
    //   450: iload 6
    //   452: iconst_1
    //   453: if_icmpne +35 -> 488
    //   456: aload_0
    //   457: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   460: ifnonnull +17 -> 477
    //   463: aconst_null
    //   464: astore_1
    //   465: aload_0
    //   466: aload_1
    //   467: iconst_2
    //   468: invokestatic 864	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/app/Activity;I)Ljava/lang/String;
    //   471: putfield 866	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   474: goto -269 -> 205
    //   477: aload_0
    //   478: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   481: invokevirtual 556	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   484: astore_1
    //   485: goto -20 -> 465
    //   488: iload 6
    //   490: iconst_2
    //   491: if_icmpne +12 -> 503
    //   494: aload_0
    //   495: iload 7
    //   497: invokevirtual 868	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   500: goto -295 -> 205
    //   503: iload 6
    //   505: iconst_3
    //   506: if_icmpne +116 -> 622
    //   509: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +30 -> 542
    //   515: ldc_w 277
    //   518: iconst_2
    //   519: new 32	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 870
    //   529: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_1
    //   533: invokevirtual 873	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: aload_0
    //   543: getfield 262	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   546: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   549: ifne +13 -> 562
    //   552: aload_0
    //   553: getfield 816	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   556: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   559: ifeq +54 -> 613
    //   562: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +46 -> 611
    //   568: ldc_w 277
    //   571: iconst_2
    //   572: new 32	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 877
    //   582: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_0
    //   586: getfield 262	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   589: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: ldc_w 879
    //   595: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_0
    //   599: getfield 816	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   602: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 286	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: iconst_1
    //   612: ireturn
    //   613: aload_0
    //   614: iload 7
    //   616: invokevirtual 880	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(I)V
    //   619: goto -414 -> 205
    //   622: aload_0
    //   623: iload 7
    //   625: invokespecial 881	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   628: goto -423 -> 205
    //   631: ldc_w 883
    //   634: aload 4
    //   636: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   639: ifeq +191 -> 830
    //   642: lconst_0
    //   643: lstore 8
    //   645: bipush 102
    //   647: istore 6
    //   649: aconst_null
    //   650: astore 5
    //   652: aconst_null
    //   653: astore 4
    //   655: aconst_null
    //   656: astore_3
    //   657: aconst_null
    //   658: astore_2
    //   659: aload_1
    //   660: ifnull +1871 -> 2531
    //   663: aload_1
    //   664: ldc_w 885
    //   667: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   670: astore 5
    //   672: aload_1
    //   673: ldc_w 887
    //   676: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   679: astore 4
    //   681: aload_1
    //   682: ldc_w 812
    //   685: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   688: astore 15
    //   690: aload_1
    //   691: ldc_w 889
    //   694: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: astore_3
    //   698: aload_1
    //   699: ldc_w 891
    //   702: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   705: astore_2
    //   706: aload 15
    //   708: astore_1
    //   709: aload_3
    //   710: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   713: ifne +12 -> 725
    //   716: aload_3
    //   717: invokestatic 896	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   720: invokevirtual 899	java/lang/Long:longValue	()J
    //   723: lstore 8
    //   725: aload_2
    //   726: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifne +12 -> 741
    //   732: aload_2
    //   733: invokestatic 902	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   736: invokevirtual 905	java/lang/Integer:intValue	()I
    //   739: istore 6
    //   741: aload_1
    //   742: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   745: ifne +66 -> 811
    //   748: aload_0
    //   749: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   752: aload_1
    //   753: invokestatic 896	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   756: invokevirtual 899	java/lang/Long:longValue	()J
    //   759: aload 4
    //   761: aload 5
    //   763: lload 8
    //   765: iload 6
    //   767: aload_0
    //   768: invokevirtual 910	com/tencent/biz/troop/TroopMemberApiClient:a	(JLjava/lang/String;Ljava/lang/String;JILcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   771: goto -566 -> 205
    //   774: astore_2
    //   775: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   778: ifeq -573 -> 205
    //   781: ldc_w 277
    //   784: iconst_2
    //   785: new 32	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 912
    //   795: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_1
    //   799: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: goto -603 -> 205
    //   811: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   814: ifeq -609 -> 205
    //   817: ldc_w 277
    //   820: iconst_2
    //   821: ldc_w 916
    //   824: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   827: goto -622 -> 205
    //   830: ldc_w 918
    //   833: aload 4
    //   835: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   838: ifeq +77 -> 915
    //   841: ldc_w 469
    //   844: astore_2
    //   845: aload_1
    //   846: ifnull +11 -> 857
    //   849: aload_1
    //   850: ldc_w 636
    //   853: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   856: astore_2
    //   857: aload_0
    //   858: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   861: ifnonnull +19 -> 880
    //   864: aload_0
    //   865: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   868: aload_2
    //   869: invokevirtual 920	cooperation/troop_homework/jsp/TroopHWVoiceController:b	(Ljava/lang/String;)V
    //   872: aload_0
    //   873: aload_2
    //   874: putfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   877: goto -672 -> 205
    //   880: aload_0
    //   881: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   884: aload_2
    //   885: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   888: ifne -683 -> 205
    //   891: aload_0
    //   892: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   895: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   898: pop
    //   899: aload_0
    //   900: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   903: aload_2
    //   904: invokevirtual 920	cooperation/troop_homework/jsp/TroopHWVoiceController:b	(Ljava/lang/String;)V
    //   907: aload_0
    //   908: aload_2
    //   909: putfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   912: goto -707 -> 205
    //   915: ldc_w 922
    //   918: aload 4
    //   920: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   923: ifeq +53 -> 976
    //   926: ldc_w 469
    //   929: astore_2
    //   930: aload_1
    //   931: ifnull +11 -> 942
    //   934: aload_1
    //   935: ldc_w 636
    //   938: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   941: astore_2
    //   942: aload_0
    //   943: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   946: ifnull -741 -> 205
    //   949: aload_0
    //   950: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   953: aload_2
    //   954: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   957: ifeq -752 -> 205
    //   960: aload_0
    //   961: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   964: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   967: pop
    //   968: aload_0
    //   969: aconst_null
    //   970: putfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   973: goto -768 -> 205
    //   976: ldc_w 924
    //   979: aload 4
    //   981: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   984: ifeq +23 -> 1007
    //   987: aload_0
    //   988: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   991: aload_0
    //   992: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   995: invokevirtual 591	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   998: invokevirtual 927	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1001: invokevirtual 929	cooperation/troop_homework/jsp/TroopHWVoiceController:e	(Ljava/lang/String;)V
    //   1004: goto -799 -> 205
    //   1007: ldc_w 931
    //   1010: aload 4
    //   1012: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1015: ifeq +39 -> 1054
    //   1018: aload_1
    //   1019: ifnull +25 -> 1044
    //   1022: aload_0
    //   1023: aload_1
    //   1024: ldc_w 933
    //   1027: invokevirtual 937	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1030: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1033: aload_0
    //   1034: aload_1
    //   1035: ldc_w 939
    //   1038: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1041: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1044: aload_0
    //   1045: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1048: invokevirtual 941	cooperation/troop_homework/jsp/TroopHWVoiceController:b	()V
    //   1051: goto -846 -> 205
    //   1054: ldc_w 943
    //   1057: aload 4
    //   1059: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1062: ifeq +25 -> 1087
    //   1065: new 945	annt
    //   1068: dup
    //   1069: aload_0
    //   1070: aload_2
    //   1071: invokestatic 948	com/tencent/mobileqq/transfile/AbsDownloader:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: invokespecial 949	annt:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1077: bipush 8
    //   1079: aconst_null
    //   1080: iconst_0
    //   1081: invokestatic 766	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1084: goto -879 -> 205
    //   1087: ldc_w 951
    //   1090: aload 4
    //   1092: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1095: ifeq +54 -> 1149
    //   1098: aload_1
    //   1099: ifnull -894 -> 205
    //   1102: aload_1
    //   1103: ldc_w 636
    //   1106: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1109: astore_2
    //   1110: aload_1
    //   1111: ldc_w 953
    //   1114: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1117: astore_3
    //   1118: aload_0
    //   1119: aload_1
    //   1120: ldc_w 807
    //   1123: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1126: putfield 773	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1129: aload_0
    //   1130: aload_3
    //   1131: aload_2
    //   1132: invokevirtual 776	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1135: astore_1
    //   1136: aload_0
    //   1137: getfield 955	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1140: aload_2
    //   1141: aload_1
    //   1142: aload_0
    //   1143: invokevirtual 960	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;Ljava/lang/String;Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager$OnDownloadStateListener;)V
    //   1146: goto -941 -> 205
    //   1149: ldc_w 962
    //   1152: aload 4
    //   1154: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1157: ifeq +26 -> 1183
    //   1160: aload_1
    //   1161: ifnull -956 -> 205
    //   1164: aload_1
    //   1165: ldc_w 636
    //   1168: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1171: astore_1
    //   1172: aload_0
    //   1173: getfield 955	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1176: aload_1
    //   1177: invokevirtual 963	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;)V
    //   1180: goto -975 -> 205
    //   1183: ldc_w 965
    //   1186: aload 4
    //   1188: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1191: ifeq +194 -> 1385
    //   1194: aload_1
    //   1195: ifnull -990 -> 205
    //   1198: aload_1
    //   1199: ldc_w 953
    //   1202: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1205: astore 4
    //   1207: aload_1
    //   1208: ldc_w 967
    //   1211: invokevirtual 971	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1214: astore 5
    //   1216: aload_1
    //   1217: ldc_w 807
    //   1220: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1223: astore_2
    //   1224: new 240	org/json/JSONObject
    //   1227: dup
    //   1228: invokespecial 626	org/json/JSONObject:<init>	()V
    //   1231: astore_3
    //   1232: new 973	org/json/JSONArray
    //   1235: dup
    //   1236: invokespecial 974	org/json/JSONArray:<init>	()V
    //   1239: astore 15
    //   1241: aload 5
    //   1243: invokevirtual 976	org/json/JSONArray:length	()I
    //   1246: istore 7
    //   1248: iconst_0
    //   1249: istore 6
    //   1251: iload 6
    //   1253: iload 7
    //   1255: if_icmpge +33 -> 1288
    //   1258: aload 15
    //   1260: iload 6
    //   1262: aload_0
    //   1263: aload 4
    //   1265: aload 5
    //   1267: iload 6
    //   1269: invokevirtual 979	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1272: invokevirtual 981	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1275: invokevirtual 984	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1278: pop
    //   1279: iload 6
    //   1281: iconst_1
    //   1282: iadd
    //   1283: istore 6
    //   1285: goto -34 -> 1251
    //   1288: aload_3
    //   1289: ldc_w 986
    //   1292: aload 15
    //   1294: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1297: pop
    //   1298: aload_3
    //   1299: invokevirtual 265	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1302: astore_3
    //   1303: aload_0
    //   1304: aload_2
    //   1305: iconst_1
    //   1306: anewarray 264	java/lang/String
    //   1309: dup
    //   1310: iconst_0
    //   1311: aload_3
    //   1312: aastore
    //   1313: invokevirtual 269	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1316: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1319: ifeq -1114 -> 205
    //   1322: ldc_w 277
    //   1325: iconst_2
    //   1326: new 32	java/lang/StringBuilder
    //   1329: dup
    //   1330: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1333: ldc_w 988
    //   1336: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: aload_1
    //   1340: invokevirtual 873	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1343: ldc_w 990
    //   1346: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: aload_3
    //   1350: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1356: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1359: goto -1154 -> 205
    //   1362: astore 4
    //   1364: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1367: ifeq -69 -> 1298
    //   1370: ldc_w 277
    //   1373: iconst_2
    //   1374: ldc_w 988
    //   1377: aload 4
    //   1379: invokestatic 993	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1382: goto -84 -> 1298
    //   1385: ldc_w 995
    //   1388: aload 4
    //   1390: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1393: ifeq +68 -> 1461
    //   1396: aload_1
    //   1397: ifnull -1192 -> 205
    //   1400: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1403: ifeq +30 -> 1433
    //   1406: ldc_w 277
    //   1409: iconst_2
    //   1410: new 32	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1417: ldc_w 997
    //   1420: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: aload_1
    //   1424: invokevirtual 873	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1427: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1430: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1433: aload_1
    //   1434: ldc_w 999
    //   1437: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1440: astore_2
    //   1441: aload_1
    //   1442: ldc_w 1001
    //   1445: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1448: astore_1
    //   1449: aload_0
    //   1450: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1453: aload_2
    //   1454: aload_1
    //   1455: invokevirtual 1004	com/tencent/biz/troop/TroopMemberApiClient:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1458: goto -1253 -> 205
    //   1461: ldc_w 1006
    //   1464: aload 4
    //   1466: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1469: ifeq +58 -> 1527
    //   1472: aload_1
    //   1473: ifnull +54 -> 1527
    //   1476: aload_1
    //   1477: ldc_w 638
    //   1480: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1483: pop
    //   1484: aload_1
    //   1485: ldc_w 628
    //   1488: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1491: istore 6
    //   1493: aload_0
    //   1494: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1497: iload 6
    //   1499: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1502: invokevirtual 849	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1505: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1508: astore_1
    //   1509: aload_1
    //   1510: ifnull -1305 -> 205
    //   1513: aload_1
    //   1514: getfield 1007	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Boolean	Z
    //   1517: ifne -1312 -> 205
    //   1520: aload_1
    //   1521: invokevirtual 1008	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:b	()V
    //   1524: goto -1319 -> 205
    //   1527: ldc_w 1010
    //   1530: aload 4
    //   1532: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1535: ifeq +62 -> 1597
    //   1538: aload_1
    //   1539: ifnull +58 -> 1597
    //   1542: aload_1
    //   1543: ldc_w 638
    //   1546: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1549: pop
    //   1550: aload_1
    //   1551: ldc_w 628
    //   1554: invokevirtual 821	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1557: istore 6
    //   1559: aload_0
    //   1560: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1563: iload 6
    //   1565: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1568: invokevirtual 849	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1571: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1574: astore_1
    //   1575: aload_1
    //   1576: ifnull -1371 -> 205
    //   1579: aload_1
    //   1580: getfield 1007	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Boolean	Z
    //   1583: ifeq -1378 -> 205
    //   1586: aload_1
    //   1587: getfield 1013	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1590: iconst_1
    //   1591: invokevirtual 1019	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1594: goto -1389 -> 205
    //   1597: ldc_w 1021
    //   1600: aload 4
    //   1602: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1605: ifeq +83 -> 1688
    //   1608: aload_1
    //   1609: ifnull -1404 -> 205
    //   1612: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1615: ifeq +24 -> 1639
    //   1618: ldc_w 277
    //   1621: iconst_2
    //   1622: iconst_2
    //   1623: anewarray 140	java/lang/Object
    //   1626: dup
    //   1627: iconst_0
    //   1628: ldc_w 1023
    //   1631: aastore
    //   1632: dup
    //   1633: iconst_1
    //   1634: aload_1
    //   1635: aastore
    //   1636: invokestatic 416	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1639: aload_1
    //   1640: ldc_w 953
    //   1643: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1646: astore_2
    //   1647: aload_1
    //   1648: ldc_w 638
    //   1651: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1654: astore_1
    //   1655: aload_0
    //   1656: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1659: aload_2
    //   1660: aload_1
    //   1661: invokevirtual 1025	com/tencent/biz/troop/TroopMemberApiClient:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1664: goto -1459 -> 205
    //   1667: astore_1
    //   1668: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1671: ifeq -1466 -> 205
    //   1674: ldc_w 277
    //   1677: iconst_2
    //   1678: ldc_w 1027
    //   1681: aload_1
    //   1682: invokestatic 993	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1685: goto -1480 -> 205
    //   1688: ldc_w 1029
    //   1691: aload 4
    //   1693: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1696: ifeq +167 -> 1863
    //   1699: aload_1
    //   1700: ifnull -1495 -> 205
    //   1703: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1706: ifeq +30 -> 1736
    //   1709: ldc_w 277
    //   1712: iconst_2
    //   1713: new 32	java/lang/StringBuilder
    //   1716: dup
    //   1717: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1720: ldc_w 1031
    //   1723: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: aload_1
    //   1727: invokevirtual 873	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1730: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1733: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1736: aload_1
    //   1737: ldc_w 628
    //   1740: iconst_0
    //   1741: invokevirtual 860	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1744: istore 6
    //   1746: aload_0
    //   1747: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1750: iload 6
    //   1752: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1755: invokevirtual 849	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1758: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1761: astore_2
    //   1762: aload_2
    //   1763: ifnull +70 -> 1833
    //   1766: aload_2
    //   1767: getfield 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1770: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1773: ifne +60 -> 1833
    //   1776: new 693	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1779: dup
    //   1780: invokespecial 694	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1783: astore_1
    //   1784: aload_1
    //   1785: aload_2
    //   1786: getfield 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1789: invokevirtual 716	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1792: new 129	android/content/Intent
    //   1795: dup
    //   1796: aload_0
    //   1797: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1800: invokevirtual 556	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1803: ldc_w 730
    //   1806: invokespecial 1032	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1809: astore_2
    //   1810: aload_2
    //   1811: ldc_w 732
    //   1814: aload_1
    //   1815: invokevirtual 514	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1818: pop
    //   1819: aload_0
    //   1820: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1823: invokevirtual 556	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1826: aload_2
    //   1827: invokevirtual 840	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1830: goto -1625 -> 205
    //   1833: ldc_w 277
    //   1836: iconst_1
    //   1837: new 32	java/lang/StringBuilder
    //   1840: dup
    //   1841: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1844: ldc_w 1034
    //   1847: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: aload_2
    //   1851: invokevirtual 873	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1860: goto -1655 -> 205
    //   1863: ldc_w 1036
    //   1866: aload 4
    //   1868: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1871: ifeq +18 -> 1889
    //   1874: aload_0
    //   1875: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1878: invokevirtual 1039	java/util/HashMap:clear	()V
    //   1881: aload_0
    //   1882: iconst_1
    //   1883: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   1886: goto -1681 -> 205
    //   1889: ldc_w 1041
    //   1892: aload 4
    //   1894: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1897: ifeq +77 -> 1974
    //   1900: aload_1
    //   1901: ifnull -1696 -> 205
    //   1904: aload_1
    //   1905: ldc_w 628
    //   1908: iconst_0
    //   1909: invokevirtual 860	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1912: istore 6
    //   1914: aload_0
    //   1915: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1918: iload 6
    //   1920: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1923: invokevirtual 849	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1926: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1929: astore_1
    //   1930: aload_1
    //   1931: ifnull -1726 -> 205
    //   1934: aload_1
    //   1935: getfield 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1938: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1941: ifne -1736 -> 205
    //   1944: new 301	java/io/File
    //   1947: dup
    //   1948: aload_1
    //   1949: getfield 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1952: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   1955: astore_2
    //   1956: aload_0
    //   1957: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1960: aload_1
    //   1961: getfield 610	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1964: aload_2
    //   1965: invokevirtual 1042	java/io/File:getName	()Ljava/lang/String;
    //   1968: invokevirtual 1004	com/tencent/biz/troop/TroopMemberApiClient:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1971: goto -1766 -> 205
    //   1974: ldc_w 1044
    //   1977: aload 4
    //   1979: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1982: ifeq +94 -> 2076
    //   1985: aload_1
    //   1986: ifnull +78 -> 2064
    //   1989: ldc_w 277
    //   1992: ldc_w 1046
    //   1995: aload_1
    //   1996: invokestatic 1051	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   1999: aload_1
    //   2000: ldc_w 1053
    //   2003: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2006: astore_2
    //   2007: aload_1
    //   2008: ldc_w 1055
    //   2011: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2014: astore_3
    //   2015: aload_1
    //   2016: ldc_w 1057
    //   2019: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2022: astore 4
    //   2024: aload_1
    //   2025: ldc_w 1059
    //   2028: invokevirtual 810	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2031: astore_1
    //   2032: aload_0
    //   2033: aload_0
    //   2034: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2037: invokevirtual 556	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2040: aload_2
    //   2041: aload_3
    //   2042: aload_0
    //   2043: getfield 262	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2046: aload 4
    //   2048: aload_0
    //   2049: getfield 816	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2052: aload_1
    //   2053: invokestatic 1064	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2056: bipush 6
    //   2058: invokevirtual 843	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2061: goto -1856 -> 205
    //   2064: ldc_w 277
    //   2067: ldc_w 1066
    //   2070: invokestatic 1067	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2073: goto -1868 -> 205
    //   2076: ldc_w 1069
    //   2079: aload 4
    //   2081: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2084: ifeq +186 -> 2270
    //   2087: new 240	org/json/JSONObject
    //   2090: dup
    //   2091: aload 5
    //   2093: iconst_0
    //   2094: aaload
    //   2095: invokespecial 805	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2098: ldc_w 1071
    //   2101: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2104: astore_2
    //   2105: aload_2
    //   2106: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2109: istore 14
    //   2111: iload 14
    //   2113: ifne -1908 -> 205
    //   2116: lconst_0
    //   2117: lstore 8
    //   2119: aload_2
    //   2120: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2123: lstore 10
    //   2125: lload 10
    //   2127: lstore 8
    //   2129: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2132: ifeq +31 -> 2163
    //   2135: ldc_w 277
    //   2138: iconst_2
    //   2139: new 32	java/lang/StringBuilder
    //   2142: dup
    //   2143: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   2146: ldc_w 1077
    //   2149: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: lload 8
    //   2154: invokevirtual 433	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2157: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2160: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2163: lload 8
    //   2165: lconst_0
    //   2166: lcmp
    //   2167: ifle +67 -> 2234
    //   2170: aload_0
    //   2171: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2174: ifnull +55 -> 2229
    //   2177: aload_0
    //   2178: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2181: invokevirtual 556	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2184: astore_1
    //   2185: aload_1
    //   2186: aconst_null
    //   2187: aload_2
    //   2188: invokestatic 1082	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2191: aload_1
    //   2192: ifnull -1987 -> 205
    //   2195: aload_1
    //   2196: ldc_w 1083
    //   2199: ldc_w 1084
    //   2202: invokevirtual 1087	android/app/Activity:overridePendingTransition	(II)V
    //   2205: goto -2000 -> 205
    //   2208: astore_1
    //   2209: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2212: ifeq -2007 -> 205
    //   2215: ldc_w 277
    //   2218: iconst_2
    //   2219: ldc_w 1089
    //   2222: aload_1
    //   2223: invokestatic 993	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2226: goto -2021 -> 205
    //   2229: aconst_null
    //   2230: astore_1
    //   2231: goto -46 -> 2185
    //   2234: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2237: ifeq -2032 -> 205
    //   2240: ldc_w 277
    //   2243: iconst_2
    //   2244: new 32	java/lang/StringBuilder
    //   2247: dup
    //   2248: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   2251: ldc_w 1091
    //   2254: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2257: aload_2
    //   2258: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2264: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2267: goto -2062 -> 205
    //   2270: ldc_w 1093
    //   2273: aload 4
    //   2275: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2278: ifeq -2073 -> 205
    //   2281: new 240	org/json/JSONObject
    //   2284: dup
    //   2285: aload 5
    //   2287: iconst_0
    //   2288: aaload
    //   2289: invokespecial 805	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2292: astore_1
    //   2293: aload_1
    //   2294: ldc_w 1095
    //   2297: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2300: astore_2
    //   2301: aload_2
    //   2302: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2305: istore 14
    //   2307: iload 14
    //   2309: ifne -2104 -> 205
    //   2312: aload_2
    //   2313: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2316: lstore 10
    //   2318: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2321: ifeq +31 -> 2352
    //   2324: ldc_w 277
    //   2327: iconst_2
    //   2328: new 32	java/lang/StringBuilder
    //   2331: dup
    //   2332: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   2335: ldc_w 1097
    //   2338: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: lload 10
    //   2343: invokevirtual 433	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2346: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2349: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2352: aload_1
    //   2353: ldc_w 1071
    //   2356: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2359: astore_1
    //   2360: lconst_0
    //   2361: lstore 8
    //   2363: aload_1
    //   2364: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2367: istore 14
    //   2369: lload 8
    //   2371: lstore 12
    //   2373: iload 14
    //   2375: ifne +55 -> 2430
    //   2378: aload_1
    //   2379: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2382: lstore 12
    //   2384: lload 12
    //   2386: lstore 8
    //   2388: lload 8
    //   2390: lstore 12
    //   2392: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2395: ifeq +35 -> 2430
    //   2398: ldc_w 277
    //   2401: iconst_2
    //   2402: new 32	java/lang/StringBuilder
    //   2405: dup
    //   2406: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   2409: ldc_w 1077
    //   2412: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: lload 8
    //   2417: invokevirtual 433	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2420: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2423: invokestatic 875	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2426: lload 8
    //   2428: lstore 12
    //   2430: lload 10
    //   2432: lconst_0
    //   2433: lcmp
    //   2434: ifle -2229 -> 205
    //   2437: lload 12
    //   2439: lconst_0
    //   2440: lcmp
    //   2441: ifle -2236 -> 205
    //   2444: aload_0
    //   2445: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2448: ifnull +70 -> 2518
    //   2451: aload_0
    //   2452: getfield 551	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2455: invokevirtual 556	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2458: astore_1
    //   2459: aload_0
    //   2460: aload_1
    //   2461: lload 12
    //   2463: lload 10
    //   2465: invokestatic 1102	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2468: bipush 7
    //   2470: invokevirtual 843	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2473: aload_1
    //   2474: ifnull -2269 -> 205
    //   2477: aload_1
    //   2478: ldc_w 1083
    //   2481: ldc_w 1084
    //   2484: invokevirtual 1087	android/app/Activity:overridePendingTransition	(II)V
    //   2487: goto -2282 -> 205
    //   2490: astore_1
    //   2491: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2494: ifeq -2289 -> 205
    //   2497: ldc_w 277
    //   2500: iconst_2
    //   2501: ldc_w 1089
    //   2504: aload_1
    //   2505: invokestatic 993	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2508: goto -2303 -> 205
    //   2511: astore_2
    //   2512: lconst_0
    //   2513: lstore 10
    //   2515: goto -197 -> 2318
    //   2518: aconst_null
    //   2519: astore_1
    //   2520: goto -61 -> 2459
    //   2523: astore_1
    //   2524: goto -395 -> 2129
    //   2527: astore_1
    //   2528: goto -140 -> 2388
    //   2531: aconst_null
    //   2532: astore_1
    //   2533: goto -1824 -> 709
    //   2536: iconst_m1
    //   2537: istore 6
    //   2539: goto -2293 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2542	0	this	TroopHWJsPlugin
    //   0	2542	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2542	2	paramString1	String
    //   0	2542	3	paramString2	String
    //   0	2542	4	paramString3	String
    //   0	2542	5	paramVarArgs	String[]
    //   244	2294	6	j	int
    //   410	846	7	k	int
    //   643	1784	8	l1	long
    //   2123	391	10	l2	long
    //   2371	91	12	l3	long
    //   2109	265	14	bool	boolean
    //   43	1250	15	localObject	Object
    //   52	10	16	str	String
    // Exception table:
    //   from	to	target	type
    //   20	32	207	org/json/JSONException
    //   741	771	774	java/lang/NumberFormatException
    //   811	827	774	java/lang/NumberFormatException
    //   1232	1248	1362	java/lang/Exception
    //   1258	1279	1362	java/lang/Exception
    //   1288	1298	1362	java/lang/Exception
    //   1639	1664	1667	java/lang/Exception
    //   2087	2111	2208	java/lang/Exception
    //   2129	2163	2208	java/lang/Exception
    //   2170	2185	2208	java/lang/Exception
    //   2185	2191	2208	java/lang/Exception
    //   2195	2205	2208	java/lang/Exception
    //   2234	2267	2208	java/lang/Exception
    //   2281	2307	2490	java/lang/Exception
    //   2318	2352	2490	java/lang/Exception
    //   2352	2360	2490	java/lang/Exception
    //   2363	2369	2490	java/lang/Exception
    //   2392	2426	2490	java/lang/Exception
    //   2444	2459	2490	java/lang/Exception
    //   2459	2473	2490	java/lang/Exception
    //   2477	2487	2490	java/lang/Exception
    //   2312	2318	2511	java/lang/Exception
    //   2119	2125	2523	java/lang/Exception
    //   2378	2384	2527	java/lang/Exception
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
                localObject1 = new annz(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
                paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (annz)localObject1, 0);
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
              paramIntent = new File(jdField_a_of_type_JavaLangString);
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
                  if (AlbumUtil.a((LocalMediaInfo)paramIntent.get(localObject3)) != 1) {
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
          ThreadManager.postImmediately(new anny(this, new annz(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
        } while (localHashMap1.size() <= 0);
        if (QLog.isColorLevel()) {
          QLog.e("TroopHWJsPlugin", 2, "pic selected! size = " + localHashMap1.size());
        }
        paramIntent = new File(jdField_a_of_type_JavaLangString);
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
        ThreadManager.postImmediately(new annx(this, localHashMap1), null, false);
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
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController = new TroopHWVoiceController(this.mRuntime.a(), this);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager = new TroopHWFileDownloadManager(this.mRuntime.a());
  }
  
  protected void onDestroy()
  {
    int k = 0;
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
    if ("homework".equals(this.g))
    {
      Object localObject1 = new File(jdField_a_of_type_JavaLangString);
      int j;
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).listFiles();
        j = 0;
        while (j < localObject1.length)
        {
          localObject1[j].delete();
          j += 1;
        }
      }
      localObject1 = new File(AppConstants.bf);
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).listFiles();
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
          localObject2 = new File((String)localObject2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */