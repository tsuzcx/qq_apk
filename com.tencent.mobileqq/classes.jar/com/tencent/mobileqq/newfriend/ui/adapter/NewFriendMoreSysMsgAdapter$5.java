package com.tencent.mobileqq.newfriend.ui.adapter;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class NewFriendMoreSysMsgAdapter$5
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$5(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, boolean paramBoolean) {}
  
  public void run()
  {
    label639:
    Object localObject4;
    synchronized (this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      long l = FriendSystemMsgController.a().a(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
      List localList = NewFriendMoreSysMsgAdapter.a(this.this$0).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l);
      if ((localList != null) && (localList.size() > 0))
      {
        ArrayList localArrayList = new ArrayList(localList.size());
        int i = localList.size() - 1;
        for (;;)
        {
          ??? = localArrayList;
          if (i < 0) {
            break;
          }
          ??? = (MessageRecord)localList.get(i);
          if ((??? instanceof MessageForSystemMsg))
          {
            MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)???;
            if (localMessageForSystemMsg.structMsg == null) {
              localMessageForSystemMsg.parse();
            }
            if ((localMessageForSystemMsg.structMsg != null) && (localMessageForSystemMsg.structMsg.msg != null) && ((localMessageForSystemMsg.structMsg.msg.sub_type.get() != 13) || (!NewFriendMoreSysMsgAdapter.a(this.this$0).isFriend(String.valueOf(localMessageForSystemMsg.structMsg.req_uin.get())))))
            {
              if ((localMessageForSystemMsg.structMsg.msg.uint32_source_flag.get() & 0x8) == 8)
              {
                String str2 = localMessageForSystemMsg.structMsg.msg.msg_source.get();
                l = localMessageForSystemMsg.structMsg.msg.uint64_discuss_uin.get();
                if (l != 0L)
                {
                  ??? = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getDiscussionNameCanNull(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(l));
                  if (TextUtils.isEmpty((CharSequence)???)) {
                    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getDiscussInfo(l, this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
                  }
                  try
                  {
                    ConcurrentHashMap localConcurrentHashMap = this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                    if (??? != null) {
                      break label639;
                    }
                    String str1 = "";
                    localConcurrentHashMap.put(Long.valueOf(l), str1);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                  }
                }
                else
                {
                  ??? = "";
                }
                if (QLog.isColorLevel()) {
                  QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "NewFriendMoreSysMsgAdapter source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(localMessageForSystemMsg.structMsg.msg.uint32_source_flag.get()), Long.valueOf(l), ???, str2 }));
                }
              }
              localArrayList.add(new FriendSystemMessage(localMessageForSystemMsg));
            }
          }
          i -= 1;
        }
      }
      ??? = new ArrayList();
      Object localObject2 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQIMNotifyAddFriendsMsg(true, this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (((ArrayList)localObject2).size() > 0) {
        ((ArrayList)???).addAll((Collection)localObject2);
      }
      localObject2 = NewFriendMoreSysMsgAdapter.a(this.this$0).getPhoneContactAddList();
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
      {
        localObject2 = ((ArrayList)((ArrayList)localObject2).clone()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)???).add(new PhoneContactAddMessage((PhoneContactAdd)((Iterator)localObject2).next()));
        }
      }
      Collections.sort((List)???, NewFriendMoreSysMsgAdapter.a(this.this$0));
      this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(new NewFriendMoreSysMsgAdapter.5.1(this, (ArrayList)???));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.5
 * JD-Core Version:    0.7.0.1
 */