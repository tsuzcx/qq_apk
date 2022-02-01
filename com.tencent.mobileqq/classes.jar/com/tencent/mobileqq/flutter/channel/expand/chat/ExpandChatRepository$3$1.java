package com.tencent.mobileqq.flutter.channel.expand.chat;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class ExpandChatRepository$3$1
  implements Runnable
{
  ExpandChatRepository$3$1(ExpandChatRepository.3 param3, int paramInt, List paramList1, List paramList2) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (!ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$3.a).contains(Integer.valueOf(this.jdField_a_of_type_Int)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("expand.chat.ExpandChatRepository", 1, "onGetExtendFriendOnlineState not mine req:" + this.jdField_a_of_type_Int);
      }
      localObject1 = new HashSet(ExpandChatRepository.b(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$3.a));
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Long)((Iterator)localObject3).next();
        if (!((Set)localObject1).contains(localObject4)) {
          ((List)localObject2).add(localObject4);
        }
      }
      ExpandChatRepository.b(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$3.a).addAll((Collection)localObject2);
    }
    for (;;)
    {
      QLog.i("expand.chat.ExpandChatRepository", 1, "onGetExtendFriendOnlineState cached list size=" + ExpandChatRepository.b(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$3.a).size());
      localObject1 = new ArrayList();
      localObject2 = this.b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        localObject4 = new OnlineStateInfo();
        ((OnlineStateInfo)localObject4).uin = (localObject3 + "");
        ((OnlineStateInfo)localObject4).online = this.jdField_a_of_type_JavaUtilList.contains(localObject3);
        ((List)localObject1).add(localObject4);
        if ((((OnlineStateInfo)localObject4).online) && (QLog.isColorLevel())) {
          QLog.d("expand.chat.ExpandChatRepository", 1, "notifyOnlineState  " + MsfSdkUtils.getShortUin(((OnlineStateInfo)localObject4).uin));
        }
      }
      ExpandChatRepository.b(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$3.a).clear();
      ExpandChatRepository.b(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$3.a).addAll(this.jdField_a_of_type_JavaUtilList);
    }
    ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$3.a, (List)localObject1, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.3.1
 * JD-Core Version:    0.7.0.1
 */