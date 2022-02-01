package cooperation.qzone;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.feed.CertifiedFakeFeed;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.List;

class QzoneIPCModule$3
  implements EIPCResultCallback
{
  QzoneIPCModule$3(QzoneIPCModule paramQzoneIPCModule) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ArrayList localArrayList;
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data;
      paramEIPCResult.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
      localArrayList = paramEIPCResult.getParcelableArrayList("KEY_CERTIFIED_FAKE_FEED_LIST");
      if (localArrayList != null) {
        SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(localArrayList));
      }
      SimpleEventBus.getInstance().dispatchEvent(new PublishBoxStatusEvent(paramEIPCResult));
      if (localArrayList != null) {
        break label93;
      }
    }
    label93:
    for (int i = 0;; i = localArrayList.size())
    {
      QLog.d("QzoneIPCModule", 4, String.format("Get certifed account task list %b", new Object[] { Integer.valueOf(i) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.3
 * JD-Core Version:    0.7.0.1
 */