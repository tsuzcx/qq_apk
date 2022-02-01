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
  int b = 540;
  int c = 540;
  String d;
  String e;
  String f;
  String g;
  ActionSheet h = null;
  boolean i = false;
  int j = 0;
  int k = 1;
  ITroopMemberApiClientApi l = null;
  TroopHWVoiceController m = null;
  String n = null;
  int o = -1;
  String p = null;
  boolean q = false;
  String r = null;
  HashMap<Integer, String> s = new HashMap();
  HashMap<Integer, TroopHWJsPlugin.UploadMediaEntry> t = new HashMap();
  private TroopHWFileDownloadManager u;
  private String v;
  private boolean w = false;
  private Handler x = new TroopHWJsPlugin.5(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_HOMEWORK_AUDIO);
    localStringBuilder.append("homeworkTmp/");
    a = localStringBuilder.toString();
  }
  
  public TroopHWJsPlugin()
  {
    this.mPluginNameSpace = "homework";
  }
  
  @TargetApi(12)
  public static int a(Bitmap paramBitmap)
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 12)
    {
      i1 = paramBitmap.getByteCount();
    }
    else
    {
      i1 = paramBitmap.getRowBytes();
      i1 = paramBitmap.getHeight() * i1;
    }
    if (i1 > 41246720) {
      return 0;
    }
    if (i1 > 6291456) {
      return 50;
    }
    if (i1 > 1048576) {
      return 80;
    }
    if (i1 > 102400) {
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
  public static String a(int paramInt1, String paramString, int paramInt2, TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    // Byte code:
    //   0: new 169	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 176	java/io/File:length	()J
    //   11: ldc2_w 177
    //   14: lcmp
    //   15: ifle +1153 -> 1168
    //   18: new 49	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   25: astore 14
    //   27: new 180	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 181	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 11
    //   36: aload 11
    //   38: iconst_1
    //   39: putfield 184	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload 11
    //   44: getstatic 190	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   47: putfield 193	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   50: aload 11
    //   52: iconst_1
    //   53: putfield 196	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   56: aload_1
    //   57: aload 11
    //   59: invokestatic 202	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: pop
    //   63: aload 11
    //   65: getfield 205	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: istore 8
    //   70: aload 11
    //   72: getfield 208	android/graphics/BitmapFactory$Options:outHeight	I
    //   75: istore 10
    //   77: iload 8
    //   79: ifle +1079 -> 1158
    //   82: iload 10
    //   84: ifgt +5 -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: iload 8
    //   91: iload_2
    //   92: if_icmpgt +22 -> 114
    //   95: aload_3
    //   96: ifnull +1089 -> 1185
    //   99: aload_3
    //   100: getfield 210	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   103: iload_0
    //   104: aload_1
    //   105: iload 8
    //   107: iload 10
    //   109: aload_3
    //   110: invokestatic 213	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;ILjava/lang/String;IILcooperation/troop_homework/jsp/TroopHWJsPlugin;)Ljava/lang/String;
    //   113: areturn
    //   114: new 215	android/graphics/Matrix
    //   117: dup
    //   118: invokespecial 216	android/graphics/Matrix:<init>	()V
    //   121: astore 15
    //   123: fconst_1
    //   124: fstore 5
    //   126: aload_1
    //   127: invokestatic 222	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   130: istore 9
    //   132: iload 9
    //   134: iconst_5
    //   135: if_icmpeq +1058 -> 1193
    //   138: iload 9
    //   140: bipush 6
    //   142: if_icmpeq +1051 -> 1193
    //   145: iload 9
    //   147: bipush 7
    //   149: if_icmpeq +1044 -> 1193
    //   152: iload 9
    //   154: bipush 8
    //   156: if_icmpne +1031 -> 1187
    //   159: goto +1034 -> 1193
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
    //   185: putfield 184	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
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
    //   239: putfield 225	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   242: new 227	java/io/FileInputStream
    //   245: dup
    //   246: aload_1
    //   247: invokespecial 228	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   250: astore 12
    //   252: aload 12
    //   254: astore 13
    //   256: aload 12
    //   258: aconst_null
    //   259: aload 11
    //   261: invokestatic 232	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   264: astore 11
    //   266: aload 11
    //   268: ifnonnull +10 -> 278
    //   271: aload 12
    //   273: invokevirtual 235	java/io/FileInputStream:close	()V
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
    //   297: invokevirtual 139	android/graphics/Bitmap:getHeight	()I
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
    //   318: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
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
    //   336: ldc2_w 239
    //   339: dcmpg
    //   340: ifge +859 -> 1199
    //   343: ldc 241
    //   345: fstore 5
    //   347: goto +852 -> 1199
    //   350: fload 5
    //   352: fstore 4
    //   354: aload 12
    //   356: astore 13
    //   358: aload 15
    //   360: fload 5
    //   362: fload 5
    //   364: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   367: goto +277 -> 644
    //   370: fload 5
    //   372: fstore 4
    //   374: aload 12
    //   376: astore 13
    //   378: aload 15
    //   380: fload 5
    //   382: fload 5
    //   384: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   387: fload 5
    //   389: fstore 4
    //   391: aload 12
    //   393: astore 13
    //   395: aload 15
    //   397: ldc 246
    //   399: invokevirtual 250	android/graphics/Matrix:postRotate	(F)Z
    //   402: pop
    //   403: goto +241 -> 644
    //   406: fload 5
    //   408: fstore 4
    //   410: aload 12
    //   412: astore 13
    //   414: aload 15
    //   416: fload 5
    //   418: fneg
    //   419: fload 5
    //   421: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   424: fload 5
    //   426: fstore 4
    //   428: aload 12
    //   430: astore 13
    //   432: aload 15
    //   434: ldc 251
    //   436: invokevirtual 250	android/graphics/Matrix:postRotate	(F)Z
    //   439: pop
    //   440: goto +204 -> 644
    //   443: fload 5
    //   445: fstore 4
    //   447: aload 12
    //   449: astore 13
    //   451: aload 15
    //   453: fload 5
    //   455: fload 5
    //   457: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   460: fload 5
    //   462: fstore 4
    //   464: aload 12
    //   466: astore 13
    //   468: aload 15
    //   470: ldc 251
    //   472: invokevirtual 250	android/graphics/Matrix:postRotate	(F)Z
    //   475: pop
    //   476: goto +168 -> 644
    //   479: fload 5
    //   481: fstore 4
    //   483: aload 12
    //   485: astore 13
    //   487: aload 15
    //   489: fload 5
    //   491: fload 5
    //   493: fneg
    //   494: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   497: fload 5
    //   499: fstore 4
    //   501: aload 12
    //   503: astore 13
    //   505: aload 15
    //   507: ldc 251
    //   509: invokevirtual 250	android/graphics/Matrix:postRotate	(F)Z
    //   512: pop
    //   513: goto +131 -> 644
    //   516: fload 5
    //   518: fstore 4
    //   520: aload 12
    //   522: astore 13
    //   524: aload 15
    //   526: fload 5
    //   528: fload 5
    //   530: fneg
    //   531: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   534: goto +110 -> 644
    //   537: fload 5
    //   539: fstore 4
    //   541: aload 12
    //   543: astore 13
    //   545: aload 15
    //   547: fload 5
    //   549: fload 5
    //   551: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   554: fload 5
    //   556: fstore 4
    //   558: aload 12
    //   560: astore 13
    //   562: aload 15
    //   564: ldc 252
    //   566: invokevirtual 250	android/graphics/Matrix:postRotate	(F)Z
    //   569: pop
    //   570: goto +74 -> 644
    //   573: fload 5
    //   575: fstore 4
    //   577: aload 12
    //   579: astore 13
    //   581: aload 15
    //   583: fload 5
    //   585: fneg
    //   586: fload 5
    //   588: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   591: goto +53 -> 644
    //   594: aconst_null
    //   595: astore 11
    //   597: fload 5
    //   599: fstore 4
    //   601: goto +21 -> 622
    //   604: astore_1
    //   605: aconst_null
    //   606: astore 13
    //   608: goto +538 -> 1146
    //   611: aconst_null
    //   612: astore 11
    //   614: aload 11
    //   616: astore 12
    //   618: fload 5
    //   620: fstore 4
    //   622: aload 12
    //   624: astore 13
    //   626: aload 15
    //   628: fload 4
    //   630: fload 4
    //   632: invokevirtual 245	android/graphics/Matrix:setScale	(FF)V
    //   635: aload 11
    //   637: astore 13
    //   639: aload 12
    //   641: ifnull +12 -> 653
    //   644: aload 12
    //   646: invokevirtual 235	java/io/FileInputStream:close	()V
    //   649: aload 11
    //   651: astore 13
    //   653: aload 13
    //   655: iconst_0
    //   656: iconst_0
    //   657: aload 13
    //   659: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
    //   662: aload 13
    //   664: invokevirtual 139	android/graphics/Bitmap:getHeight	()I
    //   667: aload 15
    //   669: iconst_1
    //   670: invokestatic 256	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   673: astore 12
    //   675: aload 13
    //   677: aload 12
    //   679: if_acmpeq +8 -> 687
    //   682: aload 13
    //   684: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   687: aload 12
    //   689: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
    //   692: istore_2
    //   693: aload 12
    //   695: invokevirtual 139	android/graphics/Bitmap:getHeight	()I
    //   698: istore 7
    //   700: aload 12
    //   702: invokestatic 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   705: istore 8
    //   707: iload 8
    //   709: ifle +79 -> 788
    //   712: new 263	java/io/ByteArrayOutputStream
    //   715: dup
    //   716: sipush 1024
    //   719: invokespecial 266	java/io/ByteArrayOutputStream:<init>	(I)V
    //   722: astore 11
    //   724: aload 12
    //   726: getstatic 272	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   729: iload 8
    //   731: aload 11
    //   733: invokevirtual 276	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   736: pop
    //   737: aload_3
    //   738: ifnull +18 -> 756
    //   741: aload 14
    //   743: aload 11
    //   745: invokevirtual 280	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   748: iconst_2
    //   749: invokestatic 286	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   752: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: goto +53 -> 809
    //   759: astore_1
    //   760: goto +321 -> 1081
    //   763: astore 13
    //   765: goto +327 -> 1092
    //   768: astore_1
    //   769: aconst_null
    //   770: astore 12
    //   772: aload 12
    //   774: astore_3
    //   775: goto +351 -> 1126
    //   778: astore 13
    //   780: aconst_null
    //   781: astore_1
    //   782: aload_1
    //   783: astore 11
    //   785: goto +309 -> 1094
    //   788: iload 8
    //   790: ifne +16 -> 806
    //   793: aload_3
    //   794: ifnull +12 -> 806
    //   797: aload_3
    //   798: getfield 113	cooperation/troop_homework/jsp/TroopHWJsPlugin:x	Landroid/os/Handler;
    //   801: iconst_1
    //   802: invokevirtual 292	android/os/Handler:sendEmptyMessage	(I)Z
    //   805: pop
    //   806: aconst_null
    //   807: astore 11
    //   809: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +28 -> 840
    //   815: ldc_w 300
    //   818: iconst_2
    //   819: iconst_2
    //   820: anewarray 302	java/lang/Object
    //   823: dup
    //   824: iconst_0
    //   825: ldc_w 304
    //   828: aastore
    //   829: dup
    //   830: iconst_1
    //   831: iload 8
    //   833: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   836: aastore
    //   837: invokestatic 313	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   840: aload 12
    //   842: ifnull +8 -> 850
    //   845: aload 12
    //   847: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   850: aload_3
    //   851: ifnull +83 -> 934
    //   854: aload_3
    //   855: aload_3
    //   856: getfield 210	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   859: iload_0
    //   860: iconst_1
    //   861: ldc_w 315
    //   864: aconst_null
    //   865: iconst_m1
    //   866: invokevirtual 318	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   869: astore 12
    //   871: aload 14
    //   873: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   879: ifne +14 -> 893
    //   882: aload 12
    //   884: ldc_w 326
    //   887: aload 14
    //   889: invokevirtual 332	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   892: pop
    //   893: aload 12
    //   895: ldc_w 334
    //   898: iload_2
    //   899: invokevirtual 337	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   902: pop
    //   903: aload 12
    //   905: ldc_w 339
    //   908: iload 7
    //   910: invokevirtual 337	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   913: pop
    //   914: aload_3
    //   915: aload_3
    //   916: getfield 341	cooperation/troop_homework/jsp/TroopHWJsPlugin:d	Ljava/lang/String;
    //   919: iconst_1
    //   920: anewarray 343	java/lang/String
    //   923: dup
    //   924: iconst_0
    //   925: aload 12
    //   927: invokevirtual 344	org/json/JSONObject:toString	()Ljava/lang/String;
    //   930: aastore
    //   931: invokevirtual 348	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   934: aload 11
    //   936: ifnull +117 -> 1053
    //   939: new 49	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   946: astore_3
    //   947: aload_3
    //   948: getstatic 69	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	Ljava/lang/String;
    //   951: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload_3
    //   956: aload_1
    //   957: aload_1
    //   958: ldc_w 350
    //   961: invokevirtual 353	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   964: iconst_1
    //   965: iadd
    //   966: aload_1
    //   967: ldc_w 355
    //   970: invokevirtual 353	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   973: invokevirtual 359	java/lang/String:substring	(II)Ljava/lang/String;
    //   976: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload_3
    //   981: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   984: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload_3
    //   989: aload_1
    //   990: invokestatic 372	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   993: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload_3
    //   998: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: astore 13
    //   1003: new 374	com/tencent/mm/vfs/VFSFileOutputStream
    //   1006: dup
    //   1007: aload 13
    //   1009: invokespecial 375	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Ljava/lang/String;)V
    //   1012: astore_1
    //   1013: aload_1
    //   1014: astore 12
    //   1016: aload 11
    //   1018: astore_3
    //   1019: aload_1
    //   1020: aload 11
    //   1022: invokevirtual 280	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1025: invokevirtual 379	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   1028: aload_1
    //   1029: astore 12
    //   1031: aload 11
    //   1033: astore_3
    //   1034: aload 13
    //   1036: iconst_0
    //   1037: invokestatic 385	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1040: astore 13
    //   1042: aload 13
    //   1044: astore_3
    //   1045: goto +12 -> 1057
    //   1048: astore 13
    //   1050: goto +44 -> 1094
    //   1053: aconst_null
    //   1054: astore_3
    //   1055: aload_3
    //   1056: astore_1
    //   1057: aload 11
    //   1059: ifnull +8 -> 1067
    //   1062: aload 11
    //   1064: invokevirtual 386	java/io/ByteArrayOutputStream:close	()V
    //   1067: aload_3
    //   1068: astore 11
    //   1070: aload_1
    //   1071: ifnull +179 -> 1250
    //   1074: aload_1
    //   1075: invokevirtual 387	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1078: aload_3
    //   1079: areturn
    //   1080: astore_1
    //   1081: aconst_null
    //   1082: astore 12
    //   1084: aload 11
    //   1086: astore_3
    //   1087: goto +39 -> 1126
    //   1090: astore 13
    //   1092: aconst_null
    //   1093: astore_1
    //   1094: aload_1
    //   1095: astore 12
    //   1097: aload 11
    //   1099: astore_3
    //   1100: aload 13
    //   1102: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   1105: aload 11
    //   1107: ifnull +8 -> 1115
    //   1110: aload 11
    //   1112: invokevirtual 386	java/io/ByteArrayOutputStream:close	()V
    //   1115: aload_1
    //   1116: ifnull +131 -> 1247
    //   1119: aload_1
    //   1120: invokevirtual 387	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1123: goto +124 -> 1247
    //   1126: aload_3
    //   1127: ifnull +7 -> 1134
    //   1130: aload_3
    //   1131: invokevirtual 386	java/io/ByteArrayOutputStream:close	()V
    //   1134: aload 12
    //   1136: ifnull +8 -> 1144
    //   1139: aload 12
    //   1141: invokevirtual 387	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1144: aload_1
    //   1145: athrow
    //   1146: aload 13
    //   1148: ifnull +8 -> 1156
    //   1151: aload 13
    //   1153: invokevirtual 235	java/io/FileInputStream:close	()V
    //   1156: aload_1
    //   1157: athrow
    //   1158: aconst_null
    //   1159: areturn
    //   1160: astore_1
    //   1161: aload_1
    //   1162: invokevirtual 391	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1165: invokestatic 394	java/lang/System:gc	()V
    //   1168: aconst_null
    //   1169: areturn
    //   1170: astore 11
    //   1172: goto -561 -> 611
    //   1175: astore 11
    //   1177: goto -583 -> 594
    //   1180: astore 13
    //   1182: goto -560 -> 622
    //   1185: aload_1
    //   1186: areturn
    //   1187: iconst_0
    //   1188: istore 7
    //   1190: goto -1028 -> 162
    //   1193: iconst_1
    //   1194: istore 7
    //   1196: goto -1034 -> 162
    //   1199: iload 9
    //   1201: tableswitch	default:+43 -> 1244, 2:+-628->573, 3:+-664->537, 4:+-685->516, 5:+-722->479, 6:+-758->443, 7:+-795->406, 8:+-831->370
    //   1245: <illegal opcode>
    //   1246: ixor
    //   1247: aconst_null
    //   1248: astore 11
    //   1250: aload 11
    //   1252: areturn
    //   1253: astore_1
    //   1254: goto -128 -> 1126
    //   1257: astore_1
    //   1258: goto -112 -> 1146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1261	0	paramInt1	int
    //   0	1261	1	paramString	String
    //   0	1261	2	paramInt2	int
    //   0	1261	3	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   289	342	4	f1	float
    //   124	495	5	f2	float
    //   285	46	6	f3	float
    //   162	1033	7	i1	int
    //   68	764	8	i2	int
    //   130	1070	9	i3	int
    //   75	96	10	i4	int
    //   34	1077	11	localObject1	Object
    //   1170	1	11	localIOException1	java.io.IOException
    //   1175	1	11	localIOException2	java.io.IOException
    //   1248	3	11	str1	String
    //   250	890	12	localObject2	Object
    //   254	429	13	localObject3	Object
    //   763	1	13	localIOException3	java.io.IOException
    //   778	1	13	localIOException4	java.io.IOException
    //   1001	42	13	str2	String
    //   1048	1	13	localIOException5	java.io.IOException
    //   1090	62	13	localIOException6	java.io.IOException
    //   1180	1	13	localIOException7	java.io.IOException
    //   25	863	14	localStringBuilder	StringBuilder
    //   121	547	15	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   126	132	604	finally
    //   167	173	604	finally
    //   176	182	604	finally
    //   182	188	604	finally
    //   225	252	604	finally
    //   724	737	759	finally
    //   741	756	759	finally
    //   724	737	763	java/io/IOException
    //   741	756	763	java/io/IOException
    //   712	724	768	finally
    //   797	806	768	finally
    //   712	724	778	java/io/IOException
    //   797	806	778	java/io/IOException
    //   1019	1028	1048	java/io/IOException
    //   1034	1042	1048	java/io/IOException
    //   809	840	1080	finally
    //   845	850	1080	finally
    //   854	893	1080	finally
    //   893	934	1080	finally
    //   939	1013	1080	finally
    //   809	840	1090	java/io/IOException
    //   845	850	1090	java/io/IOException
    //   854	893	1090	java/io/IOException
    //   893	934	1090	java/io/IOException
    //   939	1013	1090	java/io/IOException
    //   27	77	1160	java/lang/OutOfMemoryError
    //   99	114	1160	java/lang/OutOfMemoryError
    //   114	123	1160	java/lang/OutOfMemoryError
    //   271	276	1160	java/lang/OutOfMemoryError
    //   644	649	1160	java/lang/OutOfMemoryError
    //   653	675	1160	java/lang/OutOfMemoryError
    //   682	687	1160	java/lang/OutOfMemoryError
    //   687	707	1160	java/lang/OutOfMemoryError
    //   1062	1067	1160	java/lang/OutOfMemoryError
    //   1074	1078	1160	java/lang/OutOfMemoryError
    //   1110	1115	1160	java/lang/OutOfMemoryError
    //   1119	1123	1160	java/lang/OutOfMemoryError
    //   1130	1134	1160	java/lang/OutOfMemoryError
    //   1139	1144	1160	java/lang/OutOfMemoryError
    //   1144	1146	1160	java/lang/OutOfMemoryError
    //   1151	1156	1160	java/lang/OutOfMemoryError
    //   1156	1158	1160	java/lang/OutOfMemoryError
    //   126	132	1170	java/io/IOException
    //   167	173	1170	java/io/IOException
    //   176	182	1170	java/io/IOException
    //   182	188	1170	java/io/IOException
    //   225	252	1170	java/io/IOException
    //   256	266	1175	java/io/IOException
    //   295	301	1180	java/io/IOException
    //   316	322	1180	java/io/IOException
    //   330	343	1180	java/io/IOException
    //   358	367	1180	java/io/IOException
    //   378	387	1180	java/io/IOException
    //   395	403	1180	java/io/IOException
    //   414	424	1180	java/io/IOException
    //   432	440	1180	java/io/IOException
    //   451	460	1180	java/io/IOException
    //   468	476	1180	java/io/IOException
    //   487	497	1180	java/io/IOException
    //   505	513	1180	java/io/IOException
    //   524	534	1180	java/io/IOException
    //   545	554	1180	java/io/IOException
    //   562	570	1180	java/io/IOException
    //   581	591	1180	java/io/IOException
    //   1019	1028	1253	finally
    //   1034	1042	1253	finally
    //   1100	1105	1253	finally
    //   256	266	1257	finally
    //   295	301	1257	finally
    //   316	322	1257	finally
    //   330	343	1257	finally
    //   358	367	1257	finally
    //   378	387	1257	finally
    //   395	403	1257	finally
    //   414	424	1257	finally
    //   432	440	1257	finally
    //   451	460	1257	finally
    //   468	476	1257	finally
    //   487	497	1257	finally
    //   505	513	1257	finally
    //   524	534	1257	finally
    //   545	554	1257	finally
    //   562	570	1257	finally
    //   581	591	1257	finally
    //   626	635	1257	finally
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
      QQToast.makeText(localBaseApplication, 2131916075, 0).show();
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
        QQToast.makeText(localBaseApplication, 2131887645, 0).show();
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
    //   6: new 263	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 266	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: getstatic 272	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   23: iload_1
    //   24: aload_3
    //   25: invokevirtual 276	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   28: pop
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 280	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   35: iconst_2
    //   36: invokestatic 286	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
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
    //   61: invokevirtual 457	java/lang/Exception:printStackTrace	()V
    //   64: aload_3
    //   65: ifnull +19 -> 84
    //   68: aload_3
    //   69: invokevirtual 462	java/io/ByteArrayOutputStream:flush	()V
    //   72: aload_3
    //   73: invokevirtual 386	java/io/ByteArrayOutputStream:close	()V
    //   76: goto +8 -> 84
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aload_2
    //   88: ifnull +19 -> 107
    //   91: aload_2
    //   92: invokevirtual 462	java/io/ByteArrayOutputStream:flush	()V
    //   95: aload_2
    //   96: invokevirtual 386	java/io/ByteArrayOutputStream:close	()V
    //   99: goto +8 -> 107
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: athrow
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_2
    //   112: ifnull +18 -> 130
    //   115: aload_2
    //   116: invokevirtual 462	java/io/ByteArrayOutputStream:flush	()V
    //   119: aload_2
    //   120: invokevirtual 386	java/io/ByteArrayOutputStream:close	()V
    //   123: aload_0
    //   124: areturn
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 390	java/io/IOException:printStackTrace	()V
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
    //   0: new 227	java/io/FileInputStream
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 228	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: new 49	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   17: astore 8
    //   19: sipush 30720
    //   22: newarray byte
    //   24: astore 9
    //   26: aload 7
    //   28: aload 9
    //   30: invokevirtual 466	java/io/FileInputStream:read	([B)I
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
    //   63: invokestatic 470	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   66: aload 8
    //   68: aload 10
    //   70: iconst_2
    //   71: invokestatic 286	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   74: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -52 -> 26
    //   81: aload 8
    //   83: aload 9
    //   85: iconst_2
    //   86: invokestatic 286	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   89: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: goto -67 -> 26
    //   96: aload 5
    //   98: ifnull +78 -> 176
    //   101: aload 5
    //   103: aload_0
    //   104: iload_1
    //   105: iconst_1
    //   106: ldc_w 315
    //   109: aconst_null
    //   110: iconst_m1
    //   111: invokevirtual 318	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   114: astore_0
    //   115: aload 8
    //   117: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +13 -> 136
    //   126: aload_0
    //   127: ldc_w 326
    //   130: aload 8
    //   132: invokevirtual 332	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_0
    //   137: ldc_w 334
    //   140: iload_3
    //   141: invokevirtual 337	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload_0
    //   146: ldc_w 339
    //   149: iload 4
    //   151: invokevirtual 337	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   154: pop
    //   155: aload 5
    //   157: aload 5
    //   159: getfield 341	cooperation/troop_homework/jsp/TroopHWJsPlugin:d	Ljava/lang/String;
    //   162: iconst_1
    //   163: anewarray 343	java/lang/String
    //   166: dup
    //   167: iconst_0
    //   168: aload_0
    //   169: invokevirtual 344	org/json/JSONObject:toString	()Ljava/lang/String;
    //   172: aastore
    //   173: invokevirtual 348	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   176: aload 7
    //   178: invokevirtual 235	java/io/FileInputStream:close	()V
    //   181: aload_2
    //   182: areturn
    //   183: astore_0
    //   184: aload 7
    //   186: astore_2
    //   187: goto +6 -> 193
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 235	java/io/FileInputStream:close	()V
    //   201: goto +5 -> 206
    //   204: aload_0
    //   205: athrow
    //   206: goto -2 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString1	String
    //   0	209	1	paramInt1	int
    //   0	209	2	paramString2	String
    //   0	209	3	paramInt2	int
    //   0	209	4	paramInt3	int
    //   0	209	5	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   33	29	6	i1	int
    //   8	177	7	localFileInputStream	java.io.FileInputStream
    //   17	114	8	localStringBuilder	StringBuilder
    //   24	60	9	arrayOfByte1	byte[]
    //   53	16	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	26	183	finally
    //   26	35	183	finally
    //   49	78	183	finally
    //   81	93	183	finally
    //   101	136	183	finally
    //   136	176	183	finally
    //   0	10	190	finally
  }
  
  /* Error */
  private Bitmap c(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 210	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   14: iload_1
    //   15: iconst_2
    //   16: ldc_w 315
    //   19: aconst_null
    //   20: iconst_m1
    //   21: invokevirtual 318	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   24: astore 8
    //   26: new 482	android/media/MediaMetadataRetriever
    //   29: dup
    //   30: invokespecial 483	android/media/MediaMetadataRetriever:<init>	()V
    //   33: astore 9
    //   35: aload 9
    //   37: aload_2
    //   38: invokevirtual 486	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   41: aload 9
    //   43: ldc2_w 487
    //   46: invokevirtual 492	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +179 -> 232
    //   56: aload_0
    //   57: getfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	I
    //   60: istore_1
    //   61: sipush 540
    //   64: istore_3
    //   65: iload_1
    //   66: ifgt +10 -> 76
    //   69: sipush 540
    //   72: istore_1
    //   73: goto +8 -> 81
    //   76: aload_0
    //   77: getfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	I
    //   80: istore_1
    //   81: aload_0
    //   82: getfield 75	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	I
    //   85: ifgt +6 -> 91
    //   88: goto +8 -> 96
    //   91: aload_0
    //   92: getfield 75	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	I
    //   95: istore_3
    //   96: aload 4
    //   98: iload_1
    //   99: iload_3
    //   100: invokestatic 498	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   103: astore 6
    //   105: aload 6
    //   107: astore_2
    //   108: aload 4
    //   110: astore 5
    //   112: aload 6
    //   114: ifnull +124 -> 238
    //   117: aload 6
    //   119: aload 6
    //   121: invokestatic 261	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   124: invokestatic 500	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   127: astore 7
    //   129: aload 6
    //   131: astore_2
    //   132: aload 4
    //   134: astore 5
    //   136: aload 7
    //   138: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +97 -> 238
    //   144: aload 8
    //   146: ldc_w 326
    //   149: aload 7
    //   151: invokevirtual 332	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   154: pop
    //   155: aload 8
    //   157: ldc_w 334
    //   160: aload 6
    //   162: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
    //   165: invokevirtual 337	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload 8
    //   171: ldc_w 339
    //   174: aload 6
    //   176: invokevirtual 139	android/graphics/Bitmap:getHeight	()I
    //   179: invokevirtual 337	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload 6
    //   185: astore_2
    //   186: aload 4
    //   188: astore 5
    //   190: goto +48 -> 238
    //   193: astore 7
    //   195: goto +67 -> 262
    //   198: astore 7
    //   200: goto +122 -> 322
    //   203: astore 7
    //   205: goto +177 -> 382
    //   208: astore 7
    //   210: aconst_null
    //   211: astore 6
    //   213: goto +49 -> 262
    //   216: astore 7
    //   218: aconst_null
    //   219: astore 6
    //   221: goto +101 -> 322
    //   224: astore 7
    //   226: aconst_null
    //   227: astore 6
    //   229: goto +153 -> 382
    //   232: aconst_null
    //   233: astore_2
    //   234: aload 4
    //   236: astore 5
    //   238: aload 9
    //   240: invokevirtual 503	android/media/MediaMetadataRetriever:release	()V
    //   243: goto +199 -> 442
    //   246: goto +196 -> 442
    //   249: astore_2
    //   250: goto +238 -> 488
    //   253: astore 7
    //   255: aconst_null
    //   256: astore 4
    //   258: aload 4
    //   260: astore 6
    //   262: aload 6
    //   264: astore_2
    //   265: aload 4
    //   267: astore 5
    //   269: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -34 -> 238
    //   275: new 49	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   282: astore_2
    //   283: aload_2
    //   284: ldc_w 505
    //   287: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_2
    //   292: aload 7
    //   294: invokevirtual 508	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc_w 300
    //   304: iconst_2
    //   305: aload_2
    //   306: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 511	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload 6
    //   314: astore_2
    //   315: aload 4
    //   317: astore 5
    //   319: goto -81 -> 238
    //   322: aload 6
    //   324: astore_2
    //   325: aload 4
    //   327: astore 5
    //   329: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -94 -> 238
    //   335: new 49	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   342: astore_2
    //   343: aload_2
    //   344: ldc_w 513
    //   347: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_2
    //   352: aload 7
    //   354: invokevirtual 514	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   357: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: ldc_w 300
    //   364: iconst_2
    //   365: aload_2
    //   366: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 511	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload 6
    //   374: astore_2
    //   375: aload 4
    //   377: astore 5
    //   379: goto -141 -> 238
    //   382: aload 6
    //   384: astore_2
    //   385: aload 4
    //   387: astore 5
    //   389: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq -154 -> 238
    //   395: new 49	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   402: astore_2
    //   403: aload_2
    //   404: ldc_w 513
    //   407: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_2
    //   412: aload 7
    //   414: invokevirtual 515	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   417: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: ldc_w 300
    //   424: iconst_2
    //   425: aload_2
    //   426: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 511	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 6
    //   434: astore_2
    //   435: aload 4
    //   437: astore 5
    //   439: goto -201 -> 238
    //   442: aload_0
    //   443: aload_0
    //   444: getfield 341	cooperation/troop_homework/jsp/TroopHWJsPlugin:d	Ljava/lang/String;
    //   447: iconst_1
    //   448: anewarray 343	java/lang/String
    //   451: dup
    //   452: iconst_0
    //   453: aload 8
    //   455: invokevirtual 344	org/json/JSONObject:toString	()Ljava/lang/String;
    //   458: aastore
    //   459: invokevirtual 348	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   462: aload_2
    //   463: ifnull +15 -> 478
    //   466: aload 5
    //   468: ifnull +8 -> 476
    //   471: aload 5
    //   473: invokevirtual 259	android/graphics/Bitmap:recycle	()V
    //   476: aload_2
    //   477: areturn
    //   478: aload 5
    //   480: ifnull +6 -> 486
    //   483: aload 5
    //   485: areturn
    //   486: aconst_null
    //   487: areturn
    //   488: aload 9
    //   490: invokevirtual 503	android/media/MediaMetadataRetriever:release	()V
    //   493: goto +5 -> 498
    //   496: aload_2
    //   497: athrow
    //   498: goto -2 -> 496
    //   501: astore 4
    //   503: goto -257 -> 246
    //   506: astore 4
    //   508: goto -15 -> 493
    //   511: astore 7
    //   513: aconst_null
    //   514: astore 4
    //   516: aload 4
    //   518: astore 6
    //   520: goto -198 -> 322
    //   523: astore 7
    //   525: aconst_null
    //   526: astore 4
    //   528: aload 4
    //   530: astore 6
    //   532: goto -150 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	TroopHWJsPlugin
    //   0	535	1	paramInt	int
    //   0	535	2	paramString	String
    //   64	36	3	i1	int
    //   49	387	4	localBitmap1	Bitmap
    //   501	1	4	localRuntimeException1	java.lang.RuntimeException
    //   506	1	4	localRuntimeException2	java.lang.RuntimeException
    //   514	15	4	localObject1	Object
    //   110	374	5	localBitmap2	Bitmap
    //   103	428	6	localObject2	Object
    //   127	23	7	str	String
    //   193	1	7	localJSONException1	JSONException
    //   198	1	7	localRuntimeException3	java.lang.RuntimeException
    //   203	1	7	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   208	1	7	localJSONException2	JSONException
    //   216	1	7	localRuntimeException4	java.lang.RuntimeException
    //   224	1	7	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   253	160	7	localJSONException3	JSONException
    //   511	1	7	localRuntimeException5	java.lang.RuntimeException
    //   523	1	7	localIllegalArgumentException3	java.lang.IllegalArgumentException
    //   24	430	8	localJSONObject	JSONObject
    //   33	456	9	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   117	129	193	org/json/JSONException
    //   136	183	193	org/json/JSONException
    //   117	129	198	java/lang/RuntimeException
    //   136	183	198	java/lang/RuntimeException
    //   117	129	203	java/lang/IllegalArgumentException
    //   136	183	203	java/lang/IllegalArgumentException
    //   56	61	208	org/json/JSONException
    //   76	81	208	org/json/JSONException
    //   81	88	208	org/json/JSONException
    //   91	96	208	org/json/JSONException
    //   96	105	208	org/json/JSONException
    //   56	61	216	java/lang/RuntimeException
    //   76	81	216	java/lang/RuntimeException
    //   81	88	216	java/lang/RuntimeException
    //   91	96	216	java/lang/RuntimeException
    //   96	105	216	java/lang/RuntimeException
    //   56	61	224	java/lang/IllegalArgumentException
    //   76	81	224	java/lang/IllegalArgumentException
    //   81	88	224	java/lang/IllegalArgumentException
    //   91	96	224	java/lang/IllegalArgumentException
    //   96	105	224	java/lang/IllegalArgumentException
    //   35	51	249	finally
    //   56	61	249	finally
    //   76	81	249	finally
    //   81	88	249	finally
    //   91	96	249	finally
    //   96	105	249	finally
    //   117	129	249	finally
    //   136	183	249	finally
    //   269	312	249	finally
    //   329	372	249	finally
    //   389	432	249	finally
    //   35	51	253	org/json/JSONException
    //   238	243	501	java/lang/RuntimeException
    //   488	493	506	java/lang/RuntimeException
    //   35	51	511	java/lang/RuntimeException
    //   35	51	523	java/lang/IllegalArgumentException
  }
  
  private void e(int paramInt)
  {
    ActionSheet localActionSheet = this.h;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    localActionSheet = ActionSheet.create(this.mRuntime.d());
    localActionSheet.addButton(2131916259, 1);
    localActionSheet.addButton(2131916249, 1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new TroopHWJsPlugin.2(this, paramInt, localActionSheet));
    localActionSheet.show();
    this.h = localActionSheet;
  }
  
  private void f(int paramInt)
  {
    Activity localActivity;
    if (this.mRuntime == null) {
      localActivity = null;
    } else {
      localActivity = this.mRuntime.d();
    }
    if (localActivity == null)
    {
      QQToast.makeText(MobileQQ.getContext(), 2131887645, 0).show();
      return;
    }
    if ((localActivity instanceof AppActivity))
    {
      int i1;
      if ((Build.VERSION.SDK_INT >= 23) && (localActivity.checkSelfPermission("android.permission.CAMERA") != 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          ((AppActivity)localActivity).requestPermissions(new TroopHWJsPlugin.3(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
        }
      }
      else {
        this.e = a(localActivity, paramInt);
      }
    }
    else
    {
      this.e = a(localActivity, paramInt);
    }
  }
  
  public TroopHWJsPlugin.UploadMediaEntry a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, TroopHWJsPlugin.RequestSource paramRequestSource, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    TroopHWJsPlugin.UploadMediaEntry localUploadMediaEntry = new TroopHWJsPlugin.UploadMediaEntry(paramTroopHWJsPlugin);
    localUploadMediaEntry.c = paramInt1;
    localUploadMediaEntry.a = paramRequestSource;
    localUploadMediaEntry.b = new TroopHomeworkHelper.UploadFileTask(paramTroopHWJsPlugin.mRuntime.b(), paramString, paramRequestSource.b);
    localUploadMediaEntry.b.a(localUploadMediaEntry.j);
    localUploadMediaEntry.d = paramBitmap;
    localUploadMediaEntry.g = paramString;
    localUploadMediaEntry.i = paramInt2;
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
      localActivity = this.mRuntime.d();
    }
    if (localActivity == null)
    {
      this.x.sendEmptyMessage(3);
      return;
    }
    if ((localActivity instanceof AppActivity))
    {
      int i1;
      if ((Build.VERSION.SDK_INT >= 23) && ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0)
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
    JSONObject localJSONObject = a(this.f, paramInt, 2, "uploading", null, -1);
    try
    {
      localJSONObject.put("progress", paramFloat);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    callJs(this.d, new String[] { localJSONObject.toString() });
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
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("', 'type':'record', 'state':'stopPlay', 'url':'");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'}");
      localObject = ((StringBuilder)localObject).toString();
      callJs(this.d, new String[] { localObject });
      localObject = this.n;
      if ((localObject != null) && (((String)localObject).equals(paramString))) {
        this.n = null;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{'webid':'");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("', 'type':'record', 'state':'downloaded', 'url':'");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'}");
      paramString = ((StringBuilder)localObject).toString();
      callJs(this.d, new String[] { paramString });
    }
  }
  
  public void a(String paramString, double paramDouble)
  {
    this.s.put(Integer.valueOf(this.k), paramString);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.k);
      localJSONObject.put("state", "stop");
      localJSONObject.put("path", paramString);
      localJSONObject.put("time", Math.round(paramDouble / 1000.0D));
      callJs(this.d, new String[] { localJSONObject.toString() });
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.k += 1;
    if (this.q) {
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
      callJs(this.v, new String[] { paramString2.toString() });
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
      callJs(this.v, new String[] { localJSONObject.toString() });
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
    Activity localActivity = this.mRuntime.d();
    WebViewProvider localWebViewProvider = this.mRuntime.f();
    if ((!((ITroopHWApi)QRoute.api(ITroopHWApi.class)).isAbsBaseWebViewActivity(localActivity)) && (localWebViewProvider == null))
    {
      this.x.sendEmptyMessage(3);
      return;
    }
    ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).gotoSelectPicture(localActivity, localWebViewProvider, this, paramInt, (byte)3);
  }
  
  public void b(int paramInt, String paramString)
  {
    callJs(this.d, new String[] { a(this.f, paramInt, 0, "stopPlay", null, -1).toString() });
    int i1 = this.o;
    if ((i1 != -1) && (paramInt == i1)) {
      this.o = -1;
    }
  }
  
  protected void c(int paramInt)
  {
    Activity localActivity;
    if (this.mRuntime == null) {
      localActivity = null;
    } else {
      localActivity = this.mRuntime.d();
    }
    if (localActivity == null)
    {
      this.x.sendEmptyMessage(4);
      return;
    }
    if ((localActivity instanceof AppActivity))
    {
      int i1;
      if ((Build.VERSION.SDK_INT >= 23) && ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0)
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
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openTroopFilerDetailBrowse(this.mRuntime.d(), localForwardFileInfo);
    }
  }
  
  protected void d(int paramInt)
  {
    Activity localActivity = this.mRuntime.d();
    WebViewProvider localWebViewProvider = this.mRuntime.f();
    if ((!((ITroopHWApi)QRoute.api(ITroopHWApi.class)).isAbsBaseWebViewActivity(localActivity)) && (localWebViewProvider == null))
    {
      this.x.sendEmptyMessage(4);
      return;
    }
    Intent localIntent = a(paramInt, localActivity, this.mRuntime.b().getCurrentAccountUin());
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
      this.i = this.m.a();
      return false;
    }
    if ((paramLong == 2L) && (this.i))
    {
      paramString = new StringBuilder();
      paramString.append("{'webid':");
      paramString.append(this.f);
      paramString.append(", 'type':'home', 'state':'click'}");
      paramString = paramString.toString();
      callJs(this.d, new String[] { paramString });
      this.i = false;
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
    //   4: ifnull +2902 -> 2906
    //   7: ldc 115
    //   9: aload_3
    //   10: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +2893 -> 2906
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
    //   35: new 328	org/json/JSONObject
    //   38: dup
    //   39: aload 5
    //   41: iconst_0
    //   42: aaload
    //   43: invokespecial 823	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore_1
    //   47: goto +5 -> 52
    //   50: aconst_null
    //   51: astore_1
    //   52: ldc_w 825
    //   55: aload 4
    //   57: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: istore 8
    //   62: ldc_w 410
    //   65: astore 15
    //   67: iload 8
    //   69: ifeq +86 -> 155
    //   72: aload 19
    //   74: astore_2
    //   75: aload_1
    //   76: ifnull +11 -> 87
    //   79: aload_1
    //   80: ldc_w 826
    //   83: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload_0
    //   88: aload_2
    //   89: iconst_1
    //   90: anewarray 343	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: ldc_w 410
    //   98: aastore
    //   99: invokevirtual 348	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   102: aload_0
    //   103: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   106: invokevirtual 529	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnonnull +5 -> 116
    //   114: iconst_0
    //   115: ireturn
    //   116: new 443	android/content/Intent
    //   119: dup
    //   120: invokespecial 444	android/content/Intent:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc_w 831
    //   128: aload 5
    //   130: iconst_0
    //   131: aaload
    //   132: invokevirtual 835	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   135: pop
    //   136: aload_1
    //   137: iconst_m1
    //   138: aload_2
    //   139: invokevirtual 839	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   142: aload_1
    //   143: invokevirtual 842	android/app/Activity:isFinishing	()Z
    //   146: ifne +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 845	android/app/Activity:finish	()V
    //   153: iconst_1
    //   154: ireturn
    //   155: aload_1
    //   156: ifnull +102 -> 258
    //   159: aload_1
    //   160: ldc_w 847
    //   163: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 19
    //   168: aload_1
    //   169: ldc_w 634
    //   172: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 20
    //   177: aload_0
    //   178: aload 19
    //   180: putfield 341	cooperation/troop_homework/jsp/TroopHWJsPlugin:d	Ljava/lang/String;
    //   183: aload_0
    //   184: aload 20
    //   186: putfield 210	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   189: aload_0
    //   190: aload_3
    //   191: putfield 93	cooperation/troop_homework/jsp/TroopHWJsPlugin:p	Ljava/lang/String;
    //   194: aload_0
    //   195: aload_1
    //   196: ldc_w 849
    //   199: ldc_w 410
    //   202: invokevirtual 851	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: putfield 852	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   208: aload_0
    //   209: aload_1
    //   210: ldc_w 854
    //   213: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   216: putfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	I
    //   219: aload_0
    //   220: aload_1
    //   221: ldc_w 859
    //   224: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   227: putfield 75	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	I
    //   230: aload_0
    //   231: getfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	I
    //   234: ifne +10 -> 244
    //   237: aload_0
    //   238: sipush 540
    //   241: putfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	I
    //   244: aload_0
    //   245: getfield 75	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	I
    //   248: ifne +10 -> 258
    //   251: aload_0
    //   252: sipush 540
    //   255: putfield 75	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	I
    //   258: ldc_w 861
    //   261: aload 4
    //   263: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +72 -> 338
    //   269: aload_0
    //   270: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   273: invokevirtual 529	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   276: astore_1
    //   277: new 443	android/content/Intent
    //   280: dup
    //   281: invokespecial 444	android/content/Intent:<init>	()V
    //   284: astore_2
    //   285: aload_2
    //   286: new 863	android/content/ComponentName
    //   289: dup
    //   290: aload_1
    //   291: ldc_w 865
    //   294: invokespecial 868	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   297: invokevirtual 872	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   300: pop
    //   301: aload_2
    //   302: ldc_w 634
    //   305: aload_0
    //   306: getfield 210	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   309: invokevirtual 835	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   312: pop
    //   313: aload_0
    //   314: getfield 341	cooperation/troop_homework/jsp/TroopHWJsPlugin:d	Ljava/lang/String;
    //   317: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +10 -> 330
    //   323: aload_1
    //   324: aload_2
    //   325: invokevirtual 876	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   328: iconst_1
    //   329: ireturn
    //   330: aload_0
    //   331: aload_2
    //   332: iconst_1
    //   333: invokevirtual 879	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   336: iconst_1
    //   337: ireturn
    //   338: ldc_w 881
    //   341: aload 4
    //   343: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifeq +113 -> 459
    //   349: aload_1
    //   350: ifnull +15 -> 365
    //   353: aload_1
    //   354: ldc_w 632
    //   357: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   360: istore 6
    //   362: goto +6 -> 368
    //   365: iconst_m1
    //   366: istore 6
    //   368: aload_0
    //   369: getfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:o	I
    //   372: istore 7
    //   374: iload 7
    //   376: iconst_m1
    //   377: if_icmpne +35 -> 412
    //   380: aload_0
    //   381: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   384: iload 6
    //   386: aload_0
    //   387: getfield 102	cooperation/troop_homework/jsp/TroopHWJsPlugin:s	Ljava/util/HashMap;
    //   390: iload 6
    //   392: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: invokevirtual 885	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   398: checkcast 343	java/lang/String
    //   401: invokevirtual 887	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   404: aload_0
    //   405: iload 6
    //   407: putfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:o	I
    //   410: iconst_1
    //   411: ireturn
    //   412: iload 6
    //   414: iload 7
    //   416: if_icmpeq +2488 -> 2904
    //   419: aload_0
    //   420: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   423: invokevirtual 812	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   426: pop
    //   427: aload_0
    //   428: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   431: iload 6
    //   433: aload_0
    //   434: getfield 102	cooperation/troop_homework/jsp/TroopHWJsPlugin:s	Ljava/util/HashMap;
    //   437: iload 6
    //   439: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   442: invokevirtual 885	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   445: checkcast 343	java/lang/String
    //   448: invokevirtual 887	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(ILjava/lang/String;)V
    //   451: aload_0
    //   452: iload 6
    //   454: putfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:o	I
    //   457: iconst_1
    //   458: ireturn
    //   459: ldc_w 889
    //   462: aload 4
    //   464: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifeq +56 -> 523
    //   470: aload_1
    //   471: ifnull +15 -> 486
    //   474: aload_1
    //   475: ldc_w 632
    //   478: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   481: istore 6
    //   483: goto +6 -> 489
    //   486: iconst_m1
    //   487: istore 6
    //   489: aload_0
    //   490: getfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:o	I
    //   493: istore 7
    //   495: iload 7
    //   497: iconst_m1
    //   498: if_icmpeq +2406 -> 2904
    //   501: iload 6
    //   503: iload 7
    //   505: if_icmpne +2399 -> 2904
    //   508: aload_0
    //   509: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   512: invokevirtual 812	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   515: pop
    //   516: aload_0
    //   517: iconst_m1
    //   518: putfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:o	I
    //   521: iconst_1
    //   522: ireturn
    //   523: ldc_w 891
    //   526: aload 4
    //   528: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: ifeq +223 -> 754
    //   534: bipush 10
    //   536: istore 6
    //   538: aload_1
    //   539: ifnull +34 -> 573
    //   542: aload_1
    //   543: ldc_w 893
    //   546: bipush 10
    //   548: invokevirtual 896	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   551: istore 6
    //   553: aload_0
    //   554: aload_1
    //   555: ldc_w 854
    //   558: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   561: putfield 81	cooperation/troop_homework/jsp/TroopHWJsPlugin:j	I
    //   564: aload_1
    //   565: ldc_w 898
    //   568: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   571: istore 7
    //   573: iload 7
    //   575: iconst_1
    //   576: if_icmpne +19 -> 595
    //   579: aload_0
    //   580: ldc 115
    //   582: invokestatic 902	com/tencent/mobileqq/webview/swift/WebViewUtil:a	(Ljava/lang/String;)I
    //   585: bipush 8
    //   587: ishl
    //   588: iconst_2
    //   589: iadd
    //   590: invokespecial 473	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	(I)V
    //   593: iconst_1
    //   594: ireturn
    //   595: iload 7
    //   597: iconst_2
    //   598: if_icmpne +11 -> 609
    //   601: aload_0
    //   602: iload 6
    //   604: invokevirtual 904	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(I)V
    //   607: iconst_1
    //   608: ireturn
    //   609: iload 7
    //   611: iconst_3
    //   612: if_icmpne +134 -> 746
    //   615: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +36 -> 654
    //   621: new 49	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   628: astore_2
    //   629: aload_2
    //   630: ldc_w 906
    //   633: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload_2
    //   638: aload_1
    //   639: invokevirtual 909	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: ldc_w 300
    //   646: iconst_2
    //   647: aload_2
    //   648: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: aload_0
    //   655: getfield 341	cooperation/troop_homework/jsp/TroopHWJsPlugin:d	Ljava/lang/String;
    //   658: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   661: ifne +24 -> 685
    //   664: aload_0
    //   665: getfield 852	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   668: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   671: ifeq +6 -> 677
    //   674: goto +11 -> 685
    //   677: aload_0
    //   678: iload 6
    //   680: invokevirtual 913	cooperation/troop_homework/jsp/TroopHWJsPlugin:c	(I)V
    //   683: iconst_1
    //   684: ireturn
    //   685: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +56 -> 744
    //   691: new 49	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   698: astore_1
    //   699: aload_1
    //   700: ldc_w 915
    //   703: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_1
    //   708: aload_0
    //   709: getfield 341	cooperation/troop_homework/jsp/TroopHWJsPlugin:d	Ljava/lang/String;
    //   712: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload_1
    //   717: ldc_w 917
    //   720: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload_1
    //   725: aload_0
    //   726: getfield 852	cooperation/troop_homework/jsp/TroopHWJsPlugin:g	Ljava/lang/String;
    //   729: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: ldc_w 300
    //   736: iconst_2
    //   737: aload_1
    //   738: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 511	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: iconst_1
    //   745: ireturn
    //   746: aload_0
    //   747: iload 6
    //   749: invokespecial 919	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(I)V
    //   752: iconst_1
    //   753: ireturn
    //   754: ldc_w 921
    //   757: aload 4
    //   759: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   762: istore 8
    //   764: lconst_0
    //   765: lstore 9
    //   767: iload 8
    //   769: ifeq +222 -> 991
    //   772: aload_1
    //   773: ifnull +55 -> 828
    //   776: aload_1
    //   777: ldc_w 923
    //   780: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   783: astore 4
    //   785: aload_1
    //   786: ldc_w 925
    //   789: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   792: astore_2
    //   793: aload_1
    //   794: ldc_w 849
    //   797: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   800: astore_3
    //   801: aload_1
    //   802: ldc_w 927
    //   805: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   808: astore 5
    //   810: aload_1
    //   811: ldc_w 929
    //   814: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   817: astore 15
    //   819: aload 4
    //   821: astore_1
    //   822: aload_1
    //   823: astore 4
    //   825: goto +22 -> 847
    //   828: aconst_null
    //   829: astore 15
    //   831: aload 15
    //   833: astore_1
    //   834: aload_1
    //   835: astore_2
    //   836: aload_2
    //   837: astore_3
    //   838: aload_2
    //   839: astore 4
    //   841: aload_1
    //   842: astore_2
    //   843: aload 16
    //   845: astore 5
    //   847: aload 5
    //   849: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   852: ifne +13 -> 865
    //   855: aload 5
    //   857: invokestatic 934	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   860: invokevirtual 937	java/lang/Long:longValue	()J
    //   863: lstore 9
    //   865: aload 15
    //   867: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   870: ifne +16 -> 886
    //   873: aload 15
    //   875: invokestatic 940	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   878: invokevirtual 943	java/lang/Integer:intValue	()I
    //   881: istore 6
    //   883: goto +7 -> 890
    //   886: bipush 102
    //   888: istore 6
    //   890: aload_3
    //   891: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   894: ifne +35 -> 929
    //   897: aload_0
    //   898: getfield 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:l	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   901: astore_1
    //   902: aload_3
    //   903: invokestatic 934	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   906: invokevirtual 937	java/lang/Long:longValue	()J
    //   909: lstore 11
    //   911: aload_1
    //   912: lload 11
    //   914: aload_2
    //   915: aload 4
    //   917: lload 9
    //   919: iload 6
    //   921: aload_0
    //   922: invokeinterface 949 9 0
    //   927: iconst_1
    //   928: ireturn
    //   929: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   932: ifeq +1972 -> 2904
    //   935: ldc_w 300
    //   938: iconst_2
    //   939: ldc_w 951
    //   942: invokestatic 953	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   945: iconst_1
    //   946: ireturn
    //   947: goto +3 -> 950
    //   950: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   953: ifeq +1951 -> 2904
    //   956: new 49	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   963: astore_1
    //   964: aload_1
    //   965: ldc_w 955
    //   968: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload_1
    //   973: aload_3
    //   974: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: ldc_w 300
    //   981: iconst_2
    //   982: aload_1
    //   983: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokestatic 953	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   989: iconst_1
    //   990: ireturn
    //   991: ldc_w 957
    //   994: aload 4
    //   996: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   999: ifeq +76 -> 1075
    //   1002: aload_1
    //   1003: ifnull +12 -> 1015
    //   1006: aload_1
    //   1007: ldc_w 640
    //   1010: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1013: astore 15
    //   1015: aload_0
    //   1016: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:n	Ljava/lang/String;
    //   1019: astore_1
    //   1020: aload_1
    //   1021: ifnonnull +20 -> 1041
    //   1024: aload_0
    //   1025: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1028: aload 15
    //   1030: invokevirtual 958	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(Ljava/lang/String;)V
    //   1033: aload_0
    //   1034: aload 15
    //   1036: putfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:n	Ljava/lang/String;
    //   1039: iconst_1
    //   1040: ireturn
    //   1041: aload_1
    //   1042: aload 15
    //   1044: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1047: ifne +1857 -> 2904
    //   1050: aload_0
    //   1051: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1054: invokevirtual 812	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   1057: pop
    //   1058: aload_0
    //   1059: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1062: aload 15
    //   1064: invokevirtual 958	cooperation/troop_homework/jsp/TroopHWVoiceController:a	(Ljava/lang/String;)V
    //   1067: aload_0
    //   1068: aload 15
    //   1070: putfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:n	Ljava/lang/String;
    //   1073: iconst_1
    //   1074: ireturn
    //   1075: ldc_w 960
    //   1078: aload 4
    //   1080: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1083: ifeq +49 -> 1132
    //   1086: aload_1
    //   1087: ifnull +12 -> 1099
    //   1090: aload_1
    //   1091: ldc_w 640
    //   1094: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1097: astore 15
    //   1099: aload_0
    //   1100: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:n	Ljava/lang/String;
    //   1103: astore_1
    //   1104: aload_1
    //   1105: ifnull +1799 -> 2904
    //   1108: aload_1
    //   1109: aload 15
    //   1111: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1114: ifeq +1790 -> 2904
    //   1117: aload_0
    //   1118: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1121: invokevirtual 812	cooperation/troop_homework/jsp/TroopHWVoiceController:a	()Z
    //   1124: pop
    //   1125: aload_0
    //   1126: aconst_null
    //   1127: putfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:n	Ljava/lang/String;
    //   1130: iconst_1
    //   1131: ireturn
    //   1132: ldc_w 962
    //   1135: aload 4
    //   1137: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1140: ifeq +22 -> 1162
    //   1143: aload_0
    //   1144: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1147: aload_0
    //   1148: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1151: invokevirtual 591	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   1154: invokevirtual 965	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1157: invokevirtual 967	cooperation/troop_homework/jsp/TroopHWVoiceController:e	(Ljava/lang/String;)V
    //   1160: iconst_1
    //   1161: ireturn
    //   1162: ldc_w 969
    //   1165: aload 4
    //   1167: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1170: ifeq +38 -> 1208
    //   1173: aload_1
    //   1174: ifnull +25 -> 1199
    //   1177: aload_0
    //   1178: aload_1
    //   1179: ldc_w 971
    //   1182: invokevirtual 975	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1185: putfield 95	cooperation/troop_homework/jsp/TroopHWJsPlugin:q	Z
    //   1188: aload_0
    //   1189: aload_1
    //   1190: ldc_w 977
    //   1193: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1196: putfield 97	cooperation/troop_homework/jsp/TroopHWJsPlugin:r	Ljava/lang/String;
    //   1199: aload_0
    //   1200: getfield 87	cooperation/troop_homework/jsp/TroopHWJsPlugin:m	Lcooperation/troop_homework/jsp/TroopHWVoiceController;
    //   1203: invokevirtual 979	cooperation/troop_homework/jsp/TroopHWVoiceController:b	()V
    //   1206: iconst_1
    //   1207: ireturn
    //   1208: ldc_w 981
    //   1211: aload 4
    //   1213: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1216: ifeq +24 -> 1240
    //   1219: new 983	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1222: dup
    //   1223: aload_0
    //   1224: aload_2
    //   1225: invokestatic 988	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   1228: invokespecial 989	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1231: bipush 8
    //   1233: aconst_null
    //   1234: iconst_0
    //   1235: invokestatic 709	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1238: iconst_1
    //   1239: ireturn
    //   1240: ldc_w 991
    //   1243: aload 4
    //   1245: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1248: ifeq +53 -> 1301
    //   1251: aload_1
    //   1252: ifnull +1652 -> 2904
    //   1255: aload_1
    //   1256: ldc_w 640
    //   1259: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1262: astore_2
    //   1263: aload_1
    //   1264: ldc_w 993
    //   1267: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1270: astore_3
    //   1271: aload_0
    //   1272: aload_1
    //   1273: ldc_w 847
    //   1276: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1279: putfield 718	cooperation/troop_homework/jsp/TroopHWJsPlugin:v	Ljava/lang/String;
    //   1282: aload_0
    //   1283: aload_3
    //   1284: aload_2
    //   1285: invokevirtual 721	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1288: astore_1
    //   1289: aload_0
    //   1290: getfield 995	cooperation/troop_homework/jsp/TroopHWJsPlugin:u	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1293: aload_2
    //   1294: aload_1
    //   1295: aload_0
    //   1296: invokevirtual 1000	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;Ljava/lang/String;Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager$OnDownloadStateListener;)V
    //   1299: iconst_1
    //   1300: ireturn
    //   1301: ldc_w 1002
    //   1304: aload 4
    //   1306: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1309: ifeq +25 -> 1334
    //   1312: aload_1
    //   1313: ifnull +1591 -> 2904
    //   1316: aload_1
    //   1317: ldc_w 640
    //   1320: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1323: astore_1
    //   1324: aload_0
    //   1325: getfield 995	cooperation/troop_homework/jsp/TroopHWJsPlugin:u	Lcooperation/troop_homework/jsp/TroopHWFileDownloadManager;
    //   1328: aload_1
    //   1329: invokevirtual 1003	cooperation/troop_homework/jsp/TroopHWFileDownloadManager:a	(Ljava/lang/String;)V
    //   1332: iconst_1
    //   1333: ireturn
    //   1334: ldc_w 1005
    //   1337: aload 4
    //   1339: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1342: ifeq +203 -> 1545
    //   1345: aload_1
    //   1346: ifnull +1558 -> 2904
    //   1349: aload_1
    //   1350: ldc_w 993
    //   1353: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1356: astore 4
    //   1358: aload_1
    //   1359: ldc_w 1007
    //   1362: invokevirtual 1011	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1365: astore 5
    //   1367: aload_1
    //   1368: ldc_w 847
    //   1371: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1374: astore_2
    //   1375: new 328	org/json/JSONObject
    //   1378: dup
    //   1379: invokespecial 630	org/json/JSONObject:<init>	()V
    //   1382: astore_3
    //   1383: new 1013	org/json/JSONArray
    //   1386: dup
    //   1387: invokespecial 1014	org/json/JSONArray:<init>	()V
    //   1390: astore 15
    //   1392: aload 5
    //   1394: invokevirtual 1016	org/json/JSONArray:length	()I
    //   1397: istore 7
    //   1399: iconst_0
    //   1400: istore 6
    //   1402: iload 6
    //   1404: iload 7
    //   1406: if_icmpge +33 -> 1439
    //   1409: aload 15
    //   1411: iload 6
    //   1413: aload_0
    //   1414: aload 4
    //   1416: aload 5
    //   1418: iload 6
    //   1420: invokevirtual 1019	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1423: invokevirtual 1021	cooperation/troop_homework/jsp/TroopHWJsPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1426: invokevirtual 1024	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1429: pop
    //   1430: iload 6
    //   1432: iconst_1
    //   1433: iadd
    //   1434: istore 6
    //   1436: goto -34 -> 1402
    //   1439: aload_3
    //   1440: ldc_w 1026
    //   1443: aload 15
    //   1445: invokevirtual 332	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1448: pop
    //   1449: goto +23 -> 1472
    //   1452: astore 4
    //   1454: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1457: ifeq +15 -> 1472
    //   1460: ldc_w 300
    //   1463: iconst_2
    //   1464: ldc_w 1028
    //   1467: aload 4
    //   1469: invokestatic 1031	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1472: aload_3
    //   1473: invokevirtual 344	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1476: astore_3
    //   1477: aload_0
    //   1478: aload_2
    //   1479: iconst_1
    //   1480: anewarray 343	java/lang/String
    //   1483: dup
    //   1484: iconst_0
    //   1485: aload_3
    //   1486: aastore
    //   1487: invokevirtual 348	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1490: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1493: ifeq +1411 -> 2904
    //   1496: new 49	java/lang/StringBuilder
    //   1499: dup
    //   1500: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1503: astore_2
    //   1504: aload_2
    //   1505: ldc_w 1028
    //   1508: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: pop
    //   1512: aload_2
    //   1513: aload_1
    //   1514: invokevirtual 909	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1517: pop
    //   1518: aload_2
    //   1519: ldc_w 1033
    //   1522: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload_2
    //   1527: aload_3
    //   1528: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: ldc_w 300
    //   1535: iconst_2
    //   1536: aload_2
    //   1537: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1543: iconst_1
    //   1544: ireturn
    //   1545: ldc_w 1035
    //   1548: aload 4
    //   1550: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1553: ifeq +75 -> 1628
    //   1556: aload_1
    //   1557: ifnull +1347 -> 2904
    //   1560: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1563: ifeq +36 -> 1599
    //   1566: new 49	java/lang/StringBuilder
    //   1569: dup
    //   1570: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1573: astore_2
    //   1574: aload_2
    //   1575: ldc_w 1037
    //   1578: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1581: pop
    //   1582: aload_2
    //   1583: aload_1
    //   1584: invokevirtual 909	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1587: pop
    //   1588: ldc_w 300
    //   1591: iconst_2
    //   1592: aload_2
    //   1593: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1596: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1599: aload_1
    //   1600: ldc_w 1039
    //   1603: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1606: astore_2
    //   1607: aload_1
    //   1608: ldc_w 1041
    //   1611: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1614: astore_1
    //   1615: aload_0
    //   1616: getfield 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:l	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   1619: aload_2
    //   1620: aload_1
    //   1621: invokeinterface 1044 3 0
    //   1626: iconst_1
    //   1627: ireturn
    //   1628: ldc_w 1046
    //   1631: aload 4
    //   1633: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1636: ifeq +57 -> 1693
    //   1639: aload_1
    //   1640: ifnull +53 -> 1693
    //   1643: aload_1
    //   1644: ldc_w 642
    //   1647: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1650: pop
    //   1651: aload_1
    //   1652: ldc_w 632
    //   1655: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1658: istore 6
    //   1660: aload_0
    //   1661: getfield 104	cooperation/troop_homework/jsp/TroopHWJsPlugin:t	Ljava/util/HashMap;
    //   1664: iload 6
    //   1666: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1669: invokevirtual 885	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1672: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1675: astore_1
    //   1676: aload_1
    //   1677: ifnull +1227 -> 2904
    //   1680: aload_1
    //   1681: getfield 1048	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:f	Z
    //   1684: ifne +1220 -> 2904
    //   1687: aload_1
    //   1688: invokevirtual 1049	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:b	()V
    //   1691: iconst_1
    //   1692: ireturn
    //   1693: ldc_w 1051
    //   1696: aload 4
    //   1698: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1701: ifeq +61 -> 1762
    //   1704: aload_1
    //   1705: ifnull +57 -> 1762
    //   1708: aload_1
    //   1709: ldc_w 642
    //   1712: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1715: pop
    //   1716: aload_1
    //   1717: ldc_w 632
    //   1720: invokevirtual 857	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1723: istore 6
    //   1725: aload_0
    //   1726: getfield 104	cooperation/troop_homework/jsp/TroopHWJsPlugin:t	Ljava/util/HashMap;
    //   1729: iload 6
    //   1731: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1734: invokevirtual 885	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1737: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1740: astore_1
    //   1741: aload_1
    //   1742: ifnull +1162 -> 2904
    //   1745: aload_1
    //   1746: getfield 1048	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:f	Z
    //   1749: ifeq +1155 -> 2904
    //   1752: aload_1
    //   1753: getfield 1054	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1756: iconst_1
    //   1757: invokevirtual 1060	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1760: iconst_1
    //   1761: ireturn
    //   1762: ldc_w 1062
    //   1765: aload 4
    //   1767: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1770: ifeq +83 -> 1853
    //   1773: aload_1
    //   1774: ifnull +1130 -> 2904
    //   1777: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1780: ifeq +24 -> 1804
    //   1783: ldc_w 300
    //   1786: iconst_2
    //   1787: iconst_2
    //   1788: anewarray 302	java/lang/Object
    //   1791: dup
    //   1792: iconst_0
    //   1793: ldc_w 1064
    //   1796: aastore
    //   1797: dup
    //   1798: iconst_1
    //   1799: aload_1
    //   1800: aastore
    //   1801: invokestatic 313	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1804: aload_1
    //   1805: ldc_w 993
    //   1808: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1811: astore_2
    //   1812: aload_1
    //   1813: ldc_w 642
    //   1816: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1819: astore_1
    //   1820: aload_0
    //   1821: getfield 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:l	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   1824: aload_2
    //   1825: aload_1
    //   1826: invokeinterface 1067 3 0
    //   1831: iconst_1
    //   1832: ireturn
    //   1833: astore_1
    //   1834: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1837: ifeq +1067 -> 2904
    //   1840: ldc_w 300
    //   1843: iconst_2
    //   1844: ldc_w 1069
    //   1847: aload_1
    //   1848: invokestatic 1031	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1851: iconst_1
    //   1852: ireturn
    //   1853: ldc_w 1071
    //   1856: aload 4
    //   1858: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1861: ifeq +161 -> 2022
    //   1864: aload_1
    //   1865: ifnull +1039 -> 2904
    //   1868: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1871: ifeq +36 -> 1907
    //   1874: new 49	java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1881: astore_2
    //   1882: aload_2
    //   1883: ldc_w 1073
    //   1886: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1889: pop
    //   1890: aload_2
    //   1891: aload_1
    //   1892: invokevirtual 909	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1895: pop
    //   1896: ldc_w 300
    //   1899: iconst_2
    //   1900: aload_2
    //   1901: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1904: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1907: aload_1
    //   1908: ldc_w 632
    //   1911: iconst_0
    //   1912: invokevirtual 896	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1915: istore 6
    //   1917: aload_0
    //   1918: getfield 104	cooperation/troop_homework/jsp/TroopHWJsPlugin:t	Ljava/util/HashMap;
    //   1921: iload 6
    //   1923: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1926: invokevirtual 885	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1929: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   1932: astore_1
    //   1933: aload_1
    //   1934: ifnull +53 -> 1987
    //   1937: aload_1
    //   1938: getfield 612	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:g	Ljava/lang/String;
    //   1941: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1944: ifne +43 -> 1987
    //   1947: new 753	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1950: dup
    //   1951: invokespecial 754	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1954: astore_2
    //   1955: aload_2
    //   1956: aload_1
    //   1957: getfield 612	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:g	Ljava/lang/String;
    //   1960: invokevirtual 772	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:a	(Ljava/lang/String;)V
    //   1963: ldc_w 786
    //   1966: invokestatic 154	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1969: checkcast 786	com/tencent/mobileqq/filemanager/api/IQQFileTempUtils
    //   1972: aload_0
    //   1973: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1976: invokevirtual 529	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   1979: aload_2
    //   1980: invokeinterface 790 3 0
    //   1985: iconst_1
    //   1986: ireturn
    //   1987: new 49	java/lang/StringBuilder
    //   1990: dup
    //   1991: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1994: astore_2
    //   1995: aload_2
    //   1996: ldc_w 1075
    //   1999: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: pop
    //   2003: aload_2
    //   2004: aload_1
    //   2005: invokevirtual 909	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2008: pop
    //   2009: ldc_w 300
    //   2012: iconst_1
    //   2013: aload_2
    //   2014: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2017: invokestatic 953	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2020: iconst_1
    //   2021: ireturn
    //   2022: ldc_w 1077
    //   2025: aload 4
    //   2027: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2030: ifeq +17 -> 2047
    //   2033: aload_0
    //   2034: getfield 104	cooperation/troop_homework/jsp/TroopHWJsPlugin:t	Ljava/util/HashMap;
    //   2037: invokevirtual 1080	java/util/HashMap:clear	()V
    //   2040: aload_0
    //   2041: iconst_1
    //   2042: putfield 83	cooperation/troop_homework/jsp/TroopHWJsPlugin:k	I
    //   2045: iconst_1
    //   2046: ireturn
    //   2047: ldc_w 1082
    //   2050: aload 4
    //   2052: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2055: ifeq +78 -> 2133
    //   2058: aload_1
    //   2059: ifnull +845 -> 2904
    //   2062: aload_1
    //   2063: ldc_w 632
    //   2066: iconst_0
    //   2067: invokevirtual 896	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2070: istore 6
    //   2072: aload_0
    //   2073: getfield 104	cooperation/troop_homework/jsp/TroopHWJsPlugin:t	Ljava/util/HashMap;
    //   2076: iload 6
    //   2078: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2081: invokevirtual 885	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2084: checkcast 581	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry
    //   2087: astore_1
    //   2088: aload_1
    //   2089: ifnull +815 -> 2904
    //   2092: aload_1
    //   2093: getfield 612	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:g	Ljava/lang/String;
    //   2096: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2099: ifne +805 -> 2904
    //   2102: new 169	java/io/File
    //   2105: dup
    //   2106: aload_1
    //   2107: getfield 612	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:g	Ljava/lang/String;
    //   2110: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   2113: astore_2
    //   2114: aload_0
    //   2115: getfield 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:l	Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;
    //   2118: aload_1
    //   2119: getfield 612	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:g	Ljava/lang/String;
    //   2122: aload_2
    //   2123: invokevirtual 1085	java/io/File:getName	()Ljava/lang/String;
    //   2126: invokeinterface 1044 3 0
    //   2131: iconst_1
    //   2132: ireturn
    //   2133: ldc_w 1087
    //   2136: aload 4
    //   2138: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2141: ifeq +192 -> 2333
    //   2144: new 328	org/json/JSONObject
    //   2147: dup
    //   2148: aload 5
    //   2150: iconst_0
    //   2151: aaload
    //   2152: invokespecial 823	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2155: ldc_w 1089
    //   2158: invokevirtual 1090	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2161: astore_2
    //   2162: aload_2
    //   2163: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2166: istore 8
    //   2168: iload 8
    //   2170: ifne +734 -> 2904
    //   2173: aload_2
    //   2174: invokestatic 1093	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2177: lstore 9
    //   2179: goto +6 -> 2185
    //   2182: lconst_0
    //   2183: lstore 9
    //   2185: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2188: ifeq +37 -> 2225
    //   2191: new 49	java/lang/StringBuilder
    //   2194: dup
    //   2195: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2198: astore_1
    //   2199: aload_1
    //   2200: ldc_w 1095
    //   2203: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: pop
    //   2207: aload_1
    //   2208: lload 9
    //   2210: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2213: pop
    //   2214: ldc_w 300
    //   2217: iconst_2
    //   2218: aload_1
    //   2219: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2222: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2225: lload 9
    //   2227: lconst_0
    //   2228: lcmp
    //   2229: ifle +43 -> 2272
    //   2232: aload_0
    //   2233: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2236: ifnull +704 -> 2940
    //   2239: aload_0
    //   2240: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2243: invokevirtual 529	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   2246: astore_1
    //   2247: goto +3 -> 2250
    //   2250: aload_1
    //   2251: ifnull +653 -> 2904
    //   2254: aload_1
    //   2255: aconst_null
    //   2256: aload_2
    //   2257: invokestatic 1100	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2260: aload_1
    //   2261: ldc_w 1101
    //   2264: ldc_w 1102
    //   2267: invokevirtual 1105	android/app/Activity:overridePendingTransition	(II)V
    //   2270: iconst_1
    //   2271: ireturn
    //   2272: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2275: ifeq +629 -> 2904
    //   2278: new 49	java/lang/StringBuilder
    //   2281: dup
    //   2282: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2285: astore_1
    //   2286: aload_1
    //   2287: ldc_w 1107
    //   2290: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2293: pop
    //   2294: aload_1
    //   2295: aload_2
    //   2296: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2299: pop
    //   2300: ldc_w 300
    //   2303: iconst_2
    //   2304: aload_1
    //   2305: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2308: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2311: iconst_1
    //   2312: ireturn
    //   2313: astore_1
    //   2314: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2317: ifeq +587 -> 2904
    //   2320: ldc_w 300
    //   2323: iconst_2
    //   2324: ldc_w 1109
    //   2327: aload_1
    //   2328: invokestatic 1031	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2331: iconst_1
    //   2332: ireturn
    //   2333: ldc_w 1111
    //   2336: aload 4
    //   2338: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2341: ifeq +250 -> 2591
    //   2344: new 328	org/json/JSONObject
    //   2347: dup
    //   2348: aload 5
    //   2350: iconst_0
    //   2351: aaload
    //   2352: invokespecial 823	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2355: astore_1
    //   2356: aload_1
    //   2357: ldc_w 1113
    //   2360: invokevirtual 1090	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2363: astore_2
    //   2364: aload_2
    //   2365: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2368: istore 8
    //   2370: iload 8
    //   2372: ifne +532 -> 2904
    //   2375: aload_2
    //   2376: invokestatic 1093	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2379: lstore 11
    //   2381: goto +6 -> 2387
    //   2384: lconst_0
    //   2385: lstore 11
    //   2387: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2390: ifeq +37 -> 2427
    //   2393: new 49	java/lang/StringBuilder
    //   2396: dup
    //   2397: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2400: astore_2
    //   2401: aload_2
    //   2402: ldc_w 1115
    //   2405: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2408: pop
    //   2409: aload_2
    //   2410: lload 11
    //   2412: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2415: pop
    //   2416: ldc_w 300
    //   2419: iconst_2
    //   2420: aload_2
    //   2421: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2424: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2427: aload_1
    //   2428: ldc_w 1089
    //   2431: invokevirtual 1090	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2434: astore_1
    //   2435: aload_1
    //   2436: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2439: istore 8
    //   2441: iload 8
    //   2443: ifne +502 -> 2945
    //   2446: aload_1
    //   2447: invokestatic 1093	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2450: lstore 9
    //   2452: goto +6 -> 2458
    //   2455: lconst_0
    //   2456: lstore 9
    //   2458: lload 9
    //   2460: lstore 13
    //   2462: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2465: ifeq +44 -> 2509
    //   2468: new 49	java/lang/StringBuilder
    //   2471: dup
    //   2472: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2475: astore_1
    //   2476: aload_1
    //   2477: ldc_w 1095
    //   2480: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: pop
    //   2484: aload_1
    //   2485: lload 9
    //   2487: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2490: pop
    //   2491: ldc_w 300
    //   2494: iconst_2
    //   2495: aload_1
    //   2496: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2499: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2502: lload 9
    //   2504: lstore 13
    //   2506: goto +3 -> 2509
    //   2509: lload 11
    //   2511: lconst_0
    //   2512: lcmp
    //   2513: ifle +391 -> 2904
    //   2516: lload 13
    //   2518: lconst_0
    //   2519: lcmp
    //   2520: ifle +384 -> 2904
    //   2523: aload 17
    //   2525: astore_1
    //   2526: aload_0
    //   2527: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2530: ifnull +11 -> 2541
    //   2533: aload_0
    //   2534: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2537: invokevirtual 529	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   2540: astore_1
    //   2541: aload_0
    //   2542: aload_1
    //   2543: lload 13
    //   2545: lload 11
    //   2547: invokestatic 1120	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2550: bipush 7
    //   2552: invokevirtual 879	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2555: aload_1
    //   2556: ifnull +348 -> 2904
    //   2559: aload_1
    //   2560: ldc_w 1101
    //   2563: ldc_w 1102
    //   2566: invokevirtual 1105	android/app/Activity:overridePendingTransition	(II)V
    //   2569: iconst_1
    //   2570: ireturn
    //   2571: astore_1
    //   2572: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2575: ifeq +329 -> 2904
    //   2578: ldc_w 300
    //   2581: iconst_2
    //   2582: ldc_w 1109
    //   2585: aload_1
    //   2586: invokestatic 1031	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2589: iconst_1
    //   2590: ireturn
    //   2591: ldc_w 1122
    //   2594: aload 4
    //   2596: invokevirtual 681	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2599: ifeq +305 -> 2904
    //   2602: new 328	org/json/JSONObject
    //   2605: dup
    //   2606: aload 5
    //   2608: iconst_0
    //   2609: aaload
    //   2610: invokespecial 823	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2613: astore_2
    //   2614: aload_2
    //   2615: ldc_w 1113
    //   2618: invokevirtual 1090	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2621: astore_1
    //   2622: aload_2
    //   2623: ldc_w 1089
    //   2626: invokevirtual 1090	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2629: astore_2
    //   2630: aload_1
    //   2631: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2634: ifne +197 -> 2831
    //   2637: aload_2
    //   2638: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2641: istore 8
    //   2643: iload 8
    //   2645: ifne +186 -> 2831
    //   2648: aload_1
    //   2649: invokestatic 1093	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2652: lstore 9
    //   2654: goto +6 -> 2660
    //   2657: lconst_0
    //   2658: lstore 9
    //   2660: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2663: ifeq +37 -> 2700
    //   2666: new 49	java/lang/StringBuilder
    //   2669: dup
    //   2670: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2673: astore_1
    //   2674: aload_1
    //   2675: ldc_w 1124
    //   2678: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2681: pop
    //   2682: aload_1
    //   2683: lload 9
    //   2685: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2688: pop
    //   2689: ldc_w 300
    //   2692: iconst_2
    //   2693: aload_1
    //   2694: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2697: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2700: aload_2
    //   2701: invokestatic 1093	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2704: lstore 11
    //   2706: goto +6 -> 2712
    //   2709: lconst_0
    //   2710: lstore 11
    //   2712: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2715: ifeq +37 -> 2752
    //   2718: new 49	java/lang/StringBuilder
    //   2721: dup
    //   2722: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2725: astore_1
    //   2726: aload_1
    //   2727: ldc_w 1126
    //   2730: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2733: pop
    //   2734: aload_1
    //   2735: lload 11
    //   2737: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2740: pop
    //   2741: ldc_w 300
    //   2744: iconst_2
    //   2745: aload_1
    //   2746: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2749: invokestatic 911	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2752: lload 9
    //   2754: lconst_0
    //   2755: lcmp
    //   2756: ifle +148 -> 2904
    //   2759: lload 11
    //   2761: lconst_0
    //   2762: lcmp
    //   2763: ifle +141 -> 2904
    //   2766: aload 18
    //   2768: astore_1
    //   2769: aload_0
    //   2770: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2773: ifnull +11 -> 2784
    //   2776: aload_0
    //   2777: getfield 524	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2780: invokevirtual 529	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   2783: astore_1
    //   2784: new 748	android/os/Bundle
    //   2787: dup
    //   2788: invokespecial 1127	android/os/Bundle:<init>	()V
    //   2791: astore_3
    //   2792: aload_3
    //   2793: ldc_w 1113
    //   2796: lload 9
    //   2798: invokevirtual 1131	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2801: aload_3
    //   2802: ldc_w 1133
    //   2805: iconst_2
    //   2806: invokevirtual 1137	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2809: aload_1
    //   2810: ifnull +94 -> 2904
    //   2813: aload_1
    //   2814: aload_3
    //   2815: aload_2
    //   2816: invokestatic 1100	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2819: aload_1
    //   2820: ldc_w 1101
    //   2823: ldc_w 1102
    //   2826: invokevirtual 1105	android/app/Activity:overridePendingTransition	(II)V
    //   2829: iconst_1
    //   2830: ireturn
    //   2831: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2834: ifeq +70 -> 2904
    //   2837: new 49	java/lang/StringBuilder
    //   2840: dup
    //   2841: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2844: astore_3
    //   2845: aload_3
    //   2846: ldc_w 1139
    //   2849: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2852: pop
    //   2853: aload_3
    //   2854: aload_1
    //   2855: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2858: pop
    //   2859: aload_3
    //   2860: ldc_w 1141
    //   2863: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2866: pop
    //   2867: aload_3
    //   2868: aload_2
    //   2869: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2872: pop
    //   2873: ldc_w 300
    //   2876: iconst_2
    //   2877: aload_3
    //   2878: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2881: invokestatic 953	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2884: iconst_1
    //   2885: ireturn
    //   2886: astore_1
    //   2887: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2890: ifeq +14 -> 2904
    //   2893: ldc_w 300
    //   2896: iconst_2
    //   2897: ldc_w 1109
    //   2900: aload_1
    //   2901: invokestatic 1031	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2904: iconst_1
    //   2905: ireturn
    //   2906: iconst_0
    //   2907: ireturn
    //   2908: astore_1
    //   2909: goto -2859 -> 50
    //   2912: astore_1
    //   2913: goto -1963 -> 950
    //   2916: astore_1
    //   2917: goto -1970 -> 947
    //   2920: astore_1
    //   2921: goto -739 -> 2182
    //   2924: astore_2
    //   2925: goto -541 -> 2384
    //   2928: astore_1
    //   2929: goto -474 -> 2455
    //   2932: astore_1
    //   2933: goto -276 -> 2657
    //   2936: astore_1
    //   2937: goto -228 -> 2709
    //   2940: aconst_null
    //   2941: astore_1
    //   2942: goto -692 -> 2250
    //   2945: lconst_0
    //   2946: lstore 13
    //   2948: goto -439 -> 2509
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2951	0	this	TroopHWJsPlugin
    //   0	2951	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2951	2	paramString1	String
    //   0	2951	3	paramString2	String
    //   0	2951	4	paramString3	String
    //   0	2951	5	paramVarArgs	String[]
    //   360	1717	6	i1	int
    //   1	1406	7	i2	int
    //   60	2584	8	bool	boolean
    //   765	2032	9	l1	long
    //   909	1851	11	l2	long
    //   2460	487	13	l3	long
    //   65	1379	15	localObject1	Object
    //   24	820	16	localObject2	Object
    //   27	2497	17	localObject3	Object
    //   30	2737	18	localObject4	Object
    //   33	146	19	str1	String
    //   175	10	20	str2	String
    // Exception table:
    //   from	to	target	type
    //   1383	1399	1452	java/lang/Exception
    //   1409	1430	1452	java/lang/Exception
    //   1439	1449	1452	java/lang/Exception
    //   1804	1831	1833	java/lang/Exception
    //   2144	2168	2313	java/lang/Exception
    //   2185	2225	2313	java/lang/Exception
    //   2232	2247	2313	java/lang/Exception
    //   2254	2270	2313	java/lang/Exception
    //   2272	2311	2313	java/lang/Exception
    //   2344	2370	2571	java/lang/Exception
    //   2387	2427	2571	java/lang/Exception
    //   2427	2441	2571	java/lang/Exception
    //   2462	2502	2571	java/lang/Exception
    //   2526	2541	2571	java/lang/Exception
    //   2541	2555	2571	java/lang/Exception
    //   2559	2569	2571	java/lang/Exception
    //   2602	2643	2886	java/lang/Exception
    //   2660	2700	2886	java/lang/Exception
    //   2712	2752	2886	java/lang/Exception
    //   2769	2784	2886	java/lang/Exception
    //   2784	2809	2886	java/lang/Exception
    //   2813	2829	2886	java/lang/Exception
    //   2831	2884	2886	java/lang/Exception
    //   35	47	2908	org/json/JSONException
    //   890	911	2912	java/lang/NumberFormatException
    //   911	927	2916	java/lang/NumberFormatException
    //   929	945	2916	java/lang/NumberFormatException
    //   2173	2179	2920	java/lang/Exception
    //   2375	2381	2924	java/lang/Exception
    //   2446	2452	2928	java/lang/Exception
    //   2648	2654	2932	java/lang/Exception
    //   2700	2706	2936	java/lang/Exception
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
            callJs(this.d, new String[] { paramIntent });
          }
        }
      }
      else if (paramInt == -1)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        Object localObject1;
        if ((paramByte == 2) && (!TextUtils.isEmpty(this.e)))
        {
          BaseImageUtil.b(this.mRuntime.d(), this.e);
          localHashMap1.put(Integer.valueOf(this.k), this.e);
          this.k += 1;
        }
        else
        {
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          } else {
            localObject1 = null;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
            break label879;
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
              localHashMap2.put(Integer.valueOf(this.k), localObject3);
            } else {
              localHashMap1.put(Integer.valueOf(this.k), localObject3);
            }
            this.k += 1;
          }
          if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.g))) {
            break label819;
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
          paramIntent = new VFSFile(a);
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
                callJs(this.d, new String[] { a(this.f, paramInt, 2, "select", null, -1).toString() });
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                this.x.sendEmptyMessage(0);
              }
            }
          }
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressVideoJob(this, new TroopHWJsPlugin.RequestSource(this.d, this.g, this.f), localHashMap2), null, false);
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
          paramIntent = new VFSFile(a);
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
                callJs(this.d, new String[] { a(this.f, paramInt, 1, "select", null, -1).toString() });
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
                this.x.sendEmptyMessage(0);
              }
            }
          }
          ThreadManager.postImmediately(new TroopHWJsPlugin.CompressImageJob(this, localHashMap1), null, false);
          return;
          label819:
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("mJsCallback == ");
            paramIntent.append(this.d);
            paramIntent.append(", mTroopUin == ");
            paramIntent.append(this.g);
            QLog.w("TroopHWJsPlugin", 2, paramIntent.toString());
            return;
            label879:
            QLog.e("TroopHWJsPlugin", 1, "selected list empty!");
            this.x.sendEmptyMessage(0);
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
          ((JSONObject)localObject2).put("id", this.k);
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
        this.x.sendEmptyMessage(0);
        return;
      }
      callJs(this.d, new String[] { ((JSONObject)localObject2).toString() });
      if (paramIntent == null) {
        paramIntent = "";
      } else {
        paramIntent = paramIntent.getStringExtra("localPath");
      }
      this.s.put(Integer.valueOf(this.k), paramIntent);
      Object localObject2 = new TroopHWJsPlugin.RequestSource(this.d, this.g, this.f);
      paramIntent = a(this, this.k, paramIntent, null, (TroopHWJsPlugin.RequestSource)localObject2, 0);
      this.t.put(Integer.valueOf(this.k), paramIntent);
      paramIntent.b.a();
      this.k += 1;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.l = ((ITroopMemberApiClientApi)QRoute.api(ITroopMemberApiClientApi.class));
    this.l.doBindService();
    this.m = new TroopHWVoiceController(this.mRuntime.d(), this);
    this.u = new TroopHWFileDownloadManager(this.mRuntime.d());
  }
  
  protected void onDestroy()
  {
    Object localObject1 = this.l;
    if (localObject1 != null) {
      ((ITroopMemberApiClientApi)localObject1).doUnbindService();
    }
    super.onDestroy();
    localObject1 = this.u;
    if (localObject1 != null) {
      ((TroopHWFileDownloadManager)localObject1).a(this.mRuntime.d());
    }
    if ("homework".equals(this.p))
    {
      localObject1 = new VFSFile(a);
      boolean bool = ((VFSFile)localObject1).exists();
      int i2 = 0;
      int i1;
      if (bool)
      {
        localObject1 = ((VFSFile)localObject1).listFiles();
        i1 = 0;
        while (i1 < localObject1.length)
        {
          localObject1[i1].delete();
          i1 += 1;
        }
      }
      localObject1 = new VFSFile(AppConstants.SDCARD_HOMEWORK_AUDIO);
      if (((VFSFile)localObject1).exists())
      {
        localObject1 = ((VFSFile)localObject1).listFiles();
        i1 = i2;
        while (i1 < localObject1.length)
        {
          localObject1[i1].delete();
          i1 += 1;
        }
      }
      localObject1 = this.s.entrySet().iterator();
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
      this.w = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */