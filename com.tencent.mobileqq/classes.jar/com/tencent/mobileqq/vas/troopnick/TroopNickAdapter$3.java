package com.tencent.mobileqq.vas.troopnick;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;

class TroopNickAdapter$3
  implements Runnable
{
  TroopNickAdapter$3(TroopNickAdapter paramTroopNickAdapter, Bundle paramBundle) {}
  
  public void run()
  {
    int i = this.a.getInt("dynamicType");
    String str1 = this.a.getString("tplId");
    String str2 = this.a.getString("fileName");
    ??? = null;
    switch (i)
    {
    }
    boolean bool;
    for (;;)
    {
      if (??? != null)
      {
        ??? = new File((String)???);
        bool = DownloaderFactory.a(new File(SignatureTemplateConfig.a(str1, str2)), (File)???, true);
        if (TroopNickAdapter.a(this.this$0) != null) {
          break;
        }
      }
      return;
      ??? = SignatureTemplateConfig.a(str1, "dynamic_aio");
    }
    synchronized (TroopNickAdapter.a(this.this$0))
    {
      if (TroopNickAdapter.a(this.this$0) == null) {
        return;
      }
    }
    if (bool) {
      TroopNickAdapter.a(this.this$0).a().sendEmptyMessage(10003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.3
 * JD-Core Version:    0.7.0.1
 */