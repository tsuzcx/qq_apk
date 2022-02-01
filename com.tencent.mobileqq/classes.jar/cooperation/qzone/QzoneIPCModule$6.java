package cooperation.qzone;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qqcircle.events.QCircleFeedEvent;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

class QzoneIPCModule$6
  implements EIPCResultCallback
{
  QzoneIPCModule$6(QzoneIPCModule paramQzoneIPCModule) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data;
      paramEIPCResult.setClassLoader(QCircleFakeFeed.class.getClassLoader());
      paramEIPCResult = paramEIPCResult.getParcelableArrayList("KEY_CERTIFIED_FAKE_FEED_LIST");
      if (paramEIPCResult != null) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramEIPCResult));
      }
      if (paramEIPCResult != null) {
        break label79;
      }
    }
    label79:
    for (int i = 0;; i = paramEIPCResult.size())
    {
      QLog.d("QzoneIPCModule", 4, String.format("Get QCircleFakeFeed task list %b", new Object[] { Integer.valueOf(i) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.6
 * JD-Core Version:    0.7.0.1
 */