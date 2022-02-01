package com.tencent.mobileqq.emosm.web;

import ajzy;
import android.os.Bundle;
import arpq;
import ashe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Iterator;
import java.util.List;

public class MessengerService$IncomingHandler$11
  implements Runnable
{
  public MessengerService$IncomingHandler$11(ashe paramashe, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject2 = ajzy.a().a();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      ajzy.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ajzy.a().a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (arpq)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((arpq)localObject2).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (((arpq)localObject2).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != this.jdField_a_of_type_Int));
    }
    for (int i = ((arpq)localObject2).jdField_a_of_type_Byte;; i = -1)
    {
      localObject1 = new Bundle();
      if (i == -1)
      {
        ((Bundle)localObject1).putInt("ret", 1);
        if (i != 0) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject1).putInt("type", i);
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
        ((Bundle)localObject1).putInt("ret", 0);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.11
 * JD-Core Version:    0.7.0.1
 */