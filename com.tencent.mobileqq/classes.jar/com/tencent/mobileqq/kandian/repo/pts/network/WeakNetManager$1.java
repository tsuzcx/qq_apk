package com.tencent.mobileqq.kandian.repo.pts.network;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.pts.WeakNetHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class WeakNetManager$1
  implements Runnable
{
  WeakNetManager$1(WeakNetManager paramWeakNetManager, long paramLong) {}
  
  public void run()
  {
    WeakNetManager.a(this.this$0, null);
    if (WeakNetHelper.a())
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 1, 2131915605, 1).show();
      try
      {
        WeakNetHelper.a("0X8009D08", RIJTransMergeKanDianReport.g().addString("loading_time", String.valueOf(this.a)).build());
      }
      catch (JSONException localJSONException)
      {
        QLog.e("WeakNetManager", 1, "show weak net data report exception, e = ", localJSONException);
      }
      QLog.d("WeakNetManager", 1, "show weak net toast.");
      return;
    }
    QLog.d("WeakNetManager", 1, "no need to show toast.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.network.WeakNetManager.1
 * JD-Core Version:    0.7.0.1
 */