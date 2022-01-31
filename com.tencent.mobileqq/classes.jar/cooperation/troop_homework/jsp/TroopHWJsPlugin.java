package cooperation.troop_homework.jsp;

import ajsd;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bahy;
import bbbx;
import bbco;
import bbef;
import bbvj;
import bcdp;
import bcql;
import bdik;
import bfpc;
import bhxj;
import bhxk;
import bhxm;
import bhxn;
import bhxo;
import bhxp;
import bhxq;
import bhxr;
import bhxs;
import bhxt;
import bhxx;
import bhxz;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
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
import lkj;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;
import wxr;
import wxt;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements bhxm, bhxz, wxt
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new bhxq(this);
  bfpc jdField_a_of_type_Bfpc = null;
  private bhxk jdField_a_of_type_Bhxk;
  bhxx jdField_a_of_type_Bhxx = null;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  wxr jdField_a_of_type_Wxr = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 540;
  String jdField_b_of_type_JavaLangString;
  HashMap<Integer, bhxt> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    jdField_a_of_type_JavaLangString = ajsd.bs + "homeworkTmp/";
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
    //   23: astore 6
    //   25: new 216	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 217	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 7
    //   34: aload 7
    //   36: aload_2
    //   37: invokevirtual 221	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   40: aload 7
    //   42: ldc2_w 222
    //   45: invokevirtual 227	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +386 -> 436
    //   53: aload_0
    //   54: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   57: ifgt +129 -> 186
    //   60: sipush 540
    //   63: istore_1
    //   64: aload_0
    //   65: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   68: ifgt +126 -> 194
    //   71: sipush 540
    //   74: istore_3
    //   75: aload_2
    //   76: iload_1
    //   77: iload_3
    //   78: invokestatic 233	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +60 -> 145
    //   88: aload 4
    //   90: aload 4
    //   92: invokestatic 235	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   95: invokestatic 238	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   98: astore 5
    //   100: aload 5
    //   102: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +40 -> 145
    //   108: aload 6
    //   110: ldc 240
    //   112: aload 5
    //   114: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload 6
    //   120: ldc 248
    //   122: aload 4
    //   124: invokevirtual 251	android/graphics/Bitmap:getWidth	()I
    //   127: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload 6
    //   133: ldc_w 256
    //   136: aload 4
    //   138: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   141: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload 7
    //   147: invokevirtual 259	android/media/MediaMetadataRetriever:release	()V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   155: iconst_1
    //   156: anewarray 263	java/lang/String
    //   159: dup
    //   160: iconst_0
    //   161: aload 6
    //   163: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   166: aastore
    //   167: invokevirtual 268	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   170: aload 4
    //   172: ifnull +209 -> 381
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 271	android/graphics/Bitmap:recycle	()V
    //   183: aload 4
    //   185: areturn
    //   186: aload_0
    //   187: getfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   190: istore_1
    //   191: goto -127 -> 64
    //   194: aload_0
    //   195: getfield 60	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Int	I
    //   198: istore_3
    //   199: goto -124 -> 75
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_2
    //   206: aconst_null
    //   207: astore 4
    //   209: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +34 -> 246
    //   215: ldc_w 279
    //   218: iconst_2
    //   219: new 34	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 281
    //   229: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 5
    //   234: invokevirtual 284	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   237: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload 7
    //   248: invokevirtual 259	android/media/MediaMetadataRetriever:release	()V
    //   251: goto -101 -> 150
    //   254: astore 5
    //   256: goto -106 -> 150
    //   259: astore 5
    //   261: aconst_null
    //   262: astore_2
    //   263: aconst_null
    //   264: astore 4
    //   266: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +34 -> 303
    //   272: ldc_w 279
    //   275: iconst_2
    //   276: new 34	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 281
    //   286: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 5
    //   291: invokevirtual 289	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 7
    //   305: invokevirtual 259	android/media/MediaMetadataRetriever:release	()V
    //   308: goto -158 -> 150
    //   311: astore 5
    //   313: goto -163 -> 150
    //   316: astore 5
    //   318: aconst_null
    //   319: astore_2
    //   320: aconst_null
    //   321: astore 4
    //   323: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +34 -> 360
    //   329: ldc_w 279
    //   332: iconst_2
    //   333: new 34	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 291
    //   343: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 5
    //   348: invokevirtual 292	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   351: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 7
    //   362: invokevirtual 259	android/media/MediaMetadataRetriever:release	()V
    //   365: goto -215 -> 150
    //   368: astore 5
    //   370: goto -220 -> 150
    //   373: astore_2
    //   374: aload 7
    //   376: invokevirtual 259	android/media/MediaMetadataRetriever:release	()V
    //   379: aload_2
    //   380: athrow
    //   381: aload_2
    //   382: ifnull -375 -> 7
    //   385: aload_2
    //   386: areturn
    //   387: astore 5
    //   389: goto -239 -> 150
    //   392: astore 4
    //   394: goto -15 -> 379
    //   397: astore 5
    //   399: aconst_null
    //   400: astore 4
    //   402: goto -79 -> 323
    //   405: astore 5
    //   407: goto -84 -> 323
    //   410: astore 5
    //   412: aconst_null
    //   413: astore 4
    //   415: goto -149 -> 266
    //   418: astore 5
    //   420: goto -154 -> 266
    //   423: astore 5
    //   425: aconst_null
    //   426: astore 4
    //   428: goto -219 -> 209
    //   431: astore 5
    //   433: goto -224 -> 209
    //   436: aconst_null
    //   437: astore 4
    //   439: goto -294 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	TroopHWJsPlugin
    //   0	442	1	paramInt	int
    //   0	442	2	paramString	String
    //   74	125	3	j	int
    //   81	241	4	localBitmap	Bitmap
    //   392	1	4	localRuntimeException1	java.lang.RuntimeException
    //   400	38	4	localObject	Object
    //   98	15	5	str	String
    //   202	31	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   254	1	5	localRuntimeException2	java.lang.RuntimeException
    //   259	31	5	localRuntimeException3	java.lang.RuntimeException
    //   311	1	5	localRuntimeException4	java.lang.RuntimeException
    //   316	31	5	localJSONException1	JSONException
    //   368	1	5	localRuntimeException5	java.lang.RuntimeException
    //   387	1	5	localRuntimeException6	java.lang.RuntimeException
    //   397	1	5	localJSONException2	JSONException
    //   405	1	5	localJSONException3	JSONException
    //   410	1	5	localRuntimeException7	java.lang.RuntimeException
    //   418	1	5	localRuntimeException8	java.lang.RuntimeException
    //   423	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   431	1	5	localIllegalArgumentException3	java.lang.IllegalArgumentException
    //   23	139	6	localJSONObject	JSONObject
    //   32	343	7	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   34	49	202	java/lang/IllegalArgumentException
    //   246	251	254	java/lang/RuntimeException
    //   34	49	259	java/lang/RuntimeException
    //   303	308	311	java/lang/RuntimeException
    //   34	49	316	org/json/JSONException
    //   360	365	368	java/lang/RuntimeException
    //   34	49	373	finally
    //   53	60	373	finally
    //   64	71	373	finally
    //   75	83	373	finally
    //   88	145	373	finally
    //   186	191	373	finally
    //   194	199	373	finally
    //   209	246	373	finally
    //   266	303	373	finally
    //   323	360	373	finally
    //   145	150	387	java/lang/RuntimeException
    //   374	379	392	java/lang/RuntimeException
    //   53	60	397	org/json/JSONException
    //   64	71	397	org/json/JSONException
    //   75	83	397	org/json/JSONException
    //   186	191	397	org/json/JSONException
    //   194	199	397	org/json/JSONException
    //   88	145	405	org/json/JSONException
    //   53	60	410	java/lang/RuntimeException
    //   64	71	410	java/lang/RuntimeException
    //   75	83	410	java/lang/RuntimeException
    //   186	191	410	java/lang/RuntimeException
    //   194	199	410	java/lang/RuntimeException
    //   88	145	418	java/lang/RuntimeException
    //   53	60	423	java/lang/IllegalArgumentException
    //   64	71	423	java/lang/IllegalArgumentException
    //   75	83	423	java/lang/IllegalArgumentException
    //   186	191	423	java/lang/IllegalArgumentException
    //   194	199	423	java/lang/IllegalArgumentException
    //   88	145	431	java/lang/IllegalArgumentException
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
    //   82: ifle +1195 -> 1277
    //   85: iload 10
    //   87: ifgt +6 -> 93
    //   90: goto +1187 -> 1277
    //   93: iload 8
    //   95: iload_2
    //   96: if_icmpgt +25 -> 121
    //   99: aload_1
    //   100: astore 11
    //   102: aload_3
    //   103: ifnull +1177 -> 1280
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
    //   151: if_icmpeq +1132 -> 1283
    //   154: iload 9
    //   156: bipush 6
    //   158: if_icmpeq +1125 -> 1283
    //   161: iload 9
    //   163: bipush 7
    //   165: if_icmpeq +1118 -> 1283
    //   168: iload 9
    //   170: bipush 8
    //   172: if_icmpne +6 -> 178
    //   175: goto +1108 -> 1283
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
    //   287: ifnull +993 -> 1280
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
    //   318: ifeq +422 -> 740
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
    //   360: goto +929 -> 1289
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
    //   386: ifnull +884 -> 1270
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
    //   425: invokevirtual 271	android/graphics/Bitmap:recycle	()V
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
    //   456: ifle +605 -> 1061
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
    //   485: ifnull +782 -> 1267
    //   488: aload 15
    //   490: aload 11
    //   492: invokevirtual 401	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   495: iconst_2
    //   496: invokestatic 407	bbco:encodeToString	([BI)Ljava/lang/String;
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
    //   541: invokevirtual 271	android/graphics/Bitmap:recycle	()V
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
    //   607: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   610: iconst_1
    //   611: anewarray 263	java/lang/String
    //   614: dup
    //   615: iconst_0
    //   616: aload 13
    //   618: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   621: aastore
    //   622: invokevirtual 268	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   625: aload 11
    //   627: ifnull +633 -> 1260
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
    //   673: invokestatic 440	apvd:a	(Ljava/lang/String;)Ljava/lang/String;
    //   676: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: astore_3
    //   683: new 442	com/tencent/mm/vfs/VFSFileOutputStream
    //   686: dup
    //   687: aload_3
    //   688: invokespecial 443	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Ljava/lang/String;)V
    //   691: astore_1
    //   692: aload_1
    //   693: aload 11
    //   695: invokevirtual 401	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   698: invokevirtual 447	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   701: aload_3
    //   702: iconst_0
    //   703: invokestatic 453	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   706: astore 12
    //   708: aload_1
    //   709: astore_3
    //   710: aload 12
    //   712: astore_1
    //   713: aload 11
    //   715: ifnull +8 -> 723
    //   718: aload 11
    //   720: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   723: aload_1
    //   724: astore 11
    //   726: aload_3
    //   727: ifnull +10 -> 737
    //   730: aload_3
    //   731: invokevirtual 455	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   734: aload_1
    //   735: astore 11
    //   737: aload 11
    //   739: areturn
    //   740: iload_2
    //   741: i2f
    //   742: fstore 6
    //   744: fload 5
    //   746: fstore 4
    //   748: aload 11
    //   750: astore 12
    //   752: aload 11
    //   754: invokevirtual 251	android/graphics/Bitmap:getWidth	()I
    //   757: i2f
    //   758: fstore 5
    //   760: fload 5
    //   762: fstore 4
    //   764: aload 11
    //   766: astore 12
    //   768: fload 6
    //   770: fload 5
    //   772: fdiv
    //   773: fstore 5
    //   775: fload 5
    //   777: fstore 4
    //   779: goto +510 -> 1289
    //   782: fload 5
    //   784: fstore 4
    //   786: aload 11
    //   788: astore 12
    //   790: aload 16
    //   792: fload 5
    //   794: fneg
    //   795: fload 5
    //   797: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   800: goto -420 -> 380
    //   803: astore 11
    //   805: aload 12
    //   807: astore 11
    //   809: aload 16
    //   811: fload 4
    //   813: fload 4
    //   815: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   818: aload 11
    //   820: astore 12
    //   822: aload 13
    //   824: ifnull +446 -> 1270
    //   827: aload 13
    //   829: invokevirtual 366	java/io/FileInputStream:close	()V
    //   832: goto -438 -> 394
    //   835: fload 5
    //   837: fstore 4
    //   839: aload 11
    //   841: astore 12
    //   843: aload 16
    //   845: fload 5
    //   847: fload 5
    //   849: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   852: fload 5
    //   854: fstore 4
    //   856: aload 11
    //   858: astore 12
    //   860: aload 16
    //   862: ldc_w 456
    //   865: invokevirtual 460	android/graphics/Matrix:postRotate	(F)Z
    //   868: pop
    //   869: goto -489 -> 380
    //   872: astore_1
    //   873: aload 13
    //   875: astore_3
    //   876: aload_3
    //   877: ifnull +7 -> 884
    //   880: aload_3
    //   881: invokevirtual 366	java/io/FileInputStream:close	()V
    //   884: aload_1
    //   885: athrow
    //   886: fload 5
    //   888: fneg
    //   889: fstore 6
    //   891: fload 5
    //   893: fstore 4
    //   895: aload 11
    //   897: astore 12
    //   899: aload 16
    //   901: fload 5
    //   903: fload 6
    //   905: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   908: goto -528 -> 380
    //   911: fload 5
    //   913: fstore 4
    //   915: aload 11
    //   917: astore 12
    //   919: aload 16
    //   921: fload 5
    //   923: fload 5
    //   925: fneg
    //   926: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   929: fload 5
    //   931: fstore 4
    //   933: aload 11
    //   935: astore 12
    //   937: aload 16
    //   939: ldc_w 461
    //   942: invokevirtual 460	android/graphics/Matrix:postRotate	(F)Z
    //   945: pop
    //   946: goto -566 -> 380
    //   949: fload 5
    //   951: fstore 4
    //   953: aload 11
    //   955: astore 12
    //   957: aload 16
    //   959: fload 5
    //   961: fload 5
    //   963: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   966: fload 5
    //   968: fstore 4
    //   970: aload 11
    //   972: astore 12
    //   974: aload 16
    //   976: ldc_w 461
    //   979: invokevirtual 460	android/graphics/Matrix:postRotate	(F)Z
    //   982: pop
    //   983: goto -603 -> 380
    //   986: fload 5
    //   988: fstore 4
    //   990: aload 11
    //   992: astore 12
    //   994: aload 16
    //   996: fload 5
    //   998: fneg
    //   999: fload 5
    //   1001: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   1004: fload 5
    //   1006: fstore 4
    //   1008: aload 11
    //   1010: astore 12
    //   1012: aload 16
    //   1014: ldc_w 461
    //   1017: invokevirtual 460	android/graphics/Matrix:postRotate	(F)Z
    //   1020: pop
    //   1021: goto -641 -> 380
    //   1024: fload 5
    //   1026: fstore 4
    //   1028: aload 11
    //   1030: astore 12
    //   1032: aload 16
    //   1034: fload 5
    //   1036: fload 5
    //   1038: invokevirtual 378	android/graphics/Matrix:setScale	(FF)V
    //   1041: fload 5
    //   1043: fstore 4
    //   1045: aload 11
    //   1047: astore 12
    //   1049: aload 16
    //   1051: ldc_w 462
    //   1054: invokevirtual 460	android/graphics/Matrix:postRotate	(F)Z
    //   1057: pop
    //   1058: goto -678 -> 380
    //   1061: iload 8
    //   1063: ifne +16 -> 1079
    //   1066: aload_3
    //   1067: ifnull +12 -> 1079
    //   1070: aload_3
    //   1071: getfield 96	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1074: iconst_1
    //   1075: invokevirtual 468	android/os/Handler:sendEmptyMessage	(I)Z
    //   1078: pop
    //   1079: aconst_null
    //   1080: astore 11
    //   1082: goto -579 -> 503
    //   1085: astore 11
    //   1087: aconst_null
    //   1088: astore_1
    //   1089: aload 13
    //   1091: astore_3
    //   1092: aload 11
    //   1094: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   1097: aconst_null
    //   1098: astore 12
    //   1100: aload_3
    //   1101: ifnull +7 -> 1108
    //   1104: aload_3
    //   1105: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   1108: aload 12
    //   1110: astore 11
    //   1112: aload_1
    //   1113: ifnull -376 -> 737
    //   1116: aload_1
    //   1117: invokevirtual 455	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1120: aload 12
    //   1122: astore 11
    //   1124: goto -387 -> 737
    //   1127: aload 11
    //   1129: ifnull +8 -> 1137
    //   1132: aload 11
    //   1134: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   1137: aload_3
    //   1138: ifnull +7 -> 1145
    //   1141: aload_3
    //   1142: invokevirtual 455	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1145: aload_1
    //   1146: athrow
    //   1147: astore_1
    //   1148: aload 12
    //   1150: astore_3
    //   1151: goto -24 -> 1127
    //   1154: astore_1
    //   1155: aload 12
    //   1157: astore_3
    //   1158: goto -31 -> 1127
    //   1161: astore 12
    //   1163: aload_1
    //   1164: astore_3
    //   1165: aload 12
    //   1167: astore_1
    //   1168: goto -41 -> 1127
    //   1171: astore 13
    //   1173: aload_1
    //   1174: astore 11
    //   1176: aload_3
    //   1177: astore 12
    //   1179: aload 13
    //   1181: astore_1
    //   1182: aload 11
    //   1184: astore_3
    //   1185: aload 12
    //   1187: astore 11
    //   1189: goto -62 -> 1127
    //   1192: astore_1
    //   1193: aload 11
    //   1195: astore_3
    //   1196: aconst_null
    //   1197: astore 12
    //   1199: aload_1
    //   1200: astore 11
    //   1202: aload 12
    //   1204: astore_1
    //   1205: goto -113 -> 1092
    //   1208: astore 12
    //   1210: aconst_null
    //   1211: astore_1
    //   1212: aload 11
    //   1214: astore_3
    //   1215: aload 12
    //   1217: astore 11
    //   1219: goto -127 -> 1092
    //   1222: astore 12
    //   1224: aload 11
    //   1226: astore_3
    //   1227: aload 12
    //   1229: astore 11
    //   1231: goto -139 -> 1092
    //   1234: astore_1
    //   1235: aconst_null
    //   1236: astore_3
    //   1237: goto -361 -> 876
    //   1240: astore_1
    //   1241: aload 13
    //   1243: astore_3
    //   1244: goto -368 -> 876
    //   1247: astore 13
    //   1249: fload 5
    //   1251: fstore 4
    //   1253: aload 12
    //   1255: astore 13
    //   1257: goto -448 -> 809
    //   1260: aconst_null
    //   1261: astore_3
    //   1262: aconst_null
    //   1263: astore_1
    //   1264: goto -551 -> 713
    //   1267: goto -764 -> 503
    //   1270: aload 12
    //   1272: astore 11
    //   1274: goto -880 -> 394
    //   1277: aconst_null
    //   1278: astore 11
    //   1280: aload 11
    //   1282: areturn
    //   1283: iconst_1
    //   1284: istore 7
    //   1286: goto -1108 -> 178
    //   1289: fload 4
    //   1291: f2d
    //   1292: ldc2_w 470
    //   1295: dcmpg
    //   1296: ifge +55 -> 1351
    //   1299: ldc_w 472
    //   1302: fstore 5
    //   1304: iload 9
    //   1306: tableswitch	default:+42 -> 1348, 2:+-524->782, 3:+-471->835, 4:+-420->886, 5:+-395->911, 6:+-357->949, 7:+-320->986, 8:+-282->1024
    //   1349: <illegal opcode>
    //   1350: dload_1
    //   1351: fconst_1
    //   1352: fstore 5
    //   1354: goto -50 -> 1304
    //   1357: astore_1
    //   1358: aconst_null
    //   1359: astore 11
    //   1361: aload 12
    //   1363: astore_3
    //   1364: goto -237 -> 1127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1367	0	paramInt1	int
    //   0	1367	1	paramString	String
    //   0	1367	2	paramInt2	int
    //   0	1367	3	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   261	1029	4	f1	float
    //   137	1216	5	f2	float
    //   323	581	6	f3	float
    //   140	1145	7	j	int
    //   71	991	8	k	int
    //   146	1159	9	m	int
    //   78	109	10	n	int
    //   100	687	11	localObject1	Object
    //   803	1	11	localIOException1	java.io.IOException
    //   807	274	11	localObject2	Object
    //   1085	8	11	localIOException2	java.io.IOException
    //   1110	250	11	localObject3	Object
    //   19	1137	12	localObject4	Object
    //   1161	5	12	localObject5	Object
    //   1177	26	12	localTroopHWJsPlugin	TroopHWJsPlugin
    //   1208	8	12	localIOException3	java.io.IOException
    //   1222	140	12	localIOException4	java.io.IOException
    //   257	833	13	localObject6	Object
    //   1171	71	13	localObject7	Object
    //   1247	1	13	localIOException5	java.io.IOException
    //   1255	1	13	localIOException6	java.io.IOException
    //   125	415	14	localBitmap	Bitmap
    //   28	552	15	localStringBuilder	StringBuilder
    //   134	916	16	localMatrix	android.graphics.Matrix
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
    //   718	723	297	java/lang/OutOfMemoryError
    //   730	734	297	java/lang/OutOfMemoryError
    //   827	832	297	java/lang/OutOfMemoryError
    //   880	884	297	java/lang/OutOfMemoryError
    //   884	886	297	java/lang/OutOfMemoryError
    //   1104	1108	297	java/lang/OutOfMemoryError
    //   1116	1120	297	java/lang/OutOfMemoryError
    //   1132	1137	297	java/lang/OutOfMemoryError
    //   1141	1145	297	java/lang/OutOfMemoryError
    //   1145	1147	297	java/lang/OutOfMemoryError
    //   267	277	803	java/io/IOException
    //   333	341	803	java/io/IOException
    //   349	356	803	java/io/IOException
    //   371	380	803	java/io/IOException
    //   752	760	803	java/io/IOException
    //   768	775	803	java/io/IOException
    //   790	800	803	java/io/IOException
    //   843	852	803	java/io/IOException
    //   860	869	803	java/io/IOException
    //   899	908	803	java/io/IOException
    //   919	929	803	java/io/IOException
    //   937	946	803	java/io/IOException
    //   957	966	803	java/io/IOException
    //   974	983	803	java/io/IOException
    //   994	1004	803	java/io/IOException
    //   1012	1021	803	java/io/IOException
    //   1032	1041	803	java/io/IOException
    //   1049	1058	803	java/io/IOException
    //   267	277	872	finally
    //   333	341	872	finally
    //   349	356	872	finally
    //   371	380	872	finally
    //   752	760	872	finally
    //   768	775	872	finally
    //   790	800	872	finally
    //   843	852	872	finally
    //   860	869	872	finally
    //   899	908	872	finally
    //   919	929	872	finally
    //   937	946	872	finally
    //   957	966	872	finally
    //   974	983	872	finally
    //   994	1004	872	finally
    //   1012	1021	872	finally
    //   1032	1041	872	finally
    //   1049	1058	872	finally
    //   459	471	1085	java/io/IOException
    //   1070	1079	1085	java/io/IOException
    //   471	484	1147	finally
    //   488	503	1147	finally
    //   503	534	1154	finally
    //   539	544	1154	finally
    //   548	585	1154	finally
    //   585	625	1154	finally
    //   630	692	1154	finally
    //   692	708	1161	finally
    //   1092	1097	1171	finally
    //   471	484	1192	java/io/IOException
    //   488	503	1192	java/io/IOException
    //   503	534	1208	java/io/IOException
    //   539	544	1208	java/io/IOException
    //   548	585	1208	java/io/IOException
    //   585	625	1208	java/io/IOException
    //   630	692	1208	java/io/IOException
    //   692	708	1222	java/io/IOException
    //   142	148	1234	finally
    //   183	189	1234	finally
    //   189	195	1234	finally
    //   232	259	1234	finally
    //   307	313	1234	finally
    //   809	818	1240	finally
    //   142	148	1247	java/io/IOException
    //   183	189	1247	java/io/IOException
    //   189	195	1247	java/io/IOException
    //   232	259	1247	java/io/IOException
    //   307	313	1247	java/io/IOException
    //   459	471	1357	finally
    //   1070	1079	1357	finally
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    Object localObject = "";
    if (lkj.b(BaseApplicationImpl.getContext())) {}
    BaseApplication localBaseApplication;
    String str;
    Intent localIntent;
    do
    {
      return localObject;
      localBaseApplication = BaseApplicationImpl.getContext();
      str = bbvj.a(ajsd.bc + System.currentTimeMillis() + ".jpg");
      localObject = new File(str).getParentFile();
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        bcql.a(localBaseApplication, 2131719055, 0).a();
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
      bcql.a(localBaseApplication, 2131690593, 0).a();
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
    //   39: invokestatic 407	bbco:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 532	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 528	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 532	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 469	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 532	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 469	java/io/IOException:printStackTrace	()V
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
          localStringBuilder.append(bbco.encodeToString(arrayOfByte2, 2));
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
      localStringBuilder.append(bbco.encodeToString(arrayOfByte1, 2));
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
    localObject = new VFSFile(ajsd.bs);
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
    if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
      return;
    }
    bfpc localbfpc = bfpc.a(this.mRuntime.a());
    localbfpc.a(2131719278, 1);
    localbfpc.a(2131719267, 1);
    localbfpc.c(2131690596);
    localbfpc.a(new bhxn(this, paramInt, localbfpc));
    localbfpc.show();
    this.jdField_a_of_type_Bfpc = localbfpc;
  }
  
  private void f(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.a())
    {
      bcql.a(BaseApplicationImpl.getContext(), 2131690593, 0).a();
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
        ((AppActivity)localActivity).requestPermissions(new bhxo(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
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
  
  public bhxt a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, bhxs parambhxs, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    bhxt localbhxt = new bhxt(paramTroopHWJsPlugin);
    localbhxt.jdField_a_of_type_Int = paramInt1;
    localbhxt.jdField_a_of_type_Bhxs = parambhxs;
    localbhxt.jdField_a_of_type_Bhxj = new bhxj(paramTroopHWJsPlugin.mRuntime.a(), paramString, parambhxs.jdField_b_of_type_JavaLangString);
    localbhxt.jdField_a_of_type_Bhxj.a(localbhxt.jdField_a_of_type_Bhxi);
    localbhxt.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    localbhxt.jdField_b_of_type_JavaLangString = paramString;
    localbhxt.jdField_b_of_type_Int = paramInt2;
    return localbhxt;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = bdik.d(paramString2) + bahy.a(paramString2);
    paramString1 = bbvj.a(ajsd.bt + paramString1 + File.separator);
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
        ((AppActivity)localActivity).requestPermissions(new bhxp(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
        ((AppActivity)localActivity).requestPermissions(new bhxr(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhxx.a();
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
    //   7: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   28: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: ldc_w 861
    //   35: aload 4
    //   37: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +83 -> 123
    //   43: aload_0
    //   44: aload_1
    //   45: ldc_w 863
    //   48: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: iconst_1
    //   52: anewarray 263	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc_w 477
    //   60: aastore
    //   61: invokevirtual 268	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   68: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
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
    //   88: invokespecial 132	android/content/Intent:<init>	()V
    //   91: astore_2
    //   92: aload_2
    //   93: ldc_w 868
    //   96: aload 5
    //   98: iconst_0
    //   99: aaload
    //   100: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   103: pop
    //   104: aload_1
    //   105: iconst_m1
    //   106: aload_2
    //   107: invokevirtual 872	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   110: aload_1
    //   111: invokevirtual 875	android/app/Activity:isFinishing	()Z
    //   114: ifne +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 878	android/app/Activity:finish	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: aload_1
    //   124: ifnull +102 -> 226
    //   127: aload_1
    //   128: ldc_w 880
    //   131: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 15
    //   136: aload_1
    //   137: ldc_w 665
    //   140: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 16
    //   145: aload_0
    //   146: aload 15
    //   148: putfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   151: aload_0
    //   152: aload 16
    //   154: putfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   157: aload_0
    //   158: aload_3
    //   159: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   162: aload_0
    //   163: aload_1
    //   164: ldc_w 882
    //   167: ldc_w 477
    //   170: invokevirtual 884	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   173: putfield 886	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   176: aload_0
    //   177: aload_1
    //   178: ldc_w 888
    //   181: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   184: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   187: aload_0
    //   188: aload_1
    //   189: ldc_w 893
    //   192: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   226: ldc_w 895
    //   229: aload 4
    //   231: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +73 -> 307
    //   237: aload_0
    //   238: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   241: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
    //   244: astore_1
    //   245: new 131	android/content/Intent
    //   248: dup
    //   249: invokespecial 132	android/content/Intent:<init>	()V
    //   252: astore_2
    //   253: aload_2
    //   254: new 897	android/content/ComponentName
    //   257: dup
    //   258: aload_1
    //   259: ldc_w 899
    //   262: invokespecial 902	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   265: invokevirtual 906	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   268: pop
    //   269: aload_2
    //   270: ldc_w 665
    //   273: aload_0
    //   274: getfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   277: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   280: pop
    //   281: aload_0
    //   282: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   285: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifeq +10 -> 298
    //   291: aload_1
    //   292: aload_2
    //   293: invokevirtual 910	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   296: iconst_1
    //   297: ireturn
    //   298: aload_0
    //   299: aload_2
    //   300: iconst_1
    //   301: invokevirtual 913	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   304: goto -8 -> 296
    //   307: ldc_w 915
    //   310: aload 4
    //   312: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +110 -> 425
    //   318: iconst_m1
    //   319: istore 6
    //   321: aload_1
    //   322: ifnull +12 -> 334
    //   325: aload_1
    //   326: ldc_w 663
    //   329: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   332: istore 6
    //   334: aload_0
    //   335: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   338: iconst_m1
    //   339: if_icmpne +36 -> 375
    //   342: aload_0
    //   343: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   346: iload 6
    //   348: aload_0
    //   349: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   352: iload 6
    //   354: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: invokevirtual 919	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 263	java/lang/String
    //   363: invokevirtual 921	bhxx:a	(ILjava/lang/String;)V
    //   366: aload_0
    //   367: iload 6
    //   369: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   372: goto -76 -> 296
    //   375: iload 6
    //   377: aload_0
    //   378: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   381: if_icmpeq -85 -> 296
    //   384: aload_0
    //   385: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   388: invokevirtual 846	bhxx:a	()Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   396: iload 6
    //   398: aload_0
    //   399: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   402: iload 6
    //   404: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: invokevirtual 919	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   410: checkcast 263	java/lang/String
    //   413: invokevirtual 921	bhxx:a	(ILjava/lang/String;)V
    //   416: aload_0
    //   417: iload 6
    //   419: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   422: goto -126 -> 296
    //   425: ldc_w 923
    //   428: aload 4
    //   430: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +49 -> 482
    //   436: aload_1
    //   437: ifnull +2472 -> 2909
    //   440: aload_1
    //   441: ldc_w 663
    //   444: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   467: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   470: invokevirtual 846	bhxx:a	()Z
    //   473: pop
    //   474: aload_0
    //   475: iconst_m1
    //   476: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   479: goto -183 -> 296
    //   482: ldc_w 925
    //   485: aload 4
    //   487: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   490: ifeq +204 -> 694
    //   493: bipush 10
    //   495: istore 7
    //   497: iconst_0
    //   498: istore 6
    //   500: aload_1
    //   501: ifnull +34 -> 535
    //   504: aload_1
    //   505: ldc_w 927
    //   508: bipush 10
    //   510: invokevirtual 930	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   513: istore 7
    //   515: aload_0
    //   516: aload_1
    //   517: ldc_w 888
    //   520: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   523: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   526: aload_1
    //   527: ldc_w 932
    //   530: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   533: istore 6
    //   535: iload 6
    //   537: iconst_1
    //   538: if_icmpne +13 -> 551
    //   541: aload_0
    //   542: sipush 29954
    //   545: invokespecial 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	(I)V
    //   548: goto -252 -> 296
    //   551: iload 6
    //   553: iconst_2
    //   554: if_icmpne +12 -> 566
    //   557: aload_0
    //   558: iload 7
    //   560: invokevirtual 934	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   563: goto -267 -> 296
    //   566: iload 6
    //   568: iconst_3
    //   569: if_icmpne +116 -> 685
    //   572: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +30 -> 605
    //   578: ldc_w 279
    //   581: iconst_2
    //   582: new 34	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 936
    //   592: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_1
    //   596: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: aload_0
    //   606: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   612: ifne +13 -> 625
    //   615: aload_0
    //   616: getfield 886	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   619: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   622: ifeq +54 -> 676
    //   625: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +46 -> 674
    //   631: ldc_w 279
    //   634: iconst_2
    //   635: new 34	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   642: ldc_w 943
    //   645: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_0
    //   649: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   652: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc_w 945
    //   658: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 886	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   665: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: iconst_1
    //   675: ireturn
    //   676: aload_0
    //   677: iload 7
    //   679: invokevirtual 946	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   682: goto -386 -> 296
    //   685: aload_0
    //   686: iload 7
    //   688: invokespecial 948	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(I)V
    //   691: goto -395 -> 296
    //   694: ldc_w 950
    //   697: aload 4
    //   699: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   723: ldc_w 952
    //   726: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   729: astore 5
    //   731: aload_1
    //   732: ldc_w 954
    //   735: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   738: astore 4
    //   740: aload_1
    //   741: ldc_w 882
    //   744: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   747: astore 15
    //   749: aload_1
    //   750: ldc_w 956
    //   753: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: astore_3
    //   757: aload_1
    //   758: ldc_w 958
    //   761: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   764: astore_2
    //   765: aload 15
    //   767: astore_1
    //   768: aload_3
    //   769: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   772: ifne +12 -> 784
    //   775: aload_3
    //   776: invokestatic 963	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   779: invokevirtual 966	java/lang/Long:longValue	()J
    //   782: lstore 8
    //   784: aload_2
    //   785: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   788: ifne +12 -> 800
    //   791: aload_2
    //   792: invokestatic 969	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   795: invokevirtual 972	java/lang/Integer:intValue	()I
    //   798: istore 6
    //   800: aload_1
    //   801: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   804: ifne +66 -> 870
    //   807: aload_0
    //   808: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxr	Lwxr;
    //   811: aload_1
    //   812: invokestatic 963	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   815: invokevirtual 966	java/lang/Long:longValue	()J
    //   818: aload 4
    //   820: aload 5
    //   822: lload 8
    //   824: iload 6
    //   826: aload_0
    //   827: invokevirtual 977	wxr:a	(JLjava/lang/String;Ljava/lang/String;JILwxt;)V
    //   830: goto -534 -> 296
    //   833: astore_2
    //   834: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq -541 -> 296
    //   840: ldc_w 279
    //   843: iconst_2
    //   844: new 34	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 979
    //   854: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_1
    //   858: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 981	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: goto -571 -> 296
    //   870: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq -577 -> 296
    //   876: ldc_w 279
    //   879: iconst_2
    //   880: ldc_w 983
    //   883: invokestatic 981	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   886: goto -590 -> 296
    //   889: ldc_w 985
    //   892: aload 4
    //   894: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   897: ifeq +73 -> 970
    //   900: aload_1
    //   901: ifnull +1992 -> 2893
    //   904: aload_1
    //   905: ldc_w 671
    //   908: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   911: astore_1
    //   912: aload_0
    //   913: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   916: ifnonnull +19 -> 935
    //   919: aload_0
    //   920: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   923: aload_1
    //   924: invokevirtual 987	bhxx:b	(Ljava/lang/String;)V
    //   927: aload_0
    //   928: aload_1
    //   929: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   932: goto -636 -> 296
    //   935: aload_0
    //   936: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   939: aload_1
    //   940: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   943: ifne -647 -> 296
    //   946: aload_0
    //   947: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   950: invokevirtual 846	bhxx:a	()Z
    //   953: pop
    //   954: aload_0
    //   955: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   958: aload_1
    //   959: invokevirtual 987	bhxx:b	(Ljava/lang/String;)V
    //   962: aload_0
    //   963: aload_1
    //   964: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   967: goto -671 -> 296
    //   970: ldc_w 989
    //   973: aload 4
    //   975: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifeq +49 -> 1027
    //   981: aload_1
    //   982: ifnull +1904 -> 2886
    //   985: aload_1
    //   986: ldc_w 671
    //   989: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   992: astore_1
    //   993: aload_0
    //   994: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   997: ifnull -701 -> 296
    //   1000: aload_0
    //   1001: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1004: aload_1
    //   1005: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1008: ifeq -712 -> 296
    //   1011: aload_0
    //   1012: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   1015: invokevirtual 846	bhxx:a	()Z
    //   1018: pop
    //   1019: aload_0
    //   1020: aconst_null
    //   1021: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   1024: goto -728 -> 296
    //   1027: ldc_w 991
    //   1030: aload 4
    //   1032: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1035: ifeq +23 -> 1058
    //   1038: aload_0
    //   1039: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   1042: aload_0
    //   1043: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   1046: invokevirtual 626	bcdp:a	()Lcom/tencent/common/app/AppInterface;
    //   1049: invokevirtual 994	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1052: invokevirtual 996	bhxx:e	(Ljava/lang/String;)V
    //   1055: goto -759 -> 296
    //   1058: ldc_w 998
    //   1061: aload 4
    //   1063: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1066: ifeq +39 -> 1105
    //   1069: aload_1
    //   1070: ifnull +25 -> 1095
    //   1073: aload_0
    //   1074: aload_1
    //   1075: ldc_w 1000
    //   1078: invokevirtual 1004	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1081: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1084: aload_0
    //   1085: aload_1
    //   1086: ldc_w 1006
    //   1089: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1092: putfield 82	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1095: aload_0
    //   1096: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxx	Lbhxx;
    //   1099: invokevirtual 1008	bhxx:b	()V
    //   1102: goto -806 -> 296
    //   1105: ldc_w 1010
    //   1108: aload 4
    //   1110: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1113: ifeq +25 -> 1138
    //   1116: new 1012	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1119: dup
    //   1120: aload_0
    //   1121: aload_2
    //   1122: invokestatic 1015	ayoi:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1125: invokespecial 1016	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1128: bipush 8
    //   1130: aconst_null
    //   1131: iconst_0
    //   1132: invokestatic 801	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1135: goto -839 -> 296
    //   1138: ldc_w 1018
    //   1141: aload 4
    //   1143: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1146: ifeq +54 -> 1200
    //   1149: aload_1
    //   1150: ifnull -854 -> 296
    //   1153: aload_1
    //   1154: ldc_w 671
    //   1157: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1160: astore_2
    //   1161: aload_1
    //   1162: ldc_w 1020
    //   1165: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1168: astore_3
    //   1169: aload_0
    //   1170: aload_1
    //   1171: ldc_w 880
    //   1174: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1177: putfield 808	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1180: aload_0
    //   1181: aload_3
    //   1182: aload_2
    //   1183: invokevirtual 811	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1186: astore_1
    //   1187: aload_0
    //   1188: getfield 1022	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxk	Lbhxk;
    //   1191: aload_2
    //   1192: aload_1
    //   1193: aload_0
    //   1194: invokevirtual 1027	bhxk:a	(Ljava/lang/String;Ljava/lang/String;Lbhxm;)V
    //   1197: goto -901 -> 296
    //   1200: ldc_w 1029
    //   1203: aload 4
    //   1205: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1208: ifeq +26 -> 1234
    //   1211: aload_1
    //   1212: ifnull -916 -> 296
    //   1215: aload_1
    //   1216: ldc_w 671
    //   1219: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1222: astore_1
    //   1223: aload_0
    //   1224: getfield 1022	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxk	Lbhxk;
    //   1227: aload_1
    //   1228: invokevirtual 1030	bhxk:a	(Ljava/lang/String;)V
    //   1231: goto -935 -> 296
    //   1234: ldc_w 1032
    //   1237: aload 4
    //   1239: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1242: ifeq +194 -> 1436
    //   1245: aload_1
    //   1246: ifnull -950 -> 296
    //   1249: aload_1
    //   1250: ldc_w 1020
    //   1253: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1256: astore 4
    //   1258: aload_1
    //   1259: ldc_w 1034
    //   1262: invokevirtual 1038	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1265: astore 5
    //   1267: aload_1
    //   1268: ldc_w 880
    //   1271: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1274: astore_2
    //   1275: new 242	org/json/JSONObject
    //   1278: dup
    //   1279: invokespecial 661	org/json/JSONObject:<init>	()V
    //   1282: astore_3
    //   1283: new 1040	org/json/JSONArray
    //   1286: dup
    //   1287: invokespecial 1041	org/json/JSONArray:<init>	()V
    //   1290: astore 15
    //   1292: aload 5
    //   1294: invokevirtual 1043	org/json/JSONArray:length	()I
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
    //   1320: invokevirtual 1046	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1323: invokevirtual 1048	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1326: invokevirtual 1051	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1329: pop
    //   1330: iload 6
    //   1332: iconst_1
    //   1333: iadd
    //   1334: istore 6
    //   1336: goto -34 -> 1302
    //   1339: aload_3
    //   1340: ldc_w 1053
    //   1343: aload 15
    //   1345: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1348: pop
    //   1349: aload_3
    //   1350: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1353: astore_3
    //   1354: aload_0
    //   1355: aload_2
    //   1356: iconst_1
    //   1357: anewarray 263	java/lang/String
    //   1360: dup
    //   1361: iconst_0
    //   1362: aload_3
    //   1363: aastore
    //   1364: invokevirtual 268	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1367: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -1074 -> 296
    //   1373: ldc_w 279
    //   1376: iconst_2
    //   1377: new 34	java/lang/StringBuilder
    //   1380: dup
    //   1381: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1384: ldc_w 1055
    //   1387: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: aload_1
    //   1391: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1394: ldc_w 1057
    //   1397: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: aload_3
    //   1401: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: goto -1114 -> 296
    //   1413: astore 4
    //   1415: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq -69 -> 1349
    //   1421: ldc_w 279
    //   1424: iconst_2
    //   1425: ldc_w 1055
    //   1428: aload 4
    //   1430: invokestatic 1060	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1433: goto -84 -> 1349
    //   1436: ldc_w 1062
    //   1439: aload 4
    //   1441: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1444: ifeq +68 -> 1512
    //   1447: aload_1
    //   1448: ifnull -1152 -> 296
    //   1451: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq +30 -> 1484
    //   1457: ldc_w 279
    //   1460: iconst_2
    //   1461: new 34	java/lang/StringBuilder
    //   1464: dup
    //   1465: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1468: ldc_w 1064
    //   1471: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload_1
    //   1475: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1478: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1481: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1484: aload_1
    //   1485: ldc_w 1066
    //   1488: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1491: astore_2
    //   1492: aload_1
    //   1493: ldc_w 1068
    //   1496: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1499: astore_1
    //   1500: aload_0
    //   1501: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxr	Lwxr;
    //   1504: aload_2
    //   1505: aload_1
    //   1506: invokevirtual 1071	wxr:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: goto -1213 -> 296
    //   1512: ldc_w 1073
    //   1515: aload 4
    //   1517: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1520: ifeq +58 -> 1578
    //   1523: aload_1
    //   1524: ifnull +54 -> 1578
    //   1527: aload_1
    //   1528: ldc_w 673
    //   1531: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1534: pop
    //   1535: aload_1
    //   1536: ldc_w 663
    //   1539: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1542: istore 6
    //   1544: aload_0
    //   1545: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1548: iload 6
    //   1550: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1553: invokevirtual 919	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1556: checkcast 616	bhxt
    //   1559: astore_1
    //   1560: aload_1
    //   1561: ifnull -1265 -> 296
    //   1564: aload_1
    //   1565: getfield 1074	bhxt:jdField_a_of_type_Boolean	Z
    //   1568: ifne -1272 -> 296
    //   1571: aload_1
    //   1572: invokevirtual 1075	bhxt:b	()V
    //   1575: goto -1279 -> 296
    //   1578: ldc_w 1077
    //   1581: aload 4
    //   1583: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1586: ifeq +62 -> 1648
    //   1589: aload_1
    //   1590: ifnull +58 -> 1648
    //   1593: aload_1
    //   1594: ldc_w 673
    //   1597: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1600: pop
    //   1601: aload_1
    //   1602: ldc_w 663
    //   1605: invokevirtual 891	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1608: istore 6
    //   1610: aload_0
    //   1611: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1614: iload 6
    //   1616: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1619: invokevirtual 919	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1622: checkcast 616	bhxt
    //   1625: astore_1
    //   1626: aload_1
    //   1627: ifnull -1331 -> 296
    //   1630: aload_1
    //   1631: getfield 1074	bhxt:jdField_a_of_type_Boolean	Z
    //   1634: ifeq -1338 -> 296
    //   1637: aload_1
    //   1638: getfield 1080	bhxt:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1641: iconst_1
    //   1642: invokevirtual 1086	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1645: goto -1349 -> 296
    //   1648: ldc_w 1088
    //   1651: aload 4
    //   1653: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1656: ifeq +83 -> 1739
    //   1659: aload_1
    //   1660: ifnull -1364 -> 296
    //   1663: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1666: ifeq +24 -> 1690
    //   1669: ldc_w 279
    //   1672: iconst_2
    //   1673: iconst_2
    //   1674: anewarray 142	java/lang/Object
    //   1677: dup
    //   1678: iconst_0
    //   1679: ldc_w 1090
    //   1682: aastore
    //   1683: dup
    //   1684: iconst_1
    //   1685: aload_1
    //   1686: aastore
    //   1687: invokestatic 418	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1690: aload_1
    //   1691: ldc_w 1020
    //   1694: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1697: astore_2
    //   1698: aload_1
    //   1699: ldc_w 673
    //   1702: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1705: astore_1
    //   1706: aload_0
    //   1707: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxr	Lwxr;
    //   1710: aload_2
    //   1711: aload_1
    //   1712: invokevirtual 1092	wxr:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1715: goto -1419 -> 296
    //   1718: astore_1
    //   1719: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1722: ifeq -1426 -> 296
    //   1725: ldc_w 279
    //   1728: iconst_2
    //   1729: ldc_w 1094
    //   1732: aload_1
    //   1733: invokestatic 1060	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1736: goto -1440 -> 296
    //   1739: ldc_w 1096
    //   1742: aload 4
    //   1744: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1747: ifeq +167 -> 1914
    //   1750: aload_1
    //   1751: ifnull -1455 -> 296
    //   1754: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1757: ifeq +30 -> 1787
    //   1760: ldc_w 279
    //   1763: iconst_2
    //   1764: new 34	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1771: ldc_w 1098
    //   1774: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: aload_1
    //   1778: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1787: aload_1
    //   1788: ldc_w 663
    //   1791: iconst_0
    //   1792: invokevirtual 930	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1795: istore 6
    //   1797: aload_0
    //   1798: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1801: iload 6
    //   1803: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1806: invokevirtual 919	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1809: checkcast 616	bhxt
    //   1812: astore_2
    //   1813: aload_2
    //   1814: ifnull +70 -> 1884
    //   1817: aload_2
    //   1818: getfield 645	bhxt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1821: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1824: ifne +60 -> 1884
    //   1827: new 726	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1830: dup
    //   1831: invokespecial 727	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1834: astore_1
    //   1835: aload_1
    //   1836: aload_2
    //   1837: getfield 645	bhxt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1840: invokevirtual 748	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1843: new 131	android/content/Intent
    //   1846: dup
    //   1847: aload_0
    //   1848: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   1851: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
    //   1854: ldc_w 762
    //   1857: invokespecial 1099	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1860: astore_2
    //   1861: aload_2
    //   1862: ldc_w 764
    //   1865: aload_1
    //   1866: invokevirtual 767	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1869: pop
    //   1870: aload_0
    //   1871: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   1874: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
    //   1877: aload_2
    //   1878: invokevirtual 910	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1881: goto -1585 -> 296
    //   1884: ldc_w 279
    //   1887: iconst_1
    //   1888: new 34	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1895: ldc_w 1101
    //   1898: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: aload_2
    //   1902: invokevirtual 939	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1905: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1908: invokestatic 981	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1911: goto -1615 -> 296
    //   1914: ldc_w 1103
    //   1917: aload 4
    //   1919: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1922: ifeq +18 -> 1940
    //   1925: aload_0
    //   1926: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1929: invokevirtual 1106	java/util/HashMap:clear	()V
    //   1932: aload_0
    //   1933: iconst_1
    //   1934: putfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   1937: goto -1641 -> 296
    //   1940: ldc_w 1108
    //   1943: aload 4
    //   1945: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1948: ifeq +77 -> 2025
    //   1951: aload_1
    //   1952: ifnull -1656 -> 296
    //   1955: aload_1
    //   1956: ldc_w 663
    //   1959: iconst_0
    //   1960: invokevirtual 930	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1963: istore 6
    //   1965: aload_0
    //   1966: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1969: iload 6
    //   1971: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1974: invokevirtual 919	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1977: checkcast 616	bhxt
    //   1980: astore_1
    //   1981: aload_1
    //   1982: ifnull -1686 -> 296
    //   1985: aload_1
    //   1986: getfield 645	bhxt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1989: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1992: ifne -1696 -> 296
    //   1995: new 303	java/io/File
    //   1998: dup
    //   1999: aload_1
    //   2000: getfield 645	bhxt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2003: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   2006: astore_2
    //   2007: aload_0
    //   2008: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxr	Lwxr;
    //   2011: aload_1
    //   2012: getfield 645	bhxt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2015: aload_2
    //   2016: invokevirtual 1109	java/io/File:getName	()Ljava/lang/String;
    //   2019: invokevirtual 1071	wxr:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2022: goto -1726 -> 296
    //   2025: ldc_w 1111
    //   2028: aload 4
    //   2030: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2033: ifeq +94 -> 2127
    //   2036: aload_1
    //   2037: ifnull +78 -> 2115
    //   2040: ldc_w 279
    //   2043: ldc_w 1113
    //   2046: aload_1
    //   2047: invokestatic 1118	ved:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   2050: aload_1
    //   2051: ldc_w 1120
    //   2054: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2057: astore_2
    //   2058: aload_1
    //   2059: ldc_w 1122
    //   2062: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2065: astore_3
    //   2066: aload_1
    //   2067: ldc_w 1124
    //   2070: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2073: astore 4
    //   2075: aload_1
    //   2076: ldc_w 1126
    //   2079: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2082: astore_1
    //   2083: aload_0
    //   2084: aload_0
    //   2085: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   2088: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
    //   2091: aload_2
    //   2092: aload_3
    //   2093: aload_0
    //   2094: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2097: aload 4
    //   2099: aload_0
    //   2100: getfield 886	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2103: aload_1
    //   2104: invokestatic 1131	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2107: bipush 6
    //   2109: invokevirtual 913	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2112: goto -1816 -> 296
    //   2115: ldc_w 279
    //   2118: ldc_w 1133
    //   2121: invokestatic 1134	ved:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2124: goto -1828 -> 296
    //   2127: ldc_w 1136
    //   2130: aload 4
    //   2132: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2135: ifeq +186 -> 2321
    //   2138: new 242	org/json/JSONObject
    //   2141: dup
    //   2142: aload 5
    //   2144: iconst_0
    //   2145: aaload
    //   2146: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2149: ldc_w 1138
    //   2152: invokevirtual 1139	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2155: astore_2
    //   2156: aload_2
    //   2157: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2160: istore 14
    //   2162: iload 14
    //   2164: ifne -1868 -> 296
    //   2167: lconst_0
    //   2168: lstore 8
    //   2170: aload_2
    //   2171: invokestatic 1142	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2174: lstore 10
    //   2176: lload 10
    //   2178: lstore 8
    //   2180: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2183: ifeq +31 -> 2214
    //   2186: ldc_w 279
    //   2189: iconst_2
    //   2190: new 34	java/lang/StringBuilder
    //   2193: dup
    //   2194: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2197: ldc_w 1144
    //   2200: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: lload 8
    //   2205: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2208: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2211: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2214: lload 8
    //   2216: lconst_0
    //   2217: lcmp
    //   2218: ifle +67 -> 2285
    //   2221: aload_0
    //   2222: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   2225: ifnull +55 -> 2280
    //   2228: aload_0
    //   2229: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   2232: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
    //   2235: astore_1
    //   2236: aload_1
    //   2237: aconst_null
    //   2238: aload_2
    //   2239: invokestatic 1149	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2242: aload_1
    //   2243: ifnull -1947 -> 296
    //   2246: aload_1
    //   2247: ldc_w 1150
    //   2250: ldc_w 1151
    //   2253: invokevirtual 1154	android/app/Activity:overridePendingTransition	(II)V
    //   2256: goto -1960 -> 296
    //   2259: astore_1
    //   2260: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2263: ifeq -1967 -> 296
    //   2266: ldc_w 279
    //   2269: iconst_2
    //   2270: ldc_w 1156
    //   2273: aload_1
    //   2274: invokestatic 1060	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2277: goto -1981 -> 296
    //   2280: aconst_null
    //   2281: astore_1
    //   2282: goto -46 -> 2236
    //   2285: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2288: ifeq -1992 -> 296
    //   2291: ldc_w 279
    //   2294: iconst_2
    //   2295: new 34	java/lang/StringBuilder
    //   2298: dup
    //   2299: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2302: ldc_w 1158
    //   2305: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2308: aload_2
    //   2309: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2312: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2315: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2318: goto -2022 -> 296
    //   2321: ldc_w 1160
    //   2324: aload 4
    //   2326: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2329: ifeq +245 -> 2574
    //   2332: new 242	org/json/JSONObject
    //   2335: dup
    //   2336: aload 5
    //   2338: iconst_0
    //   2339: aaload
    //   2340: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2343: astore_1
    //   2344: aload_1
    //   2345: ldc_w 1162
    //   2348: invokevirtual 1139	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2351: astore_2
    //   2352: aload_2
    //   2353: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2356: istore 14
    //   2358: iload 14
    //   2360: ifne -2064 -> 296
    //   2363: aload_2
    //   2364: invokestatic 1142	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2367: lstore 10
    //   2369: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2372: ifeq +31 -> 2403
    //   2375: ldc_w 279
    //   2378: iconst_2
    //   2379: new 34	java/lang/StringBuilder
    //   2382: dup
    //   2383: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2386: ldc_w 1164
    //   2389: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: lload 10
    //   2394: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2397: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2400: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2403: aload_1
    //   2404: ldc_w 1138
    //   2407: invokevirtual 1139	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2410: astore_1
    //   2411: lconst_0
    //   2412: lstore 8
    //   2414: aload_1
    //   2415: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2418: istore 14
    //   2420: lload 8
    //   2422: lstore 12
    //   2424: iload 14
    //   2426: ifne +55 -> 2481
    //   2429: aload_1
    //   2430: invokestatic 1142	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2433: lstore 12
    //   2435: lload 12
    //   2437: lstore 8
    //   2439: lload 8
    //   2441: lstore 12
    //   2443: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2446: ifeq +35 -> 2481
    //   2449: ldc_w 279
    //   2452: iconst_2
    //   2453: new 34	java/lang/StringBuilder
    //   2456: dup
    //   2457: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2460: ldc_w 1144
    //   2463: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: lload 8
    //   2468: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2471: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2474: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2496: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   2499: ifnull +70 -> 2569
    //   2502: aload_0
    //   2503: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   2506: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
    //   2509: astore_1
    //   2510: aload_0
    //   2511: aload_1
    //   2512: lload 12
    //   2514: lload 10
    //   2516: invokestatic 1169	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2519: bipush 7
    //   2521: invokevirtual 913	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2524: aload_1
    //   2525: ifnull -2229 -> 296
    //   2528: aload_1
    //   2529: ldc_w 1150
    //   2532: ldc_w 1151
    //   2535: invokevirtual 1154	android/app/Activity:overridePendingTransition	(II)V
    //   2538: goto -2242 -> 296
    //   2541: astore_1
    //   2542: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2545: ifeq -2249 -> 296
    //   2548: ldc_w 279
    //   2551: iconst_2
    //   2552: ldc_w 1156
    //   2555: aload_1
    //   2556: invokestatic 1060	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2559: goto -2263 -> 296
    //   2562: astore_2
    //   2563: lconst_0
    //   2564: lstore 10
    //   2566: goto -197 -> 2369
    //   2569: aconst_null
    //   2570: astore_1
    //   2571: goto -61 -> 2510
    //   2574: ldc_w 1171
    //   2577: aload 4
    //   2579: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2582: ifeq -2286 -> 296
    //   2585: new 242	org/json/JSONObject
    //   2588: dup
    //   2589: aload 5
    //   2591: iconst_0
    //   2592: aaload
    //   2593: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2596: astore_2
    //   2597: aload_2
    //   2598: ldc_w 1162
    //   2601: invokevirtual 1139	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2604: astore_1
    //   2605: aload_2
    //   2606: ldc_w 1138
    //   2609: invokevirtual 1139	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2612: astore_2
    //   2613: aload_1
    //   2614: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2617: ifne +211 -> 2828
    //   2620: aload_2
    //   2621: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2624: istore 14
    //   2626: iload 14
    //   2628: ifne +200 -> 2828
    //   2631: aload_1
    //   2632: invokestatic 1142	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2635: lstore 8
    //   2637: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2640: ifeq +31 -> 2671
    //   2643: ldc_w 279
    //   2646: iconst_2
    //   2647: new 34	java/lang/StringBuilder
    //   2650: dup
    //   2651: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2654: ldc_w 1173
    //   2657: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2660: lload 8
    //   2662: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2665: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2668: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2671: lconst_0
    //   2672: lstore 10
    //   2674: aload_2
    //   2675: invokestatic 1142	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2678: lstore 12
    //   2680: lload 12
    //   2682: lstore 10
    //   2684: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2687: ifeq +31 -> 2718
    //   2690: ldc_w 279
    //   2693: iconst_2
    //   2694: new 34	java/lang/StringBuilder
    //   2697: dup
    //   2698: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2701: ldc_w 1175
    //   2704: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: lload 10
    //   2709: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2712: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2715: invokestatic 941	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2718: lload 8
    //   2720: lconst_0
    //   2721: lcmp
    //   2722: ifle -2426 -> 296
    //   2725: lload 10
    //   2727: lconst_0
    //   2728: lcmp
    //   2729: ifle -2433 -> 296
    //   2732: aload_0
    //   2733: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   2736: ifnull +87 -> 2823
    //   2739: aload_0
    //   2740: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdp;
    //   2743: invokevirtual 571	bcdp:a	()Landroid/app/Activity;
    //   2746: astore_1
    //   2747: new 721	android/os/Bundle
    //   2750: dup
    //   2751: invokespecial 1176	android/os/Bundle:<init>	()V
    //   2754: astore_3
    //   2755: aload_3
    //   2756: ldc_w 1162
    //   2759: lload 8
    //   2761: invokevirtual 1180	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2764: aload_3
    //   2765: ldc_w 1182
    //   2768: iconst_2
    //   2769: invokevirtual 1186	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2772: aload_1
    //   2773: aload_3
    //   2774: aload_2
    //   2775: invokestatic 1149	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2778: aload_1
    //   2779: ifnull -2483 -> 296
    //   2782: aload_1
    //   2783: ldc_w 1150
    //   2786: ldc_w 1151
    //   2789: invokevirtual 1154	android/app/Activity:overridePendingTransition	(II)V
    //   2792: goto -2496 -> 296
    //   2795: astore_1
    //   2796: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2799: ifeq -2503 -> 296
    //   2802: ldc_w 279
    //   2805: iconst_2
    //   2806: ldc_w 1156
    //   2809: aload_1
    //   2810: invokestatic 1060	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2813: goto -2517 -> 296
    //   2816: astore_1
    //   2817: lconst_0
    //   2818: lstore 8
    //   2820: goto -183 -> 2637
    //   2823: aconst_null
    //   2824: astore_1
    //   2825: goto -78 -> 2747
    //   2828: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2831: ifeq -2535 -> 296
    //   2834: ldc_w 279
    //   2837: iconst_2
    //   2838: new 34	java/lang/StringBuilder
    //   2841: dup
    //   2842: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2845: ldc_w 1188
    //   2848: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: aload_1
    //   2852: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: ldc_w 1190
    //   2858: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2861: aload_2
    //   2862: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2868: invokestatic 981	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2871: goto -2575 -> 296
    //   2874: astore_1
    //   2875: goto -695 -> 2180
    //   2878: astore_1
    //   2879: goto -440 -> 2439
    //   2882: astore_1
    //   2883: goto -199 -> 2684
    //   2886: ldc_w 477
    //   2889: astore_1
    //   2890: goto -1897 -> 993
    //   2893: ldc_w 477
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
                localObject1 = new bhxs(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
                paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (bhxs)localObject1, 0);
                this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
                paramIntent.jdField_a_of_type_Bhxj.a();
                this.jdField_d_of_type_Int += 1;
                return;
              }
            } while (paramInt != -1);
            localHashMap1 = new HashMap();
            localHashMap2 = new HashMap();
            if ((paramByte == 2) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
            {
              bbef.a(this.mRuntime.a(), this.jdField_c_of_type_JavaLangString);
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
                  if (bbbx.a((LocalMediaInfo)paramIntent.get(localObject3)) != 1) {
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
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new bhxs(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
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
    this.jdField_a_of_type_Wxr = wxr.a();
    this.jdField_a_of_type_Wxr.a();
    this.jdField_a_of_type_Bhxx = new bhxx(this.mRuntime.a(), this);
    this.jdField_a_of_type_Bhxk = new bhxk(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    int k = 0;
    if (this.jdField_a_of_type_Wxr != null) {
      this.jdField_a_of_type_Wxr.b();
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Bhxk != null) {
      this.jdField_a_of_type_Bhxk.a(this.mRuntime.a());
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
      localObject1 = new VFSFile(ajsd.bs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */