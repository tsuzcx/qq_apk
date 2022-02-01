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
    if (i != 16) {
      ??? = null;
    } else {
      ??? = SignatureTemplateConfig.a(str1, "dynamic_aio");
    }
    if (??? != null)
    {
      ??? = new File((String)???);
      boolean bool = DownloaderFactory.a(new File(SignatureTemplateConfig.a(str1, str2)), (File)???, true);
      if (TroopNickAdapter.a(this.this$0) == null) {
        return;
      }
      synchronized (TroopNickAdapter.a(this.this$0))
      {
        if (TroopNickAdapter.a(this.this$0) == null) {
          return;
        }
        if (bool) {
          TroopNickAdapter.a(this.this$0).a().sendEmptyMessage(10003);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.3
 * JD-Core Version:    0.7.0.1
 */