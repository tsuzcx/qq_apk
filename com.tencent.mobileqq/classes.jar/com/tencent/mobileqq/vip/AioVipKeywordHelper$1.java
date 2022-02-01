package com.tencent.mobileqq.vip;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AioVipKeywordHelper$1
  implements Runnable
{
  AioVipKeywordHelper$1(AioVipKeywordHelper paramAioVipKeywordHelper, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, String paramString, ChatMessage paramChatMessage, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "keyword has been detected, message is ignored.");
      }
    }
    label264:
    label401:
    for (;;)
    {
      return;
      if (this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        Object localObject1 = this.this$0;
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localObject2 = AioVipKeywordHelper.a((AioVipKeywordHelper)localObject1, localContext, (String)localObject2, bool);
          if ((localObject2 != null) && (localObject2.length != 0)) {
            break;
          }
          QLog.e("AioVipKeywordHelper", 1, "vipKeywords null");
          return;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString.toLowerCase();
        int i = 0;
        for (;;)
        {
          if (i >= localObject2.length) {
            break label401;
          }
          localContext = localObject2[i];
          if ((!TextUtils.isEmpty(localContext)) && (((String)localObject1).contains(localContext)))
          {
            if ((this.this$0.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.this$0.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
            {
              i = 0;
              for (;;)
              {
                if (i >= this.this$0.jdField_a_of_type_ArrayOfJavaLangString.length) {
                  break label264;
                }
                localObject2 = this.this$0.jdField_a_of_type_ArrayOfJavaLangString[i];
                if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject1).contains((CharSequence)localObject2)))
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("AioVipKeywordHelper", 4, "detected Keyword but contain dirty word, keyword=" + localContext + ", dirty word=" + (String)localObject2);
                  return;
                }
                i += 1;
              }
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (QLog.isColorLevel()) {
              QLog.d("AioVipKeywordHelper", 4, "detected Keyword, keyword=" + localContext);
            }
            if (!this.jdField_a_of_type_Boolean)
            {
              this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localContext, false);
              return;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            this.this$0.x = localContext;
            ((VIPAioSendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIP_AIO_SEND_HANDLER)).a(localContext);
            ThreadManager.getUIHandler().postDelayed(new AioVipKeywordHelper.1.1(this, localContext), this.this$0.d);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipKeywordHelper.1
 * JD-Core Version:    0.7.0.1
 */