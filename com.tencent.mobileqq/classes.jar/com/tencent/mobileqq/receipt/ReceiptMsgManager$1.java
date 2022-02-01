package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import java.util.ArrayList;

class ReceiptMsgManager$1
  implements Runnable
{
  ReceiptMsgManager$1(ReceiptMsgManager paramReceiptMsgManager, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, String paramString, int paramInt3, boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    this.this$0.a.voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(this.a);
    this.this$0.a.voiceChangeFlag = this.b;
    this.this$0.a.voiceType = this.c.c;
    this.this$0.a.fullLocalPath = this.d;
    Object localObject = this.this$0.a;
    boolean bool;
    if (this.e == 4) {
      bool = true;
    } else {
      bool = false;
    }
    ((MessageForPtt)localObject).sendFromvoiceChangePanelFlag = bool;
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(this.this$0.a);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(this.d);
    Bundle localBundle = new Bundle();
    localBundle.putString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH", this.d);
    localBundle.putInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE", this.e);
    localBundle.putBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED", this.f);
    ReceiptMsgManager.a(this.this$0, this.g, this.h.b, this.h.a, this.h.c, ReceiptMsgManager.a(this.this$0, 3), false, (ArrayList)localObject, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager.1
 * JD-Core Version:    0.7.0.1
 */