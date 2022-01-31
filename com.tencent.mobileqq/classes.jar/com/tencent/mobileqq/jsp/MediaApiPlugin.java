package com.tencent.mobileqq.jsp;

import ailp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import atdp;
import atdq;
import awga;
import bdbi;
import becq;
import begw;
import bepp;
import bepr;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ymk;
import ymm;

public class MediaApiPlugin
  extends WebViewPlugin
  implements bepr, ymm
{
  public static final String a;
  bepp jdField_a_of_type_Bepp;
  Thread jdField_a_of_type_JavaLangThread;
  ymk jdField_a_of_type_Ymk;
  
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
    awga.a(paramString);
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
      ((StringBuilder)localObject1).append(bdbi.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
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
    //   0: new 61	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 62	org/json/JSONObject:<init>	()V
    //   7: astore 10
    //   9: new 64	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 9
    //   19: aload 9
    //   21: invokevirtual 70	java/io/File:length	()J
    //   24: ldc2_w 71
    //   27: lcmp
    //   28: ifge +11 -> 39
    //   31: new 74	java/io/IOException
    //   34: dup
    //   35: invokespecial 75	java/io/IOException:<init>	()V
    //   38: athrow
    //   39: new 77	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 78	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 8
    //   48: aload 8
    //   50: iconst_1
    //   51: putfield 82	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload_0
    //   55: aload 8
    //   57: invokestatic 88	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload 8
    //   63: getfield 92	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: istore 6
    //   68: aload 8
    //   70: getfield 95	android/graphics/BitmapFactory$Options:outHeight	I
    //   73: istore 7
    //   75: iload 6
    //   77: iflt +8 -> 85
    //   80: iload 7
    //   82: ifge +11 -> 93
    //   85: new 74	java/io/IOException
    //   88: dup
    //   89: invokespecial 75	java/io/IOException:<init>	()V
    //   92: athrow
    //   93: iload 6
    //   95: iload_1
    //   96: if_icmplt +9 -> 105
    //   99: iload 7
    //   101: iload_2
    //   102: if_icmpge +15 -> 117
    //   105: aload 10
    //   107: ldc 187
    //   109: iconst_1
    //   110: invokevirtual 190	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 10
    //   116: areturn
    //   117: iload 6
    //   119: iload_3
    //   120: if_icmpgt +332 -> 452
    //   123: iload 7
    //   125: iload 4
    //   127: if_icmpgt +325 -> 452
    //   130: new 207	java/io/FileInputStream
    //   133: dup
    //   134: aload 9
    //   136: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 9
    //   141: aload 9
    //   143: invokevirtual 216	java/io/InputStream:read	()I
    //   146: istore_1
    //   147: aload 9
    //   149: invokevirtual 216	java/io/InputStream:read	()I
    //   152: istore_2
    //   153: aload 9
    //   155: invokevirtual 216	java/io/InputStream:read	()I
    //   158: istore_3
    //   159: iload_1
    //   160: sipush 255
    //   163: if_icmpne +103 -> 266
    //   166: iload_2
    //   167: sipush 216
    //   170: if_icmpne +96 -> 266
    //   173: new 103	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 201
    //   179: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
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
    //   205: invokestatic 185	bdbi:encodeToString	([BI)Ljava/lang/String;
    //   208: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: sipush 30720
    //   215: newarray byte
    //   217: astore 11
    //   219: aload 9
    //   221: aload 11
    //   223: invokevirtual 219	java/io/InputStream:read	([B)I
    //   226: istore_1
    //   227: iload_1
    //   228: iconst_m1
    //   229: if_icmpeq +182 -> 411
    //   232: invokestatic 225	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   235: invokevirtual 228	java/lang/Thread:isInterrupted	()Z
    //   238: ifeq +121 -> 359
    //   241: new 230	java/lang/InterruptedException
    //   244: dup
    //   245: invokespecial 231	java/lang/InterruptedException:<init>	()V
    //   248: athrow
    //   249: astore_0
    //   250: aload 9
    //   252: astore 8
    //   254: aload 8
    //   256: ifnull +8 -> 264
    //   259: aload 8
    //   261: invokevirtual 234	java/io/InputStream:close	()V
    //   264: aload_0
    //   265: athrow
    //   266: iload_1
    //   267: bipush 66
    //   269: if_icmpne +23 -> 292
    //   272: iload_2
    //   273: bipush 77
    //   275: if_icmpne +17 -> 292
    //   278: new 103	java/lang/StringBuilder
    //   281: dup
    //   282: ldc 236
    //   284: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: astore 8
    //   289: goto -105 -> 184
    //   292: iload_1
    //   293: sipush 137
    //   296: if_icmpne +23 -> 319
    //   299: iload_2
    //   300: bipush 80
    //   302: if_icmpne +17 -> 319
    //   305: new 103	java/lang/StringBuilder
    //   308: dup
    //   309: ldc 159
    //   311: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: astore 8
    //   316: goto -132 -> 184
    //   319: iload_1
    //   320: bipush 71
    //   322: if_icmpne +23 -> 345
    //   325: iload_2
    //   326: bipush 73
    //   328: if_icmpne +17 -> 345
    //   331: new 103	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 238
    //   337: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: astore 8
    //   342: goto -158 -> 184
    //   345: new 103	java/lang/StringBuilder
    //   348: dup
    //   349: ldc 240
    //   351: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
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
    //   378: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   381: aload 8
    //   383: aload 12
    //   385: iconst_2
    //   386: invokestatic 185	bdbi:encodeToString	([BI)Ljava/lang/String;
    //   389: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: goto -174 -> 219
    //   396: aload 8
    //   398: aload 11
    //   400: iconst_2
    //   401: invokestatic 185	bdbi:encodeToString	([BI)Ljava/lang/String;
    //   404: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: goto -189 -> 219
    //   411: aload 10
    //   413: ldc 187
    //   415: iconst_0
    //   416: invokevirtual 190	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 10
    //   422: ldc 192
    //   424: aload 8
    //   426: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 10
    //   432: ldc 197
    //   434: aload_0
    //   435: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   438: pop
    //   439: aload 9
    //   441: ifnull -327 -> 114
    //   444: aload 9
    //   446: invokevirtual 234	java/io/InputStream:close	()V
    //   449: aload 10
    //   451: areturn
    //   452: iload 6
    //   454: iload_3
    //   455: idiv
    //   456: iload 7
    //   458: iload 4
    //   460: idiv
    //   461: invokestatic 250	java/lang/Math:max	(II)I
    //   464: istore_1
    //   465: aload 8
    //   467: iconst_0
    //   468: putfield 82	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
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
    //   508: putfield 253	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   511: aload_0
    //   512: aload 8
    //   514: invokestatic 88	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   517: astore 11
    //   519: aload 11
    //   521: ifnonnull +11 -> 532
    //   524: new 74	java/io/IOException
    //   527: dup
    //   528: invokespecial 75	java/io/IOException:<init>	()V
    //   531: athrow
    //   532: iload 6
    //   534: iload 4
    //   536: imul
    //   537: iload 7
    //   539: iload_3
    //   540: imul
    //   541: if_icmple +238 -> 779
    //   544: iload_3
    //   545: i2f
    //   546: aload 11
    //   548: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
    //   551: i2f
    //   552: fdiv
    //   553: fstore 5
    //   555: new 258	android/graphics/Matrix
    //   558: dup
    //   559: invokespecial 259	android/graphics/Matrix:<init>	()V
    //   562: astore 9
    //   564: aload_0
    //   565: invokestatic 265	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   568: tableswitch	default:+44 -> 612, 2:+226->794, 3:+239->807, 4:+260->828, 5:+273->841, 6:+295->863, 7:+316->884, 8:+338->906
    //   613: lconst_0
    //   614: fload 5
    //   616: fload 5
    //   618: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   621: aload 11
    //   623: iconst_0
    //   624: iconst_0
    //   625: aload 11
    //   627: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
    //   630: aload 11
    //   632: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
    //   635: aload 9
    //   637: iconst_1
    //   638: invokestatic 276	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   641: astore 9
    //   643: aload 11
    //   645: aload 9
    //   647: if_acmpeq +8 -> 655
    //   650: aload 11
    //   652: invokevirtual 175	android/graphics/Bitmap:recycle	()V
    //   655: new 135	java/io/ByteArrayOutputStream
    //   658: dup
    //   659: sipush 1024
    //   662: invokespecial 138	java/io/ByteArrayOutputStream:<init>	(I)V
    //   665: astore 11
    //   667: aload 8
    //   669: getfield 141	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   672: astore 8
    //   674: ldc 143
    //   676: aload 8
    //   678: invokevirtual 149	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   681: ifne +23 -> 704
    //   684: ldc 151
    //   686: aload 8
    //   688: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   691: ifne +13 -> 704
    //   694: ldc 157
    //   696: aload 8
    //   698: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   701: ifeq +226 -> 927
    //   704: new 103	java/lang/StringBuilder
    //   707: dup
    //   708: ldc 159
    //   710: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   713: astore 8
    //   715: aload 9
    //   717: getstatic 166	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   720: bipush 100
    //   722: aload 11
    //   724: invokevirtual 172	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   727: pop
    //   728: aload 9
    //   730: invokevirtual 175	android/graphics/Bitmap:recycle	()V
    //   733: aload 8
    //   735: aload 11
    //   737: invokevirtual 179	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   740: iconst_2
    //   741: invokestatic 185	bdbi:encodeToString	([BI)Ljava/lang/String;
    //   744: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 10
    //   750: ldc 187
    //   752: iconst_0
    //   753: invokevirtual 190	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 10
    //   759: ldc 192
    //   761: aload 8
    //   763: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   766: pop
    //   767: aload 10
    //   769: ldc 197
    //   771: aload_0
    //   772: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   775: pop
    //   776: aload 10
    //   778: areturn
    //   779: iload 4
    //   781: i2f
    //   782: aload 11
    //   784: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
    //   787: i2f
    //   788: fdiv
    //   789: fstore 5
    //   791: goto -236 -> 555
    //   794: aload 9
    //   796: fload 5
    //   798: fneg
    //   799: fload 5
    //   801: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   804: goto -183 -> 621
    //   807: aload 9
    //   809: fload 5
    //   811: fload 5
    //   813: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   816: aload 9
    //   818: ldc_w 277
    //   821: invokevirtual 281	android/graphics/Matrix:postRotate	(F)Z
    //   824: pop
    //   825: goto -204 -> 621
    //   828: aload 9
    //   830: fload 5
    //   832: fload 5
    //   834: fneg
    //   835: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   838: goto -217 -> 621
    //   841: aload 9
    //   843: fload 5
    //   845: fload 5
    //   847: fneg
    //   848: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   851: aload 9
    //   853: ldc_w 282
    //   856: invokevirtual 281	android/graphics/Matrix:postRotate	(F)Z
    //   859: pop
    //   860: goto -239 -> 621
    //   863: aload 9
    //   865: fload 5
    //   867: fload 5
    //   869: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   872: aload 9
    //   874: ldc_w 282
    //   877: invokevirtual 281	android/graphics/Matrix:postRotate	(F)Z
    //   880: pop
    //   881: goto -260 -> 621
    //   884: aload 9
    //   886: fload 5
    //   888: fneg
    //   889: fload 5
    //   891: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   894: aload 9
    //   896: ldc_w 282
    //   899: invokevirtual 281	android/graphics/Matrix:postRotate	(F)Z
    //   902: pop
    //   903: goto -282 -> 621
    //   906: aload 9
    //   908: fload 5
    //   910: fload 5
    //   912: invokevirtual 269	android/graphics/Matrix:setScale	(FF)V
    //   915: aload 9
    //   917: ldc_w 283
    //   920: invokevirtual 281	android/graphics/Matrix:postRotate	(F)Z
    //   923: pop
    //   924: goto -303 -> 621
    //   927: new 103	java/lang/StringBuilder
    //   930: dup
    //   931: ldc 201
    //   933: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   936: astore 8
    //   938: aload 9
    //   940: getstatic 204	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   943: bipush 80
    //   945: aload 11
    //   947: invokevirtual 172	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   950: pop
    //   951: goto -223 -> 728
    //   954: astore_0
    //   955: aconst_null
    //   956: astore 8
    //   958: goto -704 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	961	0	paramString	String
    //   0	961	1	paramInt1	int
    //   0	961	2	paramInt2	int
    //   0	961	3	paramInt3	int
    //   0	961	4	paramInt4	int
    //   553	358	5	f	float
    //   66	471	6	i	int
    //   73	468	7	j	int
    //   46	911	8	localObject1	Object
    //   17	922	9	localObject2	Object
    //   7	770	10	localJSONObject	JSONObject
    //   217	729	11	localObject3	Object
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
    //   130	141	954	finally
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
  
  private boolean a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (localBaseApplication.checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (Camera.getNumberOfCameras() > 0)
        {
          return true;
          i = 0;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
        i = 1;
      }
    }
  }
  
  private static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 4);
  }
  
  Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  /* Error */
  String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 64	java/io/File
    //   6: dup
    //   7: getstatic 388	aljq:bd	Ljava/lang/String;
    //   10: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 391	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_3
    //   20: invokevirtual 394	java/io/File:canWrite	()Z
    //   23: ifne +14 -> 37
    //   26: new 74	java/io/IOException
    //   29: dup
    //   30: ldc_w 396
    //   33: invokespecial 397	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: new 77	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 78	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: iconst_1
    //   47: putfield 82	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   50: aload_1
    //   51: iconst_0
    //   52: aload_1
    //   53: arraylength
    //   54: aload_3
    //   55: invokestatic 401	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   58: pop
    //   59: aload_3
    //   60: getfield 92	android/graphics/BitmapFactory$Options:outWidth	I
    //   63: ifle +10 -> 73
    //   66: aload_3
    //   67: getfield 95	android/graphics/BitmapFactory$Options:outHeight	I
    //   70: ifgt +14 -> 84
    //   73: new 403	java/lang/IllegalArgumentException
    //   76: dup
    //   77: ldc_w 405
    //   80: invokespecial 406	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: ldc_w 408
    //   87: aload_3
    //   88: getfield 141	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   91: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifeq +136 -> 230
    //   97: ldc_w 410
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +228 -> 330
    //   105: new 103	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   112: getstatic 388	aljq:bd	Ljava/lang/String;
    //   115: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 412
    //   121: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   127: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 4
    //   139: new 64	java/io/File
    //   142: dup
    //   143: aload 4
    //   145: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore 5
    //   150: new 414	java/io/FileOutputStream
    //   153: dup
    //   154: aload 5
    //   156: invokespecial 415	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   159: astore_3
    //   160: aload_3
    //   161: aload_1
    //   162: invokevirtual 419	java/io/FileOutputStream:write	([B)V
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   173: iconst_1
    //   174: istore_2
    //   175: aload 4
    //   177: astore_1
    //   178: iload_2
    //   179: ifeq +318 -> 497
    //   182: new 286	android/content/Intent
    //   185: dup
    //   186: ldc_w 422
    //   189: invokespecial 423	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   192: astore_3
    //   193: aload_3
    //   194: new 103	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 425
    //   204: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 431	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   217: invokevirtual 435	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   220: pop
    //   221: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   224: aload_3
    //   225: invokevirtual 440	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   228: aload_1
    //   229: areturn
    //   230: ldc 157
    //   232: aload_3
    //   233: getfield 141	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   236: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifeq +10 -> 249
    //   242: ldc_w 442
    //   245: astore_3
    //   246: goto -145 -> 101
    //   249: ldc 143
    //   251: aload_3
    //   252: getfield 141	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   255: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +10 -> 268
    //   261: ldc_w 444
    //   264: astore_3
    //   265: goto -164 -> 101
    //   268: ldc 151
    //   270: aload_3
    //   271: getfield 141	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   274: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   277: ifeq +260 -> 537
    //   280: ldc_w 446
    //   283: astore_3
    //   284: goto -183 -> 101
    //   287: astore_1
    //   288: aconst_null
    //   289: astore_3
    //   290: aload_3
    //   291: ifnull +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   298: aload 5
    //   300: invokevirtual 449	java/io/File:exists	()Z
    //   303: ifeq +9 -> 312
    //   306: aload 5
    //   308: invokevirtual 452	java/io/File:delete	()Z
    //   311: pop
    //   312: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +13 -> 328
    //   318: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: iconst_2
    //   322: ldc_w 454
    //   325: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: aload_1
    //   329: athrow
    //   330: new 103	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   337: getstatic 388	aljq:bd	Ljava/lang/String;
    //   340: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: ldc_w 412
    //   346: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   352: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: ldc_w 410
    //   358: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: astore_3
    //   365: new 64	java/io/File
    //   368: dup
    //   369: aload_3
    //   370: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   373: astore 6
    //   375: new 414	java/io/FileOutputStream
    //   378: dup
    //   379: aload 6
    //   381: invokespecial 415	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   384: astore 5
    //   386: aload_1
    //   387: iconst_0
    //   388: aload_1
    //   389: arraylength
    //   390: invokestatic 457	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   393: getstatic 204	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   396: bipush 75
    //   398: aload 5
    //   400: invokevirtual 172	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   403: istore_2
    //   404: aload 5
    //   406: ifnull +8 -> 414
    //   409: aload 5
    //   411: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   414: iload_2
    //   415: ifne +117 -> 532
    //   418: aload 6
    //   420: invokevirtual 449	java/io/File:exists	()Z
    //   423: ifeq +9 -> 432
    //   426: aload 6
    //   428: invokevirtual 452	java/io/File:delete	()Z
    //   431: pop
    //   432: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +97 -> 532
    //   438: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   441: iconst_2
    //   442: ldc_w 459
    //   445: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: aload_3
    //   449: astore_1
    //   450: goto -272 -> 178
    //   453: astore_1
    //   454: aload 4
    //   456: astore_3
    //   457: aload_3
    //   458: ifnull +7 -> 465
    //   461: aload_3
    //   462: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   465: aload 6
    //   467: invokevirtual 449	java/io/File:exists	()Z
    //   470: ifeq +9 -> 479
    //   473: aload 6
    //   475: invokevirtual 452	java/io/File:delete	()Z
    //   478: pop
    //   479: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +13 -> 495
    //   485: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   488: iconst_2
    //   489: ldc_w 459
    //   492: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: aload_1
    //   496: athrow
    //   497: new 74	java/io/IOException
    //   500: dup
    //   501: invokespecial 75	java/io/IOException:<init>	()V
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
    localStringBuilder.append(bdbi.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
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
  
  void a(Activity paramActivity, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramActivity instanceof AppActivity))
    {
      paramActivity = (AppActivity)paramActivity;
      paramActivity.requestPermissions(new atdp(this, paramJSONObject, paramBoolean, paramActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
    while (!(paramActivity instanceof BaseActivity)) {
      return;
    }
    paramActivity = (BaseActivity)paramActivity;
    paramActivity.requestPermissions(new atdq(this, paramJSONObject, paramBoolean, paramActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    boolean bool1 = paramJSONObject.optBoolean("needCrop", false);
    int j = paramJSONObject.optInt("mediaType", 0);
    double d1 = paramJSONObject.optDouble("maxProportion", 2.0D);
    double d2 = paramJSONObject.optDouble("minProportion", 0.6D);
    int i = paramJSONObject.optInt("imageSizeLimit", 8192) * 1024;
    long l1 = paramJSONObject.optLong("videoSizeLimit", 512000L);
    long l2 = paramJSONObject.optLong("videoDurationLimit", 120L);
    Activity localActivity = this.mRuntime.a();
    String str = this.mRuntime.a().getAccount();
    boolean bool2 = localActivity instanceof AbsBaseWebViewActivity;
    boolean bool3 = localActivity instanceof begw;
    Intent localIntent = new Intent();
    if ((bool3) && (((begw)localActivity).c()))
    {
      localIntent.setClass(a(), NewPhotoListActivity.class);
      localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
      localIntent.putExtra("PhotoConst.PLUGIN_APK", ((begw)localActivity).e());
      localIntent.putExtra("PhotoConst.PLUGIN_NAME", ((begw)localActivity).d());
      localIntent.putExtra("PhotoConst.UIN", this.mRuntime.a().getCurrentAccountUin());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
      if (bool1)
      {
        Point localPoint = ailp.a(localActivity, 103);
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", localPoint.x);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", localPoint.y);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
        localIntent.putExtra("Business_Origin", 103);
        localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
        localIntent.putExtra("PhotoConst.TARGET_PATH", ailp.a());
      }
      if (j != 0) {
        break label529;
      }
      j = paramJSONObject.optInt("max", 1);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", j);
      if (j == 1) {
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
      localIntent.putExtra("imageSizeLimit", i);
      if (!bool2) {
        break label490;
      }
      ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)2);
    }
    label529:
    for (;;)
    {
      b(localBaseApplication).edit().putString("getMediaParam", paramJSONObject.toString()).putBoolean("calledFromOpenApi", paramBoolean).commit();
      return;
      localIntent.setClass(localActivity, NewPhotoListActivity.class);
      break;
      label490:
      if (bool3)
      {
        ((begw)localActivity).a(this, localIntent, (byte)2);
      }
      else
      {
        this.mRuntime.a().a(this, localIntent, (byte)2);
        continue;
        if (j == 1)
        {
          localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
          localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
          localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 2);
          if (bool2) {
            ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)3);
          } else {
            ((begw)localActivity).a(this, localIntent, (byte)3);
          }
        }
        else if (j == 2)
        {
          localIntent.putExtra("uin", str);
          localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
          localIntent.putExtra("PhotoConst.IS_FROM_TROOP_REWARD", true);
          localIntent.putExtra("maxProportion", d1);
          localIntent.putExtra("minProportion", d2);
          localIntent.putExtra("imageSizeLimit", i);
          localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 1000L * l2);
          localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
          localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1024L * l1);
          if (bool2) {
            ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)3);
          } else {
            ((begw)localActivity).a(this, localIntent, (byte)3);
          }
        }
      }
    }
  }
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle == null) {}
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 31
    //   2: aload_3
    //   3: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +1973 -> 1979
    //   9: aload_1
    //   10: ifnull +1975 -> 1985
    //   13: aload_1
    //   14: getfield 690	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	Z
    //   17: ifeq +1968 -> 1985
    //   20: iconst_1
    //   21: istore 8
    //   23: aload_0
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 694	com/tencent/mobileqq/jsp/MediaApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   30: ldc_w 696
    //   33: aload 4
    //   35: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +14 -> 52
    //   41: ldc_w 698
    //   44: aload 4
    //   46: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +794 -> 843
    //   52: aload 5
    //   54: arraylength
    //   55: iconst_1
    //   56: if_icmpne +787 -> 843
    //   59: new 61	org/json/JSONObject
    //   62: dup
    //   63: aload 5
    //   65: iconst_0
    //   66: aaload
    //   67: invokespecial 699	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_1
    //   71: aload_1
    //   72: ldc_w 701
    //   75: aload 4
    //   77: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   80: pop
    //   81: aload_1
    //   82: ldc_w 702
    //   85: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_2
    //   89: aload_2
    //   90: invokestatic 712	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifeq +10 -> 103
    //   96: iload 8
    //   98: ifne +5 -> 103
    //   101: iconst_1
    //   102: ireturn
    //   103: aload_1
    //   104: ldc_w 714
    //   107: iconst_0
    //   108: invokevirtual 519	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   111: istore 6
    //   113: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: astore_3
    //   117: iload 6
    //   119: ifne +205 -> 324
    //   122: aload_0
    //   123: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   126: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   129: astore_3
    //   130: aload_3
    //   131: instanceof 555
    //   134: istore 9
    //   136: aload_3
    //   137: instanceof 557
    //   140: istore 10
    //   142: iload 9
    //   144: ifne +18 -> 162
    //   147: iload 10
    //   149: ifne +13 -> 162
    //   152: aload_0
    //   153: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   156: invokevirtual 656	becq:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   159: ifnull +26 -> 185
    //   162: aload_0
    //   163: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   166: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   169: ifnull +16 -> 185
    //   172: aload_0
    //   173: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   176: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   179: instanceof 487
    //   182: ifne +16 -> 198
    //   185: aload_0
    //   186: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   189: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   192: instanceof 500
    //   195: ifeq +64 -> 259
    //   198: iconst_0
    //   199: istore 7
    //   201: iload 7
    //   203: istore 6
    //   205: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   208: bipush 23
    //   210: if_icmplt +34 -> 244
    //   213: iload 7
    //   215: istore 6
    //   217: aload_0
    //   218: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   221: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   224: ldc_w 494
    //   227: invokevirtual 715	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   230: ifeq +14 -> 244
    //   233: iconst_1
    //   234: istore 6
    //   236: aload_0
    //   237: aload_3
    //   238: iload 8
    //   240: aload_1
    //   241: invokevirtual 717	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Landroid/app/Activity;ZLorg/json/JSONObject;)V
    //   244: iload 6
    //   246: ifne +1745 -> 1991
    //   249: aload_0
    //   250: aload_1
    //   251: iload 8
    //   253: invokevirtual 719	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Lorg/json/JSONObject;Z)V
    //   256: goto +1735 -> 1991
    //   259: iload 8
    //   261: ifeq +16 -> 277
    //   264: aload_0
    //   265: aload 4
    //   267: iconst_0
    //   268: ldc_w 721
    //   271: invokevirtual 724	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: goto +1719 -> 1993
    //   277: aload_0
    //   278: aload_2
    //   279: iconst_2
    //   280: anewarray 145	java/lang/String
    //   283: dup
    //   284: iconst_0
    //   285: ldc_w 726
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: ldc_w 721
    //   294: aastore
    //   295: invokevirtual 730	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   298: goto +1695 -> 1993
    //   301: astore_1
    //   302: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   305: iconst_1
    //   306: ldc_w 732
    //   309: aload_1
    //   310: invokestatic 735	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: goto +1678 -> 1991
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 479	org/json/JSONException:printStackTrace	()V
    //   321: goto +1670 -> 1991
    //   324: iload 6
    //   326: iconst_1
    //   327: if_icmpne +1664 -> 1991
    //   330: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   333: invokestatic 740	lmm:b	(Landroid/content/Context;)Z
    //   336: ifeq +5 -> 341
    //   339: iconst_1
    //   340: ireturn
    //   341: new 103	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   348: getstatic 743	aljq:aX	Ljava/lang/String;
    //   351: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 745
    //   357: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   363: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   366: ldc_w 410
    //   369: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: astore 5
    //   377: new 286	android/content/Intent
    //   380: dup
    //   381: invokespecial 558	android/content/Intent:<init>	()V
    //   384: astore 15
    //   386: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   389: new 64	java/io/File
    //   392: dup
    //   393: aload 5
    //   395: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   398: aload 15
    //   400: invokestatic 751	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:setSystemCapture	(Landroid/content/Context;Ljava/io/File;Landroid/content/Intent;)Landroid/net/Uri;
    //   403: pop
    //   404: aload_1
    //   405: ldc_w 753
    //   408: iconst_0
    //   409: invokevirtual 513	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   412: ifeq +13 -> 425
    //   415: aload 15
    //   417: ldc_w 755
    //   420: iconst_1
    //   421: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   424: pop
    //   425: iconst_0
    //   426: istore 7
    //   428: aload_0
    //   429: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   432: ifnull +184 -> 616
    //   435: aload_0
    //   436: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   439: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   442: ifnull +174 -> 616
    //   445: aload_0
    //   446: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   449: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   452: instanceof 487
    //   455: ifeq +161 -> 616
    //   458: aload_0
    //   459: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   462: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   465: checkcast 487	mqq/app/AppActivity
    //   468: astore 16
    //   470: iload 7
    //   472: istore 6
    //   474: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   477: bipush 23
    //   479: if_icmplt +55 -> 534
    //   482: iload 7
    //   484: istore 6
    //   486: aload 16
    //   488: ldc_w 350
    //   491: invokevirtual 756	mqq/app/AppActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   494: ifeq +40 -> 534
    //   497: aload 16
    //   499: new 758	atdn
    //   502: dup
    //   503: aload_0
    //   504: aload 15
    //   506: aload_3
    //   507: aload 5
    //   509: aload_1
    //   510: iload 8
    //   512: aload 16
    //   514: invokespecial 761	atdn:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;ZLmqq/app/AppActivity;)V
    //   517: iconst_1
    //   518: iconst_1
    //   519: anewarray 145	java/lang/String
    //   522: dup
    //   523: iconst_0
    //   524: ldc_w 350
    //   527: aastore
    //   528: invokevirtual 498	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   531: goto +1464 -> 1995
    //   534: iload 6
    //   536: ifne +1455 -> 1991
    //   539: new 64	java/io/File
    //   542: dup
    //   543: new 103	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   550: getstatic 743	aljq:aX	Ljava/lang/String;
    //   553: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 745
    //   559: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   568: astore 16
    //   570: aload 16
    //   572: invokevirtual 449	java/io/File:exists	()Z
    //   575: ifne +183 -> 758
    //   578: aload 16
    //   580: invokevirtual 391	java/io/File:mkdirs	()Z
    //   583: ifne +175 -> 758
    //   586: aload_3
    //   587: ldc_w 762
    //   590: iconst_0
    //   591: invokestatic 767	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   594: invokevirtual 770	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   597: pop
    //   598: iload 8
    //   600: ifeq +134 -> 734
    //   603: aload_0
    //   604: aload 4
    //   606: iconst_0
    //   607: ldc_w 721
    //   610: invokevirtual 724	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: goto +1388 -> 2001
    //   616: iload 7
    //   618: istore 6
    //   620: aload_0
    //   621: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   624: ifnull -90 -> 534
    //   627: iload 7
    //   629: istore 6
    //   631: aload_0
    //   632: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   635: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   638: ifnull -104 -> 534
    //   641: iload 7
    //   643: istore 6
    //   645: aload_0
    //   646: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   649: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   652: instanceof 379
    //   655: ifeq -121 -> 534
    //   658: aload_0
    //   659: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   662: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   665: checkcast 379	com/tencent/mobileqq/pluginsdk/BasePluginActivity
    //   668: astore 16
    //   670: iload 7
    //   672: istore 6
    //   674: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   677: bipush 23
    //   679: if_icmplt -145 -> 534
    //   682: iload 7
    //   684: istore 6
    //   686: aload 16
    //   688: ldc_w 350
    //   691: invokevirtual 771	com/tencent/mobileqq/pluginsdk/BasePluginActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   694: ifeq -160 -> 534
    //   697: aload 16
    //   699: new 773	atdo
    //   702: dup
    //   703: aload_0
    //   704: aload 15
    //   706: aload_3
    //   707: aload 5
    //   709: aload_1
    //   710: iload 8
    //   712: aload 16
    //   714: invokespecial 776	atdo:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;ZLcom/tencent/mobileqq/pluginsdk/BasePluginActivity;)V
    //   717: iconst_1
    //   718: iconst_1
    //   719: anewarray 145	java/lang/String
    //   722: dup
    //   723: iconst_0
    //   724: ldc_w 350
    //   727: aastore
    //   728: invokevirtual 777	com/tencent/mobileqq/pluginsdk/BasePluginActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   731: goto +1264 -> 1995
    //   734: aload_0
    //   735: aload_2
    //   736: iconst_2
    //   737: anewarray 145	java/lang/String
    //   740: dup
    //   741: iconst_0
    //   742: ldc_w 726
    //   745: aastore
    //   746: dup
    //   747: iconst_1
    //   748: ldc_w 721
    //   751: aastore
    //   752: invokevirtual 730	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   755: goto +1246 -> 2001
    //   758: aload_0
    //   759: aload 15
    //   761: iconst_1
    //   762: invokevirtual 781	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   765: aload_3
    //   766: invokestatic 38	com/tencent/mobileqq/jsp/MediaApiPlugin:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   769: invokeinterface 634 1 0
    //   774: ldc_w 783
    //   777: aload 5
    //   779: invokeinterface 643 3 0
    //   784: ldc_w 636
    //   787: aload_1
    //   788: invokevirtual 637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   791: invokeinterface 643 3 0
    //   796: ldc_w 645
    //   799: iload 8
    //   801: invokeinterface 649 3 0
    //   806: invokeinterface 652 1 0
    //   811: pop
    //   812: goto +1179 -> 1991
    //   815: astore_1
    //   816: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   819: iconst_1
    //   820: aload_1
    //   821: iconst_0
    //   822: anewarray 308	java/lang/Object
    //   825: invokestatic 786	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   828: aload_3
    //   829: ldc_w 787
    //   832: iconst_0
    //   833: invokestatic 767	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   836: invokevirtual 770	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   839: pop
    //   840: goto +1151 -> 1991
    //   843: ldc_w 789
    //   846: aload 4
    //   848: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   851: ifne +14 -> 865
    //   854: ldc_w 791
    //   857: aload 4
    //   859: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   862: ifeq +230 -> 1092
    //   865: aload 5
    //   867: arraylength
    //   868: iconst_1
    //   869: if_icmpne +223 -> 1092
    //   872: new 61	org/json/JSONObject
    //   875: dup
    //   876: aload 5
    //   878: iconst_0
    //   879: aaload
    //   880: invokespecial 699	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   883: astore_1
    //   884: aload_1
    //   885: ldc_w 702
    //   888: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   891: astore_2
    //   892: aload_1
    //   893: ldc 197
    //   895: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   898: astore_3
    //   899: aload_2
    //   900: invokestatic 712	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   903: ifne +1100 -> 2003
    //   906: aload_3
    //   907: invokestatic 712	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   910: ifeq +6 -> 916
    //   913: goto +1090 -> 2003
    //   916: aload_0
    //   917: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   920: ifnonnull +54 -> 974
    //   923: aload_0
    //   924: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   927: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   930: astore 5
    //   932: aload_0
    //   933: new 795	bepp
    //   936: dup
    //   937: aload 5
    //   939: aload 5
    //   941: invokevirtual 799	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   944: ldc_w 800
    //   947: invokevirtual 806	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   950: invokespecial 809	bepp:<init>	(Landroid/content/Context;I)V
    //   953: putfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   956: aload_0
    //   957: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   960: ldc_w 810
    //   963: invokevirtual 812	bepp:c	(I)V
    //   966: aload_0
    //   967: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   970: aload_0
    //   971: invokevirtual 815	bepp:a	(Lbepr;)V
    //   974: aload_0
    //   975: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   978: invokevirtual 818	bepp:isShowing	()Z
    //   981: ifne +10 -> 991
    //   984: aload_0
    //   985: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   988: invokevirtual 821	bepp:show	()V
    //   991: ldc_w 791
    //   994: aload 4
    //   996: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   999: ifeq +38 -> 1037
    //   1002: new 823	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2
    //   1005: dup
    //   1006: aload_0
    //   1007: aload_2
    //   1008: aload_1
    //   1009: ldc_w 825
    //   1012: iconst_0
    //   1013: invokevirtual 519	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1016: aload_3
    //   1017: invokespecial 828	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   1020: iconst_5
    //   1021: aconst_null
    //   1022: iconst_1
    //   1023: invokestatic 834	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1026: goto +965 -> 1991
    //   1029: astore_1
    //   1030: aload_1
    //   1031: invokevirtual 479	org/json/JSONException:printStackTrace	()V
    //   1034: goto +957 -> 1991
    //   1037: new 836	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread
    //   1040: dup
    //   1041: aload_0
    //   1042: aload_2
    //   1043: aload_1
    //   1044: ldc_w 838
    //   1047: sipush 1280
    //   1050: invokevirtual 519	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1053: aload_1
    //   1054: ldc_w 840
    //   1057: sipush 1280
    //   1060: invokevirtual 519	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1063: aload_1
    //   1064: ldc_w 842
    //   1067: iconst_1
    //   1068: invokevirtual 519	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1071: aload_1
    //   1072: ldc_w 844
    //   1075: iconst_1
    //   1076: invokevirtual 519	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1079: aload_3
    //   1080: invokespecial 847	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIIILjava/lang/String;)V
    //   1083: iconst_5
    //   1084: aconst_null
    //   1085: iconst_1
    //   1086: invokestatic 834	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1089: goto +902 -> 1991
    //   1092: ldc_w 849
    //   1095: aload 4
    //   1097: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1100: ifeq +474 -> 1574
    //   1103: aload 5
    //   1105: arraylength
    //   1106: iconst_1
    //   1107: if_icmpne +467 -> 1574
    //   1110: aconst_null
    //   1111: astore_2
    //   1112: new 851	java/util/concurrent/atomic/AtomicBoolean
    //   1115: dup
    //   1116: iconst_0
    //   1117: invokespecial 854	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   1120: astore_3
    //   1121: aload_2
    //   1122: astore_1
    //   1123: new 61	org/json/JSONObject
    //   1126: dup
    //   1127: aload 5
    //   1129: iconst_0
    //   1130: aaload
    //   1131: invokespecial 699	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1134: astore 4
    //   1136: aload_2
    //   1137: astore_1
    //   1138: aload 4
    //   1140: ldc_w 702
    //   1143: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1146: astore_2
    //   1147: aload_2
    //   1148: astore_1
    //   1149: aload 4
    //   1151: ldc_w 856
    //   1154: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1157: astore 5
    //   1159: aload_2
    //   1160: astore_1
    //   1161: aload 5
    //   1163: invokestatic 712	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1166: ifne +182 -> 1348
    //   1169: aload_2
    //   1170: astore_1
    //   1171: new 64	java/io/File
    //   1174: dup
    //   1175: aload 5
    //   1177: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1180: invokevirtual 449	java/io/File:exists	()Z
    //   1183: ifne +33 -> 1216
    //   1186: aload_2
    //   1187: astore_1
    //   1188: aload_0
    //   1189: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   1192: invokevirtual 548	becq:a	()Lcom/tencent/common/app/AppInterface;
    //   1195: invokevirtual 860	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1198: iconst_1
    //   1199: ldc_w 861
    //   1202: invokestatic 866	alpo:a	(I)Ljava/lang/String;
    //   1205: iconst_0
    //   1206: invokestatic 869	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1209: invokevirtual 770	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1212: pop
    //   1213: goto +792 -> 2005
    //   1216: aload_2
    //   1217: astore_1
    //   1218: new 871	com/tencent/mobileqq/jsp/MediaApiPlugin$3
    //   1221: dup
    //   1222: aload_0
    //   1223: aload 5
    //   1225: aload_2
    //   1226: aload_3
    //   1227: invokespecial 874	com/tencent/mobileqq/jsp/MediaApiPlugin$3:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1230: bipush 8
    //   1232: aconst_null
    //   1233: iconst_1
    //   1234: invokestatic 834	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1237: goto +768 -> 2005
    //   1240: astore_2
    //   1241: invokestatic 877	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1244: ifeq +30 -> 1274
    //   1247: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1250: iconst_4
    //   1251: new 103	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1258: ldc_w 879
    //   1261: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload_2
    //   1265: invokevirtual 882	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1274: aload_1
    //   1275: invokestatic 712	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1278: ifne +713 -> 1991
    //   1281: aload_3
    //   1282: iconst_0
    //   1283: iconst_1
    //   1284: invokevirtual 886	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1287: ifeq +704 -> 1991
    //   1290: new 61	org/json/JSONObject
    //   1293: dup
    //   1294: invokespecial 62	org/json/JSONObject:<init>	()V
    //   1297: astore_2
    //   1298: aload_2
    //   1299: ldc_w 888
    //   1302: iconst_m1
    //   1303: invokevirtual 190	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1306: pop
    //   1307: aload_2
    //   1308: ldc_w 890
    //   1311: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1314: ldc_w 891
    //   1317: invokevirtual 894	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1320: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1323: pop
    //   1324: iload 8
    //   1326: ifeq +233 -> 1559
    //   1329: aload_0
    //   1330: aload_1
    //   1331: iconst_1
    //   1332: anewarray 145	java/lang/String
    //   1335: dup
    //   1336: iconst_0
    //   1337: aload_2
    //   1338: invokevirtual 637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1341: aastore
    //   1342: invokevirtual 730	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1345: goto +646 -> 1991
    //   1348: aload_2
    //   1349: astore_1
    //   1350: aload 4
    //   1352: ldc_w 896
    //   1355: invokevirtual 898	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1358: astore 4
    //   1360: aload_2
    //   1361: astore_1
    //   1362: aload 4
    //   1364: ldc_w 900
    //   1367: invokevirtual 903	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1370: ifne +16 -> 1386
    //   1373: aload_2
    //   1374: astore_1
    //   1375: aload 4
    //   1377: ldc_w 905
    //   1380: invokevirtual 903	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1383: ifeq +152 -> 1535
    //   1386: aload_2
    //   1387: astore_1
    //   1388: aload_0
    //   1389: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   1392: ifnonnull +62 -> 1454
    //   1395: aload_2
    //   1396: astore_1
    //   1397: aload_0
    //   1398: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   1401: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   1404: astore 5
    //   1406: aload_2
    //   1407: astore_1
    //   1408: aload_0
    //   1409: new 795	bepp
    //   1412: dup
    //   1413: aload 5
    //   1415: aload 5
    //   1417: invokevirtual 799	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1420: ldc_w 800
    //   1423: invokevirtual 806	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1426: invokespecial 809	bepp:<init>	(Landroid/content/Context;I)V
    //   1429: putfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   1432: aload_2
    //   1433: astore_1
    //   1434: aload_0
    //   1435: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   1438: ldc_w 810
    //   1441: invokevirtual 812	bepp:c	(I)V
    //   1444: aload_2
    //   1445: astore_1
    //   1446: aload_0
    //   1447: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   1450: aload_0
    //   1451: invokevirtual 815	bepp:a	(Lbepr;)V
    //   1454: aload_2
    //   1455: astore_1
    //   1456: aload_0
    //   1457: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   1460: invokevirtual 818	bepp:isShowing	()Z
    //   1463: ifne +12 -> 1475
    //   1466: aload_2
    //   1467: astore_1
    //   1468: aload_0
    //   1469: getfield 793	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bepp	Lbepp;
    //   1472: invokevirtual 821	bepp:show	()V
    //   1475: aload_2
    //   1476: astore_1
    //   1477: new 907	com/tencent/mobileqq/jsp/MediaApiPlugin$4
    //   1480: dup
    //   1481: aload_0
    //   1482: aload 4
    //   1484: aload_2
    //   1485: aload_3
    //   1486: invokespecial 908	com/tencent/mobileqq/jsp/MediaApiPlugin$4:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1489: iconst_5
    //   1490: aconst_null
    //   1491: iconst_1
    //   1492: invokestatic 834	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1495: goto +496 -> 1991
    //   1498: astore_1
    //   1499: invokestatic 877	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1502: ifeq +489 -> 1991
    //   1505: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1508: iconst_4
    //   1509: new 103	java/lang/StringBuilder
    //   1512: dup
    //   1513: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1516: ldc_w 879
    //   1519: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1522: aload_1
    //   1523: invokevirtual 882	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1526: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1529: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1532: goto +459 -> 1991
    //   1535: aload_2
    //   1536: astore_1
    //   1537: invokestatic 912	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1540: new 914	com/tencent/mobileqq/jsp/MediaApiPlugin$5
    //   1543: dup
    //   1544: aload_0
    //   1545: aload 4
    //   1547: aload_2
    //   1548: aload_3
    //   1549: invokespecial 915	com/tencent/mobileqq/jsp/MediaApiPlugin$5:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1552: invokevirtual 920	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1555: pop
    //   1556: goto +435 -> 1991
    //   1559: aload_0
    //   1560: ldc_w 849
    //   1563: iconst_0
    //   1564: aload_2
    //   1565: invokevirtual 637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1568: invokevirtual 724	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   1571: goto +420 -> 1991
    //   1574: ldc_w 922
    //   1577: aload 4
    //   1579: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1582: ifeq +120 -> 1702
    //   1585: aload 5
    //   1587: arraylength
    //   1588: iconst_1
    //   1589: if_icmpne +113 -> 1702
    //   1592: new 61	org/json/JSONObject
    //   1595: dup
    //   1596: aload 5
    //   1598: iconst_0
    //   1599: aaload
    //   1600: invokespecial 699	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1603: astore_1
    //   1604: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1607: ifeq +30 -> 1637
    //   1610: ldc_w 924
    //   1613: iconst_2
    //   1614: new 103	java/lang/StringBuilder
    //   1617: dup
    //   1618: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1621: ldc_w 926
    //   1624: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: aload_1
    //   1628: invokevirtual 882	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1631: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1634: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1637: aload_1
    //   1638: ldc_w 928
    //   1641: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1644: astore_2
    //   1645: aload_1
    //   1646: ldc_w 930
    //   1649: invokevirtual 933	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1652: lstore 11
    //   1654: aload_1
    //   1655: ldc_w 935
    //   1658: invokevirtual 933	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1661: lstore 13
    //   1663: aload_0
    //   1664: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbecq;
    //   1667: invokevirtual 377	becq:a	()Landroid/app/Activity;
    //   1670: aload_2
    //   1671: lload 11
    //   1673: lload 13
    //   1675: invokestatic 937	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Landroid/content/Context;Ljava/lang/String;JJ)V
    //   1678: goto +313 -> 1991
    //   1681: astore_1
    //   1682: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1685: ifeq +306 -> 1991
    //   1688: ldc_w 924
    //   1691: iconst_2
    //   1692: ldc_w 939
    //   1695: aload_1
    //   1696: invokestatic 942	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1699: goto +292 -> 1991
    //   1702: ldc_w 944
    //   1705: aload 4
    //   1707: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1710: ifeq +173 -> 1883
    //   1713: aload 5
    //   1715: arraylength
    //   1716: iconst_1
    //   1717: if_icmplt +166 -> 1883
    //   1720: new 61	org/json/JSONObject
    //   1723: dup
    //   1724: aload 5
    //   1726: iconst_0
    //   1727: aaload
    //   1728: invokespecial 699	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1731: astore_1
    //   1732: aload_1
    //   1733: ldc_w 702
    //   1736: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1739: astore_2
    //   1740: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1743: astore_3
    //   1744: aload_0
    //   1745: new 286	android/content/Intent
    //   1748: dup
    //   1749: aload_3
    //   1750: ldc_w 946
    //   1753: invokespecial 291	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1756: iconst_5
    //   1757: invokevirtual 781	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1760: aload_3
    //   1761: invokestatic 38	com/tencent/mobileqq/jsp/MediaApiPlugin:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   1764: invokeinterface 634 1 0
    //   1769: ldc_w 636
    //   1772: aload_1
    //   1773: invokevirtual 637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1776: invokeinterface 643 3 0
    //   1781: ldc_w 645
    //   1784: iload 8
    //   1786: invokeinterface 649 3 0
    //   1791: invokeinterface 652 1 0
    //   1796: pop
    //   1797: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1800: ifeq +191 -> 1991
    //   1803: ldc_w 924
    //   1806: iconst_2
    //   1807: new 103	java/lang/StringBuilder
    //   1810: dup
    //   1811: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1814: ldc_w 948
    //   1817: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: aload 5
    //   1822: iconst_0
    //   1823: aaload
    //   1824: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: ldc_w 950
    //   1830: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: aload_2
    //   1834: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1840: invokestatic 952	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1843: goto +148 -> 1991
    //   1846: astore_1
    //   1847: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1850: ifeq +141 -> 1991
    //   1853: ldc_w 924
    //   1856: iconst_2
    //   1857: new 103	java/lang/StringBuilder
    //   1860: dup
    //   1861: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1864: ldc_w 954
    //   1867: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: aload_1
    //   1871: invokevirtual 882	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1874: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1877: invokestatic 952	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1880: goto +111 -> 1991
    //   1883: ldc_w 956
    //   1886: aload 4
    //   1888: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1891: ifeq +100 -> 1991
    //   1894: new 61	org/json/JSONObject
    //   1897: dup
    //   1898: aload 5
    //   1900: iconst_0
    //   1901: aaload
    //   1902: invokespecial 699	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1905: ldc_w 702
    //   1908: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1911: astore_1
    //   1912: aload_1
    //   1913: invokestatic 712	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1916: ifne +75 -> 1991
    //   1919: new 61	org/json/JSONObject
    //   1922: dup
    //   1923: invokespecial 62	org/json/JSONObject:<init>	()V
    //   1926: astore_2
    //   1927: aload_2
    //   1928: ldc_w 958
    //   1931: aload_0
    //   1932: invokespecial 960	com/tencent/mobileqq/jsp/MediaApiPlugin:a	()Z
    //   1935: invokevirtual 963	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   1938: pop
    //   1939: aload_0
    //   1940: aload_1
    //   1941: iconst_1
    //   1942: anewarray 145	java/lang/String
    //   1945: dup
    //   1946: iconst_0
    //   1947: aload_2
    //   1948: invokevirtual 637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1951: aastore
    //   1952: invokevirtual 730	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1955: goto +36 -> 1991
    //   1958: astore_1
    //   1959: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1962: ifeq +29 -> 1991
    //   1965: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1968: iconst_2
    //   1969: ldc_w 965
    //   1972: aload_1
    //   1973: invokestatic 942	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1976: goto +15 -> 1991
    //   1979: iconst_0
    //   1980: ireturn
    //   1981: astore_3
    //   1982: goto -658 -> 1324
    //   1985: iconst_0
    //   1986: istore 8
    //   1988: goto -1965 -> 23
    //   1991: iconst_1
    //   1992: ireturn
    //   1993: iconst_1
    //   1994: ireturn
    //   1995: iconst_1
    //   1996: istore 6
    //   1998: goto -1464 -> 534
    //   2001: iconst_1
    //   2002: ireturn
    //   2003: iconst_1
    //   2004: ireturn
    //   2005: iconst_1
    //   2006: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2007	0	this	MediaApiPlugin
    //   0	2007	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2007	2	paramString1	String
    //   0	2007	3	paramString2	String
    //   0	2007	4	paramString3	String
    //   0	2007	5	paramVarArgs	String[]
    //   111	1886	6	i	int
    //   199	484	7	j	int
    //   21	1966	8	bool1	boolean
    //   134	9	9	bool2	boolean
    //   140	8	10	bool3	boolean
    //   1652	20	11	l1	long
    //   1661	13	13	l2	long
    //   384	376	15	localIntent	Intent
    //   468	245	16	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   152	162	301	java/lang/Throwable
    //   162	185	301	java/lang/Throwable
    //   185	198	301	java/lang/Throwable
    //   205	213	301	java/lang/Throwable
    //   217	233	301	java/lang/Throwable
    //   236	244	301	java/lang/Throwable
    //   249	256	301	java/lang/Throwable
    //   264	274	301	java/lang/Throwable
    //   277	298	301	java/lang/Throwable
    //   59	96	316	org/json/JSONException
    //   103	117	316	org/json/JSONException
    //   122	142	316	org/json/JSONException
    //   152	162	316	org/json/JSONException
    //   162	185	316	org/json/JSONException
    //   185	198	316	org/json/JSONException
    //   205	213	316	org/json/JSONException
    //   217	233	316	org/json/JSONException
    //   236	244	316	org/json/JSONException
    //   249	256	316	org/json/JSONException
    //   264	274	316	org/json/JSONException
    //   277	298	316	org/json/JSONException
    //   302	313	316	org/json/JSONException
    //   330	339	316	org/json/JSONException
    //   341	425	316	org/json/JSONException
    //   428	470	316	org/json/JSONException
    //   474	482	316	org/json/JSONException
    //   486	531	316	org/json/JSONException
    //   539	598	316	org/json/JSONException
    //   603	613	316	org/json/JSONException
    //   620	627	316	org/json/JSONException
    //   631	641	316	org/json/JSONException
    //   645	670	316	org/json/JSONException
    //   674	682	316	org/json/JSONException
    //   686	731	316	org/json/JSONException
    //   734	755	316	org/json/JSONException
    //   758	812	316	org/json/JSONException
    //   816	840	316	org/json/JSONException
    //   758	812	815	java/lang/Exception
    //   872	913	1029	org/json/JSONException
    //   916	974	1029	org/json/JSONException
    //   974	991	1029	org/json/JSONException
    //   991	1026	1029	org/json/JSONException
    //   1037	1089	1029	org/json/JSONException
    //   1123	1136	1240	java/lang/OutOfMemoryError
    //   1138	1147	1240	java/lang/OutOfMemoryError
    //   1149	1159	1240	java/lang/OutOfMemoryError
    //   1161	1169	1240	java/lang/OutOfMemoryError
    //   1171	1186	1240	java/lang/OutOfMemoryError
    //   1188	1213	1240	java/lang/OutOfMemoryError
    //   1218	1237	1240	java/lang/OutOfMemoryError
    //   1350	1360	1240	java/lang/OutOfMemoryError
    //   1362	1373	1240	java/lang/OutOfMemoryError
    //   1375	1386	1240	java/lang/OutOfMemoryError
    //   1388	1395	1240	java/lang/OutOfMemoryError
    //   1397	1406	1240	java/lang/OutOfMemoryError
    //   1408	1432	1240	java/lang/OutOfMemoryError
    //   1434	1444	1240	java/lang/OutOfMemoryError
    //   1446	1454	1240	java/lang/OutOfMemoryError
    //   1456	1466	1240	java/lang/OutOfMemoryError
    //   1468	1475	1240	java/lang/OutOfMemoryError
    //   1477	1495	1240	java/lang/OutOfMemoryError
    //   1537	1556	1240	java/lang/OutOfMemoryError
    //   1123	1136	1498	org/json/JSONException
    //   1138	1147	1498	org/json/JSONException
    //   1149	1159	1498	org/json/JSONException
    //   1161	1169	1498	org/json/JSONException
    //   1171	1186	1498	org/json/JSONException
    //   1188	1213	1498	org/json/JSONException
    //   1218	1237	1498	org/json/JSONException
    //   1350	1360	1498	org/json/JSONException
    //   1362	1373	1498	org/json/JSONException
    //   1375	1386	1498	org/json/JSONException
    //   1388	1395	1498	org/json/JSONException
    //   1397	1406	1498	org/json/JSONException
    //   1408	1432	1498	org/json/JSONException
    //   1434	1444	1498	org/json/JSONException
    //   1446	1454	1498	org/json/JSONException
    //   1456	1466	1498	org/json/JSONException
    //   1468	1475	1498	org/json/JSONException
    //   1477	1495	1498	org/json/JSONException
    //   1537	1556	1498	org/json/JSONException
    //   1592	1637	1681	java/lang/Exception
    //   1637	1678	1681	java/lang/Exception
    //   1720	1843	1846	java/lang/Exception
    //   1894	1955	1958	java/lang/Exception
    //   1298	1324	1981	org/json/JSONException
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject2 = b(BaseApplicationImpl.getContext());
    Object localObject3 = ((SharedPreferences)localObject2).getString("camera_photo_path", "");
    Object localObject1 = ((SharedPreferences)localObject2).getString("getMediaParam", "");
    boolean bool1 = ((SharedPreferences)localObject2).getBoolean("calledFromOpenApi", false);
    ((SharedPreferences)localObject2).edit().remove("camera_photo_path").remove("getMediaParam").remove("calledFromOpenApi").commit();
    if (paramByte == 6) {
      localObject1 = paramIntent.getStringExtra("savedParam");
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!bool1)) {}
      label390:
      label762:
      do
      {
        JSONObject localJSONObject;
        do
        {
          return;
          String str;
          for (;;)
          {
            try
            {
              localJSONObject = new JSONObject((String)localObject1);
              str = localJSONObject.optString("method");
              localObject2 = localJSONObject.optString("callback");
              bool2 = TextUtils.isEmpty((CharSequence)localObject2);
              if ((bool2) && (!bool1)) {
                break;
              }
              if ((paramByte != 1) && (paramByte != 2) && (paramByte != 6)) {
                break label801;
              }
              if (paramInt != -1) {
                break label762;
              }
              if (paramByte == 1)
              {
                paramIntent = new String[1];
                paramIntent[0] = localObject3;
                if ((paramByte != 1) || (!localJSONObject.optBoolean("needCrop", false))) {
                  break label390;
                }
                localObject2 = new Intent();
                paramInt = this.mRuntime.a().switchRequestCode(this, (byte)6);
                ((Intent)localObject2).putExtra("keyAction", "actionSelectPicture");
                ((Intent)localObject2).putExtra("requestCode", paramInt);
                ((Intent)localObject2).putExtra("savedParam", (String)localObject1);
                ailp.a((Activity)a(), (Intent)localObject2, paramIntent[0], 103);
                return;
              }
            }
            catch (JSONException paramIntent)
            {
              paramIntent.printStackTrace();
              return;
            }
            if (paramIntent != null) {
              paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            }
            while ((paramIntent == null) || (paramIntent.size() == 0)) {
              if (bool1)
              {
                callJs4OpenApiIfNeeded(str, 0, "[]");
                return;
                paramIntent = null;
              }
              else
              {
                callJs((String)localObject2, new String[] { "2", "[]" });
                return;
              }
            }
            paramIntent = (String[])paramIntent.toArray(new String[paramIntent.size()]);
          }
          if (localJSONObject.optBoolean("urlOnly", false)) {
            try
            {
              localObject1 = new JSONArray();
              i = paramIntent.length;
              paramInt = 0;
              while (paramInt < i)
              {
                localJSONObject = paramIntent[paramInt];
                localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("data", "");
                ((JSONObject)localObject3).put("imageID", localJSONObject);
                ((JSONObject)localObject3).put("match", 0);
                ((JSONArray)localObject1).put(localObject3);
                paramInt += 1;
              }
              if (bool1)
              {
                callJs4OpenApiIfNeeded(str, 0, ((JSONArray)localObject1).toString());
                return;
              }
            }
            catch (JSONException paramIntent)
            {
              if (bool1)
              {
                callJs4OpenApiIfNeeded(str, 0, "[]");
                return;
                callJs((String)localObject2, new String[] { "0", ((JSONArray)localObject1).toString() });
                return;
              }
              callJs((String)localObject2, new String[] { "2", "[]" });
              return;
            }
          }
          if (this.jdField_a_of_type_Bepp == null)
          {
            localObject1 = this.mRuntime.a();
            this.jdField_a_of_type_Bepp = new bepp((Context)localObject1, ((Activity)localObject1).getResources().getDimensionPixelSize(2131298914));
            this.jdField_a_of_type_Bepp.c(2131694217);
            this.jdField_a_of_type_Bepp.a(this);
          }
          if (this.jdField_a_of_type_JavaLangThread != null) {
            this.jdField_a_of_type_JavaLangThread.interrupt();
          }
          if (!this.jdField_a_of_type_Bepp.isShowing()) {
            this.jdField_a_of_type_Bepp.show();
          }
          if ("getPictureV2".equals(str)) {}
          for (this.jdField_a_of_type_JavaLangThread = new MediaApiPlugin.PreparePicturesAndCallbackThreadV2(this, (String)localObject2, localJSONObject.optInt("scaleMode", 0), paramIntent);; this.jdField_a_of_type_JavaLangThread = new MediaApiPlugin.PreparePicturesAndCallbackThread(this, (String)localObject2, bool1, str, localJSONObject.optInt("outMaxWidth", 1280), localJSONObject.optInt("outMaxHeight", 1280), localJSONObject.optInt("inMinWidth", 1), localJSONObject.optInt("inMinHeight", 1), paramIntent))
          {
            ThreadManager.post(this.jdField_a_of_type_JavaLangThread, 5, null, true);
            return;
          }
          if (bool1)
          {
            callJs4OpenApiIfNeeded(str, 0, "[]");
            return;
          }
          callJs((String)localObject2, new String[] { "1", "[]" });
          return;
          if (paramByte != 3) {
            break;
          }
        } while (paramInt != -1);
        if (paramIntent != null) {
          localObject1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        }
        for (;;)
        {
          long l1;
          long l2;
          if ((paramIntent != null) && (paramIntent.getBooleanExtra("PhotoConst.IS_VIDEO_SELECTED", false)))
          {
            paramInt = 1;
            if (paramIntent == null) {
              break label976;
            }
            l1 = paramIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
            if (paramIntent == null) {
              break label982;
            }
            l2 = paramIntent.getLongExtra("file_send_duration", 0L);
            if ((localObject1 == null) && (paramInt == 0)) {
              break label998;
            }
            paramIntent = new JSONArray();
            localObject1 = a((String)localObject1);
          }
          try
          {
            ((JSONObject)localObject1).put("videoDuration", l2 / 1000L);
            ((JSONObject)localObject1).put("videoSize", l1 / 1024L);
            ((JSONObject)localObject1).put("mediaType", 1);
            paramIntent.put(localObject1);
            callJs((String)localObject2, new String[] { "0", paramIntent.toString() });
            return;
            localObject1 = null;
            continue;
            paramInt = 0;
            break label841;
            l1 = 0L;
            break label855;
            l2 = 0L;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        this.jdField_a_of_type_JavaLangThread = new MediaApiPlugin.PreparePicturesAndCallbackThread(this, (String)localObject2, bool1, localJSONException, localJSONObject.optInt("outMaxWidth", 2000), localJSONObject.optInt("outMaxHeight", 3000), localJSONObject.optInt("inMinWidth", 0), localJSONObject.optInt("inMinHeight", 0), new String[] { localObject1 });
        ThreadManager.post(this.jdField_a_of_type_JavaLangThread, 5, null, true);
        return;
      } while (paramByte != 5);
      label801:
      label841:
      label855:
      label998:
      int i = paramIntent.getIntExtra("pstnGrayFlag", 0);
      label976:
      label982:
      boolean bool2 = paramIntent.getBooleanExtra("isBindingContact", false);
      if (i != 0)
      {
        bool1 = true;
        label1109:
        paramInt = 0;
        if ((!bool1) || (!bool2)) {
          break label1213;
        }
        paramInt = 1;
      }
      for (;;)
      {
        callJs((String)localObject2, new String[] { String.valueOf(paramInt) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("MediaApiPlugin", 2, "GetIsLTUser pstnGrayFlag = " + i + "|" + bool2 + "|" + bool1 + "|" + paramInt);
        return;
        bool1 = false;
        break label1109;
        label1213:
        if (!bool2) {
          paramInt = 2;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
    if (this.jdField_a_of_type_Ymk != null) {
      this.jdField_a_of_type_Ymk.b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin
 * JD-Core Version:    0.7.0.1
 */