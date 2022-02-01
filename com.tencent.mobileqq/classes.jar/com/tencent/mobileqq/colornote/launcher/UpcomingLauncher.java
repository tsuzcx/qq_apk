package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.colornote.data.ColorNote;
import mqq.app.AppRuntime;

public class UpcomingLauncher
  implements ILauncher
{
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public int getType()
  {
    return 17235968;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      ((UpComingMsgManager)localQQAppInterface.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER)).a(paramContext, paramColorNote);
    }
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.UpcomingLauncher
 * JD-Core Version:    0.7.0.1
 */