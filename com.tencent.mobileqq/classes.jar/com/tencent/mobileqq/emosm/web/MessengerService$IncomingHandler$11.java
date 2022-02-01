package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MessengerService$IncomingHandler$11
  implements Runnable
{
  MessengerService$IncomingHandler$11(MessengerService.IncomingHandler paramIncomingHandler, QQAppInterface paramQQAppInterface, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject2 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((ILebaHelperService)localObject2).getLebaMgrList();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break label207;
      }
      ((ILebaHelperService)localObject2).reloadLebaItems(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ((ILebaHelperService)localObject2).getLebaMgrList();
    }
    label139:
    label197:
    label207:
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (LebaViewItem)((Iterator)localObject1).next();
        } while ((localObject2 == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != this.jdField_a_of_type_Int));
      }
      for (int i = ((LebaViewItem)localObject2).jdField_a_of_type_Byte;; i = -1)
      {
        localObject1 = new Bundle();
        if (i == -1)
        {
          ((Bundle)localObject1).putInt("ret", 1);
          if (i != 0) {
            break label197;
          }
        }
        for (i = 1;; i = 0)
        {
          ((Bundle)localObject1).putInt("type", i);
          this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
          return;
          QLog.d("IPC_LEBA_ITEM_GET", 1, "lebaHelperService == null");
          localObject1 = null;
          break;
          ((Bundle)localObject1).putInt("ret", 0);
          break label139;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.11
 * JD-Core Version:    0.7.0.1
 */