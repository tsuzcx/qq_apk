import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.EncryptUinHandler.3;
import com.tencent.biz.pubaccount.EncryptUinInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinReqBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinResult;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinRspBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.ReqBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13.RspBody;

public class nzr
  extends BusinessHandler
{
  private String jdField_a_of_type_JavaLangString;
  private nzt jdField_a_of_type_Nzt;
  
  public nzr(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public nzr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(List<Long> paramList, int paramInt)
  {
    oidb_0xc13.ReqBody localReqBody = new oidb_0xc13.ReqBody();
    localReqBody.msg_encrypt_uin_req_body.rpt_uint64_uin.set(paramList);
    localReqBody.msg_encrypt_uin_req_body.setHasFlag(true);
    paramList = makeOIDBPkg("OidbSvc.0xc13", 3091, 1, localReqBody.toByteArray());
    paramList.addAttribute("ARGS_TYPE", Integer.valueOf(paramInt));
    sendPbReq(paramList);
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    while (this.jdField_a_of_type_Nzt != null) {
      return;
    }
    this.jdField_a_of_type_Nzt = new nzs(this);
    this.mApp.addObserver(this.jdField_a_of_type_Nzt);
    ThreadManager.excute(new EncryptUinHandler.3(this), 128, null, true);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return nzt.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp.removeObserver(this.jdField_a_of_type_Nzt);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    Object localObject = new oidb_0xc13.RspBody();
    Bundle localBundle = new Bundle();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    if (j == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUinHandler", 2, "onReceive: isSuccess=" + bool + ", code=" + j);
      }
      if (!bool) {
        break label244;
      }
      paramFromServiceMsg = (oidb_0xc13.EncryptUinRspBody)((oidb_0xc13.RspBody)localObject).msg_encrypt_uin_rsp_body.get();
      if (paramFromServiceMsg == null) {
        break label275;
      }
      paramObject = paramFromServiceMsg.rpt_msg_encrypt_result.get();
      if ((paramObject == null) || (paramObject.isEmpty())) {
        break label275;
      }
      paramFromServiceMsg = new ArrayList();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        localObject = (oidb_0xc13.EncryptUinResult)paramObject.next();
        EncryptUinInfo localEncryptUinInfo = new EncryptUinInfo();
        localEncryptUinInfo.jdField_a_of_type_Long = ((oidb_0xc13.EncryptUinResult)localObject).uint64_original_uin.get();
        localEncryptUinInfo.jdField_a_of_type_Int = ((oidb_0xc13.EncryptUinResult)localObject).int32_result.get();
        if (((oidb_0xc13.EncryptUinResult)localObject).bytes_encrypt_uin.get() != null) {
          localEncryptUinInfo.jdField_a_of_type_JavaLangString = ((oidb_0xc13.EncryptUinResult)localObject).bytes_encrypt_uin.get().toStringUtf8();
        }
        paramFromServiceMsg.add(localEncryptUinInfo);
      }
    }
    for (;;)
    {
      localBundle.putParcelableArrayList("KEY_ENCRYPT_RESULT_LIST", paramFromServiceMsg);
      label244:
      paramToServiceMsg = paramToServiceMsg.getAttribute("ARGS_TYPE");
      if (paramToServiceMsg != null) {
        i = ((Integer)paramToServiceMsg).intValue();
      }
      notifyUI(i, bool, localBundle);
      return;
      label275:
      paramFromServiceMsg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzr
 * JD-Core Version:    0.7.0.1
 */