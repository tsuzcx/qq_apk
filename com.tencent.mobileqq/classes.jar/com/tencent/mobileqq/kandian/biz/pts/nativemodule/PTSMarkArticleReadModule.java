package com.tencent.mobileqq.kandian.biz.pts.nativemodule;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry.IPTSMarkArticleRead;
import com.tencent.qphone.base.util.QLog;

public class PTSMarkArticleReadModule
  implements PTSNativeModuleRegistry.IPTSMarkArticleRead
{
  public void markArticleRead(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[markArticleRead], articleID = ");
    localStringBuilder1.append(paramLong1);
    localStringBuilder1.append(", channelID = ");
    localStringBuilder1.append(paramLong2);
    QLog.i("PTSMarkArticleReadModule", 1, localStringBuilder1.toString());
    try
    {
      ReadInJoyLogicEngine.a().a(paramLong1, System.currentTimeMillis());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[markArticleRead], e = ");
      localStringBuilder2.append(localException);
      QLog.e("PTSMarkArticleReadModule", 1, localStringBuilder2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSMarkArticleReadModule
 * JD-Core Version:    0.7.0.1
 */