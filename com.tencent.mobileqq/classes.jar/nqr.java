import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;
import tencent.im.oidb.qqshop.qqshop.SQQSHPNewUserRecmd;

public class nqr
  extends ajtb
{
  public nqr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqshop.SQQSHPClientRsp();
    try
    {
      ((qqshop.SQQSHPClientRsp)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte.retcode.get() == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("EcShopHandler", 2, "response from server error: " + paramArrayOfByte.retcode.get());
      return;
      if (!paramArrayOfByte.newusrrecmd.has()) {
        break label175;
      }
      localObject = (qqshop.SQQSHPNewUserRecmd)paramArrayOfByte.newusrrecmd.get();
      if ((!((qqshop.SQQSHPNewUserRecmd)localObject).recmdflag.has()) || (((qqshop.SQQSHPNewUserRecmd)localObject).recmdflag.get() != 1)) {
        break label175;
      }
      localObject = ((qqshop.SQQSHPNewUserRecmd)localObject).recmdurl.get();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label175;
      }
      if (!QLog.isColorLevel()) {
        break label167;
      }
      QLog.i("EcShopHandler", 2, "newusrrecmd url:" + (String)localObject);
      label167:
      notifyUI(0, true, localObject);
      return;
      label175:
      if (!paramArrayOfByte.recmdlist.has()) {
        break label210;
      }
      paramArrayOfByte = paramArrayOfByte.recmdlist.get();
      if (paramArrayOfByte.size() <= 0) {
        break label210;
      }
      notifyUI(0, true, paramArrayOfByte);
      return;
      label210:
      notifyUI(0, false, null);
    }
    if (paramArrayOfByte == null) {
      return;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    qqshop.SQQSHPClientRsp localSQQSHPClientRsp = new qqshop.SQQSHPClientRsp();
    try
    {
      localSQQSHPClientRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localSQQSHPClientRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      } while (!QLog.isColorLevel());
      QLog.i("EcShopHandler", 2, "no bind uin found!");
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.bindlist.has()))
    {
      paramArrayOfByte = paramArrayOfByte.bindlist.get();
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
      {
        paramArrayOfByte = (qqshop.SQQSHPAccoutRelation)paramArrayOfByte.get(0);
        if ((!paramArrayOfByte.customerservice.has()) || (paramArrayOfByte.customerservice.get() != 1)) {
          break label148;
        }
        if ((paramArrayOfByte.binduin.has()) && (paramArrayOfByte.puin.has()))
        {
          nqn.a.put(String.valueOf(paramArrayOfByte.puin.get()), String.valueOf(paramArrayOfByte.binduin.get()));
          notifyUI(3, true, null);
        }
      }
      return;
    }
    label148:
    notifyUI(3, false, null);
  }
  
  public void a()
  {
    notifyUI(4, true, null);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.e("EcShopHandler", 2, "onReceive data null.");
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramIntent = paramIntent.getStringExtra("cmd");
        if (!TextUtils.isEmpty(paramIntent))
        {
          if (paramIntent.equals("GetFolderInfo"))
          {
            a(paramArrayOfByte);
            return;
          }
          if ((!paramIntent.equals("GetShopBindUin")) && (!paramIntent.equals("UserEventReport")))
          {
            if (paramIntent.equals("GetShopCustomerservice"))
            {
              b(paramArrayOfByte);
              return;
            }
            if (paramIntent.equals("GetRecommendShop"))
            {
              paramIntent = new qqshop.SQQSHPClientRsp();
              try
              {
                paramIntent.mergeFrom(paramArrayOfByte);
                if ((paramIntent != null) && (paramIntent.rcpuin.has()))
                {
                  notifyUI(5, true, String.valueOf(paramIntent.rcpuin.get()));
                  return;
                }
              }
              catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
              {
                for (;;)
                {
                  paramIntent = null;
                  paramFromServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("EcShopHandler", 2, "EcShopHandler onReceive cmd cannot be recognized");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "getShopUinServantInfo empty uin.");
      }
      return;
    }
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.puinlist.add(Long.valueOf(paramString));
    paramString = new NewIntent(this.app.getApp(), nqt.class);
    paramString.putExtra("cmd", "GetShopCustomerservice");
    paramString.putExtra("data", localSQQSHPClientReq.toByteArray());
    paramString.putExtra("timeout", 30000);
    this.app.startServlet(paramString);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return nqs.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqr
 * JD-Core Version:    0.7.0.1
 */