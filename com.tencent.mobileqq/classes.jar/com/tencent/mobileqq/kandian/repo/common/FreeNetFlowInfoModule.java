package com.tencent.mobileqq.kandian.repo.common;

import android.os.Handler;
import android.text.SpannableString;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.oidb_0xbfe.RspBody;

public class FreeNetFlowInfoModule
  extends ReadInJoyEngineModule
{
  private FreeNetFlowInfoModule.FreeNetFlowInfo a;
  private CharSequence b;
  private boolean c = true;
  private boolean d = false;
  
  public FreeNetFlowInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_0xbfe.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    boolean bool = false;
    QLog.d("FreeNetFlowInfoModule", 2, new Object[] { "handle0xBe6FreeNetFlowInfo result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      if (paramToServiceMsg.has())
      {
        if (this.a == null) {
          this.a = new FreeNetFlowInfoModule.FreeNetFlowInfo();
        }
        if (paramToServiceMsg.uint32_receive_status.has()) {
          this.a.a = paramToServiceMsg.uint32_receive_status.get();
        }
        if (paramToServiceMsg.bytes_jump_url.has()) {
          this.a.b = paramToServiceMsg.bytes_jump_url.get().toStringUtf8();
        }
        if (paramToServiceMsg.uint32_flag.has())
        {
          paramFromServiceMsg = this.a;
          if (paramToServiceMsg.uint32_flag.get() == 1) {
            bool = true;
          }
          paramFromServiceMsg.c = bool;
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("free netflow, status: ");
          paramToServiceMsg.append(this.a.a);
          paramToServiceMsg.append(", jumpUrl: ");
          paramToServiceMsg.append(this.a.b);
          paramToServiceMsg.append(", isActive: ");
          paramToServiceMsg.append(this.a.c);
          QLog.d("FreeNetFlowInfoModule", 2, paramToServiceMsg.toString());
        }
      }
    }
    else
    {
      this.c = true;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("get free netflow error, result code: ");
        paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
        QLog.d("FreeNetFlowInfoModule", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  public static CharSequence e()
  {
    Object localObject = HardCodeUtil.a(2131902854);
    int i = ((String)localObject).indexOf("领取1G流量");
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new FreeNetFlowInfoModule.1(), i, i + 6, 33);
    return localObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.c = (paramBoolean ^ true);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setShowingFreeNetFlow: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("FreeNetFlowInfoModule", 2, ((StringBuilder)localObject).toString());
    }
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        ((FreeNetFlowInfoModule.FreeNetFlowInfo)localObject).b();
      }
    }
  }
  
  public boolean a()
  {
    if (!this.d)
    {
      FreeNetFlowInfoModule.FreeNetFlowInfo localFreeNetFlowInfo = this.a;
      if ((localFreeNetFlowInfo != null) && (localFreeNetFlowInfo.a())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public String c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      String str = ((FreeNetFlowInfoModule.FreeNetFlowInfo)localObject).b;
      localObject = str;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get url from freeNetFlow: ");
        ((StringBuilder)localObject).append(str);
        QLog.d("FreeNetFlowInfoModule", 2, ((StringBuilder)localObject).toString());
        return str;
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public CharSequence d()
  {
    if (this.b == null) {
      this.b = e();
    }
    return this.b;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbfe")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule
 * JD-Core Version:    0.7.0.1
 */