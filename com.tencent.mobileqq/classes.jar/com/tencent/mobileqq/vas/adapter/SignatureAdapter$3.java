package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;

class SignatureAdapter$3
  implements Runnable
{
  SignatureAdapter$3(SignatureAdapter paramSignatureAdapter, Bundle paramBundle) {}
  
  public void run()
  {
    int i = this.a.getInt("dynamicType");
    String str1 = this.a.getString("tplId");
    String str2 = this.a.getString("fileName");
    Object localObject;
    if (i != 16) {
      localObject = null;
    } else {
      localObject = SignatureTemplateConfig.a(str1, "dynamic_aio");
    }
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (DownloaderFactory.a(new File(SignatureTemplateConfig.a(str1, str2)), (File)localObject, true)) {
        SignatureAdapter.c(this.this$0).a().sendEmptyMessage(10003);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.3
 * JD-Core Version:    0.7.0.1
 */