package com.tencent.mobileqq.profilecard.bussiness.qzone;

import android.os.Message;
import anmw;
import azfe;
import azow;
import bkgm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class ProfileQZoneComponent$6
  implements Runnable
{
  public ProfileQZoneComponent$6(azow paramazow) {}
  
  public void run()
  {
    int j = 0;
    azfe localazfe = (azfe)azow.a(this.this$0);
    Object localObject = (anmw)azow.a(this.this$0).getManager(51);
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
        if (azow.a(this.this$0) != null) {
          azow.a(this.this$0).sendMessage(localMessage);
        }
        i = j;
        if (localazfe.a != null) {
          i = localazfe.a.h;
        }
        azow.a(this.this$0, i);
        return;
        localObject = ((anmw)localObject).b(localazfe.a.a);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.6
 * JD-Core Version:    0.7.0.1
 */