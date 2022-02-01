package com.tencent.mobileqq.studyroom.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.GuardProcessExitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class StudyRoomManagerImpl$2
  extends BroadcastReceiver
{
  StudyRoomManagerImpl$2(StudyRoomManagerImpl paramStudyRoomManagerImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) && (!paramContext.equals("mqq.intent.action.LOGOUT")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq.intent.action.EXIT_");
      localStringBuilder.append(MobileQQ.getContext().getPackageName());
      if (paramContext.equals(localStringBuilder.toString()))
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("***exitProcexx*** receive broacast action=");
          paramContext.append(paramIntent.getAction());
          QLog.e("studyroom.StudyRoomManager", 2, paramContext.toString());
        }
        StudyRoomManagerImpl.a(this.a).a(true);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("***exitProcexx*** receive broacast action=");
        paramContext.append(paramIntent.getAction());
        QLog.e("studyroom.StudyRoomManager", 2, paramContext.toString());
      }
      StudyRoomManagerImpl.a(this.a).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */