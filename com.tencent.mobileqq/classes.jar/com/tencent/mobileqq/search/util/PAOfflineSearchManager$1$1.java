package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import bcnb;
import bcnc;
import com.tencent.qphone.base.util.QLog;
import nmj;

public class PAOfflineSearchManager$1$1
  implements Runnable
{
  public PAOfflineSearchManager$1$1(bcnc parambcnc) {}
  
  public void run()
  {
    String str = nmj.a("1011");
    if ((str == null) || (TextUtils.equals(str, ""))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PAOfflineSearchManager", 2, "callback get current ver:" + str + ", local ver:" + this.a.a.a);
      }
    } while ((str.equals(this.a.a.a)) && (!str.equals("0")));
    this.a.a.c = true;
    this.a.a.a = str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.PAOfflineSearchManager.1.1
 * JD-Core Version:    0.7.0.1
 */