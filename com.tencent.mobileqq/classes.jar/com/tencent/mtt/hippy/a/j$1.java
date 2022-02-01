package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import java.io.File;

class j$1
  implements HippyHttpAdapter.HttpTaskCallback
{
  j$1(j paramj, a parama, File paramFile, String paramString) {}
  
  public void onTaskFailed(HippyHttpRequest paramHippyHttpRequest, Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.a(new i("Could not connect to development server.URL: " + this.c.toString() + "  try to :adb reverse tcp:38989 tcp:38989 , message : " + paramThrowable.getMessage()));
    }
  }
  
  /* Error */
  public void onTaskSuccess(HippyHttpRequest paramHippyHttpRequest, com.tencent.mtt.hippy.adapter.http.HippyHttpResponse paramHippyHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: invokevirtual 73	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getStatusCode	()Ljava/lang/Integer;
    //   12: invokevirtual 79	java/lang/Integer:intValue	()I
    //   15: sipush 200
    //   18: if_icmpne +177 -> 195
    //   21: aload_2
    //   22: invokevirtual 83	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getInputStream	()Ljava/io/InputStream;
    //   25: ifnull +170 -> 195
    //   28: aconst_null
    //   29: astore 4
    //   31: aconst_null
    //   32: astore 5
    //   34: aload 4
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   41: invokevirtual 89	java/io/File:exists	()Z
    //   44: ifeq +14 -> 58
    //   47: aload 4
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   54: invokevirtual 92	java/io/File:delete	()Z
    //   57: pop
    //   58: aload 4
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   65: invokevirtual 95	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: aload 4
    //   71: astore_1
    //   72: new 97	java/io/FileOutputStream
    //   75: dup
    //   76: aload_0
    //   77: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   80: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore 4
    //   85: sipush 2048
    //   88: newarray byte
    //   90: astore_1
    //   91: aload_2
    //   92: invokevirtual 83	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getInputStream	()Ljava/io/InputStream;
    //   95: aload_1
    //   96: invokevirtual 106	java/io/InputStream:read	([B)I
    //   99: istore_3
    //   100: iload_3
    //   101: ifle +39 -> 140
    //   104: aload 4
    //   106: aload_1
    //   107: iconst_0
    //   108: iload_3
    //   109: invokevirtual 110	java/io/FileOutputStream:write	([BII)V
    //   112: goto -21 -> 91
    //   115: astore_1
    //   116: aload 4
    //   118: astore_2
    //   119: aload_1
    //   120: astore 4
    //   122: aload_2
    //   123: astore_1
    //   124: aload 4
    //   126: invokevirtual 113	java/lang/Throwable:printStackTrace	()V
    //   129: aload_2
    //   130: ifnull -123 -> 7
    //   133: aload_2
    //   134: invokevirtual 116	java/io/FileOutputStream:close	()V
    //   137: return
    //   138: astore_1
    //   139: return
    //   140: aload 4
    //   142: invokevirtual 119	java/io/FileOutputStream:flush	()V
    //   145: aload_0
    //   146: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   149: ifnull +16 -> 165
    //   152: aload_0
    //   153: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   156: aload_0
    //   157: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   160: invokeinterface 121 2 0
    //   165: aload 4
    //   167: ifnull -160 -> 7
    //   170: aload 4
    //   172: invokevirtual 116	java/io/FileOutputStream:close	()V
    //   175: return
    //   176: astore_1
    //   177: return
    //   178: astore 4
    //   180: aload_1
    //   181: astore_2
    //   182: aload 4
    //   184: astore_1
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 116	java/io/FileOutputStream:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: ldc 123
    //   197: astore_1
    //   198: aload_2
    //   199: invokevirtual 126	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getErrorStream	()Ljava/io/InputStream;
    //   202: ifnull +65 -> 267
    //   205: new 128	java/lang/StringBuffer
    //   208: dup
    //   209: invokespecial 129	java/lang/StringBuffer:<init>	()V
    //   212: astore_1
    //   213: new 131	java/io/BufferedReader
    //   216: dup
    //   217: new 133	java/io/InputStreamReader
    //   220: dup
    //   221: aload_2
    //   222: invokevirtual 126	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getErrorStream	()Ljava/io/InputStream;
    //   225: ldc 135
    //   227: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   230: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   233: astore_2
    //   234: aload_2
    //   235: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +20 -> 262
    //   245: aload_1
    //   246: aload 4
    //   248: invokevirtual 147	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   251: pop
    //   252: aload_1
    //   253: ldc 149
    //   255: invokevirtual 147	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   258: pop
    //   259: goto -25 -> 234
    //   262: aload_1
    //   263: invokevirtual 150	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   266: astore_1
    //   267: aload_0
    //   268: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   271: ifnull -264 -> 7
    //   274: aload_0
    //   275: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   278: new 32	com/tencent/mtt/hippy/a/i
    //   281: dup
    //   282: new 34	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   289: ldc 37
    //   291: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: getfield 24	com/tencent/mtt/hippy/a/j$1:c	Ljava/lang/String;
    //   298: invokevirtual 47	java/lang/String:toString	()Ljava/lang/String;
    //   301: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 49
    //   306: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_1
    //   310: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokespecial 58	com/tencent/mtt/hippy/a/i:<init>	(Ljava/lang/String;)V
    //   319: invokeinterface 63 2 0
    //   324: return
    //   325: astore_2
    //   326: goto -133 -> 193
    //   329: astore_1
    //   330: aload 4
    //   332: astore_2
    //   333: goto -148 -> 185
    //   336: astore 4
    //   338: aload 5
    //   340: astore_2
    //   341: goto -219 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	1
    //   0	344	1	paramHippyHttpRequest	HippyHttpRequest
    //   0	344	2	paramHippyHttpResponse	com.tencent.mtt.hippy.adapter.http.HippyHttpResponse
    //   99	10	3	i	int
    //   29	142	4	localObject1	Object
    //   178	5	4	localObject2	Object
    //   238	93	4	str	String
    //   336	1	4	localThrowable	Throwable
    //   32	307	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   85	91	115	java/lang/Throwable
    //   91	100	115	java/lang/Throwable
    //   104	112	115	java/lang/Throwable
    //   140	165	115	java/lang/Throwable
    //   133	137	138	java/io/IOException
    //   170	175	176	java/io/IOException
    //   37	47	178	finally
    //   50	58	178	finally
    //   61	69	178	finally
    //   72	85	178	finally
    //   124	129	178	finally
    //   189	193	325	java/io/IOException
    //   85	91	329	finally
    //   91	100	329	finally
    //   104	112	329	finally
    //   140	165	329	finally
    //   37	47	336	java/lang/Throwable
    //   50	58	336	java/lang/Throwable
    //   61	69	336	java/lang/Throwable
    //   72	85	336	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.j.1
 * JD-Core Version:    0.7.0.1
 */