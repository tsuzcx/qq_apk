package com.tencent.mobileqq.gamecenter.data;

import android.content.SharedPreferences;
import avce;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;

public class PadFaceManager$1
  implements Runnable
{
  public PadFaceManager$1(avce paramavce) {}
  
  public void run()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.this$0)
      {
        avce.a(this.this$0, avce.a(this.this$0).getApp().getSharedPreferences("gamecenter_sp" + avce.a(this.this$0).getCurrentAccountUin(), 4));
        avce.a(this.this$0, avce.a(this.this$0).getLong("last_pad_face_request_time", 0L));
        avce localavce2 = this.this$0;
        if (avce.a(this.this$0).getInt("pad_face_ad_enabled", 1) == 1)
        {
          avce.a(localavce2, bool);
          avce.a(this.this$0, avce.a(this.this$0).getInt("last_id_pad_face_shown", 0));
          avce.b(this.this$0, avce.a(this.this$0).getLong("last_time_pad_face_shown", 0L));
          avce.c(this.this$0, avce.a(this.this$0).getInt("request_interval", 2) * 3600000L);
          avce.a(this.this$0, avce.a(this.this$0).getEntityManagerFactory().createEntityManager());
          avce.a(this.this$0);
          avce.b(this.this$0, true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager.1
 * JD-Core Version:    0.7.0.1
 */