package com.tencent.mobileqq.winkpublish.data;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IDataManager;
import com.tencent.mobileqq.winkpublish.event.WinkDraftStatusEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WinkSimpleEventDaftManager
  implements WinkBaseSimpleEventManager
{
  private void a(WinkDraftStatusEvent paramWinkDraftStatusEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WinkSimpleEventDaftManager", 1, new Object[] { "[handleDraftEvent] event: ", paramWinkDraftStatusEvent });
    }
    String str = paramWinkDraftStatusEvent.getMissionId();
    if (paramWinkDraftStatusEvent.getUploadStatus() != -1) {
      ((IDataManager)QRoute.api(IDataManager.class)).updateUploadStatus(HostDataTransUtils.getLongAccountUin(), str, paramWinkDraftStatusEvent.getUploadStatus());
    }
    if (paramWinkDraftStatusEvent.getToastStatus() != -1) {
      ((IDataManager)QRoute.api(IDataManager.class)).updateToastStatus(HostDataTransUtils.getLongAccountUin(), str, paramWinkDraftStatusEvent.getUploadStatus());
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkDraftStatusEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkDraftStatusEvent)) {
      a((WinkDraftStatusEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.data.WinkSimpleEventDaftManager
 * JD-Core Version:    0.7.0.1
 */