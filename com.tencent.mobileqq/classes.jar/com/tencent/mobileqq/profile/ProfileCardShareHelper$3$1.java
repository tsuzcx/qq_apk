package com.tencent.mobileqq.profile;

import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.QQToast;

class ProfileCardShareHelper$3$1
  implements Runnable
{
  ProfileCardShareHelper$3$1(ProfileCardShareHelper.3 param3, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.b.this$0.c();
    if (this.a != null)
    {
      ProfileCardShareHelper.a(this.b.this$0, ProfileCardShareHelper.a(this.b.this$0), ProfileCardShareHelper.i(this.b.this$0), this.a);
      return;
    }
    QQToast.makeText(ProfileCardShareHelper.j(this.b.this$0), 1, 2131916545, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */