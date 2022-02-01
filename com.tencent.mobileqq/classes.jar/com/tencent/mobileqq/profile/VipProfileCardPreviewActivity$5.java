package com.tencent.mobileqq.profile;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;

class VipProfileCardPreviewActivity$5
  implements Runnable
{
  VipProfileCardPreviewActivity$5(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.a, false);
    if (localObject != null)
    {
      localObject = new BitmapDrawable(this.this$0.getResources(), (Bitmap)localObject);
      GlobalImageCache.a.put(this.a, localObject);
      localObject = this.this$0.y.obtainMessage();
      ((Message)localObject).what = 28;
      ((Message)localObject).arg1 = this.b;
      this.this$0.y.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.5
 * JD-Core Version:    0.7.0.1
 */