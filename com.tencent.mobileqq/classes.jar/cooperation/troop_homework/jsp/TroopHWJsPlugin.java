package cooperation.troop_homework.jsp;

import ajed;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import azgh;
import baaf;
import baaw;
import bacm;
import bbac;
import bbmy;
import bcdu;
import begr;
import bgny;
import bgnz;
import bgob;
import bgoc;
import bgod;
import bgoe;
import bgof;
import bgoj;
import bgol;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
import kzy;
import org.json.JSONException;
import org.json.JSONObject;
import wis;
import wiu;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements bgob, bgol, wiu
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new bgod(this);
  begr jdField_a_of_type_Begr = null;
  private bgnz jdField_a_of_type_Bgnz;
  bgoj jdField_a_of_type_Bgoj = null;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  wis jdField_a_of_type_Wis = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 540;
  String jdField_b_of_type_JavaLangString;
  HashMap<Integer, bgof> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public String c;
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
    jdField_a_of_type_JavaLangString = ajed.bq + "homeworkTmp/";
  }
  
  public TroopHWJsPlugin()
  {
    this.jdField_c_of_type_Int = 0;
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
    //   1: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   14: iload_1
    //   15: iconst_2
    //   16: ldc 211
    //   18: aconst_null
    //   19: iconst_m1
    //   20: invokevirtual 214	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   23: astore 5
    //   25: new 216	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 217	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 6
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 221	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   40: aload 6
    //   42: ldc2_w 222
    //   45: invokevirtual 227	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +100 -> 150
    //   53: aload_0
    //   54: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   57: ifgt +120 -> 177
    //   60: sipush 540
    //   63: istore_1
    //   64: aload_0
    //   65: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   68: ifgt +117 -> 185
    //   71: sipush 540
    //   74: istore_3
    //   75: aload_2
    //   76: iload_1
    //   77: iload_3
    //   78: invokestatic 233	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +65 -> 150
    //   88: aload 4
    //   90: aload 4
    //   92: invokestatic 235	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   95: invokestatic 238	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   98: astore 7
    //   100: aload 7
    //   102: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +40 -> 145
    //   108: aload 5
    //   110: ldc 240
    //   112: aload 7
    //   114: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload 5
    //   120: ldc 248
    //   122: aload 4
    //   124: invokevirtual 251	android/graphics/Bitmap:getWidth	()I
    //   127: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload 5
    //   133: ldc_w 256
    //   136: aload 4
    //   138: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   141: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload 4
    //   147: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   150: aload 6
    //   152: invokevirtual 262	android/media/MediaMetadataRetriever:release	()V
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 264	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   160: iconst_1
    //   161: anewarray 266	java/lang/String
    //   164: dup
    //   165: iconst_0
    //   166: aload 5
    //   168: invokevirtual 267	org/json/JSONObject:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: invokevirtual 271	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   175: aload_2
    //   176: areturn
    //   177: aload_0
    //   178: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   181: istore_1
    //   182: goto -118 -> 64
    //   185: aload_0
    //   186: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   189: istore_3
    //   190: goto -115 -> 75
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_2
    //   197: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +34 -> 234
    //   203: ldc_w 279
    //   206: iconst_2
    //   207: new 34	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 281
    //   217: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 4
    //   222: invokevirtual 284	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   225: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload 6
    //   236: invokevirtual 262	android/media/MediaMetadataRetriever:release	()V
    //   239: goto -84 -> 155
    //   242: astore 4
    //   244: goto -89 -> 155
    //   247: astore 4
    //   249: aconst_null
    //   250: astore_2
    //   251: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +34 -> 288
    //   257: ldc_w 279
    //   260: iconst_2
    //   261: new 34	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 281
    //   271: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 4
    //   276: invokevirtual 289	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload 6
    //   290: invokevirtual 262	android/media/MediaMetadataRetriever:release	()V
    //   293: goto -138 -> 155
    //   296: astore 4
    //   298: goto -143 -> 155
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_2
    //   305: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +34 -> 342
    //   311: ldc_w 279
    //   314: iconst_2
    //   315: new 34	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 291
    //   325: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload 4
    //   330: invokevirtual 292	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload 6
    //   344: invokevirtual 262	android/media/MediaMetadataRetriever:release	()V
    //   347: goto -192 -> 155
    //   350: astore 4
    //   352: goto -197 -> 155
    //   355: astore_2
    //   356: aload 6
    //   358: invokevirtual 262	android/media/MediaMetadataRetriever:release	()V
    //   361: aload_2
    //   362: athrow
    //   363: astore 4
    //   365: goto -210 -> 155
    //   368: astore 4
    //   370: goto -9 -> 361
    //   373: astore 4
    //   375: goto -70 -> 305
    //   378: astore 4
    //   380: goto -129 -> 251
    //   383: astore 4
    //   385: goto -188 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	TroopHWJsPlugin
    //   0	388	1	paramInt	int
    //   0	388	2	paramString	String
    //   74	116	3	j	int
    //   81	65	4	localBitmap	Bitmap
    //   193	28	4	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   242	1	4	localRuntimeException1	java.lang.RuntimeException
    //   247	28	4	localRuntimeException2	java.lang.RuntimeException
    //   296	1	4	localRuntimeException3	java.lang.RuntimeException
    //   301	28	4	localJSONException1	JSONException
    //   350	1	4	localRuntimeException4	java.lang.RuntimeException
    //   363	1	4	localRuntimeException5	java.lang.RuntimeException
    //   368	1	4	localRuntimeException6	java.lang.RuntimeException
    //   373	1	4	localJSONException2	JSONException
    //   378	1	4	localRuntimeException7	java.lang.RuntimeException
    //   383	1	4	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   23	144	5	localJSONObject	JSONObject
    //   32	325	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   98	15	7	str	String
    // Exception table:
    //   from	to	target	type
    //   34	49	193	java/lang/IllegalArgumentException
    //   234	239	242	java/lang/RuntimeException
    //   34	49	247	java/lang/RuntimeException
    //   288	293	296	java/lang/RuntimeException
    //   34	49	301	org/json/JSONException
    //   342	347	350	java/lang/RuntimeException
    //   34	49	355	finally
    //   53	60	355	finally
    //   64	71	355	finally
    //   75	83	355	finally
    //   88	145	355	finally
    //   145	150	355	finally
    //   177	182	355	finally
    //   185	190	355	finally
    //   197	234	355	finally
    //   251	288	355	finally
    //   305	342	355	finally
    //   150	155	363	java/lang/RuntimeException
    //   356	361	368	java/lang/RuntimeException
    //   53	60	373	org/json/JSONException
    //   64	71	373	org/json/JSONException
    //   75	83	373	org/json/JSONException
    //   88	145	373	org/json/JSONException
    //   145	150	373	org/json/JSONException
    //   177	182	373	org/json/JSONException
    //   185	190	373	org/json/JSONException
    //   53	60	378	java/lang/RuntimeException
    //   64	71	378	java/lang/RuntimeException
    //   75	83	378	java/lang/RuntimeException
    //   88	145	378	java/lang/RuntimeException
    //   145	150	378	java/lang/RuntimeException
    //   177	182	378	java/lang/RuntimeException
    //   185	190	378	java/lang/RuntimeException
    //   53	60	383	java/lang/IllegalArgumentException
    //   64	71	383	java/lang/IllegalArgumentException
    //   75	83	383	java/lang/IllegalArgumentException
    //   88	145	383	java/lang/IllegalArgumentException
    //   145	150	383	java/lang/IllegalArgumentException
    //   177	182	383	java/lang/IllegalArgumentException
    //   185	190	383	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString, int paramInt2, TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    // Byte code:
    //   0: new 303	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 309	java/io/File:length	()J
    //   11: ldc2_w 310
    //   14: lcmp
    //   15: ifle +290 -> 305
    //   18: aconst_null
    //   19: astore 12
    //   21: new 34	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   28: astore 15
    //   30: new 313	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 314	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_1
    //   42: putfield 317	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload 17
    //   47: getstatic 323	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   50: putfield 326	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   53: aload 17
    //   55: iconst_1
    //   56: putfield 329	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   59: aload_1
    //   60: aload 17
    //   62: invokestatic 335	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 17
    //   68: getfield 338	android/graphics/BitmapFactory$Options:outWidth	I
    //   71: istore 8
    //   73: aload 17
    //   75: getfield 341	android/graphics/BitmapFactory$Options:outHeight	I
    //   78: istore 10
    //   80: iload 8
    //   82: ifle +1190 -> 1272
    //   85: iload 10
    //   87: ifgt +6 -> 93
    //   90: goto +1182 -> 1272
    //   93: iload 8
    //   95: iload_2
    //   96: if_icmpgt +25 -> 121
    //   99: aload_1
    //   100: astore 11
    //   102: aload_3
    //   103: ifnull +1172 -> 1275
    //   106: aload_3
    //   107: getfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   110: iload_0
    //   111: aload_1
    //   112: iload 8
    //   114: iload 10
    //   116: aload_3
    //   117: invokestatic 344	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;ILjava/lang/String;IILcooperation/troop_homework/jsp/TroopHWJsPlugin;)Ljava/lang/String;
    //   120: areturn
    //   121: aconst_null
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 14
    //   127: new 346	android/graphics/Matrix
    //   130: dup
    //   131: invokespecial 347	android/graphics/Matrix:<init>	()V
    //   134: astore 16
    //   136: fconst_1
    //   137: fstore 5
    //   139: iconst_0
    //   140: istore 7
    //   142: aload_1
    //   143: invokestatic 353	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   146: istore 9
    //   148: iload 9
    //   150: iconst_5
    //   151: if_icmpeq +1127 -> 1278
    //   154: iload 9
    //   156: bipush 6
    //   158: if_icmpeq +1120 -> 1278
    //   161: iload 9
    //   163: bipush 7
    //   165: if_icmpeq +1113 -> 1278
    //   168: iload 9
    //   170: bipush 8
    //   172: if_icmpne +6 -> 178
    //   175: goto +1103 -> 1278
    //   178: iload 7
    //   180: ifeq +127 -> 307
    //   183: iload 10
    //   185: iload_2
    //   186: idiv
    //   187: istore 8
    //   189: aload 17
    //   191: iconst_0
    //   192: putfield 317	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
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
    //   246: putfield 356	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   249: new 358	java/io/FileInputStream
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 359	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   257: astore 13
    //   259: fload 5
    //   261: fstore 4
    //   263: aload 14
    //   265: astore 12
    //   267: aload 13
    //   269: aconst_null
    //   270: aload 17
    //   272: invokestatic 363	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   275: astore 11
    //   277: aload 11
    //   279: ifnonnull +37 -> 316
    //   282: aconst_null
    //   283: astore 11
    //   285: aload 13
    //   287: ifnull +988 -> 1275
    //   290: aload 13
    //   292: invokevirtual 366	java/io/FileInputStream:close	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 369	java/lang/OutOfMemoryError:printStackTrace	()V
    //   302: invokestatic 374	java/lang/System:gc	()V
    //   305: aconst_null
    //   306: areturn
    //   307: iload 8
    //   309: iload_2
    //   310: idiv
    //   311: istore 8
    //   313: goto -124 -> 189
    //   316: iload 7
    //   318: ifeq +417 -> 735
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
    //   360: goto +924 -> 1284
    //   363: fload 5
    //   365: fstore 4
    //   367: aload 11
    //   369: astore 12
    //   371: aload 16
    //   373: fload 5
    //   375: fload 5
    //   377: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   380: aload 11
    //   382: astore 12
    //   384: aload 13
    //   386: ifnull +879 -> 1265
    //   389: aload 13
    //   391: invokevirtual 366	java/io/FileInputStream:close	()V
    //   394: aload 11
    //   396: iconst_0
    //   397: iconst_0
    //   398: aload 11
    //   400: invokevirtual 251	android/graphics/Bitmap:getWidth	()I
    //   403: aload 11
    //   405: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   408: aload 16
    //   410: iconst_1
    //   411: invokestatic 382	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   414: astore 14
    //   416: aload 11
    //   418: aload 14
    //   420: if_acmpeq +8 -> 428
    //   423: aload 11
    //   425: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   428: aload 14
    //   430: invokevirtual 251	android/graphics/Bitmap:getWidth	()I
    //   433: istore_2
    //   434: aload 14
    //   436: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   439: istore 7
    //   441: aconst_null
    //   442: astore 13
    //   444: aconst_null
    //   445: astore 12
    //   447: aload 14
    //   449: invokestatic 235	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   452: istore 8
    //   454: iload 8
    //   456: ifle +600 -> 1056
    //   459: new 384	java/io/ByteArrayOutputStream
    //   462: dup
    //   463: sipush 1024
    //   466: invokespecial 387	java/io/ByteArrayOutputStream:<init>	(I)V
    //   469: astore 11
    //   471: aload 14
    //   473: getstatic 393	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   476: iload 8
    //   478: aload 11
    //   480: invokevirtual 397	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   483: pop
    //   484: aload_3
    //   485: ifnull +777 -> 1262
    //   488: aload 15
    //   490: aload 11
    //   492: invokevirtual 401	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   495: iconst_2
    //   496: invokestatic 407	baaw:encodeToString	([BI)Ljava/lang/String;
    //   499: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +28 -> 534
    //   509: ldc_w 279
    //   512: iconst_2
    //   513: iconst_2
    //   514: anewarray 142	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: ldc_w 409
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: iload 8
    //   527: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: invokestatic 418	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   534: aload 14
    //   536: ifnull +8 -> 544
    //   539: aload 14
    //   541: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   544: aload_3
    //   545: ifnull +80 -> 625
    //   548: aload_3
    //   549: aload_3
    //   550: getfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: iload_0
    //   554: iconst_1
    //   555: ldc 211
    //   557: aconst_null
    //   558: iconst_m1
    //   559: invokevirtual 214	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   562: astore 13
    //   564: aload 15
    //   566: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   572: ifne +13 -> 585
    //   575: aload 13
    //   577: ldc 240
    //   579: aload 15
    //   581: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   584: pop
    //   585: aload 13
    //   587: ldc 248
    //   589: iload_2
    //   590: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload 13
    //   596: ldc_w 256
    //   599: iload 7
    //   601: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   604: pop
    //   605: aload_3
    //   606: aload_3
    //   607: getfield 264	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   610: iconst_1
    //   611: anewarray 266	java/lang/String
    //   614: dup
    //   615: iconst_0
    //   616: aload 13
    //   618: invokevirtual 267	org/json/JSONObject:toString	()Ljava/lang/String;
    //   621: aastore
    //   622: invokevirtual 271	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   625: aload 11
    //   627: ifnull +628 -> 1255
    //   630: new 34	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   637: getstatic 54	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   640: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: aload_1
    //   644: aload_1
    //   645: ldc_w 420
    //   648: invokevirtual 423	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   651: iconst_1
    //   652: iadd
    //   653: aload_1
    //   654: ldc_w 425
    //   657: invokevirtual 423	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   660: invokevirtual 429	java/lang/String:substring	(II)Ljava/lang/String;
    //   663: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokestatic 432	java/lang/System:currentTimeMillis	()J
    //   669: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   672: aload_1
    //   673: invokestatic 440	apdh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   676: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: astore 13
    //   684: new 442	java/io/FileOutputStream
    //   687: dup
    //   688: aload 13
    //   690: invokespecial 443	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   693: astore_1
    //   694: aload_1
    //   695: aload 11
    //   697: invokevirtual 401	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   700: invokevirtual 447	java/io/FileOutputStream:write	([B)V
    //   703: aload_1
    //   704: astore_3
    //   705: aload 13
    //   707: astore_1
    //   708: aload 11
    //   710: ifnull +8 -> 718
    //   713: aload 11
    //   715: invokevirtual 448	java/io/ByteArrayOutputStream:close	()V
    //   718: aload_1
    //   719: astore 11
    //   721: aload_3
    //   722: ifnull +10 -> 732
    //   725: aload_3
    //   726: invokevirtual 449	java/io/FileOutputStream:close	()V
    //   729: aload_1
    //   730: astore 11
    //   732: aload 11
    //   734: areturn
    //   735: iload_2
    //   736: i2f
    //   737: fstore 6
    //   739: fload 5
    //   741: fstore 4
    //   743: aload 11
    //   745: astore 12
    //   747: aload 11
    //   749: invokevirtual 251	android/graphics/Bitmap:getWidth	()I
    //   752: i2f
    //   753: fstore 5
    //   755: fload 5
    //   757: fstore 4
    //   759: aload 11
    //   761: astore 12
    //   763: fload 6
    //   765: fload 5
    //   767: fdiv
    //   768: fstore 5
    //   770: fload 5
    //   772: fstore 4
    //   774: goto +510 -> 1284
    //   777: fload 5
    //   779: fstore 4
    //   781: aload 11
    //   783: astore 12
    //   785: aload 16
    //   787: fload 5
    //   789: fneg
    //   790: fload 5
    //   792: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   795: goto -415 -> 380
    //   798: astore 11
    //   800: aload 12
    //   802: astore 11
    //   804: aload 16
    //   806: fload 4
    //   808: fload 4
    //   810: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   813: aload 11
    //   815: astore 12
    //   817: aload 13
    //   819: ifnull +446 -> 1265
    //   822: aload 13
    //   824: invokevirtual 366	java/io/FileInputStream:close	()V
    //   827: goto -433 -> 394
    //   830: fload 5
    //   832: fstore 4
    //   834: aload 11
    //   836: astore 12
    //   838: aload 16
    //   840: fload 5
    //   842: fload 5
    //   844: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   847: fload 5
    //   849: fstore 4
    //   851: aload 11
    //   853: astore 12
    //   855: aload 16
    //   857: ldc_w 450
    //   860: invokevirtual 454	android/graphics/Matrix:postRotate	(F)Z
    //   863: pop
    //   864: goto -484 -> 380
    //   867: astore_1
    //   868: aload 13
    //   870: astore_3
    //   871: aload_3
    //   872: ifnull +7 -> 879
    //   875: aload_3
    //   876: invokevirtual 366	java/io/FileInputStream:close	()V
    //   879: aload_1
    //   880: athrow
    //   881: fload 5
    //   883: fneg
    //   884: fstore 6
    //   886: fload 5
    //   888: fstore 4
    //   890: aload 11
    //   892: astore 12
    //   894: aload 16
    //   896: fload 5
    //   898: fload 6
    //   900: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   903: goto -523 -> 380
    //   906: fload 5
    //   908: fstore 4
    //   910: aload 11
    //   912: astore 12
    //   914: aload 16
    //   916: fload 5
    //   918: fload 5
    //   920: fneg
    //   921: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   924: fload 5
    //   926: fstore 4
    //   928: aload 11
    //   930: astore 12
    //   932: aload 16
    //   934: ldc_w 455
    //   937: invokevirtual 454	android/graphics/Matrix:postRotate	(F)Z
    //   940: pop
    //   941: goto -561 -> 380
    //   944: fload 5
    //   946: fstore 4
    //   948: aload 11
    //   950: astore 12
    //   952: aload 16
    //   954: fload 5
    //   956: fload 5
    //   958: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   961: fload 5
    //   963: fstore 4
    //   965: aload 11
    //   967: astore 12
    //   969: aload 16
    //   971: ldc_w 455
    //   974: invokevirtual 454	android/graphics/Matrix:postRotate	(F)Z
    //   977: pop
    //   978: goto -598 -> 380
    //   981: fload 5
    //   983: fstore 4
    //   985: aload 11
    //   987: astore 12
    //   989: aload 16
    //   991: fload 5
    //   993: fneg
    //   994: fload 5
    //   996: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   999: fload 5
    //   1001: fstore 4
    //   1003: aload 11
    //   1005: astore 12
    //   1007: aload 16
    //   1009: ldc_w 455
    //   1012: invokevirtual 454	android/graphics/Matrix:postRotate	(F)Z
    //   1015: pop
    //   1016: goto -636 -> 380
    //   1019: fload 5
    //   1021: fstore 4
    //   1023: aload 11
    //   1025: astore 12
    //   1027: aload 16
    //   1029: fload 5
    //   1031: fload 5
    //   1033: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   1036: fload 5
    //   1038: fstore 4
    //   1040: aload 11
    //   1042: astore 12
    //   1044: aload 16
    //   1046: ldc_w 456
    //   1049: invokevirtual 454	android/graphics/Matrix:postRotate	(F)Z
    //   1052: pop
    //   1053: goto -673 -> 380
    //   1056: iload 8
    //   1058: ifne +16 -> 1074
    //   1061: aload_3
    //   1062: ifnull +12 -> 1074
    //   1065: aload_3
    //   1066: getfield 96	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1069: iconst_1
    //   1070: invokevirtual 462	android/os/Handler:sendEmptyMessage	(I)Z
    //   1073: pop
    //   1074: aconst_null
    //   1075: astore 11
    //   1077: goto -574 -> 503
    //   1080: astore 11
    //   1082: aconst_null
    //   1083: astore_1
    //   1084: aload 13
    //   1086: astore_3
    //   1087: aload 11
    //   1089: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   1092: aconst_null
    //   1093: astore 12
    //   1095: aload_3
    //   1096: ifnull +7 -> 1103
    //   1099: aload_3
    //   1100: invokevirtual 448	java/io/ByteArrayOutputStream:close	()V
    //   1103: aload 12
    //   1105: astore 11
    //   1107: aload_1
    //   1108: ifnull -376 -> 732
    //   1111: aload_1
    //   1112: invokevirtual 449	java/io/FileOutputStream:close	()V
    //   1115: aload 12
    //   1117: astore 11
    //   1119: goto -387 -> 732
    //   1122: aload 11
    //   1124: ifnull +8 -> 1132
    //   1127: aload 11
    //   1129: invokevirtual 448	java/io/ByteArrayOutputStream:close	()V
    //   1132: aload_3
    //   1133: ifnull +7 -> 1140
    //   1136: aload_3
    //   1137: invokevirtual 449	java/io/FileOutputStream:close	()V
    //   1140: aload_1
    //   1141: athrow
    //   1142: astore_1
    //   1143: aload 12
    //   1145: astore_3
    //   1146: goto -24 -> 1122
    //   1149: astore_1
    //   1150: aload 12
    //   1152: astore_3
    //   1153: goto -31 -> 1122
    //   1156: astore 12
    //   1158: aload_1
    //   1159: astore_3
    //   1160: aload 12
    //   1162: astore_1
    //   1163: goto -41 -> 1122
    //   1166: astore 13
    //   1168: aload_1
    //   1169: astore 11
    //   1171: aload_3
    //   1172: astore 12
    //   1174: aload 13
    //   1176: astore_1
    //   1177: aload 11
    //   1179: astore_3
    //   1180: aload 12
    //   1182: astore 11
    //   1184: goto -62 -> 1122
    //   1187: astore_1
    //   1188: aload 11
    //   1190: astore_3
    //   1191: aconst_null
    //   1192: astore 12
    //   1194: aload_1
    //   1195: astore 11
    //   1197: aload 12
    //   1199: astore_1
    //   1200: goto -113 -> 1087
    //   1203: astore 12
    //   1205: aconst_null
    //   1206: astore_1
    //   1207: aload 11
    //   1209: astore_3
    //   1210: aload 12
    //   1212: astore 11
    //   1214: goto -127 -> 1087
    //   1217: astore 12
    //   1219: aload 11
    //   1221: astore_3
    //   1222: aload 12
    //   1224: astore 11
    //   1226: goto -139 -> 1087
    //   1229: astore_1
    //   1230: aconst_null
    //   1231: astore_3
    //   1232: goto -361 -> 871
    //   1235: astore_1
    //   1236: aload 13
    //   1238: astore_3
    //   1239: goto -368 -> 871
    //   1242: astore 13
    //   1244: fload 5
    //   1246: fstore 4
    //   1248: aload 12
    //   1250: astore 13
    //   1252: goto -448 -> 804
    //   1255: aconst_null
    //   1256: astore_3
    //   1257: aconst_null
    //   1258: astore_1
    //   1259: goto -551 -> 708
    //   1262: goto -759 -> 503
    //   1265: aload 12
    //   1267: astore 11
    //   1269: goto -875 -> 394
    //   1272: aconst_null
    //   1273: astore 11
    //   1275: aload 11
    //   1277: areturn
    //   1278: iconst_1
    //   1279: istore 7
    //   1281: goto -1103 -> 178
    //   1284: fload 4
    //   1286: f2d
    //   1287: ldc2_w 464
    //   1290: dcmpg
    //   1291: ifge +56 -> 1347
    //   1294: ldc_w 466
    //   1297: fstore 5
    //   1299: iload 9
    //   1301: tableswitch	default:+43 -> 1344, 2:+-524->777, 3:+-471->830, 4:+-420->881, 5:+-395->906, 6:+-357->944, 7:+-320->981, 8:+-282->1019
    //   1345: <illegal opcode>
    //   1346: aload_1
    //   1347: fconst_1
    //   1348: fstore 5
    //   1350: goto -51 -> 1299
    //   1353: astore_1
    //   1354: aconst_null
    //   1355: astore 11
    //   1357: aload 12
    //   1359: astore_3
    //   1360: goto -238 -> 1122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1363	0	paramInt1	int
    //   0	1363	1	paramString	String
    //   0	1363	2	paramInt2	int
    //   0	1363	3	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   261	1024	4	f1	float
    //   137	1212	5	f2	float
    //   323	576	6	f3	float
    //   140	1140	7	j	int
    //   71	986	8	k	int
    //   146	1154	9	m	int
    //   78	109	10	n	int
    //   100	682	11	localObject1	Object
    //   798	1	11	localIOException1	java.io.IOException
    //   802	274	11	localObject2	Object
    //   1080	8	11	localIOException2	java.io.IOException
    //   1105	251	11	localObject3	Object
    //   19	1132	12	localObject4	Object
    //   1156	5	12	localObject5	Object
    //   1172	26	12	localTroopHWJsPlugin	TroopHWJsPlugin
    //   1203	8	12	localIOException3	java.io.IOException
    //   1217	141	12	localIOException4	java.io.IOException
    //   257	828	13	localObject6	Object
    //   1166	71	13	localObject7	Object
    //   1242	1	13	localIOException5	java.io.IOException
    //   1250	1	13	localIOException6	java.io.IOException
    //   125	415	14	localBitmap	Bitmap
    //   28	552	15	localStringBuilder	StringBuilder
    //   134	911	16	localMatrix	android.graphics.Matrix
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
    //   713	718	297	java/lang/OutOfMemoryError
    //   725	729	297	java/lang/OutOfMemoryError
    //   822	827	297	java/lang/OutOfMemoryError
    //   875	879	297	java/lang/OutOfMemoryError
    //   879	881	297	java/lang/OutOfMemoryError
    //   1099	1103	297	java/lang/OutOfMemoryError
    //   1111	1115	297	java/lang/OutOfMemoryError
    //   1127	1132	297	java/lang/OutOfMemoryError
    //   1136	1140	297	java/lang/OutOfMemoryError
    //   1140	1142	297	java/lang/OutOfMemoryError
    //   267	277	798	java/io/IOException
    //   333	341	798	java/io/IOException
    //   349	356	798	java/io/IOException
    //   371	380	798	java/io/IOException
    //   747	755	798	java/io/IOException
    //   763	770	798	java/io/IOException
    //   785	795	798	java/io/IOException
    //   838	847	798	java/io/IOException
    //   855	864	798	java/io/IOException
    //   894	903	798	java/io/IOException
    //   914	924	798	java/io/IOException
    //   932	941	798	java/io/IOException
    //   952	961	798	java/io/IOException
    //   969	978	798	java/io/IOException
    //   989	999	798	java/io/IOException
    //   1007	1016	798	java/io/IOException
    //   1027	1036	798	java/io/IOException
    //   1044	1053	798	java/io/IOException
    //   267	277	867	finally
    //   333	341	867	finally
    //   349	356	867	finally
    //   371	380	867	finally
    //   747	755	867	finally
    //   763	770	867	finally
    //   785	795	867	finally
    //   838	847	867	finally
    //   855	864	867	finally
    //   894	903	867	finally
    //   914	924	867	finally
    //   932	941	867	finally
    //   952	961	867	finally
    //   969	978	867	finally
    //   989	999	867	finally
    //   1007	1016	867	finally
    //   1027	1036	867	finally
    //   1044	1053	867	finally
    //   459	471	1080	java/io/IOException
    //   1065	1074	1080	java/io/IOException
    //   471	484	1142	finally
    //   488	503	1142	finally
    //   503	534	1149	finally
    //   539	544	1149	finally
    //   548	585	1149	finally
    //   585	625	1149	finally
    //   630	694	1149	finally
    //   694	703	1156	finally
    //   1087	1092	1166	finally
    //   471	484	1187	java/io/IOException
    //   488	503	1187	java/io/IOException
    //   503	534	1203	java/io/IOException
    //   539	544	1203	java/io/IOException
    //   548	585	1203	java/io/IOException
    //   585	625	1203	java/io/IOException
    //   630	694	1203	java/io/IOException
    //   694	703	1217	java/io/IOException
    //   142	148	1229	finally
    //   183	189	1229	finally
    //   189	195	1229	finally
    //   232	259	1229	finally
    //   307	313	1229	finally
    //   804	813	1235	finally
    //   142	148	1242	java/io/IOException
    //   183	189	1242	java/io/IOException
    //   189	195	1242	java/io/IOException
    //   232	259	1242	java/io/IOException
    //   307	313	1242	java/io/IOException
    //   459	471	1353	finally
    //   1065	1074	1353	finally
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    Object localObject = "";
    if (kzy.b(BaseApplicationImpl.getContext())) {}
    BaseApplication localBaseApplication;
    String str;
    Intent localIntent;
    do
    {
      return localObject;
      localBaseApplication = BaseApplicationImpl.getContext();
      localObject = new File(ajed.ba);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        bbmy.a(localBaseApplication, 2131653216, 0).a();
      }
      str = ajed.ba + System.currentTimeMillis() + ".jpg";
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
      bbmy.a(localBaseApplication, 2131625032, 0).a();
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
    //   9: new 384	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 387	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 393	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 397	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 401	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 407	baaw:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 519	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 448	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 515	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 519	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 448	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 519	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 448	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 463	java/io/IOException:printStackTrace	()V
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
          localStringBuilder.append(baaw.encodeToString(arrayOfByte2, 2));
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
      localStringBuilder.append(baaw.encodeToString(arrayOfByte1, 2));
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
    localObject = new File(ajed.bq);
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
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      return;
    }
    begr localbegr = begr.a(this.mRuntime.a());
    localbegr.a(2131653438, 1);
    localbegr.a(2131653427, 1);
    localbegr.c(2131625035);
    localbegr.a(new bgoc(this, paramInt, localbegr));
    localbegr.show();
    this.jdField_a_of_type_Begr = localbegr;
  }
  
  public bgof a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, bgoe parambgoe, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    bgof localbgof = new bgof(paramTroopHWJsPlugin);
    localbgof.jdField_a_of_type_Int = paramInt1;
    localbgof.jdField_a_of_type_Bgoe = parambgoe;
    localbgof.jdField_a_of_type_Bgny = new bgny(paramTroopHWJsPlugin.mRuntime.a(), paramString, parambgoe.jdField_b_of_type_JavaLangString);
    localbgof.jdField_a_of_type_Bgny.a(localbgof.jdField_a_of_type_Bgnx);
    localbgof.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    localbgof.jdField_b_of_type_JavaLangString = paramString;
    localbgof.jdField_b_of_type_Int = paramInt2;
    return localbgof;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = bcdu.d(paramString2) + azgh.a(paramString2);
    paramString1 = ajed.br + paramString1 + File.separator;
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
        ThreadManager.post(new TroopHWJsPlugin.4(this, paramString), 2, null, false);
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
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934597L) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bgoj.a();
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
    //   7: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +8 -> 18
    //   13: aload 4
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 242	org/json/JSONObject
    //   23: dup
    //   24: aload 5
    //   26: iconst_0
    //   27: aaload
    //   28: invokespecial 802	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +102 -> 135
    //   36: aload_1
    //   37: ldc_w 804
    //   40: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 15
    //   45: aload_1
    //   46: ldc_w 622
    //   49: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 16
    //   54: aload_0
    //   55: aload 15
    //   57: putfield 264	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   60: aload_0
    //   61: aload 16
    //   63: putfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   71: aload_0
    //   72: aload_1
    //   73: ldc_w 809
    //   76: ldc_w 471
    //   79: invokevirtual 811	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: putfield 813	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload_0
    //   86: aload_1
    //   87: ldc_w 815
    //   90: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   93: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   96: aload_0
    //   97: aload_1
    //   98: ldc_w 820
    //   101: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   104: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   107: aload_0
    //   108: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: sipush 540
    //   118: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   121: aload_0
    //   122: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   125: ifne +10 -> 135
    //   128: aload_0
    //   129: sipush 540
    //   132: putfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   135: ldc_w 822
    //   138: aload 4
    //   140: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +79 -> 222
    //   146: aload_0
    //   147: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   150: invokevirtual 548	bbac:a	()Landroid/app/Activity;
    //   153: astore_1
    //   154: new 131	android/content/Intent
    //   157: dup
    //   158: invokespecial 132	android/content/Intent:<init>	()V
    //   161: astore_2
    //   162: aload_2
    //   163: new 824	android/content/ComponentName
    //   166: dup
    //   167: aload_1
    //   168: ldc_w 826
    //   171: invokespecial 829	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   174: invokevirtual 833	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   177: pop
    //   178: aload_2
    //   179: ldc_w 622
    //   182: aload_0
    //   183: getfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   186: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   189: pop
    //   190: aload_0
    //   191: getfield 264	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   194: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +16 -> 213
    //   200: aload_1
    //   201: aload_2
    //   202: invokevirtual 837	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -178 -> 32
    //   213: aload_0
    //   214: aload_2
    //   215: iconst_1
    //   216: invokevirtual 840	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   219: goto -14 -> 205
    //   222: ldc_w 842
    //   225: aload 4
    //   227: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +107 -> 337
    //   233: aload_1
    //   234: ifnull +2302 -> 2536
    //   237: aload_1
    //   238: ldc_w 620
    //   241: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   244: istore 6
    //   246: aload_0
    //   247: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   250: iconst_m1
    //   251: if_icmpne +36 -> 287
    //   254: aload_0
    //   255: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   258: iload 6
    //   260: aload_0
    //   261: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   264: iload 6
    //   266: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: invokevirtual 846	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 266	java/lang/String
    //   275: invokevirtual 848	bgoj:a	(ILjava/lang/String;)V
    //   278: aload_0
    //   279: iload 6
    //   281: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   284: goto -79 -> 205
    //   287: iload 6
    //   289: aload_0
    //   290: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   293: if_icmpeq -88 -> 205
    //   296: aload_0
    //   297: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   300: invokevirtual 789	bgoj:a	()Z
    //   303: pop
    //   304: aload_0
    //   305: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   308: iload 6
    //   310: aload_0
    //   311: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   314: iload 6
    //   316: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: invokevirtual 846	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 266	java/lang/String
    //   325: invokevirtual 848	bgoj:a	(ILjava/lang/String;)V
    //   328: aload_0
    //   329: iload 6
    //   331: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   334: goto -129 -> 205
    //   337: ldc_w 850
    //   340: aload 4
    //   342: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   345: ifeq +52 -> 397
    //   348: iconst_m1
    //   349: istore 6
    //   351: aload_1
    //   352: ifnull +12 -> 364
    //   355: aload_1
    //   356: ldc_w 620
    //   359: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   362: istore 6
    //   364: aload_0
    //   365: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   368: iconst_m1
    //   369: if_icmpeq -164 -> 205
    //   372: iload 6
    //   374: aload_0
    //   375: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   378: if_icmpne -173 -> 205
    //   381: aload_0
    //   382: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   385: invokevirtual 789	bgoj:a	()Z
    //   388: pop
    //   389: aload_0
    //   390: iconst_m1
    //   391: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   394: goto -189 -> 205
    //   397: ldc_w 852
    //   400: aload 4
    //   402: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   405: ifeq +226 -> 631
    //   408: bipush 10
    //   410: istore 7
    //   412: iconst_0
    //   413: istore 6
    //   415: aload_1
    //   416: ifnull +34 -> 450
    //   419: aload_1
    //   420: ldc_w 854
    //   423: bipush 10
    //   425: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   428: istore 7
    //   430: aload_0
    //   431: aload_1
    //   432: ldc_w 815
    //   435: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   438: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   441: aload_1
    //   442: ldc_w 859
    //   445: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   448: istore 6
    //   450: iload 6
    //   452: iconst_1
    //   453: if_icmpne +35 -> 488
    //   456: aload_0
    //   457: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   460: ifnonnull +17 -> 477
    //   463: aconst_null
    //   464: astore_1
    //   465: aload_0
    //   466: aload_1
    //   467: iconst_2
    //   468: invokestatic 861	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/app/Activity;I)Ljava/lang/String;
    //   471: putfield 863	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   474: goto -269 -> 205
    //   477: aload_0
    //   478: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   481: invokevirtual 548	bbac:a	()Landroid/app/Activity;
    //   484: astore_1
    //   485: goto -20 -> 465
    //   488: iload 6
    //   490: iconst_2
    //   491: if_icmpne +12 -> 503
    //   494: aload_0
    //   495: iload 7
    //   497: invokevirtual 865	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   500: goto -295 -> 205
    //   503: iload 6
    //   505: iconst_3
    //   506: if_icmpne +116 -> 622
    //   509: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +30 -> 542
    //   515: ldc_w 279
    //   518: iconst_2
    //   519: new 34	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 867
    //   529: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_1
    //   533: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: aload_0
    //   543: getfield 264	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   546: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   549: ifne +13 -> 562
    //   552: aload_0
    //   553: getfield 813	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   556: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   559: ifeq +54 -> 613
    //   562: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +46 -> 611
    //   568: ldc_w 279
    //   571: iconst_2
    //   572: new 34	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 874
    //   582: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_0
    //   586: getfield 264	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   589: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: ldc_w 876
    //   595: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_0
    //   599: getfield 813	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   602: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: iconst_1
    //   612: ireturn
    //   613: aload_0
    //   614: iload 7
    //   616: invokevirtual 877	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(I)V
    //   619: goto -414 -> 205
    //   622: aload_0
    //   623: iload 7
    //   625: invokespecial 878	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   628: goto -423 -> 205
    //   631: ldc_w 880
    //   634: aload 4
    //   636: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   664: ldc_w 882
    //   667: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   670: astore 5
    //   672: aload_1
    //   673: ldc_w 884
    //   676: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   679: astore 4
    //   681: aload_1
    //   682: ldc_w 809
    //   685: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   688: astore 15
    //   690: aload_1
    //   691: ldc_w 886
    //   694: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: astore_3
    //   698: aload_1
    //   699: ldc_w 888
    //   702: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   705: astore_2
    //   706: aload 15
    //   708: astore_1
    //   709: aload_3
    //   710: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   713: ifne +12 -> 725
    //   716: aload_3
    //   717: invokestatic 893	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   720: invokevirtual 896	java/lang/Long:longValue	()J
    //   723: lstore 8
    //   725: aload_2
    //   726: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifne +12 -> 741
    //   732: aload_2
    //   733: invokestatic 899	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   736: invokevirtual 902	java/lang/Integer:intValue	()I
    //   739: istore 6
    //   741: aload_1
    //   742: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   745: ifne +66 -> 811
    //   748: aload_0
    //   749: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wis	Lwis;
    //   752: aload_1
    //   753: invokestatic 893	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   756: invokevirtual 896	java/lang/Long:longValue	()J
    //   759: aload 4
    //   761: aload 5
    //   763: lload 8
    //   765: iload 6
    //   767: aload_0
    //   768: invokevirtual 907	wis:a	(JLjava/lang/String;Ljava/lang/String;JILwiu;)V
    //   771: goto -566 -> 205
    //   774: astore_2
    //   775: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   778: ifeq -573 -> 205
    //   781: ldc_w 279
    //   784: iconst_2
    //   785: new 34	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 909
    //   795: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_1
    //   799: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 911	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: goto -603 -> 205
    //   811: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   814: ifeq -609 -> 205
    //   817: ldc_w 279
    //   820: iconst_2
    //   821: ldc_w 913
    //   824: invokestatic 911	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   827: goto -622 -> 205
    //   830: ldc_w 915
    //   833: aload 4
    //   835: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   838: ifeq +77 -> 915
    //   841: ldc_w 471
    //   844: astore_2
    //   845: aload_1
    //   846: ifnull +11 -> 857
    //   849: aload_1
    //   850: ldc_w 628
    //   853: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   856: astore_2
    //   857: aload_0
    //   858: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   861: ifnonnull +19 -> 880
    //   864: aload_0
    //   865: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   868: aload_2
    //   869: invokevirtual 917	bgoj:b	(Ljava/lang/String;)V
    //   872: aload_0
    //   873: aload_2
    //   874: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   877: goto -672 -> 205
    //   880: aload_0
    //   881: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   884: aload_2
    //   885: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   888: ifne -683 -> 205
    //   891: aload_0
    //   892: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   895: invokevirtual 789	bgoj:a	()Z
    //   898: pop
    //   899: aload_0
    //   900: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   903: aload_2
    //   904: invokevirtual 917	bgoj:b	(Ljava/lang/String;)V
    //   907: aload_0
    //   908: aload_2
    //   909: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   912: goto -707 -> 205
    //   915: ldc_w 919
    //   918: aload 4
    //   920: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   923: ifeq +53 -> 976
    //   926: ldc_w 471
    //   929: astore_2
    //   930: aload_1
    //   931: ifnull +11 -> 942
    //   934: aload_1
    //   935: ldc_w 628
    //   938: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   941: astore_2
    //   942: aload_0
    //   943: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   946: ifnull -741 -> 205
    //   949: aload_0
    //   950: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   953: aload_2
    //   954: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   957: ifeq -752 -> 205
    //   960: aload_0
    //   961: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   964: invokevirtual 789	bgoj:a	()Z
    //   967: pop
    //   968: aload_0
    //   969: aconst_null
    //   970: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   973: goto -768 -> 205
    //   976: ldc_w 921
    //   979: aload 4
    //   981: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   984: ifeq +23 -> 1007
    //   987: aload_0
    //   988: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   991: aload_0
    //   992: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   995: invokevirtual 583	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   998: invokevirtual 924	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1001: invokevirtual 926	bgoj:e	(Ljava/lang/String;)V
    //   1004: goto -799 -> 205
    //   1007: ldc_w 928
    //   1010: aload 4
    //   1012: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1015: ifeq +39 -> 1054
    //   1018: aload_1
    //   1019: ifnull +25 -> 1044
    //   1022: aload_0
    //   1023: aload_1
    //   1024: ldc_w 930
    //   1027: invokevirtual 934	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1030: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1033: aload_0
    //   1034: aload_1
    //   1035: ldc_w 936
    //   1038: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1041: putfield 82	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1044: aload_0
    //   1045: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgoj	Lbgoj;
    //   1048: invokevirtual 938	bgoj:b	()V
    //   1051: goto -846 -> 205
    //   1054: ldc_w 940
    //   1057: aload 4
    //   1059: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1062: ifeq +25 -> 1087
    //   1065: new 942	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1068: dup
    //   1069: aload_0
    //   1070: aload_2
    //   1071: invokestatic 945	axoa:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: invokespecial 946	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1077: bipush 8
    //   1079: aconst_null
    //   1080: iconst_0
    //   1081: invokestatic 761	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1084: goto -879 -> 205
    //   1087: ldc_w 948
    //   1090: aload 4
    //   1092: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1095: ifeq +54 -> 1149
    //   1098: aload_1
    //   1099: ifnull -894 -> 205
    //   1102: aload_1
    //   1103: ldc_w 628
    //   1106: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1109: astore_2
    //   1110: aload_1
    //   1111: ldc_w 950
    //   1114: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1117: astore_3
    //   1118: aload_0
    //   1119: aload_1
    //   1120: ldc_w 804
    //   1123: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1126: putfield 768	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1129: aload_0
    //   1130: aload_3
    //   1131: aload_2
    //   1132: invokevirtual 771	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1135: astore_1
    //   1136: aload_0
    //   1137: getfield 952	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgnz	Lbgnz;
    //   1140: aload_2
    //   1141: aload_1
    //   1142: aload_0
    //   1143: invokevirtual 957	bgnz:a	(Ljava/lang/String;Ljava/lang/String;Lbgob;)V
    //   1146: goto -941 -> 205
    //   1149: ldc_w 959
    //   1152: aload 4
    //   1154: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1157: ifeq +26 -> 1183
    //   1160: aload_1
    //   1161: ifnull -956 -> 205
    //   1164: aload_1
    //   1165: ldc_w 628
    //   1168: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1171: astore_1
    //   1172: aload_0
    //   1173: getfield 952	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bgnz	Lbgnz;
    //   1176: aload_1
    //   1177: invokevirtual 960	bgnz:a	(Ljava/lang/String;)V
    //   1180: goto -975 -> 205
    //   1183: ldc_w 962
    //   1186: aload 4
    //   1188: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1191: ifeq +194 -> 1385
    //   1194: aload_1
    //   1195: ifnull -990 -> 205
    //   1198: aload_1
    //   1199: ldc_w 950
    //   1202: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1205: astore 4
    //   1207: aload_1
    //   1208: ldc_w 964
    //   1211: invokevirtual 968	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1214: astore 5
    //   1216: aload_1
    //   1217: ldc_w 804
    //   1220: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1223: astore_2
    //   1224: new 242	org/json/JSONObject
    //   1227: dup
    //   1228: invokespecial 618	org/json/JSONObject:<init>	()V
    //   1231: astore_3
    //   1232: new 970	org/json/JSONArray
    //   1235: dup
    //   1236: invokespecial 971	org/json/JSONArray:<init>	()V
    //   1239: astore 15
    //   1241: aload 5
    //   1243: invokevirtual 973	org/json/JSONArray:length	()I
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
    //   1269: invokevirtual 976	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1272: invokevirtual 978	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1275: invokevirtual 981	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1278: pop
    //   1279: iload 6
    //   1281: iconst_1
    //   1282: iadd
    //   1283: istore 6
    //   1285: goto -34 -> 1251
    //   1288: aload_3
    //   1289: ldc_w 983
    //   1292: aload 15
    //   1294: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1297: pop
    //   1298: aload_3
    //   1299: invokevirtual 267	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1302: astore_3
    //   1303: aload_0
    //   1304: aload_2
    //   1305: iconst_1
    //   1306: anewarray 266	java/lang/String
    //   1309: dup
    //   1310: iconst_0
    //   1311: aload_3
    //   1312: aastore
    //   1313: invokevirtual 271	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1316: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1319: ifeq -1114 -> 205
    //   1322: ldc_w 279
    //   1325: iconst_2
    //   1326: new 34	java/lang/StringBuilder
    //   1329: dup
    //   1330: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1333: ldc_w 985
    //   1336: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: aload_1
    //   1340: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1343: ldc_w 987
    //   1346: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: aload_3
    //   1350: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1356: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1359: goto -1154 -> 205
    //   1362: astore 4
    //   1364: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1367: ifeq -69 -> 1298
    //   1370: ldc_w 279
    //   1373: iconst_2
    //   1374: ldc_w 985
    //   1377: aload 4
    //   1379: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1382: goto -84 -> 1298
    //   1385: ldc_w 992
    //   1388: aload 4
    //   1390: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1393: ifeq +68 -> 1461
    //   1396: aload_1
    //   1397: ifnull -1192 -> 205
    //   1400: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1403: ifeq +30 -> 1433
    //   1406: ldc_w 279
    //   1409: iconst_2
    //   1410: new 34	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1417: ldc_w 994
    //   1420: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: aload_1
    //   1424: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1427: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1430: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1433: aload_1
    //   1434: ldc_w 996
    //   1437: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1440: astore_2
    //   1441: aload_1
    //   1442: ldc_w 998
    //   1445: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1448: astore_1
    //   1449: aload_0
    //   1450: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wis	Lwis;
    //   1453: aload_2
    //   1454: aload_1
    //   1455: invokevirtual 1001	wis:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1458: goto -1253 -> 205
    //   1461: ldc_w 1003
    //   1464: aload 4
    //   1466: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1469: ifeq +58 -> 1527
    //   1472: aload_1
    //   1473: ifnull +54 -> 1527
    //   1476: aload_1
    //   1477: ldc_w 630
    //   1480: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1483: pop
    //   1484: aload_1
    //   1485: ldc_w 620
    //   1488: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1491: istore 6
    //   1493: aload_0
    //   1494: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1497: iload 6
    //   1499: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1502: invokevirtual 846	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1505: checkcast 573	bgof
    //   1508: astore_1
    //   1509: aload_1
    //   1510: ifnull -1305 -> 205
    //   1513: aload_1
    //   1514: getfield 1004	bgof:jdField_a_of_type_Boolean	Z
    //   1517: ifne -1312 -> 205
    //   1520: aload_1
    //   1521: invokevirtual 1005	bgof:b	()V
    //   1524: goto -1319 -> 205
    //   1527: ldc_w 1007
    //   1530: aload 4
    //   1532: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1535: ifeq +62 -> 1597
    //   1538: aload_1
    //   1539: ifnull +58 -> 1597
    //   1542: aload_1
    //   1543: ldc_w 630
    //   1546: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1549: pop
    //   1550: aload_1
    //   1551: ldc_w 620
    //   1554: invokevirtual 818	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1557: istore 6
    //   1559: aload_0
    //   1560: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1563: iload 6
    //   1565: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1568: invokevirtual 846	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1571: checkcast 573	bgof
    //   1574: astore_1
    //   1575: aload_1
    //   1576: ifnull -1371 -> 205
    //   1579: aload_1
    //   1580: getfield 1004	bgof:jdField_a_of_type_Boolean	Z
    //   1583: ifeq -1378 -> 205
    //   1586: aload_1
    //   1587: getfield 1010	bgof:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1590: iconst_1
    //   1591: invokevirtual 1016	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1594: goto -1389 -> 205
    //   1597: ldc_w 1018
    //   1600: aload 4
    //   1602: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1605: ifeq +83 -> 1688
    //   1608: aload_1
    //   1609: ifnull -1404 -> 205
    //   1612: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1615: ifeq +24 -> 1639
    //   1618: ldc_w 279
    //   1621: iconst_2
    //   1622: iconst_2
    //   1623: anewarray 142	java/lang/Object
    //   1626: dup
    //   1627: iconst_0
    //   1628: ldc_w 1020
    //   1631: aastore
    //   1632: dup
    //   1633: iconst_1
    //   1634: aload_1
    //   1635: aastore
    //   1636: invokestatic 418	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1639: aload_1
    //   1640: ldc_w 950
    //   1643: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1646: astore_2
    //   1647: aload_1
    //   1648: ldc_w 630
    //   1651: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1654: astore_1
    //   1655: aload_0
    //   1656: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wis	Lwis;
    //   1659: aload_2
    //   1660: aload_1
    //   1661: invokevirtual 1022	wis:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1664: goto -1459 -> 205
    //   1667: astore_1
    //   1668: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1671: ifeq -1466 -> 205
    //   1674: ldc_w 279
    //   1677: iconst_2
    //   1678: ldc_w 1024
    //   1681: aload_1
    //   1682: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1685: goto -1480 -> 205
    //   1688: ldc_w 1026
    //   1691: aload 4
    //   1693: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1696: ifeq +167 -> 1863
    //   1699: aload_1
    //   1700: ifnull -1495 -> 205
    //   1703: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1706: ifeq +30 -> 1736
    //   1709: ldc_w 279
    //   1712: iconst_2
    //   1713: new 34	java/lang/StringBuilder
    //   1716: dup
    //   1717: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1720: ldc_w 1028
    //   1723: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: aload_1
    //   1727: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1730: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1733: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1736: aload_1
    //   1737: ldc_w 620
    //   1740: iconst_0
    //   1741: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1744: istore 6
    //   1746: aload_0
    //   1747: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1750: iload 6
    //   1752: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1755: invokevirtual 846	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1758: checkcast 573	bgof
    //   1761: astore_2
    //   1762: aload_2
    //   1763: ifnull +70 -> 1833
    //   1766: aload_2
    //   1767: getfield 602	bgof:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1770: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1773: ifne +60 -> 1833
    //   1776: new 685	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1779: dup
    //   1780: invokespecial 686	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1783: astore_1
    //   1784: aload_1
    //   1785: aload_2
    //   1786: getfield 602	bgof:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1789: invokevirtual 708	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1792: new 131	android/content/Intent
    //   1795: dup
    //   1796: aload_0
    //   1797: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   1800: invokevirtual 548	bbac:a	()Landroid/app/Activity;
    //   1803: ldc_w 722
    //   1806: invokespecial 1029	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1809: astore_2
    //   1810: aload_2
    //   1811: ldc_w 724
    //   1814: aload_1
    //   1815: invokevirtual 727	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1818: pop
    //   1819: aload_0
    //   1820: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   1823: invokevirtual 548	bbac:a	()Landroid/app/Activity;
    //   1826: aload_2
    //   1827: invokevirtual 837	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1830: goto -1625 -> 205
    //   1833: ldc_w 279
    //   1836: iconst_1
    //   1837: new 34	java/lang/StringBuilder
    //   1840: dup
    //   1841: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1844: ldc_w 1031
    //   1847: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: aload_2
    //   1851: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: invokestatic 911	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1860: goto -1655 -> 205
    //   1863: ldc_w 1033
    //   1866: aload 4
    //   1868: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1871: ifeq +18 -> 1889
    //   1874: aload_0
    //   1875: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1878: invokevirtual 1036	java/util/HashMap:clear	()V
    //   1881: aload_0
    //   1882: iconst_1
    //   1883: putfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   1886: goto -1681 -> 205
    //   1889: ldc_w 1038
    //   1892: aload 4
    //   1894: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1897: ifeq +77 -> 1974
    //   1900: aload_1
    //   1901: ifnull -1696 -> 205
    //   1904: aload_1
    //   1905: ldc_w 620
    //   1908: iconst_0
    //   1909: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1912: istore 6
    //   1914: aload_0
    //   1915: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1918: iload 6
    //   1920: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1923: invokevirtual 846	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1926: checkcast 573	bgof
    //   1929: astore_1
    //   1930: aload_1
    //   1931: ifnull -1726 -> 205
    //   1934: aload_1
    //   1935: getfield 602	bgof:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1938: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1941: ifne -1736 -> 205
    //   1944: new 303	java/io/File
    //   1947: dup
    //   1948: aload_1
    //   1949: getfield 602	bgof:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1952: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   1955: astore_2
    //   1956: aload_0
    //   1957: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wis	Lwis;
    //   1960: aload_1
    //   1961: getfield 602	bgof:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1964: aload_2
    //   1965: invokevirtual 1039	java/io/File:getName	()Ljava/lang/String;
    //   1968: invokevirtual 1001	wis:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1971: goto -1766 -> 205
    //   1974: ldc_w 1041
    //   1977: aload 4
    //   1979: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1982: ifeq +94 -> 2076
    //   1985: aload_1
    //   1986: ifnull +78 -> 2064
    //   1989: ldc_w 279
    //   1992: ldc_w 1043
    //   1995: aload_1
    //   1996: invokestatic 1048	urk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   1999: aload_1
    //   2000: ldc_w 1050
    //   2003: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2006: astore_2
    //   2007: aload_1
    //   2008: ldc_w 1052
    //   2011: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2014: astore_3
    //   2015: aload_1
    //   2016: ldc_w 1054
    //   2019: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2022: astore 4
    //   2024: aload_1
    //   2025: ldc_w 1056
    //   2028: invokevirtual 807	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2031: astore_1
    //   2032: aload_0
    //   2033: aload_0
    //   2034: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   2037: invokevirtual 548	bbac:a	()Landroid/app/Activity;
    //   2040: aload_2
    //   2041: aload_3
    //   2042: aload_0
    //   2043: getfield 264	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2046: aload 4
    //   2048: aload_0
    //   2049: getfield 813	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2052: aload_1
    //   2053: invokestatic 1061	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2056: bipush 6
    //   2058: invokevirtual 840	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2061: goto -1856 -> 205
    //   2064: ldc_w 279
    //   2067: ldc_w 1063
    //   2070: invokestatic 1064	urk:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2073: goto -1868 -> 205
    //   2076: ldc_w 1066
    //   2079: aload 4
    //   2081: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2084: ifeq +186 -> 2270
    //   2087: new 242	org/json/JSONObject
    //   2090: dup
    //   2091: aload 5
    //   2093: iconst_0
    //   2094: aaload
    //   2095: invokespecial 802	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2098: ldc_w 1068
    //   2101: invokevirtual 1069	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2104: astore_2
    //   2105: aload_2
    //   2106: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2109: istore 14
    //   2111: iload 14
    //   2113: ifne -1908 -> 205
    //   2116: lconst_0
    //   2117: lstore 8
    //   2119: aload_2
    //   2120: invokestatic 1072	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2123: lstore 10
    //   2125: lload 10
    //   2127: lstore 8
    //   2129: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2132: ifeq +31 -> 2163
    //   2135: ldc_w 279
    //   2138: iconst_2
    //   2139: new 34	java/lang/StringBuilder
    //   2142: dup
    //   2143: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2146: ldc_w 1074
    //   2149: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: lload 8
    //   2154: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2157: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2160: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2163: lload 8
    //   2165: lconst_0
    //   2166: lcmp
    //   2167: ifle +67 -> 2234
    //   2170: aload_0
    //   2171: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   2174: ifnull +55 -> 2229
    //   2177: aload_0
    //   2178: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   2181: invokevirtual 548	bbac:a	()Landroid/app/Activity;
    //   2184: astore_1
    //   2185: aload_1
    //   2186: aconst_null
    //   2187: aload_2
    //   2188: invokestatic 1079	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2191: aload_1
    //   2192: ifnull -1987 -> 205
    //   2195: aload_1
    //   2196: ldc_w 1080
    //   2199: ldc_w 1081
    //   2202: invokevirtual 1084	android/app/Activity:overridePendingTransition	(II)V
    //   2205: goto -2000 -> 205
    //   2208: astore_1
    //   2209: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2212: ifeq -2007 -> 205
    //   2215: ldc_w 279
    //   2218: iconst_2
    //   2219: ldc_w 1086
    //   2222: aload_1
    //   2223: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2226: goto -2021 -> 205
    //   2229: aconst_null
    //   2230: astore_1
    //   2231: goto -46 -> 2185
    //   2234: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2237: ifeq -2032 -> 205
    //   2240: ldc_w 279
    //   2243: iconst_2
    //   2244: new 34	java/lang/StringBuilder
    //   2247: dup
    //   2248: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2251: ldc_w 1088
    //   2254: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2257: aload_2
    //   2258: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2264: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2267: goto -2062 -> 205
    //   2270: ldc_w 1090
    //   2273: aload 4
    //   2275: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2278: ifeq -2073 -> 205
    //   2281: new 242	org/json/JSONObject
    //   2284: dup
    //   2285: aload 5
    //   2287: iconst_0
    //   2288: aaload
    //   2289: invokespecial 802	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2292: astore_1
    //   2293: aload_1
    //   2294: ldc_w 1092
    //   2297: invokevirtual 1069	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2300: astore_2
    //   2301: aload_2
    //   2302: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2305: istore 14
    //   2307: iload 14
    //   2309: ifne -2104 -> 205
    //   2312: aload_2
    //   2313: invokestatic 1072	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2316: lstore 10
    //   2318: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2321: ifeq +31 -> 2352
    //   2324: ldc_w 279
    //   2327: iconst_2
    //   2328: new 34	java/lang/StringBuilder
    //   2331: dup
    //   2332: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2335: ldc_w 1094
    //   2338: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: lload 10
    //   2343: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2346: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2349: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2352: aload_1
    //   2353: ldc_w 1068
    //   2356: invokevirtual 1069	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2359: astore_1
    //   2360: lconst_0
    //   2361: lstore 8
    //   2363: aload_1
    //   2364: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2367: istore 14
    //   2369: lload 8
    //   2371: lstore 12
    //   2373: iload 14
    //   2375: ifne +55 -> 2430
    //   2378: aload_1
    //   2379: invokestatic 1072	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2382: lstore 12
    //   2384: lload 12
    //   2386: lstore 8
    //   2388: lload 8
    //   2390: lstore 12
    //   2392: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2395: ifeq +35 -> 2430
    //   2398: ldc_w 279
    //   2401: iconst_2
    //   2402: new 34	java/lang/StringBuilder
    //   2405: dup
    //   2406: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2409: ldc_w 1074
    //   2412: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: lload 8
    //   2417: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2420: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2423: invokestatic 872	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2445: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   2448: ifnull +70 -> 2518
    //   2451: aload_0
    //   2452: getfield 543	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbbac;
    //   2455: invokevirtual 548	bbac:a	()Landroid/app/Activity;
    //   2458: astore_1
    //   2459: aload_0
    //   2460: aload_1
    //   2461: lload 12
    //   2463: lload 10
    //   2465: invokestatic 1099	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2468: bipush 7
    //   2470: invokevirtual 840	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2473: aload_1
    //   2474: ifnull -2269 -> 205
    //   2477: aload_1
    //   2478: ldc_w 1080
    //   2481: ldc_w 1081
    //   2484: invokevirtual 1084	android/app/Activity:overridePendingTransition	(II)V
    //   2487: goto -2282 -> 205
    //   2490: astore_1
    //   2491: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2494: ifeq -2289 -> 205
    //   2497: ldc_w 279
    //   2500: iconst_2
    //   2501: ldc_w 1086
    //   2504: aload_1
    //   2505: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
                localObject1 = new bgoe(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
                paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (bgoe)localObject1, 0);
                this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
                paramIntent.jdField_a_of_type_Bgny.a();
                this.jdField_d_of_type_Int += 1;
                return;
              }
            } while (paramInt != -1);
            localHashMap1 = new HashMap();
            localHashMap2 = new HashMap();
            if ((paramByte == 2) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
            {
              bacm.a(this.mRuntime.a(), this.jdField_c_of_type_JavaLangString);
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
                  if (baaf.a((LocalMediaInfo)paramIntent.get(localObject3)) != 1) {
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
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new bgoe(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
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
    this.jdField_a_of_type_Wis = wis.a();
    this.jdField_a_of_type_Wis.a();
    this.jdField_a_of_type_Bgoj = new bgoj(this.mRuntime.a(), this);
    this.jdField_a_of_type_Bgnz = new bgnz(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    int k = 0;
    if (this.jdField_a_of_type_Wis != null) {
      this.jdField_a_of_type_Wis.b();
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
      localObject1 = new File(ajed.bq);
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