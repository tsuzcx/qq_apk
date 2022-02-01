package cooperation.troop_homework;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.VideoConverterLog;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.utils.HomeworkURLUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopHomeworkHelper
{
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    boolean bool = ShortVideoTrimmer.initVideoTrim(paramContext);
    int i = -1;
    int j;
    if (bool)
    {
      VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(paramString1);
      if ((localVideoConverterConfig != null) && (localVideoConverterConfig.isNeedCompress))
      {
        j = i;
        if (Build.VERSION.SDK_INT >= 18)
        {
          Object localObject = new TroopHomeworkHelper.HWCompressProcessor(paramString2, (int)(localVideoConverterConfig.srcBitrate * 1024L), (int)localVideoConverterConfig.srcFrameRate);
          VideoConverter localVideoConverter = new VideoConverter(new VideoConverterLog());
          localVideoConverter.setCompressMode(1);
          j = localVideoConverter.startCompress(paramContext, paramString1, (VideoConverter.Processor)localObject, true);
          if (j == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: compress completed using MediaCodec");
            }
            j = 0;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("CompressTask, step: compress failed using MediaCodec, compressRet:");
            ((StringBuilder)localObject).append(j);
            QLog.d("TroopHomeworkHelper", 2, ((StringBuilder)localObject).toString());
            j = i;
          }
        }
        i = j;
        if (j != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
          }
          i = ShortVideoTrimmer.compressVideo(paramContext, paramString1, paramString2, localVideoConverterConfig);
          if (i == 0)
          {
            QLog.d("TroopHomeworkHelper", 1, "CompressTask, step:compress completed using ShortVideoTrimmer.compressVideo");
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append("CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = ");
            paramContext.append(i);
            QLog.d("TroopHomeworkHelper", 1, paramContext.toString());
          }
        }
      }
      else
      {
        i = 1;
      }
      long l2 = System.currentTimeMillis();
      long l3 = new File(paramString1).length();
      long l4 = new File(paramString2).length();
      j = i;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("CompressTask，step: ShortVideoTrimmer compress ret = ");
        paramContext.append(i);
        paramContext.append(", cost:");
        paramContext.append(l2 - l1);
        paramContext.append("ms, fileSourceSize=");
        paramContext.append(l3);
        paramContext.append(", fileTargetSize=");
        paramContext.append(l4);
        QLog.d("TroopHomeworkHelper", 2, paramContext.toString());
        return i;
      }
    }
    else
    {
      QLog.e("TroopHomeworkHelper", 2, "CompressTask，step: ShortVideoTrimmer init failure, ignore compress");
      j = i;
    }
    return j;
  }
  
  /* Error */
  public static int a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 142
    //   3: invokevirtual 148	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc 150
    //   12: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 4
    //   17: aload 5
    //   19: ldc 156
    //   21: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_0
    //   25: aload 5
    //   27: ldc 158
    //   29: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aconst_null
    //   35: astore 7
    //   37: aconst_null
    //   38: astore 5
    //   40: aconst_null
    //   41: astore 6
    //   43: new 160	java/net/URL
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 161	java/net/URL:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 165	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   55: checkcast 167	java/net/HttpURLConnection
    //   58: astore 4
    //   60: aload 4
    //   62: sipush 30000
    //   65: invokevirtual 170	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload 4
    //   70: sipush 30000
    //   73: invokevirtual 173	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   76: aload 4
    //   78: iconst_1
    //   79: invokevirtual 177	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   82: aload 4
    //   84: iconst_1
    //   85: invokevirtual 180	java/net/HttpURLConnection:setDoInput	(Z)V
    //   88: aload 4
    //   90: iconst_0
    //   91: invokevirtual 183	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   94: aload 4
    //   96: ldc 185
    //   98: invokevirtual 188	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   101: aload 4
    //   103: ldc 190
    //   105: ldc 192
    //   107: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 4
    //   112: ldc 198
    //   114: aload_0
    //   115: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 4
    //   120: ldc 200
    //   122: aload 8
    //   124: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 4
    //   129: ldc 202
    //   131: ldc 204
    //   133: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 4
    //   138: ldc 206
    //   140: aload_2
    //   141: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: new 208	java/io/DataOutputStream
    //   147: dup
    //   148: aload 4
    //   150: invokevirtual 212	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   153: invokespecial 215	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   156: astore_0
    //   157: new 111	java/io/File
    //   160: dup
    //   161: aload_1
    //   162: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore_1
    //   166: new 217	java/io/BufferedInputStream
    //   169: dup
    //   170: new 217	java/io/BufferedInputStream
    //   173: dup
    //   174: new 219	java/io/FileInputStream
    //   177: dup
    //   178: aload_1
    //   179: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   182: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   185: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   188: astore 8
    //   190: sipush 3072
    //   193: newarray byte
    //   195: astore_2
    //   196: aload 8
    //   198: aload_2
    //   199: invokevirtual 229	java/io/BufferedInputStream:read	([B)I
    //   202: istore_3
    //   203: iload_3
    //   204: iconst_m1
    //   205: if_icmpeq +13 -> 218
    //   208: aload_0
    //   209: aload_2
    //   210: iconst_0
    //   211: iload_3
    //   212: invokevirtual 233	java/io/DataOutputStream:write	([BII)V
    //   215: goto -19 -> 196
    //   218: aload 8
    //   220: invokevirtual 236	java/io/BufferedInputStream:close	()V
    //   223: new 238	java/lang/StringBuffer
    //   226: dup
    //   227: invokespecial 239	java/lang/StringBuffer:<init>	()V
    //   230: astore_1
    //   231: new 241	java/io/BufferedReader
    //   234: dup
    //   235: new 243	java/io/InputStreamReader
    //   238: dup
    //   239: aload 4
    //   241: invokevirtual 247	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   244: invokespecial 248	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   247: invokespecial 251	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   250: astore_2
    //   251: aload_2
    //   252: invokevirtual 254	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   255: astore 5
    //   257: aload 5
    //   259: ifnull +21 -> 280
    //   262: aload_1
    //   263: aload 5
    //   265: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   268: pop
    //   269: aload_1
    //   270: ldc_w 259
    //   273: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   276: pop
    //   277: goto -26 -> 251
    //   280: aload_1
    //   281: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   284: pop
    //   285: aload_2
    //   286: invokevirtual 261	java/io/BufferedReader:close	()V
    //   289: aload 4
    //   291: ifnull +8 -> 299
    //   294: aload 4
    //   296: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_0
    //   300: invokevirtual 265	java/io/DataOutputStream:close	()V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore_1
    //   306: goto +102 -> 408
    //   309: new 85	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   316: astore_2
    //   317: aload_2
    //   318: ldc_w 267
    //   321: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_2
    //   326: aload_1
    //   327: invokevirtual 117	java/io/File:length	()J
    //   330: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: ldc_w 269
    //   338: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_2
    //   343: aload_1
    //   344: invokevirtual 272	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   347: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: ldc 77
    //   353: iconst_2
    //   354: aload_2
    //   355: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: invokevirtual 275	java/io/DataOutputStream:flush	()V
    //   365: aload_0
    //   366: invokevirtual 265	java/io/DataOutputStream:close	()V
    //   369: aload 4
    //   371: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   374: aload 5
    //   376: astore_2
    //   377: aload_0
    //   378: astore_1
    //   379: aload 8
    //   381: invokevirtual 236	java/io/BufferedInputStream:close	()V
    //   384: aload_0
    //   385: invokevirtual 265	java/io/DataOutputStream:close	()V
    //   388: iconst_m1
    //   389: ireturn
    //   390: astore 5
    //   392: aload 6
    //   394: astore 4
    //   396: goto +72 -> 468
    //   399: astore 5
    //   401: aload 7
    //   403: astore 4
    //   405: goto +118 -> 523
    //   408: aload 8
    //   410: invokevirtual 236	java/io/BufferedInputStream:close	()V
    //   413: aload_1
    //   414: athrow
    //   415: astore_2
    //   416: goto +161 -> 577
    //   419: astore_1
    //   420: goto +16 -> 436
    //   423: astore_1
    //   424: goto +21 -> 445
    //   427: astore_2
    //   428: aconst_null
    //   429: astore_0
    //   430: goto +147 -> 577
    //   433: astore_1
    //   434: aconst_null
    //   435: astore_0
    //   436: aload_1
    //   437: astore 5
    //   439: goto +29 -> 468
    //   442: astore_1
    //   443: aconst_null
    //   444: astore_0
    //   445: aload_1
    //   446: astore 5
    //   448: goto +75 -> 523
    //   451: astore_2
    //   452: aconst_null
    //   453: astore_0
    //   454: aload_0
    //   455: astore 4
    //   457: goto +120 -> 577
    //   460: astore 5
    //   462: aconst_null
    //   463: astore_0
    //   464: aload 6
    //   466: astore 4
    //   468: aload 4
    //   470: astore_2
    //   471: aload_0
    //   472: astore_1
    //   473: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +19 -> 495
    //   479: aload 4
    //   481: astore_2
    //   482: aload_0
    //   483: astore_1
    //   484: ldc 77
    //   486: iconst_2
    //   487: ldc_w 277
    //   490: aload 5
    //   492: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   495: aload 4
    //   497: ifnull +8 -> 505
    //   500: aload 4
    //   502: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   505: aload_0
    //   506: ifnull +61 -> 567
    //   509: aload_0
    //   510: invokevirtual 265	java/io/DataOutputStream:close	()V
    //   513: iconst_m1
    //   514: ireturn
    //   515: astore 5
    //   517: aconst_null
    //   518: astore_0
    //   519: aload 7
    //   521: astore 4
    //   523: aload 4
    //   525: astore_2
    //   526: aload_0
    //   527: astore_1
    //   528: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +19 -> 550
    //   534: aload 4
    //   536: astore_2
    //   537: aload_0
    //   538: astore_1
    //   539: ldc 77
    //   541: iconst_2
    //   542: ldc_w 277
    //   545: aload 5
    //   547: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   550: aload 4
    //   552: ifnull +8 -> 560
    //   555: aload 4
    //   557: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   560: aload_0
    //   561: ifnull +6 -> 567
    //   564: goto -55 -> 509
    //   567: iconst_m1
    //   568: ireturn
    //   569: astore_0
    //   570: aload_2
    //   571: astore 4
    //   573: aload_0
    //   574: astore_2
    //   575: aload_1
    //   576: astore_0
    //   577: aload 4
    //   579: ifnull +8 -> 587
    //   582: aload 4
    //   584: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   587: aload_0
    //   588: ifnull +7 -> 595
    //   591: aload_0
    //   592: invokevirtual 265	java/io/DataOutputStream:close	()V
    //   595: goto +5 -> 600
    //   598: aload_2
    //   599: athrow
    //   600: goto -2 -> 598
    //   603: astore_2
    //   604: goto -295 -> 309
    //   607: astore_0
    //   608: goto -305 -> 303
    //   611: astore_0
    //   612: iconst_m1
    //   613: ireturn
    //   614: astore_0
    //   615: iconst_m1
    //   616: ireturn
    //   617: astore_0
    //   618: goto -23 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	paramJSONObject	JSONObject
    //   0	621	1	paramString1	String
    //   0	621	2	paramString2	String
    //   202	10	3	i	int
    //   15	568	4	localObject1	Object
    //   6	369	5	localObject2	Object
    //   390	1	5	localOutOfMemoryError1	OutOfMemoryError
    //   399	1	5	localException1	java.lang.Exception
    //   437	10	5	str	String
    //   460	31	5	localOutOfMemoryError2	OutOfMemoryError
    //   515	31	5	localException2	java.lang.Exception
    //   41	424	6	localObject3	Object
    //   35	485	7	localObject4	Object
    //   32	377	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   196	203	305	finally
    //   208	215	305	finally
    //   309	374	305	finally
    //   379	384	390	java/lang/OutOfMemoryError
    //   379	384	399	java/lang/Exception
    //   157	196	415	finally
    //   218	251	415	finally
    //   251	257	415	finally
    //   262	277	415	finally
    //   280	289	415	finally
    //   408	415	415	finally
    //   157	196	419	java/lang/OutOfMemoryError
    //   218	251	419	java/lang/OutOfMemoryError
    //   251	257	419	java/lang/OutOfMemoryError
    //   262	277	419	java/lang/OutOfMemoryError
    //   280	289	419	java/lang/OutOfMemoryError
    //   408	415	419	java/lang/OutOfMemoryError
    //   157	196	423	java/lang/Exception
    //   218	251	423	java/lang/Exception
    //   251	257	423	java/lang/Exception
    //   262	277	423	java/lang/Exception
    //   280	289	423	java/lang/Exception
    //   408	415	423	java/lang/Exception
    //   60	157	427	finally
    //   60	157	433	java/lang/OutOfMemoryError
    //   60	157	442	java/lang/Exception
    //   43	60	451	finally
    //   43	60	460	java/lang/OutOfMemoryError
    //   43	60	515	java/lang/Exception
    //   379	384	569	finally
    //   473	479	569	finally
    //   484	495	569	finally
    //   528	534	569	finally
    //   539	550	569	finally
    //   196	203	603	java/lang/OutOfMemoryError
    //   208	215	603	java/lang/OutOfMemoryError
    //   299	303	607	java/io/IOException
    //   384	388	611	java/io/IOException
    //   509	513	614	java/io/IOException
    //   591	595	617	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 283	cooperation/troop_homework/TroopHomeworkHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 8
    //   6: new 111	java/io/File
    //   9: dup
    //   10: aload 8
    //   12: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: invokevirtual 286	java/io/File:exists	()Z
    //   22: istore_2
    //   23: aconst_null
    //   24: astore 6
    //   26: iload_2
    //   27: ifne +37 -> 64
    //   30: aload 5
    //   32: invokevirtual 290	java/io/File:getParentFile	()Ljava/io/File;
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 286	java/io/File:exists	()Z
    //   40: ifne +8 -> 48
    //   43: aload_3
    //   44: invokevirtual 293	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload 5
    //   50: invokevirtual 296	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: goto +10 -> 64
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 299	java/io/IOException:printStackTrace	()V
    //   62: aconst_null
    //   63: areturn
    //   64: new 160	java/net/URL
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 161	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: invokevirtual 165	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   75: checkcast 167	java/net/HttpURLConnection
    //   78: astore_3
    //   79: aload_3
    //   80: sipush 5000
    //   83: invokevirtual 170	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   86: aload_3
    //   87: sipush 30000
    //   90: invokevirtual 173	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   93: aload_3
    //   94: ldc_w 301
    //   97: invokevirtual 188	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   100: aload_3
    //   101: ldc 190
    //   103: ldc 192
    //   105: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_3
    //   109: invokevirtual 247	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   112: astore 4
    //   114: new 303	java/io/FileOutputStream
    //   117: dup
    //   118: aload 5
    //   120: iconst_1
    //   121: invokespecial 306	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   124: astore 9
    //   126: aload_3
    //   127: astore 5
    //   129: aload 4
    //   131: astore 6
    //   133: aload 9
    //   135: astore 7
    //   137: sipush 1024
    //   140: newarray byte
    //   142: astore 10
    //   144: aload_3
    //   145: astore 5
    //   147: aload 4
    //   149: astore 6
    //   151: aload 9
    //   153: astore 7
    //   155: aload 4
    //   157: aload 10
    //   159: invokevirtual 309	java/io/InputStream:read	([B)I
    //   162: istore_1
    //   163: iload_1
    //   164: iconst_m1
    //   165: if_icmpeq +26 -> 191
    //   168: aload_3
    //   169: astore 5
    //   171: aload 4
    //   173: astore 6
    //   175: aload 9
    //   177: astore 7
    //   179: aload 9
    //   181: aload 10
    //   183: iconst_0
    //   184: iload_1
    //   185: invokevirtual 310	java/io/FileOutputStream:write	([BII)V
    //   188: goto -44 -> 144
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   199: aload 4
    //   201: ifnull +8 -> 209
    //   204: aload 4
    //   206: invokevirtual 311	java/io/InputStream:close	()V
    //   209: aload 9
    //   211: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   214: aload 8
    //   216: areturn
    //   217: astore 7
    //   219: aload_3
    //   220: astore 5
    //   222: aload 4
    //   224: astore_0
    //   225: aload 7
    //   227: astore_3
    //   228: goto +174 -> 402
    //   231: aconst_null
    //   232: astore 5
    //   234: aload_3
    //   235: astore 8
    //   237: aload 5
    //   239: astore_3
    //   240: goto +40 -> 280
    //   243: astore 4
    //   245: aconst_null
    //   246: astore_0
    //   247: aload_3
    //   248: astore 5
    //   250: aload 4
    //   252: astore_3
    //   253: goto +149 -> 402
    //   256: aload_3
    //   257: astore 8
    //   259: goto +16 -> 275
    //   262: astore_3
    //   263: aconst_null
    //   264: astore 5
    //   266: aload 5
    //   268: astore_0
    //   269: goto +133 -> 402
    //   272: aconst_null
    //   273: astore 8
    //   275: aconst_null
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_3
    //   280: aload 8
    //   282: astore 5
    //   284: aload 4
    //   286: astore 6
    //   288: aload_3
    //   289: astore 7
    //   291: new 85	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   298: astore 9
    //   300: aload 8
    //   302: astore 5
    //   304: aload 4
    //   306: astore 6
    //   308: aload_3
    //   309: astore 7
    //   311: aload 9
    //   313: ldc_w 314
    //   316: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 8
    //   322: astore 5
    //   324: aload 4
    //   326: astore 6
    //   328: aload_3
    //   329: astore 7
    //   331: aload 9
    //   333: aload_0
    //   334: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 8
    //   340: astore 5
    //   342: aload 4
    //   344: astore 6
    //   346: aload_3
    //   347: astore 7
    //   349: ldc_w 316
    //   352: iconst_2
    //   353: aload 9
    //   355: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload 8
    //   363: ifnull +8 -> 371
    //   366: aload 8
    //   368: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   371: aload 4
    //   373: ifnull +11 -> 384
    //   376: aload 4
    //   378: invokevirtual 311	java/io/InputStream:close	()V
    //   381: goto +3 -> 384
    //   384: aload_3
    //   385: ifnull +7 -> 392
    //   388: aload_3
    //   389: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   392: aconst_null
    //   393: areturn
    //   394: astore_3
    //   395: aload 6
    //   397: astore_0
    //   398: aload 7
    //   400: astore 6
    //   402: aload 5
    //   404: ifnull +8 -> 412
    //   407: aload 5
    //   409: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   412: aload_0
    //   413: ifnull +10 -> 423
    //   416: aload_0
    //   417: invokevirtual 311	java/io/InputStream:close	()V
    //   420: goto +3 -> 423
    //   423: aload 6
    //   425: ifnull +8 -> 433
    //   428: aload 6
    //   430: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   433: goto +5 -> 438
    //   436: aload_3
    //   437: athrow
    //   438: goto -2 -> 436
    //   441: astore_3
    //   442: goto -170 -> 272
    //   445: astore 4
    //   447: goto -191 -> 256
    //   450: astore 5
    //   452: goto -221 -> 231
    //   455: astore 5
    //   457: aload_3
    //   458: astore 8
    //   460: aload 9
    //   462: astore_3
    //   463: goto -183 -> 280
    //   466: astore_0
    //   467: goto -258 -> 209
    //   470: astore_0
    //   471: aload 8
    //   473: areturn
    //   474: astore_0
    //   475: goto -91 -> 384
    //   478: astore_0
    //   479: aconst_null
    //   480: areturn
    //   481: astore_0
    //   482: goto -59 -> 423
    //   485: astore_0
    //   486: goto -53 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramString	String
    //   162	23	1	i	int
    //   22	5	2	bool	boolean
    //   35	222	3	localObject1	Object
    //   262	1	3	localObject2	Object
    //   279	110	3	localObject3	Object
    //   394	43	3	localObject4	Object
    //   441	17	3	localException1	java.lang.Exception
    //   462	1	3	localObject5	Object
    //   112	111	4	localInputStream	java.io.InputStream
    //   243	8	4	localObject6	Object
    //   276	101	4	localObject7	Object
    //   445	1	4	localException2	java.lang.Exception
    //   15	393	5	localObject8	Object
    //   450	1	5	localException3	java.lang.Exception
    //   455	1	5	localException4	java.lang.Exception
    //   24	405	6	localObject9	Object
    //   135	43	7	localObject10	Object
    //   217	9	7	localObject11	Object
    //   289	110	7	localObject12	Object
    //   4	468	8	localObject13	Object
    //   124	337	9	localObject14	Object
    //   142	40	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   48	54	57	java/io/IOException
    //   114	126	217	finally
    //   79	114	243	finally
    //   64	79	262	finally
    //   137	144	394	finally
    //   155	163	394	finally
    //   179	188	394	finally
    //   291	300	394	finally
    //   311	320	394	finally
    //   331	338	394	finally
    //   349	361	394	finally
    //   64	79	441	java/lang/Exception
    //   79	114	445	java/lang/Exception
    //   114	126	450	java/lang/Exception
    //   137	144	455	java/lang/Exception
    //   155	163	455	java/lang/Exception
    //   179	188	455	java/lang/Exception
    //   204	209	466	java/io/IOException
    //   209	214	470	java/io/IOException
    //   376	381	474	java/io/IOException
    //   388	392	478	java/io/IOException
    //   416	420	481	java/io/IOException
    //   428	433	485	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 13
    //   6: new 160	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 161	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 165	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 167	java/net/HttpURLConnection
    //   20: astore 7
    //   22: aload 7
    //   24: sipush 5000
    //   27: invokevirtual 170	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   30: aload 7
    //   32: sipush 30000
    //   35: invokevirtual 173	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   38: aload 7
    //   40: iconst_1
    //   41: invokevirtual 177	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   44: aload 7
    //   46: iconst_1
    //   47: invokevirtual 180	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload 7
    //   52: iconst_0
    //   53: invokevirtual 183	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   56: aload 7
    //   58: ldc_w 319
    //   61: invokevirtual 188	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   64: aload 7
    //   66: ldc 190
    //   68: ldc 192
    //   70: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: new 85	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   80: astore 8
    //   82: aload 8
    //   84: ldc_w 321
    //   87: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 8
    //   93: ldc_w 323
    //   96: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 7
    //   102: ldc 202
    //   104: aload 8
    //   106: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: new 85	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   119: astore 8
    //   121: aload 8
    //   123: ldc_w 325
    //   126: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 8
    //   132: aload_2
    //   133: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 8
    //   139: ldc_w 327
    //   142: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 8
    //   148: aload_3
    //   149: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 7
    //   155: ldc_w 329
    //   158: aload 8
    //   160: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 196	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: new 208	java/io/DataOutputStream
    //   169: dup
    //   170: aload 7
    //   172: invokevirtual 212	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   175: invokespecial 215	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   178: astore_2
    //   179: new 238	java/lang/StringBuffer
    //   182: dup
    //   183: invokespecial 239	java/lang/StringBuffer:<init>	()V
    //   186: astore 14
    //   188: aload 14
    //   190: ldc_w 331
    //   193: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: aload 14
    //   199: ldc_w 333
    //   202: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   205: pop
    //   206: aload 14
    //   208: ldc_w 323
    //   211: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   214: pop
    //   215: aload 14
    //   217: ldc_w 331
    //   220: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   223: pop
    //   224: aload 14
    //   226: ldc_w 335
    //   229: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   232: pop
    //   233: new 85	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   240: astore_3
    //   241: aload_3
    //   242: ldc_w 337
    //   245: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_3
    //   250: lload 4
    //   252: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_3
    //   257: ldc_w 337
    //   260: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 14
    //   266: aload_3
    //   267: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   273: pop
    //   274: aload_2
    //   275: aload 14
    //   277: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   280: invokevirtual 343	java/lang/String:getBytes	()[B
    //   283: invokevirtual 348	java/io/OutputStream:write	([B)V
    //   286: aload 14
    //   288: iconst_0
    //   289: invokevirtual 351	java/lang/StringBuffer:setLength	(I)V
    //   292: aload 14
    //   294: ldc_w 331
    //   297: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   300: pop
    //   301: aload 14
    //   303: ldc_w 333
    //   306: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   309: pop
    //   310: aload 14
    //   312: ldc_w 323
    //   315: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   318: pop
    //   319: aload 14
    //   321: ldc_w 331
    //   324: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   327: pop
    //   328: new 85	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   335: astore_3
    //   336: aload_3
    //   337: ldc_w 353
    //   340: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_3
    //   345: aload_1
    //   346: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_3
    //   351: ldc_w 355
    //   354: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 14
    //   360: aload_3
    //   361: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   367: pop
    //   368: aload_1
    //   369: ldc_w 357
    //   372: invokevirtual 361	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   375: ifeq +659 -> 1034
    //   378: ldc_w 363
    //   381: astore_3
    //   382: goto +3 -> 385
    //   385: aload_3
    //   386: ifnull +653 -> 1039
    //   389: aload_3
    //   390: astore 8
    //   392: aload_3
    //   393: ldc_w 365
    //   396: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   399: ifeq +6 -> 405
    //   402: goto +637 -> 1039
    //   405: new 85	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   412: astore_3
    //   413: aload_3
    //   414: ldc_w 371
    //   417: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload_3
    //   422: aload 8
    //   424: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload_3
    //   429: ldc_w 373
    //   432: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 14
    //   438: aload_3
    //   439: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   445: pop
    //   446: aload_2
    //   447: aload 14
    //   449: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   452: invokevirtual 343	java/lang/String:getBytes	()[B
    //   455: invokevirtual 348	java/io/OutputStream:write	([B)V
    //   458: new 375	java/io/DataInputStream
    //   461: dup
    //   462: new 219	java/io/FileInputStream
    //   465: dup
    //   466: aload_1
    //   467: invokespecial 376	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   470: invokespecial 377	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   473: astore 8
    //   475: sipush 1024
    //   478: newarray byte
    //   480: astore_1
    //   481: aload 8
    //   483: aload_1
    //   484: invokevirtual 378	java/io/DataInputStream:read	([B)I
    //   487: istore 6
    //   489: iload 6
    //   491: iconst_m1
    //   492: if_icmpeq +14 -> 506
    //   495: aload_2
    //   496: aload_1
    //   497: iconst_0
    //   498: iload 6
    //   500: invokevirtual 379	java/io/OutputStream:write	([BII)V
    //   503: goto -22 -> 481
    //   506: new 85	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   513: astore_1
    //   514: aload_1
    //   515: ldc_w 381
    //   518: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_1
    //   523: ldc_w 323
    //   526: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_1
    //   531: ldc_w 383
    //   534: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_2
    //   539: aload_1
    //   540: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokevirtual 343	java/lang/String:getBytes	()[B
    //   546: invokevirtual 348	java/io/OutputStream:write	([B)V
    //   549: aload_2
    //   550: invokevirtual 384	java/io/OutputStream:flush	()V
    //   553: aload 14
    //   555: iconst_0
    //   556: invokevirtual 351	java/lang/StringBuffer:setLength	(I)V
    //   559: new 241	java/io/BufferedReader
    //   562: dup
    //   563: new 243	java/io/InputStreamReader
    //   566: dup
    //   567: aload 7
    //   569: invokevirtual 247	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   572: invokespecial 248	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   575: invokespecial 251	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   578: astore_1
    //   579: aload 7
    //   581: astore 9
    //   583: aload_1
    //   584: astore 10
    //   586: aload_2
    //   587: astore 11
    //   589: aload 8
    //   591: astore 12
    //   593: aload_1
    //   594: invokevirtual 254	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   597: astore_3
    //   598: aload_3
    //   599: ifnull +50 -> 649
    //   602: aload 7
    //   604: astore 9
    //   606: aload_1
    //   607: astore 10
    //   609: aload_2
    //   610: astore 11
    //   612: aload 8
    //   614: astore 12
    //   616: aload 14
    //   618: aload_3
    //   619: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   622: pop
    //   623: aload 7
    //   625: astore 9
    //   627: aload_1
    //   628: astore 10
    //   630: aload_2
    //   631: astore 11
    //   633: aload 8
    //   635: astore 12
    //   637: aload 14
    //   639: ldc_w 259
    //   642: invokevirtual 257	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   645: pop
    //   646: goto -67 -> 579
    //   649: aload 7
    //   651: astore 9
    //   653: aload_1
    //   654: astore 10
    //   656: aload_2
    //   657: astore 11
    //   659: aload 8
    //   661: astore 12
    //   663: aload 14
    //   665: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   668: astore_3
    //   669: aload 7
    //   671: ifnull +8 -> 679
    //   674: aload 7
    //   676: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   679: aload 8
    //   681: invokevirtual 385	java/io/DataInputStream:close	()V
    //   684: aload_2
    //   685: invokevirtual 386	java/io/OutputStream:close	()V
    //   688: aload_3
    //   689: astore_0
    //   690: aload_1
    //   691: invokevirtual 261	java/io/BufferedReader:close	()V
    //   694: aload_0
    //   695: areturn
    //   696: astore_0
    //   697: aconst_null
    //   698: astore_1
    //   699: goto +226 -> 925
    //   702: aconst_null
    //   703: astore_1
    //   704: aload_2
    //   705: astore_3
    //   706: aload 8
    //   708: astore_2
    //   709: goto +68 -> 777
    //   712: astore_0
    //   713: aconst_null
    //   714: astore_1
    //   715: aload 9
    //   717: astore_3
    //   718: goto +210 -> 928
    //   721: aconst_null
    //   722: astore_1
    //   723: aload_1
    //   724: astore 8
    //   726: aload_2
    //   727: astore_3
    //   728: aload 8
    //   730: astore_2
    //   731: goto +46 -> 777
    //   734: astore_0
    //   735: aconst_null
    //   736: astore_1
    //   737: aload_1
    //   738: astore_2
    //   739: aload 9
    //   741: astore_3
    //   742: goto +186 -> 928
    //   745: aconst_null
    //   746: astore_1
    //   747: aload_1
    //   748: astore_3
    //   749: aload_3
    //   750: astore_2
    //   751: goto +26 -> 777
    //   754: astore_0
    //   755: aconst_null
    //   756: astore_1
    //   757: aload_1
    //   758: astore_2
    //   759: aload_2
    //   760: astore 7
    //   762: aload 9
    //   764: astore_3
    //   765: goto +163 -> 928
    //   768: aconst_null
    //   769: astore_1
    //   770: aload_1
    //   771: astore_3
    //   772: aload_3
    //   773: astore_2
    //   774: aload_2
    //   775: astore 7
    //   777: aload 7
    //   779: astore 9
    //   781: aload_1
    //   782: astore 10
    //   784: aload_3
    //   785: astore 11
    //   787: aload_2
    //   788: astore 12
    //   790: new 85	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   797: astore 8
    //   799: aload 7
    //   801: astore 9
    //   803: aload_1
    //   804: astore 10
    //   806: aload_3
    //   807: astore 11
    //   809: aload_2
    //   810: astore 12
    //   812: aload 8
    //   814: ldc_w 388
    //   817: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload 7
    //   823: astore 9
    //   825: aload_1
    //   826: astore 10
    //   828: aload_3
    //   829: astore 11
    //   831: aload_2
    //   832: astore 12
    //   834: aload 8
    //   836: aload_0
    //   837: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload 7
    //   843: astore 9
    //   845: aload_1
    //   846: astore 10
    //   848: aload_3
    //   849: astore 11
    //   851: aload_2
    //   852: astore 12
    //   854: ldc_w 316
    //   857: iconst_2
    //   858: aload 8
    //   860: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload 7
    //   868: ifnull +8 -> 876
    //   871: aload 7
    //   873: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   876: aload_2
    //   877: ifnull +10 -> 887
    //   880: aload_2
    //   881: invokevirtual 385	java/io/DataInputStream:close	()V
    //   884: goto +3 -> 887
    //   887: aload_3
    //   888: ifnull +10 -> 898
    //   891: aload_3
    //   892: invokevirtual 386	java/io/OutputStream:close	()V
    //   895: goto +3 -> 898
    //   898: aload_1
    //   899: ifnull +9 -> 908
    //   902: aload 13
    //   904: astore_0
    //   905: goto -215 -> 690
    //   908: aconst_null
    //   909: areturn
    //   910: astore_0
    //   911: aload 12
    //   913: astore 8
    //   915: aload 11
    //   917: astore_2
    //   918: aload 10
    //   920: astore_1
    //   921: aload 9
    //   923: astore 7
    //   925: aload 8
    //   927: astore_3
    //   928: aload 7
    //   930: ifnull +8 -> 938
    //   933: aload 7
    //   935: invokevirtual 264	java/net/HttpURLConnection:disconnect	()V
    //   938: aload_3
    //   939: ifnull +10 -> 949
    //   942: aload_3
    //   943: invokevirtual 385	java/io/DataInputStream:close	()V
    //   946: goto +3 -> 949
    //   949: aload_2
    //   950: ifnull +10 -> 960
    //   953: aload_2
    //   954: invokevirtual 386	java/io/OutputStream:close	()V
    //   957: goto +3 -> 960
    //   960: aload_1
    //   961: ifnull +7 -> 968
    //   964: aload_1
    //   965: invokevirtual 261	java/io/BufferedReader:close	()V
    //   968: goto +5 -> 973
    //   971: aload_0
    //   972: athrow
    //   973: goto -2 -> 971
    //   976: astore_1
    //   977: goto -209 -> 768
    //   980: astore_1
    //   981: goto -236 -> 745
    //   984: astore_1
    //   985: goto -264 -> 721
    //   988: astore_1
    //   989: goto -287 -> 702
    //   992: astore_3
    //   993: aload_2
    //   994: astore_3
    //   995: aload 8
    //   997: astore_2
    //   998: goto -221 -> 777
    //   1001: astore_0
    //   1002: goto -318 -> 684
    //   1005: astore_0
    //   1006: aload_3
    //   1007: astore_0
    //   1008: goto -318 -> 690
    //   1011: astore_1
    //   1012: aload_0
    //   1013: areturn
    //   1014: astore_0
    //   1015: goto -128 -> 887
    //   1018: astore_0
    //   1019: goto -121 -> 898
    //   1022: astore_3
    //   1023: goto -74 -> 949
    //   1026: astore_2
    //   1027: goto -67 -> 960
    //   1030: astore_1
    //   1031: goto -63 -> 968
    //   1034: aconst_null
    //   1035: astore_3
    //   1036: goto -651 -> 385
    //   1039: ldc 204
    //   1041: astore 8
    //   1043: goto -638 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1046	0	paramString1	String
    //   0	1046	1	paramString2	String
    //   0	1046	2	paramString3	String
    //   0	1046	3	paramString4	String
    //   0	1046	4	paramLong	long
    //   487	12	6	i	int
    //   20	914	7	localObject1	Object
    //   80	962	8	localObject2	Object
    //   1	921	9	localObject3	Object
    //   584	335	10	str1	String
    //   587	329	11	str2	String
    //   591	321	12	localObject4	Object
    //   4	899	13	localObject5	Object
    //   186	478	14	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   475	481	696	finally
    //   481	489	696	finally
    //   495	503	696	finally
    //   506	579	696	finally
    //   179	378	712	finally
    //   392	402	712	finally
    //   405	475	712	finally
    //   22	179	734	finally
    //   6	22	754	finally
    //   593	598	910	finally
    //   616	623	910	finally
    //   637	646	910	finally
    //   663	669	910	finally
    //   790	799	910	finally
    //   812	821	910	finally
    //   834	841	910	finally
    //   854	866	910	finally
    //   6	22	976	java/lang/Exception
    //   22	179	980	java/lang/Exception
    //   179	378	984	java/lang/Exception
    //   392	402	984	java/lang/Exception
    //   405	475	984	java/lang/Exception
    //   475	481	988	java/lang/Exception
    //   481	489	988	java/lang/Exception
    //   495	503	988	java/lang/Exception
    //   506	579	988	java/lang/Exception
    //   593	598	992	java/lang/Exception
    //   616	623	992	java/lang/Exception
    //   637	646	992	java/lang/Exception
    //   663	669	992	java/lang/Exception
    //   679	684	1001	java/io/IOException
    //   684	688	1005	java/io/IOException
    //   690	694	1011	java/io/IOException
    //   880	884	1014	java/io/IOException
    //   891	895	1018	java/io/IOException
    //   942	946	1022	java/io/IOException
    //   953	957	1026	java/io/IOException
    //   964	968	1030	java/io/IOException
  }
  
  private static JSONObject a(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    try
    {
      paramString = HomeworkURLUtil.a(paramAppRuntime.getApplication().getApplicationContext(), paramString, paramBundle1, paramBundle2);
      paramAppRuntime = paramString;
      if (paramString == null) {
        paramAppRuntime = "";
      }
      paramAppRuntime = new JSONObject(paramAppRuntime);
      return paramAppRuntime;
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
    }
    catch (JSONException paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
    }
    catch (IOException paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
    }
    return null;
  }
  
  public static JSONObject a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    String str = paramAppRuntime.getAccount();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null) {
      localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());
    } else {
      localObject = null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("filename", paramString1);
    localBundle.putString("gc", paramString2);
    localBundle.putString("file_sha1", paramString3);
    localBundle.putString("bkn", String.valueOf(((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getBknBySkey((String)localObject)));
    paramString1 = new Bundle();
    paramString2 = new StringBuilder();
    paramString2.append("uin=");
    paramString2.append(str);
    paramString2.append(";skey=");
    paramString2.append((String)localObject);
    paramString1.putString("Cookie", paramString2.toString());
    if (HomeworkDpcCfg.a().a()) {
      return a(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", localBundle, paramString1);
    }
    return b(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", localBundle, paramString1);
  }
  
  public static String b(String paramString)
  {
    Object localObject = AppConstants.SDCARD_HOMEWORK_AUDIO;
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
    localObject = new StringBuilder((String)localObject);
    ((StringBuilder)localObject).append("stream");
    ((StringBuilder)localObject).append(str);
    if (paramString.toLowerCase().endsWith(".slk")) {
      ((StringBuilder)localObject).append(".slk");
    } else {
      ((StringBuilder)localObject).append(".amr");
    }
    return VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
  }
  
  /* Error */
  private static JSONObject b(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokevirtual 397	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7: invokevirtual 403	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   10: aload_1
    //   11: ldc_w 301
    //   14: aload_2
    //   15: aload_3
    //   16: invokestatic 518	com/tencent/biz/common/util/HttpUtil:openUrl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   19: astore 6
    //   21: aload 6
    //   23: astore 5
    //   25: aload 6
    //   27: ifnonnull +8 -> 35
    //   30: ldc_w 365
    //   33: astore 5
    //   35: new 144	org/json/JSONObject
    //   38: dup
    //   39: aload 5
    //   41: invokespecial 409	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 5
    //   48: areturn
    //   49: astore 5
    //   51: goto +75 -> 126
    //   54: astore 5
    //   56: ldc 77
    //   58: iconst_2
    //   59: aload 5
    //   61: invokevirtual 412	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   64: aload 5
    //   66: invokestatic 415	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: goto +18 -> 87
    //   72: astore 5
    //   74: ldc 77
    //   76: iconst_2
    //   77: aload 5
    //   79: invokevirtual 416	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   82: aload 5
    //   84: invokestatic 415	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore 5
    //   91: ldc 77
    //   93: iconst_2
    //   94: aload 5
    //   96: invokevirtual 417	java/io/IOException:getMessage	()Ljava/lang/String;
    //   99: aload 5
    //   101: invokestatic 415	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: ldc 77
    //   106: iconst_2
    //   107: ldc_w 520
    //   110: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: aload_1
    //   115: aload_2
    //   116: aload_3
    //   117: invokestatic 475	cooperation/troop_homework/TroopHomeworkHelper:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/json/JSONObject;
    //   120: areturn
    //   121: astore 5
    //   123: iconst_1
    //   124: istore 4
    //   126: iload 4
    //   128: ifeq +20 -> 148
    //   131: ldc 77
    //   133: iconst_2
    //   134: ldc_w 520
    //   137: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: aload_1
    //   142: aload_2
    //   143: aload_3
    //   144: invokestatic 475	cooperation/troop_homework/TroopHomeworkHelper:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 5
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramAppRuntime	AppRuntime
    //   0	151	1	paramString	String
    //   0	151	2	paramBundle1	Bundle
    //   0	151	3	paramBundle2	Bundle
    //   1	126	4	i	int
    //   23	24	5	localObject1	Object
    //   49	1	5	localObject2	Object
    //   54	11	5	localOutOfMemoryError	OutOfMemoryError
    //   72	11	5	localJSONException	JSONException
    //   89	11	5	localIOException	IOException
    //   121	28	5	localObject3	Object
    //   19	7	6	str	String
    // Exception table:
    //   from	to	target	type
    //   3	21	49	finally
    //   35	46	49	finally
    //   56	69	49	finally
    //   74	87	49	finally
    //   3	21	54	java/lang/OutOfMemoryError
    //   35	46	54	java/lang/OutOfMemoryError
    //   3	21	72	org/json/JSONException
    //   35	46	72	org/json/JSONException
    //   3	21	89	java/io/IOException
    //   35	46	89	java/io/IOException
    //   91	104	121	finally
  }
  
  public static JSONObject b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    String str = paramAppRuntime.getAccount();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null) {
      localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());
    } else {
      localObject = null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("filename", paramString1);
    localBundle.putString("gc", paramString2);
    localBundle.putString("positions", paramString3);
    localBundle.putString("bkn", String.valueOf(((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getBknBySkey((String)localObject)));
    paramString1 = new Bundle();
    paramString2 = new StringBuilder();
    paramString2.append("uin=");
    paramString2.append(str);
    paramString2.append(";skey=");
    paramString2.append((String)localObject);
    paramString1.putString("Cookie", paramString2.toString());
    if (HomeworkDpcCfg.a().a()) {
      return a(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_append", localBundle, paramString1);
    }
    return b(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_append", localBundle, paramString1);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return null;
    }
    long l2 = paramString.length();
    long l1 = 0L;
    if (l2 == 0L) {
      return null;
    }
    paramString = new StringBuilder();
    while (l1 < l2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append(",");
      paramString.append(localStringBuilder.toString());
      if (l2 - l1 <= 4096L) {
        break;
      }
      l1 += 1048576L;
    }
    paramString.deleteCharAt(paramString.length() - 1);
    return paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.TroopHomeworkHelper
 * JD-Core Version:    0.7.0.1
 */