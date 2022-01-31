import android.os.Bundle;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ClearMessageResult;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspClearMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class kke
  implements BusinessObserver
{
  public kke(TroopRedTouchHandler paramTroopRedTouchHandler, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRedTouchHandler", 2, "clearStoryMessageRedPoint receive isSuccess=" + paramBoolean);
    }
    int k = 0;
    int i = 0;
    long l2 = 0L;
    int j = -1;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Object localObject1 = paramBundle.getByteArray("data");
        if (localObject1 != null)
        {
          paramBundle = new qqstory_710_message.RspClearMessage();
          paramBundle.mergeFrom((byte[])localObject1);
          paramInt = paramBundle.remain_num.get();
        }
        TroopRedTouchManager localTroopRedTouchManager;
        Bundle localBundle;
        Object localObject2 = null;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        try
        {
          l1 = paramBundle.image_uid.get();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          paramBundle = null;
          paramBoolean = false;
          i = j;
          l1 = l2;
          continue;
        }
        try
        {
          i = paramBundle.last_time.get();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
        {
          paramBoolean = false;
          paramBundle = null;
          i = j;
          continue;
        }
        try
        {
          localObject1 = (qqstory_710_message.ClearMessageResult)paramBundle.msg_tab.get();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
        {
          paramBundle = null;
          paramBoolean = true;
          continue;
        }
        try
        {
          paramBundle = (qqstory_710_message.ClearMessageResult)paramBundle.msg_dynamic.get();
          paramBoolean = true;
          j = i;
          i = paramInt;
          l2 = l1;
          paramInt = j;
          j = i;
          i = paramInt;
          l1 = l2;
          paramInt = j;
          localTroopRedTouchManager = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.b.getManager(69);
          if (QLog.isColorLevel()) {
            QLog.i("storyRedDotDebug", 2, "updateStoryMessageFromSvr:succ=" + paramBoolean + " num=" + paramInt + " time=" + i);
          }
          if (!paramBoolean) {
            continue;
          }
          if (paramInt <= 0) {
            continue;
          }
          paramBoolean = true;
          localTroopRedTouchManager.a(paramBoolean, paramInt, l1, i, 49);
          if (localObject1 != null)
          {
            if (((qqstory_710_message.ClearMessageResult)localObject1).remain_num.get() <= 0) {
              continue;
            }
            paramBoolean = true;
            localTroopRedTouchManager.a(paramBoolean, ((qqstory_710_message.ClearMessageResult)localObject1).remain_num.get(), l1, ((qqstory_710_message.ClearMessageResult)localObject1).last_time.get(), 48);
          }
          if (paramBundle != null)
          {
            if (paramBundle.remain_num.get() <= 0) {
              continue;
            }
            paramBoolean = true;
            localTroopRedTouchManager.a(paramBoolean, paramBundle.remain_num.get(), l1, paramBundle.last_time.get(), 28);
          }
          this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a(105, true, null);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
        {
          paramBoolean = true;
          paramBundle = localInvalidProtocolBufferMicroException4;
          localObject2 = localInvalidProtocolBufferMicroException5;
          continue;
        }
        localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
        paramBoolean = false;
        paramBundle = null;
        paramInt = k;
        l1 = l2;
        i = j;
        if (QLog.isColorLevel()) {
          QLog.d("TroopRedTouchHandler", 2, "parse RspClearMessage error", localInvalidProtocolBufferMicroException1);
        }
        localBundle = paramBundle;
        paramBundle = null;
        continue;
        paramBoolean = false;
        continue;
        paramBoolean = false;
        continue;
        paramBoolean = false;
        continue;
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a(localTroopRedTouchManager, 48);
          continue;
        }
        this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a(localTroopRedTouchManager, 49);
        this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a(localTroopRedTouchManager, 48);
        this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a(localTroopRedTouchManager, 28);
        continue;
        paramBoolean = false;
        localObject2 = null;
        paramBundle = null;
        paramInt = j;
        continue;
      }
      paramBoolean = false;
      paramBundle = null;
      paramInt = 0;
      i = -1;
      long l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kke
 * JD-Core Version:    0.7.0.1
 */