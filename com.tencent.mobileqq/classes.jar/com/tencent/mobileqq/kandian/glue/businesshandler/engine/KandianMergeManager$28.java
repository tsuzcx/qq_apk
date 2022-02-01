package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

class KandianMergeManager$28
  implements Runnable
{
  KandianMergeManager$28(KandianMergeManager paramKandianMergeManager, String paramString, int paramInt) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.NEW_KANDIAN_UIN;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    ChatActivityFacade.a(KandianMergeManager.a(this.this$0), localSessionInfo);
    KandianMergeManager.a(this.this$0).getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.28
 * JD-Core Version:    0.7.0.1
 */