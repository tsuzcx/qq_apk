package com.tencent.mobileqq.vipav;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import mqq.app.AppRuntime;

class VipFunCallPreviewActivity$3
  implements Runnable
{
  VipFunCallPreviewActivity$3(VipFunCallPreviewActivity paramVipFunCallPreviewActivity, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.app;
    int i = this.this$0.a;
    BitmapDrawable localBitmapDrawable = null;
    localObject = BitmapManager.a(VipFunCallUtil.a((AppRuntime)localObject, i, 9, null));
    if (localObject != null) {
      localBitmapDrawable = new BitmapDrawable((Bitmap)localObject);
    }
    if (localBitmapDrawable != null) {
      this.this$0.z.sendMessage(Message.obtain(this.this$0.z, 51, this.a, 0, localBitmapDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */