package com.tencent.mobileqq.colornote.smallscreen;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.colornote.data.ColorNoteObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class ColorNoteUpcomingServiceCallback
  implements IColorNoteServiceLifecycleCallback
{
  private QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private void a(List<ColorNote> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      UpComingMsgManager localUpComingMsgManager = (UpComingMsgManager)a().getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER);
      if (localUpComingMsgManager != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localUpComingMsgManager.a((ColorNote)paramList.next());
        }
      }
      QLog.e("ColorNoteUpcomingServic", 1, "manager not init");
      return;
    }
    QLog.e("ColorNoteUpcomingServic", 1, "note size 0");
  }
  
  public void a(AppService paramAppService)
  {
    a().addObserver(new ColorNoteObserver());
    ((ColorNoteHandler)a().getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a();
    a(((IColorNoteDataService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteUpcomingServiceCallback
 * JD-Core Version:    0.7.0.1
 */