package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import android.text.TextUtils;
import antf;
import bbux;
import bhmi;
import bhzb;
import bhzd;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import gm;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SignatureManagerForTool$1
  implements Runnable
{
  public SignatureManagerForTool$1(bbux parambbux, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Signature.TOOL", 2, "in getTemplateInfo info" + this.a);
    }
    Object localObject1 = (bhzd)bbux.a(this.this$0).get(Integer.valueOf(this.a));
    Object localObject2;
    boolean bool;
    if ((localObject1 == null) || (!((bhzd)localObject1).a.get())) {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getTemplateInfo info == null: ");
        if (localObject1 != null) {
          break label109;
        }
        bool = true;
        QLog.e("Signature.TOOL", 2, bool);
      }
    }
    label109:
    do
    {
      return;
      bool = false;
      break;
      localObject2 = new File(antf.bZ + this.a + File.separator + "config.json");
      if (!((File)localObject2).exists()) {
        break label208;
      }
      localObject2 = bhmi.a((File)localObject2, -1);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    bhzb.a((String)localObject2, (bhzd)localObject1);
    ((bhzd)localObject1).a.set(false);
    bbux.a(this.this$0);
    this.this$0.notifyObservers(Integer.valueOf(3));
    return;
    label208:
    this.this$0.notifyObservers(Integer.valueOf(9));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("id", this.a);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gm.d, (Bundle)localObject1, bbux.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.1
 * JD-Core Version:    0.7.0.1
 */