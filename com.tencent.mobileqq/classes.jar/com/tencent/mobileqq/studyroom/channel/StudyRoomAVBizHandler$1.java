package com.tencent.mobileqq.studyroom.channel;

import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.QQConfigAbilityInterface.Callback;

class StudyRoomAVBizHandler$1
  implements IModule.FocusChangeListener
{
  StudyRoomAVBizHandler$1(StudyRoomAVBizHandler paramStudyRoomAVBizHandler) {}
  
  public void onFocusGain()
  {
    QLog.i("studyroom.StudyRoomAVBizHandler", 1, "mFocusChangeListener onFocusGain");
    StudyRoomAVBizHandler.a(this.a).onResult(StudyRoomAVBizHandler.a(this.a, 4));
  }
  
  public void onFocusLoss()
  {
    QLog.i("studyroom.StudyRoomAVBizHandler", 1, "mFocusChangeListener onFocusLoss");
    if (StudyRoomAVBizHandler.a(this.a) != null)
    {
      QLog.i("studyroom.StudyRoomAVBizHandler", 1, "mFocusChangeListener onFocusLoss callback.onResult");
      StudyRoomAVBizHandler.a(this.a).onResult(StudyRoomAVBizHandler.a(this.a, 3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.channel.StudyRoomAVBizHandler.1
 * JD-Core Version:    0.7.0.1
 */