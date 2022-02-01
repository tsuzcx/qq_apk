package com.tencent.mobileqq.qwallet.hb.impl;

import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class HbThemeConfigApiImpl$2
  implements Runnable
{
  HbThemeConfigApiImpl$2(HbThemeConfigApiImpl paramHbThemeConfigApiImpl, String paramString, AppInterface paramAppInterface) {}
  
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update hbTheme config: ");
        localStringBuilder.append(this.a);
        QLog.d("HbThemeConfigApi", 2, localStringBuilder.toString());
      }
      FileUtils.writeFile(HbThemeConfigApiImpl.access$200(this.this$0, this.b), "hbThemeConfig.cfg", Base64.encodeToString(this.a.getBytes(), 0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.HbThemeConfigApiImpl.2
 * JD-Core Version:    0.7.0.1
 */