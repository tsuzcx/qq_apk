package com.tencent.open.agent;

import android.graphics.Bitmap;
import befn;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class OpenSelectPermissionFragment$1
  implements Runnable
{
  OpenSelectPermissionFragment$1(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void run()
  {
    Bitmap localBitmap = OpenSelectPermissionFragment.a(this.this$0).a(String.valueOf(OpenSelectPermissionFragment.a(this.this$0)));
    if (localBitmap != null) {
      befn.a(new OpenSelectPermissionFragment.1.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.1
 * JD-Core Version:    0.7.0.1
 */