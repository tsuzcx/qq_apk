package com.tencent.mobileqq.troop.homework.recite.ui;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.homework.hw_recite_score.hw_recite_score.RspReciteScore;
import com.tencent.qphone.base.util.QLog;

class ReciteFragment$7
  extends ProtoUtils.TroopProtocolObserver
{
  ReciteFragment$7(ReciteFragment paramReciteFragment, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      paramBundle = new hw_recite_score.RspReciteScore();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.score_grade.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReciteFragment", 2, "onCompleteRecite grade = " + paramBundle.score_grade.get());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.a.post(new ReciteFragment.7.1(this, paramInt));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ReciteFragment", 2, "InvalidProtocolBufferMicroException");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment.7
 * JD-Core Version:    0.7.0.1
 */