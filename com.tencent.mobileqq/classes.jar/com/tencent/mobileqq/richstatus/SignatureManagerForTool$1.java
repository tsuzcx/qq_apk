package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class SignatureManagerForTool$1
  implements Runnable
{
  SignatureManagerForTool$1(SignatureManagerForTool paramSignatureManagerForTool, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("in getTemplateInfo info");
      ((StringBuilder)localObject1).append(this.a);
      QLog.e("Signature.TOOL", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (SignatureTemplateInfo)SignatureManagerForTool.a(this.this$0).get(Integer.valueOf(this.a));
    boolean bool = false;
    Object localObject2;
    if ((localObject1 != null) && (((SignatureTemplateInfo)localObject1).a.get()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("config.json");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists())
      {
        localObject2 = FileUtils.readFileToStringEx((File)localObject2, -1);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          SignatureTemplateConfig.a((String)localObject2, (SignatureTemplateInfo)localObject1);
          ((SignatureTemplateInfo)localObject1).a.set(false);
          SignatureManagerForTool.a(this.this$0);
          this.this$0.notifyObservers(Integer.valueOf(3));
        }
      }
      else
      {
        this.this$0.notifyObservers(Integer.valueOf(9));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("id", this.a);
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.d, (Bundle)localObject1, SignatureManagerForTool.a(this.this$0));
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTemplateInfo info == null: ");
      if (localObject1 == null) {
        bool = true;
      }
      ((StringBuilder)localObject2).append(bool);
      QLog.e("Signature.TOOL", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.1
 * JD-Core Version:    0.7.0.1
 */