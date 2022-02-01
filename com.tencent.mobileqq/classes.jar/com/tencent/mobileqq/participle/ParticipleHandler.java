package com.tencent.mobileqq.participle;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79.ReqBody;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79.RspBody;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79.content;

public class ParticipleHandler
  extends BusinessHandler
{
  private AtomicInteger a = new AtomicInteger();
  
  public ParticipleHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        Object localObject = new Oidb_0xd79.RspBody();
        OidbWrapper.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        i = ((Oidb_0xd79.RspBody)localObject).uint32_ret.get();
        if (((Oidb_0xd79.RspBody)localObject).uint32_compress_flag.get() != 0) {
          break label232;
        }
        paramFromServiceMsg = new Oidb_0xd79.content();
        paramFromServiceMsg.mergeFrom(((Oidb_0xd79.RspBody)localObject).bytes_raw_content.get().toByteArray());
        if (!paramFromServiceMsg.bytes_slice_content.has()) {
          break label232;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_slice_content.get();
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
        {
          paramObject = new ArrayList(paramFromServiceMsg.size());
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          if (!paramFromServiceMsg.hasNext()) {
            break label237;
          }
          localObject = a(((ByteStringMicro)paramFromServiceMsg.next()).toStringUtf8());
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramObject.add(localObject);
          continue;
          notifyUI(1, bool, paramObject);
        }
        else
        {
          notifyUI(1, false, null);
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleParticipleTheContent : ret -> ");
          paramFromServiceMsg.append(i);
          QLog.d("ParticipleHandler", 2, paramFromServiceMsg.toString());
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.d("ParticipleHandler", 1, paramFromServiceMsg, new Object[0]);
      }
      return;
      label232:
      paramFromServiceMsg = null;
      continue;
      label237:
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public String a(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int k = paramString.length() - 1;
    int i = 0;
    while ((i <= k) && (arrayOfChar[i] <= ' ') && (arrayOfChar[i] != '\024')) {
      i += 1;
    }
    int j = k;
    while ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024'))) {
      j -= 1;
    }
    if ((i == 0) && (j == k)) {
      return paramString;
    }
    return paramString.substring(i, j + 1);
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("participleTheContent senderUin -> ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("ParticipleHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Oidb_0xd79.ReqBody();
      ((Oidb_0xd79.ReqBody)localObject).uint64_seq.set(this.a.incrementAndGet());
      paramAppInterface = paramAppInterface.getCurrentUin();
      ((Oidb_0xd79.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramAppInterface));
      ((Oidb_0xd79.ReqBody)localObject).uint32_compress_flag.set(0);
      ((Oidb_0xd79.ReqBody)localObject).bytes_content.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
      if (!TextUtils.isEmpty(paramString2)) {
        ((Oidb_0xd79.ReqBody)localObject).uint64_sender_uin.set(Long.parseLong(paramString2));
      }
      paramAppInterface = ((Oidb_0xd79.ReqBody)localObject).bytes_qua;
      paramString1 = new StringBuilder();
      paramString1.append("and_");
      paramString1.append(AppSetting.d());
      paramString1.append("_");
      paramString1.append("8.8.17");
      paramAppInterface.set(ByteStringMicro.copyFrom(paramString1.toString().getBytes()));
      sendPbReq(makeOIDBPkg("OidbSvc.0xd79", 3449, 1, ((Oidb_0xd79.ReqBody)localObject).toByteArray()));
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.d("ParticipleHandler", 1, paramAppInterface, new Object[0]);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ParticipleObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (TextUtils.equals(paramFromServiceMsg.getServiceCmd(), "OidbSvc.0xd79"))) {
      a(paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.participle.ParticipleHandler
 * JD-Core Version:    0.7.0.1
 */