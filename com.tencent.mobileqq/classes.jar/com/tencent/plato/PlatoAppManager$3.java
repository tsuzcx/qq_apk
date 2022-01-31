package com.tencent.plato;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

final class PlatoAppManager$3
  implements AsyncBack
{
  PlatoAppManager$3(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PlatoAppManager.access$000(), 2, "loadPlatoAppByBid loaded, code:" + paramInt + ", param :" + paramString);
    }
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        if ((PlatoAppManager.mLoadMode == 0) || (this.val$isNeedEvent)) {
          PlatoAppManager.loadBunderJSByBid(this.val$bid);
        }
        PlatoAppManager.jsLoad_status = 1;
        TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.val$startTime), "1", "", "");
        return;
      }
      if (paramString.contains("url"))
      {
        TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.val$startTime), "1-1", "", "");
        return;
      }
      if ((PlatoAppManager.mLoadMode == 0) || (this.val$isNeedEvent)) {
        PlatoAppManager.loadBunderJSByBid(this.val$bid);
      }
      PlatoAppManager.jsLoad_status = 0;
      TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.val$startTime), "0", "", "");
      return;
    }
    paramString = PlatoLoadEvent.createBundlerLoadEvent(1, this.val$bid, PlatoAppManager.getAbsFilePath(this.val$bid, "bundler.js"));
    Dispatchers.get().dispatch(paramString);
    TroopTechReportUtils.a("plato_v1", "bundler_download", String.valueOf(System.currentTimeMillis() - this.val$startTime), "-1", String.valueOf(paramInt), "");
  }
  
  public void progress(int paramInt)
  {
    QLog.d(PlatoAppManager.access$000(), 2, "progress:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppManager.3
 * JD-Core Version:    0.7.0.1
 */