package com.tencent.qidian.controller;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QidianHandler$1
  implements Runnable
{
  QidianHandler$1(QidianHandler paramQidianHandler, ToServiceMsg paramToServiceMsg, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.a.extraData.getString("extUin");
      long l = this.a.extraData.getLong("uinseq");
      int i = this.a.extraData.getInt("uinType");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = QidianHandler.a(this.this$0).getMessageFacade().b((String)localObject, i, l);
        if ((localObject != null) && ((localObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)localObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.b() != null))
          {
            ((MessageForUniteGrayTip)localObject).tipParam.c();
            ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(QidianHandler.a(this.this$0));
            this.this$0.notifyUI(1005, true, this.b);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QidianHandler.a(), 2, "handleBlockBulkMsg ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianHandler.1
 * JD-Core Version:    0.7.0.1
 */