package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class QCircleMsgProcessor$QCircleMsgTask
  implements Runnable
{
  private WeakReference<Context> a;
  private long b;
  
  QCircleMsgProcessor$QCircleMsgTask(QCircleMsgProcessor paramQCircleMsgProcessor, Context paramContext, long paramLong)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramLong;
  }
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      VSNetworkHelper.getInstance().sendRequest((Context)this.a.get(), ((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQQCircleGetGroupCountRequest(this.b), new QCircleMsgProcessor.QCircleMsgTask.1(this));
      return;
    }
    QLog.e("QCircleMsgProcessor", 2, "mContextRef == null || mContextRef.get() == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor.QCircleMsgTask
 * JD-Core Version:    0.7.0.1
 */