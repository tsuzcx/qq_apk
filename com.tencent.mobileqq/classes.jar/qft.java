import android.os.Handler;
import android.text.SpannableString;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.oidb_0xbfe.RspBody;

public class qft
  extends qhj
{
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private qfv jdField_a_of_type_Qfv;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public qft(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
  }
  
  public static void a(String paramString)
  {
    int i;
    switch (NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()))
    {
    default: 
      i = 2;
    }
    for (;;)
    {
      olh.a(null, "", paramString, paramString, 0, 0, "" + i, pkh.a(), "0", null, false);
      return;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public static CharSequence b()
  {
    Object localObject = anvx.a(2131704339);
    int i = ((String)localObject).indexOf("领取1G流量");
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new qfu(), i, i + 6, 33);
    return localObject;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    paramToServiceMsg = new oidb_0xbfe.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("FreeNetFlowInfoModule", 2, new Object[] { "handle0xBe6FreeNetFlowInfo result = ", Integer.valueOf(i) });
    if (i == 0) {
      if (paramToServiceMsg.has())
      {
        if (this.jdField_a_of_type_Qfv == null) {
          this.jdField_a_of_type_Qfv = new qfv();
        }
        if (paramToServiceMsg.uint32_receive_status.has()) {
          this.jdField_a_of_type_Qfv.jdField_a_of_type_Int = paramToServiceMsg.uint32_receive_status.get();
        }
        if (paramToServiceMsg.bytes_jump_url.has()) {
          this.jdField_a_of_type_Qfv.jdField_a_of_type_JavaLangString = paramToServiceMsg.bytes_jump_url.get().toStringUtf8();
        }
        if (paramToServiceMsg.uint32_flag.has())
        {
          paramFromServiceMsg = this.jdField_a_of_type_Qfv;
          if (paramToServiceMsg.uint32_flag.get() != 1) {
            break label223;
          }
          paramFromServiceMsg.jdField_a_of_type_Boolean = bool;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FreeNetFlowInfoModule", 2, "free netflow, status: " + this.jdField_a_of_type_Qfv.jdField_a_of_type_Int + ", jumpUrl: " + this.jdField_a_of_type_Qfv.jdField_a_of_type_JavaLangString + ", isActive: " + this.jdField_a_of_type_Qfv.jdField_a_of_type_Boolean);
        }
      }
    }
    label223:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("FreeNetFlowInfoModule", 2, "get free netflow error, result code: " + paramFromServiceMsg.getResultCode());
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
    Object localObject = null;
    if (this.jdField_a_of_type_Qfv != null)
    {
      String str = this.jdField_a_of_type_Qfv.jdField_a_of_type_JavaLangString;
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.d("FreeNetFlowInfoModule", 2, "get url from freeNetFlow: " + str);
        localObject = str;
      }
    }
    return localObject;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbfe")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("FreeNetFlowInfoModule", 2, "setShowingFreeNetFlow: " + paramBoolean);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Qfv != null)) {
        this.jdField_a_of_type_Qfv.a();
      }
      return;
    }
  }
  
  public boolean a()
  {
    return (!this.b) && (this.jdField_a_of_type_Qfv != null) && (this.jdField_a_of_type_Qfv.a());
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qft
 * JD-Core Version:    0.7.0.1
 */