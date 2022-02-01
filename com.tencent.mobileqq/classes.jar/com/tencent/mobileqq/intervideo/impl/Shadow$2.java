package com.tencent.mobileqq.intervideo.impl;

import com.tencent.mobileqq.intervideo.ICdnPmUpdater.PmUpdaterListener;
import com.tencent.qphone.base.util.QLog;

final class Shadow$2
  implements ICdnPmUpdater.PmUpdaterListener
{
  Shadow$2(String paramString) {}
  
  public void a()
  {
    synchronized ()
    {
      Shadow.a(null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pluginManagerWrapper pmUpdaterCallBcak : bizType:");
      localStringBuilder.append(this.a);
      QLog.i("shadow::Shadow", 2, localStringBuilder.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.Shadow.2
 * JD-Core Version:    0.7.0.1
 */