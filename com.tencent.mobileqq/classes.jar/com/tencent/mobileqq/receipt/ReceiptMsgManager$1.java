package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import java.util.ArrayList;

class ReceiptMsgManager$1
  implements Runnable
{
  ReceiptMsgManager$1(ReceiptMsgManager paramReceiptMsgManager, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, String paramString, int paramInt3, boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    this.this$0.a.voiceLength = QQRecorder.a(this.jdField_a_of_type_Int);
    this.this$0.a.voiceChangeFlag = this.b;
    this.this$0.a.voiceType = this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.c;
    this.this$0.a.fullLocalPath = this.jdField_a_of_type_JavaLangString;
    Object localObject = this.this$0.a;
    if (this.c == 4) {}
    for (boolean bool = true;; bool = false)
    {
      ((MessageForPtt)localObject).sendFromvoiceChangePanelFlag = bool;
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(this.this$0.a);
      PttBuffer.b(this.jdField_a_of_type_JavaLangString);
      Bundle localBundle = new Bundle();
      localBundle.putString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH", this.jdField_a_of_type_JavaLangString);
      localBundle.putInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE", this.c);
      localBundle.putBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED", this.jdField_a_of_type_Boolean);
      ReceiptMsgManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ReceiptMsgManager.a(this.this$0, 3), false, (ArrayList)localObject, localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager.1
 * JD-Core Version:    0.7.0.1
 */