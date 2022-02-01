package cooperation.ilive.group;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.group.entity.IliveGroupTipsEntity;
import cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsReq;
import cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsRsp;

public class IliveCommonHandler
  extends BusinessHandler
{
  protected IliveCommonHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    LiveGroupTips.GetLiveGroupTipsRsp localGetLiveGroupTipsRsp = new LiveGroupTips.GetLiveGroupTipsRsp();
    try
    {
      localGetLiveGroupTipsRsp.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      paramObject.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleGetIliveGroupTipsData, isSuccess = ");
      paramObject.append(paramFromServiceMsg.isSuccess());
      QLog.i("IliveCommonHandler", 2, paramObject.toString());
    }
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("source");
    if (paramFromServiceMsg.isSuccess())
    {
      notifyUI(1, true, new Object[] { paramToServiceMsg, IliveGroupTipsEntity.a(localGetLiveGroupTipsRsp) });
      return;
    }
    notifyUI(1, false, new Object[] { paramToServiceMsg });
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPbRequest. IliveGroup troopUin = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" anchorUid = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" source = ");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("IliveCommonHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new LiveGroupTips.GetLiveGroupTipsReq();
    ((LiveGroupTips.GetLiveGroupTipsReq)localObject).anchor_uid.set(paramString1);
    ((LiveGroupTips.GetLiveGroupTipsReq)localObject).group_id.set(Long.parseLong(paramString2));
    paramString1 = createToServiceMsg("QQLive.GetLiveGroupTips");
    paramString1.putWupBuffer(((LiveGroupTips.GetLiveGroupTipsReq)localObject).toByteArray());
    paramString1.setTimeout(10000L);
    paramString1.addAttribute("source", paramString3);
    super.sendPbReq(paramString1);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return IliveGroupObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLive.GetLiveGroupTips".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.group.IliveCommonHandler
 * JD-Core Version:    0.7.0.1
 */