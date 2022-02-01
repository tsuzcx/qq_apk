package com.tencent.mobileqq.secspy;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;

class SecSpyFileManager$2$1
  extends ResultReceiver
{
  SecSpyFileManager$2$1(SecSpyFileManager.2 param2, Handler paramHandler, String paramString1, String paramString2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    long l = paramBundle.getLong("seq");
    if ((paramInt != -2) && (paramInt != -1))
    {
      if (paramInt != 0)
      {
        paramBundle = this.c.this$0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("x5 log upload failed, x5 upload result code = ");
        localStringBuilder.append(paramInt);
        paramBundle.a(l, -1, new Object[] { localStringBuilder.toString() });
        return;
      }
      this.c.this$0.a(l, 0, new Object[0]);
      return;
    }
    SecSpyFileManager.a(this.c.this$0, this.a, this.c.this$0.d.getCurrentAccountUin(), l, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.2.1
 * JD-Core Version:    0.7.0.1
 */