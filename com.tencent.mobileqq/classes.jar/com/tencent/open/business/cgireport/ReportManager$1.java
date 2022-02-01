package com.tencent.open.business.cgireport;

import android.os.Bundle;
import bjvn;

public class ReportManager$1
  implements Runnable
{
  public ReportManager$1(bjvn parambjvn, String paramString, Bundle paramBundle) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 34
    //   2: new 36	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   9: ldc 39
    //   11: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 17	com/tencent/open/business/cgireport/ReportManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 53	bjtx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: ldc 34
    //   29: new 36	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   36: ldc 55
    //   38: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 19	com/tencent/open/business/cgireport/ReportManager$1:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   45: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 53	bjtx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   58: invokestatic 63	bjjo:a	()Lbjjo;
    //   61: invokevirtual 66	bjjo:a	()Landroid/content/Context;
    //   64: aconst_null
    //   65: invokestatic 71	bjvf:a	(Landroid/content/Context;Ljava/lang/String;)Lbjvf;
    //   68: ldc 73
    //   70: invokevirtual 76	bjvf:a	(Ljava/lang/String;)I
    //   73: putfield 81	bjvn:jdField_a_of_type_Int	I
    //   76: aload_0
    //   77: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   80: astore 5
    //   82: aload_0
    //   83: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   86: getfield 81	bjvn:jdField_a_of_type_Int	I
    //   89: ifne +193 -> 282
    //   92: iconst_3
    //   93: istore_1
    //   94: aload 5
    //   96: iload_1
    //   97: putfield 81	bjvn:jdField_a_of_type_Int	I
    //   100: iconst_0
    //   101: istore_1
    //   102: iconst_0
    //   103: istore_3
    //   104: iload_3
    //   105: iconst_1
    //   106: iadd
    //   107: istore 4
    //   109: ldc 34
    //   111: new 36	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   118: ldc 83
    //   120: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 4
    //   125: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 53	bjtx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aconst_null
    //   135: aload_0
    //   136: getfield 17	com/tencent/open/business/cgireport/ReportManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokestatic 91	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
    //   142: astore 5
    //   144: new 93	org/apache/http/client/methods/HttpPost
    //   147: dup
    //   148: ldc 95
    //   150: aload_0
    //   151: getfield 17	com/tencent/open/business/cgireport/ReportManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: invokestatic 101	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: invokespecial 104	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   160: astore 6
    //   162: aload 6
    //   164: ldc 106
    //   166: ldc 108
    //   168: invokevirtual 111	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 6
    //   173: ldc 113
    //   175: ldc 115
    //   177: invokevirtual 118	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 6
    //   182: new 120	org/apache/http/entity/ByteArrayEntity
    //   185: dup
    //   186: aload_0
    //   187: getfield 19	com/tencent/open/business/cgireport/ReportManager$1:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   190: invokestatic 123	com/tencent/open/base/http/HttpBaseUtil:a	(Landroid/os/Bundle;)Ljava/lang/String;
    //   193: invokevirtual 129	java/lang/String:getBytes	()[B
    //   196: invokespecial 132	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   199: invokevirtual 136	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   202: aload 5
    //   204: aload 6
    //   206: invokeinterface 142 2 0
    //   211: invokeinterface 148 1 0
    //   216: invokeinterface 154 1 0
    //   221: sipush 200
    //   224: if_icmpeq +69 -> 293
    //   227: ldc 34
    //   229: ldc 156
    //   231: invokestatic 159	bjtx:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   238: iconst_0
    //   239: putfield 162	bjvn:jdField_a_of_type_Boolean	Z
    //   242: ldc 34
    //   244: new 36	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   251: ldc 164
    //   253: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: getfield 17	com/tencent/open/business/cgireport/ReportManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   260: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 53	bjtx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: iload_1
    //   270: iconst_1
    //   271: if_icmpne +101 -> 372
    //   274: ldc 34
    //   276: ldc 166
    //   278: invokestatic 53	bjtx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: return
    //   282: aload_0
    //   283: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   286: getfield 81	bjvn:jdField_a_of_type_Int	I
    //   289: istore_1
    //   290: goto -196 -> 94
    //   293: ldc 34
    //   295: ldc 168
    //   297: invokestatic 53	bjtx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: iconst_1
    //   301: istore_1
    //   302: goto -68 -> 234
    //   305: astore 5
    //   307: getstatic 169	bjvn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   310: ldc 171
    //   312: aload 5
    //   314: invokestatic 175	bjtx:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   317: iload_1
    //   318: istore_2
    //   319: iload_2
    //   320: istore_1
    //   321: iload 4
    //   323: istore_3
    //   324: iload 4
    //   326: aload_0
    //   327: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   330: getfield 81	bjvn:jdField_a_of_type_Int	I
    //   333: if_icmplt -229 -> 104
    //   336: iload_2
    //   337: istore_1
    //   338: goto -104 -> 234
    //   341: astore 5
    //   343: getstatic 169	bjvn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   346: ldc 177
    //   348: aload 5
    //   350: invokestatic 175	bjtx:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   353: iload_1
    //   354: istore_2
    //   355: goto -36 -> 319
    //   358: astore 5
    //   360: ldc 34
    //   362: ldc 179
    //   364: aload 5
    //   366: invokestatic 175	bjtx:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   369: goto -135 -> 234
    //   372: ldc 34
    //   374: ldc 181
    //   376: invokestatic 159	bjtx:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_0
    //   380: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   383: getfield 184	bjvn:jdField_a_of_type_Bjvl	Lbjvl;
    //   386: aload_0
    //   387: getfield 15	com/tencent/open/business/cgireport/ReportManager$1:this$0	Lbjvn;
    //   390: getfield 187	bjvn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   393: invokevirtual 192	bjvl:a	(Ljava/util/ArrayList;)I
    //   396: pop
    //   397: return
    //   398: astore 5
    //   400: goto -166 -> 234
    //   403: astore 5
    //   405: iconst_1
    //   406: istore_1
    //   407: goto -173 -> 234
    //   410: astore 5
    //   412: iconst_1
    //   413: istore_1
    //   414: goto -54 -> 360
    //   417: astore 5
    //   419: iconst_1
    //   420: istore_1
    //   421: goto -78 -> 343
    //   424: astore 5
    //   426: iconst_1
    //   427: istore_1
    //   428: goto -121 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	1
    //   93	335	1	i	int
    //   318	37	2	j	int
    //   103	221	3	k	int
    //   107	227	4	m	int
    //   80	123	5	localObject	Object
    //   305	8	5	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   341	8	5	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   358	7	5	localException1	java.lang.Exception
    //   398	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   403	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   410	1	5	localException2	java.lang.Exception
    //   417	1	5	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   424	1	5	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   160	45	6	localHttpPost	org.apache.http.client.methods.HttpPost
    // Exception table:
    //   from	to	target	type
    //   134	234	305	org/apache/http/conn/ConnectTimeoutException
    //   134	234	341	java/net/SocketTimeoutException
    //   134	234	358	java/lang/Exception
    //   134	234	398	java/lang/OutOfMemoryError
    //   293	300	403	java/lang/OutOfMemoryError
    //   293	300	410	java/lang/Exception
    //   293	300	417	java/net/SocketTimeoutException
    //   293	300	424	org/apache/http/conn/ConnectTimeoutException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.business.cgireport.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */