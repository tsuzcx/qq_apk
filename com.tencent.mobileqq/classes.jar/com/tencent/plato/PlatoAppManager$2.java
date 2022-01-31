package com.tencent.plato;

import android.content.Context;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

final class PlatoAppManager$2
  implements AsyncBack
{
  PlatoAppManager$2(Context paramContext, AppRuntime paramAppRuntime, long paramLong, long[] paramArrayOfLong) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PlatoAppManager.access$000(), 2, "preInitV8So loaded,code=" + paramInt + ", param :" + paramString);
    }
    if (paramInt == 0)
    {
      if (paramString != null) {
        break label85;
      }
      PlatoAppManager.access$100(this.val$context, this.val$appRuntime);
      TroopTechReportUtils.a("plato_v1", "v8_so_unzip", String.valueOf(System.currentTimeMillis() - this.val$stratTime), "", "", "");
    }
    label85:
    do
    {
      return;
      if (paramString.contains("url"))
      {
        PlatoAppManager.sV8LibLoaded.set(false);
        this.val$downloadTime[0] = (System.currentTimeMillis() - this.val$stratTime);
        TroopTechReportUtils.a("plato_v1", "v8_so_download", String.valueOf(this.val$downloadTime[0]), "", "", "");
        return;
      }
    } while (PlatoAppManager.sV8LibLoaded.get());
    PlatoAppManager.access$100(this.val$context, this.val$appRuntime);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppManager.2
 * JD-Core Version:    0.7.0.1
 */