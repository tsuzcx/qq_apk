import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public abstract class lje<T1 extends MessageMicro, T2 extends MessageMicro>
{
  protected final void a(long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = ljb.a(this);
    ((ljd)localObject).a("QAVMessageHandler", paramLong);
    if ((((ljd)localObject).a != null) && (((ljd)localObject).b != null)) {}
    try
    {
      MessageMicro localMessageMicro = (MessageMicro)((ljd)localObject).a.newInstance();
      localObject = (MessageMicro)((ljd)localObject).b.newInstance();
      paramToServiceMsg = paramToServiceMsg.getWupBuffer();
      if ((paramToServiceMsg != null) && (paramToServiceMsg.length > 4)) {
        localMessageMicro.mergeFrom(paramToServiceMsg, 4, paramToServiceMsg.length - 4);
      }
      ((MessageMicro)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
      a(paramLong, paramFromServiceMsg.isSuccess(), localMessageMicro, (MessageMicro)localObject, paramObject);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("QAVMessageHandler", 1, "onSendMsgRsp, Exception, seq[" + paramLong + "]", paramToServiceMsg);
    }
  }
  
  public abstract void a(long paramLong, boolean paramBoolean, T1 paramT1, T2 paramT2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lje
 * JD-Core Version:    0.7.0.1
 */