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
      Object localObject = (HttpURLConnection)new URL(this.val$path).openConnection();
      ((HttpURLConnection)localObject).setConnectTimeout(5000);
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      int i = ((HttpURLConnection)localObject).getResponseCode();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report code: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", path: ");
      ((StringBuilder)localObject).append(this.val$path);
      RLog.d("SLAReporter", new Object[] { ((StringBuilder)localObject).toString() });
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report error: ");
      localStringBuilder.append(localException);
      localStringBuilder.append(", path: ");
      localStringBuilder.append(this.val$path);
      RLog.w("SLAReporter", new Object[] { localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftframework.sla.SLAReporter.1
 * JD-Core Version:    0.7.0.1
 */