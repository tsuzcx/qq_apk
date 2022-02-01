package com.tencent.raft.raftframework.sla;

import com.tencent.raft.raftframework.log.RLog;
import java.net.HttpURLConnection;
import java.net.URL;

class SLAReporter$1
  implements Runnable
{
  SLAReporter$1(SLAReporter paramSLAReporter, String paramString) {}
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.val$path).openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setRequestMethod("GET");
      int i = localHttpURLConnection.getResponseCode();
      RLog.d("SLAReporter", new Object[] { "report code: " + i + ", path: " + this.val$path });
      return;
    }
    catch (Exception localException)
    {
      RLog.w("SLAReporter", new Object[] { "report error: " + localException + ", path: " + this.val$path });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftframework.sla.SLAReporter.1
 * JD-Core Version:    0.7.0.1
 */