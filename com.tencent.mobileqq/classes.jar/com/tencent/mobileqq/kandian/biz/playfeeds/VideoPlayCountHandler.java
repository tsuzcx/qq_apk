package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
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

public class VideoPlayCountHandler
  extends BusinessHandler
{
  static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.pubaccount.video.");
    localStringBuilder.append(VideoPlayCountObserver.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public VideoPlayCountHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public VideoPlayCountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int m = 0;
    int i = 0;
    int k = 0;
    if ((bool) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    Bundle localBundle = new Bundle();
    paramFromServiceMsg = "";
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetPlayCount onReceive :");
      localStringBuilder.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    int j;
    if (bool) {
      j = m;
    }
    label769:
    for (;;)
    {
      try
      {
        localObject = new oidb_sso.OIDBSSOPkg();
        j = m;
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        j = m;
        paramObject = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
        j = m;
        localObject = new oidb_0x6a6.RspBody();
        j = m;
        ((oidb_0x6a6.RspBody)localObject).mergeFrom(paramObject);
        j = m;
        if (((oidb_0x6a6.RspBody)localObject).uint32_ret_code.has())
        {
          j = m;
          if (((oidb_0x6a6.RspBody)localObject).uint32_ret_code.get() == 0)
          {
            j = m;
            if (((oidb_0x6a6.RspBody)localObject).uint32_read_count.has())
            {
              j = m;
              i = ((oidb_0x6a6.RspBody)localObject).uint32_read_count.get();
              break label769;
            }
            j = m;
            if (((oidb_0x6a6.RspBody)localObject).uint64_read_count.has())
            {
              j = m;
              i = (int)((oidb_0x6a6.RspBody)localObject).uint64_read_count.get();
              break label769;
            }
            i = k;
            j = m;
            if (!QLog.isColorLevel()) {
              continue;
            }
            j = m;
            QLog.e(a, 2, "handleGetPlayCount 获取失败, read_count 为空");
            i = k;
            continue;
          }
        }
        i = k;
        j = m;
        if (QLog.isColorLevel())
        {
          j = m;
          QLog.e(a, 2, "handleGetPlayCount 获取失败, ret_code 为空或 ret_code == 1");
          i = k;
        }
        j = i;
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          j = i;
          paramObject = new oidb_sso.OIDBSSOPkg();
          j = i;
          paramObject.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
          j = i;
          if (paramObject.bytes_bodybuffer.has())
          {
            j = i;
            if (paramObject.bytes_bodybuffer.get() != null)
            {
              j = i;
              paramToServiceMsg = new oidb_0x6a6.ReqBody();
              j = i;
              paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
              j = i;
              if (paramToServiceMsg.bytes_article_id.has())
              {
                j = i;
                if (paramToServiceMsg.bytes_article_id.get() != null)
                {
                  j = i;
                  paramToServiceMsg = paramToServiceMsg.bytes_article_id.get().toStringUtf8().substring(2);
                  k = i;
                  break label688;
                }
              }
              j = i;
              k = i;
              paramToServiceMsg = paramFromServiceMsg;
              if (!QLog.isColorLevel()) {
                break label688;
              }
              j = i;
              QLog.e(a, 2, "geVideoPlayCount, 请求vid空");
              k = i;
              paramToServiceMsg = paramFromServiceMsg;
              break label688;
            }
          }
          j = i;
          k = i;
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.e(a, 2, "geVideoPlayCount, reqBody为空");
            k = i;
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
        else
        {
          j = i;
          k = i;
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.e(a, 2, "geVideoPlayCount, reqPkg为空");
            k = i;
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        k = j;
        paramToServiceMsg = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          break label688;
        }
      }
      paramToServiceMsg = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("geVideoPlayCount, ERROR e=");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.e(paramToServiceMsg, 2, ((StringBuilder)localObject).toString());
      k = j;
      paramToServiceMsg = paramFromServiceMsg;
      break label688;
      k = i;
      paramToServiceMsg = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.e(a, 2, "geVideoPlayCount, 返回直接出错了");
        paramToServiceMsg = paramFromServiceMsg;
        k = i;
      }
      label688:
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = a;
        paramObject = new StringBuilder();
        paramObject.append("handleGetPlayCount vid :");
        paramObject.append(paramToServiceMsg);
        paramObject.append(" playCount :");
        paramObject.append(k);
        QLog.d(paramFromServiceMsg, 2, paramObject.toString());
      }
      localBundle.putInt("VALUE_VIDEO_PLAY_COUNT", k);
      localBundle.putString("VALUE_VIDEO_VID", paramToServiceMsg);
      super.notifyUI(1, bool, localBundle);
      return;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoPlayCount()  vId");
      localStringBuilder.append(paramString1);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
    }
    Object localObject = new oidb_0x6a6.ReqBody();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("5_");
    localStringBuilder.append(paramString1);
    paramString1 = ByteStringMicro.copyFromUtf8(localStringBuilder.toString());
    ((oidb_0x6a6.ReqBody)localObject).bytes_article_id.set(paramString1);
    ((oidb_0x6a6.ReqBody)localObject).uint32_req_type.set(paramInt1);
    ((oidb_0x6a6.ReqBody)localObject).uint32_article_type.set(paramInt2);
    ((oidb_0x6a6.ReqBody)localObject).uint32_platform_type.set(paramInt3);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      ((oidb_0x6a6.ReqBody)localObject).rowkey.set(paramString1);
    }
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x6a6", 1702, 0, ((oidb_0x6a6.ReqBody)localObject).toByteArray()));
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.excute(new VideoPlayCountHandler.1(this, paramString1, paramString2), 16, null, true);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VideoPlayCountObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleGetPlayCount onReceive");
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayCountHandler
 * JD-Core Version:    0.7.0.1
 */