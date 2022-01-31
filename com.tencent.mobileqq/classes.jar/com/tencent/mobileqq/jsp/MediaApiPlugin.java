package com.tencent.mobileqq.jsp;

import ageu;
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
import atqs;
import baaw;
import bbac;
import bbeh;
import bbms;
import bbmu;
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
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wis;
import wiu;

public class MediaApiPlugin
  extends WebViewPlugin
  implements bbmu, wiu
{
  public static final String a;
  bbms jdField_a_of_type_Bbms;
  Thread jdField_a_of_type_JavaLangThread;
  wis jdField_a_of_type_Wis;
  
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
    atqs.a(paramString);
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
      ((StringBuilder)localObject1).append(baaw.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
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
    //   205: invokestatic 185	baaw:encodeToString	([BI)Ljava/lang/String;
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
    //   386: invokestatic 185	baaw:encodeToString	([BI)Ljava/lang/String;
    //   389: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: goto -174 -> 219
    //   396: aload 8
    //   398: aload 11
    //   400: iconst_2
    //   401: invokestatic 185	baaw:encodeToString	([BI)Ljava/lang/String;
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
    //   741: invokestatic 185	baaw:encodeToString	([BI)Ljava/lang/String;
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
    //   7: getstatic 388	ajed:ba	Ljava/lang/String;
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
    //   112: getstatic 388	ajed:ba	Ljava/lang/String;
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
    //   337: getstatic 388	ajed:ba	Ljava/lang/String;
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
    localStringBuilder.append(baaw.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
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
    boolean bool3 = localActivity instanceof bbeh;
    Intent localIntent = new Intent();
    if ((bool3) && (((bbeh)localActivity).c()))
    {
      localIntent.setClass(a(), NewPhotoListActivity.class);
      localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
      localIntent.putExtra("PhotoConst.PLUGIN_APK", ((bbeh)localActivity).e());
      localIntent.putExtra("PhotoConst.PLUGIN_NAME", ((bbeh)localActivity).d());
      localIntent.putExtra("PhotoConst.UIN", this.mRuntime.a().getCurrentAccountUin());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
      if (bool1)
      {
        Point localPoint = ageu.a(localActivity, 103);
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", localPoint.x);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", localPoint.y);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
        localIntent.putExtra("Business_Origin", 103);
        localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
        localIntent.putExtra("PhotoConst.TARGET_PATH", ageu.a());
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
        ((bbeh)localActivity).a(this, localIntent, (byte)2);
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
            ((bbeh)localActivity).a(this, localIntent, (byte)3);
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
            ((bbeh)localActivity).a(this, localIntent, (byte)3);
          }
        }
      }
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 31
    //   2: aload_3
    //   3: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +1979 -> 1985
    //   9: aload_1
    //   10: ifnull +1981 -> 1991
    //   13: aload_1
    //   14: getfield 667	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	Z
    //   17: ifeq +1974 -> 1991
    //   20: iconst_1
    //   21: istore 8
    //   23: aload_0
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 671	com/tencent/mobileqq/jsp/MediaApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   30: ldc_w 673
    //   33: aload 4
    //   35: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +14 -> 52
    //   41: ldc_w 675
    //   44: aload 4
    //   46: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +800 -> 849
    //   52: aload 5
    //   54: arraylength
    //   55: iconst_1
    //   56: if_icmpne +793 -> 849
    //   59: new 61	org/json/JSONObject
    //   62: dup
    //   63: aload 5
    //   65: iconst_0
    //   66: aaload
    //   67: invokespecial 676	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_1
    //   71: aload_1
    //   72: ldc_w 678
    //   75: aload 4
    //   77: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   80: pop
    //   81: aload_1
    //   82: ldc_w 680
    //   85: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_3
    //   89: aload_3
    //   90: invokestatic 690	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifeq +10 -> 103
    //   96: iload 8
    //   98: ifne +5 -> 103
    //   101: iconst_1
    //   102: ireturn
    //   103: aload_1
    //   104: ldc_w 692
    //   107: iconst_0
    //   108: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   111: istore 6
    //   113: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: astore_2
    //   117: iload 6
    //   119: ifne +216 -> 335
    //   122: aload_0
    //   123: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   126: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   129: astore_2
    //   130: aload_2
    //   131: instanceof 534
    //   134: istore 9
    //   136: aload_2
    //   137: instanceof 536
    //   140: istore 10
    //   142: iload 9
    //   144: ifne +18 -> 162
    //   147: iload 10
    //   149: ifne +13 -> 162
    //   152: aload_0
    //   153: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   156: invokevirtual 635	bbac:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   159: ifnull +111 -> 270
    //   162: aload_0
    //   163: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   166: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   169: ifnull +101 -> 270
    //   172: aload_0
    //   173: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   176: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   179: instanceof 694
    //   182: ifeq +88 -> 270
    //   185: iconst_0
    //   186: istore 7
    //   188: aload_0
    //   189: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   192: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   195: checkcast 694	mqq/app/AppActivity
    //   198: astore_2
    //   199: iload 7
    //   201: istore 6
    //   203: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   206: bipush 23
    //   208: if_icmplt +47 -> 255
    //   211: iload 7
    //   213: istore 6
    //   215: aload_2
    //   216: ldc_w 696
    //   219: invokevirtual 697	mqq/app/AppActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   222: ifeq +33 -> 255
    //   225: iconst_1
    //   226: istore 6
    //   228: aload_2
    //   229: new 699	aqsa
    //   232: dup
    //   233: aload_0
    //   234: aload_1
    //   235: iload 8
    //   237: aload_2
    //   238: invokespecial 702	aqsa:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Lorg/json/JSONObject;ZLmqq/app/AppActivity;)V
    //   241: iconst_1
    //   242: iconst_1
    //   243: anewarray 145	java/lang/String
    //   246: dup
    //   247: iconst_0
    //   248: ldc_w 696
    //   251: aastore
    //   252: invokevirtual 706	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   255: iload 6
    //   257: ifne +1740 -> 1997
    //   260: aload_0
    //   261: aload_1
    //   262: iload 8
    //   264: invokevirtual 708	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Lorg/json/JSONObject;Z)V
    //   267: goto +1730 -> 1997
    //   270: iload 8
    //   272: ifeq +16 -> 288
    //   275: aload_0
    //   276: aload 4
    //   278: iconst_0
    //   279: ldc_w 710
    //   282: invokevirtual 713	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: goto +1714 -> 1999
    //   288: aload_0
    //   289: aload_3
    //   290: iconst_2
    //   291: anewarray 145	java/lang/String
    //   294: dup
    //   295: iconst_0
    //   296: ldc_w 715
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: ldc_w 710
    //   305: aastore
    //   306: invokevirtual 719	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   309: goto +1690 -> 1999
    //   312: astore_1
    //   313: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   316: iconst_1
    //   317: ldc_w 721
    //   320: aload_1
    //   321: invokestatic 724	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: goto +1673 -> 1997
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 479	org/json/JSONException:printStackTrace	()V
    //   332: goto +1665 -> 1997
    //   335: iload 6
    //   337: iconst_1
    //   338: if_icmpne +1659 -> 1997
    //   341: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   344: invokestatic 729	kzy:b	(Landroid/content/Context;)Z
    //   347: ifeq +5 -> 352
    //   350: iconst_1
    //   351: ireturn
    //   352: new 64	java/io/File
    //   355: dup
    //   356: new 103	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   363: getstatic 732	ajed:aU	Ljava/lang/String;
    //   366: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 734
    //   372: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   381: astore 5
    //   383: aload 5
    //   385: invokevirtual 449	java/io/File:exists	()Z
    //   388: ifne +65 -> 453
    //   391: aload 5
    //   393: invokevirtual 391	java/io/File:mkdirs	()Z
    //   396: ifne +57 -> 453
    //   399: aload_2
    //   400: ldc_w 735
    //   403: iconst_0
    //   404: invokestatic 740	bbmy:a	(Landroid/content/Context;II)Lbbmy;
    //   407: invokevirtual 743	bbmy:a	()Landroid/widget/Toast;
    //   410: pop
    //   411: iload 8
    //   413: ifeq +16 -> 429
    //   416: aload_0
    //   417: aload 4
    //   419: iconst_0
    //   420: ldc_w 710
    //   423: invokevirtual 713	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: goto +1575 -> 2001
    //   429: aload_0
    //   430: aload_3
    //   431: iconst_2
    //   432: anewarray 145	java/lang/String
    //   435: dup
    //   436: iconst_0
    //   437: ldc_w 715
    //   440: aastore
    //   441: dup
    //   442: iconst_1
    //   443: ldc_w 710
    //   446: aastore
    //   447: invokevirtual 719	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   450: goto +1551 -> 2001
    //   453: new 103	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   460: getstatic 732	ajed:aU	Ljava/lang/String;
    //   463: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc_w 734
    //   469: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   475: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   478: ldc_w 410
    //   481: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: astore_3
    //   488: new 286	android/content/Intent
    //   491: dup
    //   492: invokespecial 537	android/content/Intent:<init>	()V
    //   495: astore 4
    //   497: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   500: new 64	java/io/File
    //   503: dup
    //   504: aload_3
    //   505: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   508: aload 4
    //   510: invokestatic 749	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:setSystemCapture	(Landroid/content/Context;Ljava/io/File;Landroid/content/Intent;)Landroid/net/Uri;
    //   513: pop
    //   514: aload_1
    //   515: ldc_w 751
    //   518: iconst_0
    //   519: invokevirtual 492	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   522: ifeq +13 -> 535
    //   525: aload 4
    //   527: ldc_w 753
    //   530: iconst_1
    //   531: invokevirtual 582	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   534: pop
    //   535: iconst_0
    //   536: istore 7
    //   538: aload_0
    //   539: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   542: ifnull +190 -> 732
    //   545: aload_0
    //   546: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   549: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   552: ifnull +180 -> 732
    //   555: aload_0
    //   556: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   559: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   562: instanceof 694
    //   565: ifeq +167 -> 732
    //   568: aload_0
    //   569: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   572: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   575: checkcast 694	mqq/app/AppActivity
    //   578: astore 5
    //   580: iload 7
    //   582: istore 6
    //   584: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   587: bipush 23
    //   589: if_icmplt +54 -> 643
    //   592: iload 7
    //   594: istore 6
    //   596: aload 5
    //   598: ldc_w 350
    //   601: invokevirtual 697	mqq/app/AppActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   604: ifeq +39 -> 643
    //   607: aload 5
    //   609: new 755	aqsb
    //   612: dup
    //   613: aload_0
    //   614: aload 4
    //   616: aload_2
    //   617: aload_3
    //   618: aload_1
    //   619: iload 8
    //   621: aload 5
    //   623: invokespecial 758	aqsb:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;ZLmqq/app/AppActivity;)V
    //   626: iconst_1
    //   627: iconst_1
    //   628: anewarray 145	java/lang/String
    //   631: dup
    //   632: iconst_0
    //   633: ldc_w 350
    //   636: aastore
    //   637: invokevirtual 706	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   640: iconst_1
    //   641: istore 6
    //   643: iload 6
    //   645: ifne +1352 -> 1997
    //   648: aload_0
    //   649: aload 4
    //   651: iconst_1
    //   652: invokevirtual 762	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   655: aload_2
    //   656: invokestatic 38	com/tencent/mobileqq/jsp/MediaApiPlugin:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   659: invokeinterface 613 1 0
    //   664: ldc_w 764
    //   667: aload_3
    //   668: invokeinterface 622 3 0
    //   673: ldc_w 615
    //   676: aload_1
    //   677: invokevirtual 616	org/json/JSONObject:toString	()Ljava/lang/String;
    //   680: invokeinterface 622 3 0
    //   685: ldc_w 624
    //   688: iload 8
    //   690: invokeinterface 628 3 0
    //   695: invokeinterface 631 1 0
    //   700: pop
    //   701: goto +1296 -> 1997
    //   704: astore_1
    //   705: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   708: iconst_1
    //   709: aload_1
    //   710: iconst_0
    //   711: anewarray 308	java/lang/Object
    //   714: invokestatic 767	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   717: aload_2
    //   718: ldc_w 768
    //   721: iconst_0
    //   722: invokestatic 740	bbmy:a	(Landroid/content/Context;II)Lbbmy;
    //   725: invokevirtual 743	bbmy:a	()Landroid/widget/Toast;
    //   728: pop
    //   729: goto +1268 -> 1997
    //   732: iload 7
    //   734: istore 6
    //   736: aload_0
    //   737: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   740: ifnull -97 -> 643
    //   743: iload 7
    //   745: istore 6
    //   747: aload_0
    //   748: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   751: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   754: ifnull -111 -> 643
    //   757: iload 7
    //   759: istore 6
    //   761: aload_0
    //   762: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   765: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   768: instanceof 379
    //   771: ifeq -128 -> 643
    //   774: aload_0
    //   775: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   778: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   781: checkcast 379	com/tencent/mobileqq/pluginsdk/BasePluginActivity
    //   784: astore 5
    //   786: iload 7
    //   788: istore 6
    //   790: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   793: bipush 23
    //   795: if_icmplt -152 -> 643
    //   798: iload 7
    //   800: istore 6
    //   802: aload 5
    //   804: ldc_w 350
    //   807: invokevirtual 769	com/tencent/mobileqq/pluginsdk/BasePluginActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   810: ifeq -167 -> 643
    //   813: aload 5
    //   815: new 771	aqsc
    //   818: dup
    //   819: aload_0
    //   820: aload 4
    //   822: aload_2
    //   823: aload_3
    //   824: aload_1
    //   825: iload 8
    //   827: aload 5
    //   829: invokespecial 774	aqsc:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;ZLcom/tencent/mobileqq/pluginsdk/BasePluginActivity;)V
    //   832: iconst_1
    //   833: iconst_1
    //   834: anewarray 145	java/lang/String
    //   837: dup
    //   838: iconst_0
    //   839: ldc_w 350
    //   842: aastore
    //   843: invokevirtual 775	com/tencent/mobileqq/pluginsdk/BasePluginActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   846: goto -206 -> 640
    //   849: ldc_w 777
    //   852: aload 4
    //   854: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   857: ifne +14 -> 871
    //   860: ldc_w 779
    //   863: aload 4
    //   865: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   868: ifeq +230 -> 1098
    //   871: aload 5
    //   873: arraylength
    //   874: iconst_1
    //   875: if_icmpne +223 -> 1098
    //   878: new 61	org/json/JSONObject
    //   881: dup
    //   882: aload 5
    //   884: iconst_0
    //   885: aaload
    //   886: invokespecial 676	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   889: astore_1
    //   890: aload_1
    //   891: ldc_w 680
    //   894: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   897: astore_2
    //   898: aload_1
    //   899: ldc 197
    //   901: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   904: astore_3
    //   905: aload_2
    //   906: invokestatic 690	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   909: ifne +1094 -> 2003
    //   912: aload_3
    //   913: invokestatic 690	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   916: ifeq +6 -> 922
    //   919: goto +1084 -> 2003
    //   922: aload_0
    //   923: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   926: ifnonnull +54 -> 980
    //   929: aload_0
    //   930: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   933: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   936: astore 5
    //   938: aload_0
    //   939: new 783	bbms
    //   942: dup
    //   943: aload 5
    //   945: aload 5
    //   947: invokevirtual 787	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   950: ldc_w 788
    //   953: invokevirtual 794	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   956: invokespecial 797	bbms:<init>	(Landroid/content/Context;I)V
    //   959: putfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   962: aload_0
    //   963: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   966: ldc_w 798
    //   969: invokevirtual 800	bbms:c	(I)V
    //   972: aload_0
    //   973: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   976: aload_0
    //   977: invokevirtual 803	bbms:a	(Lbbmu;)V
    //   980: aload_0
    //   981: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   984: invokevirtual 806	bbms:isShowing	()Z
    //   987: ifne +10 -> 997
    //   990: aload_0
    //   991: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   994: invokevirtual 809	bbms:show	()V
    //   997: ldc_w 779
    //   1000: aload 4
    //   1002: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1005: ifeq +38 -> 1043
    //   1008: new 811	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2
    //   1011: dup
    //   1012: aload_0
    //   1013: aload_2
    //   1014: aload_1
    //   1015: ldc_w 813
    //   1018: iconst_0
    //   1019: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1022: aload_3
    //   1023: invokespecial 816	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   1026: iconst_5
    //   1027: aconst_null
    //   1028: iconst_1
    //   1029: invokestatic 822	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1032: goto +965 -> 1997
    //   1035: astore_1
    //   1036: aload_1
    //   1037: invokevirtual 479	org/json/JSONException:printStackTrace	()V
    //   1040: goto +957 -> 1997
    //   1043: new 824	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread
    //   1046: dup
    //   1047: aload_0
    //   1048: aload_2
    //   1049: aload_1
    //   1050: ldc_w 826
    //   1053: sipush 1280
    //   1056: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1059: aload_1
    //   1060: ldc_w 828
    //   1063: sipush 1280
    //   1066: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1069: aload_1
    //   1070: ldc_w 830
    //   1073: iconst_1
    //   1074: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1077: aload_1
    //   1078: ldc_w 832
    //   1081: iconst_1
    //   1082: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1085: aload_3
    //   1086: invokespecial 835	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIIILjava/lang/String;)V
    //   1089: iconst_5
    //   1090: aconst_null
    //   1091: iconst_1
    //   1092: invokestatic 822	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1095: goto +902 -> 1997
    //   1098: ldc_w 837
    //   1101: aload 4
    //   1103: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1106: ifeq +474 -> 1580
    //   1109: aload 5
    //   1111: arraylength
    //   1112: iconst_1
    //   1113: if_icmpne +467 -> 1580
    //   1116: aconst_null
    //   1117: astore_2
    //   1118: new 839	java/util/concurrent/atomic/AtomicBoolean
    //   1121: dup
    //   1122: iconst_0
    //   1123: invokespecial 842	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   1126: astore_3
    //   1127: aload_2
    //   1128: astore_1
    //   1129: new 61	org/json/JSONObject
    //   1132: dup
    //   1133: aload 5
    //   1135: iconst_0
    //   1136: aaload
    //   1137: invokespecial 676	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1140: astore 4
    //   1142: aload_2
    //   1143: astore_1
    //   1144: aload 4
    //   1146: ldc_w 680
    //   1149: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1152: astore_2
    //   1153: aload_2
    //   1154: astore_1
    //   1155: aload 4
    //   1157: ldc_w 844
    //   1160: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1163: astore 5
    //   1165: aload_2
    //   1166: astore_1
    //   1167: aload 5
    //   1169: invokestatic 690	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1172: ifne +182 -> 1354
    //   1175: aload_2
    //   1176: astore_1
    //   1177: new 64	java/io/File
    //   1180: dup
    //   1181: aload 5
    //   1183: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   1186: invokevirtual 449	java/io/File:exists	()Z
    //   1189: ifne +33 -> 1222
    //   1192: aload_2
    //   1193: astore_1
    //   1194: aload_0
    //   1195: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   1198: invokevirtual 527	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   1201: invokevirtual 848	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1204: iconst_1
    //   1205: ldc_w 849
    //   1208: invokestatic 854	ajjy:a	(I)Ljava/lang/String;
    //   1211: iconst_0
    //   1212: invokestatic 857	bbmy:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbbmy;
    //   1215: invokevirtual 743	bbmy:a	()Landroid/widget/Toast;
    //   1218: pop
    //   1219: goto +786 -> 2005
    //   1222: aload_2
    //   1223: astore_1
    //   1224: new 859	com/tencent/mobileqq/jsp/MediaApiPlugin$4
    //   1227: dup
    //   1228: aload_0
    //   1229: aload 5
    //   1231: aload_2
    //   1232: aload_3
    //   1233: invokespecial 862	com/tencent/mobileqq/jsp/MediaApiPlugin$4:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1236: bipush 8
    //   1238: aconst_null
    //   1239: iconst_1
    //   1240: invokestatic 822	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1243: goto +762 -> 2005
    //   1246: astore_2
    //   1247: invokestatic 865	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1250: ifeq +30 -> 1280
    //   1253: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1256: iconst_4
    //   1257: new 103	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 867
    //   1267: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: aload_2
    //   1271: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1274: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1277: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1280: aload_1
    //   1281: invokestatic 690	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1284: ifne +713 -> 1997
    //   1287: aload_3
    //   1288: iconst_0
    //   1289: iconst_1
    //   1290: invokevirtual 874	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1293: ifeq +704 -> 1997
    //   1296: new 61	org/json/JSONObject
    //   1299: dup
    //   1300: invokespecial 62	org/json/JSONObject:<init>	()V
    //   1303: astore_2
    //   1304: aload_2
    //   1305: ldc_w 876
    //   1308: iconst_m1
    //   1309: invokevirtual 190	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1312: pop
    //   1313: aload_2
    //   1314: ldc_w 878
    //   1317: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1320: ldc_w 879
    //   1323: invokevirtual 882	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1326: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1329: pop
    //   1330: iload 8
    //   1332: ifeq +233 -> 1565
    //   1335: aload_0
    //   1336: aload_1
    //   1337: iconst_1
    //   1338: anewarray 145	java/lang/String
    //   1341: dup
    //   1342: iconst_0
    //   1343: aload_2
    //   1344: invokevirtual 616	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1347: aastore
    //   1348: invokevirtual 719	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1351: goto +646 -> 1997
    //   1354: aload_2
    //   1355: astore_1
    //   1356: aload 4
    //   1358: ldc_w 884
    //   1361: invokevirtual 886	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1364: astore 4
    //   1366: aload_2
    //   1367: astore_1
    //   1368: aload 4
    //   1370: ldc_w 888
    //   1373: invokevirtual 891	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1376: ifne +16 -> 1392
    //   1379: aload_2
    //   1380: astore_1
    //   1381: aload 4
    //   1383: ldc_w 893
    //   1386: invokevirtual 891	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1389: ifeq +152 -> 1541
    //   1392: aload_2
    //   1393: astore_1
    //   1394: aload_0
    //   1395: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   1398: ifnonnull +62 -> 1460
    //   1401: aload_2
    //   1402: astore_1
    //   1403: aload_0
    //   1404: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   1407: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   1410: astore 5
    //   1412: aload_2
    //   1413: astore_1
    //   1414: aload_0
    //   1415: new 783	bbms
    //   1418: dup
    //   1419: aload 5
    //   1421: aload 5
    //   1423: invokevirtual 787	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1426: ldc_w 788
    //   1429: invokevirtual 794	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1432: invokespecial 797	bbms:<init>	(Landroid/content/Context;I)V
    //   1435: putfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   1438: aload_2
    //   1439: astore_1
    //   1440: aload_0
    //   1441: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   1444: ldc_w 798
    //   1447: invokevirtual 800	bbms:c	(I)V
    //   1450: aload_2
    //   1451: astore_1
    //   1452: aload_0
    //   1453: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   1456: aload_0
    //   1457: invokevirtual 803	bbms:a	(Lbbmu;)V
    //   1460: aload_2
    //   1461: astore_1
    //   1462: aload_0
    //   1463: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   1466: invokevirtual 806	bbms:isShowing	()Z
    //   1469: ifne +12 -> 1481
    //   1472: aload_2
    //   1473: astore_1
    //   1474: aload_0
    //   1475: getfield 781	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_Bbms	Lbbms;
    //   1478: invokevirtual 809	bbms:show	()V
    //   1481: aload_2
    //   1482: astore_1
    //   1483: new 895	com/tencent/mobileqq/jsp/MediaApiPlugin$5
    //   1486: dup
    //   1487: aload_0
    //   1488: aload 4
    //   1490: aload_2
    //   1491: aload_3
    //   1492: invokespecial 896	com/tencent/mobileqq/jsp/MediaApiPlugin$5:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1495: iconst_5
    //   1496: aconst_null
    //   1497: iconst_1
    //   1498: invokestatic 822	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1501: goto +496 -> 1997
    //   1504: astore_1
    //   1505: invokestatic 865	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1508: ifeq +489 -> 1997
    //   1511: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1514: iconst_4
    //   1515: new 103	java/lang/StringBuilder
    //   1518: dup
    //   1519: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1522: ldc_w 867
    //   1525: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: aload_1
    //   1529: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1532: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1535: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1538: goto +459 -> 1997
    //   1541: aload_2
    //   1542: astore_1
    //   1543: invokestatic 900	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1546: new 902	com/tencent/mobileqq/jsp/MediaApiPlugin$6
    //   1549: dup
    //   1550: aload_0
    //   1551: aload 4
    //   1553: aload_2
    //   1554: aload_3
    //   1555: invokespecial 903	com/tencent/mobileqq/jsp/MediaApiPlugin$6:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1558: invokevirtual 908	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1561: pop
    //   1562: goto +435 -> 1997
    //   1565: aload_0
    //   1566: ldc_w 837
    //   1569: iconst_0
    //   1570: aload_2
    //   1571: invokevirtual 616	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1574: invokevirtual 713	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   1577: goto +420 -> 1997
    //   1580: ldc_w 910
    //   1583: aload 4
    //   1585: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1588: ifeq +120 -> 1708
    //   1591: aload 5
    //   1593: arraylength
    //   1594: iconst_1
    //   1595: if_icmpne +113 -> 1708
    //   1598: new 61	org/json/JSONObject
    //   1601: dup
    //   1602: aload 5
    //   1604: iconst_0
    //   1605: aaload
    //   1606: invokespecial 676	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1609: astore_1
    //   1610: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1613: ifeq +30 -> 1643
    //   1616: ldc_w 912
    //   1619: iconst_2
    //   1620: new 103	java/lang/StringBuilder
    //   1623: dup
    //   1624: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1627: ldc_w 914
    //   1630: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: aload_1
    //   1634: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1637: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1640: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1643: aload_1
    //   1644: ldc_w 916
    //   1647: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1650: astore_2
    //   1651: aload_1
    //   1652: ldc_w 918
    //   1655: invokevirtual 921	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1658: lstore 11
    //   1660: aload_1
    //   1661: ldc_w 923
    //   1664: invokevirtual 921	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1667: lstore 13
    //   1669: aload_0
    //   1670: getfield 372	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lbbac;
    //   1673: invokevirtual 377	bbac:a	()Landroid/app/Activity;
    //   1676: aload_2
    //   1677: lload 11
    //   1679: lload 13
    //   1681: invokestatic 925	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Landroid/content/Context;Ljava/lang/String;JJ)V
    //   1684: goto +313 -> 1997
    //   1687: astore_1
    //   1688: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1691: ifeq +306 -> 1997
    //   1694: ldc_w 912
    //   1697: iconst_2
    //   1698: ldc_w 927
    //   1701: aload_1
    //   1702: invokestatic 930	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1705: goto +292 -> 1997
    //   1708: ldc_w 932
    //   1711: aload 4
    //   1713: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1716: ifeq +173 -> 1889
    //   1719: aload 5
    //   1721: arraylength
    //   1722: iconst_1
    //   1723: if_icmplt +166 -> 1889
    //   1726: new 61	org/json/JSONObject
    //   1729: dup
    //   1730: aload 5
    //   1732: iconst_0
    //   1733: aaload
    //   1734: invokespecial 676	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1737: astore_1
    //   1738: aload_1
    //   1739: ldc_w 680
    //   1742: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1745: astore_2
    //   1746: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1749: astore_3
    //   1750: aload_0
    //   1751: new 286	android/content/Intent
    //   1754: dup
    //   1755: aload_3
    //   1756: ldc_w 934
    //   1759: invokespecial 291	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1762: iconst_5
    //   1763: invokevirtual 762	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1766: aload_3
    //   1767: invokestatic 38	com/tencent/mobileqq/jsp/MediaApiPlugin:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   1770: invokeinterface 613 1 0
    //   1775: ldc_w 615
    //   1778: aload_1
    //   1779: invokevirtual 616	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1782: invokeinterface 622 3 0
    //   1787: ldc_w 624
    //   1790: iload 8
    //   1792: invokeinterface 628 3 0
    //   1797: invokeinterface 631 1 0
    //   1802: pop
    //   1803: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1806: ifeq +191 -> 1997
    //   1809: ldc_w 912
    //   1812: iconst_2
    //   1813: new 103	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1820: ldc_w 936
    //   1823: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: aload 5
    //   1828: iconst_0
    //   1829: aaload
    //   1830: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: ldc_w 938
    //   1836: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: aload_2
    //   1840: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1846: invokestatic 940	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1849: goto +148 -> 1997
    //   1852: astore_1
    //   1853: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1856: ifeq +141 -> 1997
    //   1859: ldc_w 912
    //   1862: iconst_2
    //   1863: new 103	java/lang/StringBuilder
    //   1866: dup
    //   1867: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1870: ldc_w 942
    //   1873: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: aload_1
    //   1877: invokevirtual 870	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1880: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1883: invokestatic 940	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1886: goto +111 -> 1997
    //   1889: ldc_w 944
    //   1892: aload 4
    //   1894: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1897: ifeq +100 -> 1997
    //   1900: new 61	org/json/JSONObject
    //   1903: dup
    //   1904: aload 5
    //   1906: iconst_0
    //   1907: aaload
    //   1908: invokespecial 676	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1911: ldc_w 680
    //   1914: invokevirtual 684	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1917: astore_1
    //   1918: aload_1
    //   1919: invokestatic 690	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1922: ifne +75 -> 1997
    //   1925: new 61	org/json/JSONObject
    //   1928: dup
    //   1929: invokespecial 62	org/json/JSONObject:<init>	()V
    //   1932: astore_2
    //   1933: aload_2
    //   1934: ldc_w 946
    //   1937: aload_0
    //   1938: invokespecial 948	com/tencent/mobileqq/jsp/MediaApiPlugin:a	()Z
    //   1941: invokevirtual 951	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   1944: pop
    //   1945: aload_0
    //   1946: aload_1
    //   1947: iconst_1
    //   1948: anewarray 145	java/lang/String
    //   1951: dup
    //   1952: iconst_0
    //   1953: aload_2
    //   1954: invokevirtual 616	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1957: aastore
    //   1958: invokevirtual 719	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1961: goto +36 -> 1997
    //   1964: astore_1
    //   1965: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1968: ifeq +29 -> 1997
    //   1971: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1974: iconst_2
    //   1975: ldc_w 953
    //   1978: aload_1
    //   1979: invokestatic 930	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1982: goto +15 -> 1997
    //   1985: iconst_0
    //   1986: ireturn
    //   1987: astore_3
    //   1988: goto -658 -> 1330
    //   1991: iconst_0
    //   1992: istore 8
    //   1994: goto -1971 -> 23
    //   1997: iconst_1
    //   1998: ireturn
    //   1999: iconst_1
    //   2000: ireturn
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
    //   111	690	6	i	int
    //   186	613	7	j	int
    //   21	1972	8	bool1	boolean
    //   134	9	9	bool2	boolean
    //   140	8	10	bool3	boolean
    //   1658	20	11	l1	long
    //   1667	13	13	l2	long
    // Exception table:
    //   from	to	target	type
    //   152	162	312	java/lang/Throwable
    //   162	185	312	java/lang/Throwable
    //   188	199	312	java/lang/Throwable
    //   203	211	312	java/lang/Throwable
    //   215	225	312	java/lang/Throwable
    //   228	255	312	java/lang/Throwable
    //   260	267	312	java/lang/Throwable
    //   275	285	312	java/lang/Throwable
    //   288	309	312	java/lang/Throwable
    //   59	96	327	org/json/JSONException
    //   103	117	327	org/json/JSONException
    //   122	142	327	org/json/JSONException
    //   152	162	327	org/json/JSONException
    //   162	185	327	org/json/JSONException
    //   188	199	327	org/json/JSONException
    //   203	211	327	org/json/JSONException
    //   215	225	327	org/json/JSONException
    //   228	255	327	org/json/JSONException
    //   260	267	327	org/json/JSONException
    //   275	285	327	org/json/JSONException
    //   288	309	327	org/json/JSONException
    //   313	324	327	org/json/JSONException
    //   341	350	327	org/json/JSONException
    //   352	411	327	org/json/JSONException
    //   416	426	327	org/json/JSONException
    //   429	450	327	org/json/JSONException
    //   453	535	327	org/json/JSONException
    //   538	580	327	org/json/JSONException
    //   584	592	327	org/json/JSONException
    //   596	640	327	org/json/JSONException
    //   648	701	327	org/json/JSONException
    //   705	729	327	org/json/JSONException
    //   736	743	327	org/json/JSONException
    //   747	757	327	org/json/JSONException
    //   761	786	327	org/json/JSONException
    //   790	798	327	org/json/JSONException
    //   802	846	327	org/json/JSONException
    //   648	701	704	java/lang/Exception
    //   878	919	1035	org/json/JSONException
    //   922	980	1035	org/json/JSONException
    //   980	997	1035	org/json/JSONException
    //   997	1032	1035	org/json/JSONException
    //   1043	1095	1035	org/json/JSONException
    //   1129	1142	1246	java/lang/OutOfMemoryError
    //   1144	1153	1246	java/lang/OutOfMemoryError
    //   1155	1165	1246	java/lang/OutOfMemoryError
    //   1167	1175	1246	java/lang/OutOfMemoryError
    //   1177	1192	1246	java/lang/OutOfMemoryError
    //   1194	1219	1246	java/lang/OutOfMemoryError
    //   1224	1243	1246	java/lang/OutOfMemoryError
    //   1356	1366	1246	java/lang/OutOfMemoryError
    //   1368	1379	1246	java/lang/OutOfMemoryError
    //   1381	1392	1246	java/lang/OutOfMemoryError
    //   1394	1401	1246	java/lang/OutOfMemoryError
    //   1403	1412	1246	java/lang/OutOfMemoryError
    //   1414	1438	1246	java/lang/OutOfMemoryError
    //   1440	1450	1246	java/lang/OutOfMemoryError
    //   1452	1460	1246	java/lang/OutOfMemoryError
    //   1462	1472	1246	java/lang/OutOfMemoryError
    //   1474	1481	1246	java/lang/OutOfMemoryError
    //   1483	1501	1246	java/lang/OutOfMemoryError
    //   1543	1562	1246	java/lang/OutOfMemoryError
    //   1129	1142	1504	org/json/JSONException
    //   1144	1153	1504	org/json/JSONException
    //   1155	1165	1504	org/json/JSONException
    //   1167	1175	1504	org/json/JSONException
    //   1177	1192	1504	org/json/JSONException
    //   1194	1219	1504	org/json/JSONException
    //   1224	1243	1504	org/json/JSONException
    //   1356	1366	1504	org/json/JSONException
    //   1368	1379	1504	org/json/JSONException
    //   1381	1392	1504	org/json/JSONException
    //   1394	1401	1504	org/json/JSONException
    //   1403	1412	1504	org/json/JSONException
    //   1414	1438	1504	org/json/JSONException
    //   1440	1450	1504	org/json/JSONException
    //   1452	1460	1504	org/json/JSONException
    //   1462	1472	1504	org/json/JSONException
    //   1474	1481	1504	org/json/JSONException
    //   1483	1501	1504	org/json/JSONException
    //   1543	1562	1504	org/json/JSONException
    //   1598	1643	1687	java/lang/Exception
    //   1643	1684	1687	java/lang/Exception
    //   1726	1849	1852	java/lang/Exception
    //   1900	1961	1964	java/lang/Exception
    //   1304	1330	1987	org/json/JSONException
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
                ageu.a((Activity)a(), (Intent)localObject2, paramIntent[0], 103);
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
          if (this.jdField_a_of_type_Bbms == null)
          {
            localObject1 = this.mRuntime.a();
            this.jdField_a_of_type_Bbms = new bbms((Context)localObject1, ((Activity)localObject1).getResources().getDimensionPixelSize(2131167766));
            this.jdField_a_of_type_Bbms.c(2131628457);
            this.jdField_a_of_type_Bbms.a(this);
          }
          if (this.jdField_a_of_type_JavaLangThread != null) {
            this.jdField_a_of_type_JavaLangThread.interrupt();
          }
          if (!this.jdField_a_of_type_Bbms.isShowing()) {
            this.jdField_a_of_type_Bbms.show();
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
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
    if (this.jdField_a_of_type_Wis != null) {
      this.jdField_a_of_type_Wis.b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin
 * JD-Core Version:    0.7.0.1
 */