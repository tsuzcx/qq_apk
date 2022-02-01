package com.tencent.open.adapter;

import android.content.Context;
import com.tencent.open.base.LogUtility;
import java.util.HashMap;

final class OpenAppClient$2
  implements Runnable
{
  OpenAppClient$2(Context paramContext, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      OpenAppClient.b(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushMsg exception: ");
      ((StringBuilder)localObject).append(this.b);
      localObject = ((StringBuilder)localObject).toString();
      LogUtility.c(OpenAppClient.a, (String)localObject, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.2
 * JD-Core Version:    0.7.0.1
 */