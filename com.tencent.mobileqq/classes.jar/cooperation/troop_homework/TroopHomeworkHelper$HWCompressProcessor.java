package cooperation.troop_homework;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;

public class TroopHomeworkHelper$HWCompressProcessor
  implements VideoConverter.Processor
{
  final String a;
  final int b;
  final int c;
  
  TroopHomeworkHelper$HWCompressProcessor(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    if (paramInt2 > 0) {
      this.c = paramInt2;
    } else {
      this.c = 30;
    }
    if (paramString != null) {
      return;
    }
    throw new IllegalArgumentException("null == outputFilePath");
  }
  
  /* Error */
  public com.tencent.richmedia.videocompress.VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 36	com/tencent/richmedia/videocompress/VideoConverterConfig
    //   3: dup
    //   4: invokespecial 37	com/tencent/richmedia/videocompress/VideoConverterConfig:<init>	()V
    //   7: astore 11
    //   9: iload_1
    //   10: istore 8
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpgt +6 -> 20
    //   17: iload_2
    //   18: istore 8
    //   20: aload 11
    //   22: aload_0
    //   23: getfield 18	cooperation/troop_homework/TroopHomeworkHelper$HWCompressProcessor:a	Ljava/lang/String;
    //   26: putfield 40	com/tencent/richmedia/videocompress/VideoConverterConfig:output	Ljava/lang/String;
    //   29: ldc 42
    //   31: invokestatic 48	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   34: checkcast 42	com/tencent/mobileqq/dpc/api/IDPCApi
    //   37: getstatic 54	com/tencent/mobileqq/dpc/enumname/DPCNames:lvcc	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   40: invokevirtual 58	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   43: ldc 60
    //   45: invokeinterface 64 3 0
    //   50: astore 10
    //   52: iconst_0
    //   53: istore 9
    //   55: aload 10
    //   57: ifnull +164 -> 221
    //   60: aload 10
    //   62: invokevirtual 70	java/lang/String:length	()I
    //   65: ifle +156 -> 221
    //   68: aload 10
    //   70: ldc 72
    //   72: invokevirtual 76	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   75: astore 10
    //   77: aload 10
    //   79: ifnull +142 -> 221
    //   82: aload 10
    //   84: arraylength
    //   85: iconst_4
    //   86: if_icmple +135 -> 221
    //   89: aload 10
    //   91: iconst_1
    //   92: aaload
    //   93: invokestatic 82	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   96: invokevirtual 85	java/lang/Integer:intValue	()I
    //   99: istore_3
    //   100: aload 10
    //   102: iconst_2
    //   103: aaload
    //   104: invokestatic 82	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   107: invokevirtual 85	java/lang/Integer:intValue	()I
    //   110: istore_2
    //   111: aload 10
    //   113: iconst_3
    //   114: aaload
    //   115: invokestatic 82	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   118: invokevirtual 85	java/lang/Integer:intValue	()I
    //   121: istore_1
    //   122: aload 10
    //   124: iconst_4
    //   125: aaload
    //   126: invokestatic 82	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   129: invokevirtual 85	java/lang/Integer:intValue	()I
    //   132: istore 4
    //   134: goto +97 -> 231
    //   137: astore 10
    //   139: iload_3
    //   140: istore 5
    //   142: iload_2
    //   143: istore 6
    //   145: iload_1
    //   146: istore 7
    //   148: goto +28 -> 176
    //   151: astore 10
    //   153: goto +14 -> 167
    //   156: astore 10
    //   158: goto +7 -> 165
    //   161: astore 10
    //   163: iconst_0
    //   164: istore_3
    //   165: iconst_0
    //   166: istore_2
    //   167: iconst_0
    //   168: istore 7
    //   170: iload_2
    //   171: istore 6
    //   173: iload_3
    //   174: istore 5
    //   176: iload 9
    //   178: istore 4
    //   180: iload 5
    //   182: istore_3
    //   183: iload 6
    //   185: istore_2
    //   186: iload 7
    //   188: istore_1
    //   189: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +39 -> 231
    //   195: ldc 93
    //   197: iconst_2
    //   198: ldc 95
    //   200: aload 10
    //   202: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: iload 9
    //   207: istore 4
    //   209: iload 5
    //   211: istore_3
    //   212: iload 6
    //   214: istore_2
    //   215: iload 7
    //   217: istore_1
    //   218: goto +13 -> 231
    //   221: iconst_0
    //   222: istore_3
    //   223: iconst_0
    //   224: istore_2
    //   225: iconst_0
    //   226: istore_1
    //   227: iload 9
    //   229: istore 4
    //   231: iload_3
    //   232: istore 5
    //   234: iload_3
    //   235: ifgt +8 -> 243
    //   238: sipush 640
    //   241: istore 5
    //   243: iload_2
    //   244: istore_3
    //   245: iload_2
    //   246: ifgt +7 -> 253
    //   249: sipush 384
    //   252: istore_3
    //   253: iload_1
    //   254: istore_2
    //   255: iload_1
    //   256: ifgt +7 -> 263
    //   259: sipush 768
    //   262: istore_2
    //   263: iload 4
    //   265: istore_1
    //   266: iload 4
    //   268: ifgt +6 -> 274
    //   271: bipush 30
    //   273: istore_1
    //   274: aload 11
    //   276: iload 5
    //   278: i2f
    //   279: iload 8
    //   281: i2f
    //   282: fdiv
    //   283: putfield 103	com/tencent/richmedia/videocompress/VideoConverterConfig:scaleRate	F
    //   286: aload 11
    //   288: aload_0
    //   289: getfield 20	cooperation/troop_homework/TroopHomeworkHelper$HWCompressProcessor:b	I
    //   292: i2f
    //   293: aload 11
    //   295: getfield 103	com/tencent/richmedia/videocompress/VideoConverterConfig:scaleRate	F
    //   298: fmul
    //   299: aload 11
    //   301: getfield 103	com/tencent/richmedia/videocompress/VideoConverterConfig:scaleRate	F
    //   304: fmul
    //   305: ldc 104
    //   307: fadd
    //   308: f2i
    //   309: putfield 107	com/tencent/richmedia/videocompress/VideoConverterConfig:videoBitRate	I
    //   312: aload 11
    //   314: getfield 107	com/tencent/richmedia/videocompress/VideoConverterConfig:videoBitRate	I
    //   317: istore 4
    //   319: iload_2
    //   320: sipush 1024
    //   323: imul
    //   324: istore_2
    //   325: iload 4
    //   327: iload_2
    //   328: if_icmple +12 -> 340
    //   331: aload 11
    //   333: iload_2
    //   334: putfield 107	com/tencent/richmedia/videocompress/VideoConverterConfig:videoBitRate	I
    //   337: goto +26 -> 363
    //   340: aload 11
    //   342: getfield 107	com/tencent/richmedia/videocompress/VideoConverterConfig:videoBitRate	I
    //   345: istore_2
    //   346: iload_3
    //   347: sipush 1024
    //   350: imul
    //   351: istore_3
    //   352: iload_2
    //   353: iload_3
    //   354: if_icmpge +9 -> 363
    //   357: aload 11
    //   359: iload_3
    //   360: putfield 107	com/tencent/richmedia/videocompress/VideoConverterConfig:videoBitRate	I
    //   363: aload_0
    //   364: getfield 22	cooperation/troop_homework/TroopHomeworkHelper$HWCompressProcessor:c	I
    //   367: istore_2
    //   368: iload_2
    //   369: iload_1
    //   370: if_icmpgt +8 -> 378
    //   373: iload_2
    //   374: istore_1
    //   375: goto +3 -> 378
    //   378: aload 11
    //   380: iload_1
    //   381: putfield 110	com/tencent/richmedia/videocompress/VideoConverterConfig:videoFrameRate	I
    //   384: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +42 -> 429
    //   390: new 112	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   397: astore 10
    //   399: aload 10
    //   401: ldc 115
    //   403: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 10
    //   409: aload 11
    //   411: getfield 123	com/tencent/richmedia/videocompress/VideoConverterConfig:setRotation	Z
    //   414: invokevirtual 126	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: ldc 93
    //   420: iconst_2
    //   421: aload 10
    //   423: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 11
    //   431: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	HWCompressProcessor
    //   0	432	1	paramInt1	int
    //   0	432	2	paramInt2	int
    //   99	261	3	i	int
    //   132	197	4	j	int
    //   140	137	5	k	int
    //   143	70	6	m	int
    //   146	70	7	n	int
    //   10	270	8	i1	int
    //   53	175	9	i2	int
    //   50	73	10	localObject	Object
    //   137	1	10	localNumberFormatException1	java.lang.NumberFormatException
    //   151	1	10	localNumberFormatException2	java.lang.NumberFormatException
    //   156	1	10	localNumberFormatException3	java.lang.NumberFormatException
    //   161	40	10	localNumberFormatException4	java.lang.NumberFormatException
    //   397	25	10	localStringBuilder	StringBuilder
    //   7	423	11	localVideoConverterConfig	com.tencent.richmedia.videocompress.VideoConverterConfig
    // Exception table:
    //   from	to	target	type
    //   122	134	137	java/lang/NumberFormatException
    //   111	122	151	java/lang/NumberFormatException
    //   100	111	156	java/lang/NumberFormatException
    //   89	100	161	java/lang/NumberFormatException
  }
  
  public void onCancel() {}
  
  public void onFail(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CompressTask, step: HWCompressProcessor onProgress:");
      localStringBuilder.append(paramInt);
      QLog.d("TroopHomeworkHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void onSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.TroopHomeworkHelper.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */