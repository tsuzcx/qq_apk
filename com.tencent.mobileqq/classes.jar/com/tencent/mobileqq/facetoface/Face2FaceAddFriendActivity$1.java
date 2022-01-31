package com.tencent.mobileqq.facetoface;

import alvm;
import alxj;
import android.text.TextUtils;
import aqkd;
import com.tencent.mobileqq.app.QQAppInterface;

class Face2FaceAddFriendActivity$1
  implements Runnable
{
  Face2FaceAddFriendActivity$1(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, alxj paramalxj) {}
  
  public void run()
  {
    if (this.this$0.b == 1) {
      if (!TextUtils.isEmpty(this.this$0.d)) {}
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          long l = Long.valueOf(this.this$0.d).longValue();
          boolean bool = this.a.a(l, 1);
          if (!bool)
          {
            Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
            this.this$0.f = 2;
            return;
          }
        }
        catch (Exception localException) {}
      }
      if (!this.a.a(0L, 1))
      {
        Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
        this.this$0.f = 2;
        return;
      }
    } while (this.this$0.a.a(this.this$0.app.getCurrentAccountUin(), false));
    this.this$0.e = 2;
    Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(6, 0L);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */