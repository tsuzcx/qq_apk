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
  private FreeNetFlowInfoModule.FreeNetFlowInfo jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
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
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo = new FreeNetFlowInfoModule.FreeNetFlowInfo();
        }
        if (paramToServiceMsg.uint32_receive_status.has()) {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo.jdField_a_of_type_Int = paramToServiceMsg.uint32_receive_status.get();
        }
        if (paramToServiceMsg.bytes_jump_url.has()) {
          this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo.jdField_a_of_type_JavaLangString = paramToServiceMsg.bytes_jump_url.get().toStringUtf8();
        }
        if (paramToServiceMsg.uint32_flag.has())
        {
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo;
          if (paramToServiceMsg.uint32_flag.get() == 1) {
            bool = true;
          }
          paramFromServiceMsg.jdField_a_of_type_Boolean = bool;
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("free netflow, status: ");
          paramToServiceMsg.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo.jdField_a_of_type_Int);
          paramToServiceMsg.append(", jumpUrl: ");
          paramToServiceMsg.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo.jdField_a_of_type_JavaLangString);
          paramToServiceMsg.append(", isActive: ");
          paramToServiceMsg.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo.jdField_a_of_type_Boolean);
          QLog.d("FreeNetFlowInfoModule", 2, paramToServiceMsg.toString());
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("get free netflow error, result code: ");
        paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
        QLog.d("FreeNetFlowInfoModule", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  public static CharSequence b()
  {
    Object localObject = HardCodeUtil.a(2131704963);
    int i = ((String)localObject).indexOf("领取1G流量");
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new FreeNetFlowInfoModule.1(), i, i + 6, 33);
    return localObject;
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = b();
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo;
    if (localObject != null)
    {
      String str = ((FreeNetFlowInfoModule.FreeNetFlowInfo)localObject).jdField_a_of_type_JavaLangString;
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
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_Boolean = (paramBoolean ^ true);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setShowingFreeNetFlow: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("FreeNetFlowInfoModule", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo;
      if (localObject != null) {
        ((FreeNetFlowInfoModule.FreeNetFlowInfo)localObject).a();
      }
    }
  }
  
  public boolean a()
  {
    if (!this.b)
    {
      FreeNetFlowInfoModule.FreeNetFlowInfo localFreeNetFlowInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonFreeNetFlowInfoModule$FreeNetFlowInfo;
      if ((localFreeNetFlowInfo != null) && (localFreeNetFlowInfo.a())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule
 * JD-Core Version:    0.7.0.1
 */