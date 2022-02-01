package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PendantInfo$2
  implements Runnable
{
  PendantInfo$2(PendantInfo paramPendantInfo, int paramInt, long paramLong, Drawable paramDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getDrawable, Runnable in");
    }
    String str = AvatarPendantUtil.b(this.this$0.p, this.a);
    if (2 == this.a) {
      str = AvatarPendantUtil.b(this.this$0.p, 8);
    }
    if (FileUtils.fileExists(str))
    {
      if (2 == this.a)
      {
        this.this$0.b();
        if (this.this$0.u == null)
        {
          this.this$0.a(this.a, this.b);
          return;
        }
        PendantInfo.a(this.this$0, this.b, this.a);
        return;
      }
      this.this$0.a(this.c, false, this.b);
      return;
    }
    this.this$0.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.2
 * JD-Core Version:    0.7.0.1
 */