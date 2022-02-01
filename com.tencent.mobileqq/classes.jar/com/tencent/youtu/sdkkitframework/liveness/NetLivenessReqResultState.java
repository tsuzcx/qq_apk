package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;
import android.util.Base64;
import com.tencent.youtu.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.EncryptUtil;
import com.tencent.youtu.sdkkitframework.common.WeJson;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NetLivenessReqResultState
  extends YtFSMBaseState
{
  private static final String TAG = "NetLivenessReqResultState";
  private int actRefUXMode = 0;
  private int actReflectType = 0;
  private String appId;
  private int backendProtoType = 0;
  private YuvImage bestImage;
  private int changePointNum = 2;
  private String controlConfig = "";
  private String extraConfig = "";
  private int finalConfidenceThreshold;
  private JSONObject jsonOptionObject = null;
  boolean needEncrypt = false;
  private boolean needManualTrigger = false;
  boolean needVideoData = true;
  private HashMap<String, String> requestOptions = new HashMap();
  private String resultUrl;
  private String secretId;
  private String secretKey;
  private String sessionId = "";
  private int simiThreshold = 70;
  private String userId;
  
  /* Error */
  private void handleResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 92	java/util/HashMap:keySet	()Ljava/util/Set;
    //   4: invokeinterface 98 1 0
    //   9: astore 12
    //   11: aload 12
    //   13: invokeinterface 104 1 0
    //   18: ifeq +58 -> 76
    //   21: aload 12
    //   23: invokeinterface 108 1 0
    //   28: checkcast 110	java/lang/String
    //   31: astore 13
    //   33: getstatic 75	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   36: astore 14
    //   38: new 112	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   45: astore 15
    //   47: aload 15
    //   49: ldc 115
    //   51: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 15
    //   57: aload 13
    //   59: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 14
    //   65: aload 15
    //   67: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 128	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   73: goto -62 -> 11
    //   76: invokestatic 134	com/tencent/youtu/sdkkitframework/common/YtSDKStats:getInstance	()Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   79: invokevirtual 137	com/tencent/youtu/sdkkitframework/common/YtSDKStats:exitState	()V
    //   82: aload_2
    //   83: ifnull +74 -> 157
    //   86: getstatic 75	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   89: ldc 139
    //   91: invokestatic 143	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: invokestatic 134	com/tencent/youtu/sdkkitframework/common/YtSDKStats:getInstance	()Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   97: ldc 144
    //   99: aload_2
    //   100: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 153	com/tencent/youtu/sdkkitframework/common/YtSDKStats:reportError	(ILjava/lang/String;)V
    //   106: aload_2
    //   107: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: astore 12
    //   112: aload 12
    //   114: astore_2
    //   115: aload_1
    //   116: ifnull +25 -> 141
    //   119: aload 12
    //   121: astore_2
    //   122: aload_1
    //   123: ldc 155
    //   125: invokevirtual 159	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   128: ifeq +13 -> 141
    //   131: aload_1
    //   132: ldc 155
    //   134: invokevirtual 163	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 110	java/lang/String
    //   140: astore_2
    //   141: invokestatic 168	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   144: new 170	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState$3
    //   147: dup
    //   148: aload_0
    //   149: aload_2
    //   150: invokespecial 173	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState$3:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState;Ljava/lang/String;)V
    //   153: invokevirtual 177	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   156: return
    //   157: new 179	org/json/JSONObject
    //   160: dup
    //   161: aload_1
    //   162: ldc 155
    //   164: invokevirtual 163	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   167: checkcast 110	java/lang/String
    //   170: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   173: astore_2
    //   174: aload_2
    //   175: ldc 184
    //   177: invokevirtual 188	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   180: istore 10
    //   182: aload_2
    //   183: ldc 190
    //   185: invokevirtual 188	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   188: ifne +31 -> 219
    //   191: aload_2
    //   192: ldc 192
    //   194: invokevirtual 188	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   197: ifeq +6 -> 203
    //   200: goto +19 -> 219
    //   203: getstatic 75	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   206: ldc 194
    //   208: invokestatic 197	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: iconst_m1
    //   212: istore 4
    //   214: iconst_m1
    //   215: istore_3
    //   216: goto +186 -> 402
    //   219: aload_0
    //   220: getfield 59	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:backendProtoType	I
    //   223: ifne +13 -> 236
    //   226: aload_2
    //   227: ldc 190
    //   229: invokevirtual 201	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   232: istore_3
    //   233: goto +693 -> 926
    //   236: aload_2
    //   237: ldc 192
    //   239: invokevirtual 188	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   242: ifeq +13 -> 255
    //   245: aload_2
    //   246: ldc 192
    //   248: invokevirtual 201	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   251: istore_3
    //   252: goto +674 -> 926
    //   255: aload_2
    //   256: ldc 190
    //   258: invokevirtual 188	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   261: ifeq +13 -> 274
    //   264: aload_2
    //   265: ldc 190
    //   267: invokevirtual 201	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   270: istore_3
    //   271: goto +655 -> 926
    //   274: iconst_m1
    //   275: istore 4
    //   277: iload 10
    //   279: ifeq +17 -> 296
    //   282: aload_2
    //   283: ldc 184
    //   285: invokevirtual 201	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   288: istore_3
    //   289: goto +9 -> 298
    //   292: astore_2
    //   293: goto +233 -> 526
    //   296: iconst_m1
    //   297: istore_3
    //   298: iload 4
    //   300: istore 7
    //   302: iload_3
    //   303: istore 6
    //   305: getstatic 75	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   308: astore 12
    //   310: iload 4
    //   312: istore 7
    //   314: iload_3
    //   315: istore 6
    //   317: new 112	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   324: astore 13
    //   326: iload 4
    //   328: istore 7
    //   330: iload_3
    //   331: istore 6
    //   333: aload 13
    //   335: ldc 203
    //   337: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: iload 4
    //   343: istore 7
    //   345: iload_3
    //   346: istore 6
    //   348: aload 13
    //   350: iload 4
    //   352: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: iload 4
    //   358: istore 7
    //   360: iload_3
    //   361: istore 6
    //   363: aload 13
    //   365: ldc 208
    //   367: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: iload 4
    //   373: istore 7
    //   375: iload_3
    //   376: istore 6
    //   378: aload 13
    //   380: iload_3
    //   381: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: iload 4
    //   387: istore 7
    //   389: iload_3
    //   390: istore 6
    //   392: aload 12
    //   394: aload 13
    //   396: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 143	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: iload 4
    //   404: istore 7
    //   406: iload_3
    //   407: istore 6
    //   409: aload_2
    //   410: ldc 210
    //   412: invokevirtual 188	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   415: ifeq +77 -> 492
    //   418: iload 4
    //   420: istore 7
    //   422: iload_3
    //   423: istore 6
    //   425: aload_2
    //   426: ldc 210
    //   428: invokevirtual 201	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   431: istore 5
    //   433: iload 5
    //   435: istore 6
    //   437: iload 10
    //   439: istore 11
    //   441: iload 4
    //   443: istore 7
    //   445: iload_3
    //   446: istore 8
    //   448: iload 5
    //   450: iconst_m1
    //   451: if_icmpeq +105 -> 556
    //   454: aload_0
    //   455: getfield 48	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:simiThreshold	I
    //   458: istore 9
    //   460: iload 5
    //   462: istore 6
    //   464: iload 10
    //   466: istore 11
    //   468: iload 4
    //   470: istore 7
    //   472: iload_3
    //   473: istore 8
    //   475: iload 5
    //   477: iload 9
    //   479: if_icmple +77 -> 556
    //   482: ldc 212
    //   484: astore_2
    //   485: goto +89 -> 574
    //   488: astore_2
    //   489: goto +42 -> 531
    //   492: ldc 214
    //   494: astore_2
    //   495: iconst_m1
    //   496: istore 5
    //   498: goto +76 -> 574
    //   501: astore_2
    //   502: iconst_m1
    //   503: istore 5
    //   505: iload 7
    //   507: istore 4
    //   509: iload 6
    //   511: istore_3
    //   512: goto +19 -> 531
    //   515: astore_2
    //   516: goto +7 -> 523
    //   519: astore_2
    //   520: iconst_0
    //   521: istore 10
    //   523: iconst_m1
    //   524: istore 4
    //   526: iconst_m1
    //   527: istore 5
    //   529: iconst_m1
    //   530: istore_3
    //   531: getstatic 75	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   534: aload_2
    //   535: invokevirtual 217	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   538: invokestatic 197	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: iload_3
    //   542: istore 8
    //   544: iload 4
    //   546: istore 7
    //   548: iload 10
    //   550: istore 11
    //   552: iload 5
    //   554: istore 6
    //   556: ldc 214
    //   558: astore_2
    //   559: iload 8
    //   561: istore_3
    //   562: iload 7
    //   564: istore 4
    //   566: iload 11
    //   568: istore 10
    //   570: iload 6
    //   572: istore 5
    //   574: new 50	java/util/HashMap
    //   577: dup
    //   578: invokespecial 51	java/util/HashMap:<init>	()V
    //   581: astore 12
    //   583: getstatic 75	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   586: astore 13
    //   588: new 112	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   595: astore 14
    //   597: aload 14
    //   599: ldc 203
    //   601: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 14
    //   607: iload 4
    //   609: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 14
    //   615: ldc 208
    //   617: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload 14
    //   623: iload_3
    //   624: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 13
    //   630: aload 14
    //   632: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 143	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: iload 4
    //   640: ifne +126 -> 766
    //   643: iload 10
    //   645: ifeq +14 -> 659
    //   648: iload_3
    //   649: aload_0
    //   650: getfield 219	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:finalConfidenceThreshold	I
    //   653: if_icmplt +113 -> 766
    //   656: goto +3 -> 659
    //   659: aload 12
    //   661: ldc 221
    //   663: ldc 223
    //   665: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   668: pop
    //   669: aload 12
    //   671: ldc 229
    //   673: ldc 212
    //   675: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   678: pop
    //   679: aload 12
    //   681: ldc 231
    //   683: ldc 233
    //   685: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   688: pop
    //   689: aload 12
    //   691: ldc 192
    //   693: iconst_0
    //   694: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   697: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   700: pop
    //   701: aload 12
    //   703: ldc 241
    //   705: iconst_0
    //   706: ldc 212
    //   708: aload_1
    //   709: ldc 155
    //   711: invokevirtual 163	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   714: checkcast 110	java/lang/String
    //   717: invokestatic 247	com/tencent/youtu/sdkkitframework/common/CommonUtils:makeMessageJson	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   720: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   723: pop
    //   724: aload 12
    //   726: ldc 249
    //   728: aload_0
    //   729: getfield 251	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:bestImage	Landroid/graphics/YuvImage;
    //   732: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   735: pop
    //   736: iload 5
    //   738: ifle +25 -> 763
    //   741: aload 12
    //   743: ldc 253
    //   745: aload_2
    //   746: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   749: pop
    //   750: aload 12
    //   752: ldc 255
    //   754: iload 5
    //   756: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   759: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   762: pop
    //   763: goto +119 -> 882
    //   766: iload 10
    //   768: ifeq +29 -> 797
    //   771: iload_3
    //   772: aload_0
    //   773: getfield 219	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:finalConfidenceThreshold	I
    //   776: if_icmpge +21 -> 797
    //   779: aload 12
    //   781: ldc_w 257
    //   784: ldc_w 258
    //   787: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   790: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   793: pop
    //   794: goto +17 -> 811
    //   797: aload 12
    //   799: ldc_w 257
    //   802: iload 4
    //   804: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   807: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   810: pop
    //   811: aload 12
    //   813: ldc 221
    //   815: ldc 223
    //   817: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   820: pop
    //   821: aload 12
    //   823: ldc 229
    //   825: ldc 214
    //   827: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   830: pop
    //   831: aload 12
    //   833: ldc 231
    //   835: ldc_w 260
    //   838: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   841: pop
    //   842: aload 12
    //   844: ldc 192
    //   846: ldc_w 261
    //   849: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   852: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   855: pop
    //   856: aload_1
    //   857: ldc 155
    //   859: invokevirtual 163	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   862: checkcast 110	java/lang/String
    //   865: astore_1
    //   866: aload 12
    //   868: ldc 241
    //   870: iload 4
    //   872: ldc 214
    //   874: aload_1
    //   875: invokestatic 247	com/tencent/youtu/sdkkitframework/common/CommonUtils:makeMessageJson	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   878: invokevirtual 227	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   881: pop
    //   882: invokestatic 134	com/tencent/youtu/sdkkitframework/common/YtSDKStats:getInstance	()Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   885: astore_1
    //   886: new 112	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   893: astore_2
    //   894: aload_2
    //   895: ldc_w 263
    //   898: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: aload_2
    //   903: iload 4
    //   905: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   908: pop
    //   909: aload_1
    //   910: aload_2
    //   911: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokevirtual 266	com/tencent/youtu/sdkkitframework/common/YtSDKStats:reportInfo	(Ljava/lang/String;)V
    //   917: invokestatic 168	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   920: aload 12
    //   922: invokevirtual 177	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   925: return
    //   926: iload_3
    //   927: istore 4
    //   929: goto -652 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	932	0	this	NetLivenessReqResultState
    //   0	932	1	paramHashMap	HashMap<String, String>
    //   0	932	2	paramException	Exception
    //   215	712	3	i	int
    //   212	716	4	j	int
    //   431	324	5	k	int
    //   303	268	6	m	int
    //   300	263	7	n	int
    //   446	114	8	i1	int
    //   458	22	9	i2	int
    //   180	587	10	bool1	boolean
    //   439	128	11	bool2	boolean
    //   9	912	12	localObject1	Object
    //   31	598	13	localObject2	Object
    //   36	595	14	localObject3	Object
    //   45	21	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   282	289	292	org/json/JSONException
    //   454	460	488	org/json/JSONException
    //   305	310	501	org/json/JSONException
    //   317	326	501	org/json/JSONException
    //   333	341	501	org/json/JSONException
    //   348	356	501	org/json/JSONException
    //   363	371	501	org/json/JSONException
    //   378	385	501	org/json/JSONException
    //   392	402	501	org/json/JSONException
    //   409	418	501	org/json/JSONException
    //   425	433	501	org/json/JSONException
    //   182	200	515	org/json/JSONException
    //   203	211	515	org/json/JSONException
    //   219	233	515	org/json/JSONException
    //   236	252	515	org/json/JSONException
    //   255	271	515	org/json/JSONException
    //   157	182	519	org/json/JSONException
  }
  
  private String makeActionStr(String[] paramArrayOfString)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      int j = Integer.parseInt(paramArrayOfString[i]);
      if ((j != 0) && (j != 1))
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("silence");
                localObject1 = ((StringBuilder)localObject2).toString();
              }
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("shake");
              localObject1 = ((StringBuilder)localObject2).toString();
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("node");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("mouth");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("blink");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      Object localObject2 = localObject1;
      if (i != paramArrayOfString.length - 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private void onActReflectRequest()
  {
    Object localObject4;
    try
    {
      localObject8 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      localObject7 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      this.bestImage = ((YuvImage)((YtFSMBaseState)localObject7).getStateDataBy("best_frame"));
      this.stateData.put("best_frame", this.bestImage);
      localObject4 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
      localObject6 = (ActionReflectReq)((YtFSMBaseState)localObject4).getStateDataBy("reflect_request_object");
      localObject1 = (byte[])((YtFSMBaseState)localObject7).getStateDataBy("frames");
      if (localObject1 != null) {
        break label981;
      }
      YtLogger.w(TAG, "action data is null");
    }
    catch (Exception localException)
    {
      Object localObject8;
      Object localObject7;
      Object localObject6;
      Object localObject1;
      Object localObject9;
      StringBuilder localStringBuilder;
      localObject4 = TAG;
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("actrefl request failed");
      ((StringBuilder)localObject5).append(localException.getLocalizedMessage());
      YtLogger.e((String)localObject4, ((StringBuilder)localObject5).toString());
      localObject4 = YtSDKStats.getInstance();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("actrefl request failed: ");
      ((StringBuilder)localObject5).append(localException.getLocalizedMessage());
      ((YtSDKStats)localObject4).reportInfo(((StringBuilder)localObject5).toString());
      YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.10(this, localException));
      return;
    }
    localObject1 = Base64.encode((byte[])localObject1, 2);
    label120:
    localObject5 = (String)((YtFSMBaseState)localObject8).getStateDataBy("control_config");
    if (localObject5 != null) {
      this.controlConfig = ((String)localObject5);
    }
    localObject5 = (String)((YtFSMBaseState)localObject8).getStateDataBy("extra_config");
    if (localObject5 != null)
    {
      this.extraConfig = ((String)localObject5);
      localObject5 = TAG;
      localObject9 = new StringBuilder();
      ((StringBuilder)localObject9).append("extraconfig:");
      ((StringBuilder)localObject9).append(this.extraConfig);
      YtLogger.d((String)localObject5, ((StringBuilder)localObject9).toString());
    }
    localObject9 = (String)((YtFSMBaseState)localObject4).getStateDataBy("refcontrol_begin");
    localObject5 = "";
    if (localObject9 != null)
    {
      localStringBuilder = new StringBuilder();
      if (this.extraConfig == null) {
        break label990;
      }
      localObject4 = this.extraConfig;
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject4);
      localStringBuilder.append(" refcontrol_begin ");
      localStringBuilder.append((String)localObject9);
      this.extraConfig = localStringBuilder.toString();
      localObject4 = (String)((YtFSMBaseState)localObject8).getStateDataBy("cp_num");
      if (localObject4 != null)
      {
        this.changePointNum = Integer.parseInt((String)localObject4);
        localObject4 = TAG;
        localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("cpnum:");
        ((StringBuilder)localObject8).append(this.changePointNum);
        YtLogger.d((String)localObject4, ((StringBuilder)localObject8).toString());
      }
      parseControlConfig();
      localObject4 = makeActionStr((String[])((YtFSMBaseState)localObject7).getStateDataBy("action_seq"));
      localObject7 = new YtLivenessNetProtoHelper.ActionReflectLiveReqData();
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).baseInfo.sessionId = UUID.randomUUID().toString();
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).baseInfo.appId = this.appId;
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).baseInfo.businessId = "";
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).colorData = ((ActionReflectReq)localObject6).color_data;
      if (this.needVideoData)
      {
        if (localObject1 == null) {
          localObject1 = localObject5;
        } else {
          localObject1 = new String((byte[])localObject1);
        }
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).actionVideo = ((String)localObject1);
      }
      else
      {
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).actionVideo = "";
      }
      localObject1 = TAG;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("reqData.actionVideo length: ");
      ((StringBuilder)localObject5).append(((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).actionVideo.length());
      YtLogger.d((String)localObject1, ((StringBuilder)localObject5).toString());
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).actionStr = ((String)localObject4);
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).eyeImage = new YtLivenessNetProtoHelper.ImageInfo(((ActionReflectReq)localObject6).eye_image.image, ((ActionReflectReq)localObject6).eye_image.five_points, ((ActionReflectReq)localObject6).eye_image.checksum);
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).mouthImage = new YtLivenessNetProtoHelper.ImageInfo(((ActionReflectReq)localObject6).mouth_image.image, ((ActionReflectReq)localObject6).mouth_image.five_points, ((ActionReflectReq)localObject6).mouth_image.checksum);
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).liveImage = new YtLivenessNetProtoHelper.ImageInfo(((ActionReflectReq)localObject6).live_image.image, ((ActionReflectReq)localObject6).live_image.five_points, ((ActionReflectReq)localObject6).live_image.checksum);
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).reflectData = ((ActionReflectReq)localObject6).reflect_data;
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).baseInfo.lux = ((ActionReflectReq)localObject6).select_data.android_data.lux;
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).reflectConfig = this.extraConfig;
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).controlConfig = this.controlConfig;
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7).colorNum = this.changePointNum;
      localObject4 = YtLivenessNetProtoHelper.makeActionReflectLiveReq((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject7);
      localObject5 = this.jsonOptionObject;
      localObject1 = localObject4;
      Object localObject2;
      if (localObject5 != null) {
        try
        {
          localObject1 = new JSONObject((String)localObject4);
          localObject5 = this.jsonOptionObject.keys();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            ((JSONObject)localObject1).put((String)localObject6, this.jsonOptionObject.get((String)localObject6));
          }
          localObject1 = ((JSONObject)localObject1).toString();
        }
        catch (JSONException localJSONException)
        {
          localObject5 = TAG;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("lipread net request parse json failed ");
          ((StringBuilder)localObject6).append(localJSONException.getLocalizedMessage());
          YtLogger.e((String)localObject5, ((StringBuilder)localObject6).toString());
          localObject2 = localObject4;
        }
      }
      if (this.needEncrypt)
      {
        localObject2 = new EncryptUtil().generateEncReq((String)localObject2, this.appId, this.sessionId, "config");
        YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject2, null, new NetLivenessReqResultState.8(this));
        return;
      }
      YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject2, null, new NetLivenessReqResultState.9(this));
      return;
      label981:
      if (localException != null) {
        break;
      }
      Object localObject3 = null;
      break label120;
      label990:
      localObject4 = "";
    }
  }
  
  private void onActReflectRequest2()
  {
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject1).getStateDataBy("best_frame"));
    this.stateData.put("best_frame", this.bestImage);
    ArrayList localArrayList = (ArrayList)((YtFSMBaseState)localObject1).getStateDataBy("frame_list");
    Object localObject3 = TAG;
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("action request 2 frame size:");
    ((StringBuilder)localObject5).append(localArrayList.size());
    YtLogger.d((String)localObject3, ((StringBuilder)localObject5).toString());
    localObject3 = (ActionReflectReq)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE)).getStateDataBy("reflect_request_object");
    NetLivenessReqResultState.ActionReflectReq2 localActionReflectReq2 = new NetLivenessReqResultState.ActionReflectReq2(this);
    localObject1 = Base64.encode((byte[])((YtFSMBaseState)localObject1).getStateDataBy("frames"), 2);
    localObject5 = new NetLivenessReqResultState.Version(this);
    ((NetLivenessReqResultState.Version)localObject5).sdk_version = YtSDKKitFramework.getInstance().version();
    ((NetLivenessReqResultState.Version)localObject5).ftrack_sdk_version = YTFaceTracker.getVersion();
    ((NetLivenessReqResultState.Version)localObject5).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    ((NetLivenessReqResultState.Version)localObject5).freflect_sdk_version = "3.6.8";
    ((ActionReflectReq)localObject3).action_video = new String((byte[])localObject1);
    new WeJson();
    ((ActionReflectReq)localObject3).client_version = String.format("sdk_version:%s;ftrack_sdk_version:%s;freflect_sdk_version:%s;faction_sdk_version:%s", new Object[] { ((NetLivenessReqResultState.Version)localObject5).sdk_version, ((NetLivenessReqResultState.Version)localObject5).ftrack_sdk_version, ((NetLivenessReqResultState.Version)localObject5).freflect_sdk_version, ((NetLivenessReqResultState.Version)localObject5).faction_sdk_version });
    ((ActionReflectReq)localObject3).session_id = "12345";
    localActionReflectReq2.live_req = ((ActionReflectReq)localObject3);
    localActionReflectReq2.session_id = UUID.randomUUID().toString();
    localObject5 = null;
    localObject1 = null;
    localObject3 = localObject5;
    try
    {
      localObject6 = new StringBuilder();
      localObject3 = localObject5;
      ((StringBuilder)localObject6).append(Environment.getExternalStorageDirectory().getPath());
      localObject3 = localObject5;
      ((StringBuilder)localObject6).append("/test.mp4");
      localObject3 = localObject5;
      localObject6 = new FileInputStream(new File(((StringBuilder)localObject6).toString()));
      localObject3 = localObject5;
      String str = TAG;
      localObject3 = localObject5;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = localObject5;
      localStringBuilder.append("encode video size:");
      localObject3 = localObject5;
      localStringBuilder.append(((FileInputStream)localObject6).available());
      localObject3 = localObject5;
      YtLogger.d(str, localStringBuilder.toString());
      localObject3 = localObject5;
      if (((FileInputStream)localObject6).available() != 0)
      {
        localObject3 = localObject5;
        localObject1 = new byte[((FileInputStream)localObject6).available()];
      }
      localObject3 = localObject1;
      ((FileInputStream)localObject6).read((byte[])localObject1);
      localObject3 = localObject1;
      ((FileInputStream)localObject6).close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject6;
        int i;
        Object localObject4;
        Object localObject2 = localObject4;
      }
    }
    if (localObject1 == null) {
      localActionReflectReq2.video = "";
    } else {
      localActionReflectReq2.video = new String(Base64.encode((byte[])localObject1, 2));
    }
    localObject1 = TAG;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("encode video size:");
    ((StringBuilder)localObject3).append(localActionReflectReq2.video.length());
    YtLogger.d((String)localObject1, ((StringBuilder)localObject3).toString());
    localActionReflectReq2.images = new ArrayList();
    localActionReflectReq2.five_points = new ArrayList();
    i = 0;
    while (i < localArrayList.size())
    {
      int k = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getWidth();
      int j = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getHeight();
      localObject1 = TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Eye score ");
      ((StringBuilder)localObject3).append(((ActionLivenessState.BestFrame)localArrayList.get(i)).eyeScore);
      YtLogger.d((String)localObject1, ((StringBuilder)localObject3).toString());
      int m;
      if (YtFSM.getInstance().getContext().currentRotateState >= 5)
      {
        m = k;
      }
      else
      {
        m = j;
        j = k;
      }
      localObject1 = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getYuvData();
      localObject3 = TAG;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("Rotated size:");
      ((StringBuilder)localObject5).append(localObject1.length);
      YtLogger.d((String)localObject3, ((StringBuilder)localObject5).toString());
      localObject1 = new YuvImage((byte[])localObject1, 17, j, m, null);
      localObject3 = new ByteArrayOutputStream();
      ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject3);
      localObject5 = ((ByteArrayOutputStream)localObject3).toByteArray();
      localObject1 = Base64.encode((byte[])localObject5, 2);
      try
      {
        localObject3 = BitmapFactory.decodeByteArray((byte[])localObject5, 0, ((ByteArrayOutputStream)localObject3).size());
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject5).append("/bestbmp");
        ((StringBuilder)localObject5).append(i);
        ((StringBuilder)localObject5).append(".jpg");
        localObject5 = new FileOutputStream(new File(((StringBuilder)localObject5).toString()));
        ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject5);
        ((OutputStream)localObject5).flush();
        ((OutputStream)localObject5).close();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localActionReflectReq2.images.add(new String((byte[])localObject1));
      localObject1 = new NetLivenessReqResultState.FivePoints(this);
      ((NetLivenessReqResultState.FivePoints)localObject1).points = new ArrayList();
      localObject4 = TAG;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("f5p size:");
      ((StringBuilder)localObject5).append(((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2);
      YtLogger.d((String)localObject4, ((StringBuilder)localObject5).toString());
      j = 0;
      while (j < ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2)
      {
        localObject4 = new NetLivenessReqResultState.Pointf(this);
        localObject5 = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p;
        k = j * 2;
        ((NetLivenessReqResultState.Pointf)localObject4).x = localObject5[k];
        ((NetLivenessReqResultState.Pointf)localObject4).y = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p[(k + 1)];
        ((NetLivenessReqResultState.FivePoints)localObject1).points.add(localObject4);
        localObject5 = TAG;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("f5p[");
        ((StringBuilder)localObject6).append(j);
        ((StringBuilder)localObject6).append("] ");
        ((StringBuilder)localObject6).append(((NetLivenessReqResultState.Pointf)localObject4).x);
        ((StringBuilder)localObject6).append(",");
        ((StringBuilder)localObject6).append(((NetLivenessReqResultState.Pointf)localObject4).y);
        YtLogger.d((String)localObject5, ((StringBuilder)localObject6).toString());
        j += 1;
      }
      localActionReflectReq2.five_points.add(localObject1);
      i += 1;
    }
    localObject1 = TAG;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("f5p count");
    ((StringBuilder)localObject4).append(localActionReflectReq2.five_points.size());
    YtLogger.d((String)localObject1, ((StringBuilder)localObject4).toString());
    localObject1 = new WeJson().toJson(localActionReflectReq2);
    localObject4 = TAG;
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("upload string size:");
    ((StringBuilder)localObject5).append(((String)localObject1).length());
    YtLogger.d((String)localObject4, ((StringBuilder)localObject5).toString());
    YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.11(this));
  }
  
  private void onActionRequest()
  {
    Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    if (localObject3 == null)
    {
      YtSDKStats.getInstance().reportInfo("action request action state is null");
      YtLogger.e(TAG, "action request action state is null");
      return;
    }
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("best_frame"));
    Object localObject1 = new ByteArrayOutputStream();
    Object localObject2 = this.bestImage;
    ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject2).getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
    localObject2 = Base64.encode((byte[])((YtFSMBaseState)localObject3).getStateDataBy("frames"), 2);
    localObject3 = makeActionStr((String[])((YtFSMBaseState)localObject3).getStateDataBy("action_seq"));
    parseControlConfig();
    YtLivenessNetProtoHelper.ActionLiveReqData localActionLiveReqData = new YtLivenessNetProtoHelper.ActionLiveReqData();
    localActionLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    localActionLiveReqData.baseInfo.appId = this.appId;
    localActionLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
    localActionLiveReqData.bestImage = new String(Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2));
    localActionLiveReqData.actionStr = ((String)localObject3);
    if (this.needVideoData) {
      localActionLiveReqData.actionVideo = new String((byte[])localObject2);
    } else {
      localActionLiveReqData.actionVideo = "";
    }
    localActionLiveReqData.needEyeDetect = true;
    localActionLiveReqData.needMouthDetect = true;
    localActionLiveReqData.reflectConfig = this.extraConfig;
    localActionLiveReqData.controlConfig = this.controlConfig;
    localActionLiveReqData.colorNum = this.changePointNum;
    localObject1 = YtLivenessNetProtoHelper.makeActionLiveReq(localActionLiveReqData);
    YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.6(this));
  }
  
  private void onCheckResponseManual()
  {
    if (this.needManualTrigger) {
      try
      {
        YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_manual_trigger", null);
        YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("on Check response manual failed ");
        localStringBuilder.append(localException.getLocalizedMessage());
        String str = localStringBuilder.toString();
        YtLogger.e(TAG, str);
        YtSDKStats.getInstance().reportInfo(str);
      }
    }
  }
  
  private void onLipReadRequest()
  {
    label1199:
    label1206:
    label1213:
    label1220:
    label1227:
    label1232:
    for (;;)
    {
      try
      {
        Object localObject5 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
        if (localObject2 == null)
        {
          YtSDKStats.getInstance().reportInfo("lipread request action state is null");
          YtLogger.e(TAG, "lipread request action state is null");
          return;
        }
        this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("last_frame"));
        Object localObject1 = new ByteArrayOutputStream();
        this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
        Object localObject6 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
        Arrays.toString((String[])((YtFSMBaseState)localObject2).getStateDataBy("action_seq"));
        i = this.backendProtoType;
        int j;
        if (i == 2)
        {
          localObject4 = new YtLivenessNetProtoHelper.LipReadReqData();
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo.appId = this.appId;
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo.sessionId = UUID.randomUUID().toString();
          Object localObject7 = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("business_id")) {
            break label1199;
          }
          localObject1 = (String)this.requestOptions.get("business_id");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).businessId = ((String)localObject1);
          localObject7 = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("person_id")) {
            break label1206;
          }
          localObject1 = (String)this.requestOptions.get("person_id");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).personId = ((String)localObject1);
          localObject7 = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("person_type")) {
            break label1213;
          }
          localObject1 = (String)this.requestOptions.get("person_type");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).personType = ((String)localObject1);
          localObject7 = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("req_type")) {
            break label1220;
          }
          localObject1 = (String)this.requestOptions.get("req_type");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).reqType = ((String)localObject1);
          localObject1 = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("live_type")) {
            break label1227;
          }
          i = Integer.parseInt((String)this.requestOptions.get("live_type"));
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject1).liveType = i;
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).liveImage = new String((byte[])localObject6);
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).liveFivePoint = ((float[])((YtFSMBaseState)localObject2).getStateDataBy("last_frame_landmark"));
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).faceExtraInfo = ((String)((YtFSMBaseState)localObject2).getStateDataBy("face_extra_list"));
          localObject6 = (String[])((YtFSMBaseState)localObject2).getStateDataBy("action_seq");
          j = localObject6.length;
          localObject1 = "";
          i = 0;
          if (i < j)
          {
            localObject7 = localObject6[i];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)localObject7);
            localObject1 = localStringBuilder.toString();
            i += 1;
            continue;
          }
          localObject6 = TAG;
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("action_seq: ");
          ((StringBuilder)localObject7).append((String)localObject1);
          YtLogger.d((String)localObject6, ((StringBuilder)localObject7).toString());
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).validate_data = ((String)localObject1);
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).voice = new String(Base64.encode((byte[])((YtFSMBaseState)localObject2).getStateDataBy("audio_data"), 2));
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).mouth_lip_reading = ((String)((YtFSMBaseState)localObject2).getStateDataBy("lipreading_feature"));
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).mouth_move = ((String)((YtFSMBaseState)localObject2).getStateDataBy("feature"));
          localObject1 = (YuvImage)((YtFSMBaseState)localObject5).getStateDataBy("best_image");
          localObject2 = (float[])((YtFSMBaseState)localObject5).getStateDataBy("best_shape");
          localObject5 = new ByteArrayOutputStream();
          ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject5);
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).bestImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject5).toByteArray(), (float[])localObject2, null);
          localObject1 = YtLivenessNetProtoHelper.makeLipReadReq((YtLivenessNetProtoHelper.LipReadReqData)localObject4);
        }
        else
        {
          i = 0;
          localObject4 = (String[])((YtFSMBaseState)localObject2).getStateDataBy("action_seq");
          j = localObject4.length;
          localObject1 = "";
          if (i < j)
          {
            localObject5 = localObject4[i];
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append((String)localObject1);
            ((StringBuilder)localObject6).append((String)localObject5);
            localObject1 = ((StringBuilder)localObject6).toString();
            i += 1;
            continue;
          }
          localObject4 = TAG;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("action_seq: ");
          ((StringBuilder)localObject5).append((String)localObject1);
          YtLogger.d((String)localObject4, ((StringBuilder)localObject5).toString());
          localObject4 = new YtLivenessNetProtoHelper.FourLiveReqData();
          ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).baseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
          ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).baseInfoData.appId = this.appId;
          ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).validateData = ((String)localObject1);
          ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).video = new String(Base64.encode((byte[])((YtFSMBaseState)localObject2).getStateDataBy("audio_data"), 2));
          localObject1 = YtLivenessNetProtoHelper.makeFourLiveReq((YtLivenessNetProtoHelper.FourLiveReqData)localObject4);
          i = this.requestOptions.size();
          if (i <= 0) {
            break label1232;
          }
        }
        try
        {
          localObject2 = new JSONObject((String)localObject1);
          localObject4 = this.requestOptions.entrySet().iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject4).next();
            ((JSONObject)localObject2).put((String)((Map.Entry)localObject5).getKey(), ((Map.Entry)localObject5).getValue());
            continue;
          }
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          localObject4 = TAG;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("lipread net request parse json failed ");
          ((StringBuilder)localObject5).append(localJSONException.getLocalizedMessage());
          YtLogger.e((String)localObject4, ((StringBuilder)localObject5).toString());
          break label1232;
        }
        YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.4(this));
        return;
      }
      catch (Exception localException)
      {
        Object localObject3 = TAG;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("lipread request failed");
        ((StringBuilder)localObject4).append(localException.getLocalizedMessage());
        YtLogger.e((String)localObject3, ((StringBuilder)localObject4).toString());
        localObject3 = YtSDKStats.getInstance();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("lipreading request failed: ");
        ((StringBuilder)localObject4).append(localException.getLocalizedMessage());
        ((YtSDKStats)localObject3).reportInfo(((StringBuilder)localObject4).toString());
        YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.5(this, localException));
        return;
      }
      String str = "wx_default";
      continue;
      str = "wx_default0";
      continue;
      str = "youtu";
      continue;
      str = "live";
      continue;
      int i = 0;
    }
  }
  
  private void onReflectRequest()
  {
    CommonUtils.benchMarkBegin("reflect_request_s1");
    Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_image"));
    Object localObject1 = new ByteArrayOutputStream();
    Object localObject3 = this.bestImage;
    ((YuvImage)localObject3).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject3).getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
    try
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("DumpImage");
      ((StringBuilder)localObject3).append(File.separator);
      localObject3 = new File(((StringBuilder)localObject3).toString());
      int j = 1;
      i = j;
      if (!((File)localObject3).exists())
      {
        i = j;
        if (!((File)localObject3).mkdirs()) {
          i = 0;
        }
      }
      if (i != 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(((File)localObject3).getPath());
        localStringBuilder1.append(File.separator);
        localStringBuilder1.append("best.jpg");
        localObject3 = new File(localStringBuilder1.toString());
        boolean bool = ((File)localObject3).exists();
        if (!bool) {
          try
          {
            ((File)localObject3).createNewFile();
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        localObject3 = new FileOutputStream((File)localObject3);
        ((FileOutputStream)localObject3).write(((ByteArrayOutputStream)localObject1).toByteArray());
        ((FileOutputStream)localObject3).close();
        ((FileOutputStream)localObject3).flush();
      }
    }
    catch (Exception localException1)
    {
      int i;
      label277:
      Object localObject5;
      Object localObject4;
      Object localObject6;
      StringBuilder localStringBuilder2;
      break label277;
    }
    localObject3 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
    this.stateData.put("best_frame", this.bestImage);
    localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
    localObject5 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
    localObject4 = (ReflectLiveReq)((YtFSMBaseState)localObject1).getStateDataBy("reflect_request_object");
    localObject6 = (String)((YtFSMBaseState)localObject5).getStateDataBy("extra_config");
    if (localObject6 != null) {
      this.extraConfig = ((String)localObject6);
    }
    localObject6 = (String)((YtFSMBaseState)localObject1).getStateDataBy("refcontrol_begin");
    if (localObject6 != null)
    {
      localStringBuilder2 = new StringBuilder();
      localObject1 = this.extraConfig;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localStringBuilder2.append((String)localObject1);
      localStringBuilder2.append(" refcontrol_begin ");
      localStringBuilder2.append((String)localObject6);
      this.extraConfig = localStringBuilder2.toString();
    }
    localObject1 = (String)((YtFSMBaseState)localObject5).getStateDataBy("cp_num");
    if (localObject1 != null) {
      this.changePointNum = Integer.parseInt((String)localObject1);
    }
    ((ReflectLiveReq)localObject4).session_id = UUID.randomUUID().toString();
    localObject5 = new YtLivenessNetProtoHelper.ReflectLiveReqData();
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo.appId = this.appId;
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo.sessionId = UUID.randomUUID().toString();
    localObject6 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
    if (this.requestOptions.containsKey("business_id")) {
      localObject1 = (String)this.requestOptions.get("business_id");
    } else {
      localObject1 = null;
    }
    ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject6).businessId = ((String)localObject1);
    localObject6 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
    if (this.requestOptions.containsKey("person_id")) {
      localObject1 = (String)this.requestOptions.get("person_id");
    } else {
      localObject1 = null;
    }
    ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject6).personId = ((String)localObject1);
    localObject6 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
    if (this.requestOptions.containsKey("person_type")) {
      localObject1 = (String)this.requestOptions.get("person_type");
    } else {
      localObject1 = null;
    }
    ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject6).personType = ((String)localObject1);
    localObject6 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
    if (this.requestOptions.containsKey("req_type")) {
      localObject1 = (String)this.requestOptions.get("req_type");
    } else {
      localObject1 = null;
    }
    ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject6).reqType = ((String)localObject1);
    localObject1 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
    if (this.requestOptions.containsKey("live_type")) {
      i = Integer.parseInt((String)this.requestOptions.get("live_type"));
    } else {
      i = 0;
    }
    ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject1).liveType = i;
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).colorData = ((ReflectLiveReq)localObject4).color_data;
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).liveImage = new String((byte[])localObject3);
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).reflectData = ((ReflectLiveReq)localObject4).reflect_data;
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).config = this.extraConfig;
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).colorNum = this.changePointNum;
    if (this.backendProtoType == 2)
    {
      localObject1 = (YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_image");
      localObject3 = (float[])((YtFSMBaseState)localObject2).getStateDataBy("best_shape");
      localObject4 = new ByteArrayOutputStream();
      ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject4);
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).bestImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject4).toByteArray(), (float[])localObject3, null);
      localObject1 = (YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("openmouth_image");
      localObject3 = (float[])((YtFSMBaseState)localObject2).getStateDataBy("openmouth_shape");
      localObject4 = new ByteArrayOutputStream();
      ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject4);
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).openMouthImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject4).toByteArray(), (float[])localObject3, null);
      localObject1 = (YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("closeeye_image");
      localObject2 = (float[])((YtFSMBaseState)localObject2).getStateDataBy("closeeye_shape");
      localObject3 = new ByteArrayOutputStream();
      ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject3);
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).closeEyeImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject3).toByteArray(), (float[])localObject2, null);
      localObject1 = YtLivenessNetProtoHelper.makePersonLiveReq((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5);
    }
    else
    {
      localObject1 = YtLivenessNetProtoHelper.makeReflectLiveReq((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5);
    }
    localObject2 = TAG;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("begin request...uploadsize ");
    ((StringBuilder)localObject3).append(((String)localObject1).length());
    YtLogger.d((String)localObject2, ((StringBuilder)localObject3).toString());
    CommonUtils.benchMarkEnd("reflect_request_s1");
    CommonUtils.benchMarkBegin("reflect_request_s2");
    YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.7(this));
  }
  
  private void onSilentRequest()
  {
    this.bestImage = ((YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).getStateDataBy("best_image"));
    int i = this.bestImage.getWidth();
    int j = this.bestImage.getHeight();
    Object localObject = new ByteArrayOutputStream();
    this.bestImage.compressToJpeg(new Rect(0, 0, i, j), 95, (OutputStream)localObject);
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    YtLivenessNetProtoHelper.PictureLiveReqData localPictureLiveReqData = new YtLivenessNetProtoHelper.PictureLiveReqData();
    localPictureLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    localPictureLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
    localPictureLiveReqData.baseInfo.appId = this.appId;
    localPictureLiveReqData.imageInfo = new YtLivenessNetProtoHelper.ImageInfo((byte[])localObject, null, null);
    localObject = YtLivenessNetProtoHelper.makePictureLiveReq(localPictureLiveReqData);
    YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject, null, new NetLivenessReqResultState.2(this));
  }
  
  private void parseControlConfig()
  {
    if (!this.controlConfig.isEmpty())
    {
      String[] arrayOfString1 = this.controlConfig.split("&");
      if (arrayOfString1.length > 0)
      {
        int j = arrayOfString1.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length > 1)
          {
            if ((arrayOfString2[0].equals("need_action_video")) && (arrayOfString2[1].equals("false"))) {
              this.needVideoData = false;
            }
            if (arrayOfString2[0].equals("actref_ux_mode")) {
              this.actRefUXMode = Integer.parseInt(arrayOfString2[1]);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.1(this));
    int i = NetLivenessReqResultState.12.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5) {
            return;
          }
          onLipReadRequest();
          return;
        }
        if (this.actReflectType == 0)
        {
          onActReflectRequest();
          return;
        }
        onActReflectRequest2();
        return;
      }
      onReflectRequest();
      return;
    }
    onActionRequest();
  }
  
  public void enterFirst() {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      this.appId = paramJSONObject.getString("app_id");
      this.resultUrl = paramJSONObject.getString("result_api_url");
      if (this.resultUrl == null)
      {
        YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        YtLogger.e(TAG, "parse url failed");
        return;
      }
      if (paramJSONObject.has("secret_key")) {
        this.secretKey = paramJSONObject.getString("secret_key");
      }
      if (paramJSONObject.has("secret_id")) {
        this.secretId = paramJSONObject.getString("secret_id");
      }
      if (paramJSONObject.has("user_id")) {
        this.userId = paramJSONObject.getString("user_id");
      }
      if (paramJSONObject.has("similarity_threshold")) {
        this.simiThreshold = paramJSONObject.getInt("similarity_threshold");
      }
      if (paramJSONObject.has("final_liveness_confidence_threshold")) {
        this.finalConfidenceThreshold = paramJSONObject.getInt("final_liveness_confidence_threshold");
      } else {
        this.finalConfidenceThreshold = 85;
      }
      if (paramJSONObject.has("extra_config")) {
        this.extraConfig = paramJSONObject.getString("extra_config");
      } else {
        this.extraConfig = " version 2";
      }
      if (paramJSONObject.has("control_config")) {
        this.controlConfig = paramJSONObject.getString("control_config");
      }
      if (paramJSONObject.has("change_point_num")) {
        this.changePointNum = paramJSONObject.getInt("change_point_num");
      }
      if (paramJSONObject.has("manual_trigger")) {
        this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
      }
      if (paramJSONObject.has("request_options"))
      {
        this.jsonOptionObject = paramJSONObject.getJSONObject("request_options");
        paramString = this.jsonOptionObject.keys();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          String str = this.jsonOptionObject.getString((String)localObject);
          this.requestOptions.put(localObject, str);
        }
      }
      if (paramJSONObject.has("backend_proto_type")) {
        this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
      }
      if (paramJSONObject.has("need_encrypt")) {
        this.needEncrypt = paramJSONObject.getBoolean("need_encrypt");
      }
      if (paramJSONObject.has("session_id"))
      {
        this.sessionId = paramJSONObject.getString("session_id");
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramJSONObject = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to parse json:");
      ((StringBuilder)localObject).append(paramString.getLocalizedMessage());
      YtLogger.e(paramJSONObject, ((StringBuilder)localObject).toString());
    }
  }
  
  public void unload()
  {
    super.unload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState
 * JD-Core Version:    0.7.0.1
 */