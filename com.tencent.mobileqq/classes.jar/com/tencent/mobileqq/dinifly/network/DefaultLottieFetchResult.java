package com.tencent.mobileqq.dinifly.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class DefaultLottieFetchResult
  implements LottieFetchResult
{
  @NonNull
  private final HttpURLConnection connection;
  
  public DefaultLottieFetchResult(@NonNull HttpURLConnection paramHttpURLConnection)
  {
    this.connection = paramHttpURLConnection;
  }
  
  /* Error */
  private String getErrorFromConnection(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: new 24	java/io/BufferedReader
    //   3: dup
    //   4: new 26	java/io/InputStreamReader
    //   7: dup
    //   8: aload_1
    //   9: invokevirtual 32	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   12: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   15: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_1
    //   19: new 40	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: aload_1
    //   28: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +19 -> 52
    //   36: aload_2
    //   37: aload_3
    //   38: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: bipush 10
    //   45: invokevirtual 52	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: goto -22 -> 27
    //   52: aload_1
    //   53: invokevirtual 55	java/io/BufferedReader:close	()V
    //   56: aload_2
    //   57: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: areturn
    //   61: astore_2
    //   62: goto +6 -> 68
    //   65: astore_2
    //   66: aload_2
    //   67: athrow
    //   68: aload_1
    //   69: invokevirtual 55	java/io/BufferedReader:close	()V
    //   72: goto +5 -> 77
    //   75: aload_2
    //   76: athrow
    //   77: goto -2 -> 75
    //   80: astore_1
    //   81: goto -25 -> 56
    //   84: astore_1
    //   85: goto -13 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	DefaultLottieFetchResult
    //   0	88	1	paramHttpURLConnection	HttpURLConnection
    //   26	31	2	localStringBuilder	StringBuilder
    //   61	1	2	localObject	Object
    //   65	11	2	localException	java.lang.Exception
    //   31	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   27	32	61	finally
    //   36	49	61	finally
    //   66	68	61	finally
    //   27	32	65	java/lang/Exception
    //   36	49	65	java/lang/Exception
    //   52	56	80	java/lang/Exception
    //   68	72	84	java/lang/Exception
  }
  
  @NonNull
  public InputStream bodyByteStream()
  {
    return this.connection.getInputStream();
  }
  
  public void close()
  {
    this.connection.disconnect();
  }
  
  @Nullable
  public String contentType()
  {
    return this.connection.getContentType();
  }
  
  @Nullable
  public String error()
  {
    try
    {
      if (isSuccessful()) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to fetch ");
      ((StringBuilder)localObject).append(this.connection.getURL());
      ((StringBuilder)localObject).append(". Failed with ");
      ((StringBuilder)localObject).append(this.connection.getResponseCode());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(getErrorFromConnection(this.connection));
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      Logger.warning("get error failed ", localIOException);
      return localIOException.getMessage();
    }
  }
  
  public boolean isSuccessful()
  {
    boolean bool = false;
    try
    {
      int i = this.connection.getResponseCode() / 100;
      if (i == 2) {
        bool = true;
      }
      return bool;
    }
    catch (IOException localIOException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.DefaultLottieFetchResult
 * JD-Core Version:    0.7.0.1
 */