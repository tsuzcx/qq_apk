import com.tencent.av.common.ErrorInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

public class lgy
  extends ajtb
{
  static volatile long jdField_a_of_type_Long = 1L;
  static Object jdField_a_of_type_JavaLangObject = new Object();
  static volatile HashMap<Long, lhb> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public lgy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a(common.ErrorInfo paramErrorInfo)
  {
    if ((paramErrorInfo.has()) && (paramErrorInfo.uint32_errcode.has())) {
      return paramErrorInfo.uint32_errcode.get();
    }
    return -99;
  }
  
  static long a()
  {
    try
    {
      jdField_a_of_type_Long += 1L;
      long l = jdField_a_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String a(common.ErrorInfo paramErrorInfo)
  {
    if ((paramErrorInfo.has()) && (paramErrorInfo.bytes_errmsg.has())) {
      return paramErrorInfo.bytes_errmsg.get().toStringUtf8();
    }
    return "";
  }
  
  static lhb a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      lhb locallhb = (lhb)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      return locallhb;
    }
  }
  
  public static void a(long paramLong, AppInterface paramAppInterface, String paramString, MessageMicro paramMessageMicro, lhb paramlhb)
  {
    lgy locallgy = (lgy)paramAppInterface.getBusinessHandler(52);
    paramAppInterface = new ToServiceMsg("", paramAppInterface.getCurrentAccountUin(), paramString);
    mtj.a(paramAppInterface.getAttributes(), paramLong);
    long l = a();
    paramAppInterface.getAttributes().put("msgSeq_for_callback", Long.valueOf(l));
    a(l, paramlhb);
    paramAppInterface.putWupBuffer(paramMessageMicro.toByteArray());
    locallgy.sendPbReq(paramAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVMessageHandler", 1, "sendMsg, msgListener[" + paramlhb + "], msgSeq_for_callback[" + l + "], seq[" + paramLong + "]");
    }
  }
  
  static void a(long paramLong, lhb paramlhb)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramlhb);
      return;
    }
  }
  
  private static lha b(lhb paramlhb)
  {
    paramlhb = paramlhb.getClass().getGenericSuperclass();
    Object localObject;
    String str;
    if (paramlhb != null) {
      if ((paramlhb instanceof ParameterizedType))
      {
        localObject = ((ParameterizedType)paramlhb).getActualTypeArguments();
        if (localObject != null) {
          if (localObject.length == 2)
          {
            paramlhb = (Class)localObject[0];
            localObject = (Class)localObject[1];
            str = "reqType[" + paramlhb + "]rspType[" + localObject + "]";
          }
        }
      }
    }
    while (((paramlhb == null) || (localObject == null)) && (AudioHelper.d()))
    {
      throw new IllegalArgumentException("QAVMessageHandler get getClassInfo失败, " + str);
      str = "ActualTypeArguments长度为" + localObject.length;
      localObject = null;
      paramlhb = null;
      continue;
      localObject = null;
      str = "getActualTypeArguments为空";
      paramlhb = null;
      continue;
      str = "type[" + paramlhb.getClass().getName() + "]";
      localObject = null;
      paramlhb = null;
      continue;
      str = "genericInterfaces为空";
      localObject = null;
      paramlhb = null;
    }
    lha locallha = new lha(null);
    locallha.jdField_a_of_type_JavaLangString = str;
    locallha.jdField_a_of_type_JavaLangClass = paramlhb;
    locallha.b = ((Class)localObject);
    return locallha;
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return akat.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l2 = mtj.a(paramToServiceMsg.getAttributes());
    long l1 = 0L;
    Object localObject = paramToServiceMsg.getAttribute("msgSeq_for_callback");
    if ((localObject instanceof Integer)) {
      l1 = ((Integer)localObject).intValue();
    }
    for (;;)
    {
      localObject = a(l1);
      if (QLog.isColorLevel()) {
        QLog.w("QAVMessageHandler", 1, "onReceive, cmd[" + str + "], req_cmd[" + paramToServiceMsg.getServiceCmd() + "], isSuccess[" + paramFromServiceMsg.isSuccess() + "], RequestSsoSeq[" + paramToServiceMsg.getRequestSsoSeq() + "], ResultCode[" + paramFromServiceMsg.getResultCode() + "], RequestSsoSeq[" + paramFromServiceMsg.getRequestSsoSeq() + "], msgSeq_for_callback[" + l1 + "], msgListener[" + localObject + "], seq[" + l2 + "]");
      }
      if (localObject == null) {
        break;
      }
      ((lhb)localObject).a(l2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ((localObject instanceof Long)) {
        l1 = ((Long)localObject).longValue();
      }
    }
    QLog.w("QAVMessageHandler", 1, "onReceive, 没有MsgListener， cmd[" + str + "], seq[" + l2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgy
 * JD-Core Version:    0.7.0.1
 */