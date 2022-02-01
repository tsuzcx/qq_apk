package com.tencent.mobileqq.kandian.base.image.api.impl;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.kandian.base.image.RIJImageRequestHandler;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class PublicAccountHttpDownloaderImpl$PubAccoutImageReporter$WrapURLDrawableHandler
  implements URLDrawableHandler
{
  private URLDrawableHandler b;
  private PublicAccountHttpDownloaderImpl.PubAccoutImageReporter c;
  
  public PublicAccountHttpDownloaderImpl$PubAccoutImageReporter$WrapURLDrawableHandler(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter paramPubAccoutImageReporter1, URLDrawableHandler paramURLDrawableHandler, PublicAccountHttpDownloaderImpl.PubAccoutImageReporter paramPubAccoutImageReporter2)
  {
    this.b = paramURLDrawableHandler;
    this.c = paramPubAccoutImageReporter2;
  }
  
  public PublicAccountHttpDownloaderImpl.PubAccoutImageReporter a()
  {
    return this.c;
  }
  
  public void a(String paramString)
  {
    URLDrawableHandler localURLDrawableHandler = this.b;
    if ((localURLDrawableHandler instanceof RIJImageRequestHandler)) {
      ((RIJImageRequestHandler)localURLDrawableHandler).a(paramString);
    }
  }
  
  protected void b()
  {
    Object localObject1 = PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.c(this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("image download start: ");
    ((StringBuilder)localObject2).append(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.d(this.a));
    ((StringBuilder)localObject2).append(" supportInnerIp: ");
    ((StringBuilder)localObject2).append(PublicAccountHttpDownloaderImpl.access$400(this.a.b));
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (PublicAccountHttpDownloaderImpl.access$500(this.a.b))
    {
      localObject1 = InnerDns.getHostFromUrl(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.d(this.a));
      localObject2 = InnerDns.getInstance().reqSerAddrList((String)localObject1, 1002);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject1 = new StringBuilder();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ((StringBuilder)localObject1).append(((ServerAddr)((Iterator)localObject2).next()).toString());
          ((StringBuilder)localObject1).append(" ");
        }
        localObject2 = PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.c(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("InnerIp address ");
        localStringBuilder.append(localObject1);
        QLog.d((String)localObject2, 1, localStringBuilder.toString());
        return;
      }
      QLog.d(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.c(this.a), 1, "InnerIp address empty");
    }
  }
  
  public void doCancel()
  {
    this.b.doCancel();
  }
  
  public boolean isCancelled()
  {
    return this.b.isCancelled();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.c.a(false, paramInt);
    this.b.onFileDownloadFailed(paramInt);
  }
  
  public void onFileDownloadStarted()
  {
    this.c.c();
    this.b.onFileDownloadStarted();
    b();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.c.a(true, 0);
    this.b.onFileDownloadSucceed(paramLong);
  }
  
  public void publishProgress(int paramInt)
  {
    this.b.publishProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler
 * JD-Core Version:    0.7.0.1
 */