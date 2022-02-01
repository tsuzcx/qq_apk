package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

class BindGroupConfirmActivity$3
  implements Runnable
{
  BindGroupConfirmActivity$3(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void run()
  {
    if (this.this$0.p == null) {
      return;
    }
    Object localObject2 = null;
    try
    {
      localObject1 = BitmapFactory.decodeResource(this.this$0.p, 2130843653);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject1;
      label29:
      break label29;
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("BindGroupConfirmActivity", 2, "initUI decodeResource has OutOfMemoryError!");
      localObject1 = localObject2;
    }
    if (localObject1 == null) {
      return;
    }
    localObject1 = AuthorityUtil.a(this.this$0, (Bitmap)localObject1, 50, 50);
    if (localObject1 == null) {
      return;
    }
    this.this$0.runOnUiThread(new BindGroupConfirmActivity.3.1(this, (Bitmap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.3
 * JD-Core Version:    0.7.0.1
 */