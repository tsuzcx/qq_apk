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
    //   1: astore_2
    //   2: new 27	java/io/BufferedReader
    //   5: dup
    //   6: new 29	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: getfield 13	com/tencent/qqmini/miniapp/util/logmonitor/LogLoader$1:val$process	Ljava/lang/Process;
    //   14: invokevirtual 35	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   17: invokespecial 38	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_2
    //   26: aload_1
    //   27: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +59 -> 91
    //   35: aload_1
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 15	com/tencent/qqmini/miniapp/util/logmonitor/LogLoader$1:val$handler	Lcom/tencent/qqmini/miniapp/util/logmonitor/LogLoader$LoadHandler;
    //   41: aload_3
    //   42: invokeinterface 51 2 0
    //   47: goto -23 -> 24
    //   50: astore_3
    //   51: aload_1
    //   52: astore_2
    //   53: ldc 53
    //   55: new 55	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   62: ldc 58
    //   64: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 74	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_1
    //   78: astore_2
    //   79: aload_1
    //   80: ifnull +9 -> 89
    //   83: aload_1
    //   84: invokevirtual 77	java/io/BufferedReader:close	()V
    //   87: aload_1
    //   88: astore_2
    //   89: aload_2
    //   90: areturn
    //   91: aload_1
    //   92: astore_2
    //   93: aload_1
    //   94: ifnull -5 -> 89
    //   97: aload_1
    //   98: invokevirtual 77	java/io/BufferedReader:close	()V
    //   101: aload_1
    //   102: areturn
    //   103: astore_2
    //   104: ldc 53
    //   106: new 55	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   113: ldc 79
    //   115: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_2
    //   119: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 74	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_1
    //   129: areturn
    //   130: astore_2
    //   131: ldc 53
    //   133: new 55	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   140: ldc 79
    //   142: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_2
    //   146: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 74	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_1
    //   156: areturn
    //   157: astore_1
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 77	java/io/BufferedReader:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_2
    //   169: ldc 53
    //   171: new 55	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   178: ldc 79
    //   180: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_2
    //   184: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 74	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: goto -27 -> 166
    //   196: astore_1
    //   197: goto -39 -> 158
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_1
    //   203: goto -152 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	1
    //   0	206	1	paramVarArgs	Void[]
    //   1	92	2	arrayOfVoid	Void[]
    //   103	16	2	localIOException1	java.io.IOException
    //   130	33	2	localIOException2	java.io.IOException
    //   168	16	2	localIOException3	java.io.IOException
    //   30	12	3	str	java.lang.String
    //   50	18	3	localException1	java.lang.Exception
    //   200	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   26	31	50	java/lang/Exception
    //   37	47	50	java/lang/Exception
    //   97	101	103	java/io/IOException
    //   83	87	130	java/io/IOException
    //   2	24	157	finally
    //   162	166	168	java/io/IOException
    //   26	31	196	finally
    //   37	47	196	finally
    //   53	77	196	finally
    //   2	24	200	java/lang/Exception
  }
  
  protected void onPostExecute(BufferedReader paramBufferedReader)
  {
    this.val$handler.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogLoader.1
 * JD-Core Version:    0.7.0.1
 */