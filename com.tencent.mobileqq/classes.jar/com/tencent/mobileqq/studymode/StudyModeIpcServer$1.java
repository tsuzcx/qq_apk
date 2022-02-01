package com.tencent.mobileqq.studymode;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class StudyModeIpcServer$1
  extends KidModeObserver
{
  StudyModeIpcServer$1(StudyModeIpcServer paramStudyModeIpcServer) {}
  
  public void a(KidModeObserver.ClearPasswordResult paramClearPasswordResult)
  {
    StudyModeIpcServer.a(this.a).unRegistObserver(this);
    if (paramClearPasswordResult == null)
    {
      QLog.i("KidModeObserver", 1, "onClearPassword result == null");
      paramClearPasswordResult = this.a;
      StudyModeIpcServer.a(paramClearPasswordResult, StudyModeIpcServer.b(paramClearPasswordResult), 1, "result == null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClearPassword errCode=");
    ((StringBuilder)localObject).append(paramClearPasswordResult.errCode);
    ((StringBuilder)localObject).append(",errMessage=");
    ((StringBuilder)localObject).append(paramClearPasswordResult.errMessage);
    QLog.i("KidModeObserver", 1, ((StringBuilder)localObject).toString());
    if (paramClearPasswordResult.errCode != 0)
    {
      localObject = this.a;
      StudyModeIpcServer.a((StudyModeIpcServer)localObject, StudyModeIpcServer.b((StudyModeIpcServer)localObject), paramClearPasswordResult.errCode, paramClearPasswordResult.errMessage);
      return;
    }
    localObject = this.a;
    StudyModeIpcServer.a((StudyModeIpcServer)localObject, StudyModeIpcServer.b((StudyModeIpcServer)localObject), paramClearPasswordResult.errMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeIpcServer.1
 * JD-Core Version:    0.7.0.1
 */