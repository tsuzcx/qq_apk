package com.tencent.mobileqq.debug;

import android.os.Environment;
import com.tencent.util.Pair;

final class CIOSubmitUtils$1
  implements Runnable
{
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject).append("/cio_mobile_qq");
    localObject = ((StringBuilder)localObject).toString();
    CIOSubmitUtils.a((String)localObject);
    CIOSubmitUtils.a((String)localObject, this.a, this.b, this.c, this.d);
    localObject = CIOSubmitUtils.a((String)localObject, "com.tencent.mobileqq");
    CIOSubmitUtils.a((String)((Pair)localObject).first, (String)((Pair)localObject).second);
    CIOSubmitUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.CIOSubmitUtils.1
 * JD-Core Version:    0.7.0.1
 */