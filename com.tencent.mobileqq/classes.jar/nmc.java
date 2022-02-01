import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardReqBody;
import com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardReqHead;
import com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardRspBody;
import com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardRspHead;
import com.tencent.biz.bmqq.protocol.mobileqq_bmqq.HRTXHead;
import com.tencent.biz.bmqq.protocol.mobileqq_bmqq.RetInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;

public class nmc
  extends abiv
{
  public static int a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "hrtxformqq" };
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public nmc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  private byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), k, j, i };
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new Bundle();
    BmqqUserSimpleInfo localBmqqUserSimpleInfo = new BmqqUserSimpleInfo();
    Object localObject = paramFromServiceMsg.getWupBuffer();
    int i = localObject.length;
    paramFromServiceMsg = new byte[i - 4];
    System.arraycopy(localObject, 4, paramFromServiceMsg, 0, i - 4);
    i = paramFromServiceMsg.length;
    int j = paramFromServiceMsg[0];
    i = paramFromServiceMsg[(i - 1)];
    localObject = new byte[4];
    System.arraycopy(paramFromServiceMsg, 1, localObject, 0, 4);
    a((byte[])localObject);
    localObject = new byte[4];
    System.arraycopy(paramFromServiceMsg, 5, localObject, 0, 4);
    a((byte[])localObject);
    localObject = new byte[4];
    System.arraycopy(paramFromServiceMsg, 9, localObject, 0, 4);
    i = a((byte[])localObject);
    localObject = new byte[4];
    System.arraycopy(paramFromServiceMsg, 13, localObject, 0, 4);
    j = a((byte[])localObject);
    localObject = new byte[i];
    System.arraycopy(paramFromServiceMsg, 17, localObject, 0, i);
    mobileqq_bmqq.CorpcardRspHead localCorpcardRspHead = new mobileqq_bmqq.CorpcardRspHead();
    try
    {
      localCorpcardRspHead.mergeFrom((byte[])localObject);
      ((mobileqq_bmqq.HRTXHead)localCorpcardRspHead.rspHead.get()).uint64_qquin.get();
      localObject = new byte[j];
      System.arraycopy(paramFromServiceMsg, i + 17, localObject, 0, j);
      paramFromServiceMsg = new mobileqq_bmqq.CorpcardRspBody();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])localObject);
        long l = paramFromServiceMsg.uint64_qquin.get();
        if (l > 0L) {
          localBmqqUserSimpleInfo.mBmqqUin = Long.toString(l);
        }
        l = paramFromServiceMsg.uint64_kfuin.get();
        if (l >= 0L) {
          localBmqqUserSimpleInfo.mBmqqMasterUin = Long.toString(l);
        }
        i = ((mobileqq_bmqq.RetInfo)paramFromServiceMsg.retInfo.get()).uint32_ret_code.get();
        localObject = ((mobileqq_bmqq.RetInfo)paramFromServiceMsg.retInfo.get()).err_info.get();
        localBmqqUserSimpleInfo.mBmqqNickName = paramFromServiceMsg.nickname.get();
        localBmqqUserSimpleInfo.mBmqqRemarkName = paramFromServiceMsg.remarkname.get();
        localBmqqUserSimpleInfo.mBmqqJobTitle = paramFromServiceMsg.jobs.get();
        localBmqqUserSimpleInfo.mBmqqMobileNum = paramFromServiceMsg.mobile.get();
        localBmqqUserSimpleInfo.mBmqqTelphone = paramFromServiceMsg.phone.get();
        localBmqqUserSimpleInfo.mBmqqEmail = paramFromServiceMsg.email.get();
        localBmqqUserSimpleInfo.mBmqqCompany = paramFromServiceMsg.corpname.get();
        localBmqqUserSimpleInfo.mFlag = paramFromServiceMsg.flag.get();
        paramToServiceMsg.putParcelable("info", localBmqqUserSimpleInfo);
        paramToServiceMsg.putInt("result", i);
        paramToServiceMsg.putString("errinfo", (String)localObject);
        return paramToServiceMsg;
        localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
        localInvalidProtocolBufferMicroException1.printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException2.printStackTrace();
        }
      }
    }
  }
  
  private byte[] b(ToServiceMsg paramToServiceMsg)
  {
    long l1 = ((Long)paramToServiceMsg.getAttributes().get("uin")).longValue();
    long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
    Object localObject = new mobileqq_bmqq.HRTXHead();
    ((mobileqq_bmqq.HRTXHead)localObject).uint64_qquin.set(l1);
    paramToServiceMsg = new mobileqq_bmqq.CorpcardReqHead();
    paramToServiceMsg.reqHead.set((MessageMicro)localObject);
    localObject = new mobileqq_bmqq.CorpcardReqBody();
    ((mobileqq_bmqq.CorpcardReqBody)localObject).uint64_qquin.set(l2);
    int i = paramToServiceMsg.toByteArray().length;
    int j = ((mobileqq_bmqq.CorpcardReqBody)localObject).toByteArray().length;
    int k = i + 17 + j + 1;
    byte[] arrayOfByte = new byte[k];
    arrayOfByte[0] = 91;
    System.arraycopy(a(1001), 0, arrayOfByte, 1, 4);
    int m = jdField_a_of_type_Int;
    jdField_a_of_type_Int = m + 1;
    System.arraycopy(a(m), 0, arrayOfByte, 5, 4);
    System.arraycopy(a(i), 0, arrayOfByte, 9, 4);
    System.arraycopy(a(j), 0, arrayOfByte, 13, 4);
    System.arraycopy(paramToServiceMsg.toByteArray(), 0, arrayOfByte, 17, i);
    System.arraycopy(((mobileqq_bmqq.CorpcardReqBody)localObject).toByteArray(), 0, arrayOfByte, i + 17, j);
    arrayOfByte[(k - 1)] = 93;
    return arrayOfByte;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return false;
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {}
    for (paramToServiceMsg = b(paramToServiceMsg);; paramToServiceMsg = null)
    {
      if (paramToServiceMsg == null) {
        return null;
      }
      byte[] arrayOfByte1 = a(paramToServiceMsg.length + 4);
      byte[] arrayOfByte2 = new byte[paramToServiceMsg.length + 4];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
      System.arraycopy(paramToServiceMsg, 0, arrayOfByte2, 4, paramToServiceMsg.length);
      return arrayOfByte2;
    }
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmc
 * JD-Core Version:    0.7.0.1
 */