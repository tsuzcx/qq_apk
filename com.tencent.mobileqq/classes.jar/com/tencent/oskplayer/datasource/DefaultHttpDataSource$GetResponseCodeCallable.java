package com.tencent.oskplayer.datasource;

import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class DefaultHttpDataSource$GetResponseCodeCallable
  implements Callable<Integer>
{
  private HttpURLConnection mConnection;
  
  public DefaultHttpDataSource$GetResponseCodeCallable(HttpURLConnection paramHttpURLConnection)
  {
    this.mConnection = paramHttpURLConnection;
  }
  
  public Integer call()
  {
    return Integer.valueOf(this.mConnection.getResponseCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultHttpDataSource.GetResponseCodeCallable
 * JD-Core Version:    0.7.0.1
 */