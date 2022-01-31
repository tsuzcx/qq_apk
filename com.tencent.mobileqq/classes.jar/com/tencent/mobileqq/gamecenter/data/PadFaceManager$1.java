package com.tencent.mobileqq.gamecenter.data;

import android.content.SharedPreferences;
import aqro;
import aukq;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class PadFaceManager$1
  implements Runnable
{
  public PadFaceManager$1(aqro paramaqro) {}
  
  public void run()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.this$0)
      {
        aqro.a(this.this$0, aqro.a(this.this$0).getApp().getSharedPreferences("gamecenter_sp" + aqro.a(this.this$0).getCurrentAccountUin(), 4));
        aqro.a(this.this$0, aqro.a(this.this$0).getLong("last_pad_face_request_time", 0L));
        aqro localaqro2 = this.this$0;
        if (aqro.a(this.this$0).getInt("pad_face_ad_enabled", 1) == 1)
        {
          aqro.a(localaqro2, bool);
          aqro.a(this.this$0, aqro.a(this.this$0).getInt("last_id_pad_face_shown", 0));
          aqro.b(this.this$0, aqro.a(this.this$0).getLong("last_time_pad_face_shown", 0L));
          aqro.c(this.this$0, aqro.a(this.this$0).getInt("request_interval", 2) * 3600000L);
          aqro.a(this.this$0, aqro.a(this.this$0).getEntityManagerFactory().createEntityManager());
          aqro.a(this.this$0);
          aqro.b(this.this$0, true);
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