package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;

public class BasePicUploadProcessor
  extends BaseUploadProcessor
  implements Handler.Callback
{
  Handler a;
  private ArrayList b = new ArrayList();
  
  public BasePicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  protected void a(RichProto.RichProtoReq.PicUpReq paramPicUpReq)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.p)
    {
      paramPicUpReq.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      paramPicUpReq.jdField_a_of_type_ArrayOfByte = HexUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.n);
      paramPicUpReq.e = 1;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 0, "reportForServerMonitor , isSuccess = " + paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.b.contains(paramString1)) {
        return;
      }
      this.b.add(paramString1);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_type", "1");
    localHashMap.put("business_type", "1");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.j);
    localHashMap.put("server_ip", paramString1);
    localHashMap.put("server_port", paramString2);
    localHashMap.put("md5", this.d);
    if (this.f == null) {}
    for (paramString1 = this.g;; paramString1 = this.f)
    {
      localHashMap.put("uuid", paramString1);
      localHashMap.put("chatType", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a + "");
      localHashMap.put("chatUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_picUp", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void ap_()
  {
    super.ap_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-255, 2000L);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.p) {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "HotPicQuickSend", paramBoolean, 0L, 0L, null, "");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  void e()
  {
    super.e();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.p)
    {
      this.q = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      this.c = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.n;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.n);
      if (getClass().equals(GroupPicUploadProcessor.class)) {
        this.d = (this.c + "." + this.e);
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.q);
      this.q = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      this.c = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.o;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.o);
    } while (!getClass().equals(GroupPicUploadProcessor.class));
    this.d = (this.c + "." + this.e);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d < 1002) {
      d(1002);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */