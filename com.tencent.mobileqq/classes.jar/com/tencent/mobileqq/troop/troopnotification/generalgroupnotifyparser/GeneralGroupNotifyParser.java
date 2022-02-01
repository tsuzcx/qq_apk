package com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupNotify;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public abstract class GeneralGroupNotifyParser
  implements IGeneralGroupNotifyParser
{
  private general_group_notify.GroupNotify a(structmsg.StructMsg paramStructMsg)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    structmsg.StructMsg localStructMsg;
    if (paramStructMsg != null)
    {
      localObject1 = localObject3;
      if (paramStructMsg.msg.bytes_transparent_group_notify.has())
      {
        paramStructMsg = paramStructMsg.msg.bytes_transparent_group_notify.get();
        localObject1 = localObject3;
        if (paramStructMsg != null)
        {
          try
          {
            localObject1 = paramStructMsg.toByteArray();
            paramStructMsg = new general_group_notify.GroupNotify();
            try
            {
              paramStructMsg.mergeFrom((byte[])localObject1);
              return paramStructMsg;
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
            localInvalidProtocolBufferMicroException2.printStackTrace();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            paramStructMsg = localObject2;
          }
          QLog.d("GeneralGroupNotifyParser", 1, "doParse InvalidProtocolBufferMicroException", localInvalidProtocolBufferMicroException2);
          localStructMsg = paramStructMsg;
        }
      }
    }
    return localStructMsg;
  }
  
  protected abstract <T extends IGeneralGroupNotifyParser.GeneralGroupNotifyInfo> T a(general_group_notify.GroupNotify paramGroupNotify);
  
  public <T extends IGeneralGroupNotifyParser.GeneralGroupNotifyInfo> T a(structmsg.StructMsg paramStructMsg)
  {
    paramStructMsg = a(paramStructMsg);
    if (paramStructMsg != null) {
      paramStructMsg = a(paramStructMsg);
    } else {
      paramStructMsg = null;
    }
    if ((paramStructMsg != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramStructMsg.toString());
      QLog.i("GeneralGroupNotifyParser", 1, localStringBuilder.toString());
    }
    return paramStructMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.GeneralGroupNotifyParser
 * JD-Core Version:    0.7.0.1
 */