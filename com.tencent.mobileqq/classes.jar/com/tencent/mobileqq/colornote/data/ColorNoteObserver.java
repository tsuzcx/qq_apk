package com.tencent.mobileqq.colornote.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ColorNoteObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramBoolean = true;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteObserver", 2, "onUpdate: TYPE_REQ_SET_COLOR_NOTE_RECENT_SWITCH");
      }
    }
    else
    {
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 1))
      {
        Object localObject = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).loadConfig();
        if ((localObject != null) && (((ColorNoteRecentConfBean)localObject).a())) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        localObject = (IColorNoteController)QRoute.api(IColorNoteController.class);
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramInt == 0) || (((Boolean)paramObject[0]).booleanValue())) {
          paramBoolean = false;
        }
        ((IColorNoteController)localObject).setRecentlyViewedSwitch(localAppRuntime, paramBoolean);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteObserver", 2, "onUpdate: TYPE_REQ_GET_COLOR_NOTE_RECENT_SWITCH");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ColorNoteObserver", 2, "onUpdate: params == null || params.length != 1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteObserver
 * JD-Core Version:    0.7.0.1
 */