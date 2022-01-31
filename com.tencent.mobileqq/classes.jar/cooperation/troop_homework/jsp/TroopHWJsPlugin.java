package cooperation.troop_homework.jsp;

import alof;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bckt;
import bdfa;
import bdfr;
import bdhj;
import bdzf;
import begz;
import bflr;
import bhuf;
import bkdb;
import bkdc;
import bkde;
import bkdf;
import bkdg;
import bkdh;
import bkdi;
import bkdj;
import bkdk;
import bkdl;
import bkdp;
import bkdr;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
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
import lmm;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;
import yqz;
import yrb;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements bkde, bkdr, yrb
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new bkdi(this);
  bhuf jdField_a_of_type_Bhuf = null;
  private bkdc jdField_a_of_type_Bkdc;
  bkdp jdField_a_of_type_Bkdp = null;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  yqz jdField_a_of_type_Yqz = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 540;
  String jdField_b_of_type_JavaLangString;
  HashMap<Integer, bkdl> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    jdField_a_of_type_JavaLangString = alof.bt + "homeworkTmp/";
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
    //   496: invokestatic 394	bdfr:encodeToString	([BI)Ljava/lang/String;
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
    //   672: invokestatic 427	arso:a	(Ljava/lang/String;)Ljava/lang/String;
    //   675: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: astore_3
    //   682: new 429	com/tencent/mm/vfs/VFSFileOutputStream
    //   685: dup
    //   686: aload_3
    //   687: invokespecial 430	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Ljava/lang/String;)V
    //   690: astore_1
    //   691: aload_1
    //   692: aload 11
    //   694: invokevirtual 388	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   697: invokevirtual 434	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   700: aload_3
    //   701: iconst_0
    //   702: invokestatic 440	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   705: astore 12
    //   707: aload_1
    //   708: astore_3
    //   709: aload 12
    //   711: astore_1
    //   712: aload 11
    //   714: ifnull +8 -> 722
    //   717: aload 11
    //   719: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   722: aload_1
    //   723: astore 11
    //   725: aload_3
    //   726: ifnull +10 -> 736
    //   729: aload_3
    //   730: invokevirtual 442	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
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
    //   861: ldc_w 443
    //   864: invokevirtual 447	android/graphics/Matrix:postRotate	(F)Z
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
    //   938: ldc_w 448
    //   941: invokevirtual 447	android/graphics/Matrix:postRotate	(F)Z
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
    //   975: ldc_w 448
    //   978: invokevirtual 447	android/graphics/Matrix:postRotate	(F)Z
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
    //   1013: ldc_w 448
    //   1016: invokevirtual 447	android/graphics/Matrix:postRotate	(F)Z
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
    //   1050: ldc_w 449
    //   1053: invokevirtual 447	android/graphics/Matrix:postRotate	(F)Z
    //   1056: pop
    //   1057: goto -677 -> 380
    //   1060: iload 8
    //   1062: ifne +16 -> 1078
    //   1065: aload_3
    //   1066: ifnull +12 -> 1078
    //   1069: aload_3
    //   1070: getfield 96	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1073: iconst_1
    //   1074: invokevirtual 455	android/os/Handler:sendEmptyMessage	(I)Z
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
    //   1093: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   1096: aconst_null
    //   1097: astore 12
    //   1099: aload_3
    //   1100: ifnull +7 -> 1107
    //   1103: aload_3
    //   1104: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   1107: aload 12
    //   1109: astore 11
    //   1111: aload_1
    //   1112: ifnull -376 -> 736
    //   1115: aload_1
    //   1116: invokevirtual 442	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1119: aload 12
    //   1121: astore 11
    //   1123: goto -387 -> 736
    //   1126: aload 11
    //   1128: ifnull +8 -> 1136
    //   1131: aload 11
    //   1133: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   1136: aload_3
    //   1137: ifnull +7 -> 1144
    //   1140: aload_3
    //   1141: invokevirtual 442	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
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
    //   1291: ldc2_w 457
    //   1294: dcmpg
    //   1295: ifge +56 -> 1351
    //   1298: ldc_w 459
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
    if (lmm.b(BaseApplicationImpl.getContext())) {}
    BaseApplication localBaseApplication;
    String str;
    Intent localIntent;
    do
    {
      return localObject;
      localBaseApplication = BaseApplicationImpl.getContext();
      str = bdzf.a(alof.bd + System.currentTimeMillis() + ".jpg");
      localObject = new File(str).getParentFile();
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        QQToast.a(localBaseApplication, 2131719547, 0).a();
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
      QQToast.a(localBaseApplication, 2131690645, 0).a();
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
    //   39: invokestatic 394	bdfr:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 520	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 516	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 520	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 520	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 441	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 456	java/io/IOException:printStackTrace	()V
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
          localStringBuilder.append(bdfr.encodeToString(arrayOfByte2, 2));
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
      localStringBuilder.append(bdfr.encodeToString(arrayOfByte1, 2));
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
    localObject = new VFSFile(alof.bt);
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
    if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
      return;
    }
    bhuf localbhuf = bhuf.a(this.mRuntime.a());
    localbhuf.a(2131719771, 1);
    localbhuf.a(2131719760, 1);
    localbhuf.c(2131690648);
    localbhuf.a(new bkdf(this, paramInt, localbhuf));
    localbhuf.show();
    this.jdField_a_of_type_Bhuf = localbhuf;
  }
  
  private void f(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131690645, 0).a();
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
        ((AppActivity)localActivity).requestPermissions(new bkdg(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
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
  
  public bkdl a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, bkdk parambkdk, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    bkdl localbkdl = new bkdl(paramTroopHWJsPlugin);
    localbkdl.jdField_a_of_type_Int = paramInt1;
    localbkdl.jdField_a_of_type_Bkdk = parambkdk;
    localbkdl.jdField_a_of_type_Bkdb = new bkdb(paramTroopHWJsPlugin.mRuntime.a(), paramString, parambkdk.jdField_b_of_type_JavaLangString);
    localbkdl.jdField_a_of_type_Bkdb.a(localbkdl.jdField_a_of_type_Bkda);
    localbkdl.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    localbkdl.jdField_b_of_type_JavaLangString = paramString;
    localbkdl.jdField_b_of_type_Int = paramInt2;
    return localbkdl;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = bflr.d(paramString2) + bckt.a(paramString2);
    paramString1 = bdzf.a(alof.bu + paramString1 + File.separator);
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
        ((AppActivity)localActivity).requestPermissions(new bkdh(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
      localWebViewFragment.a(this, localIntent, (byte)3);
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
        ((AppActivity)localActivity).requestPermissions(new bkdj(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
      localWebViewFragment.a(this, localIntent, (byte)5);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934597L) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bkdp.a();
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
    //   7: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   28: invokespecial 852	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: ldc_w 854
    //   35: aload 4
    //   37: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +83 -> 123
    //   43: aload_0
    //   44: aload_1
    //   45: ldc_w 855
    //   48: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: iconst_1
    //   52: anewarray 250	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc_w 464
    //   60: aastore
    //   61: invokevirtual 255	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   68: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnonnull +11 -> 84
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -49 -> 32
    //   84: new 131	android/content/Intent
    //   87: dup
    //   88: invokespecial 503	android/content/Intent:<init>	()V
    //   91: astore_2
    //   92: aload_2
    //   93: ldc_w 860
    //   96: aload 5
    //   98: iconst_0
    //   99: aaload
    //   100: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   103: pop
    //   104: aload_1
    //   105: iconst_m1
    //   106: aload_2
    //   107: invokevirtual 864	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   110: aload_1
    //   111: invokevirtual 867	android/app/Activity:isFinishing	()Z
    //   114: ifne +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 870	android/app/Activity:finish	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: aload_1
    //   124: ifnull +102 -> 226
    //   127: aload_1
    //   128: ldc_w 872
    //   131: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 15
    //   136: aload_1
    //   137: ldc_w 653
    //   140: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 16
    //   145: aload_0
    //   146: aload 15
    //   148: putfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   151: aload_0
    //   152: aload 16
    //   154: putfield 196	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   157: aload_0
    //   158: aload_3
    //   159: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   162: aload_0
    //   163: aload_1
    //   164: ldc_w 874
    //   167: ldc_w 464
    //   170: invokevirtual 876	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   173: putfield 878	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   176: aload_0
    //   177: aload_1
    //   178: ldc_w 880
    //   181: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   184: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   187: aload_0
    //   188: aload_1
    //   189: ldc_w 885
    //   192: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   195: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   198: aload_0
    //   199: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   202: ifne +10 -> 212
    //   205: aload_0
    //   206: sipush 540
    //   209: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   212: aload_0
    //   213: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   216: ifne +10 -> 226
    //   219: aload_0
    //   220: sipush 540
    //   223: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   226: ldc_w 887
    //   229: aload 4
    //   231: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +73 -> 307
    //   237: aload_0
    //   238: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   241: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   244: astore_1
    //   245: new 131	android/content/Intent
    //   248: dup
    //   249: invokespecial 503	android/content/Intent:<init>	()V
    //   252: astore_2
    //   253: aload_2
    //   254: new 889	android/content/ComponentName
    //   257: dup
    //   258: aload_1
    //   259: ldc_w 891
    //   262: invokespecial 892	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   265: invokevirtual 896	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   268: pop
    //   269: aload_2
    //   270: ldc_w 653
    //   273: aload_0
    //   274: getfield 196	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   277: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   280: pop
    //   281: aload_0
    //   282: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   285: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifeq +10 -> 298
    //   291: aload_1
    //   292: aload_2
    //   293: invokevirtual 900	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   296: iconst_1
    //   297: ireturn
    //   298: aload_0
    //   299: aload_2
    //   300: iconst_1
    //   301: invokevirtual 903	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   304: goto -8 -> 296
    //   307: ldc_w 905
    //   310: aload 4
    //   312: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +110 -> 425
    //   318: iconst_m1
    //   319: istore 6
    //   321: aload_1
    //   322: ifnull +12 -> 334
    //   325: aload_1
    //   326: ldc_w 651
    //   329: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   332: istore 6
    //   334: aload_0
    //   335: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   338: iconst_m1
    //   339: if_icmpne +36 -> 375
    //   342: aload_0
    //   343: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   346: iload 6
    //   348: aload_0
    //   349: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   352: iload 6
    //   354: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: invokevirtual 909	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 250	java/lang/String
    //   363: invokevirtual 911	bkdp:a	(ILjava/lang/String;)V
    //   366: aload_0
    //   367: iload 6
    //   369: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   372: goto -76 -> 296
    //   375: iload 6
    //   377: aload_0
    //   378: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   381: if_icmpeq -85 -> 296
    //   384: aload_0
    //   385: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   388: invokevirtual 839	bkdp:a	()Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   396: iload 6
    //   398: aload_0
    //   399: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   402: iload 6
    //   404: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: invokevirtual 909	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   410: checkcast 250	java/lang/String
    //   413: invokevirtual 911	bkdp:a	(ILjava/lang/String;)V
    //   416: aload_0
    //   417: iload 6
    //   419: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   422: goto -126 -> 296
    //   425: ldc_w 913
    //   428: aload 4
    //   430: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +49 -> 482
    //   436: aload_1
    //   437: ifnull +2472 -> 2909
    //   440: aload_1
    //   441: ldc_w 651
    //   444: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   447: istore 6
    //   449: aload_0
    //   450: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   453: iconst_m1
    //   454: if_icmpeq -158 -> 296
    //   457: iload 6
    //   459: aload_0
    //   460: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   463: if_icmpne -167 -> 296
    //   466: aload_0
    //   467: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   470: invokevirtual 839	bkdp:a	()Z
    //   473: pop
    //   474: aload_0
    //   475: iconst_m1
    //   476: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   479: goto -183 -> 296
    //   482: ldc_w 915
    //   485: aload 4
    //   487: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   490: ifeq +204 -> 694
    //   493: bipush 10
    //   495: istore 7
    //   497: iconst_0
    //   498: istore 6
    //   500: aload_1
    //   501: ifnull +34 -> 535
    //   504: aload_1
    //   505: ldc_w 917
    //   508: bipush 10
    //   510: invokevirtual 920	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   513: istore 7
    //   515: aload_0
    //   516: aload_1
    //   517: ldc_w 880
    //   520: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   523: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   526: aload_1
    //   527: ldc_w 922
    //   530: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   533: istore 6
    //   535: iload 6
    //   537: iconst_1
    //   538: if_icmpne +13 -> 551
    //   541: aload_0
    //   542: sipush 29954
    //   545: invokespecial 542	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	(I)V
    //   548: goto -252 -> 296
    //   551: iload 6
    //   553: iconst_2
    //   554: if_icmpne +12 -> 566
    //   557: aload_0
    //   558: iload 7
    //   560: invokevirtual 924	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   563: goto -267 -> 296
    //   566: iload 6
    //   568: iconst_3
    //   569: if_icmpne +116 -> 685
    //   572: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +30 -> 605
    //   578: ldc_w 266
    //   581: iconst_2
    //   582: new 34	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 926
    //   592: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_1
    //   596: invokevirtual 929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: aload_0
    //   606: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   612: ifne +13 -> 625
    //   615: aload_0
    //   616: getfield 878	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   619: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   622: ifeq +54 -> 676
    //   625: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +46 -> 674
    //   631: ldc_w 266
    //   634: iconst_2
    //   635: new 34	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   642: ldc_w 933
    //   645: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_0
    //   649: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   652: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc_w 935
    //   658: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 878	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   665: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 275	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: iconst_1
    //   675: ireturn
    //   676: aload_0
    //   677: iload 7
    //   679: invokevirtual 936	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   682: goto -386 -> 296
    //   685: aload_0
    //   686: iload 7
    //   688: invokespecial 938	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(I)V
    //   691: goto -395 -> 296
    //   694: ldc_w 940
    //   697: aload 4
    //   699: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   702: ifeq +187 -> 889
    //   705: lconst_0
    //   706: lstore 8
    //   708: bipush 102
    //   710: istore 6
    //   712: aconst_null
    //   713: astore 5
    //   715: aconst_null
    //   716: astore 4
    //   718: aload_1
    //   719: ifnull +2181 -> 2900
    //   722: aload_1
    //   723: ldc_w 942
    //   726: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   729: astore 5
    //   731: aload_1
    //   732: ldc_w 944
    //   735: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   738: astore 4
    //   740: aload_1
    //   741: ldc_w 874
    //   744: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   747: astore 15
    //   749: aload_1
    //   750: ldc_w 946
    //   753: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: astore_3
    //   757: aload_1
    //   758: ldc_w 948
    //   761: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   764: astore_2
    //   765: aload 15
    //   767: astore_1
    //   768: aload_3
    //   769: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   772: ifne +12 -> 784
    //   775: aload_3
    //   776: invokestatic 953	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   779: invokevirtual 956	java/lang/Long:longValue	()J
    //   782: lstore 8
    //   784: aload_2
    //   785: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   788: ifne +12 -> 800
    //   791: aload_2
    //   792: invokestatic 959	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   795: invokevirtual 962	java/lang/Integer:intValue	()I
    //   798: istore 6
    //   800: aload_1
    //   801: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   804: ifne +66 -> 870
    //   807: aload_0
    //   808: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Yqz	Lyqz;
    //   811: aload_1
    //   812: invokestatic 953	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   815: invokevirtual 956	java/lang/Long:longValue	()J
    //   818: aload 4
    //   820: aload 5
    //   822: lload 8
    //   824: iload 6
    //   826: aload_0
    //   827: invokevirtual 967	yqz:a	(JLjava/lang/String;Ljava/lang/String;JILyrb;)V
    //   830: goto -534 -> 296
    //   833: astore_2
    //   834: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq -541 -> 296
    //   840: ldc_w 266
    //   843: iconst_2
    //   844: new 34	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 969
    //   854: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_1
    //   858: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 971	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: goto -571 -> 296
    //   870: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq -577 -> 296
    //   876: ldc_w 266
    //   879: iconst_2
    //   880: ldc_w 973
    //   883: invokestatic 971	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   886: goto -590 -> 296
    //   889: ldc_w 975
    //   892: aload 4
    //   894: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   897: ifeq +73 -> 970
    //   900: aload_1
    //   901: ifnull +1992 -> 2893
    //   904: aload_1
    //   905: ldc_w 659
    //   908: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   911: astore_1
    //   912: aload_0
    //   913: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   916: ifnonnull +19 -> 935
    //   919: aload_0
    //   920: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   923: aload_1
    //   924: invokevirtual 977	bkdp:b	(Ljava/lang/String;)V
    //   927: aload_0
    //   928: aload_1
    //   929: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   932: goto -636 -> 296
    //   935: aload_0
    //   936: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   939: aload_1
    //   940: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   943: ifne -647 -> 296
    //   946: aload_0
    //   947: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   950: invokevirtual 839	bkdp:a	()Z
    //   953: pop
    //   954: aload_0
    //   955: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   958: aload_1
    //   959: invokevirtual 977	bkdp:b	(Ljava/lang/String;)V
    //   962: aload_0
    //   963: aload_1
    //   964: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   967: goto -671 -> 296
    //   970: ldc_w 979
    //   973: aload 4
    //   975: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifeq +49 -> 1027
    //   981: aload_1
    //   982: ifnull +1904 -> 2886
    //   985: aload_1
    //   986: ldc_w 659
    //   989: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   992: astore_1
    //   993: aload_0
    //   994: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   997: ifnull -701 -> 296
    //   1000: aload_0
    //   1001: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1004: aload_1
    //   1005: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1008: ifeq -712 -> 296
    //   1011: aload_0
    //   1012: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   1015: invokevirtual 839	bkdp:a	()Z
    //   1018: pop
    //   1019: aload_0
    //   1020: aconst_null
    //   1021: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1024: goto -728 -> 296
    //   1027: ldc_w 981
    //   1030: aload 4
    //   1032: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1035: ifeq +23 -> 1058
    //   1038: aload_0
    //   1039: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   1042: aload_0
    //   1043: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   1046: invokevirtual 614	begz:a	()Lcom/tencent/common/app/AppInterface;
    //   1049: invokevirtual 984	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1052: invokevirtual 986	bkdp:e	(Ljava/lang/String;)V
    //   1055: goto -759 -> 296
    //   1058: ldc_w 988
    //   1061: aload 4
    //   1063: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1066: ifeq +39 -> 1105
    //   1069: aload_1
    //   1070: ifnull +25 -> 1095
    //   1073: aload_0
    //   1074: aload_1
    //   1075: ldc_w 990
    //   1078: invokevirtual 994	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1081: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1084: aload_0
    //   1085: aload_1
    //   1086: ldc_w 996
    //   1089: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1092: putfield 82	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1095: aload_0
    //   1096: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdp	Lbkdp;
    //   1099: invokevirtual 998	bkdp:b	()V
    //   1102: goto -806 -> 296
    //   1105: ldc_w 1000
    //   1108: aload 4
    //   1110: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1113: ifeq +25 -> 1138
    //   1116: new 1002	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1119: dup
    //   1120: aload_0
    //   1121: aload_2
    //   1122: invokestatic 1005	baqn:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1125: invokespecial 1006	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1128: bipush 8
    //   1130: aconst_null
    //   1131: iconst_0
    //   1132: invokestatic 728	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1135: goto -839 -> 296
    //   1138: ldc_w 1008
    //   1141: aload 4
    //   1143: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1146: ifeq +54 -> 1200
    //   1149: aload_1
    //   1150: ifnull -854 -> 296
    //   1153: aload_1
    //   1154: ldc_w 659
    //   1157: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1160: astore_2
    //   1161: aload_1
    //   1162: ldc_w 1010
    //   1165: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1168: astore_3
    //   1169: aload_0
    //   1170: aload_1
    //   1171: ldc_w 872
    //   1174: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1177: putfield 737	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1180: aload_0
    //   1181: aload_3
    //   1182: aload_2
    //   1183: invokevirtual 740	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1186: astore_1
    //   1187: aload_0
    //   1188: getfield 1012	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdc	Lbkdc;
    //   1191: aload_2
    //   1192: aload_1
    //   1193: aload_0
    //   1194: invokevirtual 1017	bkdc:a	(Ljava/lang/String;Ljava/lang/String;Lbkde;)V
    //   1197: goto -901 -> 296
    //   1200: ldc_w 1019
    //   1203: aload 4
    //   1205: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1208: ifeq +26 -> 1234
    //   1211: aload_1
    //   1212: ifnull -916 -> 296
    //   1215: aload_1
    //   1216: ldc_w 659
    //   1219: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1222: astore_1
    //   1223: aload_0
    //   1224: getfield 1012	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bkdc	Lbkdc;
    //   1227: aload_1
    //   1228: invokevirtual 1020	bkdc:a	(Ljava/lang/String;)V
    //   1231: goto -935 -> 296
    //   1234: ldc_w 1022
    //   1237: aload 4
    //   1239: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1242: ifeq +194 -> 1436
    //   1245: aload_1
    //   1246: ifnull -950 -> 296
    //   1249: aload_1
    //   1250: ldc_w 1010
    //   1253: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1256: astore 4
    //   1258: aload_1
    //   1259: ldc_w 1024
    //   1262: invokevirtual 1028	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1265: astore 5
    //   1267: aload_1
    //   1268: ldc_w 872
    //   1271: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1274: astore_2
    //   1275: new 229	org/json/JSONObject
    //   1278: dup
    //   1279: invokespecial 649	org/json/JSONObject:<init>	()V
    //   1282: astore_3
    //   1283: new 1030	org/json/JSONArray
    //   1286: dup
    //   1287: invokespecial 1031	org/json/JSONArray:<init>	()V
    //   1290: astore 15
    //   1292: aload 5
    //   1294: invokevirtual 1033	org/json/JSONArray:length	()I
    //   1297: istore 7
    //   1299: iconst_0
    //   1300: istore 6
    //   1302: iload 6
    //   1304: iload 7
    //   1306: if_icmpge +33 -> 1339
    //   1309: aload 15
    //   1311: iload 6
    //   1313: aload_0
    //   1314: aload 4
    //   1316: aload 5
    //   1318: iload 6
    //   1320: invokevirtual 1036	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1323: invokevirtual 1038	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1326: invokevirtual 1041	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1329: pop
    //   1330: iload 6
    //   1332: iconst_1
    //   1333: iadd
    //   1334: istore 6
    //   1336: goto -34 -> 1302
    //   1339: aload_3
    //   1340: ldc_w 1043
    //   1343: aload 15
    //   1345: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1348: pop
    //   1349: aload_3
    //   1350: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1353: astore_3
    //   1354: aload_0
    //   1355: aload_2
    //   1356: iconst_1
    //   1357: anewarray 250	java/lang/String
    //   1360: dup
    //   1361: iconst_0
    //   1362: aload_3
    //   1363: aastore
    //   1364: invokevirtual 255	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1367: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -1074 -> 296
    //   1373: ldc_w 266
    //   1376: iconst_2
    //   1377: new 34	java/lang/StringBuilder
    //   1380: dup
    //   1381: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1384: ldc_w 1045
    //   1387: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: aload_1
    //   1391: invokevirtual 929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1394: ldc_w 1047
    //   1397: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: aload_3
    //   1401: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: goto -1114 -> 296
    //   1413: astore 4
    //   1415: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq -69 -> 1349
    //   1421: ldc_w 266
    //   1424: iconst_2
    //   1425: ldc_w 1045
    //   1428: aload 4
    //   1430: invokestatic 1050	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1433: goto -84 -> 1349
    //   1436: ldc_w 1052
    //   1439: aload 4
    //   1441: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1444: ifeq +68 -> 1512
    //   1447: aload_1
    //   1448: ifnull -1152 -> 296
    //   1451: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq +30 -> 1484
    //   1457: ldc_w 266
    //   1460: iconst_2
    //   1461: new 34	java/lang/StringBuilder
    //   1464: dup
    //   1465: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1468: ldc_w 1054
    //   1471: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload_1
    //   1475: invokevirtual 929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1478: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1481: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1484: aload_1
    //   1485: ldc_w 1056
    //   1488: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1491: astore_2
    //   1492: aload_1
    //   1493: ldc_w 1058
    //   1496: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1499: astore_1
    //   1500: aload_0
    //   1501: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Yqz	Lyqz;
    //   1504: aload_2
    //   1505: aload_1
    //   1506: invokevirtual 1061	yqz:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: goto -1213 -> 296
    //   1512: ldc_w 1063
    //   1515: aload 4
    //   1517: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1520: ifeq +58 -> 1578
    //   1523: aload_1
    //   1524: ifnull +54 -> 1578
    //   1527: aload_1
    //   1528: ldc_w 661
    //   1531: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1534: pop
    //   1535: aload_1
    //   1536: ldc_w 651
    //   1539: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1542: istore 6
    //   1544: aload_0
    //   1545: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1548: iload 6
    //   1550: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1553: invokevirtual 909	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1556: checkcast 604	bkdl
    //   1559: astore_1
    //   1560: aload_1
    //   1561: ifnull -1265 -> 296
    //   1564: aload_1
    //   1565: getfield 1064	bkdl:jdField_a_of_type_Boolean	Z
    //   1568: ifne -1272 -> 296
    //   1571: aload_1
    //   1572: invokevirtual 1065	bkdl:b	()V
    //   1575: goto -1279 -> 296
    //   1578: ldc_w 1067
    //   1581: aload 4
    //   1583: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1586: ifeq +62 -> 1648
    //   1589: aload_1
    //   1590: ifnull +58 -> 1648
    //   1593: aload_1
    //   1594: ldc_w 661
    //   1597: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1600: pop
    //   1601: aload_1
    //   1602: ldc_w 651
    //   1605: invokevirtual 883	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1608: istore 6
    //   1610: aload_0
    //   1611: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1614: iload 6
    //   1616: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1619: invokevirtual 909	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1622: checkcast 604	bkdl
    //   1625: astore_1
    //   1626: aload_1
    //   1627: ifnull -1331 -> 296
    //   1630: aload_1
    //   1631: getfield 1064	bkdl:jdField_a_of_type_Boolean	Z
    //   1634: ifeq -1338 -> 296
    //   1637: aload_1
    //   1638: getfield 1070	bkdl:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1641: iconst_1
    //   1642: invokevirtual 1076	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1645: goto -1349 -> 296
    //   1648: ldc_w 1078
    //   1651: aload 4
    //   1653: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1656: ifeq +83 -> 1739
    //   1659: aload_1
    //   1660: ifnull -1364 -> 296
    //   1663: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1666: ifeq +24 -> 1690
    //   1669: ldc_w 266
    //   1672: iconst_2
    //   1673: iconst_2
    //   1674: anewarray 146	java/lang/Object
    //   1677: dup
    //   1678: iconst_0
    //   1679: ldc_w 1080
    //   1682: aastore
    //   1683: dup
    //   1684: iconst_1
    //   1685: aload_1
    //   1686: aastore
    //   1687: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1690: aload_1
    //   1691: ldc_w 1010
    //   1694: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1697: astore_2
    //   1698: aload_1
    //   1699: ldc_w 661
    //   1702: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1705: astore_1
    //   1706: aload_0
    //   1707: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Yqz	Lyqz;
    //   1710: aload_2
    //   1711: aload_1
    //   1712: invokevirtual 1082	yqz:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1715: goto -1419 -> 296
    //   1718: astore_1
    //   1719: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1722: ifeq -1426 -> 296
    //   1725: ldc_w 266
    //   1728: iconst_2
    //   1729: ldc_w 1084
    //   1732: aload_1
    //   1733: invokestatic 1050	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1736: goto -1440 -> 296
    //   1739: ldc_w 1086
    //   1742: aload 4
    //   1744: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1747: ifeq +167 -> 1914
    //   1750: aload_1
    //   1751: ifnull -1455 -> 296
    //   1754: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1757: ifeq +30 -> 1787
    //   1760: ldc_w 266
    //   1763: iconst_2
    //   1764: new 34	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1771: ldc_w 1088
    //   1774: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: aload_1
    //   1778: invokevirtual 929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1787: aload_1
    //   1788: ldc_w 651
    //   1791: iconst_0
    //   1792: invokevirtual 920	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1795: istore 6
    //   1797: aload_0
    //   1798: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1801: iload 6
    //   1803: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1806: invokevirtual 909	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1809: checkcast 604	bkdl
    //   1812: astore_2
    //   1813: aload_2
    //   1814: ifnull +70 -> 1884
    //   1817: aload_2
    //   1818: getfield 633	bkdl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1821: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1824: ifne +60 -> 1884
    //   1827: new 774	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1830: dup
    //   1831: invokespecial 775	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1834: astore_1
    //   1835: aload_1
    //   1836: aload_2
    //   1837: getfield 633	bkdl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1840: invokevirtual 793	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1843: new 131	android/content/Intent
    //   1846: dup
    //   1847: aload_0
    //   1848: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   1851: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   1854: ldc_w 807
    //   1857: invokespecial 136	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1860: astore_2
    //   1861: aload_2
    //   1862: ldc_w 813
    //   1865: aload_1
    //   1866: invokevirtual 816	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1869: pop
    //   1870: aload_0
    //   1871: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   1874: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   1877: aload_2
    //   1878: invokevirtual 900	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1881: goto -1585 -> 296
    //   1884: ldc_w 266
    //   1887: iconst_1
    //   1888: new 34	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1895: ldc_w 1090
    //   1898: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: aload_2
    //   1902: invokevirtual 929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1905: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1908: invokestatic 971	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1911: goto -1615 -> 296
    //   1914: ldc_w 1092
    //   1917: aload 4
    //   1919: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1922: ifeq +18 -> 1940
    //   1925: aload_0
    //   1926: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1929: invokevirtual 1095	java/util/HashMap:clear	()V
    //   1932: aload_0
    //   1933: iconst_1
    //   1934: putfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   1937: goto -1641 -> 296
    //   1940: ldc_w 1097
    //   1943: aload 4
    //   1945: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1948: ifeq +77 -> 2025
    //   1951: aload_1
    //   1952: ifnull -1656 -> 296
    //   1955: aload_1
    //   1956: ldc_w 651
    //   1959: iconst_0
    //   1960: invokevirtual 920	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1963: istore 6
    //   1965: aload_0
    //   1966: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1969: iload 6
    //   1971: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1974: invokevirtual 909	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1977: checkcast 604	bkdl
    //   1980: astore_1
    //   1981: aload_1
    //   1982: ifnull -1686 -> 296
    //   1985: aload_1
    //   1986: getfield 633	bkdl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1989: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1992: ifne -1696 -> 296
    //   1995: new 290	java/io/File
    //   1998: dup
    //   1999: aload_1
    //   2000: getfield 633	bkdl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2003: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   2006: astore_2
    //   2007: aload_0
    //   2008: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Yqz	Lyqz;
    //   2011: aload_1
    //   2012: getfield 633	bkdl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2015: aload_2
    //   2016: invokevirtual 1098	java/io/File:getName	()Ljava/lang/String;
    //   2019: invokevirtual 1061	yqz:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2022: goto -1726 -> 296
    //   2025: ldc_w 1100
    //   2028: aload 4
    //   2030: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2033: ifeq +94 -> 2127
    //   2036: aload_1
    //   2037: ifnull +78 -> 2115
    //   2040: ldc_w 266
    //   2043: ldc_w 1102
    //   2046: aload_1
    //   2047: invokestatic 1107	wxe:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   2050: aload_1
    //   2051: ldc_w 1109
    //   2054: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2057: astore_2
    //   2058: aload_1
    //   2059: ldc_w 1111
    //   2062: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2065: astore_3
    //   2066: aload_1
    //   2067: ldc_w 1113
    //   2070: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2073: astore 4
    //   2075: aload_1
    //   2076: ldc_w 1115
    //   2079: invokevirtual 858	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2082: astore_1
    //   2083: aload_0
    //   2084: aload_0
    //   2085: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   2088: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   2091: aload_2
    //   2092: aload_3
    //   2093: aload_0
    //   2094: getfield 248	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2097: aload 4
    //   2099: aload_0
    //   2100: getfield 878	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2103: aload_1
    //   2104: invokestatic 1120	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2107: bipush 6
    //   2109: invokevirtual 903	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2112: goto -1816 -> 296
    //   2115: ldc_w 266
    //   2118: ldc_w 1122
    //   2121: invokestatic 1123	wxe:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2124: goto -1828 -> 296
    //   2127: ldc_w 1125
    //   2130: aload 4
    //   2132: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2135: ifeq +186 -> 2321
    //   2138: new 229	org/json/JSONObject
    //   2141: dup
    //   2142: aload 5
    //   2144: iconst_0
    //   2145: aaload
    //   2146: invokespecial 852	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2149: ldc_w 1127
    //   2152: invokevirtual 1128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2155: astore_2
    //   2156: aload_2
    //   2157: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2160: istore 14
    //   2162: iload 14
    //   2164: ifne -1868 -> 296
    //   2167: lconst_0
    //   2168: lstore 8
    //   2170: aload_2
    //   2171: invokestatic 1131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2174: lstore 10
    //   2176: lload 10
    //   2178: lstore 8
    //   2180: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2183: ifeq +31 -> 2214
    //   2186: ldc_w 266
    //   2189: iconst_2
    //   2190: new 34	java/lang/StringBuilder
    //   2193: dup
    //   2194: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2197: ldc_w 1133
    //   2200: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: lload 8
    //   2205: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2208: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2211: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2214: lload 8
    //   2216: lconst_0
    //   2217: lcmp
    //   2218: ifle +67 -> 2285
    //   2221: aload_0
    //   2222: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   2225: ifnull +55 -> 2280
    //   2228: aload_0
    //   2229: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   2232: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   2235: astore_1
    //   2236: aload_1
    //   2237: aconst_null
    //   2238: aload_2
    //   2239: invokestatic 1138	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2242: aload_1
    //   2243: ifnull -1947 -> 296
    //   2246: aload_1
    //   2247: ldc_w 1139
    //   2250: ldc_w 1140
    //   2253: invokevirtual 1143	android/app/Activity:overridePendingTransition	(II)V
    //   2256: goto -1960 -> 296
    //   2259: astore_1
    //   2260: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2263: ifeq -1967 -> 296
    //   2266: ldc_w 266
    //   2269: iconst_2
    //   2270: ldc_w 1145
    //   2273: aload_1
    //   2274: invokestatic 1050	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2277: goto -1981 -> 296
    //   2280: aconst_null
    //   2281: astore_1
    //   2282: goto -46 -> 2236
    //   2285: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2288: ifeq -1992 -> 296
    //   2291: ldc_w 266
    //   2294: iconst_2
    //   2295: new 34	java/lang/StringBuilder
    //   2298: dup
    //   2299: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2302: ldc_w 1147
    //   2305: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2308: aload_2
    //   2309: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2312: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2315: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2318: goto -2022 -> 296
    //   2321: ldc_w 1149
    //   2324: aload 4
    //   2326: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2329: ifeq +245 -> 2574
    //   2332: new 229	org/json/JSONObject
    //   2335: dup
    //   2336: aload 5
    //   2338: iconst_0
    //   2339: aaload
    //   2340: invokespecial 852	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2343: astore_1
    //   2344: aload_1
    //   2345: ldc_w 1151
    //   2348: invokevirtual 1128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2351: astore_2
    //   2352: aload_2
    //   2353: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2356: istore 14
    //   2358: iload 14
    //   2360: ifne -2064 -> 296
    //   2363: aload_2
    //   2364: invokestatic 1131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2367: lstore 10
    //   2369: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2372: ifeq +31 -> 2403
    //   2375: ldc_w 266
    //   2378: iconst_2
    //   2379: new 34	java/lang/StringBuilder
    //   2382: dup
    //   2383: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2386: ldc_w 1153
    //   2389: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: lload 10
    //   2394: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2397: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2400: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2403: aload_1
    //   2404: ldc_w 1127
    //   2407: invokevirtual 1128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2410: astore_1
    //   2411: lconst_0
    //   2412: lstore 8
    //   2414: aload_1
    //   2415: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2418: istore 14
    //   2420: lload 8
    //   2422: lstore 12
    //   2424: iload 14
    //   2426: ifne +55 -> 2481
    //   2429: aload_1
    //   2430: invokestatic 1131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2433: lstore 12
    //   2435: lload 12
    //   2437: lstore 8
    //   2439: lload 8
    //   2441: lstore 12
    //   2443: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2446: ifeq +35 -> 2481
    //   2449: ldc_w 266
    //   2452: iconst_2
    //   2453: new 34	java/lang/StringBuilder
    //   2456: dup
    //   2457: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2460: ldc_w 1133
    //   2463: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: lload 8
    //   2468: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2471: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2474: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2477: lload 8
    //   2479: lstore 12
    //   2481: lload 10
    //   2483: lconst_0
    //   2484: lcmp
    //   2485: ifle -2189 -> 296
    //   2488: lload 12
    //   2490: lconst_0
    //   2491: lcmp
    //   2492: ifle -2196 -> 296
    //   2495: aload_0
    //   2496: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   2499: ifnull +70 -> 2569
    //   2502: aload_0
    //   2503: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   2506: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   2509: astore_1
    //   2510: aload_0
    //   2511: aload_1
    //   2512: lload 12
    //   2514: lload 10
    //   2516: invokestatic 1158	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2519: bipush 7
    //   2521: invokevirtual 903	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2524: aload_1
    //   2525: ifnull -2229 -> 296
    //   2528: aload_1
    //   2529: ldc_w 1139
    //   2532: ldc_w 1140
    //   2535: invokevirtual 1143	android/app/Activity:overridePendingTransition	(II)V
    //   2538: goto -2242 -> 296
    //   2541: astore_1
    //   2542: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2545: ifeq -2249 -> 296
    //   2548: ldc_w 266
    //   2551: iconst_2
    //   2552: ldc_w 1145
    //   2555: aload_1
    //   2556: invokestatic 1050	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2559: goto -2263 -> 296
    //   2562: astore_2
    //   2563: lconst_0
    //   2564: lstore 10
    //   2566: goto -197 -> 2369
    //   2569: aconst_null
    //   2570: astore_1
    //   2571: goto -61 -> 2510
    //   2574: ldc_w 1160
    //   2577: aload 4
    //   2579: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2582: ifeq -2286 -> 296
    //   2585: new 229	org/json/JSONObject
    //   2588: dup
    //   2589: aload 5
    //   2591: iconst_0
    //   2592: aaload
    //   2593: invokespecial 852	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2596: astore_2
    //   2597: aload_2
    //   2598: ldc_w 1151
    //   2601: invokevirtual 1128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2604: astore_1
    //   2605: aload_2
    //   2606: ldc_w 1127
    //   2609: invokevirtual 1128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2612: astore_2
    //   2613: aload_1
    //   2614: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2617: ifne +211 -> 2828
    //   2620: aload_2
    //   2621: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2624: istore 14
    //   2626: iload 14
    //   2628: ifne +200 -> 2828
    //   2631: aload_1
    //   2632: invokestatic 1131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2635: lstore 8
    //   2637: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2640: ifeq +31 -> 2671
    //   2643: ldc_w 266
    //   2646: iconst_2
    //   2647: new 34	java/lang/StringBuilder
    //   2650: dup
    //   2651: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2654: ldc_w 1162
    //   2657: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2660: lload 8
    //   2662: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2665: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2668: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2671: lconst_0
    //   2672: lstore 10
    //   2674: aload_2
    //   2675: invokestatic 1131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2678: lstore 12
    //   2680: lload 12
    //   2682: lstore 10
    //   2684: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2687: ifeq +31 -> 2718
    //   2690: ldc_w 266
    //   2693: iconst_2
    //   2694: new 34	java/lang/StringBuilder
    //   2697: dup
    //   2698: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2701: ldc_w 1164
    //   2704: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: lload 10
    //   2709: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2712: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2715: invokestatic 931	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2718: lload 8
    //   2720: lconst_0
    //   2721: lcmp
    //   2722: ifle -2426 -> 296
    //   2725: lload 10
    //   2727: lconst_0
    //   2728: lcmp
    //   2729: ifle -2433 -> 296
    //   2732: aload_0
    //   2733: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   2736: ifnull +87 -> 2823
    //   2739: aload_0
    //   2740: getfield 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbegz;
    //   2743: invokevirtual 559	begz:a	()Landroid/app/Activity;
    //   2746: astore_1
    //   2747: new 769	android/os/Bundle
    //   2750: dup
    //   2751: invokespecial 1165	android/os/Bundle:<init>	()V
    //   2754: astore_3
    //   2755: aload_3
    //   2756: ldc_w 1151
    //   2759: lload 8
    //   2761: invokevirtual 1169	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2764: aload_3
    //   2765: ldc_w 1171
    //   2768: iconst_2
    //   2769: invokevirtual 1175	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2772: aload_1
    //   2773: aload_3
    //   2774: aload_2
    //   2775: invokestatic 1138	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2778: aload_1
    //   2779: ifnull -2483 -> 296
    //   2782: aload_1
    //   2783: ldc_w 1139
    //   2786: ldc_w 1140
    //   2789: invokevirtual 1143	android/app/Activity:overridePendingTransition	(II)V
    //   2792: goto -2496 -> 296
    //   2795: astore_1
    //   2796: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2799: ifeq -2503 -> 296
    //   2802: ldc_w 266
    //   2805: iconst_2
    //   2806: ldc_w 1145
    //   2809: aload_1
    //   2810: invokestatic 1050	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2813: goto -2517 -> 296
    //   2816: astore_1
    //   2817: lconst_0
    //   2818: lstore 8
    //   2820: goto -183 -> 2637
    //   2823: aconst_null
    //   2824: astore_1
    //   2825: goto -78 -> 2747
    //   2828: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2831: ifeq -2535 -> 296
    //   2834: ldc_w 266
    //   2837: iconst_2
    //   2838: new 34	java/lang/StringBuilder
    //   2841: dup
    //   2842: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2845: ldc_w 1177
    //   2848: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: aload_1
    //   2852: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: ldc_w 1179
    //   2858: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2861: aload_2
    //   2862: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2868: invokestatic 971	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2871: goto -2575 -> 296
    //   2874: astore_1
    //   2875: goto -695 -> 2180
    //   2878: astore_1
    //   2879: goto -440 -> 2439
    //   2882: astore_1
    //   2883: goto -199 -> 2684
    //   2886: ldc_w 464
    //   2889: astore_1
    //   2890: goto -1897 -> 993
    //   2893: ldc_w 464
    //   2896: astore_1
    //   2897: goto -1985 -> 912
    //   2900: aconst_null
    //   2901: astore_2
    //   2902: aconst_null
    //   2903: astore_1
    //   2904: aconst_null
    //   2905: astore_3
    //   2906: goto -2138 -> 768
    //   2909: iconst_m1
    //   2910: istore 6
    //   2912: goto -2463 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2915	0	this	TroopHWJsPlugin
    //   0	2915	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2915	2	paramString1	String
    //   0	2915	3	paramString2	String
    //   0	2915	4	paramString3	String
    //   0	2915	5	paramVarArgs	String[]
    //   319	2592	6	j	int
    //   495	812	7	k	int
    //   706	2113	8	l1	long
    //   2174	552	10	l2	long
    //   2422	259	12	l3	long
    //   2160	467	14	bool	boolean
    //   134	1210	15	localObject	Object
    //   143	10	16	str	String
    // Exception table:
    //   from	to	target	type
    //   20	32	78	org/json/JSONException
    //   800	830	833	java/lang/NumberFormatException
    //   870	886	833	java/lang/NumberFormatException
    //   1283	1299	1413	java/lang/Exception
    //   1309	1330	1413	java/lang/Exception
    //   1339	1349	1413	java/lang/Exception
    //   1690	1715	1718	java/lang/Exception
    //   2138	2162	2259	java/lang/Exception
    //   2180	2214	2259	java/lang/Exception
    //   2221	2236	2259	java/lang/Exception
    //   2236	2242	2259	java/lang/Exception
    //   2246	2256	2259	java/lang/Exception
    //   2285	2318	2259	java/lang/Exception
    //   2332	2358	2541	java/lang/Exception
    //   2369	2403	2541	java/lang/Exception
    //   2403	2411	2541	java/lang/Exception
    //   2414	2420	2541	java/lang/Exception
    //   2443	2477	2541	java/lang/Exception
    //   2495	2510	2541	java/lang/Exception
    //   2510	2524	2541	java/lang/Exception
    //   2528	2538	2541	java/lang/Exception
    //   2363	2369	2562	java/lang/Exception
    //   2585	2626	2795	java/lang/Exception
    //   2637	2671	2795	java/lang/Exception
    //   2684	2718	2795	java/lang/Exception
    //   2732	2747	2795	java/lang/Exception
    //   2747	2778	2795	java/lang/Exception
    //   2782	2792	2795	java/lang/Exception
    //   2828	2871	2795	java/lang/Exception
    //   2631	2637	2816	java/lang/Exception
    //   2170	2176	2874	java/lang/Exception
    //   2429	2435	2878	java/lang/Exception
    //   2674	2680	2882	java/lang/Exception
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
                localObject1 = new bkdk(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
                paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (bkdk)localObject1, 0);
                this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
                paramIntent.jdField_a_of_type_Bkdb.a();
                this.jdField_d_of_type_Int += 1;
                return;
              }
            } while (paramInt != -1);
            localHashMap1 = new HashMap();
            localHashMap2 = new HashMap();
            if ((paramByte == 2) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
            {
              bdhj.a(this.mRuntime.a(), this.jdField_c_of_type_JavaLangString);
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
                  if (bdfa.getMediaType((LocalMediaInfo)paramIntent.get(localObject3)) != 1) {
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
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new bkdk(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
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
    this.jdField_a_of_type_Yqz = yqz.a();
    this.jdField_a_of_type_Yqz.a();
    this.jdField_a_of_type_Bkdp = new bkdp(this.mRuntime.a(), this);
    this.jdField_a_of_type_Bkdc = new bkdc(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    int k = 0;
    if (this.jdField_a_of_type_Yqz != null) {
      this.jdField_a_of_type_Yqz.b();
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Bkdc != null) {
      this.jdField_a_of_type_Bkdc.a(this.mRuntime.a());
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
      localObject1 = new VFSFile(alof.bt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */