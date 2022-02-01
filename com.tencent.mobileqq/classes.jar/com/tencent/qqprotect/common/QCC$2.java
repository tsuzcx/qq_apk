package com.tencent.qqprotect.common;

import com.tencent.startrail.T;

final class QCC$2
  implements Runnable
{
  public void run()
  {
    int i = T.a("qq.key");
    if (i != 0)
    {
      byte[] arrayOfByte = T.a(i, 0);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        QCC.a(this.a, arrayOfByte);
      }
      T.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.QCC.2
 * JD-Core Version:    0.7.0.1
 */