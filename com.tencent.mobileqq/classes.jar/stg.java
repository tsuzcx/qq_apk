import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class stg
  extends AsyncTask
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public stg(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  /* Error */
  protected Uri a(java.lang.Object... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 7
    //   15: aload_1
    //   16: iconst_0
    //   17: aaload
    //   18: checkcast 24	android/content/Context
    //   21: astore 13
    //   23: aload_1
    //   24: iconst_1
    //   25: aaload
    //   26: checkcast 26	android/net/Uri
    //   29: astore 14
    //   31: getstatic 32	com/tencent/mobileqq/app/AppConstants:bd	Ljava/lang/String;
    //   34: astore 12
    //   36: aload 13
    //   38: invokevirtual 36	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload 14
    //   43: iconst_1
    //   44: anewarray 38	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc 40
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 46	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +606 -> 666
    //   63: aload_3
    //   64: invokeinterface 52 1 0
    //   69: ifeq +597 -> 666
    //   72: aload_3
    //   73: iconst_0
    //   74: invokeinterface 56 2 0
    //   79: astore_1
    //   80: aload_1
    //   81: astore 5
    //   83: aload_1
    //   84: astore 4
    //   86: aload_3
    //   87: invokeinterface 59 1 0
    //   92: aload_1
    //   93: astore 5
    //   95: aload_1
    //   96: astore 4
    //   98: aload 12
    //   100: invokestatic 64	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   103: ifne +22 -> 125
    //   106: aload_1
    //   107: astore 5
    //   109: aload_1
    //   110: astore 4
    //   112: new 66	java/io/File
    //   115: dup
    //   116: aload 12
    //   118: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 72	java/io/File:mkdirs	()Z
    //   124: pop
    //   125: aload_1
    //   126: astore 5
    //   128: aload_1
    //   129: astore 4
    //   131: new 74	java/io/FileOutputStream
    //   134: dup
    //   135: new 66	java/io/File
    //   138: dup
    //   139: new 76	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   146: aload 12
    //   148: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: astore 8
    //   166: aload 7
    //   168: astore 4
    //   170: aload 10
    //   172: astore 5
    //   174: aload 13
    //   176: invokevirtual 36	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   179: aload 14
    //   181: ldc 90
    //   183: invokevirtual 94	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   186: astore 9
    //   188: aload 11
    //   190: astore 6
    //   192: aload 9
    //   194: ifnull +172 -> 366
    //   197: aload 7
    //   199: astore 4
    //   201: aload 10
    //   203: astore 5
    //   205: aload 9
    //   207: invokevirtual 100	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   210: astore 6
    //   212: aload 6
    //   214: astore 4
    //   216: aload 6
    //   218: astore 5
    //   220: sipush 1024
    //   223: newarray byte
    //   225: astore 7
    //   227: aload 6
    //   229: astore 4
    //   231: aload 6
    //   233: astore 5
    //   235: aload 6
    //   237: aload 7
    //   239: invokevirtual 106	java/io/InputStream:read	([B)I
    //   242: istore_2
    //   243: iload_2
    //   244: iconst_m1
    //   245: if_icmpeq +108 -> 353
    //   248: aload 6
    //   250: astore 4
    //   252: aload 6
    //   254: astore 5
    //   256: aload 8
    //   258: aload 7
    //   260: iconst_0
    //   261: iload_2
    //   262: invokevirtual 110	java/io/FileOutputStream:write	([BII)V
    //   265: goto -38 -> 227
    //   268: astore 7
    //   270: aload_3
    //   271: astore 5
    //   273: aload 4
    //   275: astore 6
    //   277: aload 8
    //   279: astore 4
    //   281: aload_1
    //   282: astore_3
    //   283: aload 5
    //   285: astore_1
    //   286: aload 7
    //   288: astore 5
    //   290: aload 5
    //   292: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   295: aload_1
    //   296: ifnull +9 -> 305
    //   299: aload_1
    //   300: invokeinterface 59 1 0
    //   305: aload 6
    //   307: ifnull +8 -> 315
    //   310: aload 6
    //   312: invokevirtual 114	java/io/InputStream:close	()V
    //   315: aload 4
    //   317: ifnull +8 -> 325
    //   320: aload 4
    //   322: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   325: new 76	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   332: ldc 117
    //   334: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 12
    //   339: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_3
    //   343: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 121	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   352: areturn
    //   353: aload 6
    //   355: astore 4
    //   357: aload 6
    //   359: astore 5
    //   361: aload 8
    //   363: invokevirtual 124	java/io/FileOutputStream:flush	()V
    //   366: aload_3
    //   367: ifnull +9 -> 376
    //   370: aload_3
    //   371: invokeinterface 59 1 0
    //   376: aload 6
    //   378: ifnull +8 -> 386
    //   381: aload 6
    //   383: invokevirtual 114	java/io/InputStream:close	()V
    //   386: aload 8
    //   388: ifnull +8 -> 396
    //   391: aload 8
    //   393: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   396: new 76	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   403: ldc 117
    //   405: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 12
    //   410: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_1
    //   414: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 121	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   423: areturn
    //   424: astore_3
    //   425: aload_3
    //   426: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   429: goto -43 -> 386
    //   432: astore_3
    //   433: aload_3
    //   434: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   437: goto -41 -> 396
    //   440: astore_1
    //   441: aload_1
    //   442: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   445: goto -130 -> 315
    //   448: astore_1
    //   449: aload_1
    //   450: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   453: goto -128 -> 325
    //   456: astore 4
    //   458: aconst_null
    //   459: astore 7
    //   461: ldc 127
    //   463: astore_1
    //   464: aconst_null
    //   465: astore_3
    //   466: aload 9
    //   468: astore 5
    //   470: aload 7
    //   472: ifnull +10 -> 482
    //   475: aload 7
    //   477: invokeinterface 59 1 0
    //   482: aload 5
    //   484: ifnull +8 -> 492
    //   487: aload 5
    //   489: invokevirtual 114	java/io/InputStream:close	()V
    //   492: aload_3
    //   493: ifnull +7 -> 500
    //   496: aload_3
    //   497: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   500: new 76	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   507: ldc 117
    //   509: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 12
    //   514: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_1
    //   518: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 121	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   527: pop
    //   528: aload 4
    //   530: athrow
    //   531: astore 5
    //   533: aload 5
    //   535: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   538: goto -46 -> 492
    //   541: astore_3
    //   542: aload_3
    //   543: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   546: goto -46 -> 500
    //   549: astore 4
    //   551: ldc 127
    //   553: astore_1
    //   554: aconst_null
    //   555: astore 5
    //   557: aload_3
    //   558: astore 7
    //   560: aload 5
    //   562: astore_3
    //   563: aload 9
    //   565: astore 5
    //   567: goto -97 -> 470
    //   570: astore 4
    //   572: aconst_null
    //   573: astore 6
    //   575: aload_3
    //   576: astore 7
    //   578: aload 5
    //   580: astore_1
    //   581: aload 6
    //   583: astore_3
    //   584: aload 9
    //   586: astore 5
    //   588: goto -118 -> 470
    //   591: astore 4
    //   593: aload_3
    //   594: astore 7
    //   596: aload 8
    //   598: astore_3
    //   599: goto -129 -> 470
    //   602: astore 7
    //   604: aload 4
    //   606: astore 5
    //   608: aload 7
    //   610: astore 4
    //   612: aload_1
    //   613: astore 7
    //   615: aload_3
    //   616: astore_1
    //   617: aload 5
    //   619: astore_3
    //   620: aload 6
    //   622: astore 5
    //   624: goto -154 -> 470
    //   627: astore 5
    //   629: aconst_null
    //   630: astore_1
    //   631: ldc 127
    //   633: astore_3
    //   634: aconst_null
    //   635: astore 4
    //   637: goto -347 -> 290
    //   640: astore 5
    //   642: aload_3
    //   643: astore_1
    //   644: aconst_null
    //   645: astore 4
    //   647: ldc 127
    //   649: astore_3
    //   650: goto -360 -> 290
    //   653: astore 5
    //   655: aload_3
    //   656: astore_1
    //   657: aload 4
    //   659: astore_3
    //   660: aconst_null
    //   661: astore 4
    //   663: goto -373 -> 290
    //   666: ldc 127
    //   668: astore_1
    //   669: goto -577 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	stg
    //   0	672	1	paramVarArgs	java.lang.Object[]
    //   242	20	2	i	int
    //   58	313	3	localObject1	java.lang.Object
    //   424	2	3	localIOException1	java.io.IOException
    //   432	2	3	localIOException2	java.io.IOException
    //   465	32	3	localObject2	java.lang.Object
    //   541	17	3	localIOException3	java.io.IOException
    //   562	98	3	localObject3	java.lang.Object
    //   84	272	4	localObject4	java.lang.Object
    //   456	73	4	localObject5	java.lang.Object
    //   549	1	4	localObject6	java.lang.Object
    //   570	1	4	localObject7	java.lang.Object
    //   591	14	4	localObject8	java.lang.Object
    //   610	52	4	localObject9	java.lang.Object
    //   81	407	5	localObject10	java.lang.Object
    //   531	3	5	localIOException4	java.io.IOException
    //   555	68	5	localObject11	java.lang.Object
    //   627	1	5	localException1	java.lang.Exception
    //   640	1	5	localException2	java.lang.Exception
    //   653	1	5	localException3	java.lang.Exception
    //   1	620	6	localObject12	java.lang.Object
    //   13	246	7	arrayOfByte	byte[]
    //   268	19	7	localException4	java.lang.Exception
    //   459	136	7	localObject13	java.lang.Object
    //   602	7	7	localObject14	java.lang.Object
    //   613	1	7	arrayOfObject	java.lang.Object[]
    //   164	433	8	localFileOutputStream	java.io.FileOutputStream
    //   7	578	9	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   10	192	10	localObject15	java.lang.Object
    //   4	185	11	localObject16	java.lang.Object
    //   34	479	12	str	java.lang.String
    //   21	154	13	localContext	android.content.Context
    //   29	151	14	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   174	188	268	java/lang/Exception
    //   205	212	268	java/lang/Exception
    //   220	227	268	java/lang/Exception
    //   235	243	268	java/lang/Exception
    //   256	265	268	java/lang/Exception
    //   361	366	268	java/lang/Exception
    //   381	386	424	java/io/IOException
    //   391	396	432	java/io/IOException
    //   310	315	440	java/io/IOException
    //   320	325	448	java/io/IOException
    //   36	59	456	finally
    //   487	492	531	java/io/IOException
    //   496	500	541	java/io/IOException
    //   63	80	549	finally
    //   86	92	570	finally
    //   98	106	570	finally
    //   112	125	570	finally
    //   131	166	570	finally
    //   174	188	591	finally
    //   205	212	591	finally
    //   220	227	591	finally
    //   235	243	591	finally
    //   256	265	591	finally
    //   361	366	591	finally
    //   290	295	602	finally
    //   36	59	627	java/lang/Exception
    //   63	80	640	java/lang/Exception
    //   86	92	653	java/lang/Exception
    //   98	106	653	java/lang/Exception
    //   112	125	653	java/lang/Exception
    //   131	166	653	java/lang/Exception
  }
  
  protected void a(Uri paramUri)
  {
    this.jdField_a_of_type_AndroidContentIntent.setData(paramUri);
    ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     stg
 * JD-Core Version:    0.7.0.1
 */