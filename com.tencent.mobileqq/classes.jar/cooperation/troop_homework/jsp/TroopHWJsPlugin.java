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
import com.tencent.common.app.AppInterface;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements ITroopMemberApiClientApi.Callback, TroopHWFileDownloadManager.OnDownloadStateListener, TroopHWVoiceController.RecordCallback
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new TroopHWJsPlugin.5(this);
  ITroopMemberApiClientApi jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi = null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_HOMEWORK_AUDIO);
    localStringBuilder.append("homeworkTmp/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public TroopHWJsPlugin()
  {
    this.mPluginNameSpace = "homework";
  }
  
  @TargetApi(12)
  public static int a(Bitmap paramBitmap)
  {
    int j;
    if (Build.VERSION.SDK_INT >= 12)
    {
      j = paramBitmap.getByteCount();
    }
    else
    {
      j = paramBitmap.getRowBytes();
      j = paramBitmap.getHeight() * j;
    }
    if (j > 41246720) {
      return 0;
    }
    if (j > 6291456) {
      return 50;
    }
    if (j > 1048576) {
      return 80;
    }
    if (j > 102400) {
      return 90;
    }
    return 100;
  }
  
  @NonNull
  public static Intent a(int paramInt, Activity paramActivity, String paramString)
  {
    return ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getSelectMediaIntent(paramInt, paramActivity, paramString);
  }
  
  /* Error */
  private Bitmap a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 157	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   14: iload_1
    //   15: iconst_2
    //   16: ldc 159
    //   18: aconst_null
    //   19: iconst_m1
    //   20: invokevirtual 162	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   23: astore 8
    //   25: new 164	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 165	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 9
    //   34: aload 9
    //   36: aload_2
    //   37: invokevirtual 169	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   40: aload 9
    //   42: ldc2_w 170
    //   45: invokevirtual 175	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +176 -> 228
    //   55: aload_0
    //   56: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   59: istore_1
    //   60: sipush 540
    //   63: istore_3
    //   64: iload_1
    //   65: ifgt +10 -> 75
    //   68: sipush 540
    //   71: istore_1
    //   72: goto +8 -> 80
    //   75: aload_0
    //   76: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   79: istore_1
    //   80: aload_0
    //   81: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   84: ifgt +6 -> 90
    //   87: goto +8 -> 95
    //   90: aload_0
    //   91: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   94: istore_3
    //   95: aload 4
    //   97: iload_1
    //   98: iload_3
    //   99: invokestatic 181	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   102: astore 6
    //   104: aload 6
    //   106: astore_2
    //   107: aload 4
    //   109: astore 5
    //   111: aload 6
    //   113: ifnull +121 -> 234
    //   116: aload 6
    //   118: aload 6
    //   120: invokestatic 183	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   123: invokestatic 186	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   126: astore 7
    //   128: aload 6
    //   130: astore_2
    //   131: aload 4
    //   133: astore 5
    //   135: aload 7
    //   137: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: ifne +94 -> 234
    //   143: aload 8
    //   145: ldc 188
    //   147: aload 7
    //   149: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   152: pop
    //   153: aload 8
    //   155: ldc 196
    //   157: aload 6
    //   159: invokevirtual 199	android/graphics/Bitmap:getWidth	()I
    //   162: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload 8
    //   168: ldc 204
    //   170: aload 6
    //   172: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   175: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 6
    //   181: astore_2
    //   182: aload 4
    //   184: astore 5
    //   186: goto +48 -> 234
    //   189: astore 7
    //   191: goto +67 -> 258
    //   194: astore 7
    //   196: goto +120 -> 316
    //   199: astore 7
    //   201: goto +173 -> 374
    //   204: astore 7
    //   206: aconst_null
    //   207: astore 6
    //   209: goto +49 -> 258
    //   212: astore 7
    //   214: aconst_null
    //   215: astore 6
    //   217: goto +99 -> 316
    //   220: astore 7
    //   222: aconst_null
    //   223: astore 6
    //   225: goto +149 -> 374
    //   228: aconst_null
    //   229: astore_2
    //   230: aload 4
    //   232: astore 5
    //   234: aload 9
    //   236: invokevirtual 207	android/media/MediaMetadataRetriever:release	()V
    //   239: goto +193 -> 432
    //   242: goto +190 -> 432
    //   245: astore_2
    //   246: goto +232 -> 478
    //   249: astore 7
    //   251: aconst_null
    //   252: astore 4
    //   254: aload 4
    //   256: astore 6
    //   258: aload 6
    //   260: astore_2
    //   261: aload 4
    //   263: astore 5
    //   265: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -34 -> 234
    //   271: new 34	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc 215
    //   282: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_2
    //   287: aload 7
    //   289: invokevirtual 218	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: ldc 220
    //   298: iconst_2
    //   299: aload_2
    //   300: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 224	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 6
    //   308: astore_2
    //   309: aload 4
    //   311: astore 5
    //   313: goto -79 -> 234
    //   316: aload 6
    //   318: astore_2
    //   319: aload 4
    //   321: astore 5
    //   323: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -92 -> 234
    //   329: new 34	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   336: astore_2
    //   337: aload_2
    //   338: ldc 226
    //   340: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_2
    //   345: aload 7
    //   347: invokevirtual 227	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc 220
    //   356: iconst_2
    //   357: aload_2
    //   358: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 224	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 6
    //   366: astore_2
    //   367: aload 4
    //   369: astore 5
    //   371: goto -137 -> 234
    //   374: aload 6
    //   376: astore_2
    //   377: aload 4
    //   379: astore 5
    //   381: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq -150 -> 234
    //   387: new 34	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   394: astore_2
    //   395: aload_2
    //   396: ldc 226
    //   398: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_2
    //   403: aload 7
    //   405: invokevirtual 228	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   408: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: ldc 220
    //   414: iconst_2
    //   415: aload_2
    //   416: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 224	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aload 6
    //   424: astore_2
    //   425: aload 4
    //   427: astore 5
    //   429: goto -195 -> 234
    //   432: aload_0
    //   433: aload_0
    //   434: getfield 230	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   437: iconst_1
    //   438: anewarray 232	java/lang/String
    //   441: dup
    //   442: iconst_0
    //   443: aload 8
    //   445: invokevirtual 233	org/json/JSONObject:toString	()Ljava/lang/String;
    //   448: aastore
    //   449: invokevirtual 237	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   452: aload_2
    //   453: ifnull +15 -> 468
    //   456: aload 5
    //   458: ifnull +8 -> 466
    //   461: aload 5
    //   463: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   466: aload_2
    //   467: areturn
    //   468: aload 5
    //   470: ifnull +6 -> 476
    //   473: aload 5
    //   475: areturn
    //   476: aconst_null
    //   477: areturn
    //   478: aload 9
    //   480: invokevirtual 207	android/media/MediaMetadataRetriever:release	()V
    //   483: goto +5 -> 488
    //   486: aload_2
    //   487: athrow
    //   488: goto -2 -> 486
    //   491: astore 4
    //   493: goto -251 -> 242
    //   496: astore 4
    //   498: goto -15 -> 483
    //   501: astore 7
    //   503: aconst_null
    //   504: astore 4
    //   506: aload 4
    //   508: astore 6
    //   510: goto -194 -> 316
    //   513: astore 7
    //   515: aconst_null
    //   516: astore 4
    //   518: aload 4
    //   520: astore 6
    //   522: goto -148 -> 374
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	TroopHWJsPlugin
    //   0	525	1	paramInt	int
    //   0	525	2	paramString	String
    //   63	36	3	j	int
    //   48	378	4	localBitmap1	Bitmap
    //   491	1	4	localRuntimeException1	java.lang.RuntimeException
    //   496	1	4	localRuntimeException2	java.lang.RuntimeException
    //   504	15	4	localObject1	Object
    //   109	365	5	localBitmap2	Bitmap
    //   102	419	6	localObject2	Object
    //   126	22	7	str	String
    //   189	1	7	localJSONException1	JSONException
    //   194	1	7	localRuntimeException3	java.lang.RuntimeException
    //   199	1	7	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   204	1	7	localJSONException2	JSONException
    //   212	1	7	localRuntimeException4	java.lang.RuntimeException
    //   220	1	7	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   249	155	7	localJSONException3	JSONException
    //   501	1	7	localRuntimeException5	java.lang.RuntimeException
    //   513	1	7	localIllegalArgumentException3	java.lang.IllegalArgumentException
    //   23	421	8	localJSONObject	JSONObject
    //   32	447	9	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   116	128	189	org/json/JSONException
    //   135	179	189	org/json/JSONException
    //   116	128	194	java/lang/RuntimeException
    //   135	179	194	java/lang/RuntimeException
    //   116	128	199	java/lang/IllegalArgumentException
    //   135	179	199	java/lang/IllegalArgumentException
    //   55	60	204	org/json/JSONException
    //   75	80	204	org/json/JSONException
    //   80	87	204	org/json/JSONException
    //   90	95	204	org/json/JSONException
    //   95	104	204	org/json/JSONException
    //   55	60	212	java/lang/RuntimeException
    //   75	80	212	java/lang/RuntimeException
    //   80	87	212	java/lang/RuntimeException
    //   90	95	212	java/lang/RuntimeException
    //   95	104	212	java/lang/RuntimeException
    //   55	60	220	java/lang/IllegalArgumentException
    //   75	80	220	java/lang/IllegalArgumentException
    //   80	87	220	java/lang/IllegalArgumentException
    //   90	95	220	java/lang/IllegalArgumentException
    //   95	104	220	java/lang/IllegalArgumentException
    //   34	50	245	finally
    //   55	60	245	finally
    //   75	80	245	finally
    //   80	87	245	finally
    //   90	95	245	finally
    //   95	104	245	finally
    //   116	128	245	finally
    //   135	179	245	finally
    //   265	306	245	finally
    //   323	364	245	finally
    //   381	422	245	finally
    //   34	50	249	org/json/JSONException
    //   234	239	491	java/lang/RuntimeException
    //   478	483	496	java/lang/RuntimeException
    //   34	50	501	java/lang/RuntimeException
    //   34	50	513	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString, int paramInt2, TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    // Byte code:
    //   0: new 251	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 253	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 257	java/io/File:length	()J
    //   11: ldc2_w 258
    //   14: lcmp
    //   15: ifle +1154 -> 1169
    //   18: new 34	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   25: astore 14
    //   27: new 261	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 262	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 11
    //   36: aload 11
    //   38: iconst_1
    //   39: putfield 265	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload 11
    //   44: getstatic 271	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   47: putfield 274	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   50: aload 11
    //   52: iconst_1
    //   53: putfield 277	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   56: aload_1
    //   57: aload 11
    //   59: invokestatic 283	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: pop
    //   63: aload 11
    //   65: getfield 286	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: istore 8
    //   70: aload 11
    //   72: getfield 289	android/graphics/BitmapFactory$Options:outHeight	I
    //   75: istore 10
    //   77: iload 8
    //   79: ifle +1080 -> 1159
    //   82: iload 10
    //   84: ifgt +5 -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: iload 8
    //   91: iload_2
    //   92: if_icmpgt +22 -> 114
    //   95: aload_3
    //   96: ifnull +1090 -> 1186
    //   99: aload_3
    //   100: getfield 157	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   103: iload_0
    //   104: aload_1
    //   105: iload 8
    //   107: iload 10
    //   109: aload_3
    //   110: invokestatic 292	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;ILjava/lang/String;IILcooperation/troop_homework/jsp/TroopHWJsPlugin;)Ljava/lang/String;
    //   113: areturn
    //   114: new 294	android/graphics/Matrix
    //   117: dup
    //   118: invokespecial 295	android/graphics/Matrix:<init>	()V
    //   121: astore 15
    //   123: fconst_1
    //   124: fstore 5
    //   126: aload_1
    //   127: invokestatic 301	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   130: istore 9
    //   132: iload 9
    //   134: iconst_5
    //   135: if_icmpeq +1059 -> 1194
    //   138: iload 9
    //   140: bipush 6
    //   142: if_icmpeq +1052 -> 1194
    //   145: iload 9
    //   147: bipush 7
    //   149: if_icmpeq +1045 -> 1194
    //   152: iload 9
    //   154: bipush 8
    //   156: if_icmpne +1032 -> 1188
    //   159: goto +1035 -> 1194
    //   162: iload 7
    //   164: ifeq +12 -> 176
    //   167: iload 10
    //   169: iload_2
    //   170: idiv
    //   171: istore 8
    //   173: goto +9 -> 182
    //   176: iload 8
    //   178: iload_2
    //   179: idiv
    //   180: istore 8
    //   182: aload 11
    //   184: iconst_0
    //   185: putfield 265	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   188: iload 8
    //   190: iconst_1
    //   191: iushr
    //   192: iload 8
    //   194: ior
    //   195: istore 8
    //   197: iload 8
    //   199: iload 8
    //   201: iconst_2
    //   202: iushr
    //   203: ior
    //   204: istore 8
    //   206: iload 8
    //   208: iload 8
    //   210: iconst_4
    //   211: iushr
    //   212: ior
    //   213: istore 8
    //   215: iload 8
    //   217: iload 8
    //   219: bipush 8
    //   221: iushr
    //   222: ior
    //   223: istore 8
    //   225: aload 11
    //   227: iload 8
    //   229: iload 8
    //   231: bipush 16
    //   233: iushr
    //   234: ior
    //   235: iconst_1
    //   236: iadd
    //   237: iconst_1
    //   238: iushr
    //   239: putfield 304	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   242: new 306	java/io/FileInputStream
    //   245: dup
    //   246: aload_1
    //   247: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   250: astore 12
    //   252: aload 12
    //   254: astore 13
    //   256: aload 12
    //   258: aconst_null
    //   259: aload 11
    //   261: invokestatic 311	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   264: astore 11
    //   266: aload 11
    //   268: ifnonnull +10 -> 278
    //   271: aload 12
    //   273: invokevirtual 314	java/io/FileInputStream:close	()V
    //   276: aconst_null
    //   277: areturn
    //   278: iload 7
    //   280: ifeq +24 -> 304
    //   283: iload_2
    //   284: i2f
    //   285: fstore 6
    //   287: fload 5
    //   289: fstore 4
    //   291: aload 12
    //   293: astore 13
    //   295: aload 11
    //   297: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   300: istore_2
    //   301: goto +21 -> 322
    //   304: iload_2
    //   305: i2f
    //   306: fstore 6
    //   308: fload 5
    //   310: fstore 4
    //   312: aload 12
    //   314: astore 13
    //   316: aload 11
    //   318: invokevirtual 199	android/graphics/Bitmap:getWidth	()I
    //   321: istore_2
    //   322: fload 5
    //   324: fstore 4
    //   326: aload 12
    //   328: astore 13
    //   330: fload 6
    //   332: iload_2
    //   333: i2f
    //   334: fdiv
    //   335: f2d
    //   336: ldc2_w 315
    //   339: dcmpg
    //   340: ifge +860 -> 1200
    //   343: ldc_w 317
    //   346: fstore 5
    //   348: goto +852 -> 1200
    //   351: fload 5
    //   353: fstore 4
    //   355: aload 12
    //   357: astore 13
    //   359: aload 15
    //   361: fload 5
    //   363: fload 5
    //   365: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   368: goto +282 -> 650
    //   371: fload 5
    //   373: fstore 4
    //   375: aload 12
    //   377: astore 13
    //   379: aload 15
    //   381: fload 5
    //   383: fload 5
    //   385: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   388: fload 5
    //   390: fstore 4
    //   392: aload 12
    //   394: astore 13
    //   396: aload 15
    //   398: ldc_w 322
    //   401: invokevirtual 326	android/graphics/Matrix:postRotate	(F)Z
    //   404: pop
    //   405: goto +245 -> 650
    //   408: fload 5
    //   410: fstore 4
    //   412: aload 12
    //   414: astore 13
    //   416: aload 15
    //   418: fload 5
    //   420: fneg
    //   421: fload 5
    //   423: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   426: fload 5
    //   428: fstore 4
    //   430: aload 12
    //   432: astore 13
    //   434: aload 15
    //   436: ldc_w 327
    //   439: invokevirtual 326	android/graphics/Matrix:postRotate	(F)Z
    //   442: pop
    //   443: goto +207 -> 650
    //   446: fload 5
    //   448: fstore 4
    //   450: aload 12
    //   452: astore 13
    //   454: aload 15
    //   456: fload 5
    //   458: fload 5
    //   460: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   463: fload 5
    //   465: fstore 4
    //   467: aload 12
    //   469: astore 13
    //   471: aload 15
    //   473: ldc_w 327
    //   476: invokevirtual 326	android/graphics/Matrix:postRotate	(F)Z
    //   479: pop
    //   480: goto +170 -> 650
    //   483: fload 5
    //   485: fstore 4
    //   487: aload 12
    //   489: astore 13
    //   491: aload 15
    //   493: fload 5
    //   495: fload 5
    //   497: fneg
    //   498: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   501: fload 5
    //   503: fstore 4
    //   505: aload 12
    //   507: astore 13
    //   509: aload 15
    //   511: ldc_w 327
    //   514: invokevirtual 326	android/graphics/Matrix:postRotate	(F)Z
    //   517: pop
    //   518: goto +132 -> 650
    //   521: fload 5
    //   523: fstore 4
    //   525: aload 12
    //   527: astore 13
    //   529: aload 15
    //   531: fload 5
    //   533: fload 5
    //   535: fneg
    //   536: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   539: goto +111 -> 650
    //   542: fload 5
    //   544: fstore 4
    //   546: aload 12
    //   548: astore 13
    //   550: aload 15
    //   552: fload 5
    //   554: fload 5
    //   556: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   559: fload 5
    //   561: fstore 4
    //   563: aload 12
    //   565: astore 13
    //   567: aload 15
    //   569: ldc_w 328
    //   572: invokevirtual 326	android/graphics/Matrix:postRotate	(F)Z
    //   575: pop
    //   576: goto +74 -> 650
    //   579: fload 5
    //   581: fstore 4
    //   583: aload 12
    //   585: astore 13
    //   587: aload 15
    //   589: fload 5
    //   591: fneg
    //   592: fload 5
    //   594: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   597: goto +53 -> 650
    //   600: aconst_null
    //   601: astore 11
    //   603: fload 5
    //   605: fstore 4
    //   607: goto +21 -> 628
    //   610: astore_1
    //   611: aconst_null
    //   612: astore 13
    //   614: goto +533 -> 1147
    //   617: aconst_null
    //   618: astore 11
    //   620: aload 11
    //   622: astore 12
    //   624: fload 5
    //   626: fstore 4
    //   628: aload 12
    //   630: astore 13
    //   632: aload 15
    //   634: fload 4
    //   636: fload 4
    //   638: invokevirtual 321	android/graphics/Matrix:setScale	(FF)V
    //   641: aload 11
    //   643: astore 13
    //   645: aload 12
    //   647: ifnull +12 -> 659
    //   650: aload 12
    //   652: invokevirtual 314	java/io/FileInputStream:close	()V
    //   655: aload 11
    //   657: astore 13
    //   659: aload 13
    //   661: iconst_0
    //   662: iconst_0
    //   663: aload 13
    //   665: invokevirtual 199	android/graphics/Bitmap:getWidth	()I
    //   668: aload 13
    //   670: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   673: aload 15
    //   675: iconst_1
    //   676: invokestatic 332	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   679: astore 12
    //   681: aload 13
    //   683: aload 12
    //   685: if_acmpeq +8 -> 693
    //   688: aload 13
    //   690: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   693: aload 12
    //   695: invokevirtual 199	android/graphics/Bitmap:getWidth	()I
    //   698: istore_2
    //   699: aload 12
    //   701: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   704: istore 7
    //   706: aload 12
    //   708: invokestatic 183	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   711: istore 8
    //   713: iload 8
    //   715: ifle +79 -> 794
    //   718: new 334	java/io/ByteArrayOutputStream
    //   721: dup
    //   722: sipush 1024
    //   725: invokespecial 337	java/io/ByteArrayOutputStream:<init>	(I)V
    //   728: astore 11
    //   730: aload 12
    //   732: getstatic 343	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   735: iload 8
    //   737: aload 11
    //   739: invokevirtual 347	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   742: pop
    //   743: aload_3
    //   744: ifnull +18 -> 762
    //   747: aload 14
    //   749: aload 11
    //   751: invokevirtual 351	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   754: iconst_2
    //   755: invokestatic 357	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   758: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: goto +53 -> 815
    //   765: astore_1
    //   766: goto +316 -> 1082
    //   769: astore 13
    //   771: goto +322 -> 1093
    //   774: astore_1
    //   775: aconst_null
    //   776: astore 12
    //   778: aload 12
    //   780: astore_3
    //   781: goto +346 -> 1127
    //   784: astore 13
    //   786: aconst_null
    //   787: astore_1
    //   788: aload_1
    //   789: astore 11
    //   791: goto +304 -> 1095
    //   794: iload 8
    //   796: ifne +16 -> 812
    //   799: aload_3
    //   800: ifnull +12 -> 812
    //   803: aload_3
    //   804: getfield 98	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   807: iconst_1
    //   808: invokevirtual 363	android/os/Handler:sendEmptyMessage	(I)Z
    //   811: pop
    //   812: aconst_null
    //   813: astore 11
    //   815: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   818: ifeq +27 -> 845
    //   821: ldc 220
    //   823: iconst_2
    //   824: iconst_2
    //   825: anewarray 365	java/lang/Object
    //   828: dup
    //   829: iconst_0
    //   830: ldc_w 367
    //   833: aastore
    //   834: dup
    //   835: iconst_1
    //   836: iload 8
    //   838: invokestatic 373	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   841: aastore
    //   842: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   845: aload 12
    //   847: ifnull +8 -> 855
    //   850: aload 12
    //   852: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   855: aload_3
    //   856: ifnull +79 -> 935
    //   859: aload_3
    //   860: aload_3
    //   861: getfield 157	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   864: iload_0
    //   865: iconst_1
    //   866: ldc 159
    //   868: aconst_null
    //   869: iconst_m1
    //   870: invokevirtual 162	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   873: astore 12
    //   875: aload 14
    //   877: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   883: ifne +13 -> 896
    //   886: aload 12
    //   888: ldc 188
    //   890: aload 14
    //   892: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   895: pop
    //   896: aload 12
    //   898: ldc 196
    //   900: iload_2
    //   901: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   904: pop
    //   905: aload 12
    //   907: ldc 204
    //   909: iload 7
    //   911: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   914: pop
    //   915: aload_3
    //   916: aload_3
    //   917: getfield 230	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   920: iconst_1
    //   921: anewarray 232	java/lang/String
    //   924: dup
    //   925: iconst_0
    //   926: aload 12
    //   928: invokevirtual 233	org/json/JSONObject:toString	()Ljava/lang/String;
    //   931: aastore
    //   932: invokevirtual 237	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   935: aload 11
    //   937: ifnull +117 -> 1054
    //   940: new 34	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   947: astore_3
    //   948: aload_3
    //   949: getstatic 54	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   952: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload_3
    //   957: aload_1
    //   958: aload_1
    //   959: ldc_w 378
    //   962: invokevirtual 381	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   965: iconst_1
    //   966: iadd
    //   967: aload_1
    //   968: ldc_w 383
    //   971: invokevirtual 381	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   974: invokevirtual 387	java/lang/String:substring	(II)Ljava/lang/String;
    //   977: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: aload_3
    //   982: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   985: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload_3
    //   990: aload_1
    //   991: invokestatic 400	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   994: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: aload_3
    //   999: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: astore 13
    //   1004: new 402	com/tencent/mm/vfs/VFSFileOutputStream
    //   1007: dup
    //   1008: aload 13
    //   1010: invokespecial 403	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Ljava/lang/String;)V
    //   1013: astore_1
    //   1014: aload_1
    //   1015: astore 12
    //   1017: aload 11
    //   1019: astore_3
    //   1020: aload_1
    //   1021: aload 11
    //   1023: invokevirtual 351	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1026: invokevirtual 407	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   1029: aload_1
    //   1030: astore 12
    //   1032: aload 11
    //   1034: astore_3
    //   1035: aload 13
    //   1037: iconst_0
    //   1038: invokestatic 413	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1041: astore 13
    //   1043: aload 13
    //   1045: astore_3
    //   1046: goto +12 -> 1058
    //   1049: astore 13
    //   1051: goto +44 -> 1095
    //   1054: aconst_null
    //   1055: astore_3
    //   1056: aload_3
    //   1057: astore_1
    //   1058: aload 11
    //   1060: ifnull +8 -> 1068
    //   1063: aload 11
    //   1065: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   1068: aload_3
    //   1069: astore 11
    //   1071: aload_1
    //   1072: ifnull +178 -> 1250
    //   1075: aload_1
    //   1076: invokevirtual 415	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1079: aload_3
    //   1080: areturn
    //   1081: astore_1
    //   1082: aconst_null
    //   1083: astore 12
    //   1085: aload 11
    //   1087: astore_3
    //   1088: goto +39 -> 1127
    //   1091: astore 13
    //   1093: aconst_null
    //   1094: astore_1
    //   1095: aload_1
    //   1096: astore 12
    //   1098: aload 11
    //   1100: astore_3
    //   1101: aload 13
    //   1103: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   1106: aload 11
    //   1108: ifnull +8 -> 1116
    //   1111: aload 11
    //   1113: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   1116: aload_1
    //   1117: ifnull +130 -> 1247
    //   1120: aload_1
    //   1121: invokevirtual 415	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1124: goto +123 -> 1247
    //   1127: aload_3
    //   1128: ifnull +7 -> 1135
    //   1131: aload_3
    //   1132: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   1135: aload 12
    //   1137: ifnull +8 -> 1145
    //   1140: aload 12
    //   1142: invokevirtual 415	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1145: aload_1
    //   1146: athrow
    //   1147: aload 13
    //   1149: ifnull +8 -> 1157
    //   1152: aload 13
    //   1154: invokevirtual 314	java/io/FileInputStream:close	()V
    //   1157: aload_1
    //   1158: athrow
    //   1159: aconst_null
    //   1160: areturn
    //   1161: astore_1
    //   1162: aload_1
    //   1163: invokevirtual 419	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1166: invokestatic 422	java/lang/System:gc	()V
    //   1169: aconst_null
    //   1170: areturn
    //   1171: astore 11
    //   1173: goto -556 -> 617
    //   1176: astore 11
    //   1178: goto -578 -> 600
    //   1181: astore 13
    //   1183: goto -555 -> 628
    //   1186: aload_1
    //   1187: areturn
    //   1188: iconst_0
    //   1189: istore 7
    //   1191: goto -1029 -> 162
    //   1194: iconst_1
    //   1195: istore 7
    //   1197: goto -1035 -> 162
    //   1200: iload 9
    //   1202: tableswitch	default:+42 -> 1244, 2:+-623->579, 3:+-660->542, 4:+-681->521, 5:+-719->483, 6:+-756->446, 7:+-794->408, 8:+-831->371
    //   1245: <illegal opcode>
    //   1246: lxor
    //   1247: aconst_null
    //   1248: astore 11
    //   1250: aload 11
    //   1252: areturn
    //   1253: astore_1
    //   1254: goto -127 -> 1127
    //   1257: astore_1
    //   1258: goto -111 -> 1147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1261	0	paramInt1	int
    //   0	1261	1	paramString	String
    //   0	1261	2	paramInt2	int
    //   0	1261	3	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   289	348	4	f1	float
    //   124	501	5	f2	float
    //   285	46	6	f3	float
    //   162	1034	7	j	int
    //   68	769	8	k	int
    //   130	1071	9	m	int
    //   75	96	10	n	int
    //   34	1078	11	localObject1	Object
    //   1171	1	11	localIOException1	java.io.IOException
    //   1176	1	11	localIOException2	java.io.IOException
    //   1248	3	11	str1	String
    //   250	891	12	localObject2	Object
    //   254	435	13	localObject3	Object
    //   769	1	13	localIOException3	java.io.IOException
    //   784	1	13	localIOException4	java.io.IOException
    //   1002	42	13	str2	String
    //   1049	1	13	localIOException5	java.io.IOException
    //   1091	62	13	localIOException6	java.io.IOException
    //   1181	1	13	localIOException7	java.io.IOException
    //   25	866	14	localStringBuilder	StringBuilder
    //   121	553	15	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   126	132	610	finally
    //   167	173	610	finally
    //   176	182	610	finally
    //   182	188	610	finally
    //   225	252	610	finally
    //   730	743	765	finally
    //   747	762	765	finally
    //   730	743	769	java/io/IOException
    //   747	762	769	java/io/IOException
    //   718	730	774	finally
    //   803	812	774	finally
    //   718	730	784	java/io/IOException
    //   803	812	784	java/io/IOException
    //   1020	1029	1049	java/io/IOException
    //   1035	1043	1049	java/io/IOException
    //   815	845	1081	finally
    //   850	855	1081	finally
    //   859	896	1081	finally
    //   896	935	1081	finally
    //   940	1014	1081	finally
    //   815	845	1091	java/io/IOException
    //   850	855	1091	java/io/IOException
    //   859	896	1091	java/io/IOException
    //   896	935	1091	java/io/IOException
    //   940	1014	1091	java/io/IOException
    //   27	77	1161	java/lang/OutOfMemoryError
    //   99	114	1161	java/lang/OutOfMemoryError
    //   114	123	1161	java/lang/OutOfMemoryError
    //   271	276	1161	java/lang/OutOfMemoryError
    //   650	655	1161	java/lang/OutOfMemoryError
    //   659	681	1161	java/lang/OutOfMemoryError
    //   688	693	1161	java/lang/OutOfMemoryError
    //   693	713	1161	java/lang/OutOfMemoryError
    //   1063	1068	1161	java/lang/OutOfMemoryError
    //   1075	1079	1161	java/lang/OutOfMemoryError
    //   1111	1116	1161	java/lang/OutOfMemoryError
    //   1120	1124	1161	java/lang/OutOfMemoryError
    //   1131	1135	1161	java/lang/OutOfMemoryError
    //   1140	1145	1161	java/lang/OutOfMemoryError
    //   1145	1147	1161	java/lang/OutOfMemoryError
    //   1152	1157	1161	java/lang/OutOfMemoryError
    //   1157	1159	1161	java/lang/OutOfMemoryError
    //   126	132	1171	java/io/IOException
    //   167	173	1171	java/io/IOException
    //   176	182	1171	java/io/IOException
    //   182	188	1171	java/io/IOException
    //   225	252	1171	java/io/IOException
    //   256	266	1176	java/io/IOException
    //   295	301	1181	java/io/IOException
    //   316	322	1181	java/io/IOException
    //   330	343	1181	java/io/IOException
    //   359	368	1181	java/io/IOException
    //   379	388	1181	java/io/IOException
    //   396	405	1181	java/io/IOException
    //   416	426	1181	java/io/IOException
    //   434	443	1181	java/io/IOException
    //   454	463	1181	java/io/IOException
    //   471	480	1181	java/io/IOException
    //   491	501	1181	java/io/IOException
    //   509	518	1181	java/io/IOException
    //   529	539	1181	java/io/IOException
    //   550	559	1181	java/io/IOException
    //   567	576	1181	java/io/IOException
    //   587	597	1181	java/io/IOException
    //   1020	1029	1253	finally
    //   1035	1043	1253	finally
    //   1101	1106	1253	finally
    //   256	266	1257	finally
    //   295	301	1257	finally
    //   316	322	1257	finally
    //   330	343	1257	finally
    //   359	368	1257	finally
    //   379	388	1257	finally
    //   396	405	1257	finally
    //   416	426	1257	finally
    //   434	443	1257	finally
    //   454	463	1257	finally
    //   471	480	1257	finally
    //   491	501	1257	finally
    //   509	518	1257	finally
    //   529	539	1257	finally
    //   550	559	1257	finally
    //   567	576	1257	finally
    //   587	597	1257	finally
    //   632	641	1257	finally
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    if (QavCameraUsage.b(MobileQQ.getContext())) {
      return "";
    }
    BaseApplication localBaseApplication = MobileQQ.getContext();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_IMG_SAVE);
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(".jpg");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    Object localObject2 = new File((String)localObject1).getParentFile();
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
      QQToast.a(localBaseApplication, 2131718574, 0).a();
    }
    localObject2 = new Intent();
    FileProvider7Helper.setSystemCapture(paramActivity, new File((String)localObject1), (Intent)localObject2);
    if (paramActivity != null) {
      try
      {
        paramActivity.startActivityForResult((Intent)localObject2, paramInt);
        return localObject1;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        QQToast.a(localBaseApplication, 2131690725, 0).a();
      }
    }
    return localObject1;
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnull +106 -> 109
    //   6: new 334	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 337	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: getstatic 343	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   23: iload_1
    //   24: aload_3
    //   25: invokevirtual 347	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   28: pop
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 351	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   35: iconst_2
    //   36: invokestatic 357	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_3
    //   41: astore_2
    //   42: goto +69 -> 111
    //   45: astore_0
    //   46: goto +12 -> 58
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_2
    //   52: goto +35 -> 87
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_3
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: invokevirtual 483	java/lang/Exception:printStackTrace	()V
    //   64: aload_3
    //   65: ifnull +19 -> 84
    //   68: aload_3
    //   69: invokevirtual 487	java/io/ByteArrayOutputStream:flush	()V
    //   72: aload_3
    //   73: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   76: goto +8 -> 84
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aload_2
    //   88: ifnull +19 -> 107
    //   91: aload_2
    //   92: invokevirtual 487	java/io/ByteArrayOutputStream:flush	()V
    //   95: aload_2
    //   96: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   99: goto +8 -> 107
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: athrow
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_2
    //   112: ifnull +18 -> 130
    //   115: aload_2
    //   116: invokevirtual 487	java/io/ByteArrayOutputStream:flush	()V
    //   119: aload_2
    //   120: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   123: aload_0
    //   124: areturn
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramBitmap	Bitmap
    //   0	132	1	paramInt	int
    //   1	95	2	localObject	Object
    //   102	18	2	localIOException1	java.io.IOException
    //   125	2	2	localIOException2	java.io.IOException
    //   16	57	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   19	29	45	java/lang/Exception
    //   31	40	45	java/lang/Exception
    //   6	17	49	finally
    //   6	17	55	java/lang/Exception
    //   68	76	79	java/io/IOException
    //   19	29	86	finally
    //   31	40	86	finally
    //   60	64	86	finally
    //   91	99	102	java/io/IOException
    //   115	123	125	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    // Byte code:
    //   0: new 306	java/io/FileInputStream
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: new 34	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   17: astore 8
    //   19: sipush 30720
    //   22: newarray byte
    //   24: astore 9
    //   26: aload 7
    //   28: aload 9
    //   30: invokevirtual 491	java/io/FileInputStream:read	([B)I
    //   33: istore 6
    //   35: iload 6
    //   37: iconst_m1
    //   38: if_icmpeq +58 -> 96
    //   41: iload 6
    //   43: sipush 30720
    //   46: if_icmpge +35 -> 81
    //   49: iload 6
    //   51: newarray byte
    //   53: astore 10
    //   55: aload 9
    //   57: iconst_0
    //   58: aload 10
    //   60: iconst_0
    //   61: iload 6
    //   63: invokestatic 495	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   66: aload 8
    //   68: aload 10
    //   70: iconst_2
    //   71: invokestatic 357	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   74: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -52 -> 26
    //   81: aload 8
    //   83: aload 9
    //   85: iconst_2
    //   86: invokestatic 357	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   89: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: goto -67 -> 26
    //   96: aload 5
    //   98: ifnull +74 -> 172
    //   101: aload 5
    //   103: aload_0
    //   104: iload_1
    //   105: iconst_1
    //   106: ldc 159
    //   108: aconst_null
    //   109: iconst_m1
    //   110: invokevirtual 162	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   113: astore_0
    //   114: aload 8
    //   116: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne +12 -> 134
    //   125: aload_0
    //   126: ldc 188
    //   128: aload 8
    //   130: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload_0
    //   135: ldc 196
    //   137: iload_3
    //   138: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload_0
    //   143: ldc 204
    //   145: iload 4
    //   147: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload 5
    //   153: aload 5
    //   155: getfield 230	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   158: iconst_1
    //   159: anewarray 232	java/lang/String
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: invokevirtual 233	org/json/JSONObject:toString	()Ljava/lang/String;
    //   168: aastore
    //   169: invokevirtual 237	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   172: aload 7
    //   174: invokevirtual 314	java/io/FileInputStream:close	()V
    //   177: aload_2
    //   178: areturn
    //   179: astore_0
    //   180: aload 7
    //   182: astore_2
    //   183: goto +6 -> 189
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_2
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 314	java/io/FileInputStream:close	()V
    //   197: goto +5 -> 202
    //   200: aload_0
    //   201: athrow
    //   202: goto -2 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramString1	String
    //   0	205	1	paramInt1	int
    //   0	205	2	paramString2	String
    //   0	205	3	paramInt2	int
    //   0	205	4	paramInt3	int
    //   0	205	5	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   33	29	6	j	int
    //   8	173	7	localFileInputStream	java.io.FileInputStream
    //   17	112	8	localStringBuilder	StringBuilder
    //   24	60	9	arrayOfByte1	byte[]
    //   53	16	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	26	179	finally
    //   26	35	179	finally
    //   49	78	179	finally
    //   81	93	179	finally
    //   101	134	179	finally
    //   134	172	179	finally
    //   0	10	186	finally
  }
  
  private void e(int paramInt)
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    localActionSheet = ActionSheet.create(this.mRuntime.a());
    localActionSheet.addButton(2131718753, 1);
    localActionSheet.addButton(2131718743, 1);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new TroopHWJsPlugin.2(this, paramInt, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  private void f(int paramInt)
  {
    Activity localActivity;
    if (this.mRuntime == null) {
      localActivity = null;
    } else {
      localActivity = this.mRuntime.a();
    }
    if (localActivity == null)
    {
      QQToast.a(MobileQQ.getContext(), 2131690725, 0).a();
      return;
    }
    if ((localActivity instanceof AppActivity))
    {
      int j;
      if ((Build.VERSION.SDK_INT >= 23) && (localActivity.checkSelfPermission("android.permission.CAMERA") != 0)) {
        j = 0;
      } else {
        j = 1;
      }
      if (j == 0)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          ((AppActivity)localActivity).requestPermissions(new TroopHWJsPlugin.3(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
        }
      }
      else {
        this.jdField_c_of_type_JavaLangString = a(localActivity, paramInt);
      }
    }
    else
    {
      this.jdField_c_of_type_JavaLangString = a(localActivity, paramInt);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MD5Utils.toMD5(paramString2));
    ((StringBuilder)localObject).append(((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getFileSuffix(paramString2));
    paramString2 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_HOMEWORK_ATTACH);
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(File.separator);
    paramString1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    localObject = new File(paramString1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    return ((StringBuilder)localObject).toString();
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
      localJSONObject.put("type", "image");
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    Activity localActivity;
    if (this.mRuntime == null) {
      localActivity = null;
    } else {
      localActivity = this.mRuntime.a();
    }
    if (localActivity == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    if ((localActivity instanceof AppActivity))
    {
      int j;
      if ((Build.VERSION.SDK_INT >= 23) && ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j == 0)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          ((AppActivity)localActivity).requestPermissions(new TroopHWJsPlugin.4(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
      }
      else {
        b(paramInt);
      }
    }
    else
    {
      b(paramInt);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    JSONObject localJSONObject = a(this.jdField_d_of_type_JavaLangString, paramInt, 2, "uploading", null, -1);
    try
    {
      localJSONObject.put("progress", paramFloat);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{'webid':'");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append("', 'type':'record', 'state':'stopPlay', 'url':'");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'}");
      localObject = ((StringBuilder)localObject).toString();
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { localObject });
      localObject = this.f;
      if ((localObject != null) && (((String)localObject).equals(paramString))) {
        this.f = null;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{'webid':'");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append("', 'type':'record', 'state':'downloaded', 'url':'");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'}");
      paramString = ((StringBuilder)localObject).toString();
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramString });
    }
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
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.jdField_d_of_type_Int += 1;
    if (this.jdField_b_of_type_Boolean) {
      ThreadManager.post(new TroopHWJsPlugin.6(this, paramString), 2, null, false);
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
    if ((!((ITroopHWApi)QRoute.api(ITroopHWApi.class)).isAbsBaseWebViewActivity(localActivity)) && (localWebViewProvider == null))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).gotoSelectPicture(localActivity, localWebViewProvider, this, paramInt, (byte)3);
  }
  
  public void b(int paramInt, String paramString)
  {
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { a(this.jdField_d_of_type_JavaLangString, paramInt, 0, "stopPlay", null, -1).toString() });
    int j = this.jdField_e_of_type_Int;
    if ((j != -1) && (paramInt == j)) {
      this.jdField_e_of_type_Int = -1;
    }
  }
  
  protected void c(int paramInt)
  {
    Activity localActivity;
    if (this.mRuntime == null) {
      localActivity = null;
    } else {
      localActivity = this.mRuntime.a();
    }
    if (localActivity == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    }
    if ((localActivity instanceof AppActivity))
    {
      int j;
      if ((Build.VERSION.SDK_INT >= 23) && ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j == 0)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          ((AppActivity)localActivity).requestPermissions(new TroopHWJsPlugin.7(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
      }
      else {
        d(paramInt);
      }
    }
    else
    {
      d(paramInt);
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
    if (paramBundle == null) {
      return;
    }
    if ("getFileInfo".equals(paramBundle.getString("method")))
    {
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(paramBundle.getLong("sessionId"));
      localForwardFileInfo.d(paramBundle.getInt("cloudType"));
      localForwardFileInfo.b(paramBundle.getInt("type"));
      localForwardFileInfo.a(paramBundle.getString("filePath"));
      localForwardFileInfo.d(paramBundle.getString("fileName"));
      localForwardFileInfo.d(paramBundle.getLong("fileSize"));
      localForwardFileInfo.a(paramBundle.getLong("troopCode"));
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openTroopFilerDetailBrowse(this.mRuntime.a(), localForwardFileInfo);
    }
  }
  
  protected void d(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    WebViewProvider localWebViewProvider = this.mRuntime.a();
    if ((!((ITroopHWApi)QRoute.api(ITroopHWApi.class)).isAbsBaseWebViewActivity(localActivity)) && (localWebViewProvider == null))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    }
    Intent localIntent = a(paramInt, localActivity, this.mRuntime.a().getCurrentAccountUin());
    ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).goSelectMedia(localActivity, localWebViewProvider, this, localIntent, (byte)5);
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 2L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934597L)
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a();
      return false;
    }
    if ((paramLong == 2L) && (this.jdField_a_of_type_Boolean))
    {
      paramString = new StringBuilder();
      paramString.append("{'webid':");
      paramString.append(this.jdField_d_of_type_JavaLangString);
      paramString.append(", 'type':'home', 'state':'click'}");
      paramString = paramString.toString();
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramString });
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_2
    //   4: ifnull +2881 -> 2885
    //   7: ldc 100
    //   9: aload_3
    //   10: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +2872 -> 2885
    //   16: aload 4
    //   18: ifnonnull +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: aconst_null
    //   24: astore 16
    //   26: aconst_null
    //   27: astore 17
    //   29: aconst_null
    //   30: astore 18
    //   32: aconst_null
    //   33: astore 19
    //   35: new 190	org/json/JSONObject
    //   38: dup
    //   39: aload 5
    //   41: iconst_0
    //   42: aaload
    //   43: invokespecial 805	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore_1
    //   47: goto +5 -> 52
    //   50: aconst_null
    //   51: astore_1
    //   52: ldc_w 807
    //   55: aload 4
    //   57: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: istore 8
    //   62: ldc_w 438
    //   65: astore 15
    //   67: iload 8
    //   69: ifeq +86 -> 155
    //   72: aload 19
    //   74: astore_2
    //   75: aload_1
    //   76: ifnull +11 -> 87
    //   79: aload_1
    //   80: ldc_w 808
    //   83: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload_0
    //   88: aload_2
    //   89: iconst_1
    //   90: anewarray 232	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: ldc_w 438
    //   98: aastore
    //   99: invokevirtual 237	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   102: aload_0
    //   103: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   106: invokevirtual 513	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnonnull +5 -> 116
    //   114: iconst_0
    //   115: ireturn
    //   116: new 469	android/content/Intent
    //   119: dup
    //   120: invokespecial 470	android/content/Intent:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc_w 813
    //   128: aload 5
    //   130: iconst_0
    //   131: aaload
    //   132: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   135: pop
    //   136: aload_1
    //   137: iconst_m1
    //   138: aload_2
    //   139: invokevirtual 821	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   142: aload_1
    //   143: invokevirtual 824	android/app/Activity:isFinishing	()Z
    //   146: ifne +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 827	android/app/Activity:finish	()V
    //   153: iconst_1
    //   154: ireturn
    //   155: aload_1
    //   156: ifnull +102 -> 258
    //   159: aload_1
    //   160: ldc_w 829
    //   163: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 19
    //   168: aload_1
    //   169: ldc_w 616
    //   172: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 20
    //   177: aload_0
    //   178: aload 19
    //   180: putfield 230	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   183: aload_0
    //   184: aload 20
    //   186: putfield 157	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   189: aload_0
    //   190: aload_3
    //   191: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   194: aload_0
    //   195: aload_1
    //   196: ldc_w 831
    //   199: ldc_w 438
    //   202: invokevirtual 833	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: putfield 835	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   208: aload_0
    //   209: aload_1
    //   210: ldc_w 837
    //   213: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   216: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   219: aload_0
    //   220: aload_1
    //   221: ldc_w 842
    //   224: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   227: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   230: aload_0
    //   231: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   234: ifne +10 -> 244
    //   237: aload_0
    //   238: sipush 540
    //   241: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   244: aload_0
    //   245: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   248: ifne +10 -> 258
    //   251: aload_0
    //   252: sipush 540
    //   255: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   258: ldc_w 844
    //   261: aload 4
    //   263: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +72 -> 338
    //   269: aload_0
    //   270: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   273: invokevirtual 513	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   276: astore_1
    //   277: new 469	android/content/Intent
    //   280: dup
    //   281: invokespecial 470	android/content/Intent:<init>	()V
    //   284: astore_2
    //   285: aload_2
    //   286: new 846	android/content/ComponentName
    //   289: dup
    //   290: aload_1
    //   291: ldc_w 848
    //   294: invokespecial 851	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   297: invokevirtual 855	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   300: pop
    //   301: aload_2
    //   302: ldc_w 616
    //   305: aload_0
    //   306: getfield 157	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   309: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   312: pop
    //   313: aload_0
    //   314: getfield 230	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   317: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +10 -> 330
    //   323: aload_1
    //   324: aload_2
    //   325: invokevirtual 859	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   328: iconst_1
    //   329: ireturn
    //   330: aload_0
    //   331: aload_2
    //   332: iconst_1
    //   333: invokevirtual 862	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   336: iconst_1
    //   337: ireturn
    //   338: ldc_w 864
    //   341: aload 4
    //   343: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifeq +113 -> 459
    //   349: aload_1
    //   350: ifnull +15 -> 365
    //   353: aload_1
    //   354: ldc_w 614
    //   357: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   360: istore 6
    //   362: goto +6 -> 368
    //   365: iconst_m1
    //   366: istore 6
    //   368: aload_0
    //   369: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   372: istore 7
    //   374: iload 7
    //   376: iconst_m1
    //   377: if_icmpne +35 -> 412
    //   380: aload_0
    //   381: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   384: iload 6
    //   386: aload_0
    //   387: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   390: iload 6
    //   392: invokestatic 373	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: invokevirtual 868	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   398: checkcast 232	java/lang/String
    //   401: invokevirtual 870	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   404: aload_0
    //   405: iload 6
    //   407: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   410: iconst_1
    //   411: ireturn
    //   412: iload 6
    //   414: iload 7
    //   416: if_icmpeq +2467 -> 2883
    //   419: aload_0
    //   420: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   423: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   426: pop
    //   427: aload_0
    //   428: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   431: iload 6
    //   433: aload_0
    //   434: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   437: iload 6
    //   439: invokestatic 373	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   442: invokevirtual 868	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   445: checkcast 232	java/lang/String
    //   448: invokevirtual 870	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   451: aload_0
    //   452: iload 6
    //   454: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   457: iconst_1
    //   458: ireturn
    //   459: ldc_w 872
    //   462: aload 4
    //   464: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifeq +56 -> 523
    //   470: aload_1
    //   471: ifnull +15 -> 486
    //   474: aload_1
    //   475: ldc_w 614
    //   478: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   481: istore 6
    //   483: goto +6 -> 489
    //   486: iconst_m1
    //   487: istore 6
    //   489: aload_0
    //   490: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   493: istore 7
    //   495: iload 7
    //   497: iconst_m1
    //   498: if_icmpeq +2385 -> 2883
    //   501: iload 6
    //   503: iload 7
    //   505: if_icmpne +2378 -> 2883
    //   508: aload_0
    //   509: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   512: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   515: pop
    //   516: aload_0
    //   517: iconst_m1
    //   518: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   521: iconst_1
    //   522: ireturn
    //   523: ldc_w 874
    //   526: aload 4
    //   528: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: ifeq +221 -> 752
    //   534: bipush 10
    //   536: istore 6
    //   538: aload_1
    //   539: ifnull +34 -> 573
    //   542: aload_1
    //   543: ldc_w 876
    //   546: bipush 10
    //   548: invokevirtual 879	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   551: istore 6
    //   553: aload_0
    //   554: aload_1
    //   555: ldc_w 837
    //   558: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   561: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   564: aload_1
    //   565: ldc_w 881
    //   568: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   571: istore 7
    //   573: iload 7
    //   575: iconst_1
    //   576: if_icmpne +19 -> 595
    //   579: aload_0
    //   580: ldc 100
    //   582: invokestatic 885	com/tencent/mobileqq/webview/swift/WebViewUtil:a	(Ljava/lang/String;)I
    //   585: bipush 8
    //   587: ishl
    //   588: iconst_2
    //   589: iadd
    //   590: invokespecial 498	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	(I)V
    //   593: iconst_1
    //   594: ireturn
    //   595: iload 7
    //   597: iconst_2
    //   598: if_icmpne +11 -> 609
    //   601: aload_0
    //   602: iload 6
    //   604: invokevirtual 887	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   607: iconst_1
    //   608: ireturn
    //   609: iload 7
    //   611: iconst_3
    //   612: if_icmpne +132 -> 744
    //   615: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +35 -> 653
    //   621: new 34	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   628: astore_2
    //   629: aload_2
    //   630: ldc_w 889
    //   633: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload_2
    //   638: aload_1
    //   639: invokevirtual 892	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: ldc 220
    //   645: iconst_2
    //   646: aload_2
    //   647: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aload_0
    //   654: getfield 230	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   657: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   660: ifne +24 -> 684
    //   663: aload_0
    //   664: getfield 835	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   667: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifeq +6 -> 676
    //   673: goto +11 -> 684
    //   676: aload_0
    //   677: iload 6
    //   679: invokevirtual 896	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   682: iconst_1
    //   683: ireturn
    //   684: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +55 -> 742
    //   690: new 34	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   697: astore_1
    //   698: aload_1
    //   699: ldc_w 898
    //   702: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload_1
    //   707: aload_0
    //   708: getfield 230	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   711: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload_1
    //   716: ldc_w 900
    //   719: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload_1
    //   724: aload_0
    //   725: getfield 835	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   728: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: ldc 220
    //   734: iconst_2
    //   735: aload_1
    //   736: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 224	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: iconst_1
    //   743: ireturn
    //   744: aload_0
    //   745: iload 6
    //   747: invokespecial 902	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(I)V
    //   750: iconst_1
    //   751: ireturn
    //   752: ldc_w 904
    //   755: aload 4
    //   757: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   760: istore 8
    //   762: lconst_0
    //   763: lstore 9
    //   765: iload 8
    //   767: ifeq +220 -> 987
    //   770: aload_1
    //   771: ifnull +55 -> 826
    //   774: aload_1
    //   775: ldc_w 906
    //   778: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   781: astore 4
    //   783: aload_1
    //   784: ldc_w 908
    //   787: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   790: astore_2
    //   791: aload_1
    //   792: ldc_w 831
    //   795: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   798: astore_3
    //   799: aload_1
    //   800: ldc_w 910
    //   803: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   806: astore 5
    //   808: aload_1
    //   809: ldc_w 912
    //   812: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   815: astore 15
    //   817: aload 4
    //   819: astore_1
    //   820: aload_1
    //   821: astore 4
    //   823: goto +22 -> 845
    //   826: aconst_null
    //   827: astore 15
    //   829: aload 15
    //   831: astore_1
    //   832: aload_1
    //   833: astore_2
    //   834: aload_2
    //   835: astore_3
    //   836: aload_2
    //   837: astore 4
    //   839: aload_1
    //   840: astore_2
    //   841: aload 16
    //   843: astore 5
    //   845: aload 5
    //   847: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   850: ifne +13 -> 863
    //   853: aload 5
    //   855: invokestatic 917	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   858: invokevirtual 920	java/lang/Long:longValue	()J
    //   861: lstore 9
    //   863: aload 15
    //   865: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   868: ifne +16 -> 884
    //   871: aload 15
    //   873: invokestatic 923	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   876: invokevirtual 926	java/lang/Integer:intValue	()I
    //   879: istore 6
    //   881: goto +7 -> 888
    //   884: bipush 102
    //   886: istore 6
    //   888: aload_3
    //   889: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   892: ifne +35 -> 927
    //   895: aload_0
    //   896: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   899: astore_1
    //   900: aload_3
    //   901: invokestatic 917	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   904: invokevirtual 920	java/lang/Long:longValue	()J
    //   907: lstore 11
    //   909: aload_1
    //   910: lload 11
    //   912: aload_2
    //   913: aload 4
    //   915: lload 9
    //   917: iload 6
    //   919: aload_0
    //   920: invokeinterface 932 9 0
    //   925: iconst_1
    //   926: ireturn
    //   927: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +1953 -> 2883
    //   933: ldc 220
    //   935: iconst_2
    //   936: ldc_w 934
    //   939: invokestatic 936	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: iconst_1
    //   943: ireturn
    //   944: goto +3 -> 947
    //   947: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   950: ifeq +1933 -> 2883
    //   953: new 34	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   960: astore_1
    //   961: aload_1
    //   962: ldc_w 938
    //   965: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload_1
    //   970: aload_3
    //   971: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: ldc 220
    //   977: iconst_2
    //   978: aload_1
    //   979: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 936	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: iconst_1
    //   986: ireturn
    //   987: ldc_w 940
    //   990: aload 4
    //   992: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   995: ifeq +76 -> 1071
    //   998: aload_1
    //   999: ifnull +12 -> 1011
    //   1002: aload_1
    //   1003: ldc_w 622
    //   1006: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1009: astore 15
    //   1011: aload_0
    //   1012: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1015: astore_1
    //   1016: aload_1
    //   1017: ifnonnull +20 -> 1037
    //   1020: aload_0
    //   1021: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1024: aload 15
    //   1026: invokevirtual 941	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(Ljava/lang/String;)V
    //   1029: aload_0
    //   1030: aload 15
    //   1032: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1035: iconst_1
    //   1036: ireturn
    //   1037: aload_1
    //   1038: aload 15
    //   1040: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1043: ifne +1840 -> 2883
    //   1046: aload_0
    //   1047: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1050: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   1053: pop
    //   1054: aload_0
    //   1055: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1058: aload 15
    //   1060: invokevirtual 941	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(Ljava/lang/String;)V
    //   1063: aload_0
    //   1064: aload 15
    //   1066: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1069: iconst_1
    //   1070: ireturn
    //   1071: ldc_w 943
    //   1074: aload 4
    //   1076: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1079: ifeq +49 -> 1128
    //   1082: aload_1
    //   1083: ifnull +12 -> 1095
    //   1086: aload_1
    //   1087: ldc_w 622
    //   1090: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1093: astore 15
    //   1095: aload_0
    //   1096: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1099: astore_1
    //   1100: aload_1
    //   1101: ifnull +1782 -> 2883
    //   1104: aload_1
    //   1105: aload 15
    //   1107: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1110: ifeq +1773 -> 2883
    //   1113: aload_0
    //   1114: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1117: invokevirtual 794	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   1120: pop
    //   1121: aload_0
    //   1122: aconst_null
    //   1123: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1126: iconst_1
    //   1127: ireturn
    //   1128: ldc_w 945
    //   1131: aload 4
    //   1133: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1136: ifeq +22 -> 1158
    //   1139: aload_0
    //   1140: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1143: aload_0
    //   1144: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1147: invokevirtual 576	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1150: invokevirtual 948	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1153: invokevirtual 949	cooperation/troop_homework/jsp/TroopHWVoiceController:d	(Ljava/lang/String;)V
    //   1156: iconst_1
    //   1157: ireturn
    //   1158: ldc_w 951
    //   1161: aload 4
    //   1163: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1166: ifeq +38 -> 1204
    //   1169: aload_1
    //   1170: ifnull +25 -> 1195
    //   1173: aload_0
    //   1174: aload_1
    //   1175: ldc_w 953
    //   1178: invokevirtual 957	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1181: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1184: aload_0
    //   1185: aload_1
    //   1186: ldc_w 959
    //   1189: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1192: putfield 82	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1195: aload_0
    //   1196: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1199: invokevirtual 961	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()V
    //   1202: iconst_1
    //   1203: ireturn
    //   1204: ldc_w 963
    //   1207: aload 4
    //   1209: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1212: ifeq +24 -> 1236
    //   1215: new 965	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1218: dup
    //   1219: aload_0
    //   1220: aload_2
    //   1221: invokestatic 970	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   1224: invokespecial 971	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1227: bipush 8
    //   1229: aconst_null
    //   1230: iconst_0
    //   1231: invokestatic 691	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1234: iconst_1
    //   1235: ireturn
    //   1236: ldc_w 973
    //   1239: aload 4
    //   1241: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1244: ifeq +53 -> 1297
    //   1247: aload_1
    //   1248: ifnull +1635 -> 2883
    //   1251: aload_1
    //   1252: ldc_w 622
    //   1255: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1258: astore_2
    //   1259: aload_1
    //   1260: ldc_w 975
    //   1263: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1266: astore_3
    //   1267: aload_0
    //   1268: aload_1
    //   1269: ldc_w 829
    //   1272: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1275: putfield 700	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1278: aload_0
    //   1279: aload_3
    //   1280: aload_2
    //   1281: invokevirtual 703	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1284: astore_1
    //   1285: aload_0
    //   1286: getfield 977	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1289: aload_2
    //   1290: aload_1
    //   1291: aload_0
    //   1292: invokevirtual 982	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;Ljava/lang/String;Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager$OnDownloadStateListener;)V
    //   1295: iconst_1
    //   1296: ireturn
    //   1297: ldc_w 984
    //   1300: aload 4
    //   1302: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1305: ifeq +25 -> 1330
    //   1308: aload_1
    //   1309: ifnull +1574 -> 2883
    //   1312: aload_1
    //   1313: ldc_w 622
    //   1316: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1319: astore_1
    //   1320: aload_0
    //   1321: getfield 977	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1324: aload_1
    //   1325: invokevirtual 985	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;)V
    //   1328: iconst_1
    //   1329: ireturn
    //   1330: ldc_w 987
    //   1333: aload 4
    //   1335: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1338: ifeq +201 -> 1539
    //   1341: aload_1
    //   1342: ifnull +1541 -> 2883
    //   1345: aload_1
    //   1346: ldc_w 975
    //   1349: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1352: astore 4
    //   1354: aload_1
    //   1355: ldc_w 989
    //   1358: invokevirtual 993	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1361: astore 5
    //   1363: aload_1
    //   1364: ldc_w 829
    //   1367: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1370: astore_2
    //   1371: new 190	org/json/JSONObject
    //   1374: dup
    //   1375: invokespecial 612	org/json/JSONObject:<init>	()V
    //   1378: astore_3
    //   1379: new 995	org/json/JSONArray
    //   1382: dup
    //   1383: invokespecial 996	org/json/JSONArray:<init>	()V
    //   1386: astore 15
    //   1388: aload 5
    //   1390: invokevirtual 998	org/json/JSONArray:length	()I
    //   1393: istore 7
    //   1395: iconst_0
    //   1396: istore 6
    //   1398: iload 6
    //   1400: iload 7
    //   1402: if_icmpge +33 -> 1435
    //   1405: aload 15
    //   1407: iload 6
    //   1409: aload_0
    //   1410: aload 4
    //   1412: aload 5
    //   1414: iload 6
    //   1416: invokevirtual 1001	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1419: invokevirtual 1003	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1422: invokevirtual 1006	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1425: pop
    //   1426: iload 6
    //   1428: iconst_1
    //   1429: iadd
    //   1430: istore 6
    //   1432: goto -34 -> 1398
    //   1435: aload_3
    //   1436: ldc_w 1008
    //   1439: aload 15
    //   1441: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1444: pop
    //   1445: goto +22 -> 1467
    //   1448: astore 4
    //   1450: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1453: ifeq +14 -> 1467
    //   1456: ldc 220
    //   1458: iconst_2
    //   1459: ldc_w 1010
    //   1462: aload 4
    //   1464: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1467: aload_3
    //   1468: invokevirtual 233	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1471: astore_3
    //   1472: aload_0
    //   1473: aload_2
    //   1474: iconst_1
    //   1475: anewarray 232	java/lang/String
    //   1478: dup
    //   1479: iconst_0
    //   1480: aload_3
    //   1481: aastore
    //   1482: invokevirtual 237	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1485: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1488: ifeq +1395 -> 2883
    //   1491: new 34	java/lang/StringBuilder
    //   1494: dup
    //   1495: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1498: astore_2
    //   1499: aload_2
    //   1500: ldc_w 1010
    //   1503: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: pop
    //   1507: aload_2
    //   1508: aload_1
    //   1509: invokevirtual 892	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload_2
    //   1514: ldc_w 1015
    //   1517: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: aload_2
    //   1522: aload_3
    //   1523: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: pop
    //   1527: ldc 220
    //   1529: iconst_2
    //   1530: aload_2
    //   1531: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1537: iconst_1
    //   1538: ireturn
    //   1539: ldc_w 1017
    //   1542: aload 4
    //   1544: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1547: ifeq +74 -> 1621
    //   1550: aload_1
    //   1551: ifnull +1332 -> 2883
    //   1554: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1557: ifeq +35 -> 1592
    //   1560: new 34	java/lang/StringBuilder
    //   1563: dup
    //   1564: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1567: astore_2
    //   1568: aload_2
    //   1569: ldc_w 1019
    //   1572: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: pop
    //   1576: aload_2
    //   1577: aload_1
    //   1578: invokevirtual 892	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1581: pop
    //   1582: ldc 220
    //   1584: iconst_2
    //   1585: aload_2
    //   1586: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1589: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1592: aload_1
    //   1593: ldc_w 1021
    //   1596: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1599: astore_2
    //   1600: aload_1
    //   1601: ldc_w 1023
    //   1604: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1607: astore_1
    //   1608: aload_0
    //   1609: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   1612: aload_2
    //   1613: aload_1
    //   1614: invokeinterface 1026 3 0
    //   1619: iconst_1
    //   1620: ireturn
    //   1621: ldc_w 1028
    //   1624: aload 4
    //   1626: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1629: ifeq +57 -> 1686
    //   1632: aload_1
    //   1633: ifnull +53 -> 1686
    //   1636: aload_1
    //   1637: ldc_w 624
    //   1640: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1643: pop
    //   1644: aload_1
    //   1645: ldc_w 614
    //   1648: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1651: istore 6
    //   1653: aload_0
    //   1654: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1657: iload 6
    //   1659: invokestatic 373	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1662: invokevirtual 868	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1665: checkcast 566	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1668: astore_1
    //   1669: aload_1
    //   1670: ifnull +1213 -> 2883
    //   1673: aload_1
    //   1674: getfield 1029	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Boolean	Z
    //   1677: ifne +1206 -> 2883
    //   1680: aload_1
    //   1681: invokevirtual 1031	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:b	()V
    //   1684: iconst_1
    //   1685: ireturn
    //   1686: ldc_w 1033
    //   1689: aload 4
    //   1691: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1694: ifeq +61 -> 1755
    //   1697: aload_1
    //   1698: ifnull +57 -> 1755
    //   1701: aload_1
    //   1702: ldc_w 624
    //   1705: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1708: pop
    //   1709: aload_1
    //   1710: ldc_w 614
    //   1713: invokevirtual 840	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1716: istore 6
    //   1718: aload_0
    //   1719: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1722: iload 6
    //   1724: invokestatic 373	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1727: invokevirtual 868	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1730: checkcast 566	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1733: astore_1
    //   1734: aload_1
    //   1735: ifnull +1148 -> 2883
    //   1738: aload_1
    //   1739: getfield 1029	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Boolean	Z
    //   1742: ifeq +1141 -> 2883
    //   1745: aload_1
    //   1746: getfield 1036	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1749: iconst_1
    //   1750: invokevirtual 1042	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1753: iconst_1
    //   1754: ireturn
    //   1755: ldc_w 1044
    //   1758: aload 4
    //   1760: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1763: ifeq +81 -> 1844
    //   1766: aload_1
    //   1767: ifnull +1116 -> 2883
    //   1770: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1773: ifeq +23 -> 1796
    //   1776: ldc 220
    //   1778: iconst_2
    //   1779: iconst_2
    //   1780: anewarray 365	java/lang/Object
    //   1783: dup
    //   1784: iconst_0
    //   1785: ldc_w 1046
    //   1788: aastore
    //   1789: dup
    //   1790: iconst_1
    //   1791: aload_1
    //   1792: aastore
    //   1793: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1796: aload_1
    //   1797: ldc_w 975
    //   1800: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1803: astore_2
    //   1804: aload_1
    //   1805: ldc_w 624
    //   1808: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1811: astore_1
    //   1812: aload_0
    //   1813: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   1816: aload_2
    //   1817: aload_1
    //   1818: invokeinterface 1049 3 0
    //   1823: iconst_1
    //   1824: ireturn
    //   1825: astore_1
    //   1826: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1829: ifeq +1054 -> 2883
    //   1832: ldc 220
    //   1834: iconst_2
    //   1835: ldc_w 1051
    //   1838: aload_1
    //   1839: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1842: iconst_1
    //   1843: ireturn
    //   1844: ldc_w 1053
    //   1847: aload 4
    //   1849: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1852: ifeq +159 -> 2011
    //   1855: aload_1
    //   1856: ifnull +1027 -> 2883
    //   1859: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1862: ifeq +35 -> 1897
    //   1865: new 34	java/lang/StringBuilder
    //   1868: dup
    //   1869: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1872: astore_2
    //   1873: aload_2
    //   1874: ldc_w 1055
    //   1877: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: pop
    //   1881: aload_2
    //   1882: aload_1
    //   1883: invokevirtual 892	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1886: pop
    //   1887: ldc 220
    //   1889: iconst_2
    //   1890: aload_2
    //   1891: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1894: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1897: aload_1
    //   1898: ldc_w 614
    //   1901: iconst_0
    //   1902: invokevirtual 879	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1905: istore 6
    //   1907: aload_0
    //   1908: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1911: iload 6
    //   1913: invokestatic 373	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1916: invokevirtual 868	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1919: checkcast 566	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1922: astore_1
    //   1923: aload_1
    //   1924: ifnull +53 -> 1977
    //   1927: aload_1
    //   1928: getfield 595	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1931: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1934: ifne +43 -> 1977
    //   1937: new 735	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1940: dup
    //   1941: invokespecial 736	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1944: astore_2
    //   1945: aload_2
    //   1946: aload_1
    //   1947: getfield 595	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1950: invokevirtual 754	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1953: ldc_w 768
    //   1956: invokestatic 139	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1959: checkcast 768	com/tencent/mobileqq/filemanager/api/IQQFileTempUtils
    //   1962: aload_0
    //   1963: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1966: invokevirtual 513	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1969: aload_2
    //   1970: invokeinterface 772 3 0
    //   1975: iconst_1
    //   1976: ireturn
    //   1977: new 34	java/lang/StringBuilder
    //   1980: dup
    //   1981: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1984: astore_2
    //   1985: aload_2
    //   1986: ldc_w 1057
    //   1989: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: pop
    //   1993: aload_2
    //   1994: aload_1
    //   1995: invokevirtual 892	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1998: pop
    //   1999: ldc 220
    //   2001: iconst_1
    //   2002: aload_2
    //   2003: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2006: invokestatic 936	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2009: iconst_1
    //   2010: ireturn
    //   2011: ldc_w 1059
    //   2014: aload 4
    //   2016: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2019: ifeq +17 -> 2036
    //   2022: aload_0
    //   2023: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2026: invokevirtual 1062	java/util/HashMap:clear	()V
    //   2029: aload_0
    //   2030: iconst_1
    //   2031: putfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   2034: iconst_1
    //   2035: ireturn
    //   2036: ldc_w 1064
    //   2039: aload 4
    //   2041: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2044: ifeq +78 -> 2122
    //   2047: aload_1
    //   2048: ifnull +835 -> 2883
    //   2051: aload_1
    //   2052: ldc_w 614
    //   2055: iconst_0
    //   2056: invokevirtual 879	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2059: istore 6
    //   2061: aload_0
    //   2062: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2065: iload 6
    //   2067: invokestatic 373	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2070: invokevirtual 868	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2073: checkcast 566	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   2076: astore_1
    //   2077: aload_1
    //   2078: ifnull +805 -> 2883
    //   2081: aload_1
    //   2082: getfield 595	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2085: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2088: ifne +795 -> 2883
    //   2091: new 251	java/io/File
    //   2094: dup
    //   2095: aload_1
    //   2096: getfield 595	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2099: invokespecial 253	java/io/File:<init>	(Ljava/lang/String;)V
    //   2102: astore_2
    //   2103: aload_0
    //   2104: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   2107: aload_1
    //   2108: getfield 595	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2111: aload_2
    //   2112: invokevirtual 1067	java/io/File:getName	()Ljava/lang/String;
    //   2115: invokeinterface 1026 3 0
    //   2120: iconst_1
    //   2121: ireturn
    //   2122: ldc_w 1069
    //   2125: aload 4
    //   2127: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2130: ifeq +189 -> 2319
    //   2133: new 190	org/json/JSONObject
    //   2136: dup
    //   2137: aload 5
    //   2139: iconst_0
    //   2140: aaload
    //   2141: invokespecial 805	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2144: ldc_w 1071
    //   2147: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2150: astore_2
    //   2151: aload_2
    //   2152: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2155: istore 8
    //   2157: iload 8
    //   2159: ifne +724 -> 2883
    //   2162: aload_2
    //   2163: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2166: lstore 9
    //   2168: goto +6 -> 2174
    //   2171: lconst_0
    //   2172: lstore 9
    //   2174: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2177: ifeq +36 -> 2213
    //   2180: new 34	java/lang/StringBuilder
    //   2183: dup
    //   2184: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2187: astore_1
    //   2188: aload_1
    //   2189: ldc_w 1077
    //   2192: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2195: pop
    //   2196: aload_1
    //   2197: lload 9
    //   2199: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2202: pop
    //   2203: ldc 220
    //   2205: iconst_2
    //   2206: aload_1
    //   2207: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2210: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2213: lload 9
    //   2215: lconst_0
    //   2216: lcmp
    //   2217: ifle +43 -> 2260
    //   2220: aload_0
    //   2221: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2224: ifnull +695 -> 2919
    //   2227: aload_0
    //   2228: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2231: invokevirtual 513	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2234: astore_1
    //   2235: goto +3 -> 2238
    //   2238: aload_1
    //   2239: ifnull +644 -> 2883
    //   2242: aload_1
    //   2243: aconst_null
    //   2244: aload_2
    //   2245: invokestatic 1082	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2248: aload_1
    //   2249: ldc_w 1083
    //   2252: ldc_w 1084
    //   2255: invokevirtual 1087	android/app/Activity:overridePendingTransition	(II)V
    //   2258: iconst_1
    //   2259: ireturn
    //   2260: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2263: ifeq +620 -> 2883
    //   2266: new 34	java/lang/StringBuilder
    //   2269: dup
    //   2270: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2273: astore_1
    //   2274: aload_1
    //   2275: ldc_w 1089
    //   2278: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2281: pop
    //   2282: aload_1
    //   2283: aload_2
    //   2284: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2287: pop
    //   2288: ldc 220
    //   2290: iconst_2
    //   2291: aload_1
    //   2292: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2295: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2298: iconst_1
    //   2299: ireturn
    //   2300: astore_1
    //   2301: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2304: ifeq +579 -> 2883
    //   2307: ldc 220
    //   2309: iconst_2
    //   2310: ldc_w 1091
    //   2313: aload_1
    //   2314: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2317: iconst_1
    //   2318: ireturn
    //   2319: ldc_w 1093
    //   2322: aload 4
    //   2324: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2327: ifeq +247 -> 2574
    //   2330: new 190	org/json/JSONObject
    //   2333: dup
    //   2334: aload 5
    //   2336: iconst_0
    //   2337: aaload
    //   2338: invokespecial 805	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2341: astore_1
    //   2342: aload_1
    //   2343: ldc_w 1095
    //   2346: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2349: astore_2
    //   2350: aload_2
    //   2351: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2354: istore 8
    //   2356: iload 8
    //   2358: ifne +525 -> 2883
    //   2361: aload_2
    //   2362: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2365: lstore 11
    //   2367: goto +6 -> 2373
    //   2370: lconst_0
    //   2371: lstore 11
    //   2373: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2376: ifeq +36 -> 2412
    //   2379: new 34	java/lang/StringBuilder
    //   2382: dup
    //   2383: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2386: astore_2
    //   2387: aload_2
    //   2388: ldc_w 1097
    //   2391: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2394: pop
    //   2395: aload_2
    //   2396: lload 11
    //   2398: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2401: pop
    //   2402: ldc 220
    //   2404: iconst_2
    //   2405: aload_2
    //   2406: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2409: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2412: aload_1
    //   2413: ldc_w 1071
    //   2416: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2419: astore_1
    //   2420: aload_1
    //   2421: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2424: istore 8
    //   2426: iload 8
    //   2428: ifne +496 -> 2924
    //   2431: aload_1
    //   2432: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2435: lstore 9
    //   2437: goto +6 -> 2443
    //   2440: lconst_0
    //   2441: lstore 9
    //   2443: lload 9
    //   2445: lstore 13
    //   2447: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2450: ifeq +43 -> 2493
    //   2453: new 34	java/lang/StringBuilder
    //   2456: dup
    //   2457: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2460: astore_1
    //   2461: aload_1
    //   2462: ldc_w 1077
    //   2465: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: pop
    //   2469: aload_1
    //   2470: lload 9
    //   2472: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2475: pop
    //   2476: ldc 220
    //   2478: iconst_2
    //   2479: aload_1
    //   2480: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2483: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2486: lload 9
    //   2488: lstore 13
    //   2490: goto +3 -> 2493
    //   2493: lload 11
    //   2495: lconst_0
    //   2496: lcmp
    //   2497: ifle +386 -> 2883
    //   2500: lload 13
    //   2502: lconst_0
    //   2503: lcmp
    //   2504: ifle +379 -> 2883
    //   2507: aload 17
    //   2509: astore_1
    //   2510: aload_0
    //   2511: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2514: ifnull +11 -> 2525
    //   2517: aload_0
    //   2518: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2521: invokevirtual 513	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2524: astore_1
    //   2525: aload_0
    //   2526: aload_1
    //   2527: lload 13
    //   2529: lload 11
    //   2531: invokestatic 1102	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2534: bipush 7
    //   2536: invokevirtual 862	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2539: aload_1
    //   2540: ifnull +343 -> 2883
    //   2543: aload_1
    //   2544: ldc_w 1083
    //   2547: ldc_w 1084
    //   2550: invokevirtual 1087	android/app/Activity:overridePendingTransition	(II)V
    //   2553: iconst_1
    //   2554: ireturn
    //   2555: astore_1
    //   2556: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2559: ifeq +324 -> 2883
    //   2562: ldc 220
    //   2564: iconst_2
    //   2565: ldc_w 1091
    //   2568: aload_1
    //   2569: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2572: iconst_1
    //   2573: ireturn
    //   2574: ldc_w 1104
    //   2577: aload 4
    //   2579: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2582: ifeq +301 -> 2883
    //   2585: new 190	org/json/JSONObject
    //   2588: dup
    //   2589: aload 5
    //   2591: iconst_0
    //   2592: aaload
    //   2593: invokespecial 805	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2596: astore_2
    //   2597: aload_2
    //   2598: ldc_w 1095
    //   2601: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2604: astore_1
    //   2605: aload_2
    //   2606: ldc_w 1071
    //   2609: invokevirtual 1072	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2612: astore_2
    //   2613: aload_1
    //   2614: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2617: ifne +195 -> 2812
    //   2620: aload_2
    //   2621: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2624: istore 8
    //   2626: iload 8
    //   2628: ifne +184 -> 2812
    //   2631: aload_1
    //   2632: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2635: lstore 9
    //   2637: goto +6 -> 2643
    //   2640: lconst_0
    //   2641: lstore 9
    //   2643: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2646: ifeq +36 -> 2682
    //   2649: new 34	java/lang/StringBuilder
    //   2652: dup
    //   2653: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2656: astore_1
    //   2657: aload_1
    //   2658: ldc_w 1106
    //   2661: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2664: pop
    //   2665: aload_1
    //   2666: lload 9
    //   2668: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2671: pop
    //   2672: ldc 220
    //   2674: iconst_2
    //   2675: aload_1
    //   2676: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2679: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2682: aload_2
    //   2683: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2686: lstore 11
    //   2688: goto +6 -> 2694
    //   2691: lconst_0
    //   2692: lstore 11
    //   2694: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2697: ifeq +36 -> 2733
    //   2700: new 34	java/lang/StringBuilder
    //   2703: dup
    //   2704: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2707: astore_1
    //   2708: aload_1
    //   2709: ldc_w 1108
    //   2712: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2715: pop
    //   2716: aload_1
    //   2717: lload 11
    //   2719: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2722: pop
    //   2723: ldc 220
    //   2725: iconst_2
    //   2726: aload_1
    //   2727: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2730: invokestatic 894	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2733: lload 9
    //   2735: lconst_0
    //   2736: lcmp
    //   2737: ifle +146 -> 2883
    //   2740: lload 11
    //   2742: lconst_0
    //   2743: lcmp
    //   2744: ifle +139 -> 2883
    //   2747: aload 18
    //   2749: astore_1
    //   2750: aload_0
    //   2751: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2754: ifnull +11 -> 2765
    //   2757: aload_0
    //   2758: getfield 508	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2761: invokevirtual 513	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2764: astore_1
    //   2765: new 730	android/os/Bundle
    //   2768: dup
    //   2769: invokespecial 1109	android/os/Bundle:<init>	()V
    //   2772: astore_3
    //   2773: aload_3
    //   2774: ldc_w 1095
    //   2777: lload 9
    //   2779: invokevirtual 1113	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2782: aload_3
    //   2783: ldc_w 1115
    //   2786: iconst_2
    //   2787: invokevirtual 1119	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2790: aload_1
    //   2791: ifnull +92 -> 2883
    //   2794: aload_1
    //   2795: aload_3
    //   2796: aload_2
    //   2797: invokestatic 1082	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2800: aload_1
    //   2801: ldc_w 1083
    //   2804: ldc_w 1084
    //   2807: invokevirtual 1087	android/app/Activity:overridePendingTransition	(II)V
    //   2810: iconst_1
    //   2811: ireturn
    //   2812: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2815: ifeq +68 -> 2883
    //   2818: new 34	java/lang/StringBuilder
    //   2821: dup
    //   2822: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2825: astore_3
    //   2826: aload_3
    //   2827: ldc_w 1121
    //   2830: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2833: pop
    //   2834: aload_3
    //   2835: aload_1
    //   2836: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: pop
    //   2840: aload_3
    //   2841: ldc_w 1123
    //   2844: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2847: pop
    //   2848: aload_3
    //   2849: aload_2
    //   2850: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2853: pop
    //   2854: ldc 220
    //   2856: iconst_2
    //   2857: aload_3
    //   2858: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2861: invokestatic 936	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2864: iconst_1
    //   2865: ireturn
    //   2866: astore_1
    //   2867: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2870: ifeq +13 -> 2883
    //   2873: ldc 220
    //   2875: iconst_2
    //   2876: ldc_w 1091
    //   2879: aload_1
    //   2880: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2883: iconst_1
    //   2884: ireturn
    //   2885: iconst_0
    //   2886: ireturn
    //   2887: astore_1
    //   2888: goto -2838 -> 50
    //   2891: astore_1
    //   2892: goto -1945 -> 947
    //   2895: astore_1
    //   2896: goto -1952 -> 944
    //   2899: astore_1
    //   2900: goto -729 -> 2171
    //   2903: astore_2
    //   2904: goto -534 -> 2370
    //   2907: astore_1
    //   2908: goto -468 -> 2440
    //   2911: astore_1
    //   2912: goto -272 -> 2640
    //   2915: astore_1
    //   2916: goto -225 -> 2691
    //   2919: aconst_null
    //   2920: astore_1
    //   2921: goto -683 -> 2238
    //   2924: lconst_0
    //   2925: lstore 13
    //   2927: goto -434 -> 2493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2930	0	this	TroopHWJsPlugin
    //   0	2930	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2930	2	paramString1	String
    //   0	2930	3	paramString2	String
    //   0	2930	4	paramString3	String
    //   0	2930	5	paramVarArgs	String[]
    //   360	1706	6	j	int
    //   1	1402	7	k	int
    //   60	2567	8	bool	boolean
    //   763	2015	9	l1	long
    //   907	1834	11	l2	long
    //   2445	481	13	l3	long
    //   65	1375	15	localObject1	Object
    //   24	818	16	localObject2	Object
    //   27	2481	17	localObject3	Object
    //   30	2718	18	localObject4	Object
    //   33	146	19	str1	String
    //   175	10	20	str2	String
    // Exception table:
    //   from	to	target	type
    //   1379	1395	1448	java/lang/Exception
    //   1405	1426	1448	java/lang/Exception
    //   1435	1445	1448	java/lang/Exception
    //   1796	1823	1825	java/lang/Exception
    //   2133	2157	2300	java/lang/Exception
    //   2174	2213	2300	java/lang/Exception
    //   2220	2235	2300	java/lang/Exception
    //   2242	2258	2300	java/lang/Exception
    //   2260	2298	2300	java/lang/Exception
    //   2330	2356	2555	java/lang/Exception
    //   2373	2412	2555	java/lang/Exception
    //   2412	2426	2555	java/lang/Exception
    //   2447	2486	2555	java/lang/Exception
    //   2510	2525	2555	java/lang/Exception
    //   2525	2539	2555	java/lang/Exception
    //   2543	2553	2555	java/lang/Exception
    //   2585	2626	2866	java/lang/Exception
    //   2643	2682	2866	java/lang/Exception
    //   2694	2733	2866	java/lang/Exception
    //   2750	2765	2866	java/lang/Exception
    //   2765	2790	2866	java/lang/Exception
    //   2794	2810	2866	java/lang/Exception
    //   2812	2864	2866	java/lang/Exception
    //   35	47	2887	org/json/JSONException
    //   888	909	2891	java/lang/NumberFormatException
    //   909	925	2895	java/lang/NumberFormatException
    //   927	942	2895	java/lang/NumberFormatException
    //   2162	2168	2899	java/lang/Exception
    //   2361	2367	2903	java/lang/Exception
    //   2431	2437	2907	java/lang/Exception
    //   2631	2637	2911	java/lang/Exception
    //   2682	2688	2915	java/lang/Exception
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte != 1)
    {
      if ((paramByte != 2) && (paramByte != 3) && (paramByte != 5))
      {
        if (paramByte != 7) {
          return;
        }
        if ((paramInt == -1) && (paramIntent != null))
        {
          paramIntent = paramIntent.getStringExtra("SubmitHomeWorkFragment:js_callback");
          if (!TextUtils.isEmpty(paramIntent)) {
            callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramIntent });
          }
        }
      }
      else if (paramInt == -1)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        Object localObject1;
        if ((paramByte == 2) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
        {
          BaseImageUtil.a(this.mRuntime.a(), this.jdField_c_of_type_JavaLangString);
          localHashMap1.put(Integer.valueOf(this.jdField_d_of_type_Int), this.jdField_c_of_type_JavaLangString);
          this.jdField_d_of_type_Int += 1;
        }
        else
        {
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          } else {
            localObject1 = null;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
            break label875;
          }
          paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("selected pic or video! size = ");
            if (paramIntent != null) {
              paramInt = paramIntent.size();
            } else {
              paramInt = 0;
            }
            ((StringBuilder)localObject3).append(paramInt);
            QLog.d("TroopHWJsPlugin", 2, ((StringBuilder)localObject3).toString());
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            if ((paramIntent != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramIntent.get(localObject3)) == 1)) {
              paramInt = 1;
            } else {
              paramInt = 0;
            }
            if (paramInt != 0) {
              localHashMap2.put(Integer.valueOf(this.jdField_d_of_type_Int), localObject3);
            } else {
              localHashMap1.put(Integer.valueOf(this.jdField_d_of_type_Int), localObject3);
            }
            this.jdField_d_of_type_Int += 1;
          }
          if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
            break label816;
          }
        }
        if (localHashMap2.size() > 0)
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("video selected! size = ");
            paramIntent.append(localHashMap2.size());
            QLog.e("TroopHWJsPlugin", 2, paramIntent.toString());
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
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new TroopHWJsPlugin.RequestSource(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
        }
        if (localHashMap1.size() > 0)
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("pic selected! size = ");
            paramIntent.append(localHashMap1.size());
            QLog.e("TroopHWJsPlugin", 2, paramIntent.toString());
          }
          paramIntent = new VFSFile(jdField_a_of_type_JavaLangString);
          if (!paramIntent.exists()) {
            paramIntent.mkdirs();
          }
          paramIntent = localHashMap1.entrySet().iterator();
          while (paramIntent.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramIntent.next();
            paramInt = ((Integer)localEntry.getKey()).intValue();
            if (!TextUtils.isEmpty((String)localEntry.getValue())) {
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
          label816:
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("mJsCallback == ");
            paramIntent.append(this.jdField_b_of_type_JavaLangString);
            paramIntent.append(", mTroopUin == ");
            paramIntent.append(this.jdField_e_of_type_JavaLangString);
            QLog.w("TroopHWJsPlugin", 2, paramIntent.toString());
            return;
            label875:
            QLog.e("TroopHWJsPlugin", 1, "selected list empty!");
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
          }
        }
      }
    }
    else if (paramInt == -1)
    {
      if (paramIntent == null) {
        localObject2 = "";
      } else {
        localObject2 = paramIntent.getStringExtra("jscallback");
      }
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        try
        {
          ((JSONObject)localObject2).put("id", this.jdField_d_of_type_Int);
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        localObject2 = null;
      }
      if (localObject2 == null)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return;
      }
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
      if (paramIntent == null) {
        paramIntent = "";
      } else {
        paramIntent = paramIntent.getStringExtra("localPath");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
      Object localObject2 = new TroopHWJsPlugin.RequestSource(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (TroopHWJsPlugin.RequestSource)localObject2, 0);
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
      paramIntent.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a();
      this.jdField_d_of_type_Int += 1;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi = ((ITroopMemberApiClientApi)QRoute.api(ITroopMemberApiClientApi.class));
    this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi.doBindService();
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController = new TroopHWVoiceController(this.mRuntime.a(), this);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager = new TroopHWFileDownloadManager(this.mRuntime.a());
  }
  
  protected void onDestroy()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi;
    if (localObject1 != null) {
      ((ITroopMemberApiClientApi)localObject1).doUnbindService();
    }
    super.onDestroy();
    localObject1 = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager;
    if (localObject1 != null) {
      ((TroopHWFileDownloadManager)localObject1).a(this.mRuntime.a());
    }
    if ("homework".equals(this.g))
    {
      localObject1 = new VFSFile(jdField_a_of_type_JavaLangString);
      boolean bool = ((VFSFile)localObject1).exists();
      int k = 0;
      int j;
      if (bool)
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
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = this.mRuntime.a();
    if ((paramCustomWebView != null) && (paramCustomWebView.getUrl() != null) && (paramCustomWebView.getUrl().contains("https://"))) {
      this.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */