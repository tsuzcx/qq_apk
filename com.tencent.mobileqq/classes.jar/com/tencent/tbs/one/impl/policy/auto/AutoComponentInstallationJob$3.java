package com.tencent.tbs.one.impl.policy.auto;

import com.tencent.tbs.one.impl.net.HttpRequestJob.Client;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

class AutoComponentInstallationJob$3
  implements HttpRequestJob.Client
{
  AutoComponentInstallationJob$3(AutoComponentInstallationJob paramAutoComponentInstallationJob, int paramInt) {}
  
  public void onResponseReceived(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    AutoComponentInstallationJob.access$1200(this.this$0, paramInt, paramMap, paramInputStream, this.val$localVersionCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob.3
 * JD-Core Version:    0.7.0.1
 */