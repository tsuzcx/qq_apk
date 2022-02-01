package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;

class PAOfflineSearchManager$1$1
  implements Runnable
{
  PAOfflineSearchManager$1$1(PAOfflineSearchManager.1 param1) {}
  
  public void run()
  {
    String str = HtmlOffline.d("1011");
    if (str != null)
    {
      if (TextUtils.equals(str, "")) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("callback get current ver:");
        localStringBuilder.append(str);
        localStringBuilder.append(", local ver:");
        localStringBuilder.append(this.a.a.e);
        QLog.d("PAOfflineSearchManager", 2, localStringBuilder.toString());
      }
      if ((str.equals(this.a.a.e)) && (!str.equals("0"))) {
        return;
      }
      this.a.a.g = true;
      this.a.a.e = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.PAOfflineSearchManager.1.1
 * JD-Core Version:    0.7.0.1
 */