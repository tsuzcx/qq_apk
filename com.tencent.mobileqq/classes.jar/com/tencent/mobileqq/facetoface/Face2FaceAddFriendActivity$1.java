package com.tencent.mobileqq.facetoface;

import android.text.TextUtils;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class Face2FaceAddFriendActivity$1
  implements Runnable
{
  Face2FaceAddFriendActivity$1(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, NearFieldTroopHandler paramNearFieldTroopHandler) {}
  
  public void run()
  {
    if (this.this$0.e == 1) {
      if (TextUtils.isEmpty(this.this$0.f)) {
        return;
      }
    }
    try
    {
      long l = Long.valueOf(this.this$0.f).longValue();
      boolean bool = this.a.a(l, 1);
      if (!bool)
      {
        Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
        this.this$0.u = 2;
        return;
        if (!this.a.a(0L, 1))
        {
          Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
          this.this$0.u = 2;
          return;
        }
        if (!this.this$0.ah.a(this.this$0.app.getCurrentAccountUin(), false))
        {
          Face2FaceAddFriendActivity localFace2FaceAddFriendActivity = this.this$0;
          localFace2FaceAddFriendActivity.t = 2;
          Face2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */