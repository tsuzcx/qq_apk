package cooperation.troop_homework.jsp;

import ajsf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bahk;
import bbbj;
import bbca;
import bbdr;
import bbuv;
import bcdb;
import bcpw;
import bdhv;
import bfol;
import bhws;
import bhwt;
import bhwv;
import bhww;
import bhwx;
import bhwy;
import bhwz;
import bhxa;
import bhxb;
import bhxc;
import bhxg;
import bhxi;
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
import lko;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;
import wxu;
import wxw;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements bhwv, bhxi, wxw
{
  public static final String a;
  int jdField_a_of_type_Int = 540;
  private Handler jdField_a_of_type_AndroidOsHandler = new bhwz(this);
  bfol jdField_a_of_type_Bfol = null;
  private bhwt jdField_a_of_type_Bhwt;
  bhxg jdField_a_of_type_Bhxg = null;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  wxu jdField_a_of_type_Wxu = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 540;
  String jdField_b_of_type_JavaLangString;
  HashMap<Integer, bhxc> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    jdField_a_of_type_JavaLangString = ajsf.bs + "homeworkTmp/";
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
    //   496: invokestatic 407	bbca:encodeToString	([BI)Ljava/lang/String;
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
    //   673: invokestatic 440	apvb:a	(Ljava/lang/String;)Ljava/lang/String;
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
    if (lko.b(BaseApplicationImpl.getContext())) {}
    BaseApplication localBaseApplication;
    String str;
    Intent localIntent;
    do
    {
      return localObject;
      localBaseApplication = BaseApplicationImpl.getContext();
      str = bbuv.a(ajsf.bc + System.currentTimeMillis() + ".jpg");
      localObject = new File(str).getParentFile();
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        bcpw.a(localBaseApplication, 2131719044, 0).a();
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
      bcpw.a(localBaseApplication, 2131690593, 0).a();
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
    //   39: invokestatic 407	bbca:encodeToString	([BI)Ljava/lang/String;
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
          localStringBuilder.append(bbca.encodeToString(arrayOfByte2, 2));
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
      localStringBuilder.append(bbca.encodeToString(arrayOfByte1, 2));
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
    localObject = new VFSFile(ajsf.bs);
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
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
      return;
    }
    bfol localbfol = bfol.a(this.mRuntime.a());
    localbfol.a(2131719267, 1);
    localbfol.a(2131719256, 1);
    localbfol.c(2131690596);
    localbfol.a(new bhww(this, paramInt, localbfol));
    localbfol.show();
    this.jdField_a_of_type_Bfol = localbfol;
  }
  
  private void f(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.a())
    {
      bcpw.a(BaseApplicationImpl.getContext(), 2131690593, 0).a();
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
        ((AppActivity)localActivity).requestPermissions(new bhwx(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
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
  
  public bhxc a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, bhxb parambhxb, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    bhxc localbhxc = new bhxc(paramTroopHWJsPlugin);
    localbhxc.jdField_a_of_type_Int = paramInt1;
    localbhxc.jdField_a_of_type_Bhxb = parambhxb;
    localbhxc.jdField_a_of_type_Bhws = new bhws(paramTroopHWJsPlugin.mRuntime.a(), paramString, parambhxb.jdField_b_of_type_JavaLangString);
    localbhxc.jdField_a_of_type_Bhws.a(localbhxc.jdField_a_of_type_Bhwr);
    localbhxc.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    localbhxc.jdField_b_of_type_JavaLangString = paramString;
    localbhxc.jdField_b_of_type_Int = paramInt2;
    return localbhxc;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = bdhv.d(paramString2) + bahk.a(paramString2);
    paramString1 = bbuv.a(ajsf.bt + paramString1 + File.separator);
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
        ((AppActivity)localActivity).requestPermissions(new bhwy(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
        ((AppActivity)localActivity).requestPermissions(new bhxa(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhxg.a();
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
    //   32: aload_1
    //   33: ifnull +102 -> 135
    //   36: aload_1
    //   37: ldc_w 861
    //   40: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 15
    //   45: aload_1
    //   46: ldc_w 665
    //   49: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 16
    //   54: aload_0
    //   55: aload 15
    //   57: putfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   60: aload_0
    //   61: aload 16
    //   63: putfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   71: aload_0
    //   72: aload_1
    //   73: ldc_w 866
    //   76: ldc_w 477
    //   79: invokevirtual 868	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: putfield 870	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload_0
    //   86: aload_1
    //   87: ldc_w 872
    //   90: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   93: putfield 58	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Int	I
    //   96: aload_0
    //   97: aload_1
    //   98: ldc_w 877
    //   101: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   135: ldc_w 879
    //   138: aload 4
    //   140: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +79 -> 222
    //   146: aload_0
    //   147: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   150: invokevirtual 571	bcdb:a	()Landroid/app/Activity;
    //   153: astore_1
    //   154: new 131	android/content/Intent
    //   157: dup
    //   158: invokespecial 132	android/content/Intent:<init>	()V
    //   161: astore_2
    //   162: aload_2
    //   163: new 881	android/content/ComponentName
    //   166: dup
    //   167: aload_1
    //   168: ldc_w 883
    //   171: invokespecial 886	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   174: invokevirtual 890	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   177: pop
    //   178: aload_2
    //   179: ldc_w 665
    //   182: aload_0
    //   183: getfield 209	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   186: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   189: pop
    //   190: aload_0
    //   191: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   194: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +16 -> 213
    //   200: aload_1
    //   201: aload_2
    //   202: invokevirtual 894	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -178 -> 32
    //   213: aload_0
    //   214: aload_2
    //   215: iconst_1
    //   216: invokevirtual 897	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   219: goto -14 -> 205
    //   222: ldc_w 899
    //   225: aload 4
    //   227: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +107 -> 337
    //   233: aload_1
    //   234: ifnull +2584 -> 2818
    //   237: aload_1
    //   238: ldc_w 663
    //   241: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   244: istore 6
    //   246: aload_0
    //   247: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   250: iconst_m1
    //   251: if_icmpne +36 -> 287
    //   254: aload_0
    //   255: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   258: iload 6
    //   260: aload_0
    //   261: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   264: iload 6
    //   266: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: invokevirtual 903	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 263	java/lang/String
    //   275: invokevirtual 905	bhxg:a	(ILjava/lang/String;)V
    //   278: aload_0
    //   279: iload 6
    //   281: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   284: goto -79 -> 205
    //   287: iload 6
    //   289: aload_0
    //   290: getfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   293: if_icmpeq -88 -> 205
    //   296: aload_0
    //   297: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   300: invokevirtual 846	bhxg:a	()Z
    //   303: pop
    //   304: aload_0
    //   305: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   308: iload 6
    //   310: aload_0
    //   311: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   314: iload 6
    //   316: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: invokevirtual 903	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 263	java/lang/String
    //   325: invokevirtual 905	bhxg:a	(ILjava/lang/String;)V
    //   328: aload_0
    //   329: iload 6
    //   331: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   334: goto -129 -> 205
    //   337: ldc_w 907
    //   340: aload 4
    //   342: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   345: ifeq +52 -> 397
    //   348: iconst_m1
    //   349: istore 6
    //   351: aload_1
    //   352: ifnull +12 -> 364
    //   355: aload_1
    //   356: ldc_w 663
    //   359: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   382: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   385: invokevirtual 846	bhxg:a	()Z
    //   388: pop
    //   389: aload_0
    //   390: iconst_m1
    //   391: putfield 76	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_Int	I
    //   394: goto -189 -> 205
    //   397: ldc_w 909
    //   400: aload 4
    //   402: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   405: ifeq +204 -> 609
    //   408: bipush 10
    //   410: istore 7
    //   412: iconst_0
    //   413: istore 6
    //   415: aload_1
    //   416: ifnull +34 -> 450
    //   419: aload_1
    //   420: ldc_w 911
    //   423: bipush 10
    //   425: invokevirtual 914	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   428: istore 7
    //   430: aload_0
    //   431: aload_1
    //   432: ldc_w 872
    //   435: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   438: putfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_c_of_type_Int	I
    //   441: aload_1
    //   442: ldc_w 916
    //   445: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   448: istore 6
    //   450: iload 6
    //   452: iconst_1
    //   453: if_icmpne +13 -> 466
    //   456: aload_0
    //   457: sipush 29954
    //   460: invokespecial 554	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	(I)V
    //   463: goto -258 -> 205
    //   466: iload 6
    //   468: iconst_2
    //   469: if_icmpne +12 -> 481
    //   472: aload_0
    //   473: iload 7
    //   475: invokevirtual 918	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   478: goto -273 -> 205
    //   481: iload 6
    //   483: iconst_3
    //   484: if_icmpne +116 -> 600
    //   487: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   490: ifeq +30 -> 520
    //   493: ldc_w 279
    //   496: iconst_2
    //   497: new 34	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 920
    //   507: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_1
    //   511: invokevirtual 923	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_0
    //   521: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   524: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   527: ifne +13 -> 540
    //   530: aload_0
    //   531: getfield 870	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   534: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   537: ifeq +54 -> 591
    //   540: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +46 -> 589
    //   546: ldc_w 279
    //   549: iconst_2
    //   550: new 34	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 927
    //   560: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_0
    //   564: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   567: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w 929
    //   573: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload_0
    //   577: getfield 870	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   580: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: iconst_1
    //   590: ireturn
    //   591: aload_0
    //   592: iload 7
    //   594: invokevirtual 930	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   597: goto -392 -> 205
    //   600: aload_0
    //   601: iload 7
    //   603: invokespecial 932	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(I)V
    //   606: goto -401 -> 205
    //   609: ldc_w 934
    //   612: aload 4
    //   614: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   617: ifeq +191 -> 808
    //   620: lconst_0
    //   621: lstore 8
    //   623: bipush 102
    //   625: istore 6
    //   627: aconst_null
    //   628: astore 5
    //   630: aconst_null
    //   631: astore 4
    //   633: aconst_null
    //   634: astore_3
    //   635: aconst_null
    //   636: astore_2
    //   637: aload_1
    //   638: ifnull +2175 -> 2813
    //   641: aload_1
    //   642: ldc_w 936
    //   645: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   648: astore 5
    //   650: aload_1
    //   651: ldc_w 938
    //   654: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   657: astore 4
    //   659: aload_1
    //   660: ldc_w 866
    //   663: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   666: astore 15
    //   668: aload_1
    //   669: ldc_w 940
    //   672: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   675: astore_3
    //   676: aload_1
    //   677: ldc_w 942
    //   680: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   683: astore_2
    //   684: aload 15
    //   686: astore_1
    //   687: aload_3
    //   688: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   691: ifne +12 -> 703
    //   694: aload_3
    //   695: invokestatic 947	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   698: invokevirtual 950	java/lang/Long:longValue	()J
    //   701: lstore 8
    //   703: aload_2
    //   704: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   707: ifne +12 -> 719
    //   710: aload_2
    //   711: invokestatic 953	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   714: invokevirtual 956	java/lang/Integer:intValue	()I
    //   717: istore 6
    //   719: aload_1
    //   720: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   723: ifne +66 -> 789
    //   726: aload_0
    //   727: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   730: aload_1
    //   731: invokestatic 947	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   734: invokevirtual 950	java/lang/Long:longValue	()J
    //   737: aload 4
    //   739: aload 5
    //   741: lload 8
    //   743: iload 6
    //   745: aload_0
    //   746: invokevirtual 961	wxu:a	(JLjava/lang/String;Ljava/lang/String;JILwxw;)V
    //   749: goto -544 -> 205
    //   752: astore_2
    //   753: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   756: ifeq -551 -> 205
    //   759: ldc_w 279
    //   762: iconst_2
    //   763: new 34	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   770: ldc_w 963
    //   773: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload_1
    //   777: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokestatic 965	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: goto -581 -> 205
    //   789: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   792: ifeq -587 -> 205
    //   795: ldc_w 279
    //   798: iconst_2
    //   799: ldc_w 967
    //   802: invokestatic 965	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   805: goto -600 -> 205
    //   808: ldc_w 969
    //   811: aload 4
    //   813: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifeq +77 -> 893
    //   819: ldc_w 477
    //   822: astore_2
    //   823: aload_1
    //   824: ifnull +11 -> 835
    //   827: aload_1
    //   828: ldc_w 671
    //   831: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   834: astore_2
    //   835: aload_0
    //   836: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   839: ifnonnull +19 -> 858
    //   842: aload_0
    //   843: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   846: aload_2
    //   847: invokevirtual 971	bhxg:b	(Ljava/lang/String;)V
    //   850: aload_0
    //   851: aload_2
    //   852: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   855: goto -650 -> 205
    //   858: aload_0
    //   859: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   862: aload_2
    //   863: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   866: ifne -661 -> 205
    //   869: aload_0
    //   870: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   873: invokevirtual 846	bhxg:a	()Z
    //   876: pop
    //   877: aload_0
    //   878: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   881: aload_2
    //   882: invokevirtual 971	bhxg:b	(Ljava/lang/String;)V
    //   885: aload_0
    //   886: aload_2
    //   887: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   890: goto -685 -> 205
    //   893: ldc_w 973
    //   896: aload 4
    //   898: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   901: ifeq +53 -> 954
    //   904: ldc_w 477
    //   907: astore_2
    //   908: aload_1
    //   909: ifnull +11 -> 920
    //   912: aload_1
    //   913: ldc_w 671
    //   916: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   919: astore_2
    //   920: aload_0
    //   921: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   924: ifnull -719 -> 205
    //   927: aload_0
    //   928: getfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   931: aload_2
    //   932: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   935: ifeq -730 -> 205
    //   938: aload_0
    //   939: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   942: invokevirtual 846	bhxg:a	()Z
    //   945: pop
    //   946: aload_0
    //   947: aconst_null
    //   948: putfield 74	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   951: goto -746 -> 205
    //   954: ldc_w 975
    //   957: aload 4
    //   959: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   962: ifeq +23 -> 985
    //   965: aload_0
    //   966: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   969: aload_0
    //   970: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   973: invokevirtual 626	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   976: invokevirtual 978	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   979: invokevirtual 980	bhxg:e	(Ljava/lang/String;)V
    //   982: goto -777 -> 205
    //   985: ldc_w 982
    //   988: aload 4
    //   990: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   993: ifeq +39 -> 1032
    //   996: aload_1
    //   997: ifnull +25 -> 1022
    //   1000: aload_0
    //   1001: aload_1
    //   1002: ldc_w 984
    //   1005: invokevirtual 988	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1008: putfield 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_Boolean	Z
    //   1011: aload_0
    //   1012: aload_1
    //   1013: ldc_w 990
    //   1016: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1019: putfield 82	cooperation/troop_homework/jsp/TroopHWJsPlugin:h	Ljava/lang/String;
    //   1022: aload_0
    //   1023: getfield 72	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhxg	Lbhxg;
    //   1026: invokevirtual 992	bhxg:b	()V
    //   1029: goto -824 -> 205
    //   1032: ldc_w 994
    //   1035: aload 4
    //   1037: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1040: ifeq +25 -> 1065
    //   1043: new 996	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1046: dup
    //   1047: aload_0
    //   1048: aload_2
    //   1049: invokestatic 999	ayog:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1052: invokespecial 1000	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1055: bipush 8
    //   1057: aconst_null
    //   1058: iconst_0
    //   1059: invokestatic 801	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1062: goto -857 -> 205
    //   1065: ldc_w 1002
    //   1068: aload 4
    //   1070: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1073: ifeq +54 -> 1127
    //   1076: aload_1
    //   1077: ifnull -872 -> 205
    //   1080: aload_1
    //   1081: ldc_w 671
    //   1084: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1087: astore_2
    //   1088: aload_1
    //   1089: ldc_w 1004
    //   1092: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1095: astore_3
    //   1096: aload_0
    //   1097: aload_1
    //   1098: ldc_w 861
    //   1101: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1104: putfield 808	cooperation/troop_homework/jsp/TroopHWJsPlugin:i	Ljava/lang/String;
    //   1107: aload_0
    //   1108: aload_3
    //   1109: aload_2
    //   1110: invokevirtual 811	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1113: astore_1
    //   1114: aload_0
    //   1115: getfield 1006	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhwt	Lbhwt;
    //   1118: aload_2
    //   1119: aload_1
    //   1120: aload_0
    //   1121: invokevirtual 1011	bhwt:a	(Ljava/lang/String;Ljava/lang/String;Lbhwv;)V
    //   1124: goto -919 -> 205
    //   1127: ldc_w 1013
    //   1130: aload 4
    //   1132: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1135: ifeq +26 -> 1161
    //   1138: aload_1
    //   1139: ifnull -934 -> 205
    //   1142: aload_1
    //   1143: ldc_w 671
    //   1146: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1149: astore_1
    //   1150: aload_0
    //   1151: getfield 1006	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Bhwt	Lbhwt;
    //   1154: aload_1
    //   1155: invokevirtual 1014	bhwt:a	(Ljava/lang/String;)V
    //   1158: goto -953 -> 205
    //   1161: ldc_w 1016
    //   1164: aload 4
    //   1166: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1169: ifeq +194 -> 1363
    //   1172: aload_1
    //   1173: ifnull -968 -> 205
    //   1176: aload_1
    //   1177: ldc_w 1004
    //   1180: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1183: astore 4
    //   1185: aload_1
    //   1186: ldc_w 1018
    //   1189: invokevirtual 1022	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1192: astore 5
    //   1194: aload_1
    //   1195: ldc_w 861
    //   1198: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1201: astore_2
    //   1202: new 242	org/json/JSONObject
    //   1205: dup
    //   1206: invokespecial 661	org/json/JSONObject:<init>	()V
    //   1209: astore_3
    //   1210: new 1024	org/json/JSONArray
    //   1213: dup
    //   1214: invokespecial 1025	org/json/JSONArray:<init>	()V
    //   1217: astore 15
    //   1219: aload 5
    //   1221: invokevirtual 1027	org/json/JSONArray:length	()I
    //   1224: istore 7
    //   1226: iconst_0
    //   1227: istore 6
    //   1229: iload 6
    //   1231: iload 7
    //   1233: if_icmpge +33 -> 1266
    //   1236: aload 15
    //   1238: iload 6
    //   1240: aload_0
    //   1241: aload 4
    //   1243: aload 5
    //   1245: iload 6
    //   1247: invokevirtual 1030	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1250: invokevirtual 1032	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1253: invokevirtual 1035	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1256: pop
    //   1257: iload 6
    //   1259: iconst_1
    //   1260: iadd
    //   1261: istore 6
    //   1263: goto -34 -> 1229
    //   1266: aload_3
    //   1267: ldc_w 1037
    //   1270: aload 15
    //   1272: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1275: pop
    //   1276: aload_3
    //   1277: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1280: astore_3
    //   1281: aload_0
    //   1282: aload_2
    //   1283: iconst_1
    //   1284: anewarray 263	java/lang/String
    //   1287: dup
    //   1288: iconst_0
    //   1289: aload_3
    //   1290: aastore
    //   1291: invokevirtual 268	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1294: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1297: ifeq -1092 -> 205
    //   1300: ldc_w 279
    //   1303: iconst_2
    //   1304: new 34	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1311: ldc_w 1039
    //   1314: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: aload_1
    //   1318: invokevirtual 923	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1321: ldc_w 1041
    //   1324: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: aload_3
    //   1328: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1337: goto -1132 -> 205
    //   1340: astore 4
    //   1342: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1345: ifeq -69 -> 1276
    //   1348: ldc_w 279
    //   1351: iconst_2
    //   1352: ldc_w 1039
    //   1355: aload 4
    //   1357: invokestatic 1044	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1360: goto -84 -> 1276
    //   1363: ldc_w 1046
    //   1366: aload 4
    //   1368: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1371: ifeq +68 -> 1439
    //   1374: aload_1
    //   1375: ifnull -1170 -> 205
    //   1378: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1381: ifeq +30 -> 1411
    //   1384: ldc_w 279
    //   1387: iconst_2
    //   1388: new 34	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1395: ldc_w 1048
    //   1398: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: aload_1
    //   1402: invokevirtual 923	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1405: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1408: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1411: aload_1
    //   1412: ldc_w 1050
    //   1415: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1418: astore_2
    //   1419: aload_1
    //   1420: ldc_w 1052
    //   1423: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1426: astore_1
    //   1427: aload_0
    //   1428: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   1431: aload_2
    //   1432: aload_1
    //   1433: invokevirtual 1055	wxu:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1436: goto -1231 -> 205
    //   1439: ldc_w 1057
    //   1442: aload 4
    //   1444: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1447: ifeq +58 -> 1505
    //   1450: aload_1
    //   1451: ifnull +54 -> 1505
    //   1454: aload_1
    //   1455: ldc_w 673
    //   1458: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1461: pop
    //   1462: aload_1
    //   1463: ldc_w 663
    //   1466: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1469: istore 6
    //   1471: aload_0
    //   1472: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1475: iload 6
    //   1477: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1480: invokevirtual 903	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1483: checkcast 616	bhxc
    //   1486: astore_1
    //   1487: aload_1
    //   1488: ifnull -1283 -> 205
    //   1491: aload_1
    //   1492: getfield 1058	bhxc:jdField_a_of_type_Boolean	Z
    //   1495: ifne -1290 -> 205
    //   1498: aload_1
    //   1499: invokevirtual 1059	bhxc:b	()V
    //   1502: goto -1297 -> 205
    //   1505: ldc_w 1061
    //   1508: aload 4
    //   1510: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1513: ifeq +62 -> 1575
    //   1516: aload_1
    //   1517: ifnull +58 -> 1575
    //   1520: aload_1
    //   1521: ldc_w 673
    //   1524: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1527: pop
    //   1528: aload_1
    //   1529: ldc_w 663
    //   1532: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1535: istore 6
    //   1537: aload_0
    //   1538: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1541: iload 6
    //   1543: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1546: invokevirtual 903	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1549: checkcast 616	bhxc
    //   1552: astore_1
    //   1553: aload_1
    //   1554: ifnull -1349 -> 205
    //   1557: aload_1
    //   1558: getfield 1058	bhxc:jdField_a_of_type_Boolean	Z
    //   1561: ifeq -1356 -> 205
    //   1564: aload_1
    //   1565: getfield 1064	bhxc:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1568: iconst_1
    //   1569: invokevirtual 1070	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1572: goto -1367 -> 205
    //   1575: ldc_w 1072
    //   1578: aload 4
    //   1580: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1583: ifeq +83 -> 1666
    //   1586: aload_1
    //   1587: ifnull -1382 -> 205
    //   1590: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1593: ifeq +24 -> 1617
    //   1596: ldc_w 279
    //   1599: iconst_2
    //   1600: iconst_2
    //   1601: anewarray 142	java/lang/Object
    //   1604: dup
    //   1605: iconst_0
    //   1606: ldc_w 1074
    //   1609: aastore
    //   1610: dup
    //   1611: iconst_1
    //   1612: aload_1
    //   1613: aastore
    //   1614: invokestatic 418	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1617: aload_1
    //   1618: ldc_w 1004
    //   1621: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1624: astore_2
    //   1625: aload_1
    //   1626: ldc_w 673
    //   1629: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1632: astore_1
    //   1633: aload_0
    //   1634: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   1637: aload_2
    //   1638: aload_1
    //   1639: invokevirtual 1076	wxu:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1642: goto -1437 -> 205
    //   1645: astore_1
    //   1646: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1649: ifeq -1444 -> 205
    //   1652: ldc_w 279
    //   1655: iconst_2
    //   1656: ldc_w 1078
    //   1659: aload_1
    //   1660: invokestatic 1044	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1663: goto -1458 -> 205
    //   1666: ldc_w 1080
    //   1669: aload 4
    //   1671: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1674: ifeq +167 -> 1841
    //   1677: aload_1
    //   1678: ifnull -1473 -> 205
    //   1681: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1684: ifeq +30 -> 1714
    //   1687: ldc_w 279
    //   1690: iconst_2
    //   1691: new 34	java/lang/StringBuilder
    //   1694: dup
    //   1695: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1698: ldc_w 1082
    //   1701: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: aload_1
    //   1705: invokevirtual 923	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1708: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1711: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1714: aload_1
    //   1715: ldc_w 663
    //   1718: iconst_0
    //   1719: invokevirtual 914	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1722: istore 6
    //   1724: aload_0
    //   1725: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1728: iload 6
    //   1730: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1733: invokevirtual 903	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1736: checkcast 616	bhxc
    //   1739: astore_2
    //   1740: aload_2
    //   1741: ifnull +70 -> 1811
    //   1744: aload_2
    //   1745: getfield 645	bhxc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1748: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1751: ifne +60 -> 1811
    //   1754: new 726	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1757: dup
    //   1758: invokespecial 727	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1761: astore_1
    //   1762: aload_1
    //   1763: aload_2
    //   1764: getfield 645	bhxc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1767: invokevirtual 748	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1770: new 131	android/content/Intent
    //   1773: dup
    //   1774: aload_0
    //   1775: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   1778: invokevirtual 571	bcdb:a	()Landroid/app/Activity;
    //   1781: ldc_w 762
    //   1784: invokespecial 1083	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1787: astore_2
    //   1788: aload_2
    //   1789: ldc_w 764
    //   1792: aload_1
    //   1793: invokevirtual 767	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1796: pop
    //   1797: aload_0
    //   1798: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   1801: invokevirtual 571	bcdb:a	()Landroid/app/Activity;
    //   1804: aload_2
    //   1805: invokevirtual 894	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1808: goto -1603 -> 205
    //   1811: ldc_w 279
    //   1814: iconst_1
    //   1815: new 34	java/lang/StringBuilder
    //   1818: dup
    //   1819: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1822: ldc_w 1085
    //   1825: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: aload_2
    //   1829: invokevirtual 923	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1832: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1835: invokestatic 965	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1838: goto -1633 -> 205
    //   1841: ldc_w 1087
    //   1844: aload 4
    //   1846: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1849: ifeq +18 -> 1867
    //   1852: aload_0
    //   1853: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1856: invokevirtual 1090	java/util/HashMap:clear	()V
    //   1859: aload_0
    //   1860: iconst_1
    //   1861: putfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_d_of_type_Int	I
    //   1864: goto -1659 -> 205
    //   1867: ldc_w 1092
    //   1870: aload 4
    //   1872: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1875: ifeq +77 -> 1952
    //   1878: aload_1
    //   1879: ifnull -1674 -> 205
    //   1882: aload_1
    //   1883: ldc_w 663
    //   1886: iconst_0
    //   1887: invokevirtual 914	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1890: istore 6
    //   1892: aload_0
    //   1893: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1896: iload 6
    //   1898: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1901: invokevirtual 903	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1904: checkcast 616	bhxc
    //   1907: astore_1
    //   1908: aload_1
    //   1909: ifnull -1704 -> 205
    //   1912: aload_1
    //   1913: getfield 645	bhxc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1916: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1919: ifne -1714 -> 205
    //   1922: new 303	java/io/File
    //   1925: dup
    //   1926: aload_1
    //   1927: getfield 645	bhxc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1930: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   1933: astore_2
    //   1934: aload_0
    //   1935: getfield 70	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   1938: aload_1
    //   1939: getfield 645	bhxc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1942: aload_2
    //   1943: invokevirtual 1093	java/io/File:getName	()Ljava/lang/String;
    //   1946: invokevirtual 1055	wxu:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1949: goto -1744 -> 205
    //   1952: ldc_w 1095
    //   1955: aload 4
    //   1957: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1960: ifeq +94 -> 2054
    //   1963: aload_1
    //   1964: ifnull +78 -> 2042
    //   1967: ldc_w 279
    //   1970: ldc_w 1097
    //   1973: aload_1
    //   1974: invokestatic 1102	veg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   1977: aload_1
    //   1978: ldc_w 1104
    //   1981: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1984: astore_2
    //   1985: aload_1
    //   1986: ldc_w 1106
    //   1989: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1992: astore_3
    //   1993: aload_1
    //   1994: ldc_w 1108
    //   1997: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2000: astore 4
    //   2002: aload_1
    //   2003: ldc_w 1110
    //   2006: invokevirtual 864	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2009: astore_1
    //   2010: aload_0
    //   2011: aload_0
    //   2012: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   2015: invokevirtual 571	bcdb:a	()Landroid/app/Activity;
    //   2018: aload_2
    //   2019: aload_3
    //   2020: aload_0
    //   2021: getfield 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2024: aload 4
    //   2026: aload_0
    //   2027: getfield 870	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2030: aload_1
    //   2031: invokestatic 1115	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2034: bipush 6
    //   2036: invokevirtual 897	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2039: goto -1834 -> 205
    //   2042: ldc_w 279
    //   2045: ldc_w 1117
    //   2048: invokestatic 1118	veg:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2051: goto -1846 -> 205
    //   2054: ldc_w 1120
    //   2057: aload 4
    //   2059: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2062: ifeq +186 -> 2248
    //   2065: new 242	org/json/JSONObject
    //   2068: dup
    //   2069: aload 5
    //   2071: iconst_0
    //   2072: aaload
    //   2073: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2076: ldc_w 1122
    //   2079: invokevirtual 1123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2082: astore_2
    //   2083: aload_2
    //   2084: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2087: istore 14
    //   2089: iload 14
    //   2091: ifne -1886 -> 205
    //   2094: lconst_0
    //   2095: lstore 8
    //   2097: aload_2
    //   2098: invokestatic 1126	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2101: lstore 10
    //   2103: lload 10
    //   2105: lstore 8
    //   2107: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2110: ifeq +31 -> 2141
    //   2113: ldc_w 279
    //   2116: iconst_2
    //   2117: new 34	java/lang/StringBuilder
    //   2120: dup
    //   2121: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2124: ldc_w 1128
    //   2127: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: lload 8
    //   2132: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2135: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2138: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2141: lload 8
    //   2143: lconst_0
    //   2144: lcmp
    //   2145: ifle +67 -> 2212
    //   2148: aload_0
    //   2149: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   2152: ifnull +55 -> 2207
    //   2155: aload_0
    //   2156: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   2159: invokevirtual 571	bcdb:a	()Landroid/app/Activity;
    //   2162: astore_1
    //   2163: aload_1
    //   2164: aconst_null
    //   2165: aload_2
    //   2166: invokestatic 1133	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2169: aload_1
    //   2170: ifnull -1965 -> 205
    //   2173: aload_1
    //   2174: ldc_w 1134
    //   2177: ldc_w 1135
    //   2180: invokevirtual 1138	android/app/Activity:overridePendingTransition	(II)V
    //   2183: goto -1978 -> 205
    //   2186: astore_1
    //   2187: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2190: ifeq -1985 -> 205
    //   2193: ldc_w 279
    //   2196: iconst_2
    //   2197: ldc_w 1140
    //   2200: aload_1
    //   2201: invokestatic 1044	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2204: goto -1999 -> 205
    //   2207: aconst_null
    //   2208: astore_1
    //   2209: goto -46 -> 2163
    //   2212: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2215: ifeq -2010 -> 205
    //   2218: ldc_w 279
    //   2221: iconst_2
    //   2222: new 34	java/lang/StringBuilder
    //   2225: dup
    //   2226: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2229: ldc_w 1142
    //   2232: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: aload_2
    //   2236: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2239: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2242: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2245: goto -2040 -> 205
    //   2248: ldc_w 1144
    //   2251: aload 4
    //   2253: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2256: ifeq +245 -> 2501
    //   2259: new 242	org/json/JSONObject
    //   2262: dup
    //   2263: aload 5
    //   2265: iconst_0
    //   2266: aaload
    //   2267: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2270: astore_1
    //   2271: aload_1
    //   2272: ldc_w 1146
    //   2275: invokevirtual 1123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2278: astore_2
    //   2279: aload_2
    //   2280: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2283: istore 14
    //   2285: iload 14
    //   2287: ifne -2082 -> 205
    //   2290: aload_2
    //   2291: invokestatic 1126	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2294: lstore 10
    //   2296: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2299: ifeq +31 -> 2330
    //   2302: ldc_w 279
    //   2305: iconst_2
    //   2306: new 34	java/lang/StringBuilder
    //   2309: dup
    //   2310: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2313: ldc_w 1148
    //   2316: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: lload 10
    //   2321: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2324: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2327: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2330: aload_1
    //   2331: ldc_w 1122
    //   2334: invokevirtual 1123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2337: astore_1
    //   2338: lconst_0
    //   2339: lstore 8
    //   2341: aload_1
    //   2342: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2345: istore 14
    //   2347: lload 8
    //   2349: lstore 12
    //   2351: iload 14
    //   2353: ifne +55 -> 2408
    //   2356: aload_1
    //   2357: invokestatic 1126	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2360: lstore 12
    //   2362: lload 12
    //   2364: lstore 8
    //   2366: lload 8
    //   2368: lstore 12
    //   2370: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2373: ifeq +35 -> 2408
    //   2376: ldc_w 279
    //   2379: iconst_2
    //   2380: new 34	java/lang/StringBuilder
    //   2383: dup
    //   2384: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2387: ldc_w 1128
    //   2390: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2393: lload 8
    //   2395: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2398: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2401: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2404: lload 8
    //   2406: lstore 12
    //   2408: lload 10
    //   2410: lconst_0
    //   2411: lcmp
    //   2412: ifle -2207 -> 205
    //   2415: lload 12
    //   2417: lconst_0
    //   2418: lcmp
    //   2419: ifle -2214 -> 205
    //   2422: aload_0
    //   2423: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   2426: ifnull +70 -> 2496
    //   2429: aload_0
    //   2430: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   2433: invokevirtual 571	bcdb:a	()Landroid/app/Activity;
    //   2436: astore_1
    //   2437: aload_0
    //   2438: aload_1
    //   2439: lload 12
    //   2441: lload 10
    //   2443: invokestatic 1153	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2446: bipush 7
    //   2448: invokevirtual 897	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2451: aload_1
    //   2452: ifnull -2247 -> 205
    //   2455: aload_1
    //   2456: ldc_w 1134
    //   2459: ldc_w 1135
    //   2462: invokevirtual 1138	android/app/Activity:overridePendingTransition	(II)V
    //   2465: goto -2260 -> 205
    //   2468: astore_1
    //   2469: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2472: ifeq -2267 -> 205
    //   2475: ldc_w 279
    //   2478: iconst_2
    //   2479: ldc_w 1140
    //   2482: aload_1
    //   2483: invokestatic 1044	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2486: goto -2281 -> 205
    //   2489: astore_2
    //   2490: lconst_0
    //   2491: lstore 10
    //   2493: goto -197 -> 2296
    //   2496: aconst_null
    //   2497: astore_1
    //   2498: goto -61 -> 2437
    //   2501: ldc_w 1155
    //   2504: aload 4
    //   2506: invokevirtual 714	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2509: ifeq -2304 -> 205
    //   2512: new 242	org/json/JSONObject
    //   2515: dup
    //   2516: aload 5
    //   2518: iconst_0
    //   2519: aaload
    //   2520: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2523: astore_2
    //   2524: aload_2
    //   2525: ldc_w 1146
    //   2528: invokevirtual 1123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2531: astore_1
    //   2532: aload_2
    //   2533: ldc_w 1122
    //   2536: invokevirtual 1123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2539: astore_2
    //   2540: aload_1
    //   2541: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2544: ifne +211 -> 2755
    //   2547: aload_2
    //   2548: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2551: istore 14
    //   2553: iload 14
    //   2555: ifne +200 -> 2755
    //   2558: aload_1
    //   2559: invokestatic 1126	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2562: lstore 8
    //   2564: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2567: ifeq +31 -> 2598
    //   2570: ldc_w 279
    //   2573: iconst_2
    //   2574: new 34	java/lang/StringBuilder
    //   2577: dup
    //   2578: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2581: ldc_w 1157
    //   2584: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: lload 8
    //   2589: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2592: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2595: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2598: lconst_0
    //   2599: lstore 10
    //   2601: aload_2
    //   2602: invokestatic 1126	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2605: lstore 12
    //   2607: lload 12
    //   2609: lstore 10
    //   2611: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2614: ifeq +31 -> 2645
    //   2617: ldc_w 279
    //   2620: iconst_2
    //   2621: new 34	java/lang/StringBuilder
    //   2624: dup
    //   2625: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2628: ldc_w 1159
    //   2631: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2634: lload 10
    //   2636: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2639: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2642: invokestatic 925	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2645: lload 8
    //   2647: lconst_0
    //   2648: lcmp
    //   2649: ifle -2444 -> 205
    //   2652: lload 10
    //   2654: lconst_0
    //   2655: lcmp
    //   2656: ifle -2451 -> 205
    //   2659: aload_0
    //   2660: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   2663: ifnull +87 -> 2750
    //   2666: aload_0
    //   2667: getfield 566	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lbcdb;
    //   2670: invokevirtual 571	bcdb:a	()Landroid/app/Activity;
    //   2673: astore_1
    //   2674: new 721	android/os/Bundle
    //   2677: dup
    //   2678: invokespecial 1160	android/os/Bundle:<init>	()V
    //   2681: astore_3
    //   2682: aload_3
    //   2683: ldc_w 1146
    //   2686: lload 8
    //   2688: invokevirtual 1164	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2691: aload_3
    //   2692: ldc_w 1166
    //   2695: iconst_2
    //   2696: invokevirtual 1170	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2699: aload_1
    //   2700: aload_3
    //   2701: aload_2
    //   2702: invokestatic 1133	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2705: aload_1
    //   2706: ifnull -2501 -> 205
    //   2709: aload_1
    //   2710: ldc_w 1134
    //   2713: ldc_w 1135
    //   2716: invokevirtual 1138	android/app/Activity:overridePendingTransition	(II)V
    //   2719: goto -2514 -> 205
    //   2722: astore_1
    //   2723: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2726: ifeq -2521 -> 205
    //   2729: ldc_w 279
    //   2732: iconst_2
    //   2733: ldc_w 1140
    //   2736: aload_1
    //   2737: invokestatic 1044	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2740: goto -2535 -> 205
    //   2743: astore_1
    //   2744: lconst_0
    //   2745: lstore 8
    //   2747: goto -183 -> 2564
    //   2750: aconst_null
    //   2751: astore_1
    //   2752: goto -78 -> 2674
    //   2755: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2758: ifeq -2553 -> 205
    //   2761: ldc_w 279
    //   2764: iconst_2
    //   2765: new 34	java/lang/StringBuilder
    //   2768: dup
    //   2769: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   2772: ldc_w 1172
    //   2775: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2778: aload_1
    //   2779: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: ldc_w 1174
    //   2785: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2788: aload_2
    //   2789: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2792: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2795: invokestatic 965	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2798: goto -2593 -> 205
    //   2801: astore_1
    //   2802: goto -695 -> 2107
    //   2805: astore_1
    //   2806: goto -440 -> 2366
    //   2809: astore_1
    //   2810: goto -199 -> 2611
    //   2813: aconst_null
    //   2814: astore_1
    //   2815: goto -2128 -> 687
    //   2818: iconst_m1
    //   2819: istore 6
    //   2821: goto -2575 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2824	0	this	TroopHWJsPlugin
    //   0	2824	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2824	2	paramString1	String
    //   0	2824	3	paramString2	String
    //   0	2824	4	paramString3	String
    //   0	2824	5	paramVarArgs	String[]
    //   244	2576	6	j	int
    //   410	824	7	k	int
    //   621	2125	8	l1	long
    //   2101	552	10	l2	long
    //   2349	259	12	l3	long
    //   2087	467	14	bool	boolean
    //   43	1228	15	localObject	Object
    //   52	10	16	str	String
    // Exception table:
    //   from	to	target	type
    //   20	32	207	org/json/JSONException
    //   719	749	752	java/lang/NumberFormatException
    //   789	805	752	java/lang/NumberFormatException
    //   1210	1226	1340	java/lang/Exception
    //   1236	1257	1340	java/lang/Exception
    //   1266	1276	1340	java/lang/Exception
    //   1617	1642	1645	java/lang/Exception
    //   2065	2089	2186	java/lang/Exception
    //   2107	2141	2186	java/lang/Exception
    //   2148	2163	2186	java/lang/Exception
    //   2163	2169	2186	java/lang/Exception
    //   2173	2183	2186	java/lang/Exception
    //   2212	2245	2186	java/lang/Exception
    //   2259	2285	2468	java/lang/Exception
    //   2296	2330	2468	java/lang/Exception
    //   2330	2338	2468	java/lang/Exception
    //   2341	2347	2468	java/lang/Exception
    //   2370	2404	2468	java/lang/Exception
    //   2422	2437	2468	java/lang/Exception
    //   2437	2451	2468	java/lang/Exception
    //   2455	2465	2468	java/lang/Exception
    //   2290	2296	2489	java/lang/Exception
    //   2512	2553	2722	java/lang/Exception
    //   2564	2598	2722	java/lang/Exception
    //   2611	2645	2722	java/lang/Exception
    //   2659	2674	2722	java/lang/Exception
    //   2674	2705	2722	java/lang/Exception
    //   2709	2719	2722	java/lang/Exception
    //   2755	2798	2722	java/lang/Exception
    //   2558	2564	2743	java/lang/Exception
    //   2097	2103	2801	java/lang/Exception
    //   2356	2362	2805	java/lang/Exception
    //   2601	2607	2809	java/lang/Exception
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
                localObject1 = new bhxb(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
                paramIntent = a(this, this.jdField_d_of_type_Int, paramIntent, null, (bhxb)localObject1, 0);
                this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_d_of_type_Int), paramIntent);
                paramIntent.jdField_a_of_type_Bhws.a();
                this.jdField_d_of_type_Int += 1;
                return;
              }
            } while (paramInt != -1);
            localHashMap1 = new HashMap();
            localHashMap2 = new HashMap();
            if ((paramByte == 2) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
            {
              bbdr.a(this.mRuntime.a(), this.jdField_c_of_type_JavaLangString);
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
                  if (bbbj.a((LocalMediaInfo)paramIntent.get(localObject3)) != 1) {
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
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new bhxb(this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString), localHashMap2), null, false);
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
    this.jdField_a_of_type_Wxu = wxu.a();
    this.jdField_a_of_type_Wxu.a();
    this.jdField_a_of_type_Bhxg = new bhxg(this.mRuntime.a(), this);
    this.jdField_a_of_type_Bhwt = new bhwt(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    int k = 0;
    if (this.jdField_a_of_type_Wxu != null) {
      this.jdField_a_of_type_Wxu.b();
    }
    super.onDestroy();
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
      localObject1 = new VFSFile(ajsf.bs);
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