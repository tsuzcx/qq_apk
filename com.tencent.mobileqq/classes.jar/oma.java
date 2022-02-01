import com.tencent.biz.pubaccount.VideoColumnSubscribeHandler.1;
import com.tencent.biz.pubaccount.VideoColumnSubscribeHandler.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.ReqBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.RspBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnReq;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnRsp;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class oma
  extends BusinessHandler
{
  public static final String a = oma.class.getSimpleName();
  
  public oma(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject = new oidb_0xd4b.ReqBody();
    oidb_0xd4b.SubscribeVideoColumnReq localSubscribeVideoColumnReq = new oidb_0xd4b.SubscribeVideoColumnReq();
    localSubscribeVideoColumnReq.uint32_video_column_id.set(paramInt);
    PBUInt32Field localPBUInt32Field = localSubscribeVideoColumnReq.uint32_oper_type;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localPBUInt32Field.set(i);
      ((oidb_0xd4b.ReqBody)localObject).msg_subscribe_video_column_req.set(localSubscribeVideoColumnReq);
      localObject = super.makeOIDBPkg("OidbSvc.0xd4b", 3403, 1, ((oidb_0xd4b.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("columnId", Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject).addAttribute("columnIconUrl", paramString);
      ((ToServiceMsg)localObject).addAttribute("isSubscribe", Boolean.valueOf(paramBoolean));
      super.sendPbReq((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    ThreadManager.excute(new VideoColumnSubscribeHandler.1(this, paramInt, paramBoolean, paramString), 16, null, true);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    int i;
    if (paramToServiceMsg.getAttribute("columnId") != null) {
      i = ((Integer)paramToServiceMsg.getAttribute("columnId")).intValue();
    }
    for (;;)
    {
      String str;
      label46:
      boolean bool1;
      if (paramToServiceMsg.getAttribute("columnIconUrl") != null)
      {
        str = (String)paramToServiceMsg.getAttribute("columnIconUrl");
        if (paramToServiceMsg.getAttribute("isSubscribe") == null) {
          break label303;
        }
        bool1 = ((Boolean)paramToServiceMsg.getAttribute("isSubscribe")).booleanValue();
        label69:
        boolean bool2 = bool3;
        if (paramFromServiceMsg.isSuccess())
        {
          bool2 = bool3;
          if (paramObject != null) {
            bool2 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "onReceive() isSuccess = " + bool2);
        }
        if (bool2) {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        }
      }
      try
      {
        oidb_0xd4b.RspBody localRspBody = new oidb_0xd4b.RspBody();
        qxp.a(paramFromServiceMsg, paramObject, localRspBody);
        int j = ((oidb_0xd4b.SubscribeVideoColumnRsp)((oidb_0xd4b.RspBody)localRspBody.get()).msg_subscribe_video_column_rsp.get()).uint32_guide_type.get();
        QLog.i(a, 1, "onReceive() " + j);
        ThreadManager.getUIHandler().post(new VideoColumnSubscribeHandler.2(this, j, bool1, str, i));
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.has()) {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "onReceive() pkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
          }
        }
        label303:
        while (!QLog.isColorLevel())
        {
          return;
          i = 0;
          break;
          str = "";
          break label46;
          bool1 = false;
          break label69;
        }
        QLog.d(a, 2, "onReceive() pkg.uint32_result is null ");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(a, 2, "onReceive() exception = " + paramToServiceMsg.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oma
 * JD-Core Version:    0.7.0.1
 */