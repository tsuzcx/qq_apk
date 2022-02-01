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
  private long jdField_a_of_type_Long;
  private WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference;
  
  QCircleMsgProcessor$QCircleMsgTask(QCircleMsgProcessor paramQCircleMsgProcessor, Context paramContext, long paramLong)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      VSNetworkHelper.getInstance().sendRequest((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQQCircleGetGroupCountRequest(this.jdField_a_of_type_Long), new QCircleMsgProcessor.QCircleMsgTask.1(this));
      return;
    }
    QLog.e("QCircleMsgProcessor", 2, "mContextRef == null || mContextRef.get() == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor.QCircleMsgTask
 * JD-Core Version:    0.7.0.1
 */