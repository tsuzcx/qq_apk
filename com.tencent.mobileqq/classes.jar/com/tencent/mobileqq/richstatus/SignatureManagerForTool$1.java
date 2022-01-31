package com.tencent.mobileqq.richstatus;

import ajed;
import android.os.Bundle;
import android.text.TextUtils;
import avep;
import bace;
import baog;
import baoi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import gf;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SignatureManagerForTool$1
  implements Runnable
{
  public SignatureManagerForTool$1(avep paramavep, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = (baoi)avep.a(this.this$0).get(Integer.valueOf(this.a));
    Object localObject2;
    boolean bool;
    if ((localObject1 == null) || (!((baoi)localObject1).a.get())) {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getTemplateInfo info == null: ");
        if (localObject1 != null) {
          break label75;
        }
        bool = true;
        QLog.e("Signature.TOOL", 2, bool);
      }
    }
    label75:
    do
    {
      return;
      bool = false;
      break;
      localObject2 = new File(ajed.bN + this.a + File.separator + "config.json");
      if (!((File)localObject2).exists()) {
        break label174;
      }
      localObject2 = bace.a((File)localObject2, -1);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    baog.a((String)localObject2, (baoi)localObject1);
    ((baoi)localObject1).a.set(false);
    avep.a(this.this$0);
    this.this$0.notifyObservers(Integer.valueOf(3));
    return;
    label174:
    this.this$0.notifyObservers(Integer.valueOf(9));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("id", this.a);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gf.d, (Bundle)localObject1, avep.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.1
 * JD-Core Version:    0.7.0.1
 */