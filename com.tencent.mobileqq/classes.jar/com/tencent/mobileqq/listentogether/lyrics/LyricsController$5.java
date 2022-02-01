package com.tencent.mobileqq.listentogether.lyrics;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class LyricsController$5
  implements Runnable
{
  LyricsController$5(LyricsController paramLyricsController) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResumed: mHoldByPermissionType:");
      ((StringBuilder)localObject).append(this.this$0.g);
      ((StringBuilder)localObject).append(" mHoldByPermissionUin:");
      ((StringBuilder)localObject).append(this.this$0.h);
      QLog.d("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    ((LyricsController)localObject).w += 1;
    if ((LyricsController.b(this.this$0)) && (this.this$0.g != -1) && (!TextUtils.isEmpty(this.this$0.h)))
    {
      localObject = this.this$0;
      ((LyricsController)localObject).a(((LyricsController)localObject).g, this.this$0.h);
    }
    if (this.this$0.w >= 3)
    {
      localObject = this.this$0;
      ((LyricsController)localObject).f = false;
      ((LyricsController)localObject).w = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.5
 * JD-Core Version:    0.7.0.1
 */