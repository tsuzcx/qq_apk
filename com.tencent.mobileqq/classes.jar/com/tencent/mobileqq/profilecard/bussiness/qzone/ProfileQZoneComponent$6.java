package com.tencent.mobileqq.profilecard.bussiness.qzone;

import android.os.Message;
import anvk;
import azrb;
import baca;
import bkys;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;

public class ProfileQZoneComponent$6
  implements Runnable
{
  public ProfileQZoneComponent$6(baca parambaca) {}
  
  public void run()
  {
    int j = 0;
    azrb localazrb = (azrb)baca.a(this.this$0);
    Object localObject = (anvk)baca.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label162;
      }
      localObject = new Card();
    }
    label162:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (i != 0) {}
      for (localMessage.what = 6;; localMessage.what = 5)
      {
        if (baca.a(this.this$0) != null) {
          baca.a(this.this$0).sendMessage(localMessage);
        }
        i = j;
        if (localazrb.a != null) {
          i = localazrb.a.h;
        }
        baca.a(this.this$0, i);
        return;
        localObject = ((anvk)localObject).b(localazrb.a.a);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.6
 * JD-Core Version:    0.7.0.1
 */