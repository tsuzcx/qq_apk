package com.tencent.qidian.controller;

import android.os.Bundle;
import android.text.TextUtils;
import aqvb;
import bdvn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class QidianHandler$1
  implements Runnable
{
  public QidianHandler$1(bdvn parambdvn, ToServiceMsg paramToServiceMsg, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getString("extUin");
      long l = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getLong("uinseq");
      int i = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getInt("uinType");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = this.this$0.app.a().b((String)localObject, i, l);
        if ((localObject != null) && ((localObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)localObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.a != null))
          {
            ((MessageForUniteGrayTip)localObject).tipParam.a.clear();
            ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(this.this$0.app);
            this.this$0.notifyUI(1005, true, this.jdField_a_of_type_JavaUtilHashMap);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(bdvn.a(), 2, "handleBlockBulkMsg ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianHandler.1
 * JD-Core Version:    0.7.0.1
 */