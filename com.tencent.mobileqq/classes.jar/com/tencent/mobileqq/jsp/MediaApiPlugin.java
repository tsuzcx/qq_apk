package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaApiPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback, QQProgressDialog.Callback
{
  public static final String a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public QQProgressDialog a;
  Thread jdField_a_of_type_JavaLangThread;
  
  static
  {
    jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  }
  
  public MediaApiPlugin()
  {
    this.mPluginNameSpace = "media";
  }
  
  public static String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt, 1035);
    CompressOperator.a(paramString);
    return paramString.e;
  }
  
  public static JSONObject a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new File(paramString);
    if (((File)localObject1).length() < 3L) {
      throw new IOException();
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
    int i = ((BitmapFactory.Options)localObject2).outWidth;
    int j = ((BitmapFactory.Options)localObject2).outHeight;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 realWidth: " + i + ", realHeight: " + j + ", realSize: " + ((File)localObject1).length());
    }
    if ((i < 0) || (j < 0)) {
      throw new IOException();
    }
    Object localObject3 = a(paramString, paramInt);
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject2 = BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    if (QLog.isColorLevel())
    {
      localObject3 = new File((String)localObject3);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 curWidth: " + ((BitmapFactory.Options)localObject1).outWidth + ", curHeight: " + ((BitmapFactory.Options)localObject1).outHeight + ", realSize: " + ((File)localObject3).length());
    }
    localObject3 = new ByteArrayOutputStream(1024);
    localObject1 = ((BitmapFactory.Options)localObject1).outMimeType;
    if (("image/png".equalsIgnoreCase((String)localObject1)) || ("image/gif".equals(localObject1)) || ("image/bmp".equals(localObject1)))
    {
      localObject1 = new StringBuilder("data:image/png;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
    }
    for (;;)
    {
      ((Bitmap)localObject2).recycle();
      ((StringBuilder)localObject1).append(Base64Util.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
      localJSONObject.put("match", 0);
      localJSONObject.put("data", localObject1);
      localJSONObject.put("imageID", paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 time: " + (System.currentTimeMillis() - l));
      }
      return localJSONObject;
      localObject1 = new StringBuilder("data:image/jpeg;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject3);
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 57	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 58	org/json/JSONObject:<init>	()V
    //   7: astore 10
    //   9: new 60	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 9
    //   19: aload 9
    //   21: invokevirtual 66	java/io/File:length	()J
    //   24: ldc2_w 67
    //   27: lcmp
    //   28: ifge +11 -> 39
    //   31: new 70	java/io/IOException
    //   34: dup
    //   35: invokespecial 71	java/io/IOException:<init>	()V
    //   38: athrow
    //   39: new 73	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 74	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 8
    //   48: aload 8
    //   50: iconst_1
    //   51: putfield 78	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 84	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload 8
    //   63: getfield 88	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: istore 6
    //   68: aload 8
    //   70: getfield 91	android/graphics/BitmapFactory$Options:outHeight	I
    //   73: istore 7
    //   75: iload 6
    //   77: iflt +8 -> 85
    //   80: iload 7
    //   82: ifge +11 -> 93
    //   85: new 70	java/io/IOException
    //   88: dup
    //   89: invokespecial 71	java/io/IOException:<init>	()V
    //   92: athrow
    //   93: iload 6
    //   95: iload_1
    //   96: if_icmplt +9 -> 105
    //   99: iload 7
    //   101: iload_2
    //   102: if_icmpge +15 -> 117
    //   105: aload 10
    //   107: ldc 183
    //   109: iconst_1
    //   110: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 10
    //   116: areturn
    //   117: iload 6
    //   119: iload_3
    //   120: if_icmpgt +332 -> 452
    //   123: iload 7
    //   125: iload 4
    //   127: if_icmpgt +325 -> 452
    //   130: new 203	java/io/FileInputStream
    //   133: dup
    //   134: aload 9
    //   136: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 9
    //   141: aload 9
    //   143: invokevirtual 212	java/io/InputStream:read	()I
    //   146: istore_1
    //   147: aload 9
    //   149: invokevirtual 212	java/io/InputStream:read	()I
    //   152: istore_2
    //   153: aload 9
    //   155: invokevirtual 212	java/io/InputStream:read	()I
    //   158: istore_3
    //   159: iload_1
    //   160: sipush 255
    //   163: if_icmpne +103 -> 266
    //   166: iload_2
    //   167: sipush 216
    //   170: if_icmpne +96 -> 266
    //   173: new 99	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 197
    //   179: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: astore 8
    //   184: aload 8
    //   186: iconst_3
    //   187: newarray byte
    //   189: dup
    //   190: iconst_0
    //   191: iload_1
    //   192: i2b
    //   193: bastore
    //   194: dup
    //   195: iconst_1
    //   196: iload_2
    //   197: i2b
    //   198: bastore
    //   199: dup
    //   200: iconst_2
    //   201: iload_3
    //   202: i2b
    //   203: bastore
    //   204: iconst_2
    //   205: invokestatic 181	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   208: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: sipush 30720
    //   215: newarray byte
    //   217: astore 11
    //   219: aload 9
    //   221: aload 11
    //   223: invokevirtual 215	java/io/InputStream:read	([B)I
    //   226: istore_1
    //   227: iload_1
    //   228: iconst_m1
    //   229: if_icmpeq +182 -> 411
    //   232: invokestatic 221	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   235: invokevirtual 224	java/lang/Thread:isInterrupted	()Z
    //   238: ifeq +121 -> 359
    //   241: new 226	java/lang/InterruptedException
    //   244: dup
    //   245: invokespecial 227	java/lang/InterruptedException:<init>	()V
    //   248: athrow
    //   249: astore_0
    //   250: aload 9
    //   252: astore 8
    //   254: aload 8
    //   256: ifnull +8 -> 264
    //   259: aload 8
    //   261: invokevirtual 230	java/io/InputStream:close	()V
    //   264: aload_0
    //   265: athrow
    //   266: iload_1
    //   267: bipush 66
    //   269: if_icmpne +23 -> 292
    //   272: iload_2
    //   273: bipush 77
    //   275: if_icmpne +17 -> 292
    //   278: new 99	java/lang/StringBuilder
    //   281: dup
    //   282: ldc 232
    //   284: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: astore 8
    //   289: goto -105 -> 184
    //   292: iload_1
    //   293: sipush 137
    //   296: if_icmpne +23 -> 319
    //   299: iload_2
    //   300: bipush 80
    //   302: if_icmpne +17 -> 319
    //   305: new 99	java/lang/StringBuilder
    //   308: dup
    //   309: ldc 155
    //   311: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: astore 8
    //   316: goto -132 -> 184
    //   319: iload_1
    //   320: bipush 71
    //   322: if_icmpne +23 -> 345
    //   325: iload_2
    //   326: bipush 73
    //   328: if_icmpne +17 -> 345
    //   331: new 99	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 234
    //   337: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: astore 8
    //   342: goto -158 -> 184
    //   345: new 99	java/lang/StringBuilder
    //   348: dup
    //   349: ldc 236
    //   351: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: astore 8
    //   356: goto -172 -> 184
    //   359: iload_1
    //   360: sipush 30720
    //   363: if_icmpge +33 -> 396
    //   366: iload_1
    //   367: newarray byte
    //   369: astore 12
    //   371: aload 11
    //   373: iconst_0
    //   374: aload 12
    //   376: iconst_0
    //   377: iload_1
    //   378: invokestatic 240	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   381: aload 8
    //   383: aload 12
    //   385: iconst_2
    //   386: invokestatic 181	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   389: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: goto -174 -> 219
    //   396: aload 8
    //   398: aload 11
    //   400: iconst_2
    //   401: invokestatic 181	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   404: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: goto -189 -> 219
    //   411: aload 10
    //   413: ldc 183
    //   415: iconst_0
    //   416: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 10
    //   422: ldc 188
    //   424: aload 8
    //   426: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 10
    //   432: ldc 193
    //   434: aload_0
    //   435: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   438: pop
    //   439: aload 9
    //   441: ifnull -327 -> 114
    //   444: aload 9
    //   446: invokevirtual 230	java/io/InputStream:close	()V
    //   449: aload 10
    //   451: areturn
    //   452: iload 6
    //   454: iload_3
    //   455: idiv
    //   456: iload 7
    //   458: iload 4
    //   460: idiv
    //   461: invokestatic 246	java/lang/Math:max	(II)I
    //   464: istore_1
    //   465: aload 8
    //   467: iconst_0
    //   468: putfield 78	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   471: iload_1
    //   472: iload_1
    //   473: iconst_1
    //   474: iushr
    //   475: ior
    //   476: istore_1
    //   477: iload_1
    //   478: iload_1
    //   479: iconst_2
    //   480: iushr
    //   481: ior
    //   482: istore_1
    //   483: iload_1
    //   484: iload_1
    //   485: iconst_4
    //   486: iushr
    //   487: ior
    //   488: istore_1
    //   489: iload_1
    //   490: iload_1
    //   491: bipush 8
    //   493: iushr
    //   494: ior
    //   495: istore_1
    //   496: aload 8
    //   498: iload_1
    //   499: iload_1
    //   500: bipush 16
    //   502: iushr
    //   503: ior
    //   504: iconst_1
    //   505: iadd
    //   506: iconst_1
    //   507: iushr
    //   508: putfield 249	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   511: aload_0
    //   512: aload 8
    //   514: invokestatic 84	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   517: astore 11
    //   519: iload 6
    //   521: iload 4
    //   523: imul
    //   524: iload 7
    //   526: iload_3
    //   527: imul
    //   528: if_icmple +235 -> 763
    //   531: iload_3
    //   532: i2f
    //   533: aload 11
    //   535: invokevirtual 252	android/graphics/Bitmap:getWidth	()I
    //   538: i2f
    //   539: fdiv
    //   540: fstore 5
    //   542: new 254	android/graphics/Matrix
    //   545: dup
    //   546: invokespecial 255	android/graphics/Matrix:<init>	()V
    //   549: astore 9
    //   551: aload_0
    //   552: invokestatic 261	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   555: tableswitch	default:+41 -> 596, 2:+223->778, 3:+236->791, 4:+257->812, 5:+270->825, 6:+292->847, 7:+313->868, 8:+335->890
    //   597: lconst_0
    //   598: fload 5
    //   600: fload 5
    //   602: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   605: aload 11
    //   607: iconst_0
    //   608: iconst_0
    //   609: aload 11
    //   611: invokevirtual 252	android/graphics/Bitmap:getWidth	()I
    //   614: aload 11
    //   616: invokevirtual 268	android/graphics/Bitmap:getHeight	()I
    //   619: aload 9
    //   621: iconst_1
    //   622: invokestatic 272	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   625: astore 9
    //   627: aload 11
    //   629: aload 9
    //   631: if_acmpeq +8 -> 639
    //   634: aload 11
    //   636: invokevirtual 171	android/graphics/Bitmap:recycle	()V
    //   639: new 131	java/io/ByteArrayOutputStream
    //   642: dup
    //   643: sipush 1024
    //   646: invokespecial 134	java/io/ByteArrayOutputStream:<init>	(I)V
    //   649: astore 11
    //   651: aload 8
    //   653: getfield 137	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   656: astore 8
    //   658: ldc 139
    //   660: aload 8
    //   662: invokevirtual 145	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   665: ifne +23 -> 688
    //   668: ldc 147
    //   670: aload 8
    //   672: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   675: ifne +13 -> 688
    //   678: ldc 153
    //   680: aload 8
    //   682: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   685: ifeq +226 -> 911
    //   688: new 99	java/lang/StringBuilder
    //   691: dup
    //   692: ldc 155
    //   694: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   697: astore 8
    //   699: aload 9
    //   701: getstatic 162	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   704: bipush 100
    //   706: aload 11
    //   708: invokevirtual 168	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   711: pop
    //   712: aload 9
    //   714: invokevirtual 171	android/graphics/Bitmap:recycle	()V
    //   717: aload 8
    //   719: aload 11
    //   721: invokevirtual 175	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   724: iconst_2
    //   725: invokestatic 181	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   728: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload 10
    //   734: ldc 183
    //   736: iconst_0
    //   737: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   740: pop
    //   741: aload 10
    //   743: ldc 188
    //   745: aload 8
    //   747: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   750: pop
    //   751: aload 10
    //   753: ldc 193
    //   755: aload_0
    //   756: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   759: pop
    //   760: aload 10
    //   762: areturn
    //   763: iload 4
    //   765: i2f
    //   766: aload 11
    //   768: invokevirtual 268	android/graphics/Bitmap:getHeight	()I
    //   771: i2f
    //   772: fdiv
    //   773: fstore 5
    //   775: goto -233 -> 542
    //   778: aload 9
    //   780: fload 5
    //   782: fneg
    //   783: fload 5
    //   785: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   788: goto -183 -> 605
    //   791: aload 9
    //   793: fload 5
    //   795: fload 5
    //   797: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   800: aload 9
    //   802: ldc_w 273
    //   805: invokevirtual 277	android/graphics/Matrix:postRotate	(F)Z
    //   808: pop
    //   809: goto -204 -> 605
    //   812: aload 9
    //   814: fload 5
    //   816: fload 5
    //   818: fneg
    //   819: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   822: goto -217 -> 605
    //   825: aload 9
    //   827: fload 5
    //   829: fload 5
    //   831: fneg
    //   832: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   835: aload 9
    //   837: ldc_w 278
    //   840: invokevirtual 277	android/graphics/Matrix:postRotate	(F)Z
    //   843: pop
    //   844: goto -239 -> 605
    //   847: aload 9
    //   849: fload 5
    //   851: fload 5
    //   853: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   856: aload 9
    //   858: ldc_w 278
    //   861: invokevirtual 277	android/graphics/Matrix:postRotate	(F)Z
    //   864: pop
    //   865: goto -260 -> 605
    //   868: aload 9
    //   870: fload 5
    //   872: fneg
    //   873: fload 5
    //   875: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   878: aload 9
    //   880: ldc_w 278
    //   883: invokevirtual 277	android/graphics/Matrix:postRotate	(F)Z
    //   886: pop
    //   887: goto -282 -> 605
    //   890: aload 9
    //   892: fload 5
    //   894: fload 5
    //   896: invokevirtual 265	android/graphics/Matrix:setScale	(FF)V
    //   899: aload 9
    //   901: ldc_w 279
    //   904: invokevirtual 277	android/graphics/Matrix:postRotate	(F)Z
    //   907: pop
    //   908: goto -303 -> 605
    //   911: new 99	java/lang/StringBuilder
    //   914: dup
    //   915: ldc 197
    //   917: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   920: astore 8
    //   922: aload 9
    //   924: getstatic 200	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   927: bipush 80
    //   929: aload 11
    //   931: invokevirtual 168	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   934: pop
    //   935: goto -223 -> 712
    //   938: astore_0
    //   939: aconst_null
    //   940: astore 8
    //   942: goto -688 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	paramString	String
    //   0	945	1	paramInt1	int
    //   0	945	2	paramInt2	int
    //   0	945	3	paramInt3	int
    //   0	945	4	paramInt4	int
    //   540	355	5	f	float
    //   66	458	6	i	int
    //   73	455	7	j	int
    //   46	895	8	localObject1	Object
    //   17	906	9	localObject2	Object
    //   7	754	10	localJSONObject	JSONObject
    //   217	713	11	localObject3	Object
    //   369	15	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   141	159	249	finally
    //   173	184	249	finally
    //   184	219	249	finally
    //   219	227	249	finally
    //   232	249	249	finally
    //   278	289	249	finally
    //   305	316	249	finally
    //   331	342	249	finally
    //   345	356	249	finally
    //   366	393	249	finally
    //   396	408	249	finally
    //   411	439	249	finally
    //   130	141	938	finally
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent(paramContext, ShortVideoPreviewActivity.class);
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("file_send_size", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong2);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("preview_only", true);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  /* Error */
  public String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 60	java/io/File
    //   6: dup
    //   7: getstatic 354	com/tencent/mobileqq/app/AppConstants:aQ	Ljava/lang/String;
    //   10: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 357	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_3
    //   20: invokevirtual 360	java/io/File:canWrite	()Z
    //   23: ifne +14 -> 37
    //   26: new 70	java/io/IOException
    //   29: dup
    //   30: ldc_w 362
    //   33: invokespecial 363	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: new 73	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 74	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: iconst_1
    //   47: putfield 78	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   50: aload_1
    //   51: iconst_0
    //   52: aload_1
    //   53: arraylength
    //   54: aload_3
    //   55: invokestatic 367	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   58: pop
    //   59: aload_3
    //   60: getfield 88	android/graphics/BitmapFactory$Options:outWidth	I
    //   63: ifle +10 -> 73
    //   66: aload_3
    //   67: getfield 91	android/graphics/BitmapFactory$Options:outHeight	I
    //   70: ifgt +14 -> 84
    //   73: new 369	java/lang/IllegalArgumentException
    //   76: dup
    //   77: ldc_w 371
    //   80: invokespecial 372	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: ldc_w 374
    //   87: aload_3
    //   88: getfield 137	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   91: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifeq +136 -> 230
    //   97: ldc_w 376
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +228 -> 330
    //   105: new 99	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   112: getstatic 354	com/tencent/mobileqq/app/AppConstants:aQ	Ljava/lang/String;
    //   115: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 378
    //   121: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   127: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 4
    //   139: new 60	java/io/File
    //   142: dup
    //   143: aload 4
    //   145: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore 5
    //   150: new 380	java/io/FileOutputStream
    //   153: dup
    //   154: aload 5
    //   156: invokespecial 381	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   159: astore_3
    //   160: aload_3
    //   161: aload_1
    //   162: invokevirtual 385	java/io/FileOutputStream:write	([B)V
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   173: iconst_1
    //   174: istore_2
    //   175: aload 4
    //   177: astore_1
    //   178: iload_2
    //   179: ifeq +318 -> 497
    //   182: new 282	android/content/Intent
    //   185: dup
    //   186: ldc_w 388
    //   189: invokespecial 389	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   192: astore_3
    //   193: aload_3
    //   194: new 99	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 391
    //   204: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 397	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   217: invokevirtual 401	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   220: pop
    //   221: invokestatic 407	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   224: aload_3
    //   225: invokevirtual 412	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   228: aload_1
    //   229: areturn
    //   230: ldc 153
    //   232: aload_3
    //   233: getfield 137	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   236: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifeq +10 -> 249
    //   242: ldc_w 414
    //   245: astore_3
    //   246: goto -145 -> 101
    //   249: ldc 139
    //   251: aload_3
    //   252: getfield 137	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   255: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +10 -> 268
    //   261: ldc_w 416
    //   264: astore_3
    //   265: goto -164 -> 101
    //   268: ldc 147
    //   270: aload_3
    //   271: getfield 137	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   274: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   277: ifeq +260 -> 537
    //   280: ldc_w 418
    //   283: astore_3
    //   284: goto -183 -> 101
    //   287: astore_1
    //   288: aconst_null
    //   289: astore_3
    //   290: aload_3
    //   291: ifnull +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   298: aload 5
    //   300: invokevirtual 421	java/io/File:exists	()Z
    //   303: ifeq +9 -> 312
    //   306: aload 5
    //   308: invokevirtual 424	java/io/File:delete	()Z
    //   311: pop
    //   312: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +13 -> 328
    //   318: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: iconst_2
    //   322: ldc_w 426
    //   325: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: aload_1
    //   329: athrow
    //   330: new 99	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   337: getstatic 354	com/tencent/mobileqq/app/AppConstants:aQ	Ljava/lang/String;
    //   340: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: ldc_w 378
    //   346: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   352: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: ldc_w 376
    //   358: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: astore_3
    //   365: new 60	java/io/File
    //   368: dup
    //   369: aload_3
    //   370: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   373: astore 6
    //   375: new 380	java/io/FileOutputStream
    //   378: dup
    //   379: aload 6
    //   381: invokespecial 381	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   384: astore 5
    //   386: aload_1
    //   387: iconst_0
    //   388: aload_1
    //   389: arraylength
    //   390: invokestatic 429	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   393: getstatic 200	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   396: bipush 75
    //   398: aload 5
    //   400: invokevirtual 168	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   403: istore_2
    //   404: aload 5
    //   406: ifnull +8 -> 414
    //   409: aload 5
    //   411: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   414: iload_2
    //   415: ifne +117 -> 532
    //   418: aload 6
    //   420: invokevirtual 421	java/io/File:exists	()Z
    //   423: ifeq +9 -> 432
    //   426: aload 6
    //   428: invokevirtual 424	java/io/File:delete	()Z
    //   431: pop
    //   432: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +97 -> 532
    //   438: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   441: iconst_2
    //   442: ldc_w 431
    //   445: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: aload_3
    //   449: astore_1
    //   450: goto -272 -> 178
    //   453: astore_1
    //   454: aload 4
    //   456: astore_3
    //   457: aload_3
    //   458: ifnull +7 -> 465
    //   461: aload_3
    //   462: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   465: aload 6
    //   467: invokevirtual 421	java/io/File:exists	()Z
    //   470: ifeq +9 -> 479
    //   473: aload 6
    //   475: invokevirtual 424	java/io/File:delete	()Z
    //   478: pop
    //   479: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +13 -> 495
    //   485: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   488: iconst_2
    //   489: ldc_w 431
    //   492: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: aload_1
    //   496: athrow
    //   497: new 70	java/io/IOException
    //   500: dup
    //   501: invokespecial 71	java/io/IOException:<init>	()V
    //   504: athrow
    //   505: astore_1
    //   506: goto -333 -> 173
    //   509: astore_3
    //   510: goto -212 -> 298
    //   513: astore_1
    //   514: goto -100 -> 414
    //   517: astore_3
    //   518: goto -53 -> 465
    //   521: astore_1
    //   522: aload 5
    //   524: astore_3
    //   525: goto -68 -> 457
    //   528: astore_1
    //   529: goto -239 -> 290
    //   532: aload_3
    //   533: astore_1
    //   534: goto -356 -> 178
    //   537: aconst_null
    //   538: astore_3
    //   539: goto -438 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	this	MediaApiPlugin
    //   0	542	1	paramArrayOfByte	byte[]
    //   174	241	2	bool	boolean
    //   13	449	3	localObject1	Object
    //   509	1	3	localIOException1	IOException
    //   517	1	3	localIOException2	IOException
    //   524	15	3	localObject2	Object
    //   1	454	4	str	String
    //   148	375	5	localObject3	Object
    //   373	101	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   150	160	287	finally
    //   375	386	453	finally
    //   169	173	505	java/io/IOException
    //   294	298	509	java/io/IOException
    //   409	414	513	java/io/IOException
    //   461	465	517	java/io/IOException
    //   386	404	521	finally
    //   160	165	528	finally
  }
  
  JSONObject a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    Object localObject = ShortVideoUtils.a(null, paramString);
    StringBuilder localStringBuilder = new StringBuilder("data:image/jpeg;base64,");
    if (localObject != null)
    {
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
      ((Bitmap)localObject).recycle();
    }
    localStringBuilder.append(Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("thumbData", localStringBuilder);
        ((JSONObject)localObject).put("videoID", paramString);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (localByteArrayOutputStream == null) {
          continue;
        }
        try
        {
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          return localObject;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return localObject;
        }
      }
      finally
      {
        if (localByteArrayOutputStream == null) {
          break label148;
        }
      }
      try
      {
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        return localObject;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return localObject;
      }
    }
    try
    {
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      label148:
      throw paramString;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 31
    //   2: aload_3
    //   3: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +2126 -> 2132
    //   9: aload_1
    //   10: ifnull +2128 -> 2138
    //   13: aload_1
    //   14: getfield 467	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	Z
    //   17: ifeq +2121 -> 2138
    //   20: iconst_1
    //   21: istore 12
    //   23: aload_0
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 471	com/tencent/mobileqq/jsp/MediaApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   30: ldc_w 473
    //   33: aload 4
    //   35: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +14 -> 52
    //   41: ldc_w 475
    //   44: aload 4
    //   46: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +1046 -> 1095
    //   52: aload 5
    //   54: arraylength
    //   55: iconst_1
    //   56: if_icmpne +1039 -> 1095
    //   59: new 57	org/json/JSONObject
    //   62: dup
    //   63: aload 5
    //   65: iconst_0
    //   66: aaload
    //   67: invokespecial 476	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_2
    //   71: aload_2
    //   72: ldc_w 478
    //   75: aload 4
    //   77: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   80: pop
    //   81: aload_2
    //   82: ldc_w 480
    //   85: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_3
    //   89: aload_3
    //   90: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifeq +10 -> 103
    //   96: iload 12
    //   98: ifne +5 -> 103
    //   101: iconst_1
    //   102: ireturn
    //   103: aload_2
    //   104: ldc_w 492
    //   107: iconst_0
    //   108: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   111: istore 10
    //   113: invokestatic 407	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: astore_1
    //   117: iload 10
    //   119: ifne +679 -> 798
    //   122: aload_2
    //   123: ldc_w 498
    //   126: iconst_0
    //   127: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   130: istore 11
    //   132: aload_2
    //   133: ldc_w 500
    //   136: ldc2_w 501
    //   139: invokevirtual 506	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   142: dstore 6
    //   144: aload_2
    //   145: ldc_w 508
    //   148: ldc2_w 509
    //   151: invokevirtual 506	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   154: dstore 8
    //   156: aload_2
    //   157: ldc_w 512
    //   160: sipush 8192
    //   163: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   166: sipush 1024
    //   169: imul
    //   170: istore 10
    //   172: aload_2
    //   173: ldc_w 514
    //   176: ldc2_w 515
    //   179: invokevirtual 520	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   182: lstore 15
    //   184: aload_2
    //   185: ldc_w 522
    //   188: ldc2_w 523
    //   191: invokevirtual 520	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   194: lstore 17
    //   196: aload_0
    //   197: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   200: invokevirtual 343	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   203: astore 5
    //   205: aload_0
    //   206: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   209: invokevirtual 527	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   212: invokevirtual 532	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   215: astore 19
    //   217: aload 5
    //   219: instanceof 534
    //   222: istore 13
    //   224: aload 5
    //   226: instanceof 536
    //   229: istore 14
    //   231: iload 13
    //   233: ifne +18 -> 251
    //   236: iload 14
    //   238: ifne +13 -> 251
    //   241: aload_0
    //   242: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   245: invokevirtual 539	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   248: ifnull +508 -> 756
    //   251: new 282	android/content/Intent
    //   254: dup
    //   255: invokespecial 540	android/content/Intent:<init>	()V
    //   258: astore_3
    //   259: iload 14
    //   261: ifeq +233 -> 494
    //   264: aload 5
    //   266: checkcast 536	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   269: invokeinterface 543 1 0
    //   274: ifeq +220 -> 494
    //   277: aload_3
    //   278: aload_0
    //   279: invokevirtual 545	com/tencent/mobileqq/jsp/MediaApiPlugin:a	()Landroid/content/Context;
    //   282: ldc_w 547
    //   285: invokevirtual 551	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   288: pop
    //   289: aload_3
    //   290: ldc_w 553
    //   293: iconst_1
    //   294: invokevirtual 320	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   297: pop
    //   298: aload_3
    //   299: ldc_w 555
    //   302: aload 5
    //   304: checkcast 536	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   307: invokeinterface 557 1 0
    //   312: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   315: pop
    //   316: aload_3
    //   317: ldc_w 559
    //   320: aload 5
    //   322: checkcast 536	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   325: invokeinterface 561 1 0
    //   330: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   333: pop
    //   334: aload_3
    //   335: ldc_w 563
    //   338: aload_0
    //   339: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   342: invokevirtual 527	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   345: invokevirtual 568	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   348: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   351: pop
    //   352: aload_3
    //   353: ldc_w 302
    //   356: aload 5
    //   358: invokevirtual 308	java/lang/Object:getClass	()Ljava/lang/Class;
    //   361: invokevirtual 311	java/lang/Class:getName	()Ljava/lang/String;
    //   364: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   367: pop
    //   368: aload_3
    //   369: ldc_w 313
    //   372: ldc_w 315
    //   375: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   378: pop
    //   379: aload_3
    //   380: ldc_w 570
    //   383: iconst_1
    //   384: invokevirtual 320	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   387: pop
    //   388: iload 11
    //   390: ifne +162 -> 552
    //   393: aload_2
    //   394: ldc_w 571
    //   397: iconst_1
    //   398: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   401: istore 11
    //   403: aload_3
    //   404: ldc_w 573
    //   407: iload 11
    //   409: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   412: pop
    //   413: iload 11
    //   415: iconst_1
    //   416: if_icmpne +12 -> 428
    //   419: aload_3
    //   420: ldc_w 578
    //   423: iconst_1
    //   424: invokevirtual 320	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   427: pop
    //   428: aload_3
    //   429: ldc_w 512
    //   432: iload 10
    //   434: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   437: pop
    //   438: iload 13
    //   440: ifeq +75 -> 515
    //   443: aload 5
    //   445: checkcast 534	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   448: aload_0
    //   449: aload_3
    //   450: iconst_2
    //   451: invokevirtual 581	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Landroid/content/Intent;B)V
    //   454: aload_1
    //   455: invokestatic 587	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   458: invokeinterface 593 1 0
    //   463: ldc_w 595
    //   466: aload_2
    //   467: invokevirtual 596	org/json/JSONObject:toString	()Ljava/lang/String;
    //   470: invokeinterface 602 3 0
    //   475: ldc_w 604
    //   478: iload 12
    //   480: invokeinterface 608 3 0
    //   485: invokeinterface 611 1 0
    //   490: pop
    //   491: goto +1653 -> 2144
    //   494: aload_3
    //   495: aload 5
    //   497: ldc_w 547
    //   500: invokevirtual 551	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   503: pop
    //   504: goto -152 -> 352
    //   507: astore_1
    //   508: aload_1
    //   509: invokevirtual 451	org/json/JSONException:printStackTrace	()V
    //   512: goto +1632 -> 2144
    //   515: iload 14
    //   517: ifeq +19 -> 536
    //   520: aload 5
    //   522: checkcast 536	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   525: aload_0
    //   526: aload_3
    //   527: iconst_2
    //   528: invokeinterface 612 4 0
    //   533: goto -79 -> 454
    //   536: aload_0
    //   537: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   540: invokevirtual 539	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   543: aload_0
    //   544: aload_3
    //   545: iconst_2
    //   546: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Landroid/content/Intent;B)V
    //   549: goto -95 -> 454
    //   552: iload 11
    //   554: iconst_1
    //   555: if_icmpne +65 -> 620
    //   558: aload_3
    //   559: ldc_w 578
    //   562: iconst_1
    //   563: invokevirtual 320	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   566: pop
    //   567: aload_3
    //   568: ldc_w 617
    //   571: iconst_2
    //   572: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   575: pop
    //   576: aload_3
    //   577: ldc_w 619
    //   580: iconst_2
    //   581: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   584: pop
    //   585: iload 13
    //   587: ifeq +17 -> 604
    //   590: aload 5
    //   592: checkcast 534	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   595: aload_0
    //   596: aload_3
    //   597: iconst_3
    //   598: invokevirtual 581	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Landroid/content/Intent;B)V
    //   601: goto -147 -> 454
    //   604: aload 5
    //   606: checkcast 536	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   609: aload_0
    //   610: aload_3
    //   611: iconst_3
    //   612: invokeinterface 612 4 0
    //   617: goto -163 -> 454
    //   620: iload 11
    //   622: iconst_2
    //   623: if_icmpne -169 -> 454
    //   626: aload_3
    //   627: ldc_w 621
    //   630: aload 19
    //   632: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   635: pop
    //   636: aload_3
    //   637: ldc_w 578
    //   640: iconst_1
    //   641: invokevirtual 320	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   644: pop
    //   645: aload_3
    //   646: ldc_w 623
    //   649: iconst_1
    //   650: invokevirtual 320	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   653: pop
    //   654: aload_3
    //   655: ldc_w 500
    //   658: dload 6
    //   660: invokevirtual 626	android/content/Intent:putExtra	(Ljava/lang/String;D)Landroid/content/Intent;
    //   663: pop
    //   664: aload_3
    //   665: ldc_w 508
    //   668: dload 8
    //   670: invokevirtual 626	android/content/Intent:putExtra	(Ljava/lang/String;D)Landroid/content/Intent;
    //   673: pop
    //   674: aload_3
    //   675: ldc_w 512
    //   678: iload 10
    //   680: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   683: pop
    //   684: aload_3
    //   685: ldc_w 619
    //   688: ldc2_w 627
    //   691: lload 17
    //   693: lmul
    //   694: invokevirtual 298	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   697: pop
    //   698: aload_3
    //   699: ldc_w 617
    //   702: iconst_0
    //   703: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   706: pop
    //   707: aload_3
    //   708: ldc_w 630
    //   711: lload 15
    //   713: ldc2_w 631
    //   716: lmul
    //   717: invokevirtual 298	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   720: pop
    //   721: iload 13
    //   723: ifeq +17 -> 740
    //   726: aload 5
    //   728: checkcast 534	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   731: aload_0
    //   732: aload_3
    //   733: iconst_3
    //   734: invokevirtual 581	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Landroid/content/Intent;B)V
    //   737: goto -283 -> 454
    //   740: aload 5
    //   742: checkcast 536	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   745: aload_0
    //   746: aload_3
    //   747: iconst_3
    //   748: invokeinterface 612 4 0
    //   753: goto -299 -> 454
    //   756: iload 12
    //   758: ifeq +16 -> 774
    //   761: aload_0
    //   762: aload 4
    //   764: iconst_0
    //   765: ldc_w 634
    //   768: invokevirtual 637	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   771: goto +1375 -> 2146
    //   774: aload_0
    //   775: aload_3
    //   776: iconst_2
    //   777: anewarray 141	java/lang/String
    //   780: dup
    //   781: iconst_0
    //   782: ldc_w 639
    //   785: aastore
    //   786: dup
    //   787: iconst_1
    //   788: ldc_w 634
    //   791: aastore
    //   792: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   795: goto +1351 -> 2146
    //   798: iload 10
    //   800: iconst_1
    //   801: if_icmpne +1343 -> 2144
    //   804: invokestatic 407	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   807: invokestatic 649	com/tencent/av/camera/QavCameraUsage:b	(Landroid/content/Context;)Z
    //   810: ifeq +5 -> 815
    //   813: iconst_1
    //   814: ireturn
    //   815: new 60	java/io/File
    //   818: dup
    //   819: new 99	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   826: getstatic 652	com/tencent/mobileqq/app/AppConstants:aK	Ljava/lang/String;
    //   829: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc_w 654
    //   835: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   844: astore 5
    //   846: aload 5
    //   848: invokevirtual 421	java/io/File:exists	()Z
    //   851: ifne +65 -> 916
    //   854: aload 5
    //   856: invokevirtual 357	java/io/File:mkdirs	()Z
    //   859: ifne +57 -> 916
    //   862: aload_1
    //   863: ldc_w 655
    //   866: iconst_0
    //   867: invokestatic 660	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   870: invokevirtual 663	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   873: pop
    //   874: iload 12
    //   876: ifeq +16 -> 892
    //   879: aload_0
    //   880: aload 4
    //   882: iconst_0
    //   883: ldc_w 634
    //   886: invokevirtual 637	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   889: goto +1259 -> 2148
    //   892: aload_0
    //   893: aload_3
    //   894: iconst_2
    //   895: anewarray 141	java/lang/String
    //   898: dup
    //   899: iconst_0
    //   900: ldc_w 639
    //   903: aastore
    //   904: dup
    //   905: iconst_1
    //   906: ldc_w 634
    //   909: aastore
    //   910: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   913: goto +1235 -> 2148
    //   916: new 99	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   923: getstatic 652	com/tencent/mobileqq/app/AppConstants:aK	Ljava/lang/String;
    //   926: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: ldc_w 654
    //   932: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   938: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   941: ldc_w 376
    //   944: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: astore_3
    //   951: new 60	java/io/File
    //   954: dup
    //   955: aload_3
    //   956: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   959: invokestatic 667	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   962: astore 4
    //   964: new 282	android/content/Intent
    //   967: dup
    //   968: ldc_w 669
    //   971: invokespecial 389	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   974: astore 5
    //   976: aload 5
    //   978: ldc_w 671
    //   981: aload 4
    //   983: invokevirtual 674	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   986: pop
    //   987: aload 5
    //   989: ldc_w 676
    //   992: bipush 100
    //   994: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   997: pop
    //   998: aload_2
    //   999: ldc_w 678
    //   1002: iconst_0
    //   1003: invokevirtual 682	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1006: ifeq +13 -> 1019
    //   1009: aload 5
    //   1011: ldc_w 684
    //   1014: iconst_1
    //   1015: invokevirtual 576	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1018: pop
    //   1019: aload_0
    //   1020: aload 5
    //   1022: iconst_1
    //   1023: invokevirtual 688	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1026: aload_1
    //   1027: invokestatic 587	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   1030: invokeinterface 593 1 0
    //   1035: ldc_w 690
    //   1038: aload_3
    //   1039: invokeinterface 602 3 0
    //   1044: ldc_w 595
    //   1047: aload_2
    //   1048: invokevirtual 596	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1051: invokeinterface 602 3 0
    //   1056: ldc_w 604
    //   1059: iload 12
    //   1061: invokeinterface 608 3 0
    //   1066: invokeinterface 611 1 0
    //   1071: pop
    //   1072: goto +1072 -> 2144
    //   1075: astore_2
    //   1076: aload_2
    //   1077: invokevirtual 691	java/lang/Exception:printStackTrace	()V
    //   1080: aload_1
    //   1081: ldc_w 692
    //   1084: iconst_0
    //   1085: invokestatic 660	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   1088: invokevirtual 663	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1091: pop
    //   1092: goto +1052 -> 2144
    //   1095: ldc_w 694
    //   1098: aload 4
    //   1100: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1103: ifne +14 -> 1117
    //   1106: ldc_w 696
    //   1109: aload 4
    //   1111: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1114: ifeq +230 -> 1344
    //   1117: aload 5
    //   1119: arraylength
    //   1120: iconst_1
    //   1121: if_icmpne +223 -> 1344
    //   1124: new 57	org/json/JSONObject
    //   1127: dup
    //   1128: aload 5
    //   1130: iconst_0
    //   1131: aaload
    //   1132: invokespecial 476	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1135: astore_1
    //   1136: aload_1
    //   1137: ldc_w 480
    //   1140: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1143: astore_2
    //   1144: aload_1
    //   1145: ldc 193
    //   1147: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1150: astore_3
    //   1151: aload_2
    //   1152: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1155: ifne +995 -> 2150
    //   1158: aload_3
    //   1159: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1162: ifeq +6 -> 1168
    //   1165: goto +985 -> 2150
    //   1168: aload_0
    //   1169: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1172: ifnonnull +54 -> 1226
    //   1175: aload_0
    //   1176: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1179: invokevirtual 343	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1182: astore 5
    //   1184: aload_0
    //   1185: new 700	com/tencent/mobileqq/widget/QQProgressDialog
    //   1188: dup
    //   1189: aload 5
    //   1191: aload 5
    //   1193: invokevirtual 704	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1196: ldc_w 705
    //   1199: invokevirtual 711	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1202: invokespecial 714	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   1205: putfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1208: aload_0
    //   1209: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1212: ldc_w 715
    //   1215: invokevirtual 717	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   1218: aload_0
    //   1219: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1222: aload_0
    //   1223: invokevirtual 720	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   1226: aload_0
    //   1227: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1230: invokevirtual 723	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1233: ifne +10 -> 1243
    //   1236: aload_0
    //   1237: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1240: invokevirtual 726	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   1243: ldc_w 696
    //   1246: aload 4
    //   1248: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1251: ifeq +38 -> 1289
    //   1254: new 728	aeeu
    //   1257: dup
    //   1258: aload_0
    //   1259: aload_2
    //   1260: aload_1
    //   1261: ldc_w 730
    //   1264: iconst_0
    //   1265: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1268: aload_3
    //   1269: invokespecial 733	aeeu:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   1272: iconst_5
    //   1273: aconst_null
    //   1274: iconst_1
    //   1275: invokestatic 739	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1278: goto +866 -> 2144
    //   1281: astore_1
    //   1282: aload_1
    //   1283: invokevirtual 451	org/json/JSONException:printStackTrace	()V
    //   1286: goto +858 -> 2144
    //   1289: new 741	aeet
    //   1292: dup
    //   1293: aload_0
    //   1294: aload_2
    //   1295: aload_1
    //   1296: ldc_w 743
    //   1299: sipush 1280
    //   1302: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1305: aload_1
    //   1306: ldc_w 745
    //   1309: sipush 1280
    //   1312: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1315: aload_1
    //   1316: ldc_w 747
    //   1319: iconst_1
    //   1320: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1323: aload_1
    //   1324: ldc_w 749
    //   1327: iconst_1
    //   1328: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1331: aload_3
    //   1332: invokespecial 752	aeet:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIIILjava/lang/String;)V
    //   1335: iconst_5
    //   1336: aconst_null
    //   1337: iconst_1
    //   1338: invokestatic 739	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1341: goto +803 -> 2144
    //   1344: ldc_w 754
    //   1347: aload 4
    //   1349: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1352: ifeq +471 -> 1823
    //   1355: aload 5
    //   1357: arraylength
    //   1358: iconst_1
    //   1359: if_icmpne +464 -> 1823
    //   1362: aconst_null
    //   1363: astore_2
    //   1364: new 756	java/util/concurrent/atomic/AtomicBoolean
    //   1367: dup
    //   1368: iconst_0
    //   1369: invokespecial 759	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   1372: astore_3
    //   1373: aload_2
    //   1374: astore_1
    //   1375: new 57	org/json/JSONObject
    //   1378: dup
    //   1379: aload 5
    //   1381: iconst_0
    //   1382: aaload
    //   1383: invokespecial 476	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1386: astore 4
    //   1388: aload_2
    //   1389: astore_1
    //   1390: aload 4
    //   1392: ldc_w 480
    //   1395: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1398: astore_2
    //   1399: aload_2
    //   1400: astore_1
    //   1401: aload 4
    //   1403: ldc_w 761
    //   1406: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1409: astore 5
    //   1411: aload_2
    //   1412: astore_1
    //   1413: aload 5
    //   1415: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1418: ifne +179 -> 1597
    //   1421: aload_2
    //   1422: astore_1
    //   1423: new 60	java/io/File
    //   1426: dup
    //   1427: aload 5
    //   1429: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   1432: invokevirtual 421	java/io/File:exists	()Z
    //   1435: ifne +30 -> 1465
    //   1438: aload_2
    //   1439: astore_1
    //   1440: aload_0
    //   1441: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1444: invokevirtual 527	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1447: invokevirtual 765	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1450: iconst_1
    //   1451: ldc_w 767
    //   1454: iconst_0
    //   1455: invokestatic 770	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1458: invokevirtual 663	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1461: pop
    //   1462: goto +690 -> 2152
    //   1465: aload_2
    //   1466: astore_1
    //   1467: new 772	aeeo
    //   1470: dup
    //   1471: aload_0
    //   1472: aload 5
    //   1474: aload_2
    //   1475: aload_3
    //   1476: invokespecial 775	aeeo:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1479: bipush 8
    //   1481: aconst_null
    //   1482: iconst_1
    //   1483: invokestatic 739	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1486: goto +666 -> 2152
    //   1489: astore_2
    //   1490: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1493: ifeq +30 -> 1523
    //   1496: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1499: iconst_4
    //   1500: new 99	java/lang/StringBuilder
    //   1503: dup
    //   1504: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1507: ldc_w 780
    //   1510: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: aload_2
    //   1514: invokevirtual 783	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1517: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1520: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1523: aload_1
    //   1524: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1527: ifne +617 -> 2144
    //   1530: aload_3
    //   1531: iconst_0
    //   1532: iconst_1
    //   1533: invokevirtual 787	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1536: ifeq +608 -> 2144
    //   1539: new 57	org/json/JSONObject
    //   1542: dup
    //   1543: invokespecial 58	org/json/JSONObject:<init>	()V
    //   1546: astore_2
    //   1547: aload_2
    //   1548: ldc_w 789
    //   1551: iconst_m1
    //   1552: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1555: pop
    //   1556: aload_2
    //   1557: ldc_w 791
    //   1560: invokestatic 407	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1563: ldc_w 792
    //   1566: invokevirtual 796	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1569: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1572: pop
    //   1573: iload 12
    //   1575: ifeq +233 -> 1808
    //   1578: aload_0
    //   1579: aload_1
    //   1580: iconst_1
    //   1581: anewarray 141	java/lang/String
    //   1584: dup
    //   1585: iconst_0
    //   1586: aload_2
    //   1587: invokevirtual 596	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1590: aastore
    //   1591: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1594: goto +550 -> 2144
    //   1597: aload_2
    //   1598: astore_1
    //   1599: aload 4
    //   1601: ldc_w 798
    //   1604: invokevirtual 800	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1607: astore 4
    //   1609: aload_2
    //   1610: astore_1
    //   1611: aload 4
    //   1613: ldc_w 802
    //   1616: invokevirtual 805	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1619: ifne +16 -> 1635
    //   1622: aload_2
    //   1623: astore_1
    //   1624: aload 4
    //   1626: ldc_w 807
    //   1629: invokevirtual 805	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1632: ifeq +152 -> 1784
    //   1635: aload_2
    //   1636: astore_1
    //   1637: aload_0
    //   1638: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1641: ifnonnull +62 -> 1703
    //   1644: aload_2
    //   1645: astore_1
    //   1646: aload_0
    //   1647: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1650: invokevirtual 343	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1653: astore 5
    //   1655: aload_2
    //   1656: astore_1
    //   1657: aload_0
    //   1658: new 700	com/tencent/mobileqq/widget/QQProgressDialog
    //   1661: dup
    //   1662: aload 5
    //   1664: aload 5
    //   1666: invokevirtual 704	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1669: ldc_w 705
    //   1672: invokevirtual 711	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1675: invokespecial 714	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   1678: putfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1681: aload_2
    //   1682: astore_1
    //   1683: aload_0
    //   1684: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1687: ldc_w 715
    //   1690: invokevirtual 717	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   1693: aload_2
    //   1694: astore_1
    //   1695: aload_0
    //   1696: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1699: aload_0
    //   1700: invokevirtual 720	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   1703: aload_2
    //   1704: astore_1
    //   1705: aload_0
    //   1706: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1709: invokevirtual 723	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1712: ifne +12 -> 1724
    //   1715: aload_2
    //   1716: astore_1
    //   1717: aload_0
    //   1718: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1721: invokevirtual 726	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   1724: aload_2
    //   1725: astore_1
    //   1726: new 809	aeep
    //   1729: dup
    //   1730: aload_0
    //   1731: aload 4
    //   1733: aload_2
    //   1734: aload_3
    //   1735: invokespecial 810	aeep:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1738: iconst_5
    //   1739: aconst_null
    //   1740: iconst_1
    //   1741: invokestatic 739	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1744: goto +400 -> 2144
    //   1747: astore_1
    //   1748: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1751: ifeq +393 -> 2144
    //   1754: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1757: iconst_4
    //   1758: new 99	java/lang/StringBuilder
    //   1761: dup
    //   1762: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1765: ldc_w 780
    //   1768: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: aload_1
    //   1772: invokevirtual 783	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1775: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1778: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: goto +363 -> 2144
    //   1784: aload_2
    //   1785: astore_1
    //   1786: invokestatic 814	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1789: new 816	aeeq
    //   1792: dup
    //   1793: aload_0
    //   1794: aload 4
    //   1796: aload_2
    //   1797: aload_3
    //   1798: invokespecial 817	aeeq:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1801: invokevirtual 822	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1804: pop
    //   1805: goto +339 -> 2144
    //   1808: aload_0
    //   1809: ldc_w 754
    //   1812: iconst_0
    //   1813: aload_2
    //   1814: invokevirtual 596	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1817: invokevirtual 637	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   1820: goto +324 -> 2144
    //   1823: ldc_w 824
    //   1826: aload 4
    //   1828: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1831: ifeq +120 -> 1951
    //   1834: aload 5
    //   1836: arraylength
    //   1837: iconst_1
    //   1838: if_icmpne +113 -> 1951
    //   1841: new 57	org/json/JSONObject
    //   1844: dup
    //   1845: aload 5
    //   1847: iconst_0
    //   1848: aaload
    //   1849: invokespecial 476	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1852: astore_1
    //   1853: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1856: ifeq +30 -> 1886
    //   1859: ldc_w 826
    //   1862: iconst_2
    //   1863: new 99	java/lang/StringBuilder
    //   1866: dup
    //   1867: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1870: ldc_w 828
    //   1873: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: aload_1
    //   1877: invokevirtual 783	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1880: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1883: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1886: aload_1
    //   1887: ldc_w 830
    //   1890: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1893: astore_2
    //   1894: aload_1
    //   1895: ldc_w 832
    //   1898: invokevirtual 835	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1901: lstore 15
    //   1903: aload_1
    //   1904: ldc_w 837
    //   1907: invokevirtual 835	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1910: lstore 17
    //   1912: aload_0
    //   1913: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1916: invokevirtual 343	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1919: aload_2
    //   1920: lload 15
    //   1922: lload 17
    //   1924: invokestatic 839	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Landroid/content/Context;Ljava/lang/String;JJ)V
    //   1927: goto +217 -> 2144
    //   1930: astore_1
    //   1931: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1934: ifeq +210 -> 2144
    //   1937: ldc_w 826
    //   1940: iconst_2
    //   1941: ldc_w 841
    //   1944: aload_1
    //   1945: invokestatic 845	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1948: goto +196 -> 2144
    //   1951: ldc_w 847
    //   1954: aload 4
    //   1956: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1959: ifeq +185 -> 2144
    //   1962: aload 5
    //   1964: arraylength
    //   1965: iconst_1
    //   1966: if_icmplt +178 -> 2144
    //   1969: new 57	org/json/JSONObject
    //   1972: dup
    //   1973: aload 5
    //   1975: iconst_0
    //   1976: aaload
    //   1977: invokespecial 476	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1980: astore_1
    //   1981: aload_1
    //   1982: ldc_w 480
    //   1985: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1988: astore_2
    //   1989: invokestatic 407	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1992: astore_3
    //   1993: aload_0
    //   1994: new 282	android/content/Intent
    //   1997: dup
    //   1998: aload_3
    //   1999: ldc_w 849
    //   2002: invokespecial 287	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2005: iconst_5
    //   2006: invokevirtual 688	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2009: aload_3
    //   2010: invokestatic 587	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   2013: invokeinterface 593 1 0
    //   2018: ldc_w 595
    //   2021: aload_1
    //   2022: invokevirtual 596	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2025: invokeinterface 602 3 0
    //   2030: ldc_w 604
    //   2033: iload 12
    //   2035: invokeinterface 608 3 0
    //   2040: invokeinterface 611 1 0
    //   2045: pop
    //   2046: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2049: ifeq +95 -> 2144
    //   2052: ldc_w 826
    //   2055: iconst_2
    //   2056: new 99	java/lang/StringBuilder
    //   2059: dup
    //   2060: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   2063: ldc_w 851
    //   2066: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: aload 5
    //   2071: iconst_0
    //   2072: aaload
    //   2073: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: ldc_w 853
    //   2079: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: aload_2
    //   2083: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2089: invokestatic 855	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2092: goto +52 -> 2144
    //   2095: astore_1
    //   2096: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2099: ifeq +45 -> 2144
    //   2102: ldc_w 826
    //   2105: iconst_2
    //   2106: new 99	java/lang/StringBuilder
    //   2109: dup
    //   2110: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   2113: ldc_w 857
    //   2116: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: aload_1
    //   2120: invokevirtual 783	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2123: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2126: invokestatic 855	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2129: goto +15 -> 2144
    //   2132: iconst_0
    //   2133: ireturn
    //   2134: astore_3
    //   2135: goto -562 -> 1573
    //   2138: iconst_0
    //   2139: istore 12
    //   2141: goto -2118 -> 23
    //   2144: iconst_1
    //   2145: ireturn
    //   2146: iconst_1
    //   2147: ireturn
    //   2148: iconst_1
    //   2149: ireturn
    //   2150: iconst_1
    //   2151: ireturn
    //   2152: iconst_1
    //   2153: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2154	0	this	MediaApiPlugin
    //   0	2154	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2154	2	paramString1	String
    //   0	2154	3	paramString2	String
    //   0	2154	4	paramString3	String
    //   0	2154	5	paramVarArgs	String[]
    //   142	517	6	d1	double
    //   154	515	8	d2	double
    //   111	691	10	i	int
    //   130	494	11	j	int
    //   21	2119	12	bool1	boolean
    //   222	500	13	bool2	boolean
    //   229	287	14	bool3	boolean
    //   182	1739	15	l1	long
    //   194	1729	17	l2	long
    //   215	416	19	str	String
    // Exception table:
    //   from	to	target	type
    //   59	96	507	org/json/JSONException
    //   103	117	507	org/json/JSONException
    //   122	231	507	org/json/JSONException
    //   241	251	507	org/json/JSONException
    //   251	259	507	org/json/JSONException
    //   264	352	507	org/json/JSONException
    //   352	388	507	org/json/JSONException
    //   393	413	507	org/json/JSONException
    //   419	428	507	org/json/JSONException
    //   428	438	507	org/json/JSONException
    //   443	454	507	org/json/JSONException
    //   454	491	507	org/json/JSONException
    //   494	504	507	org/json/JSONException
    //   520	533	507	org/json/JSONException
    //   536	549	507	org/json/JSONException
    //   558	585	507	org/json/JSONException
    //   590	601	507	org/json/JSONException
    //   604	617	507	org/json/JSONException
    //   626	721	507	org/json/JSONException
    //   726	737	507	org/json/JSONException
    //   740	753	507	org/json/JSONException
    //   761	771	507	org/json/JSONException
    //   774	795	507	org/json/JSONException
    //   804	813	507	org/json/JSONException
    //   815	874	507	org/json/JSONException
    //   879	889	507	org/json/JSONException
    //   892	913	507	org/json/JSONException
    //   916	1019	507	org/json/JSONException
    //   1019	1072	507	org/json/JSONException
    //   1076	1092	507	org/json/JSONException
    //   1019	1072	1075	java/lang/Exception
    //   1124	1165	1281	org/json/JSONException
    //   1168	1226	1281	org/json/JSONException
    //   1226	1243	1281	org/json/JSONException
    //   1243	1278	1281	org/json/JSONException
    //   1289	1341	1281	org/json/JSONException
    //   1375	1388	1489	java/lang/OutOfMemoryError
    //   1390	1399	1489	java/lang/OutOfMemoryError
    //   1401	1411	1489	java/lang/OutOfMemoryError
    //   1413	1421	1489	java/lang/OutOfMemoryError
    //   1423	1438	1489	java/lang/OutOfMemoryError
    //   1440	1462	1489	java/lang/OutOfMemoryError
    //   1467	1486	1489	java/lang/OutOfMemoryError
    //   1599	1609	1489	java/lang/OutOfMemoryError
    //   1611	1622	1489	java/lang/OutOfMemoryError
    //   1624	1635	1489	java/lang/OutOfMemoryError
    //   1637	1644	1489	java/lang/OutOfMemoryError
    //   1646	1655	1489	java/lang/OutOfMemoryError
    //   1657	1681	1489	java/lang/OutOfMemoryError
    //   1683	1693	1489	java/lang/OutOfMemoryError
    //   1695	1703	1489	java/lang/OutOfMemoryError
    //   1705	1715	1489	java/lang/OutOfMemoryError
    //   1717	1724	1489	java/lang/OutOfMemoryError
    //   1726	1744	1489	java/lang/OutOfMemoryError
    //   1786	1805	1489	java/lang/OutOfMemoryError
    //   1375	1388	1747	org/json/JSONException
    //   1390	1399	1747	org/json/JSONException
    //   1401	1411	1747	org/json/JSONException
    //   1413	1421	1747	org/json/JSONException
    //   1423	1438	1747	org/json/JSONException
    //   1440	1462	1747	org/json/JSONException
    //   1467	1486	1747	org/json/JSONException
    //   1599	1609	1747	org/json/JSONException
    //   1611	1622	1747	org/json/JSONException
    //   1624	1635	1747	org/json/JSONException
    //   1637	1644	1747	org/json/JSONException
    //   1646	1655	1747	org/json/JSONException
    //   1657	1681	1747	org/json/JSONException
    //   1683	1693	1747	org/json/JSONException
    //   1695	1703	1747	org/json/JSONException
    //   1705	1715	1747	org/json/JSONException
    //   1717	1724	1747	org/json/JSONException
    //   1726	1744	1747	org/json/JSONException
    //   1786	1805	1747	org/json/JSONException
    //   1841	1886	1930	java/lang/Exception
    //   1886	1927	1930	java/lang/Exception
    //   1969	2092	2095	java/lang/Exception
    //   1547	1573	2134	org/json/JSONException
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 861	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: invokestatic 407	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: astore 12
    //   12: aload 12
    //   14: invokestatic 587	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   17: astore 13
    //   19: aload 13
    //   21: ldc_w 690
    //   24: ldc_w 863
    //   27: invokeinterface 866 3 0
    //   32: astore 11
    //   34: aload 13
    //   36: ldc_w 595
    //   39: ldc_w 863
    //   42: invokeinterface 866 3 0
    //   47: astore 14
    //   49: aload 13
    //   51: ldc_w 604
    //   54: iconst_0
    //   55: invokeinterface 869 3 0
    //   60: istore 5
    //   62: aload 12
    //   64: invokestatic 587	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   67: invokeinterface 593 1 0
    //   72: ldc_w 690
    //   75: invokeinterface 873 2 0
    //   80: ldc_w 595
    //   83: invokeinterface 873 2 0
    //   88: ldc_w 604
    //   91: invokeinterface 873 2 0
    //   96: invokeinterface 611 1 0
    //   101: pop
    //   102: aload 14
    //   104: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifeq +9 -> 116
    //   110: iload 5
    //   112: ifne +4 -> 116
    //   115: return
    //   116: new 57	org/json/JSONObject
    //   119: dup
    //   120: aload 14
    //   122: invokespecial 476	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   125: astore 14
    //   127: aload 14
    //   129: ldc_w 478
    //   132: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 13
    //   137: aload 14
    //   139: ldc_w 480
    //   142: invokevirtual 484	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 12
    //   147: aload 12
    //   149: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: istore 6
    //   154: iload 6
    //   156: ifeq +8 -> 164
    //   159: iload 5
    //   161: ifeq -46 -> 115
    //   164: iload_2
    //   165: iconst_1
    //   166: if_icmpeq +8 -> 174
    //   169: iload_2
    //   170: iconst_2
    //   171: if_icmpne +525 -> 696
    //   174: iload_3
    //   175: iconst_m1
    //   176: if_icmpne +481 -> 657
    //   179: iload_2
    //   180: iconst_1
    //   181: if_icmpne +111 -> 292
    //   184: iconst_1
    //   185: anewarray 141	java/lang/String
    //   188: astore_1
    //   189: aload_1
    //   190: iconst_0
    //   191: aload 11
    //   193: aastore
    //   194: aload 14
    //   196: ldc_w 875
    //   199: iconst_0
    //   200: invokevirtual 682	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   203: ifeq +257 -> 460
    //   206: new 877	org/json/JSONArray
    //   209: dup
    //   210: invokespecial 878	org/json/JSONArray:<init>	()V
    //   213: astore 11
    //   215: aload_1
    //   216: arraylength
    //   217: istore 4
    //   219: iconst_0
    //   220: istore_3
    //   221: iload_3
    //   222: iload 4
    //   224: if_icmpge +153 -> 377
    //   227: aload_1
    //   228: iload_3
    //   229: aaload
    //   230: astore 14
    //   232: new 57	org/json/JSONObject
    //   235: dup
    //   236: invokespecial 58	org/json/JSONObject:<init>	()V
    //   239: astore 15
    //   241: aload 15
    //   243: ldc 188
    //   245: ldc_w 863
    //   248: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   251: pop
    //   252: aload 15
    //   254: ldc 193
    //   256: aload 14
    //   258: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   261: pop
    //   262: aload 15
    //   264: ldc 183
    //   266: iconst_0
    //   267: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   270: pop
    //   271: aload 11
    //   273: aload 15
    //   275: invokevirtual 881	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   278: pop
    //   279: iload_3
    //   280: iconst_1
    //   281: iadd
    //   282: istore_3
    //   283: goto -62 -> 221
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 451	org/json/JSONException:printStackTrace	()V
    //   291: return
    //   292: aload_1
    //   293: ifnull +38 -> 331
    //   296: aload_1
    //   297: ldc_w 883
    //   300: invokevirtual 887	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   303: astore_1
    //   304: aload_1
    //   305: ifnull +10 -> 315
    //   308: aload_1
    //   309: invokevirtual 892	java/util/ArrayList:size	()I
    //   312: ifne +47 -> 359
    //   315: iload 5
    //   317: ifeq +19 -> 336
    //   320: aload_0
    //   321: aload 13
    //   323: iconst_0
    //   324: ldc_w 634
    //   327: invokevirtual 637	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: return
    //   331: aconst_null
    //   332: astore_1
    //   333: goto -29 -> 304
    //   336: aload_0
    //   337: aload 12
    //   339: iconst_2
    //   340: anewarray 141	java/lang/String
    //   343: dup
    //   344: iconst_0
    //   345: ldc_w 639
    //   348: aastore
    //   349: dup
    //   350: iconst_1
    //   351: ldc_w 634
    //   354: aastore
    //   355: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   358: return
    //   359: aload_1
    //   360: aload_1
    //   361: invokevirtual 892	java/util/ArrayList:size	()I
    //   364: anewarray 141	java/lang/String
    //   367: invokevirtual 896	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   370: checkcast 898	[Ljava/lang/String;
    //   373: astore_1
    //   374: goto -180 -> 194
    //   377: iload 5
    //   379: ifeq +33 -> 412
    //   382: aload_0
    //   383: aload 13
    //   385: iconst_0
    //   386: aload 11
    //   388: invokevirtual 899	org/json/JSONArray:toString	()Ljava/lang/String;
    //   391: invokevirtual 637	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: return
    //   395: astore_1
    //   396: iload 5
    //   398: ifeq +39 -> 437
    //   401: aload_0
    //   402: aload 13
    //   404: iconst_0
    //   405: ldc_w 634
    //   408: invokevirtual 637	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: return
    //   412: aload_0
    //   413: aload 12
    //   415: iconst_2
    //   416: anewarray 141	java/lang/String
    //   419: dup
    //   420: iconst_0
    //   421: ldc_w 901
    //   424: aastore
    //   425: dup
    //   426: iconst_1
    //   427: aload 11
    //   429: invokevirtual 899	org/json/JSONArray:toString	()Ljava/lang/String;
    //   432: aastore
    //   433: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   436: return
    //   437: aload_0
    //   438: aload 12
    //   440: iconst_2
    //   441: anewarray 141	java/lang/String
    //   444: dup
    //   445: iconst_0
    //   446: ldc_w 639
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: ldc_w 634
    //   455: aastore
    //   456: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   459: return
    //   460: aload_0
    //   461: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   464: ifnonnull +54 -> 518
    //   467: aload_0
    //   468: getfield 338	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   471: invokevirtual 343	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   474: astore 11
    //   476: aload_0
    //   477: new 700	com/tencent/mobileqq/widget/QQProgressDialog
    //   480: dup
    //   481: aload 11
    //   483: aload 11
    //   485: invokevirtual 704	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   488: ldc_w 705
    //   491: invokevirtual 711	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   494: invokespecial 714	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   497: putfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   500: aload_0
    //   501: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   504: ldc_w 715
    //   507: invokevirtual 717	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   510: aload_0
    //   511: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   514: aload_0
    //   515: invokevirtual 720	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   518: aload_0
    //   519: getfield 453	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   522: ifnull +10 -> 532
    //   525: aload_0
    //   526: getfield 453	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   529: invokevirtual 456	java/lang/Thread:interrupt	()V
    //   532: aload_0
    //   533: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   536: invokevirtual 723	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   539: ifne +10 -> 549
    //   542: aload_0
    //   543: getfield 698	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   546: invokevirtual 726	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   549: ldc_w 475
    //   552: aload 13
    //   554: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   557: ifeq +38 -> 595
    //   560: aload_0
    //   561: new 903	aees
    //   564: dup
    //   565: aload_0
    //   566: aload 12
    //   568: aload 14
    //   570: ldc_w 730
    //   573: iconst_0
    //   574: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   577: aload_1
    //   578: invokespecial 906	aees:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;I[Ljava/lang/String;)V
    //   581: putfield 453	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   584: aload_0
    //   585: getfield 453	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   588: iconst_5
    //   589: aconst_null
    //   590: iconst_1
    //   591: invokestatic 739	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   594: return
    //   595: aload_0
    //   596: new 908	aeer
    //   599: dup
    //   600: aload_0
    //   601: aload 12
    //   603: iload 5
    //   605: aload 13
    //   607: aload 14
    //   609: ldc_w 743
    //   612: sipush 1280
    //   615: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   618: aload 14
    //   620: ldc_w 745
    //   623: sipush 1280
    //   626: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   629: aload 14
    //   631: ldc_w 747
    //   634: iconst_1
    //   635: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   638: aload 14
    //   640: ldc_w 749
    //   643: iconst_1
    //   644: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   647: aload_1
    //   648: invokespecial 911	aeer:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ZLjava/lang/String;IIII[Ljava/lang/String;)V
    //   651: putfield 453	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   654: goto -70 -> 584
    //   657: iload 5
    //   659: ifeq +14 -> 673
    //   662: aload_0
    //   663: aload 13
    //   665: iconst_0
    //   666: ldc_w 634
    //   669: invokevirtual 637	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: return
    //   673: aload_0
    //   674: aload 12
    //   676: iconst_2
    //   677: anewarray 141	java/lang/String
    //   680: dup
    //   681: iconst_0
    //   682: ldc_w 913
    //   685: aastore
    //   686: dup
    //   687: iconst_1
    //   688: ldc_w 634
    //   691: aastore
    //   692: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   695: return
    //   696: iload_2
    //   697: iconst_3
    //   698: if_icmpne +273 -> 971
    //   701: iload_3
    //   702: iconst_m1
    //   703: if_icmpne -588 -> 115
    //   706: aload_1
    //   707: ifnull +153 -> 860
    //   710: aload_1
    //   711: ldc_w 915
    //   714: invokevirtual 918	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   717: astore 11
    //   719: aload_1
    //   720: ifnull +146 -> 866
    //   723: aload_1
    //   724: ldc_w 920
    //   727: iconst_0
    //   728: invokevirtual 923	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   731: ifeq +135 -> 866
    //   734: iconst_1
    //   735: istore_3
    //   736: aload_1
    //   737: ifnull +134 -> 871
    //   740: aload_1
    //   741: ldc_w 925
    //   744: lconst_0
    //   745: invokevirtual 928	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   748: lstore 7
    //   750: aload_1
    //   751: ifnull +126 -> 877
    //   754: aload_1
    //   755: ldc_w 300
    //   758: lconst_0
    //   759: invokevirtual 928	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   762: lstore 9
    //   764: aload 11
    //   766: ifnonnull +3 -> 769
    //   769: iload_3
    //   770: ifeq +123 -> 893
    //   773: new 877	org/json/JSONArray
    //   776: dup
    //   777: invokespecial 878	org/json/JSONArray:<init>	()V
    //   780: astore_1
    //   781: aload_0
    //   782: aload 11
    //   784: invokevirtual 930	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   787: astore 11
    //   789: aload 11
    //   791: ldc_w 837
    //   794: lload 9
    //   796: ldc2_w 627
    //   799: ldiv
    //   800: invokevirtual 933	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   803: pop
    //   804: aload 11
    //   806: ldc_w 832
    //   809: lload 7
    //   811: ldc2_w 631
    //   814: ldiv
    //   815: invokevirtual 933	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   818: pop
    //   819: aload 11
    //   821: ldc_w 498
    //   824: iconst_1
    //   825: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   828: pop
    //   829: aload_1
    //   830: aload 11
    //   832: invokevirtual 881	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   835: pop
    //   836: aload_0
    //   837: aload 12
    //   839: iconst_2
    //   840: anewarray 141	java/lang/String
    //   843: dup
    //   844: iconst_0
    //   845: ldc_w 901
    //   848: aastore
    //   849: dup
    //   850: iconst_1
    //   851: aload_1
    //   852: invokevirtual 899	org/json/JSONArray:toString	()Ljava/lang/String;
    //   855: aastore
    //   856: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   859: return
    //   860: aconst_null
    //   861: astore 11
    //   863: goto -144 -> 719
    //   866: iconst_0
    //   867: istore_3
    //   868: goto -132 -> 736
    //   871: lconst_0
    //   872: lstore 7
    //   874: goto -124 -> 750
    //   877: lconst_0
    //   878: lstore 9
    //   880: goto -116 -> 764
    //   883: astore 13
    //   885: aload 13
    //   887: invokevirtual 451	org/json/JSONException:printStackTrace	()V
    //   890: goto -61 -> 829
    //   893: aload_0
    //   894: new 908	aeer
    //   897: dup
    //   898: aload_0
    //   899: aload 12
    //   901: iload 5
    //   903: aload 13
    //   905: aload 14
    //   907: ldc_w 743
    //   910: sipush 2000
    //   913: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   916: aload 14
    //   918: ldc_w 745
    //   921: sipush 3000
    //   924: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   927: aload 14
    //   929: ldc_w 747
    //   932: iconst_0
    //   933: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   936: aload 14
    //   938: ldc_w 749
    //   941: iconst_0
    //   942: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   945: iconst_1
    //   946: anewarray 141	java/lang/String
    //   949: dup
    //   950: iconst_0
    //   951: aload 11
    //   953: aastore
    //   954: invokespecial 911	aeer:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ZLjava/lang/String;IIII[Ljava/lang/String;)V
    //   957: putfield 453	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   960: aload_0
    //   961: getfield 453	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   964: iconst_5
    //   965: aconst_null
    //   966: iconst_1
    //   967: invokestatic 739	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   970: return
    //   971: iload_2
    //   972: iconst_5
    //   973: if_icmpne -858 -> 115
    //   976: aload_1
    //   977: ldc_w 935
    //   980: iconst_0
    //   981: invokevirtual 938	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   984: istore 4
    //   986: aload_1
    //   987: ldc_w 940
    //   990: iconst_0
    //   991: invokevirtual 923	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   994: istore 6
    //   996: iload 4
    //   998: ifeq +104 -> 1102
    //   1001: iconst_1
    //   1002: istore 5
    //   1004: iconst_0
    //   1005: istore_3
    //   1006: iload 5
    //   1008: ifeq +100 -> 1108
    //   1011: iload 6
    //   1013: ifeq +95 -> 1108
    //   1016: iconst_1
    //   1017: istore_3
    //   1018: aload_0
    //   1019: aload 12
    //   1021: iconst_1
    //   1022: anewarray 141	java/lang/String
    //   1025: dup
    //   1026: iconst_0
    //   1027: iload_3
    //   1028: invokestatic 943	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1031: aastore
    //   1032: invokevirtual 643	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1035: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1038: ifeq -923 -> 115
    //   1041: ldc_w 826
    //   1044: iconst_2
    //   1045: new 99	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1052: ldc_w 945
    //   1055: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: iload 4
    //   1060: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: ldc_w 947
    //   1066: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: iload 6
    //   1071: invokevirtual 950	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1074: ldc_w 947
    //   1077: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: iload 5
    //   1082: invokevirtual 950	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1085: ldc_w 947
    //   1088: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: iload_3
    //   1092: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokestatic 855	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1101: return
    //   1102: iconst_0
    //   1103: istore 5
    //   1105: goto -101 -> 1004
    //   1108: iload 6
    //   1110: ifne -92 -> 1018
    //   1113: iconst_2
    //   1114: istore_3
    //   1115: goto -97 -> 1018
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1118	0	this	MediaApiPlugin
    //   0	1118	1	paramIntent	Intent
    //   0	1118	2	paramByte	byte
    //   0	1118	3	paramInt	int
    //   217	842	4	i	int
    //   60	1044	5	bool1	boolean
    //   152	957	6	bool2	boolean
    //   748	125	7	l1	long
    //   762	117	9	l2	long
    //   32	920	11	localObject1	Object
    //   10	1010	12	localObject2	Object
    //   17	647	13	localObject3	Object
    //   883	21	13	localJSONException	JSONException
    //   47	890	14	localObject4	Object
    //   239	35	15	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   116	154	286	org/json/JSONException
    //   206	219	395	org/json/JSONException
    //   232	279	395	org/json/JSONException
    //   382	394	395	org/json/JSONException
    //   412	436	395	org/json/JSONException
    //   789	829	883	org/json/JSONException
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin
 * JD-Core Version:    0.7.0.1
 */