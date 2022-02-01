package com.tencent.qqmini.miniapp.util.logmonitor;

import android.os.AsyncTask;
import java.io.BufferedReader;

final class LogLoader$1
  extends AsyncTask<Void, Void, BufferedReader>
{
  LogLoader$1(Process paramProcess, LogLoader.LoadHandler paramLoadHandler) {}
  
  /* Error */
  protected BufferedReader doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 27	java/io/BufferedReader
    //   8: dup
    //   9: new 29	java/io/InputStreamReader
    //   12: dup
    //   13: aload_0
    //   14: getfield 13	com/tencent/qqmini/miniapp/util/logmonitor/LogLoader$1:val$process	Ljava/lang/Process;
    //   17: invokevirtual 35	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   20: invokespecial 38	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +16 -> 49
    //   36: aload_0
    //   37: getfield 15	com/tencent/qqmini/miniapp/util/logmonitor/LogLoader$1:val$handler	Lcom/tencent/qqmini/miniapp/util/logmonitor/LogLoader$LoadHandler;
    //   40: aload_1
    //   41: invokeinterface 51 2 0
    //   46: goto -19 -> 27
    //   49: aload_2
    //   50: invokevirtual 54	java/io/BufferedReader:close	()V
    //   53: goto +34 -> 87
    //   56: astore_1
    //   57: new 56	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   64: astore_3
    //   65: aload_3
    //   66: ldc 59
    //   68: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: ldc 68
    //   80: aload_3
    //   81: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 77	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_2
    //   88: areturn
    //   89: astore_1
    //   90: goto +104 -> 194
    //   93: astore_3
    //   94: goto +15 -> 109
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: aload_3
    //   101: astore_1
    //   102: goto +92 -> 194
    //   105: astore_3
    //   106: aload 4
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: new 56	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   118: astore 4
    //   120: aload_2
    //   121: astore_1
    //   122: aload 4
    //   124: ldc 79
    //   126: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: astore_1
    //   132: aload 4
    //   134: aload_3
    //   135: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: astore_1
    //   141: ldc 68
    //   143: aload 4
    //   145: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 77	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: ifnull +40 -> 192
    //   155: aload_2
    //   156: invokevirtual 54	java/io/BufferedReader:close	()V
    //   159: aload_2
    //   160: areturn
    //   161: astore_1
    //   162: new 56	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   169: astore_3
    //   170: aload_3
    //   171: ldc 59
    //   173: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_3
    //   178: aload_1
    //   179: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: ldc 68
    //   185: aload_3
    //   186: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 77	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_2
    //   193: areturn
    //   194: aload_2
    //   195: ifnull +41 -> 236
    //   198: aload_2
    //   199: invokevirtual 54	java/io/BufferedReader:close	()V
    //   202: goto +34 -> 236
    //   205: astore_2
    //   206: new 56	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   213: astore_3
    //   214: aload_3
    //   215: ldc 59
    //   217: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_3
    //   222: aload_2
    //   223: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc 68
    //   229: aload_3
    //   230: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 77	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: goto +5 -> 241
    //   239: aload_1
    //   240: athrow
    //   241: goto -2 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	1
    //   0	244	1	paramVarArgs	Void[]
    //   26	173	2	localObject1	java.lang.Object
    //   205	18	2	localIOException	java.io.IOException
    //   64	17	3	localStringBuilder1	java.lang.StringBuilder
    //   93	1	3	localException1	java.lang.Exception
    //   97	4	3	localObject2	java.lang.Object
    //   105	30	3	localException2	java.lang.Exception
    //   169	61	3	localStringBuilder2	java.lang.StringBuilder
    //   1	143	4	localStringBuilder3	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   49	53	56	java/io/IOException
    //   27	32	89	finally
    //   36	46	89	finally
    //   27	32	93	java/lang/Exception
    //   36	46	93	java/lang/Exception
    //   5	27	97	finally
    //   111	120	97	finally
    //   122	130	97	finally
    //   132	139	97	finally
    //   141	151	97	finally
    //   5	27	105	java/lang/Exception
    //   155	159	161	java/io/IOException
    //   198	202	205	java/io/IOException
  }
  
  protected void onPostExecute(BufferedReader paramBufferedReader)
  {
    this.val$handler.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogLoader.1
 * JD-Core Version:    0.7.0.1
 */