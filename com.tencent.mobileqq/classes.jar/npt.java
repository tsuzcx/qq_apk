import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoPlayCountHandler.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6.ReqBody;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class npt
  extends ajtd
{
  static final String a = "Q.pubaccount.video." + npu.class.getSimpleName();
  
  public npt(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public npt(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int k = 0;
    boolean bool;
    Bundle localBundle;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      localBundle = new Bundle();
      paramFromServiceMsg = "";
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleGetPlayCount onReceive :" + bool);
      }
      if (!bool) {
        break label532;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject = new oidb_sso.OIDBSSOPkg();
          ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
          paramObject = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
          localObject = new oidb_0x6a6.RspBody();
          ((oidb_0x6a6.RspBody)localObject).mergeFrom(paramObject);
          if ((((oidb_0x6a6.RspBody)localObject).uint32_ret_code.has()) && (((oidb_0x6a6.RspBody)localObject).uint32_ret_code.get() == 0)) {
            if (((oidb_0x6a6.RspBody)localObject).uint32_read_count.has()) {
              i = ((oidb_0x6a6.RspBody)localObject).uint32_read_count.get();
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          Object localObject;
          int i;
          continue;
          paramToServiceMsg = "";
          continue;
        }
        try
        {
          if (paramToServiceMsg.getWupBuffer() == null) {
            continue;
          }
          paramObject = new oidb_sso.OIDBSSOPkg();
          paramObject.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
          if ((paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
          {
            paramToServiceMsg = new oidb_0x6a6.ReqBody();
            paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
            if ((paramToServiceMsg.bytes_article_id.has()) && (paramToServiceMsg.bytes_article_id.get() != null))
            {
              paramToServiceMsg = paramToServiceMsg.bytes_article_id.get().toStringUtf8().substring(2);
              if (QLog.isColorLevel()) {
                QLog.d(a, 2, "handleGetPlayCount vid :" + paramToServiceMsg + " playCount :" + i);
              }
              localBundle.putInt("VALUE_VIDEO_PLAY_COUNT", i);
              localBundle.putString("VALUE_VIDEO_VID", paramToServiceMsg);
              super.notifyUI(1, bool, localBundle);
              return;
              bool = false;
              break;
              if (((oidb_0x6a6.RspBody)localObject).uint64_read_count.has())
              {
                i = (int)((oidb_0x6a6.RspBody)localObject).uint64_read_count.get();
                continue;
              }
              if (QLog.isColorLevel())
              {
                QLog.e(a, 2, "handleGetPlayCount 获取失败, read_count 为空");
                i = 0;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.e(a, 2, "handleGetPlayCount 获取失败, ret_code 为空或 ret_code == 1");
                }
              }
              i = 0;
              continue;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(a, 2, "geVideoPlayCount, 请求vid空");
            continue;
          }
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.e(a, 2, "geVideoPlayCount, reqBody为空");
            paramToServiceMsg = paramFromServiceMsg;
            continue;
            i = j;
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          j = i;
        }
      }
      paramToServiceMsg = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.e(a, 2, "geVideoPlayCount, ERROR e=" + paramObject.getMessage());
        i = j;
        paramToServiceMsg = paramFromServiceMsg;
        continue;
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.e(a, 2, "geVideoPlayCount, reqPkg为空");
          paramToServiceMsg = paramFromServiceMsg;
          continue;
          label532:
          i = k;
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.e(a, 2, "geVideoPlayCount, 返回直接出错了");
            i = k;
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 4, "getVideoPlayCount()  vId" + paramString1);
    }
    oidb_0x6a6.ReqBody localReqBody = new oidb_0x6a6.ReqBody();
    paramString1 = ByteStringMicro.copyFromUtf8("5_" + paramString1);
    localReqBody.bytes_article_id.set(paramString1);
    localReqBody.uint32_req_type.set(paramInt1);
    localReqBody.uint32_article_type.set(paramInt2);
    localReqBody.uint32_platform_type.set(paramInt3);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      localReqBody.rowkey.set(paramString1);
    }
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x6a6", 1702, 0, localReqBody.toByteArray()));
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.excute(new VideoPlayCountHandler.1(this, paramString1, paramString2), 16, null, true);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return npu.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleGetPlayCount onReceive");
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npt
 * JD-Core Version:    0.7.0.1
 */