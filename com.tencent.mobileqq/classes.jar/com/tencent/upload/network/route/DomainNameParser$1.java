package com.tencent.upload.network.route;

import android.text.TextUtils;
import com.tencent.upload.utils.UploadLog;
import java.net.InetAddress;
import java.util.Map;

final class DomainNameParser$1
  implements Runnable
{
  DomainNameParser$1(String paramString, byte[] paramArrayOfByte, DomainNameParser.ParseResult paramParseResult) {}
  
  public void run()
  {
    String str2 = Thread.currentThread().getName();
    Object localObject1 = null;
    try
    {
      String str1 = InetAddress.getByName(this.val$domainName).getHostAddress();
      localObject1 = str1;
      localStringBuilder = new StringBuilder();
      localObject1 = str1;
      localStringBuilder.append("parse: getByName, get parsed ip:");
      localObject1 = str1;
      localStringBuilder.append(str1);
      localObject1 = str1;
      localStringBuilder.append(" domainName:");
      localObject1 = str1;
      localStringBuilder.append(this.val$domainName);
      localObject1 = str1;
      localStringBuilder.append(" ");
      localObject1 = str1;
      localStringBuilder.append(str2);
      localObject1 = str1;
      UploadLog.i("DomainNameParser", localStringBuilder.toString());
      localObject1 = str1;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse: Error:");
      localStringBuilder.append(localThrowable);
      UploadLog.w("DomainNameParser", localStringBuilder.toString());
    }
    synchronized (this.val$lock)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        DomainNameParser.access$000().put(this.val$domainName, localObject1);
      }
      this.val$parseResult.parsedIp = ((String)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("notify parsed ip:");
      ((StringBuilder)localObject1).append(this.val$parseResult.parsedIp);
      ((StringBuilder)localObject1).append(" domainName:");
      ((StringBuilder)localObject1).append(this.val$domainName);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(" lock obj :");
      ((StringBuilder)localObject1).append(this.val$lock.hashCode());
      UploadLog.i("DomainNameParser", ((StringBuilder)localObject1).toString());
      this.val$lock.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.DomainNameParser.1
 * JD-Core Version:    0.7.0.1
 */