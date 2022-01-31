package com.tencent.mobileqq.intervideo.huiyin;

import android.util.Log;
import aqnd;
import com.tencent.common.app.AppInterface;

public class HuiyinUtilsImpl$2
  implements Runnable
{
  public HuiyinUtilsImpl$2(aqnd paramaqnd, AppInterface paramAppInterface) {}
  
  public void run()
  {
    this.this$0.b = false;
    if (!aqnd.a(this.this$0))
    {
      aqnd.a(this.this$0, true);
      this.this$0.b(this.a);
      Log.i("huiyin.login", "retry login");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.HuiyinUtilsImpl.2
 * JD-Core Version:    0.7.0.1
 */