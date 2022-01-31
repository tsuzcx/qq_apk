package com.tencent.mobileqq.gamecenter.data;

import android.content.SharedPreferences;
import apxk;
import atmq;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class PadFaceManager$1
  implements Runnable
{
  public PadFaceManager$1(apxk paramapxk) {}
  
  public void run()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.this$0)
      {
        apxk.a(this.this$0, apxk.a(this.this$0).getApp().getSharedPreferences("gamecenter_sp" + apxk.a(this.this$0).getCurrentAccountUin(), 4));
        apxk.a(this.this$0, apxk.a(this.this$0).getLong("last_pad_face_request_time", 0L));
        apxk localapxk2 = this.this$0;
        if (apxk.a(this.this$0).getInt("pad_face_ad_enabled", 1) == 1)
        {
          apxk.a(localapxk2, bool);
          apxk.a(this.this$0, apxk.a(this.this$0).getInt("last_id_pad_face_shown", 0));
          apxk.b(this.this$0, apxk.a(this.this$0).getLong("last_time_pad_face_shown", 0L));
          apxk.c(this.this$0, apxk.a(this.this$0).getInt("request_interval", 2) * 3600000L);
          apxk.a(this.this$0, apxk.a(this.this$0).getEntityManagerFactory().createEntityManager());
          apxk.a(this.this$0);
          apxk.b(this.this$0, true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager.1
 * JD-Core Version:    0.7.0.1
 */