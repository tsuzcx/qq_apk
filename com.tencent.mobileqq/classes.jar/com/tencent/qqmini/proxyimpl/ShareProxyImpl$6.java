package com.tencent.qqmini.proxyimpl;

import aljq;
import bdcs;
import java.io.File;

class ShareProxyImpl$6
  implements Runnable
{
  ShareProxyImpl$6(ShareProxyImpl paramShareProxyImpl, File paramFile, String paramString) {}
  
  public void run()
  {
    File localFile = new File(aljq.bd);
    localFile.mkdirs();
    if (this.val$localPic.exists())
    {
      localFile = new File(localFile, this.val$fileName);
      bdcs.a(this.val$localPic, localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */