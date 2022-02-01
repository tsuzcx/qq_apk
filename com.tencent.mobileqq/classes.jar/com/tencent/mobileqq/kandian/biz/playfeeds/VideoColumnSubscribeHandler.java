package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
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

public class VideoColumnSubscribeHandler
  extends BusinessHandler
{
  public static final String a = "VideoColumnSubscribeHandler";
  
  public VideoColumnSubscribeHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject = new oidb_0xd4b.ReqBody();
    oidb_0xd4b.SubscribeVideoColumnReq localSubscribeVideoColumnReq = new oidb_0xd4b.SubscribeVideoColumnReq();
    localSubscribeVideoColumnReq.uint32_video_column_id.set(paramInt);
    PBUInt32Field localPBUInt32Field = localSubscribeVideoColumnReq.uint32_oper_type;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localPBUInt32Field.set(i);
    ((oidb_0xd4b.ReqBody)localObject).msg_subscribe_video_column_req.set(localSubscribeVideoColumnReq);
    localObject = super.makeOIDBPkg("OidbSvc.0xd4b", 3403, 1, ((oidb_0xd4b.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("columnId", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject).addAttribute("columnIconUrl", paramString);
    ((ToServiceMsg)localObject).addAttribute("isSubscribe", Boolean.valueOf(paramBoolean));
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    ThreadManager.excute(new VideoColumnSubscribeHandler.1(this, paramInt, paramBoolean, paramString), 16, null, true);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = paramToServiceMsg.getAttribute("columnId");
    boolean bool3 = false;
    int i;
    if (localObject1 != null) {
      i = ((Integer)paramToServiceMsg.getAttribute("columnId")).intValue();
    } else {
      i = 0;
    }
    if (paramToServiceMsg.getAttribute("columnIconUrl") != null) {
      localObject1 = (String)paramToServiceMsg.getAttribute("columnIconUrl");
    } else {
      localObject1 = "";
    }
    boolean bool1;
    if (paramToServiceMsg.getAttribute("isSubscribe") != null) {
      bool1 = ((Boolean)paramToServiceMsg.getAttribute("isSubscribe")).booleanValue();
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (paramFromServiceMsg.isSuccess())
    {
      bool2 = bool3;
      if (paramObject != null) {
        bool2 = true;
      }
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive() isSuccess = ");
      ((StringBuilder)localObject2).append(bool2);
      QLog.d(paramToServiceMsg, 2, ((StringBuilder)localObject2).toString());
    }
    if (bool2)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        localObject2 = new oidb_0xd4b.RspBody();
        ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
        int j = ((oidb_0xd4b.SubscribeVideoColumnRsp)((oidb_0xd4b.RspBody)((oidb_0xd4b.RspBody)localObject2).get()).msg_subscribe_video_column_rsp.get()).uint32_guide_type.get();
        paramFromServiceMsg = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onReceive() ");
        ((StringBuilder)localObject2).append(j);
        QLog.i(paramFromServiceMsg, 1, ((StringBuilder)localObject2).toString());
        ThreadManager.getUIHandler().post(new VideoColumnSubscribeHandler.2(this, j, bool1, (String)localObject1, i));
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.has())
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = a;
            paramObject = new StringBuilder();
            paramObject.append("onReceive() pkg.uint32_result = ");
            paramObject.append(paramToServiceMsg.uint32_result.get());
            QLog.d(paramFromServiceMsg, 2, paramObject.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d(a, 2, "onReceive() pkg.uint32_result is null ");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = a;
          paramObject = new StringBuilder();
          paramObject.append("onReceive() exception = ");
          paramObject.append(paramToServiceMsg.getMessage());
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoColumnSubscribeHandler
 * JD-Core Version:    0.7.0.1
 */