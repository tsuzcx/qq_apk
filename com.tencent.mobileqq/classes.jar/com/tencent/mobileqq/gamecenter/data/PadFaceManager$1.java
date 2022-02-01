package com.tencent.mobileqq.gamecenter.data;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;

class PadFaceManager$1
  implements Runnable
{
  PadFaceManager$1(PadFaceManager paramPadFaceManager) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0)
      {
        PadFaceManager localPadFaceManager2 = this.this$0;
        BaseApplication localBaseApplication = PadFaceManager.a(this.this$0).getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gamecenter_sp");
        localStringBuilder.append(PadFaceManager.a(this.this$0).getCurrentAccountUin());
        PadFaceManager.a(localPadFaceManager2, localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4));
        PadFaceManager.a(this.this$0, PadFaceManager.a(this.this$0).getLong("last_pad_face_request_time", 0L));
        localPadFaceManager2 = this.this$0;
        if (PadFaceManager.a(this.this$0).getInt("pad_face_ad_enabled", 1) == 1)
        {
          bool = true;
          PadFaceManager.a(localPadFaceManager2, bool);
          PadFaceManager.a(this.this$0, PadFaceManager.a(this.this$0).getInt("last_id_pad_face_shown", 0));
          PadFaceManager.b(this.this$0, PadFaceManager.a(this.this$0).getLong("last_time_pad_face_shown", 0L));
          PadFaceManager.c(this.this$0, PadFaceManager.a(this.this$0).getInt("request_interval", 2) * 3600000L);
          PadFaceManager.a(this.this$0, PadFaceManager.a(this.this$0).getEntityManagerFactory().createEntityManager());
          PadFaceManager.a(this.this$0);
          PadFaceManager.b(this.this$0, true);
          return;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager.1
 * JD-Core Version:    0.7.0.1
 */