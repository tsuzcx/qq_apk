package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewTempUtil;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoReq;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoRsp;

class VipSetFunCallHandler$HandleMyDefaultFC
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private IVipFunCallManager jdField_a_of_type_ComTencentMobileqqVasVipavApiIVipFunCallManager;
  private VipFunCallAndRing.TSsoReq jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoReq;
  private VipFunCallAndRing.TSsoRsp jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoRsp;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  
  public VipSetFunCallHandler$HandleMyDefaultFC(VipSetFunCallHandler paramVipSetFunCallHandler, VipFunCallAndRing.TSsoReq paramTSsoReq, int paramInt1, Bundle paramBundle, int paramInt2, VipFunCallAndRing.TSsoRsp paramTSsoRsp, IVipFunCallManager paramIVipFunCallManager, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoReq = paramTSsoReq;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoRsp = paramTSsoRsp;
    this.jdField_a_of_type_ComTencentMobileqqVasVipavApiIVipFunCallManager = paramIVipFunCallManager;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public HandleMyDefaultFC a()
  {
    Object localObject1 = (VipFunCallAndRing.TSsoCmd0x3Req)this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoReq.st_cmd0x3_req.get();
    this.jdField_a_of_type_AndroidOsBundle.putInt("callId", ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get());
    Object localObject2;
    if (this.b == 0)
    {
      localObject2 = (VipFunCallAndRing.TSsoCmd0x3Rsp)this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoRsp.st_cmd0x3_rsp.get();
      this.jdField_a_of_type_ComTencentMobileqqVasVipavApiIVipFunCallManager.setFunCallData(VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler), 0, VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler).getAccount(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_ring_id.get(), null, 0L);
      this.c = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_ring_id.get();
      this.jdField_a_of_type_JavaLangString = VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler).getAccount();
    }
    if (1 == this.jdField_a_of_type_Int)
    {
      localObject2 = VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler);
      int i = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get();
      if (this.b == 0) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      VasWebviewTempUtil.reportVASTo00145((AppInterface)localObject2, String.valueOf(i), "preview", "SetComCall", (String)localObject1, new String[0]);
    }
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipSetFunCallHandler.HandleMyDefaultFC
 * JD-Core Version:    0.7.0.1
 */