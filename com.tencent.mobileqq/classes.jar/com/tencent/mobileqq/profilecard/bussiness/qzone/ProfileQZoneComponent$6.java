package com.tencent.mobileqq.profilecard.bussiness.qzone;

import amsw;
import android.os.Message;
import aymg;
import ayxd;
import bjng;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class ProfileQZoneComponent$6
  implements Runnable
{
  public ProfileQZoneComponent$6(ayxd paramayxd) {}
  
  public void run()
  {
    int j = 0;
    aymg localaymg = (aymg)ayxd.a(this.this$0);
    Object localObject = (amsw)ayxd.a(this.this$0).getManager(51);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label161;
      }
      localObject = new Card();
    }
    label161:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (i != 0) {}
      for (localMessage.what = 6;; localMessage.what = 5)
      {
        if (ayxd.a(this.this$0) != null) {
          ayxd.a(this.this$0).sendMessage(localMessage);
        }
        i = j;
        if (localaymg.a != null) {
          i = localaymg.a.h;
        }
        ayxd.a(this.this$0, i);
        return;
        localObject = ((amsw)localObject).b(localaymg.a.a);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.6
 * JD-Core Version:    0.7.0.1
 */