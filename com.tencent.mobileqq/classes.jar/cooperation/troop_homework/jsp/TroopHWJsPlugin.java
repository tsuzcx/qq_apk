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
import beyy;
import bfuc;
import bfvo;
import bgve;
import bjnw;
import bkxx;
import bkxy;
import bkya;
import bkyb;
import bkyc;
import bkyd;
import bkye;
import bkyf;
import bkyg;
import bkyh;
import bkyl;
import bkyn;
import com.tencent.biz.pubaccount.CustomWebView;
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
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import ljo;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;
import zon;
import zop;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements bkya, bkyn, zop
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new bkye(this);
  bjnw jdField_a_of_type_Bjnw = null;
  private bkxy jdField_a_of_type_Bkxy;
  bkyl jdField_a_of_type_Bkyl = null;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  zon jdField_a_of_type_Zon = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 540;
  String jdField_b_of_type_JavaLangString;
  HashMap<Integer, bkyh> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  public String c;
  private boolean jdField_c_of_type_Boolean;
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
    //   1: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 196	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   14: iload_1
    //   15: iconst_2
    //   16: ldc 198
    //   18: aconst_null
    //   19: iconst_m1
    //   20: invokevirtual 201	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   23: astore 6
    //   25: new 203	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 204	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 7
    //   34: aload 7
    //   36: aload_2
    //   37: invokevirtual 208	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   40: aload 7
    //   42: ldc2_w 209
    //   45: invokevirtual 214	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
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
    //   78: invokestatic 220	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +59 -> 144
    //   88: aload 4
    //   90: aload 4
    //   92: invokestatic 222	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   95: invokestatic 225	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   98: astore 5
    //   100: aload 5
    //   102: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +39 -> 144
    //   108: aload 6
    //   110: ldc 227
    //   112: aload 5
    //   114: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload 6
    //   120: ldc 235
    //   122: aload 4
    //   124: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
    //   127: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload 6
    //   133: ldc 243
    //   135: aload 4
    //   137: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   140: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload 7
    //   146: invokevirtual 246	android/media/MediaMetadataRetriever:release	()V
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_1
    //   155: anewarray 250	java/lang/String
    //   158: dup
    //   159: iconst_0
    //   160: aload 6
    //   162: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   165: aastore
    //   166: invokevirtual 255	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   169: aload 4
    //   171: ifnull +209 -> 380
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 258	android/graphics/Bitmap:recycle	()V
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
    //   208: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +34 -> 245
    //   214: ldc_w 266
    //   217: iconst_2
    //   218: new 34	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 268
    //   228: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 5
    //   233: invokevirtual 271	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 275	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 7
    //   247: invokevirtual 246	android/media/MediaMetadataRetriever:release	()V
    //   250: goto -101 -> 149
    //   253: astore 5
    //   255: goto -106 -> 149
    //   258: astore 5
    //   260: aconst_null
    //   261: astore_2
    //   262: aconst_null
    //   263: astore 4
    //   265: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +34 -> 302
    //   271: ldc_w 266
    //   274: iconst_2
    //   275: new 34	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 268
    //   285: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 5
    //   290: invokevirtual 276	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   293: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 275	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload 7
    //   304: invokevirtual 246	android/media/MediaMetadataRetriever:release	()V
    //   307: goto -158 -> 149
    //   310: astore 5
    //   312: goto -163 -> 149
    //   315: astore 5
    //   317: aconst_null
    //   318: astore_2
    //   319: aconst_null
    //   320: astore 4
    //   322: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +34 -> 359
    //   328: ldc_w 266
    //   331: iconst_2
    //   332: new 34	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 278
    //   342: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 5
    //   347: invokevirtual 279	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 275	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 7
    //   361: invokevirtual 246	android/media/MediaMetadataRetriever:release	()V
    //   364: goto -215 -> 149
    //   367: astore 5
    //   369: goto -220 -> 149
    //   372: astore_2
    //   373: aload 7
    //   375: invokevirtual 246	android/media/MediaMetadataRetriever:release	()V
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
    //   0: new 290	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 296	java/io/File:length	()J
    //   11: ldc2_w 297
    //   14: lcmp
    //   15: ifle +290 -> 305
    //   18: aconst_null
    //   19: astore 12
    //   21: new 34	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   28: astore 15
    //   30: new 300	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 301	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_1
    //   42: putfield 304	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload 17
    //   47: getstatic 310	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   50: putfield 313	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   53: aload 17
    //   55: iconst_1
    //   56: putfield 316	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   59: aload_1
    //   60: aload 17
    //   62: invokestatic 322	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 17
    //   68: getfield 325	android/graphics/BitmapFactory$Options:outWidth	I
    //   71: istore 8
    //   73: aload 17
    //   75: getfield 328	android/graphics/BitmapFactory$Options:outHeight	I
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
    //   107: getfield 196	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   110: iload_0
    //   111: aload_1
    //   112: iload 8
    //   114: iload 10
    //   116: aload_3
    //   117: invokestatic 331	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;ILjava/lang/String;IILcooperation/troop_homework/jsp/TroopHWJsPlugin;)Ljava/lang/String;
    //   120: areturn
    //   121: aconst_null
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 14
    //   127: new 333	android/graphics/Matrix
    //   130: dup
    //   131: invokespecial 334	android/graphics/Matrix:<init>	()V
    //   134: astore 16
    //   136: fconst_1
    //   137: fstore 5
    //   139: iconst_0
    //   140: istore 7
    //   142: aload_1
    //   143: invokestatic 340	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
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
    //   192: putfield 304	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
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
    //   246: putfield 343	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   249: new 345	java/io/FileInputStream
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 346	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   257: astore 13
    //   259: fload 5
    //   261: fstore 4
    //   263: aload 14
    //   265: astore 12
    //   267: aload 13
    //   269: aconst_null
    //   270: aload 17
    //   272: invokestatic 350	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   275: astore 11
    //   277: aload 11
    //   279: ifnonnull +37 -> 316
    //   282: aconst_null
    //   283: astore 11
    //   285: aload 13
    //   287: ifnull +992 -> 1279
    //   290: aload 13
    //   292: invokevirtual 353	java/io/FileInputStream:close	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 356	java/lang/OutOfMemoryError:printStackTrace	()V
    //   302: invokestatic 361	java/lang/System:gc	()V
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
    //   335: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
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
    //   377: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   380: aload 11
    //   382: astore 12
    //   384: aload 13
    //   386: ifnull +883 -> 1269
    //   389: aload 13
    //   391: invokevirtual 353	java/io/FileInputStream:close	()V
    //   394: aload 11
    //   396: iconst_0
    //   397: iconst_0
    //   398: aload 11
    //   400: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
    //   403: aload 11
    //   405: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   408: aload 16
    //   410: iconst_1
    //   411: invokestatic 369	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   414: astore 14
    //   416: aload 11
    //   418: aload 14
    //   420: if_acmpeq +8 -> 428
    //   423: aload 11
    //   425: invokevirtual 258	android/graphics/Bitmap:recycle	()V
    //   428: aload 14
    //   430: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
    //   433: istore_2
    //   434: aload 14
    //   436: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   439: istore 7
    //   441: aconst_null
    //   442: astore 13
    //   444: aconst_null
    //   445: astore 12
    //   447: aload 14
    //   449: invokestatic 222	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   452: istore 8
    //   454: iload 8
    //   456: ifle +604 -> 1060
    //   459: new 371	java/io/ByteArrayOutputStream
    //   462: dup
    //   463: sipush 1024
    //   466: invokespecial 374	java/io/ByteArrayOutputStream:<init>	(I)V
    //   469: astore 11
    //   471: aload 14
    //   473: getstatic 380	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   476: iload 8
    //   478: aload 11
    //   480: invokevirtual 384	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   483: pop
    //   484: aload_3
    //   485: ifnull +781 -> 1266
    //   488: aload 15
    //   490: aload 11
    //   492: invokevirtual 388	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   495: iconst_2
    //   496: invokestatic 394	bfuc:encodeToString	([BI)Ljava/lang/String;
    //   499: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +28 -> 534
    //   509: ldc_w 266
    //   512: iconst_2
    //   513: iconst_2
    //   514: anewarray 146	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: ldc_w 396
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: iload 8
    //   527: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   534: aload 14
    //   536: ifnull +8 -> 544
    //   539: aload 14
    //   541: invokevirtual 258	android/graphics/Bitmap:recycle	()V
    //   544: aload_3
    //   545: ifnull +79 -> 624
    //   548: aload_3
    //   549: aload_3
    //   550: getfield 196	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: iload_0
    //   554: iconst_1
    //   555: ldc 198
    //   557: aconst_null
    //   558: iconst_m1
    //   559: invokevirtual 201	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   562: astore 13
    //   564: aload 15
    //   566: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   572: ifne +13 -> 585
    //   575: aload 13
    //   577: ldc 227
    //   579: aload 15
    //   581: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   584: pop
    //   585: aload 13
    //   587: ldc 235
    //   589: iload_2
    //   590: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload 13
    //   596: ldc 243
    //   598: iload 7
    //   600: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   603: pop
    //   604: aload_3
    //   605: aload_3
    //   606: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   609: iconst_1
    //   610: anewarray 250	java/lang/String
    //   613: dup
    //   614: iconst_0
    //   615: aload 13
    //   617: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   620: aastore
    //   621: invokevirtual 255	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   624: aload 11
    //   626: ifnull +633 -> 1259
    //   629: new 34	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   636: getstatic 54	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   639: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_1
    //   643: aload_1
    //   644: ldc_w 407
    //   647: invokevirtual 410	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   650: iconst_1
    //   651: iadd
    //   652: aload_1
    //   653: ldc_w 412
    //   656: invokevirtual 410	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   659: invokevirtual 416	java/lang/String:substring	(II)Ljava/lang/String;
    //   662: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   668: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: aload_1
    //   672: invokestatic 428	com/tencent/mobileqq/filemanager/util/FileUtil:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   675: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: astore_3
    //   682: new 430	com/tencent/mm/vfs/VFSFileOutputStream
    //   685: dup
    //   686: aload_3
    //   687: invokespecial 431	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Ljava/lang/String;)V
    //   690: astore_1
    //   691: aload_1
    //   692: aload 11
    //   694: invokevirtual 388	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   697: invokevirtual 435	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   700: aload_3
    //   701: iconst_0
    //   702: invokestatic 441	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   705: astore 12
    //   707: aload_1
    //   708: astore_3
    //   709: aload 12
    //   711: astore_1
    //   712: aload 11
    //   714: ifnull +8 -> 722
    //   717: aload 11
    //   719: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   722: aload_1
    //   723: astore 11
    //   725: aload_3
    //   726: ifnull +10 -> 736
    //   729: aload_3
    //   730: invokevirtual 443	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
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
    //   753: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
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
    //   796: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   799: goto -419 -> 380
    //   802: astore 11
    //   804: aload 12
    //   806: astore 11
    //   808: aload 16
    //   810: fload 4
    //   812: fload 4
    //   814: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   817: aload 11
    //   819: astore 12
    //   821: aload 13
    //   823: ifnull +446 -> 1269
    //   826: aload 13
    //   828: invokevirtual 353	java/io/FileInputStream:close	()V
    //   831: goto -437 -> 394
    //   834: fload 5
    //   836: fstore 4
    //   838: aload 11
    //   840: astore 12
    //   842: aload 16
    //   844: fload 5
    //   846: fload 5
    //   848: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   851: fload 5
    //   853: fstore 4
    //   855: aload 11
    //   857: astore 12
    //   859: aload 16
    //   861: ldc_w 444
    //   864: invokevirtual 448	android/graphics/Matrix:postRotate	(F)Z
    //   867: pop
    //   868: goto -488 -> 380
    //   871: astore_1
    //   872: aload 13
    //   874: astore_3
    //   875: aload_3
    //   876: ifnull +7 -> 883
    //   879: aload_3
    //   880: invokevirtual 353	java/io/FileInputStream:close	()V
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
    //   904: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   907: goto -527 -> 380
    //   910: fload 5
    //   912: fstore 4
    //   914: aload 11
    //   916: astore 12
    //   918: aload 16
    //   920: fload 5
    //   922: fload 5
    //   924: fneg
    //   925: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   928: fload 5
    //   930: fstore 4
    //   932: aload 11
    //   934: astore 12
    //   936: aload 16
    //   938: ldc_w 449
    //   941: invokevirtual 448	android/graphics/Matrix:postRotate	(F)Z
    //   944: pop
    //   945: goto -565 -> 380
    //   948: fload 5
    //   950: fstore 4
    //   952: aload 11
    //   954: astore 12
    //   956: aload 16
    //   958: fload 5
    //   960: fload 5
    //   962: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   965: fload 5
    //   967: fstore 4
    //   969: aload 11
    //   971: astore 12
    //   973: aload 16
    //   975: ldc_w 449
    //   978: invokevirtual 448	android/graphics/Matrix:postRotate	(F)Z
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
    //   1000: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   1003: fload 5
    //   1005: fstore 4
    //   1007: aload 11
    //   1009: astore 12
    //   1011: aload 16
    //   1013: ldc_w 449
    //   1016: invokevirtual 448	android/graphics/Matrix:postRotate	(F)Z
    //   1019: pop
    //   1020: goto -640 -> 380
    //   1023: fload 5
    //   1025: fstore 4
    //   1027: aload 11
    //   1029: astore 12
    //   1031: aload 16
    //   1033: fload 5
    //   1035: fload 5
    //   1037: invokevirtual 365	android/graphics/Matrix:setScale	(FF)V
    //   1040: fload 5
    //   1042: fstore 4
    //   1044: aload 11
    //   1046: astore 12
    //   1048: aload 16
    //   1050: ldc_w 450
    //   1053: invokevirtual 448	android/graphics/Matrix:postRotate	(F)Z
    //   1056: pop
    //   1057: goto -677 -> 380
    //   1060: iload 8
    //   1062: ifne +16 -> 1078
    //   1065: aload_3
    //   1066: ifnull +12 -> 1078
    //   1069: aload_3
    //   1070: getfield 96	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1073: iconst_1
    //   1074: invokevirtual 456	android/os/Handler:sendEmptyMessage	(I)Z
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
    //   1093: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   1096: aconst_null
    //   1097: astore 12
    //   1099: aload_3
    //   1100: ifnull +7 -> 1107
    //   1103: aload_3
    //   1104: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   1107: aload 12
    //   1109: astore 11
    //   1111: aload_1
    //   1112: ifnull -376 -> 736
    //   1115: aload_1
    //   1116: invokevirtual 443	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1119: aload 12
    //   1121: astore 11
    //   1123: goto -387 -> 736
    //   1126: aload 11
    //   1128: ifnull +8 -> 1136
    //   1131: aload 11
    //   1133: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   1136: aload_3
    //   1137: ifnull +7 -> 1144
    //   1140: aload_3
    //   1141: invokevirtual 443	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
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
    //   1291: ldc2_w 458
    //   1294: dcmpg
    //   1295: ifge +56 -> 1351
    //   1298: ldc_w 460
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
    if (ljo.b(BaseApplicationImpl.getContext())) {}
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
        QQToast.a(localBaseApplication, 2131717955, 0).a();
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
      QQToast.a(localBaseApplication, 2131690618, 0).a();
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
    //   9: new 371	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 374	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 380	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 384	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 388	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 394	bfuc:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 523	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 519	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 523	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 523	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 457	java/io/IOException:printStackTrace	()V
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
          localStringBuilder.append(bfuc.encodeToString(arrayOfByte2, 2));
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
      localStringBuilder.append(bfuc.encodeToString(arrayOfByte1, 2));
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
    if ((this.jdField_a_of_type_Bjnw != null) && (this.jdField_a_of_type_Bjnw.isShowing())) {
      return;
    }
    bjnw localbjnw = bjnw.a(this.mRuntime.a());
    localbjnw.a(2131718129, 1);
    localbjnw.a(2131718119, 1);
    localbjnw.c(2131690620);
    localbjnw.a(new bkyb(this, paramInt, localbjnw));
    localbjnw.show();
    this.jdField_a_of_type_Bjnw = localbjnw;
  }
  
  private void f(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131690618, 0).a();
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
        ((AppActivity)localActivity).requestPermissions(new bkyc(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
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
  
  public bkyh a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, bkyg parambkyg, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    bkyh localbkyh = new bkyh(paramTroopHWJsPlugin);
    localbkyh.jdField_a_of_type_Int = paramInt1;
    localbkyh.jdField_a_of_type_Bkyg = parambkyg;
    localbkyh.jdField_a_of_type_Bkxx = new bkxx(paramTroopHWJsPlugin.mRuntime.a(), paramString, parambkyg.jdField_b_of_type_JavaLangString);
    localbkyh.jdField_a_of_type_Bkxx.a(localbkyh.jdField_a_of_type_Bkxw);
    localbkyh.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    localbkyh.jdField_b_of_type_JavaLangString = paramString;
    localbkyh.jdField_b_of_type_Int = paramInt2;
    return localbkyh;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = MD5Utils.toMD5(paramString2) + beyy.a(paramString2);
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
  
  public void a(int paramInt)
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
        ((AppActivity)localActivity).requestPermissions(new bkyd(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
  
  public void b(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    WebViewFragment localWebViewFragment = this.mRuntime.a();
    if (((localActivity instanceof AbsBaseWebViewActivity)) || (localWebViewFragment != null))
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
        ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)3);
      }
      while (localWebViewFragment == null) {
        return;
      }
      localWebViewFragment.gotoSelectPicture(this, localIntent, (byte)3);
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
        ((AppActivity)localActivity).requestPermissions(new bkyf(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
  
  public void d(int paramInt)
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
      localWebViewFragment.gotoSelectPicture(this, localIntent, (byte)5);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934597L) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bkyl.a();
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
    //   4: ldc 98
    //   6: aload_3
    //   7: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +8 -> 18
    //   13: aload 4
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 229	org/json/JSONObject
    //   23: dup
    //   24: aload 5
    //   26: iconst_0
    //   27: aaload
    //   28: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: ldc_w 861
    //   35: aload 4
    //   37: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +94 -> 134
    //   43: aload_1
    //   44: ifnull +46 -> 90
    //   47: aload_1
    //   48: ldc_w 862
    //   51: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_1
    //   58: anewarray 250	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 465
    //   66: aastore
    //   67: invokevirtual 255	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   74: invokevirtual 562	bgve:a	()Landroid/app/Activity;
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
    //   95: new 131	android/content/Intent
    //   98: dup
    //   99: invokespecial 506	android/content/Intent:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc_w 867
    //   107: aload 5
    //   109: iconst_0
    //   110: aaload
    //   111: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   114: pop
    //   115: aload_1
    //   116: iconst_m1
    //   117: aload_2
    //   118: invokevirtual 871	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   121: aload_1
    //   122: invokevirtual 874	android/app/Activity:isFinishing	()Z
    //   125: ifne +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 877	android/app/Activity:finish	()V
    //   132: iconst_1
    //   133: ireturn
    //   134: aload_1
    //   135: ifnull +102 -> 237
    //   138: aload_1
    //   139: ldc_w 879
    //   142: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 15
    //   147: aload_1
    //   148: ldc_w 658
    //   151: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 16
    //   156: aload_0
    //   157: aload 15
    //   159: putfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   162: aload_0
    //   163: aload 16
    //   165: putfield 196	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   168: aload_0
    //   169: aload_3
    //   170: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   173: aload_0
    //   174: aload_1
    //   175: ldc_w 881
    //   178: ldc_w 465
    //   181: invokevirtual 883	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   184: putfield 885	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload_0
    //   188: aload_1
    //   189: ldc_w 887
    //   192: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   195: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   198: aload_0
    //   199: aload_1
    //   200: ldc_w 892
    //   203: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   237: ldc_w 894
    //   240: aload 4
    //   242: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifeq +73 -> 318
    //   248: aload_0
    //   249: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   252: invokevirtual 562	bgve:a	()Landroid/app/Activity;
    //   255: astore_1
    //   256: new 131	android/content/Intent
    //   259: dup
    //   260: invokespecial 506	android/content/Intent:<init>	()V
    //   263: astore_2
    //   264: aload_2
    //   265: new 896	android/content/ComponentName
    //   268: dup
    //   269: aload_1
    //   270: ldc_w 898
    //   273: invokespecial 899	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   276: invokevirtual 903	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 658
    //   284: aload_0
    //   285: getfield 196	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   288: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   291: pop
    //   292: aload_0
    //   293: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   296: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifeq +10 -> 309
    //   302: aload_1
    //   303: aload_2
    //   304: invokevirtual 907	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   307: iconst_1
    //   308: ireturn
    //   309: aload_0
    //   310: aload_2
    //   311: iconst_1
    //   312: invokevirtual 910	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   315: goto -8 -> 307
    //   318: ldc_w 912
    //   321: aload 4
    //   323: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifeq +110 -> 436
    //   329: iconst_m1
    //   330: istore 6
    //   332: aload_1
    //   333: ifnull +12 -> 345
    //   336: aload_1
    //   337: ldc_w 656
    //   340: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   343: istore 6
    //   345: aload_0
    //   346: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   349: iconst_m1
    //   350: if_icmpne +36 -> 386
    //   353: aload_0
    //   354: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   357: iload 6
    //   359: aload_0
    //   360: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   363: iload 6
    //   365: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: invokevirtual 916	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 250	java/lang/String
    //   374: invokevirtual 918	bkyl:a	(ILjava/lang/String;)V
    //   377: aload_0
    //   378: iload 6
    //   380: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   383: goto -76 -> 307
    //   386: iload 6
    //   388: aload_0
    //   389: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   392: if_icmpeq -85 -> 307
    //   395: aload_0
    //   396: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   399: invokevirtual 846	bkyl:a	()Z
    //   402: pop
    //   403: aload_0
    //   404: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   407: iload 6
    //   409: aload_0
    //   410: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   413: iload 6
    //   415: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: invokevirtual 916	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   421: checkcast 250	java/lang/String
    //   424: invokevirtual 918	bkyl:a	(ILjava/lang/String;)V
    //   427: aload_0
    //   428: iload 6
    //   430: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   433: goto -126 -> 307
    //   436: ldc_w 920
    //   439: aload 4
    //   441: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   444: ifeq +49 -> 493
    //   447: aload_1
    //   448: ifnull +2472 -> 2920
    //   451: aload_1
    //   452: ldc_w 656
    //   455: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   478: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   481: invokevirtual 846	bkyl:a	()Z
    //   484: pop
    //   485: aload_0
    //   486: iconst_m1
    //   487: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   490: goto -183 -> 307
    //   493: ldc_w 922
    //   496: aload 4
    //   498: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   501: ifeq +204 -> 705
    //   504: bipush 10
    //   506: istore 7
    //   508: iconst_0
    //   509: istore 6
    //   511: aload_1
    //   512: ifnull +34 -> 546
    //   515: aload_1
    //   516: ldc_w 924
    //   519: bipush 10
    //   521: invokevirtual 927	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   524: istore 7
    //   526: aload_0
    //   527: aload_1
    //   528: ldc_w 887
    //   531: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   534: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   537: aload_1
    //   538: ldc_w 929
    //   541: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   544: istore 6
    //   546: iload 6
    //   548: iconst_1
    //   549: if_icmpne +13 -> 562
    //   552: aload_0
    //   553: sipush 29954
    //   556: invokespecial 545	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	(I)V
    //   559: goto -252 -> 307
    //   562: iload 6
    //   564: iconst_2
    //   565: if_icmpne +12 -> 577
    //   568: aload_0
    //   569: iload 7
    //   571: invokevirtual 931	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   574: goto -267 -> 307
    //   577: iload 6
    //   579: iconst_3
    //   580: if_icmpne +116 -> 696
    //   583: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq +30 -> 616
    //   589: ldc_w 266
    //   592: iconst_2
    //   593: new 34	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 933
    //   603: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_1
    //   607: invokevirtual 936	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload_0
    //   617: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   620: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   623: ifne +13 -> 636
    //   626: aload_0
    //   627: getfield 885	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   630: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   633: ifeq +54 -> 687
    //   636: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +46 -> 685
    //   642: ldc_w 266
    //   645: iconst_2
    //   646: new 34	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 940
    //   656: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_0
    //   660: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   663: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: ldc_w 942
    //   669: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload_0
    //   673: getfield 885	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   676: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 275	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: iconst_1
    //   686: ireturn
    //   687: aload_0
    //   688: iload 7
    //   690: invokevirtual 943	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   693: goto -386 -> 307
    //   696: aload_0
    //   697: iload 7
    //   699: invokespecial 945	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(I)V
    //   702: goto -395 -> 307
    //   705: ldc_w 947
    //   708: aload 4
    //   710: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   713: ifeq +187 -> 900
    //   716: lconst_0
    //   717: lstore 8
    //   719: bipush 102
    //   721: istore 6
    //   723: aconst_null
    //   724: astore 5
    //   726: aconst_null
    //   727: astore 4
    //   729: aload_1
    //   730: ifnull +2181 -> 2911
    //   733: aload_1
    //   734: ldc_w 949
    //   737: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   740: astore 5
    //   742: aload_1
    //   743: ldc_w 951
    //   746: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   749: astore 4
    //   751: aload_1
    //   752: ldc_w 881
    //   755: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   758: astore 15
    //   760: aload_1
    //   761: ldc_w 953
    //   764: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   767: astore_3
    //   768: aload_1
    //   769: ldc_w 955
    //   772: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   775: astore_2
    //   776: aload 15
    //   778: astore_1
    //   779: aload_3
    //   780: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   783: ifne +12 -> 795
    //   786: aload_3
    //   787: invokestatic 960	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   790: invokevirtual 963	java/lang/Long:longValue	()J
    //   793: lstore 8
    //   795: aload_2
    //   796: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   799: ifne +12 -> 811
    //   802: aload_2
    //   803: invokestatic 966	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   806: invokevirtual 969	java/lang/Integer:intValue	()I
    //   809: istore 6
    //   811: aload_1
    //   812: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   815: ifne +66 -> 881
    //   818: aload_0
    //   819: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Zon	Lzon;
    //   822: aload_1
    //   823: invokestatic 960	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   826: invokevirtual 963	java/lang/Long:longValue	()J
    //   829: aload 4
    //   831: aload 5
    //   833: lload 8
    //   835: iload 6
    //   837: aload_0
    //   838: invokevirtual 974	zon:a	(JLjava/lang/String;Ljava/lang/String;JILzop;)V
    //   841: goto -534 -> 307
    //   844: astore_2
    //   845: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   848: ifeq -541 -> 307
    //   851: ldc_w 266
    //   854: iconst_2
    //   855: new 34	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 976
    //   865: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_1
    //   869: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 978	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: goto -571 -> 307
    //   881: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   884: ifeq -577 -> 307
    //   887: ldc_w 266
    //   890: iconst_2
    //   891: ldc_w 980
    //   894: invokestatic 978	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: goto -590 -> 307
    //   900: ldc_w 982
    //   903: aload 4
    //   905: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   908: ifeq +73 -> 981
    //   911: aload_1
    //   912: ifnull +1992 -> 2904
    //   915: aload_1
    //   916: ldc_w 664
    //   919: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   922: astore_1
    //   923: aload_0
    //   924: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   927: ifnonnull +19 -> 946
    //   930: aload_0
    //   931: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   934: aload_1
    //   935: invokevirtual 984	bkyl:b	(Ljava/lang/String;)V
    //   938: aload_0
    //   939: aload_1
    //   940: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   943: goto -636 -> 307
    //   946: aload_0
    //   947: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   950: aload_1
    //   951: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   954: ifne -647 -> 307
    //   957: aload_0
    //   958: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   961: invokevirtual 846	bkyl:a	()Z
    //   964: pop
    //   965: aload_0
    //   966: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   969: aload_1
    //   970: invokevirtual 984	bkyl:b	(Ljava/lang/String;)V
    //   973: aload_0
    //   974: aload_1
    //   975: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   978: goto -671 -> 307
    //   981: ldc_w 986
    //   984: aload 4
    //   986: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   989: ifeq +49 -> 1038
    //   992: aload_1
    //   993: ifnull +1904 -> 2897
    //   996: aload_1
    //   997: ldc_w 664
    //   1000: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1003: astore_1
    //   1004: aload_0
    //   1005: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1008: ifnull -701 -> 307
    //   1011: aload_0
    //   1012: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1015: aload_1
    //   1016: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1019: ifeq -712 -> 307
    //   1022: aload_0
    //   1023: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   1026: invokevirtual 846	bkyl:a	()Z
    //   1029: pop
    //   1030: aload_0
    //   1031: aconst_null
    //   1032: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1035: goto -728 -> 307
    //   1038: ldc_w 988
    //   1041: aload 4
    //   1043: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1046: ifeq +23 -> 1069
    //   1049: aload_0
    //   1050: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   1053: aload_0
    //   1054: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   1057: invokevirtual 617	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   1060: invokevirtual 991	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1063: invokevirtual 993	bkyl:e	(Ljava/lang/String;)V
    //   1066: goto -759 -> 307
    //   1069: ldc_w 995
    //   1072: aload 4
    //   1074: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1077: ifeq +39 -> 1116
    //   1080: aload_1
    //   1081: ifnull +25 -> 1106
    //   1084: aload_0
    //   1085: aload_1
    //   1086: ldc_w 997
    //   1089: invokevirtual 1001	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1092: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1095: aload_0
    //   1096: aload_1
    //   1097: ldc_w 1003
    //   1100: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1103: putfield 82	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1106: aload_0
    //   1107: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkyl	Lbkyl;
    //   1110: invokevirtual 1005	bkyl:b	()V
    //   1113: goto -806 -> 307
    //   1116: ldc_w 1007
    //   1119: aload 4
    //   1121: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1124: ifeq +25 -> 1149
    //   1127: new 1009	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1130: dup
    //   1131: aload_0
    //   1132: aload_2
    //   1133: invokestatic 1014	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   1136: invokespecial 1015	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1139: bipush 8
    //   1141: aconst_null
    //   1142: iconst_0
    //   1143: invokestatic 733	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1146: goto -839 -> 307
    //   1149: ldc_w 1017
    //   1152: aload 4
    //   1154: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1157: ifeq +54 -> 1211
    //   1160: aload_1
    //   1161: ifnull -854 -> 307
    //   1164: aload_1
    //   1165: ldc_w 664
    //   1168: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1171: astore_2
    //   1172: aload_1
    //   1173: ldc_w 1019
    //   1176: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1179: astore_3
    //   1180: aload_0
    //   1181: aload_1
    //   1182: ldc_w 879
    //   1185: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1188: putfield 742	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1191: aload_0
    //   1192: aload_3
    //   1193: aload_2
    //   1194: invokevirtual 745	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1197: astore_1
    //   1198: aload_0
    //   1199: getfield 1021	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkxy	Lbkxy;
    //   1202: aload_2
    //   1203: aload_1
    //   1204: aload_0
    //   1205: invokevirtual 1026	bkxy:a	(Ljava/lang/String;Ljava/lang/String;Lbkya;)V
    //   1208: goto -901 -> 307
    //   1211: ldc_w 1028
    //   1214: aload 4
    //   1216: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1219: ifeq +26 -> 1245
    //   1222: aload_1
    //   1223: ifnull -916 -> 307
    //   1226: aload_1
    //   1227: ldc_w 664
    //   1230: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1233: astore_1
    //   1234: aload_0
    //   1235: getfield 1021	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkxy	Lbkxy;
    //   1238: aload_1
    //   1239: invokevirtual 1029	bkxy:a	(Ljava/lang/String;)V
    //   1242: goto -935 -> 307
    //   1245: ldc_w 1031
    //   1248: aload 4
    //   1250: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1253: ifeq +194 -> 1447
    //   1256: aload_1
    //   1257: ifnull -950 -> 307
    //   1260: aload_1
    //   1261: ldc_w 1019
    //   1264: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1267: astore 4
    //   1269: aload_1
    //   1270: ldc_w 1033
    //   1273: invokevirtual 1037	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1276: astore 5
    //   1278: aload_1
    //   1279: ldc_w 879
    //   1282: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1285: astore_2
    //   1286: new 229	org/json/JSONObject
    //   1289: dup
    //   1290: invokespecial 654	org/json/JSONObject:<init>	()V
    //   1293: astore_3
    //   1294: new 1039	org/json/JSONArray
    //   1297: dup
    //   1298: invokespecial 1040	org/json/JSONArray:<init>	()V
    //   1301: astore 15
    //   1303: aload 5
    //   1305: invokevirtual 1042	org/json/JSONArray:length	()I
    //   1308: istore 7
    //   1310: iconst_0
    //   1311: istore 6
    //   1313: iload 6
    //   1315: iload 7
    //   1317: if_icmpge +33 -> 1350
    //   1320: aload 15
    //   1322: iload 6
    //   1324: aload_0
    //   1325: aload 4
    //   1327: aload 5
    //   1329: iload 6
    //   1331: invokevirtual 1045	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1334: invokevirtual 1047	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1337: invokevirtual 1050	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1340: pop
    //   1341: iload 6
    //   1343: iconst_1
    //   1344: iadd
    //   1345: istore 6
    //   1347: goto -34 -> 1313
    //   1350: aload_3
    //   1351: ldc_w 1052
    //   1354: aload 15
    //   1356: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1359: pop
    //   1360: aload_3
    //   1361: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1364: astore_3
    //   1365: aload_0
    //   1366: aload_2
    //   1367: iconst_1
    //   1368: anewarray 250	java/lang/String
    //   1371: dup
    //   1372: iconst_0
    //   1373: aload_3
    //   1374: aastore
    //   1375: invokevirtual 255	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1378: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1381: ifeq -1074 -> 307
    //   1384: ldc_w 266
    //   1387: iconst_2
    //   1388: new 34	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1395: ldc_w 1054
    //   1398: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: aload_1
    //   1402: invokevirtual 936	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1405: ldc_w 1056
    //   1408: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: aload_3
    //   1412: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1421: goto -1114 -> 307
    //   1424: astore 4
    //   1426: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1429: ifeq -69 -> 1360
    //   1432: ldc_w 266
    //   1435: iconst_2
    //   1436: ldc_w 1054
    //   1439: aload 4
    //   1441: invokestatic 1059	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1444: goto -84 -> 1360
    //   1447: ldc_w 1061
    //   1450: aload 4
    //   1452: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1455: ifeq +68 -> 1523
    //   1458: aload_1
    //   1459: ifnull -1152 -> 307
    //   1462: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1465: ifeq +30 -> 1495
    //   1468: ldc_w 266
    //   1471: iconst_2
    //   1472: new 34	java/lang/StringBuilder
    //   1475: dup
    //   1476: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1479: ldc_w 1063
    //   1482: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: aload_1
    //   1486: invokevirtual 936	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1495: aload_1
    //   1496: ldc_w 1065
    //   1499: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1502: astore_2
    //   1503: aload_1
    //   1504: ldc_w 1067
    //   1507: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1510: astore_1
    //   1511: aload_0
    //   1512: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Zon	Lzon;
    //   1515: aload_2
    //   1516: aload_1
    //   1517: invokevirtual 1070	zon:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1520: goto -1213 -> 307
    //   1523: ldc_w 1072
    //   1526: aload 4
    //   1528: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1531: ifeq +58 -> 1589
    //   1534: aload_1
    //   1535: ifnull +54 -> 1589
    //   1538: aload_1
    //   1539: ldc_w 666
    //   1542: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1545: pop
    //   1546: aload_1
    //   1547: ldc_w 656
    //   1550: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1553: istore 6
    //   1555: aload_0
    //   1556: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1559: iload 6
    //   1561: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1564: invokevirtual 916	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1567: checkcast 607	bkyh
    //   1570: astore_1
    //   1571: aload_1
    //   1572: ifnull -1265 -> 307
    //   1575: aload_1
    //   1576: getfield 1073	bkyh:jdField_a_of_type_Boolean	Z
    //   1579: ifne -1272 -> 307
    //   1582: aload_1
    //   1583: invokevirtual 1074	bkyh:b	()V
    //   1586: goto -1279 -> 307
    //   1589: ldc_w 1076
    //   1592: aload 4
    //   1594: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1597: ifeq +62 -> 1659
    //   1600: aload_1
    //   1601: ifnull +58 -> 1659
    //   1604: aload_1
    //   1605: ldc_w 666
    //   1608: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1611: pop
    //   1612: aload_1
    //   1613: ldc_w 656
    //   1616: invokevirtual 890	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1619: istore 6
    //   1621: aload_0
    //   1622: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1625: iload 6
    //   1627: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1630: invokevirtual 916	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1633: checkcast 607	bkyh
    //   1636: astore_1
    //   1637: aload_1
    //   1638: ifnull -1331 -> 307
    //   1641: aload_1
    //   1642: getfield 1073	bkyh:jdField_a_of_type_Boolean	Z
    //   1645: ifeq -1338 -> 307
    //   1648: aload_1
    //   1649: getfield 1079	bkyh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1652: iconst_1
    //   1653: invokevirtual 1085	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1656: goto -1349 -> 307
    //   1659: ldc_w 1087
    //   1662: aload 4
    //   1664: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1667: ifeq +83 -> 1750
    //   1670: aload_1
    //   1671: ifnull -1364 -> 307
    //   1674: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1677: ifeq +24 -> 1701
    //   1680: ldc_w 266
    //   1683: iconst_2
    //   1684: iconst_2
    //   1685: anewarray 146	java/lang/Object
    //   1688: dup
    //   1689: iconst_0
    //   1690: ldc_w 1089
    //   1693: aastore
    //   1694: dup
    //   1695: iconst_1
    //   1696: aload_1
    //   1697: aastore
    //   1698: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1701: aload_1
    //   1702: ldc_w 1019
    //   1705: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1708: astore_2
    //   1709: aload_1
    //   1710: ldc_w 666
    //   1713: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1716: astore_1
    //   1717: aload_0
    //   1718: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Zon	Lzon;
    //   1721: aload_2
    //   1722: aload_1
    //   1723: invokevirtual 1091	zon:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1726: goto -1419 -> 307
    //   1729: astore_1
    //   1730: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1733: ifeq -1426 -> 307
    //   1736: ldc_w 266
    //   1739: iconst_2
    //   1740: ldc_w 1093
    //   1743: aload_1
    //   1744: invokestatic 1059	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1747: goto -1440 -> 307
    //   1750: ldc_w 1095
    //   1753: aload 4
    //   1755: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1758: ifeq +167 -> 1925
    //   1761: aload_1
    //   1762: ifnull -1455 -> 307
    //   1765: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1768: ifeq +30 -> 1798
    //   1771: ldc_w 266
    //   1774: iconst_2
    //   1775: new 34	java/lang/StringBuilder
    //   1778: dup
    //   1779: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1782: ldc_w 1097
    //   1785: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: aload_1
    //   1789: invokevirtual 936	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1792: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1795: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1798: aload_1
    //   1799: ldc_w 656
    //   1802: iconst_0
    //   1803: invokevirtual 927	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1806: istore 6
    //   1808: aload_0
    //   1809: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1812: iload 6
    //   1814: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1817: invokevirtual 916	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1820: checkcast 607	bkyh
    //   1823: astore_2
    //   1824: aload_2
    //   1825: ifnull +70 -> 1895
    //   1828: aload_2
    //   1829: getfield 636	bkyh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1832: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1835: ifne +60 -> 1895
    //   1838: new 781	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1841: dup
    //   1842: invokespecial 782	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1845: astore_1
    //   1846: aload_1
    //   1847: aload_2
    //   1848: getfield 636	bkyh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1851: invokevirtual 800	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1854: new 131	android/content/Intent
    //   1857: dup
    //   1858: aload_0
    //   1859: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   1862: invokevirtual 562	bgve:a	()Landroid/app/Activity;
    //   1865: ldc_w 814
    //   1868: invokespecial 136	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1871: astore_2
    //   1872: aload_2
    //   1873: ldc_w 820
    //   1876: aload_1
    //   1877: invokevirtual 823	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1880: pop
    //   1881: aload_0
    //   1882: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   1885: invokevirtual 562	bgve:a	()Landroid/app/Activity;
    //   1888: aload_2
    //   1889: invokevirtual 907	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1892: goto -1585 -> 307
    //   1895: ldc_w 266
    //   1898: iconst_1
    //   1899: new 34	java/lang/StringBuilder
    //   1902: dup
    //   1903: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1906: ldc_w 1099
    //   1909: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: aload_2
    //   1913: invokevirtual 936	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1916: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1919: invokestatic 978	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1922: goto -1615 -> 307
    //   1925: ldc_w 1101
    //   1928: aload 4
    //   1930: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1933: ifeq +18 -> 1951
    //   1936: aload_0
    //   1937: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1940: invokevirtual 1104	java/util/HashMap:clear	()V
    //   1943: aload_0
    //   1944: iconst_1
    //   1945: putfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   1948: goto -1641 -> 307
    //   1951: ldc_w 1106
    //   1954: aload 4
    //   1956: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1959: ifeq +77 -> 2036
    //   1962: aload_1
    //   1963: ifnull -1656 -> 307
    //   1966: aload_1
    //   1967: ldc_w 656
    //   1970: iconst_0
    //   1971: invokevirtual 927	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1974: istore 6
    //   1976: aload_0
    //   1977: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1980: iload 6
    //   1982: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1985: invokevirtual 916	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1988: checkcast 607	bkyh
    //   1991: astore_1
    //   1992: aload_1
    //   1993: ifnull -1686 -> 307
    //   1996: aload_1
    //   1997: getfield 636	bkyh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2000: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2003: ifne -1696 -> 307
    //   2006: new 290	java/io/File
    //   2009: dup
    //   2010: aload_1
    //   2011: getfield 636	bkyh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2014: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   2017: astore_2
    //   2018: aload_0
    //   2019: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Zon	Lzon;
    //   2022: aload_1
    //   2023: getfield 636	bkyh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2026: aload_2
    //   2027: invokevirtual 1107	java/io/File:getName	()Ljava/lang/String;
    //   2030: invokevirtual 1070	zon:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2033: goto -1726 -> 307
    //   2036: ldc_w 1109
    //   2039: aload 4
    //   2041: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2044: ifeq +94 -> 2138
    //   2047: aload_1
    //   2048: ifnull +78 -> 2126
    //   2051: ldc_w 266
    //   2054: ldc_w 1111
    //   2057: aload_1
    //   2058: invokestatic 1116	xvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   2061: aload_1
    //   2062: ldc_w 1118
    //   2065: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2068: astore_2
    //   2069: aload_1
    //   2070: ldc_w 1120
    //   2073: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2076: astore_3
    //   2077: aload_1
    //   2078: ldc_w 1122
    //   2081: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2084: astore 4
    //   2086: aload_1
    //   2087: ldc_w 1124
    //   2090: invokevirtual 865	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2093: astore_1
    //   2094: aload_0
    //   2095: aload_0
    //   2096: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   2099: invokevirtual 562	bgve:a	()Landroid/app/Activity;
    //   2102: aload_2
    //   2103: aload_3
    //   2104: aload_0
    //   2105: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2108: aload 4
    //   2110: aload_0
    //   2111: getfield 885	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2114: aload_1
    //   2115: invokestatic 1129	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2118: bipush 6
    //   2120: invokevirtual 910	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2123: goto -1816 -> 307
    //   2126: ldc_w 266
    //   2129: ldc_w 1131
    //   2132: invokestatic 1132	xvv:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2135: goto -1828 -> 307
    //   2138: ldc_w 1134
    //   2141: aload 4
    //   2143: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2146: ifeq +186 -> 2332
    //   2149: new 229	org/json/JSONObject
    //   2152: dup
    //   2153: aload 5
    //   2155: iconst_0
    //   2156: aaload
    //   2157: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2160: ldc_w 1136
    //   2163: invokevirtual 1137	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2166: astore_2
    //   2167: aload_2
    //   2168: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2171: istore 14
    //   2173: iload 14
    //   2175: ifne -1868 -> 307
    //   2178: lconst_0
    //   2179: lstore 8
    //   2181: aload_2
    //   2182: invokestatic 1140	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2185: lstore 10
    //   2187: lload 10
    //   2189: lstore 8
    //   2191: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2194: ifeq +31 -> 2225
    //   2197: ldc_w 266
    //   2200: iconst_2
    //   2201: new 34	java/lang/StringBuilder
    //   2204: dup
    //   2205: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2208: ldc_w 1142
    //   2211: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2214: lload 8
    //   2216: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2219: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2222: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2225: lload 8
    //   2227: lconst_0
    //   2228: lcmp
    //   2229: ifle +67 -> 2296
    //   2232: aload_0
    //   2233: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   2236: ifnull +55 -> 2291
    //   2239: aload_0
    //   2240: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   2243: invokevirtual 562	bgve:a	()Landroid/app/Activity;
    //   2246: astore_1
    //   2247: aload_1
    //   2248: aconst_null
    //   2249: aload_2
    //   2250: invokestatic 1147	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2253: aload_1
    //   2254: ifnull -1947 -> 307
    //   2257: aload_1
    //   2258: ldc_w 1148
    //   2261: ldc_w 1149
    //   2264: invokevirtual 1152	android/app/Activity:overridePendingTransition	(II)V
    //   2267: goto -1960 -> 307
    //   2270: astore_1
    //   2271: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2274: ifeq -1967 -> 307
    //   2277: ldc_w 266
    //   2280: iconst_2
    //   2281: ldc_w 1154
    //   2284: aload_1
    //   2285: invokestatic 1059	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2288: goto -1981 -> 307
    //   2291: aconst_null
    //   2292: astore_1
    //   2293: goto -46 -> 2247
    //   2296: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2299: ifeq -1992 -> 307
    //   2302: ldc_w 266
    //   2305: iconst_2
    //   2306: new 34	java/lang/StringBuilder
    //   2309: dup
    //   2310: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2313: ldc_w 1156
    //   2316: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: aload_2
    //   2320: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2326: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2329: goto -2022 -> 307
    //   2332: ldc_w 1158
    //   2335: aload 4
    //   2337: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2340: ifeq +245 -> 2585
    //   2343: new 229	org/json/JSONObject
    //   2346: dup
    //   2347: aload 5
    //   2349: iconst_0
    //   2350: aaload
    //   2351: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2354: astore_1
    //   2355: aload_1
    //   2356: ldc_w 1160
    //   2359: invokevirtual 1137	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2362: astore_2
    //   2363: aload_2
    //   2364: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2367: istore 14
    //   2369: iload 14
    //   2371: ifne -2064 -> 307
    //   2374: aload_2
    //   2375: invokestatic 1140	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2378: lstore 10
    //   2380: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2383: ifeq +31 -> 2414
    //   2386: ldc_w 266
    //   2389: iconst_2
    //   2390: new 34	java/lang/StringBuilder
    //   2393: dup
    //   2394: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2397: ldc_w 1162
    //   2400: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2403: lload 10
    //   2405: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2408: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2411: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2414: aload_1
    //   2415: ldc_w 1136
    //   2418: invokevirtual 1137	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2421: astore_1
    //   2422: lconst_0
    //   2423: lstore 8
    //   2425: aload_1
    //   2426: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2429: istore 14
    //   2431: lload 8
    //   2433: lstore 12
    //   2435: iload 14
    //   2437: ifne +55 -> 2492
    //   2440: aload_1
    //   2441: invokestatic 1140	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2444: lstore 12
    //   2446: lload 12
    //   2448: lstore 8
    //   2450: lload 8
    //   2452: lstore 12
    //   2454: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2457: ifeq +35 -> 2492
    //   2460: ldc_w 266
    //   2463: iconst_2
    //   2464: new 34	java/lang/StringBuilder
    //   2467: dup
    //   2468: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2471: ldc_w 1142
    //   2474: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: lload 8
    //   2479: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2482: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2485: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2488: lload 8
    //   2490: lstore 12
    //   2492: lload 10
    //   2494: lconst_0
    //   2495: lcmp
    //   2496: ifle -2189 -> 307
    //   2499: lload 12
    //   2501: lconst_0
    //   2502: lcmp
    //   2503: ifle -2196 -> 307
    //   2506: aload_0
    //   2507: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   2510: ifnull +70 -> 2580
    //   2513: aload_0
    //   2514: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   2517: invokevirtual 562	bgve:a	()Landroid/app/Activity;
    //   2520: astore_1
    //   2521: aload_0
    //   2522: aload_1
    //   2523: lload 12
    //   2525: lload 10
    //   2527: invokestatic 1167	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2530: bipush 7
    //   2532: invokevirtual 910	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2535: aload_1
    //   2536: ifnull -2229 -> 307
    //   2539: aload_1
    //   2540: ldc_w 1148
    //   2543: ldc_w 1149
    //   2546: invokevirtual 1152	android/app/Activity:overridePendingTransition	(II)V
    //   2549: goto -2242 -> 307
    //   2552: astore_1
    //   2553: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2556: ifeq -2249 -> 307
    //   2559: ldc_w 266
    //   2562: iconst_2
    //   2563: ldc_w 1154
    //   2566: aload_1
    //   2567: invokestatic 1059	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2570: goto -2263 -> 307
    //   2573: astore_2
    //   2574: lconst_0
    //   2575: lstore 10
    //   2577: goto -197 -> 2380
    //   2580: aconst_null
    //   2581: astore_1
    //   2582: goto -61 -> 2521
    //   2585: ldc_w 1169
    //   2588: aload 4
    //   2590: invokevirtual 707	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2593: ifeq -2286 -> 307
    //   2596: new 229	org/json/JSONObject
    //   2599: dup
    //   2600: aload 5
    //   2602: iconst_0
    //   2603: aaload
    //   2604: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2607: astore_2
    //   2608: aload_2
    //   2609: ldc_w 1160
    //   2612: invokevirtual 1137	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2615: astore_1
    //   2616: aload_2
    //   2617: ldc_w 1136
    //   2620: invokevirtual 1137	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2623: astore_2
    //   2624: aload_1
    //   2625: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2628: ifne +211 -> 2839
    //   2631: aload_2
    //   2632: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2635: istore 14
    //   2637: iload 14
    //   2639: ifne +200 -> 2839
    //   2642: aload_1
    //   2643: invokestatic 1140	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2646: lstore 8
    //   2648: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2651: ifeq +31 -> 2682
    //   2654: ldc_w 266
    //   2657: iconst_2
    //   2658: new 34	java/lang/StringBuilder
    //   2661: dup
    //   2662: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2665: ldc_w 1171
    //   2668: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2671: lload 8
    //   2673: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2676: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2679: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2682: lconst_0
    //   2683: lstore 10
    //   2685: aload_2
    //   2686: invokestatic 1140	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2689: lstore 12
    //   2691: lload 12
    //   2693: lstore 10
    //   2695: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2698: ifeq +31 -> 2729
    //   2701: ldc_w 266
    //   2704: iconst_2
    //   2705: new 34	java/lang/StringBuilder
    //   2708: dup
    //   2709: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2712: ldc_w 1173
    //   2715: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2718: lload 10
    //   2720: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2723: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2726: invokestatic 938	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2729: lload 8
    //   2731: lconst_0
    //   2732: lcmp
    //   2733: ifle -2426 -> 307
    //   2736: lload 10
    //   2738: lconst_0
    //   2739: lcmp
    //   2740: ifle -2433 -> 307
    //   2743: aload_0
    //   2744: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   2747: ifnull +87 -> 2834
    //   2750: aload_0
    //   2751: getfield 557	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbgve;
    //   2754: invokevirtual 562	bgve:a	()Landroid/app/Activity;
    //   2757: astore_1
    //   2758: new 776	android/os/Bundle
    //   2761: dup
    //   2762: invokespecial 1174	android/os/Bundle:<init>	()V
    //   2765: astore_3
    //   2766: aload_3
    //   2767: ldc_w 1160
    //   2770: lload 8
    //   2772: invokevirtual 1178	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2775: aload_3
    //   2776: ldc_w 1180
    //   2779: iconst_2
    //   2780: invokevirtual 1184	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2783: aload_1
    //   2784: aload_3
    //   2785: aload_2
    //   2786: invokestatic 1147	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2789: aload_1
    //   2790: ifnull -2483 -> 307
    //   2793: aload_1
    //   2794: ldc_w 1148
    //   2797: ldc_w 1149
    //   2800: invokevirtual 1152	android/app/Activity:overridePendingTransition	(II)V
    //   2803: goto -2496 -> 307
    //   2806: astore_1
    //   2807: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2810: ifeq -2503 -> 307
    //   2813: ldc_w 266
    //   2816: iconst_2
    //   2817: ldc_w 1154
    //   2820: aload_1
    //   2821: invokestatic 1059	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2824: goto -2517 -> 307
    //   2827: astore_1
    //   2828: lconst_0
    //   2829: lstore 8
    //   2831: goto -183 -> 2648
    //   2834: aconst_null
    //   2835: astore_1
    //   2836: goto -78 -> 2758
    //   2839: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2842: ifeq -2535 -> 307
    //   2845: ldc_w 266
    //   2848: iconst_2
    //   2849: new 34	java/lang/StringBuilder
    //   2852: dup
    //   2853: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2856: ldc_w 1186
    //   2859: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2862: aload_1
    //   2863: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2866: ldc_w 1188
    //   2869: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2872: aload_2
    //   2873: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2879: invokestatic 978	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2882: goto -2575 -> 307
    //   2885: astore_1
    //   2886: goto -695 -> 2191
    //   2889: astore_1
    //   2890: goto -440 -> 2450
    //   2893: astore_1
    //   2894: goto -199 -> 2695
    //   2897: ldc_w 465
    //   2900: astore_1
    //   2901: goto -1897 -> 1004
    //   2904: ldc_w 465
    //   2907: astore_1
    //   2908: goto -1985 -> 923
    //   2911: aconst_null
    //   2912: astore_2
    //   2913: aconst_null
    //   2914: astore_1
    //   2915: aconst_null
    //   2916: astore_3
    //   2917: goto -2138 -> 779
    //   2920: iconst_m1
    //   2921: istore 6
    //   2923: goto -2463 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2926	0	this	TroopHWJsPlugin
    //   0	2926	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2926	2	paramString1	String
    //   0	2926	3	paramString2	String
    //   0	2926	4	paramString3	String
    //   0	2926	5	paramVarArgs	String[]
    //   330	2592	6	j	int
    //   506	812	7	k	int
    //   717	2113	8	l1	long
    //   2185	552	10	l2	long
    //   2433	259	12	l3	long
    //   2171	467	14	bool	boolean
    //   145	1210	15	localObject	Object
    //   154	10	16	str	String
    // Exception table:
    //   from	to	target	type
    //   20	32	84	org/json/JSONException
    //   811	841	844	java/lang/NumberFormatException
    //   881	897	844	java/lang/NumberFormatException
    //   1294	1310	1424	java/lang/Exception
    //   1320	1341	1424	java/lang/Exception
    //   1350	1360	1424	java/lang/Exception
    //   1701	1726	1729	java/lang/Exception
    //   2149	2173	2270	java/lang/Exception
    //   2191	2225	2270	java/lang/Exception
    //   2232	2247	2270	java/lang/Exception
    //   2247	2253	2270	java/lang/Exception
    //   2257	2267	2270	java/lang/Exception
    //   2296	2329	2270	java/lang/Exception
    //   2343	2369	2552	java/lang/Exception
    //   2380	2414	2552	java/lang/Exception
    //   2414	2422	2552	java/lang/Exception
    //   2425	2431	2552	java/lang/Exception
    //   2454	2488	2552	java/lang/Exception
    //   2506	2521	2552	java/lang/Exception
    //   2521	2535	2552	java/lang/Exception
    //   2539	2549	2552	java/lang/Exception
    //   2374	2380	2573	java/lang/Exception
    //   2596	2637	2806	java/lang/Exception
    //   2648	2682	2806	java/lang/Exception
    //   2695	2729	2806	java/lang/Exception
    //   2743	2758	2806	java/lang/Exception
    //   2758	2789	2806	java/lang/Exception
    //   2793	2803	2806	java/lang/Exception
    //   2839	2882	2806	java/lang/Exception
    //   2642	2648	2827	java/lang/Exception
    //   2181	2187	2885	java/lang/Exception
    //   2440	2446	2889	java/lang/Exception
    //   2685	2691	2893	java/lang/Exception
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
                localObject1 = new bkyg(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
                paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (bkyg)localObject1, 0);
                this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
                paramIntent.jdField_a_of_type_Bkxx.a();
                this.jdField_d_of_type_Int += 1;
                return;
              }
            } while (paramInt != -1);
            localHashMap1 = new HashMap();
            localHashMap2 = new HashMap();
            if ((paramByte == 2) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
            {
              bfvo.a(this.mRuntime.a(), this.jdField_c_of_type_JavaLangString);
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
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new bkyg(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
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
    this.jdField_a_of_type_Zon = zon.a();
    this.jdField_a_of_type_Zon.a();
    this.jdField_a_of_type_Bkyl = new bkyl(this.mRuntime.a(), this);
    this.jdField_a_of_type_Bkxy = new bkxy(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    int k = 0;
    if (this.jdField_a_of_type_Zon != null) {
      this.jdField_a_of_type_Zon.b();
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Bkxy != null) {
      this.jdField_a_of_type_Bkxy.a(this.mRuntime.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */