package com.tencent.mobileqq.richstatus;

import alof;
import android.os.Bundle;
import android.text.TextUtils;
import aydw;
import bdhb;
import bdtt;
import bdtv;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import gh;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SignatureManagerForTool$1
  implements Runnable
{
  public SignatureManagerForTool$1(aydw paramaydw, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Signature.TOOL", 2, "in getTemplateInfo info" + this.a);
    }
    Object localObject1 = (bdtv)aydw.a(this.this$0).get(Integer.valueOf(this.a));
    Object localObject2;
    boolean bool;
    if ((localObject1 == null) || (!((bdtv)localObject1).a.get())) {
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
      localObject2 = new File(alof.bW + this.a + File.separator + "config.json");
      if (!((File)localObject2).exists()) {
        break label208;
      }
      localObject2 = bdhb.a((File)localObject2, -1);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    bdtt.a((String)localObject2, (bdtv)localObject1);
    ((bdtv)localObject1).a.set(false);
    aydw.a(this.this$0);
    this.this$0.notifyObservers(Integer.valueOf(3));
    return;
    label208:
    this.this$0.notifyObservers(Integer.valueOf(9));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("id", this.a);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gh.d, (Bundle)localObject1, aydw.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.1
 * JD-Core Version:    0.7.0.1
 */