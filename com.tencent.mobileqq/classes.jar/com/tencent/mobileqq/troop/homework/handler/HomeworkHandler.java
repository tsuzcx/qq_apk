package com.tencent.mobileqq.troop.homework.handler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.IHomeworkHandler;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.protofile.group_homework.value.HomeworkInfo;
import com.tencent.protofile.homework.hw_assign_homework.ErrorInfo;
import com.tencent.protofile.homework.hw_assign_homework.RspAssignHomework;
import com.tencent.protofile.homework.hw_get_homework_info.ErrorInfo;
import com.tencent.protofile.homework.hw_get_homework_info.ReqGetHomeworkInfo;
import com.tencent.protofile.homework.hw_get_homework_info.RspGetHomeworkInfo;
import com.tencent.protofile.homework.hw_submit_homework.ErrorInfo;
import com.tencent.protofile.homework.hw_submit_homework.HwCommentInfo;
import com.tencent.protofile.homework.hw_submit_homework.ReqSubmitHomework;
import com.tencent.protofile.homework.hw_submit_homework.RspSubmitHomework;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xb14.oidb_0xb14.ReqBody;
import tencent.im.oidb.cmd0xb14.oidb_0xb14.RspBody;
import tencent.im.oidb.cmd0xb14.oidb_0xb14.UserInfo;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class HomeworkHandler
  extends TroopBaseHandler
  implements IHomeworkHandler
{
  protected Set<String> a;
  
  public HomeworkHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo");
    }
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int j;
    HomeworkInfo localHomeworkInfo;
    int i;
    int k;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      j = paramFromServiceMsg.getResultCode();
      localHomeworkInfo = new HomeworkInfo();
      i = -1;
      if (j == 1000)
      {
        paramFromServiceMsg = new hw_get_homework_info.RspGetHomeworkInfo();
        k = i;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        k = i;
        if (paramFromServiceMsg.errinfo.has())
        {
          j = i;
          k = i;
          if (((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_code.has())
          {
            k = i;
            j = ((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_code.get();
          }
          k = j;
          if (((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_desc.has())
          {
            k = j;
            paramToServiceMsg = ((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_desc.get().toStringUtf8();
            i = j;
          }
          else
          {
            paramToServiceMsg = "";
            i = j;
          }
        }
        else
        {
          paramToServiceMsg = null;
        }
        if (i == 0) {
          try
          {
            if (!paramFromServiceMsg.info.has()) {
              break label662;
            }
            paramFromServiceMsg = (value.HomeworkInfo)paramFromServiceMsg.info.get();
            if (paramFromServiceMsg != null)
            {
              if (QLog.isColorLevel())
              {
                paramObject = new StringBuilder();
                paramObject.append("handleGetHomeworkInfo: homeworkInfo: ");
                paramObject.append(paramFromServiceMsg.toString());
                QLog.d("HomeworkHandler", 2, paramObject.toString());
              }
              if (!paramFromServiceMsg.content.has()) {
                break label667;
              }
              paramObject = paramFromServiceMsg.content.get().toStringUtf8();
              localHomeworkInfo.b = paramObject;
              if (!paramFromServiceMsg.title.has()) {
                break label672;
              }
              paramObject = paramFromServiceMsg.title.get();
              localHomeworkInfo.jdField_a_of_type_JavaLangString = paramObject;
              paramObject = localObject1;
              if (paramFromServiceMsg.course_name.has()) {
                paramObject = paramFromServiceMsg.course_name.get();
              }
              localHomeworkInfo.d = paramObject;
              if (!paramFromServiceMsg.course_id.has()) {
                break label677;
              }
              j = paramFromServiceMsg.course_id.get();
              localHomeworkInfo.jdField_a_of_type_Int = j;
              if (!paramFromServiceMsg.need_feedback.has()) {
                break label683;
              }
              bool = paramFromServiceMsg.need_feedback.get();
              localHomeworkInfo.jdField_a_of_type_Boolean = bool;
              if (!paramFromServiceMsg.feedback_ts.has()) {
                break label689;
              }
              l = paramFromServiceMsg.feedback_ts.get();
              localHomeworkInfo.c = l;
              if (paramFromServiceMsg.syncgids.has())
              {
                localHomeworkInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
                localHomeworkInfo.jdField_a_of_type_JavaUtilList.addAll(paramFromServiceMsg.syncgids.get());
              }
            }
            bool = true;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            bool = true;
            continue;
          }
        } else {
          bool = false;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        bool = false;
        i = k;
        paramToServiceMsg = localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo: RspBody parseFrom byte InvalidProtocolBufferMicroException");
        }
        paramFromServiceMsg.printStackTrace();
      }
      boolean bool = false;
      paramToServiceMsg = localObject3;
      notifyUI(HomeworkObserver.c, bool, new Object[] { localHomeworkInfo });
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetHomeworkInfo.errCode:");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append("　erroDesc:");
        paramFromServiceMsg.append(paramToServiceMsg);
        paramFromServiceMsg.append(",hwInfo:");
        paramFromServiceMsg.append(localHomeworkInfo);
        QLog.d("HomeworkHandler", 2, paramFromServiceMsg.toString());
      }
      return;
      notifyUI(HomeworkObserver.c, false, null);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo: req == null || resp == null");
      }
      return;
      label662:
      paramFromServiceMsg = null;
      continue;
      label667:
      paramObject = null;
      continue;
      label672:
      paramObject = null;
      continue;
      label677:
      j = 0;
      continue;
      label683:
      bool = false;
      continue;
      label689:
      long l = 0L;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkHandler", 2, "handleSubmitHomework");
    }
    Object localObject1 = null;
    hw_submit_homework.RspSubmitHomework localRspSubmitHomework = null;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    int j;
    int n;
    int k;
    int i;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      j = paramFromServiceMsg.getResultCode();
      n = -1;
      paramToServiceMsg = localRspSubmitHomework;
      k = n;
      i = j;
      if (j == 1000) {
        localRspSubmitHomework = new hw_submit_homework.RspSubmitHomework();
      }
    }
    for (;;)
    {
      try
      {
        localRspSubmitHomework.mergeFrom((byte[])paramObject);
        if (!localRspSubmitHomework.errinfo.has()) {
          break label449;
        }
        if (((hw_submit_homework.ErrorInfo)localRspSubmitHomework.errinfo.get()).error_code.has()) {
          i = ((hw_submit_homework.ErrorInfo)localRspSubmitHomework.errinfo.get()).error_code.get();
        } else {
          i = -1;
        }
        paramFromServiceMsg = localObject2;
        bool2 = bool4;
        j = i;
        try
        {
          if (!((hw_submit_homework.ErrorInfo)localRspSubmitHomework.errinfo.get()).error_desc.has()) {
            break label443;
          }
          paramFromServiceMsg = localObject2;
          bool2 = bool4;
          j = i;
          paramToServiceMsg = ((hw_submit_homework.ErrorInfo)localRspSubmitHomework.errinfo.get()).error_desc.get().toStringUtf8();
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          break label300;
        }
        paramFromServiceMsg = paramToServiceMsg;
        bool2 = bool1;
        j = i;
        paramObject = paramToServiceMsg;
        bool3 = bool1;
        k = n;
        m = i;
        if (!localRspSubmitHomework.status.has()) {
          break label332;
        }
        paramFromServiceMsg = paramToServiceMsg;
        bool2 = bool1;
        j = i;
        k = localRspSubmitHomework.status.get();
        paramObject = paramToServiceMsg;
        bool3 = bool1;
        m = i;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        j = -1;
        paramFromServiceMsg = localObject1;
      }
      label300:
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkHandler", 2, "handleSubmitHomework: RspBody parseFrom byte InvalidProtocolBufferMicroException");
      }
      paramToServiceMsg.printStackTrace();
      int m = j;
      k = n;
      bool3 = bool2;
      paramObject = paramFromServiceMsg;
      label332:
      i = m;
      paramToServiceMsg = paramObject;
      notifyUI(HomeworkObserver.d, bool3, Integer.valueOf(i));
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSubmitHomework.errCode:");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append("　erroDesc:");
        paramFromServiceMsg.append(paramToServiceMsg);
        paramFromServiceMsg.append(",status:");
        paramFromServiceMsg.append(k);
        QLog.d("HomeworkHandler", 2, paramFromServiceMsg.toString());
      }
      return;
      notifyUI(HomeworkObserver.d, false, null);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkHandler", 2, "handleSubmitHomework: req == null || resp == null");
      }
      return;
      label443:
      paramToServiceMsg = "";
      break label455;
      label449:
      i = -1;
      paramToServiceMsg = localObject3;
      label455:
      if (i == 0) {
        bool1 = true;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkHandler", 2, "handleAssignHomework");
    }
    Object localObject1 = null;
    hw_assign_homework.RspAssignHomework localRspAssignHomework = null;
    Object localObject2 = null;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      int j = paramFromServiceMsg.getResultCode();
      long l2 = -1L;
      int i;
      boolean bool;
      long l1;
      if (j == 1000)
      {
        localRspAssignHomework = new hw_assign_homework.RspAssignHomework();
        j = -1;
        try
        {
          localRspAssignHomework.mergeFrom((byte[])paramObject);
          paramToServiceMsg = localObject2;
          i = j;
          if (localRspAssignHomework.errinfo.has())
          {
            i = j;
            if (((hw_assign_homework.ErrorInfo)localRspAssignHomework.errinfo.get()).error_code.has()) {
              i = ((hw_assign_homework.ErrorInfo)localRspAssignHomework.errinfo.get()).error_code.get();
            }
            try
            {
              if (((hw_assign_homework.ErrorInfo)localRspAssignHomework.errinfo.get()).error_desc.has()) {
                paramToServiceMsg = ((hw_assign_homework.ErrorInfo)localRspAssignHomework.errinfo.get()).error_desc.get().toStringUtf8();
              } else {
                paramToServiceMsg = "";
              }
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              bool = false;
              paramToServiceMsg = localObject1;
              break label259;
            }
          }
          paramFromServiceMsg = paramToServiceMsg;
          j = i;
          if (i != 0) {
            break label288;
          }
          l1 = l2;
          try
          {
            if (localRspAssignHomework.hw_id.has()) {
              l1 = localRspAssignHomework.hw_id.get();
            }
            bool = true;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            bool = true;
          }
          if (!QLog.isColorLevel()) {
            break label274;
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          bool = false;
          i = -1;
          paramToServiceMsg = localObject1;
        }
        label259:
        QLog.d("HomeworkHandler", 2, "handleAssignHomework: RspBody parseFrom byte InvalidProtocolBufferMicroException");
        label274:
        paramFromServiceMsg.printStackTrace();
        l1 = l2;
      }
      else
      {
        paramFromServiceMsg = localRspAssignHomework;
        label288:
        bool = false;
        i = j;
        l1 = l2;
        paramToServiceMsg = paramFromServiceMsg;
      }
      notifyUI(HomeworkObserver.b, bool, new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleAssignHomework.errCode:");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append("　erroDesc:");
        paramFromServiceMsg.append(paramToServiceMsg);
        paramFromServiceMsg.append(",homeworkID:");
        paramFromServiceMsg.append(l1);
        paramFromServiceMsg.append(",isSuccess:");
        paramFromServiceMsg.append(bool);
        QLog.d("HomeworkHandler", 2, paramFromServiceMsg.toString());
      }
      return;
    }
    notifyUI(HomeworkObserver.b, false, null);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkHandler", 2, "handleAssignHomework: req == null || resp == null");
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    homework.RspSend1V1Msg localRspSend1V1Msg = new homework.RspSend1V1Msg();
    homework.ReqSend1V1Msg localReqSend1V1Msg = new homework.ReqSend1V1Msg();
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      try
      {
        localRspSend1V1Msg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[paramToServiceMsg.getInt() - 4];
        paramToServiceMsg.get(paramFromServiceMsg);
        localReqSend1V1Msg.mergeFrom(paramFromServiceMsg);
        notifyUI(HomeworkObserver.e, true, new Object[] { localRspSend1V1Msg, localReqSend1V1Msg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e(".troop.troopManagerHomeworkHandler", 2, "handleTroopBulkSendMessageRespond", paramToServiceMsg);
        notifyUI(HomeworkObserver.e, false, new Object[] { null, null });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troopManagerHomeworkHandler", 2, new Object[] { "handleTroopBulkSendMessageRespond failed, no response, error=", paramFromServiceMsg.getBusinessFailMsg() });
    }
    notifyUI(HomeworkObserver.e, false, new Object[] { null, null });
  }
  
  protected String a()
  {
    return "HomeworkHandler";
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHomeworkInfo homeworkID = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("HomeworkHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new hw_get_homework_info.ReqGetHomeworkInfo();
    ((hw_get_homework_info.ReqGetHomeworkInfo)localObject).hw_id.set(paramLong);
    ToServiceMsg localToServiceMsg = createToServiceMsg("HwSvc.get_homework_info");
    localToServiceMsg.putWupBuffer(((hw_get_homework_info.ReqGetHomeworkInfo)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("submitHomework  homeworkID = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",troopUin = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",content = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("HomeworkHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new hw_submit_homework.ReqSubmitHomework();
    ((hw_submit_homework.ReqSubmitHomework)localObject).hw_id.set(paramLong1);
    ((hw_submit_homework.ReqSubmitHomework)localObject).gid.set(paramLong2);
    ((hw_submit_homework.ReqSubmitHomework)localObject).status.set(2);
    hw_submit_homework.HwCommentInfo localHwCommentInfo = new hw_submit_homework.HwCommentInfo();
    localHwCommentInfo.text.set(ByteStringMicro.copyFromUtf8(paramString));
    ((hw_submit_homework.ReqSubmitHomework)localObject).comment_info.set(localHwCommentInfo);
    paramString = createToServiceMsg("HwSvc.submit_homework");
    paramString.putWupBuffer(((hw_submit_homework.ReqSubmitHomework)localObject).toByteArray());
    sendPbReq(paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xb14.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i == 0)
      {
        paramToServiceMsg = String.valueOf(((oidb_0xb14.RspBody)localObject).group_id.get());
        localObject = ((oidb_0xb14.RspBody)localObject).infos.get();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          paramFromServiceMsg = String.valueOf(((oidb_0xb14.UserInfo)((List)localObject).get(0)).uin.get());
          i = ((oidb_0xb14.UserInfo)((List)localObject).get(0)).id.get();
          paramObject = ((oidb_0xb14.UserInfo)((List)localObject).get(0)).course.get();
          localObject = ((oidb_0xb14.UserInfo)((List)localObject).get(0)).name.get();
          if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, new Object[] { "handleGetHomeworkTroopIdentity. troopUin=", paramToServiceMsg, ", memberUin=", paramFromServiceMsg, ", identity=", Integer.valueOf(i), ", course=", paramObject, ", name=", localObject });
          }
          ((IBizTroopMemberInfoService)this.appRuntime.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveHomeworkTroopMemberIdentity(paramToServiceMsg, paramFromServiceMsg, null, i, paramObject, (String)localObject);
          notifyUI(HomeworkObserver.jdField_a_of_type_Int, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), paramObject, localObject });
        }
      }
      else
      {
        QLog.e("HomeworkHandler", 1, new Object[] { "handleGetHomeworkTroopIdentity failed! retCode = ", Integer.valueOf(i) });
        notifyUI(HomeworkObserver.jdField_a_of_type_Int, false, new Object[] { "", "", Integer.valueOf(0), "", "" });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("HomeworkHandler", 1, "handleGetHomeworkTroopIdentity exception. e=", paramToServiceMsg);
      notifyUI(HomeworkObserver.jdField_a_of_type_Int, false, new Object[] { "", "", Integer.valueOf(0), "", "" });
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkHandler", 2, new Object[] { "getHomeworkTroopIdentity. troopUin = ", paramString1, ", uin = ", paramString2 });
    }
    try
    {
      oidb_0xb14.ReqBody localReqBody = new oidb_0xb14.ReqBody();
      localReqBody.type.set(1);
      localReqBody.group_id.set(Long.parseLong(paramString1));
      localReqBody.uins.set(Collections.singletonList(Long.valueOf(Long.parseLong(paramString2))));
      sendPbReq(makeOIDBPkg("OidbSvc.0xb14", 2836, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1) {}
  }
  
  public void a(@NonNull homework.ReqSend1V1Msg paramReqSend1V1Msg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troopManagerHomeworkHandler", 2, "sendTroopBulkSendMessageRequest");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("HwSvc.send_msg");
    localToServiceMsg.putWupBuffer(paramReqSend1V1Msg.toByteArray());
    a(localToServiceMsg);
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0xb14");
      this.a.add("HwSvc.get_homework_info");
      this.a.add("HwSvc.submit_homework");
      this.a.add("HwSvc.assign_homework");
      this.a.add("HwSvc.send_msg");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return HomeworkObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("HomeworkHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("HomeworkHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xb14".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("HwSvc.get_homework_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("HwSvc.submit_homework".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("HwSvc.assign_homework".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("HwSvc.send_msg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.handler.HomeworkHandler
 * JD-Core Version:    0.7.0.1
 */