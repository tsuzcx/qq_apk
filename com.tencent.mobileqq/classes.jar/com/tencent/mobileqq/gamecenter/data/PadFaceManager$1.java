package com.tencent.mobileqq.gamecenter.data;

import android.content.SharedPreferences;
import aslq;
import awgg;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class PadFaceManager$1
  implements Runnable
{
  public PadFaceManager$1(aslq paramaslq) {}
  
  public void run()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.this$0)
      {
        aslq.a(this.this$0, aslq.a(this.this$0).getApp().getSharedPreferences("gamecenter_sp" + aslq.a(this.this$0).getCurrentAccountUin(), 4));
        aslq.a(this.this$0, aslq.a(this.this$0).getLong("last_pad_face_request_time", 0L));
        aslq localaslq2 = this.this$0;
        if (aslq.a(this.this$0).getInt("pad_face_ad_enabled", 1) == 1)
        {
          aslq.a(localaslq2, bool);
          aslq.a(this.this$0, aslq.a(this.this$0).getInt("last_id_pad_face_shown", 0));
          aslq.b(this.this$0, aslq.a(this.this$0).getLong("last_time_pad_face_shown", 0L));
          aslq.c(this.this$0, aslq.a(this.this$0).getInt("request_interval", 2) * 3600000L);
          aslq.a(this.this$0, aslq.a(this.this$0).getEntityManagerFactory().createEntityManager());
          aslq.a(this.this$0);
          aslq.b(this.this$0, true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager.1
 * JD-Core Version:    0.7.0.1
 */