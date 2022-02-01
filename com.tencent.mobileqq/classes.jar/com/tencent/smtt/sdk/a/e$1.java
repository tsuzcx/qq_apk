package com.tencent.smtt.sdk.a;

import android.os.Handler;
import com.tencent.smtt.utils.TbsLog;

class e$1
  implements Runnable
{
  e$1(e parame, e.a parama) {}
  
  public void run()
  {
    Object localObject = this.b;
    localObject = ((e)localObject).a(e.a((e)localObject));
    if (localObject != null)
    {
      e.b(this.b).post(new e.1.1(this, (String)localObject));
      return;
    }
    localObject = e.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected result for an empty http response: ");
    localStringBuilder.append(e.a(this.b));
    TbsLog.e((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.e.1
 * JD-Core Version:    0.7.0.1
 */