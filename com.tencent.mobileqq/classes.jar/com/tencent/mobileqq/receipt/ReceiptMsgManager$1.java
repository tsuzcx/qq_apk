package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import bahi;
import bbbc;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import java.util.ArrayList;

public class ReceiptMsgManager$1
  implements Runnable
{
  public ReceiptMsgManager$1(bbbc parambbbc, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, String paramString, int paramInt3, boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    this.this$0.a.voiceLength = QQRecorder.a(this.jdField_a_of_type_Int);
    this.this$0.a.voiceChangeFlag = this.b;
    this.this$0.a.voiceType = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c;
    this.this$0.a.fullLocalPath = this.jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.this$0.a);
    bahi.b(this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE", this.c);
    localBundle.putBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED", this.jdField_a_of_type_Boolean);
    bbbc.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, bbbc.a(this.this$0, 3), false, localArrayList, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager.1
 * JD-Core Version:    0.7.0.1
 */